package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.depositos.saques.DepositosSaques;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ValorSaqueTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_qnt")
    @iOSXCUITFindBy(accessibility = "Digite o valor que voc� quer sacar")
    private MobileElement textoSaque;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value_available")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeStaticText\" and name contains \"Ops.\"")
    private MobileElement mensagemValorLimSaq;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_clear")
    private MobileElement iconeApagarCampoValor;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement botaoContinuarTelaAgendamento;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_info")
    @iOSXCUITFindBy(accessibility = "Informa��es")
    private MobileElement botaoInformacao;

    public ValorSaqueTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Digitar valor do saque
     *
     * @param valor via Json
     * @return
     * @throws Exception
     */
    @Step("Digitar valor do Saque")
    public ValorSaqueTela escreverValorSaque(String valor) throws Exception {
        if (android) {
            tocarElemento(textoSaque, "Nao foi poss�vel tocar elemento texto saque");
            tocarBotaoApagarTexto();
            escreverTexto(textoSaque, valor, "Nao foi poss�vel Digitar valor do Saque.");
            tocarTelaParaEsconderTecladoNoIos();
        } else {
            apagarCampoTexto(textoSaque, "N�o foi poss�vel apagar o valor do campo saque.");
            escreverTexto(textoSaque, valor, "N�o foi poss�vel Digitar valor do Saque.");
        }
        salvarEvidencia("Digitar valor do Saque");
        return this;
    }

    private void tocarBotaoApagarTexto() {
        tocarCoordenadaProporcional(90, 46);
    }

    private void tocarTelaParaEsconderTecladoNoIos() {
        tocarCoordenadaProporcional(50, 30);
    }

    /**
     * Validar mensagem de exce��o de limite m�nimo de saque
     *
     * @throws Exception
     */
    @Step("Validar Mensagem de erro valor minimo de saque")
    public ValorSaqueTela validarMensagemValorMinSaq() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(mensagemValorLimSaq);
            compararElementoTexto(mensagemValorLimSaq, DepositosSaques.MENSAGEM_SAQUE_VALOR_MINIMO, MetodoComparacao.CONTEM);
            salvarEvidencia("Mensagem de exce��o de valor m�nimo de saque validado");
            tocarElemento(textoSaque, "N�o foi poss�vel tocar elemento texto saque");
            tocarCoordenadaProporcional(90, 46); //toca no bot�o para apagar texto
        } else {
            compararElementoTexto(mensagemValorLimSaq, DepositosSaques.MENSAGEM_SAQUE_VALOR_MINIMO, MetodoComparacao.CONTEM);
            salvarEvidencia("Mensagem de exce��o de valor m�nimo de saque validado");
            tocarElemento(iconeApagarCampoValor, "N�o foi poss�vel apagar campo Valor");
        }
        return this;
    }

    /**
     * Validar mensagem de exce��o de valor m�ximo de saque
     *
     * @throws Exception
     */
    @Step("Validar Mensagem de erro valor minimo de saque")
    public ValorSaqueTela validarMensagemValorMaxSaq() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(mensagemValorLimSaq);
            compararElementoTexto(mensagemValorLimSaq, DepositosSaques.MENSAGEM_SAQUE_VALOR_MAXIMO, MetodoComparacao.CONTEM);
            salvarEvidencia("Mensagem de exce��o de valor m�ximo de saque validado");
            tocarElemento(textoSaque, "N�o foi poss�vel tocar elemento texto saque");
            tocarCoordenadaProporcional(90, 40); //toca no bot�o para apagar texto
        } else {
            compararElementoTexto(mensagemValorLimSaq, DepositosSaques.MENSAGEM_SAQUE_VALOR_MAXIMO, MetodoComparacao.CONTEM);
            salvarEvidencia("Mensagem de exce��o de valor m�ximo de saque validado");
            tocarElemento(iconeApagarCampoValor, "N�o foi poss�vel apagar campo Valor");
        }
        return this;
    }

    /**
     * Verifica se o bot�o continuar da tela de 'Inserir valor' est� habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar botao habilitado")
    public ValorSaqueTela verificarBotaoContinuarTelaValorHabilitado() throws Exception {
        aguardarCarregamentoElemento(botaoContinuarTelaAgendamento);
        validarAtributoBooleano(botaoContinuarTelaAgendamento, "enabled", "true", "Verificar Bot�o Continuar Habilitado");
        salvarEvidencia("Verificar Bot�o Continuar Habilitado");
        return this;
    }

    /**
     * Tocar em Continuar Tela Agendamento
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao \"Continuar\"")
    public ValorSaqueTela tocarBotaoContinuarAgendamento() throws Exception {
        boolean botaoContinuarTelaAgendamentoPresente = aguardarCarregamentoElemento(botaoContinuarTelaAgendamento);
        salvarEvidencia("Tocar em 'continuar'");
        if (!botaoContinuarTelaAgendamentoPresente) {
            tocarElemento(botaoConfirmar, "Erro ao tocar no bot�o Confirmar");
        } else {
            tocarElemento(botaoContinuarTelaAgendamento, "N�o foi poss�vel Tocar  em Continuar");
        }
        return this;
    }

    /**
     * Tocar em 'Informa��o'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao \"Informacao\"")
    public ValorSaqueTela tocarBotaoInformacao() throws Exception {
        aguardarCarregamentoElemento(botaoInformacao);
        tocarElemento(botaoInformacao, "N�o foi poss�vel tocar em Informa��o");
        salvarEvidencia("Tocar no bot�o 'Informa��o'");
        return this;
    }
}
