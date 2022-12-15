package br.com.next.automacao.core.drivers.web.managers;

import br.com.next.automacao.core.constantes.driver.web.TipoWebDriver;
import br.com.next.automacao.core.tools.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import java.util.Objects;

import static br.com.next.automacao.core.drivers.OperadorDriver.getPastaDownloadBrowser;
import static br.com.next.automacao.core.drivers.OperadorDriver.setPastaDownloadBrowser;

/**
 * Classe para criação de driver Firefox
 */
public class NextFirefoxDriver extends NextWebDriver {

    public NextFirefoxDriver() {
        setPastaDownloadBrowser(BrowserType.FIREFOX);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        configuracoesDriver = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("security.tls.version.max", 3);
        profile.setPreference("security.tls.version.enable-deprecated", true);
        ((FirefoxOptions)configuracoesDriver).setProfile(profile);
        ((FirefoxOptions) configuracoesDriver).setPageLoadStrategy(PageLoadStrategy.EAGER);
        ((FirefoxOptions) configuracoesDriver).addPreference("browser.download.folderList", 2);
        ((FirefoxOptions) configuracoesDriver).addPreference("browser.helperApps.alwaysAsk.force", false);
        ((FirefoxOptions) configuracoesDriver).addPreference("browser.download.panel.shown", false);
        ((FirefoxOptions) configuracoesDriver).addPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/plain, application/octet-stream, application/binary, text/csv, application/csv, application/excel, text/comma-separated-values, text/xml, application/xml");
        ((FirefoxOptions) configuracoesDriver).addPreference("browser.download.manager.showWhenStarting", false);
        ((FirefoxOptions) configuracoesDriver).addPreference("browser.download.dir", getPastaDownloadBrowser().getAbsolutePath());
        ((FirefoxOptions) configuracoesDriver).addPreference("browser.download.useDownloadDir", true);
        ((FirefoxOptions) configuracoesDriver).addPreference("browser.download.panel.shown", true);
        ((FirefoxOptions) configuracoesDriver).addPreference("browser.download.improvements_to_download_panel", true);
        configuracoesDriver.merge(capabilities);
        this.plataforma = TipoWebDriver.FIREFOX.getNavegador();
    }

    @Override
    protected synchronized void iniciarWebDriver(String url) {
        try{
            String caminhoDriver = caminhoBase + Objects.requireNonNull(ReadProperties.getProperty("firefox.driver")).replace(".exe", "");
            if (System.getProperty("os.name").toLowerCase().contains("win")) caminhoDriver += ".exe";
            Reporter.log("Inicializando driver: \n " +
                    caminhoDriver , true);
            System.setProperty("webdriver.gecko.driver",caminhoDriver);
            this.driver = new FirefoxDriver((FirefoxOptions) configuracoesDriver);
        }catch(Exception e){
            Reporter.log("Inicializando driver automaticamente pelo WebDriverManager...", true);
            this.driver = WebDriverManager.firefoxdriver().capabilities(configuracoesDriver).create();
        }
        this.driver.navigate().to(url);
    }

    @Override
    public WebDriver recuperarDriver() {
        return this.driver;
    }
}
