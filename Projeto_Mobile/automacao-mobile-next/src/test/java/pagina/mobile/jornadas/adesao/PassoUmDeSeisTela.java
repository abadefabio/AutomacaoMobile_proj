package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class PassoUmDeSeisTela extends PaginaBase {

    public PassoUmDeSeisTela(AppiumDriver driver){
        super(driver);
    }

    //botao Dados preencher dados pessoais
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"PREENCHER DADOS PESSOAIS\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PREENCHER DADOS PESSOAIS\"]")
    private MobileElement botaoPreencherDadosPessoais;

    //botao OK cadastrar endereco
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK, CADASTRAR ENDEREÇO\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK, CADASTRAR ENDEREÇO\"]")
    private MobileElement botaoOkCadastrarEndereco;

    //botao TERMINAR MAIS TARDE
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_finish_later")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"TERMINAR MAIS TARDE\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"TERMINAR MAIS TARDE\"]")
    private MobileElement botaoTerminarMaisTarde;

    /**
     * Tocar botao 'Preencher Dados pessoais'
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Preencher Dados pessoais\"")
    public PassoUmDeSeisTela tocarBotaoDadosPessoais() throws Exception {
        salvarEvidencia("'Tocar botao Preencher Dados pessoais'");
        tocarElemento(botaoPreencherDadosPessoais, "Erro ao Tocar botao Preencher Dados pessoais");
        return this;
    }

    /**
     * Tocar botao 'OK Cadastar endereco'
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"OK Cadastar endereco\"")
    public PassoUmDeSeisTela tocarBotaoOkCadastrarEndereco() throws Exception {
        salvarEvidencia("'Tocar botao OK Cadastar endereco'");
        tocarElemento(botaoOkCadastrarEndereco, "Erro ao Tocar botao OK Cadastar endereco");
        return this;
    }

    /**
     * Tocar botao 'Terminar Mais Tarde'
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Terminar Mais Tarde\"")
    public PassoUmDeSeisTela tocarTerminarMaisTarde() throws Exception {
        salvarEvidencia("'Tocar botao Terminar Mais Tarde'");
        tocarElemento(botaoTerminarMaisTarde, "Erro ao Tocar botao Terminar Mais Tarde");
        return this;
    }
}
