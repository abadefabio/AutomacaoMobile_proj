package funcionalidade.mobile.configuracoes.perfil.configuracoes.pagamento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.configuracoes.perfil.FormaDePagamento;
import constantes.configuracoes.perfil.Teimosinha;
import pagina.mobile.jornadas.configuracoes.perfil.ConfiguracoesPerfilTela;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.ConfiguracoesPagamentosTela;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.EmprestimoPessoalTela;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.ProdutosCreditoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ConfiguracoesPagamentoFunc extends FuncionalidadeBase {

    /**
     * Método para alterar configuracao de pagamento
     *
     * @throws Exception
     */
    public void alterarConfiguracaoPagamento(String mensagem, Teimosinha repetirTentativaDebitoAutomatico, String saldoDevedorProcurado) throws Exception {
        new ConfiguracoesPagamentosTela(getDriver())
                .tocarEmprestimoPessoal()
                .tocarEmprestimoPessoalComSaldoDevedor(saldoDevedorProcurado);
        new EmprestimoPessoalTela(getDriver())
                .validarTelaEmprestimoPessoal();
        switch (repetirTentativaDebitoAutomatico){
            case REPETIR_TENTATIVAS_DEBITO_AUTOMATICO_SELECIONADO:
                new EmprestimoPessoalTela(getDriver())
                        .tocarCheckRepetirTentativasDebitoAutomatico();
        }
        new EmprestimoPessoalTela(getDriver())
                .tocarBotaoSalvar()
                .validarMensagemAlteracao(mensagem)
                .tocarBotaoOK();
        new ConfiguracoesPagamentosTela(getDriver())
                .validarTelaConfiguracoesPagamento()
                .validarEmprestimoPessoal();
    }

    /**
     * Método para alterar configuracao de pagamento
     *
     * @throws Exception
     */
    public void alterarConfiguracaoPagamentoUsarGranaEmergencia(String mensagem, Teimosinha repetirTentativaDebitoAutomatico, Teimosinha usarGranaEmergencia, String saldoDevedorProcurado) throws Exception {
        new ConfiguracoesPagamentosTela(getDriver())
                .tocarEmprestimoPessoal()
                .tocarEmprestimoPessoalComSaldoDevedor(saldoDevedorProcurado);
        new EmprestimoPessoalTela(getDriver())
                .validarTelaEmprestimoPessoal();
        switch (repetirTentativaDebitoAutomatico){
            case REPETIR_TENTATIVAS_DEBITO_AUTOMATICO_SELECIONAR:
            new EmprestimoPessoalTela(getDriver())
                    .tocarCheckRepetirTentativasDebitoAutomaticoSemSelecao();
        }
        switch (usarGranaEmergencia) {
            case GRANA_DE_EMERGENCIA:
            new EmprestimoPessoalTela(getDriver())
                    .tocarCheckUsarGranaEmergencia();
        }
        new EmprestimoPessoalTela(getDriver())
                .tocarBotaoSalvar()
                .validarMensagemAlteracao(mensagem)
                .tocarBotaoOK();
        new ConfiguracoesPagamentosTela(getDriver())
                .validarTelaConfiguracoesPagamento()
                .validarEmprestimoPessoal();
    }

    /**
     * Altera forma de pagamento dos produtos contratados
     *
     * @throws Exception
     */
    public void alteraFormaPagamentoProdutosContratados() throws Exception{
        new ConfiguracoesPagamentosTela(getDriver())
                .tocarCartaoDeCredito();
        selecionarFormaPagamentoCartao();
        new ProdutosCreditoTela(getDriver())
                .tocarBotaoSalvar()
                .validarFormaDePagamentoAtualizada()
                .tocarBotaoOk()
                .tocarBotaoVoltar();
        new ConfiguracoesPagamentosTela(getDriver())
                .validarTelaConfiguracoesPagamento();
        new ConfiguracoesPagamentosTela(getDriver())
                .tocarBotaoVoltar();
        new ConfiguracoesPerfilTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Método para alterar configuracao de pagamento Por boleto
     *
     * @throws Exception
     */
    public void alterarConfiguracaoPagamentoPorBoleto(String mensagem, Enum forma) throws Exception {
        new ConfiguracoesPagamentosTela(getDriver())
                .tocarEmprestimoPessoal();
        new EmprestimoPessoalTela(getDriver())
                .validarTelaEmprestimoPessoal();
        selecionarFormaPagamento(forma.toString());
        new EmprestimoPessoalTela(getDriver())
                .tocarBotaoSalvar()
                .validarMensagemAlteracao(mensagem)
                .tocarBotaoOK();
        new ConfiguracoesPagamentosTela(getDriver())
                .validarTelaConfiguracoesPagamento()
                .validarEmprestimoPessoal();
    }

    /**
     * Fluxo para selecionar  forma de pagamento
     *
     * FR
     * @throws Exception
     */
    public void selecionarFormaPagamento(String forma) throws Exception {
        switch (forma) {
            case "Por Boleto":
                new EmprestimoPessoalTela(getDriver())
                        .selecionarFormaPagamentoPorBoleto();
                break;
            case "Por Debito Automatico":
                new EmprestimoPessoalTela(getDriver())
                        .selecionarFormaPagamentoDebitoAuto();
                break;
        }
    }

    /**
     * Fluxo para selecionar forma de pagamento do cartão de crédito
     *
     * @throws Exception
     */
    public void selecionarFormaPagamentoCartao() throws Exception {
        var tipoPagamento = new ProdutosCreditoTela(getDriver()).tipoDePagamentoSelecionado() ?
                FormaDePagamento.POR_DEBITO_AUTOMATICO : FormaDePagamento.POR_BOLETO;

        switch (tipoPagamento) {
            case POR_BOLETO:
                new ProdutosCreditoTela(getDriver())
                        .tocarOpcaoBoleto();
                break;
            case POR_DEBITO_AUTOMATICO:
                new ProdutosCreditoTela(getDriver())
                        .tocarOpcaoPorDebitoAutomatico();
                break;
        }
    }
}
