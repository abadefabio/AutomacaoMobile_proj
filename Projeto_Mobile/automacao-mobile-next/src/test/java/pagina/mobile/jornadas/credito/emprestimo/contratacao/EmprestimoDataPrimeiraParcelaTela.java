package pagina.mobile.jornadas.credito.emprestimo.contratacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.credito.Mensagem;
import constantes.credito.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EmprestimoDataPrimeiraParcelaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@name='Voltar']")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar']")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_choose")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Escolher\"]")
    @iOSXCUITFindBy(accessibility = "Escolher")
    private MobileElement linkEscolher;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    private MobileElement dataDiasParcela;

    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    public EmprestimoDataPrimeiraParcelaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Data Primeira Parcela Empr�stimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Data Primeira Parcela Empr�stimo'")
    public EmprestimoDataPrimeiraParcelaTela validarPresencaTelaDataPrimeiraParcelaEmprestimo() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO, Mensagem.DATA_PRIMEIRA_PARCELA_EMPRESTIMO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo '" + TituloTela.EMPRESTIMO + "' e/ou mensagem '" + Mensagem.DATA_PRIMEIRA_PARCELA_EMPRESTIMO + "' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela 'Data Primeira Parcela Empr�stimo'");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public EmprestimoDataPrimeiraParcelaTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Tocar link 'Escolher'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar link 'Escolher'")
    public EmprestimoDataPrimeiraParcelaTela tocarLinkEscolher() throws Exception {
        salvarEvidencia("Tocar link 'Escolher'");
        tocarElemento(linkEscolher, "N�o foi poss�vel tocar no link 'Escolher'");
        return this;
    }

    /**
     * Verificar link 'Escolher' presente
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar link 'Escolher' presente")
    public boolean verificarLinkEscolherPresente() throws Exception {
        return verificarPresencaElemento(linkEscolher);
    }

    /**
     * Selecionar quantidade de dias para d�bito da primeira parcela do empr�stimo
     *
     * @param quantidadeDias
     * @return
     * @throws Exception
     */
    @Step("Selecionar quantidade de dias para d�bito da primeira parcela do empr�stimo")
    public EmprestimoDataPrimeiraParcelaTela selecionarQuantidadeDiasPrimeiraParcelaEmprestimo(String quantidadeDias) throws Exception {
        By seletorQuantidadeDias;
        seletorQuantidadeDias = ios ? new By.ByXPath("construirElementoIos'" + quantidadeDias + "'") : new By.ByXPath("construirElementoAndroid'" + quantidadeDias + "'");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(seletorQuantidadeDias, "N�o foi poss�vel encontrar a quantidade de dias :" + quantidadeDias);
        salvarEvidencia("Selecionar quantidade de dias para d�bito da primeira parcela do empr�stimo");
        tocarElemento(seletorQuantidadeDias, "N�o foi poss�vel tocar na quantidade de dias escolhida");
        return this;
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public EmprestimoDataPrimeiraParcelaTela tocarbotaoContinuar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Tocar bot�o '15 dias'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o '15 dias'")
    public EmprestimoDataPrimeiraParcelaTela selecionarDataPrimeiraParcela() throws Exception {
        if (android){
            salvarEvidencia("Tocar bot�o '15 dias'");
            tocarElemento(dataDiasParcela, "N�o foi poss�vel tocar no bot�o '15 dias'");
        }
        return this;
    }

    /**
     * Tocar bot�o 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Confirmar'")
    public EmprestimoDataPrimeiraParcelaTela tocarBotaoConfirmar() throws Exception {

        if (ios){
            salvarEvidencia("Tocar bot�o 'Confirmar'");
            tocarElemento(botaoConfirmar, "N�o foi poss�vel tocar no bot�o 'Confirmar'");
        }
        return this;
    }
}
