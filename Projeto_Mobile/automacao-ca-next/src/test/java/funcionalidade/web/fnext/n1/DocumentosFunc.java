package funcionalidade.web.fnext.n1;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.n1.CardDocumentosTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class DocumentosFunc extends FuncionalidadeBase {

    /**
     * M�todos para marcar Aprovado Documento Identifica��o, Comprovante de Endere�o e V�deo Selfie
     *
     * @throws Exception
     */
    public void marcarAprovadoTodosDocumentos() throws Exception{
        new CardDocumentosTela(getWebDriver())
                .clicarAprovadoDocumentoIdentificacao()
                .clicarAprovadoComprovanteEndereco()
                .clicarAprovadoVideoSelfie()
                .clicarSimConfereVideoSelfie();
    }

    /**
     * Solicitar Reenvio Documento Identifica��o com Motivo igual C�pia
     *
     * @throws Exception
     */
    public void solicitarReenvioDocumentoIdentificacao(String motivo) throws Exception{
        new CardDocumentosTela(getWebDriver())
                .clicarAprovadoVideoSelfie()
                .clicarSolicitaReenvioDocumentoIdentificacao()
                .selecionarComboMotivoDocIdentificacao(motivo)
                .clicarAprovadoComprovanteEndereco()
                .clicarSimConfereVideoSelfie();
    }

    /**
     * Solicitar Reenvio Documento de Identifica��o do Respons�vel
     *
     * @throws Exception
     */
    public void solicitarReenvioDocumentoIdentificacaoResponsavel(String motivo) throws Exception{
        new CardDocumentosTela(getWebDriver())
                .clicarAprovadoComprovanteEnderecoResponsavel()
                .clicarAprovadoVideoSelfieResponsavel()
                .clicarSolicitaReenvioDocumentoIdentificacaoResponsible()
                .selecionarComboMotivoDocIdentificacaoResponsible(motivo);
    }

    /**
     * M�todos para marcar Aprovado no Documento Identifica��o para propostas Next Joy e Next Joy II
     *
     * @throws Exception
     */
    public void marcarAprovadoDocumentoJoys() throws Exception{
        new CardDocumentosTela(getWebDriver())
                .clicarAprovadoDocumentoIdentificacao();
    }

    /**
     * M�todo para marcar Aprovado nos Documentos do respons�vel para propostas Next Joy II
     *
     * @throws Exception
     */
    public void marcarAprovadoDocumentosResponsavelJoyII() throws Exception {
        new CardDocumentosTela(getWebDriver())
                .clicarAprovadoComprovanteEnderecoResponsavel()
                .clicarAprovadoVideoSelfieResponsavel()
                .clicarAprovadoDocumentoIdentificacaoResponsavel()
                .clicarSimConfereVideoSelfieResponsavel();
    }

    /**
     * M�todos para marcar Aprovado no Frame Liveness e Documento Identifica��o para proposta Next
     *
     * @throws Exception
     */
    public void marcarAprovadoDocumentoLivenessNext() throws Exception{
        new CardDocumentosTela(getWebDriver())
                .clicarAprovadoFrameLiveness()
                .clicarAprovadoDocumentoIdentificacao()
                .clicarSimFrameLivenessConfereDocumentoIdentificacao();
    }

    /**
     * Verificar n�o exist�ncia dos campos de Frame Liveness
     *
     * @throws Exception
     */
    public void verificarNaoExistenciaDosCamposDeFrameLiveness() throws Exception {
        new CardDocumentosTela(getWebDriver())
                .validarNaoExistenciaCampoFrameLiveness()
                .validarNaoExistenciaCampoFrameLivenessConfereDocumentoIdentificacao();

    }

    /**
     * Solicitar reenvio de documento de identifica��o para NextJoy
     *
     * @param motivo
     * @throws Exception
     */
    public void solicitarReenvioDocumentoIdentificacaoJoy(String motivo) throws Exception {
        new CardDocumentosTela(getWebDriver())
                .clicarSolicitaReenvioDocumentoIdentificacao()
                .selecionarComboMotivoDocIdentificacao(motivo);
    }

    /**
     * Validar campos Frame Liveness-Aprovado, Frame Liveness-Solicita Reenvio e Frame Liveness confere com Documento de identifica��o habilitado e sem sele��o
     *
     * @throws Exception
     */
    public void camposFrameLivenessEFrameLivenessConfereDocIdentificacaoHabilitadoESemSelecao() throws Exception {
        new CardDocumentosTela(getWebDriver())
                .validarSeAprovadoFrameLivenessHabilitado()
                .validarNaoSelecaoAprovadoFrameLiveness()
                .validarSeSolicitaReenvioFrameLivenessHabilitado()
                .validarNaoSelecaoSolicitaReenvioFrameLiveness()
                .validarSeFrameLivenessConfereDocumentoIdentificacaoHabilitado()
                .validarSimFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado()
                .validarNaoFrameLivenessConfereDocumentoIdentificacaoNaoSelecionado();
    }

    /**
     * Validar campos Frame Liveness-Solicita Reenvio e N�o do Frame Liveness confere com Documento de identifica��o habilitado e com sele��o
     *
     * @throws Exception
     */
    public void camposFrameLivenessSolicitaReenvioENaoFrameLivenessConfereDocIdentificacaoHabilitadoEComSelecao() throws Exception {
        new CardDocumentosTela(getWebDriver())
                .validarSeAprovadoFrameLivenessHabilitado()
                .validarNaoSelecaoAprovadoFrameLiveness()
                .validarSeSolicitaReenvioFrameLivenessHabilitado()
                .validarSelecaoSolicitaReenvioFrameLiveness()
                .validarSeMotivoFrameLivenessHabilitado()
                .validarSeFrameLivenessConfereDocumentoIdentificacaoHabilitado()
                .validarNaoFrameLivenessConfereDocumentoIdentificacaoSelecionado();
    }

    /**
     * M�todos para marcar Aprovado no Documento Identifica��o e N�o Solicita Documento de Guarda para propostas Next Joy
     *
     * @throws Exception
     */
    public void marcarAprovadoDocumentoNaoSolicitaDocumentoGuardaJoy() throws Exception{
        new CardDocumentosTela(getWebDriver())
                .clicarAprovadoDocumentoIdentificacao()
                .clicarNaoCampoSolicitarDocumentoDeGuarda();
    }
}
