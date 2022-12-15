package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.seguros.SegurosDebito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SeguroColetivoDePessoasDebitoTela extends PaginaBase {

    public SeguroColetivoDePessoasDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela SEGURO COLETIVO DE PESSOAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDI��ES GERAIS\"]")
    private MobileElement headerTituloTelaSeguroColetivoDePessoas;

    // bot�o VOLTAR da tela SEGURO COLETIVO DE PESSOAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarSeguroColetivoDePessoas;

    /**
     * M�todo para validar Tela SEGURO COLETIVO DE PESSOAS - D�bito
     * @return SeguroColetivoDePessoasDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela SEGURO COLETIVO DE PESSOAS - D�BITO")
    public SeguroColetivoDePessoasDebitoTela validaTelaSeguroColetivoDePessoas() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(SegurosDebito.TITULO_TELA_SEGURO_COLETIVO_DE_PESSOAS)), MetodoComparacaoBooleano.VERDADEIRO,"N�o Carregou a pagina SEGURO COLETIVO DE PESSOAS");
        salvarEvidencia("Tela SEGURO COLETIVO DE PESSOAS - D�BITO");
        return this;
    }

    /**
     * M�todo para Tocar no �cone (<) voltar
     * @return SeguroColetivoDePessoasDebitoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (<) voltar")
    public SeguroColetivoDePessoasDebitoTela tocarBotaoVoltarTelaSeguroColetivoDePessoas() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarSeguroColetivoDePessoas);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoVoltarSeguroColetivoDePessoas, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }
}
