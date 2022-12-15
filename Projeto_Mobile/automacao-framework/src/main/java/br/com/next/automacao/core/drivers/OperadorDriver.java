package br.com.next.automacao.core.drivers;

import br.com.next.automacao.core.constantes.driver.TipoExecucao;
import br.com.next.automacao.core.constantes.driver.mobile.TipoMobileDriver;
import br.com.next.automacao.core.drivers.mobile.managers.NextMobileDriver;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.exception.SecaoNextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import javax.naming.ldap.Control;
import java.io.File;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static br.com.next.automacao.core.drivers.ControladoraDriver.*;

import static br.com.next.automacao.core.drivers.mobile.fabrica.NextFabricaMobileDriver.retornaDriverMobile;
import static br.com.next.automacao.core.drivers.web.fabrica.NextFabricaWebDriver.retornaDriverWeb;
import static java.util.Objects.isNull;

/**
 * Classe criada para coordenar as ações realizadas pelos drivers durante a execução do teste
 * Essa classe utiliza uma instância Thread-safe da classe ControladoraDriver, permitindo
 * a execução de testes em série, paralelo, além de testes em que haja necessidade de utilização
 * WebDriver e AppiumDriver na mesma execução do teste
 *
 * @author Matheus Lima Barbosa de Tulio
 * @version 3.5.2
 * @since 2021-05
 */
public class OperadorDriver {

    private static ControladoraDriver controladora;
    private static ThreadLocal<String> plataformaMobile;
    private static ThreadLocal<List<String>> listaNavegadoresWeb;
    private static ThreadLocal<String> navegadorAtual;
    private static ThreadLocal<File> pastaDownloadBrowserCustomizada;
    private static ThreadLocal<File> pastaDownloadBrowserPadrao;

    /**
     * Método utilizado para iniciar internamente a variável Thread-safe controladora
     */
     private static void definirControladora(){
        if(controladora == null){
            controladora = new ControladoraDriver();
        }
    }

    /*
    Consulta a controladora para saber se o device é um emulador
     */
    public static boolean isDeviceEmulador() {
         return ControladoraDriver.isDeviceEmulador();
    }

    /**
     * Método utilizado para iniciar internamente a variável Thread-safe plataformaMobile
     */
    private static void definirTipoPlataformaMobile(TipoMobileDriver plataforma){
        if(plataformaMobile == null) {
            plataformaMobile = new ThreadLocal<>();
        }
        plataformaMobile.set(plataforma.getPlataforma());
    }

    private static String getPlataformaMobile(){
        return plataformaMobile.get();
    }

    /**
     * Método utilizado para iniciar internamente a variável Thread-safe navegadorWeb
     */
    public static void definirListaNavegadoresWeb(){
        if(listaNavegadoresWeb == null) listaNavegadoresWeb = new ThreadLocal<>();
        if(listaNavegadoresWeb.get() == null) listaNavegadoresWeb.set(new ArrayList<>());
    }

    public static void adicionarNavegadores(String... navegadores){
        if(recuperarListaNavegadores() == null) listaNavegadoresWeb.set(new ArrayList<>());
        for(String navegador: navegadores) listaNavegadoresWeb.get().add(navegador.toLowerCase());
    }

    public static List<String> recuperarListaNavegadores(){
        return listaNavegadoresWeb.get();
    }

    private static void definirNavegadorAtual(String navegador){
        if(navegadorAtual == null){
            navegadorAtual = new ThreadLocal<>();
        }
        navegadorAtual.set(navegador);
    }

    private static String recuperarNavegadorAtual(){
        return  navegadorAtual.get();
    }

    /**
     * Método que verifica se o driver mobile existe (mobile já iniciado)
     */
    public static boolean existeMobileDriver()  {
        return existeDriverMobileControladora();
    }

    /**
     * Método que verifica se o driver mobile existe (mobile já iniciado)
     */
    public static boolean existeWebDriver()  {
        return existeDriverWebControladora();
    }

