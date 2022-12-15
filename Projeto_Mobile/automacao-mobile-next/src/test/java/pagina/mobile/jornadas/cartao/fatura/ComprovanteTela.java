package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.Mensagem;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.qameta.allure.Step;

public class ComprovanteTela extends PaginaBase {

    //botao compartilhar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_share_code")
    private MobileElement tocarCompartilharBoleto;  //sem mapeamento IOS

    //botao voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_share_code")
    private MobileElement tocarVoltar;   //sem mapeamento IOS

    public ComprovanteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao "Compartilhar"
     *FR
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Compartilhar\"")
    public ComprovanteTela tocarBotaoCompartilhar() throws Exception {
        salvarEvidencia("Tocar no botao \"Compartilhar\"");
        tocarElemento(tocarCompartilharBoleto, "Não foi possível tocar no botao \"Compartilhar\"");
        return this;
    }

    /**
     * Tocar botao "voltar"
     *FR
     *
     * @throws Exception
     */
    @Step("Tocar botao \"voltar\"")
    public ComprovanteTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no botao \"voltar\"");
        tocarElemento(tocarVoltar, "Não foi possível tocar no botao \"voltar\"");
        return this;
    }

    /**
     * validar Texto de Compartilhamento"
     *fr
     *
     * @throws Exception
     */
    @Step("validar texto tela \"Aplicativos Compartilhamento\"")
    public ComprovanteTela validarTituloTela() throws Exception {
        salvarEvidencia("validar Texto tela \"Aplicativos Compartilhamento\"");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagem.COMPLETE_ACAO_USANDO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Complete a ação usando' não está presente na tela!");
        return this;
    }
}
