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
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'Quero este cartão')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"QUERO ESTE CARTÃO\"]")
    private MobileElement botaoQueroEsteCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/imageView21")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Próximo\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \">\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\">\"]")
    private MobileElement botaoProximo;

    /**
     * Validar Titulo Tela 'Escolha seu Cartão'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Titulo Tela 'Escolha seu Cartão'")
    public EscolhaSeuCartaoTela validarTituloTelaEscolhaSeuCartao() throws Exception {
        boolean telaPresente = (ios ?  aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.ESCOLHA_SEU_CARTAO_IOS)) : aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.ESCOLHA_SEU_CARTAO)));
        validarCondicaoBooleana(telaPresente, MetodoComparacaoBooleano.VERDADEIRO, "Título 'Escolha seu Cartão' não está presente na tela!");
        salvarEvidencia("Validada tela 'Escolha seu Cartão'");
        return this;
    }

    /**
     * Tocar botão 'Quero este cartão'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Quero este cartão'")
    public EscolhaSeuCartaoTela tocarbotaoQueroEsteCartao() throws Exception {
        if(!verificarPresencaElemento(botaoQueroEsteCartao)){
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoQueroEsteCartao, "Botão 'Quero este cartão' não localizado");
        }
        aguardarElementoHabilitado(botaoQueroEsteCartao);
        salvarEvidencia("Tocar botão 'Quero este cartão'");
        tocarElemento(botaoQueroEsteCartao, "Erro ao tentar tocar no botão 'Quero este cartão'");
        return this;
    }

    /**
     * Tocar botão 'Proximo'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Proximo'")
    public EscolhaSeuCartaoTela tocarProximo() throws Exception {
        tocarElemento(botaoProximo, "Erro ao tentar tocar no botão 'Proximo'");
        salvarEvidencia("Botão 'Proximo' tocado");
        return this;
    }
}
