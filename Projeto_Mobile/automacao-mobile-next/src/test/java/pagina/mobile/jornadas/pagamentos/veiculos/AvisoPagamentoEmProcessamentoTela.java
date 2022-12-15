package pagina.mobile.jornadas.pagamentos.veiculos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;


import static java.time.Duration.ofSeconds;

public class AvisoPagamentoEmProcessamentoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"O Pagamento está em Processamento\"]/../*[@resource-id= \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(accessibility = "O Pagamento está em Processamento")
    private MobileElement textoOPagamentoEstaEmProcessamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"O comprovante estará disponível em até 30 minutos em:\"]/../*[@resource-id= \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(accessibility = "O comprovante estará disponível em até 30 minutos em:")
    private MobileElement textoOComprovanteEstaraDisponivelEmAteTrintaMinutosEm;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"Menu > Comprovantes e Extratos > Comprovantes > Pagamento > Débitos de Veículos:\"]/../*[@resource-id= \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(accessibility = "Menu > Comprovantes e Extratos > Comprovantes > Pagamento > Débitos de Veículos")
    private MobileElement textoRotaComprovante;


    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Ok")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"Ok\"]")
    @AndroidFindBy(accessibility ="br.com.bradesco.next:id/bt_continue")
    private MobileElement botaoOk;

    public AvisoPagamentoEmProcessamentoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Validar texto Pagamento Está em Processamento
     * @return
     */
    @Step("Validar exibição do texto Pagamento Esta Em Processamento")
    public AvisoPagamentoEmProcessamentoTela validarExibicaoTextoPagamentoEstaEmProcessamento(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoOPagamentoEstaEmProcessamento), MetodoComparacaoBooleano.VERDADEIRO, "Texto Pagamento Em Processamento não está presente na tela!");
        salvarEvidencia("Validar exibição do texto Pagamento Esta Em Processamento");
        return this;
    }

    /**
     * Validar texto O comprovante estará disponivel em até 30 minutos em:
     * @return
     */
    @Step("Validar exibição do texto O comprovante estará disponivel em até 30 minutos em:")
    public AvisoPagamentoEmProcessamentoTela validarTextoAdicional(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoOComprovanteEstaraDisponivelEmAteTrintaMinutosEm), MetodoComparacaoBooleano.VERDADEIRO, "Texto adicional não está presente na tela!");
        salvarEvidencia("Validar exibição do texto O comprovante estará disponivel em até 30 minutos em:");
        return this;
    }

    /**
     * Validar texto Menu > Comprovantes e Extratos > Comprovantes > Pagamento > Débitos de Veículos
     * @return
     */
    @Step("Validar exibição da rota Menu > Comprovantes e Extratos > Comprovantes > Pagamento > Débitos de Veículos")
    public AvisoPagamentoEmProcessamentoTela validarTextoRotaInformativa(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoRotaComprovante), MetodoComparacaoBooleano.VERDADEIRO, "Texto da rota Menu > Comprovantes e Extratos > Comprovantes > Pagamento > Débitos de Veículos não está visivel na tela");
        salvarEvidencia("Validar exibição do texto Menu > Comprovantes e Extratos > Comprovantes > Pagamento > Débitos de Veículos");
        return this;
    }

    /**
     * Tocar botão 'OK'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'OK'")
    public AvisoPagamentoEmProcessamentoTela tocarNoBotaoOk() throws Exception {
        tocarElemento(botaoOk, "Não foi possivel tocar o botão 'OK'");
        salvarEvidencia("Tocar botão 'OK'");
        return this;
    }



}
