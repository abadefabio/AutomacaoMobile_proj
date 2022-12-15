package br.com.next.automacao.core.tools.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static br.com.next.automacao.core.tools.ReadProperties.*;

public class ConectorSqlServer {

    private static Connection connection;
    private static Statement sqlDeclaracao;


    /**
     * Cria a conexão com o banco de dados a partir dos parâmetros do arquivo de credenciais
     *
     * @return Conexão com DB
     * @throws SQLException
     */
    private static Connection getDBConnection() throws SQLException{
        if (connection == null) {
            var dbURL = getDataBaseSqlUrl() + getDataBaseSqlDB() + getDataBaseSqlUser() + getDataBaseSqlPass();
            connection = DriverManager.getConnection(dbURL);
        }
        return connection;
    }

    /**
     * Cria statement definindo os parâmetros que serão aceitos pelo ResultSet
     *
     * @return Statement
     * @throws SQLException
     */
    private static Statement createStatement() throws SQLException{
        return sqlDeclaracao =
                getDBConnection()
                        .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    /**
     * Executa a query para retornar a lista de volores, Insert ou Delete
     *
     * @param query condições de busca
     * @return arraylist
     * @throws SQLException
     */
    public static ArrayList<String> executarQuery(String query) throws SQLException {
        ResultSet resultado;
        ArrayList <String> retorno = new ArrayList<>();
        try {
            resultado = createStatement().executeQuery(query);
            while (resultado.next()) {
                retorno.add(resultado.getString(1));
            }
            return retorno;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null && !connection.isClosed()) {
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
