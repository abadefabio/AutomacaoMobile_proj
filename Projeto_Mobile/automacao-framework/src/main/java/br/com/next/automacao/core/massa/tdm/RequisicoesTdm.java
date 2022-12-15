package br.com.next.automacao.core.massa.tdm;

import br.com.next.automacao.core.tools.ReadProperties;
import io.restassured.http.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import java.util.List;

import static br.com.next.automacao.core.massa.tdm.ConectorTdm.getTokenTdm;
import static br.com.next.automacao.core.massa.tdm.ConectorTdm.invalidarTdmToken;
import static io.restassured.RestAssured.given;

public class RequisicoesTdm {

    private static JSONArray listaVariaveis = new JSONArray();
    private static ZonedDateTime time = ZonedDateTime.now(ZoneOffset.UTC);

    public void executarFluxoMassa(List<String> parametros) {
        try {
            given()
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + getTokenTdm())
                    .body(criarCorpoRequisicao(parametros))
                    .when()
                    .post(ReadProperties.getTdmUrl() + "/TDMDataFlowService/api/ca/v1/requests")
                    .then()
                    .statusCode(200)
            ;
            invalidarTdmToken();
        } catch (AssertionError error) {
            Reporter.log("Falha na execução de massa TDM: " + error.getMessage(), true);
        }
    }

    private JSONObject criarCorpoRequisicao(List<String> parametros) {
        JSONObject corpoPrincipal = new JSONObject();
        JSONObject corpoJobPubParams = new JSONObject();
        JSONObject corpoPublishJobs = new JSONObject();
        JSONObject corpoDataDesign = new JSONObject();

        JSONArray listaAlmJobs = new JSONArray();
        JSONArray listaRallyJobs = new JSONArray();
        JSONArray listaJobParams = new JSONArray();
        JSONArray listaPublishJobs = new JSONArray();
        JSONArray listaTestMatches = new JSONArray();
        JSONArray listaExportJobs = new JSONArray();

        corpoJobPubParams.put("scheduledDateTimeInMillisec", time.toInstant().toEpochMilli());
        corpoJobPubParams.put("almjobs", listaAlmJobs);
        corpoJobPubParams.put("rallyJobs", listaRallyJobs);
        corpoJobPubParams.put("jobParams", listaJobParams);

        corpoPublishJobs.put("batchEngineThread", "ANY");
        corpoPublishJobs.put("dataSourceProfile", "");
        corpoPublishJobs.put("dataTargetProfile", "");
        corpoPublishJobs.put("description", "");
        corpoPublishJobs.put("jobTitle", "Group Job");
        corpoPublishJobs.put("levelID", Integer.parseInt(parametros.get(0)));
        corpoPublishJobs.put("publishVariables", listaVariaveis);
        corpoPublishJobs.put("seq", 1);
        corpoPublishJobs.put("vtfnodeID", parametros.get(1));
        corpoPublishJobs.put("vtfnodeName", parametros.get(2));
        corpoPublishJobs.put("iterations", 1);
        corpoPublishJobs.put("configurationId", 586);
        listaPublishJobs.add(corpoPublishJobs);

        corpoJobPubParams.put("publishJobs", listaPublishJobs);
        corpoJobPubParams.put("testMatches", listaTestMatches);
        corpoJobPubParams.put("exportJobs", listaExportJobs);
        corpoJobPubParams.put("scheduledDt", "");
        corpoJobPubParams.put("selfServiceEmailMandate", false);
        corpoJobPubParams.put("email", "");
        corpoJobPubParams.put("globalThreadName", "ANY");
        corpoJobPubParams.put("scheduledDateTimeInMillis", time.toInstant().toEpochMilli());
        corpoJobPubParams.put("currentDay", time.getDayOfMonth());
        corpoJobPubParams.put("currentMonth", time.getMonthValue());
        corpoJobPubParams.put("currentYear", time.getYear());
        corpoJobPubParams.put("globalSourceConnection", "");
        corpoJobPubParams.put("globalTargetConnection", "");
        corpoJobPubParams.put("jobSubmissionOrder", "1");
        corpoJobPubParams.put("jobTitle", parametros.get(3));
        corpoJobPubParams.put("username", ReadProperties.getFuncionalUser());

        corpoPrincipal.put("jobPubParams", corpoJobPubParams);
        corpoPrincipal.put("advancedToggleFlag", true);
        corpoDataDesign.put("projectID", Integer.parseInt(parametros.get(4)));
        corpoDataDesign.put("versionID", Integer.parseInt(parametros.get(5)));
        corpoPrincipal.put("dataDesign", corpoDataDesign);

        return corpoPrincipal;
    }

    private JSONObject criarVariavel(String name, String value) {
        JSONObject variavel = new JSONObject();
        variavel.put("name", name);
        variavel.put("preResolveError", "");
        variavel.put("preResolveValue", "");
        variavel.put("value", value);
        return variavel;
    }

    public void implementarListaVariaveis(String name, String value) {
        listaVariaveis.add(criarVariavel(name, value));
    }
}
