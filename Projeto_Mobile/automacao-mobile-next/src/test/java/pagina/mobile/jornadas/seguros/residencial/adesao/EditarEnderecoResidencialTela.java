package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EditarEnderecoResidencialTela extends PaginaBase {

    public EditarEnderecoResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela EDITAR ENDERECO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO RESIDENCIAL\"]")
    private MobileElement headerTituloTelaEditarEndereco;

    // bot�o VOLTAR da tela EDITAR ENDERE�O
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaEditarEndereco;

    // campo CEP
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@content-desc=\"Informe o c�pe\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"CEP\")]")
    private MobileElement campoCEP;

    // campo Rua/Avenida
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,\"Rua/Avenida\")]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"Rua/Avenida\")]")
    private MobileElement campoRua;

    // campo N�mero
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@content-desc=\"Informe o n�mero\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"N�mero\")]")
    private MobileElement CampoNumero;

    // campo Complemento
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@content-desc=\"Informe o complemento\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"Complemento\")]")
    private MobileElement campoComplemento;

    // Bot�o CONTINUAR da tela EDITAR ENDERECO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_residential_address_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CONTINUAR']")
    private MobileElement btnContinuarTelaEdicaoEndereco;
    /*     *************************     */

    /*
    M�todo para validar a tela EDITAR ENDERE�O
     */
    @Step("Valida tela EDITAR ENDERECO")
    public EditarEnderecoResidencialTela validaTelaEditarEndereco() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaEditarEndereco);
        compararElementoTexto(headerTituloTelaEditarEndereco, SegurosResidencial.TITULO_TELA_EDITAR_ENDERECO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela EDITAR ENDERECO");
        return this;
    }
    /*
    M�todo para tocar no �cone (<) voltar da tela EDITAR ENDERE�O
     */
    @Step("Tocar no �cone (<) voltar")
    public EditarEnderecoResidencialTela tocarBtnVoltarTelaEdicaoEndereco() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaEditarEndereco);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(btnVoltarTelaEditarEndereco, "N�o foi poss�vel tocar no �cone (<) voltar.");
        return this;
    }
    /*
    M�todo para preencher o campo CEP
     */
    @Step("Preencher campo CEP")
    public EditarEnderecoResidencialTela preencherCampoCEP(String cep) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoCEP,"N�o foi poss�vel encontrar o campo CEP");
        if(ios){
            apagarCampoTexto(campoCEP, "N�o foi poss�vel apagar o campo CEP");
            escreverTexto(campoCEP,cep, "N�o foi poss�vel preencher campo CEP");
        }else {
            teclarBackSpaceAteApagar(campoCEP, 11);
            digitarTexto(campoCEP, cep);
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo CEP com informa��o: " + cep);
        return this;
    }
    /*
    M�todo para preencher o campo Rua/Avenida
     */
    @Step("Preencher campo Rua/Avenida")
    public EditarEnderecoResidencialTela preencherCampoRua(String rua) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoRua,"N�o foi poss�vel encontrar o campo Rua/Avenida");
        apagarCampoTexto(campoRua, "N�o foi poss�vel apagar campo Rua/Avenida");
        escreverTexto(campoRua, rua, "N�o foi poss�vel preencher campo Rua/Avenida");
        salvarEvidencia("Preencher campo Rua/Avenida com informa��o: " + rua);
        return this;
    }
    /*
    M�todo para preencher o campo N�mero
     */
    @Step("Preencher campo N�mero")
    public EditarEnderecoResidencialTela preencherCampoNumero(String numero) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(CampoNumero,"N�o foi poss�vel encontrar o campo N�mero");
        if(ios){
            apagarCampoTexto(CampoNumero, "N�o foi poss�vel apagar o campo Rua");
            escreverTexto(CampoNumero, numero,"N�o foi poss�vel preencher campo Rua");
        }else {
            teclarBackSpaceAteApagar(CampoNumero,10);
            digitarTexto(CampoNumero,numero);
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo N�mero com informa��o: " + numero);
        return this;
    }
    /*
    M�todo para preencher o campo Complemento
     */
    @Step("Preencher campo Complemento")
    public EditarEnderecoResidencialTela preencherCampoComplemento(String complemento) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoComplemento,"N�o foi poss�vel encontrar o campo Complemento");
        apagarCampoTexto(campoComplemento, "N�o foi poss�vel apagar campo Complemento");
        if(ios) {
            escreverTexto(campoComplemento, complemento + "\uE007", "N�o foi poss�vel preencher campo Complemento");
        }
        else {
            digitarTexto(campoComplemento, complemento);
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo Complemento com informa��o: " + complemento);
        return this;
    }
    /*
    M�todo para tocar no bot�o <CONTINUAR> da tela EDITAR ENDERE�O
     */
    @Step("Tocar no bot�o <CONTINUAR>")
    public EditarEnderecoResidencialTela tocarBtnContinuarEdicaoEndereco() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(btnContinuarTelaEdicaoEndereco,"N�o foi poss�vel encontrar o bot�o <CONTINUAR>");
        salvarEvidencia("Tocar no bot�o <CONTINUAR>.");
        tocarElemento(btnContinuarTelaEdicaoEndereco, "N�o foi poss�vel tocar no bot�o <CONTINUAR>.");
        return this;
    }
}
