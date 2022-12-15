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

public class EscolhaSuaCestaTela extends PaginaBase {

    public EscolhaSuaCestaTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_others")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"VER PACOTES PADRONIZADOS\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"VER PACOTES PADRONIZADOS\")]")
    private MobileElement botaoVerPacotesPadronizados;

    /**
     * Validar Titulo Tela 'Escolha sua Cesta'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Escolha sua Cesta'")
    public EscolhaSuaCestaTela validarTituloTelaEscolhaSuaCesta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.ESCOLHA_SUA_CESTA)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Escolha sua Cesta' não está presente na tela!");
        salvarEvidencia("Validada tela 'Escolha sua Cesta'");
        return this;
    }

    /**
     * Tocar botão 'Ver Pacotes Padronizados'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Ver Pacotes Padronizados'")
    public EscolhaSuaCestaTela tocarVerPacotesPadronizados() throws Exception {
        if  (ios)
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerPacotesPadronizados, "Não foi possível realizar scroll para baixo até o botão pacotes padronizados");
        else
            rolarTelaAteFinal();
        salvarEvidencia("Tocar botão 'Ver Pacotes Padronizados'");
        tocarElemento(botaoVerPacotesPadronizados, "Erro ao tentar tocar no botão 'Ver Pacotes Padronizados'");
        return this;
    }
}
