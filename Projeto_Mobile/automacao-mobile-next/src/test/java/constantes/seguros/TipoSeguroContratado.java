package constantes.seguros;

import io.appium.java_client.ios.IOSDriver;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public enum TipoSeguroContratado {

    //Posição 0 do array = Android
    //Posição 1 do array = IOS
    SEGURO_CREDITO("Seguro Crédito","Superprotegido Premiável Em vigência, toque para mais detalhes"),
    SEGURO_DEBITO("Seguro Débito","Seguro Cartão de Débito Em vigência, toque para mais detalhes"),
    SEGURO_DENTAL("Plano dental","Dental Ideal Em vigência, toque para mais detalhes"),
    SEGURO_RESIDENCIAL("Seguro Residencial","Bilhete Residencial Mensal Em vigência, toque para mais detalhes");

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
