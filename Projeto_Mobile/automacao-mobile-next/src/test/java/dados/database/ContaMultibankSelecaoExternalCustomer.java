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
     * Pesquisa na base de dados CPFs de responsável multibank que
     * possuam até maxDependentes. Um CPF aleatório é escolhido.
     * O status de onboarding do CPF do responsável é ignorado.
     *
     * @param maxDependentes
     * @throws SQLException
     * @throws NextException
     */
    public void selecionarCpfResponsavel(int maxDependentes) throws SQLException, NextException {

        OperadorEvidencia.logarPasso("Selecionar CPF do responsável...");
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
        OperadorEvidencia.logarPasso("Resultado inicial de CPFs elegíveis (número de dependentes até " + maxDependentes + "):\n");
        OperadorEvidencia.logarPasso("CPF do Responsável, Adesões restantes");
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
                    " entre " + cpfList.size() + " CPFs disponíveis no Multibank.");
            cpf = cpfList.get(registroAleatorio);
        } catch (Exception e) {
            throw new NextException("cpfList size com até 4 dependentes = " + cpfList.size(), e);
        }

        setCpfResponsavel(cpf);
        OperadorEvidencia.logarPasso("CPF selecionado: " + cpf);
        OperadorEvidencia.logarPasso("Adesões restantes (até): " + adesoesRestantes);
    }

    /**
     * Obtém dados de input para a geração da adesão Joy dependente
     * com base no CPF do responsável obtido e armazenado na instância.
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
                "CPF do responsável: " + cpf + "\n" +
                "EXTERNAL_CUSTOMER_UID (customerIdResponsavel): " + externalCustomer.customerIdResponsavel + "\n" +
                "EXTERNAL_HASH_ID (idClienteResponsavel): " + externalCustomer.idClienteResponsavel);
        return externalCustomer;
    }


    /**
     * Classe que define e resgata valores de input para a adesão Joy Multibank.
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
