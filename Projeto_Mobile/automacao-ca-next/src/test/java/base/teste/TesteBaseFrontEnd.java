package base.teste;

import br.com.next.automacao.core.base.TesteBase;
import funcionalidade.frontend.menu.LogoutGestaoOcorrenciasFunc;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TesteBaseFrontEnd extends TesteBase {

    /**
     * Devera realizar o logout ao finalizar a execucao do teste
     * seja passed ou failed.
     *
     * @param iTestResult
     * @throws Exception
     */
    @AfterMethod()
    public void sairGestaoOcorrencias(ITestResult iTestResult) throws Exception{
        LogoutGestaoOcorrenciasFunc logout = new LogoutGestaoOcorrenciasFunc();
        logout.realizarLogout();
    }
}
