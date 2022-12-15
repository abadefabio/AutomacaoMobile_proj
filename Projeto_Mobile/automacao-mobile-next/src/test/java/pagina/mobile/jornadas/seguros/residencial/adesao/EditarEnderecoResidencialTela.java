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
    // Título da tela EDITAR ENDERECO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO RESIDENCIAL\"]")
    private MobileElement headerTituloTelaEditarEndereco;

    // botão VOLTAR da tela EDITAR ENDEREÇO
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaEditarEndereco;

    // campo CEP
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@content-desc=\"Informe o cépe\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"CEP\")]")
    private MobileElement campoCEP;

    // campo Rua/Avenida
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,\"Rua/Avenida\")]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"Rua/Avenida\")]")
    private MobileElement campoRua;

    // campo Número
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@content-desc=\"Informe o número\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"Número\")]")
    private MobileElement CampoNumero;

    // campo Complemento
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@content-desc=\"Informe o complemento\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"Complemento\")]")
    private MobileElement campoComplemento;

    // Botão CONTINUAR da tela EDITAR ENDERECO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_residential_address_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CONTINUAR']")
    private MobileElement btnContinuarTelaEdicaoEndereco;
    /*     *************************     */

    /*
    Método para validar a tela EDITAR ENDEREÇO
     */
    @Step("Valida tela EDITAR ENDERECO")
    public EditarEnderecoResidencialTela validaTelaEditarEndereco() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaEditarEndereco);
        compararElementoTexto(headerTituloTelaEditarEndereco, SegurosResidencial.TITULO_TELA_EDITAR_ENDERECO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela EDITAR ENDERECO");
        return this;
    }
    /*
    Método para tocar no ícone (<) voltar da tela EDITAR ENDEREÇO
     */
    @Step("Tocar no ícone (<) voltar")
    public EditarEnderecoResidencialTela tocarBtnVoltarTelaEdicaoEndereco() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaEditarEndereco);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(btnVoltarTelaEditarEndereco, "Não foi possível tocar no ícone (<) voltar.");
        return this;
    }
    /*
    Método para preencher o campo CEP
     */
    @Step("Preencher campo CEP")
    public EditarEnderecoResidencialTela preencherCampoCEP(String cep) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoCEP,"Não foi possível encontrar o campo CEP");
        if(ios){
            apagarCampoTexto(campoCEP, "Não foi possível apagar o campo CEP");
            escreverTexto(campoCEP,cep, "Não foi possível preencher campo CEP");
        }else {
            teclarBackSpaceAteApagar(campoCEP, 11);
            digitarTexto(campoCEP, cep);
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo CEP com informação: " + cep);
        return this;
    }
    /*
    Método para preencher o campo Rua/Avenida
     */
    @Step("Preencher campo Rua/Avenida")
    public EditarEnderecoResidencialTela preencherCampoRua(String rua) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoRua,"Não foi possível encontrar o campo Rua/Avenida");
        apagarCampoTexto(campoRua, "Não foi possível apagar campo Rua/Avenida");
        escreverTexto(campoRua, rua, "Não foi possível preencher campo Rua/Avenida");
        salvarEvidencia("Preencher campo Rua/Avenida com informação: " + rua);
        return this;
    }
    /*
    Método para preencher o campo Número
     */
    @Step("Preencher campo Número")
    public EditarEnderecoResidencialTela preencherCampoNumero(String numero) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(CampoNumero,"Não foi possível encontrar o campo Número");
        if(ios){
            apagarCampoTexto(CampoNumero, "Não foi possível apagar o campo Rua");
            escreverTexto(CampoNumero, numero,"Não foi possível preencher campo Rua");
        }else {
            teclarBackSpaceAteApagar(CampoNumero,10);
            digitarTexto(CampoNumero,numero);
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo Número com informação: " + numero);
        return this;
    }
    /*
    Método para preencher o campo Complemento
     */
    @Step("Preencher campo Complemento")
    public EditarEnderecoResidencialTela preencherCampoComplemento(String complemento) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoComplemento,"Não foi possível encontrar o campo Complemento");
        apagarCampoTexto(campoComplemento, "Não foi possível apagar campo Complemento");
        if(ios) {
            escreverTexto(campoComplemento, complemento + "\uE007", "Não foi possível preencher campo Complemento");
        }
        else {
            digitarTexto(campoComplemento, complemento);
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo Complemento com informação: " + complemento);
        return this;
    }
    /*
    Método para tocar no botão <CONTINUAR> da tela EDITAR ENDEREÇO
     */
    @Step("Tocar no botão <CONTINUAR>")
    public EditarEnderecoResidencialTela tocarBtnContinuarEdicaoEndereco() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(btnContinuarTelaEdicaoEndereco,"Não foi possível encontrar o botão <CONTINUAR>");
        salvarEvidencia("Tocar no botão <CONTINUAR>.");
        tocarElemento(btnContinuarTelaEdicaoEndereco, "Não foi possível tocar no botão <CONTINUAR>.");
        return this;
    }
}
