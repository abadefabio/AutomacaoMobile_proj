package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CaixaEletronicoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_search_cash_machine")
    @iOSXCUITFindBy(accessibility = "Procurar caixa eletr�nico")
    private MobileElement botaoProcurarCaixaEletronico;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_cancel")
    @iOSXCUITFindBy(accessibility = "Cancelar")
    private MobileElement botaoCancelar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_search_atms")
    @iOSXCUITFindBy(accessibility = "cashin icon nav search")
    private MobileElement botaoLupa;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_details_track_route")
    @iOSXCUITFindBy(accessibility = "Ver caminho")
    private MobileElement botaoVerCaminho;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_details")
    @iOSXCUITFindBy(accessibility = "Detalhes")
    private MobileElement botaoDetalhes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_track_route")
    @iOSXCUITFindBy(accessibility = "Ver caminho")
    private MobileElement verCaminhoGps;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @iOSXCUITFindBy(accessibility = "Maps")
    private MobileElement botaoMaps;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOk;

    public CaixaEletronicoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar bot�o 'Procurar Caixa eletr�nico'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Procurar Caixa Eletr�nico\"")
    public CaixaEletronicoTela tocarBotaoProcurarCaixaEletronico() throws Exception {
        aguardarCarregamentoElemento(botaoProcurarCaixaEletronico);
        salvarEvidencia("Clicar no bot�o 'procurar caixa eletr�nico'");
        tocarElemento(botaoProcurarCaixaEletronico, "N�o foi poss�vel clicar no bot�o procurar caixa eletr�nico");
        return this;
    }

    /**
     * Clicar bot�o 'Cancelar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Cancelar\"")
    public CaixaEletronicoTela tocarBotaoCancelar() throws Exception {
        aguardarCarregamentoElemento(botaoCancelar);
        salvarEvidencia("Clicar no bot�o 'cancelar'");
        tocarElemento(botaoCancelar, "N�o foi poss�vel clicar no bot�o cancelar");
        return this;
    }

    /**
     * Clicar bot�o 'Lupa'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Lupa\"")
    public CaixaEletronicoTela tocarBotaoLupa() throws Exception {
        aguardarCarregamentoElemento(botaoLupa);
        salvarEvidencia("Clicar no bot�o 'Lupa'");
        tocarElemento(botaoLupa, "N�o foi poss�vel clicar no bot�o lupa");
        return this;
    }

    /**
     * Clicar bot�o 'Ver Caminho'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Ver Caminho\"")
    public CaixaEletronicoTela tocarBotaoVerCaminho() throws Exception {
        aguardarCarregamentoElemento(botaoVerCaminho);
        salvarEvidencia("Clicar no bot�o 'Ver Caminho'");
        tocarElemento(botaoVerCaminho, "N�o foi poss�vel clicar no bot�o ver caminho");
        return this;
    }

    /**
     * Clicar bot�o 'Detalhes'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Detalhes\"")
    public CaixaEletronicoTela tocarBotaoDetalhes() throws Exception {
        aguardarCarregamentoElemento(botaoDetalhes);
        salvarEvidencia("Clicar no bot�o 'Detalhes'");
        tocarElemento(botaoDetalhes, "N�o foi poss�vel clicar no bot�o Detalhes");
        return this;
    }

    /**
     * Clicar em 'Ver Caminho' - Gps
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Ver Caminho - Gps\"")
    public CaixaEletronicoTela tocarEmVerCaminho() throws Exception {
        aguardarCarregamentoElemento(verCaminhoGps);
        salvarEvidencia("Clicar em 'Ver Caminho'");
        tocarElemento(verCaminhoGps, "N�o foi poss�vel clicar  em ver caminho");
        if (getDriver() instanceof IOSDriver) {
            tocarBotaoMaps();
        }
        voltarAppIos();
        if (getDriver() instanceof AndroidDriver) {
            voltarTelaAnterior();
        }
        return this;
    }

    /**
     * Clicar em 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Voltar\"")
    public CaixaEletronicoTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicar em 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel clicar  em Voltar");
        return this;
    }

    /**
     * Clicar em Maps
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Maps\"")
    public CaixaEletronicoTela tocarBotaoMaps() throws Exception {
        aguardarCarregamentoElemento(botaoMaps);
        salvarEvidencia("Clicar em 'Maps'");
        tocarElemento(botaoMaps, "N�o foi poss�vel clicar  em Maps");
        return this;
    }

    /**
     * Clicar bot�o 'Ok'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"OK\"")
    public CaixaEletronicoTela tocarBotaoOk() throws Exception {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Clicar bot�o 'Ok'");
        tocarElemento(botaoOk, "N�o foi poss�vel clicar bot�o 'Ok'");
        return this;
    }
}