    /**
     * Método inicia, internamente, instância de NextMobileDriver, incluindo-o no controladora
     * Uso indicado apenas para iniciar o aplicativo a primeira vez.
     * @throws MalformedURLException
     * @throws NextException
     */
    public static void iniciarMobileDriver() throws Exception {
        NextMobileDriver nextMobileDriver = retornaDriverMobile();
        incluirNextDriver(nextMobileDriver);
        definirTipoPlataformaMobile(TipoMobileDriver.setTipoMobileDriver());
        nextMobileDriver.recuperarDriver().resetApp();
    }

    /**
     * Método inicia, internamente, instância de NextWebDriver, incluindo-o no controladora
     * Uso indicado apenas no início de cada classe de teste.
     * @param navegadorWeb
     * @param url
     * @throws MalformedURLException
     * @throws NextException
     */
    public static void iniciarWebDriver(String navegadorWeb, String url) throws Exception {
        definirControladora();
        if (navegadorWeb == null) return;
        if (!navegadorWeb.isEmpty()) {
            incluirNextDriver(retornaDriverWeb(navegadorWeb, url));
            definirNavegadorAtual(navegadorWeb);
        }
    }

    /**
     * Método inicia nova janela do navegador
     * @param url
     */
    public static void abrirNovaJanelaNavegador(String url){
        abrirNovaJanela(recuperarNavegadorAtual(), url);
    }

    /**
     * Método inicia nova aba do navegador
     * @param url
     */
    public static void abrirNovaAbaNavegador(String url){
        abrirNovaAba(recuperarNavegadorAtual(), url);
    }

    /**
     * @return Lista com as abas/janelas abertas do navegador
     */
    public static ArrayList<String> recuperarListaInstanciasAbertas(){
        return recuperarInstanciasJanelaDriver(recuperarNavegadorAtual());
    }

    /**
     * Método altera o foco do agente para nova aba/janela informada
     * @param indiceInstanciaNavegador
     */
    public static void alterarFocoNavegadorPara(int indiceInstanciaNavegador){
        alterarFocoParaInstanciaJanela(recuperarNavegadorAtual(), indiceInstanciaNavegador);
    }

    /**
     * Encerra janela/aba aberta do navegador
     * @param indiceInstanciaNavegador
     */
    public static void fecharInstanciaNavegador(int indiceInstanciaNavegador){
        encerrarInstanciaNavegador(recuperarNavegadorAtual(), indiceInstanciaNavegador);
    }

    /**
     * Realizar o reset do app(Appium Driver)
     */
    public static void redefinirMobileDriver(){
        redefinirDriverMobileControladora();
    }

    /**
     * Realizar o reset do navegador
     */
    public static void encerrarDriverNavegador(){
        encerrarDriversWebControladora();
    }

    /**
     * @return driver (WebDriver - Teste Web)
     */
    public static WebDriver getWebDriver(){
        return recuperarNextDriver(recuperarNavegadorAtual()).recuperarDriver();
    }

    /**
     * Método para trocar o navegador que o agente da automação irá interagir
     * @param navegador
     * @param url
     */
    public static WebDriver trocarNavegador(String navegador, String url) throws Exception {
        if(!existeDriverPlataforma(navegador)){
            iniciarWebDriver(navegador,url);
        }else{
            definirNavegadorAtual(navegador);
            recuperarNextDriver(recuperarNavegadorAtual()).recuperarDriver().get(url);
        }
        return recuperarNextDriver(recuperarNavegadorAtual()).recuperarDriver();
    }

    /**
     * Método para trocar o navegador que o agente da automação irá interagir
     * @param navegador
     * @return
     */
    public static WebDriver trocarNavegador(String navegador){
        if(!existeDriverPlataforma(navegador)){
            throw new SecaoNextException("O navegador " + navegador + " ainda não foi instanciado nesse teste");
        }
        definirNavegadorAtual(navegador);
        return recuperarNextDriver(recuperarNavegadorAtual()).recuperarDriver();
    }

