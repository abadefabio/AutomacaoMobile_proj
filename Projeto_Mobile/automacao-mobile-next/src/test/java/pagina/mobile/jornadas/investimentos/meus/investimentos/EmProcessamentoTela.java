package pagina.mobile.jornadas.investimentos.meus.investimentos;

import org.openqa.selenium.By;
import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EmProcessamentoTela extends PaginaBase {

    @iOSXCUITFindBy(accessibility = "Voltar")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='menu']")
    private MobileElement botaoVoltar;

    public EmProcessamentoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Validar as informa��es da nova solicita��o
     *
     * @param produto         Produto a ser validado (next CDB, next Aloca��o Arrojada, etc)
     * @param tipoSolicitacao Tipo de solicita��o a ser validado (Aplica��o ou Resgate)
     * @param valor           Valor da solicita��o
     * @param dataSolicitacao Data da solicita��o
     * @return EmProcessamentoTela
     * @throws Exception
     */
    @Step("Validar as informa��es da nova solicita��o")
    public EmProcessamentoTela validarInformacoesNovaSolicitacao(
            String produto,
            String tipoSolicitacao,
            String valor,
            String tipoProcessamento,
            String dataSolicitacao)
            throws Exception {
        By labelTipoSolicitacaoEValor;
        By labelProduto;
        By labelData;
        By labelTipoProcessamento;
        if(android) {
            labelTipoSolicitacaoEValor = By.xpath("//*[@text='"+tipoSolicitacao+": R$ "+valor+"']");
            labelProduto = By.xpath("//*[@text='"+tipoSolicitacao+": R$ "+valor+"']/preceding::*[contains(@text,'"+produto+"')]");
            labelData = By.xpath("//*[@text='"+tipoSolicitacao+": R$ "+valor+"']/../following::*[contains(@text,'"+dataSolicitacao+" �s')]");
            labelTipoProcessamento = By.xpath("//*[@text='"+tipoSolicitacao+": R$ "+valor+"']/../following::*[contains(@text,'"+tipoProcessamento+"')]");
        } else {
            labelTipoSolicitacaoEValor = By.xpath("//*[contains(@value, '"+tipoSolicitacao+"') and contains(@value, '"+valor+"')]");
            labelProduto = By.xpath("//*[contains(@value, '"+valor+"')]/preceding-sibling::*[starts-with(@value, '"+produto+"')]");
            labelData = By.xpath("//*[contains(@value, '"+valor+"')]/following-sibling::*[starts-with(@value, '"+dataSolicitacao+" �s')]");
            labelTipoProcessamento = By.xpath("//*[contains(@value, '"+valor+"')]/following-sibling::*[starts-with(@value, '"+tipoProcessamento+"')]");
        }
        salvarEvidencia("Iniciada a valida��o das informa��es da nova solicita��o");
        compararElementoTexto(labelProduto, produto, MetodoComparacao.CONTEM);
        compararElementoTexto(labelTipoSolicitacaoEValor, tipoSolicitacao, MetodoComparacao.CONTEM);
        compararElementoTexto(labelTipoSolicitacaoEValor, valor, MetodoComparacao.CONTEM);
        compararElementoTexto(labelTipoProcessamento, tipoProcessamento, MetodoComparacao.CONTEM);
        compararElementoTexto(labelData, dataSolicitacao, MetodoComparacao.CONTEM);
        salvarEvidencia("Finalizada a valida��o das informa��es da nova solicita��o");
        return this;
    }

    /**
     * Tocar no bot�o 'Voltar' (<)
     *
     * @return EmProcessamentoTela
     * @throws NextException
     */
    @Step("Tocar no bot�o voltar (<)")
    public EmProcessamentoTela tocarBotaoVoltar() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Voltar' (<)");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar' (<)");
        return this;
    }
}
