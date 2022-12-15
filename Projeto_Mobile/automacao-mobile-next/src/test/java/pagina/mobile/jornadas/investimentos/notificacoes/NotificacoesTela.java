package pagina.mobile.jornadas.investimentos.notificacoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class NotificacoesTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"NOTIFICA��ES\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NOTIFICA��ES\"]")
    private MobileElement tituloNotificacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nt_know_more_nt")
    @AndroidFindBy(xpath = "//android.widget.Button[contais(@content-desc,\"ver mais\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Ver mais\")]")
    private MobileElement botaoVerMais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_description_nt")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,\"perfil t� vencido\")]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"perfil t� vencido\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"Seu perfil t� vencido\")]")
    private MobileElement labelNotificacaoInvestimentosPerfilVencido;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_description_nt")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"[Investimentos] A aplica��o agendada n�o t� no seu perfil. Pra continuar, assina o Termo de Ci�ncia e Risco!\")]")
    @iOSXCUITFindBy(accessibility = "[Investimentos] A aplica��o agendada n�o t� no seu perfil. Pra continuar, assina o Termo de Ci�ncia e Risco!")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"[Investimentos] A aplica��o agendada n�o t� no seu perfil. Pra continuar, assina o Termo de Ci�ncia e Risco!\"`]")
    private MobileElement textoInvestimentoForaDoPerfil;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"[Objetivos] Hey! Para confirmar sua aplica��o voc� precisa aceitar o termo de ci�ncia de risco.\")]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"[Objetivos] Hey! Para confirmar sua aplica��o voc� precisa aceitar o termo de ci�ncia de risco.\"])[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"[Objetivos] Hey! Para confirmar sua aplica��o voc� precisa aceitar o termo de ci�ncia de risco.\"`][1]")
    private MobileElement textoInvestimentoAtualizacaoCadastral;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "ver maisem jornada deem investimentos")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"ver maisem jornada deem investimentos\"]")
    @iOSXCUITFindBy(accessibility = "Ver mais em jornada de Investimentos")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver mais em jornada de Investimentos\"`]")
    private MobileElement botaoVerMaisInvestimentoForaDoPerfil;

    @AndroidFindBy(id = "br.com.bradesco.next:id/text_type_of_love")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"seu cadastro precisa t� atualizado\"$]")
    private MobileElement labelAtualizacaoCadastro;

    @AndroidFindBy(id = "br.com.bradesco.next:id/update_registry")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Atualizar meus dados\"`]")
    private MobileElement botaoAtualizarMeusDados;

    public NotificacoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar exibi��o da tela 'Notifica��es'
     *
     * @return NotificacoesTela
     */
    @Step("Validar exibi��o da tela 'Notifica��es'")
    public NotificacoesTela validarExibicaoTelaNotificacoes() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloNotificacoes),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar e exibi��o da tela 'Notifica��es'");
        salvarEvidencia("Validar a exibi��o da tela 'Notifica��es'");
        return this;
    }

    /**
     * Validar a notifica��o de perfil vencido
     * fr
     * @return NotificacoesTela
     * @throws Exception
     */
    @Step("Validar a notifica��o de perfil vencido")
    public NotificacoesTela validarNotificacaoInvestimentosPerfilVencido() throws Exception {

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelNotificacaoInvestimentosPerfilVencido,
                "N�o foi poss�vel encontrar o aviso de perfil vencido.");
        salvarEvidencia("Validou a notifica��o: Seu perfil t� vencido!");
        return this;
    }
    /**
     * Validar a notifica��o de atualiza��o cadastral
     *
     * @param
     * @return NotificacoesTela
     * @throws Exception
     */
    @Step("Validar a notifica��o de atualiza��o cadastral")
    public NotificacoesTela validarNotificacaoAtualizacaoCadastral() {
        validarCondicaoBooleana(verificarPresencaElemento(labelAtualizacaoCadastro),MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel encontrar o texto notifica��o de atualiza��o cadastral");
        salvarEvidencia("Validar texto notificacao atualizacao cadastral");
        return this;
    }

    /**
     * Tocar no bot�o 'VER MAIS'
     *
     * @return NotificacoesTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'VER MAIS'")
    public NotificacoesTela tocarBotaoVerMais() throws NextException {
        salvarEvidencia("Tocar no bot�o 'VER MAIS'");
        tocarElemento(botaoVerMais,"Erro ao tocar no bot�o: 'VER MAIS'");
        return this;
    }

    /**
     * Tocar no bot�o 'Atualizar meus dados'
     *
     * @return NotificacoesTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Atualizar meus dados'")
    public NotificacoesTela tocarBotaoAtualizarMeusDados() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Atualizar meus dados'");
        tocarElemento(botaoAtualizarMeusDados,"Erro ao tocar no bot�o: 'Atualizar meus dados'");
        return this;
    }

    /**
     * Validar a presenca do texto investimentos a aplicacao agendada nao ta no seu perfil
     * @return NotificacoesTela
     * @throws Exception
     */
    @Step("Validar texto investimentos a aplicacao agendada nao ta no seu perfil")
    public NotificacoesTela validarTextoInvestimentoAgendadoForaDoPerfil()throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoInvestimentoForaDoPerfil,"Texto investimentos a aplicacao agendada nao ta no seu perfil nao esta presente na tela");
        salvarEvidencia("Validar texto investimentos a aplicacao agendada nao ta no seu perfil");
        return this;
    }

    /**
     * Validar a presenca do texto investimentos atualizacao cadastral
     * @return NotificacoesTela
     * @throws Exception
     */
    @Step("Validar a presenca do texto investimentos a aplicacao agendada nao ta no seu perfil")
    public NotificacoesTela validarTextoInvestimentoAtualizacaoCadastral()throws Exception{
        salvarEvidencia("Validar a presenca do texto investimentos a aplicacao agendada nao ta no seu perfil presente na tela");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoInvestimentoAtualizacaoCadastral,"Texto investimentos a aplicacao agendada nao ta no seu perfil nao esta presente na tela");
        return this;
    }

    /**
     * Tocar no botao ver mais do card investimento agendado fora do perfil
     * @return NotificacoesTela
     * @throws Exception
     */
    @Step("Tocar no botao ver mais do card investimento agendado fora do perfil")
    public NotificacoesTela tocarBotaoVerMaisInvestimentoForaDoPerfil()throws Exception{
        salvarEvidencia("Tocar no botao ver mais do card investimento agendado fora do perfil");
        tocarElemento(botaoVerMaisInvestimentoForaDoPerfil,"Nao foi possivel tocar no botao ver mais do card investimento agendado fora do perfil");
        return this;
    }
}
