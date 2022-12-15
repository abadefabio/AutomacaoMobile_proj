package pagina.mobile.jornadas.pix.copia.cola;

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

public class ComprovanteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='VOLTAR AO PIX']")
    @AndroidFindBy(xpath = "//*[@text='Voltar ao Pix']")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar ao Pix']")
    private MobileElement botaoVoltarAoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='COMPROVANTE']")
    @AndroidFindBy(xpath = "//*[@text='Comprovante']")
    @iOSXCUITFindBy(xpath = "//*[@name='COMPROVANTE']")
    private MobileElement textoTituloTela;

    public ComprovanteTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no botão 'Voltar ao Pix'
     *
     * @return ComprovanteTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Voltar ao Pix'")
    public ComprovanteTela tocarBotaoVoltarAoPix() throws NextException {
        aguardarCarregamentoElemento(botaoVoltarAoPix);
        salvarEvidencia("Tocar no botão 'Voltar ao Pix'");
        tocarElemento(botaoVoltarAoPix, "Não foi possível tocar no botão 'Voltar ao Pix'");
        return this;
    }

    /**
     * Validar presença do título 'COMPROVANTE'
     *
     * @return ComprovanteTela
     * @throws NextException
     */
    @Step("Validar presença do título 'COMPROVANTE'")
    public ComprovanteTela validarPresencaTituloComprovante() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoTituloTela), MetodoComparacaoBooleano.VERDADEIRO, "O título 'COMPROVANTE', não está na tela");
        salvarEvidencia("Validado título 'COMPROVANTE' está presente na tela");
        return this;
    }
}
