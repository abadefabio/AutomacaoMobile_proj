package dados.utils;

import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Objects;


public class PortalMassasUtil {

    public static JSONObject convertResponseJsonObject(Object obj) throws JsonProcessingException, ParseException {

        JSONParser parser = new JSONParser();

        ObjectWriter objectMapper = new ObjectMapper()
                .writer()
                .withDefaultPrettyPrinter();
        String jsonString = objectMapper.writeValueAsString(obj);

        return (JSONObject) parser.parse(jsonString);
    }

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
        return responsePortalMassa;
    }
}
