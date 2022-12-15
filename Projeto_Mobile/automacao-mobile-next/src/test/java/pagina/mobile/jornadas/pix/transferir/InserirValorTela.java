package pagina.mobile.jornadas.pix.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pix.Pix;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InserirValorTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[contains(@text,'R$')])[2]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_input_value")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'R$')])[2]")
    private MobileElement campoValor;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_advance")
    @AndroidFindBy(xpath = "//*[@text='AVAN�AR']")
    @iOSXCUITFindBy(accessibility = "AVAN�AR")
    @iOSXCUITFindBy(xpath = "//*[@name='AVAN�AR']")
    private MobileElement botaoAvancar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nfbt_continue_keyboard")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOK;

    public InserirValorTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela 'Inserir Valor'
     */
    @Step("Validar tela 'Inserir Valor'")
    public InserirValorTela validarInserirValorTela() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Pix.INSERIR_VALOR_TELA), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar a tela 'Inserir Valor'");
        salvarEvidencia("Validada a tela 'Inserir Valor'");
        return this;
    }

    /**
     * Preencher campo valor
     *
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Preencher campo valor")
    public InserirValorTela preencherCampoValor(String valor) throws Exception {
        if(ios){
            apagarCampoTexto(campoValor, "Erro ao apagar dados no campo valor");
            escreverTexto(campoValor, valor, false, "Erro ao inserir dados no campo valor");
        }else{
            teclarBackSpaceAteApagar(campoValor,15);
            digitarTexto(campoValor, valor);
        }
        salvarEvidencia("Campo valor preenchido");
        return this;
    }

    /**
     * Tocar no bot�o 'Avan�ar'
     *
     * @return InserirValorTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Avan�ar'")
    public InserirValorTela tocarBotaoAvancar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Avan�ar'");
        tocarElemento(botaoAvancar, "N�o foi poss�vel tocar no bot�o 'Avan�ar'");
        return this;
    }
}
