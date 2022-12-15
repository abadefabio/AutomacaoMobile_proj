package pagina.mobile.jornadas.credito;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.credito.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pagina.mobile.jornadas.vaquinha.VaquinhaTela;

public class CreditoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"CR�DITO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CR�DITO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"CR�DITO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"EMPR�STIMOS\"]")
    private MobileElement tituloCredito;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_request_limit_increase")
    @iOSXCUITFindBy(accessibility = "PEDIR MAIS LIMITE")
    private MobileElement botaoPedirMaisLimite;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ic_my_contracts_limit_cog")
    private MobileElement botaoConfigurarUsoLimite;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_details")
    private MobileElement botaoVerDetalhes;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Carregando\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name=\"carregando\")]")
    private MobileElement ampulheta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@name='Voltar']")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar']")
    private MobileElement botaoVoltar;

    @AndroidFindBy(xpath = "//me.next.uikit.NextChip[@text='Cr�dito Parcelado']/preceding-sibling::*//*[@text='SIMULAR']")
    @iOSXCUITFindBy(xpath = "//*[@value='Cr�dito Parcelado']/parent::*//*[@value='SIMULAR']")
    private MobileElement botaoSimularCreditoParcelado;

    @AndroidFindBy(xpath = "//me.next.uikit.NextChip[@text='Empr�stimo pessoal']/preceding-sibling::*//*[@text='SIMULAR']")
    @iOSXCUITFindBy(xpath = "//*[@value='Empr�stimo Pessoal']/parent::*//*[@value='SIMULAR']")
    private MobileElement botaoSimularEmprestimoPessoal;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_details")
    @iOSXCUITFindBy(accessibility = "ic_arrow_down_green")
    private MobileElement botaoVerDetalhesLimite;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_expand")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Limite Usado\"])[1]")
    private MobileElement botaoExpandirEmprestimos;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "Empr�stimo Pessoal")
    private MobileElement botaoExpandirEmprestimosPessoais;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ok\"]")
    private MobileElement botaoOkAviso;

    @iOSXCUITFindBy(xpath = "//*[@name='MEUS CONTRATOS']")
    @AndroidFindBy(xpath = "//*[@text='MEUS CONTRATOS']")
    private MobileElement abaMeusContratos;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Grana de Emerg�ncia']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_flex_overdraft_my_contracts_limit_adapt")
    private MobileElement botaoGranaEmergenciaCardLimiteFlex;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Empr�stimo']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_flex_loans_my_contracts_limit_adapt")
    private MobileElement botaoEmprestimoCardLimiteFlex;

    @iOSXCUITFindBy(xpath = "//*[@name='Limites']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/avatar_limits_my_contracts_frag")
    private MobileElement botaoLimites;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement caixaLimiteFlex;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_left_icon")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar para o Menu']")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    private MobileElement botaoMenu;

    public CreditoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar a exibi��o da Tela 'Cr�dito'
     *
     * @return
     */
    @Step("validar a exibi��o da Tela 'Cr�dito'")
    public CreditoTela validarExibicaoTelaCredito() throws Exception {
        OperadorEvidencia.logarPasso("Aguardando oculta��o da ampulheta ...");
        // solu��o devido a lentid�o do carregamento desta tela para evitar o "timeout" do aguardarCarregamentoElemento()
        aguardarOcultacaoElemento(ampulheta);
        OperadorEvidencia.logarPasso("Validando a tela 'Cr�dito' ...");
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloCredito),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar a exibi��o da Tela 'Cr�dito'");
        salvarEvidencia("Validou a exibi��o da Tela 'Cr�dito'");
        return this;
    }

    /**
     * Validar presen�a tela 'Cr�dito'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Cr�dito'")
    public CreditoTela validarPresencaTelaCredito() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CREDITO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Cr�dito' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela Cr�dito");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public CreditoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * tocar no bot�o 'Pedir Mais Limite'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Pedir Mais Limite'")
    public CreditoTela tocarBotaoPedirMaisLimite() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Pedir Mais Limite'");
        tocarElemento(botaoPedirMaisLimite, "Erro ao tocar no bot�o 'Pedir Mais Limite'");
        return this;
    }

    /**
     * Tocar bot�o 'Simular' do Cr�dito Parcelado
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Simular' do Empr�stimo Pessoal")
    public CreditoTela tocarBotaoSimularCreditoParcelado() throws Exception {
        salvarEvidencia("Tocar bot�o 'Simular' do Cr�dito Parcelado");
        tocarElemento(botaoSimularCreditoParcelado, "N�o foi poss�vel tocar no bot�o 'Simular' do Cr�dito Parcelado");
        return this;
    }

    /**
     * Tocar bot�o 'Simular' do Empr�stimo Pessoal
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Simular' do Empr�stimo Pessoal")
    public CreditoTela tocarBotaoSimularEmprestimoPessoal() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSimularEmprestimoPessoal, "N�o foi poss�vel tocar no bot�o 'Simular' do Empr�stimo Pessoal");
        salvarEvidencia("Tocar bot�o 'Simular' do Empr�stimo Pessoal");
        tocarElemento(botaoSimularEmprestimoPessoal, "N�o foi poss�vel tocar no bot�o 'Simular' do Empr�stimo Pessoal");
        return this;
    }


    /**
     * Tocar bot�o 'Ver Detalhes'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar bot�o 'Ver Detalhes'")
    public CreditoTela tocarBotaoVerDetalhes() throws Exception {
        if (android) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerDetalhes, "Erro a rolar at� o bot�o, 'Ver Detalhes'");
            salvarEvidencia("Tocar botao 'Ver Detalhes'");
            tocarElemento(botaoVerDetalhes, "Erro ao tocar no bot�o 'Ver Detalhes'");
        }
        return this;
    }

    /**
     * Tocar bot�o 'Ver detalhes (Limite)'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ver detalhes (Limite)'")
    public CreditoTela tocarBotaoVerDetalhesLimite() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerDetalhesLimite, "N�o foi poss�vel encontrar o bot�o 'Ver detalhes (Limite)'");
        salvarEvidencia("Tocar bot�o 'Ver detalhes (Limite)'");
        tocarElemento(botaoVerDetalhesLimite, "N�o foi poss�vel tocar no bot�o 'Ver detalhes (Limite)'");
        return this;
    }


    /**
     * Tocar bot�o 'Expandir' Limite pessoal Utilizado
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Expandir' Limite pessoal Utilizado")
    public CreditoTela tocarBotaoExpandirLimitePessoalUtilizado() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoExpandirEmprestimos, "N�o foi poss�vel encontrar o bot�o 'Expandir' Limite pessoal Utilizado");
        salvarEvidencia("Tocar bot�o 'Expandir' Limite pessoal Utilizado");
        tocarElemento(botaoExpandirEmprestimos, "N�o foi poss�vel tocar no bot�o 'Expandir' Limite pessoal Utilizado");
        return this;
    }


    /**
     * Tocar bot�o 'ok' aviso cr�dito j� utilizado
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'ok' ")
    public CreditoTela tocarBotaoOk() throws Exception {
        if (ios && verificarPresencaElemento(botaoOkAviso)) {
            salvarEvidencia("Tocar bot�o 'Ok'");
            tocarElemento(botaoOkAviso, "N�o foi poss�vel tocar no bot�o 'Ok'");
        }
        return this;
    }

    /**
     * Tocar Seta Emprestimo Pessoal
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar Seta Emprestimo Pessoal")
    public CreditoTela tocarSetaEmprestimoPessoal() throws Exception {
        salvarEvidencia("tocar Seta Emprestimo Pessoal");
        tocarElemento(botaoExpandirEmprestimosPessoais, "N�o foi poss�vel tocar Seta Emprestimo Pessoal");
        return this;
    }

    /**
     * Tocar botao 'Pagar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'Pagar'")
    public CreditoTela tocarBotaoPagar(String valorCredito) throws Exception {
        By botaoPagar = new By.ByXPath(ios ?
                "//*[contains(@name, '" + valorCredito + "')]/parent::*/*[@name='PAGAR']" :
                "//*[contains(@text, '" + valorCredito + "')]/parent::*/parent::*//*[@text='PAGAR']");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPagar, "Nao foi possivel encontrar o botao 'Pagar'");
        salvarEvidencia("Tocar botao 'Pagar'");
        tocarElemento(botaoPagar, "N�o foi poss�vel tocar no botao 'Pagar'");
        return this;
    }

    /**
     * Tocar aba 'MEUS CONTRATOS'
     *
     * @return
     */
    @Step("Tocar aba 'MEUS CONTRATOS'")
    public CreditoTela tocarAbaMeusContratos() throws NextException {
        salvarEvidencia("Tocar aba 'MEUS CONTRATOS'");
        tocarElemento(abaMeusContratos, "N�o foi poss�vel tocar aba 'MEUS CONTRATOS'");
        return this;
    }


    /**
     * Validar Opcao de Emprestimo Habilitado no card de 'Limite Flex'
     *
     * @return
     */
    @Step("Validar Opcao de Emprestimo no card de 'Limite Flex'")
    public CreditoTela validarEmprestimoHabilitadoNoLimiteFlex() {
        rolarTelaAteFinal();
        validarCondicaoBooleana(verificarPresencaElemento(botaoEmprestimoCardLimiteFlex), MetodoComparacaoBooleano.VERDADEIRO, "Opcao de Emprestimo ja esta desativado");
        salvarEvidencia("Validada presen�a da opcao de Emprestimo");
        return this;
    }

    /**
     * Validar Opcao de Grana de emergencia Habilitado no card de 'Limite Flex'
     *
     * @return
     */
    @Step("Validar Opcao de Grana de Emergencia no card de 'Limite Flex'")
    public CreditoTela validarGranaDeEmergenciaHabilitadoNoLimiteFlex() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoGranaEmergenciaCardLimiteFlex), MetodoComparacaoBooleano.VERDADEIRO, "Opcao de Grana Emergencia ja esta desativado");
        salvarEvidencia("Validada presen�a da opcao de Grana de Emergencia");
        return this;
    }

    /**
     * Validar Opcao de Emprestimo desabilidado no card de 'Limite Flex'
     *
     * @return
     */
    @Step("Validar Opcao de Emprestimo no card de 'Limite Flex'")
    public CreditoTela validarEmprestimoDesabilitadoNoLimiteFlex() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoEmprestimoCardLimiteFlex), MetodoComparacaoBooleano.FALSO, "Opcao de Emprestimo ainda esta ativada");
        salvarEvidencia("Validada Ausencia da opcao de Emprestimo");
        return this;
    }

    /**
     * Validar Opcao de Grana de emergencia desabiitado no card de 'Limite Flex'
     *
     * @return
     */
    @Step("Validar Opcao de Grana de Emergencia no card de 'Limite Flex'")
    public CreditoTela validarGranaDeEmergenciaDesabilitadoNoLimiteFlex() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoGranaEmergenciaCardLimiteFlex), MetodoComparacaoBooleano.FALSO, "Opcao de Grana de Emergencia ainda esta ativada");
        salvarEvidencia("Validada Ausencia da opcao de Grana de Emergencia");
        return this;
    }

    /**
     * Tocar botao 'CONFIGURAR USO LIMITE'
     *
     * @return
     */
    @Step("Tocar botao 'Configurar Uso do Limite'")
    public CreditoTela tocarBotaoConfigurarUsoLimite() throws NextException {
        salvarEvidencia("Tocar botao 'Configurar Uso do Limite'");
        rolaTelaBaixo();

        if (android) {
            tocarElemento(botaoConfigurarUsoLimite, "N�o foi poss�vel tocar botao 'configurar Uso do Limite'");
            aguardarOcultacaoElemento(botaoConfigurarUsoLimite);
        } else {
            tocarCoordenadaProporcional(caixaLimiteFlex, 86, 17);
            tocarCoordenadaProporcional(caixaLimiteFlex, 86, 20);
            aguardarOcultacaoElemento(ampulheta);
        }
        return this;
    }

    /**
     * Tocar botao 'Limites'
     *
     * @return
     */
    @Step("Tocar botao 'Limites'")
    public CreditoTela tocarBotaoLimites() throws NextException {
        aguardarCarregamentoElemento(botaoLimites);
        salvarEvidencia("Tocar botao 'Limites'");
        tocarElemento(botaoLimites, "N�o foi poss�vel tocar botao 'Limites'");
        aguardarPaginaConterQualquerTexto("LIMITE FLEX");
        return this;
    }

    /**
     * Tocar no �cone 'Menu'
     *
     * @return CreditoTela
     * @throws Exception
     */
    @Step("Tocar botao 'Menu'")
    public CreditoTela tocarBotaoMenu() throws Exception {
        aguardarCarregamentoElemento(botaoMenu);
        salvarEvidencia("Clicar no botao 'Menu'");
        tocarElemento(botaoMenu, "N�o foi poss�vel clicar no bot�o Menu");
        return this;
    }

}
