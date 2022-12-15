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
     * Validar as informações da nova solicitação
     *
     * @param produto         Produto a ser validado (next CDB, next Alocação Arrojada, etc)
     * @param tipoSolicitacao Tipo de solicitação a ser validado (Aplicação ou Resgate)
     * @param valor           Valor da solicitação
     * @param dataSolicitacao Data da solicitação
     * @return EmProcessamentoTela
     * @throws Exception
     */
    @Step("Validar as informações da nova solicitação")
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
            labelData = By.xpath("//*[@text='"+tipoSolicitacao+": R$ "+valor+"']/../following::*[contains(@text,'"+dataSolicitacao+" às')]");
            labelTipoProcessamento = By.xpath("//*[@text='"+tipoSolicitacao+": R$ "+valor+"']/../following::*[contains(@text,'"+tipoProcessamento+"')]");
        } else {
            labelTipoSolicitacaoEValor = By.xpath("//*[contains(@value, '"+tipoSolicitacao+"') and contains(@value, '"+valor+"')]");
            labelProduto = By.xpath("//*[contains(@value, '"+valor+"')]/preceding-sibling::*[starts-with(@value, '"+produto+"')]");
            labelData = By.xpath("//*[contains(@value, '"+valor+"')]/following-sibling::*[starts-with(@value, '"+dataSolicitacao+" às')]");
            labelTipoProcessamento = By.xpath("//*[contains(@value, '"+valor+"')]/following-sibling::*[starts-with(@value, '"+tipoProcessamento+"')]");
        }
        salvarEvidencia("Iniciada a validação das informações da nova solicitação");
        compararElementoTexto(labelProduto, produto, MetodoComparacao.CONTEM);
        compararElementoTexto(labelTipoSolicitacaoEValor, tipoSolicitacao, MetodoComparacao.CONTEM);
        compararElementoTexto(labelTipoSolicitacaoEValor, valor, MetodoComparacao.CONTEM);
        compararElementoTexto(labelTipoProcessamento, tipoProcessamento, MetodoComparacao.CONTEM);
        compararElementoTexto(labelData, dataSolicitacao, MetodoComparacao.CONTEM);
        salvarEvidencia("Finalizada a validação das informações da nova solicitação");
        return this;
    }

    /**
     * Tocar no botão 'Voltar' (<)
     *
     * @return EmProcessamentoTela
     * @throws NextException
     */
    @Step("Tocar no botão voltar (<)")
    public EmProcessamentoTela tocarBotaoVoltar() throws NextException {
        salvarEvidencia("Tocar no botão 'Voltar' (<)");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar' (<)");
        return this;
    }
}
