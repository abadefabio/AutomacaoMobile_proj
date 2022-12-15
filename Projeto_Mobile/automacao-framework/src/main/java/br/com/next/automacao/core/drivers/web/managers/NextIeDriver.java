package br.com.next.automacao.core.drivers.web.managers;

import br.com.next.automacao.core.constantes.driver.web.TipoWebDriver;
import br.com.next.automacao.core.drivers.OperadorDriver;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Reporter;

import static br.com.next.automacao.core.drivers.OperadorDriver.setPastaDownloadBrowser;

public class NextIeDriver extends NextWebDriver {

    public NextIeDriver() {
        setPastaDownloadBrowser(BrowserType.IE);
        configuracoesDriver = new InternetExplorerOptions();
        this.plataforma = TipoWebDriver.IE.getNavegador();
    }

    @Override
    protected synchronized void iniciarWebDriver(String url) throws NextException {
        try{
            String caminhoDriver = caminhoBase + ReadProperties.getProperty("ie.driver");
            Reporter.log("Inicializando driver: \n " +
                    caminhoDriver , true);
            System.setProperty("webdriver.ie.driver",caminhoDriver);
            this.driver =  new InternetExplorerDriver((InternetExplorerOptions) configuracoesDriver);
        }catch(Exception e){
            throw new NextException("Houve um erro ao iniciar o Internet Explorer, e o teste será abortado.", e);
        }
        this.driver.navigate().to(url);
    }

    @Override
    public WebDriver recuperarDriver() {
        return this.driver;
    }
}
