package funcionalidade.mobile.pagamentos.codigo.barras;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.pagamentos.Mensagem;
import constantes.pagamentos.TipoConta;
import constantes.pagamentos.codigo.barras.TipoPagamento;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.pagamentos.AgendamentoTela;
import pagina.mobile.jornadas.pagamentos.AgendarTela;
import pagina.mobile.jornadas.pagamentos.codigo.barras.ConfirmacaoTela;
import pagina.mobile.jornadas.pagamentos.codigo.barras.DigitarCodigoDeBarrasTela;
import pagina.mobile.jornadas.pagamentos.codigo.barras.LeitorCodigoDeBarrasTela;
import pagina.mobile.jornadas.pagamentos.codigo.barras.boleto.BoletoEdicaoTela;
import pagina.mobile.jornadas.pagamentos.codigo.barras.boleto.BoletoTela;
import pagina.mobile.jornadas.pagamentos.codigo.barras.consumo.ContaDeConsumoEdicaoTela;
import pagina.mobile.jornadas.pagamentos.codigo.barras.consumo.ContaDeConsumoTela;
import pagina.mobile.jornadas.pagamentos.codigo.barras.tributo.TributoTela;
import pagina.mobile.jornadas.pagamentos.comprovante.ComprovantePdfTela;
import pagina.mobile.jornadas.pagamentos.comprovante.ComprovanteTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static java.util.Objects.isNull;

public class CodigoDeBarrasFunc extends FuncionalidadeBase {

    /**
     * Fluxo para pagamento com código de barras
     *
     * @param pagamento
     * @param conta
     * @param codigoDeBarras
     * @param dataVencimento
     * @param dataPagamento
     * @param favorecido
     * @param valor
     * @param descricao
     * @throws Exception
     */
    public void pagarComCodigoDeBarras(TipoPagamento pagamento,
                                       TipoConta conta,
                                       String codigoDeBarras,
                                       String dataVencimento,
                                       String dataPagamento,
                                       String favorecido,
                                       String valor,
                                       ThreadLocal valorArmazenado,
                                       String descricao) throws Exception {

        pagarComCodigoDeBarras(pagamento, conta, codigoDeBarras, dataVencimento, dataPagamento, favorecido, valor, valorArmazenado, descricao, "");
    }

