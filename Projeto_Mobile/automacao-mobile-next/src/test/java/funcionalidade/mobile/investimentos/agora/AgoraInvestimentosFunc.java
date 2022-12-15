package funcionalidade.mobile.investimentos.agora;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.investimentos.Agora.Texto;
import constantes.investimentos.Segmento;
import constantes.investimentos.TituloTela;
import pagina.mobile.comum.next.HomeJornadaTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.investimentos.agora.AgoraInvestimentosTela;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.menu.MenuTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AgoraInvestimentosFunc extends FuncionalidadeBase {

    /**
     * Método responsável por validar a apresentação da tela de cadastro Ágora Investimentos no navegador do APP
     *
     * @throws Exception
     */
    public void validarExibicaoNavegadorCadastroAgoraInvestimentos() throws Exception {
        new HomeInvestimentosTela(getDriver())
                .selecionarSegmento(Segmento.AGORA_INVESTIMENTOS);
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TituloTela.AGORA_INVESTIMENTOS.toString());
        new AgoraInvestimentosTela(getDriver())
                .tocarBotaoQueroComecarAgora();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Texto.JA_INICIOU_SEU_CADASTRO);
        new AgoraInvestimentosTela(getDriver())
                .voltarParaAppNext()
                .tocarBotaoVoltar();
        new HomeJornadaTela(getDriver())
                .tocarBotaoVoltarTelaInicialApp();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }
}
