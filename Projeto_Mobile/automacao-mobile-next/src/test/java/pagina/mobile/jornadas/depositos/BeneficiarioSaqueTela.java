package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class BeneficiarioSaqueTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_circle")
    @iOSXCUITFindBy(accessibility = "Opção selecionável, Próprio,")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name][1]")
    private MobileElement botaoProprio;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Outro beneficiário']")
    @iOSXCUITFindBy(accessibility = "Opção selecionável, Outro beneficiário,")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Opção selecionável, Outro beneficiário, \"]")
    private MobileElement botaoOutroBeneficiario;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_beneficiary")
    @iOSXCUITFindBy(accessibility = "Beneficiário")
    private MobileElement campoBeneficiario;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_cpf")
    @iOSXCUITFindBy(accessibility = "Buscar")
    private MobileElement cpfBeneficiario;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_apply")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoApply;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continuar']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement continuar;

    public BeneficiarioSaqueTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Selecionar opcao de quem realizara o saque
     *
     * @return AgendamentoSaqueTela
     * @throws Exception
     */
    @Step("Selecionar opcao Proprio")
    public BeneficiarioSaqueTela selecionarOpcaoProprio() throws Exception {
        aguardarCarregamentoElemento(botaoProprio);
        salvarEvidencia("Selecionar opcao Proprio");
        tocarElemento(botaoProprio, "Nao foi possível selecionar opcao Proprio");
        return this;
    }

    /**
     * Tocar em Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao \"Continuar\"")
    public BeneficiarioSaqueTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(continuar);
        salvarEvidencia("Tocar botão 'Continuar'");
        try {
            tocarElemento(continuar, "Não foi possível tocar botão 'Continuar'");
        } catch (Exception e) {
            tocarElemento(continuar, "Não foi possível tocar botão 'Continuar'");
        }
        return this;
    }

    /**
     * Selecionar em outro beneficiario
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar opcao Outro Beneficiario")
    public BeneficiarioSaqueTela tocarOutroBeneficiario() throws NextException {
        aguardarCarregamentoElemento(botaoOutroBeneficiario);
        salvarEvidencia("Selecionar opcao Outro Beneficiario");
        tocarElemento(botaoOutroBeneficiario, "Não foi possível selecionar opção Outro Beneficiário");
        return this;
    }

    /**
     * Tocar Campo Beneficiario
     *
     * @return AgendamentoSaqueTela
     * @throws Exception
     */
    public BeneficiarioSaqueTela tocarCampoBeneficiario() throws Exception {
        aguardarCarregamentoElemento(campoBeneficiario);
        salvarEvidencia("Tocar campo Outro Beneficiário");
        tocarElemento(campoBeneficiario, "Não foi possível tocar no campo Beneficiário");
        return this;
    }

    /**
     * Preencher campo CPF/CNPJ beneficiario
     *
     * @return AgendamentoSaqueTela
     * @throws Exception
     */
    public BeneficiarioSaqueTela preencherCampoCpfCnpjBeneficiario(String cpfcnpjBeneficiario) throws Exception {
        escreverTexto(cpfBeneficiario, cpfcnpjBeneficiario, "Erro ao preencher CPF");
        salvarEvidencia("Preencher campo CPF/CNPJ Beneficiário com: " + cpfcnpjBeneficiario);
        return this;
    }

    /**
     * tocar em na opção Apply
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao apply")
    public BeneficiarioSaqueTela tocarBotaoApply() throws NextException {
        aguardarCarregamentoElemento(botaoApply);
        salvarEvidencia("Tocar botao apply");
        tocarElemento(botaoApply, "Não foi possível confirmar o CPF do Beneficiário");
        return this;
    }
}
