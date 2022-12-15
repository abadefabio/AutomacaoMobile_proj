package funcionalidade.mobile.investimentos.home;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.HomeJornadaTela;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.investimentos.meus.DetalhesProdutoTela;
import pagina.mobile.jornadas.investimentos.meus.investimentos.MeusInvestimentosTela;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.jornadas.perfil.investidor.SeuPerfilTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class HomeInvestimentosFunc extends FuncionalidadeBase {

    /**
     * ACESSAR API DE QUEST�ES PARA DESCOBRIR O PERFIL DE INVESTIDOR
     *
     * @throws Exception
     */
    public void descubraSeuPerfilDeInvestidor() throws Exception {
         new HomeInvestimentosTela(getDriver())
                .tocarBotaoDescubraSeuPerfil();
    }

    /**
     * ACESSAR API DE QUEST�ES PARA REFAZER O PERFIL DE INVESTIDOR
     *
     * @throws Exception
     */
    public void refazerPerfilDeInvestidor() throws Exception {
        new HomeInvestimentosTela(getDriver())
                .validarTituloTela()
                .tocarBotaoPerfilDeInvestidor();
        new SeuPerfilTela(getDriver())
                .verificarTituloTela()
                .tocarBotaoRefazerPerfil();
    }

    /**
     * Selecionar o bot�o voltar
     * para retornar a tela inicial do app
     *
     * @throws Exception
     */
    public void tocarMeusInvestimentos() throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();
    }

    /**
     * M�todo respons�vel por validar a aus�ncia do bot�o 'Meus investimentos'
     *
     * @throws Exception
     */
    public void validarAusenciaBotaoMeusInvestimentos() throws Exception {
        new DetalhesProdutoTela(getDriver())
                .tocarBotaoVoltar();
        if (getDriver() instanceof AndroidDriver) {
            new MeusInvestimentosTela(getDriver())
                    .tocarBotaoVoltar()
                    .validarAusenciaBlocoEmProcessamento()
                    .tocarBotaoVoltar();
            new CarregamentoTela(getDriver())
                    .aguardarCarregamentoTela();
        } else {
            // TODO Remover condi��o (else) quando o defeito NEXT2-231373 for conclu�do
            new HomeJornadaTela(getDriver())
                    .tocarBotaoVoltarTelaInicialApp();
            new MenuTela(getDriver())
                    .clicarMenuInvestimentos();
        }
        new HomeInvestimentosTela(getDriver())
                .validarAusenciaBotaoMeusInvestimentos();
        new HomeJornadaTela(getDriver())
                .tocarBotaoVoltarTelaInicialApp();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }
}
