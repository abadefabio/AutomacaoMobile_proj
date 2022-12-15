package br.com.next.automacao.core.tools;

import br.com.next.automacao.core.drivers.ControladoraDriver;
import br.com.next.automacao.core.drivers.mobile.fabrica.Config;
import br.com.next.automacao.core.exception.NextException;
import org.apache.commons.codec.binary.Base64;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static java.util.Objects.isNull;

public class ReadProperties {
    private static String caminho;

    private static String funcionalUser;
    private static String funcionalPass;

    private static String authUserId;
    private static String authUserPass;

    private static String mcUrl;

    private static String tdmUrl;

    private static String jiraUrl;
    private static String jiraUser;
    private static String jiraPass;

    private static String caUrl;
    private static Map<String, String> credenciaisEmulador;
    private static String ambiente;
    private static String esteira;

    private static String gestaoUser;
    private static String gestaoPass;

    private static String dataBaseUser;
    private static String dataBasePass;
    private static String dataBaseUrl;
    private static String dataBaseSqlUser;
    private static String dataBaseSqlPass;
    private static String dataBaseSqlDb;
    private static String dataBaseSqlUrl;

    private static String coreBankingUrl;

    private static String clientIdMobileCenter;
    private static String secretMobileCenter;

    private static String caminhoArquivoConsultoria;
    private static String caminhoArquivoNext;

