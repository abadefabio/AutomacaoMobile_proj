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

    @AndroidFindBy(accessibility = "Confirmar Seleção")
    private MobileElement botaoConfirmar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_bt_more")
    private MobileElement botaoAumentarQtdeVezes;

    public EmprestimoQuantidadeParcelasTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Quantidade Parcelas Empréstimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença tela 'Quantidade Parcelas Empréstimo'")
    public EmprestimoQuantidadeParcelasTela validarPresencaTelaQuantidadeParcelasEmprestimo() throws Exception {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO, Mensagem.QUANTIDADE_PARCELAS_EMPRESTIMO), MetodoComparacaoBooleano.VERDADEIRO, "Título '" + TituloTela.EMPRESTIMO + "' e/ou mensagem '" + Mensagem.QUANTIDADE_PARCELAS_EMPRESTIMO + "' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela 'Quantidade Parcelas Empréstimo'");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public EmprestimoQuantidadeParcelasTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Tocar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public EmprestimoQuantidadeParcelasTela tocarbotaoContinuar() throws Exception {
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Tocar botão 'Quantidade de Vezes/Valor'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Quantidade de Vezes/Valor'")
    public EmprestimoQuantidadeParcelasTela tocarbotaoQtdeVezes() throws Exception {
        salvarEvidencia("Tocar botão 'Quantidade de Vezes/Valor'");
        tocarElemento(botaoSelecionarQtdeVezes, "Não foi possível tocar no botão 'Quantidade de Vezes/Valor'");
        return this;
    }

    /**
     * Tocar botão 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Confirmar'")
    public EmprestimoQuantidadeParcelasTela tocarbotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar botão 'Confirmar'");
        tocarElemento(botaoSelecionarQtdeVezes, "Não foi possível tocar no botão 'Confirmar'");
        return this;
    }

    /**
     * Tocar botão 'Aumentar Quantidade de Vezes'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Aumentar Quantidade de Vezes'")
    public EmprestimoQuantidadeParcelasTela tocarbotaoAumentarQtdeVezes() throws Exception {
        salvarEvidencia("Tocar botão 'Aumentar Quantidade de Vezes'");
        tocarElemento(botaoSelecionarQtdeVezes, "Não foi possível tocar no botão 'Aumentar Quantidade de Vezes'");
        return this;
    }

}
