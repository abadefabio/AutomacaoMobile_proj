package pagina.mobile.jornadas.cartao.servicos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AvisoViagemTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Lista']")
    private MobileElement botaoTresPontosCantoSuperiorDireito;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_remove_travel")
    private MobileElement botaoExcluirAvisoViagem;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Vai cancelar a viagem mesmo?']")
    private MobileElement tituloTelaExcluirAvisoViagem;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_left")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Sim']")
    private MobileElement botaoSimExcluirNaTelaExcluirAvisoViagem;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    private MobileElement botaoOk;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and contains(@text, 'Faltam')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Faltam']")
    private MobileElement textoFaltamAvisoViagem;

    public AvisoViagemTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a do texto 'FALTAM DO AVISO VIAGEM'
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Validar presen�a do texto 'FALTAM DO AVISO VIAGEM'")
    public AvisoViagemTela validarTextoFaltamDoAvisoViagem() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(retornarTexto(textoFaltamAvisoViagem, "N�o foi poss�vel localizar o texto 'FALTAM'")), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'FALTAM DO AVISO VIAGEM' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a do texto 'FALTAM DO AVISO VIAGEM'");
        return this;
    }

    /**
     * Tocar nos tr�s pontinhos canto superior direito da tela
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Tocar nos tr�s pontinhos canto superior direito da tela")
    public AvisoViagemTela tocarNosTresPontinhosNoCantoSuperiorDireito() throws Exception {
        salvarEvidencia("Tocar nos tr�s pontinhos canto superior direito da tela");
        tocarElemento(botaoTresPontosCantoSuperiorDireito, "N�o foi possivel tocar nos tr�s pontinhos canto superior direito da tela");
        return this;
    }

    /**
     * Tocar bot�o 'Excluir Aviso Viagem'
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Excluir Flow'")
    public AvisoViagemTela tocarBotaoExcluirAvisoViagem() throws Exception {
        salvarEvidencia("Tocar bot�o 'Excluir Aviso Viagem'");
        if (android) {
            tocarElemento(botaoExcluirAvisoViagem,"N�o foi possivel tocar no bot�o 'Excluir Aviso Viagem'");
        }
        else {
            tocarCoordenada(109, 201);
        }
        return this;
    }

    /**
     * Validar exibi��o da tela de 'Excluir Aviso Viagem'
     * @return AvisoViagemTela
     */
    @Step("Validar exibi��o da tela de 'Excluir Aviso Viagem'")
    public AvisoViagemTela validarTelaExcluirAvisoViagem(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloTelaExcluirAvisoViagem),
                MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exibi��o da tela 'Excluir Aviso Viagem'");
        salvarEvidencia("Validou exibi��o da tela de 'Excluir Aviso Viagem'");
        return this;
    }

    /**
     * Tocar bot�o 'SIM, EXCLUIR'
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'SIM, EXCLUIR'")
    public AvisoViagemTela tocarBotaoSimExcluir() throws Exception {
        salvarEvidencia("Tocar bot�o 'SIM, EXCLUIR'");
        tocarElemento(botaoSimExcluirNaTelaExcluirAvisoViagem, "N�o foi possivel tocar no bot�o 'SIM, EXCLUIR'");
        return this;
    }

    /**
     * Validar exibi��o da tela de 'Aviso de Viagem cancelado'
     * @return AvisoViagemTela
     */
    @Step("Validar exibi��o da tela de 'Aviso de Viagem cancelado'")
    public AvisoViagemTela validarTelaAvisoViagemCancelado(){
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.TELA_AVISO_VIAGEM_CANCELADO),
                MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exibi��o da tela 'Aviso de Viagem cancelado'");
        salvarEvidencia("Validou exibi��o da tela de 'Aviso de Viagem cancelado'");
        return this;
    }

    /**
     * Tocar bot�o 'OK'
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'OK'")
    public AvisoViagemTela tocarBotaoOk() throws Exception {
        salvarEvidencia("Tocar bot�o 'OK'");
        tocarElemento(botaoOk, "N�o foi possivel tocar no bot�o 'OK'");
        return this;
    }
}
