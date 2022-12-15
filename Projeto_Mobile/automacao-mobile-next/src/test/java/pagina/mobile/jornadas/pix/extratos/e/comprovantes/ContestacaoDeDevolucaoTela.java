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

    @iOSXCUITFindBy(accessibility = "Declaro que as informações são verdadeiras.. . . Caixa de seleção. Toque duas vezes para selecionar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    private MobileElement checkbox;

    @iOSXCUITFindBy(accessibility = "SOLICITAR DEVOLUÇÃO")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_pix_med_request_devolution")
    private MobileElement botaoSolicitarDevolucao;

    @iOSXCUITFindBy(accessibility = "VOLTAR AO PIX")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    private MobileElement botaoVoltarAoPix;

    /**
     * Selecionar o tipo de contestação
     *
     * @throws Exception
     */
    @Step("Selecionar o tipo de contestação'")
    public ContestacaoDeDevolucaoTela selecionarOTipoDeContestacao(TipoContestacao contestacao) throws Exception {
        By localizador = android ? new By.ByXPath("//*[@text='" + contestacao + "']") :
                                   new By.ByXPath("//*[@name='" + contestacao + "']");
        aguardarCarregamentoElemento(localizador);
        salvarEvidencia("Selecionada contestação por '" + contestacao + "'.");
        tocarElemento(localizador, "Não foi possível selecionar a contestação '" + contestacao + "'.");
        return this;
    }

    /**
     * Preencher campo descrição
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo descrição")
    public ContestacaoDeDevolucaoTela preencherCampoDescricao(String descricaoContestacao) throws Exception {
        aguardarCarregamentoElemento(campoDescricao);
        escreverTexto(campoDescricao, descricaoContestacao, false, "Erro ao inserir dados no campo descrição");
        salvarEvidencia("Campo descrição preenchido");
        return this;
    }

    /**
     * Tocar no botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'Continuar'")
    public ContestacaoDeDevolucaoTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkbox, "Checkbox não encontrado");
        tocarElemento(checkbox, "Não foi possível Selecionar Checkbox ");
        salvarEvidencia("Checkbox selecionado");
        return this;
    }

    /**
     * Tocar no botão 'Solicitar Devolução'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'Solicitar Devolução'")
    public ContestacaoDeDevolucaoTela tocarBotaoSolicitarDevolucao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSolicitarDevolucao,"Não foi possível encontrar o botão 'Solicitar Devolução'");
        salvarEvidencia("Tocar botão 'Solicitar Devolução'");
        tocarElemento(botaoSolicitarDevolucao, "Não foi possível tocar no botão 'Solicitar Devolução'");
        return this;
    }

    /**
     * Tocar no botão 'Voltar Ao Pix'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'Voltar Ao Pix'")
    public ContestacaoDeDevolucaoTela tocarBotaoVoltarAoPix() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar Ao Pix'");
        tocarElemento(botaoVoltarAoPix, "Não foi possível tocar no botão 'Voltar Ao Pix'");
        return this;
    }

}
