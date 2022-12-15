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
     * Validar presença da mensagem 'Compartilhamento Encerrado com sucesso'
     *
     * @return EncerrarCompartilhamentoTela
     * @throws Exception
     */
    @Step("Validar presença tela 'Compartilhamento Encerrado com sucesso'")
    public EncerrarCompartilhamentoTela validarPresencaMensagemCompartilhamentoEncerradoComSucesso() throws Exception {
        validarCondicaoBooleana(!aguardarPaginaConterQualquerTexto(
                Mensagens.MSG_COMPARTILHAMENTO_ENCERRADO_COM_SUCESSO).equals("") , MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Compartilhamento Encerrado com sucesso' não está presente na tela!");
        salvarEvidencia("Validada presença da mensagem 'Compartilhamento Encerrado com sucesso' na tela");
        return this;
    }

    /**
     * Tocar botão 'Ver Comprovante'
     *
     * @return EncerrarCompartilhamentoTela
     * @throws Exception
     */
    @Step("Tocar botão 'Ver Comprovante'")
    public EncerrarCompartilhamentoTela tocarBotaoVerComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoVerComprovante);
        salvarEvidencia("Tocar botão 'Ver Comprovante'");
        tocarElemento(botaoVerComprovante, "Não foi possível tocar no botão 'Ver Comprovante'");
        return this;
    }
}
