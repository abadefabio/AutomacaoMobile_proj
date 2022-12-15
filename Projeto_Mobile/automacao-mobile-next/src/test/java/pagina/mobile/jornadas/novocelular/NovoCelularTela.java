package pagina.mobile.jornadas.novocelular;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NovoCelularTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_dont_have_cell_phone")
    private MobileElement botaoVamosLa;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    private MobileElement botaofechar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_info")
    private MobileElement botaoInformacoes;

    public NovoCelularTela(AppiumDriver driver) {
        super(driver);
    }
}
