package br.com.next.automacao.core.tools.configuracao.validator;

import br.com.next.automacao.core.connections.login.LoginJira;
import br.com.next.automacao.core.connections.login.LoginMobileCenter;
import br.com.next.automacao.core.connections.mobileCenter.GeracaoToken;
import br.com.next.automacao.core.tools.configuracao.createfile.FileProperties;
import br.com.next.automacao.core.tools.configuracao.jpanel.ConfigurationPanel;
import com.google.gson.Gson;
import io.restassured.response.Response;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static br.com.next.automacao.core.connections.Conexao.login;
import static br.com.next.automacao.core.tools.ReadProperties.getDataBasePass;
import static br.com.next.automacao.core.tools.ReadProperties.getDataBaseUrl;
import static br.com.next.automacao.core.tools.ReadProperties.getDataBaseUser;
import static br.com.next.automacao.core.tools.ReadProperties.getFuncionalPass;
import static br.com.next.automacao.core.tools.ReadProperties.getFuncionalUser;
import static br.com.next.automacao.core.tools.ReadProperties.getJiraPass;
import static br.com.next.automacao.core.tools.ReadProperties.getJiraUrl;
import static br.com.next.automacao.core.tools.ReadProperties.getJiraUser;
import static br.com.next.automacao.core.tools.ReadProperties.getMcUrl;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 * Classe respons�vel pela valida��o do login no Jira
 * login mobile center
 * e conex�o de banco de dados
 *
 * @author Joyce Melo
 * @version 1.0
 * @since 2022-01
 */
public class ValidateConfigurations extends JFrame {

    private static final String urlDataBase = getDataBaseUrl();
    private static final String passDataBase = getDataBasePass();
    private static final String userDataBase = getDataBaseUser();
    private static final String pathConnectionJira = "/rest/auth/latest/session";
    private static final String pathConnectionMobileCenter = "/rest/client/login";
    private static final String pathJira = getJiraUrl() + pathConnectionJira;
    private static final String pathMobileCenter = getMcUrl() + pathConnectionMobileCenter;
    private static final String pathMobileCenterCredentials = getMcUrl() + "/rest/oauth2/credentials";
    private static final Gson gson = new Gson();

    private static Response loginJira() throws Exception {
        var body = new LoginJira(getJiraUser(), getJiraPass());
        return executeRequest(gson.toJson(body), pathJira);
    }

    private static Response loginConnectorMobileCenter() throws Exception {
        var body = new LoginMobileCenter(getFuncionalUser(), getFuncionalPass());
        return executeRequest(gson.toJson(body), pathMobileCenter);
    }


    private static Response executeRequest(String body, String uriBase) throws Exception {
        return login(body, uriBase);
    }

    private static void connectionDataBase() {
        try {

            ConfigurationPanel.popupInformation("Iniciando conexão com o banco \n" + urlDataBase, "ATENÇÃO, pode demorar um pouco", 20000);

            Connection conn = DriverManager.getConnection(urlDataBase, userDataBase, passDataBase);
            if (conn != null) {
                ConfigurationPanel.popupInformation("Conexão com o banco feita com sucesso \n " + urlDataBase, "", 3000);
                conn.close();
            } else {
                ConfigurationPanel.popupInformation("Não foi possivel conectar no BD. \n " + urlDataBase, "", 3000);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Não conseguiu conectar no BD", "Conexão com banco", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void messageResultRequests(HashMap<String, Response> responseRequest) {

        var responseList = new ArrayList<>();

        for (var response : responseRequest.keySet()) {
            responseList.add(
                    "URL: " + response + "\n" +
                            "STATUS: " + responseRequest.get(response).statusCode() + "\n" +
                            "BODY: \n" + responseRequest.get(response).getBody().print() + "\n");
        }

        String message = responseList.toString().replace(",", "\n").replace("[", " ").replace("]", " ").replace("}}", "}}\n");

        JOptionPane.showMessageDialog(null, message, "MENSAGENS DAS REQUISICOES", INFORMATION_MESSAGE);
    }

    public static void execute() throws Exception {
        try {
            var responseLogin = loginJira();
            var responseConnector = loginConnectorMobileCenter();
            var responseTokenMobileCenter = GeracaoToken.createTokenMobileCenter(responseConnector);


            var resultRequests = new HashMap<String, Response>();
            resultRequests.put(pathJira, responseLogin);
            resultRequests.put(pathMobileCenter, responseConnector);
            resultRequests.put(pathMobileCenterCredentials, responseTokenMobileCenter);

            if(responseTokenMobileCenter != null)
                FileProperties.obterCredentialMobileCenter(responseTokenMobileCenter);

            connectionDataBase();
            messageResultRequests(resultRequests);
        }catch (IOException e) {
            JOptionPane.showInternalMessageDialog(null, "Fique atento é necessário criar o arquivo primeiro: \n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}