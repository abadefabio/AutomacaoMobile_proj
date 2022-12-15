package funcionalidade.web.contingencia.transferencia.para.mim;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import funcionalidade.web.contingencia.transferencia.para.TransferenciaTidFunc;
import pagina.web.contingencia.transferencia.*;
import pagina.web.contingencia.views.alertas.AlertaTransferenciaTela;
import pagina.web.contingencia.views.base.ContingenciaBaseTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class TransferenciaParaMimFunc extends FuncionalidadeBase {

    /**
     * Met�do para clicar no menu transfer�ncia ao logar no site da conting�ncia
     * @throws Exception
     * @return
     */
    public void acessarMenuTransferencia() throws Exception {
        new ContingenciaBaseTela(getWebDriver())
                .clicarMenuTransferencia();
    }

    /**
     * Met�do para informar os dados da tela de transfer�ncia TED
     *
     * @param conta
     * @param agencia
     * @param nome
     * @param finalidade
     * @param nomeTransferencia
     * @param valorTransferir
     * @param tipoConta
     * @throws Exception
     * @return
     */
    public void preencherDadosTransferenciaParaMim(
            String nome,
            String tipoConta,
            String valorTransferir,
            String finalidade,
            String nomeTransferencia,
            String agencia,
            String conta

    ) throws Exception {
        new TransferenciaParaQuemTela(getWebDriver())
                .clicarRadionButtonParaMim();
        new TransferenciaSelecionarInstituicaoContaTela(getWebDriver())
                .selecionarContaFavorecido(nome)
                .clicarRadioButtonConta(agencia, conta)
                .clicarBotaoConfirmar();
        new TransferenciaTipoContaTela(getWebDriver())
                .selecionarTipoConta(tipoConta);
        new TransferenciaOndeSaiDinheiroTela(getWebDriver())
                .selecionarTipoContaCorrente();
        new TransferenciaValorTela(getWebDriver())
                .informarValorTransferir(valorTransferir);
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
     * Met�do para informar os dados da tela de transfer�ncia TED
     * @param nome
     * @param tipoConta
     * @param valorTransferir
     * @param nomeTransferencia
     * @param agencia
     * @param conta
     * @throws Exception
     * @return
     */
    public void preencherDadosTransferenciaParaMimContaInterna(
            String nome,
            String tipoConta,
            String valorTransferir,
            String nomeTransferencia,
            String agencia,
            String conta

    ) throws Exception {
        new TransferenciaParaQuemTela(getWebDriver())
                .clicarRadionButtonParaMim();
        new TransferenciaSelecionarInstituicaoContaTela(getWebDriver())
                .selecionarContaFavorecido(nome)
                .clicarRadioButtonConta(agencia, conta)
                .clicarBotaoConfirmar();
        new TransferenciaTipoContaTela(getWebDriver())
                .selecionarTipoConta(tipoConta);
        new TransferenciaOndeSaiDinheiroTela(getWebDriver())
                .selecionarTipoContaCorrente();
        new TransferenciaValorTela(getWebDriver())
                .informarValorTransferir(valorTransferir);
        new TransferenciaNomeTransferenciaTela(getWebDriver())
                .informarNomeTransferencia(nomeTransferencia);
        new TransferenciaTela(getWebDriver())
                .clicarBotaoAvancar();
    }

    /**
     * Met�do para informar os dados da tela de transfer�ncia DOC
     * @throws Exception
     *
     * @param agencia
     * @param conta
     * @param nome
     * @param finalidade
     * @param nomeTransferencia
     * @param tipoConta
     * @param valorTransferir
     * @return
     */
    public void preencherDadosTransferenciaParaMimDoc(
            String nome,
            String tipoConta,
            String valorTransferir,
            String finalidade,
            String nomeTransferencia,
            String agencia,
            String conta

    ) throws Exception {
        new TransferenciaParaQuemTela(getWebDriver())
                .clicarRadionButtonParaMim();
        new TransferenciaSelecionarInstituicaoContaTela(getWebDriver())
                .selecionarContaFavorecido(nome)
                .clicarRadioButtonConta(agencia, conta)
                .clicarBotaoConfirmar();
        new TransferenciaTipoContaTela(getWebDriver())
                .selecionarTipoConta(tipoConta);
        new TransferenciaOndeSaiDinheiroTela(getWebDriver())
                .selecionarTipoContaCorrente();
        new TransferenciaValorTela(getWebDriver())
                .informarValorTransferir(valorTransferir);
        new TransferenciaTipoTela(getWebDriver())
                .clicarTransferirDoc();
        new TransferenciaFinalidadeTela(getWebDriver())
                .selecionarFinalidadeTransferencia(finalidade);
        new TransferenciaNomeTransferenciaTela(getWebDriver())
                .informarNomeTransferencia(nomeTransferencia);
        new TransferenciaTela(getWebDriver())
                .clicarBotaoAvancar();
    }

    /**
     * Met�do para validar os dados da transfer�ncia
     * @throws Exception
     *
     * @param nomeTransferencia
     * @param valorTransferir
     * @param finalidade
     * @param conta
     * @param tipoTransferencia
     * @param agencia
     * @param contaDestino
     * @param contaOrigem
     * @param cpf
     * @param deQuem
     * @param instituicao
     * @param paraQuem
     * @return
     */
    public void conferirDadosTransferencia(
             String deQuem,
             String paraQuem,
             String cpf,
             String instituicao,
             String agencia,
             String conta,
             String contaDestino,
             String contaOrigem,
             String valorTransferir,
             String tipoTransferencia,
             String finalidade,
             String nomeTransferencia

    ) throws Exception {
        new TransferenciaConferirDadosTela(getWebDriver())
                .validarTextoQuemTransfere(deQuem)
                .validarTextoParaQuemTransferir(paraQuem)
                .validarTextoCpfDeQuemTransfere(cpf)
                .validarBancoInsituicao(instituicao)
                .conferirAgenciaDestino(agencia)
                .conferirConta(conta)
                .conferirContaDestino(contaDestino)
                .conferirContaOrigem(contaOrigem)
                .conferirDataAtual()
                .conferirValorTransferencia(valorTransferir)
                .conferirTipoTransferencia(tipoTransferencia)
                .conferirFinalidadeTransferencia(finalidade)
                .conferirDescricaoTransferencia(nomeTransferencia);
    }

    /**
     * Met�do para validar os dados da transfer�ncia
     * @param deQuem
     * @param paraQuem
     * @param cpf
     * @param instituicao
     * @param agencia
     * @param contaDestino
     * @param contaOrigem
     * @param valorTransferir
     * @param finalidadeVerificacao
     * @param nomeTransferencia
     * @throws Exception
     * @return
     */
    public void conferirDadosTransferenciaContaInterna(
            String deQuem,
            String paraQuem,
            String cpf,
            String instituicao,
            String agencia,
            String contaDestino,
            String contaOrigem,
            String valorTransferir,
            String finalidadeVerificacao,
            String nomeTransferencia

            ) throws Exception {
        new TransferenciaConferirDadosTela(getWebDriver())
                .validarTextoQuemTransfere(deQuem)
                .validarTextoParaQuemTransferir(paraQuem)
                .validarTextoCpfDeQuemTransfere(cpf)
                .validarBancoInsituicao(instituicao)
                .conferirAgenciaDestino(agencia)
                .conferirContaDestino(contaDestino)
                .conferirContaOrigem(contaOrigem)
                .conferirDataAtual()
                .conferirValorTransferencia(valorTransferir)
                .conferirFinalidadeTransferencia(finalidadeVerificacao)
                .conferirDescricaoTransferencia(nomeTransferencia);
    }

    /**
     * Met�do para confirmar autoriza��o da TID
     * @throws Exception
     * @param senha
     * @return
     */
    public void confirmarTransferenciaTid (String senha) throws Exception {
        new TransferenciaTidFunc()
                .confirmarTidTransferencia(senha);
    }

    /**
     * Met�do para validar o alerta de transfer�ncia e clicar no bot�o para sair da popup
     * @throws Exception
     * @return
     */
    public void confirmarAlertaTransferencia() throws Exception {
        new AlertaTransferenciaTela(getWebDriver())
                .validarMensagemTransferenciaSucesso()
                .clicarBotaoVoltar();
    }
}
