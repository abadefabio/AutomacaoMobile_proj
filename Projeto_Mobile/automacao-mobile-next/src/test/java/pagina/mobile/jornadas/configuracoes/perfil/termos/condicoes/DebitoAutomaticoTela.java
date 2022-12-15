package pagina.mobile.jornadas.configuracoes.perfil.termos.condicoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.configuracoes.perfil.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class DebitoAutomaticoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Voltar, Bot�o\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_document_send_by_email")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enviar por e-mail']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Enviar por e-mail\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Enviar por e-mail\"`]")
    private MobileElement botaoEnviarEmail;


    public DebitoAutomaticoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar Bot�o "Voltar"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public DebitoAutomaticoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o Voltar");
        return this;
    }


    /**
     * Validar "titulo da tela"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela")
    public DebitoAutomaticoTela validarTituloTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.DEBITO_AUTOMATICO)),
                MetodoComparacaoBooleano.VERDADEIRO, "N�o foi possivel validar tela d�bito autom�tico");
        aguardarPaginaConterTodosTextos("Condi��es Gerais");
        salvarEvidencia("Validar titulo da tela");
        return this;

    }

    /**
     * Validar botao "Enviar por email"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Botao Enviar Email")
    public DebitoAutomaticoTela validarBotaoEnviarEmail() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Validar bot�o 'Enviar Email'");
        aguardarExistenciaElemento(botaoEnviarEmail);
        return this;
    }
}


