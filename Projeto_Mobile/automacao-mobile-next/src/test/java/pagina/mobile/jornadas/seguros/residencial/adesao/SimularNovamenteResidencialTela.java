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
    // T�tulo da tela SIMULAR NOVAMENTE RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSimularNovamenteResidencial;

    // bot�o VOLTAR
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Bot�o (i) INFORMA��ES
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_option")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Informa��es\"]")
    private MobileElement botaoInfo;

    // bot�o VER TODOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_residential_insurance_see_all")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ver Todos\"]")
    private MobileElement botaoVerTodos;

    // Bot�o SAIBA MAIS RODAP�
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "//[./[contains(@label,'A ades�o')] and ./*[@label=\"SAIBA MAIS\"]]")
    private MobileElement botaoSaibaMaisRodape;

    // Texto VANTAGENS PRA VOC�
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_residential_insurance_benefits_to_you")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Vantagens pra voc�\"]")
    private MobileElement textoVantagensPraVoce;

    // Texto PROTE��O COMPLETA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_full_protection_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Prote��o completa\"]")
    private MobileElement textoProtecaoCompleta;

    // Texto PAGAMENTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_payment_header")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Pagamento\"]")
    private MobileElement textoPagamento;

    // Texto RESID�NCIA SEGURADA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_address_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Resid�ncia segurada\"]")
    private MobileElement textoResidenciaSegurada;

    /**
     * M�todo para Validar tela 'SIMULAR NOVAMENTE RESIDENCIAL'
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida t�tulo tela 'SIMULAR NOVAMENTE RESIDENCIAL'")
    public SimularNovamenteResidencialTela validaTelaSimularNovamenteResidencial() throws Exception {
        aguardarCarregamentoElemento(headerTituloSimularNovamenteResidencial);
        compararElementoTexto(headerTituloSimularNovamenteResidencial, SegurosResidencial.TITULO_TELA_PRODUTO_SIMULAR_NOVAMENTE_RESIDENCIAL, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SIMULAR NOVAMENTE RESIDENCIAL");
        return this;
    }

    /**
     * Validar texto 'Vantagens para voc�'
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida texto 'Vantagens pra voc�'")
    public SimularNovamenteResidencialTela validaTextoVantagensPraVoce() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoVantagensPraVoce, "N�o carregou o texto 'Vantagens pra voc�'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoVantagensPraVoce), MetodoComparacaoBooleano.VERDADEIRO, "N�o carregou o texto 'Vantagens pra voc�'");
        salvarEvidencia("texto 'Vantagens pra voc�'");
        return this;
    }

    /**
     * Validar texto 'Prote��o completa'
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida texto 'Prote��o completa'")
    public SimularNovamenteResidencialTela validaTextoProtecaoCompleta() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoProtecaoCompleta, "N�o carregou o texto 'Prote��o completa'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoProtecaoCompleta), MetodoComparacaoBooleano.VERDADEIRO, "N�o carregou o texto 'Prote��o completa'");
        salvarEvidencia("texto 'Prote��o completa'");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoPagamento, "N�o carregou o texto 'Pagamento'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoPagamento), MetodoComparacaoBooleano.VERDADEIRO, "N�o carregou o texto 'Pagamento'");
        salvarEvidencia("texto 'Pagamento'");
        return this;
    }

    /**
     * Validar texto 'Resid�ncia segurada'
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida texto 'Resid�ncia segurada'")
    public SimularNovamenteResidencialTela validaTextoResidenciaSegurada() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoResidenciaSegurada, "N�o carregou o texto 'Resid�ncia segurada'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoResidenciaSegurada), MetodoComparacaoBooleano.VERDADEIRO, "N�o carregou o texto 'Resid�ncia segurada'");
        salvarEvidencia("texto 'Resid�ncia segurada'");
        return this;
    }

    /**
     * Validar texto SAIBA MAIS
     *
     * @return SimularNovamenteResidencialTela
     * @throws Exception
     */
    @Step("Valida bot�o SAIBA MAIS")
    public SimularNovamenteResidencialTela validaBotaoSaibaMais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSaibaMaisRodape, "N�o carregou o bot�o SAIBA MAIS do rodap�");
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoSaibaMaisRodape), MetodoComparacaoBooleano.VERDADEIRO, "N�o carregou o bot�o SAIBA MAIS do rodap�");
        salvarEvidencia("bot�o SAIBA MAIS");
        return this;
    }
}
