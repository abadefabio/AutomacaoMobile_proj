package br.com.next.automacao.core.base.api;

import br.com.next.automacao.core.constantes.MetodoRequisicao;
import br.com.next.automacao.core.exception.NextException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Reporter;

import java.io.File;
import java.util.Map;

/**
 * Classe responsável por encapsular itens pertinentes à requisição HTTP
 *
 * @author Lucas Santos
 * @since 02-2020
 */
public class RequisicaoBase {


    protected RequestSpecification request;

    public RequisicaoBase() {
        request = RestAssured.given();
    }

    /**
     * Método retorna objeto RequestSpecification, que contem as especificações para o chamado API-Restful
     *
     * @return RequestSpecification
     */
    public RequestSpecification getRequest() {
        return request;
    }

    /**
     * Ao utilizar esse método, você confiará em todos os hosts mesmo quando o certificado estiver inválido
     */
    public RequisicaoBase usarRelaxedHTTPSValidation() {
        request.relaxedHTTPSValidation();
        return this;
    }

    /**
     * Método define cookies a serem incluídos no chamado a API-Restful
     *
     * @param cookies
     * @return
     */
    public RequisicaoBase definirCookies(Cookies cookies) {
        request.cookies(cookies);
        return this;
    }

    /**
     * Define o ContentType da requisição
     *
     * @param type enumerador content type
     */
    public RequisicaoBase definirContentType(ContentType type) {
        request.contentType(type);
        return this;
    }

    /**
     * Define Headers a serem enviados no chamado HTTP
     *
     * @param headers
     * @return
     */
    public RequisicaoBase definirHeaders(Headers headers) {
        request.headers(headers);
        return this;
    }

    public RequisicaoBase definirHeaders(String nomePrimeiroHeader, Object valorPrimeiroHeader, Object... paresNomeValoresHeaders) {
        request.headers(nomePrimeiroHeader, valorPrimeiroHeader, paresNomeValoresHeaders);
        return this;
    }

    /**
     * Defnine o Header da requisição
     *
     * @param nomeHeader
     * @param primeiroValor
     * @param valoresHeaderAdicionais valores adicionais para o header
     * @return
     */
    public RequisicaoBase definirHeader(String nomeHeader, Object primeiroValor, Object... valoresHeaderAdicionais) {
        request.header(nomeHeader, primeiroValor, valoresHeaderAdicionais);
        return this;
    }

    /**
     * Defnine o Header da requisição
     *
     * @param header enumerador Header
     */
    public RequisicaoBase definirHeader(Header header) {
        request.header(header);
        return this;
    }

    /**
     * Define o corpo da requisição
     *
     * @param jsonBody
     */
    public RequisicaoBase definirBody(JSONObject jsonBody) {
        request.body(jsonBody.toJSONString());
        return this;
    }

    /**
     * Define o corpo da requisição
     *
     * @param valor
     */
    public RequisicaoBase definirBody(String valor) {
        request.body(valor);
        return this;
    }

    /**
     * Método especifica arquivo para upload no servidor usando multi-part form data uploading
     *
     * @param nomeControle
     * @param arquivoUpload
     * @param mimeType
     * @return
     */
    public RequisicaoBase especificarArquivoUpload(String nomeControle, File arquivoUpload, String mimeType) {
        request.multiPart(nomeControle, arquivoUpload, mimeType);
        return this;
    }

    /**
     * Método inclui lista de parâmetros na requisição
     *
     * @param parametros
     * @return
     */
    public RequisicaoBase definirParametros(Map<String, ?> parametros) {
        request.params(parametros);
        return this;
    }

    /**
     * Mátodo cria o objeto de requisição  de acordo com os dados incluídos no objeto dados requisição
     *
     * @param dadosRequisicao
     * @return
     */
    public static RequisicaoBase montarRequisicao(DadosRequisicaoBase dadosRequisicao) {
        RequisicaoBase requisicao = new RequisicaoBase();
        requisicao.usarRelaxedHTTPSValidation();
        if (dadosRequisicao.temCookies()) requisicao.definirCookies(dadosRequisicao.cookies);
        if (dadosRequisicao.temHeaders()) requisicao.definirHeaders(dadosRequisicao.headers);
        if (dadosRequisicao.temCorpoRequisicao())
            requisicao.definirContentType(ContentType.JSON).definirBody(dadosRequisicao.corpoRequisicao);
        if (dadosRequisicao.temParametros()) requisicao.definirParametros(dadosRequisicao.parametros);
        if (dadosRequisicao.temArquivoParaUpload())
            requisicao.especificarArquivoUpload(dadosRequisicao.nomeControleCorpoParte, dadosRequisicao.arquivo, dadosRequisicao.mimeType);
        return requisicao;
    }

    /**
     * Método executa chamado HTTP para API-Restful de acordo com os dados informados
     *
     * @param dadosRequisicao
     * @param metodoRequisicao
     * @return
     * @throws NextException
     */
    public static RespostaBase executarRequisicao(DadosRequisicaoBase dadosRequisicao, MetodoRequisicao metodoRequisicao) throws NextException {
        return montarRequisicao(dadosRequisicao).fazerRequisicao(metodoRequisicao, dadosRequisicao.caminho);
    }

    /**
     * Método executa chamado HTTP para API-Restful, validando o status code retornado
     *
     * @param dadosRequisicao
     * @param metodoRequisicao
     * @param statusCode
     * @param mensagemErro
     * @return
     * @throws NextException
     */
    public static RespostaBase executarRequisicao(DadosRequisicaoBase dadosRequisicao, MetodoRequisicao metodoRequisicao, int statusCode, String mensagemErro) throws NextException {
        return montarRequisicao(dadosRequisicao).fazerRequisicao(metodoRequisicao, dadosRequisicao.caminho).validarStatusCodeRequisicao(statusCode, mensagemErro);
    }

    /**
     * Método realiza chamado HTTP para API-Restful, utilizando a url armazenada em objeto DadosRequisicao
     *
     * @param dadosRequisicao
     * @param metodoRequisicao
     * @return
     * @throws NextException
     */
    public RespostaBase fazerRequisicao(DadosRequisicaoBase dadosRequisicao, MetodoRequisicao metodoRequisicao) throws NextException {
        return fazerRequisicao(metodoRequisicao, dadosRequisicao.caminho);

    }

    /**
     * Realiza a chamada HTTP, utilizando o método definido via enumerador, para uma API Restful
     *
     * @param metodoRequisicao Define o método de chamada
     * @param caminho          Caminho do endpoint para disparo da requisição
     */
    public RespostaBase fazerRequisicao(MetodoRequisicao metodoRequisicao, String caminho) throws NextException {
        Response response;
        try {
            switch (metodoRequisicao) {
                case GET:
                    Reporter.log("Realizando requisição GET para: " + caminho, false);
                    return new RespostaBase(request.get(caminho));
                case POST:
                    Reporter.log("Realizando requisição POST para: " + caminho, false);
                    return new RespostaBase(request.post( caminho ));
                case PUT:
                    Reporter.log("Realizando requisição PUT para: " + caminho, false);
                    return new RespostaBase(request.put(caminho));
                case DELETE:
                    Reporter.log("Realizando requisição DELETE para: " + caminho, false);
                    return new RespostaBase(request.delete(caminho));
                case HEAD:
                    Reporter.log("Realizando requisição HEAD para: " + caminho, false);
                    return new RespostaBase(request.head(caminho));
            }
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (Exception ex) {
            throw new NextException("Não foi possível finalizar requisição " + metodoRequisicao, ex);
        }
        return null;
    }
}
