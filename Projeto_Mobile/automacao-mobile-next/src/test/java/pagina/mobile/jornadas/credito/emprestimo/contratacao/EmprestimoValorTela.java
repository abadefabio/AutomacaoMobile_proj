package pagina.mobile.jornadas.credito.emprestimo.contratacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.credito.Mensagem;
import constantes.credito.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EmprestimoValorTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@name='Voltar']")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar']")
    private MobileElement botaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_value")
    @iOSXCUITFindBy(accessibility = "et_value")
    private MobileElement campoValor;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    public EmprestimoValorTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Valor Empréstimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença tela 'Valor Empréstimo'")
    public EmprestimoValorTela validarPresencaTelaValorEmprestimo() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO, Mensagem.VALOR_EMPRESTIMO), MetodoComparacaoBooleano.VERDADEIRO, "Título '" + TituloTela.EMPRESTIMO + "' e/ou mensagem '" + Mensagem.VALOR_EMPRESTIMO + "' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela 'Valor Empréstimo'");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public EmprestimoValorTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Preencher campo 'Valor'
     *
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Preencher campo 'Valor'")
    public EmprestimoValorTela preencherCampoValor(String valor) throws Exception {
        aguardarCarregamentoElemento(campoValor);
        tocarElemento(campoValor,"teste");
        escreverTexto(campoValor, valor, "Não foi possível preencher o campo 'Valor' com: " + valor);
        salvarEvidencia("Preenchido campo 'Valor' com: " + valor);
        return this;
    }

    /**
     * Verificar se campo 'Valor' está presente na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar campo 'Valor' presente")
    public boolean verificarCampoValorPresente() {
        return verificarPresencaElemento(campoValor);
    }

    /**
     * Tocar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public EmprestimoValorTela tocarbotaoContinuar() throws Exception {
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }
}
