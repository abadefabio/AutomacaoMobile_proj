package br.com.next.automacao.core.massa.portal.qualidade;

import br.com.next.automacao.core.tools.ProcuraClasses;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import br.com.next.automacao.core.tools.geradores.BaseMassaFunc;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static br.com.next.automacao.core.tools.ReadProperties.getAmbiente;

public class GeracaoMassa {

    public JSONObject executaGeracaoMassaDeDados(Boolean ignorarErroCriacaoMassa,
                                           String nomeDaClasse, Boolean offline) throws Exception {

        Reporter.log("===============================================\n" +
                "             Preparação de Massa\n" +
                "===============================================", true);

        // Obtem as classes dentro do pacote funcionalidade
        var listaClassesDeMassa = ProcuraClasses.getClasses("funcionalidade");

        // Filtra a lista de classes
        // 1 - Filtra quais classes tem a interface CasoDeTesteMassa
        var listaClassesFiltradas = listaClassesDeMassa.stream()
                .filter(clazz -> Arrays.asList(clazz.getInterfaces()).contains(CasoDeTesteMassa.class))
                .collect(Collectors.toList());

        CasoDeTesteMassa casoDeTesteMassa = null;

        for (var clazz: listaClassesFiltradas){

            var nomeCasoDeTesteMassa = clazz.getSimpleName().toUpperCase().replace("MASSA", "");

            // caso a variavel nomeDaClasse seja igual ao casoDeTeste, valor da anotação
            // instancia a variável casoDeTesteMassa
            if (nomeDaClasse.equals(nomeCasoDeTesteMassa)){
                OperadorEvidencia.logarPasso("Classe encontrada! -> " + clazz.getName());
                casoDeTesteMassa = (CasoDeTesteMassa) clazz.newInstance();
                if(offline)
                    ((BaseMassaFunc) casoDeTesteMassa).setOffline();
                break;
            }
        }

        if (casoDeTesteMassa == null){
            String msg = "Não foi encontrado nenhuma classe para geracao de massa de dados com o nome " + nomeDaClasse;
            OperadorEvidencia.logarPasso(msg);
            throw new Exception(msg);
        }

        try {

            JSONObject dados = casoDeTesteMassa.criar();

            OperadorEvidencia.logarPasso("Massa de dados criada com sucesso!");
            OperadorEvidencia.logarPasso("Dados criados:");
            OperadorEvidencia.logarPasso(dados.toJSONString());
            return dados;

        } catch (Exception | Error exception){

            OperadorEvidencia.logarPasso("Não foi possível gerar a massa.");

            if (ignorarErroCriacaoMassa){
                OperadorEvidencia.logarPasso("Os dados serão pegos da massa contida no arquivo .json");
            } else {
                throw new Exception(exception);
            }

        }

        return null;

    }

    public void executaGeracaoMassaDeDadosOffline(String nomeDaClasse, int parametroMassaOffline) throws Exception {

        StringBuilder jsonTudo = new StringBuilder();
        String jsonInicialInstancia = "{\"instancia\":[";
        jsonTudo.append(jsonInicialInstancia);

        // repetir criacao de itens do array de instancias
        boolean erroCriacaoInstancia = true;
        for (int i = 1; i <= parametroMassaOffline; i++) {
            String tag = "@offline-" +
                    nomeDaClasse.replace("Massa", "").toUpperCase() + "-" +
                    getAmbiente().trim().toLowerCase() + "-" +
                    System.getProperty("user.name").trim().toLowerCase() + "-" +
                    System.nanoTime() + "-R_" + RandomStringUtils.randomAlphanumeric(5);
            JSONObject dados = null;
            try {
                dados = executaGeracaoMassaDeDados(false, nomeDaClasse, true);
                erroCriacaoInstancia = false;
            } catch (Exception e) {
                OperadorEvidencia.logarPasso("Erro com " + nomeDaClasse +
                        "na iteração " + i);
                erroCriacaoInstancia = true;
            }

            if (!erroCriacaoInstancia) {
                String jsonArray = jsonTudo.toString().contains("@offline") ? "," : "";
                jsonArray += "{\"squad\": \"@nucleo\",\n" +
                        "        \"tags\": \"" + tag + "\"," +
                        "\"" + getAmbiente().toLowerCase().trim() + "\":" +
                        dados + // fecha ambiente // fecha instancia
                        "}";// fecha array instancia
                jsonTudo.append(jsonArray);
            }

        } // end arrays do mesmo MassaQA

        jsonTudo.append("]}"); // finaliza json

        // formata json se pelo menos 1 massa foi gerada com pretty format e salva arquivo em disco
        if (jsonTudo.toString().contains("@offline")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(jsonTudo.toString());
            String prettyJsonString = gson.toJson(je);
            criarJsonOffline(prettyJsonString, nomeDaClasse, parametroMassaOffline);
        }

    }

    public void criarJsonOffline(String json, String nomeDaClasse, int parametroMassaOffline) {
        String path = new File(ReadProperties.getCaminho()).getParent() + "/offline/";
        String nomeArq =
                nomeDaClasse.replace("Massa", "").toUpperCase() + "-" +
                        System.getProperty("user.name").trim().toLowerCase() + "-" +
                        System.nanoTime() + "-R_" + RandomStringUtils.randomAlphanumeric(5)
                 + "---" + parametroMassaOffline + ".json";
        try {
            FileUtils.forceMkdir(new File(path));
            String nomeArqCompleto =  path + nomeArq;
            File file = new File(nomeArqCompleto);
            file.createNewFile();
            FileUtils.writeStringToFile(file, json, true);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
