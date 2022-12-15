package base.teste;

import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.api.cockpit.LoginFunc;
import funcionalidade.frontend.menu.LogoutGestaoOcorrenciasFunc;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TesteBaseCockpitLoginToken extends TesteBase {

    protected LoginFunc loginFunc = new LoginFunc();

    protected String cpf = null;
    /**
     * Devera realizar o logout ao finalizar a execucao do teste
     * seja passed ou failed.
     *
     * @param iTestResult
     * @throws Exception
     */
    @AfterMethod()
    public void logoffToken(ITestResult iTestResult) throws Exception{
        loginFunc.logoffToken(cpf);
    }
}
