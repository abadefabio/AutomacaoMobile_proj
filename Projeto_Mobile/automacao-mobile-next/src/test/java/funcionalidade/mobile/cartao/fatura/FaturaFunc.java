package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import framework.AcoesGerais;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.FaturaTela;
import pagina.mobile.jornadas.cartao.fatura.PagarTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class FaturaFunc extends FuncionalidadeBase {

    /**
     * Método para Ver Fatura Cartao'
     *
     * @throws Exception
     */
    public void verFaturaCartao() throws Exception {
        new CartaoTela(getDriver())
                .tocarVerFatura();
        new FaturaTela(getDriver())
                .validarTituloTela();
    }

    /**
     * Método para gerar Boleto - fatura'
     * FR
     *
     * @throws Exception
     */
    public void gerarBoletoFaturaAnterior() throws Exception {
        new CartaoTela(getDriver())
                .tocarVerFatura();
        new FaturaTela(getDriver())
                .validarTituloTela()
                .buscarPresencaBotaoBoleto();
        String valorFatura = new FaturaTela(getDriver()).retornarValorDaFatura();

        new FaturaTela(getDriver())
                .tocarGerarBoleto();
        new PagarTela(getDriver())
                .validarTituloTela();
        if (getDriver() instanceof IOSDriver) {
            new ValidaMensagensTela(getDriver())
                    .validarTodasAsMensagens(valorFatura.substring(3));
        }
        new AcoesGerais(getDriver())
                .esconderTeclado();
    }

    /**
     * Método para gerar visualizar - fatura'
     * FR
     *
     * @throws Exception
     */
    public void visualizarFatura() throws Exception {
        new CartaoTela(getDriver())
                .tocarVerFatura();
        new FaturaTela(getDriver())
                .validarTituloTela()
                .buscarPresencaBotaoFaturaEmPdf()
                .tocarBotaoFaturaEmPdf()
                .validarTituloTela()
                .validarApresencaBotaoCompartilhar()
                .validarApresentacaoWebViewFaturaEmPdf();
    }
}
