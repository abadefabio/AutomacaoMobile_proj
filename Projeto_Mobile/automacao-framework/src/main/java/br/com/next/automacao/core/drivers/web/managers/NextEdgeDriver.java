package br.com.next.automacao.core.drivers.web.managers;

import br.com.next.automacao.core.constantes.driver.web.TipoWebDriver;
import br.com.next.automacao.core.tools.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Reporter;
import java.util.HashMap;
import java.util.Objects;

import static br.com.next.automacao.core.drivers.OperadorDriver.getPastaDownloadBrowser;
import static br.com.next.automacao.core.drivers.OperadorDriver.setPastaDownloadBrowser;

public class NextEdgeDriver extends NextWebDriver {

    public NextEdgeDriver()  {
        setPastaDownloadBrowser(BrowserType.EDGE);
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", getPastaDownloadBrowser().getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        if (System.getProperty("os.name").toLowerCase().contains("win"))
            chromeOptions.setBinary(ReadProperties.getProperty("edge.dev"));
        chromeOptions.setCapability("browserName", "edge");
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        configuracoesDriver = new EdgeOptions().merge(chromeOptions);
        this.plataforma = TipoWebDriver.EDGE.getNavegador();
    }

    @Override
    protected synchronized void iniciarWebDriver(String url) {

        try{
            String caminhoDriver = caminhoBase + Objects.requireNonNull(ReadProperties.getProperty("edge.driver")).replace(".exe", "");
            if (System.getProperty("os.name").toLowerCase().contains("win")) caminhoDriver += ".exe";
            Reporter.log("Inicializando driver: \n " +
                    caminhoDriver , true);
            System.setProperty("webdriver.edge.driver",caminhoDriver);
            this.driver =  new EdgeDriver((EdgeOptions) configuracoesDriver);
        }catch(Exception e){
            Reporter.log("Inicializando driver automaticamente pelo WebDriverManager...", true);
            this.driver = WebDriverManager.edgedriver().capabilities(configuracoesDriver).create();
        }
        this.driver.navigate().to(url);
    }

    @Override
    public WebDriver recuperarDriver() {
        return this.driver;
    }
}
