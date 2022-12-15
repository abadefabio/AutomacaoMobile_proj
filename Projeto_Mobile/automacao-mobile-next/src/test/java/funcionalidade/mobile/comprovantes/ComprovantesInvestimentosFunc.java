package funcionalidade.mobile.comprovantes;

import pagina.mobile.jornadas.comprovantes.investimentos.ExtratoTela;
import pagina.mobile.jornadas.comprovantes.investimentos.InvestimentosTela;
import pagina.mobile.jornadas.comprovantes.investimentos.PeriodoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ComprovantesInvestimentosFunc {

    /**
     * Visualiza Detalhes do Comprovante.<br><br>
     *
     * Obs.: Mapear o titulo da tela do investimento em constantes > comprovantes > TituloTela.
     *
     * @param tituloInvestimentoTela Recebe o Titulo da tela já mapeado
     * @throws Exception
     */
    public void visualizarDetalhes(String tituloInvestimentoTela) throws Exception {

        new InvestimentosTela(getDriver())
                .validarPresencaTelaInvestimentos()
                .tocarOpcaoNextCdb()
                .validarPresencaTela(tituloInvestimentoTela)
                .tocarBotaoSelecionarPeriodo();
        new PeriodoTela(getDriver())
                .validarPresencaTelaPeriodo()
                .tocarBotaoConfirmar();
        new InvestimentosTela(getDriver())
                .tocarBotaoVisualizar();
        new ExtratoTela(getDriver())
                .validarPresencaTelaExtrato();
    }

    /**
     * Enviar o comprovante por email
     *
     * @throws Exception
     */
    public void enviarPorEmail() throws Exception {

        new ExtratoTela(getDriver())
                .tocarBotaoEnviarPorEmail()
                .validarMensagemExtratoEnviado()
                .tocarBotaoOk();
    }
}
