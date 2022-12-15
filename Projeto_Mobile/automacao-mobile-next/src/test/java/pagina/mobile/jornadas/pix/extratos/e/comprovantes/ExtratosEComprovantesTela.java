package pagina.mobile.jornadas.pix.extratos.e.comprovantes;

import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.Utilitarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ExtratosEComprovantesTela extends PaginaBase {
    public ExtratosEComprovantesTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[contains(@text,'R$') and starts-with(@text,'R$')])[1]")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'R$') and starts-with(@name,'R$')])[1]")
    private MobileElement botaoPrimeiraTransacaoRecebidaPix;

    @AndroidFindBy(xpath = "(//*[contains(@text,'R$') and not(starts-with(@text,'R$'))])[1]")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'R$') and not(starts-with(@name,'R$'))])[1]")
    private MobileElement botaoPrimeiraTransacaoEnviadaPix;

    @AndroidFindBy(xpath = "//*[contains(@text,'DETALHES DA TRANSA��O')]/..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='DETALHES DA TRANSA��O']")
    private MobileElement labelDetalhesDaTransacao;

    @AndroidFindBy(xpath = "//*[contains(@text,'VOLTAR AO PIX')]")
    @iOSXCUITFindBy(accessibility = "VOLTAR AO PIX")
    private MobileElement botaoVoltarAoPix;

    @AndroidFindBy(xpath = "//*[contains(@text,'VER COMPROVANTE')]")
    @iOSXCUITFindBy(accessibility = "VER COMPROVANTE")
    private MobileElement botaoVerComprovante;

    @AndroidFindBy(id = "br.com.bradesco.next:id/pdf_view")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeWebView)[1]")
    private MobileElement pdfComprovante;

    @iOSXCUITFindBy(accessibility = "icon-cell-collapsed")
    @AndroidFindBy(id = "br.com.bradesco.next:id/arrow_expand_imageview")
    private MobileElement setaExpandirTransacao;

    /**
     * Fun��o para contruir o xpath baseado no valor do pix
     *
     * @param valor
     * @return By.xpath
     */
    private By elementoValorTransacao(String valor){
        if (ios) {
            return By.xpath("//*[contains(@name,'" + valor + "')]");
        }
        return By.xpath("//*[contains(@text,'" + valor + "')]/ancestor::*[@class=\"android.view.ViewGroup\"][1]");
    }

    /**
     * Selecionar o periodo do extrato
     * @param valorEsperado
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Selecionar o periodo do extrato")
    public ExtratosEComprovantesTela selecionarPeriodoDoExtrato(String valorEsperado) throws Exception {
        By botaoPeriodoExtrato;
        if (ios) {
            botaoPeriodoExtrato = By.xpath("//XCUIElementTypeStaticText[@name='" + valorEsperado + "']/..");
        } else {
            botaoPeriodoExtrato = By.xpath("//*[contains(@text,'" + valorEsperado + "')]");
        }
        aguardarCarregamentoElemento(botaoPeriodoExtrato);
        tocarElemento(botaoPeriodoExtrato, "N�o foi poss�vel tocar no bot�o '" + valorEsperado + "'");
        salvarEvidencia("Tocar o bot�o '" + valorEsperado + "'");
        return this;
    }

    /**
     * Selecionar a primeira transa��o recebida pix
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Selecionar a primeira transa��o recebida pix")
    public ExtratosEComprovantesTela selecionarTransacaoRecebidaPix()  throws Exception {
        if (!verificarPresencaElemento(botaoPrimeiraTransacaoRecebidaPix)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPrimeiraTransacaoRecebidaPix, "N�o foi poss�vel encontrar a transa��o recebida");
        }
        aguardarCarregamentoElemento(botaoPrimeiraTransacaoRecebidaPix);
        salvarEvidencia("Tocar bot�o da transa��o recebida");
        tocarElemento(botaoPrimeiraTransacaoRecebidaPix, "N�o foi poss�vel tocar na transa��o recebida");
        return this;
    }

    /**
     * Validar detalhes da transa��o
     *
     * @return ExtratosEComprovantesTela
     */
    @Step("Validar detalhes da transa��o")
    public ExtratosEComprovantesTela validarDetalhesDaTransacao() {
        validarCondicaoBooleana(verificarPresencaElemento(labelDetalhesDaTransacao), MetodoComparacaoBooleano.VERDADEIRO,"'Detalhes da transa��o' n�o est�o presente na tela!");
        salvarEvidencia("Validado detalhes da transa��o");
        return this;
    }

    /**
     * Tocar no bot�o 'Voltar ao Pix'
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Voltar ao Pix'")
    public ExtratosEComprovantesTela tocarBotaoVoltarAoPix()  throws Exception {
        if (!verificarPresencaElemento(botaoVoltarAoPix)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVoltarAoPix, "N�o foi poss�vel encontrar o bot�o 'Voltar ao Pix'");
        }
        tocarElemento(botaoVoltarAoPix, "N�o foi poss�vel tocar no bot�o 'Voltar ao Pix'");
        salvarEvidencia("Tocar o bot�o 'Voltar ao Pix'");
        return this;
    }

    /**
     * Selecionar a primeira transa��o enviada pix
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Selecionar a primeira transa��o enviada pix")
    public ExtratosEComprovantesTela selecionarTransacaoEnviadaPix()  throws Exception {
        if (!verificarPresencaElemento(botaoPrimeiraTransacaoEnviadaPix)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPrimeiraTransacaoEnviadaPix, "N�o foi poss�vel encontrar a transa��o enviada");
        }
        tocarElemento(botaoPrimeiraTransacaoEnviadaPix, "N�o foi poss�vel tocar na transa��o enviada");
        salvarEvidencia("Tocar o bot�o da transa��o enviada");
        return this;
    }

    /**
     * Tocar bot�o 'Ver Comprovante'
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ver Comprovante'")
    public ExtratosEComprovantesTela tocarBotaoVerComprovante()  throws Exception {
        if (!verificarPresencaElemento(botaoVerComprovante)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerComprovante, "N�o foi poss�vel encontrar o bot�o 'Ver Comprovante'");
        }
        tocarElemento(botaoVerComprovante, "N�o foi poss�vel tocar no bot�o 'Ver Comprovante'");
        salvarEvidencia("Tocar o bot�o 'Ver Comprovante'");
        return this;
    }

    /**
     * Validar comprovante transa��o enviada pix
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Validar comprovante transa��o enviada pix")
    public ExtratosEComprovantesTela validarComprovanteTransacaoEnviadaPix() throws Exception {
        aguardarCarregamentoElemento(pdfComprovante);
        validarCondicaoBooleana(verificarPresencaElemento(pdfComprovante), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a presen�a do comprovante");
        salvarEvidencia("Valido comprovante transa��o enviada pix");
        return this;
    }

    /**
     * Expandir transa��o pelo valor em 'Extrato e Comprovantes'
     *
     * @param valor Valor a ser buscado no extrato
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Expandir transa��o pelo valor ")
    public ExtratosEComprovantesTela expandirTransacaoPeloValor(String valor) throws Exception {
        valor = Utilitarios.reformatarValorMonetario(valor);
        if(!aguardarElementoHabilitado(elementoValorTransacao(valor))) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elementoValorTransacao(valor), "N�o foi poss�vel encontrar a transa��o com o valor: " + valor);
        }
        tocarElemento(elementoValorTransacao(valor), "N�o foi possivel expandir a transa��o com valor " + valor);
        salvarEvidencia("Transa��o Expandida");
        return this;
    }
}
