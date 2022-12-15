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
    @iOSXCUITFindBy(xpath = "//*[@name=\"Empr�stimo pessoal\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Empr�stimo pessoal\"`]")
    private MobileElement botaoEmprestimoPessoal;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_root")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Cart�o de cr�dito\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Cart�o de cr�dito'`]")
    private MobileElement botaoCartaoDeCredito;

    public ConfiguracoesPagamentosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o Voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public ConfiguracoesPagamentosTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar,"N�o foi poss�vel tocar bot�o voltar");
        return this;
    }

    /**
     * Tocar bot�o Emprestimo Pessoal
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Emprestimo Pessoal\"")
    public ConfiguracoesPagamentosTela tocarEmprestimoPessoal() throws Exception {

        salvarEvidencia("Tocar no bot�o 'Emprestimo Pessoal'");
        tocarElemento(botaoEmprestimoPessoal, "N�o foi poss�vel Tocar no bot�o Emprestimo Pessoal");
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
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CONFIGURACOES_PAGAMENTO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'configuracoes pagamento' n�o est� presente na tela!");
        salvarEvidencia("Validado tela Configura��es de Pagamento'!");
        return this;
    }

    /**
     * validar bot�o Emprestimo Pessoal
     *
     * @return
     * @throws Exception
     */
    @Step("Validar bot�o \"Emprestimo Pessoal\"")
    public ConfiguracoesPagamentosTela validarEmprestimoPessoal() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(botaoEmprestimoPessoal), MetodoComparacaoBooleano.VERDADEIRO, "O botao Emprestimo Pessoal > n�o foi exibido");
        salvarEvidencia("Validar Presenca do bot�o 'Emprestimo Pessoal > '");
        return this;
    }

    /**
     * Tocar bot�o "Cart�o de Cr�dito"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o \"Cart�o de Cr�dito\"")
    public ConfiguracoesPagamentosTela tocarCartaoDeCredito() throws Exception{
        salvarEvidencia("Tocar no bot�o 'Cart�o de Cr�dito'");
        tocarElemento(botaoCartaoDeCredito, "N�o foi poss�vel tocar no bot�o Cart�o de Cr�dito");
        return this;
    }

    /**
     * Tocar na op��o de empr�stimo pessoal com saldo devedor especificado
     * @param saldoDevedor
     */
    public ConfiguracoesPagamentosTela tocarEmprestimoPessoalComSaldoDevedor(String saldoDevedor) throws Exception {
        By opcaoSaldoDevedor = android ?
                new By.ByXPath(String.format("//*[contains(@text, '%s')]", saldoDevedor)):
                new By.ByXPath(String.format("//*[contains(@name, '%s')]", saldoDevedor));
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(opcaoSaldoDevedor, String.format("N�o foi poss�vel tocar na op��o com saldo devedor %s", saldoDevedor));
        salvarEvidencia(String.format("Tocar na op��o com saldo devedor %s", saldoDevedor));
        tocarElemento(opcaoSaldoDevedor, String.format("N�o foi poss�vel tocar na op��o com saldo devedor %s", saldoDevedor));
        return this;
    }
}
