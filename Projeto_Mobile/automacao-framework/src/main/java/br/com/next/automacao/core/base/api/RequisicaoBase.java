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
 * Classe respons�vel por encapsular itens pertinentes � requisi��o HTTP
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
     * M�todo retorna objeto RequestSpecification, que contem as especifica��es para o chamado API-Restful
     *
     * @return RequestSpecification
     */
    public RequestSpecification getRequest() {
        return request;
    }

    /**
     * Ao utilizar esse m�todo, voc� confiar� em todos os hosts mesmo quando o certificado estiver inv�lido
     */
    public RequisicaoBase usarRelaxedHTTPSValidation() {
        request.relaxedHTTPSValidation();
        return this;
    }

    /**
     * M�todo define cookies a serem inclu�dos no chamado a API-Restful
     *
     * @param cookies
     * @return
     */
    public RequisicaoBase definirCookies(Cookies cookies) {
        request.cookies(cookies);
        return this;
    }

    /**
     * Define o ContentType da requisi��o
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
     * Defnine o Header da requisi��o
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
     * Defnine o Header da requisi��o
     *
     * @param header enumerador Header
     */
    public RequisicaoBase definirHeader(Header header) {
        request.header(header);
        return this;
    }

    /**
     * Define o corpo da requisi��o
     *
     * @param jsonBody
     */
    public RequisicaoBase definirBody(JSONObject jsonBody) {
        request.body(jsonBody.toJSONString());
        return this;
    }

    /**
     * Define o corpo da requisi��o
     *
     * @param valor
     */
    public RequisicaoBase definirBody(String valor) {
        request.body(valor);
        return this;
    }

    /**
     * M�todo especifica arquivo para upload no servidor usando multi-part form data uploading
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
     * M�todo inclui lista de par�metros na requisi��o
     *
     * @param parametros
     * @return
     */
    public RequisicaoBase definirParametros(Map<String, ?> parametros) {
        request.params(parametros);
        return this;
    }

    /**
     * M�todo cria o objeto de requisi��o  de acordo com os dados inclu�dos no objeto dados requisi��o
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
     * M�todo executa chamado HTTP para API-Restful de acordo com os dados informados
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
     * M�todo executa chamado HTTP para API-Restful, validando o status code retornado
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
     * M�todo realiza chamado HTTP para API-Restful, utilizando a url armazenada em objeto DadosRequisicao
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
     * Realiza a chamada HTTP, utilizando o m�todo definido via enumerador, para uma API Restful
     *
     * @param metodoRequisicao Define o m�todo de chamada
     * @param caminho          Caminho do endpoint para disparo da requisi��o
     */
    public RespostaBase fazerRequisicao(MetodoRequisicao metodoRequisicao, String caminho) throws NextException {
        Response response;
        try {
            switch (metodoRequisicao) {
                case GET:
                    Reporter.log("Realizando requisi��o GET para: " + caminho, false);
                    return new RespostaBase(request.get(caminho));
                case POST:
                    Reporter.log("Realizando requisi��o POST para: " + caminho, false);
                    return new RespostaBase(request.post( caminho ));
                case PUT:
                    Reporter.log("Realizando requisi��o PUT para: " + caminho, false);
                    return new RespostaBase(request.put(caminho));
                case DELETE:
                    Reporter.log("Realizando requisi��o DELETE para: " + caminho, false);
                    return new RespostaBase(request.delete(caminho));
                case HEAD:
                    Reporter.log("Realizando requisi��o HEAD para: " + caminho, false);
                    return new RespostaBase(request.head(caminho));
            }
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (Exception ex) {
            throw new NextException("N�o foi poss�vel finalizar requisi��o " + metodoRequisicao, ex);
        }
        return null;
    }
}