    private ReadProperties() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Lé as properties do framework
     *
     * @return properties
     * @throws IOException
     */
    private static Properties readProperties() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        properties.load(classLoader.getResourceAsStream("properties/config.properties"));
        return properties;
    }

    /**
     * Pega as properties do framework
     *
     * @param property propriedade a ser recuperada
     * @return
     */
    public static String getProperty(String property) {
        try {
            Properties properties = readProperties();
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void setCaminho() {
        var osName = System.getProperty("os.name").toLowerCase();
        var pathConfiguracoes = getProperty("path.configuracoes");
        var basePath = "";

        if (Boolean.parseBoolean(getProperty("environment.run.test"))) {
            basePath = getProperty("path.base.unit.test");
        } else {
            if (osName.contains("windows")) {
                basePath = getProperty("path.base.windows");
            } else if (osName.contains("mac")) {
                basePath = getProperty("path.base.mac");
            } else {
                basePath = System.getProperty("user.home") + getProperty("path.base.linux");
            }
        }

        caminho = basePath + pathConfiguracoes;
    }

    /**
     * Seta as properties do usuário
     */
    public static void setCredentials() {

        try {
            if (!Boolean.parseBoolean(getProperty("environment.run.pipeline"))) {
                setCaminho();
            }

            Properties credentialProperties = new Properties();

            FileInputStream file = new FileInputStream(caminho);
            credentialProperties.load(file);

            byte[] senhaFuncional = Base64.decodeBase64(credentialProperties.getProperty("funcional.pass"));
            funcionalUser = credentialProperties.getProperty("funcional.user");
            funcionalPass = new String(senhaFuncional);

            clientIdMobileCenter = credentialProperties.getProperty("user.tokenId");
            secretMobileCenter = credentialProperties.getProperty("user.tokenPass");

            byte[] mcTokenId = Base64.decodeBase64(clientIdMobileCenter);
            byte[] mcTokenPass = Base64.decodeBase64(secretMobileCenter);
            authUserId = new String(mcTokenId);
            authUserPass = new String(mcTokenPass);


            mcUrl = credentialProperties.getProperty("mc.url");

            byte[] senhaJira = Base64.decodeBase64(credentialProperties.getProperty("jira.pass"));
            jiraUser = credentialProperties.getProperty("jira.user");
            jiraPass = new String(senhaJira);
            jiraUrl = credentialProperties.getProperty("jira.url");

            byte[] senhaDataBase = Base64.decodeBase64(credentialProperties.getProperty("database.pass").trim());
            dataBaseUser = credentialProperties.getProperty("database.user");
            dataBasePass = new String(senhaDataBase);
            dataBaseUrl = credentialProperties.getProperty("database.url");

            byte[] senhaDataBaseSql = Base64.decodeBase64(credentialProperties.getProperty("database.sql.pass").trim());
            dataBaseSqlUser = credentialProperties.getProperty("database.sql.user");
            dataBaseSqlPass = new String(senhaDataBaseSql);
            dataBaseSqlUrl = credentialProperties.getProperty("database.sql.url");
            dataBaseSqlDb = credentialProperties.getProperty("database.sql.db");

            ambiente = credentialProperties.getProperty("ambiente");
            esteira = credentialProperties.getProperty("esteira.ambiente."
                    + ambiente.toLowerCase().trim());
            caUrl = credentialProperties.getProperty("ca.url.ambiente."
                    + ambiente.toLowerCase().trim());

            coreBankingUrl = credentialProperties.getProperty("coreBanking.url");

            tdmUrl = credentialProperties.getProperty("tdm.url");


            // Hashmap de usuários e senhas do emulador
            credenciaisEmulador = new HashMap<>();
            String[] todosUsers = credentialProperties.getProperty("emulador.user").trim().split(",");
            String[] todosPass = credentialProperties.getProperty("emulador.pass").trim().split(",");
            for (int i = 0; i < todosUsers.length; i++) {
                byte[] senhaEmulador = Base64.decodeBase64(todosPass[i].trim());
                String password = new String(senhaEmulador);
                try {
                    credenciaisEmulador.put(todosUsers[i].trim(), password.trim());
                } catch (ArrayIndexOutOfBoundsException aobe) {
                    throw new NextException("Erro: verifique se existem todos os pares " +
                            "de usuário e senha do emulador no arquivo de configurações!", aobe);
                }
            }

            byte[] senhaSistemaDeGestao = Base64.decodeBase64(credentialProperties.getProperty("gestao.pass").trim());
            gestaoUser = credentialProperties.getProperty("gestao.user");
            gestaoPass = new String(senhaSistemaDeGestao);

            caminhoArquivoConsultoria = getProperty("path.config-consultoria");
            caminhoArquivoNext = getProperty("path.config-next");

        } catch (IOException e) {
            e.printStackTrace();
            Reporter.log("Arquivo de credenciais não encontrado", true);
        } catch (NullPointerException | NextException ex) {
            ex.printStackTrace();
        }
    }

    public static String getCaminho() {
        if (caminho == null) {
            setCredentials();
        }
        return caminho;
    }

    public static String getFuncionalPass() {
        if (funcionalPass == null) {
            setCredentials();
        }
        return funcionalPass;
    }

    public static String getFuncionalUser() {
        if (funcionalUser == null) {
            setCredentials();
        }
        return funcionalUser;
    }
    public static String getAuthUserId() {
        if (authUserId == null) {
            setCredentials();
        }
        return authUserId;
    }
    public static String getAuthUserPass() {
        if (authUserPass == null) {
            setCredentials();
        }
        return authUserPass;
    }

    public static String getMcUrl() {
        if (mcUrl == null) {
            setCredentials();
        }
        if (mcUrl.isBlank()) {
            mcUrl = Config.MC_URL_DEFAULT;
        }
        return mcUrl;
    }

    public static String getJiraUser() {
        if (jiraUser == null) {
            setCredentials();
        }
        return jiraUser;
    }

    public static String getJiraPass() {
        if (jiraPass == null) {
            setCredentials();
        }
        return jiraPass;
    }

    public static String getJiraUrl() {
        if (jiraUrl == null) {
            setCredentials();
        }
        return jiraUrl;
    }

    public static String getDataBaseUser() {
        if (dataBaseUser == null) {
            setCredentials();
        }
        return dataBaseUser;
    }

    public static String getDataBasePass() {
        if (dataBasePass == null) {
            setCredentials();
        }
        return dataBasePass;
    }

    public static String getDataBaseUrl() {
        if (dataBaseUrl == null) {
            setCredentials();
        }
        return dataBaseUrl;

    }

    public static String getCoreBankingUrl() {
        if (coreBankingUrl == null) {
            setCredentials();
        }
        return coreBankingUrl;
    }

    public static String getCaUrl() {
        if (caUrl == null) {
            setCredentials();
        }
        return caUrl;
    }

    public static String getEmuladorUser() {
        return getEmuladorUser(0);

    }

    public static String getEmuladorUser(int indice) {
        if (isNull(credenciaisEmulador)) {
            setCredentials();
        }
        return (String) credenciaisEmulador.keySet().toArray()[indice];

    }

    public static String getEmuladorPass() {
        return getEmuladorPass(0);
    }

    public static String getEmuladorPass(int indice) {
        if (isNull(credenciaisEmulador)) {
            setCredentials();
        }
        return credenciaisEmulador.get(getEmuladorUser(indice));
    }

    public static Map<String, String> getCredenciaisEmulador() {
        if (isNull(credenciaisEmulador)) {
            setCredentials();
        }
        return credenciaisEmulador;
    }

    public static String getAmbiente() {
        if (ambiente == null) {
            setCredentials();
        }
        return ambiente;
    }

    public static String getEsteira() {
        if (esteira == null) {
            setCredentials();
        }
        return esteira;
    }

    public static String getTdmUrl() {
        if (tdmUrl == null) {
            setCredentials();
        }
        return tdmUrl;
    }

    public static String getGestaoUser() {
        if (gestaoUser == null) {
            setCredentials();
        }
        return gestaoUser;
    }

    public static String getGestaoPass() {
        if (gestaoPass == null) {
            setCredentials();
        }
        return gestaoPass;
    }

    public static String getClientIdMobileCenter() {
        if (clientIdMobileCenter == null) {
            setCredentials();
        }
        return clientIdMobileCenter;
    }

    public static String getSecretMobileCenter() {
        if (secretMobileCenter == null) {
            setCredentials();
        }
        return secretMobileCenter;
    }

    public static String getCaminhoArquivoConsultoria() {

        if (caminhoArquivoConsultoria == null) {
            setCredentials();
        }
        return caminhoArquivoConsultoria;
    }

    public static String getCaminhoArquivoNext() {
        if (caminhoArquivoNext == null) {
            setCredentials();
        }
        return caminhoArquivoNext;
    }
    public static String getDataBaseSqlUser() {
        if (dataBaseSqlUser == null) {
            setCredentials();
        }
        return dataBaseSqlUser;
    }

    public static String getDataBaseSqlPass() {
        if (dataBaseSqlPass == null) {
            setCredentials();
        }
        return dataBaseSqlPass;
    }

    public static String getDataBaseSqlUrl() {
        if (dataBaseSqlUrl == null) {
            setCredentials();
        }
        return dataBaseSqlUrl;
    }

    public static String getDataBaseSqlDB() {
        if (dataBaseSqlDb == null) {
            setCredentials();
        }
        return dataBaseSqlDb;
    }
}
