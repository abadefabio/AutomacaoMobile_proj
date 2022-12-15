package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.vaquinha.TituloTela;
import constantes.vaquinha.Vaquinha;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.da.conta.EncerrarContaTela;

import java.util.HashMap;

public class VaquinhaTela extends PaginaBase {

    //bot�o criar vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_create_vaquinha")
    @iOSXCUITFindBy(id = "Criar vaquinha")
    private MobileElement botaoCriarVaquinha;

    //bot�o + add vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_new_vaquinha")
    @iOSXCUITFindBy(accessibility = "Adicionar")
    @iOSXCUITFindBy(id = "item_new_vaquinha")
    private MobileElement botaoAdicionarVaquinha;

    //bot�o + excluir vaquinha lixeira

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_item_remove")
    @iOSXCUITFindBy(accessibility = "icon-delete")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"icon-delete\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Excluir\"]")
    private MobileElement botaoExcluirVaquinha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/pv_vaquinha")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"img_progress_graphic\"])[1]")
    @iOSXCUITFindBy(id = "Criar vaquinha")
    private MobileElement botaoSelecionar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name_vaquinha")
    @iOSXCUITFindBy(id = "Criar vaquinha")
    private MobileElement botaoConfirmaExcluirVaquinha;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_delete_vaquinha")
    @iOSXCUITFindBy(id = "Criar vaquinha")
    private MobileElement selecionarNomeVaquinha;

    //fechar tela vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    private MobileElement botaoFecharTelaVaquinha;

    //Titulo tela vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    private MobileElement textViewTelaVaquinha;

    //Subtitulo organize sua vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(id = "Organize sua vaquinha com a gente")
    private MobileElement subtituloOrganizeSuaVaquinha;

    //Aceitar termo e condi��es vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Aceitar\"`]")
    private MobileElement botaoAceitaTermoCondicoesVaquinha;

    //Fechar tela de termoe e condi��es
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(id = "Central de Relacionamento Next:")
    private MobileElement botaoFecharTelaTermoCondicoes;

    //Titulo da tela de termo e condi��es
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//*[@name = \"TERMOS E CONDI��ES\"]")
    private MobileElement tituloTelaTermoCondicoesVaquinha;

    //Bot�o Continuar tela de vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement botaoContinuarTelaVaquinha;

    //Bot�o Continuar proximo
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    private MobileElement botaoProximo;

    //Dar um nome para vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name_vaquinha")
    @iOSXCUITFindBy(accessibility = "Meu nome �")
    private MobileElement labelDarNomeVaquinha;

    //Label "quanto" vai pagar na vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_qnt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Valor por pessoa\"]")
    @iOSXCUITFindBy(id = "et_value")
    private MobileElement labelQuantoPagarVaquinha;

    //At� "quando" pagar a vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = " br.com.bradesco.next:id/et_qnd")
    @iOSXCUITFindBy(id = "date_limit")
    private MobileElement labelAteQuandoVaquinha;

    //Bot�o Continuar ate quando vai pagar
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(id = "Continuar")
    private MobileElement botaoContinuarQuandoVaquinha;

    //Botao confirmar data de agendamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "//android.widget.ImageView[@content-desc=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmarDataAgendamentoVaquinha;

    //Bot�o contatos
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_invited_contacts")
    @iOSXCUITFindBy(id = "Convidar")
    private MobileElement botaoContatosVaquinha;

    //Continuar Contatos Vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_invited_contacts")
    @iOSXCUITFindBy(id = "bt_continue")
    private MobileElement botaoContinuarContatosVaquinha;

    //Radio Button Banco vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_bank")
    @iOSXCUITFindBy(id = "rb_type_bank")
    private MobileElement radioButtonBancoContatoVaquinha;

    //Radio Button institui��o pagadora vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_institutional")
    @iOSXCUITFindBy(id = "rb_type_institutional")
    private MobileElement radioButtonInstitui��oPgtoContatoVaquinha;

    //Combo banco e intitui��o contato vaquinha
    @AndroidFindBy(id = "//android.widget.LinearLayout[@content-desc=\"Banco ou Institui��o\"]/android.widget.RelativeLayout")
    @iOSXCUITFindBy(accessibility = "Banco ou Institui��o")
    private MobileElement comboBancoInstitui��oContatoVaquinha;

    //Label agencia contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_agency")
    @iOSXCUITFindBy(accessibility = "Ag�ncia")
    private MobileElement labelAgenciaContatoVaquinha;

    //Conta tela contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_account")
    @iOSXCUITFindBy(accessibility = "Conta e d�gito")
    private MobileElement labelContaContatoVaquinha;

    //Nome completo tela contato vaguina
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name")
    @iOSXCUITFindBy(accessibility = "Nome completo")
    private MobileElement labelNomeContatoVaquinha;

    //Cnpj tela contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_cnpj")
    @iOSXCUITFindBy(accessibility = "CPF/CNPJ")
    private MobileElement labelCnpjContatoVaquinha;

    //Swit autoriza conta para TED
    @AndroidFindBy(id = "br.com.bradesco.next:id/next_switch")
    @iOSXCUITFindBy(accessibility = "next_switch")
    private MobileElement switAutorizaContaContatoVaquinha;

    //Bot�o fechar tela esclher contado vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "animated_view")
    private MobileElement botaoFecharTelaEscolherContatoVaquinha;

    //Bot�o adicionar banco contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_add_remove")
    @iOSXCUITFindBy(accessibility = "ADICIONAR")
    private MobileElement botaoAddBancoContatoVaquinha;

    //Bot�o adicionar vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_new_vaquinha")
    @iOSXCUITFindBy(accessibility = "Adicionar")
    private MobileElement botaoAdicionarMaisUmaVaquinha;

    //Bot�o salvar banco contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @iOSXCUITFindBy(accessibility = "bt_save")
    private MobileElement botaoSalvarBancoContatoVaquinha;

    //Bot�o editar contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @iOSXCUITFindBy(accessibility = "Editar contato")
    private MobileElement botaoEditarContatoVaquinha;

    //Tab Nov Contato Vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Aba Autorizados selecionada")
    private MobileElement tabNovoContatoVaquinha;

    //Tab Contato Vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_tab_all")
    @iOSXCUITFindBy(accessibility = "Aba Todos, Bot�o")
    private MobileElement tabContatoVaquinha;

    //Toolbar escolher titulo da tela
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(accessibility = "ESCOLHER")
    private MobileElement toolbarEscolherContatoVaquinha;

    //Imagem vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_img_vaquinha")
    @iOSXCUITFindBy(accessibility = "IMAGEM")
    private MobileElement imagemContatoVaquinha;

    //Editar Contato vaquinha
    @AndroidFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-edit\"]\n")
    @iOSXCUITFindBy(accessibility = "icon-edit")
    private MobileElement editContatoVaquinha;

    //deletar vaquinha lixeira
    @AndroidFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-delete\"]\n")
    @iOSXCUITFindBy(accessibility = "icon-delete")
    private MobileElement editDeletearContatoVaquinha;

    //excluir vaquinha confirma��o
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_delete_vaquinha")
    @iOSXCUITFindBy(accessibility = "Excluir Vaquinha")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Excluir Vaquinha\"`]")
    private MobileElement editExcluirContatoVaquinha;

    //deletar card vaquinha
    @AndroidFindBy(xpath = "//XCUIElementTypeButton[@name=\"bt_delete_card\"]\n")
    @iOSXCUITFindBy(accessibility = "bt_delete_card")
    private MobileElement botaoDeletarCardContatoVaquinha;

    //Texto de limite, validar excesso de limite de vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value_available")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText' and contains(@value, 'Ops.')]")
    private MobileElement textoValorLimiteVaquinha;

    //Editar data
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_choose")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Selecione uma data\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Selecione uma data\"]")
    private MobileElement editDataVaquinha;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id = 'br.com.bradesco.next:id/title_month_current']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"m�s\")]")
    private MobileElement labelMesAgenda;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Fechar, Bot�o")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Fechar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_more")
    @AndroidFindBy(accessibility = " Adicionar, bot�o")
    @iOSXCUITFindBy(accessibility = "rightListButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Lista\"`]")
    private MobileElement botaoPerfil;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_more")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Lista\"`]")
    private MobileElement listaVaquinha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_edit_travel")
    @iOSXCUITFindBy(accessibility = "Editar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Editar\"`]")
    private MobileElement botaoEditarPerfil;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_edit_vaquinha")
    @iOSXCUITFindBy(id = "icon-edit")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"icon-vaquinha-default\"`]")
    private MobileElement botaoEditarImagem;

    @AndroidFindBy(id = "br.com.bradesco.next:id/img")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeOther/XCUIElementTypeButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"img_select_icon\"`]")
    private MobileElement botaoAlterarImagem;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Salvar edi��o\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Salvar edi��o\"]")
    private MobileElement botaoContinue;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_edit_name")
    @iOSXCUITFindBy(id = "NOME DA VAQUINHA")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"icon edit\"])[1]")
    private MobileElement botaoEditNome;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_edit_date")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"icon edit\"`][2]")
    @iOSXCUITFindBy(xpath = "(//[@name=\"icon edit\"])[2]")
    private MobileElement botaoAlterarData;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Menu, Bot�o")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    private MobileElement botaoMenu;

    @iOSXCUITFindBy(xpath = "/XCUIElementTypeTextField[@name=\"NOME DA VAQUINHA\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name")
    private MobileElement alteraNome;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Aceitar\"`]")
    private MobileElement botaoAceitar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continuar']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"bt_continue\"]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name_vaquinha")
    @iOSXCUITFindBy(accessibility = "lb_card_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    private MobileElement cardVaquinha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_remove_travel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Excluir\"]")
    @iOSXCUITFindBy(id = "Excluir")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Excluir\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Excluir\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    private MobileElement botaoExcluir;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_container_details")
    @iOSXCUITFindBy(accessibility = "bt_delete_card")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"bt_delete_card\"])[1]")
    private MobileElement botaoApagarCard;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_vaquinha_edit_contact")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Convidar\"]")
    private MobileElement convidar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "bt_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continuar\"]")
    private MobileElement continuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_no_want")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"N�o, valeu\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"N�o, valeu\" AND name == \"N�o, valeu\" AND type == \"XCUIElementTypeButton\"")
    private MobileElement recusar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_accept")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='T� dentro']")
    private MobileElement aceitar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name_vaquinha")
    @iOSXCUITFindBy(accessibility = "lb_card_title")
    private MobileElement tituloVaquinha;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pr�ximo\"]")
    private MobileElement botaoProximoTeclado;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Salvar\"`]")
    private MobileElement botaoSalvar;

    @AndroidFindBy(accessibility = "Adicionar, bot�o")
    @iOSXCUITFindBy(accessibility = "rightListButton")
    private MobileElement botaoMais;

    public VaquinhaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar no bot�o 'Criar vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"criar vaquinha\"")
    public VaquinhaTela tocarBotaoCriarVaquinha() throws Exception {
        aguardarPaginaConterTodosTextos("VAQUINHA");
        if (verificarPresencaElemento(botaoAdicionarMaisUmaVaquinha)) {
            aguardarCarregamentoElemento(botaoAdicionarMaisUmaVaquinha);
            tocarElemento(botaoAdicionarMaisUmaVaquinha, "N�o foi poss�vel clicar no bot�o 'Add Vaquinha'");
            salvarEvidencia("Clicar no bot�o 'Add vaquinha'");
        }
        esperarCarregando();
        aguardarCarregamentoElemento(botaoCriarVaquinha);
        salvarEvidencia("Clicar no bot�o 'criar vaquinha'");
        tocarElemento(botaoCriarVaquinha, "N�o foi poss�vel clicar no bot�o criar vaquinha, o CPF utilizado j� possui vaquinhas criadas");
        return this;
    }

    /**
     * Clicar bot�o 'Add Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"ADD VAquinha\"")
    public VaquinhaTela tocarBotaoAdicionarVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoAdicionarMaisUmaVaquinha);
        tocarElemento(botaoAdicionarMaisUmaVaquinha, "N�o foi poss�vel clicar no bot�o 'Add Vaquinha'");
        salvarEvidencia("Clicar no bot�o 'Add vaquinha'");
        return this;
    }

    /**
     * Clicar bot�o 'Excluir Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"excluir Vaquinha\"")
    public VaquinhaTela tocarBotaoExcluirVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoExcluirVaquinha);
        salvarEvidencia("Clicar no bot�o 'excluir vaquinha'");
        if (ios)
            if (verificarPresencaElemento(botaoExcluirVaquinha))
                tocarElemento(botaoExcluirVaquinha, "N�o foi poss�vel clicar no bot�o 'Excluir Vaquinha'");
            else
                tocarCoordenadaProporcional(By.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton"), 99, 50);
        else
            tocarElemento(botaoExcluirVaquinha, "N�o foi poss�vel clicar no bot�o 'Excluir Vaquinha'");
        return this;
    }

    /**
     * Clicar bot�o 'Excluir Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Confirma excluir Vaquinha\"")
    public VaquinhaTela tocarBotaoConfirmaExcluirVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoExcluirVaquinha);
        salvarEvidencia("Clicar no bot�o 'Confirma excluir vaquinha'");
        if (android) {
            tocarElemento(botaoConfirmaExcluirVaquinha, "N�o foi poss�vel clicar no bot�o 'Confirma Excluir Vaquinha'");
        } else {
            tocarCoordenadaProporcional(92, 5);
        }
        return this;
    }

    /**
     * Tocar bot�o Excluir Vaquinha
     */
    @Step("Tocar bot�o Excluir Vaquinha")
    public VaquinhaTela tocarBotaoExcluir() throws Exception {
        aguardarCarregamentoElemento(editExcluirContatoVaquinha);
        salvarEvidencia("Clicar no bot�o 'Confirma excluir vaquinha'");
        tocarElemento(editExcluirContatoVaquinha, "N�o foi poss�vel clicar no bot�o 'Confirma Excluir Vaquinha'");
        esperarCarregando();
        return this;
    }

    /**
     * Clicar bot�o 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Fechar\"")
    public VaquinhaTela tocarBotaoFechar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Fechar'");
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar no bot�o Fechar");
        esperarCarregando();
        aguardarCarregamentoElemento(botaoAdicionarMaisUmaVaquinha);
        esperarCarregando();
        return this;
    }

    /**
     * Tocar bot�o 'Apagar Card'
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Apagar Card\"")
    public VaquinhaTela tocarBotaoApagarCard() throws Exception {
        esperarCarregando();
        aguardarCarregamentoElemento(botaoApagarCard);
        salvarEvidencia("Tocar no bot�o 'Apagar Card'");
        tocarElemento(botaoApagarCard, "N�o foi poss�vel tocar no bot�o Apagar Card");
        return this;
    }

    /**
     * Tocar Card Vaquinha
     */
    public VaquinhaTela tocarCardVaquinha() throws Exception {
        aguardarCarregamentoElemento(cardVaquinha);
        tocarElemento(cardVaquinha, "N�o foi poss�vel tocar no card da Vaquinha");
        salvarEvidencia("Tocar card vaquinha");
        return this;
    }

    /**
     * Tocar bot�o Lista
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o Lista")
    public VaquinhaTela tocarBotaoLista() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(listaVaquinha);
        salvarEvidencia("Tocar no bot�o 'lista");
        tocarElemento(listaVaquinha, "N�o foi poss�vel tocar no bot�o lista");
        return this;
    }

    /**
     * Tocar bot�o Excluir
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o Excluir Vaquinha")
    public VaquinhaTela tocarBotaoExcluirVaq() throws Exception {

        salvarEvidencia("Tocar no bot�o 'excluir");
        aguardarExistenciaElemento(botaoExcluir);
        tocarElemento(botaoExcluir, "N�o foi poss�vel tocar no bot�o excluir");
        if (ios && verificarPresencaElemento(botaoExcluir)) // toca no bot�o novamente se tocarElemento n�o refletir (problema ocorrendo em alguns iOS)
            tocarCoordenadaProporcional(By.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton"), 99, 50);
        return this;

    }

    /**
     * Tocar no bot�o 'continuar vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o \" + continuar vaquinha\"")
    public VaquinhaTela tocarContinuarVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoContinuarTelaVaquinha);
        salvarEvidencia("Tocar no bot�o 'continuar");
        tocarElemento(botaoContinuarTelaVaquinha, "N�o foi poss�vel tocar no bot�o continuar");
        return this;
    }

    /**
     * Tocar no bot�o 'quanto pagar de vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar label \" + label quanto\"")
    public VaquinhaTela tocarLabelQuanto(String valorVaquinha) throws Exception {
        aguardarCarregamentoElemento(labelQuantoPagarVaquinha);
        salvarEvidencia("Tocar no label 'Valor da Vaquinha");
        escreverTexto(labelQuantoPagarVaquinha, valorVaquinha, "N�o foi poss�vel tocar no label valor da vaquinha");
        if (android) {
            tocarContinuarVaquinha();
        }
        return this;
    }

    /**
     * Preencher nome da vaquinha
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Preencher nome da vaquinha")
    public VaquinhaTela preencherNomeVaquinha(String nomeVaquinha) throws Exception {
        aguardarCarregamentoElemento(labelDarNomeVaquinha);
        String mensagemErro = "Erro encontrado ao preencher campo nome da vaquinha";
        String mensagemEvidencia = "Preecher campo \"Nome da Vaquinha\" com \"" + nomeVaquinha + "\"";
        if (ios) {
            try {
                //Por algum motivo, nesse campo, o m�todo escreverTexto() do framework estava apresentando erro. Essa implementa��o deve ser alterada,
                //assim que o problema com o m�todo do framework for solucionado.
                labelDarNomeVaquinha.sendKeys(nomeVaquinha);
                salvarEvidencia(mensagemEvidencia);
            } catch (Exception e) {
                throw new NextException(mensagemErro, e);
            }
            esconderTeclado();
        } else {
            esconderTeclado();
            escreverTexto(labelDarNomeVaquinha, nomeVaquinha, mensagemErro);
            salvarEvidencia(mensagemEvidencia);
        }
        return this;
    }

    /**
     * Clicar no bot�o 'quanto pagar de vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Informar valor vaquinha")
    public VaquinhaTela informaValorVaquinha(String valorVaquinha) throws Exception {
        aguardarCarregamentoElemento(labelQuantoPagarVaquinha);
        escreverTexto(labelQuantoPagarVaquinha, valorVaquinha, "N�o foi poss�vel clicar no label valor da vaquinha");
        salvarEvidencia("Preencher campo \"Valor da Vaquinha\"");
        return this;
    }

    /**
     * Validar mensagem de valor m�ximo permitido
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Validar mensagem de valor m�ximo permitido")
    public VaquinhaTela validarMensagemValorLimiteVaquinha() throws Exception {
        aguardarCarregamentoElemento(textoValorLimiteVaquinha);
        compararElementoTexto(textoValorLimiteVaquinha, Vaquinha.VALOR_MAIOR, MetodoComparacao.CONTEM);
        salvarEvidencia("Mensagem esperada");
        return this;
    }

    /**
     * Tocar no label 'data vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar label \" + label data da vaquinha\"")
    public VaquinhaTela tocarBotaoDataEdicao() throws Exception {
        aguardarCarregamentoElemento(editDataVaquinha);
        salvarEvidencia("Tocar no label 'data da vaquinha");
        tocarElemento(editDataVaquinha, "N�o foi poss�vel tocar no label data da vaquinha");
        return this;
    }

    /**
     * Selecionar Data
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Selecionar a Data")
    public VaquinhaTela selecionarData(String data) throws Exception {
        aguardarCarregamentoElemento(labelMesAgenda);
        //Separa a data de entrada em dia, m�s e ano
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        //Dicionario relacionando mes com nome em portugu�s
        HashMap<String, String> relacaoMes = new HashMap<String, String>();
        relacaoMes.put("01", "Janeiro");
        relacaoMes.put("02", "Fevereiro");
        relacaoMes.put("03", "Mar�o");
        relacaoMes.put("04", "Abril");
        relacaoMes.put("05", "Maio");
        relacaoMes.put("06", "Junho");
        relacaoMes.put("07", "Julho");
        relacaoMes.put("08", "Agosto");
        relacaoMes.put("09", "Setembro");
        relacaoMes.put("10", "Outubro");
        relacaoMes.put("11", "Novembro");
        relacaoMes.put("12", "Dezembro");
        // substitui valor num�rico de m�s por nome
        String mesNome = relacaoMes.get(mes);

        if (ios) {
            // data a ser buscada ao deslizar a tela em busca do m�s desejado
            By dataPadrao = By.xpath("//XCUIElementTypeCell[contains(@name,'15 de " + mesNome.toLowerCase() + " de " + ano + "')]");
            // data a ser selecionada no calend�rio
            By dataDesejada = By.xpath("//XCUIElementTypeCell[contains(@name,'" + dia + " de " + mesNome.toLowerCase() + " de " + ano + "')]");
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(dataPadrao,
                    "N�o foi poss�vel encontrar o elemento " + dataDesejada + "");
            tocarElemento(dataDesejada, "N�o foi poss�vel selecionar a Data");
            OperadorEvidencia.logarPasso("Dia " + dia + " selecionado");
        } else {
            // data a ser selecionada no calend�rio
            By dataDesejada = By.xpath("//android.view.View[contains(@content-desc,'" + ano + "-" + mes + "-" + dia + "')]");
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(dataDesejada, "N�o foi poss�vel encontrar o elemento " + dataDesejada + "");
            tocarElemento(dataDesejada, "N�o foi poss�vel selecionar a Data");
            OperadorEvidencia.logarPasso("Dia " + dia + " selecionado");
        }
        salvarEvidencia("Selecionar a Data");
        return this;
    }

    /**
     * Tocar em 'Confirmar'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Confirmar\"")
    public VaquinhaTela tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        tocarElemento(botaoConfirmar, "N�o foi poss�vel tocar em Confirmar");
        return this;
    }

    /**
     * Selecinar vaquinha existente
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Selecionar vaquinha")
    public VaquinhaTela selecionarVaquinhaExistente(String nome) throws Exception {
        if (ios) {
            salvarEvidencia("Selecionar vaquinha existente'");
            retornaElemento(new By.ByClassName("XCUIElementTypeSearchField")).sendKeys(nome);
            tocarElemento(botaoSelecionar, "N�o foi poss�vel selecionar vaquinha existente");
        } else {
            tocarBotaoSelecionarVaquinha();
        }
        return this;
    }

    /**
     * Tocar bot�o 'Perfil'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar no bot�o \"perfil\"")
    public VaquinhaTela tocarBotaoPerfil() throws Exception {
        esperarCarregando();
        aguardarCarregamentoElemento(botaoPerfil);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPerfil, "N�o foi poss�vel encontrar o elemento " + botaoPerfil + "");
        salvarEvidencia("Tocar no bot�o 'Perfil'");
        tocarElemento(botaoPerfil, "N�o foi poss�vel tocar no bot�o 'Perfil'");
        return this;
    }

    /**
     * Tocar bot�o editar 'Perfil'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar no bot�o \"perfil\"")
    public VaquinhaTela tocarBotaoEditarPerfil() throws Exception {
        aguardarCarregamentoElemento(botaoEditarPerfil);
        salvarEvidencia("Tocar no botao 'Editar Perfil'");
        if (ios) {
            if (!verificarPresencaElemento(botaoEditarPerfil))
                tocarCoordenadaProporcional(By.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton"), 99, 50);
            else
                tocarElemento(botaoEditarPerfil, "N�o foi poss�vel tocar no bot�o 'Editar Perfil'");
        } else
            tocarElemento(botaoEditarPerfil, "N�o foi poss�vel tocar no bot�o 'Editar Perfil'");
        return this;
    }

    /**
     * Tocar bot�o editar 'Imagem'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar no bot�o editar \"imagem\"")
    public VaquinhaTela tocarBotaoEditarImagem() throws Exception {
        aguardarCarregamentoElemento(botaoEditarImagem);
        salvarEvidencia("Tocar no botao 'Editar Imagem'");
        tocarElemento(botaoEditarImagem, "N�o foi poss�vel tocar no bot�o 'Editar Imagem'");
        return this;
    }

    /**
     * Tocar bot�o alterar 'Imagem'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar alterar \"imagem\"")
    public VaquinhaTela tocarBotaoAlterarImagem() throws Exception {
        aguardarCarregamentoElemento(botaoAlterarImagem);
        salvarEvidencia("Tocar no botao 'Alterar Imagem'");
        if (ios)
            tocarCoordenadaProporcional(By.xpath("//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeOther/XCUIElementTypeButton"), 50, 50);
        else
            tocarElemento(botaoAlterarImagem, "N�o foi poss�vel tocar no bot�o 'Alterar Imagem'");
        return this;
    }

    /**
     * Tocar bot�o salvar edi��o'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar alterar \"imagem\"")
    public VaquinhaTela tocarBotaoSalvarEdicao() throws Exception {
        aguardarCarregamentoElemento(botaoContinue);
        salvarEvidencia("Tocar no botao 'Salvar Edicao'");
        tocarElemento(botaoContinue, "N�o foi poss�vel tocar no bot�o 'Continue'");
        return this;
    }

    /**
     * Tocar bot�o alterar nome
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar alterar \"nome\"")
    public VaquinhaTela tocarBotaoEditarNome() throws Exception {
        aguardarCarregamentoElemento(botaoEditNome);
        salvarEvidencia("Tocar no botao 'Editar nome'");
        tocarElemento(botaoEditNome, "N�o foi poss�vel tocar no botao 'Editar nome'");
        return this;
    }

    /**
     * Tocar bot�o alterar 'Imagem'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar alterar \"data\"")
    public VaquinhaTela tocarBotaoEditarData() throws Exception {
        aguardarCarregamentoElemento(botaoAlterarData);
        salvarEvidencia("Tocar no botao 'Alterar Data'");
        tocarElemento(botaoAlterarData, "N�o foi poss�vel tocar no bot�o 'Alterar data'");
        return this;
    }

    /**
     * Tocar no �cone 'Menu'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao \"Menu\"")
    public VaquinhaTela tocarBotaoMenu() throws Exception {
        aguardarCarregamentoElemento(botaoMenu);
        int contador = 0;
        while (!verificarPresencaElemento(botaoMenu) || contador < 3) {
            contador++;
        }
        salvarEvidencia("Clicar no botao 'Menu'");
        tocarElemento(botaoMenu, "N�o foi poss�vel clicar no bot�o Menu");
        return this;
    }

    /**
     * Clicar no bot�o 'Aceitar'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar no botao aceitar")
    public VaquinhaTela tocarBotaoAceitar() throws Exception {
        aguardarCarregamentoElemento(tituloTelaTermoCondicoesVaquinha);
        int contador = 0;
        while (!verificarPresencaElemento(botaoAceitaTermoCondicoesVaquinha) || contador < 7) {
            rolarTela(0.9, 0.3);
            contador++;
        }
        tocarElemento(botaoAceitaTermoCondicoesVaquinha, "N�o foi poss�vel tocar no bot�o 'Aceitar'");
        salvarEvidencia("Tocar no botao aceitar'");
        return this;
    }

    /**
     * Clicar no bot�o 'Continuar'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar no botao 'Continuar'")
    public VaquinhaTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "N�o foi poss�vel clicar no bot�o 'Continuar'");
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        esperarCarregando();
        return this;
    }

    /**
     * Escrever o nome da vaquinha
     *
     * @param nomeVaquinhaAlterada
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("nome vaquinha")
    public VaquinhaTela nomeVaquina(String nomeVaquinhaAlterada) throws Exception {
        salvarEvidencia("Editar campo 'NOME VAQUINHA'");
        if (android) {
            apagarCampoTexto(alteraNome, "N�o foi poss�vel apagar o conte�do do campo 'NOME DA VAQUINHA'!");
            escreverTexto(alteraNome, nomeVaquinhaAlterada, "n�o foi poss�vel escrever nome vaquinha");
        } else {
            tocarCoordenadaProporcional(40, 90);
        }
        return this;
    }

    /**
     * tocar botao convidar amigos
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("tocar bot�o convidar")
    public VaquinhaTela tocarConvidar() throws Exception {

        salvarEvidencia("tocar bot�o convidar");
        rolaTelaBaixo();
        rolaTelaBaixo();
        tocarElemento(convidar, "N�o foi poss�vel tocar no bot�o convidar");
        esperarCarregando();
        return this;
    }

    /**
     * tocar botao continuar
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("tocar bot�o contiunar")
    public VaquinhaTela tocarContinuar() throws Exception {

        salvarEvidencia("tocar bot�o continuar");
        tocarElemento(continuar, "N�o foi poss�vel tocar no bot�o continuar");
        esperarCarregando();
        return this;
    }

    /**
     * tocar botao recusar vaquinha
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("tocar bot�o recusar vaquinha")
    public VaquinhaTela tocarBotaoRecusarVaquinha() throws Exception {
        aguardarPaginaConterTodosTextos("VAQUINHA");
        salvarEvidencia("tocar bot�o recusar vaquinha");
        rolaTelaBaixo();
        aguardarCarregamentoElemento(recusar);
        if (ios) {
            tocarCoordenadaElemento(recusar);
        } else {
            tocarElemento(recusar, "N�o foi poss�vel tocar no bot�o recusar vaquinha");
        }
        return this;
    }

    /**
     * tocar botao selecionar vaquinha
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("tocar bot�o selecionar vaquinha")
    public VaquinhaTela tocarBotaoSelecionarVaquinha() throws Exception {
        aguardarCarregamentoElemento(tituloVaquinha);
        salvarEvidencia("tocar bot�o selecionar vaquinha");
        tocarElemento(tituloVaquinha, "N�o foi poss�vel tocar no bot�o selecionar vaquinha");
        return this;
    }

    /**
     * Selecionar Vaquinha
     *
     * @param nomeVaquinha
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Deslizar ate achar Vaquinha")
    public VaquinhaTela deslizarAteAcharVaquinha(String nomeVaquinha) throws Exception {

        int index = 0;
        while(!aguardarPaginaConterTodosTextos(nomeVaquinha)){
            deslizar(Direcao.DIREITA, 90, 25);
            index++;
            if (index == 14){
                throw new NextException("N�o foi poss�vel achar a vaquinha", new Exception());
            }
        }
        salvarEvidencia("Deslizar at� encontrar vaquinha: "+ nomeVaquinha);
        return this;
    }

    /**
     * tocar botao via coordenada encontrada no id passado via param
     *
     * @param elemento
     */
    protected void tocarCoordenadaElemento(MobileElement elemento) {
        Point localizacao = elemento.getLocation();
        tocarCoordenada(localizacao.x, localizacao.y);
    }

    /**
     * Clicar no bot�o 'quanto pagar de vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar label \" + label quanto\"")
    public VaquinhaTela escreverLabelQuanto(String valorVaquinha) throws Exception {
        aguardarCarregamentoElemento(labelQuantoPagarVaquinha);
        if (ios) {
            try {
                MobileElement valorVaquinhaElemento = retornaElemento(By.xpath("//XCUIElementTypeSearchField[@name=\"Valor por pessoa\"]"));
                valorVaquinhaElemento.sendKeys(valorVaquinha + "\uE007");
            } catch (Exception e) {
                throw new NextException("N�o foi poss�vel clicar no label valor da vaquinha", e);
            }
        } else {
            escreverTexto(labelQuantoPagarVaquinha, valorVaquinha, "N�o foi poss�vel digitar valor da vaquinha");
        }
        salvarEvidencia("Digitar 'Valor da Vaquinha': " + valorVaquinha);
        return this;
    }


    /**
     * Tocar bot�o salvar
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao 'Salvar'")
    public VaquinhaTela tocarBotaoSalvar() throws Exception {
        aguardarCarregamentoElemento(botaoSalvar);
        salvarEvidencia("Tocar no botao 'Salvar'");
        tocarElemento(botaoSalvar, "N�o foi poss�vel tocar no bot�o 'Salvar'");
        return this;
    }

    /**
     * Validar presen�a da tela 'Vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Validar tela 'Vaquinha'")
    public VaquinhaTela validarTelaVaquinha() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.VAQUINHA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Vaquinha' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a do t�tulo 'Vaquinha'");
        return this;
    }

    /**
     * Tocar bot�o (+) 'Adicionar Vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao (+) 'Adicionar Vaquinha'")
    public VaquinhaTela tocarAdicionarVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoAdicionarVaquinha);
        salvarEvidencia("Tocar no botao (+) 'Adicionar Vaquinha'");
        tocarElemento(botaoAdicionarVaquinha, "N�o foi poss�vel tocar no bot�o (+) 'Adicionar Vaquinha'");
        return this;
    }

    /**
     * Validar efetiva��o de vaquinha
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Validar efetiva��o de vaquinha")
    public VaquinhaTela validarEfetivacaoVaquinha() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Vaquinha.MENSAGEM_SUA_VAQUINHA_TA_PRONTA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Sua vaquinha t� pronta!' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a da mensagem 'Sua vaquinha t� pronta!'");
        return this;
    }

    /**
     * Tocar bot�o (+) 'Mais' e/ou 'Lista'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao (+) 'Mais' e/ou 'Lista'")
    public VaquinhaTela tocarBotaoMais() throws Exception {
        aguardarCarregamentoElemento(botaoMais);
        salvarEvidencia("Tocar no botao (+) 'Mais' e/ou 'Lista'");
        tocarElemento(botaoMais, "N�o foi poss�vel tocar no bot�o (+) 'Mais' e/ou 'Lista'");
        return this;
    }

    /**
     * Tocar bot�o Excluir Vaquinha Criada
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao Excluir Vaquinha Criada")
    public VaquinhaTela tocarBotaoExcluirVaquinhaCriada() throws Exception {
        aguardarCarregamentoElemento(botaoExcluirVaquinha);
        salvarEvidencia("Tocar no botao Excluir Vaquinha Criada");
        tocarElemento(botaoExcluirVaquinha, "N�o foi poss�vel tocar no bot�o (Excluir Vaquinha Criada");
        return this;
    }

    /**
     * Validar Vaquinha Cancelada e/ou Exclu�da
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Validar Vaquinha Cancelada e/ou Exclu�da")
    public VaquinhaTela validarVaquinhaCancelada() throws Exception {
        if(android){
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Vaquinha.MENSAGEM_VAQUINHA_CANCELADA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Vaquinha Cancelada!' n�o est� presente na tela!");
            salvarEvidencia("Validar presen�a da mensagem 'Vaquinha Cancelada!'");
        }
        else {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Vaquinha.MENSAGEM_VAQUINHA_EXCLUIDA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Vaquinha Exclu�da!' n�o est� presente na tela!");
            salvarEvidencia("Validar presen�a da mensagem 'Vaquinha Exclu�da!'");
        }
        return this;
    }

    /**
     * Tocar bot�o 'Fechar'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao 'Fechar'")
    public VaquinhaTela tocarNoBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no botao 'Fechar'");
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar no bot�o 'Fechar'");
        return this;
    }

    /**
     * Tocar bot�o Contatos
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao 'Contatos'")
    public VaquinhaTela tocarBotaoContatos() throws Exception {
        aguardarCarregamentoElemento(botaoContatosVaquinha);
        salvarEvidencia("Tocar no botao 'Contatos'");
        tocarElemento(botaoContatosVaquinha, "N�o foi poss�vel tocar no bot�o 'Contatos'");
        return this;
    }

    /**
     * Tocar bot�o 'To dentro'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao 'To Dentro'")
    public VaquinhaTela tocarBotaoToDentro() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(aceitar, "N�o foi poss�vel tocar botao 'To Dentro'");
        salvarEvidencia("Tocar no botao 'To Dentro'");
        tocarElemento(aceitar, "N�o foi poss�vel tocar no bot�o 'To Dentro'");
        return this;
    }



}
