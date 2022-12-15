package funcionalidade.api.cockpit.base;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.constantes.MetodoRequisicao;
import br.com.next.automacao.core.exception.NextException;
import io.restassured.http.Header;

public class CaApi {
    protected DadosRequisicaoBase dados;

    public CaApi(DadosRequisicaoBase dados) {
        this.dados = dados;
    }

    /**
     * Envia a requisição GET com headers e corpo da mensagem
     * @param token
     * @param esteira
     * @return
     * @throws NextException
     */
    public RespostaBase enviarRequisicaoGet(String token, String esteira) throws NextException {
        Header[] headers = new Header[] {
                new Header("coreIp", esteira),
                new Header("X-Next-AuthToken", token)
        };
        dados.definirHeaders(headers);
        return RequisicaoBase.executarRequisicao(
                dados,
                MetodoRequisicao.GET,
                200,
                "Houve um erro na requisição ao serviço GET: " + dados);
    }
}
