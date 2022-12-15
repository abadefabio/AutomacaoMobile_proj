package funcionalidade.massa;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.List;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static java.util.Objects.isNull;

public class MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return null; // TODO melhoria: substituir pelo mesmo que obterJsonTesteAtual, para não ser preciso chamar obterJsonTesteAtual em cada MassaQA, nem precisaria criar arquivo massaQA para esses casos, porém seria preciso ajuste Framework gerar MassaQA padrão
    }

    public JSONObject obterJsonTesteAtual() throws Exception {
        return lerArquivoJson(this.getClass().getSimpleName().replace("Massa", ""));
    }

    @SuppressWarnings("unchecked")
    public JSONObject lerArquivoJson(String qa) throws Exception {
        var massa = dadosArquivoJson(qa);
        var squadList = getCasoTeste().getParametrosTeste().getOrDefault("squad", null);
        var tagList = getCasoTeste().getParametrosTeste().getOrDefault("tags", null);

        JSONObject massaF = new JSONObject();
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
                    OperadorEvidencia.logarPasso("Massa encontrada para o cenario:" + massa);
                    break;
                }
            }
        }

        if (massa.containsKey(ReadProperties.getAmbiente())) {
            massa = (JSONObject) massa.get(ReadProperties.getAmbiente());
            OperadorEvidencia.logarPasso("Info: Massa selecionada para o ambiente " + ReadProperties.getAmbiente());
            OperadorEvidencia.logarPasso(massa.toJSONString());
        } else {
            OperadorEvidencia.logarPasso("Info: Massa nao contem separacao por ambiente tu/ti");
        }

        var plataforma = getCasoTeste().getParametrosTeste().getOrDefault("plataforma", null);
        if (!isNull(plataforma)) {
            var plataformaLowerCase = plataforma.toLowerCase();
            if (massa.containsKey(plataformaLowerCase)) {
                massa = (JSONObject) massa.get(plataformaLowerCase);
                OperadorEvidencia.logarPasso("Info: Massa selecionada para a plataforma " + plataformaLowerCase);
                OperadorEvidencia.logarPasso(massa.toJSONString());
            } else {
                OperadorEvidencia.logarPasso("Info: Massa nao contem separacao de plataforma android ou ios");
            }
        }
        return massa;
    }

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
                OperadorEvidencia.logarPasso("AVISO: A chave " + chave + " nao contem o valor " + sq);
            }
        }
        return massaF;
    }
}
