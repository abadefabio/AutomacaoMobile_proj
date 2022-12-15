package pagina.mobile.jornadas.pagamentos.veiculos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import constantes.pagamentos.veiculos.MensagensEValidacoes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class AvisoImportanteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='A emissão do licenciamento agora é digital.']")
    @iOSXCUITFindBy(accessibility = "A emissão do licenciamento agora é digital.")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"A emissão do licenciamento agora é digital.\"")
    private MobileElement mensagemAvisoImportanteTela;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK, ENTENDI']")
    @iOSXCUITFindBy(accessibility = "OK, ENTENDI")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK, ENTENDI\"`]")
    private MobileElement botaoOKEntendi;

    public AvisoImportanteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar mensagem da tela de Aviso Importante "A emissão do licenciamento agora é digital."
     *
     * @return AvisoImportanteTela
     * @throws Exception
     */
    @Step("Validar mensagem da tela de Aviso Importante \"A emissão do licenciamento agora é digital.\"")
    public AvisoImportanteTela validarMensagemAvisoImportante() throws Exception {
        aguardarCarregamentoElemento(mensagemAvisoImportanteTela);
        validarAtributoTexto(mensagemAvisoImportanteTela, MensagensEValidacoes.AVISO_IMPORTANTE.toString(), "Erro ao validar mensagem da tela de Aviso Importante \"A emissão do licenciamento agora é digital.\"");
        salvarEvidencia("Validar mensagem da tela de Aviso Importante \"A emissão do licenciamento agora é digital.\"");
        return this;
    }

    /**
     * Tocar botão "OK Entendi"
     *
     * @return AvisoImportanteTela
     * @throws Exception
     */
    @Step("Tocar botão \"OK Entendi\"")
    public AvisoImportanteTela tocarbotaoOKEntendi() throws NextException {
        salvarEvidencia("Tocar botão \"OK Entendi\"");
        tocarElemento(botaoOKEntendi, "Ocorreu um erro inesperado ao tentar tocar botão \"OK Entendi\"");
        return this;
    }
}
