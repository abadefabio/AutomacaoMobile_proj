package funcionalidade.transferencia;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.GET;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserId;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserPassword;
import static org.hamcrest.Matchers.*;

import br.com.next.automacao.core.api.token.crs.TokenCrsApi;
import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.tools.ReadProperties;

import constantes.CodigosRetorno;
import constantes.NextTransfer;

public class ListarTransferenciasFunc extends ListarContatoAtributos {

    protected RespostaBase respostaBase;
    private String uri = ReadProperties.getCaUrl();

    /**
     * Listar transfer�ncias programadas/agendadas sem resultado
     *
     * @param cpf          CPF a ser logado para gera��o do Token
     * @param dataInicial  Data inicial a ser consultada a transfer�ncia
     * @param dataFinal    Data final a ser consultada a transfer�ncia
     * @return ListarTransferenciasFunc
     * @throws Exception
     */
    public ListarTransferenciasFunc listarTransferenciasProgramadasAgendadas(
            String cpf,
            String dataInicial,
            String dataFinal) throws Exception {
        String requisicao = NextTransfer.LISTA_TRANSFERENCIAS_PROGRAMADAS_AGENDADAS;
        logarPasso(String.format("Montando requisi��o '%s'", requisicao));

        TokenCrsApi tokenCrsApi = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword());
        String token = loginCliente(tokenCrsApi);

        try {
            DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
            dadosRequisicaoBase
                    .limparDadosRequisicao()
                    .definirHeaders(obterHeaderRequisicao(token))
                    .definirParametros(
                            "startDate", dataInicial,
                            "endDate", dataFinal)
                    .definirCaminhoRequisicao(requisicao);

            respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET);
            logarPassoResposta(respostaBase);
        } finally {
            logoffCliente(tokenCrsApi, token);
        }
        return this;
    }

    /**
     * Validar a lista de transfer�ncias programadas/agendadas est� vazia
     *
     * @return ListarTransferenciasFunc
     */
    public ListarTransferenciasFunc validarListaTransferenciasVazia() {
        logarPasso("Validando retorno requisi��o");

        respostaBase.validarStatusCodeRequisicao(CodigosRetorno.OK.getCodigo())
                .getResponse().then()
                .body("system.messages", empty())
                .body("scheduledTransfers", empty())
                .body("listSize", is(0))
                .body("restartSchedulingNumber", is(""));

        return this;
    }

    /**
     * Listar recibos de transfer�ncias efetivadas sem sucesso
     *
     * @param cpf          CPF a ser logado para gera��o do Token
     * @return ListarTransferenciasFunc
     * @throws Exception
     */
    public ListarTransferenciasFunc listarRecibosTransferenciasEfetivadasSemSucesso(String cpf, String transferId, String transferDate) throws Exception {
        String requisicao = NextTransfer.LISTA_OBTER_RECIBO_TRANSFERENCIA_EFEITVADA_SEM_SUCESSO + "/" + transferId + "/receipts";
        logarPasso(String.format("Montando requisi��o '%s'", requisicao));

        TokenCrsApi tokenCrsApi = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword());
        String token = loginCliente(tokenCrsApi);

        try {
            DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
            dadosRequisicaoBase
                    .limparDadosRequisicao()
                    .definirHeaders(obterHeaderRequisicao(token))
                    .definirParametros(
                    "transferDate", transferDate)
                    .definirCaminhoRequisicao(requisicao);

            respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET);
            logarPassoResposta(respostaBase);
        } finally {
            logoffCliente(tokenCrsApi, token);
        }
        return this;
    }

    /**
     * Validar retorno 400
     *
     * @return ListarTransferenciasFunc
     */
    public ListarTransferenciasFunc validarRetornoReciboTransferenciaSemSucesso() {
        logarPasso("Validando retorno requisi��o");

        respostaBase.validarStatusCodeRequisicao(CodigosRetorno.BAD_REQUEST.getCodigo())
                .getResponse().then()
                .body("system.messages", contains("Eita! N�o rolou"));

        return this;
    }

    /**
     * Validar a lista de transfer�ncias programadas/agendadas sem range de pesquisa
     *
     * @return ListarTransferenciasFunc
     */
    public ListarTransferenciasFunc validarListaTransferenciasSemRangePesquisa() {
        logarPasso("Validando retorno requisi��o");

        respostaBase.validarStatusCodeRequisicao(CodigosRetorno.BAD_REQUEST.getCodigo())
                .getResponse().then()
                .body("system.messages", empty())
                .body("$", not(hasKey("scheduledTransfers")))
                .body("$", not(hasKey("listSize")))
                .body("$", not(hasKey("restartSchedulingNumber")));

        return this;
    }

    /**
     * Validar se status da resposta � a especificada
     *
     * @param statusCode
     * @return
     */
    public ListarTransferenciasFunc validarStatusResposta(int statusCode) {
        logarPasso("Validando retorno requisi��o");

        respostaBase.validarStatusCodeRequisicao(statusCode);

        return this;

    }
}
