package br.com.next.automacao.core.caso;

import br.com.next.automacao.core.constantes.driver.TipoExecucao;

import java.util.*;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static br.com.next.automacao.core.tools.ReadProperties.getProperty;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static java.util.Objects.isNull;

/**
 * Bean para criação de objeto Caso de Teste
 *
 * @author Lucas Santos
 * @since 02-2020
 */
public class CasoTeste {

    /**
     * ID do caso de teste
     */
    private String casoId = null;

    /**
     * Nome da jornada
     */
    private String jornadaCt = null;

    /**
     * Nome do testador
     */
    private String tester = null;

    /**
     * Nome do caso de teste (Anotação @Test, parâmetro 'description')
     */
    private String nomeCasoTeste = null;

    /**
     * Objetivo do caso de teste (anotação @Description)
     */
    private String objetivoTeste = null;

    /**
     * Severidade do caso de teste (anotação @Severity)
     */
    private String severidadeCt = null;

    /**
     * Plataforma de execução do caso de teste
     */
    private String plataformaCt = null;

    /**
     * Nome gerado para o arquivo de evidência do teste
     */
    private String nomeArquivoEvidencia = null;

    /**
     * Lista de todos os arquivos de evidência do teste, com o caminho completo para cada arquivo
     */
    private List<String> listaArquivosEvidencia = null;

    /**
     * Nome do sispositivo empregado no teste
     */
    private String dispositivo = null;

    /**
     * UDID do dispositivo de teste
     */
    private String udid = null;

    /**
     * Versao do APP em teste
     */
    private String versaoApp = null;

    private String cicloTeste = null;

    public Map<String, String> parametrosTeste;

    /**
     * Lista contendo todos os tipos de execução aplicáveis do teste: mobile, web, api.
     */
    public static ThreadLocal<Set<TipoExecucao>> listaTipoExecucao = new ThreadLocal<Set<TipoExecucao>>() {
        @Override
        protected Set<TipoExecucao> initialValue() {
            return new HashSet<>();
        }
    };


    /**
     * @return ID do caso de teste
     */
    public String getCasoId() {
        return casoId;
    }

    /**
     * Seta ID do caso de teste
     *
     * @param casoId ID do caso de teste
     */
    public void setCasoId(String casoId) {
        this.casoId = casoId;
    }

    /**
     * @return Nome da jornada
     */
    public String getJornadaCt() {
        return jornadaCt;
    }

    /**
     * Seta o nome da jornada
     *
     * @param jornadaCt nome da jornada
     */
    public void setJornadaCt(String jornadaCt) {
        this.jornadaCt = jornadaCt;
    }

    /**
     * @return chave M do testador
     */
    public String getTester() {
        return tester;
    }

    /**
     * Setar a chave M do testador
     * @param tester chave M
     */
    public void setTester(String tester) {
        this.tester = tester;
    }

    /**
     * Pega o nome do caso de teste (Anotação @Test, parâmetro 'description')
     *
     * @return nome do caso de teste
     */
    public String getNomeCasoTeste() {
        return nomeCasoTeste;
    }

    /**
     * Seta o nome do caso de teste (Anotação @Test, parâmetro 'description')
     *
     * @param nomeCasoTeste nome do caso de teste
     */
    public void setNomeCasoTeste(String nomeCasoTeste) {
        this.nomeCasoTeste = nomeCasoTeste;
    }

    /**
     * Pega o objetivo do caso de teste (anotação @Description)
     * @return
     */
    public String getObjetivoTeste() {
        return objetivoTeste;
    }

    /**
     * Seta o objetivo do caso de teste (anotação @Description)
     * @param objetivoTeste
     */
    public void setObjetivoTeste(String objetivoTeste) {
        this.objetivoTeste = objetivoTeste;
    }

    /**
     * Pega a severidade do caso de teste (anotação @Severity)
     * @return
     */
    public String getSeveridadeCt() {
        return severidadeCt;
    }

    /**
     * Seta a severidade do caso de teste (anotação @Severity)
     * @param severidadeCt
     */
    public void setSeveridadeCt(String severidadeCt) {
        this.severidadeCt = severidadeCt;
    }

