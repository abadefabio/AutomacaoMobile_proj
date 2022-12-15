package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.open.finance.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EncerrarCompartilhamentoTela extends PaginaBase {
    public EncerrarCompartilhamentoTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "VER COMPROVANTE")
    private MobileElement botaoVerComprovante;

    /**
     * Validar presen�a da mensagem 'Compartilhamento Encerrado com sucesso'
     *
     * @return EncerrarCompartilhamentoTela
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Compartilhamento Encerrado com sucesso'")
    public EncerrarCompartilhamentoTela validarPresencaMensagemCompartilhamentoEncerradoComSucesso() throws Exception {
        validarCondicaoBooleana(!aguardarPaginaConterQualquerTexto(
                Mensagens.MSG_COMPARTILHAMENTO_ENCERRADO_COM_SUCESSO).equals("") , MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Compartilhamento Encerrado com sucesso' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da mensagem 'Compartilhamento Encerrado com sucesso' na tela");
        return this;
    }

    /**
     * Tocar bot�o 'Ver Comprovante'
     *
     * @return EncerrarCompartilhamentoTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ver Comprovante'")
    public EncerrarCompartilhamentoTela tocarBotaoVerComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoVerComprovante);
        salvarEvidencia("Tocar bot�o 'Ver Comprovante'");
        tocarElemento(botaoVerComprovante, "N�o foi poss�vel tocar no bot�o 'Ver Comprovante'");
        return this;
    }
}
