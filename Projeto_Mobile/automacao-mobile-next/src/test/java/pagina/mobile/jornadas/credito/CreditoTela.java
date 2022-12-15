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
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"CRÉDITO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CRÉDITO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"CRÉDITO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"EMPRÉSTIMOS\"]")
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

    @AndroidFindBy(xpath = "//me.next.uikit.NextChip[@text='Crédito Parcelado']/preceding-sibling::*//*[@text='SIMULAR']")
    @iOSXCUITFindBy(xpath = "//*[@value='Crédito Parcelado']/parent::*//*[@value='SIMULAR']")
    private MobileElement botaoSimularCreditoParcelado;

    @AndroidFindBy(xpath = "//me.next.uikit.NextChip[@text='Empréstimo pessoal']/preceding-sibling::*//*[@text='SIMULAR']")
    @iOSXCUITFindBy(xpath = "//*[@value='Empréstimo Pessoal']/parent::*//*[@value='SIMULAR']")
    private MobileElement botaoSimularEmprestimoPessoal;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_details")
    @iOSXCUITFindBy(accessibility = "ic_arrow_down_green")
    private MobileElement botaoVerDetalhesLimite;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_expand")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Limite Usado\"])[1]")
    private MobileElement botaoExpandirEmprestimos;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "Empréstimo Pessoal")
    private MobileElement botaoExpandirEmprestimosPessoais;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ok\"]")
    private MobileElement botaoOkAviso;

    @iOSXCUITFindBy(xpath = "//*[@name='MEUS CONTRATOS']")
    @AndroidFindBy(xpath = "//*[@text='MEUS CONTRATOS']")
    private MobileElement abaMeusContratos;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Grana de Emergência']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_flex_overdraft_my_contracts_limit_adapt")
    private MobileElement botaoGranaEmergenciaCardLimiteFlex;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Empréstimo']")
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
     * Validar a exibição da Tela 'Crédito'
     *
     * @return
     */
    @Step("validar a exibição da Tela 'Crédito'")
    public CreditoTela validarExibicaoTelaCredito() throws Exception {
        OperadorEvidencia.logarPasso("Aguardando ocultação da ampulheta ...");
        // solução devido a lentidão do carregamento desta tela para evitar o "timeout" do aguardarCarregamentoElemento()
        aguardarOcultacaoElemento(ampulheta);
        OperadorEvidencia.logarPasso("Validando a tela 'Crédito' ...");
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloCredito),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar a exibição da Tela 'Crédito'");
        salvarEvidencia("Validou a exibição da Tela 'Crédito'");
        return this;
    }

    /**
     * Validar presença tela 'Crédito'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença tela 'Crédito'")
    public CreditoTela validarPresencaTelaCredito() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CREDITO), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Crédito' não está presente na tela!");
        salvarEvidencia("Validada presença da tela Crédito");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public CreditoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * tocar no botão 'Pedir Mais Limite'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Pedir Mais Limite'")
    public CreditoTela tocarBotaoPedirMaisLimite() throws NextException {
        salvarEvidencia("Tocar no botão 'Pedir Mais Limite'");
        tocarElemento(botaoPedirMaisLimite, "Erro ao tocar no botão 'Pedir Mais Limite'");
        return this;
    }

    /**
     * Tocar botão 'Simular' do Crédito Parcelado
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Simular' do Empréstimo Pessoal")
    public CreditoTela tocarBotaoSimularCreditoParcelado() throws Exception {
        salvarEvidencia("Tocar botão 'Simular' do Crédito Parcelado");
        tocarElemento(botaoSimularCreditoParcelado, "Não foi possível tocar no botão 'Simular' do Crédito Parcelado");
        return this;
    }

    /**
     * Tocar botão 'Simular' do Empréstimo Pessoal
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Simular' do Empréstimo Pessoal")
    public CreditoTela tocarBotaoSimularEmprestimoPessoal() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSimularEmprestimoPessoal, "Não foi possível tocar no botão 'Simular' do Empréstimo Pessoal");
        salvarEvidencia("Tocar botão 'Simular' do Empréstimo Pessoal");
        tocarElemento(botaoSimularEmprestimoPessoal, "Não foi possível tocar no botão 'Simular' do Empréstimo Pessoal");
        return this;
    }


    /**
     * Tocar botão 'Ver Detalhes'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar botão 'Ver Detalhes'")
    public CreditoTela tocarBotaoVerDetalhes() throws Exception {
        if (android) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerDetalhes, "Erro a rolar até o botão, 'Ver Detalhes'");
            salvarEvidencia("Tocar botao 'Ver Detalhes'");
            tocarElemento(botaoVerDetalhes, "Erro ao tocar no botão 'Ver Detalhes'");
        }
        return this;
    }

    /**
     * Tocar botão 'Ver detalhes (Limite)'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Ver detalhes (Limite)'")
    public CreditoTela tocarBotaoVerDetalhesLimite() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerDetalhesLimite, "Não foi possível encontrar o botão 'Ver detalhes (Limite)'");
        salvarEvidencia("Tocar botão 'Ver detalhes (Limite)'");
        tocarElemento(botaoVerDetalhesLimite, "Não foi possível tocar no botão 'Ver detalhes (Limite)'");
        return this;
    }


    /**
     * Tocar botão 'Expandir' Limite pessoal Utilizado
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Expandir' Limite pessoal Utilizado")
    public CreditoTela tocarBotaoExpandirLimitePessoalUtilizado() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoExpandirEmprestimos, "Não foi possível encontrar o botão 'Expandir' Limite pessoal Utilizado");
        salvarEvidencia("Tocar botão 'Expandir' Limite pessoal Utilizado");
        tocarElemento(botaoExpandirEmprestimos, "Não foi possível tocar no botão 'Expandir' Limite pessoal Utilizado");
        return this;
    }


    /**
     * Tocar botão 'ok' aviso crédito já utilizado
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'ok' ")
    public CreditoTela tocarBotaoOk() throws Exception {
        if (ios && verificarPresencaElemento(botaoOkAviso)) {
            salvarEvidencia("Tocar botão 'Ok'");
            tocarElemento(botaoOkAviso, "Não foi possível tocar no botão 'Ok'");
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
        tocarElemento(botaoExpandirEmprestimosPessoais, "Não foi possível tocar Seta Emprestimo Pessoal");
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
        tocarElemento(botaoPagar, "Não foi possível tocar no botao 'Pagar'");
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
        tocarElemento(abaMeusContratos, "Não foi possível tocar aba 'MEUS CONTRATOS'");
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
        salvarEvidencia("Validada presença da opcao de Emprestimo");
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
        salvarEvidencia("Validada presença da opcao de Grana de Emergencia");
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
            tocarElemento(botaoConfigurarUsoLimite, "Não foi possível tocar botao 'configurar Uso do Limite'");
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
        tocarElemento(botaoLimites, "Não foi possível tocar botao 'Limites'");
        aguardarPaginaConterQualquerTexto("LIMITE FLEX");
        return this;
    }

    /**
     * Tocar no ícone 'Menu'
     *
     * @return CreditoTela
     * @throws Exception
     */
    @Step("Tocar botao 'Menu'")
    public CreditoTela tocarBotaoMenu() throws Exception {
        aguardarCarregamentoElemento(botaoMenu);
        salvarEvidencia("Clicar no botao 'Menu'");
        tocarElemento(botaoMenu, "Não foi possível clicar no botão Menu");
        return this;
    }

}
