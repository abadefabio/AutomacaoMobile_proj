package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.ServicosCartaoTela;
import pagina.mobile.jornadas.cartao.fatura.VisaCausasTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ApoiarFunc extends FuncionalidadeBase {

    /**
     * Método para iniciar Apoio Causa Visa'
     *
     * @throws Exception
     */
    public void apoiarCausa() throws Exception {
        comecarApoiar();
        new VisaCausasTela(getDriver())
                .tocarBotaoApoiarCausa();
        confirmarApoiar();
    }

    /**
     * Método para iniciar Apoio Instituição Visa'
     *
     * @throws Exception
     */
    public void apoiarInstituicao() throws Exception {
        comecarApoiar();
        new VisaCausasTela(getDriver())
                .tocarBotaoApoiarPrimeiraInstituicao();
        confirmarApoiar();
    }

    /**
     * Método para começar um apoio
     *
     * @throws Exception
     */
    private void comecarApoiar() throws Exception {
        new CartaoTela(getDriver())
                .tocarServicosCartao();
        new ServicosCartaoTela(getDriver())
                .tocarVisaCausa();
        new VisaCausasTela(getDriver())
                .tocarBotaoComecar();
    }

    /**
     * Método para confirmar um Apoio'
     *
     * @throws Exception
     */
    private void confirmarApoiar() throws Exception {
        new VisaCausasTela(getDriver())
                .tocarBotaoConfirmar()
                .tocarCheckLieAceito()
                .tocarBotaoContinuar()
                .tocarBotaoOk()
                .tocarMaisDetalhes();
    }

    /**
     * Método para deixar de apoiar uma causa ou instituição'
     *
     * @throws Exception
     */
    public void deixarDeApoiar() throws Exception {
        new VisaCausasTela(getDriver())
                .tocarBotaoVoltar()
                .tocarBotaoDeixarDeApoiar()
                .tocarBotaoSimTenhoCerteza();
    }

}
