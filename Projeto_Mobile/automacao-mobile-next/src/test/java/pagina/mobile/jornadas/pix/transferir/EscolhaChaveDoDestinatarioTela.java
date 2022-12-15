package pagina.mobile.jornadas.pix.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.pix.ChavesPix;
import constantes.pix.Pix;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EscolhaChaveDoDestinatarioTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='E-mail']")
    @iOSXCUITFindBy(accessibility = "E-mail")
    @iOSXCUITFindBy(xpath = "//*[@name='E-mail']")
    private MobileElement botaoEmail;

    public EscolhaChaveDoDestinatarioTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela 'Escolha Chave do Destinat�rio'
     */
    @Step("Validar tela 'Escolha Chave do Destinat�rio'")
    public EscolhaChaveDoDestinatarioTela validarEscolhaChaveDoDestinatarioTela() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Pix.ESCOLHA_CHAVE_DO_DESTINATARIO_TELA), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar a tela 'Escolha Chave do Destinat�rio'");
        salvarEvidencia("Validada a tela 'Escolha Chave do Destinat�rio'");
        return this;
    }

    /**
     * Tocar no bot�o 'E-mail'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'E-mail'")
    public EscolhaChaveDoDestinatarioTela tocarBotaoEmail() throws Exception {
        salvarEvidencia("Tocar bot�o 'E-mail'");
        tocarElemento(botaoEmail, "N�o foi poss�vel tocar no bot�o 'E-mail'");
        return this;
    }

    /**
     * M�todo que far� a sele��o da chave Pix
     * @param chavePix Chave que ser� selecionada na tela 'ESCOLHA A CHAVE DO DESTINAT�RIO'
     * @return EscolhaChaveDoDestinatarioTela
     * @throws NextException
     */
    @Step("Selecionar a chave Pix")
    public EscolhaChaveDoDestinatarioTela selecionarChavePix(ChavesPix chavePix) throws NextException {
        By localizador = android ? new By.ByXPath("//*[@text='" + chavePix.toString() + "']") :
                new By.ByXPath("//*[@name='" + chavePix.toString() + "']");
        aguardarCarregamentoElemento(localizador);
        salvarEvidencia("Tocar na chave '" + chavePix + "'.");
        tocarElemento(localizador, "N�o foi poss�vel tocar na chave '" + chavePix + "'.");
        return this;
    }
}
