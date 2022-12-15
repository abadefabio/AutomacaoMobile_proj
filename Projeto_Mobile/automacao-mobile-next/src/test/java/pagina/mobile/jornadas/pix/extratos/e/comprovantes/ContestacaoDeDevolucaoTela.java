package pagina.mobile.jornadas.pix.extratos.e.comprovantes;

import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;

import constantes.pix.TipoContestacao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ContestacaoDeDevolucaoTela extends PaginaBase {

    public ContestacaoDeDevolucaoTela(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(xpath = "//*[@name='CONTINUAR']/../XCUIElementTypeOther")
    @AndroidFindBy(xpath = "(//*[@resource-id='br.com.bradesco.next:id/pmtf_message'])[2]")
    private MobileElement campoDescricao;

    @iOSXCUITFindBy(xpath = "(//*[@name='CONTINUAR'])[2]")
    @AndroidFindBy(xpath = "//*[@text='CONTINUAR']")
    private MobileElement botaoContinuar;

    @iOSXCUITFindBy(accessibility = "Declaro que as informa��es s�o verdadeiras.. . . Caixa de sele��o. Toque duas vezes para selecionar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    private MobileElement checkbox;

    @iOSXCUITFindBy(accessibility = "SOLICITAR DEVOLU��O")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_pix_med_request_devolution")
    private MobileElement botaoSolicitarDevolucao;

    @iOSXCUITFindBy(accessibility = "VOLTAR AO PIX")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    private MobileElement botaoVoltarAoPix;

    /**
     * Selecionar o tipo de contesta��o
     *
     * @throws Exception
     */
    @Step("Selecionar o tipo de contesta��o'")
    public ContestacaoDeDevolucaoTela selecionarOTipoDeContestacao(TipoContestacao contestacao) throws Exception {
        By localizador = android ? new By.ByXPath("//*[@text='" + contestacao + "']") :
                                   new By.ByXPath("//*[@name='" + contestacao + "']");
        aguardarCarregamentoElemento(localizador);
        salvarEvidencia("Selecionada contesta��o por '" + contestacao + "'.");
        tocarElemento(localizador, "N�o foi poss�vel selecionar a contesta��o '" + contestacao + "'.");
        return this;
    }

    /**
     * Preencher campo descri��o
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo descri��o")
    public ContestacaoDeDevolucaoTela preencherCampoDescricao(String descricaoContestacao) throws Exception {
        aguardarCarregamentoElemento(campoDescricao);
        escreverTexto(campoDescricao, descricaoContestacao, false, "Erro ao inserir dados no campo descri��o");
        salvarEvidencia("Campo descri��o preenchido");
        return this;
    }

    /**
     * Tocar no bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Continuar'")
    public ContestacaoDeDevolucaoTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Selecionar Checkbox
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Checkbox ")
    public ContestacaoDeDevolucaoTela selecionarCheckbox() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkbox, "Checkbox n�o encontrado");
        tocarElemento(checkbox, "N�o foi poss�vel Selecionar Checkbox ");
        salvarEvidencia("Checkbox selecionado");
        return this;
    }

    /**
     * Tocar no bot�o 'Solicitar Devolu��o'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Solicitar Devolu��o'")
    public ContestacaoDeDevolucaoTela tocarBotaoSolicitarDevolucao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSolicitarDevolucao,"N�o foi poss�vel encontrar o bot�o 'Solicitar Devolu��o'");
        salvarEvidencia("Tocar bot�o 'Solicitar Devolu��o'");
        tocarElemento(botaoSolicitarDevolucao, "N�o foi poss�vel tocar no bot�o 'Solicitar Devolu��o'");
        return this;
    }

    /**
     * Tocar no bot�o 'Voltar Ao Pix'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Voltar Ao Pix'")
    public ContestacaoDeDevolucaoTela tocarBotaoVoltarAoPix() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar Ao Pix'");
        tocarElemento(botaoVoltarAoPix, "N�o foi poss�vel tocar no bot�o 'Voltar Ao Pix'");
        return this;
    }

}
