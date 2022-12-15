package pagina.mobile.jornadas.comprovantes.investimentos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.comprovantes.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class PeriodoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_confirm")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar\"]")
    private MobileElement botaoConfirmar;

    public PeriodoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presenca da tela 'PERIODO'
     * @return
     */
    @Step("Validar presença da tela 'PERIODO'")
    public PeriodoTela validarPresencaTelaPeriodo() {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.PERIODO), MetodoComparacaoBooleano.VERDADEIRO, "Titulo 'PERIODO' nao esta presente na tela!");
        salvarEvidencia("Validada presenca da tela 'PERIODO'");
        return this;
    }


    /**Tocar no botao 'Confirmar'
     * @return
     * @throws Exception
     */
    public PeriodoTela tocarBotaoConfirmar() throws Exception {

        salvarEvidencia("Confirmar o período atual");
        tocarElemento(botaoConfirmar,"Nao foi possivel tocar no botão 'confirmar'!");
        return this;
    }
}
