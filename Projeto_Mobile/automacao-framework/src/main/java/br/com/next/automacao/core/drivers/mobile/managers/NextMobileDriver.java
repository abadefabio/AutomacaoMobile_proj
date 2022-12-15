package br.com.next.automacao.core.drivers.mobile.managers;

import br.com.next.automacao.core.drivers.NextDriver;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.exception.SecaoNextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Classe herda de NextDriver instanciando AppiumDriver
 * @author Matheus Lima Barbosa de Tulio
 * @version 3.5.2
 * @Since 2021-05
 */
public abstract class NextMobileDriver extends NextDriver {

    public NextMobileDriver(){
        configuracoesDriver = new DesiredCapabilities();
        configuracoesDriver.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 360);
    }

    abstract void iniciarMobileDriver(URL endereco) throws NextException, MalformedURLException;

    @Override
    public NextMobileDriver criarDriver(String url) throws Exception{
        URL endereco = new URL(url);
        Reporter.log("======================================\n" +
                "          Iniciando Driver " + this.plataforma +  "\n" +
                "======================================", true);
        try{
            iniciarMobileDriver(endereco);
        }catch(SessionNotCreatedException error){
            throw new SecaoNextException(plataforma + "| Falha ao criar conexao com o dispositivo! DICA: Verifique se o dispositivo ja esta reservado ou desconectado e o usu�rio e senha do MC.", error);
        }
        return this;
    }

    /**
     * @return AppiumDriver<MobileElement>
     */
    @Override
    public AppiumDriver<MobileElement> recuperarDriver(){
        return (AppiumDriver)this.driver;
    }
}
