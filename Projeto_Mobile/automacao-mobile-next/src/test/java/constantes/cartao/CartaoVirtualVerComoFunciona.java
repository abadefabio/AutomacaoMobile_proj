package constantes.cartao;

import io.appium.java_client.ios.IOSDriver;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public enum CartaoVirtualVerComoFunciona {

    // Posição 0 do Array = Android
    // Posição 1 do Array = IOS

    CADA_CARTAO_GERADO("Cada cartão gerado é válido pra uma compra.","Cada cartão gerado é válido pra uma compra."),
    EXPIRAM_DEPOIS_72HORAS("Os cartões virtuais expiram depois de 72 horas.", "Os cartões virtuais expiram depois de 72 horas."),
    CVV_MUDA_TODA_VEZ("O número é sempre o mesmo, mas o CVV muda toda vez ;).","O número do cartão é sempre o mesmo, mas o CVV muda toda vez."),
    SERVICOS_PARA_ASSINATURA("Você também pode usar pra serviços de assinatura.","Você também pode usar pra serviços de assinatura.");

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
