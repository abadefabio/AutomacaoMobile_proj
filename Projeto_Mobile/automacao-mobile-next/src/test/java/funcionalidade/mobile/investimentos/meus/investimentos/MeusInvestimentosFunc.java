package funcionalidade.mobile.investimentos.meus.investimentos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.HomeJornadaTela;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.investimentos.meus.DetalhesProdutoTela;
import pagina.mobile.jornadas.investimentos.meus.investimentos.MeusInvestimentosTela;
import pagina.mobile.jornadas.menu.MenuTela;

public class MeusInvestimentosFunc extends FuncionalidadeBase {

    /**
     * Método responsável por validar a ausência do bloco 'Em processamento'
     *
     * @throws Exception
     */
    public void validarAusenciaBlocoEmProcessamento() throws Exception {
        new HomeInvestimentosTela(getDriver())
                .tocarBotaoMeusInvestimentos();
        new MeusInvestimentosTela(getDriver())
                .validarAusenciaBlocoEmProcessamento();
        voltarTelaPrincipalApp();
    }

    /**
     * Método responsável por validar o bloco 'Em Processamnto' (se existir, extrair a quantidade de solicitações em aberto)

     * @param solicitacoes Quantidade de solicitações em aberto
     * @throws Exception
     */
    public void validarBlocoEmProcessamentoAposExclusaoAplicacao(ThreadLocal<Integer> solicitacoes) throws Exception {
        new DetalhesProdutoTela(getDriver())
                .tocarBotaoVoltar();
        // TODO Ajustar quando defeito de inconsistência de tela Android e iOS for concluído
        if (getDriver() instanceof AndroidDriver) {
            new MeusInvestimentosTela(getDriver())
                    .tocarBotaoVoltar();
            new CarregamentoTela(getDriver())
                    .aguardarCarregamentoTela();
        } else {
            new CarregamentoTela(getDriver())
                    .aguardarCarregamentoTela();
            new HomeInvestimentosTela(getDriver())
                    .tocarBotaoMeusInvestimentos();
        }

        solicitacoes.set(solicitacoes.get() - 1);

        if (solicitacoes.get() != 0) {
            new MeusInvestimentosTela(getDriver())
                    .validarSolicitacoesEmAberto(solicitacoes);
        } else {
            new MeusInvestimentosTela(getDriver())
                    .validarAusenciaBlocoEmProcessamento();
        }
        voltarTelaPrincipalApp();
    }

    /**
     * Método responsável por voltar a tela principal do app
     *
     * @throws Exception
     */
    private void voltarTelaPrincipalApp() throws Exception {
        new MeusInvestimentosTela(getDriver())
                .tocarBotaoVoltar();
        new HomeJornadaTela(getDriver())
                .tocarBotaoVoltarTelaInicialApp();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }
}
