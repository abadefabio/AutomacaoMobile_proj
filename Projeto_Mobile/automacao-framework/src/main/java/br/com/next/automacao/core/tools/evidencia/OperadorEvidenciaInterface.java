package br.com.next.automacao.core.tools.evidencia;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public interface OperadorEvidenciaInterface extends OperadorEvidencia{

    /**
     * Gerador screenshot da tela para evidência de teste
     *
     * @param description
     * @throws Exception
     */
    void salvarEvidencia(String description);

    /**
     * Tira ScreenShot da tela do dispositivo
     *
     * @param driver
     * @return ScreenShot em Base64
     */
    default String tirarScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }

    String recuperarFonteTela();
}