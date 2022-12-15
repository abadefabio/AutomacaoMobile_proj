package funcionalidade.mobile.investimentos;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.jornadas.investimentos.meus.DetalhesPoupancaTela;
import pagina.mobile.jornadas.menu.MenuTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class MovimentacoesFunc extends FuncionalidadeBase {

    /**
     * Método responsável por validar as movimentações dos produtos do tipo 'Poupança'
     *
     * @param valor Valor aplicado/resgatado a ser validado
     * @throws Exception
     */
    public void validarMovimentacoesPoupanca(String valor) throws Exception {
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        // Necessário voltar ao menu principal do APP e depois acessar o menu Poupança no iOS,
        // pois o valor da movimentação não está sendo apresentada no pagesource
        if (getDriver() instanceof IOSDriver) {
            new DetalhesPoupancaTela(getDriver())
                    .tocarBotaoVoltar();
            new MenuTela(getDriver())
                    .clicarMenuPoupanca();
        }

        new DetalhesPoupancaTela(getDriver())
                .tocarEmMovimentacoes()
                .validarMovimentacoes(valor)
                .tocarBotaoVoltar();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }
}