    /**
     * Retorna o nome do arquivo de evidência
     *
     * @return nome do arquivo de evidência
     */
    public String getNomeArquivoEvidencia() {
        return nomeArquivoEvidencia;
    }

    /**
     * Obtém a lista de arquivos com path e extensão para anexar ao Jira
     * A lista é limpada imediatamente após o retorno
     */
    public List<String> obterListaArquivosEvidenciaUsoUnico() {
        if (isNull(listaArquivosEvidencia))
            listaArquivosEvidencia = new ArrayList<>();
        List<String> listaRetornar = new ArrayList<>(listaArquivosEvidencia);
        listaArquivosEvidencia.clear();
        return listaRetornar;
    }

    /**
     * Retorna o caminho base para a salva de evidências
     *
     * @return caminho para a salva das evidências
     */
    public String getCaminhoEvidencia() {
        String caminhoEvidencia = System.getProperty("os.name").toLowerCase().contains("windows") ?
                        getProperty("path.base.windows") :
                        getProperty("path.base.mac");
        caminhoEvidencia += getProperty("path.evidencia");
        return caminhoEvidencia.toLowerCase(Locale.ROOT);
    }

    public String getCaminhoJornada() {
        return (getCaminhoEvidencia() + getJornadaCt() + "/").toLowerCase(Locale.ROOT);
    }

    public String getCaminhoEvidenciaCt() {
        return (getCaminhoJornada() + getCasoTeste().getCasoId() + "/").toLowerCase(Locale.ROOT);
    }

    /**
     * Define o nome do arquivo de evidência
     * @param nomeArquivoEvidencia nome do arquivo de evidência
     */
    public void setNomeArquivoEvidencia(String nomeArquivoEvidencia) {
        this.nomeArquivoEvidencia = nomeArquivoEvidencia;
    }

    /**
     * Adiciona um arquivo com path e extensão à lista de arquivos de evidência
     * para uso final do Jira ao anexar arquivo
     * @param nomeArquivoEvidenciaCompleto nome do arquivo de evidência
     */
    public void adicionarArquivoEvidencia(String nomeArquivoEvidenciaCompleto) {
        if (isNull(listaArquivosEvidencia))
            listaArquivosEvidencia = new ArrayList<>();
        listaArquivosEvidencia.add(nomeArquivoEvidenciaCompleto);
    }

    /**
     * Pega a plataforma de execução do CT
     * @return
     */
    public String getPlataformaCt() {
        return plataformaCt;
    }

    /**
     * Seta a plataforma de execução do CT
     * @param plataformaCt
     */
    public void setPlataformaCt(String plataformaCt) {
        this.plataformaCt = plataformaCt;
    }

    /**
     * Pega o nome do dispositivo empregado no teste
     * @return
     */
    public String getDispositivo() {
        return dispositivo;
    }

    /**
     * Seta o nome do dispositivo empregado no teste
     * @param dispositivo
     */
    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    /**
     * Pega o UDID do dispositivo empregado no teste
     * @return
     */
    public String getUdid() {
        return udid;
    }

    /**
     * Seta o UDID do dispositivo empregado no teste
     * @param udid
     */
    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getVersaoApp() {
        return versaoApp;
    }

    public void setVersaoApp(String versaoApp) {
        this.versaoApp = versaoApp;
    }

    public String getCicloTeste() {
        return cicloTeste;
    }

    public void setCicloTeste(String cicloTeste) {
        this.cicloTeste = cicloTeste;
    }

    public Map<String, String> getParametrosTeste() {
        return this.parametrosTeste;
    }

    public void setParametrosTeste(Map<String, String> parametrosTeste) {
        this.parametrosTeste = parametrosTeste;
    }

    public void registrarTipoExecucao(TipoExecucao tipoExecucao) {
        try {
            listaTipoExecucao.get().add(tipoExecucao);
        } catch (Exception aviso) {
            logarPasso("Aviso: Houve um erro ao adicionar o tipo de execução: " + tipoExecucao.toString());
        }
    }

    public boolean isTipoExecucao(TipoExecucao tipoExecucao) {
        return listaTipoExecucao.get().contains(tipoExecucao);
    }

}
