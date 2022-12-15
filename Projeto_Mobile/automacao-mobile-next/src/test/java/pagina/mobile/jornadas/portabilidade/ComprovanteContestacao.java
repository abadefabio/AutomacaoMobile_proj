package pagina.mobile.jornadas.portabilidade;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class ComprovanteContestacao  extends PaginaBase {

    //validar texto da contesta��o da portabilidade
    @AndroidFindBy(id= "br.com.bradesco.next:id/ntv_message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"contesta��o\") and contains(@name, \"resposta\")]")
    private MobileElement labelContestacao;

    //Bot�o 'Visualizar Comprovante tela Contestar PortabilidadeDados'
    @AndroidFindBy( id = "br.com.bradesco.next:id/ll_visualize")
    @iOSXCUITFindBy(accessibility = "btn_Comprovante")
    private MobileElement botaoVisualizarComprovanteContestar;

    //Bot�o voltar tela de visualizar comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath="//*[@name='DETALHES']/XCUIElementTypeButton")
    private MobileElement botaoVoltarVisualizarComprovante;

    //botao Fechar na tela Comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//*[@name='TRAZER MEU SAL�RIO']/XCUIElementTypeButton")
    private MobileElement botaoFecharComprovante;

    //Label tela "TRAZER MEU SALARIO"
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeNavigationBar\" and name = \"TRAZER MEU SAL�RIO\"")
    private MobileElement tituloTelaTrazerMeuSalario;

    public ComprovanteContestacao(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar texto da contesta��o no Comprovante na contesta��o
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"Texto da Contesta��o\" do comprovante")
    public ComprovanteContestacao validarStatusComprovanteContestarPortabilidade(Enum textoContestacao) throws Exception {
        aguardarCarregamentoElemento(labelContestacao);
        salvarEvidencia("validar Status no comprovante Contestar portabilidade.");
        compararElementoTexto(labelContestacao, textoContestacao, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * Clicar bot�o 'Visualizar'  - Comprovante contestar portabilidade
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Visualizar\"")
    public ComprovanteContestacao tocarBotaoVisualizarComprovanteContestar() throws Exception {
        aguardarCarregamentoElemento(botaoVisualizarComprovanteContestar);
        salvarEvidencia("Clicar no bot�o 'Visualizar'");
        tocarElemento(botaoVisualizarComprovanteContestar, "N�o foi poss�vel clicar no bot�o Visualizar");
        salvarEvidencia("Comprovante em Tela'");
        return this;
    }

    /**
     * Clicar bot�o 'voltar'  - em visualizar Comprovante - portabilidade
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar Visualizacao\"")
    public ComprovanteContestacao tocarBotaoVoltarVisualizarComprovante() throws Exception {
        salvarEvidencia("Bot�o Voltar em Visualizar Comprovante em Tela'");
        tocarElemento(botaoVoltarVisualizarComprovante, "N�o foi possivel clicar no bot�o voltar < ");
        return this;
    }

    /**
     * Tocar bot�o 'Fechar' na tela comprovante
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Fechar\" na tela 'Comprovante'")
    public ComprovanteContestacao tocarBotaoFecharComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoFecharComprovante);
        tocarElemento(botaoFecharComprovante, "N�o foi poss�vel clicar no bot�o fechar comprovante");
        aguardarCarregamentoElemento(tituloTelaTrazerMeuSalario);
        salvarEvidencia("Fechar Comprovante");
        return this;
    }
}
