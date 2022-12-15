package br.com.next.automacao.core.massa;

import br.com.next.automacao.core.tools.ReadProperties;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

/**
 * O Leitor de Massa faz a busca pelo arquivo JSON correspondente ao caso de teste
 * em execução. Ao encontrar o arquivo, seus dados são parseados e gravados em um objeto java,
 * estes por sua vez, por possuirem atributos específicos, são separados por jornada.
 * <p>
 * O Leitor de massa é invocado automaticamente através da TesteBase
 *
 * @author Lucas Santos
 * @version 2.0
 * @since 2019-12
 */

public class LeitorMassaDados {

    public ThreadLocal<JSONObject> massaDados = null;

    public LeitorMassaDados(String casoTeste) {
        lerArquivo(casoTeste);
    }

    /**
     * Pesquisa o arquivo JSON com a massa de dados e invoca o parseamento
     *
     * @param casoTeste ID do caso de teste
     */
    private void lerArquivo(String casoTeste) {
        JSONParser jsonParser = new JSONParser();

        Collection<File> files = FileUtils.listFiles(new File(ReadProperties.getProperty("path.massa")), new String[]{"json"}, true);
        for (File file : files) {
            if (file.getAbsolutePath().contains("QA" + casoTeste + ".json")) {
                try {
                    FileReader fileReader = new FileReader(file);
                    JSONArray jsonObject = (JSONArray) jsonParser.parse(fileReader);
                    jsonObject.forEach(json -> gerarMassaDados((JSONObject) json, "QA" + casoTeste));
                } catch (ParseException e) {
                    Reporter.log("Falha ao parsear arquivo de massa! Verifique a tipagem das variáveis do objeto de massa.", true);
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    Reporter.log("Arquivo de massa nao encontrado! Verfique se o arquivo \"QA" + casoTeste + "\" existe.", true);
                    e.printStackTrace();
                } catch (IOException e) {
                    Reporter.log("Falha ao ler dados da massa! Verifique a estrutura do arquivo", true);
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    Reporter.log("Falha ao ler dados da massa! Verifique se o ID do caso de teste esta correto no JSON", true);
                    e.printStackTrace();
                }

            }
        }
    }

    public JSONObject getMassaDados() {
        return massaDados.get();
    }

    public void setMassaDados(JSONObject jsonObject) {
        if (massaDados == null) {
            massaDados = new ThreadLocal<JSONObject>();
        }
        massaDados.set(new JSONObject(jsonObject));
    }

    /**
     * Realiza a chamada do parseador da jornada em execução
     *
     * @param jsonObject    Arquivo de massa
     * @param nomeCasoTeste ID do caso de teste* @return
     */
    private void gerarMassaDados(JSONObject jsonObject, String nomeCasoTeste) {
        setMassaDados((JSONObject) jsonObject.get(nomeCasoTeste));
    }

}