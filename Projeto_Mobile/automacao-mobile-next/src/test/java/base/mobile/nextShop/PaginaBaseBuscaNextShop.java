package base.mobile.nextShop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.Date;

public class PaginaBaseBuscaNextShop extends PaginaBase {

    public PaginaBaseBuscaNextShop(AppiumDriver driver) {
        super(driver);
    }


    /**
     * @param elemento Estratégia para encontrar a caixa de texto.
     * @param texto    Texto para inserir.
     */
    protected <T> void escreverTextoBuscaNextShopAndroid(T elemento, String texto, String mensagemErro) throws NextException {
        try {
            MobileElement elementoMobile = retornaElemento(elemento);
            elementoMobile.click();
            elementoMobile.sendKeys(texto);
            new TecladoBuscaNextShopAndroid().esconderTeclado();
        } catch(NoSuchElementException execaoNext){
            throw new NextException(this, execaoNext.getMessage(), execaoNext);
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
    }

     /**
     * Classe interna ? PaginaBase criada para organizar as a??es com o teclado
     * @author Matheus Lima Barbosa de Tulio
     * @since 11-2021
     * @version 4.0.2
     */
    class TecladoBuscaNextShopAndroid {

         private TecladoBuscaNextShopAndroid() {
             PageFactory.initElements(new AppiumFieldDecorator(driver), this);
         }

         @AndroidFindBy(xpath = "//*[@text='ok' or @text='OK' or @text='return' or @text='retorno' or @text='aceptar' or @text='done']")
         private MobileElement teclado;

         /**
          * Método retorna True se teclado presente e falso se teclado oculto
          *
          * @return
          */
         boolean tecladoPresente() {
             return android && ((AndroidDriver) driver).isKeyboardShown();
         }

         /**
          * Método esconde teclado
          */
         void esconderTeclado() {
             try {
                 if (tecladoPresente()) {
                     int xTela = driver.manage().window().getSize().getWidth();
                     int yTela = driver.manage().window().getSize().getHeight();
                     int xInc = 50, yInc = 50;
                     //as coordenadas foram baseadas em um device com a resolução 1431x2693
                     //devices com a resolução como tablets por exemplo podem falhar
                     long inicio = System.currentTimeMillis();
                     while (tecladoPresente()) {
                         xInc += 20;
                         yInc += 35;
                         tocarCoordenada(xTela - xInc, yTela - yInc);
                         if (System.currentTimeMillis() - inicio > 60000) break;
                     }
                 }
             } catch (Exception ignore) {

             }
         }
    }

         /**
          * Método para escrever sem esconder teclado
          * @param elemento Estratégia para encontrar a caixa de texto.
          * @param texto    Texto para inserir.
          */
         protected <T> void escreverTextoSemEsconderTeclado(T elemento, String texto, String mensagemErro) throws NextException {
             Date d1 = Calendar.getInstance().getTime();

             try {
                 MobileElement elementoMobile = retornaElemento(elemento);
                 elementoMobile.click();
                 if (ios) {
                     elementoMobile.setValue(texto);
                     this.esconderTeclado();
                 } else {
                     elementoMobile.sendKeys(new CharSequence[]{texto});
                 }
             } catch (NoSuchElementException var7) {
                 throw new NextException(var7.getMessage(), var7);
             } catch (Exception var8) {
                 throw new NextException(mensagemErro, var8);
             }
         }

}

