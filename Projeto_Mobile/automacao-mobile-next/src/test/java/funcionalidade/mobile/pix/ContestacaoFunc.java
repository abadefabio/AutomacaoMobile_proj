package funcionalidade.mobile.pix;

import constantes.pix.Mensagens;
import constantes.pix.TipoContestacao;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.extratos.e.comprovantes.ContestacaoDeDevolucaoTela;
import pagina.mobile.jornadas.pix.extratos.e.comprovantes.DetalhesDaTransacaoTela;
import pagina.mobile.jornadas.pix.extratos.e.comprovantes.ExtratosEComprovantesTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ContestacaoFunc {

    /**
     * Método para criar uma contestação Pix
     * @throws Exception
     */
    public void efetuarContestacaoPix(String valor, TipoContestacao contestacao, String descricaoContestacao) throws Exception {
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ExtratosEComprovantesTela(getDriver())
                .expandirTransacaoPeloValor(valor);
        new DetalhesDaTransacaoTela(getDriver())
                .tocarBotaoReportarUmProblema();
        switch (contestacao){
            case FUI_VITIMA_DE_GOLPE_AMEACA:
                new ContestacaoDeDevolucaoTela(getDriver())
                        .selecionarOTipoDeContestacao(TipoContestacao.FUI_VITIMA_DE_GOLPE_AMEACA)
                        .preencherCampoDescricao(descricaoContestacao)
                        .tocarBotaoContinuar()
                        .tocarBotaoSolicitarDevolucao();
                new ValidaMensagensTela(getDriver())
                        .validarTodasAsMensagens(Mensagens.SOLICITACAO_ENVIADA);
                new ContestacaoDeDevolucaoTela(getDriver())
                        .tocarBotaoVoltarAoPix();
                if (getDriver() instanceof AndroidDriver) {
                    new PixTela(getDriver())
                            .tocarBotaoExtratosEComprovantes();
                }
                new ExtratosEComprovantesTela(getDriver())
                        .expandirTransacaoPeloValor(valor);
                new DetalhesDaTransacaoTela(getDriver())
                        .tocarBotaoPixEmContestacao();
                new ValidaMensagensTela(getDriver())
                        .validarTodasAsMensagens(Mensagens.PIX_EM_ANALISE);
            break;
        }
    }
}
