package funcionalidade.mobile.open.finance;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.open.finance.TipoDadoCompartilhado;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.jornadas.open.finance.AtencaoTela;
import pagina.mobile.jornadas.open.finance.BuscarInstituicaoTela;
import pagina.mobile.jornadas.open.finance.CompartilheMaisDadosTela;
import pagina.mobile.jornadas.open.finance.ComprovanteTela;
import pagina.mobile.jornadas.open.finance.ConfirmarTela;
import pagina.mobile.jornadas.open.finance.DadosQueEuEnvieiTela;
import pagina.mobile.jornadas.open.finance.EncerrarCompartilhamentoTela;
import pagina.mobile.jornadas.open.finance.EscolherDadosTela;
import pagina.mobile.jornadas.open.finance.EscolherInstituicaoTela;
import pagina.mobile.jornadas.open.finance.FaltaPoucoTela;
import pagina.mobile.jornadas.open.finance.OpenFinanceTela;
import pagina.mobile.jornadas.open.finance.TutorialOpenFinanceTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static constantes.open.finance.TipoDadoCompartilhado.*;

public class OpenFinanceFunc extends FuncionalidadeBase {

    /**
     * Validar exibi��o da tela de tutorial de primeiro acesso a jornada 'Open Finance'
     *
     * fr
     * @throws Exception
     */
    public void validarTelaPrimeiroAcessoJornadaOpenFinance() throws Exception {
        new TutorialOpenFinanceTela(getDriver())
                .validarTelaTutorialPrimeiroAcessoOpenFinance()
                .validarTelaOpenFinance()
                .tocarBotaoContinuar();
    }

    /**
     * Escolher a institui��o - Banco
     *
     * fr
     * @throws Exception
     */
    public void escolherInstituicao() throws Exception {
        new EscolherInstituicaoTela(getDriver())
                .tocarBotaoEscolherInstituicao();
        new BuscarInstituicaoTela(getDriver())
                .tocarBotaoBancoNext();
    }

    /**
     * Escolher dados a serem selecionados
     *
     * fr
     * @throws Exception
     */
    public void escolherDados() throws Exception {

        new EscolherDadosTela(getDriver())
                .tocarCheckBoxDadosCadastrais()
                .tocarCheckBoxInformacoesComplementares()
                .tocarCheckBoxSaldo()
                .tocarCheckBoxLimites()
                .tocarCheckBoxExtratos()
                .tocarCheckBoxLimiteCartao()
                .tocarCheckBoxTransacoes()
                .tocarCheckBoxFaturas()
                .tocarCheckBoxContratosCreditos();
        new AtencaoTela(getDriver())
                .validarTelaAtencao()
                .tocarBotaoOkEntendi();
        new EscolherDadosTela(getDriver())
                .tocarCheckBoxContratosCreditos()
                .tocarBotaoContinuar();
        new CompartilheMaisDadosTela(getDriver())
                .validarTextoMelhoreSuaExperiencia()
                .tocarBotaoSelecionarTodosOsDados();
        new EscolherDadosTela(getDriver())
                .tocarBotaoContinuar();
        new FaltaPoucoTela(getDriver())
                .validarTextoMelhoreSuaExperiencia()
                .tocarBotaoOkContinuar();
    }

    /**
     * Confirmar dados a compartilhar
     * @param cpf
     * fr
     * @throws Exception
     */
    public void confirmarCompartilhamentoDados(String cpf) throws Exception {
        new ConfirmarTela(getDriver())
                .validarTelaConfirmarDadosCompartilhamento()
                .validarResumoCpf(cpf)
                .validarResumoInstituicaoNext()
                .tocarBotaoConfirmar();
    }

