package dados.database;

import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.adesao.multibank.Config;
import oracle.jdbc.pool.OracleDataSource;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.util.Objects.isNull;


public class ContaMultibankBancoDados {

    private Connection connection;
    private String cpfResponsavel;

    private Connection getDBConnection() throws SQLException {
        if (connection == null) {
            OperadorEvidencia.logarPasso("Conectando ao banco " + ReadProperties.getDataBaseUrl() + "...");
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL(ReadProperties.getDataBaseUrl());
            connection = dataSource.getConnection(ReadProperties.getDataBaseUser(), ReadProperties.getDataBasePass());
        }

        return connection;
    }

    /**
     * Armazena o CPF do responsável na instância.
     */
    private void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    /**
     * Obtém o CPF do responsável previamente armazenado na instância
     *
     * @return cpfResponsavel
     */
    public String getCpfResponsavel() {
        return cpfResponsavel;
    }


    /**
     * Aguarda o status da adesão do CPF de dependente ser atualizado para o status statusEsperado.
     * Um timeout em segundos para esta tarefa é definido por timeoutSegs.
     *
     * @param cpfDependente
     * @param statusEsperado
     * @param timeoutSegs
     * @return
     * @throws SQLException
     */
    public String esperarOnBoardingStatus(String cpfDependente, String statusEsperado, int timeoutSegs) throws SQLException {

        timeoutSegs = Math.max(Config.TIMEOUT_MINIMO_ESPERA_ONBOARDING, timeoutSegs);
        timeoutSegs = Math.min(timeoutSegs, Config.TIMEOUT_MAXIMO_ESPERA_ONBOARDING);

        if (isNull(statusEsperado))
            statusEsperado = "1";

        String statusEncontrado = null;

        long inicio = System.currentTimeMillis();
        while (System.currentTimeMillis() - inicio < timeoutSegs * 1000) {
            statusEncontrado = getOnBoardingStatus(cpfDependente);
            if (!isNull(statusEncontrado) && statusEncontrado.equalsIgnoreCase(statusEsperado)) {
                return statusEncontrado;
            }
            OperadorEvidencia.logarPasso("Aguardando CPF dependente ficar no status " + statusEsperado);
            try {
                Thread.sleep(Config.TEMPO_ENTRE_TENTATIVAS_VERIFICACAO_ONBOARDING_SEGS * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return isNull(statusEncontrado) ? "STATUS INVÁLIDO" : statusEncontrado;
    }

    /**
     * Aguarda o status da adesão do CPF de dependente ser atualizado para o status statusEsperado.
     * Este método sobrecarregado define automaticamente um timeout padrão.
     *
     * @param cpfDependente
     * @param statusEsperado
     * @return
     * @throws SQLException
     */
    public String esperarOnBoardingStatus(String cpfDependente, String statusEsperado) throws SQLException {
        return esperarOnBoardingStatus(cpfDependente, statusEsperado, Config.TIMEOUT_PADRAO_ESPERA_ONBOARDING);
    }

    private String getOnBoardingStatus(String cpfDependente) throws SQLException {

        OperadorEvidencia.logarPasso("Obtendo onboarding status do dependente com CPF: " + cpfDependente);
        String sql = "SELECT * " +
                "FROM " +
                "NEXTBANK.CUSTOMER " +
                "WHERE CPF IN " + cpfDependente;

        Connection connection = getDBConnection();
        ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);

        OperadorEvidencia.logarPasso("[resultSet]: " + resultSet);

        String onBoardingStatusEncontrado = null;

        if (resultSet.next()) {
            onBoardingStatusEncontrado = resultSet.getString("ONBOARDING_STATUS_ID");
        }

        onBoardingStatusEncontrado = isNull(onBoardingStatusEncontrado) ? "Inválido" : onBoardingStatusEncontrado;
        return onBoardingStatusEncontrado;
    }

    /**
     * Valida o status de onboarding do CPF do dependente com base no cpfResponsavel e statusEsperado.
     *
     * @param cpfDependente
     * @param cpfResponsvel
     * @param statusEsperado
     * @throws SQLException
     */
    public void validarOnBoardingStatus(String cpfDependente, String cpfResponsvel, String statusEsperado) throws SQLException {
        String statusEncontrado = getOnBoardingStatus(cpfDependente);
        String mensagemErro = "Falha: status de onboarding diferente do esperado. " +
                "Status esperado = " + statusEsperado + ", Status encontrado = " + statusEncontrado;
        Assert.assertTrue(statusEncontrado.equalsIgnoreCase(statusEsperado), mensagemErro);
        OperadorEvidencia.logarPasso("Validado o status de onboarding do dependente " + cpfDependente +
                ". Status: " + statusEncontrado);
        OperadorEvidencia.logarPasso("CPF do responsável: " + cpfResponsvel);
    }


}
