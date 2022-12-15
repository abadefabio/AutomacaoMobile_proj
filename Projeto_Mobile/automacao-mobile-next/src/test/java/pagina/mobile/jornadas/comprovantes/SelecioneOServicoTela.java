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

public class SelecioneOServicoTela  extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "SELECIONE O SERVIÇO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SELECIONE O SERVIÇO']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"SELECIONE O SERVI\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SELECIONE O SERVIÇO']")
    private MobileElement tituloSelecioneServico;

    // Elemento apenas em ios, em android recupera o elemento atraves de uma lista.
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private MobileElement selecioneServico;

    // elemento presente apenas em ios, em android a seleção é automatica.
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar\"]")
    private MobileElement botaoHeaderConfirmar;

    public SelecioneOServicoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela: 'Selecione o Serviço'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Selecione o Serviço\"")
    public SelecioneOServicoTela validarTelaSelecioneOServico() throws Exception {
        validarCondicaoBooleana(Boolean.logicalOr(aguardarCarregamentoElemento(tituloSelecioneServico),
                Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto("SELECIONE O SERVIÇO"))),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar a tela 'Selecione o Serviço'");
        salvarEvidencia("Validou a tela 'Selecione o Serviço'");
        return this;
    }

    /**
     * Selecionar serviço
     * @param servico
     * @return
     * @throws Exception
     */
    @Step("Selecionar serviço")
    public SelecioneOServicoTela selecionarServico(String servico) throws Exception {
        if (ios) {
            String servicoAtributo = "";
            int tentativas = 10;
            do {
                servicoAtributo = retornaAtributo();
                if (!servicoAtributo.equals(normalizaString(servico))) {
                    tocarCoordenadaProporcional(50, 70);
                }
                tentativas--;
                if (tentativas == 0) {
                    throw new NoSuchElementException(String.format("Não foi possível encontrar o serviço após 10 tentativas: %s", servico));
                }
            }
            while (!servicoAtributo.equals(normalizaString(servico)));
        } else {
            List<MobileElement> servicos = retornarLista(By.id("br.com.bradesco.next:id/tv_value"), "Erro a retornar a lista");
            MobileElement elementoServico = null;
            for (MobileElement s : servicos) {
                if (normalizaString(s.getText()).equals(normalizaString(servico))) {
                    elementoServico = s;
                    break;
                }
            }
            tocarElemento(elementoServico, "Erro ao selecionar o serviço: " + servico);
        }
        salvarEvidencia("Selecionou o serviço: " + servico);
        return this;
    }

    /**
     * Tocar botão Confirmar
     * @return
     * @throws NextException
     */
    @Step("Tocar botão Confirmar")
    public SelecioneOServicoTela tocarBotaoHeaderConfirmar() throws NextException {
        if (verificarPresencaElemento(botaoHeaderConfirmar)) {
            salvarEvidencia("Tocar botão Confirmar (header)");
            tocarElemento(botaoHeaderConfirmar, "Tocar botão Confirmar (header)");
        }
        return this;
    }

    /**
     * Retornar atributo
     * @return
     * @throws Exception
     */
    private String retornaAtributo() throws Exception {
        return normalizaString(selecioneServico.getAttribute("value"));
    }

}
