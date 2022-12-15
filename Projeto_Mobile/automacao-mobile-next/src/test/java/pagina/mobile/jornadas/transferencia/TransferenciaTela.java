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
    @iOSXCUITFindBy(accessibility = "Informa��es")
    private MobileElement iconeInformacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Menu, Bot�o")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Menu, Bot�o\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar para o Menu\"]")
    private MobileElement iconeVoltarParaMenu;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Institui��o de pagamento\"]")
    @iOSXCUITFindBy(accessibility = "Institui��o de Pagamento")
    @iOSXCUITFindBy(xpath = "//*[@text=\"Institui��o de pagamento\"]")
    private MobileElement botaoInstituicaoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Banco ou institui��o\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_bank_or_instituional")
    @iOSXCUITFindBy(accessibility = "Banco ou Institui��o")
    private MobileElement selecionarBancoOuInstitucao;

    public TransferenciaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o "Para Mim"
     *
     * @return TransferenciaTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Para mim\"")
    public TransferenciaTela tocarBotaoParaMim() throws Exception {
        aguardarCarregamentoElemento(botaoParaMim);
        salvarEvidencia( "Tocar no bot�o 'Para mim'" );
        tocarElemento(botaoParaMim, "N�o foi poss�vel Tocar no bot�o Para Mim" );
        return this;
    }

    /**
     * Tocar bot�o "Outra Pessoa"
     *
     * @return TransferenciaTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Outra Pessoa\"")
    public TransferenciaTela tocarBotaoOutraPessoa() throws Exception {
        aguardarCarregamentoElemento(botaoOutraPessoa);
        salvarEvidencia( "Tocar no bot�o 'Outra Pessoa'" );
        tocarElemento(botaoOutraPessoa, "N�o foi poss�vel Tocar no bot�o Outra Pessoa" );
        return this;
    }

    /**
     * Tocar bot�o "Fechar(x)"
     *
     * @return TransferenciaTela
     * @throws Exception
     */
    @Step("Tocar no bot�o fechar (X)")
    public TransferenciaTela tocarFecharTransferir() throws Exception {
        aguardarCarregamentoElemento(fecharTransferir);
        salvarEvidencia( "Tocar no bot�o fechar (X)" );
        tocarElemento(fecharTransferir, "Nao foi possivel tocar no bot�o fechar" );
        return this;
    }

    /**
     * Tocar �cone "i"
     *
     * @return TransferenciaTela
     * @throws Exception
     */
    @Step("Tocar �cone \"i\"")
    public TransferenciaTela tocarIconeInformacao() throws Exception {
        aguardarCarregamentoElemento(iconeInformacao);
        tocarElemento( iconeInformacao, "Erro ao tocar �cone \"i\"" );
        salvarEvidencia( "Tocar �cone \"i\"" );
        return this;
    }

    /**
     * Tocar Icone 'Voltar Para Menu' (=)
     * @return
     * @throws NextException
     */
    @Step("Tocar �cone \"=\"")
    public TransferenciaTela tocarIconeVoltarParaMenu() throws NextException {
        aguardarCarregamentoElemento(iconeVoltarParaMenu);
        tocarElemento(iconeVoltarParaMenu, "Erro ao tocar �cone \"=\"" );
        salvarEvidencia( "Tocar �cone \"=\"" );
        return this;
    }

    /**
     * Validar presen�a da tela 'Transfer�ncia'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Transfer�ncia'")
    public TransferenciaTela validarPresencaTelaTransferencia() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TRANSFERENCIA), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Transfer�ncia' e/ou Mensagem inicial da jornada n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela 'Transfer�ncia'");
        return this;
    }

    /**
     * Tocar Botao Institui��o de pagamento
     * @return
     * @throws NextException
     */
    @Step("Tocar Bot�o Institui��o de pagamento")
    public TransferenciaTela tocarBotaoInstituicaoDePagamento() throws NextException {
        aguardarCarregamentoElemento(botaoInstituicaoPagamento);
        salvarEvidencia( "Tocar Bot�o Institui��o de pagamento" );
        tocarElemento(botaoInstituicaoPagamento, "Erro ao tocar Bot�o Institui��o de pagamento" );
        return this;
    }

    /**
     * Tocar Banco ou institui��o
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em Bot�o selecionar Banco ou institui��o")
    public TransferenciaTela tocarBotaoBancoOuInstituicao() throws Exception {
        salvarEvidencia("Banco ou Institui��o");
        tocarElemento(selecionarBancoOuInstitucao, "N�o foi poss�vel tocar no bot�o Selecionar Banco ou Institui��o");
        return this;
    }
}
