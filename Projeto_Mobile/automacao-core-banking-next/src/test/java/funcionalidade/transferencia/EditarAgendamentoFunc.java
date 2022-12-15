package funcionalidade.transferencia;

import br.com.next.automacao.core.api.token.crs.TokenCrsApi;
import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.tools.ReadProperties;
import constantes.CodigosRetorno;
import constantes.NextTransfer;

import java.util.Random;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.PUT;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserId;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserPassword;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class EditarAgendamentoFunc extends ListarContatoAtributos {

    protected RespostaBase respostaBase;
    private String uri = ReadProperties.getCaUrl();

    /**
     * Atualizar categoria de transferencia agendada
     *
     * @param cpf
     * @param transferId
     * @return
     * @throws Exception
     */
    public EditarAgendamentoFunc atualizarCategoriaTransferenciaAgendada(String cpf, String transferId, String categoryId) throws Exception {
        String requisicao = NextTransfer.LISTA_TRANSFERENCIAS_PROGRAMADAS_AGENDADAS+ "/" + transferId + "/categories";
        logarPasso(String.format("Montando requisição '%s'", requisicao));

        TokenCrsApi tokenCrsApi = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword());
        String token = loginCliente(tokenCrsApi);

        try {
            DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
            dadosRequisicaoBase
                    .limparDadosRequisicao()
                    .definirHeaders(obterHeaderRequisicao(token))
                    .definirParametros(
                            "categoryId",  categoryId)
                    .definirCaminhoRequisicao(requisicao);

            respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, PUT);
            logarPassoResposta(respostaBase);
        } finally {
            logoffCliente(tokenCrsApi, token);
        }

        return this;
    }

    /**
     * Validar se a atualizacao de categoria de transferencia foi feita com sucesso
     *
     * @return ListarTransferenciasFunc
     */
    public EditarAgendamentoFunc validarAtualizacaoCategoriaTransferenciaAgendada(){
        respostaBase.validarStatusCodeRequisicao(CodigosRetorno.OK.getCodigo())
                .getResponse().then()
                .body("system.messages", empty());

        return this;
    }

    /**
     * Validar se a atualizacao de categoria invalida para uma transferencia esta sendo validada
     *
     * @return ListarTransferenciasFunc
     */
    public EditarAgendamentoFunc validarAtualizacaoCategoriaInvalidaParaTransferenciaAgendada(){
        respostaBase.validarStatusCodeRequisicao(CodigosRetorno.BAD_REQUEST.getCodigo())
                .getResponse().then()
                .body("system.messages", contains("Categoria não é válida"));

        return this;
    }

}
