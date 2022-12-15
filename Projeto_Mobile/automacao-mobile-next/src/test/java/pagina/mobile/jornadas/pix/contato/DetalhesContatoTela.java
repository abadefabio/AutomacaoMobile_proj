package pagina.mobile.jornadas.pix.contato;

import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;

public class DetalhesContatoTela extends PaginaBase {

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nb_continue']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CONTINUAR']")
    private MobileElement botaoContinuar;

    public DetalhesContatoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Selecionar chave do contato
     *
     * @param chave Chave a ser selecionada
     * @return DetalhesContatoTela
     * @throws NextException
     */
    @Step("Selecionar chave do contato")
    public DetalhesContatoTela selecionarChaveContato(String chave) throws NextException {
        By radioButton;
        if (android) {
            radioButton = By.xpath("//*[contains(@text,'"+chave+"')]/preceding::*[@resource-id='R.id.radio']");
        } else {
            radioButton = By.xpath("(//XCUIElementTypeStaticText[contains(@name, '"+chave+"')])[1]");
        }
        tocarElemento(radioButton, "N�o foi poss�vel selecionar a chave " + chave);
        salvarEvidencia("Selecionado chave do contato");
        return this;
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @return DetalhesContatoTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Continuar")
    public DetalhesContatoTela tocarBotaoContinuar() throws NextException {
        aguardarElementoHabilitado(botaoContinuar);
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }
}
