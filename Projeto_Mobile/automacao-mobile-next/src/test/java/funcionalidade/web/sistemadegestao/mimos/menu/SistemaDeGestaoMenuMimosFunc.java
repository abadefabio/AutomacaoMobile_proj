package funcionalidade.web.sistemadegestao.mimos.menu;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.sistemadegestao.Mimos.Menu.SistemaDeGestaoMenuMimosTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class SistemaDeGestaoMenuMimosFunc extends FuncionalidadeBase {



    /**
     * Clicar no Link Parceiros
     *
     * @throws Exception
     */
    public void clicarLinkParceiros() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver())
                .clicarLinkParceiros();
    }

    /**
     * Clicar link Card
     *
     * @throws Exception
     */
    public void clicarLinkCard() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver()).clicarLinkCard();
    }

    /**
     * Clicar link Categorias
     *
     * @throws Exception
     */
    public void clicarLinkCategorias() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver())
                .clicarLinkCategorias();
    }

    /**
     * Clicar Link Eligibilidade
     *
     * @throws Exception
     */
    public void clicarLinkEligibilidade() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver())
                .clicarLinkEligibilidade();
    }

    /**
     * Clicar link Eligibilidade
     *
     * @throws Exception
     */
    public void clicarLinkEstatisticas() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver())
                .clicarLinkEstatisticas();
    }

    /**
     * Clicar link Hub
     *
     * @throws Exception
     */
    public void clicarLinkHub() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver())
                .clicarLinkHub();
    }

    /**
     * Clicar link Joy
     *
     * @throws Exception
     */
    public void clicarLinkJoy() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver())
                .clicarLinkJoy();
    }

    /**
     * Clicar link Ordenar Card
     *
     * @throws Exception
     */
    public void clicarLinkOrdenarCard() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver())
                .clicarLinkOrdenarCard();
    }

    /**
     * Clicar link Voltar
     *
     * @throws Exception
     */
    public void clicarLinkVoltar() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver())
                .clicarLinkVoltarMenuMimos();
    }

    /**
     * Clicar link Termos e Condições
     *
     * @throws Exception
     */
    public void clicarLinkTermosECondicoes() throws Exception {
        new SistemaDeGestaoMenuMimosTela(getWebDriver())
                .clicarLinkTermosECondicoes();
    }

}
