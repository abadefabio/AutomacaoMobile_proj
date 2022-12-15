package constantes.login.contingencia.mobile;

import io.appium.java_client.android.AndroidDriver;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public enum LoginContingenciaPopupMensagens {

    SUCESSO_ATIVACAO("Pronto! Ativação realizada com sucesso", "Pronto! Ativação realizada com sucesso"),
    FALHA_ATIVACAO("Não foi possível realizar o login :(", "Não foi possível realizar o login :(");

    private String value;
    private String androidValue;
    private String iosValue;

    LoginContingenciaPopupMensagens(String value){
        this.value = value;
    }

    LoginContingenciaPopupMensagens(String androidValue, String iosValue){
        this.androidValue = androidValue;
        this.iosValue = iosValue;
    }

    @Override
    public String toString() {
        switch (this){
            case FALHA_ATIVACAO:
            case SUCESSO_ATIVACAO:
                return getDriver() instanceof AndroidDriver ? androidValue : iosValue;
            default: return this.value;
        }
    }
}
