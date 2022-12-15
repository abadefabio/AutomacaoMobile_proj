package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.objetivos.MensagensObjetivos;
import constantes.objetivos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ObjetivosTela extends PaginaBase {

    //botao criar novo objetivo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Criar novo Objetivo\"]]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Criar novo Objetivo\"`]")
    private MobileElement criarNovoObjetivo;

    // botao Meus objetivos
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Meus Objetivos\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Meus Objetivos\"`]")
    @AndroidFindBy(id="br.com.bradesco.next:id/discover_profile")
    @AndroidFindBy(xpath="//*[contains(@text,\"Meus Objetivos\")]")
    private MobileElement botaoMeusObjetivos;

    // voltar menu - Menu hamburgue
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar para o Menu\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar para o Menu\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Menu, Bot�o\"]")
    private MobileElement botaoVoltar;

    // btn Lista - tres ponto ...
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Lista")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Lista\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Lista\"]") // add map marcos
    @AndroidFindBy(accessibility = "Menu Objetivos")
    @AndroidFindBy(id="br.com.bradesco.next:id/item_menu_goals")
    private MobileElement botaoListaTresPontos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_edit_category")
    @iOSXCUITFindBy(accessibility = "Perfil de investidor")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"icon-contact\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    private MobileElement botaoPerfilInvestidor;

    // btn criar objetivo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/create_goals")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_create_goals")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_objective")
    @iOSXCUITFindBy(accessibility = "Criar objetivo")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Criar novo Objetivo\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Criar objetivo\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Criar novo Objetivo\"]")
    private MobileElement botaoCriarObjetivo;

    // descobrir perfil
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/discover_profile")
    @iOSXCUITFindBy(accessibility = "Descobrir perfil")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Descobrir perfil\"]")
    private MobileElement botaoDescobrirPerfil;

    // texto tela - 'Com os Objetivos voc� faz acontecer seu sonho.'
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Com os Objetivos voc� faz acontecer seu sonho.")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Com os Objetivos voc� faz acontecer seu sonho.\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Com os Objetivos\")]")
    private  MobileElement textoComOsObjetivosVoce;

    // botao Informa��es - I
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"OBJETIVOS\"`]/XCUIElementTypeButton[2]")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeNavigationBar[@name=\"OBJETIVOS\"]/XCUIElementTypeButton[2]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_option")
    private MobileElement botaoInformacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_option")
    @AndroidFindBy(accessibility = "Informa��es, bot�o")
    @AndroidFindBy(xpath = "//me.next.uikit.NextNavigationIcon[@content-desc=\"Informa��es, bot�o\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/next_text_view_details")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextViewWithDrawDetailsAchieved")
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_right_icon")
    @iOSXCUITFindBy(accessibility = "DETALHES")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"DETALHES\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"DETALHES\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"OBJETIVOS\"]/XCUIElementTypeButton[2]")
    private MobileElement botaoDetalhes;

    //botao aporte
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"APORTE\"`][1]")//primeiro item da sequencia
    @iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"APORTE\"])[1]")//primeiro item da sequencia
    @AndroidFindBy(id="br.com.bradesco.next:id/next_text_view_contribution")
    @AndroidFindBy(xpath="//*[contains(@text,\"APORTE\")]")
    private MobileElement botaoAporte;

    //titulo da tela
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"OBJETIVOS\"`]")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OBJETIVOS\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @AndroidFindBy(id="br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,\"OBJETIVOS\")]")
    @AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"OBJETIVOS\"]")
    private MobileElement textoTituloTela;

    //botao ver meus objetivos
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Ver meus objetivos\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ver meus objetivos\"]")
    @AndroidFindBy(id="br.com.bradesco.next:id/create_goals")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,\"Ver meus objetivos\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Ver meus objetivos\")]")
    private MobileElement botaoVerMeusObjetivos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/next_text_view_number_of_ongoing_and_achieved_goals")
    private MobileElement textoZeroObjetivoCriado;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_edit_category")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Perfil de investidor\"]/../../XCUIElementTypeButton\n")
    @iOSXCUITFindBy(accessibility = "Perfil de investidor")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"icon-contact\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    private MobileElement itemListaPerfilInvestidor;

    public ObjetivosTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar bot�o Voltar criar novo objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Criar Objetivo\"")
    public ObjetivosTela tocarCriarObjetivo() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Criar Objetivo ou Ver meus objetivos'");
        tocarElemento(botaoCriarObjetivo, "N�o foi poss�vel Tocar no bot�o Criar Objetivo");
        return this;
    }

    /**
     * Tocar bot�o 'APORTE' objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'APORTE'")
    public ObjetivosTela tocarBotaoAporte() throws Exception {
        rolarTela(0.9, 0.1);
        salvarEvidencia("Tocar no bot�o 'APORTE'");
        tocarElemento(botaoAporte, "N�o foi poss�vel Tocar no bot�o 'APORTE'");
        return this;
    }

    /**
     * Tocar bot�o Voltar Menu Hamburguer
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o 'Voltar Menu Principal'")
    public ObjetivosTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Voltar menu principal'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar menu principal'");
        return this;
    }

    /**
     * Clicar bot�o Meus Objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Meus Objetivo\"")
    public ObjetivosTela tocarMeusObjetivos() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Meus Objetivos'");
        aguardarCarregamentoElemento(botaoMeusObjetivos);
        tocarElemento(botaoMeusObjetivos, "N�o foi poss�vel tocar no bot�o Meus Objetivos");
        return this;
    }

    /**
     * Tocar no bot�o 'Detalhes'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Detalhes'")
    public ObjetivosTela tocarBotaoDetalhes() throws Exception {
        rolarTela(0.9, 0.1);
        aguardarCarregamentoElemento(botaoDetalhes);
        salvarEvidencia("Tocar no bot�o 'Detalhes'");
        tocarElemento(botaoDetalhes, "N�o foi poss�vel tocar no 'Detalhes'");
        return this;
    }

    /**
     * Validar que esta na tela de objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Objetivos\"")
    public ObjetivosTela validarEstarTelaObjetivos() throws Exception {
        salvarEvidencia("Valida estar na tela de 'Objetivos'");
        validarCondicaoBooleana((aguardarCarregamentoQualquerElemento(textoComOsObjetivosVoce,textoTituloTela) != -1),
                MetodoComparacaoBooleano.VERDADEIRO, "erro ao verificar titulo da tela");
        return this;
    }

    /**
     * Clicar bot�o "Descobrindo seu perfil"
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Descobrindo seu perfil\"")
    public ObjetivosTela tocarBotaoDescobrindoSeuPerfil() throws Exception {
        aguardarCarregamentoElemento(botaoDescobrirPerfil); //neste caso em especifico � preciso deixar.
        salvarEvidencia("Tocar no bot�o 'Descobrindo seu perfil.'");
        tocarElemento(botaoDescobrirPerfil, "N�o foi poss�vel Tocar no descobrindoseu perfil.");
        return this;
    }

    /**
     * Validar tela "Objetivo"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Objetivo\"")
    public ObjetivosTela validarTextoTelaObjetivos() throws Exception{
        verificarPresencaElemento(textoTituloTela);
        salvarEvidencia("Validar tela objetivo");
        return this;
    }


    /**
     * Verifica se a tela primeiro acesso est� presente e caso estiver clicar no bot�o 'Ver objetivos'
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar se a tela primeiro acesso est� presente e caso estiver clicar no bot�o 'Ver objetivos'")
    public ObjetivosTela verificarBotaoVerMeusObjetivosEstaPresente() throws Exception {
        if (aguardarCarregamentoElemento(botaoVerMeusObjetivos)){
            tocarCriarObjetivo();
        }
        return this;
    }

    /**
     * Validar 'Tutorial' primeiro acesso � Objetivos
     *
     * @return ObjetivosTela
     * @throws Exception
     */
    @Step("Validar 'Tutorial' Objetivos")
    public ObjetivosTela validarTutorial() throws Exception {
        validarCondicaoBooleana(!aguardarPaginaConterQualquerTexto(
                        MensagensObjetivos.TEXTOS_COM_OS_OBJETIVOS_VOCE_FAZ_ACONTECER_SEU_SONHO).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Tela de 'Tutorial' n�o est� presente!");
        salvarEvidencia("Tela de 'Tutorial' presente!");
        return this;
    }

    /**
     * Validar 'Objetivos Criados'
     *
     * @return ObjetivosTela
     * @throws Exception
     */
    @Step("Validar 'Objetivos Criados'")
    public ObjetivosTela validarObjetivosCriados() throws Exception {
        validarCondicaoBooleana(!aguardarPaginaConterQualquerTexto(
                        MensagensObjetivos.TEXTOS_OBJETIVOS_CRIADOS).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Tela com total de 'Objetivos Criados' n�o est� presente!");
        salvarEvidencia("Tela com total de 'Objetivos Criados' presente!");
        return this;
    }

    /**
     * Validar que esta na tela de objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Objetivos\"")
    public ObjetivosTela validarTelaObjetivos() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.OBJETIVOS.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Objetivos' n�o est� presente na tela!");
        salvarEvidencia("validar que esta na tela de 'Objetivos'");
        return this;
    }

    /**
     * Tocar no bot�o 'Ver meus objetivos'
     *
     * @return ObjetivosTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Ver oeus objetivos'")
    public ObjetivosTela tocarBotaoVerMeusObjetivos() throws NextException {
        if(verificarPresencaElemento(botaoVerMeusObjetivos)){
            salvarEvidencia("Tocar no bot�o 'Ver meus objetivos'");
            tocarElemento(botaoVerMeusObjetivos,"Erro ao tocar no Bot�o 'Ver meus objetivos'");
        }
        return this;
    }

    /**
     * Tocar no Bot�o (header) "..."
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o (header) \"...\"")
    public ObjetivosTela tocarBotaoHeaderListaTresPontos() throws NextException {
        tocarElemento(botaoListaTresPontos,"Erro ao tocar no Bot�o '...'");
        salvarEvidencia("Tocou no bot�o do header '...'");
        return this;
    }

    /**
     * Tocar no menu 'Perfil de Investidor'
     * @return
     * @throws NextException
     */
    @Step("Tocar no item da lista \"Perfil de Investidor\"")
    public ObjetivosTela tocarBotaoPerfilInvestidor() throws NextException {
        tocarElemento(itemListaPerfilInvestidor,"Erro ao tocar no Bot�o '...'");
        salvarEvidencia("Tocou no item da lista 'Perfil Investidor'");
        return this;
    }

    /**
     * Verifica se a tela primeiro acesso est� presente e caso estiver clicar no bot�o 'Ver objetivos'
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar se a tela primeiro acesso est� presente e caso estiver clicar no bot�o 'Ver objetivos' e criar objetivos")
    public ObjetivosTela verificarBotaoVerMeusObjetivosECriarEstaoPresentes() throws Exception {
        if (aguardarCarregamentoElemento(botaoVerMeusObjetivos))
            tocarElemento(botaoVerMeusObjetivos,"Erro ao tocar no bot�o 'Ver Meus Objetivos'");

        return this;
    }

    /**
     * Verificar o elemento '0 objetivo criado'
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar elemento '0 objetivo criado' e 'Swipe'")
    public ObjetivosTela verificarElementoZeroObjetivoCriado() throws Exception{
        verificarPresencaElemento(textoZeroObjetivoCriado);
        rolarTelaAteFinal();
        salvarEvidencia("Verificar elemento '0 objetivo criado' e 'Swipe'");
        return this;
    }

    /**
     * Rolar tela de baixo para cima
     * @return ObjetivosTela
     * @throws Exception
     */
    @Step("Realizar o Swipe de baixo para cima")
    public ObjetivosTela rolarTelaCima() throws Exception{
        rolarTela(0.9,0.1);
        return this;
    }

    /**
     * Tocar no bot�o (i) 'Informa��es'
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o (i) 'Informa��es'")
    public ObjetivosTela tocarBotaoInformacoes() throws NextException {
        salvarEvidencia("Tocar bot�o (i) 'Informa��es'");
        tocarElemento(botaoInformacoes,"Erro ao tocar no Bot�o (i) 'Informa��es'");
        return this;
    }
}
