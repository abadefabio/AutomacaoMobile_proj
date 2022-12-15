package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.seguros.SegurosResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SimularNovamenteResidencialTela extends PaginaBase {

    public SimularNovamenteResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela SIMULAR NOVAMENTE RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSimularNovamenteResidencial;

    // botão VOLTAR
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Botão (i) INFORMAÇÕES
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_option")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Informações\"]")
    private MobileElement botaoInfo;

    // botão VER TODOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_residential_insurance_see_all")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ver Todos\"]")
    private MobileElement botaoVerTodos;

    // Botão SAIBA MAIS RODAPÉ
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "//[./[contains(@label,'A adesão')] and ./*[@label=\"SAIBA MAIS\"]]")
    private MobileElement botaoSaibaMaisRodape;

    // Texto VANTAGENS PRA VOCÊ
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_residential_insurance_benefits_to_you")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Vantagens pra você\"]")
    private MobileElement textoVantagensPraVoce;

    // Texto PROTEÇÃO COMPLETA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_full_protection_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Proteção completa\"]")
    private MobileElement textoProtecaoCompleta;

    // Texto PAGAMENTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_payment_header")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Pagamento\"]")
    private MobileElement textoPagamento;

    // Texto RESIDÊNCIA SEGURADA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_address_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Residência segurada\"]")
    private MobileElement textoResidenciaSegurada;

    /**
     * Método para Validar tela 'SIMULAR NOVAMENTE RESIDENCIAL'
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida título tela 'SIMULAR NOVAMENTE RESIDENCIAL'")
    public SimularNovamenteResidencialTela validaTelaSimularNovamenteResidencial() throws Exception {
        aguardarCarregamentoElemento(headerTituloSimularNovamenteResidencial);
        compararElementoTexto(headerTituloSimularNovamenteResidencial, SegurosResidencial.TITULO_TELA_PRODUTO_SIMULAR_NOVAMENTE_RESIDENCIAL, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SIMULAR NOVAMENTE RESIDENCIAL");
        return this;
    }

    /**
     * Validar texto 'Vantagens para você'
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida texto 'Vantagens pra você'")
    public SimularNovamenteResidencialTela validaTextoVantagensPraVoce() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoVantagensPraVoce, "Não carregou o texto 'Vantagens pra você'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoVantagensPraVoce), MetodoComparacaoBooleano.VERDADEIRO, "Não carregou o texto 'Vantagens pra você'");
        salvarEvidencia("texto 'Vantagens pra você'");
        return this;
    }

    /**
     * Validar texto 'Proteção completa'
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida texto 'Proteção completa'")
    public SimularNovamenteResidencialTela validaTextoProtecaoCompleta() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoProtecaoCompleta, "Não carregou o texto 'Proteção completa'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoProtecaoCompleta), MetodoComparacaoBooleano.VERDADEIRO, "Não carregou o texto 'Proteção completa'");
        salvarEvidencia("texto 'Proteção completa'");
        return this;
    }

    /**
     * Validar texto 'Pagamento'
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida texto 'Pagamento'")
    public SimularNovamenteResidencialTela validaTextoPagamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoPagamento, "Não carregou o texto 'Pagamento'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoPagamento), MetodoComparacaoBooleano.VERDADEIRO, "Não carregou o texto 'Pagamento'");
        salvarEvidencia("texto 'Pagamento'");
        return this;
    }

    /**
     * Validar texto 'Residência segurada'
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida texto 'Residência segurada'")
    public SimularNovamenteResidencialTela validaTextoResidenciaSegurada() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoResidenciaSegurada, "Não carregou o texto 'Residência segurada'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoResidenciaSegurada), MetodoComparacaoBooleano.VERDADEIRO, "Não carregou o texto 'Residência segurada'");
        salvarEvidencia("texto 'Residência segurada'");
        return this;
    }

    /**
     * Validar texto SAIBA MAIS
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida botão SAIBA MAIS")
    public SimularNovamenteResidencialTela validaBotaoSaibaMais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSaibaMaisRodape, "Não carregou o botão SAIBA MAIS do rodapé");
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoSaibaMaisRodape), MetodoComparacaoBooleano.VERDADEIRO, "Não carregou o botão SAIBA MAIS do rodapé");
        salvarEvidencia("botão SAIBA MAIS");
        return this;
    }
}
