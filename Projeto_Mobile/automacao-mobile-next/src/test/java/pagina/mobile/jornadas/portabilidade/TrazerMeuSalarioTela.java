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

    //Botão 'mensagem'
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Em andamento')]")
    private MobileElement mensagem;

    //Botão 'Trazer Salário'
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/button_get_salary")
    @iOSXCUITFindBy(xpath = "//*[@name='addNewPortabilityButton']")
    private MobileElement botaoTrazerSalario;

    //Botão 'Trazer Salário' quando não tem registro portabilidade
    @AndroidFindBy(xpath = "//*[@text='TRAZER SALÁRIO']")
    @iOSXCUITFindBy(accessibility = "TRAZER SALÁRIO")
    private MobileElement botaoTrazerSalarioPrimeiraPort;

    //Botão 'Informações' icone 'i' no canto superior direito
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system_option")
    @iOSXCUITFindBy(xpath = "//*[@label='Mais informações']")
    private MobileElement botaoInfo;

    //radio button cpf
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_cpf")
    @iOSXCUITFindBy(accessibility = "Opção selecionável, CPF, ")
    private MobileElement radioCPF;

    //radio button cnpj
    @AndroidFindBy(xpath = "//*[@text='CNPJ']")
    @iOSXCUITFindBy(accessibility = "Opção selecionável, CNPJ, ")
    private MobileElement radioCNPJ;

    //Botão proximo
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_next")
    @iOSXCUITFindBy(accessibility = "PRÓXIMO")
    private MobileElement botaoProximo;

    //Botão Voltar
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
    @iOSXCUITFindBy(xpath = "//*[@name='AVANÇAR' and @visible='true']")
    private MobileElement botaoAvancarComTecladoAberto;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[2]")
    @AndroidFindBy(xpath = "//*[@text='AVANÇAR']")
    @AndroidFindBy(id= "br.com.bradesco.next.account_portability:id/nbt_advance")
    @iOSXCUITFindBy(xpath = "//*[@value='AVANÇAR']")
    @iOSXCUITFindBy(xpath = "//*[@value='PRÓXIMO']")
    private MobileElement botaoAvancar;

    //Campo para digitar 'Nome Empregador'
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_source_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeTextField\" and name = \"Nome do Empregador\" and visible = true")
    private MobileElement campoNomeEmpregador;

    //botão confirmar
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_confirm")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    //Botão 'Continuar' da tela termo
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/bt_accept")
    @iOSXCUITFindBy(accessibility = "Avançar")
    private MobileElement botaoContinuar;

    //Botão 'OK Entendi'
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(accessibility = "OK, ENTENDI.")
    private MobileElement botaoOKEntendi;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_see_details")
    @iOSXCUITFindBy(xpath = "//*[@name='buttonDetails' and @visible='true']")
    private MobileElement botaoVerDetalhes;

    //Botão popup 'OK'
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(accessibility = "Ok")
    private MobileElement botaoOkPopup;

    //Botão 'Visualizar Comprovante tela Contestar PortabilidadeDados'
    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_visualize")
    @iOSXCUITFindBy(accessibility = "VISUALIZAR")
    private MobileElement botaoVisualizarComprovanteContestar;

    //Botão 'Cancelar' para cancelar pedidos de portabilidade em andamento
    @AndroidFindBy(xpath = "//*[contains(@text, 'CANCELAR')]")
    @iOSXCUITFindBy(xpath = "//*[@name='btnCancel']")
    private MobileElement botaoCancelar;

    //Botão 'Ver Detalhes'
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'VER ')]")
    private MobileElement botaoDetalhes;

    //Botão 'Avancar na Contestacao'
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(xpath = "//*[@name='AVANÇAR']")
    private MobileElement botaoAvancarContestacao;

    //Botão 'Cancelar na Contestacao'
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_secondary_button")
    @iOSXCUITFindBy(xpath = "//*[@name='CANCELAR']")
    private MobileElement botaoCancelarContestacao;

    @AndroidFindBy(xpath = "//*[contains(@text, \"inválido\")]")
    private MobileElement mensagemInvalido;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_info")
    @iOSXCUITFindBy(accessibility = "Informações")
    private MobileElement botaoInformacao;

    //Botão 'Ver Detalhes' PEDIDO EM ANDAMENTO
    @AndroidFindBy(xpath = "//*[contains(@text, 'VER DETALHES')]")
    @iOSXCUITFindBy(xpath = "//*[@visible='true' and @label='VER DETALHES']")
    private MobileElement botaoDetalhesPedidoAndamento;

    //Label PEDIDOS CONCLUIDOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PEDIDO CONCLUÍDO\"]")
    private MobileElement labelPedidosConcluidos;

    //Registro PEDIDOS DE PORTABILIDADE
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_description_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[@visible='true' and contains(@label, 'Cnpj')]")
    private MobileElement registroPedidoPortabilidade;

    //Label CONTESTAR
    @iOSXCUITFindBy(xpath = "br.com.bradesco.next:id/tv_text")
    private MobileElement labelContestar;

    //Botão Fechar tela
    @AndroidFindBy(accessibility = "Fechar, Botão")
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
    @iOSXCUITFindBy(xpath = "//*[@name='DETALHES' or @name='TRAZER MEU SALÁRIO']/XCUIElementTypeButton")
    private MobileElement botaoFecharComprovante;

    //botao Proximo na tela TRAZER MEU SALARIO depois de selecionar banco
    @AndroidFindBy(id = "br.com.bradesco.next:id/portability_confirm")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeButton\" and name = \"PRÓXIMO\" and visible = true and enabled = true")
    private MobileElement tocarBotaoSeguir;

    //combobox Banco Conta Salario
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/icon_bank_container")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@label,'Banco da conta salário')]")
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

    //botao Confirmar Banco Conta Salário
    @AndroidFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoCheck;

    //Checkbox "Confirmo Solicitação"
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[@value='Selecionar']")
    private MobileElement checkboxConfirmoSolicitacao;

    //Checkbox "Texto Modal 'Você Já Cadastrou CPF/CNPJ'"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_description")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Você já cadastrou esse CPF/CNPJ pra trazer')]")
    private MobileElement textoModalVoceJaCadastrouCpfCnpj;

    //Label tela "TRAZER MEU SALARIO"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeNavigationBar\" and name = \"TRAZER MEU SALÁRIO\"")
    private MobileElement tituloTelaTrazerMeuSalario;

    //Titulo Termos e Condições
    @AndroidFindBy(accessibility = "TERMOS E CONDIÇÕES")
    @iOSXCUITFindBy(accessibility = "TERMOS E CONDIÇÕES")
    private MobileElement tituloTermosCondicoes;

    //Texto do menu Informação
    @AndroidFindBy(id = "br.com.bradesco.next:id/activity_tac_term")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeStaticText\" and name contains \"Solicitação\"")
    private MobileElement textoTermoCondicoes;

    //Texto topo Tela Tutorial
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_cnpj")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeOther\" and name contains \"Traz seu salário\"")
    private MobileElement textoTopoPrimeiroAcesso;

    //Texto Rodapé Tela Tutorial - Não foi utilizado
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

    //Botão Contestar
    @AndroidFindBy(xpath = "//*[@text=\"CONTESTAR\"]")
    @iOSXCUITFindBy(xpath = "//*[@label='CONTESTAR' and @visible='true']")
    private MobileElement botaoContestar;

    //Botão voltar tela de visualizar comprovante
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//*[@name='DETALHES']/XCUIElementTypeButton[1]")
    private MobileElement botaoVoltarVisualizarComprovante;

    //Botão voltar para Menu Principal
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

    //validar texto da contestação da portabilidade
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"contestação\") and contains(@name, \"resposta\")]")
    private MobileElement labelContestacao;

    //Icone Next na tela de comprovantes '&'
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_portability")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Contestação')]//preceding-sibling::XCUIElementTypeImage")
    private MobileElement iconeComprovante;

    public TrazerMeuSalarioTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Clicar botão Voltar Menu Principal
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Voltar Menu Principal\"")
    public TrazerMeuSalarioTela clicarBotaoVoltarMenuPrincipal() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarParaMenu);
        salvarEvidencia("Clicar no botão 'botão Voltar menu principal'");
        tocarElemento(botaoVoltarParaMenu, "Não foi possível clicar no botão Voltar menu principal");
        return this;
    }

    /**
     * Clicar no botão 'Proximo'
     *
     * @throws Exception
     */
    @Step("Clicar no botão \"Proximo\"")
    public TrazerMeuSalarioTela tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Clicar no botão 'Proximo'");
        tocarElemento(botaoConfirmar, "Não foi possível clicar no botão 'Proximo'");
        return this;
    }

    /**
     * Clicar botão 'Cancelar'
     *
     * @return
     * @throws Exception
     */

    @Step("Clicar botão \"Cancelar\"")
    public TrazerMeuSalarioTela tocarBotaoCancelar() throws Exception {
        salvarEvidencia("Tocar no botão 'cancelar'");
        aguardarCarregamentoElemento(botaoCancelar);
        tocarElemento(botaoCancelar, "Não foi possível clicar no botão cancelar");
        return this;
    }


    /**
     * Clicar botão 'Trazer Salário'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Trazer Sálario\"")
    public TrazerMeuSalarioTela tocarBotaoTrazerSalario() throws Exception {
        if (aguardarCarregamentoElemento(botaoTrazerSalario)) {
            tocarElemento(botaoTrazerSalario, "Não foi possível clicar no botão Trazer Sálario");
            salvarEvidencia("Clicar no botão 'Trazer Salário'");
        } else {
            rolaTelaBaixo();
            if (aguardarCarregamentoElemento(botaoTrazerSalarioPrimeiraPort)) {
                tocarElemento(botaoTrazerSalarioPrimeiraPort, "Não foi possível clicar no botão Trazer Sálario");
                salvarEvidencia("Clicar no botão 'Trazer Salário'");
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
        salvarEvidencia("Validado mensagem cancelamento da solicitação de portabilidade");
        return this;
    }

    /**
     * Clicar botão 'Detalhes' de Pedido em Andamento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Detalhes\" de Pedido em Andamento")
    public TrazerMeuSalarioTela tocarBotaoDetalhesPedidoAndamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDetalhesPedidoAndamento, "Nao foi possivel encontrar o elemento");
        tocarElemento(botaoDetalhesPedidoAndamento, "Não foi possível clicar no botão Detalhes");
        salvarEvidencia("Tocar botão \"Ver Detalhes\"");
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
     * Clicar botão 'Ver Detalhes' tela de contestar portabilidade
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Ver Detalhes\"")
    public TrazerMeuSalarioTela tocarBotaoVerDetalhes() throws Exception {
        aguardarCarregamentoElemento(botaoDetalhes);
        salvarEvidencia("Clicar no botão 'Ver Detalhes'");
        tocarElemento(botaoDetalhes, "Não foi possível clicar no botão Ver Detalhes");
        return this;
    }

    @Step("Clicar botão \"Ver Detalhes Portabilidade Concluida\"")
    public TrazerMeuSalarioTela tocarBotaoVerDetalhesPortabilidadeConcluida() throws Exception {
        aguardarCarregamentoElemento(botaoVerDetalhes);
        salvarEvidencia("Clicar no botão 'Ver Detalhes'");
        tocarElemento(botaoVerDetalhes, "Não foi possível clicar no botão Ver Detalhes");
        return this;
    }

    /**
     * Clicar botão Informação 'i' no canto superior
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Informação 'i'\" no canto superior")
    public TrazerMeuSalarioTela tocarBotaoInformacao() throws Exception {
        aguardarCarregamentoElemento(botaoInfo);
        tocarElemento(botaoInfo, "Não foi possível clicar no botão Informação");
        salvarEvidencia("Clicar no botão Informação 'i'");
        return this;
    }

    /**
     * Clicar botão 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public TrazerMeuSalarioTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "Não foi possível clicar no botão Fechar");
        aguardarCarregamentoElemento(tituloTelaTrazerMeuSalario);
        salvarEvidencia("Clicar no botão 'Fechar'");
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
     * Clicar botão 'voltar'  - em visualizar Comprovante - portabilidade
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar Visualizacao\"")
    public TrazerMeuSalarioTela tocarBotaoVoltarVisualizarComprovante() throws Exception {
        salvarEvidencia("Botão Voltar em Visualizar Comprovante em Tela'");
        tocarElemento(botaoVoltarVisualizarComprovante, "Não foi possivel clicar no botão voltar < ");
        return this;
    }

    /**
     * Clicar no botão 'Salvar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Salvar\"")
    public TrazerMeuSalarioTela tocarBotaoOk() throws Exception {

        if (getDriver() instanceof AndroidDriver) {
            aguardarCarregamentoElemento(labelContestar);
            salvarEvidencia("Clicar no botão 'Ok'");
            tocarElemento(botaoOkPopup, "Não foi possível clicar no botão 'Ok'");
        } else {
            if (aguardarCarregamentoElemento(labelContestar)) {
                tocarCoordenadaProporcional(0, 138);
            } else {
                tocarCoordenadaProporcional(0, 138);
            }
        }
        salvarEvidencia("Clicar no botão 'Contestar'");
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
     * Validar CNPJ do comprovante é o mesmo da solicitação cancelada
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"CPF/CNPJ\" do comprovante")
    public TrazerMeuSalarioTela validarDadosComprovante() throws Exception {
        aguardarCarregamentoElemento(labelCnpjComprovante);
        String comprovantes;

        if (getDriver() instanceof IOSDriver) {
            comprovantes = normalizaStringNumero(retornarTexto(new By.ByXPath("//XCUIElementTypeStaticText[@name = \"CPF/CNPJ\"]/following-sibling::XCUIElementTypeStaticText"), "Não foi possivel validar o comprovante"));
        } else {
            comprovantes = normalizaStringNumero(retornarTexto(labelCnpjComprovante, "Erro ao validar comprovante"));
        }
        validarCondicaoBooleana(comprovantes.equals(normalizaString(cpfCnpj.get())), MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar CNPJ do comprovante");
        salvarEvidencia("Validar CPF/CNPJ no comprovante");
        return this;
    }

    /**
     * Validar CNPJ do comprovante é o mesmo da solicitação cancelada
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
     * Validar Consistência Banco Conta Salário no Comprovante
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
     * Tocar botão 'Fechar' na tela comprovante
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\" na tela 'Comprovante'")
    public TrazerMeuSalarioTela tocarBotaoFecharComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoFecharComprovante);
        tocarElemento(botaoFecharComprovante, "Não foi possível clicar no botão fechar comprovante");
        aguardarCarregamentoElemento(tituloTelaTrazerMeuSalario);
        salvarEvidencia("Fechar Comprovante");
        return this;
    }

    /**
     * Selecionar radio-button 'CPF' na tela TRAZER MEU SALÁRIO
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar radio-button \"CPF\" na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela selecionarCPF() throws Exception {
        aguardarCarregamentoElemento(radioCPF);
        tocarElemento(radioCPF, "Não foi possível selecionar a opção CPF");
        salvarEvidencia("Selecionar radio-button CPF");
        return this;
    }

    /**
     * Selecionar radio-button 'CNPJ' na tela TRAZER MEU SALÁRIO
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar radio-button \"CNPJ\" na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela selecionarCNPJ() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(radioCNPJ);
        tocarElemento(radioCNPJ, "Não foi possível selecionar a opção CNPJ");
        salvarEvidencia("Selecionar radio-button CNPJ");
        return this;
    }

    /**
     * Tocar botão Próximo
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Próximo\" na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela tocarBotaoProximo() throws Exception {
        salvarEvidencia("Tocar Botão Proximo ");
        tocarElemento(botaoProximo, "Não foi possível tocar no botão Próximo");
        return this;
    }

    /**
     * Clicar botão Voltar depois de selecionar banco
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\" na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar Botão Voltar ");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão Voltar");
        return this;
    }

    /**
     * Clicar botão Próximo depois de selecionar banco
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Próximo\" na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela tocarBotaoSeguir() throws Exception {
        aguardarCarregamentoElemento(campoNomeEmpregador);
        nomeEmpregador.set(campoNomeEmpregador.getText());
        salvarEvidencia("Tocar Botão Proximo ");
        tocarElemento(tocarBotaoSeguir, "Não foi possível tocar no botão Próximo");
        return this;
    }

    /**
     * Preencher campo CPF Empregador
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo \"CNPJ do Empregador\" na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela preencherCampoCNPJ(String cnpjEmpregador) throws Exception {
        tocarElemento(campoCNPJEmpregador, "Não foi possível selecionar campo CNPJ do Empregador");
        escreverTexto(campoCNPJEmpregador, cnpjEmpregador, "Não foi possível preencher campo CNPJ do Empregador");
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
    @Step("Preencher campo 'CNPJ ou CPF do Empregador' na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela preencherCnpjCpfEmpregador(String cnpjCpfEmpregador) throws Exception {
        if(ios){
            apagarCampoTexto(campoCnpjCpfEmpregador, "Campo CNPJ ou CPF do empregador não encontrado");
            escreverTexto(campoCnpjCpfEmpregador, cnpjCpfEmpregador, "Não foi possível preencher campo CNPJ ou CPF do Empregador");
        }else{
            //TODO Refatorar método futuramente
            MobileElement elementoMobile = retornaElemento(campoCnpjCpfEmpregador);
            elementoMobile.clear();
            elementoMobile.sendKeys(cnpjCpfEmpregador);
            //teclarBackSpaceAteApagar(campoCnpjCpfEmpregador,15);
            //digitarTexto(campoCnpjCpfEmpregador, cnpjCpfEmpregador);
        }
        //tocarElemento(campoCnpjCpfEmpregador, "Nao foi possivel tocar no campo CNPJ ou CPF do Empregador");
        cpfCnpj.set(cnpjCpfEmpregador);
        salvarEvidencia("Informado um CNPJ ou CPF inválido para o empregador");
        return this;
    }

    /**
     * Tocar botão AVANÇAR quando o teclado númerico estiver aberto
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'AVANÇAR' na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela tocarBotaoAvancarComTecladoAberto() throws Exception {
        salvarEvidencia("Tocar no botão 'AVANÇAR'");
        tocarElemento(botaoAvancarComTecladoAberto, "Não foi possível tocar no botão 'AVANÇAR'!");
        return this;
    }

    /**
     * Tocar botão AVANÇAR
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'AVANÇAR' na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela tocarBotaoAvancar() throws Exception {
        esconderTeclado();
        salvarEvidencia("Tocar no botão 'AVANÇAR'");
        tocarElemento(botaoAvancar, "Não foi possível tocar no botão 'AVANÇAR'!");
        return this;
    }

    /**
     * Selecionar Banco Conta Salário
     *
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Selecionar \"Banco Conta Salário\"")
    public TrazerMeuSalarioTela selecionarBancoContaSalario(String banco) throws Exception {
        By seletorBanco = android ?
                new By.ByXPath(String.format("//*[@resource-id='br.com.bradesco.next.account_portability:id/ctv_name' and contains(@text, '%s')]", banco)):
                new By.ByXPath(String.format("//*[contains(@name, '%s')]", banco));
        tocarElemento(seletorBanco, String.format("Não foi possível selecionar banco conta-salário: %s", banco));
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
     * Tocar Combobox Conta-Salário
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar combobox \"Banco Conta Salário\" na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela tocarComboboxContaSalario() throws Exception {
        aguardarCarregamentoElemento(comboboxBancoContaSalario);
        tocarElemento(comboboxBancoContaSalario, "Não foi possível selecionar Combobox Banco Conta Salário");
        salvarEvidencia("Selecionar 'Banco Conta Salário'");
        return this;
    }

    /**
     * Tocar Combobox Conta-Salário quando selecionar por CPF
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar combobox \"Banco Conta Salário\" na tela 'TRAZER MEU SALÁRIO'")
    public TrazerMeuSalarioTela tocarComboboxContaSalarioCpfCNPJ() throws Exception {
        aguardarCarregamentoElemento(comboboxBancoContaSalarioCpfCNPJ);
        tocarElemento(comboboxBancoContaSalarioCpfCNPJ, "Não foi possível selecionar Combobox Banco Conta Salário");
        return this;
    }


    /**
     * Preencher filtro com Banco Conta-Salário
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher filtro de pesquisa com Banco Conta-Salário \"Banco Conta Salário\"")
    public TrazerMeuSalarioTela preenchercampoPesquisa(String bancoFavorecido) throws Exception {
        if (android) {
            teclarBackSpaceAteApagar(campoFiltroPesquisaBanco,15);
            digitarTexto(campoFiltroPesquisaBanco,bancoFavorecido);
        } else {
            campoFiltroPesquisaBanco.setValue(bancoFavorecido);
            setValorBancoContaSalario(bancoFavorecido);
        }
        salvarEvidencia("Preencher a barra de buscar com o código do banco desejado");
        return this;
    }

    /**
     * Tocar botão confirmar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"check(^)\"")
    public TrazerMeuSalarioTela tocarbotaoCheck() throws Exception {
        tocarElemento(botaoCheck, "Não foi possível selecionar Combobox Banco Conta Salário");
        salvarEvidencia("Tocar no botão check(^)");
        return this;
    }

    /**
     * Tocar checkbox "Confirmar Solicitação"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar checkbox \"Confirmar Solicitação\"")
    public TrazerMeuSalarioTela tocarCheboxConfirmoSolicitacao() throws Exception {
        aguardarCarregamentoElemento(tituloTermosCondicoes);
        rolaTelaBaixo();
        salvarEvidencia("Tocar no checkbox \"Confirmo a solicitação\"");
        tocarElemento(checkboxConfirmoSolicitacao, "Não foi possível clicar no checkbox \"Confirmo a solicitação\"");
        return this;
    }

    /**
     * Tocar botão continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TrazerMeuSalarioTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar no botão \"Continuar\"");
        tocarElemento(botaoContinuar, "Não foi possível tocar o botão \"Continuar\"");
        aguardarOcultacaoElemento(botaoContinuar);
        return this;
    }

    /**
     * Tocar botão "OK, Entendi"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"OK Entendi\"")
    public TrazerMeuSalarioTela tocarBotaoOKEntendi() throws Exception {
        aguardarCarregamentoElemento(botaoOKEntendi);
        salvarEvidencia("Tocar no botão OK,ENTENDI");
        tocarElemento(botaoOKEntendi, "Não foi possível tocar o botão \"OK, Entendi\"");
        return this;
    }

    /**
     * Tocar botão "OK, Popup"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"OK \"")
    public TrazerMeuSalarioTela tocarBotaoOK() throws Exception {
        aguardarCarregamentoElemento(botaoOkPopup);
        tocarElemento(botaoOkPopup, "Não foi possível tocar o botão \"OK \"");
        salvarEvidencia("Tocar no botão OK ");
        return this;
    }

    /**
     * Validar Mensagem "Frase Você já cadastrou esse CPF/CNPJ pra trazer seu salário pro next."
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem \"Frase Voc? j? cadastrou esse CPF/CNPJ pra trazer seu sal?rio pro next.\"")
    public TrazerMeuSalarioTela validarMensagemVoceJaCadastrouCpfCnpj() throws Exception {
        aguardarCarregamentoElemento(textoModalVoceJaCadastrouCpfCnpj);
        if (getDriver() instanceof IOSDriver) {
            compararElementoTexto(textoModalVoceJaCadastrouCpfCnpj, PortabilidadeDados.VOCE_JA_CADASTROU_CPF, MetodoComparacao.CONTEM);
            salvarEvidencia("Validação realizada com sucesso - 'Voce ja cadastrou este CPF/CNPJ para trazer seu Salario pro next.'");
        } else {
            compararElementoTexto(textoModalVoceJaCadastrouCpfCnpj, PortabilidadeDados.VOCE_JA_CADASTROU_CPF, MetodoComparacao.CONTEM);
            salvarEvidencia("Validação realizada com sucesso - 'Voce ja cadastrou este CPF/CNPJ para trazer seu Salario pro next.'");
        }
        return this;
    }

    /**
     * Validar Tela "Trazer Meu Salário"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar exibição tela \"Trazer Meu Salário\"")
    public TrazerMeuSalarioTela validarTelaTrazerMeuSalario() throws Exception {
        try {
            aguardarCarregamentoElemento(tituloTelaTrazerMeuSalario);
            if (getDriver() instanceof AndroidDriver) {

                compararElementoTexto(tituloTelaTrazerMeuSalario, PortabilidadeDados.TRAZER_MEU_SALARIO, MetodoComparacao.CONTEM);
            } else {
                Assert.assertTrue(Normalizer.normalize(tituloTelaTrazerMeuSalario.getAttribute("name"), Normalizer.Form.NFD).toUpperCase().replaceAll("[\n .!?,]", "")
                        .contains(Normalizer.normalize("TRAZER MEU SALÁRIO", Normalizer.Form.NFD).toUpperCase().replaceAll("[\n .!?,]", "")));
            }
            return this;
        } catch (AssertionError e) {
            throw new AssertionError("Não foi possível validar tela 'TRAZER MEU SALÁRIO'");
        }
    }


    /**
     * Validar 'Termo e Condições'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar texto \"Termo e Condições\"")
    public TrazerMeuSalarioTela validarTermoECondicoes() throws Exception {
        aguardarCarregamentoElemento(textoTermoCondicoes);
        if (ios) {
            validarCondicaoBooleana(verificarPresencaElemento(textoTermoCondicoes), MetodoComparacaoBooleano.VERDADEIRO,
                    "Termo e Condições não está visível no iOS.");
        }
        salvarEvidencia("Texto Termo e Condições Validado com Sucesso");
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
     * Clicar botão 'Contestar'
     *
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Clicar botão \"Contestar\"")
    public TrazerMeuSalarioTela tocarBotaoContestar() throws Exception {
        aguardarCarregamentoElemento(botaoContestar);salvarEvidencia("Clicar no botão 'Contestar'");
        tocarElemento(botaoContestar, "Não foi possível clicar no botão contestar");
        salvarEvidencia("Clicar no botão 'Ok - PortabilidadeDados Concluida'");
        return this;
    }

    /**
     * Tocar Botão Avançar
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Tocar botão \"Avancar\" no fluxo de Contestar")
    public TrazerMeuSalarioTela tocarBotaoAvancarContestacao() throws Exception {
        aguardarCarregamentoElemento(botaoAvancarContestacao);
        salvarEvidencia("Clicar no botão 'Avancar'");
        tocarElemento(botaoAvancarContestacao, "Não foi possível clicar no botão Avancar");
        return this;
    }

    /**
     * Tocar Botão Canekar
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Tocar botão \"Cancelar\" no fluxo de Contestar")
    public TrazerMeuSalarioTela tocarBotaoCancelarContestacao() throws Exception {
        aguardarCarregamentoElemento(botaoCancelarContestacao);
        salvarEvidencia("Clicar no botão 'Cancelar'");
        tocarElemento(botaoCancelarContestacao, "Não foi possível clicar no botão Cancelar");
        return this;
    }

    /**
     * Validar mensagem de CPF/CNPJ inválido
     *
     * @return TrazerMeuSalarioTela
     * @throws Exception
     */
    @Step("Validar mensagem CPF/CNPJ inválido")
    public TrazerMeuSalarioTela validarMensagemCpfCnpjInvalido() throws Exception {

        if(android){
            MobileElement elementoMobile = retornaElemento(mensagemInvalido);
            aguardarCarregamentoElemento(elementoMobile);
        } else{
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos("CNPJ inválido"), MetodoComparacaoBooleano.VERDADEIRO,
                    "Erro na validação da mensagem 'CPF/CNPJ inválido'");
        }
        salvarEvidencia("Validação da mensagem 'CPF/CNPJ inválido'");
        return this;
    }
}
