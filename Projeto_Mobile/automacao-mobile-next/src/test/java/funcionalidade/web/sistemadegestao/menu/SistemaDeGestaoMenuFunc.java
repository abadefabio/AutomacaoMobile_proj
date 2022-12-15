package funcionalidade.web.sistemadegestao.menu;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.sistemadegestao.Login.SistemaDeGestaoLoginTela;
import pagina.web.sistemadegestao.Menu.SistemaDeGestaoMenuTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;


public class SistemaDeGestaoMenuFunc extends FuncionalidadeBase {

    /**
     * Clicar no Link Mimos
     *
     * @throws Exception
     */
    public void clicarLinkMIMOS() throws Exception {
        new SistemaDeGestaoMenuTela(getWebDriver())
                .clicarLinkMIMOS();
    }

    /**
     * Clicar no Link CARD
     *
     * @throws Exception
     */
    public void clicarLinkCARD() throws Exception {
        new SistemaDeGestaoMenuTela(getWebDriver())
                .clicarLinkCARD();
    }

}
