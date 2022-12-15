package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.ContratarSeguroTela;
import pagina.mobile.jornadas.cartao.fatura.DesbloqueioDeCartaoTela;
import pagina.mobile.jornadas.cartao.fatura.YeahTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AtivarCartaoFunc extends FuncionalidadeBase {

    /**
     * Ativar Cartão de Crédito
     *
     * @throws Exception
     */
    public void ativarCartaoDeCredito(String cartao, String cvv) throws Exception {
        new CartaoTela(getDriver())
                .validarTelaCartao()
                .tocarAtivarCartaodeCredito();
        new YeahTela(getDriver())
                .validarTelaYEAH()
                .tocarBotaoAtivarAgora();
        new ContratarSeguroTela(getDriver())
                .validarMensagemContratarSeguro()
                .tocarContratarSemSeguro();
        new DesbloqueioDeCartaoTela(getDriver())
                .validarTelaDesbloqueioDeCartao()
                .preencherQuatroUltimosDigitosDoCartão(cartao)
                .tocarBotaoContinuar()
                .preencherCVV(cvv)
                .tocarBotaoContinuar()
                .validarMensagemCreditoAtivado()
                .tocarBotaoOK();
        new CartaoTela(getDriver())
                .validarPresencaBotaoVerFatura();
    }
}
