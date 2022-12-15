package funcionalidade.mobile.investimentos.agendamento;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import constantes.investimentos.Segmento;
import funcionalidade.mobile.investimentos.aplicacao.AplicacaoFunc;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.jornadas.investimentos.aplicacao.EditarAplicacaoTela;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.investimentos.meus.DetalhesProdutoTela;
import pagina.mobile.jornadas.investimentos.meus.investimentos.MeusInvestimentosTela;

public class AgendarAplicacaoFunc extends AplicacaoFunc {

    /**
     * Método responsável por realizar uma aplicação agendada em um produto já investido
     *
     * @param segmento     Segmento a ser selecionado (CDB, Fundos, Poupança ou Ágora)
     * @param produto      Produto a ser selecionado (next CDB, next Ibov, next Alocação Arrojada, etc)
     * @param valor        Valor a ser aplicado
     * @param data         Data do agendamento
     * @param solicitacoes Quantidade de solicitações em aberto
     * @throws Exception
     */
    public void realizarAplicacaoAgendadaNoProdutoJaInvestido(
            Segmento segmento,
            String produto,
            String valor,
            String data,
            ThreadLocal<Integer> solicitacoes) throws Exception {
        realizarAplicacaoNoProdutoJaInvestido(segmento, produto, valor, data, solicitacoes, null);
    }

    /**
     * Método responsável por editar uma aplicação agendada
     *
     * @param segmento    Segmento a ser selecionado (CDB, Fundos, Poupança ou Ágora)
     * @param produto     Produto a ser selecionado (next CDB, next Ibov, next Alocação Arrojada, etc)
     * @param valorAntigo Valor do produto já aplicado
     * @param novoValor   Valor a ser alterado
     * @param novaData    Data a ser alterada
     * @throws Exception
     */
    public void realizarEdicaoAplicacaoAgendada(
            Segmento segmento,
            String produto,
            String valorAntigo,
            String novoValor,
            String novaData,
            ThreadLocal<Integer> solicitacoes) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();

        extrairSolicitacaoEmAberto(solicitacoes, segmento);

        new MeusInvestimentosTela(getDriver())
                .tocarBotaoVerMais(produto);
        new DetalhesProdutoTela(getDriver())
                .tocarBotaoDetalhes()
                .tocarBotaoEditarAplicacaoAgendada(valorAntigo);
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new EditarAplicacaoTela(getDriver())
                .apagarCampoValor()
                .preencherCampoValor(novoValor)
                .tocarBotaoDataDaAplicacao();
        new CalendarioTela(getDriver())
                .selecionarData(false, novaData)
                .tocarBotaoConfirmar();
        new EditarAplicacaoTela(getDriver())
                .tocarBotaoContinuar();
    }
}
