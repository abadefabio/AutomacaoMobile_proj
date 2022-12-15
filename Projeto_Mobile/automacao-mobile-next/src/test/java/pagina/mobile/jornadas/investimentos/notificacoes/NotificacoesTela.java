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
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"NOTIFICAÇÕES\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NOTIFICAÇÕES\"]")
    private MobileElement tituloNotificacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nt_know_more_nt")
    @AndroidFindBy(xpath = "//android.widget.Button[contais(@content-desc,\"ver mais\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Ver mais\")]")
    private MobileElement botaoVerMais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_description_nt")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,\"perfil tá vencido\")]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"perfil tá vencido\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"Seu perfil tá vencido\")]")
    private MobileElement labelNotificacaoInvestimentosPerfilVencido;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_description_nt")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"[Investimentos] A aplicação agendada não tá no seu perfil. Pra continuar, assina o Termo de Ciência e Risco!\")]")
    @iOSXCUITFindBy(accessibility = "[Investimentos] A aplicação agendada não tá no seu perfil. Pra continuar, assina o Termo de Ciência e Risco!")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"[Investimentos] A aplicação agendada não tá no seu perfil. Pra continuar, assina o Termo de Ciência e Risco!\"`]")
    private MobileElement textoInvestimentoForaDoPerfil;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"[Objetivos] Hey! Para confirmar sua aplicação você precisa aceitar o termo de ciência de risco.\")]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"[Objetivos] Hey! Para confirmar sua aplicação você precisa aceitar o termo de ciência de risco.\"])[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"[Objetivos] Hey! Para confirmar sua aplicação você precisa aceitar o termo de ciência de risco.\"`][1]")
    private MobileElement textoInvestimentoAtualizacaoCadastral;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "ver maisem jornada deem investimentos")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"ver maisem jornada deem investimentos\"]")
    @iOSXCUITFindBy(accessibility = "Ver mais em jornada de Investimentos")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver mais em jornada de Investimentos\"`]")
    private MobileElement botaoVerMaisInvestimentoForaDoPerfil;

    @AndroidFindBy(id = "br.com.bradesco.next:id/text_type_of_love")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"seu cadastro precisa tá atualizado\"$]")
    private MobileElement labelAtualizacaoCadastro;

    @AndroidFindBy(id = "br.com.bradesco.next:id/update_registry")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Atualizar meus dados\"`]")
    private MobileElement botaoAtualizarMeusDados;

    public NotificacoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar exibição da tela 'Notificações'
     *
     * @return NotificacoesTela
     */
    @Step("Validar exibição da tela 'Notificações'")
    public NotificacoesTela validarExibicaoTelaNotificacoes() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloNotificacoes),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar e exibição da tela 'Notificações'");
        salvarEvidencia("Validar a exibição da tela 'Notificações'");
        return this;
    }

    /**
     * Validar a notificação de perfil vencido
     * fr
     * @return NotificacoesTela
     * @throws Exception
     */
    @Step("Validar a notificação de perfil vencido")
    public NotificacoesTela validarNotificacaoInvestimentosPerfilVencido() throws Exception {

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelNotificacaoInvestimentosPerfilVencido,
                "Não foi possível encontrar o aviso de perfil vencido.");
        salvarEvidencia("Validou a notificação: Seu perfil tá vencido!");
        return this;
    }
    /**
     * Validar a notificação de atualização cadastral
     *
     * @param
     * @return NotificacoesTela
     * @throws Exception
     */
    @Step("Validar a notificação de atualização cadastral")
    public NotificacoesTela validarNotificacaoAtualizacaoCadastral() {
        validarCondicaoBooleana(verificarPresencaElemento(labelAtualizacaoCadastro),MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível encontrar o texto notificação de atualização cadastral");
        salvarEvidencia("Validar texto notificacao atualizacao cadastral");
        return this;
    }

    /**
     * Tocar no botão 'VER MAIS'
     *
     * @return NotificacoesTela
     * @throws NextException
     */
    @Step("Tocar no botão 'VER MAIS'")
    public NotificacoesTela tocarBotaoVerMais() throws NextException {
        salvarEvidencia("Tocar no botão 'VER MAIS'");
        tocarElemento(botaoVerMais,"Erro ao tocar no botão: 'VER MAIS'");
        return this;
    }

    /**
     * Tocar no botão 'Atualizar meus dados'
     *
     * @return NotificacoesTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Atualizar meus dados'")
    public NotificacoesTela tocarBotaoAtualizarMeusDados() throws NextException {
        salvarEvidencia("Tocar no botão 'Atualizar meus dados'");
        tocarElemento(botaoAtualizarMeusDados,"Erro ao tocar no botão: 'Atualizar meus dados'");
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
