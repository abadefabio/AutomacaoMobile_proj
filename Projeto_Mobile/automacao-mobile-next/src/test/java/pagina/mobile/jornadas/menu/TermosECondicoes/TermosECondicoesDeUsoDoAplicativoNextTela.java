package pagina.mobile.jornadas.menu.TermosECondicoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.termosECondicoes.TituloTermosECondicoes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;


public class TermosECondicoesDeUsoDoAplicativoNextTela extends PaginaBase {

    public TermosECondicoesDeUsoDoAplicativoNextTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"fechar\"]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Fechar\"`]")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Termo de Adesão e Condições de Uso do Aplicativo Next")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Termo de Adesão e Condições de Uso do Aplicativo Next\"`]")
    private MobileElement termoDeAdesaoECondicoesDeUsoDoAplicativoNext;

    /**
     * Validar Titulo Tela 'Termos e Condições de Uso do Aplicativo Next'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Termos e Condições de Uso do Aplicativo Next'")
    public TermosECondicoesDeUsoDoAplicativoNextTela validarTituloTelaTermosECondicoesDeUsoDoAplicativoNext() throws Exception {
        String titulo = android ? (String.valueOf(TituloTermosECondicoes.TERMOS_E_CONDICOES_DE_USO_DO_APLICATIVO_NEXT).toUpperCase()) : String.valueOf(TituloTermosECondicoes.TERMOS_E_CONDICOES_DE_USO_DO_APLICATIVO_NEXT);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(titulo), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Termos e Condições de Uso do Aplicativo Next");
        salvarEvidencia("Validada Titulo Tela 'Termos e Condições de Uso do Aplicativo Next'");
        return this;
    }

    /**
     * Tocar botão 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Fechar'")
    public TermosECondicoesDeUsoDoAplicativoNextTela tocarFechar() throws Exception {
        tocarElemento(botaoFechar, "Erro ao tentar tocar no botao 'Fechar'");
        salvarEvidencia("Botão 'Fechar' tocado");
        return this;
    }
}
