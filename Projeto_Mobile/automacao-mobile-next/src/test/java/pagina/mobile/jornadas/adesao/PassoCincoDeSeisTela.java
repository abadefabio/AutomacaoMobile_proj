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

    //Mensagem vídeo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/next_text_view_32")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"um vídeo seu.\"$]")
    private MobileElement mensagemVideo;

    //botão Voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    private MobileElement botaoVoltar;

    /**
     *Validar mensagem vídeo
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem \"Video\"")
    public PassoCincoDeSeisTela validarMensagemVideo() throws Exception{
        validarCondicaoBooleana(verificarPresencaElemento(mensagemVideo), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Agora, a gente precisa de um vídeo seu' não está presente!");
        salvarEvidencia("Valida tela Complete Seu Cadastro");
        return this;
    }

    /**
     * Tocar botão voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public PassoCincoDeSeisTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar botão Voltar");
        tocarElemento(botaoVoltar,"Não foi possível tocar o botão Voltar");
        return this;
    }
}


