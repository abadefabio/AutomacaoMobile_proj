package dados.database;

import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ContaMultibankSelecaoExternalCustomer {

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
     * Armazena o CPF do respons�vel na inst�ncia.
     */
    private void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    /**
     * Obt�m o CPF do respons�vel previamente armazenado na inst�ncia
     *
     * @return cpfResponsavel
     */
    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    /**
     * Pesquisa na base de dados CPFs de respons�vel multibank que
     * possuam at� maxDependentes. Um CPF aleat�rio � escolhido.
     * O status de onboarding do CPF do respons�vel � ignorado.
     *
     * @param maxDependentes
     * @throws SQLException
     * @throws NextException
     */
    public void selecionarCpfResponsavel(int maxDependentes) throws SQLException, NextException {

        OperadorEvidencia.logarPasso("Selecionar CPF do respons�vel...");
        String sql = "SELECT EC.CPF, C.ONBOARDING_STATUS_ID, COUNT(C.CPF)\n" +
                "FROM " +
                "NEXTBANK.CUSTOMER C " +
                "INNER JOIN NEXTBANK.DEPENDENT_MANAGEMENT DM " +
                "ON DM.DEPENDENT_CUSTOMER_UID = C.CUSTOMER_UID " +
                "RIGHT JOIN NEXTBANK.EXTERNAL_CUSTOMER EC " +
                "ON EC.EXTERNAL_CUSTOMER_UID = DM.RESPONSIBLE_CUSTOMER_UID " +
                "GROUP BY EC.CPF, C.ONBOARDING_STATUS_ID " +
                "ORDER BY 1 DESC";

        Connection connection = getDBConnection();
        ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
        List<String> cpfList = new ArrayList<>();
        OperadorEvidencia.logarPasso("Resultado inicial de CPFs eleg�veis (n�mero de dependentes at� " + maxDependentes + "):\n");
        OperadorEvidencia.logarPasso("CPF do Respons�vel, Ades�es restantes");
        int adesoesRestantes = 0;
        while (resultSet.next()) {
            Integer numAdesoesNesteCpf = Integer.parseInt(resultSet.getString(3));
            if (numAdesoesNesteCpf <= maxDependentes) {
                String cpfElegivelAtual = resultSet.getString(1);
                if (!cpfList.contains(cpfElegivelAtual) && cpfElegivelAtual.trim().length() == 11) {
                    adesoesRestantes += (5 - numAdesoesNesteCpf);
                    cpfList.add(cpfElegivelAtual);
                    OperadorEvidencia.logarPasso(cpfElegivelAtual + ", " + resultSet.getString(2));
                }
            }
        }

        int registroAleatorio = (int) Math.floor(Math.random() * (cpfList.size() + 1));
        String cpf;
        try {
            OperadorEvidencia.logarPasso("Selecionado CPF de ordem #" + registroAleatorio +
                    " entre " + cpfList.size() + " CPFs dispon�veis no Multibank.");
            cpf = cpfList.get(registroAleatorio);
        } catch (Exception e) {
            throw new NextException("cpfList size com at� 4 dependentes = " + cpfList.size(), e);
        }

        setCpfResponsavel(cpf);
        OperadorEvidencia.logarPasso("CPF selecionado: " + cpf);
        OperadorEvidencia.logarPasso("Ades�es restantes (at�): " + adesoesRestantes);
    }

    /**
     * Obt�m dados de input para a gera��o da ades�o Joy dependente
     * com base no CPF do respons�vel obtido e armazenado na inst�ncia.
     */
    public ExternalCustomer getExternalCustomer() throws SQLException {

        String cpf = getCpfResponsavel();

        OperadorEvidencia.logarPasso("Obtendo dados do external customer...");
        String sql = "SELECT * FROM NEXTBANK.EXTERNAL_CUSTOMER " +
                "WHERE cpf = '" + cpf + "'";

        Connection connection = getDBConnection();
        ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
        ExternalCustomer externalCustomer = new ExternalCustomer();

        if (resultSet.next()) {
            externalCustomer.setCpfResponsavel(cpf);
            externalCustomer.setCustomerIdResponsavel(resultSet.getString("EXTERNAL_CUSTOMER_UID"));
            externalCustomer.setIdClienteResponsavel(resultSet.getString("EXTERNAL_HASH_ID"));
        }

        OperadorEvidencia.logarPasso("Dados do external customer:\n " +
                "CPF do respons�vel: " + cpf + "\n" +
                "EXTERNAL_CUSTOMER_UID (customerIdResponsavel): " + externalCustomer.customerIdResponsavel + "\n" +
                "EXTERNAL_HASH_ID (idClienteResponsavel): " + externalCustomer.idClienteResponsavel);
        return externalCustomer;
    }


    /**
     * Classe que define e resgata valores de input para a ades�o Joy Multibank.
     */
    public class ExternalCustomer {
        String cpfResponsavel;
        String customerIdResponsavel;
        String idClienteResponsavel;

        public void setCpfResponsavel(String cpfResponsavel) {
            this.cpfResponsavel = cpfResponsavel;
        }

        public void setCustomerIdResponsavel(String customerIdResponsavel) {
            this.customerIdResponsavel = customerIdResponsavel;
        }

        public void setIdClienteResponsavel(String idClienteResponsavel) {
            this.idClienteResponsavel = idClienteResponsavel;
        }

        public String getCpfResponsavel() {
            return cpfResponsavel;
        }

        public String getCustomerIdResponsavel() {
            return customerIdResponsavel;
        }

        public String getIdClienteResponsavel() {
            return idClienteResponsavel;
        }
    }


}
