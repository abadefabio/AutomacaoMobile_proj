package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermoAceiteVaquinhaTela extends PaginaBase {

    //Bot�o Continuar tela de vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    private MobileElement botaoContinuarTelaVaquinha;

    //Aceitar termo e condi��es vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Aceitar\"`]")
    private MobileElement botaoAceitaTermoCondicoesVaquinha;

    //Titulo da tela de termo e condi��es
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"TERMOS E CONDI��ES\"`]")
    private MobileElement tituloTelaTermoCondicoesVaquinha;

    public TermoAceiteVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar no bot�o 'check aceitar termo'
     *
     * @return TermoAceiteVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o (+) adicionar vaquinha")
    public TermoAceiteVaquinhaTela tocarAceitarTermoCondicoesVaquinha() throws Exception {
        aguardarCarregamentoElemento(tituloTelaTermoCondicoesVaquinha);
        for (int i=0;i<=10;i++) {
            OperadorEvidencia.logarPasso("Procurando pelo bot�o 'Aceitar', aguarde!");
            if (verificarPresencaElemento(botaoAceitaTermoCondicoesVaquinha)) {
                salvarEvidencia("Clicar no bot�o 'aceitar termo");
                tocarElemento(botaoAceitaTermoCondicoesVaquinha, "N�o foi poss�vel clicar no bot�o aceitar termo condi��es");
                break;
            }
            rolarTelaAteFinal();
        }
        return this;
    }

    /**
     * Clicar no bot�o 'Continuar'
     *
     * @return TermoAceiteVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'continuar vaquinha'")
    public TermoAceiteVaquinhaTela tocarContinuarVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoContinuarTelaVaquinha);
        salvarEvidencia("Clicar no bot�o 'continuar");
        tocarElemento(botaoContinuarTelaVaquinha, "N�o foi poss�vel clicar no bot�o continuar");
        return this;
    }
}
