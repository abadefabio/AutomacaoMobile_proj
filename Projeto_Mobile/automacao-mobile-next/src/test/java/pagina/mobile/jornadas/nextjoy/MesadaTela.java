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

public class MesadaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/recycler_allowace")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Mesada de FULANO'")
    private MobileElement mesadaDetalhes;

    public MesadaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar detalhes da Mesada
     *
     * @return MesadaTela
     * @throws Exception
     */
    @Step("Tocar detalhes da Mesada")
    public MesadaTela tocarDetalhesMesada() throws Exception {
        salvarEvidencia("Tocar detalhes da Mesada");
        tocarElemento(mesadaDetalhes, "Não foi possível tocar nos detalhes da Mesada");
        return this;
    }

    /**
     * Validar mensagem exibida na tela
     *
     * @return MesadaTela
     * @throws Exception
     */
    @Step("Validar mensagem exibida na tela")
    public MesadaTela validarMensagem(String textoEsperado) throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(textoEsperado), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível encontrar o texto:" + textoEsperado);
        salvarEvidencia("Validou exibição da mensagem: " + textoEsperado);
        return this;
    }
}
