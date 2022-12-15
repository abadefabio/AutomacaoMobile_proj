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
    // T�tulo da tela HOME DE SEGUROS
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"SEGUROS\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSeguroHome;

    // Aba MEUS SEGUROS
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Tab, Meus Seguros, n�o selecionado, 2 de 2\"]/android.widget.RelativeLayout/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'myInsurancesTab')]")
    private MobileElement abaMeusSeguros;

    // Bot�o Cancelamento
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/ctv_text' and contains(@text, 'Cancelamento')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cancelamento']")
    private MobileElement botaoCancelamento;

    // Bot�o Ver Detalhes do Plano
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VER DETALHES DO PLANO\"]")
    private MobileElement verDetalhesDoPlano;

    // Bot�o Simular
    @AndroidFindBy(xpath = "//*[contains(@text, 'SIMULAR')]")
    @iOSXCUITFindBy(xpath = "//*[@label='SIMULAR']")
    private MobileElement textoBotaoSimular;

    // Card Generico
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_insurance_options_simulate")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"detailsButton\"])[1]")
    private MobileElement cardGenerico;

    // Bot�o Simular Novamente
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
     * Metodo retorna elemento texto tipo prote��o
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
     * Metodo retorna elemento card tipo prote��o
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
     * metodo retorna elemento bot�o simular
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
     * M�todo respons�vel por encontrar e retorar true or false no bot�o SIMULAR dos tipos de seguros dispon�veis;
     *
     * @param tipoProtecao;
     * @param tipoSeguro
     * @return boolean
     * @throws Exception
     */
    @Step("Procurar Bot�o Simular do carrosel selecionado")
    public boolean procuraBotaoSimular(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        By xpath = null;
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoBotaoSimular, "N�o foi poss�vel encontrar o bot�o SIMULAR do Carrossel 'Para o seu cart�o'!");
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
     * M�todo respons�vel por encontrar e retorar true or false no bot�o SIMULAR dos tipos de seguros dispon�veis no Android
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
                salvarEvidencia("Tocar no bot�o SIMULAR do produto '" + tipoProtecao + "'!");
                return botaoSimular;
            } else {
                deslizar(cardGenerico, Direcao.DIREITA, 90, 25);
            }
        }
        return null;
    }

    /**
     * M�todo respons�vel por encontrar e retorar true or false no bot�o SIMULAR dos tipos de seguros dispon�veis no Ios
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
                salvarEvidencia("Tocar no bot�o SIMULAR do produto '" + tipoProtecao + "'!");
                return botaoSimular;
            } else {
                deslizar(cardGenerico, Direcao.DIREITA, 90, 25);
            }
        }
        return null;
    }


    /**
     * M�todo respons�vel por validar a tela HOME DE SEGUROS
     *
     * @return SegurosHomeTela
     * @throws Exception
     */
    @Step("Valida tela HOME SEGUROS")
    public SegurosHomeTela validaTelaHomeSeguros() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroHome);
        aguardarPaginaConterQualquerTexto("Para o seu dia a dia", "Para o seu cart�o");
        compararElementoTexto(headerTituloSeguroHome, SegurosHome.TITULO_HOME, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela HOME DE SEGUROS");
        return this;
    }

    /**
     * M�todo respons�vel por encontrar e tocar no bot�o SIMULAR dos tipos de seguros dispon�veis
     *
     * @param tipoProtecao
     * @param tipoSeguro
     * @return SegurosHomeTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Simular do carrossel selecionado")
    public SegurosHomeTela tocarBotaoSimular(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        validaTelaHomeSeguros();
        By xpath = null;
        if (android) {
            xpath = procuraBotaoSimularAndroid(tipoSeguro, tipoProtecao);
        } else {
            xpath = procuraBotaoSimularIos(tipoSeguro, tipoProtecao);
        }

        tocarElemento(xpath, "N�o foi poss�vel tocar no bot�o 'SIMULAR'!");
        return this;
    }

    /**
     * M�todo respons�vel por encontrar e tocar no bot�o SIMULAR dos tipos de seguros dispon�veis
     *
     * @param tipoProtecao
     * @param tipoSeguro
     * @return SegurosHomeTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Simular do carrossel selecionado")
    public SegurosHomeTela tocarBotaoSimularComDeslizeDeTela(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        validaTelaHomeSeguros();
        By botaoSimular = elementoBotaoSimular(tipoSeguro, tipoProtecao);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSimular, "N�o foi poss�vel encontrar o bot�o 'SIMULAR'!");
        salvarEvidencia("Tocar bot�o 'SIMULAR'");
        tocarElemento(botaoSimular, "N�o foi poss�vel tocar no bot�o 'SIMULAR'!");
        return this;
    }

    /**
     * M�todo respons�vel por tocar na aba MEUS SEGUROS
     *
     * @return SegurosHomeTela
     * @throws NextException
     */
    @Step("Tocar na aba 'MEUS SEGUROS'")
    public SegurosHomeTela tocarAbaMeusSeguros() throws NextException {
        salvarEvidencia("Tocar aba 'MEUS SEGUROS'");
        tocarElemento(abaMeusSeguros, "N�o foi poss�vel tocar na aba 'MEUS SEGUROS'");
        return this;
    }

    /**
     * M�todo respons�vel por tocar no bot�o VER DETALHES DO PLANO
     *
     * @return SegurosHomeTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'VER DETALHES DO PLANO'")
    public SegurosHomeTela tocarBotaoVerDetalhesDoPlano() throws NextException {
        aguardarCarregamentoElemento(verDetalhesDoPlano);
        aguardarPaginaConterTodosTextos(String.valueOf(SegurosHome.TEXTO_CARD_ATIVO));
        salvarEvidencia("Tocar bot�o 'VER DETALHES DO PLANO'");
        tocarElemento(verDetalhesDoPlano, "N�o foi poss�vel tocar bot�o 'VER DETALHES DO PLANO'");
        return this;
    }

    /**
     * M�todo respons�vel por tocar no bot�o de cada seguro contratado
     *
     * @param seguroContratado
     * @return SegurosHomeTela
     * @throws NextException
     */
    @Step("Tocar no bot�o do seguro contratado")
    public SegurosHomeTela tocarBotaoSeguroContratado(String seguroContratado) throws NextException {
        By botaoSeguroContratado;
        if (android) {
            botaoSeguroContratado = By.xpath("//*[@resource-id='br.com.bradesco.next:id/nl_insurance_title' and contains(@text, '" + seguroContratado + "')]");
        } else {
            botaoSeguroContratado = By.xpath("//*[contains(@label, '" + seguroContratado + "')]");
        }
        salvarEvidencia("Tocar bot�o '" + seguroContratado + "'");
        tocarElemento(botaoSeguroContratado, "N�o poss�vel tocar no bot�o '" + seguroContratado + "'");

        return this;
    }

    /**
     * M�todo respons�vel por tocar no bot�o Cancelamento
     *
     * @return SegurosHomeTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Cancelamento'")
    public SegurosHomeTela tocarBotaoCancelamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCancelamento, "N�o foi poss�vel encontrar o bot�o 'Cancelamento'");
        salvarEvidencia("Tocar bot�o 'Cancelamento'");
        tocarElemento(botaoCancelamento, "N�o foi poss�vel tocar no bot�o 'Cancelamento'");
        return this;
    }

    /**
     * M�todo para validar a N�o Exist�ncia de um card
     *
     * @param tipoSeguro
     * @param tipoProtecao
     * @return SegurosHomeTela
     * @throws Exception
     */
    public SegurosHomeTela validarNaoExistenciaDoCard(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        validarCondicaoBooleana(procuraBotaoSimular(tipoSeguro, tipoProtecao), MetodoComparacaoBooleano.FALSO, "Card Encontrado");
        salvarEvidencia("Card N�o Encontrado");
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
        salvarEvidencia("Tocar bot�o Ver Detalhes Do Plano Contratado");
        tocarElemento(elementoVerDetalhesDoPlanoContratado(tipoSeguroContratado), "N�o foi poss�vel tocar bot�o VER DETALHES DO PLANO - CR�DITO");
        return this;
    }

    /**
     * M�todo respons�vel por tocar no bot�o 'SIMULAR NOVAMENTE'
     *
     * @return SegurosHomeTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'SIMULAR NOVAMENTE'")
    public SegurosHomeTela tocarBotaoSimularNovamente() throws NextException {
        salvarEvidencia("Tocar no bot�o 'SIMULAR NOVAMENTE'");
        tocarElemento(botaoSimularNovamente, "N�o foi poss�vel tocar no bot�o 'SIMULAR NOVAMENTE'");
        return this;
    }
}