    /**
     * @return driver (AppiumDriver<MobileElement> - Teste Mobile)
     */
    public static AppiumDriver<MobileElement> getDriver(){
        return (AppiumDriver) recuperarNextDriver(getPlataformaMobile()).recuperarDriver();
    }

    /**
     * Encerra o driver do navegador informado
     * @param navegador
     */
    public static void encerrarDriverNavegador(String navegador){
        removerNextDriver(navegador);
    }

    /**
     * Encerra os drivers de todos os navegadores abertos
     */
    public static void encerrarDriversNavegador() {
        encerrarDriversWebControladora();
    }

    /**
     * Encerra os Drivers da controladora e remove a instância da lista
     */
    public static void encerrarDriversExecucao(){

        if (getCasoTeste().isTipoExecucao(TipoExecucao.MOBILE)) {
            Reporter.log("===============================================", true);
            Reporter.log("Finalizando o driver do app...", true);
            encerrarDriversMobileControladora();
        }

        if (getCasoTeste().isTipoExecucao(TipoExecucao.WEB)) {
            Reporter.log("Finalizando drivers Web...", true);
            Reporter.log("===============================================", true);
            encerrarDriversWebControladora();
            listaNavegadoresWeb.remove();
        }
    }

    public static void setPastaDownloadBrowser(String browserType) {

        if(isNull(pastaDownloadBrowserCustomizada)) pastaDownloadBrowserCustomizada = new ThreadLocal<>();

        String barra = System.getProperty("os.name").toLowerCase().startsWith("windows") ? "\\" : "/";
        String pastaDownloadBrowser = System.getProperty("user.home") + barra + "Downloads" + barra;

        if ("chrome firefox".contains(browserType)) {
            if (isNull(pastaDownloadBrowserCustomizada.get())) {
                pastaDownloadBrowser += "framework" + barra + getCasoTeste().getCasoId() + "_";
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSS");
                pastaDownloadBrowser += LocalDateTime.now().format(dateTimeFormatter) + barra;
                File file = new File(pastaDownloadBrowser);
                file.mkdirs();
                if (!file.exists())
                    OperadorEvidencia.logarPasso("Não foi possível criar a pasta '" +
                            pastaDownloadBrowser + "'. Isto pode ocasionar erros em testes web que fazem download de arquivos.");
                OperadorEvidencia.logarPasso("Pasta de download do navegador para este teste e execução: " + pastaDownloadBrowser);
                pastaDownloadBrowserCustomizada.set(file);
            }
            return;
        }

        if(isNull(pastaDownloadBrowserPadrao)) pastaDownloadBrowserPadrao = new ThreadLocal<>();
        if(isNull(pastaDownloadBrowserPadrao.get())) {
            File file = new File(pastaDownloadBrowser);
            if (!file.exists())
                file.mkdir();
            if (!file.exists())
                OperadorEvidencia.logarPasso("Não foi possível criar a pasta '" +
                        pastaDownloadBrowser + "'. Isto pode ocasionar erros em testes web que fazem download de arquivos.");
            OperadorEvidencia.logarPasso("Pasta de download do navegador para este teste e execução: " + pastaDownloadBrowser);
            pastaDownloadBrowserPadrao.set(file);
        }
    }

    public static File getPastaDownloadBrowser() {

        if(isNull(pastaDownloadBrowserCustomizada)) pastaDownloadBrowserCustomizada = new ThreadLocal<>();
        if(isNull(pastaDownloadBrowserPadrao)) pastaDownloadBrowserPadrao = new ThreadLocal<>();

        if (!isNull(pastaDownloadBrowserCustomizada.get()))
            return pastaDownloadBrowserCustomizada.get();
        if (!isNull(pastaDownloadBrowserPadrao.get()))
            return pastaDownloadBrowserPadrao.get();

        return null;
    }


    public static Boolean isAppBrowserRessetado() {
        return ResetApp.isAppBrowserRessetado();
    }
}
