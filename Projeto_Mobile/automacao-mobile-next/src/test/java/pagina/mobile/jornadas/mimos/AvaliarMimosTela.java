package pagina.mobile.jornadas.mimos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.mimos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AvaliarMimosTela extends PaginaBase {

    public AvaliarMimosTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Duas estrelas")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$label == \"emptyStar\"$][2]")
    private MobileElement avaliacaoDuasEstrelas;

    @AndroidFindBy(accessibility = "5 estrelas")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$label == \"emptyStar\"$][5]")
    private MobileElement avaliacaoCincoEstrelas;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nti_edit_text_comment")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeTextField\"")
    private MobileElement campoComentario;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_send")
    @iOSXCUITFindBy(accessibility = "Avaliar mimo")
    private MobileElement botaoAvaliarMimo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_not_now")
    @iOSXCUITFindBy(accessibility = "AGORA N�O")
    private MobileElement botaoAgoraNao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "fechar")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    /**
     * Validar presen�a da tela 'AVALIAR MIMO'
     *
     * @return AvaliarMimosTela
     * @throws Exception
     */
    @Step("Validar presen�a tela 'AVALIAR MIMO'")
    public AvaliarMimosTela validarPresencaTelaAvaliarMimo() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(TituloTela.AVALIAR_MIMO), MetodoComparacaoBooleano.VERDADEIRO, "A tela 'AVALIAR MIMO' n�o est� presente!");
        salvarEvidencia("Validado presen�a da tela 'AVALIAR MIMO'");
        return this;
    }

    /**
     * Tocar avalia��o 'Duas Estrelas'
     *
     * @return AvaliarMimosTela
     * @throws Exception
     */
    @Step("Tocar Avalia��o 'Duas Estrelas'")
    public AvaliarMimosTela tocarAvaliacaoDuasEstrelas() throws Exception {
        aguardarCarregamentoElemento(avaliacaoDuasEstrelas);
        if (getDriver() instanceof AndroidDriver) {
            esconderTeclado();
        }
        tocarElemento(avaliacaoDuasEstrelas, "N�o foi poss�vel tocar avalia��o 'Duas Estrelas'!");
        salvarEvidencia("Tocar avalia��o 'Duas Estrelas'!");
        return this;
    }

    /**
     * Tocar avalia��o 'Cinco Estrelas'
     *
     * @return AvaliarMimosTela
     * @throws Exception
     */
    @Step("Tocar Avalia��o 'Cinco Estrelas'")
    public AvaliarMimosTela tocarAvaliacaoCincoEstrelas() throws Exception {
        aguardarCarregamentoElemento(avaliacaoCincoEstrelas);
        if (getDriver() instanceof AndroidDriver) {
            esconderTeclado();
        }
        tocarElemento(avaliacaoCincoEstrelas, "N�o foi poss�vel tocar avalia��o 'Cinco Estrelas'!");
        salvarEvidencia("Tocar avalia��o 'Cinco Estrelas'!");
        return this;
    }

    /**
     * Preencher Campo 'Coment�rio'
     *
     * @return AvaliarMimosTela
     * @throws Exception
     */
    @Step("Preencher campo 'Comentario'")
    public AvaliarMimosTela preencherComentario() throws Exception {
        escreverTexto(campoComentario, "COMENTARIO PADRAO", "Nao foi possivel escrever texto campo 'Comentario'!");
        esconderTeclado();
        salvarEvidencia("Preencher campo comentario com 'COMENTARIO PADRAO'!");
        return this;
    }

    /**
     * Tocar bot�o 'Avaliar Mimo'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Avaliar Mimo'")
    public AvaliarMimosTela tocarBotaoAvaliarMimos() throws Exception {
        aguardarCarregamentoElemento(botaoAvaliarMimo);
        tocarElemento(botaoAvaliarMimo, "N�o foi poss�vel tocar no bot�o 'Avaliar Mimos'!");
        salvarEvidencia("Tocar no bot�o 'Avaliar Mimos'!");
        return this;
    }

    /**
     * Tocar bot�o 'AGORA NAO'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'AGORA NAO'")
    public AvaliarMimosTela tocarBotaoAgoraNao() throws Exception {
        tocarElemento(botaoAgoraNao, "N�o foi poss�vel tocar no bot�o 'AGORA NAO'!");
        salvarEvidencia("Tocar no bot�o 'AGIRA NAO'!");
        return this;
    }

    /**
     * Tocar bot�o 'Fechar'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Fechar'")
    public AvaliarMimosTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar bot�o 'Fechar'!");
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar bot�o 'Fechar'!");
        return this;
    }
}
