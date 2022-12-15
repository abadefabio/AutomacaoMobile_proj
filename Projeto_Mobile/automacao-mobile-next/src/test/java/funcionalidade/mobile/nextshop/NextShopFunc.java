package funcionalidade.mobile.nextshop;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.nextshop.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class NextShopFunc extends FuncionalidadeBase {

    /**
     * Realiza a Busca de um Pedido de acordo com o passado pelo parâmetro nomeProduto, e o adiciona no carrinho.
     */
    public void buscaProdutoParaCompraAlterandoLoja (String nomeProduto) throws Exception {

        new HomeNextShopTela(getDriver())
                .tocarBarraDePesquisa();
        new BuscaNextShopTela(getDriver())
                .preencheCampoDePesquisa(nomeProduto)
                .tocarCardProduto();
        new PaginaDoProdutoNextShopTela(getDriver())
                .tocarBotaoComprarAgora()
                .selecionarEsvaziareSeguir();
        new CarrinhoNextShopTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Realiza a Busca de um Pedido de acordo com o passado pelo parâmetro nomeProduto, e o adiciona no carrinho, removendo o item da Loja anteriormente selecionada.
     */
    public void buscaProdutoParaCompra(String nomeProduto) throws Exception {
        new HomeNextShopTela(getDriver())
                .tocarBarraDePesquisa();
        new BuscaNextShopTela(getDriver())
                .preencheCampoDePesquisa(nomeProduto)
                .tocarCardProduto();
        new PaginaDoProdutoNextShopTela(getDriver())
                .tocarBotaoComprarAgora();
    }

    /**
     * Comprar produto selecionado
     */
    public void comprarAgoraConfirmarAtePagamento() throws Exception{
        new CarrinhoNextShopTela(getDriver())
                .validarTelaCarrinho()
                .tocarBotaoContinuar();
        new EnderecoNextShopTela(getDriver())
                .validarTelaEnderecoEntrega()
                .selecionarEnderecoPadrao()
                .tocarBotaoContinuar();
        new FreteNextShopTela(getDriver())
                .validarTelaFrete()
                .tocarBotaoContinuar();
    }


    /**
     * Seleciona o endereço next cadastrado para o cliente.
     */
    public void selecionaEnderecoPadrao() throws Exception {
        new EnderecoNextShopTela(getDriver())
                .validarTelaEnderecoEntrega()
                .tocarBotaoContinuar();
    }

    /**
     * Continua no fluxo de compra, deixando selecionado a opção de frete pré-selecionada.
     */
    public void selecionaFretePadrao() throws Exception {
        new FreteNextShopTela(getDriver())
                .validarTelaFrete()
                .tocarBotaoContinuar();
    }

    /**
     * Utiliza do modo de pagamento salvo selecionado do cliente, pagando sempre em 1x parcela.
     */
    public void selecionaPagamentoPadraoCartao() throws Exception {
        new FormaPagamentoNextShopTela(getDriver())
                .tocarSelecionaParcelasPagamento()
                .tocarRadioButtonParcelaUnica()
                .tocarBotaoContinuar();
    }

    /**
     * Utiliza do modo de pagamento salvo selecionado do cliente, pagando sempre em 1x parcela.
     */
    public void selecionaParcelasViaBotaoContinuar() throws Exception {
        new FormaPagamentoNextShopTela(getDriver())
                .tocarBotaoContinuar()
                .tocarRadioButtonParcelaUnica()
                .tocarBotaoContinuar()
                .tocarBotaoContinuar();
    }

    /**
     * Finaliza a compra do cliente adicionando o CVV e prosseguindo para a tela de Pedido Realizado.
     */
    public void finalizaCompraNextShop(String cvv) throws Exception {
       new ResumoPedidoNextShopTela(getDriver())
                .preencherCvv(cvv)
                .tocarBotaoConcluirPedido();
       new PedidoRealizadoNextShopTela(getDriver())
                .validaTelaPedidoConcluido()
                .validaPresencaBotaoAcompanharMeusPedidos();

    }

    /**
     * Seleciona a forma de pagamento com boleto
     */
    public void selecionaPagamentoBoleto() throws Exception {
        new FormaPagamentoNextShopTela(getDriver())
                .validarTelaPagamento()
                .selecionaPagamentoBoleto()
                .tocarBotaoContinuar();
    }

    /**
     * Finaliza a compra do cliente em uma compra com boleto.
     */
    public void finalizaCompraNextShopBoleto() throws Exception  {
        new ResumoPedidoNextShopTela(getDriver())
                .tocarBotaoConcluirPedido();
        new PedidoRealizadoNextShopTela(getDriver())
                .validaTelaPedidoConcluido();
    }

    /**
     * Adiciona um produto ao carrinho utilizando o filtro de Categoria
     */
    public void buscaProdutoParaCompraViaFiltroCategoria() throws Exception {
        new HomeNextShopTela(getDriver())
                .tocarBotaoCategoriaCelularESmartphone();
        new CategoriaNextShopTela(getDriver())
                .tocarCardProdutoCategoria();
        new PaginaDoProdutoNextShopTela(getDriver())
                .tocarBotaoComprarAgora();
        new CarrinhoNextShopTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Adiciona um produto ao carrinho utilizando o filtro de Loja
     */
    public void buscaProdutoParaCompraViaFiltroLoja() throws Exception {
        new HomeNextShopTela(getDriver())
                .tocarBotaoLojaVTEX();
        new LojaNextShopTela(getDriver())
                .tocarCardProdutoLoja();
        new PaginaDoProdutoNextShopTela(getDriver())
                .tocarBotaoComprarAgora();
        new CarrinhoNextShopTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Remove o primeiro endereco adicional cadastrado.
     */
    public void removePrimeiroEnderecoCadastrado() throws Exception {
        new EnderecoNextShopTela(getDriver())
                .tocaBotaoEdicaoDeEndereco()
                .tocaBotaoExcluirEndereco();
    }

    /**
     * Clica no botão continuar na tela de Endereço
     */
    public void tocarBotaoAdicionarEndereco() throws Exception {
        new EnderecoNextShopTela(getDriver())
                .tocarBotaoAdicionarEndereco();
    }

    /**
     * Retorna para tela de busca e limpa o campo de pesquisa.
     */
    public void retornaParaTelaDeBuscaELimpaCampoDePesquisa() throws Exception {
        new CarrinhoNextShopTela(getDriver())
                .validarTelaCarrinho()
                .tocarBotaoVoltarHeader();
        new PaginaDoProdutoNextShopTela(getDriver())
                .tocarBotaoVoltarHeader();
        new BuscaNextShopTela(getDriver())
                .tocarBotaoVoltarHeader();

    }
}
