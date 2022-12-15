package br.com.next.automacao.core.tools.jira.conector;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.constantes.MetodoRequisicao;
import br.com.next.automacao.core.constantes.jira.ExecucaoStatus;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.jira.modelo.ControladorJira;
import com.google.gson.JsonArray;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static br.com.next.automacao.core.base.TesteBase.getCasoTeste;
import static br.com.next.automacao.core.base.TesteBase.nomeSuite;
import static br.com.next.automacao.core.base.api.RequisicaoBase.executarRequisicao;
import static br.com.next.automacao.core.base.api.RequisicaoBase.montarRequisicao;
import static br.com.next.automacao.core.tools.Utilitarios.dataAtual;
import static br.com.next.automacao.core.tools.Utilitarios.pegarDataAtualEpoch;
import static br.com.next.automacao.core.tools.jira.conector.LoginJira.uriBaseJira;

/**
 * Classe de integração da execução de testes com a ferramenta Jira
 * Criação de versão
 * Criação de ciclo
 * Adição de caso de teste ao ciclo
 * Controle de status da execução
 * Upload de evidência
 *
 * @author Lucas Santos
 * @version 1.0
 * @since 2020-02
 */

public class ConectorJira {

    private static final ControladorJira jiraUnico = new ControladorJira();
    public static ThreadLocal<ControladorJira> jira;
    private static Cookies loginJira;
    private static Set<String> ciclos = new HashSet<String>();
    private static ThreadLocal<DadosRequisicaoBase> dadosRequisicao;

    public ConectorJira() throws NextException {
        loginJira = LoginJira.login();
    }

    private static ControladorJira getJira() {
        return jira.get();
    }

    private static void setJira() {
        if (jira == null) {
            jira = new ThreadLocal<>();
        }
        jira.set(new ControladorJira());
    }

    private static void setDadosRequisicao() {
        if (dadosRequisicao == null) {
            dadosRequisicao = new ThreadLocal<>();
        }
        dadosRequisicao.set(new DadosRequisicaoBase(uriBaseJira).definirCookies(loginJira));
    }

    private static DadosRequisicaoBase getDadosRequisicao() {
        return dadosRequisicao.get();
    }

    /**
     * Método armazena o valor do id da versão retornado pelo Jira
     *
     * @param idVersao
     */
    private void setIdRelease(String idVersao) {
        jiraUnico.setIdRelease(idVersao);
    }

    /**
     * @return id release no Jira
     */
    private String getIdRelease() {
        return jiraUnico.getIdRelease();
    }

    /**
     * Cria a release no Jira
     */
    public void criarVersaoRelease(String release) throws NextException {
        String idVersao = release;
        setDadosRequisicao();
        if (idVersao.equalsIgnoreCase("")) {
            Date data = new Date(Long.parseLong(pegarDataAtualEpoch()));
            JSONObject requestBody = new JSONObject();
            requestBody.put("description", "Execução automatizada: " + nomeSuite + " | Data: " + data);
            requestBody.put("name", nomeSuite + "_" + pegarDataAtualEpoch());
            requestBody.put("archived", false);
            requestBody.put("released", false);
            requestBody.put("releaseDate", dataAtual());
            requestBody.put("project", "QA");
            requestBody.put("projectId", 13302);

            getDadosRequisicao().definirCaminhoRequisicao("/rest/api/latest/version").definirCorpoRequisicao(requestBody);

            idVersao = executarRequisicao(getDadosRequisicao(), MetodoRequisicao.POST)
                    .validarStatusCodeRequisicao(201, "Não foi possível criar a RELEASE de teste no JIRA!")
                    .obterValorJson("id");
        }
        setIdRelease(idVersao);
    }

    /**
     * Verifica se o ciclo de teste já foi criado no jira
     *
     * @param ciclo
     * @return
     */
    public boolean verificarExistenciaCiclo(final String ciclo) throws NextException {
        synchronized (ciclos) {
            return ciclos.contains(ciclo) || verificaExistenciaCicloJira(ciclo);
        }
    }

    /**
     * Chamada para criar ciclo de teste no Jira, caso o mesmo ainda não exista
     *
     * @param ciclo
     */
    public void processarCicloJira(final String ciclo) throws NextException {
        synchronized (ciclos) {
            if (!ciclos.contains(ciclo)) {
                criarCicloJira(ciclo);
                ciclos.add(ciclo);
            }
        }
    }

