package pagina.mobile.jornadas.pix.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.pix.Pix;
import constantes.pix.TipoConta;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class OrigemPagamentoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='Conta-corrente']")
    @iOSXCUITFindBy(accessibility = "Conta-corrente")
    @iOSXCUITFindBy(xpath = "//*[@name='Conta-corrente']")
    private MobileElement botaoContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='Conta-poupança']")
    @iOSXCUITFindBy(accessibility = "Conta-poupança")
    @iOSXCUITFindBy(xpath = "//*[@name='Conta-poupança']")
    private MobileElement botaoContaPoupanca;

    public OrigemPagamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela 'Origem do Pagamento'
     */
    @Step("Validar tela 'Origem do Pagamento'")
    public OrigemPagamentoTela validarOrigemDoPagementoTela() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Pix.ORIGEM_DO_PAGAMENTO_TELA), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar a tela 'Origem do Pagamento'");
        salvarEvidencia("Validada a tela 'Origem do Pagamento'");
        return this;
    }

    /**
     * Selecionar 'Conta-Corrente'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar 'Conta-Corrente'")
    public OrigemPagamentoTela selecionarContaCorrente() throws Exception {
        salvarEvidencia("Selecionado 'Conta-Corrente'");
        tocarElemento(botaoContaCorrente, "Não foi possível selecionar 'Conta-Corrente'");
        return this;
    }

    /**
     * Selecionar 'Conta-Poupança'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar 'Conta-Poupança'")
    public OrigemPagamentoTela selecionarContaPoupanca() throws Exception {
        salvarEvidencia("Selecionado 'Conta-Poupança'");
        tocarElemento(botaoContaPoupanca, "Não foi possível selecionar 'Conta-Poupança'");
        return this;
    }

    /**
     * Método que fará a seleção da 'Origem do Pagamento'
     * @param origemPagamento de onde saíra o dinheiro para a transação
     * @return OrigemPagamentoTela
     * @throws NextException
     */
    @Step("Selecionar a 'Origem do Pagamento'")
    public OrigemPagamentoTela selecionarOrigemPagamento(TipoConta origemPagamento) throws NextException {
        By localizador = android ? new By.ByXPath("//*[@text='" + origemPagamento + "']") :
                new By.ByXPath("//*[contains(@name, '"+ origemPagamento +"')]");
        aguardarCarregamentoElemento(localizador);
        salvarEvidencia("Tocar na chave '" + origemPagamento + "'.");
        tocarElemento(localizador, "Não foi possível tocar na chave '" + origemPagamento + "'.");
        return this;
    }
}
