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
    @AndroidFindBy(xpath = "//*[@text='AVANÇAR']")
    @iOSXCUITFindBy(accessibility = "AVANÇAR")
    @iOSXCUITFindBy(xpath = "//*[@name='AVANÇAR']")
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
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Pix.INSERIR_VALOR_TELA), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar a tela 'Inserir Valor'");
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
     * Tocar no botão 'Avançar'
     *
     * @return InserirValorTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Avançar'")
    public InserirValorTela tocarBotaoAvancar() throws Exception {
        salvarEvidencia("Tocar botão 'Avançar'");
        tocarElemento(botaoAvancar, "Não foi possível tocar no botão 'Avançar'");
        return this;
    }
}