    /**
     * Verifica se já existe a pasta da jornada no Jira
     *
     * @param folder
     * @return
     */
    public boolean verificarExistenciaPasta(final String folder) {
        final String ciclo = getCasoTeste().getCicloTeste();
        synchronized (jiraUnico.retornarFolder(ciclo)) {
            return jiraUnico.retornarFolder(ciclo).contains(folder);
        }
    }

    /**
     * Realiza a chamada para a criação da pasta no Jira
     *
     * @param pasta
     */
    public void processarPastaJira(final String pasta) throws NextException {
        final String ciclo = getCasoTeste().getCicloTeste();
        synchronized (jiraUnico.retornarFolder(ciclo)) {
            if (!jiraUnico.retornarFolder(ciclo).contains(pasta) && !capturarPastaExistente(pasta)) {
                criarPasta(ciclo, pasta);
                jiraUnico.adicionarPasta(ciclo, pasta);
            } else {
                capturarPastaExistente(pasta);
            }
        }
    }

    /**
     * Cria um ciclo para execução dentro da release
     *
     * @param ciclo
     */
    private void criarCicloJira(String ciclo) throws NextException {
        JSONObject requestBody = new JSONObject();

        requestBody.put("clonedCycleId", "");
        requestBody.put("name", ciclo);
        requestBody.put("build", "");
        requestBody.put("environment", "");
        requestBody.put("description", "");
        requestBody.put("projectId", 13302);
        requestBody.put("versionId", getIdRelease());

        getDadosRequisicao().definirCaminhoRequisicao("/rest/zapi/latest/cycle").definirCorpoRequisicao(requestBody);

        String idCiclo = executarRequisicao(getDadosRequisicao(), MetodoRequisicao.POST)
                .validarStatusCodeRequisicao(200, "Não foi possível criar o CICLO de teste no JIRA!")
                .obterValorJson("id");

        jiraUnico.setIdCiclo(ciclo, idCiclo);
    }

    /**
     * Cria a pasta dentro do ciclo com o nome da jornada da execução,
     * caso a pasta já não exista
     */
    public void criarPasta(String ciclo, String pasta) throws NextException {
        setJira();
        JSONObject requestBody = new JSONObject();
        requestBody.put("cycleId", jiraUnico.getIdCiclo(ciclo));
        requestBody.put("name", pasta);
        requestBody.put("description", "");
        requestBody.put("projectId", "13302");
        requestBody.put("versionId", getIdRelease());

        getDadosRequisicao().definirCorpoRequisicao(requestBody).definirCaminhoRequisicao("/rest/zapi/latest/folder/create");

        String idPasta = executarRequisicao(getDadosRequisicao(), MetodoRequisicao.POST)
                .validarStatusCodeRequisicao(200, "Não foi possível criar a PASTA de teste no JIRA!")
                .obterValorJson("id");
        getJira().setIdFolder(getCasoTeste().getCicloTeste(), idPasta);
    }

    /**
     * Adiciona o card de teste no ciclo
     */
    public void adicionarTeste() throws NextException {
        final String ciclo = getCasoTeste().getCicloTeste();
        JsonArray ct = new JsonArray();
        ct.add("QA-" + new Integer(getCasoTeste().getCasoId()).toString());

        JSONObject requestBody = new JSONObject();
        requestBody.put("issues", ct);
        requestBody.put("cycleId", jiraUnico.getIdCiclo(ciclo));
        requestBody.put("method", "1");
        requestBody.put("projectId", "13302");
        requestBody.put("versionId", getIdRelease());
        requestBody.put("folderId", getJira().getIdFolder(ciclo));

        getDadosRequisicao().definirCaminhoRequisicao("/rest/zapi/latest/execution/addTestsToCycle/").definirCorpoRequisicao(requestBody);

        executarRequisicao(getDadosRequisicao(), MetodoRequisicao.POST).validarStatusCodeRequisicao(200, "Não foi possível inserir o TESTE no ciclo!");
    }

