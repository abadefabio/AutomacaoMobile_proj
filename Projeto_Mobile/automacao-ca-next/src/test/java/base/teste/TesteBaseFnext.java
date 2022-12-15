package base.teste;

import br.com.next.automacao.core.base.TesteBase;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TesteBaseFnext extends TesteBase {

    /**
     * Método responsável por realizar o logout na aplicação
     * @param iTestResult Resultado do teste executado
     */
    @AfterMethod()
    public void efetuarLogout(ITestResult iTestResult) {
            PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
        try {
            pesquisaGeralFunc.garantirLogout();
        } catch (Exception ignored) {

        }
    }
}
