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
     * Tocar botão 'Fechar'
     *
     * @return ComprovanteTela
     * @throws Exception
     */
    @Step("Clicar botão \"Fechar\"")
    public ComprovanteTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar botão \"Fechar\"");
        tocarElemento(botaoFechar, "Erro ao executar a ação de tocar botão \"Fechar\"");
        return this;
    }

    /**
     * Tocar botão enviar comprovante por e-mail
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botãoo comprovante por email")
    public ComprovanteTela enviarComprovantePorEmail() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComprovantePorEmail, "Erro encontrada durante a tentativa de encontrar elemento \"Enviar Comprovante por e-mail\"");
        salvarEvidencia("Tocar botão enviar comprovante");
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
        salvarEvidencia("Tocar botão confirmar");
        tocarElemento(botaoConfirmarEnvioEmail, "Não foi possível tocar no botao confirmar");
        return this;
    }
}
