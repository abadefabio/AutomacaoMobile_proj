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

public class PacotesPadronizadosTela extends PaginaBase {

    public PacotesPadronizadosTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_central_bank")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Escolher pacote padronizado\"]")
    @iOSXCUITFindBy(accessibility = "ESCOLHER PACOTE PADRONIZADO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ESCOLHER PACOTE PADRONIZADO\"`]")
    private MobileElement botaoEscolherPacotePadronizado;

    /**
     * Validar Titulo Tela 'Pacotes Padronizados'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Pacotes Padronizados'")
    public PacotesPadronizadosTela validarTituloTelaPacotesPadronizados() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.PACOTES_PADRONIZADOS)), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Pacotes Padronizados' n�o est� presente na tela!");
        salvarEvidencia("Validada tela 'Pacotes Padronizados'");
        return this;
    }

    /**
     * Tocar bot�o 'Escolher Pacote Padronizado'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Escolher Pacote Padronizado'")
    public PacotesPadronizadosTela tocarEscolherPacotePadronizado() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEscolherPacotePadronizado, "Bot�o 'Escolher Pacote Padronizado' n�o localizado");
        salvarEvidencia("Bot�o 'Escolher Pacote Padronizado'");
        tocarElemento(botaoEscolherPacotePadronizado, "Erro ao tentar tocar no bot�o 'Escolher Pacote Padronizado'");
        return this;
    }
}
