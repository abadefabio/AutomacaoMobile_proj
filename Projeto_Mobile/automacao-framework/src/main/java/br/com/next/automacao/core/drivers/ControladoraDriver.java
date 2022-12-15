package br.com.next.automacao.core.drivers;

import br.com.next.automacao.core.drivers.mobile.fabrica.Config;
import br.com.next.automacao.core.drivers.mobile.managers.NextMobileDriver;
import br.com.next.automacao.core.drivers.web.managers.NextWebDriver;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.exception.SecaoNextException;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static java.util.Objects.isNull;

/**
 * Classe orquestra, armazena e organiza os diversos drivers com suas respectivas seções iniciadas durante o teste
 * @author Matheus Lima Barbosa de Tulio
 * @version 3.5.2
 * @since 2021-05
 */
public class ControladoraDriver {

    private static ThreadLocal<ConcurrentHashMap<String, NextDriver>> mapaDrivers = new ThreadLocal<ConcurrentHashMap<String, NextDriver>>() {
        @Override
        protected ConcurrentHashMap<String, NextDriver> initialValue() {
            return new ConcurrentHashMap<String, NextDriver>();
        }
    };

    public static ConcurrentHashMap<String, NextDriver> drivers() {
        return mapaDrivers.get();
    }
    public static ThreadLocal<ConcurrentHashMap<String, Boolean>> deviceEmulador = new ThreadLocal<ConcurrentHashMap<String, Boolean>>() {
        @Override
        protected ConcurrentHashMap<String, Boolean> initialValue() {
            return new ConcurrentHashMap<String, Boolean>();
        }
    };


    protected ControladoraDriver(){

    }

    protected static boolean existeDriverPlataforma(final String plataforma){
        return drivers().containsKey(plataforma);
    }

    public static URL obterUrlAppiumServerCorrigida() throws MalformedURLException {
        String url = getCasoTeste().getParametrosTeste().getOrDefault("appiumServer", ReadProperties.getMcUrl());
        url = url.endsWith("/wd/hub") ? url : url + "/wd/hub";
        return new URL(url);
    }

    /**
     * Método inclui novo objeto NextDriver na controladora
     * @param driver
     */
    protected static void incluirNextDriver(final NextDriver driver) throws NextException, MalformedURLException {

        class Quit extends Thread {
            @Override
            public void run() {
                try {
                    driver.recuperarDriver().quit();
                } catch (Exception ignore) {
                }
            }
        }
        Runtime.getRuntime().addShutdownHook(new Quit());

        definirDriverControladora(driver);
        drivers().put(driver.recuperarPlataforma(),driver);

        boolean erroDevice = false;

        if (driver.recuperarDriver() instanceof AndroidDriver) {
            /*
            O comando seguinte só deve funcionar em emuladores:
            driver.executeScript("mobile: sensorSet", ImmutableMap.of("sensorType","light","value","100"))
            Trata-se de comando mobile nativo aceito pelo Appium.
            */
            try {
                ((AndroidDriver<?>) driver.recuperarDriver()).executeScript(
                        "mobile: sensorSet",
                        ImmutableMap.of("sensorType", "light", "value", "100")
                );
                setDeviceEmulador(true);
                return;
            } catch (WebDriverException wde) {
                if (wde.getMessage().contains("sensorSet method is only available for emulators")) {
                    erroDevice = true;
                }
            }
        }

        if (driver.recuperarDriver() instanceof IOSDriver) {
            try {
                ((IOSDriver<?>) driver.recuperarDriver()).executeScript(
                        "mobile: setPasteboard",
                        ImmutableMap.of("content", "next", "encoding", "ascii")
                );
                setDeviceEmulador(true);
                return;
            } catch (WebDriverException wde) {
                if (wde.getMessage().contains("Setting pasteboard content is not supported on real devices")) {
                    erroDevice = true;
                }
            }
        }

        if (erroDevice) {
            if (obterUrlAppiumServerCorrigida().toString()
                    // Usando contains() para permitir especificação de portas no configuracoes.properties
                    // e sufixo /wd/hub ou outro, testando apenas o protocolo, servidor e domínio.
                    .startsWith(Config.MC_URL_DEFAULT)) {
                // Se o device físico é do Mobile Center, então não seria problema
                return;
            }
            // como não é Mobile Center, então temos um problema
            throw new NextException("O device conectado não parece ser um emulador (mas device físico). Somente emuladores são aceitos de fora do Mobile Center.", new WebDriverException());
        }
    }

