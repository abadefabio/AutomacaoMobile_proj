package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosCreditoTelefones;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TelefonesUteisCreditoTela extends PaginaBase {

    public TelefonesUteisCreditoTela(AppiumDriver driver) {
        super(driver);
    }


    // botão VOLTAR da tela TELEFONES UTEIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarTelefonesUteis;

    // Texto TELEFONES UTEIS 1 ;
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/insurance_phone_phone' and contains(@text, '0800 275 6398')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'0800 275 6398')]")
    private MobileElement textoTelefonesUteis1;

    // Texto TELEFONES UTEIS 2
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/insurance_phone_phone' and contains(@text, '0800 727 9988')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'0800 727 9988')]")
    private MobileElement textoTelefonesUteis2;

    // Texto TELEFONES UTEIS 3
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/insurance_phone_phone' and contains(@text, '0800 722 0099')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'0800 722 0099')]")
    private MobileElement textoTelefonesUteis3;

    // Texto TELEFONES UTEIS 4
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/insurance_phone_phone' and contains(@text, '0800 727 9933')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'0800 727 9933')]")
    private MobileElement textoTelefonesUteis4;

    /**
     * Método para validar a Tela de Telefones Úteis
     * @param textoTelefones1
     * @param textoTelefones2
     * @param textoTelefones3
     * @param textoTelefones4
     * @return TelefonesUteisCreditoTela
     * @throws Exception
     */
    @Step("Validar Tela de Telefones Úteis - DÉBITO")
    public TelefonesUteisCreditoTela validaTelaTelefonesUteisCredito(SegurosCreditoTelefones textoTelefones1, SegurosCreditoTelefones textoTelefones2, SegurosCreditoTelefones textoTelefones3, SegurosCreditoTelefones textoTelefones4) throws Exception {
        compararElementoTexto(textoTelefonesUteis1, textoTelefones1, MetodoComparacao.IGUAL);
        compararElementoTexto(textoTelefonesUteis2, textoTelefones2, MetodoComparacao.IGUAL);
        compararElementoTexto(textoTelefonesUteis3, textoTelefones3, MetodoComparacao.IGUAL);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoTelefonesUteis4,"Texto TELEFONES ÚTEIS 4 não foi carregado");
        compararElementoTexto(textoTelefonesUteis4, textoTelefones4, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela TELEFONES ÚTEIS - CRÉDITO");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     * @return TelefonesUteisCreditoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public TelefonesUteisCreditoTela tocarBotaoVoltarTelaTelefonesUteis() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarTelefonesUteis);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarTelefonesUteis, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
