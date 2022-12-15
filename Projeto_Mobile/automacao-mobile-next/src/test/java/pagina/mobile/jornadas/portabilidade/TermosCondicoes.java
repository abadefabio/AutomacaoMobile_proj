package pagina.mobile.jornadas.portabilidade;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermosCondicoes extends PaginaBase {

    //Titulo Termos e Condi��es
    @AndroidFindBy(accessibility = "TERMOS E CONDI��ES")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement tituloTermosCondicoes;

    //Checkbox "Confirmo Solicita��o"
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[@value='Selecionar']")
    private MobileElement checkboxConfirmoSolicitacao;

    //Bot�o 'Continuar' da tela termo
    @AndroidFindBy( id = "br.com.bradesco.next:id/bt_accept")
    @iOSXCUITFindBy(accessibility = "Avan�ar")
    private MobileElement botaoContinuar;

    //Checkbox "Texto Modal 'Voc� J� Cadastrou CPF/CNPJ'"
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @iOSXCUITFindBy(accessibility = "Voc� j� cadastrou esse CPF/CNPJ pra trazer seu sal�rio pro next.")
    private MobileElement textoModalVoceJaCadastrouCpfCnpj;

    public TermosCondicoes(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar checkbox "Confirmar Solicita��o"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar checkbox \"Confirmar Solicita��o\"")
    public TermosCondicoes tocarCheboxConfirmoSolicitacao() throws Exception{
        aguardarCarregamentoElemento(checkboxConfirmoSolicitacao);
        rolaTelaBaixo();
        aguardarCarregamentoElemento(checkboxConfirmoSolicitacao);
        tocarElemento(checkboxConfirmoSolicitacao, "N�o foi poss�vel clicar no checkbox \"Confirmo a solicita��o\"");
        salvarEvidencia("Tocar no checkbox \"Confirmo a solicita��o\"");
        return this;
    }

    /**
     * Tocar bot�o continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public TermosCondicoes tocarBotaoContinuar() throws Exception{
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar o bot�o \"Continuar\"");
        aguardarCarregamentoElemento(textoModalVoceJaCadastrouCpfCnpj);
        salvarEvidencia("Tocar no bot�o \"Continuar\"");
        return this;
    }

}