    public static void setDeviceEmulador(boolean emulador) {
        deviceEmulador.get().putIfAbsent("valor", true);
    }

    /**
     * Retorna se o device é um emulador. Retorna verdadeiro quando é, e falso para qualquer outra possibilidade.
     * @return
     */
    public static boolean isDeviceEmulador() {
        boolean ret = false;
        try {
            ret = deviceEmulador.get().get("valor");
        } catch (Exception ignored) {

        }
        return ret;
    }

    /**
     * Método configura o objeto NextDriver informado
     * @param nextDriver
     */
    private static synchronized void definirDriverControladora(final NextDriver nextDriver){
        nextDriver.configurarImplicitlyWait(2);
        if(nextDriver instanceof NextWebDriver){
            ((NextWebDriver) nextDriver).configurarPaginaWeb(30);
        }
    }

    /**
     * Método retorna objeto NextDriver referente a plataforma informada
     * @param plataforma
     * @return NextDriver
     */
    protected static NextDriver recuperarNextDriver(final String plataforma){
        return drivers().get(plataforma);
    }

    /**
     * @param plataforma
     * @return ArrayList<String> com as janelas/abas abertas no driver
     */
    protected static ArrayList<String> recuperarInstanciasJanelaDriver(final String plataforma){
        return new ArrayList(drivers().get(plataforma).driver.getWindowHandles());
    }

    /**
     * Método abre nova janela do driver
     * @param plataforma
     * @param url
     */
    protected static void abrirNovaJanela(final String plataforma, final String url){
        ((JavascriptExecutor)drivers().get(plataforma).driver).executeScript("window.open('','_blank','height=570, width=520');");
        ArrayList<String> instanciasAbertas = recuperarInstanciasJanelaDriver(plataforma);
        int indiceNovaJanela = instanciasAbertas.size() - 1;
        drivers().get(plataforma).driver.switchTo().window(instanciasAbertas.get(indiceNovaJanela));
        drivers().get(plataforma).driver.manage().window().maximize();
        drivers().get(plataforma).driver.get(url);
    }

    /**
     * Método aber nova aba do driver
     * @param plataforma
     * @param url
     */
    protected static void abrirNovaAba(final String plataforma, final String url){
        ((JavascriptExecutor)drivers().get(plataforma).driver).executeScript("window.open('" + url + "', '_blank');");
        ArrayList<String> instanciasAbertas = recuperarInstanciasJanelaDriver(plataforma);
        int indiceNovaJanela = instanciasAbertas.size() - 1;
        drivers().get(plataforma).driver.switchTo().window(instanciasAbertas.get(indiceNovaJanela));
    }

    /**
     * Método retorna objeto NextDriver da plataforma desejada de acordo com o índice informado.
     * Esse método deve ser utilizado quando mais do que uma janela do mesmo navegador for iniciada durante o teste
     * @param plataforma
     * @param indiceJanela
     * @return
     */
    protected static void alterarFocoParaInstanciaJanela(final String plataforma, final int indiceJanela){
        String inctanciaDesejada = recuperarInstanciasJanelaDriver(plataforma).get(indiceJanela);
        drivers().get(plataforma).driver.switchTo().window(inctanciaDesejada);
    }

    /**
     * Método encerra seção do driver referente a plataforma informada, removendo o mesmo da controladora
     * @param plataforma
     */
    protected static void removerNextDriver(final String plataforma){
        NextFabricaDrivers.encerrarNextDriver(drivers().get(plataforma));
        drivers().remove(plataforma);
    }

    /**
     * Método encerra janela desejada do navegador informado
     * @param plataforma
     * @param indiceJanela
     */
    protected static void encerrarInstanciaNavegador(final String plataforma, final int indiceJanela){
        ArrayList<String> instanciasAbertas = recuperarInstanciasJanelaDriver(plataforma);
        drivers().get(plataforma).driver.switchTo().window(instanciasAbertas.get(indiceJanela));
        drivers().get(plataforma).driver.close();
        instanciasAbertas = recuperarInstanciasJanelaDriver(plataforma);
        if(instanciasAbertas.size() > 0){
            drivers().get(plataforma).driver.switchTo().window(instanciasAbertas.get(0));
        }
    }

