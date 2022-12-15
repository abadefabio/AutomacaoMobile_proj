package funcionalidade.mobile.doacoes;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.doacoes.DoacoesTela;
import pagina.mobile.jornadas.menu.MenuTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class DoacoesFunc extends FuncionalidadeBase {

    /**
     * M�todo para validar tela de apoio a uma institui��o
     *
     * @throws Exception
     */
    public void validarTelaApoioDoacoes() throws Exception{
        new DoacoesTela(getDriver())
                .validarExibicaoTelaDoacoes()
                .tocarBotaoVoltar();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }
}
