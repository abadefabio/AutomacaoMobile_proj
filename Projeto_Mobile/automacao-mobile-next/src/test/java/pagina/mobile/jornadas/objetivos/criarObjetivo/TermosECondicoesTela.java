package pagina.mobile.jornadas.objetivos.criarObjetivo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static java.time.Duration.ofSeconds;

public class TermosECondicoesTela extends PaginaBase {

    //botao voltar <
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    private MobileElement botaoVoltar;

    //botao seta para baixo
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_arrow")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Termo de adesão a Objetivo\"`]")
    private MobileElement selecionarSetaBaixoCima;

    public TermosECondicoesTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar botao Voltar ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Voltar <\"")
    public TermosECondicoesTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("'clicar botao Voltar'");
        if(getDriver() instanceof IOSDriver) {
            voltarTelaAnterior();

        }else{
            tocarElemento(botaoVoltar, "Erro ao clicar botao Voltar");
        }
        return this;
    }

    /**
     * Tocar botao seta para baixo para expandir descricao ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Seta Baixo <\"")
    public TermosECondicoesTela tocarSetaBaixoCima() throws Exception {
        aguardarCarregamentoElemento(selecionarSetaBaixoCima);
        salvarEvidencia("'clicar botao Seta Baixo/Cima para expandir Detalhes do termo.'");
        tocarElemento(selecionarSetaBaixoCima, "Erro ao clicar Seta para baixo/cima e expandir texto.");
        return this;
    }
}
