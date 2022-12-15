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

    //botão criar vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_create_vaquinha")
    @iOSXCUITFindBy(id = "Criar vaquinha")
    private MobileElement botaoCriarVaquinha;

    //botão + add vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_new_vaquinha")
    @iOSXCUITFindBy(accessibility = "Adicionar")
    @iOSXCUITFindBy(id = "item_new_vaquinha")
    private MobileElement botaoAdicionarVaquinha;

    //botão + excluir vaquinha lixeira

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

    //Aceitar termo e condições vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Aceitar\"`]")
    private MobileElement botaoAceitaTermoCondicoesVaquinha;

    //Fechar tela de termoe e condições
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(id = "Central de Relacionamento Next:")
    private MobileElement botaoFecharTelaTermoCondicoes;

    //Titulo da tela de termo e condições
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//*[@name = \"TERMOS E CONDIÇÕES\"]")
    private MobileElement tituloTelaTermoCondicoesVaquinha;

    //Botão Continuar tela de vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement botaoContinuarTelaVaquinha;

    //Botão Continuar proximo
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    private MobileElement botaoProximo;

    //Dar um nome para vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name_vaquinha")
    @iOSXCUITFindBy(accessibility = "Meu nome é")
    private MobileElement labelDarNomeVaquinha;

    //Label "quanto" vai pagar na vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_qnt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Valor por pessoa\"]")
    @iOSXCUITFindBy(id = "et_value")
    private MobileElement labelQuantoPagarVaquinha;

    //Até "quando" pagar a vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = " br.com.bradesco.next:id/et_qnd")
    @iOSXCUITFindBy(id = "date_limit")
    private MobileElement labelAteQuandoVaquinha;

    //Botão Continuar ate quando vai pagar
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(id = "Continuar")
    private MobileElement botaoContinuarQuandoVaquinha;

    //Botao confirmar data de agendamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "//android.widget.ImageView[@content-desc=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmarDataAgendamentoVaquinha;

    //Botão contatos
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

    //Radio Button instituição pagadora vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_institutional")
    @iOSXCUITFindBy(id = "rb_type_institutional")
    private MobileElement radioButtonInstituiçãoPgtoContatoVaquinha;

    //Combo banco e intituição contato vaquinha
    @AndroidFindBy(id = "//android.widget.LinearLayout[@content-desc=\"Banco ou Instituição\"]/android.widget.RelativeLayout")
    @iOSXCUITFindBy(accessibility = "Banco ou Instituição")
    private MobileElement comboBancoInstituiçãoContatoVaquinha;

    //Label agencia contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_agency")
    @iOSXCUITFindBy(accessibility = "Agência")
    private MobileElement labelAgenciaContatoVaquinha;

    //Conta tela contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_account")
    @iOSXCUITFindBy(accessibility = "Conta e dígito")
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

    //Botão fechar tela esclher contado vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "animated_view")
    private MobileElement botaoFecharTelaEscolherContatoVaquinha;

    //Botão adicionar banco contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_add_remove")
    @iOSXCUITFindBy(accessibility = "ADICIONAR")
    private MobileElement botaoAddBancoContatoVaquinha;

    //Botão adicionar vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_new_vaquinha")
    @iOSXCUITFindBy(accessibility = "Adicionar")
    private MobileElement botaoAdicionarMaisUmaVaquinha;

    //Botão salvar banco contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @iOSXCUITFindBy(accessibility = "bt_save")
    private MobileElement botaoSalvarBancoContatoVaquinha;

    //Botão editar contato vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @iOSXCUITFindBy(accessibility = "Editar contato")
    private MobileElement botaoEditarContatoVaquinha;

    //Tab Nov Contato Vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Aba Autorizados selecionada")
    private MobileElement tabNovoContatoVaquinha;

    //Tab Contato Vaquinha
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_tab_all")
    @iOSXCUITFindBy(accessibility = "Aba Todos, Botão")
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

    //excluir vaquinha confirmação
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"mês\")]")
    private MobileElement labelMesAgenda;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Fechar, Botão")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Fechar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_more")
    @AndroidFindBy(accessibility = " Adicionar, botão")
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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Salvar edição\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Salvar edição\"]")
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
    @AndroidFindBy(accessibility = "Menu, Botão")
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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Não, valeu\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Não, valeu\" AND name == \"Não, valeu\" AND type == \"XCUIElementTypeButton\"")
    private MobileElement recusar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_accept")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Tô dentro']")
    private MobileElement aceitar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name_vaquinha")
    @iOSXCUITFindBy(accessibility = "lb_card_title")
    private MobileElement tituloVaquinha;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Próximo\"]")
    private MobileElement botaoProximoTeclado;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Salvar\"`]")
    private MobileElement botaoSalvar;

    @AndroidFindBy(accessibility = "Adicionar, botão")
    @iOSXCUITFindBy(accessibility = "rightListButton")
    private MobileElement botaoMais;

    public VaquinhaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar no botão 'Criar vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"criar vaquinha\"")
    public VaquinhaTela tocarBotaoCriarVaquinha() throws Exception {
        aguardarPaginaConterTodosTextos("VAQUINHA");
        if (verificarPresencaElemento(botaoAdicionarMaisUmaVaquinha)) {
            aguardarCarregamentoElemento(botaoAdicionarMaisUmaVaquinha);
            tocarElemento(botaoAdicionarMaisUmaVaquinha, "Não foi possível clicar no botão 'Add Vaquinha'");
            salvarEvidencia("Clicar no botão 'Add vaquinha'");
        }
        esperarCarregando();
        aguardarCarregamentoElemento(botaoCriarVaquinha);
        salvarEvidencia("Clicar no botão 'criar vaquinha'");
        tocarElemento(botaoCriarVaquinha, "Não foi possível clicar no botão criar vaquinha, o CPF utilizado já possui vaquinhas criadas");
        return this;
    }

    /**
     * Clicar botão 'Add Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"ADD VAquinha\"")
    public VaquinhaTela tocarBotaoAdicionarVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoAdicionarMaisUmaVaquinha);
        tocarElemento(botaoAdicionarMaisUmaVaquinha, "Não foi possível clicar no botão 'Add Vaquinha'");
        salvarEvidencia("Clicar no botão 'Add vaquinha'");
        return this;
    }

    /**
     * Clicar botão 'Excluir Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"excluir Vaquinha\"")
    public VaquinhaTela tocarBotaoExcluirVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoExcluirVaquinha);
        salvarEvidencia("Clicar no botão 'excluir vaquinha'");
        if (ios)
            if (verificarPresencaElemento(botaoExcluirVaquinha))
                tocarElemento(botaoExcluirVaquinha, "Não foi possível clicar no botão 'Excluir Vaquinha'");
            else
                tocarCoordenadaProporcional(By.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton"), 99, 50);
        else
            tocarElemento(botaoExcluirVaquinha, "Não foi possível clicar no botão 'Excluir Vaquinha'");
        return this;
    }

    /**
     * Clicar botão 'Excluir Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Confirma excluir Vaquinha\"")
    public VaquinhaTela tocarBotaoConfirmaExcluirVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoExcluirVaquinha);
        salvarEvidencia("Clicar no botão 'Confirma excluir vaquinha'");
        if (android) {
            tocarElemento(botaoConfirmaExcluirVaquinha, "Não foi possível clicar no botão 'Confirma Excluir Vaquinha'");
        } else {
            tocarCoordenadaProporcional(92, 5);
        }
        return this;
    }

    /**
     * Tocar botão Excluir Vaquinha
     */
    @Step("Tocar botão Excluir Vaquinha")
    public VaquinhaTela tocarBotaoExcluir() throws Exception {
        aguardarCarregamentoElemento(editExcluirContatoVaquinha);
        salvarEvidencia("Clicar no botão 'Confirma excluir vaquinha'");
        tocarElemento(editExcluirContatoVaquinha, "Não foi possível clicar no botão 'Confirma Excluir Vaquinha'");
        esperarCarregando();
        return this;
    }

    /**
     * Clicar botão 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public VaquinhaTela tocarBotaoFechar() throws Exception {
        salvarEvidencia("Tocar no botão 'Fechar'");
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "Não foi possível tocar no botão Fechar");
        esperarCarregando();
        aguardarCarregamentoElemento(botaoAdicionarMaisUmaVaquinha);
        esperarCarregando();
        return this;
    }

    /**
     * Tocar botão 'Apagar Card'
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Apagar Card\"")
    public VaquinhaTela tocarBotaoApagarCard() throws Exception {
        esperarCarregando();
        aguardarCarregamentoElemento(botaoApagarCard);
        salvarEvidencia("Tocar no botão 'Apagar Card'");
        tocarElemento(botaoApagarCard, "Não foi possível tocar no botão Apagar Card");
        return this;
    }

    /**
     * Tocar Card Vaquinha
     */
    public VaquinhaTela tocarCardVaquinha() throws Exception {
        aguardarCarregamentoElemento(cardVaquinha);
        tocarElemento(cardVaquinha, "Não foi possível tocar no card da Vaquinha");
        salvarEvidencia("Tocar card vaquinha");
        return this;
    }

    /**
     * Tocar botão Lista
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botão Lista")
    public VaquinhaTela tocarBotaoLista() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(listaVaquinha);
        salvarEvidencia("Tocar no botão 'lista");
        tocarElemento(listaVaquinha, "Não foi possível tocar no botão lista");
        return this;
    }

    /**
     * Tocar botão Excluir
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botão Excluir Vaquinha")
    public VaquinhaTela tocarBotaoExcluirVaq() throws Exception {

        salvarEvidencia("Tocar no botão 'excluir");
        aguardarExistenciaElemento(botaoExcluir);
        tocarElemento(botaoExcluir, "Não foi possível tocar no botão excluir");
        if (ios && verificarPresencaElemento(botaoExcluir)) // toca no botão novamente se tocarElemento não refletir (problema ocorrendo em alguns iOS)
            tocarCoordenadaProporcional(By.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton"), 99, 50);
        return this;

    }

    /**
     * Tocar no botão 'continuar vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botão \" + continuar vaquinha\"")
    public VaquinhaTela tocarContinuarVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoContinuarTelaVaquinha);
        salvarEvidencia("Tocar no botão 'continuar");
        tocarElemento(botaoContinuarTelaVaquinha, "Não foi possível tocar no botão continuar");
        return this;
    }

    /**
     * Tocar no botão 'quanto pagar de vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar label \" + label quanto\"")
    public VaquinhaTela tocarLabelQuanto(String valorVaquinha) throws Exception {
        aguardarCarregamentoElemento(labelQuantoPagarVaquinha);
        salvarEvidencia("Tocar no label 'Valor da Vaquinha");
        escreverTexto(labelQuantoPagarVaquinha, valorVaquinha, "Não foi possível tocar no label valor da vaquinha");
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
                //Por algum motivo, nesse campo, o método escreverTexto() do framework estava apresentando erro. Essa implementação deve ser alterada,
                //assim que o problema com o método do framework for solucionado.
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
     * Clicar no botão 'quanto pagar de vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Informar valor vaquinha")
    public VaquinhaTela informaValorVaquinha(String valorVaquinha) throws Exception {
        aguardarCarregamentoElemento(labelQuantoPagarVaquinha);
        escreverTexto(labelQuantoPagarVaquinha, valorVaquinha, "Não foi possível clicar no label valor da vaquinha");
        salvarEvidencia("Preencher campo \"Valor da Vaquinha\"");
        return this;
    }

    /**
     * Validar mensagem de valor máximo permitido
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Validar mensagem de valor máximo permitido")
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
        tocarElemento(editDataVaquinha, "Não foi possível tocar no label data da vaquinha");
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
        //Separa a data de entrada em dia, mês e ano
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        //Dicionario relacionando mes com nome em português
        HashMap<String, String> relacaoMes = new HashMap<String, String>();
        relacaoMes.put("01", "Janeiro");
        relacaoMes.put("02", "Fevereiro");
        relacaoMes.put("03", "Março");
        relacaoMes.put("04", "Abril");
        relacaoMes.put("05", "Maio");
        relacaoMes.put("06", "Junho");
        relacaoMes.put("07", "Julho");
        relacaoMes.put("08", "Agosto");
        relacaoMes.put("09", "Setembro");
        relacaoMes.put("10", "Outubro");
        relacaoMes.put("11", "Novembro");
        relacaoMes.put("12", "Dezembro");
        // substitui valor numérico de mês por nome
        String mesNome = relacaoMes.get(mes);

        if (ios) {
            // data a ser buscada ao deslizar a tela em busca do mês desejado
            By dataPadrao = By.xpath("//XCUIElementTypeCell[contains(@name,'15 de " + mesNome.toLowerCase() + " de " + ano + "')]");
            // data a ser selecionada no calendário
            By dataDesejada = By.xpath("//XCUIElementTypeCell[contains(@name,'" + dia + " de " + mesNome.toLowerCase() + " de " + ano + "')]");
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(dataPadrao,
                    "Não foi possível encontrar o elemento " + dataDesejada + "");
            tocarElemento(dataDesejada, "Não foi possível selecionar a Data");
            OperadorEvidencia.logarPasso("Dia " + dia + " selecionado");
        } else {
            // data a ser selecionada no calendário
            By dataDesejada = By.xpath("//android.view.View[contains(@content-desc,'" + ano + "-" + mes + "-" + dia + "')]");
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(dataDesejada, "Não foi possível encontrar o elemento " + dataDesejada + "");
            tocarElemento(dataDesejada, "Não foi possível selecionar a Data");
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
    @Step("Tocar botão \"Confirmar\"")
    public VaquinhaTela tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        tocarElemento(botaoConfirmar, "Não foi possível tocar em Confirmar");
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
            tocarElemento(botaoSelecionar, "Não foi possível selecionar vaquinha existente");
        } else {
            tocarBotaoSelecionarVaquinha();
        }
        return this;
    }

    /**
     * Tocar botão 'Perfil'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar no botão \"perfil\"")
    public VaquinhaTela tocarBotaoPerfil() throws Exception {
        esperarCarregando();
        aguardarCarregamentoElemento(botaoPerfil);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPerfil, "Não foi possível encontrar o elemento " + botaoPerfil + "");
        salvarEvidencia("Tocar no botão 'Perfil'");
        tocarElemento(botaoPerfil, "Não foi possível tocar no botão 'Perfil'");
        return this;
    }

    /**
     * Tocar botão editar 'Perfil'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar no botão \"perfil\"")
    public VaquinhaTela tocarBotaoEditarPerfil() throws Exception {
        aguardarCarregamentoElemento(botaoEditarPerfil);
        salvarEvidencia("Tocar no botao 'Editar Perfil'");
        if (ios) {
            if (!verificarPresencaElemento(botaoEditarPerfil))
                tocarCoordenadaProporcional(By.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton"), 99, 50);
            else
                tocarElemento(botaoEditarPerfil, "Não foi possível tocar no botão 'Editar Perfil'");
        } else
            tocarElemento(botaoEditarPerfil, "Não foi possível tocar no botão 'Editar Perfil'");
        return this;
    }

    /**
     * Tocar botão editar 'Imagem'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar no botão editar \"imagem\"")
    public VaquinhaTela tocarBotaoEditarImagem() throws Exception {
        aguardarCarregamentoElemento(botaoEditarImagem);
        salvarEvidencia("Tocar no botao 'Editar Imagem'");
        tocarElemento(botaoEditarImagem, "Não foi possível tocar no botão 'Editar Imagem'");
        return this;
    }

    /**
     * Tocar botão alterar 'Imagem'
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
            tocarElemento(botaoAlterarImagem, "Não foi possível tocar no botão 'Alterar Imagem'");
        return this;
    }

    /**
     * Tocar botão salvar edição'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar alterar \"imagem\"")
    public VaquinhaTela tocarBotaoSalvarEdicao() throws Exception {
        aguardarCarregamentoElemento(botaoContinue);
        salvarEvidencia("Tocar no botao 'Salvar Edicao'");
        tocarElemento(botaoContinue, "Não foi possível tocar no botão 'Continue'");
        return this;
    }

    /**
     * Tocar botão alterar nome
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar alterar \"nome\"")
    public VaquinhaTela tocarBotaoEditarNome() throws Exception {
        aguardarCarregamentoElemento(botaoEditNome);
        salvarEvidencia("Tocar no botao 'Editar nome'");
        tocarElemento(botaoEditNome, "Não foi possível tocar no botao 'Editar nome'");
        return this;
    }

    /**
     * Tocar botão alterar 'Imagem'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar alterar \"data\"")
    public VaquinhaTela tocarBotaoEditarData() throws Exception {
        aguardarCarregamentoElemento(botaoAlterarData);
        salvarEvidencia("Tocar no botao 'Alterar Data'");
        tocarElemento(botaoAlterarData, "Não foi possível tocar no botão 'Alterar data'");
        return this;
    }

    /**
     * Tocar no ícone 'Menu'
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
        tocarElemento(botaoMenu, "Não foi possível clicar no botão Menu");
        return this;
    }

    /**
     * Clicar no botão 'Aceitar'
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
        tocarElemento(botaoAceitaTermoCondicoesVaquinha, "Não foi possível tocar no botão 'Aceitar'");
        salvarEvidencia("Tocar no botao aceitar'");
        return this;
    }

    /**
     * Clicar no botão 'Continuar'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar no botao 'Continuar'")
    public VaquinhaTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "Não foi possível clicar no botão 'Continuar'");
        salvarEvidencia("Tocar no botão 'Continuar'");
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
            apagarCampoTexto(alteraNome, "Não foi possível apagar o conteúdo do campo 'NOME DA VAQUINHA'!");
            escreverTexto(alteraNome, nomeVaquinhaAlterada, "não foi possível escrever nome vaquinha");
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
    @Step("tocar botão convidar")
    public VaquinhaTela tocarConvidar() throws Exception {

        salvarEvidencia("tocar botão convidar");
        rolaTelaBaixo();
        rolaTelaBaixo();
        tocarElemento(convidar, "Não foi possível tocar no botão convidar");
        esperarCarregando();
        return this;
    }

    /**
     * tocar botao continuar
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("tocar botão contiunar")
    public VaquinhaTela tocarContinuar() throws Exception {

        salvarEvidencia("tocar botão continuar");
        tocarElemento(continuar, "Não foi possível tocar no botão continuar");
        esperarCarregando();
        return this;
    }

    /**
     * tocar botao recusar vaquinha
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("tocar botão recusar vaquinha")
    public VaquinhaTela tocarBotaoRecusarVaquinha() throws Exception {
        aguardarPaginaConterTodosTextos("VAQUINHA");
        salvarEvidencia("tocar botão recusar vaquinha");
        rolaTelaBaixo();
        aguardarCarregamentoElemento(recusar);
        if (ios) {
            tocarCoordenadaElemento(recusar);
        } else {
            tocarElemento(recusar, "Não foi possível tocar no botão recusar vaquinha");
        }
        return this;
    }

    /**
     * tocar botao selecionar vaquinha
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("tocar botão selecionar vaquinha")
    public VaquinhaTela tocarBotaoSelecionarVaquinha() throws Exception {
        aguardarCarregamentoElemento(tituloVaquinha);
        salvarEvidencia("tocar botão selecionar vaquinha");
        tocarElemento(tituloVaquinha, "Não foi possível tocar no botão selecionar vaquinha");
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
                throw new NextException("Não foi possível achar a vaquinha", new Exception());
            }
        }
        salvarEvidencia("Deslizar até encontrar vaquinha: "+ nomeVaquinha);
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
     * Clicar no botão 'quanto pagar de vaquinha'
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
                throw new NextException("Não foi possível clicar no label valor da vaquinha", e);
            }
        } else {
            escreverTexto(labelQuantoPagarVaquinha, valorVaquinha, "Não foi possível digitar valor da vaquinha");
        }
        salvarEvidencia("Digitar 'Valor da Vaquinha': " + valorVaquinha);
        return this;
    }


    /**
     * Tocar botão salvar
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao 'Salvar'")
    public VaquinhaTela tocarBotaoSalvar() throws Exception {
        aguardarCarregamentoElemento(botaoSalvar);
        salvarEvidencia("Tocar no botao 'Salvar'");
        tocarElemento(botaoSalvar, "Não foi possível tocar no botão 'Salvar'");
        return this;
    }

    /**
     * Validar presença da tela 'Vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Validar tela 'Vaquinha'")
    public VaquinhaTela validarTelaVaquinha() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.VAQUINHA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Vaquinha' não está presente na tela!");
        salvarEvidencia("Validar presença do título 'Vaquinha'");
        return this;
    }

    /**
     * Tocar botão (+) 'Adicionar Vaquinha'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao (+) 'Adicionar Vaquinha'")
    public VaquinhaTela tocarAdicionarVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoAdicionarVaquinha);
        salvarEvidencia("Tocar no botao (+) 'Adicionar Vaquinha'");
        tocarElemento(botaoAdicionarVaquinha, "Não foi possível tocar no botão (+) 'Adicionar Vaquinha'");
        return this;
    }

    /**
     * Validar efetivação de vaquinha
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Validar efetivação de vaquinha")
    public VaquinhaTela validarEfetivacaoVaquinha() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Vaquinha.MENSAGEM_SUA_VAQUINHA_TA_PRONTA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Sua vaquinha tá pronta!' não está presente na tela!");
        salvarEvidencia("Validar presença da mensagem 'Sua vaquinha tá pronta!'");
        return this;
    }

    /**
     * Tocar botão (+) 'Mais' e/ou 'Lista'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao (+) 'Mais' e/ou 'Lista'")
    public VaquinhaTela tocarBotaoMais() throws Exception {
        aguardarCarregamentoElemento(botaoMais);
        salvarEvidencia("Tocar no botao (+) 'Mais' e/ou 'Lista'");
        tocarElemento(botaoMais, "Não foi possível tocar no botão (+) 'Mais' e/ou 'Lista'");
        return this;
    }

    /**
     * Tocar botão Excluir Vaquinha Criada
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao Excluir Vaquinha Criada")
    public VaquinhaTela tocarBotaoExcluirVaquinhaCriada() throws Exception {
        aguardarCarregamentoElemento(botaoExcluirVaquinha);
        salvarEvidencia("Tocar no botao Excluir Vaquinha Criada");
        tocarElemento(botaoExcluirVaquinha, "Não foi possível tocar no botão (Excluir Vaquinha Criada");
        return this;
    }

    /**
     * Validar Vaquinha Cancelada e/ou Excluída
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Validar Vaquinha Cancelada e/ou Excluída")
    public VaquinhaTela validarVaquinhaCancelada() throws Exception {
        if(android){
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Vaquinha.MENSAGEM_VAQUINHA_CANCELADA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Vaquinha Cancelada!' não está presente na tela!");
            salvarEvidencia("Validar presença da mensagem 'Vaquinha Cancelada!'");
        }
        else {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Vaquinha.MENSAGEM_VAQUINHA_EXCLUIDA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Vaquinha Excluída!' não está presente na tela!");
            salvarEvidencia("Validar presença da mensagem 'Vaquinha Excluída!'");
        }
        return this;
    }

    /**
     * Tocar botão 'Fechar'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao 'Fechar'")
    public VaquinhaTela tocarNoBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no botao 'Fechar'");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão 'Fechar'");
        return this;
    }

    /**
     * Tocar botão Contatos
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao 'Contatos'")
    public VaquinhaTela tocarBotaoContatos() throws Exception {
        aguardarCarregamentoElemento(botaoContatosVaquinha);
        salvarEvidencia("Tocar no botao 'Contatos'");
        tocarElemento(botaoContatosVaquinha, "Não foi possível tocar no botão 'Contatos'");
        return this;
    }

    /**
     * Tocar botão 'To dentro'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao 'To Dentro'")
    public VaquinhaTela tocarBotaoToDentro() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(aceitar, "Não foi possível tocar botao 'To Dentro'");
        salvarEvidencia("Tocar no botao 'To Dentro'");
        tocarElemento(aceitar, "Não foi possível tocar no botão 'To Dentro'");
        return this;
    }



}
