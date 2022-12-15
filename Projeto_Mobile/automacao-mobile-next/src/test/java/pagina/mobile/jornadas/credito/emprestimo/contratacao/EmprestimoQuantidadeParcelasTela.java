package pagina.mobile.jornadas.credito.emprestimo.contratacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.credito.Mensagem;
import constantes.credito.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class EmprestimoQuantidadeParcelasTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@name='Voltar']")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar']")
    private MobileElement botaoVoltar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_container_number_install_and_amount")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[5]")
    private MobileElement botaoSelecionarQtdeVezes;

    @AndroidFindBy(accessibility = "Confirmar Sele��o")
    private MobileElement botaoConfirmar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_bt_more")
    private MobileElement botaoAumentarQtdeVezes;

    public EmprestimoQuantidadeParcelasTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Quantidade Parcelas Empr�stimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Quantidade Parcelas Empr�stimo'")
    public EmprestimoQuantidadeParcelasTela validarPresencaTelaQuantidadeParcelasEmprestimo() throws Exception {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO, Mensagem.QUANTIDADE_PARCELAS_EMPRESTIMO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo '" + TituloTela.EMPRESTIMO + "' e/ou mensagem '" + Mensagem.QUANTIDADE_PARCELAS_EMPRESTIMO + "' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela 'Quantidade Parcelas Empr�stimo'");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public EmprestimoQuantidadeParcelasTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public EmprestimoQuantidadeParcelasTela tocarbotaoContinuar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Tocar bot�o 'Quantidade de Vezes/Valor'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Quantidade de Vezes/Valor'")
    public EmprestimoQuantidadeParcelasTela tocarbotaoQtdeVezes() throws Exception {
        salvarEvidencia("Tocar bot�o 'Quantidade de Vezes/Valor'");
        tocarElemento(botaoSelecionarQtdeVezes, "N�o foi poss�vel tocar no bot�o 'Quantidade de Vezes/Valor'");
        return this;
    }

    /**
     * Tocar bot�o 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Confirmar'")
    public EmprestimoQuantidadeParcelasTela tocarbotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Confirmar'");
        tocarElemento(botaoSelecionarQtdeVezes, "N�o foi poss�vel tocar no bot�o 'Confirmar'");
        return this;
    }

    /**
     * Tocar bot�o 'Aumentar Quantidade de Vezes'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Aumentar Quantidade de Vezes'")
    public EmprestimoQuantidadeParcelasTela tocarbotaoAumentarQtdeVezes() throws Exception {
        salvarEvidencia("Tocar bot�o 'Aumentar Quantidade de Vezes'");
        tocarElemento(botaoSelecionarQtdeVezes, "N�o foi poss�vel tocar no bot�o 'Aumentar Quantidade de Vezes'");
        return this;
    }

}
