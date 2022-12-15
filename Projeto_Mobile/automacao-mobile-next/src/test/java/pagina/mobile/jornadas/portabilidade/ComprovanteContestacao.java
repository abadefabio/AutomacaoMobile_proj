package pagina.mobile.jornadas.portabilidade;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class ComprovanteContestacao  extends PaginaBase {

    //validar texto da contestação da portabilidade
    @AndroidFindBy(id= "br.com.bradesco.next:id/ntv_message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"contestação\") and contains(@name, \"resposta\")]")
    private MobileElement labelContestacao;

    //Botão 'Visualizar Comprovante tela Contestar PortabilidadeDados'
    @AndroidFindBy( id = "br.com.bradesco.next:id/ll_visualize")
    @iOSXCUITFindBy(accessibility = "btn_Comprovante")
    private MobileElement botaoVisualizarComprovanteContestar;

    //Botão voltar tela de visualizar comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath="//*[@name='DETALHES']/XCUIElementTypeButton")
    private MobileElement botaoVoltarVisualizarComprovante;

    //botao Fechar na tela Comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//*[@name='TRAZER MEU SALÁRIO']/XCUIElementTypeButton")
    private MobileElement botaoFecharComprovante;

    //Label tela "TRAZER MEU SALARIO"
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeNavigationBar\" and name = \"TRAZER MEU SALÁRIO\"")
    private MobileElement tituloTelaTrazerMeuSalario;

    public ComprovanteContestacao(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar texto da contestação no Comprovante na contestação
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"Texto da Contestação\" do comprovante")
    public ComprovanteContestacao validarStatusComprovanteContestarPortabilidade(Enum textoContestacao) throws Exception {
        aguardarCarregamentoElemento(labelContestacao);
        salvarEvidencia("validar Status no comprovante Contestar portabilidade.");
        compararElementoTexto(labelContestacao, textoContestacao, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * Clicar botão 'Visualizar'  - Comprovante contestar portabilidade
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Visualizar\"")
    public ComprovanteContestacao tocarBotaoVisualizarComprovanteContestar() throws Exception {
        aguardarCarregamentoElemento(botaoVisualizarComprovanteContestar);
        salvarEvidencia("Clicar no botão 'Visualizar'");
        tocarElemento(botaoVisualizarComprovanteContestar, "Não foi possível clicar no botão Visualizar");
        salvarEvidencia("Comprovante em Tela'");
        return this;
    }

    /**
     * Clicar botão 'voltar'  - em visualizar Comprovante - portabilidade
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar Visualizacao\"")
    public ComprovanteContestacao tocarBotaoVoltarVisualizarComprovante() throws Exception {
        salvarEvidencia("Botão Voltar em Visualizar Comprovante em Tela'");
        tocarElemento(botaoVoltarVisualizarComprovante, "Não foi possivel clicar no botão voltar < ");
        return this;
    }

    /**
     * Tocar botão 'Fechar' na tela comprovante
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\" na tela 'Comprovante'")
    public ComprovanteContestacao tocarBotaoFecharComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoFecharComprovante);
        tocarElemento(botaoFecharComprovante, "Não foi possível clicar no botão fechar comprovante");
        aguardarCarregamentoElemento(tituloTelaTrazerMeuSalario);
        salvarEvidencia("Fechar Comprovante");
        return this;
    }
}
