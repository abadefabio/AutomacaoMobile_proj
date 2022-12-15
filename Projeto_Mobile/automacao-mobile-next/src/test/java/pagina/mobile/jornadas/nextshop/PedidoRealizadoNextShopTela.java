package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PedidoRealizadoNextShopTela extends PaginaBase {

    public PedidoRealizadoNextShopTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Pedido Concluído\"])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Pedido Concluído\"])[2]")
    private MobileElement textoPedidoConcluido;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"ACOMPANHAR MEUS PEDIDOS\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'ACOMPANHAR MEUS PEDIDOS')]")
    private MobileElement botaoAcompanharMeusPedidos;

    /**
     * Valida a finalização do pedido.
     *
     * @return PedidoRealizadoNextShopTela
     * @throws Exception
     */
    @Step("Verificar tela peidido concluido")
    public PedidoRealizadoNextShopTela validaTelaPedidoConcluido() throws Exception {
        aguardarCarregamentoElemento(textoPedidoConcluido);
        salvarEvidencia("Valida tela pedido concluido");
        return this;
    }

    /**
     * Valida presença botão acompanhar pedido
     *
     * @trows Exception
     */
    @Step("Valida presença botão acompanhar meus pedidos")
    public PedidoRealizadoNextShopTela validaPresencaBotaoAcompanharMeusPedidos() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAcompanharMeusPedidos,"Não foi possível validar a presença do botão Acompanhar Meus Pedidos");
        salvarEvidencia("Validada presença do botão Acompanhar Meus Pedidos");
        return this;
    }
}

