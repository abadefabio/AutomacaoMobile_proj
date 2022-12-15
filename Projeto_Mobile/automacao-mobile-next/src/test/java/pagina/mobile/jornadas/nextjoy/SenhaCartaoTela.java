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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='Confirme a senha do cart�o']")
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
     * @param senha Senha a ser inserida no cart�o
     * @return SenhaCartaoTela
     * @throws NextException
     */
    @Step("Preencher campo 'Senha'")
    public SenhaCartaoTela preencherCampoSenha(String senha) throws Exception {
        aguardarCarregamentoElemento(campoSenha);
        if(ios) escreverTexto(campoSenha, senha, true, "N�o foi poss�vel escrever o texto no campo 'Senha'");
        else digitarTexto(campoSenha, senha);
        salvarEvidencia("Preencher campo 'Senha'");
        // Solu��o paliativa at� ser implementado o mapeamento do bot�o continuar do teclado no framework
        if (ios) {
            tocarElemento(botaoContinuar, "N�o foi oss�vel tocar no bot�o continuar do teclado");
        }
        return this;
    }

    /**
     * Preencher campo 'Confirma senha'
     *
     * @param senha Confirma��o de senha do cart�o
     * @return SenhaCartaoTela
     * @throws NextException
     */
    @Step("Preencher campo 'Confirma senha'")
    public SenhaCartaoTela preencherCampoConfirmeSenhaCartao(String senha) throws Exception {
        aguardarCarregamentoElemento(campoConfirmaSenha);
        if(ios) escreverTexto(campoConfirmaSenha, senha, true, "N�o foi poss�vel escrever o texto no campo 'Confirme a senha do cart�o'");
        else digitarTexto(campoConfirmaSenha, senha);
        salvarEvidencia("Preencher campo 'Confirme a senha do cart�o'");
        // Solu��o paliativa at� ser implementado o mapeamento do bot�o continuar do teclado no framework
        if (ios) {
            tocarElemento(botaoContinuar, "N�o foi oss�vel tocar no bot�o continuar do teclado");
        }
        return this;
    }

    /**
     * Tocar no bot�o 'Continuar'
     *
     * @return SenhaCartaoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Continuar'")
    public SenhaCartaoTela tocarBotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "N�o foi poss�vel encontrar o bot�o 'Continuar'");
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }
}
