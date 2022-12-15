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
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"DESCRIÇÃO\")]")
    @iOSXCUITFindBy(accessibility = "Descrição")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Descrição\"`]")
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
     * Tocar botão 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Confirmar'")
    public TributoTela tocarbotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar botão 'Confirmar'");
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botão 'Confirmar'");
        return this;
    }

    /**
     * Validar presença da tela 'Boleto'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Tributo'")
    public TributoTela validarPresencaTributoTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TRIBUTO), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Boleto' não está presente na tela!");
        salvarEvidencia("Validado presença da tela 'Tributo'");
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
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(codigo), MetodoComparacaoBooleano.VERDADEIRO, String.format("Código do boleto não está presente na tela. Esperado: %s", codigo));
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(data), MetodoComparacaoBooleano.VERDADEIRO, String.format("Data do boleto não está presente na tela. Esperado: %s", data));
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(valor), MetodoComparacaoBooleano.VERDADEIRO, String.format("Valor do boleto não está presente na tela. Esperado: %s", valor));
        salvarEvidencia("Dados do Boleto validados");
        return this;
    }

    /**
     * Preencher campo 'Descrição'
     *
     * @param descricao
     * @return
     * @throws Exception
     */
    @Step("Preencher campo descrição")
    public TributoTela preencherCampoDescricao(String descricao) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoDescricao,"Não foi possível encontrar o campo 'Descrição'");
        escreverTexto(campoDescricao, descricao, "Não foi possível preencher o campo 'Descrição'");
        salvarEvidencia("Preenchido campo 'Descrição' com " + descricao);
        return this;
    }

    /**
     * Tocar botão 'Pagar agora'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Pagar agora'")
    public TributoTela tocarbotaoPagarAgora() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão 'Pagar agora'");
        tocarElemento(pagarAgora, "Não foi possível tocar no botão 'Pagar agora'");
        return this;
    }

}
