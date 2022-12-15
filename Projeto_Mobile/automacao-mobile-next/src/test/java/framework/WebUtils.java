package framework;

import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {

    public static Boolean aguardarCarregamentoDaPagina(WebDriver driver){

        return new WebDriverWait(driver, 30 ).until(input -> {
            Boolean resultado = false;
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
