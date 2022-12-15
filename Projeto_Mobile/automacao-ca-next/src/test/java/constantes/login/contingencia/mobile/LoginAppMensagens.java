package constantes.login.contingencia.mobile;

import io.appium.java_client.android.AndroidDriver;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public enum LoginAppMensagens {

    APP_INDISPONIVEL("App temporariamente indisponível.",
            "App temporariamente indisponível");

    private String value;
    private String androidValue;
    private String iosValue;

    LoginAppMensagens(String value){
        this.value = value;
    }

    LoginAppMensagens(String androidValue, String iosValue){
        this.androidValue = androidValue;
        this.iosValue = iosValue;
    }

    @Override
    public String toString() {
        switch (this) {
            case APP_INDISPONIVEL:
                return getDriver() instanceof AndroidDriver ? androidValue : iosValue;
            default: return this.value;
        }
    }
}
