package funcionalidade.api.cockpit;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.constantes.MetodoRequisicao;
import br.com.next.automacao.core.tools.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.json.simple.JSONObject;

import static br.com.next.automacao.core.tools.ReadProperties.getEmuladorPass;
import static br.com.next.automacao.core.tools.ReadProperties.getEmuladorUser;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;

@SuppressWarnings("unchecked")
public class LoginFunc extends FuncionalidadeBase {

    private String token;
    private String esteira;
    private String caminhoRequisicao;

    public LoginFunc() {
        this.caminhoRequisicao = "/v1/login/csr";
    }

    private void setToken(String token) {
        this.token = token;
    }

    /**
     * Método para obter o token já gerado na instância
     * @return
     */
    public String getToken(){
        return token;
    }

    private void setEsteira(String esteira) {
        this.esteira = esteira;
    }

    /**
     * Método para retornar a esteira utilizada quando da geração do token
     * @return
     */
    public String getEsteira() {
        return esteira;
    }

    /**
     * Método para efetuar o logoff do token do cliente
     * @param cpf
     * @throws Exception
     */
    public void logoffToken(String cpf) throws Exception{

        Header[] headers = new Header[]{
                new Header("Authorization", "Basic ZGV2OmNhcGNv"),
                new Header("X-Next-AuthToken", token),
                new Header("ContentType", ContentType.JSON.toString())
        };

        JSONObject requisicao = new JSONObject();
        requisicao.put("agentId", getEmuladorUser());
        requisicao.put("cpf", cpf);
        requisicao.put("password", getEmuladorPass());
        requisicao.put("csrUserId", getEmuladorUser());
        requisicao.put("host", "D4253E0227");
        requisicao.put("ticketId", "1235656");

        TesteBase.getDadosRequisicao()
                .limparDadosRequisicao()
                .definirCaminhoRequisicao("/v1/logoff/csr")
                .definirHeaders(headers)
                .definirCorpoRequisicao(requisicao);

        RequisicaoBase.executarRequisicao(TesteBase.getDadosRequisicao(), MetodoRequisicao.POST)
                .validarStatusCodeRequisicao(200, "Falha ao obter resposta do logoff do token");
        setToken(null);

    }

    /**
     * Método para gerar o token na instância
     * Paleativo
     * @param cpf
     * @throws Exception
     */
    public void obterToken(String cpf) throws Exception{

        setEsteira(ReadProperties.getEsteira());
        Header[] headers = new Header[]{
                new Header("ContentType", ContentType.JSON.toString()),
                new Header("Accept", ContentType.TEXT.toString()),
                new Header("channel", "MNCC"),
                new Header("coreIp", esteira)};

        JSONObject requisicao = new JSONObject();
        requisicao.put("agentId", getEmuladorUser());
        requisicao.put("cpf", cpf);
        requisicao.put("password", getEmuladorPass());
        requisicao.put("csrUserId", getEmuladorUser());
        requisicao.put("host", "D4253E0227");
        requisicao.put("ticketId", "1235656");

        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(ReadProperties.getCaUrl(), "/v1/login/csr")
                .definirHeaders(headers)
                .definirCorpoRequisicao(requisicao)
                .definirCaminhoRequisicao(caminhoRequisicao);
        setToken(RequisicaoBase.executarRequisicao(dadosRequisicaoBase, MetodoRequisicao.POST)
                .validarStatusCodeRequisicao(200, "Falha ao executar a requisição para obter o token")
                .obterJsonPath()
                .get("token")
        );
    }

    /**
     * Método para efetuar o logoff do token do cliente
     * Paleativo
     * @param cpf
     * @throws Exception
     */
    public void logoffToken(String cpf, String uri) throws Exception{

        Header[] headers = new Header[]{
                new Header("Authorization", "Basic ZGV2OmNhcGNv"),
                new Header("X-Next-AuthToken", token),
                new Header("ContentType", ContentType.JSON.toString())
        };


        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(ReadProperties.getCaUrl(), "/v1/logoff/csr")
                .definirHeaders(headers);

        RequisicaoBase.executarRequisicao(dadosRequisicaoBase, MetodoRequisicao.POST)
                .validarStatusCodeRequisicao(200, "Falha ao obter resposta do logoff do token");

    }
}
