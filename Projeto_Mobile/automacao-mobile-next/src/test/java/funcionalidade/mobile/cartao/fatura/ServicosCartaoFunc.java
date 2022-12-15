package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.ServicosCartaoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;

public class ServicosCartaoFunc extends FuncionalidadeBase {

    /**
     * Método para tocar servicos do cartao
     *
     * @throws Exception
     */
    public void servicosCartao() throws Exception {
        new CartaoTela(getDriver())
                .tocarServicosCartao();

    }
    /**
     * Método para tocar Visa Causa
     *
     * @throws Exception
     */
    public void visaCausa() throws Exception {
        new ServicosCartaoTela(getDriver())
                .tocarVisaCausa();
    }

    /**
     * Método para seguro do cartao
     *
     * @throws Exception
     */
    public void seguroCartao() throws Exception {
        new ServicosCartaoTela(getDriver())
                .tocarSeguroCartao();
    }

    /**
     * Método para seguro do cartao
     *
     * @throws Exception
     */
    public void criarAvisoViagem(String texto) throws Exception {
        String dataInicial = proximoDiaUtil(1);
        String dataFinal = proximoDiaUtil(14);

        new ServicosCartaoTela(getDriver())
                .tocarBotaoAvisoViagem()
                .tocarBotaoContinuar()
                .tocarSelecionarContinente()
                .seleconarContinente()
                .tocarBotaoConfirmar()
                .tocarSelecionarPeriodo();
        new CalendarioTela(getDriver())
                .selecionarData(false,dataInicial)
                .tocarBotaoConfirmar()
                .selecionarData(false,dataFinal)
                .tocarBotaoConfirmar();
        new ServicosCartaoTela(getDriver())
                .tocarBotaoContinuarContinente()
                .validarMensagemSucesso(texto)
                .tocarBotaoOk();
    }
}
