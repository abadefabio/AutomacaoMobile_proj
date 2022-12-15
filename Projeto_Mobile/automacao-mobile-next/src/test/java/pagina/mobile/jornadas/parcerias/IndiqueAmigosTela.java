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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Número de telefone incompleto\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Número de telefone incompleto\"]")
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
     * Tocar botão 'Enviar Convite'
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo \"Número Celular\"")
    public IndiqueAmigosTela tocarBotaoFecharTelaParceria() throws Exception {
        tocarElemento(botaoFechaIndiqueAmigo, "Não foi possível tocar no botão 'Fechar'");
        salvarEvidencia("Tocar botão 'Fechar'");
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
        salvarEvidencia("Validação do texto: Quem Abre Conta Tem:");
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
        salvarEvidencia("Validação do texto: Banco 100 Digital");
        compararElementoTexto(textoDescricaoBancoDigital, Parcerias.VALIDAR_TEXTO_BANCODIGITAL, MetodoComparacao.IGUAL);
        return this;
    }

    /**
     * Validar Campos em Branco
     *
     * @return
     * @throws Exception
     */
    @Step("Validar campo \"Número Celular\" em branco")
    public IndiqueAmigosTela validarCampoNumeroCelularEmBranco(Parcerias textoNumeroVazio) throws Exception {
        aguardarCarregamentoElemento(campoCelular);
        if (getDriver() instanceof AndroidDriver) {
            validarAtributoTexto(campoCelular, "","Não foi possível validar que o campo \"Celular\" está vazio");
        } else {
            compararElementoTexto(campoCelular, textoNumeroVazio, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validar campo \"Número Celular\" está em branco");
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
        salvarEvidencia("Validar campo \"Nome\" está em branco");
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
        escreverTexto(campoNome, nome, esconderTeclado,"Não foi possível escrever o nome no campo");
        definirNome(nome);
        salvarEvidencia("Preencher campo 'Nome' com: " + recuperarNome());
        if(ios){
            tocarElemento(botaoRetorno,"Erro ao tocar no botão RETORNO do teclado");
            tocarBotaoENTERTeclado(campoNome, "Erro ao tocar no botão ENTER do teclado");
        }
        return this;
    }

    /**
     * Preencher campo 'Número Celular'
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo \"Número Celular\"")
    public IndiqueAmigosTela preencherCampoNumeroCelular(String numeroCelular) throws Exception {
        escreverTexto(campoCelular, numeroCelular, "Não foi possível escrever o número de celular no campo");
        definirNumeroCelular(numeroCelular);
        salvarEvidencia("Preencher campo 'Número Celular' com: " + numeroCelular);
        return this;
    }

    /**
     * Tocar botão 'Enviar Convite'
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo \"Número Celular\"")
    public IndiqueAmigosTela tocarBotaoIndicarAmigo() throws Exception {
        tocarElemento(botaoIndicarAmigo, "Não foi possível tocar no botão 'Enviar Convite'");
        salvarEvidencia("Tocar botão 'Enviar Convite'");
        return this;
    }

    /**
     * Tocar botão OK
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"OK\"")
    public IndiqueAmigosTela tocarBotaoOK() throws Exception {
        tocarElemento(botaoOK, "Não foi possível tocar no botão 'OK'");
        salvarEvidencia("Tocar botão 'OK'");
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
        salvarEvidencia("Validação do Celular Incompleto");
        return this;
    }
}

