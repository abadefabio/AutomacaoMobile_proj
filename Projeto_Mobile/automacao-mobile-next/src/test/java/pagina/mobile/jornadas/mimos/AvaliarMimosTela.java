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
    @iOSXCUITFindBy(accessibility = "AGORA NÃO")
    private MobileElement botaoAgoraNao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "fechar")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    /**
     * Validar presença da tela 'AVALIAR MIMO'
     *
     * @return AvaliarMimosTela
     * @throws Exception
     */
    @Step("Validar presença tela 'AVALIAR MIMO'")
    public AvaliarMimosTela validarPresencaTelaAvaliarMimo() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(TituloTela.AVALIAR_MIMO), MetodoComparacaoBooleano.VERDADEIRO, "A tela 'AVALIAR MIMO' não está presente!");
        salvarEvidencia("Validado presença da tela 'AVALIAR MIMO'");
        return this;
    }

    /**
     * Tocar avaliação 'Duas Estrelas'
     *
     * @return AvaliarMimosTela
     * @throws Exception
     */
    @Step("Tocar Avaliação 'Duas Estrelas'")
    public AvaliarMimosTela tocarAvaliacaoDuasEstrelas() throws Exception {
        aguardarCarregamentoElemento(avaliacaoDuasEstrelas);
        if (getDriver() instanceof AndroidDriver) {
            esconderTeclado();
        }
        tocarElemento(avaliacaoDuasEstrelas, "Não foi possível tocar avaliação 'Duas Estrelas'!");
        salvarEvidencia("Tocar avaliação 'Duas Estrelas'!");
        return this;
    }

    /**
     * Tocar avaliação 'Cinco Estrelas'
     *
     * @return AvaliarMimosTela
     * @throws Exception
     */
    @Step("Tocar Avaliação 'Cinco Estrelas'")
    public AvaliarMimosTela tocarAvaliacaoCincoEstrelas() throws Exception {
        aguardarCarregamentoElemento(avaliacaoCincoEstrelas);
        if (getDriver() instanceof AndroidDriver) {
            esconderTeclado();
        }
        tocarElemento(avaliacaoCincoEstrelas, "Não foi possível tocar avaliação 'Cinco Estrelas'!");
        salvarEvidencia("Tocar avaliação 'Cinco Estrelas'!");
        return this;
    }

    /**
     * Preencher Campo 'Comentário'
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
     * Tocar botão 'Avaliar Mimo'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Avaliar Mimo'")
    public AvaliarMimosTela tocarBotaoAvaliarMimos() throws Exception {
        aguardarCarregamentoElemento(botaoAvaliarMimo);
        tocarElemento(botaoAvaliarMimo, "Não foi possível tocar no botão 'Avaliar Mimos'!");
        salvarEvidencia("Tocar no botão 'Avaliar Mimos'!");
        return this;
    }

    /**
     * Tocar botão 'AGORA NAO'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar no botão 'AGORA NAO'")
    public AvaliarMimosTela tocarBotaoAgoraNao() throws Exception {
        tocarElemento(botaoAgoraNao, "Não foi possível tocar no botão 'AGORA NAO'!");
        salvarEvidencia("Tocar no botão 'AGIRA NAO'!");
        return this;
    }

    /**
     * Tocar botão 'Fechar'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão 'Fechar'")
    public AvaliarMimosTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar botão 'Fechar'!");
        tocarElemento(botaoFechar, "Não foi possível tocar botão 'Fechar'!");
        return this;
    }
}
