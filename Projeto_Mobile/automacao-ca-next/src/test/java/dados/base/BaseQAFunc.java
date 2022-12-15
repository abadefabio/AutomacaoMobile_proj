package dados.base;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import br.com.next.automacao.core.tools.geradores.BaseMassaFunc;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.util.Strings;

import java.util.Arrays;
import java.util.List;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static java.util.Objects.isNull;

@SuppressWarnings("unchecked")
public class BaseQAFunc extends BaseMassaFunc implements CasoDeTesteMassa {


    @Override
    public JSONObject criar() throws Exception {
        return null;
    }

    /**
     * Ler Arquivo Json
     * @return JSONObject
     * @throws Exception
     */
    public JSONObject lerArquivoJson(String qa) throws Exception {
        var massa = dadosArquivoJson(qa);
        var squadList = getCasoTeste().getParametrosTeste().getOrDefault("squad", null);
        var tagList = getCasoTeste().getParametrosTeste().getOrDefault("tags", null);

        JSONObject massaF;
        if (massa.containsKey("instancia") && !isNull(squadList)) {
            JSONArray listaInstancias = (JSONArray) massa.get("instancia");
            String[] squads = squadList.split(",");
            String[] tags = null;
            if (!isNull(tagList)) tags = tagList.split(",");
            for (JSONObject listaInstancia : (Iterable<JSONObject>) listaInstancias) {
                JSONObject json = new JSONObject(listaInstancia);
                massaF = verificarItemLista("squad", squads, json);
                if (!massaF.isEmpty()) {
                    if (!isNull(tags)) massaF = verificarItemLista("tags", tags, json);
                }

                if (!massaF.isEmpty()) {
                    massa = massaF;
                    OperadorEvidencia.logarPasso("Massa encontrada para o cenário:" + massa);
                    break;
                }
            }
        }

        if (massa.containsKey(ReadProperties.getAmbiente())) {
            massa = (JSONObject) massa.get(ReadProperties.getAmbiente());
            OperadorEvidencia.logarPasso("Info: Massa selecionada para o ambiente " + ReadProperties.getAmbiente());
            OperadorEvidencia.logarPasso(massa.toJSONString());
        } else {
            OperadorEvidencia.logarPasso("Info: Massa não contém separação por ambiente tu/ti");
        }

        var plataforma = getCasoTeste().getParametrosTeste().getOrDefault("plataforma", null);

        if (!isNull(plataforma) && massa.containsKey(plataforma)) {
            massa = (JSONObject) massa.get(plataforma);
            OperadorEvidencia.logarPasso("Info: Massa selecionada para a plataforma " + plataforma);
            OperadorEvidencia.logarPasso(massa.toJSONString());
        } else {
            OperadorEvidencia.logarPasso("Info: Massa não contém separação de plataforma android ou ios");
        }

        return massa;
    }

    /**
     * Verificar Item Lista
     * @param chave
     * @param valorVerificar
     * @param json
     * @return JSONObject
     */
    private JSONObject verificarItemLista(String chave, String[] valorVerificar, JSONObject json) {

        JSONObject massaF = new JSONObject();

        if (chave.equals("squad")) {
            if (!json.containsKey(chave))
                return massaF;
        }

        for (int i = 0; i < valorVerificar.length; i++) {
            String sq = valorVerificar[i];
            if (!sq.trim().startsWith("@")) {
                OperadorEvidencia.logarPasso("AVISO: Encontrada uma tag em @: " + sq +
                        "Isto poderia ocasionar o consumo de massa incorreta.");
            }
            String teste = json.get(chave).toString();
            String[] vlrsChaveJson = teste.split(",");
            List<String> lista = Arrays.asList(vlrsChaveJson);

            if (lista.contains(sq)) {
                massaF = json;
            } else {
                OperadorEvidencia.logarPasso("AVISO: A chave " + chave + " não contém o valor " + sq);
            }
        }
        return massaF;
    }

    public static String replace(JsonPath jsonPath, String path) {
        return jsonPath.getString(path).replace("[", "").replace("]", "");
    }

    /**
     * Recuperar Nome da Classe De Teste
     * @return String
     */
    public String recuperarClasseDeTeste() throws Exception {

        Throwable throwable = new Throwable();
        throwable.fillInStackTrace();
        StackTraceElement[] stackTraceElement = throwable.getStackTrace();
        String nomeClasse = "";
        for (StackTraceElement s : stackTraceElement) {
            if(!Strings.isNullOrEmpty(s.getFileName())) nomeClasse = s.getFileName();
            nomeClasse = nomeClasse.replaceAll("[^QA0-9]+", "");
            if (nomeClasse.matches("QA[0-9]+")) break;
        }
        OperadorEvidencia.logarPasso("Nome da classe de teste recuperado: [" + nomeClasse + "]");
        return  nomeClasse;

    }

}
