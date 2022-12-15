package br.com.next.automacao.core.base.api;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe define objeto com os principais dados enviados em requisi��o HTTP de API-Restfull
 *
 * @author Matheus Lima Barbosa de Tulio
 * @since 05-2021
 * @version 3.6.2
 */
public class DadosRequisicaoBase {

    protected Map<String,Object> parametros;
    protected JSONObject corpoRequisicao;
    protected Headers headers;
    protected Cookies cookies;
    protected String nomeControleCorpoParte;
    protected File arquivo;
    protected String mimeType;
    protected String caminho;
    private String uri;

    public DadosRequisicaoBase(String uri, String path, Map paremetros, Headers headers, Cookies cookies, String nomeControleCorpoParte, File arquivo, String mimeType){
        this.uri = uri;
        this.caminho = uri + path;
        this.parametros = paremetros;
        this.headers = headers;
        this.cookies = cookies;
        this.nomeControleCorpoParte = nomeControleCorpoParte;
        this.arquivo = arquivo;
        this.mimeType = mimeType;
    }

    public DadosRequisicaoBase(String uri, String path){
        this.caminho = uri + path;
        this.uri = uri;
    }

    public DadosRequisicaoBase(String uri){
        this.uri = uri;
    }

    /**
     * M�todo utilizado para setar objeto par�metros como null
     * @return pr�pio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirParametros(){
        this.parametros = null;
        return this;
    }

    /**
     * M�todo utilizado para setar objeto par�metros da requisi��o a partir de um objeto Map<String, Object>
     * @param dicionario
     * @return pr�pio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirParametros(Map<String, Object> dicionario){
        this.parametros = dicionario;
        return this;
    }

    /**
     * M�todo utilizado para setar objeto par�metro da requisi��o a partir de pares nome, valor
     * @param primeiroNome
     * @param primeiroValor
     * @param paresNomeValor
     * @return pr�pio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirParametros(String primeiroNome, Object primeiroValor, Object... paresNomeValor){
        this.parametros = new HashMap<>();
        this.parametros.put(primeiroNome, primeiroValor);
        for(int i =0; i< paresNomeValor.length; i+= 2) parametros.put((String)paresNomeValor[i], paresNomeValor[i+1]);
        return this;
    }

    /**
     * M�todo utilizado para definir body da requisi��o como null
      * @return pr�pio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirCorpoRequisicao(){
        this.corpoRequisicao = null;
        return this;
    }

    /**
     * M�todo utilizado para definir body da requisi��o a partir de objeto JSONObject
     * @param corpoRequisicao
     * @return pr�prio objeto Dados Requisi��o
     */
    public DadosRequisicaoBase definirCorpoRequisicao(JSONObject corpoRequisicao){
        this.corpoRequisicao = corpoRequisicao;
        return this;
    }

    /**
     * M�todo define body da requisi��o a partir de par chave, valor
     * @param chave
     * @param valor
     * @return pr�prio objeto Dados Requisi��o
     */
    public DadosRequisicaoBase definirCorpoRequisicao(Object chave, Object valor){
        corpoRequisicao= new JSONObject();
        corpoRequisicao.put(chave,valor);
        return this;
    }

    /**
     * M�todo define body da requisi��o a partir dos pares chave, valor
     * @param primeiraChave
     * @param primeiroValor
     * @param paresChaveValor
     * @return pr�prio objeto Dados Requisi��o
     */
    public DadosRequisicaoBase definirCorpoRequisicao(Object primeiraChave, Object primeiroValor, Object... paresChaveValor){
        corpoRequisicao= new JSONObject();
        corpoRequisicao.put(primeiraChave,primeiroValor);
        for(int i =0; i< paresChaveValor.length; i+= 2) corpoRequisicao.put(paresChaveValor[i], paresChaveValor[i+1]);
        return this;
    }

    /**
     * M�todo seta headers da requisi��o como null
     * @return pr�prio objeto Dados Requisi��o
     */
    public DadosRequisicaoBase definirHeaders(){
        this.headers  = null;
        return this;
    }

    /**
     * M�todo define os headers da requisi��o a partir de objeto headers
     * @param headers
     * @return pr�prio objeto Dados Requisi��o
     */
    public DadosRequisicaoBase definirHeaders(Headers headers){
        this.headers  = headers;
        return this;
    }

    /**
     * M�todo define headers da requisi��o a partir de array de objetos Header
     * @param headers
     * @return pr�prio objeto Dados Requisi��o
     */
    public DadosRequisicaoBase definirHeaders(Header... headers){
        this.headers = new Headers(headers);
        return this;
    }

    /**
     * M�todo seta cookies como null
     * @return pr�prio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirCookies(){
        this.cookies = null;
        return this;
    }

    /**
     * M�todo define cookies a partir de objeto cookies
     * @param cookies
     * @return pr�prio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirCookies(Cookies cookies){
        this.cookies = cookies;
        return this;
    }

    /**
     * M�todo seta objetos nomeControleCorporParte, arquivo e mimeType como null
     * @return pr�prio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirDadosUploadArquivo(){
        this.nomeControleCorpoParte = null;
        this.arquivo = null;
        this.mimeType = null;
        return this;
    }

    /**
     * M�todo define objetos necess�rios para upload de arquivo
     * @param nomeControleCorpoParte
     * @param arquivo
     * @param mimeType
     * @return pr�prio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirDadosUploadArquivo(String nomeControleCorpoParte, File arquivo, String mimeType){
        this.nomeControleCorpoParte = nomeControleCorpoParte;
        this.arquivo = arquivo;
        this.mimeType = mimeType;
        return this;
    }

    /**
     * Definir a url para onde ser� enviada a requisi��o, informando a uri e o path
     * @param uri
     * @param path
     * @return pr�prio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirCaminhoRequisicao(String uri, String path){
        this.uri = uri;
        this.caminho = uri + path;
        return this;
    }

    /**
     * Define a url para onde a requisi��o ser� enviada, informando o caminho
     * @param path
     * @return pr�prio objeto DadosRequisicao
     */
    public DadosRequisicaoBase definirCaminhoRequisicao(String path){
        this.caminho = uri + path;
        return this;
    }

    /**
     * @return true se objeto cookis foi instanciado e false se ele n�o foi
     */
    public boolean temCookies(){
        return this.cookies == null ? false : true;
    }

    /**
     * @return true se objeto body foi instanciado e false se ele n�o foi
     */
    public boolean temCorpoRequisicao(){
        return this.corpoRequisicao == null ? false : true;
    }

    /**
     * @return true se objeto headers foi instanciado e false se ele n�o foi
     */
    public boolean temHeaders(){
        return this.headers == null ? false : true;
    }

    /**
     * @return true se o objeto arquivo foi instanciado e false se ele n�o foi
     */
    public boolean temArquivoParaUpload(){
        return this.arquivo == null ? false : true;
    }

    /**
     * @return true se o objeto parametros foi instanciado e false se ele n�o foi
     */
    public boolean temParametros(){
        return this.parametros == null ? false : true;
    }

    /**
     * Define todos os objetos da requisi��o como null
     * @return pr�prio objeto DadosRequisicao
     */
    public DadosRequisicaoBase limparDadosRequisicao(){
        this.parametros = null;
        this.headers = null;
        this.cookies = null;
        this.corpoRequisicao = null;
        this.nomeControleCorpoParte = null;
        this.arquivo = null;
        this.mimeType = null;
        return this;
    }
}
