package pagina.mobile.jornadas.comprovantes.investimentos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.comprovantes.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InvestimentosTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_item_receipts_investment_products")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"next CDB \"]")
    private MobileElement opcaoNextCdb;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Período\"]")
    private MobileElement botaoPeriodo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_visualize")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"VISUALIZAR\"]")
    private MobileElement botaoVisualizar;

    public InvestimentosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presenca da tela 'INVESTIMENTOS'
     * @return
     */
    @Step("Validar presença da tela 'EXTRATO'")
    public InvestimentosTela validarPresencaTelaInvestimentos() {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.INVESTIMENTOS), MetodoComparacaoBooleano.VERDADEIRO, "Titulo 'INVESTIMENTOS' nao esta presente na tela!");
        salvarEvidencia("Validada presenca da tela 'INVESTIMENTOS'");
        return this;
    }


    /**Tocar na opcao next CDB
     * @return
     * @throws Exception
     */
    public InvestimentosTela tocarOpcaoNextCdb() throws Exception {

        salvarEvidencia("Tocar na opção 'next CDB'");
        tocarElemento(opcaoNextCdb,"Nao foi possivel tocar na opção 'next CDB'");
        return this;
    }

    /**
     * Validar presenca da tela com o investimento selecionado
     * @param tituloTela
     * @return
     */
    @Step("Validar presença da tela de investimento")
    public InvestimentosTela validarPresencaTela(String tituloTela) {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(tituloTela), MetodoComparacaoBooleano.VERDADEIRO, "Titulo '" + tituloTela + "' nao esta presente na tela!");
        salvarEvidencia("Validada presenca da tela '" + tituloTela + "'");
        return this;
    }


    /**Tocar na opcao 'next CDB'
     * @return
     * @throws Exception
     */
    public InvestimentosTela tocarBotaoSelecionarPeriodo() throws Exception {

        salvarEvidencia("Selecionar o período para emissão do comprovante");
        tocarElemento(botaoPeriodo,"Nao foi possivel selecionar o período!");
        return this;
    }

    /**Tocar no botao 'Visualizar'
     * @return
     * @throws Exception
     */
    public InvestimentosTela tocarBotaoVisualizar() throws Exception {

        salvarEvidencia("Visualizar o comprovante");
        tocarElemento(botaoVisualizar,"Nao foi possivel tocar no botão 'Visualizar'!");
        return this;
    }
}
