package funcionalidade.mobile.investimentos.aplicacao;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static constantes.investimentos.Produto.NEXT_POUPANCA;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.investimentos.Mensagem;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import constantes.investimentos.Texto;
import constantes.investimentos.TituloTela;
import framework.MobileUtils;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.investimentos.aplicacao.AplicacaoForaPerfilTela;
import pagina.mobile.jornadas.investimentos.aplicacao.AplicacaoPoupancaTela;
import pagina.mobile.jornadas.investimentos.aplicacao.AplicacaoTela;
import pagina.mobile.jornadas.investimentos.aplicacao.AtualizacaoCadastralTela;
import pagina.mobile.jornadas.investimentos.aplicacao.ProdutoComRiscoTela;
import pagina.mobile.jornadas.investimentos.aplicacao.ProdutosTela;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.investimentos.meus.DetalhesPoupancaTela;
import pagina.mobile.jornadas.investimentos.meus.DetalhesProdutoTela;
import pagina.mobile.jornadas.investimentos.meus.investimentos.MeusInvestimentosTela;

public class AplicacaoFunc extends FuncionalidadeBase {

    /**
     * M�todo respons�vel por tocar no bot�o 'Investir' do primeiro produto do segmento selecionado
     *
     * @param segmento Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto  Par�metro a ser preenchido com o nome do produto selecionado
     * @throws Exception
     */
    public void tocarBotaoInvestirPrimeiroProduto(Segmento segmento, ThreadLocal<String> produto) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .selecionarSegmento(segmento);
        new ProdutosTela(getDriver())
                .tocarBotaoInvestirPrimeiroProduto(produto);
    }

    /**
     * M�todo respons�vel por tocar no bot�o 'Investir' do produto a ser selecionado
     *
     * @param segmento Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto  Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @throws Exception
     */
    public void tocarBotaoInvestirPorProdutoDoSegmento(Segmento segmento, String produto) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .selecionarSegmento(segmento);
        new ProdutosTela(getDriver())
                .tocarBotaoInvestir(produto);
    }

    /**
     * M�todo respons�vel por realizar uma aplica��o em um produto j� investido
     *
     * @param segmento     Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto      Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valor        Valor a ser aplicado
     * @param solicitacoes Quantidade de solicita��es em aberto
     * @throws Exception
     */
    public void realizarAplicacaoNoProdutoJaInvestido(
            Segmento segmento,
            String produto,
            String valor,
            ThreadLocal<Integer> solicitacoes) throws Exception {
        realizarAplicacaoNoProdutoJaInvestido(
                segmento,
                produto,
                valor,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy"),
                solicitacoes,
                null
        );
    }

    /**
     * M�todo respons�vel por realizar uma aplica��o em um produto j� investido
     *
     * @param segmento     Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto      Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valor        Valor a ser aplicado
     * @param saldo        Par�metro a ser preenchido com o saldo aplicado no produto
     * @throws Exception
     */
    public void realizarAplicacaoNoProdutoPoupancaJaInvestido(
            Segmento segmento,
            String produto,
            String valor,
            ThreadLocal<String> saldo) throws Exception {
        realizarAplicacaoNoProdutoJaInvestido(
                segmento,
                produto,
                valor,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy"),
                null,
                saldo
        );
    }

    /**
     * M�todo respons�vel por realizar uma aplica��o pela op��o 'Ver mais' de um produto j� investido
     *
     * @param segmento     Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto      Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valor        Valor a ser aplicado
     * @param solicitacoes Quantidade de solicita��es em aberto
     * @throws Exception
     */
    public void realizarAplicacaoBotaoVerMais(
            Segmento segmento,
            String produto,
            String valor,
            ThreadLocal<Integer> solicitacoes) throws Exception {
        realizarAplicacaoBotaoVerMais(segmento, produto, valor, solicitacoes, null);
    }

    /**
     * M�todo respons�vel por realizar uma aplica��o pela op��o 'Ver mais' de um produto j� investido
     *
     * @param segmento     Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto      Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valor        Valor a ser aplicado
     * @param saldo        Par�metro a ser preenchido com o saldo aplicado no produto
     * @throws Exception
     */
    public void realizarAplicacaoPoupancaBotaoVerMais(
            Segmento segmento,
            String produto,
            String valor,
            ThreadLocal<String> saldo) throws Exception {
        realizarAplicacaoBotaoVerMais(segmento, produto, valor, null, saldo);
    }

    /**
     * M�todo respons�vel por realizar nova aplica��o sem perfil de investidor
     *
     * @param produto Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valor   Valor a ser aplicado
     * @throws Exception
     */
    public void realizarNovaAplicacaoSemPerfilInvestidor(String produto, String valor) throws Exception {
        if (!produto.equals(NEXT_POUPANCA)) {
            new ValidaMensagensTela(getDriver())
                    .validarTodasAsMensagens(TituloTela.PRODUTO_COM_RISCO.toString());
            new ProdutoComRiscoTela(getDriver())
                    .tocarBotaoContinuarInvestimento();
        }
        realizarNovaAplicacao(produto, valor, true);
    }

    /**
     * M�todo respons�vel por realizar nova aplica��o no menu 'Poupan�a' da home principal
     *
     * @param valor Valor a ser aplicado
     * @throws Exception
     */
    public void realizarNovaAplicacaoMenuPoupanca(String valor) throws Exception {
        new DetalhesPoupancaTela(getDriver())
                .validarPresencaEDeslizarTelaTutorial(TituloTela.POUPANCA.toString(), Mensagem.TUTORIAL_PRIMEIRA_APLICACAO_POUPANCA_PARTE_1, true)
                .validarPresencaEDeslizarTelaTutorial(TituloTela.POUPANCA.toString(), Mensagem.TUTORIAL_PRIMEIRA_APLICACAO_POUPANCA_PARTE_2, true)
                .validarPresencaEDeslizarTelaTutorial(TituloTela.POUPANCA.toString(), Mensagem.TUTORIAL_PRIMEIRA_APLICACAO_POUPANCA_PARTE_3, false)
                .tocarBotaoAplicarNaPoupanca();
        realizarNovaAplicacao(Produto.NEXT_POUPANCA, valor, false);
    }

    /**
     * M�todo respons�vel por realizar uma nova aplica��o
     *
     * @param produto             Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valor               Valor a ser aplicado
     * @param aplicacaoForaPerfil Condi��o booleana (true/false) que valida se a aplica��o � fora do perfil
     * @throws Exception
     */
    public void realizarNovaAplicacao(String produto, String valor, boolean aplicacaoForaPerfil) throws Exception {
        preencherValorAplicacao(produto, valor, MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy"));
        if (aplicacaoForaPerfil && !produto.equals(NEXT_POUPANCA)) {
            new ValidaMensagensTela(getDriver())
                    .validarTodasAsMensagens(TituloTela.APLICACAO_FORA_DO_PERFIL.toString());
            new AplicacaoForaPerfilTela(getDriver())
                    .tocarBotaoContinuar();
        }
        new AplicacaoTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * M�todo respons�vel por validar a apresenta��o da tela de 'Atualiza��o Cadastral' ao realizar uma aplica��o
     *
     * @param segmento Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto  Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @throws Exception
     */
    public void validarTelaAtualizacaoCadastral(Segmento segmento, String produto) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();
        new MeusInvestimentosTela(getDriver())
                .selecionarSegmento(segmento)
                .tocarBotaoVerMais(produto);
        new DetalhesProdutoTela(getDriver())
                .tocarBotaoAplicar();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TituloTela.ATUALIZACAO_CADASTRAL.toString());
        new AtualizacaoCadastralTela(getDriver())
                .tocarBotaoMeusDadosContinuamIguais();
        new PopUpTela(getDriver())
                .validarMensagem(Mensagem.SEUS_DADOS_FORAM_CONFIRMADOS)
                .tocarBotaoContinuar();
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Texto.QUAL_VALOR_DA_APLICACAO.toString());
    }

    /**
     * M�todo respons�vel por realizar uma aplica��o em um produto j� investido
     *
     * @param segmento     Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto      Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valor        Valor a ser aplicado
     * @param data         Data da aplica��o
     * @param solicitacoes Quantidade de solicita��es em aberto
     * @param saldo        Par�metro a ser preenchido com o saldo aplicado no produto
     * @throws Exception
     */
    protected void realizarAplicacaoNoProdutoJaInvestido(
            Segmento segmento,
            String produto,
            String valor,
            String data,
            ThreadLocal<Integer> solicitacoes,
            ThreadLocal<String> saldo) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();

        switch (produto) {
            case NEXT_POUPANCA:
                extrairSaldoSegmento(segmento, saldo);
                break;
            default:
                extrairSolicitacaoEmAberto(solicitacoes, segmento);
        }

        new MeusInvestimentosTela(getDriver())
                .tocarBotaoInvestir(produto);

        preencherValorAplicacao(produto, valor, data);

        if (!data.equals(MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy"))) {
            preencherDataAplicacao(data);
        }

        new AplicacaoTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * M�todo respons�vel por extrair as solicita��es em aberto do bloco 'Em processamento'
     *
     * @param solicitacoes Quantidade de solicita��es em aberto
     * @param segmento     Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @throws Exception
     */
    protected void extrairSolicitacaoEmAberto(ThreadLocal<Integer> solicitacoes, Segmento segmento) throws Exception {
        new MeusInvestimentosTela(getDriver())
                .extrairSolicitacoesEmAberto(solicitacoes)
                .selecionarSegmento(segmento);
    }

    /**
     * M�todo respons�vel por extrair valor do saldo investido no segmento (CDB, Fundos ou Poupan�a)
     *
     * @param segmento Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param saldo    Par�metro a ser preenchido com o saldo aplicado no produto
     * @throws Exception
     */
    private void extrairSaldoSegmento(Segmento segmento, ThreadLocal<String> saldo) throws Exception {
        new MeusInvestimentosTela(getDriver())
                .selecionarSegmento(segmento)
                .tocarBotaoVerOcultarSaldoInvestido()
                .extrairSaldoInvestido(saldo);
    }

    /**
     * M�todo respons�vel por realizar uma aplica��o pela op��o 'Ver mais' de um produto j� investido
     *
     * @param segmento     Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @param produto      Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valor        Valor a ser aplicado
     * @param solicitacoes Quantidade de solcita��es em aberto
     * @param saldo        Par�metro a ser preenchido com o saldo aplicado no produto
     * @throws Exception
     */
    private void realizarAplicacaoBotaoVerMais(
            Segmento segmento,
            String produto,
            String valor,
            ThreadLocal<Integer> solicitacoes,
            ThreadLocal<String> saldo) throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();
        switch (produto) {
            case NEXT_POUPANCA:
                extrairSaldoSegmento(segmento, saldo);
                break;
            default:
                extrairSolicitacaoEmAberto(solicitacoes, segmento);
        }
        new MeusInvestimentosTela(getDriver())
                .tocarBotaoVerMais(produto);
        new DetalhesProdutoTela(getDriver())
                .tocarBotaoAplicar();
        preencherValorAplicacao(produto, valor, MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy"));
    }

    /**
     * M�todo respons�vel por preencher o valor da aplica��o
     *
     * @param produto Produto a ser selecionado (next CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @param valor   Valor a ser aplicado
     * @param data    Data da aplica��o
     * @throws Exception
     */
    private void preencherValorAplicacao(String produto, String valor, String data) throws Exception {
        switch (produto) {
            case Produto.NEXT_POUPANCA:
                new AplicacaoPoupancaTela(getDriver())
                        .tocarBotaoContinuar()
                        .preencherValorAplicacao(valor)
                        .tocarBotaoAplicar();
                break;
            default:
                new CarregamentoTela(getDriver())
                        .aguardarCarregamentoTela();
                new AplicacaoTela(getDriver())
                        .apagarCampoValor()
                        .preencherCampoValor(valor);
                if (!data.equals(MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy"))) {
                    preencherDataAplicacao(data);
                }
                new AplicacaoTela(getDriver())
                        .tocarBotaoContinuar();
        }
    }

    /**
     * M�todo respons�vel por selecionar data para agendamento
     *
     * @param data Data a ser selecionada no calend�rio
     * @throws Exception
     */
    private void preencherDataAplicacao(String data) throws Exception {
        new AplicacaoTela(getDriver())
                .tocarBotaoDataDaAplicacao();
        new CalendarioTela(getDriver())
                .selecionarData(false, data)
                .tocarBotaoConfirmar();
    }
}
