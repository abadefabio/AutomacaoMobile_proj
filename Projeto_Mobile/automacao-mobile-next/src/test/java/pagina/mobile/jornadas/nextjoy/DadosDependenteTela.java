package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.nextJoy.MensagemEsperadas;
import constantes.nextJoy.TipoDocumento;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class DadosDependenteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/npb_document_type")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Selecione o Documento\"]")
    @iOSXCUITFindBy(accessibility = "Tipo do documento")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Tipo do documento\"`]")
    private MobileElement campoTipoDocumento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='RG']")
    @iOSXCUITFindBy(accessibility = "RG")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"RG\"`]")
    private MobileElement tipoDocumentoRg;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_document")
    @AndroidFindBy(xpath = "//android.widget.EditText/child::*[@resource-id='br.com.bradesco.next:id/ntf_document']")
    @iOSXCUITFindBy(accessibility = "Campo obrigatório. Lembre-se de preencher :)")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Campo obrigatório. Lembre-se de preencher :)\"`]")
    private MobileElement numeroDocumento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Certidão de Nascimento']")
    @iOSXCUITFindBy(accessibility = "Certidão de nascimento")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Certidão de nascimento\"`]")
    private MobileElement tipoDocumentoCertidaoNascimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/npb_born_country")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Selecione o País de nascimento\"]")
    @iOSXCUITFindBy(accessibility = "País de nascimento")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"País de nascimento\"`]")
    private MobileElement campoPaisNascimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_search")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Busque por País\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Busque por país de nascimento \"`]")
    private MobileElement buscarPaisNascimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_born_location")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Local de nascimento']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Local de nascimento']")
    @iOSXCUITFindBy(accessibility = "Local de nascimento")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Local de nascimento\"`]")
    private MobileElement campoLocalNascimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Busque por local de nascimento\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Local de nascimento\"]/../../XCUIElementTypeOther//XCUIElementTypeTextField")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Busque por local de nascimento \"`]")
    private MobileElement buscarLocalNascimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='CONTINUAR']")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    private MobileElement botaoContinuar;

    public DadosDependenteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar texto não multibanco
     *
     * @return DadosDependenteTela
     * @throws NextException
     */
    @Step("Validar texto não multibanco")
    public DadosDependenteTela validarTextoNaoMultibanco() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(MensagemEsperadas.COM_QUAL_DOCUMENTO_VOCE), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possivel validar a presença do texto esperado"+MensagemEsperadas.COM_QUAL_DOCUMENTO_VOCE);
        salvarEvidencia("Validar texto " + MensagemEsperadas.COM_QUAL_DOCUMENTO_VOCE + " está visivel na tela");
        return this;
    }

    /**
     * Tocar tipo documento
     *
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Tocar tipo documento")
    public DadosDependenteTela tocarTipoDocumento() throws Exception {
        salvarEvidencia("Tocar tipo documento");
        tocarElemento(campoTipoDocumento, "Não foi possível tocar em tipo documento");
        return this;
    }

    /**
     * Selecionar tipo documento
     *
     * @param tipoDocumento Tipo do documento a ser selecionado (RG ou Certidão de Nascimento)
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Selecionar tipo documento")
    public DadosDependenteTela selecionarTipoDocumento(TipoDocumento tipoDocumento) throws Exception {
        salvarEvidencia("Selecionar tipo documento");
        switch (tipoDocumento) {
            case RG:
                tocarElemento(tipoDocumentoRg, "Não foi possível Selecionar o tipo documento");
                break;
            case CERTIDAONASCIMENTO:
                tocarElemento(tipoDocumentoCertidaoNascimento, "Não foi possível Selecionar o tipo documento");
                break;
        }
        return this;
    }

    /**
     * Preencher número de documento
     *
     * @param numeroDoc Número do documento a ser preenchido (RG ou Certidão de Nascimento)
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Preencher número de documento")
    public DadosDependenteTela preencherNumeroDocumento(String numeroDoc) throws Exception {
        if(ios) {
            escreverTexto(numeroDocumento, numeroDoc, "Não foi preencher número de documento");
        } else {
            tocarElemento(numeroDocumento,"Erro ao tocar no campo 'Numero Documento'");
            enviarTexto(numeroDoc);
        }
        salvarEvidencia("Preencher número de documento");
        // Solução paliativa até ser implementado o mapeamento do botão continuar do teclado no framework
        if (ios) {
            tocarElemento(botaoContinuar, "Não foi possível tocar no botão continuar do teclado");
        }
        return this;
    }

    /**
     * Tocar país nascimento
     *
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Tocar pais nascimento")
    public DadosDependenteTela tocarPaisNascimento() throws Exception {
        salvarEvidencia("Tocar pais nascimento");
        tocarElemento(campoPaisNascimento, "Não foi possível tocar em pais nascimento");
        return this;
    }

    /**
     * Preencher campo busca país nascimento
     *
     * @param pais País a ser preenchido no campo de busca
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Preencher campo busca pais nascimento")
    public DadosDependenteTela preencherCampoBuscarPaisNascimento(String pais) throws Exception {
        salvarEvidencia("Preencher campo busca pais nascimento");
        escreverTexto(buscarPaisNascimento, pais, "Não foi possível preencher campo busca em pais nascimento");
        return this;
    }

    /**
     * Selecionar pais nascimento
     *
     * @param pais País a ser selecionado
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Selecionar pais nascimento")
    public DadosDependenteTela selecionarPaisNascimento(String pais) throws Exception {
        By element;
        if (driver instanceof AndroidDriver) {
            element = By.xpath("//android.widget.TextView[@text='"+pais+"']");
        } else {
            element = By.xpath("//XCUIElementTypeCell[contains(@name, '" + pais + "')]");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(element, "Não foi possível encontrar o ");
        salvarEvidencia("Tocar pais nascimento " + pais);
        tocarElemento(element, "Não foi possível tocar em pais nascimento: " + pais);
        return this;
    }

    /**
     * Tocar local nascimento
     *
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Tocar local nascimento")
    public DadosDependenteTela tocarLocalNascimento() throws Exception {
        salvarEvidencia("Tocar em local nascimento");
        tocarElemento(campoLocalNascimento, "Não foi possível tocar em local nascimento");
        return this;
    }

    /**
     * Preencher campo busca local nascimento
     *
     * @param local Cidade a ser preenchida no campo de busca
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Preencher campo busca local nascimento")
    public DadosDependenteTela preencherCampoBuscarLocalNascimento(String local) throws Exception {
        salvarEvidencia("Preencher campo local pais nascimento");
        escreverTexto(buscarLocalNascimento, local, "Não foi possível preencher campo local em pais nascimento");
        return this;
    }

    /**
     * Selecionar local nascimento
     *
     * @param localNascimento Cidade a ser selecionada
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Selecionar local nascimento")
    public DadosDependenteTela selecionarLocalNascimento(String localNascimento) throws Exception {
        By element;
        if (driver instanceof AndroidDriver) {
            element = By.xpath("//android.widget.TextView[contains(@text, '"+localNascimento+"')]");
        } else {
            element = By.xpath("//XCUIElementTypeCell[contains(@name,'"+ localNascimento +"')]");
        }
        salvarEvidencia("Tocar local nascimento " + localNascimento);
        tocarElemento(element, "Não foi possível tocar em local nascimento: " + localNascimento);
        return this;
    }

    /**
     * Tocar no botão 'Continuar'
     *
     * @return DadosDependenteTela
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public DadosDependenteTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Enviar Texto
     * @param texto
     */
    private void enviarTexto(String texto){
        try { new Actions(this.driver).sendKeys(texto).perform(); } catch (Exception e){}
    }
}
