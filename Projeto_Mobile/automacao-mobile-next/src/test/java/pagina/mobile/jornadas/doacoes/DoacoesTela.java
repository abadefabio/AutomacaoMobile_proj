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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Crian�as e Adolescentes \"]")
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
    * Validar exibi��o tela "Doa��es"
    *
    * @throws Exception
    */
    @Step("Validar titulo Doa��es")
    public DoacoesTela validarExibicaoTelaDoacoes() throws Exception{
         validarCondicaoBooleana(aguardarCarregamentoElemento(tituloDoacoes),
                 MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar e exibi��o da tela 'Doa��es'");
         salvarEvidencia("Validar a exibi��o da tela 'Doa��es'");
         return this;
     }

    /**
     * Tocar bot�o Voltar
     *
     * @throws Exception
     */
    @Step("Tocar bot�o Voltar")
    public DoacoesTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar bot�o Voltar");
        tocarElemento(botaoVoltar,"N�o foi poss�vel tocar no bot�o Voltar");
        return this;
    }

    /**
     * Validar mensagem "Crian�as e Adolescentes"
     *
     * @throws Exception
     */
    @Step("Validar mensagem Crian�as e Adolescentes")
    public DoacoesTela validarMensagemCriancasAdolescentes() throws Exception{
        validarCondicaoBooleana(aguardarCarregamentoElemento(labelCriancasAdolecentes),MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel encontrar o texto 'Crian�as e Adolescentes'");
        salvarEvidencia("Validar texto Crian�as e Adolescentes");
        return this;
    }

    /**
     * Tocar bot�o ESCOLHER UM NOVO APOIO
     *
     * @throws Exception
     */
    @Step("Tocar bot�o ESCOLHER UM NOVO APOIO")
    public DoacoesTela tocarBotaoEscolherUmNovoApoio() throws Exception{
        salvarEvidencia("Tocar bot�o ESCOLHER UM NOVO APOIO");
        tocarElemento(botaoEscolherUmNovoApoio,"N�o foi poss�vel tocar no bot�o 'ESCOLHER UM NOVO APOIO'");
        return this;
    }

    /**
     * Tocar bot�o DEIXAR DE APOIAR
     *
     * @throws Exception
     */
    @Step("Tocar bot�o DEIXAR DE APOIAR")
    public DoacoesTela tocarBotaoDeixarDeApoiar() throws Exception{
        salvarEvidencia("Tocar bot�o DEIXAR DE APOIAR");
        tocarElemento(botaoDeixarDeApoiar,"N�o foi poss�vel tocar no bot�o 'DEIXAR DE APOIAR'");
        return this;
    }
}
