package funcionalidade.api.cockpit.dados;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.constantes.MetodoRequisicao;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.ReadProperties;
import constantes.cockpit.AprovacaoFnexDados;
import constantes.cockpit.DadosAprovacaoJson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static br.com.next.automacao.core.base.TesteBase.*;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static constantes.cockpit.AprovacaoFnextEndpoint.*;

public class AprovacaoFNext {

    private String URI = "";
    private String esteira;
    private String caminhoRequisicao;
    private String token;
    private String proposalId_Fnext;
    private String prospectlId_Fnext;


    public void aprovarCpfFNext(String cpf, JSONObject massa) throws ParseException, NextException {
        if (ReadProperties.getAmbiente().toLowerCase().equals("ti")){
            setURI(URI_TI);
        }else if (ReadProperties.getAmbiente().toLowerCase().equals("tu")){
            setURI(URI_TU);
        }

        capturarTokenInternalFnext();
        validarNomeCompleto();
        capturarProposalIdFNext(cpf, massa);
        capturarProspectlIdFNext(massa);
        aprovarN1Gerente();
        logoutToken();
    }

    public String getEsteira() {
        return esteira;
    }

    public void setEsteira(String esteira) {
        this.esteira = esteira;
    }

    public String getCaminhoRequisicao() {
        return caminhoRequisicao;
    }

    public void setCaminhoRequisicao(String caminhoRequisicao) {
        this.caminhoRequisicao = caminhoRequisicao;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getProposalId_Fnext() {
        return proposalId_Fnext;
    }

    public void setProposalId_Fnext(String proposalId_Fnext) {
        this.proposalId_Fnext = proposalId_Fnext;
    }

    public String getProspectlId_Fnext() {
        return prospectlId_Fnext;
    }

    public void setProspectlId_Fnext(String prospectlId_Fnext) {
        this.prospectlId_Fnext = prospectlId_Fnext;
    }


    /** M?eodo para gerar o token do Fnext para o usuario padrao
     * @throws NextException
     */
    private void capturarTokenInternalFnext() throws NextException {

        setEsteira(esteira);
        setCaminhoRequisicao(getURI()+ CAPTURAR_TOKEN_INTERNAL_FNEXT);

        Header[] headers = new Header[]{
                new Header("Cache-Control", "no-cache"),
                new Header("Accept-Encoding", "gzip, deflate, br"),
                new Header("Connection", "keep-alive"),
                new Header("Accept", "*/*"),
                new Header("ContentType", "application/json")};

        JSONObject requisicao = new JSONObject();
        requisicao.put("agentId", AprovacaoFnexDados.USUARIO_FNEXT);
        requisicao.put("host", "unknown");
        requisicao.put("password", AprovacaoFnexDados.SENHA_FNEXT);

        DadosRequisicaoBase dadosRequisicaoBase =
                getDadosRequisicao()
                        .limparDadosRequisicao()
                        .definirHeaders(headers)
                        .definirCorpoRequisicao(requisicao)
                        .definirCaminhoRequisicao(caminhoRequisicao);
        RespostaBase resposta = new RespostaBase();
        try {
            resposta = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, MetodoRequisicao.POST).validarStatusCodeRequisicao(200, "Falha ao executar a requisicao para obter o token: " + resposta.getResponse().getBody());
           setToken(resposta.obterJsonPath().get("token"));
        }catch (Exception e){
            throw new RuntimeException("Não foi possível realizar requisicao:" + e.getMessage());
        }


        logarPasso("Token: " +getToken() );
    }

    /** Metodo que valida o nome completo
     * @throws NextException
     */
    public void validarNomeCompleto() throws NextException {

        setEsteira(ReadProperties.getEsteira());
        setCaminhoRequisicao(getURI() +VALIDAR_NOME_COMPLETO );

        Header[] headers = new Header[]{
                new Header("coreip", getEsteira()),
                new Header("ContentType", ContentType.TEXT.toString()),
                new Header("x-next-authtoken", getToken())};

        JSONObject requisicao = new JSONObject();
        requisicao.put("fullName", "FULANA DA SILVA");

        DadosRequisicaoBase dadosRequisicaoBase = getDadosRequisicao()
                .limparDadosRequisicao()
                .definirHeaders(headers)
                .definirCorpoRequisicao(requisicao)
                .definirCaminhoRequisicao(caminhoRequisicao);

        try {

            RequisicaoBase.executarRequisicao(dadosRequisicaoBase, MetodoRequisicao.POST)
                    .validarStatusCodeRequisicao(200, "Falha ao Validar Nome Completo!");
        }catch (Exception e){
            throw new RuntimeException("Erro ao validar o Nome completo!");
        }

        logarPasso("Validacao Nome finalizada!");
    }

    /** Captura o proposalId do Cpf para aprovacao
     * @param cpf
     * @throws NextException
     * @throws ParseException
     */
    public void capturarProposalIdFNext(String cpf,JSONObject json) throws NextException, ParseException {

        setCaminhoRequisicao(getURI()+ CAPTURAR_PROPOSAL_ID_FNEXT);

        Header[] headers = new Header[]{
                new Header("ContentType", ContentType.TEXT.toString()),
                new Header("x-next-authtoken", getToken()),
                new Header("coreIp", getEsteira())};

        JSONObject requisicao = new JSONObject();
        requisicao.put("numberCpf", cpf);
        requisicao.put("addressEmail", null);
        requisicao.put("proposalUid", null);
        requisicao.put("size", 10);
        requisicao.put("userId", 0);

        DadosRequisicaoBase dadosRequisicaoBase = getDadosRequisicao()
                .limparDadosRequisicao()
                .definirHeaders(headers)
                .definirCorpoRequisicao(requisicao)
                .definirCaminhoRequisicao(caminhoRequisicao);

        JSONArray jsonArray = new JSONArray();
        RespostaBase resposta = new RespostaBase();
        try {

            resposta = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, MetodoRequisicao.POST).validarStatusCodeRequisicao(200, "Falha ao executar a requisicao para Capturar ProposalID");
            jsonArray.add(resposta.obterJsonPath().get("object"));

        }catch (Exception e ){
            throw new RuntimeException("Não foi possível gerar o proposalId:"+ e.getMessage());
        }

