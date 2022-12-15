package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class DetalhesMesadaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_delete_allowance")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Toque duas vezes para excluir esta mesada'")
    private MobileElement botaoExcluirMesada;

    public DetalhesMesadaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão excluir mesada
     *
     * @return DetalhesMesadaTela
     * @throws Exception
     */
    @Step("Tocar botão excluir mesada")
    public DetalhesMesadaTela tocarBotaoExcluirMesada() throws Exception {
        salvarEvidencia("Tocar botão excluir mesada");
        tocarElemento(botaoExcluirMesada, "Não foi possível tocar botão excluir mesada");
        return this;
    }
}
