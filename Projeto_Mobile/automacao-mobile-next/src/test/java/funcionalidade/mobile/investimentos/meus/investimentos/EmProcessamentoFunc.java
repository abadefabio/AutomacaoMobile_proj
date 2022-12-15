package funcionalidade.mobile.investimentos.meus.investimentos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.investimentos.Texto;
import constantes.investimentos.TipoSolicitacao;
import pagina.mobile.comum.next.HomeJornadaTela;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.investimentos.meus.investimentos.EmProcessamentoTela;
import pagina.mobile.jornadas.investimentos.meus.investimentos.MeusInvestimentosTela;
import pagina.mobile.jornadas.menu.MenuTela;

public class EmProcessamentoFunc extends FuncionalidadeBase {

    /**
     * M�todo respons�vel por validar as solicita��es que est�o 'Em processamento' ap�s realizar uma Aplica��o ou Resgate
     *
     * @param produto           Produto investido (next CDB, next Aloca��o Arrojada, etc...)
     * @param tipoSolicitacao   Tipo de solicita��o realizado (Aplica��o/Resgate)
     * @param valor             Valor investido
     * @param tipoProcessamento Tipo de processamento realizado (Solicitado em/Agendado em)
     * @param dataSolicitacao   Data da solicita��o
     * @param solicitacoes      Quantidade de solcita��es em aberto
     * @throws Exception
     */
    public void realizarValidacaoSolicitacoesEmAberto(
            String produto,
            TipoSolicitacao tipoSolicitacao,
            String valor,
            Texto tipoProcessamento,
            String dataSolicitacao,
            ThreadLocal<Integer> solicitacoes) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();

        if (solicitacoes.get() != null) {
            solicitacoes.set(solicitacoes.get() + 1);
        } else {
            solicitacoes.set(1);
        }

        validarSolicitacoesEmAberto(
                produto,
                tipoSolicitacao,
                valor,
                tipoProcessamento,
                dataSolicitacao,
                solicitacoes
        );
    }

    /**
     * M�todo respons�vel por validar as solicita��es que est�o 'Em Processamento' ap�s edi��o de uma aplica��o agendada
     *
     * @param produto           Produto investido (next CDB, next Aloca��o Arrojada, etc...)
     * @param tipoSolicitacao   Tipo de solicita��o realizado (Aplica��o/Resgate)
     * @param valor             Valor investido
     * @param tipoProcessamento Tipo de processamento realizado (Solicitado em/Agendado em)
     * @param dataSolicitacao   Data da solicita��o
     * @param solicitacoes      Quantidade de solcita��es em aberto
     * @throws Exception
     */
    public void realizarValidacaoSolicitacoesEmAbertoAposEditarAgendamento(
            String produto,
            TipoSolicitacao tipoSolicitacao,
            String valor,
            Texto tipoProcessamento,
            String dataSolicitacao,
            ThreadLocal<Integer> solicitacoes) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();

        validarSolicitacoesEmAberto(
                produto,
                tipoSolicitacao,
                valor,
                tipoProcessamento,
                dataSolicitacao,
                solicitacoes
        );
    }

    /**
     * M�todo respons�vel por validar as solicita��es que est�o 'Em processamento'
     *
     * @param produto           Produto investido (next CDB, next Aloca��o Arrojada, etc...)
     * @param tipoSolicitacao   Tipo de solicita��o realizado (Aplica��o/Resgate)
     * @param valor             Valor investido
     * @param tipoProcessamento Tipo de processamento realizado (Solicitado em/Agendado em)
     * @param dataSolicitacao   Data da solicita��o
     * @param solicitacoes      Quantidade de solcita��es em aberto
     * @throws Exception
     */
    private void validarSolicitacoesEmAberto(
            String produto,
            TipoSolicitacao tipoSolicitacao,
            String valor,
            Texto tipoProcessamento,
            String dataSolicitacao,
            ThreadLocal<Integer> solicitacoes) throws Exception {
        new MeusInvestimentosTela(getDriver())
                .validarSolicitacoesEmAberto(solicitacoes)
                .tocarBlocoEmProcessamento();
        new EmProcessamentoTela(getDriver())
                .validarInformacoesNovaSolicitacao(
                        produto.toUpperCase(),
                        tipoSolicitacao.toString(),
                        valor,
                        tipoProcessamento.toString(),
                        dataSolicitacao)
                .tocarBotaoVoltar();
        new MeusInvestimentosTela(getDriver())
                .tocarBotaoVoltar();
        new HomeJornadaTela(getDriver())
                .tocarBotaoVoltarTelaInicialApp();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }
}
