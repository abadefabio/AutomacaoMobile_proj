package funcionalidade.mobile.transferencia.para.mim;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import constantes.transferencia.ContaPagamento;
import constantes.transferencia.MensagensEsperadas;
import constantes.transferencia.TipoDeInstituicaoFinanceira;
import pagina.mobile.jornadas.transferencia.ListaInstituicoesTela;
import pagina.mobile.jornadas.transferencia.TransferenciaTela;
import pagina.mobile.jornadas.transferencia.para.mim.MinhasContasTela;
import pagina.mobile.jornadas.transferencia.para.mim.NovaContaTela;
import pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirTela;
import pagina.mobile.comum.next.PopUpTela;

public class MinhasContasFunc extends FuncionalidadeBase {

    /**
     * Realizar Cadastro Conta
     * - Instituição Financeira;
     * - Agência (valor aleatório)
     * - Conta (valor aleatório)
     *
     * @param instituicao
     * @throws Exception
     */
    public void realizarCadastroNovaConta(Enum instituicao, TipoDeInstituicaoFinanceira tipoInstituicao) throws Exception {
        switch (tipoInstituicao) {
            case BANCO:
                new MinhasContasTela(getDriver())
                        .tocarAdicionarConta();
                new NovaContaTela(getDriver())
                        .tocarCaixaSelecaoInstituicao();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(instituicao.toString());
                new NovaContaTela(getDriver())
                        .informarAgencia()
                        .informarConta()
                        .validarAutorizadoTED()
                        .tocarBotaoSalvar();
                new TransferirTela(getDriver())
                        .validarExibicaoTelaTransferir();
                break;
            case INSTITUICAO_DE_PAGAMENTO:
                new MinhasContasTela(getDriver())
                        .tocarAdicionarConta();
                new NovaContaTela(getDriver())
                        .selecionarRadioInstituicaoDePagamento()
                        .tocarCaixaSelecaoInstituicao();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(instituicao.toString());
                new NovaContaTela(getDriver())
                        .validarInstituicaoPagamentoSelecionado(instituicao)
                        .informarContaPagamento()
                        .validarAutorizadoTED()
                        .tocarBotaoSalvar();
                new TransferirTela(getDriver())
                        .validarExibicaoTelaTransferir();
                break;
        }
    }

    /**
     * Realizar Cadastro Conta para transferência
     *
     * @param conta
     * @throws Exception
     */
    public void realizarCadastroNovaConta(ContaPagamento conta) throws Exception {
        new MinhasContasTela(getDriver())
                .tocarAdicionarConta();
        switch (conta.recuperarTipoInstituicao()) {
            case BANCO:
                new NovaContaTela(getDriver())
                        .tocarCaixaSelecaoInstituicao();
                break;
            case INSTITUICAO_DE_PAGAMENTO:
                new NovaContaTela(getDriver())
                        .selecionarRadioInstituicaoDePagamento()
                        .tocarCaixaSelecaoInstituicao();
        }
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(conta.recuperarBanco());
        new NovaContaTela(getDriver())
                .preencherCampoAgencia(conta.recuperarAgencia())
                .preencherCampoConta(conta.recuperarConta())
                .tocarBotaoSalvar();
        new TransferirTela(getDriver())
                .validarExibicaoTelaTransferir();
    }

    /**
     * Realizar Cadastro Conta para transferência
     *
     * @param conta
     * @throws Exception
     */
    public void realizarCadastroNovaConta(ContaPagamento conta, boolean alterarTED, boolean resultadoEsperadoAlteracaoSwitchTED) throws Exception {
        new MinhasContasTela(getDriver())
                .tocarAdicionarConta();
        switch (conta.recuperarTipoInstituicao()) {
            case BANCO:
                new NovaContaTela(getDriver())
                        .tocarCaixaSelecaoInstituicao();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
                new NovaContaTela(getDriver())
                        .preencherCampoAgencia(conta.recuperarAgencia())
                        .preencherCampoConta(conta.recuperarConta());
                break;
            case INSTITUICAO_DE_PAGAMENTO:
                new NovaContaTela(getDriver())
                        .selecionarRadioInstituicaoDePagamento()
                        .tocarCaixaSelecaoInstituicao();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
                new NovaContaTela(getDriver())
                        .preencherContaPagamento(conta.recuperarConta());
        }
        if (alterarTED) {
            new NovaContaTela(getDriver())
                    .tocarSwitchTED()
                    .validarAlteracaoSwitchTED(resultadoEsperadoAlteracaoSwitchTED);

        }
        new NovaContaTela(getDriver())
                .tocarBotaoSalvar();
        new TransferirTela(getDriver())
                .validarExibicaoTelaTransferir();
    }

