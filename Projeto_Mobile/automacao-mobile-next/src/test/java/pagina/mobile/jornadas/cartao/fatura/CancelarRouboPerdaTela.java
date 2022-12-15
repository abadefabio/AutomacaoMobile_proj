package pagina.mobile.jornadas.cartao.fatura;

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

public class CancelarRouboPerdaTela extends PaginaBase {

    // botao SIM, IR PARA O CHAT
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "IR PARA O CHAT")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"IR PARA O CHAT\"]")
    private MobileElement botaoIrParaChat;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @AndroidFindBy(accessibility = "N�o")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    public CancelarRouboPerdaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao "IR PARA O CHAT"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao 'IR PARA O CHAT'")
    public CancelarRouboPerdaTela tocarIrParaChat() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoIrParaChat, "N�o foi poss�vel encontrar o botao 'IR PARA O CHAT'");
        tocarElemento(botaoIrParaChat, "N�o foi poss�vel tocar no botao 'IR PARA O CHAT'");
        salvarEvidencia("Tocar no botao 'IR PARA O CHAT'");
        return this;
    }

    /**
     * Tocar botao "Voltar"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Voltar\"")
    public CancelarRouboPerdaTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no botao \"Voltar\"");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no botao \"Voltar\"");
        return this;
    }

    /**
     * Validar presen�a da tela 'CANCELAR CART�O'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'CANCELAR CART�O'")
    public CancelarRouboPerdaTela validarTelaCancelarCartao() throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CANCELAR_CARTAO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'CANCELAR POR ROUBO OU PERDA' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'CANCELAR CART�O'");
        return this;
    }

    /**
     * Validar presen�a da tela 'Cancelar por roubo ou perda'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Cancelar por roubo ou perda'")
    public CancelarRouboPerdaTela validarTelaCancelarPorRouboOuPerda() throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CANCELAR_POR_ROUBO_OU_PERDA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'CANCELAR POR ROUBO OU PERDA' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'CANCELAR POR ROUBO OU PERDA'");
        return this;
    }
}
