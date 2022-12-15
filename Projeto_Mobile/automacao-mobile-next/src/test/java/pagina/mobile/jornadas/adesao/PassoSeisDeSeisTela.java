package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PassoSeisDeSeisTela extends PaginaBase {

    public PassoSeisDeSeisTela(AppiumDriver driver){
        super(driver);
    }

    //botao Vamos La
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_lets_go")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'VAMOS LÁ!')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"VAMOS LÁ!\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"VAMOS LÁ!\"]")
    private MobileElement botaoVamosLa;

    /**
     * Validar Titulo Tela 'Passo 6 de 6'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Passo 6 de 6'")
    public PassoSeisDeSeisTela validarTituloTelaPassoSeisDeSeis() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.PASSO_6_DE_6)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Passo 6 de 6' não está presente na tela!");
        salvarEvidencia("Validada tela 'Passo 6 de 6'");
        return this;
    }

    /**
     * Tocar botao 'VAMOS LÁ'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'VAMOS LÁ'")
    public PassoSeisDeSeisTela tocarVamosLa() throws Exception {
        salvarEvidencia("Tocar botao 'VAMOS LÁ'");
        tocarElemento(botaoVamosLa, "Erro ao tentar tocar no botao 'VAMOS LÁ'");
        return this;
    }
}
