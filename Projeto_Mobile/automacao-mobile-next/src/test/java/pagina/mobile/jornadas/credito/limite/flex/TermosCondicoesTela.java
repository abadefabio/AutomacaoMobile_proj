package pagina.mobile.jornadas.credito.limite.flex;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermosCondicoesTela extends PaginaBase {

    //Titulo Termos e Condi��es
    @AndroidFindBy(accessibility = "TERMOS E CONDI��ES")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement tituloTermosCondicoes;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Termo de Cancelamento a Produtos e Servi�os')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Termo de Cancelamento a Produtos e Servi�os')]")
    private MobileElement termoCancelamentoProdutosServicos;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Termo de Ades�o a Produtos e Servi�os')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Termo de Ades�o a Produtos e Servi�os')]")
    private MobileElement termoAdesaoProdutosServicos;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Regulamento de Abertura de Limite')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Regulamento de Abertura de Limite')]")
    private MobileElement termoRegularmentoAberturaLimite;


    //Checkbox "Confirmo Solicita��o"
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='GoalTermsContinueFooterDelegate']/XCUIElementTypeButton")
    private MobileElement checkboxConfirmoSolicitacao;

    //Bot�o 'Continuar' da tela termo
    @AndroidFindBy( id = "br.com.bradesco.next:id/btn_ok_flex_limit_config_act")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    private MobileElement botaoContinuar;

    public TermosCondicoesTela(AppiumDriver driver) {super(driver);}


    /**
     * Validar Exibicao Termos de Desativacao de Produto
     *
     * @return
     * @throws Exception
     */
    public TermosCondicoesTela validarExibicaoTermosProduto() throws Exception {
        aguardarCarregamentoElemento(termoCancelamentoProdutosServicos);
        validarCondicaoBooleana(verificarPresencaElemento(termoCancelamentoProdutosServicos), MetodoComparacaoBooleano.VERDADEIRO, "Termo de Cancelamento nao exibido");
        validarCondicaoBooleana(verificarPresencaElemento(termoAdesaoProdutosServicos),MetodoComparacaoBooleano.VERDADEIRO, "Termo de Adesao nao exibido");
        salvarEvidencia("Exibicao de Termos de Ativacao de Produto validado");
        return this;
    }

    /**
     * Validar Exibicao Termos de Ativacao de Produto
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Exibicao de Termos de Desativacao de Produto")
    public TermosCondicoesTela validarExibicaoTermosAtivacaoProduto() throws Exception {
        aguardarCarregamentoElemento(termoRegularmentoAberturaLimite);
        validarCondicaoBooleana(verificarPresencaElemento(termoRegularmentoAberturaLimite), MetodoComparacaoBooleano.VERDADEIRO, "Termo de Cancelamento nao exibido");
        validarCondicaoBooleana(verificarPresencaElemento(termoAdesaoProdutosServicos),MetodoComparacaoBooleano.VERDADEIRO, "Termo de Adesao nao exibido");
        salvarEvidencia("Exibicao de Termos de Desativacao de Produto validado");
        return this;
    }

    /**
     * Tocar checkbox "Confirmar Solicita��o"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar checkbox \"Confirmar Solicita��o\"")
    public TermosCondicoesTela tocarCheboxConfirmoSolicitacao() throws Exception{
        aguardarCarregamentoElemento(checkboxConfirmoSolicitacao);
        rolaTelaBaixo();
        aguardarCarregamentoElemento(checkboxConfirmoSolicitacao);
        tocarElemento(checkboxConfirmoSolicitacao, "N�o foi poss�vel clicar no checkbox \"Confirmo a solicita��o\"");
        salvarEvidencia("Tocar no checkbox \"Confirmo a solicita��o\"");
        return this;
    }

    /**
     * Tocar bot�o continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public TermosCondicoesTela tocarBotaoContinuar() throws Exception{
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar o bot�o \"Continuar\"");
        salvarEvidencia("Tocar no bot�o \"Continuar\"");
        aguardarOcultacaoElemento(botaoContinuar);
        return this;
    }

}
