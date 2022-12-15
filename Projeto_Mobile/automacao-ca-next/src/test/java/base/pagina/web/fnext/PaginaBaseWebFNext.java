package base.pagina.web.fnext;

import base.pagina.web.PaginaBaseWebDownload;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaBaseWebFNext extends PaginaBaseWebDownload {

    public PaginaBaseWebFNext(WebDriver driver) {
        super(driver);
    }

    final static int COMMON_RESOLVE_TIME = 60;

    public WebElement getInteractableWebElement(By locator, int resolve) {
        WebElement webElement = null;
        try {
            webElement = new WebDriverWait(driver, resolve)
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception ignore) {

        }
        return webElement;
    }


    /**
     * Selecionar opção Combobox
     *
     * @param elemento     Localizador do elemento combobox no topo
     * @param opcao        O texto da opção a ser selecionado
     * @param mensagemErro mensagem de erro em caso de falha
     * @param <T>
     * @throws Exception
     */
    public <T> void selecionarTextoComboboxFnext(T elemento, String opcao, String mensagemErro) throws NextException {

        WebElement element = null;
        boolean sucesso = false;
        opcao = " "+opcao.trim()+" ";

        long inicio = System.currentTimeMillis();
        while (System.currentTimeMillis() - inicio < 30 * 1000) {
            try {

                if (elemento instanceof By)
                    element = new WebDriverWait(driver, 5L)
                            .until(ExpectedConditions.elementToBeClickable((By) (elemento)));
                else
                    element = new WebDriverWait(driver, 5L)
                            .until(ExpectedConditions.elementToBeClickable((WebElement) (elemento)));

                if (element == null) continue;
                element.click();
                WebElement elementoOpcao = new WebDriverWait(driver, 5L)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//mat-option//span[text()=\"" + opcao + "\"]")));
                if (elementoOpcao != null) {
                    elementoOpcao.click();
                    aguardarOcultacaoElemento(elementoOpcao);
                    sucesso = true;
                    break;
                }

            } catch (Exception e) {

            }
            OperadorEvidencia.logarPasso("Tentando selecionar novamente");
            element.click();

        }

        if (!sucesso) {
            try {
                throw new Exception("Falha na utilização do seletor combo.");
            } catch (Exception e) {
                throw new NextException(e.getMessage(), e);
            }
        }
    }
}
