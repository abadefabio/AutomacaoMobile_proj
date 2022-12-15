package funcionalidade.mobile.transferencia.para.outra;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela.retornaNomeContato;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.constantes.massa.contato.Contato;
import br.com.next.automacao.core.constantes.massa.contato.TipoContato;
import br.com.next.automacao.core.massa.contato.CriarContato;
import br.com.next.automacao.core.massa.contato.DadosContato;

import constantes.transferencia.CadastroContatoTransferencia;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.EditarContatoConta;
import constantes.transferencia.GeradorNumeros;
import constantes.transferencia.InstituicaoFinanceira;
import constantes.transferencia.MensagensEsperadas;
import constantes.transferencia.TipoDeInstituicaoFinanceira;
import framework.AcoesGerais;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.jornadas.transferencia.ListaInstituicoesTela;
import pagina.mobile.jornadas.transferencia.confereDados.ConfereDadosTela;
import pagina.mobile.jornadas.transferencia.para.ContatoTela;
import pagina.mobile.jornadas.transferencia.para.outra.EditarContatoTela;
import pagina.mobile.jornadas.transferencia.para.outra.MeuContatoContasTela;
import pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela;
import pagina.mobile.jornadas.transferencia.para.outra.NovoContatoTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirTipoContaDestinoTela;
import pagina.mobile.comum.next.PopUpTela;

public class MeusContatosFunc extends FuncionalidadeBase {

    /**
     * Criar novo contato outro banco pf via API
     *
     * @param tipoContato
     * @param cpf
     * @throws Exception
     */
    public void criarContatoOutroBancoPF(TipoContato tipoContato, String cpf) throws Exception {
        CriarContato.criarContato(TipoContato.OUTROS_BANCOS, cpf);
    }

    /**
     * recuperar o valor da conta outro banco pf via API
     *
     * @throws Exception
     */
    public String recuperarContaPF() throws Exception {
        return DadosContato.recuperarDadosContato(Contato.CONTA);
    }

    /**
     * Cadastrar novo contato
     *
     * @param instituicao
     * @throws Exception
     */
    public void cadastrarNovoContato(Enum instituicao, Enum mensagem) throws Exception {
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());

