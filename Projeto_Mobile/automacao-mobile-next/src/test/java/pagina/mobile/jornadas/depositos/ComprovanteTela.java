package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ComprovanteTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"COMPROVANTE\"`]/XCUIElementTypeButton")
    private MobileElement botaoFechar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_send_by_email")
    @iOSXCUITFindBy(accessibility = "Enviar por e-mail")
    private MobileElement botaoComprovantePorEmail;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_confirm")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmarEnvioEmail;

    public ComprovanteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o 'Fechar'
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Fechar\"")
    public ComprovanteTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar bot�o \"Fechar\"");
        tocarElemento(botaoFechar, "Erro ao executar a a��o de tocar bot�o \"Fechar\"");
        return this;
    }

    /**
     * Tocar bot�o enviar comprovante por e-mail
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�oo comprovante por email")
    public ComprovanteTela enviarComprovantePorEmail() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComprovantePorEmail, "Erro encontrada durante a tentativa de encontrar elemento \"Enviar Comprovante por e-mail\"");
        salvarEvidencia("Tocar bot�o enviar comprovante");
        tocarElemento(botaoComprovantePorEmail, "Erro ao tocar no botao enviar comprovante");
        return this;
    }

    /**
     * Tocar confirmar envio de e-mail
     *
     * @return
     */
    public ComprovanteTela tocarBotaoConfirmarEnvioEmail() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmarEnvioEmail);
        salvarEvidencia("Tocar bot�o confirmar");
        tocarElemento(botaoConfirmarEnvioEmail, "N�o foi poss�vel tocar no botao confirmar");
        return this;
    }
}
