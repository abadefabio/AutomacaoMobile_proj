package pagina.mobile.comum.next;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class HomeJornadaTela extends PaginaBase {

    @AndroidFindBy(accessibility = "menu")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltarTelaInicialApp;

    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Next')]")
    private MobileElement tituloNext;

    public HomeJornadaTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no botão 'Voltar' (=)
     *
     * @return HomeJornadaTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Voltar' (=)")
    public HomeJornadaTela tocarBotaoVoltarTelaInicialApp() throws Exception {
        aguardarElementoHabilitado(botaoVoltarTelaInicialApp);
        salvarEvidencia("Tocar no botão 'Voltar' (=)");
        tocarElemento(botaoVoltarTelaInicialApp, "Não foi possível tocar no botão 'Voltar' (=)");
        return this;
    }

    /**
     * Validar Titulo 'Next'
     *
     * @return HomeJornadaTela
     * @throws Exception
     */
    @Step("Validar Titulo 'Next'")
    public HomeJornadaTela validarTituloNext() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(tituloNext), MetodoComparacaoBooleano.VERDADEIRO, "Validar Titulo 'Next', não está presente");
        salvarEvidencia("Validar Titulo 'Next'");
        return this;
    }
}
