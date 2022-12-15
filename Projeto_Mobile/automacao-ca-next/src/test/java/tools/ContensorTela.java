package tools;

import br.com.next.automacao.core.base.PaginaNext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unchecked")
public class ContensorTela extends PaginaNext {

    WebDriver driver;
    Class<?> classeIframeBase;
    Object iframeBase;

    public ContensorTela(WebDriver driver, Class<?> classeIframeBase) {
        super(driver);
        this.driver = driver;
        this.classeIframeBase = classeIframeBase;
        this.irDefaultContent();
        this.iframeBase = new InitClasseTela(driver, classeIframeBase);
    }

    public static ContensorTela novo(WebDriver driver, Class<?> classeIframeBase) {
        return new ContensorTela(driver, classeIframeBase);
    }

    public ContensorTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Redefine o documento HTML atual para o frame determinado
     * na classe de frame
     * @return
     */
    public ContensorTela redefinirIframeBase() {
        this.iframeBase = new InitClasseTela(driver, classeIframeBase);
        return this;
    }

    /**
     * Alterar para default content
     * @return
     */
    private ContensorTela irDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }

    /**
     * Recebe qualquer valor por parâmetro apenas para
     * processar as chamadas dentro de um método
     * @param declaracoes
     * @return
     * @param <T>
     */
    public <T> ContensorTela executar(T... declaracoes) {
        return this;
    }

    /**
     * Método obrigatório ao final da sequência de ações
     * na funcionalidade
     */
    public void desfazer() {
        driver.switchTo().defaultContent();
    }

    /**
     * Método para retornar ao iframe de base desde o default content
     * e continuar a selecionar um iframe filho de modo relativo a esse
     * iframe de base, utilizando sempre classes de frame
     * @return
     * @throws Exception
     */
    @Step("Selecionar o iframe baseado em classe absoluta, seguida de 1 ou mais classes relativas")
    public final ContensorTela irIFrame(Class<?>... classesFrameBase) {
        driver.switchTo().defaultContent();
        new InitClasseTela(driver, classesFrameBase[0]);
        for (int i=1; i<classesFrameBase.length; i++) {
            new InitClasseTela(driver, classesFrameBase[i]);
        }
        return this;
    }

}
