package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class BancoVaquinhaTela extends PaginaBase {

    //opção do banco filtrado
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_create_vaquinha")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"1 - BANCO DO BRASIL S.A.\"")
    private MobileElement banco;

    //nome banco a ser buscado
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_search")
    @iOSXCUITFindBy(accessibility = "Buscar")
    private MobileElement campoFiltroBanco;

    //nome banco a ser buscado
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_view")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_name")
    private MobileElement tocarCampoNomeBanco;

    //botao confirmar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Confirmar\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon_close")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    //botao selecionar Banco
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon")
    @iOSXCUITFindBy(accessibility = "Selecionar banco")
    private MobileElement selecionarBanco;

    public BancoVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Clicar no campo selecionar banco
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao Selecionar Banco")
    public BancoVaquinhaTela tocarBotaoSelecionarBanco() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        tocarElemento(botaoConfirmar, "Não foi possível clicar no botão selecionarBanco");
        salvarEvidencia("Tocar botao selecionar Banco");
        return this;
    }

    /**
     * Clicar e preencher banco na tela de seleção de banco
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher banco")
    public BancoVaquinhaTela preencherBanco(String banco) throws NextException {

        aguardarCarregamentoElemento(campoFiltroBanco);
        escreverTexto(campoFiltroBanco,banco,"Não foi possível preencher campo banco");
        if(android) tocarElemento(tocarCampoNomeBanco,"Não foi possível clicar selecionar o banco");
        salvarEvidencia("Preencher banco");
        return this;
    }

    /**
     * Clicar no campo selecionar banco
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao Confirmar")
    public BancoVaquinhaTela   tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Tocar botao Confirmar");
        tocarElemento(botaoConfirmar, "Não foi possível clicar no botão Confirmar");
        return this;
    }

    /**
     * Clicar no botão para selecionar banco
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao selecionar banco")
    public BancoVaquinhaTela tocarselecionarBanco() throws Exception {
        esperarCarregando();
        esperarCarregando();
        aguardarCarregamentoElemento(selecionarBanco);
        if(ios)
            rolaTelaBaixo();
        tocarElemento(selecionarBanco, "Não foi possível clicar no botão selecionar banco");
        salvarEvidencia("Tocar botao selecionar banco");
        return this;
    }
}
