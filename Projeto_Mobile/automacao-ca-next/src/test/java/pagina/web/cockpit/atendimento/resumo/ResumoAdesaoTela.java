package pagina.web.cockpit.atendimento.resumo;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static br.com.next.automacao.core.base.TesteNext.recuperarMassa;
import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class ResumoAdesaoTela extends PaginaBaseWeb {

    public ResumoAdesaoTela(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//textarea[contains(@class,'justification')]")
    private WebElement textoJustificativa;

    @FindBy(xpath = "//button[text()=' Aprovar ']")
    private WebElement botaoAprovar;

    @FindBy(xpath = "//*[@class='vision360']/div/div[3] //*[@class='items-list--key__item']/span")
    private WebElement cpf;

    @FindBy(className = "successMessage__text-desc")
    private WebElement textoContaAprovada;

    @FindBy(xpath = "//*[contains(text(),'Conta Reprovada')]")
    private WebElement textoContaReprovada;

    @FindBy(xpath = "//*[contains(text(),'Reprovar')]")
    private WebElement botaoReprovar;

    @FindBy(className = "//*[@class='successMessage__text-desc']")
    private WebElement mensagemTituloErroJustificativaObrigatorio;

    @FindBy(xpath = "//*[contains(text(),'O campo justificativa é obrigatório')]")
    private WebElement mensagemErroJustificativaObrigatorio;

    @FindBy(xpath = "//*[contains(text(),'FECHAR')]")
    private WebElement fecharPopupErroJustificativaObrigatorio;

    @FindBy(xpath = "//*[contains(text(),'Tem certeza que deseja')]")
    private WebElement mensagemConfirmacaoReprovacao;

    @FindBy(xpath ="//*[contains(text(),'Sim')]")
    private WebElement popupConfirmacaoReprovacaoSim;


    /**
     * Validar cpf é referente ao cliente esperado
     *
     * @param document
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela validarCpfAdesao(String document) throws Exception {
        aguardarCarregamentoElemento(cpf);
        salvarEvidencia("Validar cpf apresentado na visão 360°");

        return this;
    }

    /**
     * Validar o preenchimento no campo da justificativa
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela preencherJustificativaParaAprovacao() throws Exception {
        selecionarFrameDefaultContent();
        selecionarFramePorNomeOuId("frame-container");
        digitarTexto(textoJustificativa,"ADESÃO APROVADA COM SUCESSO","Não foi possivel inserir a justificativa");
        salvarEvidencia("Inserir a justificativa para aprovação");

        return this;

    }

    /**
     * Realizar aprovação atraves do botão Aprovar
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela clicarNoBotaoAprovarAdesao() throws Exception {
        salvarEvidencia("Clicar no botão Aprovar");
        clicarElemento(botaoAprovar,"Não foi possivel clicar no botão Aprovar");

        return this;

    }

    /**
     * Validar aprovação do cliente realizada com sucesso
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela validarAprovacaoComSucesso() throws Exception {
        aguardarCarregamentoElemento(textoContaAprovada);
        validarAtributoTexto(textoContaAprovada,"Conta Aprovada!","Conta não foi aprovado corretamente!");
        salvarEvidencia("Validar a mensagem de sucesso após aprovação");
        return this;

    }

    /**
     * Realizar reprovação atraves do botão Reprovar
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela clicarNoBotaoReprovarAdesao() throws Exception {
        salvarEvidencia("Clicar no botão Reprovar");
        selecionarFrameDefaultContent();
        selecionarFramePorNomeOuId("frame-container");
        clicarElemento(botaoReprovar,"Não foi possivel clicar no botão Reprovar");

        return this;

    }

    /**
     * Validar reaprovação do cliente sem preecher campo Justificativa
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela validarCampoJustificativa() throws Exception {
        selecionarFrameDefaultContent();
        selecionarFramePorNomeOuId("frame-container");
        aguardarCarregamentoElemento(mensagemErroJustificativaObrigatorio);
        validarAtributoTexto(mensagemErroJustificativaObrigatorio,"O campo justificativa é obrigatório","Mensagem justificativa inválida");
        salvarEvidencia("Campo justificativa obrigatório ");

        return this;

    }

    /**
     * Clicar no Botão fechar Popup
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */

     public ResumoAdesaoTela clicarBotaoFecharPopup() throws Exception {
         salvarEvidencia("clicar Botao Fechar Popup");
         clicarElemento(fecharPopupErroJustificativaObrigatorio,"Não foi possível clicar no botão fechar popup");
        return this;
     }

    /**
     * Validar confirmação da reaprovação
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela validarConfirmacaoReprovacao() throws Exception {
        aguardarCarregamentoElemento(mensagemConfirmacaoReprovacao);
        validarAtributoTexto(textoContaReprovada,"Conta Reprovada!","Conta não foi Reprovado corretamente!");
        return this;
    }

    /**
     * Clicar botão Reprovação Sim
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela clicarBotaoReprovacaoSim()  throws Exception {
        clicarElemento(popupConfirmacaoReprovacaoSim, "Não foi possível clicar no botão Reprovar");
        salvarEvidencia("Conta Reprovada com Sucesso");
        return this;
    }

    /**
     * Selecionar Frame Por Nome ou ID
     *
     * @param frame
     * @return
     * @throws Exception
     */
    private void selecionarFramePorNomeOuId(String frame){
        getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        getWebDriver().switchTo().frame(frame);

    }

    /**
     * Selecionar Frame Default Content
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    private void selecionarFrameDefaultContent(){
        getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        getWebDriver().switchTo().defaultContent();

    }

    /**
    * Validar reprovação do cliente realizada com sucesso
    *
    * @return ResumoAdesaoTela
    * @throws Exception
    */
    public ResumoAdesaoTela validarReprovacaoComSucesso() throws Exception {
        aguardarCarregamentoElemento(textoContaReprovada);
        validarAtributoTexto(textoContaReprovada,"Conta Reprovada!","Conta não foi Reprovar corretamente!");
        salvarEvidencia("Validar a mensagem de sucesso após reprovação");
        return this;
    }
}
