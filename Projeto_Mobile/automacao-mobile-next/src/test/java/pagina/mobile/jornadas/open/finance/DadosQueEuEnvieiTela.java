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
     * Validar presen�a tela 'Dados que eu enviei'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Dados que eu enviei'")
    public DadosQueEuEnvieiTela validarPresencaTelaDadosQueEuEnviei() throws Exception {
        validarCondicaoBooleana(!aguardarPaginaConterQualquerTexto(
                TituloTela.DADOS_QUE_EU_ENVIEI.toString()).equals("") , MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Dados que eu enviei' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'Dados que eu enviei'");
        return this;
    }

    /**
     * Tocar bot�o 'Ver detalhes'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ver detalhes'")
    public DadosQueEuEnvieiTela tocarBotaoVerDetalhes() throws Exception {
        if (!verificarPresencaElemento(botaoVerDetalhes)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerDetalhes, "N�o foi poss�vel encontrar o bot�o 'Ver detalhes'" );
        }
        salvarEvidencia("Tocar bot�o 'Ver detalhes'");
        tocarElemento(botaoVerDetalhes, "N�o foi poss�vel tocar no bot�o 'Ver detalhes'");
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
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a exibi��o do dado: 'Compartilhamento Ativo'");
        salvarEvidencia("Validar a exibi��o do dado: 'Compartilhamento Ativo'");
        return this;
    }

    /**
     * Tocar bot�o 'Expandir Detalhes do dado compartilhado(v)'
     * @param tipoDado
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Expandir Detalhes (v)'")
    public DadosQueEuEnvieiTela tocarBotaoExpandirDetalhes(String tipoDado) throws Exception {
        By botaoExpandirDetalhe;
        if (android){
            if(tipoDado.contains("Cr�dito")){
                tipoDado = tipoDado.replace("Cr�dito","cr�dito");
            }
            botaoExpandirDetalhe = By.xpath("//*[contains(@text,'" + tipoDado + "')]/../following-sibling::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']");
        }else{
            botaoExpandirDetalhe = By.xpath("//*[contains(@name,'" + tipoDado + "')]");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoExpandirDetalhe,"N�o foi poss�vel encontrar o bot�o 'Expandir Detalhes (v): ' '" + tipoDado + "'");
        salvarEvidencia("Tocar bot�o 'Expandir Detalhes (v): ' '" + tipoDado + "'");
        tocarElemento(botaoExpandirDetalhe, "N�o foi poss�vel tocar no bot�o 'Expandir Detalhes (v): ' '" + tipoDado + "'");
        return this;
    }

    /**
     * Tocar bot�o 'Informa��o (i)'
     * @param tipoDado
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Informa��o (i)'")
    public DadosQueEuEnvieiTela tocarBotaoInforma��o(String tipoDado) throws Exception {
        By botaoInformacao;
        if (android){
            if(tipoDado.contains(("Cadastro"))){
                rolarTelaAteInicio();
            }
            if(tipoDado.contains("Cr�dito")){
                tipoDado = tipoDado.replace("Cr�dito","cr�dito");
            }
            botaoInformacao = By.xpath("//*[contains(@text,'" + tipoDado + "')]/../following-sibling::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']");
        }else{
            botaoInformacao = By.xpath("(//XCUIElementTypeStaticText[@name='" + tipoDado + "']/../following-sibling::*)[1]/XCUIElementTypeImage/..");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInformacao,"N�o foi poss�vel encontrar o bot�o 'inform��o (i): ' '" + tipoDado + "'");
        salvarEvidencia("Tocar bot�o 'Informa��o (i): ' '" + tipoDado + "'");
        tocarElemento(botaoInformacao, "N�o foi poss�vel tocar no bot�o 'Informa��o (i): ' '" + tipoDado + "'");
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
        if(android && tipoDado.contains("Cr�dito")){
            tipoDado = tipoDado.replace("Cr�dito","cr�dito");
        }
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(tipoDado), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi pooss�vel validar a presen�a da tela '"+tipoDado+"'");
        salvarEvidencia("Validado presen�a da tela '"+tipoDado+"'");
        return this;
    }

    /**
     * Tocar bot�o 'Fechar'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Fechar'")
    public DadosQueEuEnvieiTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar bot�o 'Fechar'");
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar no bot�o 'Fechar'");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public DadosQueEuEnvieiTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Tocar bot�o 'Encerrar Compartilhamento'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Encerrar Compartilhamento'")
    public DadosQueEuEnvieiTela tocarBotaoEncerrarCompartilhamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEncerrarCompartilhamento, "N�o foi poss�vel encontrar o bot�o 'Encerrar Compartilhamento'");
        salvarEvidencia("Tocar bot�o 'Encerrar Compartilhamento'");
        tocarElemento(botaoEncerrarCompartilhamento, "N�o foi poss�vel tocar no bot�o 'Encerrar Compartilhamento'");
        return this;
    }

    /**
     * Tocar bot�o 'Sim, Encerrar'
     *
     * @return DadosQueEuEnvieiTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Sim, Encerrar'")
    public DadosQueEuEnvieiTela tocarBotaoSimEncerrar() throws Exception {
        aguardarCarregamentoElemento(botaoSimEncerrar);
        salvarEvidencia("Tocar bot�o 'Sim, Encerrar'");
        tocarElemento(botaoSimEncerrar, "N�o foi poss�vel tocar no bot�o 'Sim, Encerrar'");
        return this;
    }

}
