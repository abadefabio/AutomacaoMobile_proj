package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.open.finance.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class FaltaPoucoTela extends PaginaBase {

    public FaltaPoucoTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text, \"OK, CONTINUAR\")]")
    @iOSXCUITFindBy(accessibility = "OK, CONTINUAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK, CONTINUAR\"]")
    private MobileElement botaoOkContinuar;


    /**
     * Tocar botao "Ok Continuar"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Ok Continuar\"")
    public FaltaPoucoTela tocarBotaoOkContinuar() throws Exception {
        salvarEvidencia("Tocar check box \"Ok Continuar\"");
        tocarElemento(botaoOkContinuar, "Não foi possivel tocar botao \"Ok Continuar\"");
        return this;
    }

    /**
     * validar "Melhore sua experiencia  no open Finance"
     * fr
     *
     * @throws Exception
     */
    @Step("validar \"Melhore sua experiencia  no open Finance\"")
    public FaltaPoucoTela validarTextoMelhoreSuaExperiencia() throws Exception {
        if(verificarPresencaElemento(botaoOkContinuar)) {
            salvarEvidencia("Melhore sua experiencia  no open Finance.");
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.MSG_FALTA_POUCO), MetodoComparacaoBooleano.VERDADEIRO, "Erro, não foi possivel validar texto da tela dados Necessarios!");
        }
        return this;
    }

    /**
     * fecher browser no app e verificar tela Agora investimento
     * fr
     * @return
     * @throws Exception
     */
    @Step("Verifica Presenca Botao Confirmar")
    public FaltaPoucoTela fecharBrowserVerificarTelaOpenFinance() throws Exception {
        OperadorEvidencia.logarPasso("Fechar janela navegador - Voltar para App Next");
        salvarEvidencia("verifica Presenca do browser apos fechar browser");
        if(ios){
            salvarEvidencia("verificação da Presenca do browser aberto.");
            tocarCoordenadaProporcional(2,2);
        }
        if(android) {
            for(int i=1;i<=2;i++) {
                ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
                salvarEvidencia("Navegando entre a janela do browser e o App Next.");
            }
        }
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.MSG_FALTA_POUCO), MetodoComparacaoBooleano.VERDADEIRO, "Erro, não foi possivel validar texto da tela dados Necessarios!");
        salvarEvidencia("verifica Presenca da tela 'Falta Pouco' apos fechar browser - pagina Open Finance");
        return this;
    }

}
