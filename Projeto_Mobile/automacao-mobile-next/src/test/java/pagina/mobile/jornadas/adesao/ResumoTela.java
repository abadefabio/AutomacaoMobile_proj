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

public class ResumoTela extends PaginaBase {

    public ResumoTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'TUDO CERTO, CONTINUAR')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"TUDO CERTO, CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"TUDO CERTO, CONTINUAR\"]")
    private MobileElement botaoTudoCertoContinuar;

    /**
     * Validar Titulo Tela 'Resumo'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Resumo'")
    public ResumoTela validarTituloTelaResumo() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.RESUMO)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Resumo' não está presente na tela!");
        salvarEvidencia("Validada tela 'Resumo'");
        return this;
    }

    /**
     * Tocar botão 'Tudo Certo, Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Tudo Certo, Continuar'")
    public ResumoTela tocarTudoCertoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTudoCertoContinuar, "Botão 'Tudo Certo, Continuar' não localizado");
        salvarEvidencia("Tocar botão 'Tudo Certo, Continuar'");
        tocarElemento(botaoTudoCertoContinuar, "Erro ao tentar tocar no botao 'Tudo Certo, Continuar'");
        return this;
    }

}
