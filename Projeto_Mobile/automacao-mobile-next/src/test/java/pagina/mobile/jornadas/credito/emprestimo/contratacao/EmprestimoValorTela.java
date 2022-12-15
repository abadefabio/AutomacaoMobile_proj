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
     * Validar presen�a da tela 'Valor Empr�stimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Valor Empr�stimo'")
    public EmprestimoValorTela validarPresencaTelaValorEmprestimo() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO, Mensagem.VALOR_EMPRESTIMO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo '" + TituloTela.EMPRESTIMO + "' e/ou mensagem '" + Mensagem.VALOR_EMPRESTIMO + "' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela 'Valor Empr�stimo'");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public EmprestimoValorTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
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
        escreverTexto(campoValor, valor, "N�o foi poss�vel preencher o campo 'Valor' com: " + valor);
        salvarEvidencia("Preenchido campo 'Valor' com: " + valor);
        return this;
    }

    /**
     * Verificar se campo 'Valor' est� presente na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar campo 'Valor' presente")
    public boolean verificarCampoValorPresente() {
        return verificarPresencaElemento(campoValor);
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public EmprestimoValorTela tocarbotaoContinuar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }
}
