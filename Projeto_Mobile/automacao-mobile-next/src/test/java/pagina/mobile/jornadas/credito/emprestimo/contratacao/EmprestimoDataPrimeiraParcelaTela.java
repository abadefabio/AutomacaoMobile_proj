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
     * Validar presença da tela 'Data Primeira Parcela Empréstimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença tela 'Data Primeira Parcela Empréstimo'")
    public EmprestimoDataPrimeiraParcelaTela validarPresencaTelaDataPrimeiraParcelaEmprestimo() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO, Mensagem.DATA_PRIMEIRA_PARCELA_EMPRESTIMO), MetodoComparacaoBooleano.VERDADEIRO, "Título '" + TituloTela.EMPRESTIMO + "' e/ou mensagem '" + Mensagem.DATA_PRIMEIRA_PARCELA_EMPRESTIMO + "' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela 'Data Primeira Parcela Empréstimo'");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public EmprestimoDataPrimeiraParcelaTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
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
        tocarElemento(linkEscolher, "Não foi possível tocar no link 'Escolher'");
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
     * Selecionar quantidade de dias para débito da primeira parcela do empréstimo
     *
     * @param quantidadeDias
     * @return
     * @throws Exception
     */
    @Step("Selecionar quantidade de dias para débito da primeira parcela do empréstimo")
    public EmprestimoDataPrimeiraParcelaTela selecionarQuantidadeDiasPrimeiraParcelaEmprestimo(String quantidadeDias) throws Exception {
        By seletorQuantidadeDias;
        seletorQuantidadeDias = ios ? new By.ByXPath("construirElementoIos'" + quantidadeDias + "'") : new By.ByXPath("construirElementoAndroid'" + quantidadeDias + "'");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(seletorQuantidadeDias, "Não foi possível encontrar a quantidade de dias :" + quantidadeDias);
        salvarEvidencia("Selecionar quantidade de dias para débito da primeira parcela do empréstimo");
        tocarElemento(seletorQuantidadeDias, "Não foi possível tocar na quantidade de dias escolhida");
        return this;
    }

    /**
     * Tocar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public EmprestimoDataPrimeiraParcelaTela tocarbotaoContinuar() throws Exception {
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Tocar botão '15 dias'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão '15 dias'")
    public EmprestimoDataPrimeiraParcelaTela selecionarDataPrimeiraParcela() throws Exception {
        if (android){
            salvarEvidencia("Tocar botão '15 dias'");
            tocarElemento(dataDiasParcela, "Não foi possível tocar no botão '15 dias'");
        }
        return this;
    }

    /**
     * Tocar botão 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Confirmar'")
    public EmprestimoDataPrimeiraParcelaTela tocarBotaoConfirmar() throws Exception {

        if (ios){
            salvarEvidencia("Tocar botão 'Confirmar'");
            tocarElemento(botaoConfirmar, "Não foi possível tocar no botão 'Confirmar'");
        }
        return this;
    }
}
