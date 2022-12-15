package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class PassoCincoDeSeisTela extends PaginaBase{

    public PassoCincoDeSeisTela(AppiumDriver driver) {
        super(driver);
    }

    //Mensagem v�deo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/next_text_view_32")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"um v�deo seu.\"$]")
    private MobileElement mensagemVideo;

    //bot�o Voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    private MobileElement botaoVoltar;

    /**
     *Validar mensagem v�deo
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem \"Video\"")
    public PassoCincoDeSeisTela validarMensagemVideo() throws Exception{
        validarCondicaoBooleana(verificarPresencaElemento(mensagemVideo), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Agora, a gente precisa de um v�deo seu' n�o est� presente!");
        salvarEvidencia("Valida tela Complete Seu Cadastro");
        return this;
    }

    /**
     * Tocar bot�o voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public PassoCincoDeSeisTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar bot�o Voltar");
        tocarElemento(botaoVoltar,"N�o foi poss�vel tocar o bot�o Voltar");
        return this;
    }
}


