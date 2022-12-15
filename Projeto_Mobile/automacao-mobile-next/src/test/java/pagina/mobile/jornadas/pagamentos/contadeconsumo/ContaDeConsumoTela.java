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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Descrição\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_description")
    private MobileElement textoDescricao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Conta corrente\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_current_account")
    private MobileElement radioContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Conta poupança\")]")
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
                        "Dá uma olhada se capturamos certinho as informações."))),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a tela: 'CONTA DE CONSUMO'");
        salvarEvidencia("Validou a tela: 'CONTA DE CONSUMO'");
        return this;
    }

    /**
     * Tocar botão: 'Confirmar'
     * @return
     * @throws NextException
     */
    @Step("Tocar botão: 'Confirmar'")
    public ContaDeConsumoTela tocarConfirmar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfirmar,"Erro ao tocar no botão: 'Confirmar'");
        salvarEvidencia("Tocar botão: 'Confirmar'");
        tocarElemento(botaoConfirmar,"Erro ao tocar no botão: 'Confirmar'");
        return this;
    }

    /**
     * Editar o campo 'Descrição'
     * @param descricao
     * @return
     * @throws Exception
     */
    @Step("Editar o campo 'Descrição'")
    public ContaDeConsumoTela editarDescricao(String descricao) throws Exception {

        rolaTelaBaixo();
        tocarElemento(textoDescricao,"Erro ao tocar no campo : 'Descrição'");
        escreverTexto(textoDescricao,descricao,"Erro ao editar o campo: 'Descrição'");
        salvarEvidencia("Editou no campo 'Descrição' o valor : " + descricao);
        if (ios && verificarPresencaElemento(botaoSeguirTecladoIOS)){
            tocarBotaoENTERTeclado(botaoSeguirTecladoIOS, "Erro ao tocar botão 'Seguinte' no teclado do IOS");
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
     * Tocar radio button 'Conta-Poupança'
     * @return
     * @throws NextException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Step("Tocar radio button 'Conta-Poupança'")
    public ContaDeConsumoTela tocarRadioContaPoupanca() throws NextException, IOException, NoSuchAlgorithmException {
        String hash = recuperarHashElemento(radioContaPoupanca);
        tocarElemento(radioContaPoupanca,"Erro ao tocar no radio-button: 'Conta-Poupança'");
        salvarEvidencia("Tocou no radio-button: 'Conta-Poupança'");
        return this;
    }

    /**
     * Tocar botão 'Pagar Agora'
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Pagar Agora'")
    public ContaDeConsumoTela tocarBotaoPagarAgora() throws Exception {

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPagarAgora, "Botão 'Pagar Agora' não foi encontrado!");
        salvarEvidencia("Tocar botão: 'Pagar Agora'");
        tocarElemento(botaoPagarAgora,"Erro ao tocar no botão: 'Pagar Agora'");
        return this;
    }

}
