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
    // Título da tela SEGURO COLETIVO DE PESSOAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDIÇÕES GERAIS\"]")
    private MobileElement headerTituloTelaSeguroColetivoDePessoas;

    // botão VOLTAR da tela SEGURO COLETIVO DE PESSOAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarSeguroColetivoDePessoas;

    /**
     * Método para validar Tela SEGURO COLETIVO DE PESSOAS - Débito
     * @return SeguroColetivoDePessoasDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela SEGURO COLETIVO DE PESSOAS - DÉBITO")
    public SeguroColetivoDePessoasDebitoTela validaTelaSeguroColetivoDePessoas() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(SegurosDebito.TITULO_TELA_SEGURO_COLETIVO_DE_PESSOAS)), MetodoComparacaoBooleano.VERDADEIRO,"Não Carregou a pagina SEGURO COLETIVO DE PESSOAS");
        salvarEvidencia("Tela SEGURO COLETIVO DE PESSOAS - DÉBITO");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     * @return SeguroColetivoDePessoasDebitoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public SeguroColetivoDePessoasDebitoTela tocarBotaoVoltarTelaSeguroColetivoDePessoas() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarSeguroColetivoDePessoas);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarSeguroColetivoDePessoas, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