    /**
     * Fluxo para pagamento com código de barras
     *
     * @param pagamento
     * @param conta
     * @param codigoDeBarras
     * @param dataVencimento
     * @param dataPagamento
     * @param favorecido
     * @param valor
     * @param descricao
     * @param beneficiario
     * @throws Exception
     */
    public void pagarComCodigoDeBarras(TipoPagamento pagamento,
                                       TipoConta conta,
                                       String codigoDeBarras,
                                       String dataVencimento,
                                       String dataPagamento,
                                       String favorecido,
                                       String valor,
                                       ThreadLocal valorArmazenado,
                                       String descricao,
                                       String beneficiario) throws Exception {
        dataVencimento = isNull(dataVencimento) ? "" : dataVencimento;
        dataPagamento = isNull(dataPagamento) ? "" : dataPagamento;
        favorecido = isNull(favorecido) ? "" : favorecido;
        valorArmazenado.set(valor);

        new LeitorCodigoDeBarrasTela(getDriver())
                .tocarbotaoDigitarCodigoDeBarras();
        new DigitarCodigoDeBarrasTela(getDriver())
                .validarPresencaDigitarCodigoDeBarrasTela()
                .preencherCampoCodigoDeBarras(codigoDeBarras)
                .tocarbotaoConfirmar();

        switch (pagamento) {
            case BOLETO:
                new BoletoTela(getDriver())
                        .validarPresencaBoletoTela()
                        .selecionarSim()
                        .tocarbotaoConfirmar();
                new BoletoEdicaoTela(getDriver())
                        .validarPresencaBoletoTela()
                        .preencherCampoDescricao(descricao);

                switch (conta) {
                    case CONTA_CORRENTE:
                        new BoletoEdicaoTela(getDriver())
                                .selecionarContaCorrente();
                        break;
                    case CONTA_POUPANCA:
                        new BoletoEdicaoTela(getDriver())
                                .selecionarContaPoupanca();
                        break;
                }
                new BoletoEdicaoTela(getDriver())
                        .tocarbotaoContinuar();
                new ConfirmacaoTela(getDriver())
                        .validarDadosBoleto(codigoDeBarras, dataVencimento, dataPagamento, favorecido, valor)
                        .tocarbotaoContinuar();
                if (getDriver() instanceof AndroidDriver) {
                    new PopUpTela(getDriver())
                            .validarMensagem(Mensagem.SUCESSO_ANDROID);
                } else {
                    new PopUpTela(getDriver())
                            .validarMensagem(Mensagem.SUCESSO_IOS);
                }
                new PopUpTela(getDriver())
                        .tocarBotaoOk();
                new ComprovanteTela(getDriver())
                        .validarPresencaComprovanteTela();
                break;

            case TRIBUTO:
                new TributoTela(getDriver())
                        .validarPresencaTributoTela()
                        .validarDadosTributo(codigoDeBarras, dataPagamento, valor)
                        .tocarbotaoConfirmar()
                        .preencherCampoDescricao(descricao);
                switch (conta) {
                    case CONTA_CORRENTE:
                        new BoletoEdicaoTela(getDriver())
                                .selecionarContaCorrente();
                        break;
                    case CONTA_POUPANCA:
                        new BoletoEdicaoTela(getDriver())
                                .selecionarContaPoupanca();
                        break;
                }
                new TributoTela(getDriver())
                        .tocarbotaoPagarAgora();
                new ComprovanteTela(getDriver())
                        .validarPresencaComprovanteTela();
                break;

            case CONTA_CONSUMO:
                new ContaDeConsumoTela(getDriver())
                        .validarTextoTituloContaConsumo()
                        .validarInformacoesContaConsumo(codigoDeBarras, valor, favorecido)
                        .tocarBotaoConfirmar();
                new ContaDeConsumoEdicaoTela(getDriver())
                        .validarInformacoesContaConsumo(codigoDeBarras, valor)
                        .preencherDescricaoPagamento(descricao);
                switch (conta) {
                    case CONTA_CORRENTE:
                        new ContaDeConsumoEdicaoTela(getDriver())
                                .tocarBotaoContaCorrente();
                        break;
                    case CONTA_POUPANCA:
                        new ContaDeConsumoEdicaoTela(getDriver())
                                .tocarBotaoContaPoupanca();
                        break;
                }
                new pagina.mobile.jornadas.pagamentos.contadeconsumo.ContaDeConsumoTela(getDriver())
                        .tocarBotaoPagarAgora();
                new ComprovanteTela(getDriver())
                        .validarComprovanteTela()
                        .tocarLinkVisualizar()
                        .validarComprovanteEmPdf();
                new ComprovantePdfTela(getDriver())
                        .validarPresencaTelaComprovantePDF()
                        .tocarBotaoCompartilhar();
                break;
        }
    }


    /**
     * Fluxo para pagamento com código de barras
     *
     * @param pagamento
     * @param conta
     * @param codigoDeBarras
     * @param valor
     * @param descricao
     * @throws Exception
     */
    public void pagarComCodigoDeBarras(TipoPagamento pagamento,
                                       TipoConta conta,
                                       String codigoDeBarras,
                                       String valor,
                                       ThreadLocal valorArmazenado,
                                       String descricao) throws Exception {
        pagarComCodigoDeBarras(pagamento, conta, codigoDeBarras,null, null, null, valor, valorArmazenado, descricao);
    }

    /**
     * preencher código de barra
     *
     * @param codigoDeBarras
     * @throws Exception
     */
    public void preencherCodigoDeBarra(String codigoDeBarras) throws Exception {
        new LeitorCodigoDeBarrasTela(getDriver())
                .tocarbotaoDigitarCodigoDeBarras();
        new DigitarCodigoDeBarrasTela(getDriver())
                .validarPresencaDigitarCodigoDeBarrasTela()
                .preencherCampoCodigoDeBarras(codigoDeBarras)
                .tocarbotaoConfirmar();
        new pagina.mobile.jornadas.pagamentos.contadeconsumo.ContaDeConsumoTela(getDriver())
                .validarContaDeConsumoTela();
    }

