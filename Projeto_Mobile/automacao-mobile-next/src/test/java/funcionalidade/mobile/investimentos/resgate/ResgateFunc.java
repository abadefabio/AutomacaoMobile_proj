package funcionalidade.mobile.investimentos.resgate;

import constantes.investimentos.Mensagem;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import framework.MobileUtils;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.investimentos.meus.DetalhesPoupancaTela;
import pagina.mobile.jornadas.investimentos.meus.DetalhesProdutoTela;
import pagina.mobile.jornadas.investimentos.meus.investimentos.MeusInvestimentosTela;
import pagina.mobile.jornadas.investimentos.resgate.PopUpResgateTela;
import pagina.mobile.jornadas.investimentos.resgate.ResgatePoupancaTela;
import pagina.mobile.jornadas.investimentos.resgate.ResgateTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import br.com.next.automacao.core.base.FuncionalidadeBase;

public class ResgateFunc extends FuncionalidadeBase {

    /**
     * M�todo respons�vel por realizar um resgate parcial
     *
     * @param segmento               Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto                Poduto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param solicitacoes           Quantidade de solicita��es em aberto
     * @param valorResgate           Valor a ser resgatado
     * @param totalDisponivelResgate Saldo dispon�vel para resgate
     * @throws Exception
     */
    public void realizarResgateParcial(
            Segmento segmento,
            String produto,
            ThreadLocal<Integer> solicitacoes,
            String valorResgate,
            ThreadLocal<String> totalDisponivelResgate) throws Exception {
        selecionarSegmento(segmento,solicitacoes);
        new MeusInvestimentosTela(getDriver())
                .tocarBotaoResgatar(produto);
        preencherValorResgate(produto, valorResgate, totalDisponivelResgate);
    }

    /**
     * M�todo respons�vel por realizar um resgate parcial em 'Poupan�a'
     *
     * @param valorResgate           Valor a ser resgatado
     * @param totalDisponivelResgate Saldo dispon�vel para resgate
     * @throws Exception
     */
    public void realizarResgateParcialPoupanca(String valorResgate, ThreadLocal<String> totalDisponivelResgate) throws Exception {
        realizarResgateParcial(Segmento.POUPANCA, Produto.NEXT_POUPANCA, null, valorResgate, totalDisponivelResgate);
    }

    /**
     * M�todo respons�vel por realizar um resgate total
     *
     * @param segmento               Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto                Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param solicitacoes           Quantidade de solicita��es em aberto
     * @param valorResgate           Valor a ser resgatado
     * @param totalDisponivelResgate Valor total dispon�vel para resgate
     * @throws Exception
     */
    public void realizarResgateTotal(
            Segmento segmento,
            String produto,
            ThreadLocal<Integer> solicitacoes,
            ThreadLocal<String> valorResgate,
            ThreadLocal<String> totalDisponivelResgate) throws Exception {
        selecionarSegmento(segmento, solicitacoes);
        new MeusInvestimentosTela(getDriver())
                .tocarBotaoResgatar(produto);
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ResgateTela(getDriver())
                .recuperarValorTotalDisponivelParaResgate(totalDisponivelResgate)
                .tocarResgatarTudo()
                .retornarValorPreenchidoResgate(valorResgate)
                .tocarBotaoContinuar();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(
                        produto.equals(Produto.NEXT_CDB) ?
                                Mensagem.MENSAGEM_RESGATAR_TUDO_CDB :
                                Mensagem.MENSAGEM_RESGATAR_TUDO
                );
        new PopUpResgateTela(getDriver())
                .tocarBotaoResgatarTudo();
    }

    /**
     * M�todo respons�vel por realizar um resgate parcial pelo bot�o 'Ver Mais'
     *
     * @param segmento               Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto                Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valorResgate           Valor a ser resgatado
     * @param totalDisponivelResgate Saldo dispon�vel para resgate
     * @throws Exception
     */
    public void realizarResgateParcialBotaoVerMais(
            Segmento segmento,
            String produto,
            ThreadLocal<Integer> solicitacoes,
            String valorResgate,
            ThreadLocal<String> totalDisponivelResgate) throws Exception {
        selecionarSegmento(segmento, solicitacoes);
        new MeusInvestimentosTela(getDriver())
                .tocarBotaoVerMais(produto);
        switch (produto) {
            case Produto.NEXT_POUPANCA:
                new DetalhesPoupancaTela(getDriver())
                        .tocarBotaoResgatar();
                break;
            default:
                new DetalhesProdutoTela(getDriver())
                        .tocarBotaoResgatar();
        }
        preencherValorResgate(produto, valorResgate, totalDisponivelResgate);
    }

