package br.com.next.automacao.core.drivers.web.managers;

import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.driver.web.TipoWebDriver;
import br.com.next.automacao.core.drivers.OperadorDriver;
import br.com.next.automacao.core.tools.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Reporter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class NextChromeDriver extends NextWebDriver {

    public NextChromeDriver() {
        OperadorDriver.setPastaDownloadBrowser(BrowserType.CHROME);
        configuracoesDriver = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", OperadorDriver.getPastaDownloadBrowser().getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        if (TesteBase.getCasoTeste().getParametrosTeste().getOrDefault("headless", "false").equals("true")) {
            ((ChromeOptions) configuracoesDriver).setHeadless(true);
            ((ChromeOptions) configuracoesDriver).addArguments("--disable-gpu");
            ((ChromeOptions) configuracoesDriver).addArguments("--disable-browser-side-navigation");
            ((ChromeOptions) configuracoesDriver).addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
            ((ChromeOptions) configuracoesDriver).addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        }
        ((ChromeOptions) configuracoesDriver).setExperimentalOption("prefs", prefs);
        ((ChromeOptions) configuracoesDriver).setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        ((ChromeOptions) configuracoesDriver).setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        ((ChromeOptions) configuracoesDriver).setAcceptInsecureCerts(true);
        ((ChromeOptions) configuracoesDriver).setPageLoadStrategy(PageLoadStrategy.EAGER);
        this.plataforma = TipoWebDriver.CHROME.getNavegador();
    }
    @Override
    protected synchronized void iniciarWebDriver(String url) {
        try{
            String caminhoDriver = caminhoBase + Objects.requireNonNull(ReadProperties.getProperty("chrome.driver")).replace(".exe", "");
            if (System.getProperty("os.name").toLowerCase().contains("win")) caminhoDriver += ".exe";
            System.setProperty("webdriver.chrome.driver",caminhoDriver);
            Reporter.log("Inicializando driver: \n " +
                    caminhoDriver , true);
            this.driver = new ChromeDriver((ChromeOptions) configuracoesDriver);
        }catch(Exception e){
            Reporter.log("Inicializando driver automaticamente pelo WebDriverManager...", true);
            this.driver = WebDriverManager.chromedriver().capabilities(configuracoesDriver).create();
        }
        this.driver.navigate().to(url);
    }

    @Override
    public WebDriver recuperarDriver() {
        return this.driver;
    }
}
