package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PacotesTela extends PaginaBase {

    public PacotesTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_choose_plan")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"ESCOLHER PACOTE\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ESCOLHER PACOTE\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ESCOLHER PACOTE\"]")
    private MobileElement botaoEscolherPacote;

    /**
     * Validar Titulo Tela 'Pacotes'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Pacotes'")
    public PacotesTela validarTituloTelaPacotes() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.PACOTES)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Pacotes' não está presente na tela!");
        salvarEvidencia("Validada tela 'Pacotes'");
        return this;
    }

    /**
     * Tocar botão 'Mais Detalhes (?)' do 'Pacote Padronizado'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Mais Detalhes (?)' do 'Pacote Padronizado'")
    public PacotesTela tocarMaisDetalhesDoPacotePadronizado(String pacotePadronizado) throws Exception {
        By localizador = android ? new By.ByXPath("//*[contains(@text, '" + pacotePadronizado + "')]/../*[contains(@content-desc, 'Mais detalhes')]") :
                                   new By.ByXPath("//*[contains(@label, '" + pacotePadronizado + "')]/../XCUIElementTypeButton");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "Não foi possível encontrar o " + pacotePadronizado);
        tocarElemento(localizador, "Erro ao tentar tocar no botão 'Mais Detalhes (?)' do '"+ pacotePadronizado +"'");
        salvarEvidencia("Botão 'Mais Detalhes (?)' do '"+ pacotePadronizado +"' tocado");
        return this;
    }

    /**
     * Selecionar Checkbox do 'Pacote Padronizado'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Checkbox do 'Pacote Padronizado'")
    public PacotesTela selecionarCheckboxDoPacotePadronizado(String pacotePadronizado) throws Exception {
        By localizador = android ? new By.ByXPath("//*[@text= '"+ pacotePadronizado + "']/preceding-sibling::android.widget.CheckBox") :
                                   new By.ByXPath("(//*[contains(@name, '"+ pacotePadronizado + "')]/../XCUIElementTypeOther)[last()]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "Não foi possível encontrar o pacote " + pacotePadronizado);
        tocarElemento(localizador, "Erro ao tentar selecionar o Checkbox do '"+ pacotePadronizado +"'");
        salvarEvidencia("Checkbox do '"+ pacotePadronizado +"' selecionado");
        return this;
    }

    /**
     * Tocar botão 'Escolher Pacote'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Escolher Pacote'")
    public PacotesTela tocarEscolherPacote() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEscolherPacote, "Botão 'Escolher Pacote' não localizado");
        salvarEvidencia("Tocar botão 'Escolher Pacote'");
        tocarElemento(botaoEscolherPacote, "Erro ao tentar tocar no botao 'Escolher Pacote'");
        return this;
    }

}
