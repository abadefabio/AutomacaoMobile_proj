package funcionalidade.transferencia;

import br.com.next.automacao.core.api.token.crs.TokenCrsApi;
import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.tools.ReadProperties;
import constantes.NextTransfer;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.GET;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserId;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserPassword;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasKey;

public class FundosFunc extends FundosAtributos{
    protected RespostaBase respostaBase;
    private String uri = ReadProperties.getCaUrl();

    /**
     * Listar fundos saldo suficiente
     *
     * @return
     * @throws Exception
     */
    public FundosFunc listarFundosSaldoSuficiente(String cpf) throws Exception {
        String requisicao = NextTransfer.VALIDAR_CLIENTE_FUNDOS_SUFICIENTE;
        logarPasso(String.format("Montando requisição '%s'", requisicao));

        TokenCrsApi tokenCrsApi = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword());
        String token = loginCliente(tokenCrsApi);

        try {
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri)
                    .limparDadosRequisicao()
                    .definirHeaders(obterHeaderRequisicao(token))
                    .definirCaminhoRequisicao(requisicao);

        respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET);
        logarPassoResposta(respostaBase);
        } finally {
            logoffCliente(tokenCrsApi, token);
        }

        return this;
    }

    /**
     * Validar fundos com saldo suficiente
     *
     * @param statusCode
     * @return
     */
    public FundosFunc validarFundosSaldoSuficiente(int statusCode) {
        logarPasso("Validando retorno requisição");

        respostaBase.validarStatusCodeRequisicao(statusCode)
                .getResponse().then()
                .body("sufficientFundsInCurrent", is(true));

        return this;
    }
}
