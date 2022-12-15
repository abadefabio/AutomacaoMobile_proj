package constantes.transferencia;

import io.appium.java_client.android.AndroidDriver;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public enum MensagemValidacaoCamposTranferir {

    MENSAGEM_VALOR_ACIMA_LIMITE("Ops! Você ultrapassou o limite.\nSeu limite pra transações é de R$ 50.000,00", "Ops! Você ultrapassou o limite.\nSeu limite pra transações é R$ 50.000,00");

    private String value;
    private String androidValue;
    private String iosValue;

    MensagemValidacaoCamposTranferir(String androidValue, String iosValue){
        this.androidValue = androidValue;
        this.iosValue = iosValue;
    }

    @Override
    public String toString() {
        switch (this){
            case MENSAGEM_VALOR_ACIMA_LIMITE:
                return getDriver() instanceof AndroidDriver ? androidValue : iosValue;
            default: return this.value;
        }
    }
}
