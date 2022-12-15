package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MesadaExcluidaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'OK'")
    private MobileElement botaoOK;

    public MesadaExcluidaTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar botão OK
     *
     * @return MesadaExcluidaTela
     * @throws Exception
     */
    @Step("Tocar botão OK")
    public MesadaExcluidaTela tocarBotaoOK() throws Exception {
        salvarEvidencia("Tocar botão OK");
        tocarElemento(botaoOK, "Não foi possível tocar botão OK");
        return this;
    }

    /**
     * Validar mensagem exibida na tela
     *
     * @return MesadaExcluidaTela
     * @throws Exception
     */
    @Step("Validar mensagem exibida na tela")
    public MesadaExcluidaTela validarMensagem(String textoEsperado) throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(textoEsperado), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível encontrar o texto:" + textoEsperado);
        salvarEvidencia("Validou exibição da mensagem: " + textoEsperado);
        return this;
    }
}
