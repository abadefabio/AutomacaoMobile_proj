package pagina.mobile.jornadas.pagamentos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static constantes.pagamentos.Data.DIA_UTIL_FORMATADO_ANO_MES_DIA;
import static constantes.pagamentos.Data.DIA_UTIL_FORMATADO_DIA_MES_POR_EXTENSO_ANO;
import static constantes.pagamentos.TituloTela.AGENDAR;
import static constantes.pagamentos.TituloTela.AGENDAR_IOS;

public class AgendarTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirmar\"`]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Confirmar\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Confirmar\")]")
    private MobileElement botaoConfirmar;

    public AgendarTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar a presenca do titulo agendar na tela
     *
     * @return AgendarTela
     * @throws Exception
     */
    @Step("Validar a presenca do titulo agendar na tela")
    public AgendarTela validarTextoTituloAgendar() throws Exception {
        if (android) {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(AGENDAR), MetodoComparacaoBooleano.VERDADEIRO, "Titulo '" + AGENDAR + "' nao esta presente na tela");
        } else {
            validarCondicaoBooleana(aguardarExistenciaElemento(By.xpath(String.format("//XCUIElementTypeNavigationBar[@name='%s']", AGENDAR_IOS))),
                    MetodoComparacaoBooleano.VERDADEIRO,
                    "Titulo '" + AGENDAR_IOS + "' nao esta presente na tela");
        }
        salvarEvidencia("Validado titulo '" + AGENDAR_IOS + "' presente na tela");
        return this;
    }

    /**
     * Selecionar a data de agendamento
     *
     * @return AgendarTela
     * @throws Exception
     */
    @Step("Selecionar a data de agendamento")
    public AgendarTela selecionarDataAgendamento() throws Exception {
        By elementoEncontrado;
        String diaUtilFormatadoAndroid = DIA_UTIL_FORMATADO_ANO_MES_DIA;
        String diaUtilFormatadoIOS = DIA_UTIL_FORMATADO_DIA_MES_POR_EXTENSO_ANO;
        if (android)
            elementoEncontrado = By.xpath("//*[contains(@content-desc,'" + diaUtilFormatadoAndroid + "')]");
        else
            elementoEncontrado = By.xpath("//*[contains(@name,'" + diaUtilFormatadoIOS + "')]");
        salvarEvidencia("Selecionar a data de agendamento " + DIA_UTIL_FORMATADO_DIA_MES_POR_EXTENSO_ANO);
        tocarElemento(elementoEncontrado, "Não foi possível selecionar a data de agendamento " + DIA_UTIL_FORMATADO_DIA_MES_POR_EXTENSO_ANO);
        return this;
    }

    /**
     * Tocar no botao confirmar
     *
     * @return AgendarTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Confirmar'")
    public AgendarTela tocarBotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar no botão 'Confirmar'");
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botão 'Confirmar'");
        return this;
    }
}
