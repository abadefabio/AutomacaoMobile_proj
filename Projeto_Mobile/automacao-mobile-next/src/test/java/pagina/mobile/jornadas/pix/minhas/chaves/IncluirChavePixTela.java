package pagina.mobile.jornadas.pix.minhas.chaves;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class IncluirChavePixTela extends PaginaBase {

    @AndroidFindBy(xpath = "//*[contains(@text,'ESCOLHER ESTA CHAVE')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'ESCOLHER ESTA CHAVE')]")
    private MobileElement botaoEscolherEstaChave;

    @AndroidFindBy(xpath = "//*[contains(@text,'CONTINUAR')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CONTINUAR')]")
    private MobileElement botaoContinuar;

    public IncluirChavePixTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Selecionar chave pix
     *
     * @param tipoChave Chave a ser selecionada
     * @return IncluirChavesPixTela
     * @throws NextException
     */
    @Step("Selecionar chave PIX")
    public IncluirChavePixTela selecionarChavePix(String tipoChave) throws NextException {
        aguardarElementoHabilitado(botaoEscolherEstaChave);
        By radioChavePix;
        if (android) {
            radioChavePix = new ByXPath("//*[@text='"+tipoChave+"']");
        } else {
            radioChavePix = new ByXPath("//XCUIElementTypeButton[@name='"+tipoChave+"']");
        }
        salvarEvidencia("Selecionar chave Pix: " + tipoChave);
        tocarElemento(radioChavePix, "Não foi possível selecionar a chave " + tipoChave);
        return this;
    }

    /**
     * Tocar no botão 'Escolher esta Chave'
     *
     * @return IncluirChavesPixTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Escolher esta chave'")
    public IncluirChavePixTela tocarBotaoEscolherEstaChave() throws NextException {
        aguardarCarregamentoElemento(botaoEscolherEstaChave);
        salvarEvidencia("Tocar no botão 'Escolher esta Chave'");
        tocarElemento(botaoEscolherEstaChave, "Não foi possível tocar no botão 'Escolher esta Chave'");
        return this;
    }

    /**
     * Tocar no botão 'Origem Pagamento'
     *
     * @param origemPagamento
     * @return IncluirChavesPixTela
     */
    @Step("Tocar no botão 'Origem do Pagamento'")
    public IncluirChavePixTela tocarBotaoOrigemPagamento(String origemPagamento) throws NextException {
        By botaoOrigemPagamento;
        if (android) {
            botaoOrigemPagamento = By.xpath("//*[@text='"+origemPagamento+"']");
        } else {
            botaoOrigemPagamento = By.xpath("//*[@name='"+origemPagamento+"']");
        }
        aguardarElementoHabilitado(botaoOrigemPagamento);
        salvarEvidencia("Selecionar 'Origem do Pagamento': " + origemPagamento);
        tocarElemento(botaoOrigemPagamento, "Não foi possível tocar na 'Origem do Pagamento': " + origemPagamento);
        return this;
    }

    /**
     * Tocar no botão 'Continuar'
     *
     * @return IncluirChavesPixTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Continuar'")
    public IncluirChavePixTela tocarBotaoContinuar() throws NextException {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }
}
