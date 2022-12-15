package pagina.mobile.jornadas.configuracoes.perfil.meus.dados;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.configuracoes.perfil.meusDados.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MeusDadosTela extends PaginaBase {

    //Bot�o Voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"voltar\"]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    //Campo Apelido
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/netMyDataNick")
    @iOSXCUITFindBy(accessibility = "Apelido")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Apelido\"]")
    private MobileElement campoApelido;

    @AndroidFindBy(id = "br.com.bradesco.next:id/registration_update_addresses")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Endere�os')]/..")
    private MobileElement botaoEnderecos;

    public MeusDadosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar a exibi��o da tela 'Meus Dados'
     *
     * @return MeusDadosTela
     */
    @Step("Validar tela \"Meus Dados\"")
    public MeusDadosTela validarTelaMeusDados() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TITULO_MEUS_DADOS), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Meus Dados' n�o est� presente na tela!");
        salvarEvidencia("Validar presenca da tela 'Meus Dados'");
        return this;
    }

    /**
     * Tocar no Bot�o 'Voltar'
     *
     * @return MeusDadosTela
     * @throws NextException
     */
    @Step("Tocar bot�o \"Voltar\"")
    public MeusDadosTela tocarBotaoVoltar() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'!");
        return this;
    }

    /**
     * Tocar no campo 'Apelido'
     *
     * @return MeusDadosTela
     * @throws NextException
     */
    @Step("Tocar campo \"Apelido\"")
    public MeusDadosTela tocarCampoApelido() throws NextException {
        salvarEvidencia("Tocar no campo 'Apelido'");
        tocarElemento(campoApelido, "N�o foi poss�vel tocar no campo 'Apelido'!");
        return this;
    }

    /**
     * Validar altera��o no campo 'Apelido'
     *
     * @return MeusDadosTela
     * @throws NextException
     */
    @Step("Validar altera��o no campo \"Apelido\"")
    public MeusDadosTela validarAlteracaoCampoApelido(String apelido) {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(apelido), MetodoComparacaoBooleano.VERDADEIRO, "Campo 'Apelido' n�o sofreu a altera��o esperada!");
        salvarEvidencia("Validar altera��o no campo 'Apelido'");
        return this;
    }

    /**
     * Tocar no Bot�o 'Endere�os'
     *
     * @return MeusDadosTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Endere�os'")
    public MeusDadosTela tocarBotaoEnderecos() throws Exception {
        aguardarCarregamentoElemento(botaoEnderecos);
        salvarEvidencia("Tocar no bot�o 'Endere�os'");
        tocarElemento(botaoEnderecos, "N�o foi poss�vel tocar no bot�o 'Endere�os'!");
        return this;
    }


}
