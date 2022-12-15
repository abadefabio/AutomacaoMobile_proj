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
    @AndroidFindBy(xpath = "//*[@text='Código de pagamento PIX']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_pix_input_key")
    @iOSXCUITFindBy(xpath = "//*[@name='Código de pagamento Pix']")
    private MobileElement labelCodigoPagamentoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/cl_text_field']/descendant::*[@resource-id='br.com.bradesco.next:id/ntf_pix_input_key']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_pix_input_key")
    @iOSXCUITFindBy(xpath = "//*[@name='Código de pagamento Pix']")
    private MobileElement campoCodigoPagamentoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='AVANÇAR']")
    @AndroidFindBy(xpath = "//*[@text='Avançar']")
    @iOSXCUITFindBy(xpath = "//*[@name='AVANÇAR']")
    private MobileElement botaoAvancar;

    public CopiaColaTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Preencher campo 'Código de pagamento PIX'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Preencher campo 'Código de pagamento PIX'")
    public CopiaColaTela preencherCampoCodigoPagamentoPix(String codigoPagamentoPix) throws Exception {
        aguardarCarregamentoElemento(labelCodigoPagamentoPix);
        tocarElemento(labelCodigoPagamentoPix, "Não foi possível tocar no label 'Código de pagamento PIX'");
        if(ios){
            escreverTexto(campoCodigoPagamentoPix, codigoPagamentoPix, "Não foi possível preencher o campo 'Código de pagamento PIX'");
        }else {
            tocarElemento(campoCodigoPagamentoPix, "Não foi possível tocar no campo 'Código de pagamento PIX'");
            digitarTexto(campoCodigoPagamentoPix, codigoPagamentoPix);
        }
        salvarEvidencia("Preencher no campo 'Código de pagamento PIX' o código: " + codigoPagamentoPix);
        return this;
    }

    /**
     * Tocar no botão 'Avançar'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Avançar'")
    public CopiaColaTela tocarBotaoAvancar() throws NextException {
        aguardarCarregamentoElemento(botaoAvancar);
        salvarEvidencia("Tocar no botão 'Avançar'");
        tocarElemento(botaoAvancar, "Não foi possível tocar no botão 'Avançar'");
        return this;
    }
}
