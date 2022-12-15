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

    // botao SIM, USAR ESTE ENDEREÇO
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(accessibility = "Ação de confirmação, sim, usar este endereço")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Ação de confirmação, sim, usar este endereço\"]")
    @iOSXCUITFindBy(accessibility = "USAR ESTE ENDEREÇO")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"USAR ESTE ENDEREÇO\"]")
    private MobileElement botaoUsarEsteEndereco;

    // botao QUERO MUDAR O ENDEREÇO
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_update_address")
    @AndroidFindBy(accessibility = "Ação de negação, não, quero mudar meu endereço, botão")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Ação de negação, não, quero mudar meu endereço, botão\"]")
    @iOSXCUITFindBy(accessibility = "ALTERAR MEU ENDEREÇO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ALTERAR MEU ENDEREÇO\"]")
    private MobileElement botaoAlterarMeuEndereco;

    public ConfirmarEnderecoSegundaViaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Confirmar endereço'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela 'CONFIRMAR ENDEREÇO'")
    public ConfirmarEnderecoSegundaViaTela validarTelaConfirmarEnderecoDeSegundaVia() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CONFIRMAR_ENDERECO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'CONFIRMAR ENDEREÇO' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'CONFIRMAR ENDEREÇO'");
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
        tocarElemento(botaoUsarEsteEndereco, "Não foi possível tocar no botao \"USAR ESTE ENDERECO\"");
        return this;
    }

    /**
     * Tocar botao "ALTERAR MEU ENDEREÇO"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"ALTERAR MEU ENDEREÇO\"")
    public ConfirmarEnderecoSegundaViaTela tocarAlterarMeuEndereco() throws Exception {
        aguardarElementoHabilitado(botaoAlterarMeuEndereco);
        salvarEvidencia("Tocar no botao \"ALTERAR MEU ENDEREÇO\"");
        tocarElemento(botaoAlterarMeuEndereco, "Não foi possível tocar no botao 'ALTERAR MEU ENDEREÇO'");
        return this;
    }
}