        json.replace("proposalUid",((LinkedHashMap) ((ArrayList) jsonArray.get(0)).get(0)).get("proposalUid"));
        setProposalId_Fnext(json.get("proposalUid").toString());
        logarPasso("Proposal_Id: "+ getProposalId_Fnext());
    }

    /** Captura o prospectID do cpf a ser aprovado
     * @throws NextException
     */
    public void capturarProspectlIdFNext(JSONObject json) throws NextException {

        setCaminhoRequisicao(getURI()+ CAPTURAR_PROSPECT_ID_FNEXT);

        Header[] headers = new Header[]{
                new Header("ContentType", ContentType.JSON.toString()),
                new Header("x-next-authtoken", getToken()),
                new Header("coreip", getEsteira())};

        JSONObject requisicao = new JSONObject();
        JSONObject propesctProposal = new JSONObject();
        propesctProposal.put("customer",new JSONObject());
        propesctProposal.put("prospectProposalUid",getProposalId_Fnext());
        propesctProposal.put("proposalUid",getProposalId_Fnext());
        propesctProposal.put("sequenceProposalUid",1);

        requisicao.put("userId",0);
        requisicao.put("prospectProposal",propesctProposal);

        DadosRequisicaoBase dadosRequisicaoBase = getDadosRequisicao()
                .limparDadosRequisicao()
                .definirHeaders(headers)
                .definirCorpoRequisicao(requisicao)
                .definirCaminhoRequisicao(caminhoRequisicao);

        ArrayList  jsonArray = new ArrayList();
        RespostaBase resposta = new RespostaBase();
        try {
            resposta = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, MetodoRequisicao.POST).validarStatusCodeRequisicao(200, "Falha ao executar a requisicao para obter o prospectId: ");
        }catch (Exception e){
            throw new RuntimeException("Não foi possível gerar o prospectID:"+ e.getMessage());
        }

        json.replace("prospectProposalUid",resposta.obterJsonPath().get("proposalStageList[0].additionalData.prospectProposalUid"));
        setProspectlId_Fnext(json.get("prospectProposalUid").toString());
        logarPasso("Prospect_Id:" + prospectlId_Fnext);
    }


    /** Método para fazer a aprovação do gerente no Fnext
     * @throws NextException
     * @throws ParseException
     */
    public void aprovarN1Gerente() throws NextException, ParseException {

        setEsteira(esteira);
        setCaminhoRequisicao(getURI()+ N1_APROVAR_SEM_PENDENCIA);

        Header[] headers = new Header[]{
                new Header("coreip", getEsteira()),
                new Header("ContentType", ContentType.TEXT.toString()),
                new Header("x-next-authtoken", getToken())};

        JSONObject requisicao = new JSONObject();


        DadosAprovacaoJson dados = new DadosAprovacaoJson();
        String dadosJSONGerente = dados.getDados();
        JSONParser parser = new JSONParser();
        requisicao = (JSONObject) parser.parse(dadosJSONGerente);
        requisicao.put("proposalUid",getProposalId_Fnext());
        requisicao.put("prospectProposalUid",getProspectlId_Fnext());

        DadosRequisicaoBase dadosRequisicaoBase = getDadosRequisicao()
                .limparDadosRequisicao()
                .definirHeaders(headers)
                .definirCorpoRequisicao(requisicao)
                .definirCaminhoRequisicao(caminhoRequisicao);

        try {

            RequisicaoBase.executarRequisicao(dadosRequisicaoBase, MetodoRequisicao.POST)
                    .validarStatusCodeRequisicao(200, "Falha ao executar a requisi??o para obter o token")
                    .obterJsonPath();
        }catch (Exception e){
            throw new RuntimeException("Não foi possivel aprovar a massa.");
        }
        logarPasso("Aprovacao FNext Finalizada.");
    }

    /** Fazer logout no token utilizado na requisicao
     * @throws NextException
     * @throws ParseException
     */
    public void logoutToken() throws NextException, ParseException {

        if (ReadProperties.getAmbiente().toLowerCase().equals("ti")){
            setCaminhoRequisicao(URI_LOGOUT_TI);
        }else if (ReadProperties.getAmbiente().toLowerCase().equals("tu")){
            setCaminhoRequisicao(URI_LOGOUT_TU);

        }

        Header[] headers = new Header[]{
                new Header("ContentType", ContentType.TEXT.toString()),
                new Header("x-next-authtoken", getToken())};


        DadosRequisicaoBase dadosRequisicaoBase = getDadosRequisicao()
                .limparDadosRequisicao()
                .definirHeaders(headers)
                .definirCorpoRequisicao()
                .definirCaminhoRequisicao(caminhoRequisicao);

        try {

            RequisicaoBase.executarRequisicao(dadosRequisicaoBase, MetodoRequisicao.POST)
                    .validarStatusCodeRequisicao(200, "Falha ao executar a requisi??o para obter o token")
                    .obterJsonPath().get("proposalUid");
        }catch (Exception e){
            throw new RuntimeException("Não foi possivel fazer logout no Token");
        }

    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

}
