package pagina.mobile.jornadas.pagamentos.codigo.barras.boleto;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pagamentos.Mensagem;
import constantes.pagamentos.TituloTela;
import framework.AcoesGerais;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class BoletoEdicaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_description")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"DESCRI��O\")]")
    @iOSXCUITFindBy(accessibility = "Descri��o")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Descri��o\"`]")
    private MobileElement campoDescricao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_current_account")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"Conta Corrente\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\" Conta corrente, \")]")
    private MobileElement botaoRadioContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_savings_account")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Conta Poupan�a')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Conta poupan�a')]")
    private MobileElement botaoRadioContaPoupanca;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_confirm")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Continuar')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continuar'`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continuar']")
    private MobileElement botaoContinuar;

    public BoletoEdicaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Boleto Edi��o'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Boleto'")
    public BoletoEdicaoTela validarPresencaBoletoTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.BOLETO, Mensagem.DESCRICAO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Boleto' e mensagem 'Descri��o' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela 'Boleto Edi��o'");
        return this;
    }

    /**
     * Preencher campo 'Descri��o'
     *
     * @param descricao
     * @return
     * @throws Exception
     */
    @Step("Preencher campo descri��o")
    public BoletoEdicaoTela preencherCampoDescricao(String descricao) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoDescricao, "N�o foi poss�vel encontrar o campo 'Descri��o'");
        escreverTexto(campoDescricao, descricao, "N�o foi poss�vel preencher o campo 'Descri��o'");
        salvarEvidencia("Preenchido campo 'Descri��o' com " + descricao);
        new AcoesGerais((AppiumDriver) driver)
                .esconderTeclado();
        return this;
    }

    /**
     * Selecionar 'Conta Corrente'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar 'Conta Corrente'")
    public BoletoEdicaoTela selecionarContaCorrente() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRadioContaCorrente, "N�o foi poss�vel encontrar o bot�o radio 'Conta Corrente'");
        tocarElemento(botaoRadioContaCorrente, "N�o foi poss�vel Selecionar 'Conta Corrente'");
        salvarEvidencia("Selecionado 'Conta Corrente'");
        return this;
    }

    /**
     * Selecionar 'Conta Poupan�a'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar 'Conta Poupan�a'")
    public BoletoEdicaoTela selecionarContaPoupanca() throws Exception {
        tocarElemento(botaoRadioContaPoupanca, "N�o foi poss�vel Selecionar 'Conta Poupan�a'");
        salvarEvidencia("Selecionado 'Conta Poupan�a'");
        return this;
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public BoletoEdicaoTela tocarbotaoContinuar() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }
}
