package pagina.mobile.jornadas.doacoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class DoacoesTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"VISA CAUSAS\"`]")
    private MobileElement tituloDoacoes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Crianças e Adolescentes \"]")
    private MobileElement labelCriancasAdolecentes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_choose_new")
    @iOSXCUITFindBy(accessibility = "ESCOLHER UM NOVO APOIO")
    private MobileElement botaoEscolherUmNovoApoio;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_leave_supporting")
    @iOSXCUITFindBy(accessibility = "DEIXAR DE APOIAR")
    private MobileElement botaoDeixarDeApoiar;

    public DoacoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
    *
    * Validar exibição tela "Doações"
    *
    * @throws Exception
    */
    @Step("Validar titulo Doações")
    public DoacoesTela validarExibicaoTelaDoacoes() throws Exception{
         validarCondicaoBooleana(aguardarCarregamentoElemento(tituloDoacoes),
                 MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar e exibição da tela 'Doações'");
         salvarEvidencia("Validar a exibição da tela 'Doações'");
         return this;
     }

    /**
     * Tocar botão Voltar
     *
     * @throws Exception
     */
    @Step("Tocar botão Voltar")
    public DoacoesTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar botão Voltar");
        tocarElemento(botaoVoltar,"Não foi possível tocar no botão Voltar");
        return this;
    }

    /**
     * Validar mensagem "Crianças e Adolescentes"
     *
     * @throws Exception
     */
    @Step("Validar mensagem Crianças e Adolescentes")
    public DoacoesTela validarMensagemCriancasAdolescentes() throws Exception{
        validarCondicaoBooleana(aguardarCarregamentoElemento(labelCriancasAdolecentes),MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível encontrar o texto 'Crianças e Adolescentes'");
        salvarEvidencia("Validar texto Crianças e Adolescentes");
        return this;
    }

    /**
     * Tocar botão ESCOLHER UM NOVO APOIO
     *
     * @throws Exception
     */
    @Step("Tocar botão ESCOLHER UM NOVO APOIO")
    public DoacoesTela tocarBotaoEscolherUmNovoApoio() throws Exception{
        salvarEvidencia("Tocar botão ESCOLHER UM NOVO APOIO");
        tocarElemento(botaoEscolherUmNovoApoio,"Não foi possível tocar no botão 'ESCOLHER UM NOVO APOIO'");
        return this;
    }

    /**
     * Tocar botão DEIXAR DE APOIAR
     *
     * @throws Exception
     */
    @Step("Tocar botão DEIXAR DE APOIAR")
    public DoacoesTela tocarBotaoDeixarDeApoiar() throws Exception{
        salvarEvidencia("Tocar botão DEIXAR DE APOIAR");
        tocarElemento(botaoDeixarDeApoiar,"Não foi possível tocar no botão 'DEIXAR DE APOIAR'");
        return this;
    }
}
