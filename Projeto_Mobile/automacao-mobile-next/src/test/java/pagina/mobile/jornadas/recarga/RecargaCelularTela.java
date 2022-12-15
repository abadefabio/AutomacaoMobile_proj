package pagina.mobile.jornadas.recarga;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class RecargaCelularTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'test')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'test')]")
    private MobileElement botaoPrimeiroContato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Buscar')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@text,'Buscar')]")
    private MobileElement campoBuscar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Recarga de Celular")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Recarga de Celular\"]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Recarga\")]")
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Comprovante\"])[1]/android.view.View")
    @iOSXCUITFindBy(accessibility = "Recarga de Celular")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Recarga de celular\"])[2]")
    private MobileElement recargaDeCecularTituloTela;

    @AndroidFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaofechar;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(id = "Telefone com DDD")
    private MobileElement textoCelular;

    @AndroidFindBy(xpath = "//android.widget.EditText//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(id = "Operadora")
    private MobileElement seletorOperadora;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"O número não é válido\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"O número não é válido\"]")
    private MobileElement labelNumeroNaoEValido;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Digite os dados')]")
    private MobileElement labelDigiteDados;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Recarga de Celular\"]//preceding-sibling::android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"Digite os dados\")]/preceding-sibling::XCUIElementTypeOther")
    private MobileElement iconeCelular;

    @AndroidFindBy(accessibility = "Recargas salvas")
    @iOSXCUITFindBy(accessibility = "Recargas salvas")
    private MobileElement cortinaRecargasSalvas;

    @AndroidFindBy(xpath = "*//*[contains(@content-desc,\"nenhuma recarga\")]")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeStaticText[contains(@name,\"nenhuma recarga\")]")
    private MobileElement labelNenhumaRecarga;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"CONTINUAR\"]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Tudo certo com a recarga!\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tudo certo com a recarga!\"]")
    private MobileElement labelTudoCertoComARecarga;

    @AndroidFindBy(accessibility = "VER COMPROVANTE")
    @iOSXCUITFindBy(accessibility = "VER COMPROVANTE")
    private MobileElement botaoVerComprovante;

    public RecargaCelularTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Método Valida exibição do título da tela RECARGACELULAR
     *
     * @return
     * @throws Exception
     */
    @Step("Método Valida exibição do título da tela RECARGACELULAR")
    public RecargaCelularTela validarExibicaoTelaRecarga() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(recargaDeCecularTituloTela), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição da tela de recarga");
        salvarEvidencia("Validar exibição da tela de Recarga de Celular");
        return this;
    }

    /**
     * Escrever numero de celular
     *
     * @return
     * @throws Exception
     */
    @Step("Escreve o telefone celuar do contato")
    public RecargaCelularTela informarCelular(String meuTelefone) throws Exception {
        tocarElemento(textoCelular, "Não foi possivel tocar no campo numero de celular");
        escreverTexto(textoCelular, meuTelefone, "Nao foi possível escrever o numero de celular");
        salvarEvidencia("Informar número de telefone");
        return this;
    }

    /**
     * Tocar no primeiro contado da agenda
     *
     * @return
     * @throws Exception
     */
    @Step("Escreve o telefone celuar do contato")
    public RecargaCelularTela tocarPrimeiroContatoDaAgenda() throws Exception {
        aguardarCarregamentoQualquerElemento(campoBuscar);
        salvarEvidencia("Toca o primeiro contato da agenda");
        tocarElemento(botaoPrimeiroContato, "Não foi possivel tocar no campo numero de celular");
        return this;
    }

    /**
     * Clicar botão 'Operadora'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Operadora'")
    public RecargaCelularTela tocarSeletorOperadora() throws Exception {
       rolarTelaAteFinal();

        if (android) tocarElemento(labelDigiteDados, "Não foi possível encontrar o título da tela");
        salvarEvidencia("Clicar no seletor 'Operadora'");
        tocarElemento(seletorOperadora, "Não foi possível tocar no seletor operadora");
        return this;
    }

    /**
     * Clicar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public RecargaCelularTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Clicar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível clicar no botão 'Continuar'");
        return this;
    }

    /**
     * Expandir 'Recargas Salvas'
     *
     * @return
     * @throws NextException
     */
    @Step("Expandir  \"Recargas Salvas\"")
    public RecargaCelularTela expandirRecargasSalvas() throws NextException {
        tocarElemento(cortinaRecargasSalvas, "Erro ao abrir a cortina Recargas Salvas");
        salvarEvidencia("Abrir 'Recargas Salvas'");
        return this;
    }

    /**
     * Ocultar 'Recargas Salvas'
     *
     * @return
     * @throws NextException
     */
    @Step("Ocultar  \"Recargas Salvas\"")
    public RecargaCelularTela ocultarRecargasSalvas() throws Exception {
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(iconeCelular, "Não foi possível encontrar o título da tela");
        salvarEvidencia("Ocultar 'Recargas Salvas'");
        return this;
    }

    /**
     * Vaçlidação da Label 'Você ainda não fez nenhuma recarga'
     *
     * @return
     */
    @Step("Validar a label: \"Nenhuma Recarga\"")
    public RecargaCelularTela validarLabelNenhumaRecarga() {
        salvarEvidencia("Validação da Label: 'Você ainda não fez nenhuma recarga'");
        validarCondicaoBooleana(verificarPresencaElemento(labelNenhumaRecarga),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar a Label: 'Você ainda não fez nenhuma recarga'");
        return this;
    }

    /**
     * Validar a label 'Tudo Certo Com A Recarga'
     *
     * @return
     */
    @Step("Validar a label: \"Tudo Certo Com A Recarga\"")
    public RecargaCelularTela validarLabelTudoCertoComARecarga() {
        validarCondicaoBooleana(verificarPresencaElemento(labelTudoCertoComARecarga),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar a label 'Tudo certo com a recarga!'");
        salvarEvidencia("validou a label: 'Tudo Certo Com A Recarga'");
        return this;
    }

    /**
     * tocar no botão 'Comprovante'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar borão: \"ver Comprovante\"")
    public RecargaCelularTela tocarVerComprovante() throws NextException {
        tocarElemento(botaoVerComprovante, "Erro ao tocar no botão 'Ver Comprovante'");
        salvarEvidencia("Tocou no botão 'Ver Detalhes'");
        return this;
    }

    /**
     * tocar no botão 'Fechar'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar botão : \"Fechar\"")
    public RecargaCelularTela tocarBotaoFechar() throws NextException {
        salvarEvidencia("Tocar no botão header 'Fechar' (X)");
       if (aguardarCarregamentoElemento(botaofechar))
            tocarElemento(botaofechar, "Erro ao tocar no botão header 'Fechar' (X)");
        else if (aguardarCarregamentoElemento(recargaDeCecularTituloTela))
            tocarCoordenadaProporcional(7, 8);
        return this;
    }

    /**
     * validar label 'O número não é válido'
     *
     * @return
     */
    @Step("Validar label : \"O número não é válido\"")
    public RecargaCelularTela validarLabelTelefoneInvalido() throws NextException {
        // usado apenas para tirar o foco do campo 'Telefone com DDD' para realizar a validação de inconsistência do campo.
        tocarElemento(recargaDeCecularTituloTela, "Erro ao tocar no Titulo: 'Recarga de celular'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(labelNumeroNaoEValido),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar label 'O número não é válido'");
        salvarEvidencia("Validou a mensagem 'O número não é válido'");
        return this;
    }

    /**
     * Tocar no Icone da Agenda
     *
     * @return RecargaCelularTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Icone' da Agenda")
    public RecargaCelularTela tocarIconeDaAgenda() throws NextException {
        aguardarCarregamentoElemento(textoCelular);
        salvarEvidencia("Tocar no icone da Agenda");
        tocarCoordenadaProporcional(textoCelular, 95, 50);
        return this;
    }
}
