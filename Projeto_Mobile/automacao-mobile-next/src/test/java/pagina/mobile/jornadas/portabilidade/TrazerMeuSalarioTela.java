package pagina.mobile.jornadas.portabilidade;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.portabilidade.PortabilidadeDados;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.text.Normalizer;
import java.util.List;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaStringNumero;

public class TrazerMeuSalarioTela extends PaginaBase {

    public static ThreadLocal<String> agencia = new ThreadLocal<String>();
    public static ThreadLocal<String> conta = new ThreadLocal<String>();
    public static ThreadLocal<String> cpfCnpj = new ThreadLocal<String>();
    public static ThreadLocal<String> nomeEmpregador = new ThreadLocal<String>();
    public static ThreadLocal<String> valorBancoContaSalario = null;

    //Bot�o 'mensagem'
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Em andamento')]")
    private MobileElement mensagem;

    //Bot�o 'Trazer Sal�rio'
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/button_get_salary")
    @iOSXCUITFindBy(xpath = "//*[@name='addNewPortabilityButton']")
    private MobileElement botaoTrazerSalario;

    //Bot�o 'Trazer Sal�rio' quando n�o tem registro portabilidade
    @AndroidFindBy(xpath = "//*[@text='TRAZER SAL�RIO']")
    @iOSXCUITFindBy(accessibility = "TRAZER SAL�RIO")
    private MobileElement botaoTrazerSalarioPrimeiraPort;

    //Bot�o 'Informa��es' icone 'i' no canto superior direito
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system_option")
    @iOSXCUITFindBy(xpath = "//*[@label='Mais informa��es']")
    private MobileElement botaoInfo;

    //radio button cpf
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_cpf")
    @iOSXCUITFindBy(accessibility = "Op��o selecion�vel, CPF, ")
    private MobileElement radioCPF;

    //radio button cnpj
    @AndroidFindBy(xpath = "//*[@text='CNPJ']")
    @iOSXCUITFindBy(accessibility = "Op��o selecion�vel, CNPJ, ")
    private MobileElement radioCNPJ;

    //Bot�o proximo
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_next")
    @iOSXCUITFindBy(accessibility = "PR�XIMO")
    private MobileElement botaoProximo;

    //Bot�o Voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.widget.Button[1])[3]")
    @iOSXCUITFindBy(xpath = "//*[@value='VOLTAR']")
    private MobileElement botaoVoltar;

    //Campo para digitar 'CPF do Empregador'
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_cpf")
    @iOSXCUITFindBy(accessibility = "CPF do Empregador")
    private MobileElement campoCPFEmpregador;

    //Campo para digitar 'CNPJ do Empregador'
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_cnpj")
    @iOSXCUITFindBy(accessibility = "CNPJ do Empregador")
    private MobileElement campoCNPJEmpregador;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*/android.widget.EditText[contains(@text, \"CNPJ ou CPF\")]")
    @AndroidFindBy(xpath = "//*/android.view.ViewGroup[2]/android.view.ViewGroup/me.next.uikit.NextInputField/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,'CNPJ') or contains(@name,'CPF')]")
    private MobileElement campoCnpjCpfEmpregador;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nfb_advance")
    @iOSXCUITFindBy(xpath = "//*[@name='AVAN�AR' and @visible='true']")
    private MobileElement botaoAvancarComTecladoAberto;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[2]")
    @AndroidFindBy(xpath = "//*[@text='AVAN�AR']")
    @AndroidFindBy(id= "br.com.bradesco.next.account_portability:id/nbt_advance")
    @iOSXCUITFindBy(xpath = "//*[@value='AVAN�AR']")
    @iOSXCUITFindBy(xpath = "//*[@value='PR�XIMO']")
    private MobileElement botaoAvancar;

    //Campo para digitar 'Nome Empregador'
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_source_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeTextField\" and name = \"Nome do Empregador\" and visible = true")
    private MobileElement campoNomeEmpregador;

    //bot�o confirmar
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_confirm")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    //Bot�o 'Continuar' da tela termo
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/bt_accept")
    @iOSXCUITFindBy(accessibility = "Avan�ar")
    private MobileElement botaoContinuar;

    //Bot�o 'OK Entendi'
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(accessibility = "OK, ENTENDI.")
    private MobileElement botaoOKEntendi;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_see_details")
    @iOSXCUITFindBy(xpath = "//*[@name='buttonDetails' and @visible='true']")
    private MobileElement botaoVerDetalhes;

    //Bot�o popup 'OK'
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(accessibility = "Ok")
    private MobileElement botaoOkPopup;

    //Bot�o 'Visualizar Comprovante tela Contestar PortabilidadeDados'
    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_visualize")
    @iOSXCUITFindBy(accessibility = "VISUALIZAR")
    private MobileElement botaoVisualizarComprovanteContestar;

    //Bot�o 'Cancelar' para cancelar pedidos de portabilidade em andamento
    @AndroidFindBy(xpath = "//*[contains(@text, 'CANCELAR')]")
    @iOSXCUITFindBy(xpath = "//*[@name='btnCancel']")
    private MobileElement botaoCancelar;

