package br.com.next.automacao.core.tools.jira.modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * O objetivo dessa classe é organizar as execuções criadas no ciclo do Jira
 *
 * @author Matheus Lima Barbosa de Tulio
 * @version 3.5.2
 * @since 05-2021
 */
public class ControladorJira {

    private String idRelease;
    private Map<String, ExecucaoTesteJira> dicionarioExecucoes;
    protected static Map<String, Set<String>> folder;

    public ControladorJira() {
    }

    private static void setFolder() {
        if (folder == null) {
            folder = new HashMap<>();
        }
    }

    private static void setFolder(String nomeCiclo) {
        setFolder();
        if (!folder.containsKey(nomeCiclo)) {
            folder.put(nomeCiclo, new HashSet<>());
        }
    }

    public void setDicionarioExecucoes() {
        if (dicionarioExecucoes == null) {
            dicionarioExecucoes = new HashMap<>();
        }
    }

    public void setIdRelease(String idRelease) {
        this.idRelease = idRelease;
    }

    public String getIdRelease() {
        return this.idRelease;
    }

    public void setIdCiclo(String nomeCiclo, String idCiclo) {
        setDicionarioExecucoes();
        if (dicionarioExecucoes.containsKey(nomeCiclo)) {
            dicionarioExecucoes.get(nomeCiclo).setIdCiclo(idCiclo);
        } else {
            ExecucaoTesteJira execucaoTesteJira = new ExecucaoTesteJira();
            execucaoTesteJira.setIdCiclo(idCiclo);
            dicionarioExecucoes.put(nomeCiclo, execucaoTesteJira);
        }
    }

    public String getIdCiclo(String nomeCiclo) {
        setDicionarioExecucoes();
        return dicionarioExecucoes.get(nomeCiclo).getIdCiclo();
    }

    public void setIdFolder(String nomeCiclo, String idFolder) {
        setDicionarioExecucoes();
        if (dicionarioExecucoes.containsKey(nomeCiclo)) {
            dicionarioExecucoes.get(nomeCiclo).setIdFolder(idFolder);
        } else {
            ExecucaoTesteJira execucaoTesteJira = new ExecucaoTesteJira();
            execucaoTesteJira.setIdFolder(idFolder);
            dicionarioExecucoes.put(nomeCiclo, execucaoTesteJira);
        }
    }

    public String getIdFolder(String nomeCiclo) {
        ExecucaoTesteJira execucao = dicionarioExecucoes.get(nomeCiclo);
        return execucao.getIdFolder();
    }

    public void setIdIssue(String nomeCiclo, String idIssue) {
        setDicionarioExecucoes();
        if (dicionarioExecucoes.containsKey(nomeCiclo)) {
            dicionarioExecucoes.get(nomeCiclo).setIdIssue(idIssue);
        } else {
            ExecucaoTesteJira execucaoTesteJira = new ExecucaoTesteJira();
            execucaoTesteJira.setIdIssue(idIssue);
            dicionarioExecucoes.put(nomeCiclo, execucaoTesteJira);
        }
    }

    public String getIdIssue(String nomeCiclo) {
        return dicionarioExecucoes.get(nomeCiclo).getIdIssue();
    }

    public void setIdExecucao(String nomeCiclo, String idExecucao) {
        setDicionarioExecucoes();
        if (dicionarioExecucoes.containsKey(nomeCiclo)) {
            dicionarioExecucoes.get(nomeCiclo).setIdExecucao(idExecucao);
        } else {
            ExecucaoTesteJira execucaoTesteJira = new ExecucaoTesteJira();
            execucaoTesteJira.setIdExecucao(idExecucao);
            dicionarioExecucoes.put(nomeCiclo, execucaoTesteJira);
        }
    }

    public String getIdExecucao(String nomeCiclo) {
        return dicionarioExecucoes.get(nomeCiclo).getIdExecucao();
    }

    public static Set<String> retornarFolder(String nomeCiclo) {
        setFolder(nomeCiclo);
        return folder.get(nomeCiclo);
    }

    public void adicionarPasta(String nomeCiclo, final String pasta) {
        setFolder(nomeCiclo);
        folder.get(nomeCiclo).add(pasta);
    }

}
