package pagina.mobile.jornadas.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.login.LoginApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeiroAcessoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextView29")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"Yeah! Agora voc�\"")
    private MobileElement mensagemBoasVindas;

    //Bot�o Pular no tutorial do primeiro acesso ao app
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_skip")
    @iOSXCUITFindBy(accessibility = "PULAR")
    private MobileElement botaoPular;

    public PrimeiroAcessoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Validar mensagem de boas vindas exibida no primeiro acesso
     *
     * @param mensagem
     * @return PrimeiroAcessoTela
     * @throws Exception
     */
    @Step("Validar mensagem de boas vindas exibida no primeiro acesso")
    public PrimeiroAcessoTela validarMensagemPrimeiroAcesso(String mensagem) throws Exception {
        String textoEncontrado = aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_TELA_BOAS_VINDAS);
        validarCondicaoBooleana(textoEncontrado.isBlank(),MetodoComparacaoBooleano.FALSO, "A massa utilizada n�o � de primeiro acesso.");
        aguardarCarregamentoElemento(mensagemBoasVindas);
        compararElementoTexto(mensagemBoasVindas, mensagem, MetodoComparacao.IGUAL);
        salvarEvidencia("Validar exibi��o do texto: \"" + mensagem + "\" no primeiro acesso");
        return this;
    }

    /**
     * Retornar booleano verificando se est� na tela de primeiro acesso
     */
    @Step("Retornar booleano verificando se est� na tela de primeiro acesso")
    public boolean estaNaTelaPrimeiroAcesso() {
        String textoEncontrado = aguardarPaginaConterQualquerTexto(3, LoginApp.LISTA_PALAVRAS_TELA_BOAS_VINDAS);
        return !textoEncontrado.isBlank();
    }

    /**
     * Clicar bot�o 'Pular tutorial primeiro acesso'
     *
     * @return PrimeiroAcessoTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Pular Tutorial\"")
    public PrimeiroAcessoTela tocarBotaoPular() throws Exception {
        aguardarCarregamentoElemento(botaoPular);
        OperadorEvidencia.logarPasso("Tocar no bot�o 'Pular'");
        tocarElemento(botaoPular, "N�o foi poss�vel clicar no bot�o Pular - Tutorial de primeiro acesso ao App");
        return this;
    }
}
