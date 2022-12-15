package funcionalidade.transferencia;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.GET;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserId;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserPassword;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import br.com.next.automacao.core.api.token.crs.TokenCrsApi;
import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.tools.ReadProperties;
import constantes.CodigosRetorno;
import constantes.NextTransfer;

public class ListarInstrucoesTransferenciaFunc extends ListarContatoAtributos {

    protected RespostaBase respostaBase;
    private String uri = ReadProperties.getCaUrl();

    /**
     * Listar instruções de transferência
     *
     * @param cpf CPF a ser logado para geração do token e listagem das instruções de transferência
     * @return ListarInstrucoesTransferenciaFunc
     * @throws Exception
     */
    public ListarInstrucoesTransferenciaFunc listarInstrucoesTransferencia(String cpf) throws Exception {
        String requisicao = NextTransfer.LISTA_INSTRUCOES_TRANSFERENCIA;
        logarPasso(String.format("Montando requisição '%s'", requisicao));

        TokenCrsApi tokenCrsApi = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword());
        String token = loginCliente(tokenCrsApi);

        try {
            DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
            dadosRequisicaoBase
                    .limparDadosRequisicao()
                    .definirHeaders(obterHeaderRequisicao(token))
                    .definirCorpoRequisicao("customerId", cpf)
                    .definirCaminhoRequisicao(requisicao);
            respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET);
            logarPassoResposta(respostaBase);
        } finally {
            logoffCliente(tokenCrsApi, token);
        }

        return this;
    }

    /**
     * Validar a lista de instruções de transferência
     *
     * @return ListarInstrucoesTransferenciaFunc
     */
    public ListarInstrucoesTransferenciaFunc validarInstrucoesTransferencia() {
        logarPasso("Validando retorno requisição");

        respostaBase.validarStatusCodeRequisicao(CodigosRetorno.OK.getCodigo())
                .getResponse().then()
                .body("system.messages", empty())
                .body("returnCode", is(443))
                .body("returnMessage", is("Operacao efetuada"))
                .body("accountOwnershipIndicator", is("S"))
                .body("currentAccountTypeIndicator", is("S"))
                .body("savingsAccountTypeIndicator", is("S"))
                .body("investmentAccountTypeIndicator", is("N"))
                .body("tedPermittedToNonRegisteredAccountIndicator", is(true))
                .body("registeredRecipientAccountIndicator", is("N"))
                .body("transferConstraints.transferType", is(Arrays.asList("TED", "DOC", "INT", "INT", "INT")))
                .body("transferConstraints.allowedStartTime", is(Arrays.asList("10:01:00.000000Z", "09:00:00.000000Z", "0000", "0000", "0000")))
                .body("transferConstraints.allowedEndTime", is(Arrays.asList("01:55:00.000000Z", "22:55:00.000000Z", "2359", "2359", "0000")))
                .body("transferConstraints.minimumValue", is(Arrays.asList(0.01f, 0.01f, 0.0f, 0.0f, 0.0f)))
                .body("transferConstraints.maximumValue", is(Arrays.asList(50000.0f, 4999.99f, 10000.0f, 10000.0f, 10000.0f)))
                .body("transferConstraints.maximumValueRegisteredRecipientAccount", is(Arrays.asList(50000.0f, 4999.99f, 10000.0f, 0.0f, 10000.0f)))
                .body("transferConstraints.limitNonRegisteredRecipientAccount", is(Arrays.asList(50000.0f, 4999.99f, null, null, null)))
                .body("transferConstraints.limitRegisteredRecipientAccount", is(Arrays.asList(50000.0f, 4999.99f, null, null, null)))
                .body("transferConstraints.balanceAvailableNonRegisteredRecipientAccount", is(Arrays.asList(50000.0f, 4999.99f, 10000.0f, 10000.0f, 10000.0f)))
                .body("transferConstraints.balanceAvailableRegisteredRecipientAccount", is(Arrays.asList(50000.0f, 4999.99f, 0.0f, 0.0f, 0.0f)))
                .body("transferConstraints.fee", is(Arrays.asList(11.65f, 11.65f, 0, 0, 0)))
                .body("transferConstraints.usedValueLimit", is(Arrays.asList(0.0f, 0.00f, null, null, null)))
                .body("transferConstraints.accountType", is(Arrays.asList(null, null, "CURRENT", "SAVING", "INSS")))
                .body("transferConstraints.allowedStartTimeRegisteredAccounts", is(Arrays.asList(null, null, "0000", "0000", null)))
                .body("transferConstraints.allowedEndTimeRegisteredAccounts", is(Arrays.asList(null, null, "2359", "2359", null)))
                .body("transferConstraints.hasRegisteredAccounts", is(Arrays.asList(null, null, false, false, false)))
                .body("transferConstraints.totalNightLimit", is(Arrays.asList(null, null, 10000.0f, 10000.0f, null)))
                .body("transferConstraints.availableNightLimit", is(Arrays.asList(null, null, 10000.0f, 10000.0f, null)))
                .body("transferConstraints.limitTypeIndicator", is(Arrays.asList(null, null, "D", "D", "D")))
                .body("transferConstraints.startDayTimeLimit", is(Arrays.asList(null, null, "2000", "2000", "2000")))
                .body("transferConstraints.endDayTimeLimit", is(Arrays.asList(null, null, "0600", "0600", "0600")))
                .body("transferConstraints.startNightTimeLimit", is(Arrays.asList(null, null, "0600", "0600", "0600")))
                .body("transferConstraints.endNightTimeLimit", is(Arrays.asList(null, null, "2000", "2000", "2000")))
                .body("transferConstraints.daytimeLimitUsedRegisteredAccount", is(Arrays.asList(null, null, 0.0f, 0.0f, null)))
                .body("transferConstraints.daytimeLimitUsedNonRegisteredAccount", is(Arrays.asList(null, null, 0.0f, 0.0f, null)))
                .body("transferConstraints.nightLimitUsedNonRegisteredAccount", is(Arrays.asList(null, null, 0.0f, 0.0f, null)));

        return this;
    }
}
