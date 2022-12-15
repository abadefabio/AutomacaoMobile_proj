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

    //Botão Voltar
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
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Endereços')]/..")
    private MobileElement botaoEnderecos;

    public MeusDadosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar a exibição da tela 'Meus Dados'
     *
     * @return MeusDadosTela
     */
    @Step("Validar tela \"Meus Dados\"")
    public MeusDadosTela validarTelaMeusDados() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TITULO_MEUS_DADOS), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Meus Dados' não está presente na tela!");
        salvarEvidencia("Validar presenca da tela 'Meus Dados'");
        return this;
    }

    /**
     * Tocar no Botão 'Voltar'
     *
     * @return MeusDadosTela
     * @throws NextException
     */
    @Step("Tocar botão \"Voltar\"")
    public MeusDadosTela tocarBotaoVoltar() throws NextException {
        salvarEvidencia("Tocar no botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'!");
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
        tocarElemento(campoApelido, "Não foi possível tocar no campo 'Apelido'!");
        return this;
    }

    /**
     * Validar alteração no campo 'Apelido'
     *
     * @return MeusDadosTela
     * @throws NextException
     */
    @Step("Validar alteração no campo \"Apelido\"")
    public MeusDadosTela validarAlteracaoCampoApelido(String apelido) {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(apelido), MetodoComparacaoBooleano.VERDADEIRO, "Campo 'Apelido' não sofreu a alteração esperada!");
        salvarEvidencia("Validar alteração no campo 'Apelido'");
        return this;
    }

    /**
     * Tocar no Botão 'Endereços'
     *
     * @return MeusDadosTela
     * @throws Exception
     */
    @Step("Tocar botão 'Endereços'")
    public MeusDadosTela tocarBotaoEnderecos() throws Exception {
        aguardarCarregamentoElemento(botaoEnderecos);
        salvarEvidencia("Tocar no botão 'Endereços'");
        tocarElemento(botaoEnderecos, "Não foi possível tocar no botão 'Endereços'!");
        return this;
    }


}
