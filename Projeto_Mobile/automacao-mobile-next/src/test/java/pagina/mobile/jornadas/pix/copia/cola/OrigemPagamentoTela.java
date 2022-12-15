package pagina.mobile.jornadas.pix.copia.cola;

import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class OrigemPagamentoTela extends PaginaBase {

    public OrigemPagamentoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no botão 'Origem Pagamento'
     *
     * @param origemPagamento
     * @return PixTela
     */
    @Step("Tocar no botão 'Origem do Pagamento'")
    public OrigemPagamentoTela tocarBotaoOrigemPagamento(String origemPagamento)
            throws NextException {
        By botaoOrigemPagamento;
        if (android) {
            botaoOrigemPagamento = By.xpath("//*[@text='"+origemPagamento+"']");
        } else {
            botaoOrigemPagamento = By.xpath("//*[contains(@name,'"+origemPagamento+"')]");
        }
        aguardarCarregamentoElemento(botaoOrigemPagamento);
        salvarEvidencia("Selecionar 'Origem do Pagamento': " + origemPagamento);
        tocarElemento(botaoOrigemPagamento, "Não foi possível tocar na 'Origem do Pagamento': " + origemPagamento);
        return this;
    }
}
