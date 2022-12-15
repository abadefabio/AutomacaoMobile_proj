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
    @AndroidFindBy(accessibility = "Não")
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoIrParaChat, "Não foi possível encontrar o botao 'IR PARA O CHAT'");
        tocarElemento(botaoIrParaChat, "Não foi possível tocar no botao 'IR PARA O CHAT'");
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
        tocarElemento(botaoVoltar, "Não foi possível tocar no botao \"Voltar\"");
        return this;
    }

    /**
     * Validar presença da tela 'CANCELAR CARTÃO'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela 'CANCELAR CARTÃO'")
    public CancelarRouboPerdaTela validarTelaCancelarCartao() throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CANCELAR_CARTAO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'CANCELAR POR ROUBO OU PERDA' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'CANCELAR CARTÃO'");
        return this;
    }

    /**
     * Validar presença da tela 'Cancelar por roubo ou perda'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela 'Cancelar por roubo ou perda'")
    public CancelarRouboPerdaTela validarTelaCancelarPorRouboOuPerda() throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CANCELAR_POR_ROUBO_OU_PERDA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'CANCELAR POR ROUBO OU PERDA' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'CANCELAR POR ROUBO OU PERDA'");
        return this;
    }
}
