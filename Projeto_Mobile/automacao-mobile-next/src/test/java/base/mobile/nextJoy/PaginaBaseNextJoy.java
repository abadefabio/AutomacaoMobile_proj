package base.mobile.nextJoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaginaBaseNextJoy extends PaginaBase {

    public PaginaBaseNextJoy(AppiumDriver driver) {
        super(driver);
    }

    protected void clicarContinuarTecladoNextJoyIos() {
        if (!ios)
            return;

        final int BOTAO_CONTINUAR_ACIMA_TECLADO = 0;
        List<MobileElement> listaBotoesContinuar = driver.findElements(By.xpath("//XCUIElementTypeButton[@name=\"CONTINUAR\"]"));
        if (listaBotoesContinuar.size() > 1) {
            try {
                tocarElemento(listaBotoesContinuar.get(BOTAO_CONTINUAR_ACIMA_TECLADO), "");
            } catch (NextException ignore) {

            }
        }
    }

    @Override
    /**
     * @param elemento Estratégia para encontrar a caixa de texto.
     * @param texto    Texto para inserção.
     */
    protected <T> void escreverTexto(T elemento, String texto, String mensagemErro) throws NextException {
        try {
            MobileElement elementoMobile = retornaElemento(elemento);
            elementoMobile.click();
            if(ios){
                elementoMobile.setValue(texto);
                esconderTeclado();
            } else {
                esconderTeclado();
                elementoMobile.sendKeys(texto);
            }
        } catch(NoSuchElementException execaoNext){
            throw new NextException(this, execaoNext.getMessage(), execaoNext);
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
    }


    @Override
    /**
     * Método para esconder teclado
     */
    protected void esconderTeclado(){
        new Teclado().esconderTeclado();
    }

    /**
     * Classe interna à PaginaBase criada para organizar as ações com o teclado
     * @author Matheus Lima Barbosa de Tulio
     * @since 11-2021
     * @version 4.0.2
     */
    class Teclado{

        private Teclado(){
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

        @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
        @iOSXCUITFindBy(accessibility = "Return")
        @iOSXCUITFindBy(id = "OK")
        @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') ='ok']")
        @iOSXCUITFindBy(iOSNsPredicate = "**/XCUIElementTypeButton[`label == \"retorno\"`]")
        @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
        @iOSXCUITFindBy(accessibility = "Próximo")
        @iOSXCUITFindBy(accessibility = "next")
        @iOSXCUITFindBy(accessibility = "Next")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Return\"]")
        @iOSXCUITFindBy(xpath = "//*[contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz','ximo', 'next')]")
        @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') = \"search\"]")

        private MobileElement teclado;

        /**
         * Método retorna True se teclado presente e falso se teclado oculto
         * @return
         */
        boolean tecladoPresente(){
            return ios? ((IOSDriver<MobileElement>) driver).isKeyboardShown() : ((AndroidDriver) driver).isKeyboardShown();
        }

        /**
         * Método esconde teclado
         */
        void esconderTeclado(){
            try{
                try {
                    if(ios && tecladoPresente()) {
                        ((IOSDriver) driver).hideKeyboard();
                    }
                } catch (Exception ignore) {

                }
                if(ios && tecladoPresente()){
                    if(verificarPresencaElemento(teclado))
                        teclado.click();
                }else{
                    ((AppiumDriver) driver).hideKeyboard();
                }
            }catch(Exception ignore){}
        }
    }
}
