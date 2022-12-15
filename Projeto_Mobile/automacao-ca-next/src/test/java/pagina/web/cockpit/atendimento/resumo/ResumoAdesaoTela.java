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

    @FindBy(xpath = "//*[contains(text(),'O campo justificativa � obrigat�rio')]")
    private WebElement mensagemErroJustificativaObrigatorio;

    @FindBy(xpath = "//*[contains(text(),'FECHAR')]")
    private WebElement fecharPopupErroJustificativaObrigatorio;

    @FindBy(xpath = "//*[contains(text(),'Tem certeza que deseja')]")
    private WebElement mensagemConfirmacaoReprovacao;

    @FindBy(xpath ="//*[contains(text(),'Sim')]")
    private WebElement popupConfirmacaoReprovacaoSim;


    /**
     * Validar cpf � referente ao cliente esperado
     *
     * @param document
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela validarCpfAdesao(String document) throws Exception {
        aguardarCarregamentoElemento(cpf);
        salvarEvidencia("Validar cpf apresentado na vis�o 360�");

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
        digitarTexto(textoJustificativa,"ADES�O APROVADA COM SUCESSO","N�o foi possivel inserir a justificativa");
        salvarEvidencia("Inserir a justificativa para aprova��o");

        return this;

    }

    /**
     * Realizar aprova��o atraves do bot�o Aprovar
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela clicarNoBotaoAprovarAdesao() throws Exception {
        salvarEvidencia("Clicar no bot�o Aprovar");
        clicarElemento(botaoAprovar,"N�o foi possivel clicar no bot�o Aprovar");

        return this;

    }

    /**
     * Validar aprova��o do cliente realizada com sucesso
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela validarAprovacaoComSucesso() throws Exception {
        aguardarCarregamentoElemento(textoContaAprovada);
        validarAtributoTexto(textoContaAprovada,"Conta Aprovada!","Conta n�o foi aprovado corretamente!");
        salvarEvidencia("Validar a mensagem de sucesso ap�s aprova��o");
        return this;

    }

    /**
     * Realizar reprova��o atraves do bot�o Reprovar
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela clicarNoBotaoReprovarAdesao() throws Exception {
        salvarEvidencia("Clicar no bot�o Reprovar");
        selecionarFrameDefaultContent();
        selecionarFramePorNomeOuId("frame-container");
        clicarElemento(botaoReprovar,"N�o foi possivel clicar no bot�o Reprovar");

        return this;

    }

    /**
     * Validar reaprova��o do cliente sem preecher campo Justificativa
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela validarCampoJustificativa() throws Exception {
        selecionarFrameDefaultContent();
        selecionarFramePorNomeOuId("frame-container");
        aguardarCarregamentoElemento(mensagemErroJustificativaObrigatorio);
        validarAtributoTexto(mensagemErroJustificativaObrigatorio,"O campo justificativa � obrigat�rio","Mensagem justificativa inv�lida");
        salvarEvidencia("Campo justificativa obrigat�rio ");

        return this;

    }

    /**
     * Clicar no Bot�o fechar Popup
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */

     public ResumoAdesaoTela clicarBotaoFecharPopup() throws Exception {
         salvarEvidencia("clicar Botao Fechar Popup");
         clicarElemento(fecharPopupErroJustificativaObrigatorio,"N�o foi poss�vel clicar no bot�o fechar popup");
        return this;
     }

    /**
     * Validar confirma��o da reaprova��o
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela validarConfirmacaoReprovacao() throws Exception {
        aguardarCarregamentoElemento(mensagemConfirmacaoReprovacao);
        validarAtributoTexto(textoContaReprovada,"Conta Reprovada!","Conta n�o foi Reprovado corretamente!");
        return this;
    }

    /**
     * Clicar bot�o Reprova��o Sim
     *
     * @return ResumoAdesaoTela
     * @throws Exception
     */
    public ResumoAdesaoTela clicarBotaoReprovacaoSim()  throws Exception {
        clicarElemento(popupConfirmacaoReprovacaoSim, "N�o foi poss�vel clicar no bot�o Reprovar");
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
    * Validar reprova��o do cliente realizada com sucesso
    *
    * @return ResumoAdesaoTela
    * @throws Exception
    */
    public ResumoAdesaoTela validarReprovacaoComSucesso() throws Exception {
        aguardarCarregamentoElemento(textoContaReprovada);
        validarAtributoTexto(textoContaReprovada,"Conta Reprovada!","Conta n�o foi Reprovar corretamente!");
        salvarEvidencia("Validar a mensagem de sucesso ap�s reprova��o");
        return this;
    }
}
