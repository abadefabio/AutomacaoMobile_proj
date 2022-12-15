package pagina.mobile.jornadas.credito;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.credito.Mensagem;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class AumentarLimiteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_next_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"AUMENTAR LIMITE\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"AUMENTAR LIMITE\"]")
    private MobileElement tituloAumentarLimite;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_increase_limit_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"R$\")]")
    private MobileElement valorLimite;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_increase_limit_confirm")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CONFIRMAR\"])[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONFIRMAR\"]")
    private MobileElement botaoConfirmar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_limit_accept")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ATIVAR NOVO LIMITE\"]")
    private MobileElement botaoAtivarNovoLimite;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@content-desc,\"Conseguimos aumentar parte do valor\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Conseguimos aumentar parte do valor\")]")
    private MobileElement textolabelDaAprovacaoDoLimite;

    public AumentarLimiteTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Validar a exibição da Tela 'Aumentar Limite'
     *
     * @return
     */
    @Step("validar a exibição da Tela 'Aumentar Limite'")
    public AumentarLimiteTela validarExibicaoTelaAumentarLimite() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloAumentarLimite),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar a exibição da Tela 'Aumentar Limite'");
        salvarEvidencia("Validou a exibição da Tela 'Aumentar Limite'");
        return this;
    }

    /**
     * Validar o aumento do limite
     *
     * @param valor
     * @return
     */
    @Step("Validar o aumento do limite")
    public AumentarLimiteTela validarAumentoDeLimite(String valor) {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagem.LIMITE_APROVADO, valor),
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possivel localizar na tela a mensagem: " + Mensagem.LIMITE_APROVADO + "e/ou o valor: " + valor);
        salvarEvidencia("Aumento de limite validado");
        return this;
    }

    /**
     * Digitar o 'Valor do Limite'
     *
     * @param valor
     * @return
     * @throws NextException
     */
    @Step("Digitar o 'Valor do Limite'")
    public AumentarLimiteTela digitarValorLimite(String valor) throws NextException {
        escreverTexto(valorLimite, valor, "Erro ao digitar o valor: '" + valor + "' no campo 'Valor do Limite'");
        salvarEvidencia("Digitou o valor: '" + valor + "' no campo 'Valor do Limite'");
        return this;
    }

    /**
     * tocar no botão 'Confirmar'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Confirmar'")
    public AumentarLimiteTela tocarBotaoConfirmar() throws NextException {
        salvarEvidencia("Tocar no botão 'Confirmar'");
        tocarElemento(botaoConfirmar, "Erro ao tocar no botão 'Confirmar'");
        return this;
    }

    /**
     * Tocar no botão 'Ativar Novo Limite'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Ativar Novo Limite'")
    public AumentarLimiteTela tocarBotaoAtivarNovoLimite() throws NextException, InterruptedException {
        salvarEvidencia("Tocar no botão 'Ativar Novo Limite'");
        tocarElemento(botaoAtivarNovoLimite, "Erro ao tocar no botão 'Ativar Novo Limite'");
        return this;
    }


}
