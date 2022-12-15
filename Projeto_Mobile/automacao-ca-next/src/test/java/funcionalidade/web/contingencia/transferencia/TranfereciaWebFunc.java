package funcionalidade.web.contingencia.transferencia;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import funcionalidade.web.contingencia.transferencia.para.TransferenciaTidFunc;
import pagina.web.contingencia.transferencia.*;
import pagina.web.contingencia.views.alertas.AlertaTransferenciaTela;
import pagina.web.contingencia.views.base.ContingenciaBaseTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class TranfereciaWebFunc extends FuncionalidadeBase {

    /**
     * Chamada dos M�todos Menu "Transfer�ncia".
     *
     * @throws Exception
     */
    public void clicarMenuTransferencia() throws Exception {
        new ContingenciaBaseTela(getWebDriver())
                .clicarMenuTransferencia();
    }

    /**
     * Chamada dos m�todos para preenchimento dos campos da transfer�ncia
     * @param nome
     * @param valorTransferencia
     * @param finalidade
     * @param nomeTransferencia
     * @param agencia
     * @param conta
     * @throws Exception
     */
    public void paraQuemVoceVaiTransferir(
            String nome,
            String valorTransferencia,
            String finalidade,
            String nomeTransferencia,
            String agencia,
            String conta
    )

            throws Exception {
        new TransferenciaParaQuemTela(getWebDriver())
                .clicarRadionButtonOutraPessoa();
        new TransferenciaSelecionarInstituicaoContaTela(getWebDriver())
                .selecionarContaFavorecido(nome)
                .clicarRadioButtonConta(agencia, conta)
                .clicarBotaoConfirmar();
        new TransferenciaOndeSaiDinheiroTela(getWebDriver())
                .selecionarTipoContaPoupanca();
        new TransferenciaValorTela(getWebDriver())
                .informarValorTransferir(valorTransferencia);
        new TransferenciaTipoTela(getWebDriver())
                .clicarTransferirTed();
        new TransferenciaFinalidadeTela(getWebDriver())
                .selecionarFinalidadeTransferencia(finalidade);
        new TransferenciaNomeTransferenciaTela(getWebDriver())
                .informarNomeTransferencia(nomeTransferencia);
        new TransferenciaTela(getWebDriver())
                .clicarBotaoAvancar();
    }

    /**
     * Chamada dos m�todos para preenchimento dos campos da transfer�ncia
     * @param nome
     * @param valorTransferencia
     * @param finalidade
     * @param nomeTransferencia
     * @param agencia
     * @param conta
     * @throws Exception
     */

    public void paraQuemVoceVaiTransferirInstituicaoPagamento(
            String nome,
            String valorTransferencia,
            String finalidade,
            String nomeTransferencia,
            String agencia,
            String conta
    )
    throws Exception {
        new TransferenciaParaQuemTela(getWebDriver())
                .clicarRadionButtonOutraPessoa();
        new TransferenciaSelecionarInstituicaoContaTela(getWebDriver())
                .selecionarContaFavorecido(nome)
                .clicarRadioButtonConta(agencia, conta)
                .clicarBotaoConfirmar();
        new TransferenciaOndeSaiDinheiroTela(getWebDriver())
                .selecionarTipoContaPoupanca();
        new TransferenciaValorTela(getWebDriver())
                .informarValorTransferir(valorTransferencia);
        new TransferenciaTipoTela(getWebDriver())
                .clicarTransferirTed();
        new TransferenciaFinalidadeTela(getWebDriver())
                .selecionarFinalidadeTransferencia(finalidade);
        new TransferenciaNomeTransferenciaTela(getWebDriver())
                .informarNomeTransferencia(nomeTransferencia);
        new TransferenciaTela(getWebDriver())
                .clicarBotaoAvancar();
    }

    /**
     * Met�do para confirmar autoriza��o da TID
     *
     * @param senha
     * @return
     * @throws Exception
     */
    public void confirmarTransferenciaTid(String senha) throws Exception {
        new TransferenciaTidFunc().confirmarTidTransferencia(senha);
    }

    /**
     * Met�do para validar o alerta de transfer�ncia e clicar no bot�o para sair da popup
     *
     * @return
     * @throws Exception
     */
    public void confirmarAlertaTransferencia() throws Exception {
        new AlertaTransferenciaTela(getWebDriver())
                .validarMensagemTransferenciaSucesso()
                .clicarBotaoVoltar();
    }
}