    /**
     * Encerrar janelas extras do navegador
     * @param plataforma
     */
    private static void encerrarJanelasExtrasNavegador(final String plataforma){
        for(int i = 0; i < recuperarInstanciasJanelaDriver(plataforma).size() - 2; i++){
            encerrarInstanciaNavegador(plataforma, i);
        }
    }

    /**
     * Método que retorna se um driver mobile foi ou continua instanciado
     */
    protected static boolean existeDriverMobileControladora() {

        if (isNull(drivers()))
            return false;

        Set<String> keySet = drivers().keySet();

        for(String plataforma : keySet) {
            NextDriver driver = (NextDriver)drivers().get(plataforma);
            if (driver instanceof NextMobileDriver)
                return true;
        }

        return false;
    }

    /**
     * Método que retorna se um driver web foi ou continua instanciado
     */
    protected static boolean existeDriverWebControladora() {

        if (isNull(drivers()))
            return false;

        Set<String> keySet = drivers().keySet();

        for(String plataforma : keySet) {
            NextDriver driver = (NextDriver)drivers().get(plataforma);
            if (driver instanceof NextWebDriver) {
                return true;
            }
        }

        return false;
    }

    /**
     * Método realiza o resetApp de todos os NextMobileDriver da controladora e reconfigura as seções dos drivers
     * instanciados nos objetos NextMobileDriver da controladora
     */
    protected static void redefinirDriverMobileControladora() {
        if (isNull(drivers()))
            return;
        Set<String> keySet = drivers().keySet();
        for(String plataforma : keySet) {
            NextDriver driver = (NextDriver)drivers().get(plataforma);
            if (driver instanceof NextMobileDriver) {
                if (driver.recuperarDriver() instanceof IOSDriver) {
                    String iosBundleId = ((AppiumDriver<?>) driver.recuperarDriver()).getCapabilities().getCapability("bundleId").toString();
                    ((AppiumDriver<?>) driver.recuperarDriver()).resetApp();
                    /*
                    Sempre tentamos iniciar o bundleId após o reset para evitar
                    problemas após um crash do iOS ao efetuar o reset (quando o app está subindo de volta no reset e fecha)
                     */
                    ((AppiumDriver<?>) driver.recuperarDriver()).activateApp(iosBundleId);
                }
                if (driver.recuperarDriver() instanceof AndroidDriver)
                    ((AppiumDriver<?>) driver.recuperarDriver()).resetApp();
            }
        }
    }

    /**
     * Método realiza o encerramento de todos os NextMobileDriver da controladora
     * Uso indicado ao final de todos os testes
     */
    protected static void encerrarDriversMobileControladora() {

        if (isNull(drivers()))
            return;

        Set<String> keySet = drivers().keySet();

        for(String plataforma : keySet) {
            NextDriver driver = (NextDriver)drivers().get(plataforma);
            if (driver instanceof NextMobileDriver) {
                try {
                    driver.recuperarDriver().quit();
                } catch (Exception info) {
                    OperadorEvidencia.logarPasso("Aviso: O driver " + plataforma + " não foi finalizado.");
                }
                try {
                    drivers().remove(plataforma);
                } catch (Exception ex) {
                    throw new SecaoNextException("Não foi possível finalizar o driver: " + plataforma);
                }
            }
        }
    }

    /**
     * Método realiza o encerramento de todos os webdrivers (navegadores abertos),
     * primários e secundários.
     * Uso indicado ao final de todos os testes.
     */
    protected static void encerrarDriversWebControladora() {

        if (isNull(drivers()))
            return;

        Set<String> keySet = drivers().keySet();

        for(String plataforma : keySet) {
            NextDriver driver = (NextDriver)drivers().get(plataforma);
            if (!(driver instanceof NextMobileDriver)) {
                try {
                    driver.recuperarDriver().quit();
                } catch (Exception info) {
                    OperadorEvidencia.logarPasso("Aviso: O driver " + plataforma + " não foi finalizado.");
                }
                try {
                    drivers().remove(plataforma);
                } catch (Exception ex) {
                    throw new SecaoNextException("Não foi possível finalizar o driver: " + plataforma);
                }
            }
        }
    }
}
