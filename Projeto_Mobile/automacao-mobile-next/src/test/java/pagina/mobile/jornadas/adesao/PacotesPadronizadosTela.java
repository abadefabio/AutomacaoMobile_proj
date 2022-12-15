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
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.PACOTES_PADRONIZADOS)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Pacotes Padronizados' não está presente na tela!");
        salvarEvidencia("Validada tela 'Pacotes Padronizados'");
        return this;
    }

    /**
     * Tocar botão 'Escolher Pacote Padronizado'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Escolher Pacote Padronizado'")
    public PacotesPadronizadosTela tocarEscolherPacotePadronizado() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEscolherPacotePadronizado, "Botão 'Escolher Pacote Padronizado' não localizado");
        salvarEvidencia("Botão 'Escolher Pacote Padronizado'");
        tocarElemento(botaoEscolherPacotePadronizado, "Erro ao tentar tocar no botão 'Escolher Pacote Padronizado'");
        return this;
    }
}
