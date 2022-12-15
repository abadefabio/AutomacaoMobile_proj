package pagina.mobile.jornadas.adesao;

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

public class MaisDetalhesTela extends PaginaBase {

    public MaisDetalhesTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"fechar\"]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Fechar\"`]")
    private MobileElement botaoFechar;

    /**
     * Validar Titulo Tela 'Mais Detalhes'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Mais Detalhes'")
    public MaisDetalhesTela validarTituloTelaMaisDetalhes() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.MAIS_DETALHES)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Mais Detalhes' não está presente na tela!");
        salvarEvidencia("Validada tela 'Mais Detalhes'");
        return this;
    }

    /**
     * Tocar botão 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Fechar'")
    public MaisDetalhesTela tocarFechar() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão 'Fechar'");
        tocarElemento(botaoFechar, "Erro ao tentar tocar no botao 'Fechar'");
        return this;
    }

}
