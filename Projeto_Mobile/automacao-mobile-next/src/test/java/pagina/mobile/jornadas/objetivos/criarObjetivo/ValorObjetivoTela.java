package pagina.mobile.jornadas.objetivos.criarObjetivo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

public class ValorObjetivoTela extends PaginaBase {

    public static ThreadLocal<String> valor = new ThreadLocal<String>();

    public ValorObjetivoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Armazena valor informado no objeto thread-safe valorObjetivo
     * @param vvalor
     */
    public static void setValorObjetivo(String vvalor){
        valor.set(vvalor);
    }

    // campo valor objetivo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_goal_value")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"R$0,00\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"R$0,00\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField")
    private MobileElement valorObjetivo;

    //texto quanto vc precisa
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_goal_value")
    @iOSXCUITFindBy(accessibility = "De quanto você precisa?")
    private MobileElement textoQuantoPrecisa;

    //botao continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_value")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Continuar\"])[1]")
    private MobileElement botaoContinuar;

    //botao voltar <
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    // texto valor minimo objetivo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'O valor mínimo da meta')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"O valor mínimo da meta é\")]")
    private MobileElement valorMinimoObjetivo;

    /**
     * Preencher valor do objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo  \"Valor\"")
    public ValorObjetivoTela preencherValorObjetivo() throws Exception {
        aguardarCarregamentoElemento(valorObjetivo);
        String valor = String.valueOf(numeroAleatorio(10000,50000));
        setValorObjetivo(valor);
        escreverTexto(valorObjetivo,valor, "Erro ao preenher Valor do objetivo.");
        salvarEvidencia("'Preenher valor do objetivo': "+ valor);
        return this;
    }

    /**
     * Preencher valor do objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo  \"Valor\"")
    public ValorObjetivoTela preencherValorObjetivo(String valor) throws Exception {
        aguardarCarregamentoElemento(valorObjetivo);
        setValorObjetivo(valor);
        apagarCampoTexto(valorObjetivo, "Erro ao apagar campo valor objetivos");
        escreverTexto(valorObjetivo,valor,"Erro ao preencher valor do objetivo");
        salvarEvidencia("Preencher valor do objetivo: "+ valor);
        return this;
    }

    /**
     * validar texto da tela De um nome
     *
     * @return
     * @throws Exception
     */
    @Step("validar texto  \"Quanto precisa\"")
    public ValorObjetivoTela validarTextoQuantoPrecisa(String texto) throws Exception {
        aguardarCarregamentoElemento(textoQuantoPrecisa);
        salvarEvidencia("'Validando texto da tela: De quanto você precisa?'");
        validarAtributoTexto(textoQuantoPrecisa, texto,"erro ao validar o texto em tela: De quanto você precisa?" );
        return this;
    }

    /**
     * Tocar botao Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Continuar\"")
    public ValorObjetivoTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("'clicar botao continuar'");
        tocarElemento(botaoContinuar, "Erro ao clicar botao continuar");
        if(verificarPresencaElemento(botaoContinuar)) // verifica se o continuar esta na tela caso apresente o teclado
            tocarElemento(botaoContinuar, "Erro ao clicar botao continuar");
        return this;
    }

    /**
     * Tocar botao Voltar ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Voltar <\"")
    public ValorObjetivoTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("'clicar botao Voltar'");
        tocarElemento(botaoVoltar, "Erro ao clicar botao Voltar");
        return this;
    }

    /**
     * validar texto valor minimo Objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto \"O valor mínimo da meta é R$ 50,00\"")
    public ValorObjetivoTela validarValorMinimoObjetivo() throws Exception{
        if (!verificarPresencaElemento(valorMinimoObjetivo)){
            tocarElemento(textoQuantoPrecisa, "Erro ao tocar no texto 'Quanto você precisa'");
        }
        validarCondicaoBooleana(verificarPresencaElemento(valorMinimoObjetivo), MetodoComparacaoBooleano.VERDADEIRO, "erro ao validar texto valor minimo Objetivo");
        salvarEvidencia("validar texto 'O valor mínimo da meta é R$ 50,00'");
        return this;
    }
}
