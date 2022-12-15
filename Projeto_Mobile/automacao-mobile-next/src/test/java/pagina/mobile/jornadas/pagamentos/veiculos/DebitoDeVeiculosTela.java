package pagina.mobile.jornadas.pagamentos.veiculos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import constantes.pagamentos.veiculos.MensagensEValidacoes;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DebitoDeVeiculosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_state")
    @AndroidFindBy(xpath = "//*[contains(@text, \"Estado\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"Estado\")]")
    private MobileElement comboboxEstado;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextView")
    @AndroidFindBy(accessibility = "Preencha os dados de pagamento abaixo")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"pagamento abaixo\")]")
    @iOSXCUITFindBy(accessibility = "Preencha os dados de pagamento abaixo")
    private MobileElement textoTelaDebitoVeiculos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_debit_type")
    @AndroidFindBy(xpath = "//*[contains(lower-case(@text), \"tipo de d�bito\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz'), \"tipo de d�bito\")]")
    private MobileElement comboboxTipoDebito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_renavam")
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"renavam\"]")
    @iOSXCUITFindBy(accessibility = "Renavam")

    private MobileElement campoRenavam;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_renavam_history")
    @AndroidFindBy(accessibility = "Bot�o Hist�rico de Renavans. Toque duplo para selecionar")
    @iOSXCUITFindBy(accessibility = "Hist�rico de Renavam")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"hist�rico de renavam\"]")
    private MobileElement iconeListaRenavam;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_payment_type")
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"tipo de pagamento\"]")
    @iOSXCUITFindBy(accessibility = "Tipo de pagamento")
    @iOSXCUITFindBy(xpath = "//*[contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz'), \"tipo de pagamento\")]")
    private MobileElement comboboxTipoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/check_box")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxyz') = \"d�bitos pendentes\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton")
    private MobileElement checkBoxMulta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"total\"]/../*[@resource-id = \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"R$\")]")
    private MobileElement campoTotal;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"continuar\"]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"continuar\"]")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Hoje ou próximo dia útil")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hoje ou próximo dia útil\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_today")
    private MobileElement checkBoxHojeOuProximoDiaUtil;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Agendar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Agendar\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_schedule")
    private MobileElement checkBoxAgendar;

    public DebitoDeVeiculosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no combo-box estado
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no combo-box estado")
    public DebitoDeVeiculosTela tocarComboBoxEstado() throws Exception {
        salvarEvidencia("Tocar combo-box estado");
        tocarElemento(comboboxEstado, "Ocorreu um erro ao executar a a��o de tocar o combo-box");
        return this;
    }

    /**
     * Tocar no combo-box tipo de d�bito
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no combo-box estado")
    public DebitoDeVeiculosTela tocarComboBoxTipoDebito() throws Exception {
        salvarEvidencia("Tocar combo-box tipo de d�bito");
        tocarElemento(comboboxTipoDebito, "Ocorreu um erro ao executar a a��o de tocar o combo-box");
        return this;
    }

    /**
     * Preencher campo renavam
     * @param renavam
     * @return DebitoDeVeiculosTela
     * @throws NextException
     */
    @Step("Preencher campo renavam")
    public DebitoDeVeiculosTela preencherCampoRenavam(String renavam) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoRenavam,"N�o foi possivel encontrar o campo Renavam");
        digitarTexto(campoRenavam, renavam);
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o continuar");
        salvarEvidencia("Preencher campo renavam com: " + renavam);
        return this;
    }

    /**
     * Tocar no �cone de pesquisa do renavam
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no �cone de pesquisa do renavam")
    public DebitoDeVeiculosTela tocarIconePesquisaRenavam() throws Exception {
        salvarEvidencia("Tocar no �cone de pesquisa do renavam");
        tocarElemento(iconeListaRenavam, "Ocorreu um erro ao executar a a��o de tocar o combo-box");
        return this;
    }

    /**
     * Tocar no combo-box tipo de pagamento
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no combo-box tipo de pagamento")
    public DebitoDeVeiculosTela tocarComboBoxTipoPagamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(comboboxTipoPagamento, "N�o foi poss�vel encontrar combo-box");
        salvarEvidencia("Tocar combo-box tipo de pagamento");
        tocarElemento(comboboxTipoPagamento, "Ocorreu um erro ao executar a a��o de tocar o combo-box");
        return this;
    }

    /**
     * Tocar no checkbox associado a multa
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no checkbox associado a multa")
    public DebitoDeVeiculosTela tocarCheckBoxMulta() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxMulta, "A multa n�o foi encontrada em tela");
        salvarEvidencia("Selecionar a multa");
        tocarElemento(checkBoxMulta, "Ocorreu um erro ao executar a a��o de selecionar o check-box da multa");
        return this;
    }

    /**
     * M�todo armazena o valor do atributo texto da valor total da transa��o em vari�vel do teste
     * @param valor
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("M�todo armazena o valor do atributo texto da valor total da transa��o em vari�vel do teste")
    public DebitoDeVeiculosTela recuperarValorTotal(ThreadLocal valor) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoTotal, "N�o foi poss�vel encontrar o campo total");
        valor.set(retornarTexto(campoTotal, "Ocorreu um erro ao tentar recuperar atributo texto do elemento referente ao valor total"));
        return this;
    }

    /**
     * Tocar bot�o "Continuar"
     *
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public DebitoDeVeiculosTela tocarBotaoContinuar() throws Exception {
        rolaTelaBaixo();
        salvarEvidencia("Tocar bot�o \"Continuar\"");
        tocarElemento(botaoContinuar, "N�o foi possivel tocar bot�o \"Continuar\"");
        return this;
    }

    /**
     * Validar texto "Preencha os dados de pagamento abaixo"
     *
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Validar texto \"Preencha os dados de pagamento abaixo\"")
    public DebitoDeVeiculosTela validarPresencaDebitoDeVeiculosTela() throws Exception {
        aguardarCarregamentoElemento(textoTelaDebitoVeiculos);
        validarAtributoTexto(textoTelaDebitoVeiculos, MensagensEValidacoes.PREENCHA_DADOS_PAGEMENTO.toString(), "Erro ao validar tela \"Preencha os dados de pagamento abaixo\"");
        salvarEvidencia("Validar texto \"Preencha os dados de pagamento abaixo\"");
        return this;
    }

    /**
     * Tocar bot�o "Tipo de Pagamento"
     *
     * @return DebitosDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Tipo de Pagamento\"")
    public DebitoDeVeiculosTela tocarComboBoxTipoDePagamento() throws Exception {
        tocarElemento(comboboxTipoPagamento, "N�o foi possivel tocar bot�o \"Tipo de Pagamento\"");
        salvarEvidencia("Tocar bot�o \"Tipo de Pagamento\"");
        return this;
    }

    /**
     * Tocar no checkbox Hoje ou Pr�ximo dia util
     * @return  DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no checkbox Hoje ou Pr�ximo dia util")
    public DebitoDeVeiculosTela tocarCheckBoxHojeOuProximoDiaUtil() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxHojeOuProximoDiaUtil, "O checkbox Hoje ou Pr�ximo dia �til n�o encontrada em tela");
        tocarElemento(checkBoxHojeOuProximoDiaUtil, "Ocorreu um erro ao executar ao  selecionar o check-box Hoje ou Pr�ximo dia util");
        salvarEvidencia("Selecionar checkbox Pr�ximo Dia util");
        return this;
    }

    /**
     * Tocar no checkbox Agendar
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no checkbox Agendar")
    public DebitoDeVeiculosTela tocarCheckBoxAgendar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxAgendar, "O checkbox Agendar n�o encontrada em tela");
        salvarEvidencia("Selecionar checkbox agendar");
        tocarElemento(checkBoxAgendar, "Ocorreu um erro ao executar ao  selecionar o check-box Agendar");
        return this;
    }

}
