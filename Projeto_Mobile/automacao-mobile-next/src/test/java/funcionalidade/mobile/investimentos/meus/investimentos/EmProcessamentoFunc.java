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
     * Método responsável por validar as solicitações que estão 'Em processamento' após realizar uma Aplicação ou Resgate
     *
     * @param produto           Produto investido (next CDB, next Alocação Arrojada, etc...)
     * @param tipoSolicitacao   Tipo de solicitação realizado (Aplicação/Resgate)
     * @param valor             Valor investido
     * @param tipoProcessamento Tipo de processamento realizado (Solicitado em/Agendado em)
     * @param dataSolicitacao   Data da solicitação
     * @param solicitacoes      Quantidade de solcitações em aberto
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
     * Método responsável por validar as solicitações que estão 'Em Processamento' após edição de uma aplicação agendada
     *
     * @param produto           Produto investido (next CDB, next Alocação Arrojada, etc...)
     * @param tipoSolicitacao   Tipo de solicitação realizado (Aplicação/Resgate)
     * @param valor             Valor investido
     * @param tipoProcessamento Tipo de processamento realizado (Solicitado em/Agendado em)
     * @param dataSolicitacao   Data da solicitação
     * @param solicitacoes      Quantidade de solcitações em aberto
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
     * Método responsável por validar as solicitações que estão 'Em processamento'
     *
     * @param produto           Produto investido (next CDB, next Alocação Arrojada, etc...)
     * @param tipoSolicitacao   Tipo de solicitação realizado (Aplicação/Resgate)
     * @param valor             Valor investido
     * @param tipoProcessamento Tipo de processamento realizado (Solicitado em/Agendado em)
     * @param dataSolicitacao   Data da solicitação
     * @param solicitacoes      Quantidade de solcitações em aberto
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
