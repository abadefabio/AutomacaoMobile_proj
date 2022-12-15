package pagina.web.contingencia.views.base;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.qameta.allure.Step;import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ContingenciaBaseTela extends PaginaBaseWeb {

    public ContingenciaBaseTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='next-label next-label--title-2']")
    protected WebElement tituloPagina;

    @FindBy(id = "backButton")
    protected WebElement botaoVoltar;

    @FindBy(id = "nextButton")
    protected WebElement botaoAvancar;

    @FindBys({
            @FindBy(xpath = "//div/span[contains(text(),'Sair')]"),
            @FindBy(xpath = "//*[contains(text(),'Sair')]/../..//button"),
    })
    protected WebElement botaoSair;

    @FindBy(css = ".styles-module_base__1ur3U")
    protected WebElement btnAjuda;


    @FindBy(id ="topLinkUserInfoIcon")
    protected WebElement btnPerfil;

    @FindBy(xpath = "//span[text()='Pagamento']")
    protected WebElement menuPagamento;

    @FindBy(xpath = "//span[text()='Transfer�ncia']")
    protected WebElement menuTransferencia;

    /**
     * Clicar em Perfil
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Perfil\"")
    public ContingenciaBaseTela clicarBotaoPerfil() throws Exception {
        aguardarCarregamentoElemento(btnPerfil);
        salvarEvidencia("Clicar em Perfil");
        clicarElemento(btnPerfil, "N�o foi poss�vel clicar no �cone do perfil (Meus Dados).");
        return this;
    }

    /**
     * Clicar em Ajuda
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Ajuda\"")
    public ContingenciaBaseTela clicarBotaoAjuda() throws Exception {
        aguardarCarregamentoElemento(btnAjuda);
        clicarElemento(btnAjuda, "N�o foi poss�vel clicar  em Ajuda");
        salvarEvidencia("Clicar em Ajuda");
        return this;
    }

    /**
     * Validar tela inicial presente atrav�s da valida��o do bot�o 'Sair'
     * @throws Exception
     */
    @Step("Validar tela inicial da Conting�ncia Web")
    public void validarTelaInicialContingenciaWeb() throws Exception {
        /*
        Validamos a tela inicial da Conting�ncia Web
        validando que o bot�o 'Sair' est� presente
         */
        aguardarCarregamentoElemento(botaoSair);
        salvarEvidencia("Validar tela inicial da Conting�ncia Web");
        validarCondicaoBooleana(verificarPresencaElemento(botaoSair), MetodoComparacaoBooleano.VERDADEIRO,
                                "N�o foi poss�vel validar a tela inicial da Conting�ncia Web");
    }

    /**
     * Efetuar logout do app Conting�ncia
     * @throws Exception
     */
    @Step("Sair da Conting�ncia")
    public void sairContingencia() throws Exception {
        aguardarCarregamentoElemento(botaoSair);
        salvarEvidencia("Sair da Conting�ncia");
        clicarElemento(botaoSair, "N�o foi poss�vel clicar no bot�o 'Sair'");
    }

    /**
    * Clicar no Menu Pagamento na Conting�ncia Web.
    * @throws Exception
    */
    @Step("Clicar no Menu Pagamento")
    public void clicarMenuPagamento() throws Exception {
        aguardarCarregamentoElemento(menuPagamento);
        salvarEvidencia("Clicar no menu de Pagamento");
        clicarElemento(menuPagamento, "N�o foi poss�vel clicar no bot�o de 'Pagamento' no menu lateral");
    }

    /**
     * Clicar no Menu Transfer�ncia na Conting�ncia Web.
     * @throws Exception
     */
    @Step("Clicar no Menu Transfer�ncia")
    public void clicarMenuTransferencia() throws Exception {
        aguardarCarregamentoElemento(menuTransferencia);
        clicarElemento(menuTransferencia, "N�o foi poss�vel clicar no menu de 'Transfer�ncia' no menu lateral");
        salvarEvidencia("Clicar no menu de Transfer�ncia");
    }


    /**
     * Validar se o o bot�o "voltar" aparece na p�gina de pagamento da conting�ncia web.
     * @throws Exception
     */
    @Step("Validar o bot�o 'voltar'")
    public ContingenciaBaseTela validarBotaoVoltarPagamento() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Validando bot�o 'voltar'");
        validarAtributoTexto(botaoVoltar, "Bot�o voltar pagamento", "N�o foi poss�vel validar o bot�o de voltar na tela Pagamento");
        return this;
    }

        /**
         * Validar se o o bot�o "avan�ar" aparece na p�gina de pagamento da conting�ncia web.
         * @throws Exception
         */
        @Step("Validar o bot�o 'avan�ar'")
        public ContingenciaBaseTela validarBotaoAvancarPagamento() throws Exception {
            aguardarCarregamentoElemento(botaoAvancar);
            salvarEvidencia("Validando bot�o 'avan�ar'");
            validarAtributoTexto(botaoAvancar,"Bot�o avan�ar pagamento", "N�o foi poss�vel validar o bot�o de avan�ar na tela Pagamento");
            return this;
        }
}
