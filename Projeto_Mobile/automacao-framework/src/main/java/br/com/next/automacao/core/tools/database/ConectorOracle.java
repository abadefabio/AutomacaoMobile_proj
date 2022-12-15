package br.com.next.automacao.core.tools.database;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static br.com.next.automacao.core.tools.ReadProperties.*;

public class ConectorOracle {

    private static Connection connection;
    private static Statement sqlDeclaracao;

    /**
     * Cria a conexão com o banco de dados a partir dos parâmetros do arquivo de credenciais
     *
     * @return Conexão com DB
     * @throws SQLException
     */
    private static Connection getDBConnection() throws SQLException {
        if (connection == null) {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL(getDataBaseUrl());
            connection = dataSource.getConnection(getDataBaseUser(), getDataBasePass());
        }
        return connection;
    }

    /**
     * Cria statement definindo os parâmetros que serão aceitos pelo ResultSet
     *
     * @return Statement
     * @throws SQLException
     */
    private static Statement criarStatement() throws SQLException {
        return sqlDeclaracao =
                getDBConnection()
                        .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    /**
     * Executa a query para retornar apenas uma coluna única da tabela e sua lista de volores
     *
     * @param query condições de busca
     * @return
     */
    public static ArrayList executarQuery(String query) {
        ResultSet resultado;
        ArrayList<String> cpf = new ArrayList<String>();
        try {
            resultado = criarStatement().executeQuery(query);
            while (resultado.next()) {
                cpf.add(resultado.getString(1));
            }
            return cpf;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                } catch (SQLException e) {
                    System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                    e.printStackTrace();
                }
            }
            if (sqlDeclaracao != null) {
                try {
                    sqlDeclaracao.close();
                    sqlDeclaracao = null;
                } catch (SQLException e) {
                    System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
