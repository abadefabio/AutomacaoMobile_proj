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

    @iOSXCUITFindBy(xpath = "(//*[@name='Pix em contestação'])[2]")
    @AndroidFindBy(xpath = "//*[@text='Pix em contestação']")
    private MobileElement botaoPixEmContestacao;

    /**
     * Tocar botão 'Reportar um Problema'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Reportar um Problema'")
    public DetalhesDaTransacaoTela tocarBotaoReportarUmProblema() throws Exception {
        aguardarPaginaConterTodosTextos(TITULO_DETALHES_DA_TRANSACAO.toString());
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão 'Reportar um Problema'");
        tocarElemento(botaoReportarUmProblema, "Não foi possível tocar no botão 'Reportar um Problema'");
        return this;
    }

    /**
     * Tocar botão 'Pix em contestação'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Pix em contestação'")
    public DetalhesDaTransacaoTela tocarBotaoPixEmContestacao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPixEmContestacao, "Erro ao encontrar o botão 'Pix em contestação'");
        salvarEvidencia("Tocar botão 'Pix em contestação'");
        tocarElemento(botaoPixEmContestacao, "Não foi possível tocar no botão 'Pix em contestação'");
        return this;
    }
}
