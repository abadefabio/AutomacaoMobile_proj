package pagina.mobile.jornadas.pagamentos.codigo.barras.consumo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.constantes.MetodoComparacaoBooleano.VERDADEIRO;
import static constantes.pagamentos.TituloTela.CONTA_DE_CONSUMO;;

public class ContaDeConsumoTela extends PaginaBase {

    public ContaDeConsumoTela (AppiumDriver driver){
        super(driver);
    }
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id ="br.com.bradesco.next:id/bt_confirm")
    @AndroidFindBy(xpath = "//android.widget.Button[contains (@text,\"Confirmar\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirmar\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Confirmar\"])[1]")
    private MobileElement botaoConfirmar;

    /**
     * Validar a presenca do titulo conta de consumo na tela
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Validar a presenca do titulo conta de consumo  na tela")
    public ContaDeConsumoTela validarTextoTituloContaConsumo() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(CONTA_DE_CONSUMO), VERDADEIRO, "Titulo '" + CONTA_DE_CONSUMO + "' nao esta presente na tela");
        salvarEvidencia("Validado titulo '" + CONTA_DE_CONSUMO + "' presente na tela");
        return this;
    }

    /**
     * Validar informações da conta de consumo
     *
     * @param codigoDeBarras
     * @param valor
     * @param favorecido
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Validar informações da conta de consumo")
    public ContaDeConsumoTela validarInformacoesContaConsumo(String codigoDeBarras, String valor, String favorecido) throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(codigoDeBarras, valor, favorecido), VERDADEIRO, "Erro ao localizar o código de barras '" + codigoDeBarras + "', o valor '" + valor + "'e o beneficiário'" + favorecido );
        salvarEvidencia("Validado o valor '" + valor + "', o beneficiário '" + favorecido +" e o código de barras '" + codigoDeBarras + "' informados da conta de consumo'");
        return this;
    }

    /**
     * Tocar no botao confirmar
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Tocar no botao confirmar")
    public ContaDeConsumoTela tocarBotaoConfirmar() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar no botao confirmar");
        tocarElemento(botaoConfirmar, "Nao foi possivel tocar no botao confirmar");
        return this;
    }
}
