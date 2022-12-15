package pagina.mobile.jornadas.investimentos.aplicacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InvestimentoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_see_product")
    @iOSXCUITFindBy(xpath = "//*[@name='VER PRODUTO']")
    private MobileElement botaoVerProduto;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_see_receipt")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'VER COMPROVANTE') or contains(@name, 'Ver comprovante')]")
    private MobileElement botaoVerComprovante;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    public InvestimentoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Ver Produto'
     *
     * @return InvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Ver Produto'")
    public InvestimentoTela tocarBotaoVerProduto() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Ver Produto'");
        tocarElemento(botaoVerProduto, "N�o foi poss�vel tocar no bot�o 'Ver Produto'");
        return this;
    }

    /**
     * Tocar no bot�o 'Ver comprovante'
     *
     * @return InvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Ver comprovante'")
    public InvestimentoTela tocarBotaoVerComprovante() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerComprovante, "Erro ao tocar no bot�o 'Ver Comprovante'");
        salvarEvidencia("Tocar no bot�o 'Ver comprovante'");
        tocarElemento(botaoVerComprovante, "N�o foi poss�vel tocar no bot�o 'Ver comprovante'");
        return this;
    }

    /**
     * Tocar no botao 'Fechar' (X)
     *
     * @return InvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Fechar' (X)")
    public InvestimentoTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no botao 'Fechar' (X)");
        tocarElemento(botaoFechar, "Nao foi possivel tocar no bot�o 'Fechar' (X)");
        return this;
    }
}
