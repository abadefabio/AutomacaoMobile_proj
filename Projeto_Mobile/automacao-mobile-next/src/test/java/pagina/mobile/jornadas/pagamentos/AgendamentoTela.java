package pagina.mobile.jornadas.pagamentos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;


import static br.com.next.automacao.core.constantes.MetodoComparacaoBooleano.VERDADEIRO;
import static constantes.pagamentos.TituloTela.AGENDAMENTO;


public class AgendamentoTela extends PaginaBase{

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_receipts_visualize")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Visualizar\")]")
    @iOSXCUITFindBy(accessibility = "Visualizar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Visualizar')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Visualizar'`]")
    private MobileElement botaoVisualizar;

    public AgendamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar a presenca do titulo agendamento na tela
     *
     * @return AgendamentoTela
     * @throws Exception
     */
    @Step("Validar a presenca do titulo agendamento na tela")
    public AgendamentoTela validarTextoTituloAgendamento() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(AGENDAMENTO), VERDADEIRO, "Titulo '" + AGENDAMENTO + "' nao esta presente na tela");
        salvarEvidencia("Validado título '" + AGENDAMENTO + "' presente na tela");
        return this;
    }

    /**
     * Validar informações da conta de consumo
     *
     * @param favorecido
     * @param valor
     * @return AgendamentoTela
     * @throws Exception
     */
    @Step("Validar informações da conta de consumo")
    public AgendamentoTela validarInformacoesDePagamento(String favorecido, String valor) throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(favorecido, valor), VERDADEIRO, "Erro ao localizar as informações da conta de consumo");
        salvarEvidencia("Dados validados: Descrição " + favorecido + " e Valor " + valor);
        return this;
    }

    /**
     * Tocar no botao visualizar
     *
     * @return AgendamentoTela
     * @throws Exception
     */
    @Step("Tocar no botão visualizar")
    public AgendamentoTela tocarBotaoVisualizar() throws Exception {
        salvarEvidencia("Tocar no botão visualizar");
        tocarElemento(botaoVisualizar, "Não foi possível tocar botão visualizar");
        return this;
    }
}
