package pagina.mobile.jornadas.configuracoes.perfil.APP;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.configuracoes.perfil.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.sql.Driver;

public class TrocarSenhaAppTela extends PaginaBase {

    public TrocarSenhaAppTela(AppiumDriver driver) {
        super(driver);
    }

    //campo senha do app
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_password")
    @iOSXCUITFindBy(accessibility = "Campo de texto editávelSenha")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Senha')]")
    private MobileElement preencherSenha;

    //botao continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue")
    @AndroidFindBy(xpath = "//*[contains(@text,'CONTINUAR')]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CONTINUAR')]")
    private MobileElement botaoContinuar;

    //campo nova senha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_password")
    @iOSXCUITFindBy(accessibility = "Nova Senha")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Nova Senha')]")
    private MobileElement preencherNovaSenha;

    //campo confirmar nova senha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_confirm_password")
    @iOSXCUITFindBy(accessibility = "Confirmar nova senha")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Confirmar nova senha']")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Confirmar nova senha')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"Confirmar nova senha\"]")
    private MobileElement preencherConfirmarNovaSenha;

    //botao confirmar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_confirm")
    @AndroidFindBy(xpath = "//*[contains(@text,'CONFIRMAR')]")
    @iOSXCUITFindBy(accessibility = "CONFIRMAR")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CONFIRMAR')]")
    private MobileElement botaoConfirmar;


    /**
     * Validar que esta na tela Trocar senha do App
     * fr
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Trocar senha do App\"")
    public TrocarSenhaAppTela validarTelaTrocarSenhaApp() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TROCAR_SENHA_APP.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Trocar senha do APP' não está presente na tela!");
        salvarEvidencia("Validado tela Trocar senha do App'!");
        return this;
    }

    /**
     * Preencher senha
     * fr
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Senha\"")
    public TrocarSenhaAppTela preencherSenha(String senha) throws Exception{
        salvarEvidencia("Preencher campo 'Senha'");
        if(android) {
            digitarTexto(preencherSenha,senha);
            salvarEvidencia("Preencher campo 'Senha'");
        } else {
            escreverTexto(preencherSenha, senha, "Erro ao preencher campo senha");
            salvarEvidencia("Preencher campo 'Senha'");
        }
        return this;
    }

    /**
     * Tocar botão Continuar
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TrocarSenhaAppTela tocarBotaoContinuar() throws Exception{
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar,"Não foi possível tocar botão Continuar");
        return this;
    }

    /**
     * Preencher  nova senha
     * fr
     * @return
     * @throws Exception
     */
    @Step("Preencher \" Nova Senha\"")
    public TrocarSenhaAppTela preencherNovaSenha(String novaSenha) throws Exception{

        aguardarCarregamentoElemento(preencherNovaSenha);
        if(android){
            digitarTexto(preencherNovaSenha,novaSenha);
            salvarEvidencia("Preencher campo 'Nova Senha'");
        } else {
            escreverTexto(preencherNovaSenha, novaSenha, "Erro ao preencher campo nova senha");
            salvarEvidencia("Preencher campo 'Nova Senha'");
        }
        return this;
    }

    /**
     * Preencher Confirmar Nova Senha
     * fr
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Confirmar Nova Senha\"")
    public TrocarSenhaAppTela preencherConfirmarNovaSenha(String confirmarSenha) throws Exception{

        if(android){
            digitarTexto(preencherConfirmarNovaSenha,confirmarSenha);
            salvarEvidencia("Preencher campo 'Confirmar nova Senha'");
        } else {
            escreverTexto(preencherConfirmarNovaSenha, confirmarSenha, "Erro ao preencher campo confirmar nova senha");
            salvarEvidencia("Preencher campo 'Confirmar nova Senha'");
        }
        return this;
    }

    /**
     * Tocar botão Confirmar
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Confirmar\"")
    public TrocarSenhaAppTela tocarBotaoConfirmar() throws Exception{
        salvarEvidencia("Tocar botão 'Confirmar'");
        tocarElemento(botaoConfirmar,"Não foi possível tocar botão Confirmar");
        return this;
    }

    public TrocarSenhaAppTela aguardarCampoNovaSenha()throws Exception{
        esperarCarregando();
        return this;
    }

}
