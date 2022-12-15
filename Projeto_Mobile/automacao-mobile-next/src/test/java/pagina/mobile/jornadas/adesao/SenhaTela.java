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

public class SenhaTela extends PaginaBase {

    public SenhaTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Continuar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    //Solução paliativa para fechar o teclado do iOS
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@value, 'Agora escolhe uma senha')]")
    private MobileElement textoAgoraVoceEscolhe;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_password")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Senha\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`label == \"Senha\"`]")
    @iOSXCUITFindBy(accessibility = "Senha")
    private MobileElement campoSenha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_password_confirmation")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Confirma a senha\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`label == \"Confirmar a Senha\"`]")
    @iOSXCUITFindBy(accessibility= "Confirmar a Senha")
    private MobileElement campoConfirmaASenha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_eyes")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"exibir ocultar senha\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"icon eye\"`]")
    @iOSXCUITFindBy(accessibility = "icon eye")
    private MobileElement visualizarSenha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private MobileElement botaoOK;
    /**
     * Validar Titulo Tela 'Senha'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Senha'")
    public SenhaTela validarTituloTelaSenha() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.SENHA)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Senha' não está presente na tela!");
        salvarEvidencia("Validada tela 'Senha'");
        return this;
    }

    /**
     * Inserir senha 6 digitos do 'Cartão'
     *
     * @return
     * @throws Exception
     */
    @Step("Inserir senha 6 digitos do 'Cartão'")
    public SenhaTela inserirSenhaSeisDigitosDoCartao(String senhaCartao) throws Exception {
        escreverTexto(campoSenha, senhaCartao,false, "Não foi possivel escrever no campo 'Senha'");
        salvarEvidencia("Senha '"+ senhaCartao +"' inserida");
        return this;
    }

    /**
     * Confirmar senha 6 digitos do 'Cartão'
     *
     * @param confirmarSenhaCartao
     * @return
     * @throws Exception
     */
    @Step("Confirmar senha 6 digitos do 'Cartão'")
    public SenhaTela confirmarSenhaSeisDigitosDoCartao(String confirmarSenhaCartao) throws Exception {
        if(ios){
            tocarElemento(textoAgoraVoceEscolhe, "Não foi possível tocar no texto para fechar o teclado do iOS");
        }
        escreverTexto(campoConfirmaASenha, confirmarSenhaCartao, false,"Não foi possivel escrever no campo 'Confirma a Senha'");
       if(android){
           esconderTeclado();
       }
        salvarEvidencia("Confirmar Senha '"+ confirmarSenhaCartao +"' inserida");
        return this;
    }

    /**
     * Tocar botão 'Continuar' -> No caso do IOS foi mapeado o botão OK do teclado que é linkado com o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public SenhaTela tocarContinuar() throws Exception {
        if (ios){
            salvarEvidencia("Tocar botão 'Continuar'");
            tocarElemento(botaoOK,"Erro ao tentar tocar no botao 'Continuar'");
        }
        else{
            salvarEvidencia("Tocar botão 'Continuar'");
             tocarElemento(botaoContinuar, "Erro ao tentar tocar no botao 'Continuar'");
        }
        return this;
    }

    /**
     * Tocar icone de 'Visualizar Senha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar icone de 'Visualizar Senha'")
    public SenhaTela tocarVisualizarSenha() throws Exception {
        tocarElemento(visualizarSenha, "Erro ao tentar tocar no icone de 'Visualizar Senha'");
        salvarEvidencia("Icone 'Visualizar Senha' tocado");
        return this;
    }

}
