package funcionalidade.mobile.pix;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.tools.Utilitarios;

import constantes.pix.ChavesPix;
import constantes.pix.Pix;
import constantes.pix.TipoConta;
import constantes.pix.TipoTransacao;
import constantes.pix.ValorPix;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.comum.so.ModalCompartilhamentoTela;
import pagina.mobile.jornadas.pix.copia.cola.ComprovanteTela;
import pagina.mobile.jornadas.pagamentos.AgendarTela;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.transferir.*;

public class TransferirPixFunc {

    /**
     * Método executa fluxo para transferência de PIX através de chave PIX
     *
     * @param chavePix
     * @param chave
     * @param origemPagamento
     * @param tipoTransacao
     * @throws Exception
     */
    public void transferirPix(
            ChavesPix chavePix,
            String chave,
            TipoConta origemPagamento,
            TipoTransacao tipoTransacao) throws Exception {

        String valor = ValorPix.ALEATORIO_MINIMO.getValue();

        new EscolhaChaveDoDestinatarioTela(getDriver())
                .selecionarChavePix(chavePix);
        switch (chavePix) {
            case CPF_CNPJ:
                new CpfCnpjTela(getDriver())
                        .preencherCpfCnpj(chave)
                        .tocarBotaoAvancar();
            break;
            case EMAIL:
                new EmailTela(getDriver())
                        .preencherCampoEmail()
                        .tocarBotaoAvancar();
                break;

            case CELULAR:
                new CelularTela(getDriver())
                        .tocarBotaoCelular()
                        .preencherCampoCelular()
                        .tocarBotaoAvancar();
                break;
        }
        new OrigemPagamentoTela(getDriver())
                .selecionarOrigemPagamento(origemPagamento);
        new InserirValorTela(getDriver())
                .preencherCampoValor(valor)
                .tocarBotaoAvancar();
        switch (tipoTransacao) {
            case AGENDAMENTO:
                new ConfirmeOsDadosTela(getDriver())
                        .tocarBotaoQuando();
                new AgendarTela(getDriver())
                        .selecionarDataAgendamento()
                        .tocarBotaoConfirmar();
                new ConfirmeOsDadosTela(getDriver())
                        .tocarBotaoDescricao()
                        .preencherDescricao(chave)
                        .tocarBotaoSalvarMensagem()
                        .tocarBotaoAgendarTransacao();
                if (getDriver() instanceof IOSDriver) {
                    new ValidaMensagensTela(getDriver())
                            .validarTodasAsMensagens(Pix.TRANSACAO_PIX_AGENDADA_SUCESSO_IOS);
                } else {
                    new ValidaMensagensTela(getDriver())
                            .validarTodasAsMensagens(Pix.TRANSACAO_PIX_AGENDADA_SUCESSO_ANDROID);
                }
                new ConfirmeOsDadosTela(getDriver())
                        .tocarBotaoVerComprovante()
                        .tocarBotaoCompartilhar();
                new ModalCompartilhamentoTela(getDriver())
                        .validarModalCompartilhamento();
                break;
            case TRANSFERENCIA_EMAIL:
                new ConfirmeOsDadosTela(getDriver())
                        .tocarBotaoRealizarTransacao();
                new SucessoTela(getDriver())
                        .validarMensagemTransacaoRealizada()
                        .tocarBotaoVoltarAoPIX();
                new PixTela(getDriver())
                        .validarTelaPix()
                        .tocarBotaoMostrarSaldo();
                break;
            case TRANSFERENCIA_CELULAR:
                new ConfirmeOsDadosTela(getDriver())
                        .tocarBotaoRealizarTransacao();
                new SucessoTela(getDriver())
                        .validarMensagemTransacaoRealizada();
                new ConfirmeOsDadosTela(getDriver())
                        .tocarBotaoVerComprovante();
                new ComprovanteTela(getDriver())
                        .tocarBotaoVoltarAoPix();
                break;
        }
    }
}
