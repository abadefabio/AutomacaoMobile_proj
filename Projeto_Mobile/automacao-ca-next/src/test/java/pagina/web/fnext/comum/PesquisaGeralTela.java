package pagina.web.fnext.comum;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PesquisaGeralTela extends PaginaBaseWeb {


    @FindBy(xpath = "//div[text()=' Pesquisa Geral ']")
    private WebElement tituloPesquisaGeral;

    @FindBy(xpath = "//input[@formcontrolname=\"numberCpf\"]")
    private WebElement campoCpf;

    @FindBy(xpath = "//input[@formcontrolname=\"proposalUid\"]")
    private WebElement campoTrackingId;

    @FindBy(xpath = "//input[@formcontrolname=\"addressEmail\"]")
    private WebElement campoEmail;

    @FindBy(xpath = "//button[. = \" Pesquisar \"]")
    private WebElement botaoPesquisar;

    @FindBy(xpath = "//*[@class=\"mat-cell cdk-column-CPF-do-solicitante mat-column-CPF-do-solicitante ng-star-inserted\"]")
    private WebElement cpfSolicitante;

    @FindBy(xpath = "//*[@ng-reflect-message=\"Editar\"]")
    private WebElement botaoEditarProposta;

    @FindBy(xpath = "//button[text()=' Finalizar ']")
    private WebElement botaoFinalizar;

    @FindBy(xpath = "//*[@class=\"fa fa-power-off link-logout\"]")
    private WebElement botaoLogout;

    @FindBy(xpath = "//*[contains(@class, \"A-conta-foi-aberta\") and (text()=\"N�O \")]")
    private WebElement aContaFoiAbertaNao;

    @FindBy(xpath = "//td[text()='APROVADO MOTOR']")
    private WebElement resultadoDaEtapa;

    @FindBy(xpath = "//td[text()='REPROVADO MOTOR']")
    private WebElement resultadoDaEtapaReprovadoMotor;

    public PesquisaGeralTela(WebDriver driver) {
        super(driver);
    }


    /**
     * Validar T�tulo da Pesquisa Geral
     *
     * @return
     * @throws Exception
     */
    @Step("Validar T�tulo da Tela")
    public PesquisaGeralTela validarTituloPesquisaGeral(String titulo) throws Exception {
        aguardarCarregamentoElemento(tituloPesquisaGeral);
        compararElementoTexto(tituloPesquisaGeral,titulo, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar t�tulo da Pesquisa Geral");
        return this;
    }

    /**
     * Preencher campo CPF na Pesquisa Geral
     *
     * @param cpf
     * @return
     * @throws Exception
     */
    @Step("Preencher campo CPF")
    public PesquisaGeralTela preencherCpf(String cpf) throws Exception {
        aguardarCarregamentoElemento(campoCpf);
        digitarTexto(campoCpf, cpf, "Erro ao preencher CPF na pesquisa geral");
        salvarEvidencia("Preencher CPF para pesquisa");
        return this;
    }

    /**
     * Preencher campo Tracking ID na Pesquisa Geral
     *
     * @param trackingID
     * @return
     * @throws Exception
     */
    @Step("Preencher campo Tracking ID")
    public PesquisaGeralTela preencherTrackingId(String trackingID) throws Exception {
        aguardarCarregamentoElemento(campoTrackingId);
        digitarTexto(campoTrackingId, trackingID, "Erro ao preencher Tracking ID na pesquisa geral");
        salvarEvidencia("Preencher Tracking ID para pesquisa");
        return this;
    }

    /**
     * Preencher campo E-mail na Pesquisa Geral
     *
     * @param email
     * @return
     * @throws Exception
     */
    @Step("Preencher campo E-mail")
    public PesquisaGeralTela preencherEmail(String email) throws Exception {
        aguardarCarregamentoElemento(campoEmail);
        digitarTexto(campoEmail, email, "Erro ao preencher E-mail na pesquisa geral");
        salvarEvidencia("Preencher E-mail");
        return this;
    }

    /**
     * Clicar no bot�o Pesquisar na Pesquisa Geral
     *
     * @throws Exception
     */
    @Step("Clicar no bot�o Pesquisar")
    public PesquisaGeralTela clicarBotaoPesquisar() throws Exception {
        aguardarElementoClicavel(botaoPesquisar);
        clicarElemento(botaoPesquisar, "Erro ao clicar no bot�o Pesquisar");
        aguardarCarregamentoElemento(cpfSolicitante);
        salvarEvidencia("Clicar no bot�o Pesquisar");
        return this;
    }

    /**
     * Validar resultado da Pesquisa por CPF
     *
     * @throws Exception
     */
    @Step("Validar resultado da Pesquisa por CPF")
    public PesquisaGeralTela validarResultadoPesquisaCpf(String cpf) throws Exception {
        aguardarElementoClicavel(cpfSolicitante);
        validarAtributoTexto(cpfSolicitante, cpf, "CPF Pesquisado n�o encontrado!");
        salvarEvidencia("Validar resultado da pesquisa por CPF");
        return this;
    }

    /**
     * Clicar CPF pesquisado
     *
     * @throws Exception
     */
    @Step("Clicar CPF pesquisado")
    public PesquisaGeralTela clicarCpfPesquisado() throws Exception {
        aguardarElementoClicavel(cpfSolicitante);
        clicarElemento(cpfSolicitante, "Erro ao clicar no CPF pesquisado");
        salvarEvidencia("Clicar no CPF pesquisado");
        return this;
    }

    /**
     * Clicar bot�o Editar Proposta
     *
     * @throws Exception
     */
    @Step("Clicar bot�o Editar Proposta")
    public PesquisaGeralTela clicarBotaoEditarProposta() throws Exception {
        aguardarElementoClicavel(botaoEditarProposta);
        clicarElemento(botaoEditarProposta, "Erro ao clicar no bot�o Editar");
        salvarEvidencia("Clicar no bot�o editar proposta");
        return this;
    }

    /**
     * Clicar bot�o Finalizar
     *
     * throws Exception
     */
    @Step("Clicar no bot�o Finalizar")
    public PesquisaGeralTela clicarFinalizar() throws Exception {
        rolarAteElemento(botaoFinalizar,"Bot�o finalizar n�o encontrado");
        salvarEvidencia("Finalizada a An�lise");
        clicarElemento(botaoFinalizar,"Erro ao clicar no bot�o Finalizar");
        return this;
    }

    /**
     * Clicar bot�o Logout
     *
     * throws Exception
     */
    @Step("Clicar bot�o Logout")
    public PesquisaGeralTela clicarLogout() throws Exception {
        clicarElemento(botaoLogout,"Erro ao clicar no bot�o Logout");
        salvarEvidencia("Logout do FNext realizado");
        return this;
    }

    /**
     * Clicar bot�o Logout Se Existir
     *
     * throws Exception
     */
    @Step("Clicar bot�o Logout")
    public PesquisaGeralTela garantirLogoutAfterMethod() throws Exception {
        if(verificarPresencaElemento(botaoLogout)) {
            clicarElemento(botaoLogout, "Erro ao clicar no bot�o Logout");
        }
        return this;
    }

    /**
     * Validar N�o no campo A conta foi aberta?
     *
     * @throws Exception
     */
    @Step("Validar N�o no campo A conta foi aberta?")
    public PesquisaGeralTela validarNaoCampoAContaFoiAberta() throws Exception {
        aguardarExistenciaElemento(aContaFoiAbertaNao);
        salvarEvidencia("Validar texto N�o no campo A conta foi aberta");
        return this;
    }

    /**
     * Validar Resultado da Etapa igual a Aprovado Motor
     *
     * @throws Exception
     */
    @Step("Validar Resultado da Etapa")
    public PesquisaGeralTela resultadoDaEtapaAprovadoMotor() throws Exception {
        aguardarExistenciaElemento(resultadoDaEtapa);
        salvarEvidencia("Validar texto APROVADO MOTOR");
        return this;
    }

    /**
     * Validar Resultado da Etapa igual a Reprovado Motor
     *
     * @throws Exception
     */
    @Step("Validar Resultado da Etapa igual a Reprovado Motor")
    public PesquisaGeralTela validarResultadoReprovadoMotor() throws Exception {
        aguardarCarregamentoElemento(resultadoDaEtapaReprovadoMotor);
        salvarEvidencia("Validar texto REPROVADO MOTOR");
        return this;
    }

}
