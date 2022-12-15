package pagina.mobile.jornadas.portabilidade;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermosCondicoes extends PaginaBase {

    //Titulo Termos e Condições
    @AndroidFindBy(accessibility = "TERMOS E CONDIÇÕES")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement tituloTermosCondicoes;

    //Checkbox "Confirmo Solicitação"
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[@value='Selecionar']")
    private MobileElement checkboxConfirmoSolicitacao;

    //Botão 'Continuar' da tela termo
    @AndroidFindBy( id = "br.com.bradesco.next:id/bt_accept")
    @iOSXCUITFindBy(accessibility = "Avançar")
    private MobileElement botaoContinuar;

    //Checkbox "Texto Modal 'Você Já Cadastrou CPF/CNPJ'"
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @iOSXCUITFindBy(accessibility = "Você já cadastrou esse CPF/CNPJ pra trazer seu salário pro next.")
    private MobileElement textoModalVoceJaCadastrouCpfCnpj;

    public TermosCondicoes(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar checkbox "Confirmar Solicitação"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar checkbox \"Confirmar Solicitação\"")
    public TermosCondicoes tocarCheboxConfirmoSolicitacao() throws Exception{
        aguardarCarregamentoElemento(checkboxConfirmoSolicitacao);
        rolaTelaBaixo();
        aguardarCarregamentoElemento(checkboxConfirmoSolicitacao);
        tocarElemento(checkboxConfirmoSolicitacao, "Não foi possível clicar no checkbox \"Confirmo a solicitação\"");
        salvarEvidencia("Tocar no checkbox \"Confirmo a solicitação\"");
        return this;
    }

    /**
     * Tocar botão continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TermosCondicoes tocarBotaoContinuar() throws Exception{
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "Não foi possível tocar o botão \"Continuar\"");
        aguardarCarregamentoElemento(textoModalVoceJaCadastrouCpfCnpj);
        salvarEvidencia("Tocar no botão \"Continuar\"");
        return this;
    }

}
