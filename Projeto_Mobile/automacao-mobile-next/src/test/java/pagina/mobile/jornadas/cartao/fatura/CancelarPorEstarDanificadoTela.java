package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.Mensagens;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CancelarPorEstarDanificadoTela  extends PaginaBase {


    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "//*[@name='CONTINUAR']")
    private MobileElement botaoContinuar;

    public CancelarPorEstarDanificadoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Cancelar por estar danificado'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Cancelar por estar danificado'")
    public CancelarPorEstarDanificadoTela validarTelaCancelarPorEstarDanificado() throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CANCELAR_POR_ESTAR_DANIFICADO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'CANCELAR POR ESTAR DANIFICADO' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'CANCELAR POR ESTAR DANIFICADO'");
        return this;
    }

    /**
     * Validar avisos de cancelamento de cartao
     *
     * @throws Exception
     */
    @Step("Validar avisos de cancelamento de cartao")
    public CancelarPorEstarDanificadoTela validarAvisosCancelamentoCartao() throws Exception {

        validarCondicaoBooleana(
                !aguardarPaginaConterQualquerTexto(Mensagens.MENSAGENS_CANCELAMENTO_POR_ESTAR_DANIFICADO).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Avisos de cancelamento de cartao est� presente na tela!");
        salvarEvidencia("Validada presen�a de avisos de cancelamento de cartao");
        return this;
    }

    /**
     * Tocar botao 'Continuar'
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao 'Continuar'")
    public CancelarPorEstarDanificadoTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar no botao'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no botao 'Continuar'");
        return this;
    }


}
