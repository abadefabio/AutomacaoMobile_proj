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

public class ConfirmarEnderecoSegundaViaTela extends PaginaBase {

    // botao SIM, USAR ESTE ENDERE�O
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(accessibility = "A��o de confirma��o, sim, usar este endere�o")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"A��o de confirma��o, sim, usar este endere�o\"]")
    @iOSXCUITFindBy(accessibility = "USAR ESTE ENDERE�O")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"USAR ESTE ENDERE�O\"]")
    private MobileElement botaoUsarEsteEndereco;

    // botao QUERO MUDAR O ENDERE�O
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_update_address")
    @AndroidFindBy(accessibility = "A��o de nega��o, n�o, quero mudar meu endere�o, bot�o")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"A��o de nega��o, n�o, quero mudar meu endere�o, bot�o\"]")
    @iOSXCUITFindBy(accessibility = "ALTERAR MEU ENDERE�O")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ALTERAR MEU ENDERE�O\"]")
    private MobileElement botaoAlterarMeuEndereco;

    public ConfirmarEnderecoSegundaViaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Confirmar endere�o'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'CONFIRMAR ENDERE�O'")
    public ConfirmarEnderecoSegundaViaTela validarTelaConfirmarEnderecoDeSegundaVia() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CONFIRMAR_ENDERECO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'CONFIRMAR ENDERE�O' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'CONFIRMAR ENDERE�O'");
        return this;
    }

    /**
     * Tocar botao "USAR ESTE ENDERECO"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"USAR ESTE ENDERECO\"")
    public ConfirmarEnderecoSegundaViaTela tocarUsarEsteEndereco() throws Exception {
        aguardarElementoHabilitado(botaoUsarEsteEndereco);
        salvarEvidencia("Tocar no botao \"USAR ESTE ENDERECO\"");
        tocarElemento(botaoUsarEsteEndereco, "N�o foi poss�vel tocar no botao \"USAR ESTE ENDERECO\"");
        return this;
    }

    /**
     * Tocar botao "ALTERAR MEU ENDERE�O"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"ALTERAR MEU ENDERE�O\"")
    public ConfirmarEnderecoSegundaViaTela tocarAlterarMeuEndereco() throws Exception {
        aguardarElementoHabilitado(botaoAlterarMeuEndereco);
        salvarEvidencia("Tocar no botao \"ALTERAR MEU ENDERE�O\"");
        tocarElemento(botaoAlterarMeuEndereco, "N�o foi poss�vel tocar no botao 'ALTERAR MEU ENDERE�O'");
        return this;
    }
}
