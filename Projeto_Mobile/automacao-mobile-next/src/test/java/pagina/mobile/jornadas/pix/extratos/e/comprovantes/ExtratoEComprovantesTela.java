package pagina.mobile.jornadas.pix.extratos.e.comprovantes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.tools.Utilitarios;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ExtratoEComprovantesTela extends PaginaBase {

    public ExtratoEComprovantesTela(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "icon-cell-collapsed")
    @AndroidFindBy(id = "br.com.bradesco.next:id/arrow_expand_imageview")
    private MobileElement setaExpandirTransacao;

    private By elementoValorTransacao;

    /**
     * Expandir transação pelo valor em 'Extrato e Comprovantes'
     *
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Expandir transação pelo valor ")
    public ExtratoEComprovantesTela expandirTransacaoPeloValor(String valor) throws Exception {
        if (valor.contains(",")) {
            valor = valor.replace(",", "");
        }
        valor = Utilitarios.reformatarValorMonetario(valor);
        String locator;
        if (ios) {
            locator = "//*[contains(@name,'" + valor + "')]";
        } else {
            locator = "//*[contains(@text,'" + valor + "')]";
        }
        String mensagem = "Não foi possivel expandir a transação";
        if (ios) {
            elementoValorTransacao = By.xpath(locator);
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elementoValorTransacao, "Não foi possível encontrar a transação com o valor: " + valor);
            tocarElemento(elementoValorTransacao, mensagem);
        } else {
            tocarElementoOculto(locator, mensagem);
        }
        salvarEvidencia("Transação Expandida");
        return this;
    }
}
