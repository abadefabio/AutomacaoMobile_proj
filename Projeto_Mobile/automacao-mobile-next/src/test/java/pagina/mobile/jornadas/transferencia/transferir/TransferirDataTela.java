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
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Escolha uma data para fazer a transferência\"]")
    @iOSXCUITFindBy(accessibility = "Escolhe uma data pra fazer a transferência")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Escolha uma data\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Escolha uma data para fazer a transferência\"]")

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
    @Step("Informar data de transferência")
    public TransferirDataTela tocarBotaoData() throws Exception {
        aguardarCarregamentoElemento(selecaoData);
        salvarEvidencia("Tocar botão data");
        tocarElemento(selecaoData, "Não foi possível tocar o botão de data para seleção.");
        return this;
    }

    /**
     * Tocar campo de data"
     *
     * @return
     * @throws Exception
     */
    @Step("Informar data de transferência")
    public TransferirDataTela armazenarValorBotaoData() throws Exception {
        /*
        A data para quaisquer validações posteriores no fluxo
        depende das threadlocals com dia, mês, mês com 3 letras e ano.
        Isto é feito ao utilizar o calendário,
        mas desta vez não estamos agendando e, portanto,
        sem usar o calendário, obtemos esses valores aqui.
         */
        aguardarCarregamentoElemento(selecaoData);
        String data = retornarTexto(selecaoData, "Não foi possível obter a data visível na tela");
        salvarDia(data.substring(0,2));
        salvarMes(data.substring(3,5));
        salvarAno(data.substring(6));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = df.parse(data);
        DateFormat df2 = new SimpleDateFormat ("MMMMM", new Locale("pt", "BR"));
        salvarNomeMes(df2.format(dt).substring(0,3)); // ex. jan, fev, abr, mai
        salvarEvidencia("Efetuada a leitura da data visível na tela: " + data);
        return this;
    }

    /**
     * Tocar botão "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public TransferirDataTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no botão fechar (X)" );
        tocarElemento( botaoFechar, "Nao foi possivel tocar no botão fechar" );
        return this;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TransferirDataTela tocarBotaoContinuar() throws Exception{
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Erro ao tocar botão 'Continuar'");
        return this;
    }

    /**
     * Validar descrição Data na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"Descricao\" da tela")
    public TransferirDataTela validarTextoTelaDescricao() throws Exception {
        aguardarCarregamentoElemento(textoData);
        salvarEvidencia("validar Descrição do texo Escolha uma Data na tela.");
        compararElementoTexto(textoData, MensagensEsperadas.DATA_TRANSFERENCIA, MetodoComparacao.IGUAL);
        return this;
    }
}