    /**
     * M�todo respons�vel por realizar um resgate parcial pelo bot�o 'Ver Mais'
     *
     * @param segmento               Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto                Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valorResgate           Valor a ser resgatado
     * @param totalDisponivelResgate Saldo dispon�vel para resgate
     * @throws Exception
     */
    public void realizarResgateParcialPoupancaBotaoVerMais(
            Segmento segmento,
            String produto,
            String valorResgate,
            ThreadLocal<String> totalDisponivelResgate) throws Exception {
        realizarResgateParcialBotaoVerMais(segmento, produto, null, valorResgate, totalDisponivelResgate);
    }

    /**
     * M�todo respons�vel por realizar um resgate parcial pelo menu 'Poupan�a'
     *
     * @param valorResgate  Valor a ser resgatado
     * @param saldoPoupanca Saldo dispon�vel na poupan�a
     * @throws Exception
     */
    public void realizarResgateParcialMenuPoupanca(String valorResgate, ThreadLocal<String> saldoPoupanca) throws Exception {
        new DetalhesPoupancaTela(getDriver())
                .tocarBotaoResgatar();
        preencherValorResgate(Produto.NEXT_POUPANCA, valorResgate, saldoPoupanca);
    }

    /**
     * M�todo respons�vel por validar PopUp de alerta ao resgatar valor superior ao saldo m�nimo de resgate
     *
     * @param segmento               Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto                Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param solicitacoes           Quantidade de solicita��es em aberto
     * @param totalDisponivelResgate Saldo dispon�vel para resgate
     * @throws Exception
     */
    public void validarPopUpAoRealizarResgateParcialValorMaiorMinimo(
            Segmento segmento,
            String produto,
            ThreadLocal<Integer> solicitacoes,
            ThreadLocal<String> totalDisponivelResgate) throws Exception {
        String saldoRestanteResgate = "0,50";
        selecionarSegmento(segmento, solicitacoes);
        new MeusInvestimentosTela(getDriver())
                .tocarBotaoResgatar(produto);
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ResgateTela(getDriver())
                .recuperarValorTotalDisponivelParaResgate(totalDisponivelResgate)
                .preencherCampoValorResgate(MobileUtils.retornaSubtracaoValoresMonetarios(totalDisponivelResgate.get(), saldoRestanteResgate))
                .tocarBotaoContinuar();
        if (produto.equals(Produto.NEXT_CDB)) {
            new ValidaMensagensTela(getDriver())
                    .validarTodasAsMensagens(Mensagem.MENSAGEM_RESGATE_PARCIAL_CDB);
            new PopUpResgateTela(getDriver())
                    .tocarBotaoResgatar();
        } else {
            new ValidaMensagensTela(getDriver())
                    .validarTodasAsMensagens(Mensagem.MENSAGEM_RESGATAR_TUDO);
            new PopUpResgateTela(getDriver())
                    .tocarBotaoResgatarTudo();
        }
    }

    /**
     * M�todo respons�vel por preencher o valor a ser resgatado
     *
     * @param produto                    Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valorResgate               Valor a ser resgatado
     * @param totalDisponivelParaResgate Saldo dispon�vel para resgate
     * @throws Exception
     */
    private void preencherValorResgate(String produto, String valorResgate, ThreadLocal<String> totalDisponivelParaResgate) throws Exception {
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        switch (produto) {
            case Produto.NEXT_POUPANCA:
                new ResgatePoupancaTela(getDriver())
                        .recuperarSaldoDisponivelPoupanca(totalDisponivelParaResgate)
                        .preencherValorResgate(valorResgate)
                        .tocarBotaoResgatar();
                break;
            default:
                new ResgateTela(getDriver())
                        .recuperarValorTotalDisponivelParaResgate(totalDisponivelParaResgate)
                        .preencherCampoValorResgate(valorResgate)
                        .tocarBotaoContinuar();
        }
    }

    /**
     * M�todo respons�vel por selecionar um determinado  segmento
     *
     * @param segmento Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @throws Exception
     */
    private void selecionarSegmento(Segmento segmento, ThreadLocal<Integer> solicitacoes) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();
        if (!segmento.toString().equals(Segmento.POUPANCA.toString())) {
            new MeusInvestimentosTela(getDriver())
                    .extrairSolicitacoesEmAberto(solicitacoes);
        }
        new MeusInvestimentosTela(getDriver())
                .selecionarSegmento(segmento);
    }
}
