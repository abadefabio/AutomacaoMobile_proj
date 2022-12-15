package br.com.next.automacao.core.tools.jira.modelo;

import java.util.HashSet;
import java.util.Set;


public class ExecucaoTesteJira {

    private String idCiclo;
    private String idFolder;
    private String idIssue;
    private String idExecucao;

    protected String getIdCiclo() {
        return idCiclo;
    }

    protected void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    protected String getIdFolder() {
        return idFolder;
    }

    protected void setIdFolder(String idFolder) {
        this.idFolder = idFolder;
    }

    protected String getIdIssue() {
        return idIssue;
    }

    protected void setIdIssue(String idIssue) {
        this.idIssue = idIssue;
    }

    protected String getIdExecucao() {
        return idExecucao;
    }

    protected void setIdExecucao(String idExecucao) {
        this.idExecucao = idExecucao;
    }
}