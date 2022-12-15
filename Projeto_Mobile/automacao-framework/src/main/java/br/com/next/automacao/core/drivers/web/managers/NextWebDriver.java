package br.com.next.automacao.core.drivers.web.managers;

import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.drivers.NextDriver;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.exception.SecaoNextException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.SessionNotCreatedException;
import org.testng.Reporter;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static br.com.next.automacao.core.tools.ReadProperties.getProperty;

/**
 * Classe herda de NextMobileDriver instanciando WebDriver
 * @author Matheus Lima Barbosa de Tulio
 * @version 3.5.2
 * @Since 2021-05
 */
public abstract class NextWebDriver extends NextDriver {

    boolean windows = System.getProperty("os.name").toLowerCase().contains("windows");
    String caminhoBase = windows ? getProperty("path.base.windows") : getProperty("path.base.mac");
    private static ThreadLocal<String> pastaDownloadBrowser;

    abstract void iniciarWebDriver(String url) throws NextException;

    @Override
    public NextWebDriver criarDriver(String url) throws Exception{
        Reporter.log("======================================\n" +
                "Preparando Driver " + this.plataforma + " por WebDriverManager\n" +
                "======================================", true);
        try {
            iniciarWebDriver(url);
        } catch (SessionNotCreatedException error) {
            throw new SecaoNextException(plataforma + "| Falha ao iniciar seção do driver! Dica: verifique se a versão do driver é compatível com o seu navegador e se ela está localizada na pasta C:\\Users\\Public\\Documents\\next\\automacao\\drivers", error);
        }
        return this;
    }

    public void configurarPaginaWeb(int pageLoadTimeout){
        //Especificando tempo de espera de carregamento de pagina e espera implicita
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

        //Limpando cookies
        driver.manage().deleteAllCookies();

        //Ajusta a janela
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        int height = Math.min(screenHeight, 1080);
        int width = Math.min(screenWidth, 1920);

        if(TesteBase.getCasoTeste().getParametrosTeste().getOrDefault("headless", "false").equals("true")) {
            driver.manage().window().setSize(new Dimension(1920, 1080));
        } else if (screenHeight * screenWidth <= 1920*1080) {
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(new Dimension(width, height));
            // centraliza
            try {
                driver.manage().window().setPosition(new Point((int) (screenWidth - width) / 2, (int) (screenHeight - height) / 2));
            } catch (Exception e) {
                driver.manage().window().setPosition(new Point(0, 0));
            }
        }
    }

}
