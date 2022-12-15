package br.com.next.automacao.core.tools.evidencia;

import java.util.List;

/**
 * Objeto de relatório de evidência
 *
 * @author Lucas Santos
 * @version 1.0
 * @since 2020-02
 */

public class RelatorioEvidencia {

    private List<NextEvidencia> evidenceList = null;
    private String casoTeste = null;
    private String tester = null;
    private String jornada = null;
    private String exceptionString = null;
    private String nomeCt = null;
    private String objetivoCt = null;
    private String plataformaCt = null;
    private String tempoExecucaoCt;
    private String nomeDispositivo;
    private String udidDispositivo;


    /**
     * Construtor do objeto de relatório de evidência
     *
     * @param evidenceList    Lista de evidências
     * @param casoTeste       Id do caso de teste
     * @param tester          Chave M do tester
     * @param jornada         Nome da jornada
     * @param exceptionString Mensagem de erro
     * @param nomeCt          Nome do caso de teste
     * @param objetivoCt      Descricao do caso de teste
     */
    public RelatorioEvidencia(List<NextEvidencia> evidenceList, String casoTeste, String tester, String jornada, String exceptionString, String nomeCt, String objetivoCt, String plataformaCt, String tempoExecucaoCt, String nomeDispositivo, String udidDispositivo) {
        this.evidenceList = evidenceList;
        this.casoTeste = casoTeste;
        this.tester = tester;
        this.jornada = jornada;
        this.exceptionString = exceptionString;
        this.nomeCt = nomeCt;
        this.objetivoCt = objetivoCt;
        this.plataformaCt = plataformaCt;
        this.tempoExecucaoCt = tempoExecucaoCt;
        this.nomeDispositivo = nomeDispositivo;
        this.udidDispositivo = udidDispositivo;
    }

    /**
     * @return evidenceList
     */
    public List<NextEvidencia> getEvidenceList() {
        return evidenceList;
    }

    /**
     * @param evidenceList setar evidenceList
     */
    public void setEvidenceList(List<NextEvidencia> evidenceList) {
        this.evidenceList = evidenceList;
    }

    /**
     * @return nome do relatório
     */
    public String getCasoTeste() {
        return casoTeste;
    }

    /**
     * @param casoTeste seta o nome do relatório
     */
    public void setCasoTeste(String casoTeste) {
        this.casoTeste = casoTeste;
    }

    /**
     * @return a chave do testador
     */
    public String getTester() {
        return tester;
    }

    /**
     * @param tester setar a chave do tester
     */
    public void setTester(String tester) {
        this.tester = tester;
    }

    /**
     * @return a jornada
     */
    public String getJornada() {
        return jornada;
    }

    /**
     * @param jornada setar a jornada
     */
    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    /**
     * @return exceção do teste
     */
    public String getExceptionString() {
        return exceptionString;
    }

    /**
     * @param exceptionString exceção do teste
     */
    public void setExceptionString(String exceptionString) {
        this.exceptionString = exceptionString;
    }

    /**
     * @return Nome do CT
     */
    public String getNomeCt() {
        return nomeCt;
    }

    /**
     * @param nomeCt Nome do CT
     */
    public void setNomeCt(String nomeCt) {
        this.nomeCt = nomeCt;
    }

    /**
     * @return Descrição do ojetivo do CT
     */
    public String getObjetivoCt() {
        return objetivoCt;
    }

    /**
     * @param objetivoCt Descrição do ojetivo do CT
     */
    public void setObjetivoCt(String objetivoCt) {
        this.objetivoCt = objetivoCt;
    }

    public String getPlataformaCt() {
        return plataformaCt;
    }

    public void setPlataformaCt(String plataformaCt) {
        this.plataformaCt = plataformaCt;
    }

    public String getTempoExecucaoCt() {
        return tempoExecucaoCt;
    }

    public void setTempoExecucaoCt(String tempoExecucao) {
        this.tempoExecucaoCt = tempoExecucao;
    }

    public String getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    public String getUdidDispositivo() {
        return udidDispositivo;
    }

    public void setUdidDispositivo(String udidDispositivo) {
        this.udidDispositivo = udidDispositivo;
    }
}