        new MeusContatosTela(getDriver())
                .tocarAbaNovoContato();
        new NovoContatoTela(getDriver())
                .tocarSelecioneBanco();
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(instituicao.toString());
        new NovoContatoTela(getDriver())
                .informarAgencia()
                .informarConta()
                .informarNomeAleatorio()
                .informarCpfNovoContato()
                .tocarSwitchSalvar()
                .tocarContinuar();
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoOk();
        if (getDriver() instanceof AndroidDriver) {
            new TransferirTela(getDriver())
                    .deslizarCortinaConfirmacao()
                    .validarCamposCortinaConfirmacao();
        }
        new TransferirTela(getDriver())
                .tocarFechar();

    }

    /**
     * Informar CPF inválido (na criação do primeiro contato)
     *
     * @param cpfInvalido
     * @throws Exception
     */
    public void informarCpfCnpjInvalidoContinuar(GeradorNumeros cpfInvalido, MensagensEsperadas mensagemCpfInvalido) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarAbaNovoContato();
        new NovoContatoTela(getDriver())
                .informarCpf(cpfInvalido.toString())
                .validarMensagemCpfInvalido(mensagemCpfInvalido.toString());
    }

    /**
     * Cadastrar novo contato
     *
     * @param conta, mensagem
     * @throws Exception
     */
    public void cadastrarContatoSemCpf(ContaPagamento conta, Enum mensagem) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarAbaNovoContato();
        new NovoContatoTela(getDriver())
                .tocarSelecioneBanco();
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(conta.recuperarBanco());
        new NovoContatoTela(getDriver())
                .informarAgencia(conta.recuperarAgencia())
                .informarConta(conta.recuperarConta())
                .informarNomeAleatorio()
                .tocarSwitchSalvar()
                .tocarContinuar();
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoOk();
        new TransferirTela(getDriver())
                .tocarFechar();
    }

    /**
     * Cadastrar novo contato
     *
     * @param dadosCadastro
     * @throws Exception
     */
    public void cadastrarContato(CadastroContatoTransferencia dadosCadastro) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarAbaNovoContato();
        new NovoContatoTela(getDriver())
                /*
                Rolagem personalizada para voltar ao topo da tela
                antes de selecionar radio button Banco ou Instituição Financeira
                */
                .rolarAteInicio();
        switch (dadosCadastro.recuperarContaPagamento().recuperarTipoInstituicao()) {
            case BANCO:
                new NovoContatoTela(getDriver())
                        .tocarRadioButtonBanco();
                break;
            case INSTITUICAO_DE_PAGAMENTO:
                new NovoContatoTela(getDriver())
                        .tocarRadioButtonInstituicaoPagamento();
                break;
        }
        new NovoContatoTela(getDriver())
                .tocarSelecioneBanco();
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(dadosCadastro.recuperarContaPagamento().recuperarBanco());
        new NovoContatoTela(getDriver())
                .informarAgencia(dadosCadastro.recuperarContaPagamento().recuperarAgencia())
                .informarConta(dadosCadastro.recuperarContaPagamento().recuperarConta())
                .informarNomeAleatorio();
        if (dadosCadastro.recuperarCadastrarCpf()) {
            new NovoContatoTela(getDriver())
                    .informarCpf(dadosCadastro.recuperarContaPagamento().recuperarCPF());
        }
        if (dadosCadastro.retornaSalvarContato()) {
            new NovoContatoTela(getDriver())
                    .tocarSwitchSalvar();
        }
        new NovoContatoTela(getDriver())
                .tocarContinuar();
        if (dadosCadastro.retornaSalvarContato()) {
            new PopUpTela(getDriver())
                    .validarMensagem(dadosCadastro.recuperarMensagemEsperada().toString())
                    .tocarBotaoOk();
        }
    }

    /**
     * Cadastrar novo contato
     *
     * @param conta
     * @throws Exception
     */
    public void cadastrarNovoContato(ContaPagamento conta) throws Exception {
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());
        new MeusContatosTela(getDriver())
                .tocarAbaNovoContato();
        switch (conta.recuperarTipoInstituicao()) {
            case BANCO:
                novoContatoTela
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
                novoContatoTela
                        .preencherCampoAgencia(conta.recuperarAgencia())
                        .preencherCampoConta(conta.recuperarConta());
                break;
            case INSTITUICAO_DE_PAGAMENTO:
                novoContatoTela
                        .tocarRadioButtonInstituicaoPagamento()
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
                novoContatoTela
                        .preencherCampoContaPagamento(conta.recuperarConta());
        }
        novoContatoTela
                .informarNomeAleatorio();
        if (!conta.recuperarBanco().contains("BRADESCO") && !conta.recuperarBanco().contains("NEXT")) {
            if (conta.recuperarCPF() == null) {
                novoContatoTela
                        .informarCpfNovoContato();
            } else {
                novoContatoTela
                        .informarCpf(conta.recuperarCPF());
            }
        }
        novoContatoTela
                .tocarSwitchSalvar();
        novoContatoTela
                .tocarContinuar();
        new PopUpTela(getDriver())
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_CRIACAO_CONTATO.toString())
                .tocarBotaoOk();
        new TransferirTela(getDriver())
                .tocarFechar();
    }

    /**
     * Cadastrar novo contato
     *
     * @param conta
     * @throws Exception
     */
    public void cadastrarNovoContato(ContaPagamento conta, boolean tocarSwitchSalvar, boolean tocarSwitchTED) throws Exception {
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());

        new MeusContatosTela(getDriver())
                .tocarAbaNovoContato();
        switch (conta.recuperarTipoInstituicao()) {
            case BANCO:
                novoContatoTela
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
                novoContatoTela
                        .preencherCampoAgencia(conta.recuperarAgencia());
                break;
            case INSTITUICAO_DE_PAGAMENTO:
                novoContatoTela
                        .tocarRadioButtonInstituicaoPagamento()
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
        }
        novoContatoTela
                .preencherCampoConta(conta.recuperarConta())
                .informarNomeAleatorio();
        if (!conta.recuperarBanco().contains("BRADESCO") && !conta.recuperarBanco().contains("NEXT")) {
            if (conta.recuperarCPF() == null) {
                novoContatoTela
                        .informarCpf();
            } else {
                novoContatoTela
                        .informarCpf(conta.recuperarCPF());
            }
        }
        if (tocarSwitchSalvar) {
            novoContatoTela
                    .tocarSwitchSalvar();
        }
        if (tocarSwitchTED) {
            novoContatoTela
                    .tocarSwitchTED();
        }
        novoContatoTela
                .tocarContinuar();
        new PopUpTela(getDriver())
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_CRIACAO_CONTATO.toString())
                .tocarBotaoOk();
        new TransferirTela(getDriver())
                .tocarFechar();
    }

    /**
     * Realizar cadastro de pessoa:
     * - Nome
     * - E-mail
     * - Celular
     * - CPF
     * - Banco
     *
     * @throws Exception
     */
    public void realizarCadastroPessoa() throws Exception {
        new NovoContatoTela(getDriver())
                .informarNome()
                .informarEmail()
                .informarCelular()
                .informarCpf()
                .tocarAdicionarConta()
                .tocarSelecioneBanco();
    }

    /**
     * Realizar Cadastro Conta:
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
        new NovoContatoTela(getDriver())
                .informarAgencia()
                .informarConta()
                .tocarSalvar();
        new PopUpTela(getDriver())
                .tocarBotaoOk();
    }

    /**
     * Valida Contato Cadastrado na tela de Contatos
     * !!!! O método somente funciona se não houverem outros contatos cadastrados!!!!!!!!
     *
     * @throws Exception
     */
    public void validarCadastroContato() throws Exception {
        new ContatoTela(getDriver())
                .validarContaSalva()
                .validarAgenciaSalva();
    }

    /**
     * Valida o campo Cpf/Cnpj
     *
     * @throws Exception
     */
    public void validarCpfCnpj(GeradorNumeros cpfCnpj) throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa(retornaNomeContato())
                .validarPresencaContato();
        new MeusContatosTela(getDriver())
                .pressionarPrimeiroContatoCirculo()
                .tocarEditarContato();
        new NovoContatoTela(getDriver())
                .validarCpfCnpj(cpfCnpj.toString())
                .tocarBotaoVoltar();
    }

    /**
     * Valida a edição do contato.
     *
     * @throws Exception
     */
    public void validarEdicaoContato(InstituicaoFinanceira instituicao, MensagensEsperadas mensagem) throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa()
                .pressionarIconeContato()
                .tocarEditarContato();
        new EditarContatoTela(getDriver())
                .tocarSelecioneBanco();
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(instituicao.toString());
        new EditarContatoTela(getDriver())
                .informarNomeAleatorio()
                .informarCpf()
                .informarAgencia()
                .informarConta()
                .tocarSalvar();
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoOk();
    }

    /**
     * Fluxo de exclusão do contato, sem confirmação
     *
     * @throws Exception
     */
    public void excluirContatoSemConfirmacao() throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa()
                .pressionarIconeContato()
                .tocarExcluirContato();
    }

    /**
     * Fluxo de exclusão do contato, com confirmação
     *
     * @throws Exception
     */
    public void excluirContatoComConfirmacao(Enum mensagem) throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa()
                .pressionarIconeContato()
                .tocarExcluirContato();
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoSim()
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_EXCLUSAO.toString())
                .tocarBotaoOk();
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa()
                .validarPresencaContato(false);
    }

    /**
     * Fluxo de exclusão do contato, com confirmação
     *
     * @throws Exception
     */
    public void excluirContatoComConfirmacaoSemContatoPrevioCadastrado(Enum mensagem) throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa()
                .pressionarIconeContato()
                .tocarExcluirContato();
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoSim()
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_EXCLUSAO.toString())
                .tocarBotaoOk();
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());
        new MeusContatosTela(getDriver())
                .validarPresencaContato(false); // false: valida OK se não encontrar.
    }

    /**
     * Fluxo de validação de exlusão do contato
     *
     * @param mensagem
     * @throws Exception
     */
    public void validarConfirmacaoExclusao(Enum mensagem) throws Exception {
        MeusContatosTela meusContatosTela = new MeusContatosTela(getDriver());

        meusContatosTela
                .tocarBotaoConfirmar();
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoOk();
        meusContatosTela
                .preencherBarraPesquisa()
                .validarPresencaContato(false);
    }

    /**
     * Validade contato não tem circulo verde
     *
     * @throws Exception
     */
    public void validarContatoSemCirculoVerde() throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa(retornaNomeContato());
        //TODo finalizar método para validar circuloverde
    }

    /**
     * Validar novo contato salvo na tela Meus Contatos
     *
     * @param contatoSalvo: true - validar contato salvo, false - validar contato não salvo
     * @throws Exception
     */
    public void validarNovoContatoSalvo(boolean contatoSalvo) throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa(retornaNomeContato())
                .validarPresencaContato(contatoSalvo);
    }

    /**
     * Validar novo contato salvo na tela Meus Contatos
     *
     * @throws Exception
     */
    public void validarNovoContatoSalvo() throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa(retornaNomeContato())
                .validarPresencaContato();
    }

    /**
     * Toca no botão fechar na tela Meus Contatos
     *
     * @throws Exception
     */
    public void fecharMeusContatos() throws Exception {
        new MeusContatosTela(getDriver())
                .tocarFechar();
    }

    /**
     * Fluxo de validação de cancelamento de exlusão do contato
     *
     * @throws Exception
     */
    public void validarCancelamentoExclusao() throws Exception {
        new MeusContatosTela(getDriver())
                .tocarBotaoCancelar()
                .validarExibicaoIconesExcluirEditar()
                .preencherBarraPesquisa()
                .validarPresencaContato(true);
    }

    /**
     * Cadastrar novo contato e continuar para transferencia
     *
     * @param instituicao
     * @param mensagem
     * @param agencia
     * @throws Exception
     */
    public void cadastrarNovoContatoParaTransferir(Enum instituicao, Enum mensagem, String agencia) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarAbaNovoContato();
        new NovoContatoTela(getDriver())
                .tocarSelecioneBanco();
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(instituicao.toString());
        new NovoContatoTela(getDriver())
                .informarAgencia(agencia)
                .informarConta()
                .informarNomeAleatorio()
                .informarCpf()
                .tocarSwitchSalvar()
                .tocarContinuar();
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoOk();
        if (getDriver() instanceof AndroidDriver) {
            new TransferirTela(getDriver())
                    .deslizarCortinaConfirmacao();
        }
    }

    /**
     * Fluxo para encontrar conta na tela Minhas Contas
     *
     * @throws Exception
     */
    public void encontrarCadastro() throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa()
                .tocarContatoCirculo();
    }

    /**
     * Fluxo para encontrar conta Bradescard  na tela Minhas Contas
     *
     * @throws Exception
     */
    public void encontrarContaCadastrada(Enum contaBradescard) throws Exception {
        new ConfereDadosTela(getDriver())
                .validarContaTipoPagamento(contaBradescard);
        new MeusContatosTela(getDriver())
                .tocarFechar();
    }

    /**
     * Cadastrar novo contato sem acessar aba Novo Contato e sim direto pelo btn +
     *
     * @param conta
     * @throws Exception
     */
    public void cadastrarNovaContaEmUmContatoExistente(ContaPagamento conta, boolean tocarSwitchSalvar, boolean tocarSwitchTED, boolean outroBancosInstituicao) throws Exception {
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());
        if (outroBancosInstituicao) {
            new MeusContatosTela(getDriver())
                    .tocarAbaNovoContato();
        }
        switch (conta.recuperarTipoInstituicao()) {
            case BANCO:
                new NovoContatoTela(getDriver())
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
                new NovoContatoTela(getDriver())
                        .preencherCampoAgencia(conta.recuperarAgencia());
                break;
            case INSTITUICAO_DE_PAGAMENTO:
                new NovoContatoTela(getDriver())
                        .tocarRadioButtonInstituicaoPagamento()
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
        }
        if (outroBancosInstituicao) {
            novoContatoTela
                    .informarConta()
                    .informarNomeAleatorio()
                    .informarCpf()
                    .tocarSwitchSalvar();
        } else {

            new NovoContatoTela(getDriver())
                    .informarContaPagamento();
        }
        new NovoContatoTela(getDriver())
                .tocarSwitchTED();
        new NovoContatoTela(getDriver())
                .tocarSalvar();
        new TransferirTela(getDriver())
                .tocarFechar();
        new TransferirTela(getDriver())
                .tocarFechar();
    }

    public void cadastrarNovaContaEmUmContatoExistente(ContaPagamento conta) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarAdicionarConta();
        new NovoContatoTela(getDriver())
                .tocarRadioButtonInstituicaoPagamento()
                .tocarSelecioneBanco();
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(conta.recuperarBanco());
        if (conta.recuperarTipoInstituicao().equals(TipoDeInstituicaoFinanceira.INSTITUICAO_DE_PAGAMENTO)) {
            new NovoContatoTela(getDriver())
                    .informarContaPagamento();
        } else {
            new NovoContatoTela(getDriver())
                    .informarConta();
        }
        new NovoContatoTela(getDriver())
                .tocarSwitchTED();
        new NovoContatoTela(getDriver())
                .tocarSalvar();
        new TransferirTela(getDriver())
                .tocarFechar();
        new TransferirTela(getDriver())
                .tocarFechar();
    }

    /**
     * Fluxo para encontrar conta na tela Minhas Contas e validar
     *
     * @throws Exception
     */
    public void encontrarCadastroValidacao() throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa()
                .validarPresencaContaContatos();
    }

    /**
     * Seleciona contato outra pessoa
     *
     * @throws Exception
     */
    public void selecionarContatoOutraPessoa(ContaPagamento contaPagamento) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarContatosInstituicaoBancariaOutraPessoa(contaPagamento);
        new MeuContatoContasTela(getDriver())
                .tocarContaBancoContato(contaPagamento);
    }

    /**
     * Fluxo de Edição de Cadastro de Instituição de Pagamento
     *
     * @throws Exception
     */
    @Deprecated
    public void editarCadastroContato(ContaPagamento conta) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarAbaContato()
                .preencherBarraPesquisa()
                .pressionarIconeContato()
                .tocarIconeEditarContato();
        switch (conta.recuperarTipoInstituicao()) {
            case BANCO:
                new NovoContatoTela(getDriver())
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
                new NovoContatoTela(getDriver())
                        .preencherCampoAgencia(conta.recuperarAgencia());
                break;
            case INSTITUICAO_DE_PAGAMENTO:
                new NovoContatoTela(getDriver())
                        .tocarRadioButtonInstituicaoPagamento()
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
        }
        new NovoContatoTela(getDriver())
                .preencherCampoConta(conta.recuperarConta());
        new NovoContatoTela(getDriver())
                .tocarSalvar();
        new PopUpTela(getDriver())
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_EDICAO_CONTATO.toString())
                .tocarBotaoOk();
    }

    /**
     * Fluxo de Edição de Cadastro de Instituição de Pagamento
     *
     * @throws Exception
     */
    public void editarCadastroContatoCnpjParaCpf(CadastroContatoTransferencia dadosCadastro, GeradorNumeros novoCpf, MensagensEsperadas mensagemEdicao) throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa(retornaNomeContato())
                .validarPresencaContato();
        new MeusContatosTela(getDriver())
                .pressionarNomeContatoCirculo()
                .tocarEditarContato();
        new NovoContatoTela(getDriver())
                .informarCpf(novoCpf.toString());
        new NovoContatoTela(getDriver())
                .tocarSalvar();
        new PopUpTela(getDriver())
                .validarMensagem(mensagemEdicao.toString())
                .tocarBotaoOk();
        new TransferirTela(getDriver())
                .tocarFechar();
    }

    /**
     * Fluxo de Edição de Cadastro (Remove ou Adiciona Conta no Contato)
     */
    @Deprecated
    public void editarCadastroContato(EditarContatoConta editarContatoConta) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarAbaContato()
                .preencherBarraPesquisa()
                .pressionarIconeContato()
                .tocarIconeEditarContato();
        switch (editarContatoConta) {
            case REMOVER:
                // Remover conta no Contato (-Remover)
                new MeusContatosTela(getDriver())
                        .tocarRemoverConta();
                new PopUpTela(getDriver())
                        .validarMensagem(MensagensEsperadas.CONFIRMACAO_EXCLUSAO_CONTA.toString())
                        .tocarBotaoSim();
                break;
            case ADICIONAR:
                // Adicionar conta no Contato (+Adicionar)
                new MeusContatosTela(getDriver())
                        .tocarAdicionarConta();
                /*
                ...
                */
                break;
        }
        new NovoContatoTela(getDriver())
                .tocarSalvar();
        new PopUpTela(getDriver())
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_EDICAO_CONTATO.toString())
                .tocarBotaoOk();
    }

    /**
     * Fluxo até a tela de 'Editar Cadastro'
     * Contato > Preencher Barra de pesquisa > Icone Contato (Pressionar) > Icone Editar Contato (Lapis)
     *
     * @throws Exception -
     */
    public void acessarTelaEditarContato() throws Exception {
        new MeusContatosTela(getDriver())
                .tocarAbaContato()
                .pesquisaContato()
                .pressionarIconeContato()
                .tocarIconeEditarContato();
    }


    /**
     * Seleciona o primeiro contato disponível na tela (para uso quando há apenas 1 contato)
     * Em seguida, seleciona a conta da conta/agência solicitada.
     *
     * @throws Exception
     */
    public void selecionarContatoContaAgencia(ContaPagamento contaPagamento) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarContato(contaPagamento.recuperarContato());
        new MeuContatoContasTela(getDriver())
                .tocarContaPagamentoAgenciaContato(contaPagamento);
    }

    /**
     * Seleciona contato setado no enum
     *
     * @param contaPagamento
     * @throws Exception
     */
    public void selecionarContatoContaAgenciaComPesquisa(ContaPagamento contaPagamento) throws Exception {
        new MeusContatosTela(getDriver())
                .pesquisaContato(contaPagamento.recuperarBanco())
                .selecionarContato();
        new MeuContatoContasTela(getDriver())
                .tocarContaPagamentoAgenciaContato(contaPagamento);
    }

    /**
     * Validar que o contato não foi salvo
     * Primeiro verificamos se o contato existe na tela apenas para
     * obter evidência de que não existe um contato.
     * Depois, validamos que a tela é a de Novo Contato
     * para obter evidência de que o fluxo está correto.
     *
     * @throws Exception
     */
    public void validarContatoNaoSalvoAposTransferenciaSemContatoPrevioCadastrado() throws Exception {
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());
        new MeusContatosTela(getDriver())
                .validarPresencaContato(false); // false: valida OK se não encontrar.
        new NovoContatoTela(getDriver())
                .validarTela();
    }

    /**
     * Validar novo contato salvo na tela Meus Contatos
     *
     * @param contatoSalvo: true - validar contato salvo, false - validar contato não salvo
     * @throws Exception
     */
    public void selecionarContaContatoPF(boolean contatoSalvo, String conta) throws Exception {
        String nomeContato = DadosContato.recuperarDadosContato(Contato.NOME);
        String sobreNome = DadosContato.recuperarDadosContato(Contato.SOBRENOME);

        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa(nomeContato)
                .validarPresencaContatoInformado(contatoSalvo, nomeContato)
                .tocarContatoCirculo();
        new MeuContatoContasTela(getDriver())
                .tocarContaBancoContato(conta);
        if (getDriver() instanceof AndroidDriver) {
            new TransferirTela(getDriver())
                    .deslizarCortinaConfirmacao()
                    .validarCamposCortinaConfirmacaoInformada();
        }
        new TransferirTela(getDriver())
                .ocultarFaixaDropdown();
        new TransferirTipoContaDestinoTela(getDriver())
                .tocarRadioButtonPoupanca()
                .tocarBotaoContinuar();
    }

    /**
     * Validar novo contato salvo na tela Meus Contatos
     *
     * @throws Exception
     */
    public void selecionarContaContatoPF(String nome, String sobreNome, String cpf, String banco, String agencia, String conta) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarContato("AUTOMACAO");
        new MeuContatoContasTela(getDriver())
                .tocarContaAgenciaContato(TipoDeInstituicaoFinanceira.BANCO, conta, "", agencia);
        if (getDriver() instanceof AndroidDriver) {
            new TransferirTela(getDriver())
                    .deslizarCortinaConfirmacao()
                    .ValidarCamposCortinaConfirmacaoInformada(nome, sobreNome, cpf, banco, agencia, conta);
        }
        new TransferirTela(getDriver())
                .ocultarFaixaDropdown();
        new TransferirTipoContaDestinoTela(getDriver())
                .tocarRadioButtonPoupanca()
                .tocarBotaoContinuar();
    }

    /**
     * Pesquisar o contato criado via API para fazer a exclusão do mesmo
     *
     * @throws Exception
     */
    public void buscarContatoParaExcluir() throws Exception {
        String nomeSobreNomeContato = DadosContato.recuperarDadosContato(Contato.NOME) + " " + DadosContato.recuperarDadosContato(Contato.SOBRENOME);
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa(nomeSobreNomeContato)
                .pressionarIconeContato()
                .tocarExcluirContato();
    }

    /**
     * Validar novo contato salvo na tela Meus Contatos
     *
     * @throws Exception
     */
    public void validarNovoContatoSalvoNv() throws Exception {
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa()
                .pressionarIconeContato()
                .tocarEditarContato();
    }

    /**
     * Validar que o contato não foi salvo
     *
     * @throws Exception
     */
    public void validarContatoNaoSalvoAposTransferencia() throws Exception {
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());
        new MeusContatosTela(getDriver())
                .validarPresencaMeusContatos()
                .validarPresencaContato(false); // false: valida OK se não encontrar.
    }

    /**
     * Tocar no primeiro contato da lista
     *
     * @throws Exception
     */
    public void selecionarPrimeiroContato() throws Exception {
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());
        new MeusContatosTela(getDriver())
                .tocarContato();
    }

    /**
     * Excluir a conta do contato
     *
     * @throws Exception
     */
    public void excluirContaDoContato() throws Exception {
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());
        new MeusContatosTela(getDriver())
                .tocarBotaoAcoesExtras()
                .tocarExcluirConta()
                .tocarBotaoNaoMensagem()
                .tocarExcluirConta()
                .tocarBotaoSimMensagem()
                .tocarBotaoFechar();
    }

    /**
     * Excluir o contato
     *
     * @throws Exception
     */
    public void excluirContato() throws Exception {
        NovoContatoTela novoContatoTela = new NovoContatoTela(getDriver());
        new MeusContatosTela(getDriver())
                .tocarBotaoAcoesExtras()
                .tocarExcluirContato()
                .tocarBotaoNaoMensagem()
                .tocarExcluirContato()
                .tocarBotaoSimMensagem()
                .validarTelaTransferencias();

    }

}
