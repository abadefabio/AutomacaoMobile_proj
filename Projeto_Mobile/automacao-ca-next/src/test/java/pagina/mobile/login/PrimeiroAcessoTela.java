package pagina.mobile.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class PrimeiroAcessoTela extends PaginaBase {

    public PrimeiroAcessoTela(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextView29")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"Yeah! Agora você\"")
    private MobileElement mensagemBoasVindas;

    //Botão Pular no tutorial do primeiro acesso ao app
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_skip")
    @iOSXCUITFindBy(accessibility = "PULAR")
    private MobileElement botaoPular;


    /**
     * Validar mensagem de boas vindas exibida no primeiro acesso
     *
     * @param mensagem
     * @return PrimeiroAcessoTela
     * @throws Exception
     */
    @Step("Validar mensagem de boas vindas exibida no primeiro acesso")
    public PrimeiroAcessoTela validarMensagemPrimeiroAcesso(String mensagem) throws Exception {
        aguardarCarregamentoElemento(mensagemBoasVindas);
        compararElementoTexto(mensagemBoasVindas, mensagem, MetodoComparacao.IGUAL);
        salvarEvidencia("Validar exibição do texto: \"" + mensagem + "\" no primeiro acesso");
        return this;
    }

    /**
     * Clicar botão 'Pular tutorial primeiro acesso'
     *
     * @return PrimeiroAcessoTela
     * @throws Exception
     */
    @Step("Clicar botão \"Pular Tutorial\"")
    public PrimeiroAcessoTela tocarBotaoPular() throws Exception {
        aguardarCarregamentoElemento(botaoPular);
        tocarElemento(botaoPular, "Não foi possível clicar no botão Pular - Tutorial de primeiro acesso ao App");
        OperadorEvidencia.logarPasso("Tocar no botão 'Pular");
        return this;
    }
}
