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


public class PassoQuatroDeSeisTela extends PaginaBase{

    public PassoQuatroDeSeisTela(AppiumDriver driver) {
        super(driver);
    }

    //Mensagem foto
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_container_msg")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'precisamos de fotos')]")
    private MobileElement mensagemFoto;

    //bot�o Voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    private MobileElement botaoVoltar;

    /**
     *Validar mensagem foto
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem \"Foto\"")
    public PassoQuatroDeSeisTela validarMensagemFoto() throws Exception{
        boolean mensagem = aguardarCarregamentoElemento(mensagemFoto);
        validarCondicaoBooleana(mensagem, MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Agora precisamos de uma foto do seu documento de identifica��o' n�o est� presente!");
        salvarEvidencia("Valida mensagem Foto");
        return this;
    }

    /**
     * Tocar bot�o voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public PassoQuatroDeSeisTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar bot�o Voltar");
        tocarElemento(botaoVoltar,"N�o foi poss�vel tocar o bot�o Voltar");
        return this;
    }
}
