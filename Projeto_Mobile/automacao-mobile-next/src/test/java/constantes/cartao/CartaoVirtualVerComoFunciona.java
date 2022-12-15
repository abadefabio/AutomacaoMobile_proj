package constantes.cartao;

import io.appium.java_client.ios.IOSDriver;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public enum CartaoVirtualVerComoFunciona {

    // Posi��o 0 do Array = Android
    // Posi��o 1 do Array = IOS

    CADA_CARTAO_GERADO("Cada cart�o gerado � v�lido pra uma compra.","Cada cart�o gerado � v�lido pra uma compra."),
    EXPIRAM_DEPOIS_72HORAS("Os cart�es virtuais expiram depois de 72 horas.", "Os cart�es virtuais expiram depois de 72 horas."),
    CVV_MUDA_TODA_VEZ("O n�mero � sempre o mesmo, mas o CVV muda toda vez ;).","O n�mero do cart�o � sempre o mesmo, mas o CVV muda toda vez."),
    SERVICOS_PARA_ASSINATURA("Voc� tamb�m pode usar pra servi�os de assinatura.","Voc� tamb�m pode usar pra servi�os de assinatura.");

    private String value[]=new String[2];

    CartaoVirtualVerComoFunciona(String... value) {
        this.value[0]= value[0];
        this.value[1] = value[1];
    }

    @Override
    public String toString() {
        if(getDriver() instanceof IOSDriver){
            return value[1];
        }
        return value[0];
    }
}
