package br.com.next.automacao.core.base;


import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.annotations.TesteJiraAtual;
import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.constantes.driver.TipoExecucao;
import br.com.next.automacao.core.drivers.OperadorDriver;
import br.com.next.automacao.core.drivers.ResetApp;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.massa.portal.qualidade.GeracaoMassa;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.dispositivos.ConectorMobileCenter;
import br.com.next.automacao.core.tools.dispositivos.modelo.Dispositivo;
import br.com.next.automacao.core.tools.evidencia.NextEvidencia;
import io.appium.java_client.android.AndroidDriver;
import io.restassured.RestAssured;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.TestException;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

import static br.com.next.automacao.core.drivers.OperadorDriver.*;
import static br.com.next.automacao.core.tools.Utilitarios.pegarDataAtualEpoch;
import static io.restassured.RestAssured.DEFAULT_URI;
import static java.util.Objects.isNull;

/**
 * O teste base é a super classe das classes de teste, nela é realizado:
 * criação do objeto CasoTeste
 * setup Jira
 * chamada para criação de novo driver para teste ou reinicio do app;
 * carregamento da massa de dados para o caso de teste
 * chamada para encerrar driver
 *
 * @author Lucas Santos
 * @since 2019-10
 */

public class TesteBase extends TesteNext{

    private static ThreadLocal<DadosRequisicaoBase> corpoRequisicao;

    protected Dispositivo dispositivoRetornado;
    public static ThreadLocal<ArrayList<NextEvidencia>> evidencia = new ThreadLocal<>();

    private void setListaResultado() {
        listaResultado = new ThreadLocal<HashMap<String, ArrayList>>();
        listaResultado.set(new HashMap<String, ArrayList>());
    }

    /**
     * Retorna o objeto de caso de evidência(Thread safe)
     *
     * @return Evidencia
     */
    public static ArrayList<NextEvidencia> getEvidencia() {
        return evidencia.get();
    }

    /**
     * Seta o objeto de caso de evidência(Thread safe)
     */
    private void setEvidencia() {
        if (evidencia == null) {
            evidencia = new ThreadLocal<>();
        }
        evidencia.set(new ArrayList<>());
        Reporter.clear();
    }

    private static void setDadosRequisicao(String uri){
        if(corpoRequisicao == null){
            corpoRequisicao = new ThreadLocal<>();
        }
        corpoRequisicao.set(new DadosRequisicaoBase(uri));
    }

    public static DadosRequisicaoBase getDadosRequisicao(){
        if(corpoRequisicao == null){
            corpoRequisicao = new ThreadLocal<>();
        }
        return corpoRequisicao.get();
    }


    /**
     * Cria objeto do caso de teste
     */
    @BeforeClass
    @Parameters({"navegador","plataforma", "baseURI"})
    public synchronized void criarCasoTeste(@Optional("")String navegador, @Optional("")String plataforma, @Optional("")String baseUri) throws NextException {

        configurarTopoEvidenciaTeste(navegador, plataforma, baseUri);
        configurarNomeArquivoEvidencia(plataforma, navegador);
        configurarPlataformaEvidencia(plataforma, navegador);
        definirObjetivoTeste();
        if (jiraIntegracao) {
            synchronized (conectorJira) {
                try {
                    conectorJira.processarPastaJira(getCasoTeste().getJornadaCt());
                    Reporter.log("Pasta processada!", true);
                } catch (Throwable t) {
                    ignorarJiraIntegracao(t, "Falha ao processar pasta no Jira");
                }
            }
        }
    }

    private void configurarPlataformaEvidencia(String plataforma, String navegador){
        String plataformaCt = "";
        if (getCasoTeste().isTipoExecucao(TipoExecucao.API)) plataformaCt += "api";
        if (getCasoTeste().isTipoExecucao(TipoExecucao.MOBILE))
            plataformaCt += plataformaCt.isEmpty() ? "" : "/" + plataforma.toLowerCase();
        if (getCasoTeste().isTipoExecucao(TipoExecucao.WEB)) plataformaCt += plataformaCt.isEmpty() ? "" : "/" + navegador.toLowerCase();
        getCasoTeste().setPlataformaCt(plataformaCt);
    }

    private void configurarNomeArquivoEvidencia(String plataforma, String navegador){
        String nomeArquivoEvidencia = getCasoTeste().getCasoId();
        if (getCasoTeste().isTipoExecucao(TipoExecucao.API)) nomeArquivoEvidencia += "_api";
        if (getCasoTeste().isTipoExecucao(TipoExecucao.MOBILE)) nomeArquivoEvidencia += "_" + plataforma.toLowerCase();
        if (getCasoTeste().isTipoExecucao(TipoExecucao.WEB)) nomeArquivoEvidencia += "_" + navegador.toLowerCase();
        nomeArquivoEvidencia += "_" + pegarDataAtualEpoch();
        getCasoTeste().setNomeArquivoEvidencia(nomeArquivoEvidencia);
    }

    private void configurarTopoEvidenciaTeste(String navegador, String plataforma, String baseUri){
        setEvidencia();
        getCasoTeste().setCasoId(recuperarIDTeste());
        getCasoTeste().setJornadaCt(this.getClass().getAnnotation(Jornada.class).value().toString());
        getCasoTeste().setTester(ReadProperties.getFuncionalUser());

        if (!navegador.equals("")) getCasoTeste().registrarTipoExecucao(TipoExecucao.WEB);
        if (!plataforma.equals("")) getCasoTeste().registrarTipoExecucao(TipoExecucao.MOBILE);
        if (!baseUri.equals("")) getCasoTeste().registrarTipoExecucao(TipoExecucao.API);
    }

