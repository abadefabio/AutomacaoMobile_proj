package br.com.next.automacao.core.drivers.mobile.managers;

import br.com.next.automacao.core.constantes.driver.mobile.TipoMobileDriver;
import br.com.next.automacao.core.drivers.OperadorDriver;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.ReadProperties;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;

/**
 * Classe herda de NextMobileDriver instanciando AndroidDriver
 * @author Matheus Lima Barbosa de Tulio
 * @version 3.5.2
 * @Since 2021-05
 */
public class NextAndroidDriver extends NextMobileDriver {

    public NextAndroidDriver() throws MalformedURLException, NextException {

        boolean emulador = getCasoTeste().getParametrosTeste().getOrDefault("emulador", "false").equals("true");
        String appiumVersion = getCasoTeste().getParametrosTeste().getOrDefault("appiumVersion","");
        this.plataforma = TipoMobileDriver.ANDROID.getPlataforma();

        if(!emulador) {
            configuracoesDriver.setCapability("uftm:oauthClientId", ReadProperties.getAuthUserId());
            configuracoesDriver.setCapability("uftm:oauthClientSecret", ReadProperties.getAuthUserPass());
            configuracoesDriver.setCapability("uftm:appiumVersion", appiumVersion);
            configuracoesDriver.setCapability("uftm:tenantId", "999999999");
        }

        configuracoesDriver.setCapability("appium:autoGrantPermissions", "true"); // emulador não suporta
        configuracoesDriver.setCapability("appium:autoAcceptAlerts", "true"); // emulador não suporta
        configuracoesDriver.setCapability(MobileCapabilityType.UDID, getCasoTeste().getParametrosTeste().get("udid"));
        configuracoesDriver.setCapability(MobileCapabilityType.PLATFORM_NAME, getCasoTeste().getParametrosTeste().get("plataforma"));
        configuracoesDriver.setCapability(MobileCapabilityType.DEVICE_NAME, getCasoTeste().getParametrosTeste().get("deviceName"));
        configuracoesDriver.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getCasoTeste().getParametrosTeste().get("appPackage"));
        configuracoesDriver.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getCasoTeste().getParametrosTeste().get("appActivity"));
        configuracoesDriver.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
    }

    @Override
    protected void  iniciarMobileDriver(final URL endereco) throws NextException, MalformedURLException {
        this.driver = new AndroidDriver<>(endereco, configuracoesDriver);
    }
}
