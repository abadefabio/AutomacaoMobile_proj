package pagina.mobile.jornadas.configuracoes.perfil.meus.dados.editarDados;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.configuracoes.perfil.Mensagens;
import constantes.configuracoes.perfil.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;

public class EnderecoResidencialTela extends PaginaBase {
    public EnderecoResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/edit_button")
    @iOSXCUITFindBy(accessibility = "EDITAR")
    private MobileElement botaoEditar;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/ntf_zipcode']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='CEP']")
    private MobileElement campoCEP;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/number']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='N�mero']")
    private MobileElement campoNumero;

    @AndroidFindBy(xpath = "//*[contains(@text, 'CONTINUAR')]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/left_icon_info")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Os dados entregues s�o verdadeiros segundo a Lei 7.115/83']/../following-sibling::XCUIElementTypeOther")
    private MobileElement botaoInformacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nrb_selection")
    @iOSXCUITFindBy(accessibility = "Os dados entregues s�o verdadeiros segundo a Lei 7.115/83")
    private MobileElement checkBoxDadosEntregues;

    /**
     * Validar presen�a da tela 'Endere�o Residencial'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela 'Endere�o Residencial'")
    public EnderecoResidencialTela validarTelaEndere�oResidencial() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.ENDERECO_RESIDENCIAL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Endere�o Residencial' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a da na tela 'Endere�o Residencial'");
        return this;
    }

    /**
     * Tocar no Bot�o 'Editar'
     *
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Editar'")
    public EnderecoResidencialTela tocarBotaoEditar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEditar, "N�o foi poss�vel encontrar o bot�o 'Editar'");
        salvarEvidencia("Tocar no bot�o 'Editar'");
        tocarElemento(botaoEditar, "N�o foi poss�vel tocar no bot�o 'Editar'!");
        return this;
    }

    /**
     * Validar presen�a da tela 'Editar Endere�o Residencial'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela 'Editar Endere�o Residencial'")
    public EnderecoResidencialTela validarTelaEditarEndere�oResidencial() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EDITAR_ENDERECO_RESIDENCIAL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Editar Endere�o Residencial' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a da na tela 'Editar Endere�o Residencial'");
        return this;
    }

    /**
     * Preencher Campo CEP
     * @param cep
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Preencher campo Cep")
    public EnderecoResidencialTela preencherCampoCep(String cep) throws Exception {
        aguardarCarregamentoElemento(campoCEP);
        if(ios){
            escreverTexto(campoCEP,cep, "N�o foi poss�vel preencher campo CEP");
        }else {
            digitarTexto(campoCEP, cep);
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo CEP com informa��o: " + cep);
        return this;
    }

    /**
     * Preencher Campo N�mero
     * @param numero
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Preencher campo N�mero")
    public EnderecoResidencialTela preencherCampoNumero(String numero) throws Exception {
        aguardarCarregamentoElemento(campoNumero);
        if(ios){
            escreverTexto(campoNumero,numero, "N�o foi poss�vel preencher campo n�mero");
            Rectangle rect = campoNumero.getRect();
            tocarCoordenada(rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight());
        }else {
            digitarTexto(campoNumero, numero);
            esconderTeclado();
        }
        salvarEvidencia("Preencher campo n�mero com informa��o: " + numero);
        return this;
    }

    /**
     * Tocar no Bot�o 'Continuar'
     *
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public EnderecoResidencialTela tocarBotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "N�o foi poss�vel encontrar o bot�o 'Continuar'");
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'!");
        return this;
    }

    /**
     * Tocar no Bot�o 'Informa��o'
     *
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Informa��o'")
    public EnderecoResidencialTela tocarBotaoInformacao() throws Exception {
        aguardarCarregamentoElemento(botaoInformacao);
        salvarEvidencia("Tocar no bot�o 'Informa��o'");
        tocarElemento(botaoInformacao, "N�o foi poss�vel tocar no bot�o 'Informa��o'!");
        return this;
    }

    /**
     * Validar presen�a da tela 'LEI N� 7.115'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela 'LEI N� 7.115'")
    public EnderecoResidencialTela validarTelaLeiNumero7115() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.LEI_NUMERO_7115.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'LEI N� 7.115' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a da na tela 'LEI N� 7.115'");
        return this;
    }

    /**
     * Tocar no Bot�o 'Fechar'
     *
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Fechar'")
    public EnderecoResidencialTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no bot�o 'Fechar'");
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar no bot�o 'Fechar'!");
        return this;
    }

    /**
     * Tocar no Checkbox de Dados Entregues
     *
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no Checkbox de Dados Entregues")
    public EnderecoResidencialTela tocarCheckboxDeDadosEntregues() throws Exception {
        aguardarCarregamentoElemento(checkBoxDadosEntregues);
        salvarEvidencia("Tocar no Checkbox de Dados Entregues");
        tocarElemento(checkBoxDadosEntregues, "N�o foi poss�vel tocar no Checkbox de Dados Entregues!");
        return this;
    }

    /**
     * Validar tela de sucesso de dados alterados
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela de sucesso de dados alterados")
    public EnderecoResidencialTela validarTelaDeSucessoDeDadosAlterados() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.SUCESSO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Tela de sucesso de dados alterados n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a da tela de sucesso de dados alterados");
        return this;
    }

}