    /**
     * Consultar Dados Enviados Consentimento Ativo
     * fr
     * @throws Exception
     */
    public void consultarDadosEnviadosConsentimentoAtivo() throws Exception {
        new OpenFinanceTela(getDriver())
                .validarPresencaTelaOpenFinance()
                .tocarBotaoDadosQueEuEnviei();
        new DadosQueEuEnvieiTela(getDriver())
                .validarPresencaTelaDadosQueEuEnviei()
                .tocarBotaoVerDetalhes()
                .validarCompartilhamentoAtivo()
                .tocarBotaoExpandirDetalhes(TipoDadoCompartilhado.CADASTRO)
                .tocarBotaoExpandirDetalhes(TipoDadoCompartilhado.CONTA)
                .tocarBotaoExpandirDetalhes(TipoDadoCompartilhado.CARTAO_DE_CREDITO)
                .tocarBotaoExpandirDetalhes(TipoDadoCompartilhado.OPERACOES_DE_CREDITO);
        consultarInforma��eDadosCompartilhados(CADASTRO);
        consultarInforma��eDadosCompartilhados(CONTA);
        consultarInforma��eDadosCompartilhados(CARTAO_DE_CREDITO);
        consultarInforma��eDadosCompartilhados(OPERACOES_DE_CREDITO);
        new DadosQueEuEnvieiTela(getDriver())
                .validarPresencaTelaDadosQueEuEnviei()
                .tocarBotaoVoltar()
                .validarPresencaTelaDadosQueEuEnviei()
                .tocarBotaoVoltar();
        new OpenFinanceTela(getDriver())
                .validarPresencaTelaOpenFinance()
                .tocarBotaoVoltar();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }

    /**
     * Consultar Informa��es dados compartilhados
     * fr
     * @throws Exception
     * @param tipoDadoCompartilhado
     */
    public void consultarInforma��eDadosCompartilhados(String tipoDadoCompartilhado) throws Exception {
        switch (tipoDadoCompartilhado) {
            case CADASTRO:
                new DadosQueEuEnvieiTela(getDriver())
                        .tocarBotaoInforma��o(CADASTRO)
                        .validarDadoCompartilhado(CADASTRO)
                        .tocarBotaoFechar();
                break;
            case CONTA:
                new DadosQueEuEnvieiTela(getDriver())
                        .tocarBotaoInforma��o(CONTA)
                        .validarDadoCompartilhado(CONTA)
                        .tocarBotaoFechar();
                break;
            case CARTAO_DE_CREDITO:
                new DadosQueEuEnvieiTela(getDriver())
                        .tocarBotaoInforma��o(CARTAO_DE_CREDITO)
                        .validarDadoCompartilhado(CARTAO_DE_CREDITO)
                        .tocarBotaoFechar();
                break;
            case OPERACOES_DE_CREDITO:
                new DadosQueEuEnvieiTela(getDriver())
                        .tocarBotaoInforma��o(OPERACOES_DE_CREDITO)
                        .validarDadoCompartilhado(OPERACOES_DE_CREDITO)
                        .tocarBotaoFechar();
                break;
        }
    }

    /**
     * Encerrar Consentimento Enviado
     * @throws Exception
     */
    public void encerrarConsentimentoEnviado() throws Exception {
        new OpenFinanceTela(getDriver())
                .validarPresencaTelaOpenFinance()
                .tocarBotaoDadosQueEuEnviei();
        new DadosQueEuEnvieiTela(getDriver())
                .validarPresencaTelaDadosQueEuEnviei()
                .tocarBotaoVerDetalhes()
                .validarCompartilhamentoAtivo()
                .tocarBotaoEncerrarCompartilhamento()
                .tocarBotaoSimEncerrar();
        new EncerrarCompartilhamentoTela(getDriver())
                .validarPresencaMensagemCompartilhamentoEncerradoComSucesso()
                .tocarBotaoVerComprovante();
        new ComprovanteTela(getDriver())
                .validarComprovanteNaTela()
                .tocarBotaoCompartilharComprovante()
                .validarCompartilhamentoDoComprovante();
    }

}