    /**
     * Cria uma execução para determinado card de teste
     */
    public void criarExecucao() throws NextException {
        obterIssueId();
        final String ciclo = getCasoTeste().getCicloTeste();
        JSONObject requestBody = new JSONObject();
        requestBody.put("cycleId", jiraUnico.getIdCiclo(ciclo));
        requestBody.put("issueId", getJira().getIdIssue(ciclo));
        requestBody.put("projectId", "13302");
        requestBody.put("versionId", getIdRelease());
        requestBody.put("assigneeType", "assignee");
        requestBody.put("assignee", ReadProperties.getJiraUser());
        requestBody.put("folderId", getJira().getIdFolder(ciclo));

        getDadosRequisicao().definirCorpoRequisicao(requestBody).definirCaminhoRequisicao("/rest/zapi/latest/execution");

        String idExecucao = executarRequisicao(getDadosRequisicao(), MetodoRequisicao.POST)
                .validarStatusCodeRequisicao(200, "Não foi possível criar a EXECUÇÃO do CT! VERIFIQUE SE O CARD EXISTE NO JIRA.")
                .obterJsonPath()
                .getMap("")
                .keySet()
                .toString()
                .replace("[", "")
                .replace("]", "");

        getJira().setIdExecucao(ciclo, idExecucao);
    }

    /**
     * Altera o status da execução de determinado teste
     *
     * @param status Enum com o valor do novo status
     */
    public void alterarStatusExecucao(ExecucaoStatus status) throws NextException {
        JSONObject requestBody = new JSONObject();
        requestBody.put("status", status.getValue());

        getDadosRequisicao()
                .definirCaminhoRequisicao("/rest/zapi/latest/execution/" + getJira().getIdExecucao(getCasoTeste().getCicloTeste()) + "/execute")
                .definirCorpoRequisicao(requestBody);

        executarRequisicao(getDadosRequisicao(), MetodoRequisicao.PUT).validarStatusCodeRequisicao(200, "Não foi possível alterar o STATUS da execução no JIRA!");
    }

    /**
     * Pega o ID de uma issue a partir da issueKey
     */
    private void obterIssueId() throws NextException {
        String idCaso = "QA-" + new Integer(getCasoTeste().getCasoId()).toString();

        getDadosRequisicao().definirCorpoRequisicao().definirCaminhoRequisicao("/rest/api/latest/issue/" + idCaso);

        String idIssue = executarRequisicao(getDadosRequisicao(), MetodoRequisicao.GET)
                .validarStatusCodeRequisicao(200, "Não foi possível recuperar o ID da issue no JIRA!")
                .obterValorJson("id");
        getJira().setIdIssue(getCasoTeste().getCicloTeste(), idIssue);
    }

