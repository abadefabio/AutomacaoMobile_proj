package pagina.mobile.jornadas.investimentos.meus;

import org.openqa.selenium.By;
import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.investimentos.CondicaoAplicacaoMensal;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class DetalhesProdutoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_with_draw")
    @iOSXCUITFindBy(accessibility = "Resgatar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Resgatar'`]")
    private MobileElement botaoResgatar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Voltar, Bot�o")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_details")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"DETALHES\"]")
    @iOSXCUITFindBy(accessibility = "Detalhes")
    private MobileElement botaoDetalhes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_apply_investment")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_contribution")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Aplicar\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"APLICAR\")]")
    private MobileElement botaoAplicar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total dispon�vel\"]/../XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/total_available")
    private MobileElement campoTotalDisponivel;

    @AndroidFindBy(xpath = "//*[@text='Detalhes do investimento']")
    @iOSXCUITFindBy(xpath = "//*[@name='Detalhes do investimento']")
    private MobileElement labelDetalhesInvestimento;

    public DetalhesProdutoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no bot�o 'Resgatar'
     *
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Resgatar'")
    public DetalhesProdutoTela tocarBotaoResgatar() throws Exception {
        aguardarElementoHabilitado(botaoAplicar);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoResgatar, "Nao foi poss�vel encontrar o bot�o 'Resgatar'");
        salvarEvidencia("Tocar no bot�o 'Resgatar'");
        tocarElemento(botaoResgatar, "Nao foi poss�vel tocar no bot�o 'Resgatar'");
        return this;
    }

    /**
     * Tocar no bot�o 'Detalhes'
     *
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Detalhes'")
    public DetalhesProdutoTela tocarBotaoDetalhes() throws Exception {
        if (ios) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDetalhes,"Erro ao encontrar o bot�o 'Detalhes'");
        }
        salvarEvidencia("Tocar no bot�o 'Detalhes'");
        tocarElemento(botaoDetalhes, "N�o foi poss�vel tocar no bot�o 'Detalhes'");
        return this;
    }

    /**
     * Tocar no bot�o 'Voltar'
     *
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Voltar'")
    public DetalhesProdutoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "Nao foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Tocar no bot�o 'Editar' aplica��o agendada
     *
     * @param valor Valor da aplica��o a ser editada
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Editar' aplica��o agendada")
    public DetalhesProdutoTela tocarBotaoEditarAplicacaoAgendada(String valor) throws Exception {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elementoBotaoEditarAplicacaoAgendada(valor),"N�o foi poss�vel encontrar o bot�o 'Editar' aplica��o agendada com valor R$" + valorFormatado);
        salvarEvidencia("Tocar no bot�o 'Editar' aplica��o agendada com valor R$ " + valorFormatado);
        tocarElemento(elementoBotaoEditarAplicacaoAgendada(valor), "N�o foi poss�vel tocar no bot�o 'Editar' aplica��o agendada com valor R$ " + valorFormatado);
        return this;
    }

    /**
     * Tocar no bot�o 'Excluir' aplica��o do dia
     *
     * @param valor Valor da aplica��o a ser exclu�da
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Excluir' aplica��o do dia")
    public DetalhesProdutoTela tocarBotaoExcluirAplicacaoDoDia(String valor) throws Exception {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elementoBotaoExcluirAplicacaoDoDia(valor), "N�o foi poss�vel encontrar o bot�o 'Excluir' aplica��o do dia com valor R$ " + valorFormatado);
        salvarEvidencia( "Tocar no bot�o 'Excluir' da aplica��o do dia com valor R$ " + valorFormatado);
        tocarElemento(elementoBotaoExcluirAplicacaoDoDia(valor), "Nao foi possivel tocar no bot�o 'Excluir' aplica��o do dia com valor R$ " + valorFormatado);
        return this;
    }

    /**
     * Tocar no bot�o 'Aplicar'
     *
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Aplicar'")
    public DetalhesProdutoTela tocarBotaoAplicar() throws Exception {
        aguardarElementoHabilitado(botaoAplicar);
        salvarEvidencia("Tocar no bot�o 'Aplicar'");
        tocarElemento(botaoAplicar, "Nao foi poss�vel tocar no bot�o 'Aplicar'");
        return this;
    }

    /**
     * Extrair o valor total aplicado dispon�vel
     *
     * @param totalDisponivel Valor total aplicado dispon�vel
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Extrair o valor total aplicado dispon�vel")
    public DetalhesProdutoTela extrairTotalDisponivel(ThreadLocal<String> totalDisponivel) throws Exception {
        aguardarElementoHabilitado(campoTotalDisponivel);
        OperadorEvidencia.logarPasso("Iniciada a extra��o do total dispon�vel");
        totalDisponivel.set(retornarTexto(campoTotalDisponivel, "N�o foi poss�vel recuperar o valor do campo 'Total dispon�vel'").substring(3));
        salvarEvidencia("Extra�do o total de R$ " + totalDisponivel.get());
        OperadorEvidencia.logarPasso("Finalizada a extra��o do total dispon�vel");
        return this;
    }

    /**
     * Validar o valor total aplicado dispon�vel
     *
     * @param valor Valor a ser validado no campo 'Total dispon�vel'
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Validar o valor total aplicado dispon�vel")
    public DetalhesProdutoTela validarTotalDisponivelProduto(String valor) throws Exception {
        compararElementoTexto(campoTotalDisponivel, "R$ " + valor, MetodoComparacao.IGUAL);
        salvarEvidencia("Validado o valor total aplicado dispon�vel R$ " + valor);
        return this;
    }

    /**
     * Validar aus�ncia do bot�o 'Editar' aplica��o agendada
     *
     * @param valor Valor da aplica��o a ser editada
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Validar aus�ncia do bot�o 'Editar' aplica��o agendada")
    public DetalhesProdutoTela validarAusenciaBotaoEditarAplicacaoAgendada(String valor) throws Exception {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelDetalhesInvestimento, "N�o foi poss�vel encontrar o label 'Detalhes do investimento'");
        OperadorEvidencia.logarPasso("Iniciada a valida��o da aus�ncia do bot�o 'Editar' aplica��o agendada com valor R$ " + valorFormatado);
        validarCondicaoBooleana(verificarPresencaElemento(elementoBotaoEditarAplicacaoAgendada(valor)), MetodoComparacaoBooleano.FALSO, "N�o foi poss�vel validar a aus�ncia do bot�o 'Editar' aplica��o agendada com valor R$ " + valorFormatado);
        salvarEvidencia("Validada a aus�ncia do bot�o 'Editar' aplica��o agendada com valor R$ " + valorFormatado);
        return this;
    }

    /**
     * Validar a aus�ncia do bot�o 'Excluir' aplica��o do dia
     *
     * @param valor Valor da aplica��o a ser exclu�da
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Validar aus�ncia do bot�o 'Excluir' aplica��o do dia")
    public DetalhesProdutoTela validarAusenciaBotaoExcluirAplicacaoDoDia(String valor) throws Exception {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelDetalhesInvestimento, "N�o foi poss�vel encontrar o label 'Detalhes do investimento'");
        OperadorEvidencia.logarPasso("Iniciada a valida��o da aus�ncia do bot�o 'Excluir' aplica��o do dia com valor R$ " + valorFormatado);
        validarCondicaoBooleana(verificarPresencaElemento(elementoBotaoExcluirAplicacaoDoDia(valor)), MetodoComparacaoBooleano.FALSO, "N�o foi poss�vel validar a aus�ncia do bot�o 'Excluir' aplica��o do dia com valor R$ " + valorFormatado);
        salvarEvidencia("Validada a aus�ncia do bot�o 'Excluir' aplica��o do dia com valor R$ " + valorFormatado);
        return this;
    }

    /**
     * Tocar no swipe 'Aplica��o mensal'
     *
     * @return DetalhesProdutoTela
     * @throws NextException
     */
    @Step("Tocar no swipe 'Aplica��o mensal'")
    public DetalhesProdutoTela tocarSwipeAplicacaoMensal() throws NextException {
        By elemento;
        if (ios) {
            elemento = By.xpath("//*[@type='XCUIElementTypeStaticText' and contains(@value, 'Desativado') or contains(@value, 'Ativado')]");
        } else {
            elemento = By.xpath("//*[@resource-id='br.com.bradesco.next:id/sw_subscribe_status' and contains(@text, 'Desativado') or contains(@text, 'Ativado')]");
        }
        tocarElemento(elemento, "N�o foi poss�vel tocar no swaipe 'Aplica��o mensal'");
        salvarEvidencia("Tocado no swipe 'Aplica��o mensal'");
        return this;
    }

    /**
     * Validar condi��o da aplica��o mensal (Ativado ou Desativado)
     *
     * @param condicaoAplicacaoMensal Condi��o da aplica��o mensal a ser validada (Ativado ou Desativado)
     * @return DetalhesProdutoTela
     */
    @Step("Validar a condi��o da aplica��o mensal (Ativado ou Desativado)")
    public DetalhesProdutoTela validarCondicaoAplicacaoMensal(CondicaoAplicacaoMensal condicaoAplicacaoMensal) {
        By elemento;
        if (ios) {
            elemento = By.xpath("//*[@type='XCUIElementTypeStaticText' and contains(@value, '"+condicaoAplicacaoMensal+"')]");
        } else {
            elemento = By.xpath("//*[@resource-id='br.com.bradesco.next:id/sw_subscribe_status' and contains(@text, '"+condicaoAplicacaoMensal+"')]");
        }
        OperadorEvidencia.logarPasso("Iniciada a valida��o da condi��o da aplica��o mensal");
        validarCondicaoBooleana(
                aguardarCarregamentoElemento(elemento),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar a condi��o da aplica��o mensal");
        salvarEvidencia("Validada a condi��o da aplica��o mensal para " + condicaoAplicacaoMensal);
        return this;
    }

    /**
     * Fun��o que retorna o elemento do bot�o 'Editar' aplica��o agendada
     *
     * @param valor Valor da aplica��o a ser editada
     * @return Retorna o elemento do bot�o 'Editar' aplica��o agendada
     */
    private By elementoBotaoEditarAplicacaoAgendada(String valor) {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        if (ios) {
            return By.xpath("//*[contains(@name,'"+valorFormatado+"')]/following-sibling::*[@name='icon edit medium']");
        } else {
            return By.xpath("//*[contains(@text,'R$ "+valorFormatado+"')]/following::*[@resource-id='br.com.bradesco.next:id/ll_edit']");
        }
    }

    /**
     * Fun��o que retorna o elemento do bot�o 'Excluir' aplica��o do dia
     *
     * @param valor Valor da aplica��o a ser exclu�da
     * @return Retorna o elemento do bot�o 'Excluir' aplica��o do dia
     */
    private By elementoBotaoExcluirAplicacaoDoDia(String valor) {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        if (ios) {
            return By.xpath("//*[contains(@name,'"+valorFormatado+"')]/following::XCUIElementTypeButton[@name='icon delete medium']");
        } else {
            return By.xpath("//*[contains(@text,'R$ "+valorFormatado+"')]/following::*[@resource-id='br.com.bradesco.next:id/ll_day_application_cancel']");
        }
    }
}
