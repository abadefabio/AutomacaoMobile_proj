package br.com.next.automacao.core.drivers.web.managers;

import br.com.next.automacao.core.constantes.driver.web.TipoWebDriver;
import br.com.next.automacao.core.drivers.OperadorDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Reporter;

import static br.com.next.automacao.core.drivers.OperadorDriver.setPastaDownloadBrowser;

public class NextSafariDriver extends NextWebDriver {

    public NextSafariDriver(){
        setPastaDownloadBrowser(BrowserType.SAFARI);
        this.plataforma = TipoWebDriver.SAFARI.getNavegador();
        configuracoesDriver = new SafariOptions();
    }

    @Override
    protected synchronized void iniciarWebDriver(String url) {
        Reporter.log("Inicializando driver automatica e exclusivamente pelo WebDriverManager...", true);
        this.driver = WebDriverManager.safaridriver().capabilities(configuracoesDriver).create();
        this.driver.navigate().to(url);
    }

    @Override
    public WebDriver recuperarDriver() {
        return this.driver;
    }
}
