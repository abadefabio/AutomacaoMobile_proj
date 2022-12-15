package pagina.mobile.jornadas.configuracoes.perfil.APP;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.configuracoes.perfil.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.ConfiguracoesPagamentosTela;

public class ConfiguracoesDoAppTela extends PaginaBase {

    public ConfiguracoesDoAppTela(AppiumDriver driver) {
        super(driver);
    }

    //botao trocar senha do app
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Trocar senha do app')]")
    @iOSXCUITFindBy(accessibility = "Trocar senha do app. A que voc� usa para acessar o app")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Trocar senha do app')]")
    private MobileElement botaoTrocarSenhaApp;

    /**
     * Validar que esta na tela configuracoes do APP
     * fr
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Configuracao do APP\"")
    public ConfiguracoesDoAppTela validarTelaConfiguracoesApp() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TROCAR_SENHA_APP.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'configuracoes do APP' n�o est� presente na tela!");
        salvarEvidencia("Validado tela Configura��es do App'!");
        return this;
    }

    /**
     * Tocar bot�o Trocar senha
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Trocar senha\"")
    public ConfiguracoesDoAppTela tocarBotaoTrocarSenha() throws Exception{
        salvarEvidencia("Tocar bot�o 'Trocar senha'");
        tocarElemento(botaoTrocarSenhaApp,"N�o foi poss�vel tocar bot�o Trocar senha");
        return this;
    }
}
