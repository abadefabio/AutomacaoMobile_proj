package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermoAceiteVaquinhaTela extends PaginaBase {

    //Botão Continuar tela de vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    private MobileElement botaoContinuarTelaVaquinha;

    //Aceitar termo e condições vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Aceitar\"`]")
    private MobileElement botaoAceitaTermoCondicoesVaquinha;

    //Titulo da tela de termo e condições
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"TERMOS E CONDIÇÕES\"`]")
    private MobileElement tituloTelaTermoCondicoesVaquinha;

    public TermoAceiteVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar no botão 'check aceitar termo'
     *
     * @return TermoAceiteVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botão (+) adicionar vaquinha")
    public TermoAceiteVaquinhaTela tocarAceitarTermoCondicoesVaquinha() throws Exception {
        aguardarCarregamentoElemento(tituloTelaTermoCondicoesVaquinha);
        for (int i=0;i<=10;i++) {
            OperadorEvidencia.logarPasso("Procurando pelo botão 'Aceitar', aguarde!");
            if (verificarPresencaElemento(botaoAceitaTermoCondicoesVaquinha)) {
                salvarEvidencia("Clicar no botão 'aceitar termo");
                tocarElemento(botaoAceitaTermoCondicoesVaquinha, "Não foi possível clicar no botão aceitar termo condições");
                break;
            }
            rolarTelaAteFinal();
        }
        return this;
    }

    /**
     * Clicar no botão 'Continuar'
     *
     * @return TermoAceiteVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botão 'continuar vaquinha'")
    public TermoAceiteVaquinhaTela tocarContinuarVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoContinuarTelaVaquinha);
        salvarEvidencia("Clicar no botão 'continuar");
        tocarElemento(botaoContinuarTelaVaquinha, "Não foi possível clicar no botão continuar");
        return this;
    }
}
