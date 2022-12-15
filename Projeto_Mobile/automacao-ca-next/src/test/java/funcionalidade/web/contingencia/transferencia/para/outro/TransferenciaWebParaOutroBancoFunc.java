package funcionalidade.web.contingencia.transferencia.para.outro;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.transferencia.TipoContaTransferencia;
import constantes.transferencia.TipoTransferencia;
import pagina.web.contingencia.transferencia.*;
import pagina.web.contingencia.views.alertas.AlertaTransferenciaTela;
import pagina.web.contingencia.views.base.ContingenciaBaseTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class TransferenciaWebParaOutroBancoFunc extends FuncionalidadeBase {


    /**
     * Método para clicar no menu lateral de Transferencia e acessar a tela de Transferencia.
     * @throws Exception
     */
    public void acessarMenuTransferencia() throws Exception {
        new ContingenciaBaseTela(getWebDriver())
                .clicarMenuTransferencia();
    }

    /**
     * Método para clicar no botão Avançar e prosseguir com a Transferencia.
     * @throws Exception
     */
    public void clicarBotaoAvancar() throws Exception {
        new TransferenciaTela(getWebDriver())
                .clicarBotaoAvancar();
    }

    /**
     * Método para preencher dados da Transferencia.
     *
     * @param tipoTransferencia
     * @param agencia
     * @param conta
     * @param finalidade
     * @param nomeTransferencia
     * @param nome
     * @param tipoContaDestino
     * @param tipoContaTransferencia
     * @param quantiaTransferir
     *
     * @throws Exception
     */
    public void preencherDadosTransferencia(
            String nome,
            String tipoContaDestino,
            String quantiaTransferir,
            String finalidade,
            String nomeTransferencia,
            TipoContaTransferencia tipoContaTransferencia,
            TipoTransferencia tipoTransferencia,
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
        new TransferenciaTipoContaTela(getWebDriver())
                .selecionarTipoConta(tipoContaDestino);
        switch (tipoContaTransferencia){
            case CONTA_CORRENTE:
                new TransferenciaOndeSaiDinheiroTela(getWebDriver())
                        .selecionarTipoContaCorrente();
                break;
            case CONTA_POUPANCA:
                new TransferenciaOndeSaiDinheiroTela(getWebDriver())
                        .selecionarTipoContaPoupanca();
                break;
        }
        new TransferenciaValorTela(getWebDriver())
                .informarValorTransferir(quantiaTransferir);
        switch (tipoTransferencia){
            case TED:
                new TransferenciaTipoTela(getWebDriver())
                        .clicarTransferirTed();
                break;
            case DOC:
                new TransferenciaTipoTela(getWebDriver())
                        .clicarTransferirDoc();
                break;
        }

        new TransferenciaFinalidadeTela(getWebDriver())
                .selecionarFinalidadeTransferencia(finalidade);
        new TransferenciaNomeTransferenciaTela(getWebDriver())
                .informarNomeTransferencia(nomeTransferencia);
    }


    /**
     * Método para preencher dados da Transferencia.
     * @throws Exception
     * @param nome
     * @param tipoContaDestino
     * @param quantiaTransferir
     * @param nomeTransferencia
     * @param tipoContaTransferencia
     */
    public void preencherDadosTransferenciaContaInterna(
            String nome,
            String tipoContaDestino,
            String quantiaTransferir,
            String nomeTransferencia,
            TipoContaTransferencia tipoContaTransferencia
    )

            throws Exception {
        new TransferenciaParaQuemTela(getWebDriver())
                .clicarRadionButtonOutraPessoa();
        new TransferenciaSelecionarInstituicaoContaTela(getWebDriver())
                .selecionarContaFavorecido(nome)
                .clicarBotaoConfirmar();
        new TransferenciaTipoContaTela(getWebDriver())
                .selecionarTipoConta(tipoContaDestino);
        switch (tipoContaTransferencia){
            case CONTA_CORRENTE:
                new TransferenciaOndeSaiDinheiroTela(getWebDriver())
                        .selecionarTipoContaCorrente();
                break;
            case CONTA_POUPANCA:
                new TransferenciaOndeSaiDinheiroTela(getWebDriver())
                        .selecionarTipoContaPoupanca();
                break;
        }
        new TransferenciaValorTela(getWebDriver())
                .informarValorTransferir(quantiaTransferir);
        new TransferenciaNomeTransferenciaTela(getWebDriver())
                .informarNomeTransferencia(nomeTransferencia);
    }

    /**
     * Método para Validar mensagem de Transferencia de sucesso.
     * @throws Exception
     */
    public void confirmarAlertaTransferencia() throws Exception {
        new AlertaTransferenciaTela(getWebDriver())
                .validarMensagemTransferenciaSucesso()
                .clicarBotaoVoltar();
    }

    /**
     * Método para Validar tela de Transferencia e os dados da Transferencia.
     *
     * @param finalidade
     * @param quantiaTransferir
     * @param conta
     * @param agencia
     * @param contaOrigem
     * @param contaDestino
     * @param descricao
     * @param banco
     * @param para
     * @param cpfDestino
     * @param de
     * @param tipo
     * @param razaoSocialNome
     * @throws Exception
     */
    public void validarDadosTransferencia(String de, String para, String razaoSocialNome, String cpfDestino, String banco, String agencia, String conta, String contaDestino, String contaOrigem, String quantiaTransferir, String tipo, String finalidade, String descricao ) throws Exception {
        new TransferenciaConferirDadosTela(getWebDriver())
                .validarTextoQuemTransfere(de)
                .validarTextoParaQuemTransferir(para)
                .validarTextoParaQuemTransferir(razaoSocialNome)
                .validarTextoCpfDeQuemTransfere(cpfDestino)
                .validarBancoInsituicao(banco)
                .conferirAgenciaDestino(agencia)
                .conferirConta(conta)
                .conferirContaDestino(contaDestino)
                .conferirContaOrigem(contaOrigem)
                .conferirDataAtual()
                .conferirValorTransferencia(quantiaTransferir)
                .conferirTipoTransferencia(tipo)
                .conferirFinalidadeTransferencia(finalidade);
    }
}
