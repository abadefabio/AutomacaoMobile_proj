package pagina.mobile.jornadas.investimentos.meus;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DetalhesPoupancaTela extends PaginaBase {

    public DetalhesPoupancaTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_rescue_value")
    @AndroidFindBy(xpath = "//*[@text='Resgatar']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Resgatar valor'])[1]")
    private MobileElement botaoResgatar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_container_investment_transactions")
    @iOSXCUITFindBy(accessibility = "Movimenta��es")
    private MobileElement movimentacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_apply_investment")
    @iOSXCUITFindBy(accessibility = "Aplicar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok, entendi!']")
    private MobileElement botaoAplicarNaPoupanca;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    /**
     * Tocar no bot�o 'Resgatar'
     *
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Resgatar'")
    public DetalhesPoupancaTela tocarBotaoResgatar() throws Exception {
        aguardarElementoHabilitado(botaoResgatar);
        salvarEvidencia("Tocar no bot�o 'Resgatar'");
        tocarElemento(botaoResgatar, "Nao foi poss�vel tocar no bot�o 'Resgatar'");
        return this;
    }

    /**
     * Tocar em 'Movimenta��es'
     *
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Tocar em 'Movimenta��es'")
    public DetalhesPoupancaTela tocarEmMovimentacoes() throws Exception {
        aguardarCarregamentoElemento(botaoAplicarNaPoupanca);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(movimentacoes, "N�o foi poss�vel encontrar 'Movimenta��es'");
        tocarElemento(movimentacoes, "Nao foi poss�vel tocar em Movimenta��es'");
        salvarEvidencia("Tocar em 'Movimenta��es'");
        return this;
    }

    /**
     * Validar presen�a da movimenta��o (Aplica��o ou Resgate) no dia
     *
     * @param valor Valor a ser validado
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Validar movimenta��o na Poupan�a")
    public DetalhesPoupancaTela validarMovimentacoes(String valor) throws Exception {
        By localizador = android ?
                new By.ByXPath("//*[@resource-id=\"br.com.bradesco.next:id/ctv_amount_investment_list\" and contains(@text, \""+valor+"\")]") :
                new By.ByXPath("//*[@name='Movimenta��es']/following::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'"+valor+"')]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "N�o foi poss�vel localizar o valor '"+valor+"'");
        validarCondicaoBooleana(verificarPresencaElemento(localizador), MetodoComparacaoBooleano.VERDADEIRO, "Falha ao validar movimenta��o na Poupan�a");
        salvarEvidencia("Validada movimenta��o na Poupan�a");
        return this;
    }

    /**
     * Validar presen�a da tela do tutorial de primeira aplica��o na Poupan�a e deslizar
     *
     * @param tituloTela  Texto a ser apresnetado como t�tulo da tela de tutorial
     * @param mensagem    Mensagem a ser apresentada na tela de tutorial
     * @param deslizaTela Booleano (true/false) que valida se a tela do tutorial ser� deslizada ou n�o
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Validar presen�a da tela do tutorial de primeira aplica��o na Poupan�a e deslizar")
    public DetalhesPoupancaTela validarPresencaEDeslizarTelaTutorial(String tituloTela, String mensagem, boolean deslizaTela) throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(tituloTela, mensagem), MetodoComparacaoBooleano.VERDADEIRO,"T�tulo 'POUPAN�A' e/ou mensagem 'Detalhes do Produto' n�o est�o presente na tela!");
        salvarEvidencia("Validar presen�a da tela do tutorial de primeira aplica��o na Poupan�a");
        if (deslizaTela) {
            deslizar(Direcao.DIREITA, 90, 25);
        }
        return this;
    }

    /**
     * Tocar no bot�o 'Aplicar na poupan�a'
     *
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Aplicar na poupan�a'")
    public DetalhesPoupancaTela tocarBotaoAplicarNaPoupanca() throws Exception {
        aguardarElementoHabilitado(botaoAplicarNaPoupanca);
        salvarEvidencia("Tocar no bot�o 'Aplicar na poupan�a'");
        tocarElemento(botaoAplicarNaPoupanca, "N�o foi poss�vel tocar no bot�o 'Aplicar na poupan�a'");
        return this;
    }

    /**
     * Tocar no bot�o 'Voltar' (<)
     *
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Voltar' (<)")
    public DetalhesPoupancaTela tocarBotaoVoltar() throws Exception {
        aguardarElementoHabilitado(botaoVoltar);
        salvarEvidencia("Tocar no bot�o 'Voltar' (<)");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar' (<)");
        return this;
    }
}
