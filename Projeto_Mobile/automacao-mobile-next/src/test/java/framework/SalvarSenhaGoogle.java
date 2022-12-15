package framework;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SalvarSenhaGoogle extends PaginaBase {

    @AndroidFindBy(id = "android:id/autofill_save_title")
    private MobileElement tituloPopupSalvarSenhaGoogle;

    @AndroidFindBy(id = "android:id/autofill_save_no")
    private MobileElement botaoNaoObrigado;

    @AndroidFindBy(xpath = "//*[@text=\"Dispensar\"]")
    private MobileElement botaoDispensar;

    public SalvarSenhaGoogle(AppiumDriver driver) {
        super(driver);
    }

    public SalvarSenhaGoogle fecharPopupSenhaGoogleSeAberto() throws NextException {
        if (aguardarExistenciaElemento(tituloPopupSalvarSenhaGoogle, 3, 500)) {
            tocarElemento(botaoNaoObrigado, "N�o foi poss�vel tocar no bot�o \"N�o Obrigado\"");
            try {
                tocarElemento(botaoDispensar, "N�o foi poss�vel tocar no bot�o \"Dispensar\"");
            } catch (Throwable ignore) {}
        }
        return this;
    }
}
