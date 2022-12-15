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

public class EmprestimoNomeTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@name='Voltar']")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar']")
    private MobileElement botaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name")
    @iOSXCUITFindBy(accessibility = "et_name")
    private MobileElement campoNome;

    @AndroidFindBy(id="br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    public EmprestimoNomeTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Nome Empréstimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença tela 'Nome Empréstimo'")
    public EmprestimoNomeTela validarPresencaTelaNomeEmprestimo() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO, Mensagem.NOME_EMPRESTIMO), MetodoComparacaoBooleano.VERDADEIRO, "Título '"+TituloTela.EMPRESTIMO+"' e/ou mensagem '"+Mensagem.NOME_EMPRESTIMO+"' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela Nome Empréstimo");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public EmprestimoNomeTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Preencher campo 'Nome'
     *
     * @param nome
     * @return
     * @throws Exception
     */
    @Step("Preencher campo 'Nome'")
    public EmprestimoNomeTela preencherCampoNome(String nome) throws Exception {
        escreverTexto(campoNome, nome, "Não foi possível preencher o campo 'Nome' com: " +nome);
        salvarEvidencia("Preenchido campo 'Nome' com: " + nome);
        return this;
    }

    /**
     * Tocar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public EmprestimoNomeTela tocarbotaoContinuar() throws Exception {
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }
}
