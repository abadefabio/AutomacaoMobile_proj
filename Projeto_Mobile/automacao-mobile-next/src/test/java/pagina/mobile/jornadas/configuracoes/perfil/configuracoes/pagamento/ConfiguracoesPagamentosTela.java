package pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.configuracoes.perfil.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ConfiguracoesPagamentosTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    //botao Emprestimo Pessoal
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_icon")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Empréstimo pessoal\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Empréstimo pessoal\"`]")
    private MobileElement botaoEmprestimoPessoal;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_root")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Cartão de crédito\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Cartão de crédito'`]")
    private MobileElement botaoCartaoDeCredito;

    public ConfiguracoesPagamentosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão Voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public ConfiguracoesPagamentosTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar,"Não foi possível tocar botão voltar");
        return this;
    }

    /**
     * Tocar botão Emprestimo Pessoal
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Emprestimo Pessoal\"")
    public ConfiguracoesPagamentosTela tocarEmprestimoPessoal() throws Exception {

        salvarEvidencia("Tocar no botão 'Emprestimo Pessoal'");
        tocarElemento(botaoEmprestimoPessoal, "Não foi possível Tocar no botão Emprestimo Pessoal");
        aguardarOcultacaoElemento(botaoEmprestimoPessoal);
        return this;
    }

    /**
     * Validar que esta na tela configuracoes pagamento
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Configuracao Pagamento\"")
    public ConfiguracoesPagamentosTela validarTelaConfiguracoesPagamento() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CONFIGURACOES_PAGAMENTO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'configuracoes pagamento' não está presente na tela!");
        salvarEvidencia("Validado tela Configurações de Pagamento'!");
        return this;
    }

    /**
     * validar botão Emprestimo Pessoal
     *
     * @return
     * @throws Exception
     */
    @Step("Validar botão \"Emprestimo Pessoal\"")
    public ConfiguracoesPagamentosTela validarEmprestimoPessoal() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(botaoEmprestimoPessoal), MetodoComparacaoBooleano.VERDADEIRO, "O botao Emprestimo Pessoal > não foi exibido");
        salvarEvidencia("Validar Presenca do botão 'Emprestimo Pessoal > '");
        return this;
    }

    /**
     * Tocar botão "Cartão de Crédito"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão \"Cartão de Crédito\"")
    public ConfiguracoesPagamentosTela tocarCartaoDeCredito() throws Exception{
        salvarEvidencia("Tocar no botão 'Cartão de Crédito'");
        tocarElemento(botaoCartaoDeCredito, "Não foi possível tocar no botão Cartão de Crédito");
        return this;
    }

    /**
     * Tocar na opção de empréstimo pessoal com saldo devedor especificado
     * @param saldoDevedor
     */
    public ConfiguracoesPagamentosTela tocarEmprestimoPessoalComSaldoDevedor(String saldoDevedor) throws Exception {
        By opcaoSaldoDevedor = android ?
                new By.ByXPath(String.format("//*[contains(@text, '%s')]", saldoDevedor)):
                new By.ByXPath(String.format("//*[contains(@name, '%s')]", saldoDevedor));
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(opcaoSaldoDevedor, String.format("Não foi possível tocar na opção com saldo devedor %s", saldoDevedor));
        salvarEvidencia(String.format("Tocar na opção com saldo devedor %s", saldoDevedor));
        tocarElemento(opcaoSaldoDevedor, String.format("Não foi possível tocar na opção com saldo devedor %s", saldoDevedor));
        return this;
    }
}
