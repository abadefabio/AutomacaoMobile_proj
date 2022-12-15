package funcionalidade.api.cockpit.atendimento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;
import funcionalidade.api.cockpit.base.CaApi;
import org.json.simple.JSONObject;

import static br.com.next.automacao.core.base.TesteBase.*;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AllBallancesApiFunc extends FuncionalidadeBase {

    protected RespostaBase respostaBase;

    /**
     * Envia uma requisição uma única vez por instanciação da funcionalidade,
     * obtendo o token e a requisição propriamente dita, e descartando o token
     * em seguida.
     * A resposta é mantida na instância para futuras validações.
     *
     * @param token
     * @param endpoint
     * @param esteira
     * @return
     * @throws NextException
     */

    public void enviarRequisicaoGet(String endpoint, String token, String esteira) throws NextException {
        getDadosRequisicao()
                .limparDadosRequisicao()
                .definirCaminhoRequisicao(endpoint);
        respostaBase = new CaApi(getDadosRequisicao())
                .enviarRequisicaoGet(token, esteira);
        logarPasso(respostaBase.getResponse().asPrettyString());
    }


    /**
     * Valida o resumo de saldo
     *
     * @param jsonObject da massa pertinente a saldos
     * @return
     */
    public void validarResumoSaldo(JSONObject jsonObject) {
        final String STATUS = "account.corebankStatus";
        final String AVAIL_INVEST = "account.specificAccountBalances.availableForInvestments";
        final String LINKEDBAL = "account.specificAccountBalances.linkedBalance";
        final String FREEMOV = "account.specificAccountBalances.freeForMoviment";
        respostaBase.getResponse().then()
                .body(STATUS, is(Integer.parseInt(jsonObject.get(STATUS).toString())))
                .body(AVAIL_INVEST, is(Integer.parseInt(jsonObject.get(AVAIL_INVEST).toString())))
                .body(LINKEDBAL, is(Integer.parseInt(jsonObject.get(LINKEDBAL).toString())))
                .body(FREEMOV,is(Integer.parseInt(jsonObject.get(FREEMOV).toString())))
                .body("account.specificAccountBalances.currentAccountBalance", notNullValue())
                .body("account.specificAccountBalances.savingAccountBalance", notNullValue())
                .body("account.specificAccountBalances.investmentsWithAutomaticTransferOfFunds", notNullValue())
                .body("account.specificAccountBalances.investmentsWithoutAutomaticTransferOfFunds", notNullValue());
    }

    /**
     * Valida o resumo de cartão de crédito
     *
     * @return
     */
    public void validarResumoCreditCard() {
        respostaBase.getResponse()
                .then()
                .body("creditCard.corebankStatus",is(0));
    }

    /**
     * Valida o resumo de limites
     *
     * @param jsonObject da massa pertinente a limites
     * @return
     */
    public void validarResumoLimites(JSONObject jsonObject) {
        final String STATUS = "limit.corebankStatus";
        final String MESSAGE = "limit.corebankMessage";
        respostaBase.getResponse()
                .then()
                .body(STATUS,is(Integer.parseInt(jsonObject.get(STATUS).toString())))
                .body(MESSAGE,is(jsonObject.get(MESSAGE)));
    }
}

