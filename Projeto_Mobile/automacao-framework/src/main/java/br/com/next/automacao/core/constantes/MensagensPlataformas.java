package br.com.next.automacao.core.constantes;

import br.com.next.automacao.core.drivers.OperadorDriver;
import io.appium.java_client.android.AndroidDriver;

/*
Classe para possibilitar uso de strings de mensagem diferentes para iOS e Android.
 */

public class MensagensPlataformas {
    String android, ios;

    public MensagensPlataformas android(String android) {
        this.android = android;
        return this;
    }
    public MensagensPlataformas ios(String ios) {
        this.ios = ios;
        return this;
    }
    public String get() {
        return OperadorDriver.getDriver() instanceof AndroidDriver ? android : ios;
    }

}
