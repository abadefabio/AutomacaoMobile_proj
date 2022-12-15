package pagina.mobile.jornadas.seguros;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.seguros.SegurosHome;
import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSeguro;
import constantes.seguros.TipoSeguroContratado;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static java.util.Objects.nonNull;

public class SegurosHomeTela extends PaginaBase {

    public SegurosHomeTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela HOME DE SEGUROS
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"SEGUROS\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSeguroHome;

    // Aba MEUS SEGUROS
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Tab, Meus Seguros, não selecionado, 2 de 2\"]/android.widget.RelativeLayout/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'myInsurancesTab')]")
    private MobileElement abaMeusSeguros;

    // Botão Cancelamento
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/ctv_text' and contains(@text, 'Cancelamento')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cancelamento']")
    private MobileElement botaoCancelamento;

    // Botão Ver Detalhes do Plano
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VER DETALHES DO PLANO\"]")
    private MobileElement verDetalhesDoPlano;

    // Botão Simular
    @AndroidFindBy(xpath = "//*[contains(@text, 'SIMULAR')]")
    @iOSXCUITFindBy(xpath = "//*[@label='SIMULAR']")
    private MobileElement textoBotaoSimular;

    // Card Generico
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_insurance_options_simulate")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"detailsButton\"])[1]")
    private MobileElement cardGenerico;

    // Botão Simular Novamente
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIMULAR NOVAMENTE\"]")
    private MobileElement botaoSimularNovamente;

    private By elementoVerDetalhesDoPlanoContratado(TipoSeguroContratado tipoSeguroContratado) {
        By xpatch = null;
        if (ios)
            xpatch =
                    By.xpath("//XCUIElementTypeCell[@name= '" + tipoSeguroContratado.toString() + "']//preceding-sibling:: XCUIElementTypeStaticText[@name=\"VER DETALHES DO PLANO\"]");
        if (android)
            xpatch =
                    By.xpath("//*[@resource-id='br.com.bradesco.next:id/nl_insurance_title' and contains(@text, '" + tipoSeguroContratado.toString() + "')]/following::*[@class='android.widget.Button']");
        return xpatch;
    }

    /**
     * Metodo retorna elemento texto tipo proteção
     *
     * @param tipoSeguro
     * @param tipoProtecao
     * @return By
     */
    private By elementoTextoTipoProtecao(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) {
        By xpatch = null;
        if (ios)
            xpatch = By.xpath("//*[contains(@label,'" + tipoProtecao + "')]");

        if (android)
            xpatch = By.xpath("//*[@resource-id='br.com.bradesco.next:id/nl_insurance_options_title' and contains(@text, '" + tipoSeguro + "')]/following::*[@resource-id='br.com.bradesco.next:id/nl_insurance_options_subtitle']");
        return xpatch;
    }

    /**
     * Metodo retorna elemento card tipo proteção
     *
     * @param tipoSeguro
     * @param tipoProtecao
     * @return By
     */
    private By elementocardTipoProtecao(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) {
        By xpath;
        xpath = By.xpath("//*[contains(@value,'" + tipoSeguro + "')]/following::*[@name=\"cardView\"]");
        return xpath;
    }


    /**
     * metodo retorna elemento botão simular
     *
     * @param tipoSeguro
     * @param tipoProtecao
     * @return By
     */
    private By elementoBotaoSimular(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) {
        By xpatch = null;
        if (ios)
            xpatch =
                    By.xpath("//XCUIElementTypeStaticText[@value='" + tipoSeguro + "']/following::XCUIElementTypeStaticText[@value='" + tipoProtecao + "']/../following::XCUIElementTypeStaticText[@name='detailsButton']");
        if (android)
            xpatch = By.xpath("//*[@resource-id='br.com.bradesco.next:id/nl_insurance_options_title' and contains(@text, '" + tipoSeguro + "')]/following::*[@resource-id='br.com.bradesco.next:id/nl_insurance_options_subtitle' and contains(@text,'" + tipoProtecao + "')]/following::*[@class='android.widget.Button']");

        return xpatch;
    }

    /**
     * Método responsável por encontrar e retorar true or false no botão SIMULAR dos tipos de seguros disponíveis;
     *
     * @param tipoProtecao;
     * @param tipoSeguro
     * @return boolean
     * @throws Exception
     */
    @Step("Procurar Botão Simular do carrosel selecionado")
    public boolean procuraBotaoSimular(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        By xpath = null;
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoBotaoSimular, "Não foi possível encontrar o botão SIMULAR do Carrossel 'Para o seu cartão'!");
        if (android) {
            xpath = procuraBotaoSimularAndroid(tipoSeguro, tipoProtecao);
        } else {
            xpath = procuraBotaoSimularIos(tipoSeguro, tipoProtecao);
        }
        if (nonNull(xpath)) {
            return true;
        }
        return false;
    }

    /**
     * Método responsável por encontrar e retorar true or false no botão SIMULAR dos tipos de seguros disponíveis no Android
     *
     * @param tipoProtecao
     * @param tipoSeguro
     * @return By
     * @throws Exception
     */
    private By procuraBotaoSimularAndroid(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        By botaoSimular = elementoBotaoSimular(tipoSeguro, tipoProtecao);
        By textoTipoProtecao = elementoTextoTipoProtecao(tipoSeguro, tipoProtecao);
        By cardTipoProtecao = elementocardTipoProtecao(tipoSeguro, tipoProtecao);
        for (int i = 0; i < 4; i++) {
            if (aguardarPaginaConterTodosTextos(tipoProtecao.toString())) {
                salvarEvidencia("Tocar no botão SIMULAR do produto '" + tipoProtecao + "'!");
                return botaoSimular;
            } else {
                deslizar(cardGenerico, Direcao.DIREITA, 90, 25);
            }
        }
        return null;
    }

    /**
     * Método responsável por encontrar e retorar true or false no botão SIMULAR dos tipos de seguros disponíveis no Ios
     *
     * @param tipoProtecao
     * @param tipoSeguro
     * @return By
     * @throws Exception
     */
    private By procuraBotaoSimularIos(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        By botaoSimular = elementoBotaoSimular(tipoSeguro, tipoProtecao);
        By textoTipoProtecao = elementoTextoTipoProtecao(tipoSeguro, tipoProtecao);
        By cardTipoProtecao = elementocardTipoProtecao(tipoSeguro, tipoProtecao);
        for (int i = 0; i < 4; i++) {
            if (aguardarPaginaConterTodosTextos(tipoProtecao.toString())) {
                salvarEvidencia("Tocar no botão SIMULAR do produto '" + tipoProtecao + "'!");
                return botaoSimular;
            } else {
                deslizar(cardGenerico, Direcao.DIREITA, 90, 25);
            }
        }
        return null;
    }


    /**
     * Método responsável por validar a tela HOME DE SEGUROS
     *
     * @return SegurosHomeTela
     * @throws Exception
     */
    @Step("Valida tela HOME SEGUROS")
    public SegurosHomeTela validaTelaHomeSeguros() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroHome);
        aguardarPaginaConterQualquerTexto("Para o seu dia a dia", "Para o seu cartão");
        compararElementoTexto(headerTituloSeguroHome, SegurosHome.TITULO_HOME, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela HOME DE SEGUROS");
        return this;
    }

    /**
     * Método responsável por encontrar e tocar no botão SIMULAR dos tipos de seguros disponíveis
     *
     * @param tipoProtecao
     * @param tipoSeguro
     * @return SegurosHomeTela
     * @throws Exception
     */
    @Step("Tocar no botão Simular do carrossel selecionado")
    public SegurosHomeTela tocarBotaoSimular(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        validaTelaHomeSeguros();
        By xpath = null;
        if (android) {
            xpath = procuraBotaoSimularAndroid(tipoSeguro, tipoProtecao);
        } else {
            xpath = procuraBotaoSimularIos(tipoSeguro, tipoProtecao);
        }

        tocarElemento(xpath, "Não foi possível tocar no botão 'SIMULAR'!");
        return this;
    }

    /**
     * Método responsável por encontrar e tocar no botão SIMULAR dos tipos de seguros disponíveis
     *
     * @param tipoProtecao
     * @param tipoSeguro
     * @return SegurosHomeTela
     * @throws Exception
     */
    @Step("Tocar no botão Simular do carrossel selecionado")
    public SegurosHomeTela tocarBotaoSimularComDeslizeDeTela(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        validaTelaHomeSeguros();
        By botaoSimular = elementoBotaoSimular(tipoSeguro, tipoProtecao);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSimular, "Não foi possível encontrar o botão 'SIMULAR'!");
        salvarEvidencia("Tocar botão 'SIMULAR'");
        tocarElemento(botaoSimular, "Não foi possível tocar no botão 'SIMULAR'!");
        return this;
    }

    /**
     * Método responsável por tocar na aba MEUS SEGUROS
     *
     * @return SegurosHomeTela
     * @throws NextException
     */
    @Step("Tocar na aba 'MEUS SEGUROS'")
    public SegurosHomeTela tocarAbaMeusSeguros() throws NextException {
        salvarEvidencia("Tocar aba 'MEUS SEGUROS'");
        tocarElemento(abaMeusSeguros, "Não foi possível tocar na aba 'MEUS SEGUROS'");
        return this;
    }

    /**
     * Método responsável por tocar no botão VER DETALHES DO PLANO
     *
     * @return SegurosHomeTela
     * @throws NextException
     */
    @Step("Tocar no botão 'VER DETALHES DO PLANO'")
    public SegurosHomeTela tocarBotaoVerDetalhesDoPlano() throws NextException {
        aguardarCarregamentoElemento(verDetalhesDoPlano);
        aguardarPaginaConterTodosTextos(String.valueOf(SegurosHome.TEXTO_CARD_ATIVO));
        salvarEvidencia("Tocar botão 'VER DETALHES DO PLANO'");
        tocarElemento(verDetalhesDoPlano, "Não foi possível tocar botão 'VER DETALHES DO PLANO'");
        return this;
    }

    /**
     * Método responsável por tocar no botão de cada seguro contratado
     *
     * @param seguroContratado
     * @return SegurosHomeTela
     * @throws NextException
     */
    @Step("Tocar no botão do seguro contratado")
    public SegurosHomeTela tocarBotaoSeguroContratado(String seguroContratado) throws NextException {
        By botaoSeguroContratado;
        if (android) {
            botaoSeguroContratado = By.xpath("//*[@resource-id='br.com.bradesco.next:id/nl_insurance_title' and contains(@text, '" + seguroContratado + "')]");
        } else {
            botaoSeguroContratado = By.xpath("//*[contains(@label, '" + seguroContratado + "')]");
        }
        salvarEvidencia("Tocar botão '" + seguroContratado + "'");
        tocarElemento(botaoSeguroContratado, "Não possível tocar no botão '" + seguroContratado + "'");

        return this;
    }

    /**
     * Método responsável por tocar no botão Cancelamento
     *
     * @return SegurosHomeTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Cancelamento'")
    public SegurosHomeTela tocarBotaoCancelamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCancelamento, "Não foi possível encontrar o botão 'Cancelamento'");
        salvarEvidencia("Tocar botão 'Cancelamento'");
        tocarElemento(botaoCancelamento, "Não foi possível tocar no botão 'Cancelamento'");
        return this;
    }

    /**
     * Método para validar a Não Existência de um card
     *
     * @param tipoSeguro
     * @param tipoProtecao
     * @return SegurosHomeTela
     * @throws Exception
     */
    public SegurosHomeTela validarNaoExistenciaDoCard(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        validarCondicaoBooleana(procuraBotaoSimular(tipoSeguro, tipoProtecao), MetodoComparacaoBooleano.FALSO, "Card Encontrado");
        salvarEvidencia("Card Não Encontrado");
        return this;
    }

    /**
     * metodo retorna elemento ver detalhes do plano
     *
     * @param tipoSeguroContratado
     * @return SegurosHomeTela
     */
    public SegurosHomeTela tocarBotaoVerDetalhesDoPlanoContratado(TipoSeguroContratado tipoSeguroContratado) throws Exception {
        aguardarExistenciaElemento(elementoVerDetalhesDoPlanoContratado(tipoSeguroContratado));
        salvarEvidencia("Tocar botão Ver Detalhes Do Plano Contratado");
        tocarElemento(elementoVerDetalhesDoPlanoContratado(tipoSeguroContratado), "Não foi possível tocar botão VER DETALHES DO PLANO - CRÉDITO");
        return this;
    }

    /**
     * Método responsável por tocar no botão 'SIMULAR NOVAMENTE'
     *
     * @return SegurosHomeTela
     * @throws NextException
     */
    @Step("Tocar no botão 'SIMULAR NOVAMENTE'")
    public SegurosHomeTela tocarBotaoSimularNovamente() throws NextException {
        salvarEvidencia("Tocar no botão 'SIMULAR NOVAMENTE'");
        tocarElemento(botaoSimularNovamente, "Não foi possível tocar no botão 'SIMULAR NOVAMENTE'");
        return this;
    }
}
