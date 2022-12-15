package pagina.mobile.jornadas.transferencia;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.transferencia.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TransferenciaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy( id = "br.com.bradesco.next:id/bt_for_me")
    @iOSXCUITFindBy(accessibility = "PARA MIM")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PARA MIM\"]")
    private MobileElement botaoParaMim;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy( id = "br.com.bradesco.next:id/bt_for_others")
    @iOSXCUITFindBy(accessibility = "OUTRA PESSOA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@text,\"OUTRA\")]")
    private MobileElement botaoOutraPessoa;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    private MobileElement fecharTransferir;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_info")
    @iOSXCUITFindBy(accessibility = "Informações")
    private MobileElement iconeInformacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Menu, Botão")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Menu, Botão\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar para o Menu\"]")
    private MobileElement iconeVoltarParaMenu;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Instituição de pagamento\"]")
    @iOSXCUITFindBy(accessibility = "Instituição de Pagamento")
    @iOSXCUITFindBy(xpath = "//*[@text=\"Instituição de pagamento\"]")
    private MobileElement botaoInstituicaoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Banco ou instituição\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_bank_or_instituional")
    @iOSXCUITFindBy(accessibility = "Banco ou Instituição")
    private MobileElement selecionarBancoOuInstitucao;

    public TransferenciaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão "Para Mim"
     *
     * @return TransferenciaTela
     * @throws Exception
     */
    @Step("Tocar botão \"Para mim\"")
    public TransferenciaTela tocarBotaoParaMim() throws Exception {
        aguardarCarregamentoElemento(botaoParaMim);
        salvarEvidencia( "Tocar no botão 'Para mim'" );
        tocarElemento(botaoParaMim, "Não foi possível Tocar no botão Para Mim" );
        return this;
    }

    /**
     * Tocar botão "Outra Pessoa"
     *
     * @return TransferenciaTela
     * @throws Exception
     */
    @Step("Tocar botão \"Outra Pessoa\"")
    public TransferenciaTela tocarBotaoOutraPessoa() throws Exception {
        aguardarCarregamentoElemento(botaoOutraPessoa);
        salvarEvidencia( "Tocar no botão 'Outra Pessoa'" );
        tocarElemento(botaoOutraPessoa, "Não foi possível Tocar no botão Outra Pessoa" );
        return this;
    }

    /**
     * Tocar botão "Fechar(x)"
     *
     * @return TransferenciaTela
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public TransferenciaTela tocarFecharTransferir() throws Exception {
        aguardarCarregamentoElemento(fecharTransferir);
        salvarEvidencia( "Tocar no botão fechar (X)" );
        tocarElemento(fecharTransferir, "Nao foi possivel tocar no botão fechar" );
        return this;
    }

    /**
     * Tocar ícone "i"
     *
     * @return TransferenciaTela
     * @throws Exception
     */
    @Step("Tocar ícone \"i\"")
    public TransferenciaTela tocarIconeInformacao() throws Exception {
        aguardarCarregamentoElemento(iconeInformacao);
        tocarElemento( iconeInformacao, "Erro ao tocar ícone \"i\"" );
        salvarEvidencia( "Tocar ícone \"i\"" );
        return this;
    }

    /**
     * Tocar Icone 'Voltar Para Menu' (=)
     * @return
     * @throws NextException
     */
    @Step("Tocar ícone \"=\"")
    public TransferenciaTela tocarIconeVoltarParaMenu() throws NextException {
        aguardarCarregamentoElemento(iconeVoltarParaMenu);
        tocarElemento(iconeVoltarParaMenu, "Erro ao tocar ícone \"=\"" );
        salvarEvidencia( "Tocar ícone \"=\"" );
        return this;
    }

    /**
     * Validar presença da tela 'Transferência'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Transferência'")
    public TransferenciaTela validarPresencaTelaTransferencia() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TRANSFERENCIA), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Transferência' e/ou Mensagem inicial da jornada não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela 'Transferência'");
        return this;
    }

    /**
     * Tocar Botao Instituição de pagamento
     * @return
     * @throws NextException
     */
    @Step("Tocar Botão Instituição de pagamento")
    public TransferenciaTela tocarBotaoInstituicaoDePagamento() throws NextException {
        aguardarCarregamentoElemento(botaoInstituicaoPagamento);
        salvarEvidencia( "Tocar Botão Instituição de pagamento" );
        tocarElemento(botaoInstituicaoPagamento, "Erro ao tocar Botão Instituição de pagamento" );
        return this;
    }

    /**
     * Tocar Banco ou instituição
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em Botão selecionar Banco ou instituição")
    public TransferenciaTela tocarBotaoBancoOuInstituicao() throws Exception {
        salvarEvidencia("Banco ou Instituição");
        tocarElemento(selecionarBancoOuInstitucao, "Não foi possível tocar no botão Selecionar Banco ou Instituição");
        return this;
    }
}