    /**
     * Fluxo para agendar com código de barras
     *
     * @param pagamento
     * @param conta
     * @param codigoDeBarras
     * @param dataVencimento
     * @param dataPagamento
     * @param favorecido
     * @param valor
     * @param descricao
     * @throws Exception
     */
    public void agendarComCodigoDeBarras(TipoPagamento pagamento,
                                       TipoConta conta,
                                       String codigoDeBarras,
                                       String dataVencimento,
                                       String dataPagamento,
                                       String favorecido,
                                       String valor,
                                       ThreadLocal valorArmazenado,
                                       String descricao) throws Exception {
        valorArmazenado.set(valor);

        new LeitorCodigoDeBarrasTela(getDriver())
                .tocarbotaoDigitarCodigoDeBarras();
        new DigitarCodigoDeBarrasTela(getDriver())
                .validarPresencaDigitarCodigoDeBarrasTela()
                .preencherCampoCodigoDeBarras(codigoDeBarras)
                .tocarbotaoConfirmar();

        switch (pagamento) {
            case BOLETO:
                new BoletoTela(getDriver())
                        .validarPresencaBoletoTela()
                        .selecionarSim()
                        .tocarbotaoConfirmar();
                new BoletoEdicaoTela(getDriver())
                        .validarPresencaBoletoTela()
                        .preencherCampoDescricao(descricao);

                switch (conta) {
                    case CONTA_CORRENTE:
                        new BoletoEdicaoTela(getDriver())
                                .selecionarContaCorrente();
                        break;
                    case CONTA_POUPANCA:
                        new BoletoEdicaoTela(getDriver())
                                .selecionarContaPoupanca();
                        break;
                }
                new BoletoEdicaoTela(getDriver())
                        .tocarbotaoContinuar();
                new ConfirmacaoTela(getDriver())
                        .validarDadosBoleto(codigoDeBarras, dataVencimento, dataPagamento, favorecido, valor)
                        .tocarbotaoContinuar();
                new PopUpTela(getDriver())
                        .validarMensagem(Mensagem.SUCESSO_ANDROID)
                        .tocarBotaoOk();
                new ComprovanteTela(getDriver())
                        .validarPresencaComprovanteTela();
                break;

            case TRIBUTO:
                new TributoTela(getDriver())
                        .validarPresencaTributoTela()
                        .validarDadosTributo(codigoDeBarras, dataPagamento, valor)
                        .tocarbotaoConfirmar()
                        .preencherCampoDescricao(descricao);
                switch (conta) {
                    case CONTA_CORRENTE:
                        new BoletoEdicaoTela(getDriver())
                                .selecionarContaCorrente();
                        break;
                    case CONTA_POUPANCA:
                        new BoletoEdicaoTela(getDriver())
                                .selecionarContaPoupanca();
                        break;
                }
                new ContaDeConsumoEdicaoTela(getDriver())
                        .tocarSwitchAgendarPagamento();
                new AgendarTela(getDriver())
                        .validarTextoTituloAgendar()
                        .selecionarDataAgendamento()
                        .tocarBotaoConfirmar();
                new ContaDeConsumoEdicaoTela(getDriver())
                        .tocarBotaoAgendarAgora();
                new AgendamentoTela(getDriver())
                        .validarTextoTituloAgendamento()
                        .tocarBotaoVisualizar();
                new ComprovanteTela(getDriver())
                        .validarPresencaComprovanteTela();
                break;

            case CONTA_CONSUMO:
                new ContaDeConsumoTela(getDriver())
                        .validarTextoTituloContaConsumo()
                        .validarInformacoesContaConsumo(codigoDeBarras, valor, favorecido)
                        .tocarBotaoConfirmar();
                new ContaDeConsumoEdicaoTela(getDriver())
                        .validarInformacoesContaConsumo(codigoDeBarras, valor)
                        .preencherDescricaoPagamento(descricao);
                switch (conta) {
                    case CONTA_CORRENTE:
                        new ContaDeConsumoEdicaoTela(getDriver())
                                .tocarBotaoContaCorrente();
                        break;
                    case CONTA_POUPANCA:
                        new ContaDeConsumoEdicaoTela(getDriver())
                                .tocarBotaoContaPoupanca();
                        break;
                }
                new ContaDeConsumoEdicaoTela(getDriver())
                        .tocarSwitchAgendarPagamento();
                new AgendarTela(getDriver())
                        .validarTextoTituloAgendar()
                        .selecionarDataAgendamento()
                        .tocarBotaoConfirmar();
                new ContaDeConsumoEdicaoTela(getDriver())
                        .validarTextoTituloContaConsumo()
                        .tocarBotaoAgendarAgora();
                new AgendamentoTela(getDriver())
                        .validarTextoTituloAgendamento()
                        .validarInformacoesDePagamento(descricao, valor)
                        .tocarBotaoVisualizar();
                new ComprovantePdfTela(getDriver())
                        .validarPresencaTelaComprovantePDF()
                        .tocarBotaoCompartilhar();
                break;
        }
    }
}
