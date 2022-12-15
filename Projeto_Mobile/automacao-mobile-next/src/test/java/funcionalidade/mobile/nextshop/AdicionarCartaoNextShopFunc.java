package funcionalidade.mobile.nextshop;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.nextshop.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AdicionarCartaoNextShopFunc extends FuncionalidadeBase {

    /**
     * Adiciona um novo cartão válido e estático.
     * @throws Exception
     */
    public void adicionaNovoCartaoValido(String numeroCartao, String nomeCartao, String dataExpiracao, String cpfTitularCartao) throws Exception{

        new FormaPagamentoNextShopTela(getDriver())
                .validarTelaPagamento()
                .tocarBotaoAdicionarNovoCartao();
        new AdicionarCartaoNextShopTela(getDriver())
                .preencheNumeroCartao(numeroCartao)
                .preencheDataExpiracao(dataExpiracao)
                .preencheCpfTitularCartao(cpfTitularCartao)
                .preencheNomeCartao(nomeCartao)
                .tocarBotaoAdicionarCartao()
                .selecionarEnderecoPadrao()
                .tocarBotaoUsarEsteEndereco();
        new FormaPagamentoNextShopTela(getDriver())
                .tocarBotaoContinuar();
    }
}
