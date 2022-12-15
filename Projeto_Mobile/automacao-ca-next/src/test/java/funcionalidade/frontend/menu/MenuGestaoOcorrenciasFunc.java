package funcionalidade.frontend.menu;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.frontend.menu.MenuGestaoOcorrenciasTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class MenuGestaoOcorrenciasFunc extends FuncionalidadeBase {

    /**
     * Acessar menu anotações
     * @throws Exception
     */
    public void acessarMenuAnotacoes() throws Exception {
        new MenuGestaoOcorrenciasTela(getWebDriver())
                .clicarAbaAnotacao();
    }

    /**
     * Acessar menu hamburguer
     * @throws Exception
     */
    public void acessarMenuHamburguer() throws Exception {
        new MenuGestaoOcorrenciasTela(getWebDriver())
                .clicarMenuHamburguer();
    }
}
