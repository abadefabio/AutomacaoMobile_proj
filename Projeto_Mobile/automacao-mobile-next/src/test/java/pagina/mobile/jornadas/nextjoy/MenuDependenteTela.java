package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MenuDependenteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//me.next.uikit.NextLabel[@text='Mesada']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == ' Mesada . Agende dep�sitos mensais .'")
    private MobileElement menuMesada;

    public MenuDependenteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar menu Mesada
     *
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Tocar menu Mesada")
    public MenuDependenteTela tocarMenuMesada() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(menuMesada, "N�o foi poss�vel encontrar o menu Mesada");
        salvarEvidencia("Tocar menu Mesada");
        tocarElemento(menuMesada, "N�o foi poss�vel tocar no menu Mesada");
        return this;
    }

    /**
     * Tocar menu Mesada
     *
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Tocar menu Mesada")
    public MenuDependenteTela validarMenuDependente(String nome) throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(nome), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel encontrar o texto:" + nome);
        salvarEvidencia("Validou exibi��o do nome do dependente: " + nome);
        return this;
    }
}
