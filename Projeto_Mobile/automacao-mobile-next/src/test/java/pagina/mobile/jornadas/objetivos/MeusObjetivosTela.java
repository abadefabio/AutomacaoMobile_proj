package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MeusObjetivosTela extends PaginaBase {

    //validar presenca do primeiro card objetivo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/view_goals\"])[1]")
    @AndroidFindBy(xpath = "(//*[@resource-id='br.com.bradesco.next:id/view_goals' and @class='android.widget.FrameLayout'])[1]")
    @iOSXCUITFindBy(xpath ="(//*[@type=\"XCUIElementTypeCell\"])[2]")
    @iOSXCUITFindBy(xpath = "((//*[@type=\"XCUIElementTypeCell\"])[3]/preceding-sibling::XCUIElementTypeCell)[2]")
    private MobileElement containerPrimeiroCard;

    //validar icone objetivo celular
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "goal_type_14")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"goal_type_14\"`]")
    @AndroidFindBy(id="br.com.bradesco.next:id/iv_category")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"br.com.bradesco.next:id/iv_category\"]")
    private MobileElement imagemObjetivoCelular;

    //valor da aplicacao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Valor da aplicação\"]/following-sibling::XCUIElementTypeTextField")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_amount")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"br.com.bradesco.next:id/et_amount\"]")
    private MobileElement comboValorAplicacao;

    //botao continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Continuar\")]")
    private MobileElement botaoContinuar;

    //botao aporte
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"APORTE\"`][1]")//primeiro item da sequencia
    @iOSXCUITFindBy(xpath="(//XCUIElementTypeButton[@name=\"APORTE\"])[1]")//primeiro item da sequencia
    @AndroidFindBy(xpath = "(//*[@class=\"android.widget.TextView\" and @resource-id=\"br.com.bradesco.next:id/next_text_view_contribution\"])[1]")
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/next_text_view_contribution\"])[1]")
    private MobileElement botaoAporte;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextViewWithDrawDetailsAchieved")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Detalhes\"`]")
    private MobileElement botaoDetalhes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/next_text_view_details")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"DETALHES\"`]")
    private MobileElement detalhes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/next_text_view_with_draw")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_redeem_goal")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"RESGATE\"`]")
    private MobileElement botaoResgate;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextViewWithDraw")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_redeem_goal")
    @iOSXCUITFindBy(accessibility = "Resgatar Objetivo")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Resgatar Objetivo\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"RESGATE\"`]")
    private MobileElement botaoResgateObjetivoConcluido;

    public MeusObjetivosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Verificar a presenca do primeiro card do objetivo cadastrado
     * @return MeusObjetivosTela
     * @throws Exception
     */
    @Step("Verificar a presenca do primeiro card cadastrado")
    public MeusObjetivosTela validarPresencaCardObjetivo()throws Exception{
        validarCondicaoBooleana(verificarPresencaElemento(containerPrimeiroCard), MetodoComparacaoBooleano.VERDADEIRO,"Nao foi possivel localizar o primeiro card");
        salvarEvidencia("Verificar a presenca do primeiro card cadastrado");
        return this;
    }

    /**
     * Tocar no botao aporte
     * @return MeusObjetivosTela
     * @throws Exception
     */
    @Step("Tocar  botao \"APORTE\"")
    public MeusObjetivosTela tocarBotaoAporte()throws Exception{
        salvarEvidencia("Tocar no botao aporte");
        tocarElemento(botaoAporte,"Nao foi possivel tocar no botao aporte");
        return this;
    }

    /**
     * Tocar detalhes
     *
     * @return
     * @throws Exception
     */
    @Step("Realizar swipe e tocar em \"Detalhes\"")
    public MeusObjetivosTela tocarDetalhes() throws Exception{
        rolarTelaAteFinal();
        tocarElemento(detalhes,"Não foi possível tocar em detalhes");
        salvarEvidencia("Realizar swipe e tocar em detalhes");
        return this;
    }

    /**
     * Tocar botão detalhes
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Detalhes\"")
    public MeusObjetivosTela tocarBotaoDetalhes() throws Exception{
        tocarElemento(botaoDetalhes,"Não foi possível tocar no botão detalhes");
        salvarEvidencia("Tocar no botão detalhes");
        return this;
    }

    /**
     * Tocar resgate
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Resgate\"")
    public MeusObjetivosTela tocarResgate() throws Exception{
        tocarElemento(botaoResgate,"Não foi possível tocar no botão resgate");
        salvarEvidencia("Tocar no botão resgate");
        return this;
    }

    /**
     * Tocar aporte
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Aporte\"")
    public MeusObjetivosTela tocarAporte() throws Exception{
        tocarElemento(botaoAporte,"Não foi possível tocar no botão aporte");
        salvarEvidencia("Tocar no botão aporte");
        return this;
    }

    /**
     * Tocar botão resgate de objetivo concluido
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Resgate\"")
    public MeusObjetivosTela tocarResgateObjetivoConcluido() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoResgateObjetivoConcluido,"Não foi possível encontrar o botão resgate");
        salvarEvidencia("Tocar no botão resgate");
        tocarElemento(botaoResgateObjetivoConcluido,"Não foi possível tocar no botão resgate");
        return this;
    }

    /**
     * Rolar tela baixo e Tocar botão resgate de objetivo
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Resgate\"")
    public MeusObjetivosTela rolarTelaBaixoEtocarResgate() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoResgate,"Não foi possível encontrar o botão resgate");
        salvarEvidencia("Tocar no botão resgate");
        tocarElemento(botaoResgate,"Não foi possível tocar no botão resgate");
        return this;
    }
}
