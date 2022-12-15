package funcionalidade.mobile.cartao.desbloqueio;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.cartao.desbloqueio.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CartaoDesbloqueioFunc extends FuncionalidadeBase {

    /**
     * Informa recebimento do cartão
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
     * Informar os 4 últimos dígitos do cartão
     * @param numCartaoOuDigitos
     */
    public void informarDigitosCartao(String numCartaoOuDigitos) throws Exception {
        new CartaoDesbloqueioTela(getDriver())
                .informar4UltimosDigitos(numCartaoOuDigitos)
                .tocarBotaoContinuar();
    }

    /**
     * Informar código de segurança CVV
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
     * Validar tela do cartão após o desbloqueio (com os botões)
     */
    public void aceitarMensagemConfirmacaoDesbloqueio(String... textosTipoCartao) throws Exception {
        new CartaoDesbloqueioTela(getDriver())
                .tocarBotaoOK();
        new CartaoTela(getDriver())
                .validarTituloTela()
                .validarTipoCartao(textosTipoCartao);
    }

}
