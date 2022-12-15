package pagina.web.fnext.n1;

import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import base.pagina.web.fnext.PaginaBaseWebFNext;
import io.qameta.allure.Step;
import org.checkerframework.common.value.qual.StringVal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardDocumentosTela extends PaginaBaseWebFNext {

    @FindBy(id = "ApprovedVÍDEO SELFIE")
    private WebElement aprovadoVideoSelfie;

    @FindBy(xpath = "//*[text()=\"VÍDEO SELFIE\"]/../../*/*[@id=\"ApprovedResponsible\"]")
    private WebElement aprovadoVideoSelfieResponsible;

    @FindBy(id = "resendVÍDEO SELFIE")
    private WebElement solicitaReenvioVideoSelfie;

    @FindBy(id = "ApprovedDOCUMENTO IDENTIFICAÇÃO")
    private WebElement aprovadoDocumentoIdentificacao;

    @FindBy(xpath = "//*[text()=\"DOCUMENTO IDENTIFICAÇÃO\"]/../../*/*[@id=\"ApprovedResponsible\"]")
    private WebElement aprovadoDocumentoIdentificacaoResponsible;

    @FindBy(id = "resendDOCUMENTO IDENTIFICAÇÃO")
    private WebElement solicitaReenvioDocumentoIdentificacao;

    @FindBy(xpath = "//*[text()=\"DOCUMENTO IDENTIFICAÇÃO\"]/../../*/*[@id=\"resendResponsible\"]")
    private WebElement solicitaReenvioDocumentoIdentificacaoResponsible;

    @FindBy(id = "resendDocUidDocIdent")
    private WebElement comboMotivoDocIdentificacao;

    @FindBy(id = "resendDocUidDocIdentResponsible")
    private WebElement comboMotivoDocIdentificacaoResponsible;

    @FindBy(id = "ApprovedCOMPROVANTE DE ENDEREÇO")
    private WebElement aprovadoComprovanteDeEndereco;

    @FindBy(xpath = "//*[text()=\"COMPROVANTE DE ENDEREÇO\"]/../../*/*[@id=\"ApprovedResponsible\"]")
    private WebElement aprovadoComprovanteDeEnderecoResponsible;

    @FindBy(id = "resendCOMPROVANTE DE ENDEREÇO")
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

    @FindBy(xpath = "//label[text()=\" Frame Liveness confere com Documento de identificação? \"]")
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

    @FindBy(xpath = "//label[text() = \"NÃO\"]/../../div[1]")
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
        rolarAteElemento(aprovadoVideoSelfie, "Campo Video Selfie não encontrado");
        aguardarElementoClicavel(aprovadoVideoSelfie);
        clicarElemento(aprovadoVideoSelfie, "Erro para clicar Aprovado no campo Video Selfie");
        salvarEvidencia("Clicar Aprovado no campo Video Selfie");
        return this;
    }

    /**
     * Clicar Aprovado do campo Video Selfie do Responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Video Selfie do Responsável")
    public CardDocumentosTela clicarAprovadoVideoSelfieResponsavel() throws Exception {
        rolarAteElemento(aprovadoVideoSelfieResponsible, "Campo Video Selfie não encontrado");
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
        rolarAteElemento(solicitaReenvioVideoSelfie, "Campo Solicita Reenvio do Video Selfie não encontrado");
        aguardarElementoClicavel(solicitaReenvioVideoSelfie);
        clicarElemento(solicitaReenvioVideoSelfie, "Erro para clicar Solicitar Reenvio do campo Video Selfie");
        salvarEvidencia("Clicar Solicita Reenvio do campo Video Selfie");
        return this;
    }

    /**
     * Clicar Aprovado do campo Documento Identificação
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Documento Identificação")
    public CardDocumentosTela clicarAprovadoDocumentoIdentificacao() throws Exception {
        rolarAteElemento(aprovadoDocumentoIdentificacao, "Campo Aprovado do Documento Identificação não encontrado");
        aguardarElementoClicavel(aprovadoDocumentoIdentificacao);
        clicarElemento(aprovadoDocumentoIdentificacao, "Erro para clicar Aprovado no campo Documento Identificação");
        salvarEvidencia("Clicar Aprovado no campo Documento Identificação");
        return this;
    }

    /**
     * Clicar Aprovado do campo Documento Identificação do Responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Documento Identificação do Responsável")
    public CardDocumentosTela clicarAprovadoDocumentoIdentificacaoResponsavel() throws Exception {
        rolarAteElemento(aprovadoDocumentoIdentificacaoResponsible, "Campo Aprovado do Documento Identificação do Responsável não encontrado");
        aguardarElementoClicavel(aprovadoDocumentoIdentificacaoResponsible);
        clicarElemento(aprovadoDocumentoIdentificacaoResponsible, "Erro para clicar Aprovado no campo Documento Identificação do Responsável");
        salvarEvidencia("Clicar Aprovado no campo Documento Identificação do Responsável");
        return this;
    }

    /**
     * Clicar Solicita Reenvio do campo Documento Identificação
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Solicita Reenvio do campo Documento Identificação")
    public CardDocumentosTela clicarSolicitaReenvioDocumentoIdentificacao() throws Exception {
        rolarAteElemento(solicitaReenvioDocumentoIdentificacao, "Campo Solicita Reenvio do Documento Identificação não encontrado");
        aguardarElementoClicavel(solicitaReenvioDocumentoIdentificacao);
        clicarElemento(solicitaReenvioDocumentoIdentificacao, "Erro para clicar Solicita Reenvio no campo Documento Identificação");
        salvarEvidencia("Clicar Solicita Reenvio no campo Documento Identificação");
        return this;
    }

    /**
     * Clicar Solicita Reenvio do campo Documento Identificação do Responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Solicita Reenvio do campo Documento Identificação do Responsável")
    public CardDocumentosTela clicarSolicitaReenvioDocumentoIdentificacaoResponsible() throws Exception {
        rolarAteElemento(solicitaReenvioDocumentoIdentificacaoResponsible,"Campo Solicita Reenvio do Documento de Identificação do Responsável não encontrado");
        aguardarElementoClicavel(solicitaReenvioDocumentoIdentificacaoResponsible);
        clicarElemento(solicitaReenvioDocumentoIdentificacaoResponsible,"Erro para clicar Solicita Reenvio no campo Documento Identificação do Responsável");
        salvarEvidencia("Clicar Solicita Reenvio no campo Documento Identificação do Responsável");
        return this;
    }

    /**
     * Selecionar combo de Motivo de Reenvio do Documento de Identificação do Responsável
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar no combo o Motivo para Reenvio do Documento de Identificação")
    public CardDocumentosTela selecionarComboMotivoDocIdentificacaoResponsible(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboMotivoDocIdentificacaoResponsible);
        selecionarTextoComboboxFnext(comboMotivoDocIdentificacaoResponsible, combo, "Não foi possível selecionar o Motivo de Reenvio do Documento de Identificação");
        salvarEvidencia("Motivo da Solicitação de Reenvio do Responsável selecionado");
        return this;
    }

    /**
     * Clicar Aprovado do campo Comprovante de Endereço
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Comprovante de Endereço")
    public CardDocumentosTela clicarAprovadoComprovanteEndereco() throws Exception {
        rolarAteElemento(aprovadoComprovanteDeEndereco, "Campo Comprovante de Endereço não encontrado");
        aguardarElementoClicavel(aprovadoComprovanteDeEndereco);
        clicarElemento(aprovadoComprovanteDeEndereco, "Erro para clicar Aprovado no campo Comprovante de Endereço");
        salvarEvidencia("Clicar Aprovado no campo Comprovante de Endereço");
        return this;
    }

    /**
     * Clicar Aprovado do campo Comprovante de Endereço do Responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Aprovado do campo Comprovante de Endereço do Responsável")
    public CardDocumentosTela clicarAprovadoComprovanteEnderecoResponsavel() throws Exception {
        rolarAteElemento(aprovadoComprovanteDeEnderecoResponsible, "Campo Comprovante de Endereço do Responsável não encontrado");
        aguardarElementoClicavel(aprovadoComprovanteDeEnderecoResponsible);
        clicarElemento(aprovadoComprovanteDeEnderecoResponsible, "Erro para clicar Aprovado no campo Comprovante de Endereço do Responsável");
        salvarEvidencia("Clicar Aprovado no campo Comprovante de Endereço do Responsável");
        return this;
    }

    /**
     * Clicar Solicita Reenvio do campo Comprovante de Endereço
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Solicita Reenvio do campo Comprovante de Endenreço")
    public CardDocumentosTela clicarSolicitaReenvioComprovanteDeEndereco() throws Exception {
        rolarAteElemento(solicitaReenvioComprovanteDeEndereco, "Campo Solicita Reenvio do Comprovante de Endereço não encontrado");
        aguardarElementoClicavel(solicitaReenvioComprovanteDeEndereco);
        clicarElemento(solicitaReenvioComprovanteDeEndereco, "Erro para clicar Solicita Reenvio no campo Comprovante de Endereço");
        salvarEvidencia("Clicar Solicita Reenvio no campo Documento Identificação");
        return this;
    }

    /**
     * Clicar Sim do campo Video Selfie confere com o Documento de Identificação
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Sim do campo Video Selfie confere com o Documento de Identificação")
    public CardDocumentosTela clicarSimConfereVideoSelfie() throws Exception {
        rolarParaBaixoAteElemento(simConfereVideoSelfie);
        aguardarElementoClicavel(simConfereVideoSelfie);
        clicarElemento(simConfereVideoSelfie, "Erro para clicar Sim no campo Video Selfie confere com o Documento de Identificação");
        salvarEvidencia("Clicar Sim no campo Video Selfie confere com o Documento de Identificação");
        return this;
    }

    /**
     * Clicar Sim do campo Video Selfie confere com o Documento de Identificação do Responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Sim do campo Video Selfie confere com o Documento de Identificação do Responsável")
    public CardDocumentosTela clicarSimConfereVideoSelfieResponsavel() throws Exception {
        rolarParaBaixoAteElemento(simConfereVideoSelfieResponsible);
        aguardarElementoClicavel(simConfereVideoSelfieResponsible);
        clicarElemento(simConfereVideoSelfieResponsible, "Erro para clicar Sim no campo Video Selfie confere com o Documento de Identificação do Responsável");
        salvarEvidencia("Clicar Sim no campo Video Selfie confere com o Documento de Identificação do Responsável");
        return this;
    }

    /**
     * Selecionar combo de Motivo de Reenvio do Documento Identificação
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Seleciona no combo o Motivo para reenvio do Documento de Identificação")
    public CardDocumentosTela selecionarComboMotivoDocIdentificacao(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboMotivoDocIdentificacao);
        selecionarTextoComboboxFnext(comboMotivoDocIdentificacao, combo,"Não foi possível selecionar o Motivo de Reenvio do documento de identificação");
        salvarEvidencia("Motivo da Solicitação de Reenvio selecionado");
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
        rolarAteElemento(aprovadoFrameLiveness, "Campo Aprovado do Frame Liveness não encontrado");
        aguardarElementoClicavel(aprovadoFrameLiveness);
        clicarElemento(aprovadoFrameLiveness, "Erro para clicar Aprovado no campo Frame Liveness");
        salvarEvidencia("Clicar Aprovado no campo Frame Liveness");
        return this;
    }

        /**
     * Validar não Existência do campo Frame Liveness
     *
     * @return
     * @throws Exception
     */
    @Step("Validar não Existência do campo Frame Liveness")
    public CardDocumentosTela validarNaoExistenciaCampoFrameLiveness() throws Exception {
        rolarAteElemento(cardDocumentos, "Card Documentos não encontrado");
        validarCondicaoBooleana(verificarPresencaElemento(downloadCampoFrameLiveness), MetodoComparacaoBooleano.FALSO, "Campo Frame Liveness apresentado na tela");
        salvarEvidencia("Campo Frame Liveness não apresentado na tela.");
        return this;
    }

    /**
     * Validar não Existência do campo Frame Liveness confere com Documento de identificação
     *
     * @return
     * @throws Exception
     */
    @Step("Validar não Existência do campo Frame Liveness confere com Documento de identificação")
    public CardDocumentosTela validarNaoExistenciaCampoFrameLivenessConfereDocumentoIdentificacao() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Card Documentos não encontrado");
        validarCondicaoBooleana(verificarPresencaElemento(campoFrameLivenessConfereDocumentoIdentificacao), MetodoComparacaoBooleano.FALSO, "Campo Frame Liveness Confere com Documento de Identificacao apresentado na tela");
        salvarEvidencia("Campo Frame Liveness confere com documento de identificacao não apresentado na tela.");
        return this;
    }

    /**
     * Validar se opção Aprovado do campo Frame Liveness está habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se opção Aprovado do campo Frame Liveness está habilitado")
    public CardDocumentosTela validarSeAprovadoFrameLivenessHabilitado() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness não encontrado");
        verificarPresencaElemento(aprovadoFrameLivenessHabilitado);
        salvarEvidencia("Opção Aprovado do campo Frame Liveness está habilitado.");
        return this;
    }

    /**
     * Validar opção Aprovado do campo Frame Liveness não selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar opção Aprovado do campo Frame Liveness não selecionado")
    public CardDocumentosTela validarNaoSelecaoAprovadoFrameLiveness() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness não encontrado");
        verificarPresencaElemento(aprovadoFrameLivenessNaoSelecionado);
        salvarEvidencia("Opção Aprovado do campo Frame Liveness está sem seleção");
        return this;
    }

    /**
     * Validar se opção Solicita Reenvio do campo Frame Liveness está habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se opção Solicita Reenvio do campo Frame Liveness está habilitado")
    public CardDocumentosTela validarSeSolicitaReenvioFrameLivenessHabilitado() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness não encontrado");
        verificarPresencaElemento(solicitaReenvioFrameLivenessHabilitado);
        salvarEvidencia("Opção Solicita Reenvio do campo Frame Liveness está habilitado.");
        return this;
    }

    /**
     * Validar opção Solicita Reenvio do campo Frame Liveness não selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar opção Solicita Reenvio do campo Frame Liveness não selecionado")
    public CardDocumentosTela validarNaoSelecaoSolicitaReenvioFrameLiveness() throws Exception {
        rolarAteElemento(downloadCampoFrameLiveness, "Campo Frame Liveness não encontrado");
        verificarPresencaElemento(solicitaReenvioFrameLivenessNaoSelecionado);
        salvarEvidencia("Opção Solicita Reenvio do campo Frame Liveness está sem seleção");
        return this;
    }

    /**
     * Validar se opção Solicita Reenvio do campo Frame Liveness está selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar opção Solicita Reenvio do campo Frame Liveness selecionado")
    public CardDocumentosTela validarSelecaoSolicitaReenvioFrameLiveness() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness não encontrado");
        verificarPresencaElemento(solicitaReenvioFrameLivenessSelecionado);
        salvarEvidencia("Opção Solicita Reenvio do campo Frame Liveness está com seleção");
        return this;
    }

    /**
     * Validar se campo Frame Liveness confere com Documento de identificação está habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se campo Frame Liveness confere com Documento de identificação está habilitado")
    public CardDocumentosTela validarSeFrameLivenessConfereDocumentoIdentificacaoHabilitado() throws Exception {
        rolarAteElemento(simNaoFrameLivenessConfereDocumentoIdentificacao, "Campo Frame Liveness confere com Documento de identificação não encontrado");
        verificarPresencaElemento(campoSimNaoFrameLivenessConfereDocumentoIdentificacaoHabilitado);
        salvarEvidencia("Campo Frame Liveness confere com Documento de identificação está habilitado.");
        return this;
    }

    /**
     * Validar se opção Sim do campo Frame Liveness confere com Documento de identificação não está selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se opção Sim do campo Frame Liveness confere com Documento de identificação não está selecionado")
    public CardDocumentosTela validarSimFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado() throws Exception {
        rolarAteElemento(simNaoFrameLivenessConfereDocumentoIdentificacao, "Campo Sim do Frame Liveness confere com Documento de identificação não encontrado");
        verificarPresencaElemento(simFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado);
        salvarEvidencia("Campo Sim do Frame Liveness confere com Documento de identificação sem seleção.");
        return this;
    }

    /**
     * Clicar na opção Sim do campo Frame Liveness confere com Documento de identificação
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar na opção Sim do campo Frame Liveness confere com Documento de identificação")
    public CardDocumentosTela clicarSimFrameLivenessConfereDocumentoIdentificacao() throws Exception {
        rolarAteElemento(simFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado, "Campo Sim do Frame Liveness confere com Documento de identificação não encontrado");
        clicarElemento(simFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado,"Erro para clicar Sim no campo Frame Liveness confere com Documento de identificação");
        salvarEvidencia("Clicar na opção Sim do campo Frame Liveness confere com Documento de identificação");
        return this;
    }

    /**
     * Validar se opção Não do campo Frame Liveness confere com Documento de identificação não está selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se opção Não do campo Frame Liveness confere com Documento de identificação não está selecionado")
    public CardDocumentosTela validarNaoFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado() throws Exception {
        rolarAteElemento(simNaoFrameLivenessConfereDocumentoIdentificacao, "Campo Não do Frame Liveness confere com Documento de identificação não encontrado");
        verificarPresencaElemento(naoFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado);
        salvarEvidencia("Campo Não do Frame Liveness confere com Documento de identificação sem seleção.");
        return this;
    }

    /**
     * Validar se opção Não do campo Frame Liveness confere com Documento de identificação está selecionado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se opção Não do campo Frame Liveness confere com Documento de identificação está selecionado")
    public CardDocumentosTela validarNaoFrameLivenessConfereDocumentoIdentificacaoSelecionado() throws Exception {
        rolarAteElemento(simNaoFrameLivenessConfereDocumentoIdentificacao, "Campo Não do Frame Liveness confere com Documento de identificação não encontrado");
        verificarPresencaElemento(naoFrameLivenessConfereDocumentoIdentificacaoSelecionado);
        salvarEvidencia("Campo Não do Frame Liveness confere com Documento de identificação com seleção.");
        return this;
    }

    /**
     * Validar se campo Motivo do Frame Liveness está habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar se campo Motivo do Frame Liveness está habilitado")
    public CardDocumentosTela validarSeMotivoFrameLivenessHabilitado() throws Exception {
        rolarAteElemento(campoMensagemAoCliente, "Campo Frame Liveness não encontrado");
        verificarPresencaElemento(motivoFrameLivenessHabilitado);
        salvarEvidencia("Campo Motivo do Frame Liveness está habilitado.");
        return this;
    }

    /**
     * Clicar NÃO para o campo Solicitar Documento de Guarda
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar NÃO para o campo Solicitar Documento de Guarda")
    public CardDocumentosTela clicarNaoCampoSolicitarDocumentoDeGuarda() throws Exception {
        rolarAteElemento(naoSolicitarDocumentoDeGuarda, "Campo Solicitar Documento de Guarda não encontrado");
        aguardarElementoClicavel(naoSolicitarDocumentoDeGuarda);
        clicarElemento(naoSolicitarDocumentoDeGuarda, "Erro para clicar Não no Campo Solicitar Documento de Guarda");
        salvarEvidencia("Clicar NÃO para o campo Solicitar Documento de Guarda");
        return this;
    }
}
