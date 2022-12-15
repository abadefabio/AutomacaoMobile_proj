package funcionalidade.api.cockpit.atendimento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import funcionalidade.api.cockpit.base.CaApi;
import org.json.simple.JSONObject;

import static br.com.next.automacao.core.base.TesteBase.*;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static org.hamcrest.Matchers.is;

public class StatusCustomerApiFunc extends FuncionalidadeBase {

    private RespostaBase respostaBase;


    /** Enviar Requisição deOnBoarding
     *
     * @param token
     * @param endpoint
     * @param esteira
     * @return
     * @throws Exception
     */
    public void enviarRequisicao(String endpoint, String token, String esteira) throws Exception {

        logarPasso("Realizando requisicao EndPoint");
        getDadosRequisicao()
                .limparDadosRequisicao()
                .definirCaminhoRequisicao(endpoint);
        respostaBase = new CaApi(getDadosRequisicao())
                .enviarRequisicaoGet(token, esteira);
        logarPasso(respostaBase.getResponse().asPrettyString());
    }

    /** Validar Status e dados
     *
     * @param jsonObject
     * @param status
     * @return
     */
    public void validarStatusEDadosRequisicao(JSONObject jsonObject,int status) {
        final String STATUS = "onboardingStatus";
        final String DATE_CREATION = "applicationCreationDate";
        final String REJECT_REASON = "rejectionReason";
        final String UNDER_ANALISIS_DATE = "underAnalysisDate";
        final String REJECT_DATE = "rejectionDate";
        switch (status) {
            case 1:
                OperadorEvidencia.logarPasso("Validar Status OnBoarding");
                respostaBase.getResponse()
                        .then()
                        .body(STATUS, is(Integer.parseInt(jsonObject.get(STATUS).toString())));
                OperadorEvidencia.logarPasso("Validar data criação:");
                respostaBase.getResponse()
                        .then()
                        .body(DATE_CREATION, is(jsonObject.get(DATE_CREATION)));
                break;
            case 2:
                OperadorEvidencia.logarPasso("Validar Status OnBoarding");
                respostaBase.getResponse()
                        .then()
                        .body(STATUS, is(Integer.parseInt(jsonObject.get(STATUS).toString())));

                OperadorEvidencia.logarPasso("Validar Reject Reason");
                respostaBase.getResponse()
                        .then()
                        .body(REJECT_REASON, is(jsonObject.get(REJECT_REASON)));

                OperadorEvidencia.logarPasso("Validar Date Creation");
                respostaBase.getResponse()
                        .then()
                        .body(DATE_CREATION, is(jsonObject.get(DATE_CREATION)));

                OperadorEvidencia.logarPasso("Validar Under Analisis Dtte");
                respostaBase.getResponse()
                        .then()
                        .body(UNDER_ANALISIS_DATE, is(jsonObject.get(UNDER_ANALISIS_DATE)));

                OperadorEvidencia.logarPasso("Validar Reject Date");
                respostaBase.getResponse()
                        .then()
                        .body(   REJECT_DATE, is( jsonObject.get(REJECT_DATE)));

                break;
            case 5:
                OperadorEvidencia.logarPasso("Validar Status OnBoarding");
                respostaBase.getResponse()
                        .then()
                        .body(STATUS, is(Integer.parseInt(jsonObject.get(STATUS).toString())));

                OperadorEvidencia.logarPasso("Validar data criação:");
                respostaBase.getResponse()
                        .then()
                        .body(DATE_CREATION, is(jsonObject.get(DATE_CREATION)));
                break;

        }
        respostaBase = null;
    }


}

