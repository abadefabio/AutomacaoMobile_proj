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
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"DESCRIÇÃO\")]")
    @iOSXCUITFindBy(accessibility = "Descrição")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Descrição\"`]")
    private MobileElement campoDescricao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_current_account")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"Conta Corrente\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\" Conta corrente, \")]")
    private MobileElement botaoRadioContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_savings_account")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Conta Poupança')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Conta poupança')]")
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
     * Validar presença da tela 'Boleto Edição'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Boleto'")
    public BoletoEdicaoTela validarPresencaBoletoTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.BOLETO, Mensagem.DESCRICAO), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Boleto' e mensagem 'Descrição' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela 'Boleto Edição'");
        return this;
    }

    /**
     * Preencher campo 'Descrição'
     *
     * @param descricao
     * @return
     * @throws Exception
     */
    @Step("Preencher campo descrição")
    public BoletoEdicaoTela preencherCampoDescricao(String descricao) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoDescricao, "Não foi possível encontrar o campo 'Descrição'");
        escreverTexto(campoDescricao, descricao, "Não foi possível preencher o campo 'Descrição'");
        salvarEvidencia("Preenchido campo 'Descrição' com " + descricao);
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRadioContaCorrente, "Não foi possível encontrar o botão radio 'Conta Corrente'");
        tocarElemento(botaoRadioContaCorrente, "Não foi possível Selecionar 'Conta Corrente'");
        salvarEvidencia("Selecionado 'Conta Corrente'");
        return this;
    }

    /**
     * Selecionar 'Conta Poupança'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar 'Conta Poupança'")
    public BoletoEdicaoTela selecionarContaPoupanca() throws Exception {
        tocarElemento(botaoRadioContaPoupanca, "Não foi possível Selecionar 'Conta Poupança'");
        salvarEvidencia("Selecionado 'Conta Poupança'");
        return this;
    }

    /**
     * Tocar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public BoletoEdicaoTela tocarbotaoContinuar() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }
}
