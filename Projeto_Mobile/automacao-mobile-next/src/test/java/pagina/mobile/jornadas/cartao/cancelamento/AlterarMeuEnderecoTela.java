package pagina.mobile.jornadas.cartao.cancelamento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AlterarMeuEnderecoTela extends PaginaBase {

    // botao SIM, IR PARA O CHAT
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_chat")
    @AndroidFindBy(accessibility = "SIM, IR PARA O CHAT")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"SIM, IR PARA O CHAT\"]")
    @iOSXCUITFindBy(accessibility = "IR PARA O CHAT")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"IR PARA O CHAT\"]")
    private MobileElement botaoIrParaChat;

    public AlterarMeuEnderecoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'ALTERAR MEU ENDEREÇO'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela 'ALTERAR MEU ENDEREÇO'")
    public AlterarMeuEnderecoTela validarTelaAlterarMeuEndereco() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.ALTERAR_ENDERECO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'ALTERAR MEU ENDEREÇO' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'ALTERAR MEU ENDEREÇO'");
        return this;
    }

    /**
     * Tocar botao "SIM, IR PARA O CHAT"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"SIM, IR PARA O CHAT\"")
    public AlterarMeuEnderecoTela tocarIrParaChat() throws Exception {
        aguardarElementoHabilitado(botaoIrParaChat);
        salvarEvidencia("Tocar no botao 'SIM, IR PARA O CHAT'");
        tocarElemento(botaoIrParaChat, "Não foi possível tocar no botao 'SIM, IR PARA O CHAT'!");
        return this;
    }
}
