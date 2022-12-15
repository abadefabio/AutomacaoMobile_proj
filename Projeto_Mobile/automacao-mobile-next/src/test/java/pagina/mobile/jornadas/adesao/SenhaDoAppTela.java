package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class SenhaDoAppTela extends PaginaBase {

    public SenhaDoAppTela(AppiumDriver driver){
        super(driver);
    }

    //botao voltar <
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    //botao continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @AndroidFindBy(xpath = "//*[contains(@text,\"CONTINUAR\")]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"CONTINUAR\")]")
    private MobileElement botaoContinuar;

    // campo Senha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_password")
    @iOSXCUITFindBy(accessibility = "Senha")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"Senha\"]")
    private MobileElement campoSenha;

    // campo Confirme Senha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/et_password_confirmation\"])[2]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_password_confirmation")
    @iOSXCUITFindBy(accessibility = "Confirmar Senha")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Confirmar Senha\")]")
    private MobileElement campoConfirmeSenha;

    //botao mostrar senha - Olho
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Mostrar senha\"])[1]")
    @iOSXCUITFindBy(xpath = "//(//XCUIElementTypeButton[@name=\"Mostrar senha\"])[2]")
    private MobileElement botaoMostarSenha;

    /**
     * Tocar botao Voltar ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Voltar <\"")
    public SenhaDoAppTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("'Tocar botao Voltar'");
        tocarElemento(botaoVoltar, "Erro ao Tocar botao Voltar");
        return this;
    }

    /**
     * validar titulo da tela Senha do APP
     * fr
     * @return
     * @throws Exception
     */
    @Step("validar tela  \"Senha do APP\"")
    public SenhaDoAppTela validarTituloSenhaApp() throws Exception {
        esperarCarregando();
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.SENHA_DO_APP.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Senha do App' não está presente na tela!");
        salvarEvidencia("validar que esta na tela de 'SENHA DO APP'");
        rolarTelaAteFinal();
        return this;
    }

    /**
     * Tocar botao Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Continuar\"")
    public SenhaDoAppTela tocarBotaoContinuar() throws Exception {
        if (ios){
            tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar' do teclado");
        }
        tocarElemento(botaoContinuar, "Erro ao Tocar botao Continuar");
        salvarEvidencia("'Tocar botao Continuar'");
        return this;
    }

    /**
     * preencher Senha
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Senha\"")
    public SenhaDoAppTela preencherSenha(String senha) throws Exception {
        if (ios){
            escreverTexto(campoSenha,senha, "Erro ao preencher campo Senha");
        }else {
            digitarTexto(campoSenha, senha);
        }
        salvarEvidencia("'Preencher campo Senha'");
        return this;
    }


    /**
     * preencher Confirme Senha
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Confirme Senha\"")
    public SenhaDoAppTela preencherConfirmeSenha(String confirmeSenha) throws Exception {
        if (ios){
            escreverTexto(campoConfirmeSenha,confirmeSenha, "Erro ao preencher campo Confirme Senha");
        }else {
            digitarTexto(campoConfirmeSenha,confirmeSenha);
        }
        esconderTeclado();
        salvarEvidencia("'Preencher campo Confirme Senha'");
        return this;
    }


}
