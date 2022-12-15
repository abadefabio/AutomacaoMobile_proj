package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NomeVaquinhaTela extends PaginaBase {

    //Dar um nome para vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name_vaquinha")
    @iOSXCUITFindBy(accessibility = "et_name")
    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeOther[@name=\"Meu nome é\"]")
    private MobileElement labelDarNomeVaquinha;

    public NomeVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Preencher nome da vaquinha
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher nome da vaquinha")
    public NomeVaquinhaTela preencherNomeVaquinha(String nomeVaquinha) throws Exception {
        aguardarCarregamentoElemento(labelDarNomeVaquinha);
        String mensagemErro = "Erro encontrado ao preencher campo nome da vaquinha";
        OperadorEvidencia.logarPasso("Preecher campo \"Nome da Vaquinha\" com \"" + nomeVaquinha + "\"");
        if (ios) {
            try{ // solução devido erro ao utilizar o método escreverTexto()
                MobileElement nomeVaquinhaElemento = retornaElemento(By.xpath("//XCUIElementTypeOther[@name=\"Meu nome é\"]"));
                nomeVaquinhaElemento.sendKeys(nomeVaquinha + "\uE007");
            }
            catch (Exception e){
                throw new NextException(mensagemErro, e);
            }
        }
        else{
            escreverTexto(labelDarNomeVaquinha, nomeVaquinha, mensagemErro);
        }
        salvarEvidencia("Preecheu o campo \"Nome da Vaquinha\" com \"" + nomeVaquinha + "\"");
        return this;
    }
}
