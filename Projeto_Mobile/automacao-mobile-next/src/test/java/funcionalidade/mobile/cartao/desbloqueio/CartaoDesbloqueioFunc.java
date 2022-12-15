package funcionalidade.mobile.cartao.desbloqueio;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.cartao.desbloqueio.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CartaoDesbloqueioFunc extends FuncionalidadeBase {

    /**
     * Informa recebimento do cart�o
     * @param mensagensDesbloqueio
     * @throws Exception
     */
    public void informarRecebimento(String[] mensagensDesbloqueio, String... textosEsperados) throws Exception {
        new CartaoTela(getDriver())
                .validarMensagensTela(mensagensDesbloqueio)
                .tocarRecebiCartao();
        new CartaoDesbloqueioTela(getDriver())
                .validarMensagens(textosEsperados);
    }

    /**
     * Selecionar Desbloquear
     * @param textosEsperados
     */
    public void desbloquearCartao(String... textosEsperados) throws Exception {
        new CartaoDesbloqueioTela(getDriver())
                .tocarBotaoDesbloquear()
                .validarPresencaBotaoDesbloquearSemSeguro();
    }

    /**
     * Selecionar Desbloquear Sem Seguro
     */
    public void desbloquearSemSeguro() throws Exception {
        new CartaoDesbloqueioTela(getDriver())
                .tocarBotaoDesbloquearSemSeguro()
                .validarPresencaCampo4DigitosCartao();
    }

    /**
     * Informar os 4 �ltimos d�gitos do cart�o
     * @param numCartaoOuDigitos
     */
    public void informarDigitosCartao(String numCartaoOuDigitos) throws Exception {
        new CartaoDesbloqueioTela(getDriver())
                .informar4UltimosDigitos(numCartaoOuDigitos)
                .tocarBotaoContinuar();
    }

    /**
     * Informar c�digo de seguran�a CVV
     * @param cvv
     * @param textosEsperados
     */
    public void informarCodigoSegurancaCvv(String cvv, String... textosEsperados) throws Exception {
        new CartaoDesbloqueioTela(getDriver())
                .informarCvv(cvv)
                .tocarBotaoContinuar()
                .validarMensagens(textosEsperados);

    }

    /**
     * Validar tela do cart�o ap�s o desbloqueio (com os bot�es)
     */
    public void aceitarMensagemConfirmacaoDesbloqueio(String... textosTipoCartao) throws Exception {
        new CartaoDesbloqueioTela(getDriver())
                .tocarBotaoOK();
        new CartaoTela(getDriver())
                .validarTituloTela()
                .validarTipoCartao(textosTipoCartao);
    }

}
