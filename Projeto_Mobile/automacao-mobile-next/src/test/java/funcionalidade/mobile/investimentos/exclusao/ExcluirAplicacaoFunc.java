package funcionalidade.mobile.investimentos.exclusao;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.CondicaoAplicacaoMensal;
import constantes.investimentos.Mensagem;
import constantes.investimentos.Segmento;
import constantes.investimentos.Texto;
import constantes.investimentos.TituloTela;
import framework.MobileUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.HomeJornadaTela;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.investimentos.aplicacao.AplicacaoCanceladaTela;
import pagina.mobile.jornadas.investimentos.aplicacao.EditarAplicacaoTela;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.investimentos.meus.DetalhesProdutoTela;
import pagina.mobile.jornadas.investimentos.meus.investimentos.MeusInvestimentosTela;
import pagina.mobile.jornadas.menu.MenuTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ExcluirAplicacaoFunc extends FuncionalidadeBase {

    /**
     * Método responsável em excluir uma aplicação com agendamento esporádico
     *
     * @param segmento     Segmento a ser selecionado (CDB, Fundos, Poupança ou Ágora)
     * @param produto      Parâmetro a ser preenchido com o nome do produto selecionado
     * @param valor        Valor da aplicação a ser excluída
     * @param solicitacoes Quantidade de solicitações em aberto
     * @throws Exception
     */
    public void excluirAplicacaoAgendadaEsporadico(
            Segmento segmento,
            String produto,
            String valor,
            ThreadLocal<Integer> solicitacoes) throws Exception {
        excluirAplicacao(segmento, produto, valor, null, solicitacoes, true);
    }

    /**
     * Método responsável em excluir primeira aplicação do dia
     *
     * @param segmento        Segmento a ser selecionado (CDB, Fundos, Poupança ou Ágora)
     * @param produto         Parâmetro a ser preenchido com o nome do produto selecionado
     * @param valor           Valor da aplicação a ser excluída
     * @param totalDisponivel Total aplicado disponível
     * @throws Exception
     */
    public void excluirPrimeiraAplicacaoDoDia(
            Segmento segmento,
            String produto,
            String valor,
            ThreadLocal<String> totalDisponivel) throws Exception {
        excluirAplicacao(segmento, produto, valor, totalDisponivel, null, false);
    }

    /**
     * Método responsável por cancelar uma aplicação com agendamento recorrente
     *
     * @param segmento Segmento a ser selecionado (CDB, Fundos, Poupança ou Ágora)
     * @param produto  Parâmetro a ser preenchido com o nome do produto selecionado
     * @throws Exception
     */
    public void cancelarAplicacaoAgendadaRecorrente(Segmento segmento, String produto) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();
        new MeusInvestimentosTela(getDriver())
                .selecionarSegmento(segmento)
                .tocarBotaoVerMais(produto);
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new DetalhesProdutoTela(getDriver())
                .tocarSwipeAplicacaoMensal();
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new DetalhesProdutoTela(getDriver())
                .validarCondicaoAplicacaoMensal(CondicaoAplicacaoMensal.DESATIVADO);
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Texto.APLICACAO_MENSAL.toString());
        new DetalhesProdutoTela(getDriver())
                .tocarBotaoVoltar();
        // TODO Ajustar quando defeito de inconsistência de tela Android e iOS for concluído
        if (getDriver() instanceof AndroidDriver) {
            new MeusInvestimentosTela(getDriver())
                    .tocarBotaoVoltar()
                    .tocarBotaoVoltar();
        }
        new HomeJornadaTela(getDriver())
                .tocarBotaoVoltarTelaInicialApp();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }

    /**
     * Método responsável por validar a exclusão de uma aplicação (do dia ou agendada)
     *
     * @param segmento        Segmento a ser selecionado (CDB, Fundos, Poupança ou Ágora)
     * @param produto         Parâmetro a ser preenchido com o nome do produto selecionado
     * @param valor           Valor da aplicação a ser excluída
     * @param totalDisponivel Total aplicado disponível
     * @param solicitacoes    Quantidade de solicitações em aberto
     * @throws Exception
     */
    private void excluirAplicacao(
            Segmento segmento,
            String produto,
            String valor,
            ThreadLocal<String> totalDisponivel,
            ThreadLocal<Integer> solicitacoes,
            boolean aplicacaoAgendada) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();
        if (solicitacoes != null) {
            new MeusInvestimentosTela(getDriver())
                    .extrairSolicitacoesEmAberto(solicitacoes);
        }
        new MeusInvestimentosTela(getDriver())
                .selecionarSegmento(segmento)
                .tocarBotaoVerMais(produto);
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        if (!aplicacaoAgendada) {
            new DetalhesProdutoTela(getDriver())
                    .extrairTotalDisponivel(totalDisponivel)
                    .tocarBotaoDetalhes()
                    .tocarBotaoExcluirAplicacaoDoDia(valor);
            // TODO Alterar a mensagem de exclusão de aplicação agendada quando os defeitos
            // TODO NEXT2-230989 e NEXT2-230995 forem finalizados
            new ValidaMensagensTela(getDriver())
                    .validarTodasAsMensagens(Mensagem.EXCLUIR_APLICACAO_AGENDADA);
            new PopUpTela(getDriver())
                    .tocarBotaoExcluir();
            new ValidaMensagensTela(getDriver())
                    .validarTodasAsMensagens(
                            TituloTela.APLICACAO_CANCELADA.toString(),
                            produto,
                            Utilitarios.reformatarValorMonetario(valor),
                            MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy")
                    );
            new AplicacaoCanceladaTela(getDriver())
                    .tocarBotaoFechar();
            new CarregamentoTela(getDriver())
                    .aguardarCarregamentoTela();
            new DetalhesProdutoTela(getDriver())
                    .validarTotalDisponivelProduto(MobileUtils.retornaSubtracaoValoresMonetarios(totalDisponivel.get(), valor));
            new DetalhesProdutoTela(getDriver())
                    .tocarBotaoDetalhes()
                    .validarAusenciaBotaoExcluirAplicacaoDoDia(valor);
        } else {
            new DetalhesProdutoTela(getDriver())
                    .tocarBotaoDetalhes()
                    .tocarBotaoEditarAplicacaoAgendada(valor);
            new CarregamentoTela(getDriver())
                    .aguardarCarregamentoTela();
            new EditarAplicacaoTela(getDriver())
                    .tocarBotaoExcluirAplicacao();
            if (getDriver() instanceof IOSDriver) {
                new PopUpTela(getDriver())
                        .validarMensagem(Mensagem.EXCLUIR_APLICACAO_AGENDADA);
            } else {
                new PopUpTela(getDriver())
                        .validarTitulo(Mensagem.EXCLUIR_APLICACAO_AGENDADA);
            }
            new PopUpTela(getDriver())
                    .tocarBotaoExcluir();
            new DetalhesProdutoTela(getDriver())
                    .validarAusenciaBotaoEditarAplicacaoAgendada(valor);
        }
    }
}
