package pagina.mobile.jornadas.objetivos.criarObjetivo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ConfirmeDadosObjetivoTela extends PaginaBase {
    //botao voltar <
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    private MobileElement botaoVoltar;

    // texto tipo de objetivo
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_type_confirm")
    @iOSXCUITFindBy(accessibility = "Tipo do objetivo")
    private MobileElement tipoObjetivo;

    // texto nome de objetivo
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name_confirm")
    @iOSXCUITFindBy(accessibility = "Nome do objetivo")
    private MobileElement nomeObjetivo;

    // texto valor objetivo
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value_confirm")
    @iOSXCUITFindBy(accessibility = "Valor do objetivo")
    private MobileElement valorObjetivo;

    // texto prazo
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_deadline_confirm")
    private MobileElement prazoObjetivo;

    // texto parcela mensal
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_quota_confirm")
    private MobileElement parcelaObjetivo;

    // texto data parcela
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_date_confirm")
    private MobileElement dataObjetivo;

    //Checkbox termos e condicoes
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_check")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Investimento onde seu dinheiro vai ficar rendendo.\"]/../XCUIElementTypeButton[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
    private  MobileElement checkTermosCondicoes;

    // tocar termos condicoes para ver regras
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_arrow")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Li e aceito os termos & condições.\"])")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"ic_arrow_right_black\"])[2]")
    private MobileElement tocarTermosCondicoes;

    //botao criar objetivo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_create_goal")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Criar Objetivo\"])[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Criar Objetivo\"`][1]")
    private MobileElement botaoCriarObjetivo;

    public ConfirmeDadosObjetivoTela(AppiumDriver driver) {
        super(driver);
    }

    @Step("Aguardar Tela Confirme OsDados")
    public ConfirmeDadosObjetivoTela aguardarTelaConfirmeOsDados(){
        OperadorEvidencia.logarPasso("Aguardando a tela 'Confirme os dados'.");
        aguardarPaginaConterTodosTextos("Confirme os dados");
        salvarEvidencia("Aguardando a tela 'Confirme os dados'.");
        return this;
    }


    /**
     * Tocar botao Voltar ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Voltar <\"")
    public ConfirmeDadosObjetivoTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("'clicar botao Voltar'");
        tocarElemento(botaoVoltar, "Erro ao clicar botao Voltar");
        return this;
    }

    /**
     * validar tipo objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Validar  \"Tipo\"")
    public ConfirmeDadosObjetivoTela validarTipoObjetivo(String tipo) throws Exception {
        aguardarCarregamentoElemento(tipoObjetivo);
        salvarEvidencia("'validar tipo objetivo'");
        if (android){
            validarAtributoTexto(tipoObjetivo,tipo,"Erro ao validar o tipo de objetivo");
        }else {
            verificarPresencaElemento(tipoObjetivo);
        }
        return this;
    }

    /**
     * validar Nome objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Validar  \"Nome\"")
    public ConfirmeDadosObjetivoTela validarNomeObjetivo(String nome) throws Exception {
        salvarEvidencia("'validar Nome do objetivo'");
        if (android){
            validarAtributoTexto(nomeObjetivo,nome,"Erro ao validar o Nome de objetivo");
        }else {
            verificarPresencaElemento(nomeObjetivo);
        }
        return this;
    }

    /**
     * validar Valor objetivo
     *
     * @return
     * @throws Exception
     * @param valor
     */
    @Step("Validar  \"Valor\"")
    public ConfirmeDadosObjetivoTela validarValorObjetivo(String valor) throws Exception {
        salvarEvidencia("'validar valor do objetivo'");
        if (android){
            compararElementoTexto(valorObjetivo, valor, MetodoComparacao.CONTEM);
        }else {
            verificarPresencaElemento(valorObjetivo);
        }
        return this;
    }

    /**
     * tocar check  "Termos Condicoes
     *
     * @return
     * @throws Exception
     */
    @Step("tocar check  \"Termos Condicoes\"")
    public ConfirmeDadosObjetivoTela tocarCheckTermosCondicoes() throws Exception {
        if(android) rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkTermosCondicoes,"Erro ao rolar a tela até o Check Box 'Termos e Condições'");
        if(ios) rolarTelaAteFinal();
        salvarEvidencia("'Tocar check termos e condicoes.'");
        if(ios) tocarCoordenadaElemento(checkTermosCondicoes);
        if(android) tocarElemento(checkTermosCondicoes,"erro ao tocar check termos e condicoes.");
        return this;
    }

    /**
     * tocar seta para ver os "Termos Condicoes
     *
     * @return
     * @throws Exception
     */
    @Step("tocar seta ver \"Termos Condicoes\"")
    public ConfirmeDadosObjetivoTela tocarSetaParaVerTermos() throws Exception {
        rolaTelaBaixo();
        salvarEvidencia("'Tocar seta para ver Termoes e condicoes.'");
        if(getDriver() instanceof IOSDriver) {
            tocarCoordenadaElemento(tocarTermosCondicoes);
        }else {
            tocarElemento(tocarTermosCondicoes,"erro ao tocar seta para ver termos e condicoes.");
        }
        return this;
    }

    /**
     * tocar botao criar objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("tocar botao \"Criar Objetivo\"")
    public ConfirmeDadosObjetivoTela tocarBotaoCriarObjetivo() throws Exception {
        if(android) rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCriarObjetivo,"Erro ao tocar botao criar objetivo.");
        salvarEvidencia("Tocar botao 'Criar objetivo'");
        tocarElemento(botaoCriarObjetivo,"erro ao tocar botao criar objetivo.");
        return this;
    }

    /**
     * tocar elemento por coordenada
     *
     * @return
     * @throws Exception
     */
    protected void tocarCoordenadaElemento(MobileElement elemento) throws Exception {
        Point localizacao = elemento.getLocation();
        tocarCoordenada(localizacao.x, localizacao.y);
    }
}
