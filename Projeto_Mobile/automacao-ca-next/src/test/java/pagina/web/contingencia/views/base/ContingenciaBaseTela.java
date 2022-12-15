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

    @FindBy(xpath = "//span[text()='Transferência']")
    protected WebElement menuTransferencia;

    /**
     * Clicar em Perfil
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Perfil\"")
    public ContingenciaBaseTela clicarBotaoPerfil() throws Exception {
        aguardarCarregamentoElemento(btnPerfil);
        salvarEvidencia("Clicar em Perfil");
        clicarElemento(btnPerfil, "Não foi possível clicar no ícone do perfil (Meus Dados).");
        return this;
    }

    /**
     * Clicar em Ajuda
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Ajuda\"")
    public ContingenciaBaseTela clicarBotaoAjuda() throws Exception {
        aguardarCarregamentoElemento(btnAjuda);
        clicarElemento(btnAjuda, "Não foi possível clicar  em Ajuda");
        salvarEvidencia("Clicar em Ajuda");
        return this;
    }

    /**
     * Validar tela inicial presente através da validação do botão 'Sair'
     * @throws Exception
     */
    @Step("Validar tela inicial da Contingência Web")
    public void validarTelaInicialContingenciaWeb() throws Exception {
        /*
        Validamos a tela inicial da Contingência Web
        validando que o botão 'Sair' está presente
         */
        aguardarCarregamentoElemento(botaoSair);
        salvarEvidencia("Validar tela inicial da Contingência Web");
        validarCondicaoBooleana(verificarPresencaElemento(botaoSair), MetodoComparacaoBooleano.VERDADEIRO,
                                "Não foi possível validar a tela inicial da Contingência Web");
    }

    /**
     * Efetuar logout do app Contingência
     * @throws Exception
     */
    @Step("Sair da Contingência")
    public void sairContingencia() throws Exception {
        aguardarCarregamentoElemento(botaoSair);
        salvarEvidencia("Sair da Contingência");
        clicarElemento(botaoSair, "Não foi possível clicar no botão 'Sair'");
    }

    /**
    * Clicar no Menu Pagamento na Contingência Web.
    * @throws Exception
    */
    @Step("Clicar no Menu Pagamento")
    public void clicarMenuPagamento() throws Exception {
        aguardarCarregamentoElemento(menuPagamento);
        salvarEvidencia("Clicar no menu de Pagamento");
        clicarElemento(menuPagamento, "Não foi possível clicar no botão de 'Pagamento' no menu lateral");
    }

    /**
     * Clicar no Menu Transferência na Contingência Web.
     * @throws Exception
     */
    @Step("Clicar no Menu Transferência")
    public void clicarMenuTransferencia() throws Exception {
        aguardarCarregamentoElemento(menuTransferencia);
        clicarElemento(menuTransferencia, "Não foi possível clicar no menu de 'Transferência' no menu lateral");
        salvarEvidencia("Clicar no menu de Transferência");
    }


    /**
     * Validar se o o botão "voltar" aparece na página de pagamento da contingência web.
     * @throws Exception
     */
    @Step("Validar o botão 'voltar'")
    public ContingenciaBaseTela validarBotaoVoltarPagamento() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Validando botão 'voltar'");
        validarAtributoTexto(botaoVoltar, "Botão voltar pagamento", "Não foi possível validar o botão de voltar na tela Pagamento");
        return this;
    }

        /**
         * Validar se o o botão "avançar" aparece na página de pagamento da contingência web.
         * @throws Exception
         */
        @Step("Validar o botão 'avançar'")
        public ContingenciaBaseTela validarBotaoAvancarPagamento() throws Exception {
            aguardarCarregamentoElemento(botaoAvancar);
            salvarEvidencia("Validando botão 'avançar'");
            validarAtributoTexto(botaoAvancar,"Botão avançar pagamento", "Não foi possível validar o botão de avançar na tela Pagamento");
            return this;
        }
}
