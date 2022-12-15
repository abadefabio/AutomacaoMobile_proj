package pagina.mobile.jornadas.investimentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import pagina.mobile.comum.next.ValidaMensagensTela;

public class ConfirmarTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_confirm_contribution")
    @AndroidFindBy(xpath = "//*[@text='Confirmar']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirmar\"`]")
    @iOSXCUITFindBy(xpath = "//*[@name='CONFIRMAR']")
    private MobileElement botaoConfirmar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Li e aceito os termos')]//preceding-sibling::XCUIElementTypeButton")
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_check")
    private MobileElement checkboxAceiteTermosECondicoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_terms")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"Li e aceito os termos\")]//following-sibling::XCUIElementTypeButton")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[3]")
    private MobileElement botaoLeituraTermosECondicoes;

    public ConfirmarTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no checkbox 'Li e aceito os termos e condi��es'
     *
     * @return ConfirmarTela
     * @throws Exception
     */
    @Step("Tocar no checkbox 'Li e aceito os termos e condi��es'")
    public ConfirmarTela tocarCheckboxAceiteTermosECondicoes() throws Exception {
        tocarElemento(checkboxAceiteTermosECondicoes, "N�o foi poss�vel tocar no checkbox 'Li e aceito os termos e condi��es'");
        salvarEvidencia("Tocado no checkbox 'Li e aceito os termos e condi��es'");
        return this;
    }

    /**
     * Tocar no botao (>)
     *
     * @return ConfirmarTela
     * @throws Exception
     */
    @Step("Tocar no botao (>)")
    public ConfirmarTela tocarBotaoLeituraTermosECondicoes() throws Exception {
        salvarEvidencia( "Tocar no botao (>)");
        tocarElemento(botaoLeituraTermosECondicoes, "Nao foi possivel tocar no botao (>)");
        return this;
    }

    /**
     * Tocar no bot�o 'Confirmar'
     *
     * @return ConfirmarTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Confirmar'")
    public ConfirmarTela tocarBotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Confirmar'");
        tocarElemento(botaoConfirmar, "N�o foi poss�vel tocar no bot�o 'Confirmar'");
        return this;
    }

    /**
     * Validar informa��es da solicita��o antes da confirma��o
     *
     * @param produto      Produto a ser validado (next CDB, next Aloca��o Arrojada, Poupan�a, etc...)
     * @param validarDados Campos e valores a serem validados e passados no json da massa do cen�rio de teste
     * @param camposTela   Campos a serem buscados em tela
     * @return ValidaMensagensTela
     * @throws Exception
     */
    @Step("Validar informa��es da solicita��o antes da confirma��o")
    public ConfirmarTela validarInformacoes(String produto, Map<String,String> validarDados, String[] camposTela) throws Exception {
        aguardarPaginaConterTodosTextos(camposTela);
        salvarEvidencia("Iniciada a valida��o das informa��es da solicita��o antes da confirma��o");
        List<MobileElement> campos = new ArrayList<>(), valores = new ArrayList<>();
        By campo;
        if (android) {
            for (int i=0; i<camposTela.length; i++) {
                campo = new ByXPath("//*[@text='"+camposTela[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "N�o foi poss�vel encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "N�o foi poss�vel encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../*[@class='android.widget.TextView'][2]"),
                        "N�o foi poss�vel encontrar o valor referente ao campo: " + campo));
            }
        } else {
            for (int i=0; i<camposTela.length; i++) {
                campo = new ByXPath("//*[@name='"+camposTela[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "N�o foi poss�vel encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "N�o foi poss�vel encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../XCUIElementTypeStaticText[2]"),
                        "N�o foi poss�vel encontrar o valor referente ao campo: " + campo));
            }
        }
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(produto),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar em tela o produto " + produto
        );
        validarCamposValor(campos, valores, validarDados);
        salvarEvidencia("Finalizada a valida��o das informa��es da solicita��o antes da confirma��o");
        return this;
    }
}
