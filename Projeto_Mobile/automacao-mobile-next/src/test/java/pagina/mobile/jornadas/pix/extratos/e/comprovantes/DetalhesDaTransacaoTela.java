package pagina.mobile.jornadas.pix.extratos.e.comprovantes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static constantes.pix.DetalhesDaTransacaoPix.TITULO_DETALHES_DA_TRANSACAO;

public class DetalhesDaTransacaoTela extends PaginaBase {

    public DetalhesDaTransacaoTela(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(xpath = "//*[@name='Reportar um problema']")
    @AndroidFindBy(xpath = "//*[@text='Reportar um problema']")
    private MobileElement botaoReportarUmProblema;

    @iOSXCUITFindBy(xpath = "(//*[@name='Pix em contesta��o'])[2]")
    @AndroidFindBy(xpath = "//*[@text='Pix em contesta��o']")
    private MobileElement botaoPixEmContestacao;

    /**
     * Tocar bot�o 'Reportar um Problema'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Reportar um Problema'")
    public DetalhesDaTransacaoTela tocarBotaoReportarUmProblema() throws Exception {
        aguardarPaginaConterTodosTextos(TITULO_DETALHES_DA_TRANSACAO.toString());
        rolarTelaAteFinal();
        salvarEvidencia("Tocar bot�o 'Reportar um Problema'");
        tocarElemento(botaoReportarUmProblema, "N�o foi poss�vel tocar no bot�o 'Reportar um Problema'");
        return this;
    }

    /**
     * Tocar bot�o 'Pix em contesta��o'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Pix em contesta��o'")
    public DetalhesDaTransacaoTela tocarBotaoPixEmContestacao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPixEmContestacao, "Erro ao encontrar o bot�o 'Pix em contesta��o'");
        salvarEvidencia("Tocar bot�o 'Pix em contesta��o'");
        tocarElemento(botaoPixEmContestacao, "N�o foi poss�vel tocar no bot�o 'Pix em contesta��o'");
        return this;
    }
}