    //Bot�o 'Ver Detalhes'
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'VER ')]")
    private MobileElement botaoDetalhes;

    //Bot�o 'Avancar na Contestacao'
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(xpath = "//*[@name='AVAN�AR']")
    private MobileElement botaoAvancarContestacao;

    //Bot�o 'Cancelar na Contestacao'
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_secondary_button")
    @iOSXCUITFindBy(xpath = "//*[@name='CANCELAR']")
    private MobileElement botaoCancelarContestacao;

    @AndroidFindBy(xpath = "//*[contains(@text, \"inv�lido\")]")
    private MobileElement mensagemInvalido;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_info")
    @iOSXCUITFindBy(accessibility = "Informa��es")
    private MobileElement botaoInformacao;

    //Bot�o 'Ver Detalhes' PEDIDO EM ANDAMENTO
    @AndroidFindBy(xpath = "//*[contains(@text, 'VER DETALHES')]")
    @iOSXCUITFindBy(xpath = "//*[@visible='true' and @label='VER DETALHES']")
    private MobileElement botaoDetalhesPedidoAndamento;

    //Label PEDIDOS CONCLUIDOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PEDIDO CONCLU�DO\"]")
    private MobileElement labelPedidosConcluidos;

    //Registro PEDIDOS DE PORTABILIDADE
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_description_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@visible='true' and contains(@label, 'Cnpj')]")
    private MobileElement registroPedidoPortabilidade;

    //Label CONTESTAR
    @iOSXCUITFindBy(xpath = "br.com.bradesco.next:id/tv_text")
    private MobileElement labelContestar;

    //Bot�o Fechar tela
    @AndroidFindBy(accessibility = "Fechar, Bot�o")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_cnpj")
    @iOSXCUITFindBy(className = "XCUIElementTypeCell")
    private MobileElement cnpjCardPedidosAndamento;

    //label CPF/CNPJ em tela Comprovante
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Linha: 1, Coluna:  2, ')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@value='CPF/CNPJ']//preceding-sibling::XCUIElementTypeOther")
    private MobileElement labelCnpjComprovante;

    //label Nome Empregador em tela Comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_company_name_value")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeStaticText\" and name contains \"Nome\"")
    private MobileElement labelNomeComprovante;

    //label Banco em tela Comprovante
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Linha: 3, Coluna:  2, ')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@value='Banco']//preceding-sibling::XCUIElementTypeOther")
    private MobileElement labelBancoComprovante;

    //botao Fechar na tela Comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//*[@name='DETALHES' or @name='TRAZER MEU SAL�RIO']/XCUIElementTypeButton")
    private MobileElement botaoFecharComprovante;

    //botao Proximo na tela TRAZER MEU SALARIO depois de selecionar banco
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_confirm")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeButton\" and name = \"PR�XIMO\" and visible = true and enabled = true")
    private MobileElement tocarBotaoSeguir;

    //combobox Banco Conta Salario
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/icon_bank_container")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@label,'Banco da conta sal�rio')]")
    private MobileElement comboboxBancoContaSalario;

    //combobox Banco Conta Salario CPF/CNPJ
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/cl_bank_container")
    @iOSXCUITFindBy(accessibility = "icon expansible cell")
    @iOSXCUITFindBy(accessibility = "Expandir banco")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"accountSelectView\"]")
    private MobileElement comboboxBancoContaSalarioCpfCNPJ;

    //Campo Filtro Pesquisa Banco Conta Salario
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/et_search")
    @iOSXCUITFindBy(accessibility = "Buscar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Buscar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Buscar\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Buscar\"]")
    private MobileElement campoFiltroPesquisaBanco;

    //Campo Banco Conta Salario
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/ctv_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypePickerWheel\" ")
    private MobileElement bancoContaSalarioPesquisado;

    //botao Confirmar Banco Conta Sal�rio
    @AndroidFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoCheck;

    //Checkbox "Confirmo Solicita��o"
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[@value='Selecionar']")
    private MobileElement checkboxConfirmoSolicitacao;

    //Checkbox "Texto Modal 'Voc� J� Cadastrou CPF/CNPJ'"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_description")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Voc� j� cadastrou esse CPF/CNPJ pra trazer')]")
    private MobileElement textoModalVoceJaCadastrouCpfCnpj;

    //Label tela "TRAZER MEU SALARIO"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeNavigationBar\" and name = \"TRAZER MEU SAL�RIO\"")
    private MobileElement tituloTelaTrazerMeuSalario;

    //Titulo Termos e Condi��es
    @AndroidFindBy(accessibility = "TERMOS E CONDI��ES")
    @iOSXCUITFindBy(accessibility = "TERMOS E CONDI��ES")
    private MobileElement tituloTermosCondicoes;

    //Texto do menu Informa��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/activity_tac_term")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeStaticText\" and name contains \"Solicita��o\"")
    private MobileElement textoTermoCondicoes;

    //Texto topo Tela Tutorial
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_cnpj")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeOther\" and name contains \"Traz seu sal�rio\"")
    private MobileElement textoTopoPrimeiroAcesso;

    //Texto Rodap� Tela Tutorial - N�o foi utilizado
    @AndroidFindBy(xpath = "//me.next.uikit.NextLabel[contains(@text,\"O pedido\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeStaticText\" and name contains \"O pedido\"")
    private MobileElement textoRodapePrimeiroAcesso;

    //Texto Nome Empregador Comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_company_name_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = \"Nome do Empregador\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement NomeEmpregadorComprovante;

    //Texto da tela de Cancelamento Portabilidade
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_title")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Tem certeza que quer cancelar a portabilidade?')]")
    private MobileElement textoConfirmacaoCancelamento;

    //Texto CNPJ Empregador Comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_portability_cnpj_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = \"CPF/CNPJ\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement ValidarDadosComprovanteCNPJ;

    //Label Aviso CNPJ
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_error")
    private MobileElement labelAvisoCnpjInvalido;

    //Bot�o Contestar
    @AndroidFindBy(xpath = "//*[@text=\"CONTESTAR\"]")
    @iOSXCUITFindBy(xpath = "//*[@label='CONTESTAR' and @visible='true']")
    private MobileElement botaoContestar;

    //Bot�o voltar tela de visualizar comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//*[@name='DETALHES']/XCUIElementTypeButton[1]")
    private MobileElement botaoVoltarVisualizarComprovante;

    //Bot�o voltar para Menu Principal
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[1]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    private MobileElement botaoVoltarParaMenu;

    //Texto no tutorial do primeiro acesso ao app
    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextView29")
    private MobileElement textoPrimeiroAcessoApp;

    //validar texto da contesta��o da portabilidade
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"contesta��o\") and contains(@name, \"resposta\")]")
    private MobileElement labelContestacao;

    //Icone Next na tela de comprovantes '&'
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_portability")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Contesta��o')]//preceding-sibling::XCUIElementTypeImage")
    private MobileElement iconeComprovante;

    public TrazerMeuSalarioTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Clicar bot�o Voltar Menu Principal
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Voltar Menu Principal\"")
    public TrazerMeuSalarioTela clicarBotaoVoltarMenuPrincipal() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarParaMenu);
        salvarEvidencia("Clicar no bot�o 'bot�o Voltar menu principal'");
        tocarElemento(botaoVoltarParaMenu, "N�o foi poss�vel clicar no bot�o Voltar menu principal");
        return this;
    }

    /**
     * Clicar no bot�o 'Proximo'
     *
     * @throws Exception
     */
    @Step("Clicar no bot�o \"Proximo\"")
    public TrazerMeuSalarioTela tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Clicar no bot�o 'Proximo'");
        tocarElemento(botaoConfirmar, "N�o foi poss�vel clicar no bot�o 'Proximo'");
        return this;
    }

    /**
     * Clicar bot�o 'Cancelar'
     *
     * @return
     * @throws Exception
     */

    @Step("Clicar bot�o \"Cancelar\"")
    public TrazerMeuSalarioTela tocarBotaoCancelar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'cancelar'");
        aguardarCarregamentoElemento(botaoCancelar);
        tocarElemento(botaoCancelar, "N�o foi poss�vel clicar no bot�o cancelar");
        return this;
    }


    /**
     * Clicar bot�o 'Trazer Sal�rio'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Trazer S�lario\"")
    public TrazerMeuSalarioTela tocarBotaoTrazerSalario() throws Exception {
        if (aguardarCarregamentoElemento(botaoTrazerSalario)) {
            tocarElemento(botaoTrazerSalario, "N�o foi poss�vel clicar no bot�o Trazer S�lario");
            salvarEvidencia("Clicar no bot�o 'Trazer Sal�rio'");
        } else {
            rolaTelaBaixo();
            if (aguardarCarregamentoElemento(botaoTrazerSalarioPrimeiraPort)) {
                tocarElemento(botaoTrazerSalarioPrimeiraPort, "N�o foi poss�vel clicar no bot�o Trazer S�lario");
                salvarEvidencia("Clicar no bot�o 'Trazer Sal�rio'");
            }
        }
        return this;
    }

    /**
     * Validar mensagem
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mesnsagem de erro")
    public TrazerMeuSalarioTela validarMensagemPortabiliadeEmAnalise() throws Exception {
        aguardarCarregamentoElemento(mensagem);
        compararElementoTexto(mensagem, PortabilidadeDados.MENSAGEM_POPUP_CSAL_PORTABILIDADE, MetodoComparacao.CONTEM);
        salvarEvidencia("Validado mensagem cancelamento da solicita��o de portabilidade");
        return this;
    }

    /**
     * Clicar bot�o 'Detalhes' de Pedido em Andamento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Detalhes\" de Pedido em Andamento")
    public TrazerMeuSalarioTela tocarBotaoDetalhesPedidoAndamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDetalhesPedidoAndamento, "Nao foi possivel encontrar o elemento");
        tocarElemento(botaoDetalhesPedidoAndamento, "N�o foi poss�vel clicar no bot�o Detalhes");
        salvarEvidencia("Tocar bot�o \"Ver Detalhes\"");
        return this;
    }

    /**
     * Clica em um registro da lista de portabilidade para poder visualizar os daados e as opcoes 'Ver Detalhes' e/ou 'Cancelar'
     *
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Clicar registro de Portabilidade em Andamento")
    public TrazerMeuSalarioTela tocarRegistroPortabilidade(String cnpj) throws Exception {
        aguardarCarregamentoElemento(registroPedidoPortabilidade);
        salvarEvidencia("Clicar na portabilidade");
        List<MobileElement> lista = android ?
                retornarLista(By.id("br.com.bradesco.next:id/nl_description_text"),"Nao foi possivel listar as portabilidades"):
                retornarLista(new By.ByXPath("//XCUIElementTypeButton[contains(@name, 'Cnpj')]"),"Nao foi possivel listar as portabilidades");
        for (MobileElement mobileElement : lista) {
            if (mobileElement.getText().contains(cnpj) || mobileElement.getAttribute("name").contains(cnpj)) {
                tocarElemento(mobileElement, "Nao foi possivel clicar na portabilidade");
                break;
            }
        }

        Thread.sleep(1000);

        return this;
    }

    /**
     * Clicar bot�o 'Ver Detalhes' tela de contestar portabilidade
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Ver Detalhes\"")
    public TrazerMeuSalarioTela tocarBotaoVerDetalhes() throws Exception {
        aguardarCarregamentoElemento(botaoDetalhes);
        salvarEvidencia("Clicar no bot�o 'Ver Detalhes'");
        tocarElemento(botaoDetalhes, "N�o foi poss�vel clicar no bot�o Ver Detalhes");
        return this;
    }

    @Step("Clicar bot�o \"Ver Detalhes Portabilidade Concluida\"")
    public TrazerMeuSalarioTela tocarBotaoVerDetalhesPortabilidadeConcluida() throws Exception {
        aguardarCarregamentoElemento(botaoVerDetalhes);
        salvarEvidencia("Clicar no bot�o 'Ver Detalhes'");
        tocarElemento(botaoVerDetalhes, "N�o foi poss�vel clicar no bot�o Ver Detalhes");
        return this;
    }

    /**
     * Clicar bot�o Informa��o 'i' no canto superior
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Informa��o 'i'\" no canto superior")
    public TrazerMeuSalarioTela tocarBotaoInformacao() throws Exception {
        aguardarCarregamentoElemento(botaoInfo);
        tocarElemento(botaoInfo, "N�o foi poss�vel clicar no bot�o Informa��o");
        salvarEvidencia("Clicar no bot�o Informa��o 'i'");
        return this;
    }

    /**
     * Clicar bot�o 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Fechar\"")
    public TrazerMeuSalarioTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "N�o foi poss�vel clicar no bot�o Fechar");
        aguardarCarregamentoElemento(tituloTelaTrazerMeuSalario);
        salvarEvidencia("Clicar no bot�o 'Fechar'");
        return this;
    }

    /**
     * Validar Icone na tela de Comprovante
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"Validar Icone na Tela \" do comprovante")
    public TrazerMeuSalarioTela validarIconeComprovante() throws Exception {
        aguardarCarregamentoElemento(iconeComprovante);
        salvarEvidencia("validar Icone que esta na tela de comprovante.");
        validarCondicaoBooleana(verificarPresencaElemento(iconeComprovante), MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar Icone do comprovante");
        return this;
    }


    /**
     * Clicar bot�o 'voltar'  - em visualizar Comprovante - portabilidade
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar Visualizacao\"")
    public TrazerMeuSalarioTela tocarBotaoVoltarVisualizarComprovante() throws Exception {
        salvarEvidencia("Bot�o Voltar em Visualizar Comprovante em Tela'");
        tocarElemento(botaoVoltarVisualizarComprovante, "N�o foi possivel clicar no bot�o voltar < ");
        return this;
    }

    /**
     * Clicar no bot�o 'Salvar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Salvar\"")
    public TrazerMeuSalarioTela tocarBotaoOk() throws Exception {

        if (getDriver() instanceof AndroidDriver) {
            aguardarCarregamentoElemento(labelContestar);
            salvarEvidencia("Clicar no bot�o 'Ok'");
            tocarElemento(botaoOkPopup, "N�o foi poss�vel clicar no bot�o 'Ok'");
        } else {
            if (aguardarCarregamentoElemento(labelContestar)) {
                tocarCoordenadaProporcional(0, 138);
            } else {
                tocarCoordenadaProporcional(0, 138);
            }
        }
        salvarEvidencia("Clicar no bot�o 'Contestar'");
        return this;
    }

    /**
     * Deslizar para visualizar os 'pedidos em andamento'
     *
     * @return
     * @throws Exception
     */
    @Step("Deslizar para visualizar os pedidos em andamento")
    public TrazerMeuSalarioTela swipePedidosAndamentos() throws Exception {
        aguardarCarregamentoElemento(botaoTrazerSalario);
        salvarEvidencia("Swipe nos pedidos em andamento");
        if (getDriver() instanceof IOSDriver) {
            deslizar(By.className("XCUIElementTypeCell"), Direcao.DIREITA, 10, 90);
        } else {
            deslizar(By.id("br.com.bradesco.next:id/ll_details"), Direcao.DIREITA, 10, 90);
        }
        return this;
    }

    /**
     * Validar CNPJ ao efetuar swipe na tela pedidos em andamento - Apenas IOS
     *
     * @return
     * @throws Exception
     */
    @Step("Validar CNPJ ao fazer swipe de pedidos em andamento")
    public TrazerMeuSalarioTela validarCNPJPedidosAndamento() throws Exception {
        if (getDriver() instanceof IOSDriver) {
            aguardarCarregamentoElemento(cnpjCardPedidosAndamento);
        }
        salvarEvidencia("Validar CNPJ ao efetuar swipe nos 'Pedidos em Andamentos'");
        return this;
    }

    /**
     * Validar CNPJ do comprovante � o mesmo da solicita��o cancelada
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"CPF/CNPJ\" do comprovante")
    public TrazerMeuSalarioTela validarDadosComprovante() throws Exception {
        aguardarCarregamentoElemento(labelCnpjComprovante);
        String comprovantes;

        if (getDriver() instanceof IOSDriver) {
            comprovantes = normalizaStringNumero(retornarTexto(new By.ByXPath("//XCUIElementTypeStaticText[@name = \"CPF/CNPJ\"]/following-sibling::XCUIElementTypeStaticText"), "N�o foi possivel validar o comprovante"));
        } else {
            comprovantes = normalizaStringNumero(retornarTexto(labelCnpjComprovante, "Erro ao validar comprovante"));
        }
        validarCondicaoBooleana(comprovantes.equals(normalizaString(cpfCnpj.get())), MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar CNPJ do comprovante");
        salvarEvidencia("Validar CPF/CNPJ no comprovante");
        return this;
    }

    /**
     * Validar CNPJ do comprovante � o mesmo da solicita��o cancelada
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"CPF/CNPJ\" do comprovante")
    public TrazerMeuSalarioTela validarDadosComprovante(Enum vCpfCnpj) throws Exception {
        aguardarCarregamentoElemento(labelCnpjComprovante);
        compararElementoTexto(labelCnpjComprovante, vCpfCnpj, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar CPF/CNPJ no comprovante");
        return this;
    }

    @Step("Validar \"CPF/CNPJ\" do comprovante")
    public TrazerMeuSalarioTela validarDadosComprovante(String vCpfCnpj) throws Exception {
        aguardarCarregamentoElemento(labelCnpjComprovante);
        compararElementoTexto(labelCnpjComprovante, vCpfCnpj, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar CPF/CNPJ no comprovante");
        return this;
    }

    /**
     * Validar Consist�ncia Banco Conta Sal�rio no Comprovante
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"Nome do Empregador\" do comprovante")
    public TrazerMeuSalarioTela validarBancoComprovante(Enum banco) throws Exception {
        aguardarCarregamentoElemento(labelBancoComprovante);
        salvarEvidencia("validar Banco no comprovante");
        compararElementoTexto(labelBancoComprovante, banco, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * Tocar bot�o 'Fechar' na tela comprovante
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Fechar\" na tela 'Comprovante'")
    public TrazerMeuSalarioTela tocarBotaoFecharComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoFecharComprovante);
        tocarElemento(botaoFecharComprovante, "N�o foi poss�vel clicar no bot�o fechar comprovante");
        aguardarCarregamentoElemento(tituloTelaTrazerMeuSalario);
        salvarEvidencia("Fechar Comprovante");
        return this;
    }

    /**
     * Selecionar radio-button 'CPF' na tela TRAZER MEU SAL�RIO
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar radio-button \"CPF\" na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela selecionarCPF() throws Exception {
        aguardarCarregamentoElemento(radioCPF);
        tocarElemento(radioCPF, "N�o foi poss�vel selecionar a op��o CPF");
        salvarEvidencia("Selecionar radio-button CPF");
        return this;
    }

    /**
     * Selecionar radio-button 'CNPJ' na tela TRAZER MEU SAL�RIO
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar radio-button \"CNPJ\" na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela selecionarCNPJ() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(radioCNPJ);
        tocarElemento(radioCNPJ, "N�o foi poss�vel selecionar a op��o CNPJ");
        salvarEvidencia("Selecionar radio-button CNPJ");
        return this;
    }

    /**
     * Tocar bot�o Pr�ximo
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Pr�ximo\" na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela tocarBotaoProximo() throws Exception {
        salvarEvidencia("Tocar Bot�o Proximo ");
        tocarElemento(botaoProximo, "N�o foi poss�vel tocar no bot�o Pr�ximo");
        return this;
    }

    /**
     * Clicar bot�o Voltar depois de selecionar banco
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\" na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar Bot�o Voltar ");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o Voltar");
        return this;
    }

    /**
     * Clicar bot�o Pr�ximo depois de selecionar banco
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Pr�ximo\" na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela tocarBotaoSeguir() throws Exception {
        aguardarCarregamentoElemento(campoNomeEmpregador);
        nomeEmpregador.set(campoNomeEmpregador.getText());
        salvarEvidencia("Tocar Bot�o Proximo ");
        tocarElemento(tocarBotaoSeguir, "N�o foi poss�vel tocar no bot�o Pr�ximo");
        return this;
    }

    /**
     * Preencher campo CPF Empregador
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo \"CNPJ do Empregador\" na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela preencherCampoCNPJ(String cnpjEmpregador) throws Exception {
        tocarElemento(campoCNPJEmpregador, "N�o foi poss�vel selecionar campo CNPJ do Empregador");
        escreverTexto(campoCNPJEmpregador, cnpjEmpregador, "N�o foi poss�vel preencher campo CNPJ do Empregador");
        cpfCnpj.set(cnpjEmpregador);
        salvarEvidencia("Preencher CNPJ Empregador");
        return this;
    }

    /**
     * Preencher campo CNPJ ou CPF do Empregador
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo 'CNPJ ou CPF do Empregador' na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela preencherCnpjCpfEmpregador(String cnpjCpfEmpregador) throws Exception {
        if(ios){
            apagarCampoTexto(campoCnpjCpfEmpregador, "Campo CNPJ ou CPF do empregador n�o encontrado");
            escreverTexto(campoCnpjCpfEmpregador, cnpjCpfEmpregador, "N�o foi poss�vel preencher campo CNPJ ou CPF do Empregador");
        }else{
            //TODO Refatorar m�todo futuramente
            MobileElement elementoMobile = retornaElemento(campoCnpjCpfEmpregador);
            elementoMobile.clear();
            elementoMobile.sendKeys(cnpjCpfEmpregador);
            //teclarBackSpaceAteApagar(campoCnpjCpfEmpregador,15);
            //digitarTexto(campoCnpjCpfEmpregador, cnpjCpfEmpregador);
        }
        //tocarElemento(campoCnpjCpfEmpregador, "Nao foi possivel tocar no campo CNPJ ou CPF do Empregador");
        cpfCnpj.set(cnpjCpfEmpregador);
        salvarEvidencia("Informado um CNPJ ou CPF inv�lido para o empregador");
        return this;
    }

    /**
     * Tocar bot�o AVAN�AR quando o teclado n�merico estiver aberto
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'AVAN�AR' na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela tocarBotaoAvancarComTecladoAberto() throws Exception {
        salvarEvidencia("Tocar no bot�o 'AVAN�AR'");
        tocarElemento(botaoAvancarComTecladoAberto, "N�o foi poss�vel tocar no bot�o 'AVAN�AR'!");
        return this;
    }

    /**
     * Tocar bot�o AVAN�AR
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'AVAN�AR' na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela tocarBotaoAvancar() throws Exception {
        esconderTeclado();
        salvarEvidencia("Tocar no bot�o 'AVAN�AR'");
        tocarElemento(botaoAvancar, "N�o foi poss�vel tocar no bot�o 'AVAN�AR'!");
        return this;
    }

    /**
     * Selecionar Banco Conta Sal�rio
     *
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Selecionar \"Banco Conta Sal�rio\"")
    public TrazerMeuSalarioTela selecionarBancoContaSalario(String banco) throws Exception {
        By seletorBanco = android ?
                new By.ByXPath(String.format("//*[@resource-id='br.com.bradesco.next.account_portability:id/ctv_name' and contains(@text, '%s')]", banco)):
                new By.ByXPath(String.format("//*[contains(@name, '%s')]", banco));
        tocarElemento(seletorBanco, String.format("N�o foi poss�vel selecionar banco conta-sal�rio: %s", banco));
        salvarEvidencia(String.format("Tocar no banco desejado: %s", banco));
        return this;
    }

    /**
     * armazena o valor da conta salario na variavel TheadLocal
     */
    public static void setValorBancoContaSalario(String bancoContaSalario) {
        if (valorBancoContaSalario == null) {
            valorBancoContaSalario = new ThreadLocal<>();
        }
        valorBancoContaSalario.set(bancoContaSalario);
    }

    /**
     * Tocar Combobox Conta-Sal�rio
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar combobox \"Banco Conta Sal�rio\" na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela tocarComboboxContaSalario() throws Exception {
        aguardarCarregamentoElemento(comboboxBancoContaSalario);
        tocarElemento(comboboxBancoContaSalario, "N�o foi poss�vel selecionar Combobox Banco Conta Sal�rio");
        salvarEvidencia("Selecionar 'Banco Conta Sal�rio'");
        return this;
    }

    /**
     * Tocar Combobox Conta-Sal�rio quando selecionar por CPF
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar combobox \"Banco Conta Sal�rio\" na tela 'TRAZER MEU SAL�RIO'")
    public TrazerMeuSalarioTela tocarComboboxContaSalarioCpfCNPJ() throws Exception {
        aguardarCarregamentoElemento(comboboxBancoContaSalarioCpfCNPJ);
        tocarElemento(comboboxBancoContaSalarioCpfCNPJ, "N�o foi poss�vel selecionar Combobox Banco Conta Sal�rio");
        return this;
    }


    /**
     * Preencher filtro com Banco Conta-Sal�rio
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher filtro de pesquisa com Banco Conta-Sal�rio \"Banco Conta Sal�rio\"")
    public TrazerMeuSalarioTela preenchercampoPesquisa(String bancoFavorecido) throws Exception {
        if (android) {
            teclarBackSpaceAteApagar(campoFiltroPesquisaBanco,15);
            digitarTexto(campoFiltroPesquisaBanco,bancoFavorecido);
        } else {
            campoFiltroPesquisaBanco.setValue(bancoFavorecido);
            setValorBancoContaSalario(bancoFavorecido);
        }
        salvarEvidencia("Preencher a barra de buscar com o c�digo do banco desejado");
        return this;
    }

    /**
     * Tocar bot�o confirmar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"check(^)\"")
    public TrazerMeuSalarioTela tocarbotaoCheck() throws Exception {
        tocarElemento(botaoCheck, "N�o foi poss�vel selecionar Combobox Banco Conta Sal�rio");
        salvarEvidencia("Tocar no bot�o check(^)");
        return this;
    }

    /**
     * Tocar checkbox "Confirmar Solicita��o"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar checkbox \"Confirmar Solicita��o\"")
    public TrazerMeuSalarioTela tocarCheboxConfirmoSolicitacao() throws Exception {
        aguardarCarregamentoElemento(tituloTermosCondicoes);
        rolaTelaBaixo();
        salvarEvidencia("Tocar no checkbox \"Confirmo a solicita��o\"");
        tocarElemento(checkboxConfirmoSolicitacao, "N�o foi poss�vel clicar no checkbox \"Confirmo a solicita��o\"");
        return this;
    }

    /**
     * Tocar bot�o continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public TrazerMeuSalarioTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar no bot�o \"Continuar\"");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar o bot�o \"Continuar\"");
        aguardarOcultacaoElemento(botaoContinuar);
        return this;
    }

    /**
     * Tocar bot�o "OK, Entendi"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"OK Entendi\"")
    public TrazerMeuSalarioTela tocarBotaoOKEntendi() throws Exception {
        aguardarCarregamentoElemento(botaoOKEntendi);
        salvarEvidencia("Tocar no bot�o OK,ENTENDI");
        tocarElemento(botaoOKEntendi, "N�o foi poss�vel tocar o bot�o \"OK, Entendi\"");
        return this;
    }

    /**
     * Tocar bot�o "OK, Popup"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"OK \"")
    public TrazerMeuSalarioTela tocarBotaoOK() throws Exception {
        aguardarCarregamentoElemento(botaoOkPopup);
        tocarElemento(botaoOkPopup, "N�o foi poss�vel tocar o bot�o \"OK \"");
        salvarEvidencia("Tocar no bot�o OK ");
        return this;
    }

    /**
     * Validar Mensagem "Frase Voc� j� cadastrou esse CPF/CNPJ pra trazer seu sal�rio pro next."
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem \"Frase Voc? j? cadastrou esse CPF/CNPJ pra trazer seu sal?rio pro next.\"")
    public TrazerMeuSalarioTela validarMensagemVoceJaCadastrouCpfCnpj() throws Exception {
        aguardarCarregamentoElemento(textoModalVoceJaCadastrouCpfCnpj);
        if (getDriver() instanceof IOSDriver) {
            compararElementoTexto(textoModalVoceJaCadastrouCpfCnpj, PortabilidadeDados.VOCE_JA_CADASTROU_CPF, MetodoComparacao.CONTEM);
            salvarEvidencia("Valida��o realizada com sucesso - 'Voce ja cadastrou este CPF/CNPJ para trazer seu Salario pro next.'");
        } else {
            compararElementoTexto(textoModalVoceJaCadastrouCpfCnpj, PortabilidadeDados.VOCE_JA_CADASTROU_CPF, MetodoComparacao.CONTEM);
            salvarEvidencia("Valida��o realizada com sucesso - 'Voce ja cadastrou este CPF/CNPJ para trazer seu Salario pro next.'");
        }
        return this;
    }

    /**
     * Validar Tela "Trazer Meu Sal�rio"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar exibi��o tela \"Trazer Meu Sal�rio\"")
    public TrazerMeuSalarioTela validarTelaTrazerMeuSalario() throws Exception {
        try {
            aguardarCarregamentoElemento(tituloTelaTrazerMeuSalario);
            if (getDriver() instanceof AndroidDriver) {

                compararElementoTexto(tituloTelaTrazerMeuSalario, PortabilidadeDados.TRAZER_MEU_SALARIO, MetodoComparacao.CONTEM);
            } else {
                Assert.assertTrue(Normalizer.normalize(tituloTelaTrazerMeuSalario.getAttribute("name"), Normalizer.Form.NFD).toUpperCase().replaceAll("[\n .!?,]", "")
                        .contains(Normalizer.normalize("TRAZER MEU SAL�RIO", Normalizer.Form.NFD).toUpperCase().replaceAll("[\n .!?,]", "")));
            }
            return this;
        } catch (AssertionError e) {
            throw new AssertionError("N�o foi poss�vel validar tela 'TRAZER MEU SAL�RIO'");
        }
    }


    /**
     * Validar 'Termo e Condi��es'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar texto \"Termo e Condi��es\"")
    public TrazerMeuSalarioTela validarTermoECondicoes() throws Exception {
        aguardarCarregamentoElemento(textoTermoCondicoes);
        if (ios) {
            validarCondicaoBooleana(verificarPresencaElemento(textoTermoCondicoes), MetodoComparacaoBooleano.VERDADEIRO,
                    "Termo e Condi��es n�o est� vis�vel no iOS.");
        }
        salvarEvidencia("Texto Termo e Condi��es Validado com Sucesso");
        return this;
    }

    /**
     * Validar Tutorial Primeiro Acesso
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tutorial Primeiro Acesso")
    public TrazerMeuSalarioTela validarPrimeiraPortabilidade() throws Exception {
        salvarEvidencia("Tutorial de primeiro acesso a jornada 'Trazer meu salario'.");
        rolaTelaBaixo();
        aguardarCarregamentoElemento(textoRodapePrimeiroAcesso);
        compararElementoTexto(textoRodapePrimeiroAcesso, PortabilidadeDados.TEXTO_PRIMEIRA_PORTABILIDADE, MetodoComparacao.IGUAL);
        return this;
    }

    /**
     * Validar Texto Confirmacao Cancelamento
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto Confirmacao Cancelamento")
    public TrazerMeuSalarioTela validarTextoConfirmacaoCancelamento() throws Exception {
        salvarEvidencia("Tutorial de primeiro acesso a jornada 'Trazer meu salario'.");
        aguardarCarregamentoElemento(textoConfirmacaoCancelamento);
        compararElementoTexto(textoConfirmacaoCancelamento, PortabilidadeDados.TEXTO_CONFIRMACAO_CANCELAMENTO, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * Clicar bot�o 'Contestar'
     *
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Contestar\"")
    public TrazerMeuSalarioTela tocarBotaoContestar() throws Exception {
        aguardarCarregamentoElemento(botaoContestar);salvarEvidencia("Clicar no bot�o 'Contestar'");
        tocarElemento(botaoContestar, "N�o foi poss�vel clicar no bot�o contestar");
        salvarEvidencia("Clicar no bot�o 'Ok - PortabilidadeDados Concluida'");
        return this;
    }

    /**
     * Tocar Bot�o Avan�ar
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Avancar\" no fluxo de Contestar")
    public TrazerMeuSalarioTela tocarBotaoAvancarContestacao() throws Exception {
        aguardarCarregamentoElemento(botaoAvancarContestacao);
        salvarEvidencia("Clicar no bot�o 'Avancar'");
        tocarElemento(botaoAvancarContestacao, "N�o foi poss�vel clicar no bot�o Avancar");
        return this;
    }

    /**
     * Tocar Bot�o Canekar
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Cancelar\" no fluxo de Contestar")
    public TrazerMeuSalarioTela tocarBotaoCancelarContestacao() throws Exception {
        aguardarCarregamentoElemento(botaoCancelarContestacao);
        salvarEvidencia("Clicar no bot�o 'Cancelar'");
        tocarElemento(botaoCancelarContestacao, "N�o foi poss�vel clicar no bot�o Cancelar");
        return this;
    }

    /**
     * Validar mensagem de CPF/CNPJ inv�lido
     *
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Validar mensagem CPF/CNPJ inv�lido")
    public TrazerMeuSalarioTela validarMensagemCpfCnpjInvalido() throws Exception {

        if(android){
            MobileElement elementoMobile = retornaElemento(mensagemInvalido);
            aguardarCarregamentoElemento(elementoMobile);
        } else{
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos("CNPJ inv�lido"), MetodoComparacaoBooleano.VERDADEIRO,
                    "Erro na valida��o da mensagem 'CPF/CNPJ inv�lido'");
        }
        salvarEvidencia("Valida��o da mensagem 'CPF/CNPJ inv�lido'");
        return this;
    }
}
