package api.base;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.tools.ReadProperties;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.junit.Test;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.POST;


public class LoginApiCorporativa {
    private static String uri = ReadProperties.getCoreBankingUrl();

    /**
     * Abre a sessão do cliente
     * @return idSessao
     * @return ticket
     * @throws Exception
     */
    public static String abrirSessaoApiCorporativa(String cpf, int i) throws Exception{

        Header[] headers = new Header[]{
                new Header("Content-Type", "application/json"),
                new Header("access-token", "wFvPZv4unKWJ"),

        };

        JSONObject requisicao = new JSONObject();
        requisicao.put("cpf", cpf);
        requisicao.put("midia", 515);
        requisicao.put("codigoDispositivo", "AAAAAAAAAAAAAAAAAAAA");
        requisicao.put("endereco", "");
        requisicao.put("complementoEndereco", "");
        requisicao.put("cidade", "");
        requisicao.put("estado", "");
        requisicao.put("cep", 0);
        requisicao.put("complementoCep", 0);
        requisicao.put("dataNascimento", "2000-01-01");
        requisicao.put("email", "");
        requisicao.put("nome", "");
        requisicao.put("sexo", "");
        requisicao.put("telefone", 0);

        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .definirHeaders(headers)
                .definirCorpoRequisicao(requisicao)
                .definirCaminhoRequisicao("/v2/acessos/onboarding");


       JsonPath response= RequisicaoBase.executarRequisicao(dadosRequisicaoBase, POST)
                .validarStatusCodeRequisicao(200, "Falha ao obter resposta dos dados do cliente").obterJsonPath();

        String retorno[] = new String[2];

        retorno[0] = response.getString("idSessao");
        retorno[1] = response.getString("ticket");

       return retorno[i];
    }

}
