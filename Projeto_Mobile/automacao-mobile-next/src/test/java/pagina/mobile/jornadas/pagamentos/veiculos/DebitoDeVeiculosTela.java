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
    @AndroidFindBy(xpath = "//*[contains(lower-case(@text), \"tipo de débito\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz'), \"tipo de débito\")]")
    private MobileElement comboboxTipoDebito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_renavam")
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"renavam\"]")
    @iOSXCUITFindBy(accessibility = "Renavam")

    private MobileElement campoRenavam;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_renavam_history")
    @AndroidFindBy(accessibility = "Botão Histórico de Renavans. Toque duplo para selecionar")
    @iOSXCUITFindBy(accessibility = "Histórico de Renavam")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"histórico de renavam\"]")
    private MobileElement iconeListaRenavam;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_payment_type")
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"tipo de pagamento\"]")
    @iOSXCUITFindBy(accessibility = "Tipo de pagamento")
    @iOSXCUITFindBy(xpath = "//*[contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz'), \"tipo de pagamento\")]")
    private MobileElement comboboxTipoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/check_box")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxyz') = \"débitos pendentes\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton")
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
    @iOSXCUITFindBy(accessibility = "Hoje ou prÃ³ximo dia Ãºtil")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hoje ou prÃ³ximo dia Ãºtil\"]")
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
        tocarElemento(comboboxEstado, "Ocorreu um erro ao executar a ação de tocar o combo-box");
        return this;
    }

    /**
     * Tocar no combo-box tipo de débito
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no combo-box estado")
    public DebitoDeVeiculosTela tocarComboBoxTipoDebito() throws Exception {
        salvarEvidencia("Tocar combo-box tipo de débito");
        tocarElemento(comboboxTipoDebito, "Ocorreu um erro ao executar a ação de tocar o combo-box");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoRenavam,"Não foi possivel encontrar o campo Renavam");
        digitarTexto(campoRenavam, renavam);
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão continuar");
        salvarEvidencia("Preencher campo renavam com: " + renavam);
        return this;
    }

    /**
     * Tocar no ícone de pesquisa do renavam
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no ícone de pesquisa do renavam")
    public DebitoDeVeiculosTela tocarIconePesquisaRenavam() throws Exception {
        salvarEvidencia("Tocar no ícone de pesquisa do renavam");
        tocarElemento(iconeListaRenavam, "Ocorreu um erro ao executar a ação de tocar o combo-box");
        return this;
    }

    /**
     * Tocar no combo-box tipo de pagamento
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no combo-box tipo de pagamento")
    public DebitoDeVeiculosTela tocarComboBoxTipoPagamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(comboboxTipoPagamento, "Não foi possível encontrar combo-box");
        salvarEvidencia("Tocar combo-box tipo de pagamento");
        tocarElemento(comboboxTipoPagamento, "Ocorreu um erro ao executar a ação de tocar o combo-box");
        return this;
    }

    /**
     * Tocar no checkbox associado a multa
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no checkbox associado a multa")
    public DebitoDeVeiculosTela tocarCheckBoxMulta() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxMulta, "A multa não foi encontrada em tela");
        salvarEvidencia("Selecionar a multa");
        tocarElemento(checkBoxMulta, "Ocorreu um erro ao executar a ação de selecionar o check-box da multa");
        return this;
    }

    /**
     * Método armazena o valor do atributo texto da valor total da transação em variável do teste
     * @param valor
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Método armazena o valor do atributo texto da valor total da transação em variável do teste")
    public DebitoDeVeiculosTela recuperarValorTotal(ThreadLocal valor) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoTotal, "Não foi possível encontrar o campo total");
        valor.set(retornarTexto(campoTotal, "Ocorreu um erro ao tentar recuperar atributo texto do elemento referente ao valor total"));
        return this;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public DebitoDeVeiculosTela tocarBotaoContinuar() throws Exception {
        rolaTelaBaixo();
        salvarEvidencia("Tocar botão \"Continuar\"");
        tocarElemento(botaoContinuar, "Não foi possivel tocar botão \"Continuar\"");
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
     * Tocar botão "Tipo de Pagamento"
     *
     * @return DebitosDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Tipo de Pagamento\"")
    public DebitoDeVeiculosTela tocarComboBoxTipoDePagamento() throws Exception {
        tocarElemento(comboboxTipoPagamento, "Não foi possivel tocar botão \"Tipo de Pagamento\"");
        salvarEvidencia("Tocar botão \"Tipo de Pagamento\"");
        return this;
    }

    /**
     * Tocar no checkbox Hoje ou Próximo dia util
     * @return  DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no checkbox Hoje ou Próximo dia util")
    public DebitoDeVeiculosTela tocarCheckBoxHojeOuProximoDiaUtil() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxHojeOuProximoDiaUtil, "O checkbox Hoje ou Próximo dia útil não encontrada em tela");
        tocarElemento(checkBoxHojeOuProximoDiaUtil, "Ocorreu um erro ao executar ao  selecionar o check-box Hoje ou Próximo dia util");
        salvarEvidencia("Selecionar checkbox Próximo Dia util");
        return this;
    }

    /**
     * Tocar no checkbox Agendar
     * @return DebitoDeVeiculosTela
     * @throws Exception
     */
    @Step("Tocar no checkbox Agendar")
    public DebitoDeVeiculosTela tocarCheckBoxAgendar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxAgendar, "O checkbox Agendar não encontrada em tela");
        salvarEvidencia("Selecionar checkbox agendar");
        tocarElemento(checkBoxAgendar, "Ocorreu um erro ao executar ao  selecionar o check-box Agendar");
        return this;
    }

}
