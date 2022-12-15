package pagina.mobile.jornadas.objetivos.criarObjetivo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EscolhaSeuObjetivosTela extends PaginaBase {

    //botao card Carro
    @AndroidFindBy(xpath = "//*[@text=\"Carro\"]")
    private MobileElement cardCarro;

    //botao card Casa
    @AndroidFindBy(xpath = "//*[@text=\"Casa\"]")
    @iOSXCUITFindBy(accessibility = "Casa")
    private MobileElement cardCasa;

    //botao card Casamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Casamento\"]")
    @iOSXCUITFindBy(accessibility = "Casamento")
    private MobileElement cardCasamento;

    //botao card Celular
    @AndroidFindBy(xpath = "//*[@text=\"Celular\"]")
    @iOSXCUITFindBy(accessibility = "Celular")
    private MobileElement cardCelular;

    //botao card Produto
    @AndroidFindBy(xpath = "//*[@text=\"Produto\"]")
    @iOSXCUITFindBy(accessibility = "Produto")
    private MobileElement cardProduto;

    public EscolhaSeuObjetivosTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar no card Casa - objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar card \"Casa\"")
    public EscolhaSeuObjetivosTela tocarCardCasa() throws Exception {
        aguardarCarregamentoElemento(cardCasa);
        salvarEvidencia("'Tocar card Casa'");
        tocarElemento(cardCasa,"Erro ao clicar con card casa");
        return this;
    }

    /**
     * Tocar no card Carro - objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar card \"Carro\"")
    public EscolhaSeuObjetivosTela tocarCardCarro() throws Exception {
        aguardarCarregamentoElemento(cardCarro);
        salvarEvidencia("'Tocar card Carro'");
        tocarElemento(cardCasa,"Erro ao clicar con card carro");
        return this;
    }

    /**
     * Tocar no card Celular - objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar card \"Celular\"")
    public EscolhaSeuObjetivosTela tocarCardCelular() throws Exception {
        aguardarCarregamentoElemento(cardCelular);
        salvarEvidencia("'Tocar card Celular'");
        tocarElemento(cardCelular,"Erro ao Tocar con card Celular");
        return this;
    }

    /**
     * Tocar no card Produto - objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar card \"Produto\"")
    public EscolhaSeuObjetivosTela tocarCardProduto() throws Exception {
        rolarTelaAteFinal(3);
        aguardarCarregamentoElemento(cardProduto);
        salvarEvidencia("'Tocar card Produto'");
        tocarElemento(cardProduto,"Erro ao Tocar con card Produto");
        return this;
    }

}
