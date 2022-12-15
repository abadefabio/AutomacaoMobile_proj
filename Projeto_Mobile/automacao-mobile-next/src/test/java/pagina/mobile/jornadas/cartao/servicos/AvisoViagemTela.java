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
     * Validar presença do texto 'FALTAM DO AVISO VIAGEM'
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Validar presença do texto 'FALTAM DO AVISO VIAGEM'")
    public AvisoViagemTela validarTextoFaltamDoAvisoViagem() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(retornarTexto(textoFaltamAvisoViagem, "Não foi possível localizar o texto 'FALTAM'")), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'FALTAM DO AVISO VIAGEM' não está presente na tela!");
        salvarEvidencia("Validada presença do texto 'FALTAM DO AVISO VIAGEM'");
        return this;
    }

    /**
     * Tocar nos três pontinhos canto superior direito da tela
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Tocar nos três pontinhos canto superior direito da tela")
    public AvisoViagemTela tocarNosTresPontinhosNoCantoSuperiorDireito() throws Exception {
        salvarEvidencia("Tocar nos três pontinhos canto superior direito da tela");
        tocarElemento(botaoTresPontosCantoSuperiorDireito, "Não foi possivel tocar nos três pontinhos canto superior direito da tela");
        return this;
    }

    /**
     * Tocar botão 'Excluir Aviso Viagem'
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Tocar botão 'Excluir Flow'")
    public AvisoViagemTela tocarBotaoExcluirAvisoViagem() throws Exception {
        salvarEvidencia("Tocar botão 'Excluir Aviso Viagem'");
        if (android) {
            tocarElemento(botaoExcluirAvisoViagem,"Não foi possivel tocar no botão 'Excluir Aviso Viagem'");
        }
        else {
            tocarCoordenada(109, 201);
        }
        return this;
    }

    /**
     * Validar exibição da tela de 'Excluir Aviso Viagem'
     * @return AvisoViagemTela
     */
    @Step("Validar exibição da tela de 'Excluir Aviso Viagem'")
    public AvisoViagemTela validarTelaExcluirAvisoViagem(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloTelaExcluirAvisoViagem),
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição da tela 'Excluir Aviso Viagem'");
        salvarEvidencia("Validou exibição da tela de 'Excluir Aviso Viagem'");
        return this;
    }

    /**
     * Tocar botão 'SIM, EXCLUIR'
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Tocar botão 'SIM, EXCLUIR'")
    public AvisoViagemTela tocarBotaoSimExcluir() throws Exception {
        salvarEvidencia("Tocar botão 'SIM, EXCLUIR'");
        tocarElemento(botaoSimExcluirNaTelaExcluirAvisoViagem, "Não foi possivel tocar no botão 'SIM, EXCLUIR'");
        return this;
    }

    /**
     * Validar exibição da tela de 'Aviso de Viagem cancelado'
     * @return AvisoViagemTela
     */
    @Step("Validar exibição da tela de 'Aviso de Viagem cancelado'")
    public AvisoViagemTela validarTelaAvisoViagemCancelado(){
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.TELA_AVISO_VIAGEM_CANCELADO),
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição da tela 'Aviso de Viagem cancelado'");
        salvarEvidencia("Validou exibição da tela de 'Aviso de Viagem cancelado'");
        return this;
    }

    /**
     * Tocar botão 'OK'
     *
     * @return AvisoViagemTela
     * @throws Exception
     */
    @Step("Tocar botão 'OK'")
    public AvisoViagemTela tocarBotaoOk() throws Exception {
        salvarEvidencia("Tocar botão 'OK'");
        tocarElemento(botaoOk, "Não foi possivel tocar no botão 'OK'");
        return this;
    }
}
