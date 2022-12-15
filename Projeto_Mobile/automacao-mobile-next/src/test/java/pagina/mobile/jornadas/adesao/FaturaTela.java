package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FaturaTela extends PaginaBase {

    public FaturaTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_confirm")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Confirmar')]")
    @iOSXCUITFindBy(accessibility = "CONFIRMAR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONFIRMAR\"`]")
    private MobileElement botaoConfirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon")
    @AndroidFindBy(xpath = "//*[@resource-id = 'br.com.bradesco.next:id/iv_icon']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"dia de vencimento\")]/preceding-sibling::XCUIElementTypeButton")
    private MobileElement esteiraComDiasDeVencimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon_close")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"fechar\"]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(iOSClassChain = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;


    /**
     * Validar Titulo Tela 'Fatura'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Fatura'")
    public FaturaTela validarTituloTelaFatura() {
        aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.FATURA));
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.FATURA)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Fatura' não está presente na tela!");
        salvarEvidencia("Validada tela 'Fatura'");
        return this;
    }

    /**
     * Escolher dia de Vencimento
     *
     * @return
     * @throws Exception
     */
    @Step("Escolher dia de Vencimento")
    public FaturaTela selecionarDiaDeVencimento(String diaDeVencimento) throws Exception {
        By localizador = android ? new By.ByXPath("//*[contains(@text, '"+ diaDeVencimento +"')]") :
                                   new By.ByXPath("//XCUIElementTypeCell[@name='"+ diaDeVencimento +"']");
        aguardarCarregamentoElemento(localizador);
        tocarElemento(localizador, "Erro ao tentar selecionar '"+ diaDeVencimento +"' de vencimento");
        salvarEvidencia("Selecionado '"+ diaDeVencimento +"' para vencimento");
        return this;
    }

    /**
     * Selecionar 'Forma de Pagamento'
     *
     * @param tipoPagamento - Forma de pagamento
     * @return
     * @throws Exception
     */
    @Step("Selecionar 'Forma de Pagamento'")
    public FaturaTela selecionarFormaDePagamento(String tipoPagamento) throws Exception {
        By localizador = android ? new By.ByXPath("//*[contains(@text, '"+ tipoPagamento +"')]") :
                                   new By.ByXPath("//*[@name= '"+ tipoPagamento +"']/../../*[contains(@value,'Não Selecionado')]");
        aguardarCarregamentoElemento(localizador);
        tocarElemento(localizador, "Erro ao tentar selecionar '"+ tipoPagamento +"' de vencimento");
        salvarEvidencia("Selecionado '"+ tipoPagamento +"' para vencimento");
        return this;
    }

    /**
     * Abrir esteira com 'dias de vencimento' para selecionar
     *
     * @return
     * @throws Exception
     */
    @Step("Abrir esteira com 'dias de vencimento' para selecionar")
    public FaturaTela tocarVparaAbrirEsteiraComDiasDeVencimento() throws Exception {
        aguardarCarregamentoElemento(esteiraComDiasDeVencimento);
        tocarElemento(esteiraComDiasDeVencimento, "Não foi possivel abrir a esteira com os 'dias de vencimento'");
        salvarEvidencia("Esteira com 'dias de vencimento' esta presente na tela");
        return this;
    }

    /**
     * Tocar botão 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Confirmar'")
    public FaturaTela tocarConfirmar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfirmar, "Botão 'Confirmar' não localizado");
        salvarEvidencia("Tocar botão 'Confirmar'");
        tocarElemento(botaoConfirmar, "Erro ao tentar tocar no botao 'Confirmar'");
        return this;
    }

    /**
     * Tocar botão 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Fechar'")
    public FaturaTela tocarFechar() throws Exception {
        salvarEvidencia("Tocar botão 'Fechar'");
        tocarElemento(botaoFechar, "Erro ao tentar tocar no botao 'Fechar'");
        return this;
    }
}
