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
     * Validar mensagem 'Sua transação Pix foi realizada com sucesso'
     * @return SucessoTela
     */
    @Step("Validar mensagem 'Sua transação Pix foi realizada com sucesso'")
    public SucessoTela validarMensagemTransacaoRealizada() {
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(Mensagens.TRANSACAO_PIX_REALIZADA_COM_SUCESSO),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar mensagem 'Sua transação Pix foi realizada com sucesso'");
        salvarEvidencia("Validada mensagem 'Sua transação Pix foi realizada com sucesso'");
        return this;
    }

    /**
     * Tocar botão 'Voltar ao PIX'
     *
     * @return SucessoTela
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar ao PIX'")
    public SucessoTela tocarBotaoVoltarAoPIX() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar ao PIX'");
        tocarElemento(botaoVoltarAoPix, "Não foi possível tocar botão 'Voltar ao PIX'");
        return this;
    }

}
