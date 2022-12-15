package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.open.finance.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DadosQueEuEnvieiTela extends PaginaBase {
    public DadosQueEuEnvieiTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "(//*[@resource-id='br.com.bradesco.next:id/na_logo']/following::*[@text='VER DETALHES'])[1]")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'Vence em')]/following::XCUIElementTypeStaticText[@name='VER DETALHES'])[1]")
    private MobileElement botaoVerDetalhes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nc_sharing_status")
    @iOSXCUITFindBy(accessibility = "Compartilhamento Ativo")
    private MobileElement tituloCompartilhamentoAtivo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Fechar')]")
    private MobileElement botaoFechar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Voltar')]")
    private MobileElement botaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_btn_revoke")
    @iOSXCUITFindBy(accessibility = "ENCERRAR COMPARTILHAMENTO")
    private MobileElement botaoEncerrarCompartilhamento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_btn_confirm")
    @iOSXCUITFindBy(accessibility = "SIM, ENCERRAR")
    private MobileElement botaoSimEncerrar;

    /**
     * Validar presença tela 'Dados que eu enviei'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença tela 'Dados que eu enviei'")
    public DadosQueEuEnvieiTela validarPresencaTelaDadosQueEuEnviei() throws Exception {
        validarCondicaoBooleana(!aguardarPaginaConterQualquerTexto(
                TituloTela.DADOS_QUE_EU_ENVIEI.toString()).equals("") , MetodoComparacaoBooleano.VERDADEIRO, "Título 'Dados que eu enviei' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'Dados que eu enviei'");
        return this;
    }

    /**
     * Tocar botão 'Ver detalhes'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar botão 'Ver detalhes'")
    public DadosQueEuEnvieiTela tocarBotaoVerDetalhes() throws Exception {
        if (!verificarPresencaElemento(botaoVerDetalhes)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerDetalhes, "Não foi possível encontrar o botão 'Ver detalhes'" );
        }
        salvarEvidencia("Tocar botão 'Ver detalhes'");
        tocarElemento(botaoVerDetalhes, "Não foi possível tocar no botão 'Ver detalhes'");
        return this;
    }

    /**
     * Validar 'Compartilhamento ativo'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Validar 'Compartilhamento ativo'")
    public DadosQueEuEnvieiTela validarCompartilhamentoAtivo() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloCompartilhamentoAtivo),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a exibição do dado: 'Compartilhamento Ativo'");
        salvarEvidencia("Validar a exibição do dado: 'Compartilhamento Ativo'");
        return this;
    }

    /**
     * Tocar botão 'Expandir Detalhes do dado compartilhado(v)'
     * @param tipoDado
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar botão 'Expandir Detalhes (v)'")
    public DadosQueEuEnvieiTela tocarBotaoExpandirDetalhes(String tipoDado) throws Exception {
        By botaoExpandirDetalhe;
        if (android){
            if(tipoDado.contains("Crédito")){
                tipoDado = tipoDado.replace("Crédito","crédito");
            }
            botaoExpandirDetalhe = By.xpath("//*[contains(@text,'" + tipoDado + "')]/../following-sibling::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']");
        }else{
            botaoExpandirDetalhe = By.xpath("//*[contains(@name,'" + tipoDado + "')]");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoExpandirDetalhe,"Não foi possível encontrar o botão 'Expandir Detalhes (v): ' '" + tipoDado + "'");
        salvarEvidencia("Tocar botão 'Expandir Detalhes (v): ' '" + tipoDado + "'");
        tocarElemento(botaoExpandirDetalhe, "Não foi possível tocar no botão 'Expandir Detalhes (v): ' '" + tipoDado + "'");
        return this;
    }

    /**
     * Tocar botão 'Informação (i)'
     * @param tipoDado
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar botão 'Informação (i)'")
    public DadosQueEuEnvieiTela tocarBotaoInformação(String tipoDado) throws Exception {
        By botaoInformacao;
        if (android){
            if(tipoDado.contains(("Cadastro"))){
                rolarTelaAteInicio();
            }
            if(tipoDado.contains("Crédito")){
                tipoDado = tipoDado.replace("Crédito","crédito");
            }
            botaoInformacao = By.xpath("//*[contains(@text,'" + tipoDado + "')]/../following-sibling::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']");
        }else{
            botaoInformacao = By.xpath("(//XCUIElementTypeStaticText[@name='" + tipoDado + "']/../following-sibling::*)[1]/XCUIElementTypeImage/..");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInformacao,"Não foi possível encontrar o botão 'informção (i): ' '" + tipoDado + "'");
        salvarEvidencia("Tocar botão 'Informação (i): ' '" + tipoDado + "'");
        tocarElemento(botaoInformacao, "Não foi possível tocar no botão 'Informação (i): ' '" + tipoDado + "'");
        return this;
    }

    /**
     * Validar tela dado compartilhado
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Validar tela dado compartilhado")
    public DadosQueEuEnvieiTela validarDadoCompartilhado(String tipoDado) throws Exception {
        if(android && tipoDado.contains("Crédito")){
            tipoDado = tipoDado.replace("Crédito","crédito");
        }
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(tipoDado), MetodoComparacaoBooleano.VERDADEIRO,"Não foi poossível validar a presença da tela '"+tipoDado+"'");
        salvarEvidencia("Validado presença da tela '"+tipoDado+"'");
        return this;
    }

    /**
     * Tocar botão 'Fechar'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar botão 'Fechar'")
    public DadosQueEuEnvieiTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar botão 'Fechar'");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão 'Fechar'");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public DadosQueEuEnvieiTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Tocar botão 'Encerrar Compartilhamento'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar botão 'Encerrar Compartilhamento'")
    public DadosQueEuEnvieiTela tocarBotaoEncerrarCompartilhamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEncerrarCompartilhamento, "Não foi possível encontrar o botão 'Encerrar Compartilhamento'");
        salvarEvidencia("Tocar botão 'Encerrar Compartilhamento'");
        tocarElemento(botaoEncerrarCompartilhamento, "Não foi possível tocar no botão 'Encerrar Compartilhamento'");
        return this;
    }

    /**
     * Tocar botão 'Sim, Encerrar'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar botão 'Sim, Encerrar'")
    public DadosQueEuEnvieiTela tocarBotaoSimEncerrar() throws Exception {
        aguardarCarregamentoElemento(botaoSimEncerrar);
        salvarEvidencia("Tocar botão 'Sim, Encerrar'");
        tocarElemento(botaoSimEncerrar, "Não foi possível tocar no botão 'Sim, Encerrar'");
        return this;
    }

}
