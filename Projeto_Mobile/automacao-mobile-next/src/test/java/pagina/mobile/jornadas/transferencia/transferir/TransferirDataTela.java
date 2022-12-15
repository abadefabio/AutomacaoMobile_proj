package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.transferencia.MensagensEsperadas;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static pagina.mobile.comum.next.CalendarioTela.salvarAno;
import static pagina.mobile.comum.next.CalendarioTela.salvarDia;
import static pagina.mobile.comum.next.CalendarioTela.salvarMes;
import static pagina.mobile.comum.next.CalendarioTela.salvarNomeMes;

public class TransferirDataTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[1]")
    private MobileElement numeroPaginaAtual;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement descricaoPagina;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_choose']")
    @AndroidBy(id = "br.com.bradesco.next:id/tv_choose")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeButton)[1]")
    private MobileElement selecaoData;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button")
    @AndroidBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continuar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton['label == \"Continuar\"']")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_instruction")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Escolha uma data para fazer a transfer�ncia\"]")
    @iOSXCUITFindBy(accessibility = "Escolhe uma data pra fazer a transfer�ncia")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Escolha uma data\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Escolha uma data para fazer a transfer�ncia\"]")

    private MobileElement textoData;

    public TransferirDataTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar campo de data"
     *
     * @return
     * @throws Exception
     */
    @Step("Informar data de transfer�ncia")
    public TransferirDataTela tocarBotaoData() throws Exception {
        aguardarCarregamentoElemento(selecaoData);
        salvarEvidencia("Tocar bot�o data");
        tocarElemento(selecaoData, "N�o foi poss�vel tocar o bot�o de data para sele��o.");
        return this;
    }

    /**
     * Tocar campo de data"
     *
     * @return
     * @throws Exception
     */
    @Step("Informar data de transfer�ncia")
    public TransferirDataTela armazenarValorBotaoData() throws Exception {
        /*
        A data para quaisquer valida��es posteriores no fluxo
        depende das threadlocals com dia, m�s, m�s com 3 letras e ano.
        Isto � feito ao utilizar o calend�rio,
        mas desta vez n�o estamos agendando e, portanto,
        sem usar o calend�rio, obtemos esses valores aqui.
         */
        aguardarCarregamentoElemento(selecaoData);
        String data = retornarTexto(selecaoData, "N�o foi poss�vel obter a data vis�vel na tela");
        salvarDia(data.substring(0,2));
        salvarMes(data.substring(3,5));
        salvarAno(data.substring(6));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = df.parse(data);
        DateFormat df2 = new SimpleDateFormat ("MMMMM", new Locale("pt", "BR"));
        salvarNomeMes(df2.format(dt).substring(0,3)); // ex. jan, fev, abr, mai
        salvarEvidencia("Efetuada a leitura da data vis�vel na tela: " + data);
        return this;
    }

    /**
     * Tocar bot�o "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o fechar (X)")
    public TransferirDataTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no bot�o fechar (X)" );
        tocarElemento( botaoFechar, "Nao foi possivel tocar no bot�o fechar" );
        return this;
    }

    /**
     * Tocar bot�o "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public TransferirDataTela tocarBotaoContinuar() throws Exception{
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "Erro ao tocar bot�o 'Continuar'");
        return this;
    }

    /**
     * Validar descri��o Data na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"Descricao\" da tela")
    public TransferirDataTela validarTextoTelaDescricao() throws Exception {
        aguardarCarregamentoElemento(textoData);
        salvarEvidencia("validar Descri��o do texo Escolha uma Data na tela.");
        compararElementoTexto(textoData, MensagensEsperadas.DATA_TRANSFERENCIA, MetodoComparacao.IGUAL);
        return this;
    }
}
