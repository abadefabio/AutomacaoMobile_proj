package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class EnderecoTela extends PaginaBase {

    public EnderecoTela(AppiumDriver driver){
        super(driver);
    }

    //botao Salvar Localizacao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save_location")
    private MobileElement botaoSalvarLocalizacao;

    //CAMPO CEP
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_zipcode")
    @iOSXCUITFindBy(accessibility = "CEP")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CEP \"`]")
    private MobileElement campoCep;

    //CAMPO RUA
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_street")
    @iOSXCUITFindBy(accessibility = "Rua")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Rua \"`]")
    private MobileElement campoRua;

    //CAMPO Numero
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_number")
    @iOSXCUITFindBy(accessibility = "Número")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Número \"`]")
    private MobileElement campoNumero;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_complement")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Complemento Se tiver, lembre-se de incluir. Ex.: APTO 321B \"`]")
    private MobileElement campoComplemento;

    //CAMPO ESTADO
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_state")
    @iOSXCUITFindBy(accessibility = "Estado")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Estado \"`]")
    private MobileElement campoEstado;

    //checkBox nao possui numeracao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/check_box\n")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther")
    private MobileElement checkNaoPossuiNumeracao;

    //CAMPO CIDADE
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_city")
    @iOSXCUITFindBy(accessibility = "Cidade")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Cidade \"`]")
    private MobileElement campoCidade;

    //CAMPO BAIRRO
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_city")
    @iOSXCUITFindBy(accessibility = "Bairro")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Bairro \"`]")
    private MobileElement campoBairro;

    //Botao continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;

    //Botao Terminar mais tarde
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_finish_later")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"TERMINAR MAIS TARDE\"`]")
    private MobileElement botaoTerminarMaisTarde;


    /**
     * validar titulo da tela 'Endereco
     * fr
     * @return
     * @throws Exception
     */
    @Step("validar tela  \"Endereco\"")
    public EnderecoTela validarTituloEndereco() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.ENDEREÇO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Endereco' não está presente na tela!");
        salvarEvidencia("validar que esta na tela de 'Endereco'");
        return this;
    }

    /**
     * botao Salvar Localizacao
     * FR
     * @return
     * @throws Exception
     */
    @Step("Tocar \"botao Salvar Localizacao\"")
    public EnderecoTela tocarBotaoLocalizacao() throws Exception {
        tocarElemento(botaoSalvarLocalizacao, "Erro ao tocar botao Salvar Localizacao");
        salvarEvidencia("'tocar botao Salvar Localizacao.");
        return this;
    }

    /**
     * preencher CEP
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"CEP\"")
    public EnderecoTela preencherCep(String cep) throws Exception {
        escreverTexto(campoCep,cep, "Erro ao preencher campo CEP");
        salvarEvidencia("'Preencher campo CEP.'");
        return this;
    }

    /**
     * preencher Rua
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Rua\"")
    public EnderecoTela preencherRua(String rua) throws Exception {
        escreverTexto(campoRua,rua, "Erro ao preencher campo Rua");
        salvarEvidencia("'Preencher campo Rua'");
        return this;
    }

    /**
     * preencher Numero
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Numero\"")
    public EnderecoTela preencherNumero(String numero) throws Exception {
        escreverTexto(campoNumero,numero, "Erro ao preencher campo numero");
        salvarEvidencia("'Preencher campo Numero'");
        return this;
    }

    /**
     * preencher Complemento
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Complemento\"")
    public EnderecoTela preencherComplemento(String complemento) throws Exception {
        escreverTexto(campoComplemento,complemento, "Erro ao preencher campo Complemento");
        salvarEvidencia("'Preencher campo Complemento'");
        return this;
    }

    /**
     * preencher Estado
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Estado\"")
    public EnderecoTela preencherEstado(String estado) throws Exception {
        escreverTexto(campoEstado,estado, "Erro ao preencher campo Estado");
        salvarEvidencia("'Preencher campo Estado'");
        return this;
    }

    /**
     * preencher cidade
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"cidade\"")
    public EnderecoTela preencherCidade(String cidade) throws Exception {
        escreverTexto(campoCidade,cidade, "Erro ao preencher campo cidade");
        salvarEvidencia("'Preencher campo cidade'");
        return this;
    }

}
