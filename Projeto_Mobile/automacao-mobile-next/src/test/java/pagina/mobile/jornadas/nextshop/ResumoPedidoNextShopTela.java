package pagina.mobile.jornadas.nextshop;

import base.mobile.nextShop.PaginaBaseBuscaNextShop;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ResumoPedidoNextShopTela extends PaginaBaseBuscaNextShop {

    public ResumoPedidoNextShopTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"CVV\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,'CVV')]")
    private MobileElement inserirCvv;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'CONCLUIR PEDIDO')]")
    @iOSXCUITFindBy(accessibility = "CONCLUIR PEDIDO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONCLUIR PEDIDO\"]")
    private MobileElement botaoConcluirPedido;

    /**
     * Preencher campo CVV
     *
     * @return ResumoPedidoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"CVV\"")
    public ResumoPedidoNextShopTela preencherCvv(String cvv) throws Exception {
        rolarTelaAteFinal();
        escreverTexto(inserirCvv, cvv, "Não foi possível escrever o CVV no campo");
        esconderTeclado();
        salvarEvidencia("Preencher campo 'CVV' com: " + cvv);
        return this;
    }

    /**
     * Realiza o toque no botão Concluir Pedido.
     *
     * @return ResumoPedidoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Concluir Pedido\"")
    public ResumoPedidoNextShopTela tocarBotaoConcluirPedido() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão 'Concluir Pedido'");
        tocarElemento(botaoConcluirPedido, "Houve um erro ao executar a acao de tocar o elemento botao \"Concluir Pedido\"");
        return this;
    }

}

