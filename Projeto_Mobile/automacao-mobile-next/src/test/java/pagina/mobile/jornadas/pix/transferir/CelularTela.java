package pagina.mobile.jornadas.pix.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import constantes.pix.DadosPIX;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CelularTela extends PaginaBase {

    @AndroidFindBy(xpath = "//*[@text='Celular']")
    @iOSXCUITFindBy(xpath = "//*[@name='Celular']")
    private MobileElement campoCelular;

    @AndroidFindBy(xpath = "//*[@text='Insira seu n�mero de celular']")
    @iOSXCUITFindBy(xpath = "//*[@name='Insira seu n�mero de celular']")
    private MobileElement campoNumeroCelular;

    @AndroidFindBy(xpath = "//*[@text='Buscar']")
    @iOSXCUITFindBy(xpath = "//*[@name='Buscar']")
    private MobileElement campoBuscar;

    @AndroidFindBy(xpath = "//*[@text='Transferir para novo contato']")
    @iOSXCUITFindBy(xpath = "//*[@name='Transferir para novo contato']")
    private MobileElement campoContato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='AVAN�AR']")
    @AndroidFindBy(xpath = "//*[@text='Avan�ar']")
    @iOSXCUITFindBy(xpath = "//*[@name='AVAN�AR']")
    private MobileElement botaoAvancar;

    public CelularTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Preencher campo 'acionar celular'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Celular'")
    public CelularTela tocarBotaoCelular() throws NextException {
        aguardarCarregamentoElemento(campoCelular);
        salvarEvidencia("Tocar no bot�o 'Celular': ");
        tocarElemento(botaoAvancar, "N�o foi poss�vel tocar no bot�o 'Celular'");
        return this;
    }


    /**
     * Preencher campo 'preencher n�mero do celular'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Preencher numero 'Celular'")
    public CelularTela preencherCampoCelular() throws Exception {
        if (ios){
            escreverTexto(campoNumeroCelular, DadosPIX.CELULAR, true,"Erro ao inserir dados no campo Celular");
        }else{
            tocarElemento(campoNumeroCelular,"Erro ao tocar na label celular");
            digitarTexto(campoCelular,DadosPIX.CELULAR);
        }
        salvarEvidencia("Campo Celular preenchido");
        return this;
    }


    /**
     * Preencher campo 'Buscar contato'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Preencher campo 'Buscar Contato'")
    public CelularTela preencherCampoBuscarContato(String contatos) throws NextException {
        aguardarCarregamentoElemento(campoBuscar);
        escreverTexto(campoBuscar, contatos, "N�o foi poss�vel encontrar contatos cadastrados'");
        salvarEvidencia("Preencher no campo 'Buscar Contatos': " + contatos);
        return this;
    }

    /**
     * Preencher campo 'Transferir para novo contato'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Selecionar campo 'Contato'")
    public CelularTela selecionarCampoTransferirNovoContato(String Contatos) throws NextException {
        aguardarCarregamentoElemento(campoContato);
        escreverTexto(campoContato, Contatos, "N�o foi poss�vel Selecionar campo 'Transferir para novo Contato");
        salvarEvidencia("Selecionar campo 'Transferir para novo Contato': " + Contatos);
        return this;
    }

    /**
     * Tocar no bot�o 'Avan�ar'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Avan�ar'")
    public CelularTela tocarBotaoAvancar() throws NextException {
        aguardarCarregamentoElemento(botaoAvancar);
        salvarEvidencia("Tocar no bot�o 'Avan�ar'");
        tocarElemento(botaoAvancar, "N�o foi poss�vel tocar no bot�o 'Avan�ar'");
        return this;
    }
}
