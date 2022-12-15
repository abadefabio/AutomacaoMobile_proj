package pagina.mobile.jornadas.pagamentos.contadeconsumo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.testng.util.Strings;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.temporal.ChronoUnit;

public class ContaDeConsumoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "CONTA DE CONSUMO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONTA DE CONSUMO\"]")
    private MobileElement tituloContaDeConsumo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_confirm")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Confirmar\"])[1]")
    private MobileElement botaoConfirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Descri��o\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_description")
    private MobileElement textoDescricao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Conta corrente\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_current_account")
    private MobileElement radioContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Conta poupan�a\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_savings_account")
    private MobileElement radioContaPoupanca;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Pagar agora")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Pagar agora\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pagar agora\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name\"Pagar\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_confirm")
    private MobileElement botaoPagarAgora;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Next:")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"seguinte\"`]")
    @WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
    private MobileElement botaoSeguirTecladoIOS;

    public ContaDeConsumoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Validar a tela: 'CONTA DE CONSUMO'
     * @return
     */
    @Step("Validar a tela: 'CONTA DE CONSUMO'")
    public ContaDeConsumoTela validarContaDeConsumoTela(){
        validarCondicaoBooleana(Boolean.logicalOr(aguardarCarregamentoElemento(tituloContaDeConsumo),
                Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto("CONTA DE CONSUMO",
                        "D� uma olhada se capturamos certinho as informa��es."))),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a tela: 'CONTA DE CONSUMO'");
        salvarEvidencia("Validou a tela: 'CONTA DE CONSUMO'");
        return this;
    }

    /**
     * Tocar bot�o: 'Confirmar'
     * @return
     * @throws NextException
     */
    @Step("Tocar bot�o: 'Confirmar'")
    public ContaDeConsumoTela tocarConfirmar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfirmar,"Erro ao tocar no bot�o: 'Confirmar'");
        salvarEvidencia("Tocar bot�o: 'Confirmar'");
        tocarElemento(botaoConfirmar,"Erro ao tocar no bot�o: 'Confirmar'");
        return this;
    }

    /**
     * Editar o campo 'Descri��o'
     * @param descricao
     * @return
     * @throws Exception
     */
    @Step("Editar o campo 'Descri��o'")
    public ContaDeConsumoTela editarDescricao(String descricao) throws Exception {

        rolaTelaBaixo();
        tocarElemento(textoDescricao,"Erro ao tocar no campo : 'Descri��o'");
        escreverTexto(textoDescricao,descricao,"Erro ao editar o campo: 'Descri��o'");
        salvarEvidencia("Editou no campo 'Descri��o' o valor : " + descricao);
        if (ios && verificarPresencaElemento(botaoSeguirTecladoIOS)){
            tocarBotaoENTERTeclado(botaoSeguirTecladoIOS, "Erro ao tocar bot�o 'Seguinte' no teclado do IOS");
        }
        return this;
    }

    /**
     * Tocar radio button 'Conta-Corrente'
     * @return
     * @throws NextException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Step("Tocar radio button 'Conta-Corrente'")
    public ContaDeConsumoTela tocarRadioContaCorrente() throws NextException, IOException, NoSuchAlgorithmException {
        String hash = recuperarHashElemento(radioContaCorrente);
        tocarElemento(radioContaCorrente,"Erro ao tocar no radio-button: 'Conta-Corrente'");
        salvarEvidencia("Tocou no radio-button: 'Conta-Corrente'");
        return this;
    }

    /**
     * Tocar radio button 'Conta-Poupan�a'
     * @return
     * @throws NextException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Step("Tocar radio button 'Conta-Poupan�a'")
    public ContaDeConsumoTela tocarRadioContaPoupanca() throws NextException, IOException, NoSuchAlgorithmException {
        String hash = recuperarHashElemento(radioContaPoupanca);
        tocarElemento(radioContaPoupanca,"Erro ao tocar no radio-button: 'Conta-Poupan�a'");
        salvarEvidencia("Tocou no radio-button: 'Conta-Poupan�a'");
        return this;
    }

    /**
     * Tocar bot�o 'Pagar Agora'
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Pagar Agora'")
    public ContaDeConsumoTela tocarBotaoPagarAgora() throws Exception {

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPagarAgora, "Bot�o 'Pagar Agora' n�o foi encontrado!");
        salvarEvidencia("Tocar bot�o: 'Pagar Agora'");
        tocarElemento(botaoPagarAgora,"Erro ao tocar no bot�o: 'Pagar Agora'");
        return this;
    }

}