    /**
     * Verifica se a pasta de teste já existe dentro do ciclo
     *
     * @return true: pasta já existente | false: pasta não existente
     */
    public Boolean capturarPastaExistente(final String folder) throws NextException {
        setJira();
        setDadosRequisicao();
        final String ciclo = getCasoTeste().getCicloTeste();

        getDadosRequisicao()
                .definirCorpoRequisicao()
                .definirCaminhoRequisicao("/rest/zapi/latest/cycle/" + jiraUnico.getIdCiclo(ciclo) + "/folders")
                .definirParametros("projectId", "13302", "versionId", getIdRelease());

        final RespostaBase resposta = executarRequisicao(getDadosRequisicao(), MetodoRequisicao.GET)
                .validarStatusCodeRequisicao(200, "Não foi possível recuperar as PASTAS do ciclo no JIRA!");

        getDadosRequisicao().definirParametros();

        ArrayList listaJson = resposta.obterLista("folderName");
        for (int i = 0; i < listaJson.size(); i++) {
            String folderId = resposta.obterValorJson("folderId[" + i + "]");
            if (((String) listaJson.get(i)).equalsIgnoreCase(folder.toLowerCase())) {
                getJira().setIdFolder(ciclo, folderId);
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se o ciclo já existe
     *
     * @param ciclo ciclo do teste que o ciclo será criado
     * @return true: ciclo já existente | false: ciclo não existente
     */
    private String capturarIdCiclo(String ciclo) throws NextException {
        setJira();

        getDadosRequisicao()
                .definirCorpoRequisicao()
                .definirParametros("projectId", "13302", "versionId", getIdRelease())
                .definirCaminhoRequisicao("/rest/zapi/latest/cycle/");

        final RespostaBase resposta = executarRequisicao(getDadosRequisicao(), MetodoRequisicao.GET)
                .validarStatusCodeRequisicao(200, "Não foi possível recuperar as PASTAS do ciclo no JIRA!");

        getDadosRequisicao().definirParametros();

        for (int i = 0; i < resposta.obterJsonPath().getMap("").size() - 1; i++) {
            String chave = resposta.obterJsonPath().getMap("").keySet().toArray()[i].toString();
            if (resposta.obterValorJson(chave + ".name").equals("[" + ciclo + "]")) {
                return chave;
            }
        }
        return null;
    }

    private Boolean verificaExistenciaCicloJira(String ciclo) throws NextException {
        setJira();
        setDadosRequisicao();

        getDadosRequisicao()
                .definirParametros("projectId", "13302", "versionId", getIdRelease())
                .definirCaminhoRequisicao("/rest/zapi/latest/cycle/");

        RespostaBase resposta = executarRequisicao(getDadosRequisicao(), MetodoRequisicao.GET)
                .validarStatusCodeRequisicao(200, "Não foi possível recuperar a lista de ciclos no JIRA!");

        getDadosRequisicao().definirParametros();

        for (int i = 0; i < resposta.obterJsonPath().getMap("").size() - 1; i++) {
            String chave = resposta.obterJsonPath().getMap("").keySet().toArray()[i].toString();
            if (resposta.obterValorJson(chave + ".name").equals(ciclo)) {
                jiraUnico.setIdCiclo(getCasoTeste().getCicloTeste(), chave);
                return true;
            }
        }
        return false;
    }

    /**
     * Anexa todas as evidências de teste geradas:
     * Web/Mobile (PDF) e API (txt)
     */
    public void anexarArquivosEvidenciaGerados() throws NextException {

        for (String nomeArquivoCompleto : getCasoTeste().obterListaArquivosEvidenciaUsoUnico()) {
            getDadosRequisicao()
                    .definirCorpoRequisicao()
                    .definirDadosUploadArquivo("file", new File(nomeArquivoCompleto), "application/octet-stream")
                    .definirCaminhoRequisicao("/rest/zapi/latest/attachment?entityId=" + getJira().getIdExecucao(getCasoTeste().getCicloTeste()) + "&entityType=execution");
            RequisicaoBase requisicaoBase = montarRequisicao(getDadosRequisicao());
            requisicaoBase
                    .definirHeader("X-Atlassian-Token", "nocheck", "Content-Type", ContentType.JSON);
            requisicaoBase
                    .fazerRequisicao(getDadosRequisicao(), MetodoRequisicao.POST)
                    .validarStatusCodeRequisicao(200, "Não foi possível fazer o UPLOAD da evidência de teste no Jira!\n" + nomeArquivoCompleto);

            getDadosRequisicao().definirDadosUploadArquivo();
        }

    }

    /**
     * Remove todas as evidências das execuções do teste
     */
    public void removerArquivosEvidenciaTeste() throws NextException {
        getDadosRequisicao()
                .definirCorpoRequisicao()
                .definirCaminhoRequisicao( "/rest/zapi/latest/attachment/attachmentsByEntity?entityId=" + getJira().getIdExecucao(getCasoTeste().getCicloTeste()) + "&entityType=execution");

        RespostaBase resposta = montarRequisicao(getDadosRequisicao())
                .definirHeader("X-Atlassian-Token", "nocheck", "Content-Type", ContentType.JSON)
                .fazerRequisicao(getDadosRequisicao(), MetodoRequisicao.GET)
                .validarStatusCodeRequisicao(200, "Não foi possível recuperar evidências de teste no Jira!");

        for (String attachmentId : resposta.obterJsonPath().getList("data.fileId", String.class)) {
            getDadosRequisicao()
                    .definirCorpoRequisicao()
                    .definirCaminhoRequisicao( "/rest/zapi/latest/attachment/" + attachmentId);

            montarRequisicao(getDadosRequisicao())
                    .definirHeader("X-Atlassian-Token", "nocheck", "Content-Type", ContentType.JSON)
                    .fazerRequisicao(getDadosRequisicao(), MetodoRequisicao.DELETE)
                    .validarStatusCodeRequisicao(200, "Não foi possível remover a evidência de teste no Jira! Id evidência: " + attachmentId);
        }
    }
}
