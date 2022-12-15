package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SenhaCartaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_password")
    @AndroidFindBy(xpath = "//android.widget.EditText/child::*[@resource-id='br.com.bradesco.next:id/ntf_password']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='Senha']")
    private MobileElement campoSenha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_password_confirmation")
    @AndroidFindBy(xpath = "//android.widget.EditText/child::*[@resource-id='br.com.bradesco.next:id/ntf_password_confirmation']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='Confirme a senha do cartão']")
    private MobileElement campoConfirmaSenha;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='CONTINUAR'])[1]")
    private MobileElement botaoContinuar;

    public SenhaCartaoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Preencher campo 'Senha'
     *
     * @param senha Senha a ser inserida no cartão
     * @return SenhaCartaoTela
     * @throws NextException
     */
    @Step("Preencher campo 'Senha'")
    public SenhaCartaoTela preencherCampoSenha(String senha) throws Exception {
        aguardarCarregamentoElemento(campoSenha);
        if(ios) escreverTexto(campoSenha, senha, true, "Não foi possível escrever o texto no campo 'Senha'");
        else digitarTexto(campoSenha, senha);
        salvarEvidencia("Preencher campo 'Senha'");
        // Solução paliativa até ser implementado o mapeamento do botão continuar do teclado no framework
        if (ios) {
            tocarElemento(botaoContinuar, "Não foi ossível tocar no botão continuar do teclado");
        }
        return this;
    }

    /**
     * Preencher campo 'Confirma senha'
     *
     * @param senha Confirmação de senha do cartão
     * @return SenhaCartaoTela
     * @throws NextException
     */
    @Step("Preencher campo 'Confirma senha'")
    public SenhaCartaoTela preencherCampoConfirmeSenhaCartao(String senha) throws Exception {
        aguardarCarregamentoElemento(campoConfirmaSenha);
        if(ios) escreverTexto(campoConfirmaSenha, senha, true, "Não foi possível escrever o texto no campo 'Confirme a senha do cartão'");
        else digitarTexto(campoConfirmaSenha, senha);
        salvarEvidencia("Preencher campo 'Confirme a senha do cartão'");
        // Solução paliativa até ser implementado o mapeamento do botão continuar do teclado no framework
        if (ios) {
            tocarElemento(botaoContinuar, "Não foi ossível tocar no botão continuar do teclado");
        }
        return this;
    }

    /**
     * Tocar no botão 'Continuar'
     *
     * @return SenhaCartaoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Continuar'")
    public SenhaCartaoTela tocarBotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "Não foi possível encontrar o botão 'Continuar'");
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }
}
