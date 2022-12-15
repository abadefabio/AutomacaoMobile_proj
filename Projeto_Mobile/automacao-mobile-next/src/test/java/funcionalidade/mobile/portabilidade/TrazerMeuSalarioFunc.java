package funcionalidade.mobile.portabilidade;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.constantes.massa.tdm.StatusPortabilidade;
import br.com.next.automacao.core.massa.tdm.PortabilidadeTdm;
import constantes.portabilidade.PortabilidadeDados;
import io.appium.java_client.ios.IOSDriver;
import org.json.simple.JSONObject;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.portabilidade.ComprovanteContestacao;
import pagina.mobile.jornadas.portabilidade.ComprovanteTela;
import pagina.mobile.jornadas.portabilidade.InformacoesTela;
import pagina.mobile.jornadas.portabilidade.TermosCondicoes;
import pagina.mobile.jornadas.portabilidade.TrazerMeuSalarioTela;
import pagina.mobile.jornadas.portabilidade.VerDetalhesTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class TrazerMeuSalarioFunc extends FuncionalidadeBase {


    /**
     * Alterar status da portabilidade
     *
     * @throws Exception
     */
    public void alterarStatusPortabilidade(String cpf, StatusPortabilidade statusPortabilidade) throws Exception {
        PortabilidadeTdm.alterarStatusPortabilidade(cpf, statusPortabilidade);
    }


    /**
     * Método para excluir número, através da opção 'Editar'
     *
     * @throws Exception
     */

    public void tocarBotaoNao() throws Exception {

    }

    /**
     * Método para excluir número, através da opção 'Editar'
     *
     * @throws Exception
     */

    public void tocarBotaoSim() throws Exception {
        new PopUpTela(getDriver())
                .tocarBotaoSim();
    }


    /**
     * Tocar botão ver detalhe na tela de contestar portabilidade
     *
     * @throws Exception
     */
    public void botaoVerDetalheContestar() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVerDetalhesPortabilidadeConcluida();

    }

    /**
     * Validar mensagem do comprovante de agendamento
     *
     * @throws Exception
     */
    public void validarMensagemPortabilidadeEmAnalise() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .validarMensagemPortabiliadeEmAnalise();
    }

    /**
     * Acessa 'Ver Detalhes' de PortabilidadeDados
     *
     * @throws Exception
     */
    public void tocarVerDetalhesPortabilidade(String cnpj) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj);
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoDetalhesPedidoAndamento();
        new VerDetalhesTela(getDriver())
                .validartextoVerDetalhesPedidoEmAndamento();
        new VerDetalhesTela(getDriver())
                .tocarBotaoFechar();
    }

    /**
     * Tocar no registro de portabilidade
     *
     * @throws Exception
     */
    public void tocarRegistroPortabilidade(String cnpj) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj);
    }

    /**
     * Acessa 'Ver Detalhes' de PortabilidadeDados em Andamento
     *
     * @throws Exception
     */
    public void acessarVerDetalhesPortabilidadeEmAndamento(String cnpj) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj)
                .tocarBotaoDetalhesPedidoAndamento();
    }

    /**
     * Fecha 'Ver Detalhes' de PortabilidadeDados em Andamento
     *
     * @throws Exception
     */
    public void tocarBotaoFechar() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoFechar();
    }

    /**
     * Toca botão Cancelar de PortabilidadeDados em Andamento testando Não e Sim
     *
     * @throws Exception
     */
    public void tocarBotaoCancelarTestandoNaoESim(String cnpj) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj);
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoCancelar();
        new PopUpTela(getDriver())
                .tocarBotaoNao();
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoCancelar();
        new PopUpTela(getDriver())
                .tocarBotaoSim();
    }

    /**
     * Toca botão Cancelar de PortabilidadeDados em Andamento
     *
     * @throws Exception
     */
    public void tocarBotaoCancelar(String cnpj) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj);
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoCancelar();
    }

    /**
     * Cancelar PortabilidadeDados em Andamento
     *
     * @throws Exception
     */
    public void cancelarPortabilidade() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoCancelar()
                .validarTextoConfirmacaoCancelamento();
        new PopUpTela(getDriver())
                .tocarBotaoSim();
    }

    /**
     * Cancelar PortabilidadeDados em Andamento
     *
     * @throws Exception
     */
    public void desistirCancelarPortabilidade(String cnpj) throws Exception {

        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj);

        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoCancelar()
                .validarTextoConfirmacaoCancelamento();

        new PopUpTela(getDriver())
                .tocarBotaoNao();
    }


    /**
     * Valida tela de Informação
     *
     * @throws Exception
     */
    public void validarTelaInformacao() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoInformacao();
        new InformacoesTela(getDriver())
                .validarMenuInformacao()
                .tocarBotaoVoltarInformacao();
    }

    /**
     * Tocar botão 'Fechar' na tela Comprovante
     *
     * @throws Exception
     */
    public void tocarBotaoFecharComprovante() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoFecharComprovante();
    }

    /**
     * Validar comprovante e Tocar botão 'Fechar' na tela Comprovante
     *
     * @throws Exception
     */
    public void tocarBotaoFecharComprovante(Enum banco) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVerDetalhes()
                .validarBancoComprovante(banco)
                .tocarBotaoFecharComprovante();
    }

    /**
     * Validar comprovante e Tocar botão 'Fechar' na tela Comprovante
     *
     * @throws Exception
     */
    public void verificarComprovanteTocarBotaoFecharComprovante() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .validarIconeComprovante()
                .tocarBotaoFecharComprovante();
    }

    /**
     * Validar tela Comprovante passando como parametro o CNPj
     *
     * @throws Exception
     */
    public void validarComprovante(String cnpj) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVerDetalhes()
                .validarDadosComprovante(cnpj);
    }

    /**
     * Tocar botão 'TRAZER MEU SALÁRIO' na tela Comprovante
     *
     * @throws Exception
     */
    public void tocarBotaoTrazerSalario() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoTrazerSalario();
    }

    /**
     * Tocar botão Próximo
     *
     * @throws Exception
     */
    public void tocarBotaoProximo() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoProximo();
    }

    public void tocarBotaoProximoComTecladoAberto() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoAvancarComTecladoAberto();
    }

    /**
     * Tocar botão Próximo depois de Selecionar banco
     *
     * @throws Exception
     */
    public void tocarBotaoAvancar() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoAvancar();
    }

    /**
     * Preencher campo CPF Empregador
     *
     * @throws Exception
     */
    public void preencherCPFEmpregador(String cpfEmpregador) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .preencherCnpjCpfEmpregador(cpfEmpregador);
        if(getDriver() instanceof IOSDriver) {
            new TrazerMeuSalarioTela(getDriver())
                    .tocarBotaoAvancarComTecladoAberto();
        };
    }

    /**
     * Selecionar Banco Conta Salário
     *
     * @throws Exception
     */
    public void selecionarBancoContaSalario(Enum bancoFavorecido) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarComboboxContaSalario()
                .preenchercampoPesquisa(bancoFavorecido.toString())
                .selecionarBancoContaSalario(bancoFavorecido.toString())
                .tocarbotaoCheck();
    }

    /**
     * Selecionar Check-box "Confirmo Solicitação"
     *
     * @throws Exception
     */
    public void tocarCheckboxConfirmoSolicitacao() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarCheboxConfirmoSolicitacao();
    }

    /**
     * Tocar botão "Continuar"
     *
     * @throws Exception
     */
    public void tocarBotaoContinuar() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Validar mensagem de sucesso
     * Tocar em 'OK Entendi'
     *
     * @throws Exception
     */
    public void tocarBotaoOKEntendi() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoOKEntendi();
    }

    /**
     * Validar mensagem de sucesso
     * Tocar em 'OK' no Popup
     *
     * @throws Exception
     */
    public void tocarBotaoOK() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoOK();
    }

    /**
     * Validar Mensagem "Você já cadastrou CPF/CNPJ
     *
     * @throws Exception
     */
    public void validarMensagemVoceJaCadastrouCpfCnpj() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .validarMensagemVoceJaCadastrouCpfCnpj();
    }

    /**
     * Validar Tutorial Primeiro Acesso
     *
     * @throws Exception
     */
    public void validarPrimeiraPortabilidade() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .validarPrimeiraPortabilidade();
    }

    /**
     * Tocar botão contestar
     *
     * @throws Exception
     */
    public void tocarBotaoContestar() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoContestar();
    }

    /**
     * Método para voltar tela anterior e Menu Principal
     *
     * @throws Exception
     */
    public void botaoVoltarMenuPrincipal() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .clicarBotaoVoltarMenuPrincipal();
    }

    /**
     * fluxo para  Validação do pedido de portabilidade (CNPJ) com sucesso.")
     * Método para validar o fluxo completo do pedido de portabilidade
     *
     * @throws Exception
     */
    public void iniciarPortabilidadeValidandoInformacoes() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoInformacao();
        new InformacoesTela(getDriver())
                .validarMenuInformacao()
                .tocarBotaoVoltarInformacao();
    }

    /**
     * Método para selecionar banco favorecido e confirmar a solicitação da portabilidade - fluxo de portabilidade
     * apos selecionar se é CPF ou CNPJ, seleciona banco favorecido e confirma a solicitação de protabilidade.
     *
     * @throws Exception
     */
    public void preecherBancoFavorecidoConfirmandoSolicitacao(Enum bancoFavorecido) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarComboboxContaSalario()
                .preenchercampoPesquisa(bancoFavorecido.toString())
                .selecionarBancoContaSalario(bancoFavorecido.toString())
                .tocarbotaoCheck()
                .tocarBotaoAvancar()
                .tocarCheboxConfirmoSolicitacao()
                .tocarBotaoContinuar();
    }

    /**
     * fluxo para clicar no botão visualizar no comprovante e depois voltar para o comprovante.
     *
     * @throws Exception
     */
    public void visualizarComprovanteBaotaoVisualizaEVoltar(Enum banco) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVerDetalhes()
                .validarBancoComprovante(banco);
        new ComprovanteTela(getDriver())
                .tocarBotaoVisualizar();
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVoltarVisualizarComprovante()
                .tocarBotaoFecharComprovante();
    }

    /**
     * fluxo para validar comprovante e clicar no botão visualizar no comprovante e depois voltar para o comprovante.
     *
     * @throws Exception
     */
    public void validarEVisualizarComprovanteBaotaoVisualizaEVoltar(Enum TEXTO_VALIDAR_CONTESTACAO_PORTABILIDADE) throws Exception {
        new ComprovanteContestacao(getDriver())
                .validarStatusComprovanteContestarPortabilidade(TEXTO_VALIDAR_CONTESTACAO_PORTABILIDADE)
                .tocarBotaoVisualizarComprovanteContestar()
                .tocarBotaoVoltarVisualizarComprovante()
                .tocarBotaoFecharComprovante();
    }

    /**
     * fluxo para pedido de PortabilidadeDados por CPF
     *
     * @param cpfEmpregador
     * @throws Exception
     */
    public void pedidoPortabilidadeCpf(Enum cpfEmpregador) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .preencherCnpjCpfEmpregador(cpfEmpregador.toString());
        if (getDriver() instanceof IOSDriver) {
            new TrazerMeuSalarioTela(getDriver())
                    .tocarBotaoAvancarComTecladoAberto();
        }

    }

    /**
     * fluxo para validacao do botao Voltar da tela de 'Trazer meu Salario'
     *
     * @throws Exception
     */
    public void tocarBotaoVoltar() throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * fluxo para validar Tutorial Primeiro Acesso PortabilidadeDados
     *
     * @param cnpjInvalido
     * @param cnpj
     * @param banco
     * @throws Exception
     */
    public void portabilidadePrimeiroAcesso(Enum cnpjInvalido, Enum cnpj, Enum banco) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoTrazerSalario()
                .preencherCnpjCpfEmpregador(cnpjInvalido.toString());
        if (getDriver() instanceof IOSDriver) {
            new TrazerMeuSalarioTela(getDriver())
                    .tocarBotaoAvancarComTecladoAberto();
        }
        new TrazerMeuSalarioTela(getDriver())
                .validarMensagemCpfCnpjInvalido()
                .preencherCnpjCpfEmpregador(cnpj.toString());
        if (getDriver() instanceof IOSDriver) {
            new TrazerMeuSalarioTela(getDriver())
                    .tocarBotaoAvancarComTecladoAberto();
        }
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVoltar()
                .tocarBotaoAvancar()
                .tocarComboboxContaSalario()
                .preenchercampoPesquisa(banco.toString())
                .selecionarBancoContaSalario(banco.toString())
                .tocarbotaoCheck()
                .tocarBotaoAvancar()
                .validarTermoECondicoes()
                .tocarCheboxConfirmoSolicitacao()
                .tocarBotaoContinuar()
                .tocarBotaoVerDetalhes()
                .validarBancoComprovante(banco)
                .validarDadosComprovante(cnpj);
    }

    /**
     * fluxo para clicar em proximo, preencher CNPJ e selecionar conta salario"
     *
     * @param cnpjEmpregador
     * @throws Exception
     */
    public void proximoPreenchendoCnpj(Enum cnpjEmpregador) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoTrazerSalario()
                .preencherCnpjCpfEmpregador(cnpjEmpregador.toString())
                .tocarComboboxContaSalario();
    }

    /**
     * fluxo para contestar portabilidade."
     *
     * @throws Exception
     */
    public void realizarContestacao(String cnpj) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj)
                .tocarBotaoContestar()
                .tocarBotaoAvancarContestacao();
        new TermosCondicoes(getDriver())
                .tocarCheboxConfirmoSolicitacao()
                .tocarBotaoContinuar();
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVerDetalhes();
    }

    /**
     * Criar Portabilidade
     *
     * @param portabilidade
     * @throws Exception
     */
    public void criarPortabilidade(JSONObject portabilidade) throws Exception {
        String cpf = (String) portabilidade.get("CPF/CNPJ");
        String banco = (String) portabilidade.get("Banco");
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoTrazerSalario()
                .preencherCnpjCpfEmpregador(cpf);
        if (getDriver() instanceof IOSDriver) {
            new TrazerMeuSalarioTela(getDriver())
                    .tocarBotaoAvancarComTecladoAberto();
        }
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVoltar()
                .tocarBotaoAvancar()
                .tocarComboboxContaSalario()
                .preenchercampoPesquisa(banco)
                .selecionarBancoContaSalario(banco)
                .tocarbotaoCheck()
                .tocarBotaoAvancar()
                .validarTermoECondicoes()
                .tocarCheboxConfirmoSolicitacao()
                .tocarBotaoContinuar();
    }

    /**
     * Fluxo para validar botão de cancelar em portabilidades em andamento.
     *
     * @throws Exception
     */
    public void validarBotaoCancelarPortabilidadesEmAndamento(String cnpj1, String cnpj2) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj1)
                .tocarBotaoCancelar();
        new PopUpTela(getDriver())
                .validarMensagem(PortabilidadeDados.TEXTO_CONFIRMACAO_CANCELAMENTO.toString())
                .tocarBotaoNao();
        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj1);

        new TrazerMeuSalarioTela(getDriver())
                .tocarRegistroPortabilidade(cnpj2)
                .tocarBotaoCancelar();
        new PopUpTela(getDriver())
                .validarMensagem(PortabilidadeDados.TEXTO_CONFIRMACAO_CANCELAMENTO.toString())
                .tocarBotaoNao();
    }
}
