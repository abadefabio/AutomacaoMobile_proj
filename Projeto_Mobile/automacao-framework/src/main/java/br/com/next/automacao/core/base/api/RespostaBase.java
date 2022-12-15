package br.com.next.automacao.core.base.api;

import br.com.next.automacao.core.constantes.UnidadeTemporal;
import br.com.next.automacao.core.error.NextError;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertNotNull;

/**
 * Classe responsável por encapsular as resposta de um chamado HTTP a API-Restfull
 * @author Matheus Lima Barbosa de Tulio
 * @since 05-2021
 * @version 3.6.2
 */
public class RespostaBase {

    protected Response response;
    protected ArrayList listaJson;

    RespostaBase(Response resposta){
        this.response = resposta;
        Reporter.log("A requisição retornou statusCode: " + response.getStatusCode());
    }

    public RespostaBase(){

    }

    /**
     * @return Response resposta chamada API
     */
    public Response getResponse(){
        return response;
    }

    /**
     * Método valida status code da requisi��o
     * @param statusCode
     */
    public RespostaBase validarStatusCodeRequisicao(int statusCode, String mensagemErro){
        try{
            response.then().statusCode(statusCode);
        }catch (AssertionError error){
            throw new NextError(mensagemErro, error);
        }
        return this;
    }

    /**
     * Validar path JSON e valor respectivo no corpo da resposta
     * @param path
     * @param matcher
     * @return
     */
    public RespostaBase validar(String path, Matcher<?> matcher) {

        logarPasso("Validar '" + path + "' | " + matcher.toString() + " |");
        String pathRetornado = getResponse().jsonPath().getString(path);
        assertNotNull(pathRetornado);
        assertThat(
                getResponse().jsonPath().getJsonObject(path),
                matcher
        );
        return this;
    }

    /**
     * Validar múlltiplos paths JSON e valores respectivos no corpo da resposta
     * @param paresPathMatcher
     * @return
     */
    public RespostaBase validar(Map<String,Matcher<?>> paresPathMatcher) {

        for (String path : paresPathMatcher.keySet()) {
            validar(path, paresPathMatcher.get(path));
        }
        return this;
    }

    /**
     * @return Cookies da Requisição
     */
    public Cookies obterCookiesRequisicao(){
        return response.getDetailedCookies();
    }

    /**
     * Recupera o JsonPath do retorno da requisição
     */
    public JsonPath obterJsonPath() {
        return response.jsonPath();
    }

    /**
     * Retorna o valor de determinada chave contida no corpo do JSON de resposta
     *
     * @param chave chave do Objeto
     * @return valor da chave
     */
    public String obterValorJson(String chave) {
        String valor = obterJsonPath().getString( chave );
        Reporter.log( "Valor retornado: " + valor, false );
        return valor;
    }

    /**
     * Retorna o valor de determinado par chave-pai, chave-filha contidas no corpo do JSON de resposta
     * @param chavePai
     * @param chaveFilha
     * @return
     */
    public String obterValorJson(String chavePai, String chaveFilha) {
        String valor = obterJsonPath().getString( chavePai + "." + chaveFilha );
        Reporter.log( "Valor retornado: " + valor, false );
        return valor;
    }

    /**
     * Retorna o valor de determinado par chave-pai, chave-filha, identificado por �ndice, contidas no corpo do JSON de resposta
     * @param chavePai
     * @param chaveFilha
     * @param indice
     * @return
     */
    public String obterValorJson(String chavePai, String chaveFilha, String indice) {
        String valor = obterJsonPath().getString( chavePai + "." + chaveFilha + "[" + indice + "]" );
        Reporter.log( "Valor retornado: " + valor, false );
        return valor;
    }

    /**
     * Retorna um objeto lista do corpo do JSON de resposta
     *
     * @param chave
     * @return
     */
    public ArrayList obterLista(String chave) {
        listaJson = null;
        listaJson = obterJsonPath().get( chave );
        Reporter.log( "Lista retornada: " + listaJson, false );
        return listaJson;
    }

    /**
     * Retorna um objeto lista do corpo do JSON de resposta
     * @param chavePai
     * @param chaveFilha
     * @return
     */
    public ArrayList obterLista(String chavePai, String chaveFilha) {
        listaJson = null;
        listaJson = obterJsonPath().get( chavePai + "." + chaveFilha );
        Reporter.log( "Lista retornada: " + listaJson, false );
        return listaJson;
    }

    /**
     * Método valida status code da requisi��o
     * @param statusCode
     */
    public RespostaBase validarStatusCodeRequisicao(int statusCode){
        int statusCodeRetornado = response.getStatusCode();
        try{
            response.then().statusCode(statusCode);
            Reporter.log("Validado o status code da requisição com sucesso! Esperado: " + statusCode + " | Retornado: " + statusCodeRetornado, false);
        }catch (AssertionError error){
            throw new NextError("Codigo de resposta incorreto! Esperado: " + statusCode + " | Retornado: " + statusCodeRetornado, error);
        }
        return this;
    }

    /**
     * Valida o schema do JSON de resposta contra um Schema armazenado local
     *
     * @param caminhoArquivo caminho para o schema de comparação
     */
    public RespostaBase validarJsonSchema(String caminhoArquivo) {
        response
                .then()
                .assertThat()
                .body( matchesJsonSchemaInClasspath( caminhoArquivo ) );
        return this;
    }

    /**
     * Valida lista é retornada em corpo de resposta de API
     * @param chave
     * @param listaValores
     * @return
     */
    public RespostaBase validarValoresLista(String chave, String[] listaValores) {
        try {
            response.then().assertThat().body( chave, hasItems( listaValores ) );
            Reporter.log( "Valores da lista coincidem" );
        } catch (AssertionError error) {
            Reporter.log( "Valores da lista retornada diferem do esperado!", false );
            String mensagem = error.getMessage();
            Reporter.log( "LOG DO ERRO: \n" + mensagem );
            Assert.fail( mensagem );
        }
        return this;
    }

    /**
     * Valida o tamanho de uma lista de objetos do JSON de resposta
     *
     * @param tamanhoEsperado
     */
    public RespostaBase validarTamanhoLista(int tamanhoEsperado) {
        int tamanhoRetornado = listaJson.size();
        try {
            Assert.assertEquals( tamanhoEsperado, tamanhoRetornado );
        } catch (AssertionError error) {
            Reporter.log( "Lista no tamanho incorreto! Esperado: " + tamanhoEsperado + " | Retornado: " + tamanhoRetornado );
            Assert.fail( error.getMessage() );
        }
        return this;
    }

    /**
     * Mede o tempo de resposta da requisição
     *
     * @param unidadeTemporal Milis ou Segundos
     * @return o tempo de resposta
     */
    public long mensurarTempoResposta(UnidadeTemporal unidadeTemporal) {
        long tempo = 0;
        switch (unidadeTemporal) {
            case MILIS:
                tempo = response.time();
                break;

            case SEGUNDOS:
                tempo = response.timeIn( TimeUnit.SECONDS );
                break;
        }
        Reporter.log( "Tempo de resposta: " + tempo, false );
        return tempo;
    }
}
