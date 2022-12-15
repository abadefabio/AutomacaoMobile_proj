package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class TransferirNomeTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[1]")
    private MobileElement numeroPaginaAtual;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement descricaoPagina;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/et_name_transfer")
    @AndroidFindBy(xpath = "//*[contains(@text,'Nome da trans')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Nome da trans')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextView[`value == \"Nome da transferência\"`]")
    @iOSXCUITFindBy(iOSNsPredicate ="value == \"Nome da transferência\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeTextView")
    private MobileElement nomeTransferencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Continuar')]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/bt_continue']")
    @AndroidBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continuar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Próximo\"`]")
    private MobileElement botaoContinuar;

    public TransferirNomeTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Preencher campo "Nome Transferï¿½ncia" com nome aleatï¿½rio
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Nome Transferencia\"")
    public TransferirNomeTela preencherNomeTransferencia(String nomeTransf) throws Exception {
        if(android){
            esconderTeclado();
        }
        if (nomeTransf == null) {
            OperadorEvidencia.logarPasso("O campo de nome da transferência foi ignorado");
            salvarEvidencia("Nome da transferência em branco");
            return this;
        }

        aguardarCarregamentoElemento(nomeTransferencia);
        salvarEvidencia("Preencher campo Nome Transferencia com \"" + nomeTransf + "\"");
        escreverTexto(nomeTransferencia, nomeTransf, "Erro ao preencher campo \"Nome Transferencia\"");
        return this;
    }

    /**
     * Verificar se campo "Nome Transferencia" presente
     *
     * @return boolean
     * @throws Exception
     */
    @Step("Verificar se campo \"Nome Transferencia\" presente")
    public boolean verificarCampoNomeTransferenciaPresente() throws Exception {
        return verificarPresencaElemento(nomeTransferencia);
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TransferirNomeTela tocarBotaoContinuar() throws Exception{
        if (android) {
            esconderTeclado();
        }
        salvarEvidencia("Tocar botao \"Continuar\"");
        tocarElemento(botaoContinuar, "Erro ao executar a acao de tocar botao \"Continuar\"");
        salvarEvidencia("Tocar botao \"Continuar\"");
        return this;
    }
    /**
     * verificar campo Nome Transferencia"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("verfificar campo \"Nome Transferencia\"")
    public TransferirNomeTela verificarCampoNome() throws Exception{
        esconderTeclado();
        aguardarCarregamentoElemento(nomeTransferencia);
        validarCondicaoBooleana(nomeTransferencia.isEnabled(),MetodoComparacaoBooleano.VERDADEIRO,"NÃ£o foi possivel validar o Banco no comprovante.");
        salvarEvidencia("Validando existencia do campo Nome Tranferencia");
        return this;
    }

    /**
     * Tocar botão "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public TransferirNomeTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no botão fechar (X)" );
        tocarElemento( botaoFechar, "Nao foi possivel tocar no botão fechar" );
        return this;
    }
}
