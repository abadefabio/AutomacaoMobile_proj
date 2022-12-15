package pagina.mobile.jornadas.parcerias;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.parcerias.Parcerias;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static constantes.parcerias.AmigoParcerias.definirNome;
import static constantes.parcerias.AmigoParcerias.definirNumeroCelular;
import static constantes.parcerias.AmigoParcerias.recuperarNome;

public class IndiqueAmigosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,'Nome')]")
    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private MobileElement campoNome;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Return']")
    private MobileElement botaoRetorno;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,'Telefone com DDD')]")
    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private MobileElement campoCelular;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "INDICAR AMIGO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"INDICAR AMIGO\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_send_invitation")
    private MobileElement botaoIndicarAmigo;

    @iOSXCUITFindBy(iOSNsPredicate = "label=\"OK\"")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'OK!')]")
    private MobileElement botaoOK;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_error")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"N�mero de telefone incompleto\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"N�mero de telefone incompleto\"]")
    private MobileElement numeroCelularIncompleto;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar para o Menu\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    private MobileElement botaoFechaIndiqueAmigo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/open_acc")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Quem abre a conta tem:\"]")
    private MobileElement textoDescricaoQuemAbreConta;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRA FAZER ACONTECER COM UM BANCO 100% DIGITAL E GRATUITO\"]")
    private MobileElement textoDescricaoBancoDigital;

    public IndiqueAmigosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o 'Enviar Convite'
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo \"N�mero Celular\"")
    public IndiqueAmigosTela tocarBotaoFecharTelaParceria() throws Exception {
        tocarElemento(botaoFechaIndiqueAmigo, "N�o foi poss�vel tocar no bot�o 'Fechar'");
        salvarEvidencia("Tocar bot�o 'Fechar'");
        return this;
    }

    /**
     * Validar texto tela 'Abre conta tem'
     *
     * @return
     * @throws Exception
     */
    public IndiqueAmigosTela validarTextoAbreContaTem() throws Exception {
        aguardarCarregamentoElemento(textoDescricaoQuemAbreConta);
        salvarEvidencia("Valida��o do texto: Quem Abre Conta Tem:");
        compararElementoTexto(textoDescricaoQuemAbreConta, Parcerias.VALIDAR_TEXTO_QUEM_ABRE_CONTA, MetodoComparacao.IGUAL);
        return this;
    }

    /**
     * Validar texto tela 'Banco 100 digital'
     *
     * @return
     * @throws Exception
     */
    public IndiqueAmigosTela validarTextoBancoDigital() throws Exception {
        aguardarCarregamentoElemento(textoDescricaoBancoDigital);
        salvarEvidencia("Valida��o do texto: Banco 100 Digital");
        compararElementoTexto(textoDescricaoBancoDigital, Parcerias.VALIDAR_TEXTO_BANCODIGITAL, MetodoComparacao.IGUAL);
        return this;
    }

    /**
     * Validar Campos em Branco
     *
     * @return
     * @throws Exception
     */
    @Step("Validar campo \"N�mero Celular\" em branco")
    public IndiqueAmigosTela validarCampoNumeroCelularEmBranco(Parcerias textoNumeroVazio) throws Exception {
        aguardarCarregamentoElemento(campoCelular);
        if (getDriver() instanceof AndroidDriver) {
            validarAtributoTexto(campoCelular, "","N�o foi poss�vel validar que o campo \"Celular\" est� vazio");
        } else {
            compararElementoTexto(campoCelular, textoNumeroVazio, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validar campo \"N�mero Celular\" est� em branco");
        return this;
    }

    /**
     * Validar Campo Nome em Branco
     *
     * @param valorCampoNome
     * @return IndiqueAmigosTela
     * @throws Exception
     */
    @Step("Validar campo \"Nome\" em branco")
    public IndiqueAmigosTela validarCampoNomeEmBranco(Parcerias valorCampoNome) throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(campoNome);
        if (android) {
            OperadorEvidencia.logarPasso("Validando nome vazio");
            compararElementoTexto(campoNome, valorCampoNome,MetodoComparacao.IGUAL);
        } else {
            OperadorEvidencia.logarPasso("Validando nome vazio");
            compararElementoTexto(campoNome, valorCampoNome,MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validar campo \"Nome\" est� em branco");
        return this;
    }

    /**
     * Preencher campo 'Nomes'
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo \"Nome\"")
    public IndiqueAmigosTela preencherCampoNome(String nome) throws Exception {
        rolaTelaBaixo();
        Boolean esconderTeclado = android ? true : false;
        escreverTexto(campoNome, nome, esconderTeclado,"N�o foi poss�vel escrever o nome no campo");
        definirNome(nome);
        salvarEvidencia("Preencher campo 'Nome' com: " + recuperarNome());
        if(ios){
            tocarElemento(botaoRetorno,"Erro ao tocar no bot�o RETORNO do teclado");
            tocarBotaoENTERTeclado(campoNome, "Erro ao tocar no bot�o ENTER do teclado");
        }
        return this;
    }

    /**
     * Preencher campo 'N�mero Celular'
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo \"N�mero Celular\"")
    public IndiqueAmigosTela preencherCampoNumeroCelular(String numeroCelular) throws Exception {
        escreverTexto(campoCelular, numeroCelular, "N�o foi poss�vel escrever o n�mero de celular no campo");
        definirNumeroCelular(numeroCelular);
        salvarEvidencia("Preencher campo 'N�mero Celular' com: " + numeroCelular);
        return this;
    }

    /**
     * Tocar bot�o 'Enviar Convite'
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo \"N�mero Celular\"")
    public IndiqueAmigosTela tocarBotaoIndicarAmigo() throws Exception {
        tocarElemento(botaoIndicarAmigo, "N�o foi poss�vel tocar no bot�o 'Enviar Convite'");
        salvarEvidencia("Tocar bot�o 'Enviar Convite'");
        return this;
    }

    /**
     * Tocar bot�o OK
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"OK\"")
    public IndiqueAmigosTela tocarBotaoOK() throws Exception {
        tocarElemento(botaoOK, "N�o foi poss�vel tocar no bot�o 'OK'");
        salvarEvidencia("Tocar bot�o 'OK'");
        return this;
    }

    /**
     * Validar texto tela 'Indique Amigos'
     *
     * @return
     * @throws Exception
     */
    public IndiqueAmigosTela validarMensagemCelularIncompleto() throws Exception {

        String erro = android ? Parcerias.VALIDA_CELULAR_INCOMPLETO_ANDROID.toString() :
                Parcerias.VALIDA_TELEFONE_INCOMPLETO_IOS.toString();
        aguardarCarregamentoElemento(numeroCelularIncompleto);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(erro), MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar msg de numero de telefone invalido.");
        salvarEvidencia("Valida��o do Celular Incompleto");
        return this;
    }
}

