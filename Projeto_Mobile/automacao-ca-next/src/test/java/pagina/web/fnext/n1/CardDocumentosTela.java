package pagina.web.fnext.n1;

import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import base.pagina.web.fnext.PaginaBaseWebFNext;
import io.qameta.allure.Step;
import org.checkerframework.common.value.qual.StringVal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardDocumentosTela extends PaginaBaseWebFNext {

    @FindBy(id = "ApprovedV�DEO SELFIE")
    private WebElement aprovadoVideoSelfie;

    @FindBy(xpath = "//*[text()=\"V�DEO SELFIE\"]/../../*/*[@id=\"ApprovedResponsible\"]")
    private WebElement aprovadoVideoSelfieResponsible;

    @FindBy(id = "resendV�DEO SELFIE")
    private WebElement solicitaReenvioVideoSelfie;

    @FindBy(id = "ApprovedDOCUMENTO IDENTIFICA��O")
    private WebElement aprovadoDocumentoIdentificacao;

    @FindBy(xpath = "//*[text()=\"DOCUMENTO IDENTIFICA��O\"]/../../*/*[@id=\"ApprovedResponsible\"]")
    private WebElement aprovadoDocumentoIdentificacaoResponsible;

    @FindBy(id = "resendDOCUMENTO IDENTIFICA��O")
    private WebElement solicitaReenvioDocumentoIdentificacao;

    @FindBy(xpath = "//*[text()=\"DOCUMENTO IDENTIFICA��O\"]/../../*/*[@id=\"resendResponsible\"]")
    private WebElement solicitaReenvioDocumentoIdentificacaoResponsible;

    @FindBy(id = "resendDocUidDocIdent")
    private WebElement comboMotivoDocIdentificacao;

    @FindBy(id = "resendDocUidDocIdentResponsible")
    private WebElement comboMotivoDocIdentificacaoResponsible;

    @FindBy(id = "ApprovedCOMPROVANTE DE ENDERE�O")
    private WebElement aprovadoComprovanteDeEndereco;

    @FindBy(xpath = "//*[text()=\"COMPROVANTE DE ENDERE�O\"]/../../*/*[@id=\"ApprovedResponsible\"]")
    private WebElement aprovadoComprovanteDeEnderecoResponsible;

    @FindBy(id = "resendCOMPROVANTE DE ENDERE�O")
    private WebElement solicitaReenvioComprovanteDeEndereco;

    @FindBy(xpath = "//label[text() = \"SIM\"]/../../div/div[1]")
    private WebElement simConfereVideoSelfie;

    @FindBy(xpath = "//*[@id=\"checkVideoSelfieResponsible\"]/..//div")
    private WebElement simConfereVideoSelfieResponsible;

    @FindBy(id = "cardDoc")
    private WebElement cardDocumentos;

    @FindBy(id= "ApprovedFRAME LIVENESS")
    private WebElement aprovadoFrameLiveness;

    @FindBy(xpath = "//a[text()=\"FRAME LIVENESS\"]")
    private WebElement downloadCampoFrameLiveness;

    @FindBy(xpath = "//label[text()=\" Frame Liveness confere com Documento de identifica��o? \"]")
    private WebElement campoFrameLivenessConfereDocumentoIdentificacao;

    @FindBy(xpath = "//label[text() =  \" Mensagem ao Cliente\"]")
    private WebElement campoMensagemAoCliente;

    @FindBy(xpath = "//*[@id=\"ApprovedFRAME LIVENESS\" and @ng-reflect-disabled=\"false\"]")
    private WebElement aprovadoFrameLivenessHabilitado;

    @FindBy(xpath = "//*[@id=\"ApprovedFRAME LIVENESS\"]/*[not(contains(@class,\"checked\"))]")
    private WebElement aprovadoFrameLivenessNaoSelecionado;

    @FindBy(xpath = "//*[@id=\"resendFRAME LIVENESS\"]/*[contains(@class,\"checked\")]'")
    private WebElement solicitaReenvioFrameLivenessSelecionado;

    @FindBy(xpath = "//*[@id=\"resendFRAME LIVENESS\" and @ng-reflect-disabled=\"false\"]")
    private WebElement solicitaReenvioFrameLivenessHabilitado;

    @FindBy(xpath = "//*[@id=\"resendFRAME LIVENESS\"]/*[not(contains(@class,\"checked\"))]")
    private WebElement solicitaReenvioFrameLivenessNaoSelecionado;

    @FindBy(id = "checkVideoSelfie")
    private WebElement simNaoFrameLivenessConfereDocumentoIdentificacao;

    @FindBy(xpath = "//*[@id=\"checkVideoSelfie\" and @ng-reflect-disabled=\"false\"]")
    private WebElement campoSimNaoFrameLivenessConfereDocumentoIdentificacaoHabilitado;

    @FindBy(xpath = "//*[@id=\"checkVideoSelfie\"]//*[@ng-reflect-value=\"1\" and (not(contains(@class,\"checked\")))]")
    private WebElement simFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado;

    @FindBy(xpath = "//*[@id=\"checkVideoSelfie\"]//*[@ng-reflect-value=\"2\" and (not(contains(@class,\"checked\")))]")
    private WebElement naoFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado;

    @FindBy(xpath = "//label[text() = \"N�O\"]/../../div[1]")
    private WebElement naoSolicitarDocumentoDeGuarda;

    @FindBy(xpath = "//*[@id=\"checkVideoSelfie\"]//*[@ng-reflect-value=\"2\" and (contains(@class,\"checked\"))]'")
    private WebElement naoFrameLivenessConfereDocumentoIdentificacaoSelecionado;

    @FindBy(xpath = "//*[@id=\"resendDocFrameLiveness\" and @ng-reflect-is-disabled=\"false\"]")
    private WebElement motivoFrameLivenessHabilitado;


    public CardDocumentosTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar Aprovado do campo Video Selfie
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Video Selfie")
    public CardDocumentosTela clicarAprovadoVideoSelfie() throws Exception {
        rolarAteElemento(aprovadoVideoSelfie, "Campo Video Selfie n�o encontrado");
        aguardarElementoClicavel(aprovadoVideoSelfie);
        clicarElemento(aprovadoVideoSelfie, "Erro para clicar Aprovado no campo Video Selfie");
        salvarEvidencia("Clicar Aprovado no campo Video Selfie");
        return this;
    }

    /**
     * Clicar Aprovado do campo Video Selfie do Respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Video Selfie do Respons�vel")
    public CardDocumentosTela clicarAprovadoVideoSelfieResponsavel() throws Exception {
        rolarAteElemento(aprovadoVideoSelfieResponsible, "Campo Video Selfie n�o encontrado");
        aguardarElementoClicavel(aprovadoVideoSelfieResponsible);
        clicarElemento(aprovadoVideoSelfieResponsible, "Erro para clicar Aprovado no campo Video Selfie");
        salvarEvidencia("Clicar Aprovado no campo Video Selfie");
        return this;
    }

    /**
     * Clicar Solicita Reenvio do campo Video Selfie
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Solicita Reenvio do campo Video Selfie")
    public CardDocumentosTela clicarSolicitaReenvioVideoSelfie() throws Exception {
        rolarAteElemento(solicitaReenvioVideoSelfie, "Campo Solicita Reenvio do Video Selfie n�o encontrado");
        aguardarElementoClicavel(solicitaReenvioVideoSelfie);
        clicarElemento(solicitaReenvioVideoSelfie, "Erro para clicar Solicitar Reenvio do campo Video Selfie");
        salvarEvidencia("Clicar Solicita Reenvio do campo Video Selfie");
        return this;
    }

    /**
     * Clicar Aprovado do campo Documento Identifica��o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Documento Identifica��o")
    public CardDocumentosTela clicarAprovadoDocumentoIdentificacao() throws Exception {
        rolarAteElemento(aprovadoDocumentoIdentificacao, "Campo Aprovado do Documento Identifica��o n�o encontrado");
        aguardarElementoClicavel(aprovadoDocumentoIdentificacao);
        clicarElemento(aprovadoDocumentoIdentificacao, "Erro para clicar Aprovado no campo Documento Identifica��o");
        salvarEvidencia("Clicar Aprovado no campo Documento Identifica��o");
        return this;
    }

    /**
     * Clicar Aprovado do campo Documento Identifica��o do Respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Documento Identifica��o do Respons�vel")
    public CardDocumentosTela clicarAprovadoDocumentoIdentificacaoResponsavel() throws Exception {
        rolarAteElemento(aprovadoDocumentoIdentificacaoResponsible, "Campo Aprovado do Documento Identifica��o do Respons�vel n�o encontrado");
        aguardarElementoClicavel(aprovadoDocumentoIdentificacaoResponsible);
        clicarElemento(aprovadoDocumentoIdentificacaoResponsible, "Erro para clicar Aprovado no campo Documento Identifica��o do Respons�vel");
        salvarEvidencia("Clicar Aprovado no campo Documento Identifica��o do Respons�vel");
        return this;
    }

    /**
     * Clicar Solicita Reenvio do campo Documento Identifica��o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Solicita Reenvio do campo Documento Identifica��o")
    public CardDocumentosTela clicarSolicitaReenvioDocumentoIdentificacao() throws Exception {
        rolarAteElemento(solicitaReenvioDocumentoIdentificacao, "Campo Solicita Reenvio do Documento Identifica��o n�o encontrado");
        aguardarElementoClicavel(solicitaReenvioDocumentoIdentificacao);
        clicarElemento(solicitaReenvioDocumentoIdentificacao, "Erro para clicar Solicita Reenvio no campo Documento Identifica��o");
        salvarEvidencia("Clicar Solicita Reenvio no campo Documento Identifica��o");
        return this;
    }

    /**
     * Clicar Solicita Reenvio do campo Documento Identifica��o do Respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Solicita Reenvio do campo Documento Identifica��o do Respons�vel")
    public CardDocumentosTela clicarSolicitaReenvioDocumentoIdentificacaoResponsible() throws Exception {
        rolarAteElemento(solicitaReenvioDocumentoIdentificacaoResponsible,"Campo Solicita Reenvio do Documento de Identifica��o do Respons�vel n�o encontrado");
        aguardarElementoClicavel(solicitaReenvioDocumentoIdentificacaoResponsible);
        clicarElemento(solicitaReenvioDocumentoIdentificacaoResponsible,"Erro para clicar Solicita Reenvio no campo Documento Identifica��o do Respons�vel");
        salvarEvidencia("Clicar Solicita Reenvio no campo Documento Identifica��o do Respons�vel");
        return this;
    }

    /**
     * Selecionar combo de Motivo de Reenvio do Documento de Identifica��o do Respons�vel
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar no combo o Motivo para Reenvio do Documento de Identifica��o")
    public CardDocumentosTela selecionarComboMotivoDocIdentificacaoResponsible(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboMotivoDocIdentificacaoResponsible);
        selecionarTextoComboboxFnext(comboMotivoDocIdentificacaoResponsible, combo, "N�o foi poss�vel selecionar o Motivo de Reenvio do Documento de Identifica��o");
        salvarEvidencia("Motivo da Solicita��o de Reenvio do Respons�vel selecionado");
        return this;
    }

    /**
     * Clicar Aprovado do campo Comprovante de Endere�o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Comprovante de Endere�o")
    public CardDocumentosTela clicarAprovadoComprovanteEndereco() throws Exception {
        rolarAteElemento(aprovadoComprovanteDeEndereco, "Campo Comprovante de Endere�o n�o encontrado");
        aguardarElementoClicavel(aprovadoComprovanteDeEndereco);
        clicarElemento(aprovadoComprovanteDeEndereco, "Erro para clicar Aprovado no campo Comprovante de Endere�o");
        salvarEvidencia("Clicar Aprovado no campo Comprovante de Endere�o");
        return this;
    }

    /**
     * Clicar Aprovado do campo Comprovante de Endere�o do Respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Comprovante de Endere�o do Respons�vel")
    public CardDocumentosTela clicarAprovadoComprovanteEnderecoResponsavel() throws Exception {
        rolarAteElemento(aprovadoComprovanteDeEnderecoResponsible, "Campo Comprovante de Endere�o do Respons�vel n�o encontrado");
        aguardarElementoClicavel(aprovadoComprovanteDeEnderecoResponsible);
        clicarElemento(aprovadoComprovanteDeEnderecoResponsible, "Erro para clicar Aprovado no campo Comprovante de Endere�o do Respons�vel");
        salvarEvidencia("Clicar Aprovado no campo Comprovante de Endere�o do Respons�vel");
        return this;
    }

    /**
     * Clicar Solicita Reenvio do campo Comprovante de Endere�o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Solicita Reenvio do campo Comprovante de Endenre�o")
    public CardDocumentosTela clicarSolicitaReenvioComprovanteDeEndereco() throws Exception {
        rolarAteElemento(solicitaReenvioComprovanteDeEndereco, "Campo Solicita Reenvio do Comprovante de Endere�o n�o encontrado");
        aguardarElementoClicavel(solicitaReenvioComprovanteDeEndereco);
        clicarElemento(solicitaReenvioComprovanteDeEndereco, "Erro para clicar Solicita Reenvio no campo Comprovante de Endere�o");
        salvarEvidencia("Clicar Solicita Reenvio no campo Documento Identifica��o");
        return this;
    }

    /**
     * Clicar Sim do campo Video Selfie confere com o Documento de Identifica��o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Sim do campo Video Selfie confere com o Documento de Identifica��o")
    public CardDocumentosTela clicarSimConfereVideoSelfie() throws Exception {
        rolarParaBaixoAteElemento(simConfereVideoSelfie);
        aguardarElementoClicavel(simConfereVideoSelfie);
        clicarElemento(simConfereVideoSelfie, "Erro para clicar Sim no campo Video Selfie confere com o Documento de Identifica��o");
        salvarEvidencia("Clicar Sim no campo Video Selfie confere com o Documento de Identifica��o");
        return this;
    }

    /**
     * Clicar Sim do campo Video Selfie confere com o Documento de Identifica��o do Respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Sim do campo Video Selfie confere com o Documento de Identifica��o do Respons�vel")
    public CardDocumentosTela clicarSimConfereVideoSelfieResponsavel() throws Exception {
        rolarParaBaixoAteElemento(simConfereVideoSelfieResponsible);
        aguardarElementoClicavel(simConfereVideoSelfieResponsible);
        clicarElemento(simConfereVideoSelfieResponsible, "Erro para clicar Sim no campo Video Selfie confere com o Documento de Identifica��o do Respons�vel");
        salvarEvidencia("Clicar Sim no campo Video Selfie confere com o Documento de Identifica��o do Respons�vel");
        return this;
    }

    /**
     * Selecionar combo de Motivo de Reenvio do Documento Identifica��o
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Seleciona no combo o Motivo para reenvio do Documento de Identifica��o")
    public CardDocumentosTela selecionarComboMotivoDocIdentificacao(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboMotivoDocIdentificacao);
        selecionarTextoComboboxFnext(comboMotivoDocIdentificacao, combo,"N�o foi poss�vel selecionar o Motivo de Reenvio do documento de identifica��o");
        salvarEvidencia("Motivo da Solicita��o de Reenvio selecionado");
        return this;
    }

    /**
     * Clicar Aprovado do campo Frame Liveness
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Frame Liveness")
    public CardDocumentosTela clicarAprovadoFrameLiveness() throws Exception {
        rolarAteElemento(aprovadoFrameLiveness, "Campo Aprovado do Frame Liveness n�o encontrado");
        aguardarElementoClicavel(aprovadoFrameLiveness);
        clicarElemento(aprovadoFrameLiveness, "Erro para clicar Aprovado no campo Frame Liveness");
        salvarEvidencia("Clicar Aprovado no campo Frame Liveness");
        return this;
    }

        /**
     * Validar n�o Exist�ncia do campo Frame Liveness
     *
     * @return
     * @throws Exception
     */
    @Step("Validar n�o Exist�ncia do campo Frame Liveness")
    public CardDocumentosTela validarNaoExistenciaCampoFrameLiveness() throws Exception {
        rolarAteElemento(cardDocumentos, "Card Documentos n�o encontrado");
        validarCondicaoBooleana(verificarPresencaElemento(downloadCampoFrameLiveness), MetodoComparacaoBooleano.FALSO, "Campo Frame Liveness apresentado na tela");
        salvarEvidencia("Campo Frame Liveness n�o apresentado na tela.");
        return this;
    }

    /**
     * Validar n�o Exist�ncia do campo Frame Liveness confere com Documento de identifica��o
     *
     * @return
     * @throws Exception
     */
    @Step("Validar n�o Exist�ncia do campo Frame Liveness confere com Documento de identifica��o")
    public CardDocumentosTela validarNaoExistenciaCampoFrameLivenessConfereDocumentoIdentificacao() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Card Documentos n�o encontrado");
        validarCondicaoBooleana(verificarPresencaElemento(campoFrameLivenessConfereDocumentoIdentificacao), MetodoComparacaoBooleano.FALSO, "Campo Frame Liveness Confere com Documento de Identificacao apresentado na tela");
        salvarEvidencia("Campo Frame Liveness confere com documento de identificacao n�o apresentado na tela.");
        return this;
    }

    /**
     * Validar se op��o Aprovado do campo Frame Liveness est� habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se op��o Aprovado do campo Frame Liveness est� habilitado")
    public CardDocumentosTela validarSeAprovadoFrameLivenessHabilitado() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness n�o encontrado");
        verificarPresencaElemento(aprovadoFrameLivenessHabilitado);
        salvarEvidencia("Op��o Aprovado do campo Frame Liveness est� habilitado.");
        return this;
    }

    /**
     * Validar op��o Aprovado do campo Frame Liveness n�o selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar op��o Aprovado do campo Frame Liveness n�o selecionado")
    public CardDocumentosTela validarNaoSelecaoAprovadoFrameLiveness() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness n�o encontrado");
        verificarPresencaElemento(aprovadoFrameLivenessNaoSelecionado);
        salvarEvidencia("Op��o Aprovado do campo Frame Liveness est� sem sele��o");
        return this;
    }

    /**
     * Validar se op��o Solicita Reenvio do campo Frame Liveness est� habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se op��o Solicita Reenvio do campo Frame Liveness est� habilitado")
    public CardDocumentosTela validarSeSolicitaReenvioFrameLivenessHabilitado() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness n�o encontrado");
        verificarPresencaElemento(solicitaReenvioFrameLivenessHabilitado);
        salvarEvidencia("Op��o Solicita Reenvio do campo Frame Liveness est� habilitado.");
        return this;
    }

    /**
     * Validar op��o Solicita Reenvio do campo Frame Liveness n�o selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar op��o Solicita Reenvio do campo Frame Liveness n�o selecionado")
    public CardDocumentosTela validarNaoSelecaoSolicitaReenvioFrameLiveness() throws Exception {
        rolarAteElemento(downloadCampoFrameLiveness, "Campo Frame Liveness n�o encontrado");
        verificarPresencaElemento(solicitaReenvioFrameLivenessNaoSelecionado);
        salvarEvidencia("Op��o Solicita Reenvio do campo Frame Liveness est� sem sele��o");
        return this;
    }

    /**
     * Validar se op��o Solicita Reenvio do campo Frame Liveness est� selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar op��o Solicita Reenvio do campo Frame Liveness selecionado")
    public CardDocumentosTela validarSelecaoSolicitaReenvioFrameLiveness() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness n�o encontrado");
        verificarPresencaElemento(solicitaReenvioFrameLivenessSelecionado);
        salvarEvidencia("Op��o Solicita Reenvio do campo Frame Liveness est� com sele��o");
        return this;
    }

    /**
     * Validar se campo Frame Liveness confere com Documento de identifica��o est� habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se campo Frame Liveness confere com Documento de identifica��o est� habilitado")
    public CardDocumentosTela validarSeFrameLivenessConfereDocumentoIdentificacaoHabilitado() throws Exception {
        rolarAteElemento(simNaoFrameLivenessConfereDocumentoIdentificacao, "Campo Frame Liveness confere com Documento de identifica��o n�o encontrado");
        verificarPresencaElemento(campoSimNaoFrameLivenessConfereDocumentoIdentificacaoHabilitado);
        salvarEvidencia("Campo Frame Liveness confere com Documento de identifica��o est� habilitado.");
        return this;
    }

    /**
     * Validar se op��o Sim do campo Frame Liveness confere com Documento de identifica��o n�o est� selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se op��o Sim do campo Frame Liveness confere com Documento de identifica��o n�o est� selecionado")
    public CardDocumentosTela validarSimFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado() throws Exception {
        rolarAteElemento(simNaoFrameLivenessConfereDocumentoIdentificacao, "Campo Sim do Frame Liveness confere com Documento de identifica��o n�o encontrado");
        verificarPresencaElemento(simFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado);
        salvarEvidencia("Campo Sim do Frame Liveness confere com Documento de identifica��o sem sele��o.");
        return this;
    }

    /**
     * Clicar na op��o Sim do campo Frame Liveness confere com Documento de identifica��o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar na op��o Sim do campo Frame Liveness confere com Documento de identifica��o")
    public CardDocumentosTela clicarSimFrameLivenessConfereDocumentoIdentificacao() throws Exception {
        rolarAteElemento(simFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado, "Campo Sim do Frame Liveness confere com Documento de identifica��o n�o encontrado");
        clicarElemento(simFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado,"Erro para clicar Sim no campo Frame Liveness confere com Documento de identifica��o");
        salvarEvidencia("Clicar na op��o Sim do campo Frame Liveness confere com Documento de identifica��o");
        return this;
    }

    /**
     * Validar se op��o N�o do campo Frame Liveness confere com Documento de identifica��o n�o est� selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se op��o N�o do campo Frame Liveness confere com Documento de identifica��o n�o est� selecionado")
    public CardDocumentosTela validarNaoFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado() throws Exception {
        rolarAteElemento(simNaoFrameLivenessConfereDocumentoIdentificacao, "Campo N�o do Frame Liveness confere com Documento de identifica��o n�o encontrado");
        verificarPresencaElemento(naoFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado);
        salvarEvidencia("Campo N�o do Frame Liveness confere com Documento de identifica��o sem sele��o.");
        return this;
    }

    /**
     * Validar se op��o N�o do campo Frame Liveness confere com Documento de identifica��o est� selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se op��o N�o do campo Frame Liveness confere com Documento de identifica��o est� selecionado")
    public CardDocumentosTela validarNaoFrameLivenessConfereDocumentoIdentificacaoSelecionado() throws Exception {
        rolarAteElemento(simNaoFrameLivenessConfereDocumentoIdentificacao, "Campo N�o do Frame Liveness confere com Documento de identifica��o n�o encontrado");
        verificarPresencaElemento(naoFrameLivenessConfereDocumentoIdentificacaoSelecionado);
        salvarEvidencia("Campo N�o do Frame Liveness confere com Documento de identifica��o com sele��o.");
        return this;
    }

    /**
     * Validar se campo Motivo do Frame Liveness est� habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se campo Motivo do Frame Liveness est� habilitado")
    public CardDocumentosTela validarSeMotivoFrameLivenessHabilitado() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness n�o encontrado");
        verificarPresencaElemento(motivoFrameLivenessHabilitado);
        salvarEvidencia("Campo Motivo do Frame Liveness est� habilitado.");
        return this;
    }

    /**
     * Clicar N�O para o campo Solicitar Documento de Guarda
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar N�O para o campo Solicitar Documento de Guarda")
    public CardDocumentosTela clicarNaoCampoSolicitarDocumentoDeGuarda() throws Exception {
        rolarAteElemento(naoSolicitarDocumentoDeGuarda, "Campo Solicitar Documento de Guarda n�o encontrado");
        aguardarElementoClicavel(naoSolicitarDocumentoDeGuarda);
        clicarElemento(naoSolicitarDocumentoDeGuarda, "Erro para clicar N�o no Campo Solicitar Documento de Guarda");
        salvarEvidencia("Clicar N�O para o campo Solicitar Documento de Guarda");
        return this;
    }
}
