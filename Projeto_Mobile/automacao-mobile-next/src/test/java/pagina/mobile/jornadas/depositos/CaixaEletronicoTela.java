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
    @iOSXCUITFindBy(accessibility = "Procurar caixa eletrônico")
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
     * Clicar botão 'Procurar Caixa eletrônico'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Procurar Caixa Eletrônico\"")
    public CaixaEletronicoTela tocarBotaoProcurarCaixaEletronico() throws Exception {
        aguardarCarregamentoElemento(botaoProcurarCaixaEletronico);
        salvarEvidencia("Clicar no botão 'procurar caixa eletrônico'");
        tocarElemento(botaoProcurarCaixaEletronico, "Não foi possível clicar no botão procurar caixa eletrônico");
        return this;
    }

    /**
     * Clicar botão 'Cancelar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Cancelar\"")
    public CaixaEletronicoTela tocarBotaoCancelar() throws Exception {
        aguardarCarregamentoElemento(botaoCancelar);
        salvarEvidencia("Clicar no botão 'cancelar'");
        tocarElemento(botaoCancelar, "Não foi possível clicar no botão cancelar");
        return this;
    }

    /**
     * Clicar botão 'Lupa'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Lupa\"")
    public CaixaEletronicoTela tocarBotaoLupa() throws Exception {
        aguardarCarregamentoElemento(botaoLupa);
        salvarEvidencia("Clicar no botão 'Lupa'");
        tocarElemento(botaoLupa, "Não foi possível clicar no botão lupa");
        return this;
    }

    /**
     * Clicar botão 'Ver Caminho'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Ver Caminho\"")
    public CaixaEletronicoTela tocarBotaoVerCaminho() throws Exception {
        aguardarCarregamentoElemento(botaoVerCaminho);
        salvarEvidencia("Clicar no botão 'Ver Caminho'");
        tocarElemento(botaoVerCaminho, "Não foi possível clicar no botão ver caminho");
        return this;
    }

    /**
     * Clicar botão 'Detalhes'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Detalhes\"")
    public CaixaEletronicoTela tocarBotaoDetalhes() throws Exception {
        aguardarCarregamentoElemento(botaoDetalhes);
        salvarEvidencia("Clicar no botão 'Detalhes'");
        tocarElemento(botaoDetalhes, "Não foi possível clicar no botão Detalhes");
        return this;
    }

    /**
     * Clicar em 'Ver Caminho' - Gps
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Ver Caminho - Gps\"")
    public CaixaEletronicoTela tocarEmVerCaminho() throws Exception {
        aguardarCarregamentoElemento(verCaminhoGps);
        salvarEvidencia("Clicar em 'Ver Caminho'");
        tocarElemento(verCaminhoGps, "Não foi possível clicar  em ver caminho");
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
    @Step("Clicar botão \"Voltar\"")
    public CaixaEletronicoTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicar em 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível clicar  em Voltar");
        return this;
    }

    /**
     * Clicar em Maps
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Maps\"")
    public CaixaEletronicoTela tocarBotaoMaps() throws Exception {
        aguardarCarregamentoElemento(botaoMaps);
        salvarEvidencia("Clicar em 'Maps'");
        tocarElemento(botaoMaps, "Não foi possível clicar  em Maps");
        return this;
    }

    /**
     * Clicar botão 'Ok'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"OK\"")
    public CaixaEletronicoTela tocarBotaoOk() throws Exception {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Clicar botão 'Ok'");
        tocarElemento(botaoOk, "Não foi possível clicar botão 'Ok'");
        return this;
    }
}