    /**
     * Realizar Cadastro Conta
     * - Instituição Financeira(Contato Excluído)
     * - Agência(Contato Excluído)
     * - Conta(Contato Excluído)
     *
     * @throws Exception
     */
    public void realizarRecadastroContaExcluida() throws Exception {
        new MinhasContasTela(getDriver())
                .tocarAdicionarConta();
        new NovaContaTela(getDriver())
                .selecionarTipoDeInstituicaoConta()
                .tocarCaixaSelecaoInstituicao();
        new ListaInstituicoesTela(getDriver())
                .preencherCampoBuscaInstituicaoInicial()
                .selecionarInstituicao()
                .confirmarSelecaoInstituicao();
        new NovaContaTela(getDriver())
                .recadastrarAgencia()
                .recadastrarConta()
                .tocarBotaoSalvar();
        new TransferirTela(getDriver())
                .validarExibicaoTelaTransferir()
                .tocarFechar();
        new MeusContatosTela(getDriver())
                .tocarBotaoFechar();
        new TransferenciaTela(getDriver())
                .tocarBotaoParaMim();
        new MinhasContasTela(getDriver())
                .validarPresencaConta(true);
    }

    /**
     * Salva as informações da nova conta informada
     *
     * @throws Exception
     */
    public void salvarCadastroNovaConta() throws Exception {
        new NovaContaTela(getDriver())
                .tocarBotaoSalvar();
    }

    /**
     * Atualizar Contato Novo Banco
     *
     * @throws Exception
     */
    public void atualizarContatoNovoBanco() throws Exception {
        new MinhasContasTela(getDriver())
                .manterPressionadoBanco()
                .tocarBotaoEdicaoConta()
                .abrirlistaIntituicoesPagamento()
                .selecionarIntituicaoLista()
                .confirmarSelecaoInstituicao()
                .validarAlteracaoInstituicao();
    }

    /**
     * Fluxo de Exclusão de Contato até PopUP de confirmação
     *
     * @param instituicao
     * @throws Exception
     */
    public void excluirContatoSemConfirmar(Enum instituicao) throws Exception {
        new MinhasContasTela(getDriver())
                .rolarAteInstituicao(instituicao)
                .manterContatoPressionado()
                .tocarBotaoExclusaoConta();
    }

    /**
     * Fluxo de validação do cancelamento da exclusão de contato
     *
     * @throws Exception
     */
    public void validarCancelarExclusaoContato() throws Exception {
        new MinhasContasTela(getDriver())
                .tocarBotaoCancelar()
                .retornarParaTopoTela()
                .rolarAteConta()
                .validarPresencaConta(true);
    }

