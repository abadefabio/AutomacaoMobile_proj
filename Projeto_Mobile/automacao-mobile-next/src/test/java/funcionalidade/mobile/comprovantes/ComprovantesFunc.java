package funcionalidade.mobile.comprovantes;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.comprovantes.ConsultaServico;
import constantes.comprovantes.ConsultaTransacao;
import constantes.comprovantes.MensagensComprovantes;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.comum.so.ModalCompartilhamentoTela;
import pagina.mobile.jornadas.comprovantes.ComprovantesExtratoTela;
import pagina.mobile.jornadas.comprovantes.SelecioneATransacaoTela;
import pagina.mobile.jornadas.comprovantes.SelecioneOServicoTela;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.jornadas.recarga.confirmacao.ComprovanteTela;
import pagina.web.email.EmailWebTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;

public class ComprovantesFunc extends FuncionalidadeBase {

    /**
     * Consulta Comprovantes
     * @param servico
     * @param transacao
     * @param dataInicial
     * @param dataFinal
     * @throws Exception
     */
    public void consultaComprovante(ConsultaServico servico, ConsultaTransacao transacao, String dataInicial, String dataFinal) throws Exception{
        new ComprovantesExtratoTela(getDriver())
                .tocarComboServico();
        new SelecioneOServicoTela(getDriver())
                .validarTelaSelecioneOServico()
                .selecionarServico(servico.toString())
                .tocarBotaoHeaderConfirmar();
        new ComprovantesExtratoTela(getDriver())
                .validarComprovantesTela()
                .tocarComboTransacao();
        new SelecioneATransacaoTela(getDriver())
                .validarTelaSelecioneATransacao()
                .selecionarTransacao(normalizaString(transacao.toString()))
                .tocarBotaoHeaderConfirmar();
        new ComprovantesExtratoTela(getDriver())
                .validarComprovantesTela()
                .dataInicial();
        new CalendarioTela(getDriver())
                .selecionarData(false, dataInicial)
                .tocarBotaoConfirmar();
        new ComprovantesExtratoTela(getDriver())
                .dataFinal();
        new CalendarioTela(getDriver())
                .selecionarData(false, dataFinal)
                .tocarBotaoConfirmar();
        new ComprovantesExtratoTela(getDriver())
                .continuar()
                .validarComprovantesTela();
    }

    /**
     * Compartilhar Comprovante
     *
     * @throws Exception
     */
    public void compartilharComprovanteTransferencia()throws Exception{
        new ComprovantesExtratoTela(getDriver())
                .tocarTransferencia();
        new ComprovantesExtratoTela(getDriver())
                .tocarVisualizar();
        new ComprovanteTela(getDriver())
                .validarPdf()
                .tirarScreenShot(getDriver());
        new ComprovantesExtratoTela(getDriver())
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento();

    }

    /**
     * Compartilhar Comprovante
     * @throws Exception
     */
    public void compartilharComprovantePagamentos()throws Exception{
        new ComprovantesExtratoTela(getDriver())
                .validarComprovantesTela()
                .selecionarPrimeiraContaNaLista()
                .tocarVisualizar();
        new ComprovanteTela(getDriver())
                .validarPdf()
                .tirarScreenShot(getDriver());
        new ComprovantesExtratoTela(getDriver())
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento();

    }

    /**
     * Acessar menu Objetivos Via menu Comprovantes
     * FR
     * @throws Exception
     */
    public void acessarObjetivosViaComprovantes()throws Exception{
        new MenuTela(getDriver())
                .tocarBotaoComprovantes()
                .tocarMenuObjetivos();
    }

    /**
     * Compartilhar pagamento
     *
     * @throws Exception
     */
    public void compartilharPagamento() throws Exception{
        new ComprovantesExtratoTela(getDriver())
                .tocarVisualizar()
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento();
    }

    /**
     * Processo de Validação do recebimento do comprovante no Email
     *
     * @throws Exception
     */
    public void validarRecebimentoComprovanteNoEmail(String dominioUsuarioEmail, String senhaEmail) throws Exception {
        getWebDriver().navigate().refresh();
        new EmailWebTela(getWebDriver())
                .preencherCampoDominioeUsuarioEmail(dominioUsuarioEmail)
                .preencherCampoSenhaEmail(senhaEmail)
                .tocarBotaoEntrar()
                .buscarEmailComAssuntoSeuRecibo()
                .selecionarAnexo();
    }

    /**
     * Validar mensagem quando não há transação no periodo selecionado
     *
     * @throws Exception
     */
    public void validarMensagemQuandoNaoTemTransacao() throws Exception{
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(String.valueOf(MensagensComprovantes.SEM_COMPROVANTES));
        new ComprovantesExtratoTela(getDriver())
                .tocarBotaoVoltar();
        new ComprovanteTela(getDriver())
                .validarExibicaoTelaComprovante();
    }
}
