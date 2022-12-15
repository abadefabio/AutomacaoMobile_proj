package pagina.mobile.jornadas.adesao.termosecondicoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class TermosECondicoesTela  extends PaginaBase {

    public TermosECondicoesTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_next_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TERMOS E CONDIÇÕES\"]")
    private MobileElement tituloTermosECondicoes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Fechar')]")
    private MobileElement botaoRetornarMenu;

    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"TERMOS E CONDIÇÕES\"`]")
    private MobileElement menuToolBar;

    /**
     * Validar a tela: 'Termos e Condições'
     * @return
     */
    @Step("Validar a tela: 'Termos e Condições'")
    public TermosECondicoesTela validarTermosECondicoesTela(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloTermosECondicoes),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a tela: 'Termos e Condições'");
        salvarEvidencia("Validou a tela: 'Termos e Condições'");
        return this;
    }

    /**
     * Tocar no botão "Retornar ao Menu"
     *
     * @throws Exception
     */
    @Step ("Tocar botão \"Retornar ao Menu\"")
    public TermosECondicoesTela tocarBotaoRetornarMenu() throws Exception {
        aguardarCarregamentoElemento(botaoRetornarMenu);
        tocarElemento(botaoRetornarMenu, "Não foi possível clicar no botão 'Retornar Menu'" );
        return this;
    }

    /**
     * Validar carregamento da tela pela exibição do menu da tela
     *
     */
    @Step ("Validar carregamento da tela")
    public TermosECondicoesTela validarCarregamentoTela() throws Exception {
        if(!aguardarCarregamentoElemento(menuToolBar)){
            salvarEvidencia("Não foi possível validar o carregamento da tela 'TERMOS E CONDIÇÕES'");
            throw new AssertionError("Não foi possível validar o carregamento da tela 'TERMOS E CONDIÇÕES'");
        }else{
            salvarEvidencia("Validar Carregamento tela 'TERMOS E CONDIÇÕES'");
        }
        return this;
    }

    /**
     * Selecionar Termo
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Termo")
    public TermosECondicoesTela selecionarTermo(String tituloTermo) throws Exception {
        By localizador = android ? new By.ByXPath("//*[contains(@text, '"+ tituloTermo +"')]") :
                new By.ByXPath("//*[@name='"+ tituloTermo +"']");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "Termo '"+ tituloTermo +"' não foi encontrado em tela");
        tocarElemento(localizador, "Erro ao tentar selecionar o Termo '"+ tituloTermo +"'");
        salvarEvidencia("Termo '"+ tituloTermo +"' selecionado");
        return this;
    }
}
