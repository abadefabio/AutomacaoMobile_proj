package funcionalidade.web.fnext.n1;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.n1.CardDocumentosTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class DocumentosFunc extends FuncionalidadeBase {

    /**
     * Métodos para marcar Aprovado Documento Identificação, Comprovante de Endereço e Vídeo Selfie
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
     * Solicitar Reenvio Documento Identificação com Motivo igual Cópia
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
     * Solicitar Reenvio Documento de Identificação do Responsável
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
     * Métodos para marcar Aprovado no Documento Identificação para propostas Next Joy e Next Joy II
     *
     * @throws Exception
     */
    public void marcarAprovadoDocumentoJoys() throws Exception{
        new CardDocumentosTela(getWebDriver())
                .clicarAprovadoDocumentoIdentificacao();
    }

    /**
     * Método para marcar Aprovado nos Documentos do responsável para propostas Next Joy II
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
     * Métodos para marcar Aprovado no Frame Liveness e Documento Identificação para proposta Next
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
     * Verificar não existência dos campos de Frame Liveness
     *
     * @throws Exception
     */
    public void verificarNaoExistenciaDosCamposDeFrameLiveness() throws Exception {
        new CardDocumentosTela(getWebDriver())
                .validarNaoExistenciaCampoFrameLiveness()
                .validarNaoExistenciaCampoFrameLivenessConfereDocumentoIdentificacao();

    }

    /**
     * Solicitar reenvio de documento de identificação para NextJoy
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
     * Validar campos Frame Liveness-Aprovado, Frame Liveness-Solicita Reenvio e Frame Liveness confere com Documento de identificação habilitado e sem seleção
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
     * Validar campos Frame Liveness-Solicita Reenvio e Não do Frame Liveness confere com Documento de identificação habilitado e com seleção
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
     * Métodos para marcar Aprovado no Documento Identificação e Não Solicita Documento de Guarda para propostas Next Joy
     *
     * @throws Exception
     */
    public void marcarAprovadoDocumentoNaoSolicitaDocumentoGuardaJoy() throws Exception{
        new CardDocumentosTela(getWebDriver())
                .clicarAprovadoDocumentoIdentificacao()
                .clicarNaoCampoSolicitarDocumentoDeGuarda();
    }
}
