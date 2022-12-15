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

    @AndroidFindBy(xpath = "//*[contains(@text,'DETALHES DA TRANSAÇÃO')]/..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='DETALHES DA TRANSAÇÃO']")
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
     * Função para contruir o xpath baseado no valor do pix
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
        tocarElemento(botaoPeriodoExtrato, "Não foi possível tocar no botão '" + valorEsperado + "'");
        salvarEvidencia("Tocar o botão '" + valorEsperado + "'");
        return this;
    }

    /**
     * Selecionar a primeira transação recebida pix
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Selecionar a primeira transação recebida pix")
    public ExtratosEComprovantesTela selecionarTransacaoRecebidaPix()  throws Exception {
        if (!verificarPresencaElemento(botaoPrimeiraTransacaoRecebidaPix)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPrimeiraTransacaoRecebidaPix, "Não foi possível encontrar a transação recebida");
        }
        aguardarCarregamentoElemento(botaoPrimeiraTransacaoRecebidaPix);
        salvarEvidencia("Tocar botão da transação recebida");
        tocarElemento(botaoPrimeiraTransacaoRecebidaPix, "Não foi possível tocar na transação recebida");
        return this;
    }

    /**
     * Validar detalhes da transação
     *
     * @return ExtratosEComprovantesTela
     */
    @Step("Validar detalhes da transação")
    public ExtratosEComprovantesTela validarDetalhesDaTransacao() {
        validarCondicaoBooleana(verificarPresencaElemento(labelDetalhesDaTransacao), MetodoComparacaoBooleano.VERDADEIRO,"'Detalhes da transação' não estão presente na tela!");
        salvarEvidencia("Validado detalhes da transação");
        return this;
    }

    /**
     * Tocar no botão 'Voltar ao Pix'
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Voltar ao Pix'")
    public ExtratosEComprovantesTela tocarBotaoVoltarAoPix()  throws Exception {
        if (!verificarPresencaElemento(botaoVoltarAoPix)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVoltarAoPix, "Não foi possível encontrar o botão 'Voltar ao Pix'");
        }
        tocarElemento(botaoVoltarAoPix, "Não foi possível tocar no botão 'Voltar ao Pix'");
        salvarEvidencia("Tocar o botão 'Voltar ao Pix'");
        return this;
    }

    /**
     * Selecionar a primeira transação enviada pix
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Selecionar a primeira transação enviada pix")
    public ExtratosEComprovantesTela selecionarTransacaoEnviadaPix()  throws Exception {
        if (!verificarPresencaElemento(botaoPrimeiraTransacaoEnviadaPix)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPrimeiraTransacaoEnviadaPix, "Não foi possível encontrar a transação enviada");
        }
        tocarElemento(botaoPrimeiraTransacaoEnviadaPix, "Não foi possível tocar na transação enviada");
        salvarEvidencia("Tocar o botão da transação enviada");
        return this;
    }

    /**
     * Tocar botão 'Ver Comprovante'
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Tocar botão 'Ver Comprovante'")
    public ExtratosEComprovantesTela tocarBotaoVerComprovante()  throws Exception {
        if (!verificarPresencaElemento(botaoVerComprovante)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerComprovante, "Não foi possível encontrar o botão 'Ver Comprovante'");
        }
        tocarElemento(botaoVerComprovante, "Não foi possível tocar no botão 'Ver Comprovante'");
        salvarEvidencia("Tocar o botão 'Ver Comprovante'");
        return this;
    }

    /**
     * Validar comprovante transação enviada pix
     *
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Validar comprovante transação enviada pix")
    public ExtratosEComprovantesTela validarComprovanteTransacaoEnviadaPix() throws Exception {
        aguardarCarregamentoElemento(pdfComprovante);
        validarCondicaoBooleana(verificarPresencaElemento(pdfComprovante), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a presença do comprovante");
        salvarEvidencia("Valido comprovante transação enviada pix");
        return this;
    }

    /**
     * Expandir transação pelo valor em 'Extrato e Comprovantes'
     *
     * @param valor Valor a ser buscado no extrato
     * @return ExtratosEComprovantesTela
     * @throws Exception
     */
    @Step("Expandir transação pelo valor ")
    public ExtratosEComprovantesTela expandirTransacaoPeloValor(String valor) throws Exception {
        valor = Utilitarios.reformatarValorMonetario(valor);
        if(!aguardarElementoHabilitado(elementoValorTransacao(valor))) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elementoValorTransacao(valor), "Não foi possível encontrar a transação com o valor: " + valor);
        }
        tocarElemento(elementoValorTransacao(valor), "Não foi possivel expandir a transação com valor " + valor);
        salvarEvidencia("Transação Expandida");
        return this;
    }
}
