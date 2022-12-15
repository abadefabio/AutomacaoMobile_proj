package pagina.mobile.jornadas.pagamentos.codigo.barras.tributo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pagamentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class TributoTela extends PaginaBase{

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_confirm")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirmar\"`][1]")
    MobileElement botaoConfirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_description")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"DESCRI��O\")]")
    @iOSXCUITFindBy(accessibility = "Descri��o")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Descri��o\"`]")
    private MobileElement campoDescricao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_confirm")
    @AndroidFindBy(xpath = "//*[contains(@text, \"Continuar\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Pagar agora\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pagar agora\"]")
    private MobileElement pagarAgora;

    public TributoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Confirmar'")
    public TributoTela tocarbotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Confirmar'");
        tocarElemento(botaoConfirmar, "N�o foi poss�vel tocar no bot�o 'Confirmar'");
        return this;
    }

    /**
     * Validar presen�a da tela 'Boleto'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Tributo'")
    public TributoTela validarPresencaTributoTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TRIBUTO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Boleto' n�o est� presente na tela!");
        salvarEvidencia("Validado presen�a da tela 'Tributo'");
        return this;
    }

    /**
     * Validar dados do boleto
     *
     * @return
     * @param codigo
     * @param data
     * @param valor
     */
    @Step("Validar dados do boleto")
    public TributoTela validarDadosTributo(String codigo, String data, String valor) {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(codigo), MetodoComparacaoBooleano.VERDADEIRO, String.format("C�digo do boleto n�o est� presente na tela. Esperado: %s", codigo));
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(data), MetodoComparacaoBooleano.VERDADEIRO, String.format("Data do boleto n�o est� presente na tela. Esperado: %s", data));
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(valor), MetodoComparacaoBooleano.VERDADEIRO, String.format("Valor do boleto n�o est� presente na tela. Esperado: %s", valor));
        salvarEvidencia("Dados do Boleto validados");
        return this;
    }

    /**
     * Preencher campo 'Descri��o'
     *
     * @param descricao
     * @return
     * @throws Exception
     */
    @Step("Preencher campo descri��o")
    public TributoTela preencherCampoDescricao(String descricao) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoDescricao,"N�o foi poss�vel encontrar o campo 'Descri��o'");
        escreverTexto(campoDescricao, descricao, "N�o foi poss�vel preencher o campo 'Descri��o'");
        salvarEvidencia("Preenchido campo 'Descri��o' com " + descricao);
        return this;
    }

    /**
     * Tocar bot�o 'Pagar agora'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Pagar agora'")
    public TributoTela tocarbotaoPagarAgora() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar bot�o 'Pagar agora'");
        tocarElemento(pagarAgora, "N�o foi poss�vel tocar no bot�o 'Pagar agora'");
        return this;
    }

}
