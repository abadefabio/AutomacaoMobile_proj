package funcionalidade.mobile.pix;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.pix.Mensagens;
import org.json.simple.JSONObject;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.copia.cola.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class PixCopiaColaFunc extends FuncionalidadeBase {

    /**
     * Pagar QR Code de Cobrança Pix Copia e Cola
     *
     * @param codigoPagamentoPix QR Code gerado pela API
     * @param origemPagamento    Tipo de pagamento a ser selecionado (Conta Corrente ou Conta Poupança)
     * @param validarDados       Campos e valores a serem validados e passados
     * @param dados              Campos a serem buscados na tela cadastrados na 'Interface ConfirmeOsDados'
     * @throws Exception
     */
    public void pagarQRCodeCobrancaCopiaCola(String codigoPagamentoPix, String origemPagamento, JSONObject validarDados, String[] dados) throws Exception {
        new PixTela(getDriver())
                .tocarBotaoPixCopiaCola();
        new CopiaColaTela(getDriver())
                .preencherCampoCodigoPagamentoPix(codigoPagamentoPix)
                .tocarBotaoAvancar();
        new OrigemPagamentoTela(getDriver())
                .tocarBotaoOrigemPagamento(origemPagamento);
        new ConfirmeOsDadosTela(getDriver())
                .validarInformacoesTelaConfirmeDados(validarDados, dados)
                .tocarBotaoRealizarTransacao();
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Mensagens.TRANSACAO_PIX_REALIZADA_COM_SUCESSO);
        new SucessoTela(getDriver())
                .tocarBotaoVerComprovante();
        new ComprovanteTela(getDriver())
                .validarPresencaTituloComprovante()
                .tocarBotaoVoltarAoPix();
        new PixTela(getDriver())
                .validarTelaPix();
    }

    /**
     * Agendar QR Code de Cobrança Pix Copia e Cola
     * fr
     * @param codigoPagamentoPix
     * @param origemPagamento
     * @param validarDados
     * @throws Exception
     */
    public void agendarQRCodeCobrancaCopiaCola(String codigoPagamentoPix, String origemPagamento, JSONObject validarDados, String[] dados, String data) throws Exception {
        new PixTela(getDriver())
                .tocarBotaoPixCopiaCola();
        new CopiaColaTela(getDriver())
                .preencherCampoCodigoPagamentoPix(codigoPagamentoPix)
                .tocarBotaoAvancar();
        new OrigemPagamentoTela(getDriver())
                .tocarBotaoOrigemPagamento(origemPagamento);
        new ConfirmeOsDadosTela(getDriver())
                .tocarBotaoQuando();
        new CalendarioTela(getDriver())
                .selecionarData(false, data)
                .tocarBotaoConfirmar();
        new ConfirmeOsDadosTela(getDriver())
                .validarInformacoesTelaConfirmeDados(validarDados,dados)
                .tocarBotaoAgendarTransacao();
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Mensagens.TRANSACAO_PIX_AGENDADO_COM_SUCESSO);
        new SucessoTela(getDriver())
                .tocarBotaoVerComprovante();
        new ComprovanteTela(getDriver())
                .validarPresencaTituloComprovante()
                .tocarBotaoVoltarAoPix();
        new PixTela(getDriver())
                .validarTelaPix();
    }

    /**
     * Pagar QR Code de Cobrança Pix Copia e Cola, e consulta Informações Adicionais
     *
     * @param codigoPagamentoPix QR Code gerado pela API
     * @param origemPagamento    Tipo de pagamento a ser selecionado (Conta Corrente ou Conta Poupança)
     * @param validarDados       Campos e valores a serem validados e passados
     * @param dados              Campos a serem buscados na tela cadastrados na 'Interface ConfirmeOsDados'
     * @throws Exception
     */
    public void pagarQRCodeCobrancaCopiaColaInformacoesAdicionais(String codigoPagamentoPix, String origemPagamento, JSONObject validarDados, String[] dados) throws Exception {
        new PixTela(getDriver())
                .tocarBotaoPixCopiaCola();
        new CopiaColaTela(getDriver())
                .preencherCampoCodigoPagamentoPix(codigoPagamentoPix)
                .tocarBotaoAvancar();
        new OrigemPagamentoTela(getDriver())
                .tocarBotaoOrigemPagamento(origemPagamento);
        new ConfirmeOsDadosTela(getDriver())
                .tocarInformacoesAdicionais();
        new InformacoesAdicionaisTela(getDriver())
                .validarTituloInformacoesAdicionais()
                .validarTextosNomeRegraTelaInformacoesAdicionais()
                .tocarBotaoVoltarInformacoesAdicionais();
        new ConfirmeOsDadosTela(getDriver())
                .validarInformacoesTelaConfirmeDados(validarDados, dados)
                .tocarBotaoRealizarTransacao();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Mensagens.TRANSACAO_PIX_REALIZADA_COM_SUCESSO);
        new SucessoTela(getDriver())
                .tocarBotaoVerComprovante();
        new ComprovanteTela(getDriver())
                .validarPresencaTituloComprovante()
                .tocarBotaoVoltarAoPix();
        new PixTela(getDriver())
                .validarTelaPix();
    }
}
