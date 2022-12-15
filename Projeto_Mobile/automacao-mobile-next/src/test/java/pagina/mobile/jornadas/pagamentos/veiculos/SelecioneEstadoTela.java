package pagina.mobile.jornadas.pagamentos.veiculos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static java.time.Duration.ofSeconds;

public class SelecioneEstadoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_next_option")
    @AndroidFindBy(accessibility = "confirmar")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@label) = \"confirmar\"]")
    private MobileElement botaoApply;

    public SelecioneEstadoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar bot�o Confirmar
     * @return
     */
    @Step("Tocar bot�o Confirmar")
    public SelecioneEstadoTela tocarBotaoApply() throws NextException {
        salvarEvidencia("Tocar bot�o v");
        tocarElemento(botaoApply, "Ocorreu um erro inesperado ao tentar tocar bot�o de confirma��o");
        return this;
    }

    /**
     * M�todo Utilizado para tocar elemento referente ao estado desejado na tela
     * @param estado
     * @return
     * @throws Exception
     */
    @Step("Tocar campo com estado desejado")
    public SelecioneEstadoTela tocarCampoEstado(String estado) throws Exception {
        String tradutorLetrasXpath = "translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz')";
        By localizador = ios ? new By.ByXPath("//*[contains("+ tradutorLetrasXpath + ", \"" + estado.toLowerCase() + "\")]") : new By.ByXPath("//*[contains(lower-case(@text),\"" + estado.toLowerCase() + "\")]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "O estado " + estado + " n�o foi encontrado em tela");
        salvarEvidencia("Selecionar o estado " + estado);
        tocarElemento(localizador, "Ocorreu um erro ao executar a a��o de selecionar o estado");
        return this;
    }
}
