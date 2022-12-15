package pagina.mobile.jornadas.pagamentos.codigo.barras;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pagamentos.TituloTela;
import framework.AcoesGerais;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class ConfirmacaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_confirm")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Continuar')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continuar'`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continuar']")
    private MobileElement botaoContinuar;

    public ConfirmacaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Confirma��o'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Confirma��o'")
    public ConfirmacaoTela validarPresencaConfirmacaoTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CONFIRMACAO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Confirma��o' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'Confirma��o'");
        return this;
    }

    /**
     * Validar dados do boleto
     *
     * @param codigo
     * @param dataVencimento
     * @param dataPagamento
     * @param banco
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Validar dados do boleto")
    public ConfirmacaoTela validarDadosBoleto(String codigo, String dataVencimento, String dataPagamento, String banco, String valor) {
        esperarCarregando();
        codigo = codigo.replace(" . ", ".");
        try {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(codigo, banco), MetodoComparacaoBooleano.VERDADEIRO, "Algum dos textos n�o est�o presentes na tela...");
            salvarEvidencia("Dados de c�digo e banco do Boleto validados");
        } catch (AssertionError e) {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(codigo), MetodoComparacaoBooleano.VERDADEIRO, String.format("O c�digo '%s' do boleto n�o est� presente na tela!", codigo));
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(banco), MetodoComparacaoBooleano.VERDADEIRO, String.format("O banco '%s' do boleto n�o est� presente na tela!", banco));
        }
        rolaTelaBaixo();
        try {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(dataVencimento, dataPagamento, valor), MetodoComparacaoBooleano.VERDADEIRO, "Algum dos textos n�o est�o presentes na tela...");
            salvarEvidencia("Dados de data de vencimento, de pagamento e valor do Boleto validados");
        } catch (AssertionError e) {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(dataVencimento), MetodoComparacaoBooleano.VERDADEIRO, String.format("A data de vencimento '%s' do boleto n�o est� presente na tela!", dataVencimento));
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(dataPagamento), MetodoComparacaoBooleano.VERDADEIRO, String.format("A data de pagamento '%s' do boleto n�o est� presente na tela!", dataPagamento));
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(valor), MetodoComparacaoBooleano.VERDADEIRO, String.format("O valor '%s' do boleto n�o est� presente na tela!", valor));
        }
        return this;
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public ConfirmacaoTela tocarbotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "N�o foi poss�vel encontrar o bot�o 'Continuar'");
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }
}
