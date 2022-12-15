package pagina.mobile.jornadas.pix.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pix.Mensagens;
import constantes.pix.Pix;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class    SucessoTela extends PaginaBase {

    @AndroidFindBy(xpath = "//*[@text='VOLTAR AO PIX']")
    @iOSXCUITFindBy(xpath = "//*[@name='VOLTAR AO PIX']")
    private MobileElement botaoVoltarAoPix;

    public SucessoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar mensagem 'Sua transa��o Pix foi realizada com sucesso'
     * @return SucessoTela
     */
    @Step("Validar mensagem 'Sua transa��o Pix foi realizada com sucesso'")
    public SucessoTela validarMensagemTransacaoRealizada() {
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(Mensagens.TRANSACAO_PIX_REALIZADA_COM_SUCESSO),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar mensagem 'Sua transa��o Pix foi realizada com sucesso'");
        salvarEvidencia("Validada mensagem 'Sua transa��o Pix foi realizada com sucesso'");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar ao PIX'
     *
     * @return SucessoTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar ao PIX'")
    public SucessoTela tocarBotaoVoltarAoPIX() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar ao PIX'");
        tocarElemento(botaoVoltarAoPix, "N�o foi poss�vel tocar bot�o 'Voltar ao PIX'");
        return this;
    }

}
