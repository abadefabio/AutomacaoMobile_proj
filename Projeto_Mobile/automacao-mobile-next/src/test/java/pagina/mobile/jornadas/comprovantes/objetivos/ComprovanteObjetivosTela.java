package pagina.mobile.jornadas.comprovantes.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.objetivos.MensagensObjetivos;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ComprovanteObjetivosTela extends PaginaBase {

    @AndroidFindBy(xpath="//*[@resource-id = \"br.com.bradesco.next:id/tv_item_receipts_goals\" and @text = \"Objetivos Finalizados\"]")
    @iOSXCUITFindBy(accessibility = "Objetivos finalizados")
    private MobileElement objetivosFinalizados;

    @AndroidFindBy(xpath ="(//*[@resource-id='br.com.bradesco.next:id/rl_layout_view_goals'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
    private MobileElement botaoPrimeiraOpcaoObjetivosEmAndamentoNaLista;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_visualize")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
    private MobileElement botaoOk;

    public ComprovanteObjetivosTela(AppiumDriver driver) {
        super(driver);
    }

    /**Tocar botão objetivos finalizados
     * @return
     * @throws Exception
     */
    public ComprovanteObjetivosTela tocarBotaoObjetivosFinalizados() throws Exception {

        aguardarCarregamentoElemento(objetivosFinalizados);
        tocarElemento(objetivosFinalizados,"Nao foi possivel tocar botao objetivos finalizados");
        salvarEvidencia("Tocar botao 'objetivos finalizados'");
        return this;
    }

    /**Tocar primeira opcao da lista de objetivos em andamento
     * @return
     * @throws Exception
     */
    public ComprovanteObjetivosTela tocarPrimeiraOpcaoObjetivosEmAndamentoLista() throws Exception{
        aguardarCarregamentoElemento(botaoPrimeiraOpcaoObjetivosEmAndamentoNaLista);
        salvarEvidencia("Tocar na primeira opcao da lista de objetivos em andamento");
        tocarElemento(botaoPrimeiraOpcaoObjetivosEmAndamentoNaLista, "Nao foi possivel tocar na primeira opcao objetivos em andamento na lista");
        return this;
    }

    /**
     * Validar 'Comprovantes e Extrato'
     * @return
     * @throws Exception
     */
    @Step("Validar Comprovantes e Extrato")
    public ComprovanteObjetivosTela validarComprovantesEExtrato() throws Exception {
        validarCondicaoBooleana(!aguardarPaginaConterQualquerTexto(
                        MensagensObjetivos.TEXTOS_COMPROVANTES_E_EXTRATOS).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Tela de 'Comprovantes e Extrato' não está presente!");
        salvarEvidencia("Tela com 'Comprovantes e Extrato' presente!");
        return this;
    }

    /**Tocar botao ok
     * @return
     * @throws Exception
     */
    public ComprovanteObjetivosTela tocarBotaoOk() throws Exception{
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Tocar no botao ok");
        tocarElemento(botaoOk, "Nao foi possivel tocar no botao ok");
        return this;
    }
}
