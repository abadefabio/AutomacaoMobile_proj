package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EscolhaSeuCartaoTela extends PaginaBase {

    public EscolhaSeuCartaoTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'Quero este cart�o')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"QUERO ESTE CART�O\"]")
    private MobileElement botaoQueroEsteCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/imageView21")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Pr�ximo\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \">\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\">\"]")
    private MobileElement botaoProximo;

    /**
     * Validar Titulo Tela 'Escolha seu Cart�o'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Escolha seu Cart�o'")
    public EscolhaSeuCartaoTela validarTituloTelaEscolhaSeuCartao() throws Exception {
        boolean telaPresente = (ios ?  aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.ESCOLHA_SEU_CARTAO_IOS)) : aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.ESCOLHA_SEU_CARTAO)));
        validarCondicaoBooleana(telaPresente, MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Escolha seu Cart�o' n�o est� presente na tela!");
        salvarEvidencia("Validada tela 'Escolha seu Cart�o'");
        return this;
    }

    /**
     * Tocar bot�o 'Quero este cart�o'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Quero este cart�o'")
    public EscolhaSeuCartaoTela tocarbotaoQueroEsteCartao() throws Exception {
        if(!verificarPresencaElemento(botaoQueroEsteCartao)){
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoQueroEsteCartao, "Bot�o 'Quero este cart�o' n�o localizado");
        }
        aguardarElementoHabilitado(botaoQueroEsteCartao);
        salvarEvidencia("Tocar bot�o 'Quero este cart�o'");
        tocarElemento(botaoQueroEsteCartao, "Erro ao tentar tocar no bot�o 'Quero este cart�o'");
        return this;
    }

    /**
     * Tocar bot�o 'Proximo'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Proximo'")
    public EscolhaSeuCartaoTela tocarProximo() throws Exception {
        tocarElemento(botaoProximo, "Erro ao tentar tocar no bot�o 'Proximo'");
        salvarEvidencia("Bot�o 'Proximo' tocado");
        return this;
    }
}
