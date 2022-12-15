package pagina.mobile.jornadas.pagamentos.codigo.barras;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pagamentos.Mensagem;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class LeitorCodigoDeBarrasTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_type_manually")
    @AndroidFindBy(accessibility = "Digitar código de barras")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@label, 'Digitar')]")
    private MobileElement botaoDigitarCodigoDeBarras;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeAlert[`label == \"“next” Deseja Ter Acesso à Câmera\"`]")
    private MobileElement popUpPermissaoCameraIOS;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private MobileElement botaoOkPopUpPermissaoCameraIOS;

    public LeitorCodigoDeBarrasTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Pagamentos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Leitor Codigo de Barras'")
    public LeitorCodigoDeBarrasTela validarPresencaLeitorCodigoDeBarrasTela() throws Exception {
        if (ios) {
            if (aguardarCarregamentoElemento(botaoOkPopUpPermissaoCameraIOS)) {
                tocarElemento(botaoOkPopUpPermissaoCameraIOS, "Erro ao tocar botão 'OK' Pop Up Camera");
            } else {
                voltarTelaAnterior();
            }
        }
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagem.LEITOR_CODIGO_BARRAS), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Encaixa o código de barras no retângulo.' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'Leitor Codigo de Barras'");
        return this;
    }

    /**
     * Tocar botão 'Digitar Código de Barras'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Digitar Código de Barras'")
    public LeitorCodigoDeBarrasTela tocarbotaoDigitarCodigoDeBarras() throws Exception {
        aguardarCarregamentoElemento(botaoDigitarCodigoDeBarras);
        salvarEvidencia("Tocar botão 'Digitar Código de Barras'");
        tocarElemento(botaoDigitarCodigoDeBarras, "Não foi possível tocar no botão 'Digitar Código de Barras'");
        return this;
    }
}
