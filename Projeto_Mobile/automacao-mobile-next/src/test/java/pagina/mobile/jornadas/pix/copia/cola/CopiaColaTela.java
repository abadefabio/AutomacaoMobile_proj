package pagina.mobile.jornadas.pix.copia.cola;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CopiaColaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='C�digo de pagamento PIX']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_pix_input_key")
    @iOSXCUITFindBy(xpath = "//*[@name='C�digo de pagamento Pix']")
    private MobileElement labelCodigoPagamentoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/cl_text_field']/descendant::*[@resource-id='br.com.bradesco.next:id/ntf_pix_input_key']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_pix_input_key")
    @iOSXCUITFindBy(xpath = "//*[@name='C�digo de pagamento Pix']")
    private MobileElement campoCodigoPagamentoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='AVAN�AR']")
    @AndroidFindBy(xpath = "//*[@text='Avan�ar']")
    @iOSXCUITFindBy(xpath = "//*[@name='AVAN�AR']")
    private MobileElement botaoAvancar;

    public CopiaColaTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Preencher campo 'C�digo de pagamento PIX'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Preencher campo 'C�digo de pagamento PIX'")
    public CopiaColaTela preencherCampoCodigoPagamentoPix(String codigoPagamentoPix) throws Exception {
        aguardarCarregamentoElemento(labelCodigoPagamentoPix);
        tocarElemento(labelCodigoPagamentoPix, "N�o foi poss�vel tocar no label 'C�digo de pagamento PIX'");
        if(ios){
            escreverTexto(campoCodigoPagamentoPix, codigoPagamentoPix, "N�o foi poss�vel preencher o campo 'C�digo de pagamento PIX'");
        }else {
            tocarElemento(campoCodigoPagamentoPix, "N�o foi poss�vel tocar no campo 'C�digo de pagamento PIX'");
            digitarTexto(campoCodigoPagamentoPix, codigoPagamentoPix);
        }
        salvarEvidencia("Preencher no campo 'C�digo de pagamento PIX' o c�digo: " + codigoPagamentoPix);
        return this;
    }

    /**
     * Tocar no bot�o 'Avan�ar'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Avan�ar'")
    public CopiaColaTela tocarBotaoAvancar() throws NextException {
        aguardarCarregamentoElemento(botaoAvancar);
        salvarEvidencia("Tocar no bot�o 'Avan�ar'");
        tocarElemento(botaoAvancar, "N�o foi poss�vel tocar no bot�o 'Avan�ar'");
        return this;
    }
}