    /**
     * Fluxo de validação da confirmação da exclusão de contato
     *
     * @throws Exception
     */
    public void validarConfirmarExclusaoContato() throws Exception {
        MinhasContasTela minhasContasTela = new MinhasContasTela(getDriver());

        minhasContasTela
                .armazenarDadosContaInicial();
        new PopUpTela(getDriver())
                .tocarBotaoSim()
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_EXCLUSAO.toString())
                .tocarBotaoOk();
        minhasContasTela
                .retornarParaTopoTela()
                .validarPresencaConta(false);
    }

    /**
     * Salvar Alterações Minha Conta
     *
     * @throws Exception
     */
    public void salvarAlteracoesMinhaConta() throws Exception {
        new MinhasContasTela(getDriver())
                .salvarAlteracoes()
                .validarSalvamentoTrocaInstituicao();
    }

    /**
     * Acessar aba nova conta
     *
     * @throws Exception
     */
    public void acessarAbaNovaConta() throws Exception {
        new MinhasContasTela(getDriver())
                .tocarAdicionarConta();
    }

    /**
     * Realizar Cadastro Conta
     * - Instituição Financeira;
     * - Agência (valor aleatório)
     * - Conta (valor aleatório)
     *
     * @param instituicao
     * @throws Exception
     */
    public void realizarCadastroConta(String instituicao) throws Exception {
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(instituicao);
        new NovaContaTela(getDriver())
                .informarAgencia()
                .informarConta()
                .tocarBotaoSalvar();
    }

    /**
     * Validar Cadastro Contato, quando cpf já tem contato cadastrado
     *
     * @throws Exception
     */
    public void validarContatoEmTela() throws Exception {
        new MinhasContasTela(getDriver())
                .retornarParaTopoTela()
                .validarPresencaConta(true);
    }

    /**
     * Validar Conta encontrada em tela
     *
     * @throws Exception
     */
    public void validarContaEmTela() throws Exception {
        new MinhasContasTela(getDriver())
                .retornarParaTopoTela()
                .validarPresencaConta(true);
    }

    /**
     * Fechar tela "Minhas Contas"
     *
     * @throws Exception
     */
    public void fecharTelaMinhasContas() throws Exception {
        new MinhasContasTela(getDriver())
                .tocarBotaoFechar();
    }

    /**
     * Excluir Contato Criado
     *
     * @throws Exception
     */
    public void excluirContatoCriado() throws Exception {
        MinhasContasTela minhasContasTela = new MinhasContasTela(getDriver());

        minhasContasTela
                .rolarAteConta()
                .manterContatoPressionado()
                .tocarBotaoExclusaoConta();
        new PopUpTela(getDriver())
                .tocarBotaoSim()
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_EXCLUSAO.toString())
                .tocarBotaoOk();
        minhasContasTela
                .validarPresencaConta(false);
    }

    /**
     * Excluir Conta Adicionada em Minhas Contas
     *
     * @throws Exception
     */
    public void excluirContaAdicionada() throws Exception {
        MinhasContasTela minhasContasTela = new MinhasContasTela(getDriver());

        minhasContasTela
                .rolarAteConta()
                .manterContatoPressionado()
                .tocarBotaoExclusaoConta();
        new PopUpTela(getDriver())
                .tocarBotaoSim()
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_EXCLUSAO.toString())
                .tocarBotaoOk();
        minhasContasTela
                .retornarParaTopoTela()
                .validarPresencaConta(false);
    }

    /**
     * Editar Instituição de Conta cadastrada
     *
     * @param instituicaoOriginal
     * @param novaInstituicao
     * @throws Exception
     */
    public void editarInstituicaoConta(Enum instituicaoOriginal, Enum novaInstituicao) throws Exception {
        new MinhasContasTela(getDriver())
                .rolarAteInstituicao(instituicaoOriginal)
                .manterContatoPressionado()
                .armazenarDadosContaInicial()
                .tocarBotaoEdicaoConta();
        new NovaContaTela(getDriver())
                .tocarCaixaSelecaoInstituicao();
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(novaInstituicao.toString());
        new NovaContaTela(getDriver())
                .tocarBotaoSalvar();
        new MinhasContasTela(getDriver())
                .validarPresencaConta(true);
    }

    /**
     * Restaurar dados originais da conta, anteriores a edição.
     *
     * @throws Exception
     */
    public void retornarDadosOriginaisConta() throws Exception {
        new MinhasContasTela(getDriver())
                .rolarAteConta()
                .manterContatoPressionado()
                .tocarBotaoEdicaoConta();
        new NovaContaTela(getDriver())
                .selecionarTipoDeInstituicaoConta()
                .tocarCaixaSelecaoInstituicao();
        new ListaInstituicoesTela(getDriver())
                .preencherCampoBuscaInstituicaoInicial()
                .selecionarInstituicao()
                .confirmarSelecaoInstituicao();
        new NovaContaTela(getDriver())
                .recadastrarAgencia()
                .recadastrarConta()
                .tocarBotaoSalvar();
        new MinhasContasTela(getDriver())
                .validarPresencaConta(true);
    }

    /**
     * clicar botão confirmar popup
     *
     * @throws Exception
     */
    public void tocarBotaoConfirmarPopup() throws Exception {
        new PopUpTela(getDriver())
                .tocarBotaoSim();
    }

    /**
     * Selecionar minha conta
     *
     * @param conta
     * @throws Exception
     */
    public void selecionarMinhaConta(ContaPagamento conta) throws Exception {
        new MinhasContasTela(getDriver())
                .tocarContaAgenciaContato(conta);
    }

    /**
     * Selecionar minha conta pelo nome passado pelo param
     *
     * @param conta,agencia
     * @throws Exception
     */
    public void selecionarMinhaContaPorNome(String conta, String agencia) throws Exception {

        new MinhasContasTela(getDriver())
                .tocarContaPagamentoContatoJSON(conta,agencia);
    }
}
