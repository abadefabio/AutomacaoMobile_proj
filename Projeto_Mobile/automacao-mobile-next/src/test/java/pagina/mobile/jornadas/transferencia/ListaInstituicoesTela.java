package pagina.mobile.jornadas.transferencia;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import pagina.mobile.jornadas.transferencia.para.mim.MinhasContasTela;

public class ListaInstituicoesTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_search")
    @iOSXCUITFindBy(accessibility = "Buscar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Buscar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Buscar\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Buscar\"]")
    private MobileElement caixaPesquisa;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system_option")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirmar']")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirmar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar\"]")
    private MobileElement botaoConfirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon_search")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resourceId(\"br.com.bradesco.next:id/ctv_name\"));")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel")
    private MobileElement botaoInstituicao;

    public ListaInstituicoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Pesquisa por instirui��o de pagamento informado via json
     *
     * @param instituicao
     * @return ListaInstituicoesTela
     * @throws Exception
     */
    @Step("Pesquisar institui��o")
    public ListaInstituicoesTela pesquisarInstituicaoPagamento(String instituicao) throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        MinhasContasTela.setInstituicao(instituicao);
        tocarElemento( caixaPesquisa, "Erro ao tocar elemento \"Caixa de Pesquisa\"" );
        salvarEvidencia("Pesquisar Institui��o Pagamento: \"" + instituicao + "\"");
        OperadorEvidencia.logarPasso("Preencher Lupa de pesquisa: " + instituicao);
        escreverTexto( caixaPesquisa, instituicao, "Erro ao preencher \"Caixa de Pesquisa\"" );
        salvarEvidencia("Confirmar sele��o da institui��o: \"" + instituicao + "\"");
        aguardarCarregamentoElemento(botaoInstituicao);
        tocarElemento( botaoInstituicao, "Erro ao selecionar institui��o" );
        Thread.sleep(2000);
        tocarElemento( botaoConfirmar, "Erro ao tocar elemento \"v\"" );
        return this;
    }

    /**
     * Preencher campo busca institui��o inicial
     *
     * @return ListaInstituicoesTela
     * @throws Exception
     */
    @Step("Preencher campo busca institui��o")
    public ListaInstituicoesTela preencherCampoBuscaInstituicaoInicial() throws Exception{
        aguardarCarregamentoElemento(caixaPesquisa);
        tocarElemento( caixaPesquisa, "Erro ao tocar elemento \"Caixa de Pesquisa\"" );
        escreverTexto( caixaPesquisa, MinhasContasTela.retornaInstituicaoInicial(), "Erro ao preencher \"Caixa de Pesquisa\"" );
        MinhasContasTela.setInstituicao(MinhasContasTela.retornaInstituicaoInicial());
        salvarEvidencia("Pesquisar Institui��o Pagamento: \"" + MinhasContasTela.retornaInstituicao() + "\"");
        return this;
    }

    /**
     * Selecionar Institui��o
     *
     * @return ListaInstituicoesTela
     * @throws Exception
     */
    @Step("Selecionar Institui��o")
    public ListaInstituicoesTela selecionarInstituicao() throws Exception{
        aguardarCarregamentoElemento(botaoInstituicao);
        aguardarCarregamentoElemento(botaoInstituicao);
        tocarElemento( botaoInstituicao, "Erro ao selecionar institui��o" );
        return this;
    }

    /**
     * Tocar elemento "v"
     *
     * @return ListaInstituicoesTela
     * @throws Exception
     */
    @Step("Confirmar Sele��o Institui��o")
    public ListaInstituicoesTela confirmarSelecaoInstituicao() throws Exception{
        aguardarCarregamentoElemento(botaoConfirmar);
        tocarElemento( botaoConfirmar, "Erro ao tocar elemento \"v\"" );
        salvarEvidencia("Confirmar sele��o da institui��o: \"" + MinhasContasTela.retornaInstituicao() + "\"");
        return this;
    }
}
