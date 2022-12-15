package br.com.next.automacao.core.tools.configuracao.createfile;

import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.configuracao.jpanel.ConfigurationPanel;
import br.com.next.automacao.core.tools.configuracao.jpanel.FieldsPanel;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

import static br.com.next.automacao.core.tools.ReadProperties.getClientIdMobileCenter;
import static br.com.next.automacao.core.tools.ReadProperties.getProperty;
import static br.com.next.automacao.core.tools.ReadProperties.getSecretMobileCenter;

/**
 * O File Properties faz criacao do arquivo configuracao.properties com os valores digitados.
 *
 * @author Joyce Melo
 * @version 1.0
 * @since 2022-01
 */
@Slf4j
public class FileProperties {

    private String valueNextConsultancy;
    private String valueEmailJira;
    private byte[] valuePasswordJira;
    private String valueKeyM;
    private byte[] valuePasswordKeyM;
    private static String fileConteudo;
    private String typeConfigurationFinal;
    private static final String SISTEMA_OPERACIONAL = System.getProperty("os.name").toUpperCase();
    private static final String SISTEMA_OPERACIONAL_RODANDO = obtemPathSistemaOperacional();

    public void setValueNextConsultancy(String valueNextConsultancy) {
        this.valueNextConsultancy = valueNextConsultancy;
    }

    public FileProperties(String valueEmailJira, byte[] valuePasswordJira, String valueKeyM, byte[] valuePasswordKeyM) {
        this.valueEmailJira = valueEmailJira;
        this.valuePasswordJira = valuePasswordJira;
        this.valueKeyM = valueKeyM;
        this.valuePasswordKeyM = valuePasswordKeyM;
    }

    public void fillPropertiesWithValues() throws IOException {

        String fileContent;

        if ("NEXT".equals(this.valueNextConsultancy)) {
            fileContent = replaceValuesProperties(Objects.requireNonNull(ReadProperties.getCaminhoArquivoNext()));
        } else {
            fileContent = replaceValuesProperties(Objects.requireNonNull(ReadProperties.getCaminhoArquivoConsultoria()));
        }

        saveFileConfigure(fileContent, false);
    }

    public String replaceValuesProperties(String typeConfiguration) throws IOException {

        var valuesProperties = new HashMap<String, String>();
        valuesProperties.put("jira.user=(.*)", "jira.user=" + this.valueEmailJira);
        valuesProperties.put("jira.pass=(.*)", "jira.pass=" + new String(this.valuePasswordJira));
        valuesProperties.put("funcional.user=(.*)", "funcional.user=" + this.valueKeyM);
        valuesProperties.put("funcional.pass=(.*)", "funcional.pass=" + new String(this.valuePasswordKeyM));

        typeConfigurationFinal = typeConfiguration;

        return replaceValues(typeConfigurationFinal, valuesProperties);
    }

    private static String replaceValues(String typeConfigurationProperties, HashMap<String, String> valuesProperties) throws IOException {
        String fileContentReplace = Files.readString(Paths.get(typeConfigurationProperties), StandardCharsets.ISO_8859_1);
        for (var valueP : valuesProperties.keySet()) {
            fileContentReplace = fileContentReplace.replaceAll(valueP, valuesProperties.get(valueP));
        }
        return fileContentReplace;
    }

    private static void createDirectory(File pathDirectory, boolean operationalSystemLinux) {

        if (!pathDirectory.isDirectory() && !operationalSystemLinux) {
            boolean wasSuccessful = pathDirectory.mkdirs();
            if (!wasSuccessful) {
                log.info("Directory creation failed");
            } else {
                log.info("Directory creation");
            }
        }
    }

    public static void saveFileConfigure(String file, boolean estaCriandoTokenArquivo) {

        boolean operationalSystemLinux = SISTEMA_OPERACIONAL.contains("LINUX");

        createDirectory(new File(SISTEMA_OPERACIONAL_RODANDO), operationalSystemLinux);

        try {

            FileOutputStream fileConfigure;
            var logMessage = "";

            if (operationalSystemLinux) {
                fileConfigure = new FileOutputStream(SISTEMA_OPERACIONAL_RODANDO);
                logMessage = "Foi criado arquivo configuracoes.properties na pasta /Downloads";
            } else {
                fileConfigure = new FileOutputStream(SISTEMA_OPERACIONAL_RODANDO + "/configuracoes.properties");
                logMessage = "Foi criado arquivo configuracoes.properties na pasta " + SISTEMA_OPERACIONAL_RODANDO;
            }
            if (!estaCriandoTokenArquivo)
                ConfigurationPanel.popupInformation(logMessage, "", 5000);

            fileConteudo = file;

            fileConfigure.write(fileConteudo.getBytes(StandardCharsets.UTF_8));
            fileConfigure.close();

        } catch (IOException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }

    public static void obterCredentialMobileCenter(Response responseMobileCenter) throws IOException {

        var mapResponse = responseMobileCenter.jsonPath();

        if (FieldsPanel.valueCreateValidate.contains("CRIAR")) {

            var encodeClientId = Base64.encodeBase64(mapResponse.get("clientId").toString().getBytes());
            var encodeSecret = Base64.encodeBase64(mapResponse.get("secret").toString().getBytes());

            fileConteudo = fileConteudo
                    .replaceAll("user.tokenId=(.*)", "user.tokenId=" + new String(encodeClientId))
                    .replaceAll("user.tokenPass=(.*)", "user.tokenPass=" + new String(encodeSecret));

            saveFileConfigure(fileConteudo, true);
        } else {

            String fileContentReplace = Files.readString(Paths.get(SISTEMA_OPERACIONAL_RODANDO), StandardCharsets.ISO_8859_1)
                    .replaceAll("user.tokenId=(.*)", "user.tokenId=" + getClientIdMobileCenter())
                    .replaceAll("user.tokenPass=(.*)", "user.tokenPass=" + getSecretMobileCenter());

            saveFileConfigure(fileContentReplace, true);

        }
    }

    private static String obtemPathSistemaOperacional() {

        String pathDirectory;

        if (SISTEMA_OPERACIONAL.contains("LINUX")) {
            pathDirectory = System.getProperty("user.home") + getProperty("path.base.linux") + "configuracoes.properties";
        } else {
            pathDirectory = SISTEMA_OPERACIONAL.contains("MAC OS") ? (getProperty("path.base.mac")) :
                    getProperty("path.base.windows");
        }
        return pathDirectory;
    }
}