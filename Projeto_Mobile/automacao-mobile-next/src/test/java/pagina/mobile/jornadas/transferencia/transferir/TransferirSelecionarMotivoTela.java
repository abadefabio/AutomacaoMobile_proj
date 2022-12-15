package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class TransferirSelecionarMotivoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_apply")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirmar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Confirmar')]")
    private MobileElement botaoConfirmar;

    //selecionar o Motivo da transferencia na lista para uma unica opção
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_name")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_view")
    @AndroidFindBy(xpath = "//*[@text=\"CREDITO EM CONTA\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CREDITO EM CONTA\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TRANSF ENTRE CTAS MM TITULA PG\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CREDITO EM CONTA - PG\"]")
    private MobileElement selecionarMotivo;

    public TransferirSelecionarMotivoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Retorna elemento com a descrição do motivo
     *
     * @return MobileElement
     * @throws Exception
     */
    private MobileElement motivo(String descricaoMotivo) throws Exception {

        By locatorRaiz = null;
        MobileElement motivo = null;

        if (android) {
            locatorRaiz = By.id("br.com.bradesco.next:id/ctv_name");
        } else {
            locatorRaiz = By.xpath("//XCUIElementTypeCell");
        }

        /*
        Devido a problemas de mapeamento/reconhecimento, a solução abaixo executa o seguinte:
        Obtemos todos os textviews disponíveis na tela e, entre eles, procuramos o texto.
        Se não for encontrado, rolamos para baixo e obtemos novamente uma lista com todas as textviews
        e procuramos o texto novamente, e assim, sucessivamente, embora apenas 1 rolagem deve
        ser suficiente em todos os casos.
         */
        int tentativas = 0;
        externo:
        while (tentativas <= 5) {
            tentativas++;
            List<MobileElement> listaMotivos = retornarLista(locatorRaiz, "");
            for (MobileElement elementoListaMotivos : listaMotivos) {
                String texto = retornarTexto(elementoListaMotivos, "");
                if (texto == null)
                    continue;
                if (texto.contains(descricaoMotivo)) {
                    /*
                    Este rolar tela para baixo é importante para iOS, e
                    não influencia Android.
                    No iOS, os elementos da lista são encontrados mesmo
                    que não visíveis, daí a necessidade de rolar até o elemento.
                     */
                    motivo = elementoListaMotivos;
                    rolarTelaParaBaixoAosPoucosAteEncontrarElemento(motivo, "Não foi possível encontrar o motivo " + descricaoMotivo);
                    break externo;
                }
            }
            rolarTela(0.4, 0.2);
        }
        return motivo;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirSelecionarMotivoTela
     * @throws Exception
     */
    @Step("Tocar botão \"Confirmar\"")
    public TransferirSelecionarMotivoTela tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Tocar botão \"Confirmar\"");
        tocarElemento(botaoConfirmar, "Erro ao executar a ação de tocar botão \"Confirmar\"");
        return this;
    }

    /**
     * Tocar botão "Motivo"
     *
     * @return TransferirSelecionarMotivoTela
     * @throws Exception
     */
    @Step("Tocar botão \"Motivo\"")
    public TransferirSelecionarMotivoTela tocarOpcaoMotivo(String descricaoMotivo) throws Exception {
        salvarEvidencia("Selecionar motivo " + descricaoMotivo);

        if (android) {
            String uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + descricaoMotivo.trim() + "\"));";
            tocarElemento(MobileBy.AndroidUIAutomator(uiAutomator), "Erro ao executar a ação de selecionar o motivo " + descricaoMotivo);
        } else {
            tocarElemento(motivo(descricaoMotivo), "Erro ao executar a ação de selecionar o motivo " + descricaoMotivo);
        }
        return this;
    }

    /**
     * Tocar botão "Motivo (Padrão)"
     *
     * @return TransferirSelecionarMotivoTela
     * @throws Exception
     */
    @Step("Tocar botão \"Motivo\"")
    public TransferirSelecionarMotivoTela tocarOpcaoMotivo() throws Exception {
        aguardarCarregamentoElemento(selecionarMotivo);
        tocarElemento(selecionarMotivo, "Erro ao executar a ação de selecionar o motivo ");
        salvarEvidencia("Selecionou motivo ");
        return this;
    }

}
