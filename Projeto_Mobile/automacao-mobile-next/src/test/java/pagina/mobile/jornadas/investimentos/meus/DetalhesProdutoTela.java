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
    @AndroidFindBy(accessibility = "Voltar, Botão")
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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total disponível\"]/../XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/total_available")
    private MobileElement campoTotalDisponivel;

    @AndroidFindBy(xpath = "//*[@text='Detalhes do investimento']")
    @iOSXCUITFindBy(xpath = "//*[@name='Detalhes do investimento']")
    private MobileElement labelDetalhesInvestimento;

    public DetalhesProdutoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no botão 'Resgatar'
     *
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Resgatar'")
    public DetalhesProdutoTela tocarBotaoResgatar() throws Exception {
        aguardarElementoHabilitado(botaoAplicar);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoResgatar, "Nao foi possível encontrar o botão 'Resgatar'");
        salvarEvidencia("Tocar no botão 'Resgatar'");
        tocarElemento(botaoResgatar, "Nao foi possível tocar no botão 'Resgatar'");
        return this;
    }

    /**
     * Tocar no botão 'Detalhes'
     *
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Detalhes'")
    public DetalhesProdutoTela tocarBotaoDetalhes() throws Exception {
        if (ios) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDetalhes,"Erro ao encontrar o botão 'Detalhes'");
        }
        salvarEvidencia("Tocar no botão 'Detalhes'");
        tocarElemento(botaoDetalhes, "Não foi possível tocar no botão 'Detalhes'");
        return this;
    }

    /**
     * Tocar no botão 'Voltar'
     *
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Voltar'")
    public DetalhesProdutoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no botão 'Voltar'");
        tocarElemento(botaoVoltar, "Nao foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Tocar no botão 'Editar' aplicação agendada
     *
     * @param valor Valor da aplicação a ser editada
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Editar' aplicação agendada")
    public DetalhesProdutoTela tocarBotaoEditarAplicacaoAgendada(String valor) throws Exception {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elementoBotaoEditarAplicacaoAgendada(valor),"Não foi possível encontrar o botão 'Editar' aplicação agendada com valor R$" + valorFormatado);
        salvarEvidencia("Tocar no botão 'Editar' aplicação agendada com valor R$ " + valorFormatado);
        tocarElemento(elementoBotaoEditarAplicacaoAgendada(valor), "Não foi possível tocar no botão 'Editar' aplicação agendada com valor R$ " + valorFormatado);
        return this;
    }

    /**
     * Tocar no botão 'Excluir' aplicação do dia
     *
     * @param valor Valor da aplicação a ser excluída
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Excluir' aplicação do dia")
    public DetalhesProdutoTela tocarBotaoExcluirAplicacaoDoDia(String valor) throws Exception {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elementoBotaoExcluirAplicacaoDoDia(valor), "Não foi possível encontrar o botão 'Excluir' aplicação do dia com valor R$ " + valorFormatado);
        salvarEvidencia( "Tocar no botão 'Excluir' da aplicação do dia com valor R$ " + valorFormatado);
        tocarElemento(elementoBotaoExcluirAplicacaoDoDia(valor), "Nao foi possivel tocar no botão 'Excluir' aplicação do dia com valor R$ " + valorFormatado);
        return this;
    }

    /**
     * Tocar no botão 'Aplicar'
     *
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Aplicar'")
    public DetalhesProdutoTela tocarBotaoAplicar() throws Exception {
        aguardarElementoHabilitado(botaoAplicar);
        salvarEvidencia("Tocar no botão 'Aplicar'");
        tocarElemento(botaoAplicar, "Nao foi possível tocar no botão 'Aplicar'");
        return this;
    }

    /**
     * Extrair o valor total aplicado disponível
     *
     * @param totalDisponivel Valor total aplicado disponível
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Extrair o valor total aplicado disponível")
    public DetalhesProdutoTela extrairTotalDisponivel(ThreadLocal<String> totalDisponivel) throws Exception {
        aguardarElementoHabilitado(campoTotalDisponivel);
        OperadorEvidencia.logarPasso("Iniciada a extração do total disponível");
        totalDisponivel.set(retornarTexto(campoTotalDisponivel, "Não foi possível recuperar o valor do campo 'Total disponível'").substring(3));
        salvarEvidencia("Extraído o total de R$ " + totalDisponivel.get());
        OperadorEvidencia.logarPasso("Finalizada a extração do total disponível");
        return this;
    }

    /**
     * Validar o valor total aplicado disponível
     *
     * @param valor Valor a ser validado no campo 'Total disponível'
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Validar o valor total aplicado disponível")
    public DetalhesProdutoTela validarTotalDisponivelProduto(String valor) throws Exception {
        compararElementoTexto(campoTotalDisponivel, "R$ " + valor, MetodoComparacao.IGUAL);
        salvarEvidencia("Validado o valor total aplicado disponível R$ " + valor);
        return this;
    }

    /**
     * Validar ausência do botão 'Editar' aplicação agendada
     *
     * @param valor Valor da aplicação a ser editada
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Validar ausência do botão 'Editar' aplicação agendada")
    public DetalhesProdutoTela validarAusenciaBotaoEditarAplicacaoAgendada(String valor) throws Exception {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelDetalhesInvestimento, "Não foi possível encontrar o label 'Detalhes do investimento'");
        OperadorEvidencia.logarPasso("Iniciada a validação da ausência do botão 'Editar' aplicação agendada com valor R$ " + valorFormatado);
        validarCondicaoBooleana(verificarPresencaElemento(elementoBotaoEditarAplicacaoAgendada(valor)), MetodoComparacaoBooleano.FALSO, "Não foi possível validar a ausência do botão 'Editar' aplicação agendada com valor R$ " + valorFormatado);
        salvarEvidencia("Validada a ausência do botão 'Editar' aplicação agendada com valor R$ " + valorFormatado);
        return this;
    }

    /**
     * Validar a ausência do botão 'Excluir' aplicação do dia
     *
     * @param valor Valor da aplicação a ser excluída
     * @return DetalhesProdutoTela
     * @throws Exception
     */
    @Step("Validar ausência do botão 'Excluir' aplicação do dia")
    public DetalhesProdutoTela validarAusenciaBotaoExcluirAplicacaoDoDia(String valor) throws Exception {
        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelDetalhesInvestimento, "Não foi possível encontrar o label 'Detalhes do investimento'");
        OperadorEvidencia.logarPasso("Iniciada a validação da ausência do botão 'Excluir' aplicação do dia com valor R$ " + valorFormatado);
        validarCondicaoBooleana(verificarPresencaElemento(elementoBotaoExcluirAplicacaoDoDia(valor)), MetodoComparacaoBooleano.FALSO, "Não foi possível validar a ausência do botão 'Excluir' aplicação do dia com valor R$ " + valorFormatado);
        salvarEvidencia("Validada a ausência do botão 'Excluir' aplicação do dia com valor R$ " + valorFormatado);
        return this;
    }

    /**
     * Tocar no swipe 'Aplicação mensal'
     *
     * @return DetalhesProdutoTela
     * @throws NextException
     */
    @Step("Tocar no swipe 'Aplicação mensal'")
    public DetalhesProdutoTela tocarSwipeAplicacaoMensal() throws NextException {
        By elemento;
        if (ios) {
            elemento = By.xpath("//*[@type='XCUIElementTypeStaticText' and contains(@value, 'Desativado') or contains(@value, 'Ativado')]");
        } else {
            elemento = By.xpath("//*[@resource-id='br.com.bradesco.next:id/sw_subscribe_status' and contains(@text, 'Desativado') or contains(@text, 'Ativado')]");
        }
        tocarElemento(elemento, "Não foi possível tocar no swaipe 'Aplicação mensal'");
        salvarEvidencia("Tocado no swipe 'Aplicação mensal'");
        return this;
    }

    /**
     * Validar condição da aplicação mensal (Ativado ou Desativado)
     *
     * @param condicaoAplicacaoMensal Condição da aplicação mensal a ser validada (Ativado ou Desativado)
     * @return DetalhesProdutoTela
     */
    @Step("Validar a condição da aplicação mensal (Ativado ou Desativado)")
    public DetalhesProdutoTela validarCondicaoAplicacaoMensal(CondicaoAplicacaoMensal condicaoAplicacaoMensal) {
        By elemento;
        if (ios) {
            elemento = By.xpath("//*[@type='XCUIElementTypeStaticText' and contains(@value, '"+condicaoAplicacaoMensal+"')]");
        } else {
            elemento = By.xpath("//*[@resource-id='br.com.bradesco.next:id/sw_subscribe_status' and contains(@text, '"+condicaoAplicacaoMensal+"')]");
        }
        OperadorEvidencia.logarPasso("Iniciada a validação da condição da aplicação mensal");
        validarCondicaoBooleana(
                aguardarCarregamentoElemento(elemento),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar a condição da aplicação mensal");
        salvarEvidencia("Validada a condição da aplicação mensal para " + condicaoAplicacaoMensal);
        return this;
    }

    /**
     * Função que retorna o elemento do botão 'Editar' aplicação agendada
     *
     * @param valor Valor da aplicação a ser editada
     * @return Retorna o elemento do botão 'Editar' aplicação agendada
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
     * Função que retorna o elemento do botão 'Excluir' aplicação do dia
     *
     * @param valor Valor da aplicação a ser excluída
     * @return Retorna o elemento do botão 'Excluir' aplicação do dia
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
