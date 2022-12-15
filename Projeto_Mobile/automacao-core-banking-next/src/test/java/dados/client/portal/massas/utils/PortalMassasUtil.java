package dados.client.portal.massas.utils;

import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Objects;

public class PortalMassasUtil {
    /**
     * Converter class de response provindos do Portal de massas
     * para JSONObject
     * @param response  - response provindo do portal de massas
     */
    public static JSONObject convertResponseJsonObject(Object response) throws JsonProcessingException, ParseException {

        JSONParser parser = new JSONParser();

        ObjectWriter objectMapper = new ObjectMapper()
                .writer()
                .withDefaultPrettyPrinter();
        String jsonString = objectMapper.writeValueAsString(response);

        return (JSONObject) parser.parse(jsonString);
    }

    /**
     * Renomeia objetos provindos do Portal de massas
     * devido a nomeclatura estar em inglês
     * @param responsePortalMassa  - response provindo do portal de massas para a troca de nomes
     * para que fiquem iguais aos do arquivo .JSON de cada teste
     * @param arquivoJson - Arquivo .JSON provindo de cada class de teste
     */
    public static JSONObject alterPropertiesJsonObject(JSONObject responsePortalMassa, JSONObject arquivoJson) {

        if (Objects.nonNull(responsePortalMassa) && Objects.nonNull(arquivoJson)) {
            PortalMassasEnum.stream().forEach(enumPortal ->
                    arquivoJson.keySet().forEach(keyJson -> {
                        if (enumPortal.getValue().equals(keyJson)) {
                            responsePortalMassa.put(keyJson, responsePortalMassa.remove(enumPortal.name()));
                        } else if (responsePortalMassa.get(keyJson) == null) {
                            responsePortalMassa.put(keyJson, arquivoJson.get(keyJson));
                        }
                    }));
        } else {
            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Error no parse do arquivo. DICA: Verifique se existe um arquivo .JSON para o teste selecionado");
            return null;
        }

        removeUnnecessaryObjects(responsePortalMassa);

        return responsePortalMassa;
    }

    private static void removeUnnecessaryObjects(JSONObject responsePortalMassa) {
        if (responsePortalMassa.get("system") != null)
            responsePortalMassa.remove("system");

        if (responsePortalMassa.get("success") != null)
            responsePortalMassa.remove("success");
    }
}
