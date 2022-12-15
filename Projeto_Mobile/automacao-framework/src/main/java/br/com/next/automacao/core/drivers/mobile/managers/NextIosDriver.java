package br.com.next.automacao.core.drivers.mobile.managers;

import br.com.next.automacao.core.constantes.driver.mobile.TipoMobileDriver;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.ReadProperties;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;

/**
 * Classe herda de NextMobileDriver instanciando IOSDriver
 * @author Matheus Lima Barbosa de Tulio
 * @version 3.5.2
 * @Since 2021-05
 */

@SuppressWarnings("unchecked")
public class NextIosDriver extends NextMobileDriver {

    public NextIosDriver() throws MalformedURLException, NextException {

        boolean emulador = getCasoTeste().getParametrosTeste().getOrDefault("emulador", "false").equals("true");
        String appiumVersion = getCasoTeste().getParametrosTeste().getOrDefault("appiumVersion","");

        this.plataforma = TipoMobileDriver.IOS.getPlataforma();
        JSONObject argumentos = new JSONObject();
        JSONArray argumento = new JSONArray();
        argumento.add("");
        argumentos.put("args", argumento);
        Map<String, String> processEnv = new HashMap<>();
        processEnv.put("NextAppiumTest", "");
        argumentos.put("env", processEnv);

        if (!emulador) {
            configuracoesDriver.setCapability("uftm:oauthClientId", ReadProperties.getAuthUserId());
            configuracoesDriver.setCapability("uftm:oauthClientSecret", ReadProperties.getAuthUserPass());
            configuracoesDriver.setCapability("uftm:tenantId", "999999999");
            configuracoesDriver.setCapability("uftm:appiumVersion", appiumVersion);
        }

        String platformVersion = getCasoTeste().getParametrosTeste().getOrDefault("platformVersion","");
        if (!platformVersion.isBlank())
            configuracoesDriver.setCapability(MobileCapabilityType.PLATFORM_VERSION, getCasoTeste().getParametrosTeste().get("platformVersion"));
        configuracoesDriver.setCapability(MobileCapabilityType.UDID, getCasoTeste().getParametrosTeste().get("udid"));
        configuracoesDriver.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        configuracoesDriver.setCapability(MobileCapabilityType.PLATFORM_NAME, getCasoTeste().getParametrosTeste().get("plataforma"));
        configuracoesDriver.setCapability(MobileCapabilityType.DEVICE_NAME, getCasoTeste().getParametrosTeste().get("deviceName"));
        configuracoesDriver.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getCasoTeste().getParametrosTeste().get("appPackage"));
        configuracoesDriver.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 60000);
        configuracoesDriver.setCapability(MobileCapabilityType.NO_RESET, false);
        configuracoesDriver.setCapability(IOSMobileCapabilityType.PROCESS_ARGUMENTS, argumentos.toString());
    }


    @Override
    protected void  iniciarMobileDriver(URL endereco) {
        this.driver = new IOSDriver<>(endereco, configuracoesDriver);
    }

}
