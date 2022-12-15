package pagina.mobile.jornadas.comprovantes;

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
import org.openqa.selenium.By;
import org.testng.util.Strings;

import java.util.List;
import java.util.NoSuchElementException;

import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;

public class SelecioneATransacaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "SELECIONE A TRANSA��O")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SELECIONE A TRANSA��O\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"SELECIONE A TRANSA��O\"]")
    private MobileElement tituloSelecioneTransacao;

    // Elemento apenas em ios, em android recupera o elemento atraves de uma lista.
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private MobileElement selecioneTransacao;

    // elemento presente apenas em ios, em androis a sele��o � automatica.
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar\"]")
    private MobileElement botaoHeaderConfirmar;

    public SelecioneATransacaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela: 'Selecione a Transa��o'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Selecione a Transa��o\"")
    public SelecioneATransacaoTela validarTelaSelecioneATransacao() throws Exception {
        validarCondicaoBooleana(Boolean.logicalOr(aguardarCarregamentoElemento(tituloSelecioneTransacao),
                        Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto("SELECIONE A TRANSA��O"))),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar a tela 'Selecione a Transa��o'");
        salvarEvidencia("Validou a tela 'Selecione a Transa��o'");
        return this;
    }

    /**
     * Selecionar a transa��o
     *
     * @param transacao
     * @return
     * @throws Exception
     */
    @Step("Selecionar a transa��o")
    public SelecioneATransacaoTela selecionarTransacao(String transacao) throws Exception {
        if (ios) {
            String transacaoAtributo = "";
            int tentativas = 10;
            do {
                transacaoAtributo = retornaAtributo();
                if (!transacaoAtributo.equals(normalizaString(transacao))) {
                    tocarCoordenadaProporcional(50, 70);
                }
                tentativas--;
                if (tentativas == 0) {
                    throw new NoSuchElementException(String.format("N�o foi poss�vel encontrar o servi�o ap�s 10 tentativas: %s", transacao));
                }
            }
            while (!transacaoAtributo.equals(normalizaString(transacao)));
        } else {
            List<MobileElement> servicos = retornarLista(By.id("br.com.bradesco.next:id/tv_value"), "Erro a retornar a lista");
            MobileElement elementoTransacao = null;
            for (MobileElement s : servicos) {
                if (normalizaString(s.getText()).equals(normalizaString(transacao))) {
                    elementoTransacao = s;
                    break;
                }
            }
            tocarElemento(elementoTransacao, "Erro ao selecionar a Transa��o: " + transacao);
        }
        salvarEvidencia("Selecionou a Transa��o: " + transacao);
        return this;
    }

    /**
     * Tocar bot�o Confirmar
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar bot�o 'Confirmar'")
    public SelecioneATransacaoTela tocarBotaoHeaderConfirmar() throws NextException {
        if (verificarPresencaElemento(botaoHeaderConfirmar)) {
            salvarEvidencia("Tocar bot�o Confirmar (header)");
            tocarElemento(botaoHeaderConfirmar, "Tocar bot�o Confirmar (header)");
        }
        return this;
    }

    /**
     * Retornar atributo
     *
     * @return
     * @throws Exception
     */
    private String retornaAtributo() throws Exception {
        return normalizaString(selecioneTransacao.getAttribute("value"));
    }

}
