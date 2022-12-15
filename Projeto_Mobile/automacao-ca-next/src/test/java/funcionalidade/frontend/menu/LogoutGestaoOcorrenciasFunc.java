package funcionalidade.frontend.menu;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.frontend.menu.LogoutGestaoOcorrenciasTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class LogoutGestaoOcorrenciasFunc extends FuncionalidadeBase {

    /**
     * Devera realizar o logout ao finalizar a execucao do teste
     * seja passed ou failed
     *
     * @throws Exception
     */
    public void realizarLogout() throws Exception {
        getWebDriver().switchTo().defaultContent();

        new LogoutGestaoOcorrenciasTela(getWebDriver())
                .logoutGestaoOcorrencias();
    }
}
