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
    @AndroidFindBy(xpath = "//*[@text='Conta-poupan�a']")
    @iOSXCUITFindBy(accessibility = "Conta-poupan�a")
    @iOSXCUITFindBy(xpath = "//*[@name='Conta-poupan�a']")
    private MobileElement botaoContaPoupanca;

    public OrigemPagamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela 'Origem do Pagamento'
     */
    @Step("Validar tela 'Origem do Pagamento'")
    public OrigemPagamentoTela validarOrigemDoPagementoTela() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Pix.ORIGEM_DO_PAGAMENTO_TELA), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar a tela 'Origem do Pagamento'");
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
        tocarElemento(botaoContaCorrente, "N�o foi poss�vel selecionar 'Conta-Corrente'");
        return this;
    }

    /**
     * Selecionar 'Conta-Poupan�a'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar 'Conta-Poupan�a'")
    public OrigemPagamentoTela selecionarContaPoupanca() throws Exception {
        salvarEvidencia("Selecionado 'Conta-Poupan�a'");
        tocarElemento(botaoContaPoupanca, "N�o foi poss�vel selecionar 'Conta-Poupan�a'");
        return this;
    }

    /**
     * M�todo que far� a sele��o da 'Origem do Pagamento'
     * @param origemPagamento de onde sa�ra o dinheiro para a transa��o
     * @return OrigemPagamentoTela
     * @throws NextException
     */
    @Step("Selecionar a 'Origem do Pagamento'")
    public OrigemPagamentoTela selecionarOrigemPagamento(TipoConta origemPagamento) throws NextException {
        By localizador = android ? new By.ByXPath("//*[@text='" + origemPagamento + "']") :
                new By.ByXPath("//*[contains(@name, '"+ origemPagamento +"')]");
        aguardarCarregamentoElemento(localizador);
        salvarEvidencia("Tocar na chave '" + origemPagamento + "'.");
        tocarElemento(localizador, "N�o foi poss�vel tocar na chave '" + origemPagamento + "'.");
        return this;
    }
}
