package pagina.mobile.jornadas.comprovantes.investimentos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.comprovantes.MensagensComprovantes;
import constantes.comprovantes.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ExtratoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_email")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Enviar por e-mail\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(accessibility = "sendReceiptByEmail")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"sendReceiptByEmail\"]")
    private MobileElement botaoEnviarPorEmail;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_visualize")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ok\"]")
    private MobileElement botaoOk;

    public ExtratoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presenca da tela 'EXTRATO'
      * @return
     */
    @Step("Validar presença da tela 'EXTRATO'")
    public ExtratoTela validarPresencaTelaExtrato() {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EXTRATO), MetodoComparacaoBooleano.VERDADEIRO, "Titulo 'EXTRATO' nao esta presente na tela!");
        salvarEvidencia("Validada presenca da tela 'EXTRATO'");
        return this;
    }

    /**Tocar no botao 'Enviar por e-mail'
     * @return
     * @throws Exception
     */
    public ExtratoTela tocarBotaoEnviarPorEmail() throws Exception {

        salvarEvidencia("Comprovante pronto para ser enviado!");
        tocarElemento(botaoEnviarPorEmail,"Nao foi possivel tocar no botão 'Enviar por e-mail'!");
        return this;
    }

    /**
     * Validar mensagem 'Extrato enviado pra:'
     * @return
     * @throws Exception
     */
    public ExtratoTela validarMensagemExtratoEnviado() {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(MensagensComprovantes.EXTRATO_ENVIADO)), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Extrat enviado pra:' nao esta presente na tela!");
        return this;
    }

    /**
     * Tocar botão 'OK'
     * @return
     * @throws Exception
     */
    public ExtratoTela tocarBotaoOk() throws Exception {

        salvarEvidencia("Tocar no botão 'OK'!");
        tocarElemento(botaoOk,"Nao foi possivel tocar no botão 'OK'!");
        return this;
    }

}
