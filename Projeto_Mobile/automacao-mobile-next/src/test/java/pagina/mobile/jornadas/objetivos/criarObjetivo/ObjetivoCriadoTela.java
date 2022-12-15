package pagina.mobile.jornadas.objetivos.criarObjetivo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ObjetivoCriadoTela extends PaginaBase {

    //msg texto objetivo criado
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_created_goal")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Seu Objetivo foi criado\"])[2]")
    private MobileElement msgObjetivoCriado;

    //botao ver objetivos
    @AndroidFindBy(id = "br.com.bradesco.next:id/view_goals")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Ver Objetivo\"])[2]")
    private MobileElement botaoVerObjetivos;

    // textos apos rolar tela cima 'Sobre a parcela mensal'
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sobre a parcela mensal\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Sobre a parcela mensal\"])[2]")
    private MobileElement textoSobreParcelaMensal;

    // textos apos rolar tela cima 'O débito da parcela só acontece em dias uteis'
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"O débito da parcela só acontece em dias úteis, se tiver saldo suficiente na conta.\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"O débito da parcela só acontece em dias úteis\")]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,\"O débito da parcela só acontece em dias úteis, se\"])[2]")
    private MobileElement textoDebitoParcelaAconteceDiasUteis;

    // textos apos rolar tela cima 'Ter Limite credito'
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Ter limite de crédito aprovado não conta como saldo.\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,\"O débito da parcela só acontece em dias úteis, se\"])[2]")
    private MobileElement textoTerLimiteCredito;

    // textos apos rolar tela cima 'Se entrar outra cobrança no mesmo dia'
    @AndroidFindBy(xpath = "//*[contains(@text,\"Se entrar outra cobrança no mesmo dia\")]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,\"O débito da parcela só acontece em dias úteis, se\"])[2]")
    private MobileElement textoSeEntrarOutraCobranca;

    public ObjetivoCriadoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * validar  objetivo criado
     *
     * @return
     * @throws Exception
     * @param
     */
    @Step("Validar  \"Objetivo Criado\"")
    public ObjetivoCriadoTela validarObjetivoCriado( String msgObjCriado) throws Exception {
        msgObjCriado = "Seu Objetivo foi criado";
        aguardarCarregamentoElemento(msgObjetivoCriado);
        salvarEvidencia("'validar objetivo criado com sucesso'");
        validarAtributoTexto(msgObjetivoCriado,msgObjCriado,"Erro ao validar objetivo criado");
        return this;
    }

    /**
     * validar presenca botao 'Ver Objetivo'
     *
     * @return
     * @throws Exception
     * @param
     */
    public ObjetivoCriadoTela verificarPresencaBotaoVerObjetivo(){
        aguardarCarregamentoElemento(botaoVerObjetivos);
        salvarEvidencia("'validar preseca do botao 'Ver Objetivo' após criacao com sucesso.'");
        verificarPresencaElemento(botaoVerObjetivos);
        return this;
    }

    /**
     * validar presenca botao 'Ver Objetivo'
     *
     * @return
     * @throws Exception
     * @param
     */
    public ObjetivoCriadoTela tocarBotaoVerObjetivo() throws NextException {
        aguardarCarregamentoElemento(botaoVerObjetivos);
        salvarEvidencia("'validar preseca do botao 'Ver Objetivo' e tocar botao, após criacao com sucesso.'");
        verificarPresencaElemento(botaoVerObjetivos);
        tocarElemento(botaoVerObjetivos, "erro ao tocar no botao 'Ver Objetivo'");
        return this;
    }

    /**
     * validar textos apresentado - Sobre Parcela Mensal
     *
     * @return
     * @throws Exception
     * @param valor
     */
    @Step("Validar  \"Texto Sobre Parcela Mensal\"")
    public ObjetivoCriadoTela validarTextoSobreParcelaMensal(String valor) throws Exception {

        aguardarCarregamentoElemento(textoSobreParcelaMensal);
        if(android) rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoSobreParcelaMensal, "Não foi possível encontrar o texto sobre parcela mensal");
        if(ios) rolaTelaBaixo();
        salvarEvidencia("'validar texto - Sobre Parcela Mensal'");
        compararElementoTexto(textoSobreParcelaMensal, valor, MetodoComparacao.IGUAL);
        return this;

    }

    /**
     * validar textos apresentado - O débito da parcela só acontece em dias úteis
     *
     * @return
     * @throws Exception
     * @param valor
     */
    @Step("Validar  \"Texto Debito Parcela\"")
    public ObjetivoCriadoTela validarTextoDebitoParcelaDiasUteis(String valor) throws Exception {

        salvarEvidencia("'validar texto - O débito da parcela só acontece em dias úteis'");
        if (android) {
            compararElementoTexto(textoDebitoParcelaAconteceDiasUteis, valor, MetodoComparacao.CONTEM);
        }else{
            verificarPresencaElemento(textoDebitoParcelaAconteceDiasUteis);
        }
        return this;
    }

    /**
     * validar textos apresentado validarTextoTerLimiteCredito
     *
     * @return
     * @throws Exception
     * @param valor
     */
    @Step("Validar  \"Texto Ter Limite\"")
    public ObjetivoCriadoTela validarTextoTerLimiteCredito(String valor) throws Exception {

        salvarEvidencia("'validar - Texto Ter Limite Credito'");
        if (android) {
            compararElementoTexto(textoTerLimiteCredito, valor, MetodoComparacao.CONTEM);
        }else{
            verificarPresencaElemento(textoTerLimiteCredito);
        }
        return this;
    }

    /**
     * validar textos apresentado - validar Texto Se Entar Outra Cobraca
     *
     * @return
     * @throws Exception
     * @param valor
     */
    @Step("Validar  \"Texto Outra Cobraca\"")
    public ObjetivoCriadoTela validarTextoSeEntarOutraCobraca(String valor) throws Exception {

        salvarEvidencia("'validar - Texto Se Entar Outra Cobraca'");
        if (android) {
            compararElementoTexto(textoSeEntrarOutraCobranca, valor, MetodoComparacao.CONTEM);
        }else{
            verificarPresencaElemento(textoSeEntrarOutraCobranca);
        }
        return this;
    }
}
