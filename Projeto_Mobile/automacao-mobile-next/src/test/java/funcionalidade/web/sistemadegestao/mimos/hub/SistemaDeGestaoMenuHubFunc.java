package funcionalidade.web.sistemadegestao.mimos.hub;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.sistemadegestao.Mimos.Hub.SistemaDeGestaoMenuHubTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class SistemaDeGestaoMenuHubFunc extends FuncionalidadeBase {

    /**
     * Clicar no Link Compartilhar
     *
     * @throws Exception
     */
    public void clicarLinkCompartilhar() throws Exception {
        new SistemaDeGestaoMenuHubTela(getWebDriver())
        .clicarLinkCompartilhar();
    }

    /**
     * Clicar link Ofertas
     *
     * @throws Exception
     */
    public void clicarLinkOfertas() throws Exception {
        new SistemaDeGestaoMenuHubTela(getWebDriver())
                .clicarLinkOfertas();
    }

    /**
     * Clicar link Ordenar
     *
     * @throws Exception
     */
    public void clicarLinkOrdenar() throws Exception {
        new SistemaDeGestaoMenuHubTela(getWebDriver())
                .clicarLinkOrdenar();
    }

    /**
     * Clicar Link Voltar
     *
     * @throws Exception
     */
    public void clicarLinkVoltar() throws Exception {
        new SistemaDeGestaoMenuHubTela(getWebDriver())
                .clicarLinkVoltarMenuHub();
    }

}
