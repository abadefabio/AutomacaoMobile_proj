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
    @iOSXCUITFindBy(accessibility = "Movimentações")
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
     * Tocar no botão 'Resgatar'
     *
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Resgatar'")
    public DetalhesPoupancaTela tocarBotaoResgatar() throws Exception {
        aguardarElementoHabilitado(botaoResgatar);
        salvarEvidencia("Tocar no botão 'Resgatar'");
        tocarElemento(botaoResgatar, "Nao foi possível tocar no botão 'Resgatar'");
        return this;
    }

    /**
     * Tocar em 'Movimentações'
     *
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Tocar em 'Movimentações'")
    public DetalhesPoupancaTela tocarEmMovimentacoes() throws Exception {
        aguardarCarregamentoElemento(botaoAplicarNaPoupanca);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(movimentacoes, "Não foi possível encontrar 'Movimentações'");
        tocarElemento(movimentacoes, "Nao foi possível tocar em Movimentações'");
        salvarEvidencia("Tocar em 'Movimentações'");
        return this;
    }

    /**
     * Validar presença da movimentação (Aplicação ou Resgate) no dia
     *
     * @param valor Valor a ser validado
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Validar movimentação na Poupança")
    public DetalhesPoupancaTela validarMovimentacoes(String valor) throws Exception {
        By localizador = android ?
                new By.ByXPath("//*[@resource-id=\"br.com.bradesco.next:id/ctv_amount_investment_list\" and contains(@text, \""+valor+"\")]") :
                new By.ByXPath("//*[@name='Movimentações']/following::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'"+valor+"')]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "Não foi possível localizar o valor '"+valor+"'");
        validarCondicaoBooleana(verificarPresencaElemento(localizador), MetodoComparacaoBooleano.VERDADEIRO, "Falha ao validar movimentação na Poupança");
        salvarEvidencia("Validada movimentação na Poupança");
        return this;
    }

    /**
     * Validar presença da tela do tutorial de primeira aplicação na Poupança e deslizar
     *
     * @param tituloTela  Texto a ser apresnetado como título da tela de tutorial
     * @param mensagem    Mensagem a ser apresentada na tela de tutorial
     * @param deslizaTela Booleano (true/false) que valida se a tela do tutorial será deslizada ou não
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Validar presença da tela do tutorial de primeira aplicação na Poupança e deslizar")
    public DetalhesPoupancaTela validarPresencaEDeslizarTelaTutorial(String tituloTela, String mensagem, boolean deslizaTela) throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(tituloTela, mensagem), MetodoComparacaoBooleano.VERDADEIRO,"Título 'POUPANÇA' e/ou mensagem 'Detalhes do Produto' não estão presente na tela!");
        salvarEvidencia("Validar presença da tela do tutorial de primeira aplicação na Poupança");
        if (deslizaTela) {
            deslizar(Direcao.DIREITA, 90, 25);
        }
        return this;
    }

    /**
     * Tocar no botão 'Aplicar na poupança'
     *
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Aplicar na poupança'")
    public DetalhesPoupancaTela tocarBotaoAplicarNaPoupanca() throws Exception {
        aguardarElementoHabilitado(botaoAplicarNaPoupanca);
        salvarEvidencia("Tocar no botão 'Aplicar na poupança'");
        tocarElemento(botaoAplicarNaPoupanca, "Não foi possível tocar no botão 'Aplicar na poupança'");
        return this;
    }

    /**
     * Tocar no botão 'Voltar' (<)
     *
     * @return DetalhesPoupancaTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Voltar' (<)")
    public DetalhesPoupancaTela tocarBotaoVoltar() throws Exception {
        aguardarElementoHabilitado(botaoVoltar);
        salvarEvidencia("Tocar no botão 'Voltar' (<)");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar' (<)");
        return this;
    }
}
