package framework;

import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {
    /**
     * Valida se a página foi carregada completamente
     *
     * @param driver
     * @return Boolean
     */
    public static Boolean aguardarCarregamentoDaPagina(WebDriver driver){
        return new WebDriverWait(driver, 30 ).until(input -> {
            boolean resultado = false;
            String status = "";
            try{
                JavascriptExecutor js = (JavascriptExecutor) driver;
                status = js.executeScript("return document.readyState;").toString();
                resultado = status.equals("complete");
            }
            catch (Exception ignore){}
            OperadorEvidencia.logarPasso("Aguardou o carregamento da pagina, Status:[" + status + "];");
            return resultado;
        });
    }
}
