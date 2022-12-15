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
     * Validar presen�a da tela 'Nome Empr�stimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Nome Empr�stimo'")
    public EmprestimoNomeTela validarPresencaTelaNomeEmprestimo() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO, Mensagem.NOME_EMPRESTIMO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo '"+TituloTela.EMPRESTIMO+"' e/ou mensagem '"+Mensagem.NOME_EMPRESTIMO+"' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela Nome Empr�stimo");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public EmprestimoNomeTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
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
        escreverTexto(campoNome, nome, "N�o foi poss�vel preencher o campo 'Nome' com: " +nome);
        salvarEvidencia("Preenchido campo 'Nome' com: " + nome);
        return this;
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public EmprestimoNomeTela tocarbotaoContinuar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }
}
