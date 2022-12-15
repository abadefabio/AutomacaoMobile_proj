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
    @iOSXCUITFindBy(accessibility = "Digite o valor que você quer sacar")
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
    @iOSXCUITFindBy(accessibility = "Informações")
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
            tocarElemento(textoSaque, "Nao foi possível tocar elemento texto saque");
            tocarBotaoApagarTexto();
            escreverTexto(textoSaque, valor, "Nao foi possível Digitar valor do Saque.");
            tocarTelaParaEsconderTecladoNoIos();
        } else {
            apagarCampoTexto(textoSaque, "Não foi possível apagar o valor do campo saque.");
            escreverTexto(textoSaque, valor, "Não foi possível Digitar valor do Saque.");
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
     * Validar mensagem de exceção de limite mínimo de saque
     *
     * @throws Exception
     */
    @Step("Validar Mensagem de erro valor minimo de saque")
    public ValorSaqueTela validarMensagemValorMinSaq() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(mensagemValorLimSaq);
            compararElementoTexto(mensagemValorLimSaq, DepositosSaques.MENSAGEM_SAQUE_VALOR_MINIMO, MetodoComparacao.CONTEM);
            salvarEvidencia("Mensagem de exceção de valor mínimo de saque validado");
            tocarElemento(textoSaque, "Não foi possível tocar elemento texto saque");
            tocarCoordenadaProporcional(90, 46); //toca no botão para apagar texto
        } else {
            compararElementoTexto(mensagemValorLimSaq, DepositosSaques.MENSAGEM_SAQUE_VALOR_MINIMO, MetodoComparacao.CONTEM);
            salvarEvidencia("Mensagem de exceção de valor mínimo de saque validado");
            tocarElemento(iconeApagarCampoValor, "Não foi possível apagar campo Valor");
        }
        return this;
    }

    /**
     * Validar mensagem de exceção de valor máximo de saque
     *
     * @throws Exception
     */
    @Step("Validar Mensagem de erro valor minimo de saque")
    public ValorSaqueTela validarMensagemValorMaxSaq() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(mensagemValorLimSaq);
            compararElementoTexto(mensagemValorLimSaq, DepositosSaques.MENSAGEM_SAQUE_VALOR_MAXIMO, MetodoComparacao.CONTEM);
            salvarEvidencia("Mensagem de exceção de valor máximo de saque validado");
            tocarElemento(textoSaque, "Não foi possível tocar elemento texto saque");
            tocarCoordenadaProporcional(90, 40); //toca no botão para apagar texto
        } else {
            compararElementoTexto(mensagemValorLimSaq, DepositosSaques.MENSAGEM_SAQUE_VALOR_MAXIMO, MetodoComparacao.CONTEM);
            salvarEvidencia("Mensagem de exceção de valor máximo de saque validado");
            tocarElemento(iconeApagarCampoValor, "Não foi possível apagar campo Valor");
        }
        return this;
    }

    /**
     * Verifica se o botão continuar da tela de 'Inserir valor' está habilitado
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar botao habilitado")
    public ValorSaqueTela verificarBotaoContinuarTelaValorHabilitado() throws Exception {
        aguardarCarregamentoElemento(botaoContinuarTelaAgendamento);
        validarAtributoBooleano(botaoContinuarTelaAgendamento, "enabled", "true", "Verificar Botão Continuar Habilitado");
        salvarEvidencia("Verificar Botão Continuar Habilitado");
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
            tocarElemento(botaoConfirmar, "Erro ao tocar no botão Confirmar");
        } else {
            tocarElemento(botaoContinuarTelaAgendamento, "Não foi possível Tocar  em Continuar");
        }
        return this;
    }

    /**
     * Tocar em 'Informação'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao \"Informacao\"")
    public ValorSaqueTela tocarBotaoInformacao() throws Exception {
        aguardarCarregamentoElemento(botaoInformacao);
        tocarElemento(botaoInformacao, "Não foi possível tocar em Informação");
        salvarEvidencia("Tocar no botão 'Informação'");
        return this;
    }
}