    private String recuperarIDTeste() {
        String id = "";
        try {
            id = this.getClass().getAnnotation(TesteJiraAtual.class).idTesteAtual();
            id = StringUtils.substringAfter(id, "QA-");
        } catch (Exception ex) {
        } finally {
            id = id.isEmpty() ? StringUtils.substringAfter(this.getClass().getName(), "QA") : id;
            return id;
        }
    }

    @BeforeMethod(dependsOnMethods = "setUp")
    @Parameters({"segundoNavegador", "navegador"})
    public void organizarNavegadoresExecucao(@Optional("")String segundoNavegador, @Optional("")String navegador){
        if(!navegador.equalsIgnoreCase("")){
            definirListaNavegadoresWeb();
            String[] navegadores = segundoNavegador.equalsIgnoreCase("") ? new String[]{navegador} : new String[]{navegador, segundoNavegador};
            adicionarNavegadores(navegadores);
        }
    }

    /**
     * Método que define o caminho base da requisição
     *
     * @param baseUri  URI base
     */
    @BeforeMethod
    @Parameters({"baseURI"})
    public void setUpApi(@Optional String baseUri) throws NextException {
        if (isNull(baseUri))
            return;
        setDadosRequisicao(baseUri);
        RestAssured.baseURI = baseUri;
    }

    /**
     * Método responsável pela inicialização do driver e limpeza do app
     *
     * @param navegador   chrome/ie/edge/firefox/safari
     * @param url          endereço da página a ser testada
     * @throws MalformedURLException
     */
    @BeforeMethod
    @Parameters({"navegador", "url", "criaMassa", "ignorarErroCriacaoMassa"})
    public void setUp(
            @Optional("")String navegador,
            @Optional("") String url,
            @Optional("") Boolean criaMassa,
            @Optional("") Boolean ignorarErroCriacaoMassa

    ) throws Exception {
        configurarTesteJira();
        carregaMassaDados();
        if (criaMassa) {

            var nomeClasseDeTeste = this.getClass().getSimpleName();
            var geracaoMassa = new GeracaoMassa();

            int parametroMassaOffline;
            try {
                parametroMassaOffline = Integer.parseInt(getCasoTeste().getParametrosTeste().getOrDefault("massaOffline", "0"));
            } catch (NumberFormatException nfe) {
                definirDadosDriverEvidencia();
                throw new TestException("Parâmetro de geração de massa offline incorreto.");
            }
            if (parametroMassaOffline > 0) {
                // Gerar massa e ignorar continuação do teste
                geracaoMassa.executaGeracaoMassaDeDadosOffline(nomeClasseDeTeste, parametroMassaOffline);
                definirDadosDriverEvidencia();
                throw new TestException("Execução finalizada por motivo de geração de massa automática offline.");
            } else {
                var massa = geracaoMassa.executaGeracaoMassaDeDados(
                        ignorarErroCriacaoMassa,
                        nomeClasseDeTeste,
                        false
                );

                if (massa != null) {
                    getLeitorMassaDados().setMassaDados(massa);
                }
            }
        }

        if (getCasoTeste().getParametrosTeste().getOrDefault("udid", "").equalsIgnoreCase("auto)")) {
            ConectorMobileCenter conectorMobileCenter = new ConectorMobileCenter();
            dispositivoRetornado = conectorMobileCenter.getDispositivo();
            getCasoTeste().setDispositivo(dispositivoRetornado.getDeviceName());
            getCasoTeste().setUdid(dispositivoRetornado.getUdid());
            iniciarMobileDriver();
            definirDadosDriverEvidencia();
            return;
        }

        if (getCasoTeste().isTipoExecucao(TipoExecucao.WEB)) {
            if (existeWebDriver()) {
                ResetApp.decidirExecutarResetBrowser();
            }
            if (!existeWebDriver()) {
                encerrarDriversNavegador();
                iniciarWebDriver(navegador, url);
            }
        }

        if (getCasoTeste().isTipoExecucao(TipoExecucao.MOBILE)) {
            if (existeMobileDriver()) {
                ResetApp.decidirExecutarResetApp();
            } else {
                iniciarMobileDriver();
            }
        }

        definirDadosDriverEvidencia();
    }

    private void definirDadosDriverEvidencia() {

        String versaoOs = "";
        String versaoOsWeb = "";

        if (getCasoTeste().isTipoExecucao(TipoExecucao.MOBILE)) {
            getCasoTeste().setUdid(getDriver().getCapabilities().getCapability("udid").toString());
            versaoOs = getDriver().getCapabilities().getCapability("platformVersion").toString();
            if (getDriver() instanceof AndroidDriver) {
                getCasoTeste().setDispositivo(getDriver().getCapabilities().getCapability("deviceManufacturer").toString() +
                        " " + getDriver().getCapabilities().getCapability("deviceModel").toString());
                versaoOs = "android " + versaoOs;
            } else {
                getCasoTeste().setDispositivo(getDriver().getCapabilities().getCapability("deviceName").toString());
                versaoOs = "ios " + versaoOs;
            }
        }

        if (getCasoTeste().isTipoExecucao(TipoExecucao.WEB)) {
            versaoOsWeb = ((RemoteWebDriver) getWebDriver()).getCapabilities().getBrowserName();
            versaoOsWeb += " " + ((RemoteWebDriver) getWebDriver()).getCapabilities().getVersion();
            versaoOs += "/" + versaoOsWeb;
        }

        if (getCasoTeste().isTipoExecucao(TipoExecucao.API)) {
            versaoOs += " +api";
        }

        getCasoTeste().setPlataformaCt(versaoOs);
    }

    /**
     * Método responsável pela desconstrução do driver após a execução
     */
    @AfterTest(alwaysRun = true)
    public void tearDown() {
        OperadorDriver.encerrarDriversExecucao();
        RestAssured.baseURI = DEFAULT_URI;
    }
}
