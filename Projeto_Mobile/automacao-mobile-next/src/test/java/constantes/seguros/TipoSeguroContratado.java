package constantes.seguros;

import io.appium.java_client.ios.IOSDriver;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public enum TipoSeguroContratado {

    //Posi��o 0 do array = Android
    //Posi��o 1 do array = IOS
    SEGURO_CREDITO("Seguro Cr�dito","Superprotegido Premi�vel Em vig�ncia, toque para mais detalhes"),
    SEGURO_DEBITO("Seguro D�bito","Seguro Cart�o de D�bito Em vig�ncia, toque para mais detalhes"),
    SEGURO_DENTAL("Plano dental","Dental Ideal Em vig�ncia, toque para mais detalhes"),
    SEGURO_RESIDENCIAL("Seguro Residencial","Bilhete Residencial Mensal Em vig�ncia, toque para mais detalhes");

    private final String[] value = new String[2];

    TipoSeguroContratado(String ... values) {
        this.value[0] = values[0];
        this.value[1] = values[1];
    }
    public String toString() {
        if (getDriver() instanceof IOSDriver) {
            return value[1];
        }
        return value[0];
    }
}
