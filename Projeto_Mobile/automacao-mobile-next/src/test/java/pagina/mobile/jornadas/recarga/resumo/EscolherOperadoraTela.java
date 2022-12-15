package pagina.mobile.jornadas.recarga.resumo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class EscolherOperadoraTela extends PaginaBase {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Escolher Operadora\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Escolher Operadora\"]")
    private MobileElement tituloEscolherOperadora;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name, 'Buscar')]")
    private MobileElement buscarOperadora;

    public EscolherOperadoraTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Buscar Operadora
     * @param operadora
     * @return EscolherOperadoraTela
     * @throws NextException
     */
    @Step("Buscar Operadora")
    public EscolherOperadoraTela buscarOperadora(String operadora) throws NextException {
      String mensagemErro = "Erro ao digitar a operadora no campo 'Buscar";
      if(android){
          escreverTextoTeclado(buscarOperadora, operadora);
      }else
          escreverTexto(buscarOperadora, operadora, mensagemErro);
      salvarEvidencia("Digitou a operadora: '" + operadora + "' no campo 'buscar'");
      return this;
    }

    public <T> void escreverTextoTeclado(T localizador, String texto) throws NextException {
        tocarCoordenadaProporcional(localizador, 50, 50);
        new Actions(driver).
                click(retornaElemento(localizador)).
                sendKeys(texto).
                perform();
    }

    /**
     * Selecionar a Operadora
     * @return EscolherOperadoraTela
     * @throws NextException
     */
    @Step("Selecionar Operadora")
    public EscolherOperadoraTela selecionarOperadora(String operadora) throws NextException {
        By selecaoOperadora = (ios ?
                By.xpath("//XCUIElementTypeStaticText[contains(@name,\"" + operadora + "\")]") :
                By.xpath("//android.view.View[@content-desc=\"" + operadora + "\"]"));
        tocarElemento(selecaoOperadora,"Erro ao tocar na seleção da Operadora: '" + operadora + "'");
        salvarEvidencia("Selecionou a operadora: '" + operadora + "' no campo 'buscar'");
        return this;
    }

    /**
     * Selecionar a Operadora
     * @return EscolherOperadoraTela
     * @throws NextException
     */
    @Step("Validar exibição da tela 'Escolher Operadora'")
    public EscolherOperadoraTela validarExibicaoEscolherOperadoraTela() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloEscolherOperadora), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição da tela de recarga");
        salvarEvidencia("validar exibição da tela de Escolher Operadora");
        return this;
    }
}
