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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Número']")
    private MobileElement campoNumero;

    @AndroidFindBy(xpath = "//*[contains(@text, 'CONTINUAR')]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/left_icon_info")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Os dados entregues são verdadeiros segundo a Lei 7.115/83']/../following-sibling::XCUIElementTypeOther")
    private MobileElement botaoInformacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nrb_selection")
    @iOSXCUITFindBy(accessibility = "Os dados entregues são verdadeiros segundo a Lei 7.115/83")
    private MobileElement checkBoxDadosEntregues;

    /**
     * Validar presença da tela 'Endereço Residencial'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela 'Endereço Residencial'")
    public EnderecoResidencialTela validarTelaEndereçoResidencial() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.ENDERECO_RESIDENCIAL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Endereço Residencial' não está presente na tela!");
        salvarEvidencia("Validar presença da na tela 'Endereço Residencial'");
        return this;
    }

    /**
     * Tocar no Botão 'Editar'
     *
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Tocar botão 'Editar'")
    public EnderecoResidencialTela tocarBotaoEditar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEditar, "Não foi possível encontrar o botão 'Editar'");
        salvarEvidencia("Tocar no botão 'Editar'");
        tocarElemento(botaoEditar, "Não foi possível tocar no botão 'Editar'!");
        return this;
    }

    /**
     * Validar presença da tela 'Editar Endereço Residencial'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela 'Editar Endereço Residencial'")
    public EnderecoResidencialTela validarTelaEditarEndereçoResidencial() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EDITAR_ENDERECO_RESIDENCIAL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Editar Endereço Residencial' não está presente na tela!");
        salvarEvidencia("Validar presença da na tela 'Editar Endereço Residencial'");
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
            escreverTexto(campoCEP,cep, "Não foi possível preencher campo CEP");
        }else {
            digitarTexto(campoCEP, cep);
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo CEP com informação: " + cep);
        return this;
    }

    /**
     * Preencher Campo Número
     * @param numero
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Preencher campo Número")
    public EnderecoResidencialTela preencherCampoNumero(String numero) throws Exception {
        aguardarCarregamentoElemento(campoNumero);
        if(ios){
            escreverTexto(campoNumero,numero, "Não foi possível preencher campo número");
            Rectangle rect = campoNumero.getRect();
            tocarCoordenada(rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight());
        }else {
            digitarTexto(campoNumero, numero);
            esconderTeclado();
        }
        salvarEvidencia("Preencher campo número com informação: " + numero);
        return this;
    }

    /**
     * Tocar no Botão 'Continuar'
     *
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public EnderecoResidencialTela tocarBotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "Não foi possível encontrar o botão 'Continuar'");
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'!");
        return this;
    }

    /**
     * Tocar no Botão 'Informação'
     *
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Tocar botão 'Informação'")
    public EnderecoResidencialTela tocarBotaoInformacao() throws Exception {
        aguardarCarregamentoElemento(botaoInformacao);
        salvarEvidencia("Tocar no botão 'Informação'");
        tocarElemento(botaoInformacao, "Não foi possível tocar no botão 'Informação'!");
        return this;
    }

    /**
     * Validar presença da tela 'LEI Nº 7.115'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela 'LEI Nº 7.115'")
    public EnderecoResidencialTela validarTelaLeiNumero7115() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.LEI_NUMERO_7115.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'LEI Nº 7.115' não está presente na tela!");
        salvarEvidencia("Validar presença da na tela 'LEI Nº 7.115'");
        return this;
    }

    /**
     * Tocar no Botão 'Fechar'
     *
     * @return EnderecoResidencialTela
     * @throws Exception
     */
    @Step("Tocar botão 'Fechar'")
    public EnderecoResidencialTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no botão 'Fechar'");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão 'Fechar'!");
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
        tocarElemento(checkBoxDadosEntregues, "Não foi possível tocar no Checkbox de Dados Entregues!");
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
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.SUCESSO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Tela de sucesso de dados alterados não está presente na tela!");
        salvarEvidencia("Validar presença da tela de sucesso de dados alterados");
        return this;
    }

}
