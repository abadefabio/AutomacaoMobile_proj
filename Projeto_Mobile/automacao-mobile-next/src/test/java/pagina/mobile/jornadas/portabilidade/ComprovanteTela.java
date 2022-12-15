package pagina.mobile.jornadas.portabilidade;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.ParentescoElemento;
import constantes.portabilidade.DetalhesPortabilidade;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;

public class ComprovanteTela extends PaginaBase {

    //label Banco em tela Comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_portability_bank_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = \"Banco\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement labelBancoComprovante;

    //label CPF/CNPJ em tela Comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_portability_cnpj_value")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeStaticText\" and name = \"CPF/CNPJ\"")
    private MobileElement labelCnpjComprovante;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/ctv_portability_date")
    @iOSXCUITFindBy(xpath = "//**/XCUIElementTypeCell[4]/XCUIElementTypeOther[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'DATA DA SOLICITAÇÃO')]")
    private MobileElement dataComprovante;

    //Botão 'Visualizar Comprovante'
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/nb_see_receipt")
    @iOSXCUITFindBy(xpath = "//*[@name='btn_Comprovante']")
    private MobileElement botaoVisualizarComprovante;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/pdfView")
    @iOSXCUITFindBy(xpath = "//*[@name='Compartilhar comprovante']")
    private MobileElement comprovantePdf;

    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_right_icon")
    @iOSXCUITFindBy(xpath = "//*[@name='COMPARTILHAR COMPROVANTE']")
    private MobileElement botaoCompartilhar;

    public ComprovanteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar botão 'Visualizar'  - Comprovante
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Visualizar\"")
    public ComprovanteTela tocarBotaoVisualizar() throws Exception {
        aguardarCarregamentoElemento(botaoVisualizarComprovante);
        salvarEvidencia("Clicar no botão 'Visualizar'");
        tocarElemento(botaoVisualizarComprovante, "Não foi possível clicar no botão Visualizar");
        salvarEvidencia("Comprovante em Tela'");
        return this;
    }

    /**
     * Validar Título do Comprovante
     *
     * @return
     * @throws Exception
     */
    @Step("Validar  PDF")
    public ComprovanteTela validarPdf() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(comprovantePdf), MetodoComparacaoBooleano.VERDADEIRO, "O PDF Comprovante não foi exibido");
        salvarEvidencia("Validar exibição do PDF Comprovante");
        return this;
    }

    /**
     * Clicar botão 'Compartilhar Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Compartilhar\"")
    public ComprovanteTela tocarBotaoCompartilhar() throws Exception {
        aguardarCarregamentoElemento(botaoCompartilhar);
        tocarElemento(botaoCompartilhar, "Não foi possível clicar no botão Compartilhar");
        aguardarOcultacaoElemento(botaoCompartilhar);
        salvarEvidencia("App apresenta mensagem solicitando permissão para compartilhar");
        return this;
    }


    /**
     * Validar Data Comprovante
     * @return
     * @throws Exception
     */
    @Step("Validar Data exibida no comprovante")
    public ComprovanteTela validarDataComprovante() throws Exception{
        String dataEsperada = android ? calcularDataRelativaHoje(0) : calcularDataRelativaHoje(0,"dd MM yyyy");
        aguardarCarregamentoElemento(dataComprovante);
        if(android)
            validarAtributoTexto(dataComprovante, dataEsperada, "Não foi possível validar que a data do comprovante é: " + dataEsperada );
        else
            compararElementoTexto(dataComprovante, dataEsperada, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * Validar dados exibidos no comprovante
     * @param portabilidade
     * @return
     * @throws Exception
     */
    @Step("Validar dados exibidos no comprovante")
    public ComprovanteTela validarDadosComprovante(DetalhesPortabilidade portabilidade) throws Exception {
        List<MobileElement> campos;
        List<MobileElement> valores;
        if(android){
            //CPF
            campos = retornarLista(new By.ById("br.com.bradesco.next:id/ctv_portability_cnpj"), "Erro ao criar lista com campos");
            valores = retornarLista(new By.ById("br.com.bradesco.next:id/ctv_portability_cnpj_value"), "Erro ao criar lista com os valores");

            //Banco
            campos.add(retornarElemento(new By.ById("br.com.bradesco.next:id/ctv_portability_bank"), "Erro ao recuperar campo Banco"));
            valores.add(retornarElemento(new By.ById("br.com.bradesco.next:id/ctv_portability_bank_value"), "Erro ao recuperar elemento com o valor do banco"));
        } else {
            //CPF
            MobileBy cpfCnpj, banco;
            cpfCnpj = new MobileBy.ByAccessibilityId("CPF/CNPJ");
            campos = retornarLista(cpfCnpj, "Erro ao criar lista com campos");
            valores = retornarLista(new By.ByXPath("//*[@name = \"CPF/CNPJ\"]/following-sibling::XCUIElementTypeStaticText"), "Erro ao criar lista com os valores");

            //Banco
            banco = new MobileBy.ByAccessibilityId("Banco");
            campos.add(retornarElemento(banco, "Erro ao recuperar campo Banco"));
            valores.add(retornarElementoParente(banco, "XCUIElementTypeStaticText", ParentescoElemento.PROXIMO_IRMAO));
        }
        validarCamposValor(campos, valores, portabilidade.retornaDadosPortabilidade("CPF/CNPJ"));
        salvarEvidencia("Validar detalhes comprovante");
        return this;
    }

    /**
     * Validar dados exibidos no comprovante
     * @param portabilidade
     * @return
     * @throws Exception
     */
    @Step("Validar dados exibidos no comprovante")
    public ComprovanteTela validarDadosComprovante(JSONObject portabilidade) throws Exception {
        List<MobileElement> campos = null;
        List<MobileElement> valores = null;
        if(android){
            //CPF
            campos = retornarLista(new By.ById("br.com.bradesco.next:id/nl_left"), "Não foi possível montar lista com os elementos contendos os campos");
            valores = retornarLista(new By.ById("br.com.bradesco.next:id/nl_right"), "Não foi possível montar lista com os elementos contendos os valores");
            valores.remove(0);
        } else {
//            campos = retornarLista(new By.ByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[@index=\"1\"]"),"Não foi possível montar lista com os elementos contendos os campos");
//            valores = retornarLista(new By.ByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[@index=\"0\"]"),"Não foi possível montar lista com os elementos contendos os campos");
       }
        Map<String, String> cpf = new HashMap<>();
        cpf.put("CPF/CNPJ", (String) portabilidade.get("CPF/CNPJ"));

        validarCamposValor(campos, valores, cpf);
        salvarEvidencia("Validar detalhes comprovante");
        return this;
    }
}
