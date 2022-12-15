package pagina.mobile.jornadas.seguros;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacao;

import constantes.seguros.ParticipantesProtecaoOdonto;
import constantes.seguros.Protecao;
import constantes.seguros.ProtecaoCartaoDebito;
import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSecaoProtecao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

public class ProtecaoTela extends PaginaBase {

    //Botão confirmar - calendario
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system_option")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmarCalendario;

    //Botão de voltar
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement headerBotaoVoltar;

    //Título do Header
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTitulo;

    //Título do Header Confirmação
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONFIRMAÇÃO\"]")
    private MobileElement headerTituloConf;

    //Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/background_card_protection")
    //@iOSXCUITFindBy()
    private MobileElement card;

    //Título - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtTitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"chip\"])[3]/XCUIElementTypeOther")
    private MobileElement tituloCard;

    //Título - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Plano Dental\"]")
    private MobileElement tituloCardDetalhes;

    //Título - Confirmação
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title_insurance")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement tituloCardConfirmacao;

    //Subtítulo - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtSubtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"subtitleLabel\"])[2]")
    private MobileElement subtituloCard;

    //Subtítulo - Card - Detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtSubtitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tenha mais motivos para sorrir\"]")
    private MobileElement subtituloCardDetalhes;

    //Subtítulo - Card Detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_subtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[3]")
    private MobileElement subtituloCardAberto;

    //Ícone - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_insurance")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//following-sibling::XCUIElementTypeImage | //XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//..//XCUIElementTypeCell//XCUIElementTypeImage[@visible='true'])[1]")
    private MobileElement iconeCard;

    //Descrição - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDescription")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[5]")
    private MobileElement descricaoCard;

    //Descrição - Card Detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_description")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[4]")
    private MobileElement descricaoCardAberto;

    //Descrição - Card Detalhes Odonto
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tenha mais motivos para sorrir\"]")
    private MobileElement descricaoCardOdonto;

    //Descrição Valor - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_value_description_protection")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView[@name=\"collectionView\"])[1]/XCUIElementTypeCell[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement descricaoValorCard;

    //Label Valor - Card - iOS
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText)[2]")
    private MobileElement labelValorCardiOS;

    //Label Valor - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/coverage_label")
    private MobileElement labelValorCard;

    //Valor - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/coverage_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"valueLabel\"])[2]")
    private MobileElement valorCard;

    //Botão "Detalhes"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnDetails")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"DETALHES\" and @visible='true'])[1]")
    private MobileElement botaoDetalhes;

    //botão "Simular" - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_accept")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SIMULAR\"`][2]")
    private MobileElement botaoSimularCard;

    //botão "Contratar" - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_action_button_label")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CONTRATAR\"])[1]")
    private MobileElement botaoContratarCard;

    //botão "Contratar" - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_accept")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CONTRATAR\"])[1]")
    private MobileElement botaoContratarCardDetalhes;

    //Aba "Contratados" - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtMoreInfo")
    @iOSXCUITFindBy(accessibility = "CONTRATADOS")
    private MobileElement abaContratadosCard;

    //Aba "Contratados" - Card "Sem Seguros"
    @AndroidFindBy(id = "br.com.bradesco.next:id/noSelectedInsurancesList")
    //@iOSXCUITFindBy()
    private MobileElement abaContratadosCardSemSeguros;

    //Tela de Participantes - Radio "Apenas Dependentes"
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout")
    private MobileElement participantesRadioApenasDependentes;

    //Tela de Participantes - Botão Diminuir
    @AndroidFindBy(id = "br.com.bradesco.next:id/left_img")
    private MobileElement diminuirParticipante;

    //Tela de Participantes - Botão Aumentar
    @AndroidFindBy(id = "br.com.bradesco.next:id/right_img")
    private MobileElement aumentarParticipante;

    //Tela de Participantes - Número de Dependentes
    @AndroidFindBy(id = "br.com.bradesco.next:id/number_et")
    private MobileElement numeroDependentes;

    //Aba "Contratados" - Card "Sem Seguros" - Ícone
    @AndroidFindBy(id = "br.com.bradesco.next:id/imageView11")
    //@iOSXCUITFindBy()
    private MobileElement iconeAbaContratadosCardSemSeguros;

    //Aba "Contratados" - Card "Sem Seguros" - Título
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    //@iOSXCUITFindBy()
    private MobileElement tituloAbaContratadosCardSemSeguros;

    //Aba "Contratados" - Card "Sem Seguros" - Texto
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    //@iOSXCUITFindBy()
    private MobileElement textoAbaContratadosCardSemSeguros;

    //Aba "Contratados" - Card Seguro Contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/topContent")
    //@iOSXCUITFindBy()
    private MobileElement cardSeguroContratado;

    //Aba "Contratados" - Ícone Seguro Contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_contracted_insurance")
    //@iOSXCUITFindBy()
    private MobileElement iconeSeguroContratado;

    //Aba "Contratados" - Status Seguro Contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtStatus")
    //@iOSXCUITFindBy()
    private MobileElement statusSeguroContratado;

    //Aba "Informações do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_active_insurance")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"INFORMAÇÕES DO PRODUTO\"])[1]")
    private MobileElement abaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Descrição
    @AndroidFindBy(id = "br.com.bradesco.next:id/insuranceTopicsDescription")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Informações do produto')]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement descricaoAbaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Collapse Cobertura
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[1]/android.widget.LinearLayout/android.widget.RelativeLayout")
    @iOSXCUITFindBy(accessibility = "Cobertura Expandir")
    private MobileElement collapseCoberturaAbaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Collapse Carencia
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[2]/android.widget.LinearLayout/android.widget.RelativeLayout")
    @iOSXCUITFindBy(accessibility = "Carência Expandir")
    private MobileElement collapseCarenciaAbaInformacoesDoSeguro;

    @AndroidFindBy(id = "br.com.bradesco.next:id/txtInsuranceName")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[1]")
    private MobileElement labelPlanoConfirmacaoDeDados;

    //Aba "Informações do Seguro" - Collapse Dados do Parceiro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[3]/android.widget.LinearLayout/android.widget.RelativeLayout")
    @iOSXCUITFindBy(accessibility = "Dados do parceiro Expandir")
    private MobileElement collapseDadosParceiroAbaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Collapse - Cobertura - Texto
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Cobertura")
    private MobileElement textoCollapseCoberturaAbaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Collapse - Carência - Texto
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    //@iOSXCUITFindBy()
    private MobileElement textoCollapseCarenciaAbaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Collapse - Dados Parceiro - Texto
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    //@iOSXCUITFindBy()
    private MobileElement textoCollapseDadosParceiroAbaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Collapse - Cobertura - Seta
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"expandir\"`][3]")
    private MobileElement setaCollapseAbaCoberturaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Collapse - Carência - Seta
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"expandir\"`][2]")
    private MobileElement setaCollapseAbaCarenciaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Collapse - Dados do Parceiro - Seta
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"expandir\"`][1]")
    private MobileElement setaCollapseDadosParceiroAbaInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Collapse - Texto Interno
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_item")
    //@iOSXCUITFindBy(Não é possível mapear no momento)
    private MobileElement textoInternoCollapseAbaInformacoesDoSeguro;

    //Aba "Detalhes/Informações do Seguro" - Rodapé
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_insurance_details_footer")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement rodapeDetalhesSecaoInformacoesDoSeguro;

    //Aba "Confirmacao de dados/Informações do Seguro" - Rodapé
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDetailsFooter")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONTRATAR\"]/../../../../XCUIElementTypeOther)[2]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    private MobileElement rodapeConfirmacaoDeDadosSecaoInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Botão "Simular"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_accept_2")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"SIMULAR\" or @name=\"CONTRATAR\"])[2]")
    private MobileElement segundoBotaoSimularContratarCard;

    //Aba "Informações do Seguro" - Botão "Contratar"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnAccept2")
    @iOSXCUITFindBy(iOSClassChain = "(//XCUIElementTypeButton[@name=\"CONTRATAR\"])[2]")
    private MobileElement segundoBotaoContratarCard;

    //Tela de Contratação - Ícone
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView")
    //@iOSXCUITFindBy()
    private MobileElement iconeTelaContratacao;

    //Tela de Contratação - Texto
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_info_message")
    //@iOSXCUITFindBy()
    private MobileElement textoTelaContratacao;

    //Tela de Contratação - Rodapé
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_info_message_footer")
    //@iOSXCUITFindBy()
    private MobileElement rodapeTelaContratacao;

    //Tela de Contratação - Botão "Continuar"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnContinue")
    //@iOSXCUITFindBy()
    private MobileElement botaoContinuarTelaContratacao;

    //Tela de Seleção de Segurados - Título do Header
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloHeaderTelaSelecaoSegurados;

    //Tela Confirmacao cancelamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"PROTEÇÃO\"`]")
    private MobileElement tituloHeaderTelaConfirmacaoCancelamento;

    //Tela de Seleção de Segurados - Botão de Informações
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_info")
    //@iOSXCUITFindBy()
    private MobileElement botaoInformacoesTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Título
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_info_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement tituloTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - texto "Para quem?"
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    //@iOSXCUITFindBy()
    private MobileElement textoParaQuemTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Radio "Pra mim"
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_dental_for_me")
    //@iOSXCUITFindBy()
    private MobileElement radioPraMimTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Radio "Pra mim e dependentes"
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_dental_has_dependents")
    //@iOSXCUITFindBy()
    private MobileElement radioPraMimEDependentesTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Radio "Apenas Dependentes"
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_dental_only_dependents")
    //@iOSXCUITFindBy()
    private MobileElement radioApenasDependentesTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Texto Informativo
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    //@iOSXCUITFindBy()
    private MobileElement textoInformativoTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Descrição do valor
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[3]")
    //@iOSXCUITFindBy()
    private MobileElement descricaoValorTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Valor
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_month_value")
    //@iOSXCUITFindBy()
    private MobileElement valorTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Label Adicionar Dependentes
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
    //@iOSXCUITFindBy()
    private MobileElement labelAdicionarDependentesTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Quantidade Atual
    @AndroidFindBy(id = "br.com.bradesco.next:id/number_et")
    private MobileElement quantidadeAtualTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Diminuir
    @AndroidFindBy(id = "br.com.bradesco.next:id/left_img")
    private MobileElement diminuirTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Aumentar
    @AndroidFindBy(id = "br.com.bradesco.next:id/right_img")
    //@iOSXCUITFindBy()
    private MobileElement aumentarTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Botão "Próximo"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnNext")
    //@iOSXCUITFindBy()
    private MobileElement botaoProximoTelaSelecaoSegurados;

    //Tela de Confirmação - Label Campo
    @AndroidFindBy(id = "br.com.bradesco.next:id/fl_container_optional")
    //@iOSXCUITFindBy()
    private MobileElement labelCampoTelaConfirmacao;

    //Tela de Confirmação - Campo "Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtInsuranceName")
    //@iOSXCUITFindBy()
    private MobileElement campoSeguroTelaConfirmacao;

    //Tela de Confirmação - Campo "Número de Pessoas Beneficiadas"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtBeneficiariesQuantity")
    //@iOSXCUITFindBy()
    private MobileElement campoNoPessoasBeneficiadasTelaConfirmacao;

    //Tela de Confirmação - Texto Radio Grupo
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_details_dental_type_payment")
    //@iOSXCUITFindBy()
    private MobileElement textoRadioGrupoTelaConfirmacao;

    //Tela de Confirmação - Linha Horizontal
    @AndroidFindBy(id = "br.com.bradesco.next:id/view_line")
    //@iOSXCUITFindBy()
    private MobileElement linhaHorizontalTelaConfirmacao;

    //Label - Tipo de Pagamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_details_dental_type_payment")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"TIPO DE PAGAMENTO\"`]")
    private MobileElement   labelTipoPagamento;

    //Radio - Tipo de Pagamento - Mensal
    @AndroidFindBy(id = "br.com.bradesco.next:id/month_checker")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[1]")
    private MobileElement   radioButtonTipoPagamentoMensal;

    //Label Radio - Tipo de Pagamento - Mensal
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Selecionado,Mensal,botão de seleção,\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[1]")
    private MobileElement labelRadioButtonTipoPagamentoMensal;

    //Radio - Tipo de Pagamento - Anual
    @AndroidFindBy(id = "br.com.bradesco.next:id/annual_checker")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[2]")
    private MobileElement radioButtonTipoPagamentoAnual;

    //Label Radio - Tipo de Pagamento - Anual
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\",Não selecionado,Anual com desconto,botão de seleção,\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[2]")
    private MobileElement labelRadioButtonTipoPagamentoAnual;

    //Valor Radio - Tipo de Pagamento - Mensal
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[1]")
    private MobileElement valorRadioButtonTipoPagamentoMensal;

    //Valor Radio - Tipo de Pagamento - Anual
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[2]")
    private MobileElement valorRadioButtonTipoPagamentoAnual;

    //Label Data do Pagamento
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"DATA DO PAGAMENTO\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[3]")
    private MobileElement labelDataPagamento;

    //Tela de Confirmação - Radio Button
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_circle")
    //@iOSXCUITFindBy()
    private MobileElement radioButtonTelaConfirmacao;

    //Tela de Confirmação - Descrição Radio Button
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    //@iOSXCUITFindBy()
    private MobileElement descricaoRadioButtonTelaConfirmacao;

    //Tela de Confirmação - Label "Valor Total"
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"VALOR TOTAL\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[5]")
    private MobileElement labelValorTotal;

    //Tela de Confirmação - Label "Vigência"
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"VIGÊNCIA\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeTextView")
    private MobileElement labelVigencia;

    //Tela de Confirmação - Valor Radio Button
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text_bottom")
    //@iOSXCUITFindBy()
    private MobileElement valorRadioButtonTelaConfirmacao;

    //Tela de Confirmação - Campo "Data do Pagamento"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtPaymentDay")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[3]")
    private MobileElement campoDataPagamentoTelaConfirmacao;

    //Tela de Confirmação - Campo "Forma de Pagamento"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtPaymentForm")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[4]")
    private MobileElement campoFormaPagamentoTelaConfirmacao;

    //Tela de Confirmação - Campo "Valor Total"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtTotalValue")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[5]")
    private MobileElement campoValorTotalTelaConfirmacao;

    //Tela de Confirmação - Campo "Vigência"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtVigency")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeTextView")
    private MobileElement campoVigenciaTelaConfirmacao;

    //Tela de Confirmação - Checkbox
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_confirm_checkbox_terms")
    @AndroidFindBy(id = "br.com.bradesco.next:id/debito_confirm_checkbox_terms")
    //@iOSXCUITFindBy()
    private MobileElement checkboxTelaConfirmacao;

    //Tela de Confirmação - Botão "?" (No IOS o botão de "?" equivale ao botão ">")
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_confirm_checkbox_terms")
    @iOSXCUITFindBy(accessibility = "avançar")
    private MobileElement botaoInterrogacaoTelaConfirmacao;

    //Tela de Confirmação - Texto Aceite
    @AndroidFindBy(id = "br.com.bradesco.next:id/webview")
    //@iOSXCUITFindBy()
    private MobileElement textoAceiteTelaConfirmacao;

    //Tela de Confirmação - Aba "Informações do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_info")
    //@iOSXCUITFindBy()
    private MobileElement abaInformacoesDoSeguroTelaConfirmacao;

    //Tela de Confirmação - Botão "Contratar"
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_btn_hire")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONTRATAR\"`]")
    private MobileElement botaoContratarOdontoTelaConfirmacao;

    //Tela de Sucesso - Ícone
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView")
    //@iOSXCUITFindBy()
    private MobileElement iconeTelaSucesso;

    //Tela de Sucesso - Título
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_cancellation_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloTelaSucesso;

    //Tela de Sucesso - Descrição
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_contracting_success_description")
    //@iOSXCUITFindBy()
    private MobileElement descricaoTelaSucesso;

    //Tela de Sucesso - Site
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[3]")
    //@iOSXCUITFindBy()
    private MobileElement siteTelaSucesso;

    //Tela de Sucesso - Texto Proposta
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[4]")
    //@iOSXCUITFindBy()
    private MobileElement textoPropostaTelaSucesso;

    //Tela de Sucesso - Número da Proposta
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_contracting_success_protocol")
    //@iOSXCUITFindBy()
    private MobileElement numeroPropostaTelaSucesso;

    //Tela de Sucesso - Botão "Concluir"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_debit_card_success_contracting")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONCLUIR\"`]")
    private MobileElement botaoConcluirTelaSucesso;

    //Tela de exclusão com sucesso - Botão "Concluir"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_receipt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONCLUIR\"`]")
    private MobileElement botaoConcluirTelaSucessoExclusaoSeguro;

    //Tela de Sucesso - Aba "Informações do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_product_information_title_debit_card_success")
    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeOther[`label == \"informações do produto\"`]")
    private MobileElement abaInformacoesSeguroTelaSucesso;

    //Tela de Sucesso - Aba "Informações do Seguro Detalhes"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_debit_card_success_contracting_information")
    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeOther[`label == \"informações do produto\"`]")
    private MobileElement abaInformacoesSeguroDetalhesTelaSucesso;

    //Tela de Seguro Contratado - ícone Lixeira
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_next_option")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]/XCUIElementTypeButton[2]")
    private MobileElement iconeLixeiraTelaSeguroContratado;

    //Tela de Seguro Contratado - Título
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloSeguroContratado;

    //Tela de Seguro Contratado - Subtítulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_subtitle")
    //@iOSXCUITFindBy()
    private MobileElement subtituloSeguroContratado;

    //Tela de Seguro Contratado - Descrição
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_description")
    //@iOSXCUITFindBy()
    private MobileElement descricaoSeguroContratado;

    //Tela de Seguro Contratado - Ícone
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_main_icon")
    //@iOSXCUITFindBy()
    //private MobileElement iconeSeguroContratado;

    //Tela de Seguro Contratado - Label Data da Contratação
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtPeriod")
    //@iOSXCUITFindBy()
    private MobileElement labelDataContratacaoSeguroContratado;

    //Tela de Seguro Contratado - Data da Contratação
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_date")
    //@iOSXCUITFindBy()
    private MobileElement dataContratacaoSeguroContratado;

    //Tela de Seguro Contratado - Label Número Proposta
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtCert")
    //@iOSXCUITFindBy()
    private MobileElement labelNumeroPropostaSeguroContratado;

    //Tela de Seguro Contratado - Número Proposta
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_certified_number")
    //@iOSXCUITFindBy()
    private MobileElement numeroPropostaSeguroContratado;

    //Tela de Seguro Contratado - Aba "Acione seu Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_active_insurance")
    //@iOSXCUITFindBy()
    private MobileElement abaAcioneSeuSeguroCardContratado;

    //Tela de Seguro Contratado - Botão "Informações do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_insurance_info")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"INFORMAÇÕES DO PRODUTO\"`]")
    private MobileElement botaoInformacoesSeguroOuPlanoCardContratado;

    //Tela de Seguro Contratado - Descrição
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_phone_name")
    //@iOSXCUITFindBy()
    private MobileElement descricaoInformacoesSeguro;

    //Tela de Seguro Contratado - Telefone
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_phone_phone")
    //@iOSXCUITFindBy()
    private MobileElement telefoneInformacoesSeguro;

    //Tela de Seguro Contratado - Subtítulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_phone_hours")
    //@iOSXCUITFindBy()
    private MobileElement subtituloInformacoesSeguro;

    //Tela de Seguro Contratado - Linha Horizontal
    @AndroidFindBy(id = "br.com.bradesco.next:id/v_insurance_divider")
    //@iOSXCUITFindBy()
    private MobileElement linhaHorizontalInformacoesSeguro;

    //Tela de Adição de Dependente - Título
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloAdicaoDependente;

    //label titulo - Informações do produto - tela contratados/btn_informacoes do seguroOuPlano
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement labelInformacoesProduto;

    //Tela de Adição de Dependente - Rodapé
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_bottom")
    //@iOSXCUITFindBy()
    private MobileElement rodapeAdicaoDependente;

    //Rodape - Tela Informacoes do produto
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_bottom")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[5]")
    private MobileElement rodapeInformacoesDoProduto;

    //Tela de Adição de Dependente - Seta
    @AndroidFindBy(id = "br.com.bradesco.next:id/iconExpandCollapse")
    //@iOSXCUITFindBy()
    private MobileElement setaAdicaoDependente;

    //Tela de Adição de Dependente - Botão Próximo
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_beneficiaries_next_button")
    //@iOSXCUITFindBy()
    private MobileElement botaoProximoAdicaoDependente;

    //Tela de Adição de Dependente - Campo "Nome Completo"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtName")
    //@iOSXCUITFindBy()
    private MobileElement campoNomeCompletoAdicaoDependente;

    //Tela de Adição de Dependente - botão Editar "Nome Completo"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, botão\"])[1]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarNomeCompletoAdicaoDependente;

    //Tela de Adição de Dependente - Campo "Data de Nascimento"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtBirthDate")
    //@iOSXCUITFindBy()
    private MobileElement campoDataNascimentoAdicaoDependente;

    //Tela de Adição de Dependente - botão Editar "Data de Nascimento"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, botão\"])[2]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarDataNascimentoAdicaoDependente;

    //Tela de Adição de Dependente - Campo "CPF"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtCPF")
    //@iOSXCUITFindBy()
    private MobileElement campoCpfAdicaoDependente;

    //Tela de Adição de Dependente - botão Editar "CPF"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, botão\"])[3]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarCpfAdicaoDependente;

    //Tela de Adição de Dependente - Campo "Nome da Mãe"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtMothersName")
    //@iOSXCUITFindBy()
    private MobileElement campoNomeDaMaeAdicaoDependente;

    //Tela de Adição de Dependente - Botão Editar "Nome da Mãe"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, botão\"])[4]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarNomeDaMaeAdicaoDependente;

    //Tela de Adição de Dependente - Campo "Sexo"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtGender")
    //@iOSXCUITFindBy()
    private MobileElement campoSexoAdicaoDependente;

    //Tela de Adição de Dependente - Seta "Sexo"
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Editar, botão\"]/android.widget.ImageView")
    //@iOSXCUITFindBy()
    private MobileElement setaSexoAdicaoDependente;

    //Tela de Adição de Dependente - Botão Confirmar
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_apply")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoHeaderConfirmar;

    //Tela de Adição de Dependente - Campo "Parentesco"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtKinship")
    //@iOSXCUITFindBy()
    private MobileElement campoParentescoAdicaoDependente;

    //Tela de Adição de Dependente - Seta "Parentesco"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, botão\"])[6]")
    //@iOSXCUITFindBy()
    private MobileElement setaParentescoAdicaoDependente;

    //Tela de Exclusão de Seguro - Ícone
    @AndroidFindBy(id = "br.com.bradesco.next:id/imageView11")
    //@iOSXCUITFindBy()
    private MobileElement iconeTelaExclusaoSeguro;

    //Tela de Exclusão de Seguro - Título
    @AndroidFindBy(id = "br.com.bradesco.next:id/credit_success_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement tituloTelaExclusaoSeguro;

    //Tela de Exclusão de Seguro - Subtítulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/credit_success_subtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[2]")
    private MobileElement subtituloTelaExclusaoSeguro;

    //Tela de Exclusão de Seguro - Texto Cancelamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField")
    private MobileElement botaoMotivoCancelamentoTelaExclusaoSeguro;

    //Tela de Exclusão de Seguro - Seta
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon")
    //@iOSXCUITFindBy()
    private MobileElement setaTelaExclusaoSeguro;

    //Tela de Exclusão de Seguro - Botão Confirmar
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_cancellation_btn_confirm")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONFIRMAR\"`]")
    private MobileElement botaoConfirmarExclusaoSeguro;

    //Tela de Sucesso de Exclusão de Seguro - Ícone
    @AndroidFindBy(id = "br.com.bradesco.next:id/imageView3")
    //@iOSXCUITFindBy()
    private MobileElement iconeTelaSucessoExclusaoSeguro;

    //Tela de Sucesso de Exclusão de Seguro - Título
    @AndroidFindBy(id = "br.com.bradesco.next:id/credit_success_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloTelaSucessoExclusaoSeguro;

    //Tela de Sucesso de Exclusão de Seguro - Label Proposta
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_cancellation_success_description")
    //@iOSXCUITFindBy()
    private MobileElement labelPropostaTelaSucessoExclusaoSeguro;

    //Tela de Sucesso de Exclusão de Seguro - Número Proposta
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_cancellation_success_protocol")
    //@iOSXCUITFindBy()
    private MobileElement numeroPropostaExclusaoSeguro;

    //Tela Contratados - sem planos contratados
    @AndroidFindBy(accessibility = "Sem plano contratado")
    //@iOSXCUITFindBy()
    private MobileElement textoSemPlanoContratado;

    //menu geral "="
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement menuPrincipal;

    //campo "Seguro" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_credit_card_number_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"CONFIRMAÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[1]")
    private MobileElement labelSeguroConfirmacaoDeDados;

    //campo "Cartao Assegurado" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_subscription_type_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[2]")
    private MobileElement labelCartaoAsseguradoConfirmacaoDeDados;

    //campo "Valor Mensal" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_mensal_value_value")
    private MobileElement labelValorMensal;

    //campo "Data do Pagamento" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_date_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[3]")
    private MobileElement labelDataPagamentoConfirmacaoDeDados;

    //campo "Forma de Pagamento" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_form_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[4]")
    private MobileElement labelFormaPagamentoConfirmacaoDeDados;

    //botão "Editar Data de Pagamento" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_edit_date")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[3]")
    private MobileElement botaoDataPagamentoConfirmacaoDeDados;

    //Botão data 'dia 5' - calendario
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[@text=\"Todo dia 5\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoDataPagamentoDia5;

    //Botao Ok tela Erro
    @AndroidFindBy(id="br.com.bradesco.next:id/bt_confirm")
    private MobileElement botaoOkTelaErro;

    //Número de Pessoas Beneficiadas
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtBeneficiariesQuantity")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[2]")
    private MobileElement numeroPessoasBeneficiadas;

    //campo "Valor Total" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtTotalValue")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[5]")
    private MobileElement labelValorTotalConfirmacaoDeDados;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"FORMA DE PAGAMENTO\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[4]")
    private MobileElement labelFormaPagamento;

    //campo "Vigencia" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_vingency")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@visible=\"true\"]/XCUIElementTypeStaticText[3]")
    private MobileElement labelVigenciaConfirmacaoDeDados;

    //check box "Termos e Condicoes" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ncl_terms")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Selecionar\"]/XCUIElementTypeOther")
    private MobileElement checkBoxSeguroTermosCondicoesConfirmacaoDeDados;

    //botão ler "Termos e Condicoes" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_details_terms_button")
    @iOSXCUITFindBy(accessibility = "(//XCUIElementTypeOther[@name=\"CONTRATAR\"]/preceding-sibling::XCUIElementTypeOther)[2]/XCUIElementTypeButton")
    private MobileElement botaoLerTermosCondicoesConfirmacaoDeDados;

    //botão voltar "Termos e Condicoes" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Li e aceito os termos e condições. . Selecionar\"])[1]/XCUIElementTypeButton")
    private MobileElement botaoVoltarTermosCondicoesConfirmacaoDeDados;

    //botão expandir "cobertura" - tela confirmação de dados do seguro cartão (deb/cred)/Informacoes Seguro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Expandir\"] | //XCUIElementTypeCell[@name=\"Coberturas Colapsar\"]")
    private MobileElement botaoCoberturaInformacoesSeguro;

    //botão expandir "vigencia" - confirmação dos dados/informações do seguro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Vigência Expandir\"] | //XCUIElementTypeCell[@name=\"Vigência Colapsar\"]")
    private MobileElement botaoVigenciaInformacoesSeguro;

    //botão expandir "dados da seguradora" - confirmação dos dados/informações do seguro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Expandir\"] | //XCUIElementTypeCell[@name=\"Dados do parceiro Colapsar\"]")
    private MobileElement botaoDadosDaSeguradoraInformacoesSeguro;

    //botão "contratar" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_accept")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTRATAR\"]")
    private MobileElement botaoContratarSeguroConfirmacaoDeDados;

    //botão termo1 - Resumo das coberturas - botão tipo extender drop-down
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout")
    //@iOSXCUITFindBy()
    private MobileElement botaoPrimeiroTermoScrollView;

    //botão termo2 - Seguro coletivo de pessoas - botão tipo extender drop-down
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout")
    //@iOSXCUITFindBy()
    private MobileElement botaoSegundoTermoScrollView;

    //botão termo1 - Resumo das coberturas - abre uma nova pagina
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")
    //@iOSXCUITFindBy()
    private MobileElement botaoPrimeiroRecycleView;

    //botão termo2 - Seguro coletivo de pessoas - abre uma nova pagina
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")
    //@iOSXCUITFindBy()
    private MobileElement botaoSegundoTermoRecycleView;

    //titulo termo 1 - Resumo das Coberturas
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View[1]")
    //@iOSXCUITFindBy()
    private MobileElement tituloResumoCoberturasTermosCondicoesConfirmacaoDeDadosSeguroCartao;

    //titulo termo 2 - Seguro coletivo de pessoas
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View[1]")
    //@iOSXCUITFindBy()
    private MobileElement tituloSeguroColetivoPessoasTermosCondicoesConfirmacaoDeDadosSeguroCartao;

    //botão Detalhes - tela card contratado
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ir para detalhes\"`][1]")
    private MobileElement botaoDetalhesCardContratado;

    //titulo card - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement tituloDetalhesCardContratado;

    //subtitulo card - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_subtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[2]")
    private MobileElement subtituloDetalhesCardContratado;

    //label "em vigencia" - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_validity")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement labelEmVigenciaDetalhesCardContratado;

    //data da contratação - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_contracted_date_label")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement labelDataContratacaoCardContratado;

    //data da contratação - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_contracted_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement dataContratacaoCardContratado;

    //botão Acione seu produto - tela card contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_contracted_credit_card_insurance_activate")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ir para detalhes\"`][1]")
    private MobileElement botaoAcioneSeuProduto;

    //informações do produto - tela seguro contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_active_insurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement informacoesProdutoCardContratado;

    //informações do produto - tela seguro contratado
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement informacoesProdutoDetalhesCardContratado;

    //informações do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Coberturas\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseCoberturaAbaInformacoesDoSeguroContratado;

    //informações do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Vigência\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseVigenciaAbaInformacoesDoSeguroContratado;

    //informações do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Telefones\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseTelefonesAbaInformacoesDoSeguroContratado;

    //informações do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Dados do Parceiro\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseDadosDoParceiroAbaInformacoesDoSeguroContratado;

    //informações do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Cancelamento\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseCancelamentoAbaInformacoesDoSeguroContratado;

    //label "tudo certo com a contratação
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title_debit_card_success")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/preceding-sibling::XCUIElementTypeStaticText)[1]")
    private MobileElement labelTudoCertoContratacao;

    //label "tudo certo com a contratação - detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_description_debit_card_success")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/preceding-sibling::XCUIElementTypeStaticText)[2]")
    private MobileElement labelTudoCertoContratacaoDetalhes;

    //label "numero do contrato/protocolo"
    @AndroidFindBy(id = "br.com.bradesco.next:id/label_protocol_number")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONCLUIR\"]/preceding-sibling::XCUIElementTypeStaticText)[4]")
    private MobileElement labelNumeroContrato;

    //label valor "numero do contrato/protocolo"
    @AndroidFindBy(id = "br.com.bradesco.next:id/label_value_protocol_number")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONCLUIR\"]/preceding-sibling::XCUIElementTypeStaticText)[5]")
    private MobileElement valorNumeroContrato;

    //label contratação - seção informações do plano
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_footer_title")
    @iOSXCUITFindBy(accessibility = "Contratação")
    private MobileElement labelContratacaoInformacoesPlano;

    //label contratação detalhes - seção informações do plano
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_footer_message")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONCLUIR\"]/following-sibling::XCUIElementTypeStaticText)[2]")
    private MobileElement labelDetalhesContratacaoInformacoesPlano;

    //label vigencia - seção informações do plano
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "Vigência")
    private MobileElement labelVigenciaInformacoesPlano;

    //label detalhes vigencia - seção informações do plano
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONCLUIR\"]/following-sibling::XCUIElementTypeStaticText)[4]")
    private MobileElement labelDetalhesVigenciaInformacoesPlano;

    //footer - seção informações do plano
    @AndroidFindBy(id = "br.com.bradesco.next:id/footer_message")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONCLUIR\"]/following-sibling::XCUIElementTypeStaticText)[5]")
    private MobileElement labelFooterInformacoesPlano;

    //titulo card1 contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"CONTRATADOS\"]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText)[2]")
    private MobileElement tituloPrimeiroCardContratado;

    //status card1 contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_status")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"CONTRATADOS\"]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText)[1]")
    private MobileElement statusPrimeiroCardContratado;

    //botão detalhes card1 contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/icon_details")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ir para detalhes\"`][1]")
    private MobileElement botaoDetalhesPrimeiroCardContratado;

    //opção1 "nao preciso mais" - tela motivo do cancelamento
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]/..//XCUIElementTypeOther//XCUIElementTypePickerWheel")
    private MobileElement opcao1MotivoCancelamento;

    //acione seu seguro - central de atendimento
    @AndroidFindBy(xpath = "//android.widget.ScrollView[3]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[@text=\"Central de relacionamento\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"telefone\"`][1]")
    private MobileElement acioneSeuSeguroCentralAtendimento;

    //tela de erro - titulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_protection_warning_title")
    private MobileElement tituloTelaErro;

    //tela de erro - subtitulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_protection_warning_subtitle")
    private MobileElement subtituloTelaErro;

    //acione seu seguro - sac
    @AndroidFindBy(xpath = "//android.widget.ScrollView[3]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[@text=\"SAC\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"telefone\"`][2]")
    private MobileElement acioneSeuSeguroSac;

    //acione seu seguro - deficiencia
    @AndroidFindBy(xpath = "//android.widget.ScrollView[3]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[contains(@text, \"SAC - Deficiente\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"telefone\"`][3]")
    private MobileElement acioneSeuSeguroDeficiencia;

    //acione seu seguro - ouvidoria
    @AndroidFindBy(xpath = "//android.widget.ScrollView[3]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView[@text=\"Ouvidoria\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"telefone\"`][4]")
    private MobileElement acioneSeuSeguroOuvidoria;

    //pop-up telefone para ligacao
    @AndroidFindBy(id = "android:id/message")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[contains(@name, 'Ligar')]")
    private MobileElement popUpLigacao;

    //cancelar pop-up telefone para ligacao
    @AndroidFindBy(id = "android:id/button2")
    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeButton[`label == \"Cancelar\"`][1]")
    private MobileElement cancelarPopUpLigacao;

    //Texto detalhes do card de proteção cartao debito
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDescription")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Proteja seu cartão de débito contra transações decorrentes de roubo do cartão ou coação.\"]")
    private MobileElement validarTextoCardCartaoDebito;

    //botao contratar card cartão debito
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CONTRATAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SIMULAR\"`][3]")
    private MobileElement btnContratarProtecaoDebito;

    // check box termo de condiçoes de uso
    @AndroidFindBy(id = "br.com.bradesco.next:id/debit_confirm_checkbox_terms")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"termsCheckbox\"]/XCUIElementTypeOther")
    private MobileElement selecionarCheckTermoCondicoes;

    // botao contratar tela proteção
    @AndroidFindBy(id = "br.com.bradesco.next:id/debit_card_btn_hire")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTRATAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"hireButton\"]")
    private MobileElement botaoContratar;

    // botao Concluir tela proteção cartao debito
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_Receipt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"finishButton\"]")
    private MobileElement botaoConcluir;

    // validar texto da contratação proteção cartao debito
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_contracting_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Agora é só aguardar a ativação\"`]")
    private MobileElement validarContratacaoCartaoDebito;

    // validar cards
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDescription")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Proteção contra transações indevidas'")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Tenha mais motivos para sorrir'")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Proteja sua casa contra danos'")
    private MobileElement textoCardValidar;

    public ProtecaoTela(AppiumDriver driver) {
        super(driver);
    }

    /******************************************************************
     * Validar layout do Card de Proteção (todos tipos)
     *
     * @return
     * @throws Exception
     */

    @Step("Validar layout do Card de Proteção")
    public ProtecaoTela validarLayoutCardProtecao(TipoProtecao tipoProtecao) throws Exception {
        salvarEvidencia("Validar layout do Card de Proteção");
        aguardarCarregamentoElemento(headerTitulo);
        compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);

        switch (tipoProtecao) {
            case DEBITO:
                Assert.assertTrue(tituloCard.isDisplayed());
                Assert.assertTrue(subtituloCard.isDisplayed());
                Assert.assertTrue(descricaoCard.isDisplayed());
                Assert.assertTrue(valorCard.isDisplayed());
                Assert.assertTrue(botaoContratarCard.isDisplayed());
                break;
            case CREDITO:
                Assert.assertTrue(tituloCard.isDisplayed());
                Assert.assertTrue(subtituloCard.isDisplayed());
                Assert.assertTrue(descricaoCard.isDisplayed());
                Assert.assertTrue(valorCard.isDisplayed());
                Assert.assertTrue(botaoContratarCard.isDisplayed());
                break;
            case ODONTO:
                Assert.assertTrue(botaoSimularCard.isDisplayed());
                compararElementoTexto(tituloCard, Protecao.ODONTO, MetodoComparacao.CONTEM);
                compararElementoTexto(subtituloCard, Protecao.DENTAL_IDEAL, MetodoComparacao.CONTEM);
                Assert.assertTrue(headerBotaoVoltar.isDisplayed());
                if (android) {
                    Assert.assertTrue(valorCard.isDisplayed());
                    compararElementoTexto(descricaoValorCard, Protecao.DESCRICAO_VALOR_ODONTO, MetodoComparacao.CONTEM);
                    compararElementoTexto(valorCard, Protecao.VALOR_ODONTO, MetodoComparacao.CONTEM);
                }
                else {
                    compararElementoTexto(labelValorCardiOS, Protecao.DESCRICAO_E_VALOR_ODONTO, MetodoComparacao.CONTEM);
                }
                compararElementoTexto(abaContratadosCard, Protecao.ABA_CONTRATADOS, MetodoComparacao.CONTEM);
                break;
        }

        Assert.assertTrue(iconeCard.isDisplayed());
        Assert.assertTrue(botaoDetalhes.isDisplayed());

        return this;
    }

    /**
     * Tocar no Menu Next (superior/esquerdo)
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no Menu Next (superior/esquerdo)")
    public ProtecaoTela tocarMenuNext() throws Exception {
        salvarEvidencia("Clicar no Menu Principal Next (sup/esq)");
        aguardarCarregamentoElemento(menuPrincipal);
        tocarElemento(menuPrincipal, "Não foi possível clicar no Menu Next Principal (esq/sup)");
        return this;
    }

    /**
     * Navegar até o card "Odonto/Debito/Credito"
     *
     * @return
     * @throws Exception
     */

    @Step("Navegar até o card a ser testado")
    public ProtecaoTela navegarCardProtecao(TipoProtecao tipoProtecao) throws Exception {
        int ind=0;
        Boolean cardFound=false;
        String teste="";

        while(!cardFound){
            System.out.println("Procurando pelo card a ser testado...");
            aguardarCarregamentoElemento(headerTitulo);
            aguardarCarregamentoElemento(headerTitulo);
            aguardarCarregamentoElemento(tituloCard);

            if (verificarPresencaElemento(tituloCard)) {
                switch (tipoProtecao) {
                  case DEBITO:
                        if (tituloCard.getText().toUpperCase().contains(Protecao.CARTAO_DEBITO.toString().toUpperCase())) {
                            rolaTelaBaixo();
                            cardFound = true;
                        }
                    break;
                    case CREDITO:
                        if (tituloCard.getText().toUpperCase().contains(Protecao.CARTAO_CREDITO.toString().toUpperCase())) {
                            cardFound = true;
                        }
                    break;
                  case ODONTO:
                      if (tituloCard.getText().toUpperCase().contains(Protecao.ODONTO.toString().toUpperCase())) {
                          cardFound = true;
                      }
                  break;
                }
            }

            if(!cardFound){
                Dimension size = this.retornaDimensaoTela();
                int y = size.height / 2;
                int xInicial = (int)((double)size.width * 0.9);
                int xFinal = (int)((double)size.width * 0.1);
                (new TouchAction((AppiumDriver)driver)).press(PointOption.point(xInicial, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(xFinal, y)).release().perform();
            }
            ind++;
            if(ind>8){
                Assert.fail("Não foi possivel encontrar o card a ser testado. O card precisa estar disponivel para contratacao. Verifique!!!");
            }
        }
        salvarEvidencia("Card encontrado!!!");
        return this;
    }

    /**
     * Tocar no botão Detalhe - Tela do Card
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no botão Detalhe")
    public ProtecaoTela tocarBotaoDetalhes() throws Exception {
        salvarEvidencia("Clicar no botão DETALHE");
        rolaTelaCima();
        aguardarCarregamentoElemento(botaoDetalhes);
        tocarElemento(botaoDetalhes, "Não foi possível clicar no botão DETALHE");
        return this;
    }

    /**
     * Tocar no botão Contratar - tela do Card
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no botão Contratar")
    public ProtecaoTela tocarBotaoContratar() throws Exception {
        salvarEvidencia("Clicar no botão CONTRATAR");
        rolaTelaCima();
        aguardarCarregamentoElemento(botaoContratarCard);
        tocarElemento(botaoContratarCard, "Não foi possível clicar no botão CONTRATAR");
        return this;
    }

    /**
     * Validar layout tela Detalhes
     *
     * @return
     * @throws Exception
     */

    @Step("Validar layout tela Detalhes")
    public ProtecaoTela validarlayoutTelaDetalhes(TipoProtecao tipoProtecao) throws Exception {
        salvarEvidencia("Validar layout do Card de Proteção");
        aguardarCarregamentoElemento(headerTitulo);

        switch (tipoProtecao) {
            case DEBITO:
                compararElementoTexto(tituloCardDetalhes, Protecao.CARTAO_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(subtituloCardAberto, Protecao.SEGURO_CARTAO_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(descricaoCardAberto, Protecao.DESCRICAO_CARD_CARTAO_DEBITO, MetodoComparacao.CONTEM);
                break;
            case CREDITO:
                compararElementoTexto(tituloCard, Protecao.CARTAO_CREDITO, MetodoComparacao.CONTEM);
                compararElementoTexto(subtituloCard, Protecao.SEGURO_CARTAO_CREDITO, MetodoComparacao.CONTEM);
                compararElementoTexto(descricaoCard, Protecao.DESCRICAO_CARD_CARTAO_DEBITO, MetodoComparacao.CONTEM);
                break;
            case ODONTO:
                compararElementoTexto(tituloCardDetalhes, Protecao.ODONTO, MetodoComparacao.CONTEM);
                compararElementoTexto(subtituloCardDetalhes, Protecao.DENTAL_IDEAL, MetodoComparacao.CONTEM);
                compararElementoTexto(descricaoCardOdonto, Protecao.DESCRICAO_CARD_ODONTO, MetodoComparacao.CONTEM);
                if (android) {
                    compararElementoTexto(labelValorCard, Protecao.DESCRICAO_VALOR_ODONTO, MetodoComparacao.CONTEM);
                    compararElementoTexto(valorCard, Protecao.VALOR_ODONTO, MetodoComparacao.CONTEM);
                }
                else {
                    compararElementoTexto(labelValorCardiOS, Protecao.DESCRICAO_E_VALOR_ODONTO, MetodoComparacao.CONTEM);
                }
                break;
        }

        compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);
        Assert.assertTrue(headerBotaoVoltar.isDisplayed());
        Assert.assertTrue(iconeCard.isEnabled());
        Assert.assertTrue(valorCard.isDisplayed());
        Assert.assertTrue(abaInformacoesDoSeguro.isDisplayed());
        Assert.assertTrue(botaoContratarCardDetalhes.isDisplayed());

        return this;
    }

    /**
     * Tocar botão Continuar Informacoes Seguro
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar botão Continuar")
    public ProtecaoTela tocarBotaoContinuarInformacoesSeguro(TipoProtecao tipoProtecao) throws Exception {
        switch(tipoProtecao)
        {
            case ODONTO:
                tocarBotaoContinuar();
        }

        return this;
    }

    /**
     * Tocar botão Contratar - tela seguro/detalhe
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar botão Contratar - tela card/detalhe")
    public ProtecaoTela tocarBotaoContratarTelaDetalhes(Protecao botao) throws Exception {
        if(botao.equals(Protecao.PRIMEIRO_BOTAO_CONTRATAR_FROM_DETALHES)) {
            aguardarCarregamentoElemento(botaoContratarCardDetalhes);
            salvarEvidencia("Tocar no primeiro botão Contratar - tela card/detalhe");
            tocarElemento(botaoContratarCardDetalhes, "Não foi possível tocar no primeiro botão Contratar - tela card/detalhe");
        }else{
                aguardarCarregamentoElemento(segundoBotaoContratarCard);
                salvarEvidencia("Tocar no segundo botão Contratar - tela seguro/detalhe");
                tocarElemento(segundoBotaoContratarCard, "Não foi possível tocar no segundo botão Contratar - tela card/detalhe");
        }

        return this;
    }

    /**
     * Validar campos da tela "Confirmação de dados" (Deb/Cre)
     *
     * @return
     * @throws Exception
     */

    @Step("Validar campos da tela \"Confirmação de dados\"")
    public ProtecaoTela validarTelaConfirmacaoDeDados(TipoProtecao tipoProtecao, ParticipantesProtecaoOdonto participantes) throws Exception {
        switch (tipoProtecao) {
            case DEBITO:
                salvarEvidencia("Validar campos da tela \"Confirmação de dados\"");
                compararElementoTexto(headerTituloConf, Protecao.CONFIRMACAO, MetodoComparacao.CONTEM);
                compararElementoTexto(tituloCardConfirmacao, Protecao.TITULO_CONFIRMACAO_DADOS_CARTAO_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(labelSeguroConfirmacaoDeDados, Protecao.SEGURO_CARTAO_DEBITO, MetodoComparacao.CONTEM);
                Assert.assertTrue(labelCartaoAsseguradoConfirmacaoDeDados.isDisplayed());
                Assert.assertTrue(labelValorMensal.isDisplayed());
                Assert.assertTrue(botaoDataPagamentoConfirmacaoDeDados.isDisplayed());
                Assert.assertTrue(labelFormaPagamentoConfirmacaoDeDados.isDisplayed());
                Assert.assertTrue(labelDataPagamentoConfirmacaoDeDados.isDisplayed());

                int aux=1;
                while(!aguardarCarregamentoElemento(labelVigenciaConfirmacaoDeDados)){
                    rolarTela(0.7,0.3);
                    if(aux > 3){
                        throw new AssertionError("Não foi possível encontrar campo Vigencia");
                    }
                    aux++;
                }
                Assert.assertTrue(labelVigenciaConfirmacaoDeDados.isDisplayed());

                aux=1;
                while(!aguardarCarregamentoElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados)){
                    rolarTela(0.7,0.3);
                    if(aux > 3){
                        throw new AssertionError("Não foi possível encontrar campo Termos e Condicoes");
                    }
                    aux++;
                }
                break;
            case CREDITO:
                aguardarCarregamentoElemento(labelSeguroConfirmacaoDeDados);
                salvarEvidencia("Validar campos da tela \"Confirmação de dados\"");
                compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);
                compararElementoTexto(labelSeguroConfirmacaoDeDados, Protecao.SEGURO_CARTAO_CREDITO, MetodoComparacao.CONTEM);
                compararElementoTexto(tituloCard, Protecao.TITULO_CONFIRMACAO_DADOS_CARTAO_CREDITO, MetodoComparacao.CONTEM);

                aux=1;
                while(!aguardarCarregamentoElemento(labelVigenciaConfirmacaoDeDados)){
                    rolarTela(0.7,0.3);
                    if(aux > 3){
                        throw new AssertionError("Não foi possível encontrar campo Vigencia");
                    }
                    aux++;
                }
                Assert.assertTrue(labelVigenciaConfirmacaoDeDados.isDisplayed());

                aux=1;
                while(!aguardarCarregamentoElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados)){
                    rolarTela(0.7,0.3);
                    if(aux > 3){
                        throw new AssertionError("Não foi possível encontrar campo Termos e Condicoes");
                    }
                    aux++;
                }

                Assert.assertTrue(!checkBoxSeguroTermosCondicoesConfirmacaoDeDados.isSelected());
                Assert.assertTrue(!botaoContratarSeguroConfirmacaoDeDados.isEnabled());
                break;
            case ODONTO:
                aguardarCarregamentoElemento(headerTitulo);
                compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);
                Assert.assertTrue(headerBotaoVoltar.isDisplayed());
                compararElementoTexto(labelPlanoConfirmacaoDeDados, Protecao.DENTAL_IDEAL, MetodoComparacao.CONTEM);
                compararElementoTexto(tituloCard, Protecao.TITULO_CONFIRMACAO_DADOS_ODONTO, MetodoComparacao.CONTEM);
                switch(participantes.toString())
                {
                    case "PRA_MIM":
                        compararElementoTexto(numeroPessoasBeneficiadas, Protecao.ZERO_DEPENDENTES, MetodoComparacao.CONTEM);
                        break;
                    case "Pra mim e Dependentes":
                        //TODO
                        break;
                    case "Apenas Dependentes":
                        //TODO
                        break;
                }
                Assert.assertTrue(labelTipoPagamento.isDisplayed());
                Assert.assertTrue(radioButtonTipoPagamentoMensal.isDisplayed());
                Assert.assertTrue(radioButtonTipoPagamentoAnual.isDisplayed());
                Assert.assertTrue(labelRadioButtonTipoPagamentoMensal.isDisplayed());
                Assert.assertTrue(labelRadioButtonTipoPagamentoAnual.isDisplayed());
                compararElementoTexto(valorRadioButtonTipoPagamentoMensal, Protecao.QUARENTA_E_CINCO_CADA, MetodoComparacao.CONTEM);
                compararElementoTexto(valorRadioButtonTipoPagamentoAnual, Protecao.QUATROCENTOS_E_CINQUENTA_E_SEIS_CADA, MetodoComparacao.CONTEM);
                Assert.assertTrue(labelDataPagamento.isDisplayed());
                int day = LocalDate.now().getDayOfMonth();
                String dayWeek = LocalDate.now().getDayOfWeek().toString();
                if (dayWeek == "SATURDAY")
                {
                    day = day+2;
                }
                else
                {
                    if (dayWeek == "SUNDAY")
                    {
                        day = day+1;
                    }
                }

                Assert.assertTrue(campoDataPagamentoTelaConfirmacao.getText().contains("Dia " + day));
                while (!aguardarCarregamentoElemento(labelFormaPagamento))
                {
                    rolarTela(0.9D, 0.8D);
                }
                Assert.assertTrue(labelFormaPagamento.isDisplayed());
                while (!aguardarCarregamentoElemento(campoFormaPagamentoTelaConfirmacao))
                {
                    rolarTela(0.9D, 0.8D);
                }
                compararElementoTexto(campoFormaPagamentoTelaConfirmacao, Protecao.DEBITO_EM_CONTA_CORRENTE, MetodoComparacao.CONTEM);
                while (!aguardarCarregamentoElemento(labelValorTotal))
                {
                    rolarTela(0.9D, 0.8D);
                }
                Assert.assertTrue(labelValorTotal.isDisplayed());
                while (!aguardarCarregamentoElemento(campoValorTotalTelaConfirmacao))
                {
                    rolarTela(0.9D, 0.8D);
                }
                compararElementoTexto(campoValorTotalTelaConfirmacao, Protecao.QUARENTA_E_CINCO_MES, MetodoComparacao.CONTEM);
                while (!aguardarCarregamentoElemento(labelVigencia))
                {
                    rolarTela(0.9D, 0.8D);
                }
                Assert.assertTrue(labelVigencia.isDisplayed());
                while (!aguardarCarregamentoElemento(campoVigenciaTelaConfirmacao))
                {
                    rolarTela(0.9D, 0.8D);
                }
                compararElementoTexto(campoVigenciaTelaConfirmacao, Protecao.VIGENCIA_ODONTO, MetodoComparacao.CONTEM);
                while (!aguardarCarregamentoElemento(botaoInterrogacaoTelaConfirmacao))
                {
                    rolarTela(0.9D, 0.7D);
                }
                compararElementoTexto(botaoInterrogacaoTelaConfirmacao, Protecao.LI_E_ACEITO, MetodoComparacao.CONTEM);
                while (!aguardarCarregamentoElemento(botaoLerTermosCondicoesConfirmacaoDeDados))
                {
                    rolarTela(0.9D, 0.8D);
                }
                Assert.assertTrue(botaoLerTermosCondicoesConfirmacaoDeDados.isDisplayed());
                while (!aguardarCarregamentoElemento(botaoContratarOdontoTelaConfirmacao))
                {
                    rolarTela(0.9D, 0.8D);
                }
                Assert.assertTrue(botaoContratarOdontoTelaConfirmacao.isDisplayed());
                Assert.assertTrue(!botaoInterrogacaoTelaConfirmacao.isSelected());
                Assert.assertTrue(!botaoContratarOdontoTelaConfirmacao.isEnabled());
                break;
        }
        salvarEvidencia("Validar campos da tela \"Confirmação de dados\"");
        return this;
    }

    /**
     * Validar layout da tela "Termos e Condições"
     *
     * @return
     * @throws Exception
     */

    @Step("Validar \"Termos e Condições\"")
    public ProtecaoTela validarTelaTermosCondicoes(TipoProtecao tipoProtecao) throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        salvarEvidencia("Validar layout \"Termos e Condições\"");
        compararElementoTexto(headerTitulo, Protecao.TERMOS_CONDICOES, MetodoComparacao.CONTEM);

        List<MobileElement> todosTermos = retornarLista(new By.ById("br.com.bradesco.next:id/protection_item_term_title"), "Termos não encontrados");

        System.out.println(">>>>>> QTD DE TERMOS>>>>: "+todosTermos.size());

        int ind=0;
        for (MobileElement termo : todosTermos) {
            ind++;
            aguardarCarregamentoElemento(termo);
            tocarElemento(termo, "Não foi possível tocar no Termo "+ind);
            aguardarCarregamentoElemento(headerTitulo);
            compararElementoTexto(headerTitulo, Protecao.TERMOS_CONDICOES, MetodoComparacao.CONTEM);
            salvarEvidencia("Termos e Condições - Termo "+ind);
            tocarElemento(botaoVoltarTermosCondicoesConfirmacaoDeDados, "Não foi possível tocar no botão voltar "+ind);
        }

        tocarElemento(botaoVoltarTermosCondicoesConfirmacaoDeDados, "Erro ao tocar botão Fechar(x) Termo e Condicoes");
        return this;
    }

    /**
     * Validar "Informações do Seguro" em "seguro/detalhes/confirmação de dados"
     *
     * @return
     * @throws Exception
     */
    //botao 1 ou 2 = caso tenha o mesmo botao de nome repetido na tela
    @Step("Validar \"Informações do Seguro\" em \"seguro/detalhes/confirmação de dados\"")
    public ProtecaoTela validarSecaoInformacoesSeguro(TipoSecaoProtecao tipoSecaoProtecao, TipoProtecao tipoProtecao, Protecao botao) throws Exception {

        switch (tipoSecaoProtecao) {
            case INFORMACOES_SEGURO_FROM_DETALHES:
                switch (tipoProtecao) {
                    case DEBITO:
                        validarSecaoInformacoesSeguroCartaoFromDetalhesTipoDebito(botao);
                        break;
                    case CREDITO:
                        //validarSecaoInformacoesSeguroCartaoFromDetalhesTipoCredito();
                        break;
                    case ODONTO:
                        validarSecaoInformacoesSeguroOdontoFromDetalhes();
                        break;
                }
                break;
            case INFORMACOES_SEGURO_FROM_CONFIRMACAO_DADOS:
                switch (tipoProtecao) {
                    case DEBITO:
                        validarSecaoInformacoesSeguroCartaoFromConfirmacaoDadosTipoDebito(botao);
                        break;
                    case CREDITO:
                        //validarSecaoInformacoesSeguroCartaoFromConfirmacaoDadosTipoCredito();
                        break;
                }
                break;
            case INFORMACOES_SEGURO_FROM_CARD_CONTRATADO:
                switch (tipoProtecao) {
                    case DEBITO:
                        validarSecaoInformacoesDoProdutoFromCartaoCardContratadosTipoDebito();
                        break;
                    case CREDITO:
                        //validarSecaoInformacoesSeguroCartaoFromCardContratadosTipoCredito();
                        break;
                }
                break;
        }
        return this;
    }

    /**
     * Validar a seção "Informações do Produto" em ODONTO
     * @throws Exception
     */

    private void validarSecaoInformacoesSeguroOdontoFromDetalhes() throws Exception {
        rolaTelaBaixo();

        aguardarCarregamentoElemento(headerTitulo);
        compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);

        Assert.assertTrue(headerBotaoVoltar.isDisplayed());

        compararElementoTexto(descricaoAbaInformacoesDoSeguro, Protecao.DESCRICAO_INFORMACAO_SEGURO_ODONTO, MetodoComparacao.CONTEM);

        Assert.assertTrue(headerBotaoVoltar.isDisplayed());

        compararElementoTexto(rodapeDetalhesSecaoInformacoesDoSeguro, Protecao.RODAPE_INFORMACOES_DO_SEGURO_ODONTO, MetodoComparacao.CONTEM);

        Assert.assertTrue(collapseCoberturaAbaInformacoesDoSeguro.isDisplayed());
        Assert.assertTrue(setaCollapseAbaCoberturaInformacoesDoSeguro.isDisplayed());
        compararElementoTexto(textoCollapseCoberturaAbaInformacoesDoSeguro, Protecao.COBERTURA, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseAbaCoberturaInformacoesDoSeguro,"Não foi possível expandir a seção 'Cobertura'");
        aguardarCarregamentoElemento(textoInternoCollapseAbaInformacoesDoSeguro);
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.DIAGNOSTICO, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseAbaCoberturaInformacoesDoSeguro,"Não foi possível expandir a seção 'Cobertura'");

        aguardarCarregamentoElemento(collapseCarenciaAbaInformacoesDoSeguro);
        Assert.assertTrue(collapseCarenciaAbaInformacoesDoSeguro.isDisplayed());
        Assert.assertTrue(setaCollapseAbaCarenciaInformacoesDoSeguro.isDisplayed());
        compararElementoTexto(textoCollapseCarenciaAbaInformacoesDoSeguro, Protecao.CARENCIA, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseAbaCarenciaInformacoesDoSeguro,"Não foi possível expandir a seção 'Carência'");
        aguardarCarregamentoElemento(textoInternoCollapseAbaInformacoesDoSeguro);
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.BENEFICIARIOS, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseAbaCarenciaInformacoesDoSeguro,"Não foi possível expandir a seção 'Carência'");

        aguardarCarregamentoElemento(collapseDadosParceiroAbaInformacoesDoSeguro);
        Assert.assertTrue(collapseDadosParceiroAbaInformacoesDoSeguro.isDisplayed());
        Assert.assertTrue(setaCollapseDadosParceiroAbaInformacoesDoSeguro.isDisplayed());
        compararElementoTexto(textoCollapseDadosParceiroAbaInformacoesDoSeguro, Protecao.DADOS_PARCEIRO, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseDadosParceiroAbaInformacoesDoSeguro,"Não foi possível expandir a seção 'Dados do parceiro'");
        aguardarCarregamentoElemento(textoInternoCollapseAbaInformacoesDoSeguro);
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.CNPJ, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseDadosParceiroAbaInformacoesDoSeguro,"Não foi possível expandir a seção 'Carência'");

        aguardarCarregamentoElemento(segundoBotaoSimularContratarCard);
        Assert.assertTrue(segundoBotaoSimularContratarCard.isDisplayed());
        //TODO: Alterar o elemento segundoBotaoSimularContratarCard para segundoBotaoContratarCard (Alteração necesária pois no IOS os botões tem identificações diferentes)
    }


    private void validarSecaoInformacoesDoProdutoFromCartaoCardContratadosTipoDebito() throws Exception {
        aguardarCarregamentoElemento(labelInformacoesProduto);
        compararElementoTexto(rodapeInformacoesDoProduto, Protecao.RODAPE_INFORMACOES_DO_SEGURO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar seção Informações do Produto");

        aguardarCarregamentoElemento(botaoCoberturaInformacoesSeguro);
        tocarElemento(botaoCoberturaInformacoesSeguro, "Não foi possível clicar no botao \"Cobertura\"");
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.COBERTURA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Cobertura em informacoes do Seguro");

        aguardarCarregamentoElemento(botaoVigenciaInformacoesSeguro);
        tocarElemento(botaoVigenciaInformacoesSeguro, "Não foi possível clicar no botao \"Vigencia\"");
        rolaTelaBaixo();
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.VIGENCIA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Vigencia em informacoes do Seguro");

        aguardarCarregamentoElemento(botaoDadosDaSeguradoraInformacoesSeguro);
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "Não foi possível clicar no botao \"Vigencia\"");
        rolaTelaBaixo();
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.DADOS_DA_SEGURADORA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes dos Dados da seguradora em informacoes do Seguro");
    }

    private void validarSecaoInformacoesSeguroCartaoFromConfirmacaoDadosTipoDebito(Protecao botao) throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(tituloTelaSelecaoSegurados);
        compararElementoTexto(rodapeConfirmacaoDeDadosSecaoInformacoesDoSeguro, Protecao.RODAPE_INFORMACOES_DO_SEGURO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar seção Informações do Seguro");

        aguardarCarregamentoElemento(botaoCoberturaInformacoesSeguro);
        tocarElemento(botaoCoberturaInformacoesSeguro, "Não foi possível clicar no botao \"Cobertura\"");
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.COBERTURA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Cobertura em informacoes do Seguro");
        tocarElemento(botaoCoberturaInformacoesSeguro, "Não foi possível clicar no botao \"Cobertura\"");

        aguardarCarregamentoElemento(botaoVigenciaInformacoesSeguro);
        tocarElemento(botaoVigenciaInformacoesSeguro, "Não foi possível clicar no botao \"Vigencia\"");
        rolaTelaBaixo();
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.VIGENCIA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Vigencia em informacoes do Seguro");
        tocarElemento(botaoVigenciaInformacoesSeguro, "Não foi possível clicar no botao \"Vigencia\"");

        aguardarCarregamentoElemento(botaoDadosDaSeguradoraInformacoesSeguro);
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "Não foi possível clicar no botao \"Dados da Seguradora\"");
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.DADOS_DA_SEGURADORA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes dos Dados da seguradora em informacoes do Seguro");
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "Não foi possível clicar no botao \"Dados da Seguradora\"");
        //TODO: swap para cima nao funciona nessa parte, estou tendo que voltar e entrar de novo para aparecer no topo da pagina
        tocarElemento(headerBotaoVoltar, "nao foi possivel clicar no botão voltar");
        switch(botao){
            case PRIMEIRO_BOTAO_CONTRATAR_FROM_DETALHES:
                aguardarCarregamentoElemento(botaoSimularCard);
                tocarElemento(botaoSimularCard, "Não foi possível clicar no botão1 CONTRATAR ");
                break;
            case SEGUNDO_BOTAO_CONTRATAR_FROM_DETALHES:
                aguardarCarregamentoElemento(segundoBotaoSimularContratarCard);
                tocarElemento(segundoBotaoSimularContratarCard, "Não foi possível clicar no botão2 CONTRATAR ");
                //TODO: Alterar o elemento segundoBotaoSimularContratarCard para segundoBotaoContratarCard (Alteração necesária pois no IOS os botões tem identificações diferentes)
                break;
            case BOTAO_CONTRATAR_FROM_CARD:
                aguardarCarregamentoElemento(botaoContratarCard);
                tocarElemento(botaoContratarCard, "Não foi possível clicar no botão CONTRATAR ");
                break;
        }
    }

    /**
     * Tocar botão Próximo
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão próximo")
    public ProtecaoTela tocarBotaoProximo() throws Exception {
        aguardarCarregamentoElemento(botaoProximoTelaSelecaoSegurados);
        tocarElemento(botaoProximoTelaSelecaoSegurados, "Não foi possível clicar no botao \"Próximo\"");
        salvarEvidencia("Tocar botão Proximo");
        return this;
    }

    /**
     * Validar Layout da tela de Erro
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Layout da tela de Erro")
    public ProtecaoTela validarLayoutTelaErro() throws Exception {
        if (aguardarCarregamentoElemento(tituloTelaErro))
        {
            aguardarCarregamentoElemento(headerTitulo);
            compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);
            Assert.assertTrue(headerBotaoVoltar.isDisplayed());
            Assert.assertTrue(setaTelaExclusaoSeguro.isDisplayed());
            compararElementoTexto(tituloTelaErro, Protecao.TENTE_NOVAMENTE, MetodoComparacao.CONTEM);
            compararElementoTexto(subtituloTelaErro, Protecao.TENTE_DE_NOVO, MetodoComparacao.CONTEM);
            compararElementoTexto(botaoOkTelaErro, Protecao.OK, MetodoComparacao.CONTEM);
            salvarEvidencia("Tela de Erro");
        }
        else {
            System.out.println("Favor excluir o seguro contratado e rodar o teste novamente");
            compararElementoTexto(tituloTelaErro, Protecao.TENTE_NOVAMENTE, MetodoComparacao.CONTEM);
        }
        return this;
    }

    /**
     * Tocar botão X
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão X")
    public ProtecaoTela tocarBotaoX() throws Exception {
        aguardarCarregamentoElemento(headerBotaoVoltar);
        tocarElemento(headerBotaoVoltar,"Erro ao tocar no botão X");
        return this;
    }

    private void validarSecaoInformacoesSeguroCartaoFromDetalhesTipoDebito(Protecao botao) throws Exception {
        rolarTelaAteFinal();
        aguardarCarregamentoElemento(headerTitulo);
        compararElementoTexto(rodapeDetalhesSecaoInformacoesDoSeguro, Protecao.RODAPE_INFORMACOES_DO_SEGURO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar seção Informações do Seguro");

        aguardarCarregamentoElemento(botaoCoberturaInformacoesSeguro);
        tocarElemento(botaoCoberturaInformacoesSeguro, "Não foi possível clicar no botão \"Cobertura\"");
        salvarEvidencia("Validar detalhes da Cobertura em informacoes do Seguro");

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVigenciaInformacoesSeguro, "Não foi possível clicar no botao \"Vigencia\"");
        aguardarCarregamentoElemento(botaoVigenciaInformacoesSeguro);
        tocarElemento(botaoVigenciaInformacoesSeguro, "Não foi possível clicar no botao \"Vigencia\"");
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.VIGENCIA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Vigencia em informacoes do Seguro");

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "Não foi possível clicar no botao \"Dados da Seguradora\"");
        aguardarCarregamentoElemento(botaoDadosDaSeguradoraInformacoesSeguro);
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "Não foi possível clicar no botao \"Dados da Seguradora\"");
        aguardarCarregamentoElemento(textoInternoCollapseAbaInformacoesDoSeguro);
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.DADOS_DA_SEGURADORA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes dos Dados da seguradora em informacoes do Seguro");
        rolarTelaAteFinal();
        aguardarCarregamentoElemento(segundoBotaoSimularContratarCard);
        salvarEvidencia("Validar seção Informações do Seguro Rodapé com Dados do Seguro Aberto");
        Assert.assertTrue(segundoBotaoSimularContratarCard.isDisplayed());
        rolarTelaAteInicio();
    }

    /**
     * Tocar no botão "Informações do Seguro" (debito) ou "Informações do Plano" (credito)
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no botão \"Informações do Seguro/Plano\"")
    public ProtecaoTela tocarBotaoInformacoesSeguroOuPlano() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(botaoInformacoesSeguroOuPlanoCardContratado);
        salvarEvidencia("Tocar no botão \"Informações do Seguro/Plano\"");
        tocarElemento(botaoInformacoesSeguroOuPlanoCardContratado, "Não foi possível clicar no botao \"Informacoes do Seguro/Plano\"");
        Assert.assertTrue(labelInformacoesProduto.isEnabled());
        return this;
    }

    /**
     * Tocar na check box "Li e aceito os termos e condições"
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar na check box \"Li e aceito os termos e condições\"")
    public ProtecaoTela tocarCheckBoxLiAceitoTermosCondicoes(TipoProtecao tipoProtecao) throws Exception {
        rolaTelaBaixo();
        switch (tipoProtecao)
        {
            case ODONTO:
                aguardarCarregamentoElemento(headerTitulo);
                aguardarCarregamentoElemento(botaoInterrogacaoTelaConfirmacao);
                tocarElemento(botaoInterrogacaoTelaConfirmacao, "Não foi possível marcar o checkbox");
                Assert.assertTrue(botaoContratarOdontoTelaConfirmacao.isEnabled());
                break;
            default:
                aguardarCarregamentoElemento(headerTitulo);
                aguardarCarregamentoElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados);
                tocarElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados, "Não foi possível clicar no botão \"checkBox SeguroTermosCondicoes\"");
                Assert.assertTrue(botaoContratarSeguroConfirmacaoDeDados.isEnabled());
                break;
        }

        salvarEvidencia("Tocar na check box \"Li e aceito os termos e condições\"");
        return this;
    }

    /**
     * Tocar no botão "Contratar" da tela "Confirmação de dados"
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no botão \"Contratar\" da tela \"Confirmação de dados\"")
    public ProtecaoTela tocarBotaoContratarTelaConfirmacaoDeDados(TipoProtecao tipoProtecao) throws Exception {
        rolaTelaBaixo();
        switch (tipoProtecao)
        {
            case ODONTO:
                aguardarCarregamentoElemento(botaoContratarOdontoTelaConfirmacao);
                salvarEvidencia("Tocar no botão \"Contratar\" da tela \"Confirmação de dados\"");
                tocarElemento(botaoContratarOdontoTelaConfirmacao, "Não foi possível clicar no botao \"CONTRATAR\" da tela Confirmação de Dados do Seguro");
                break;
            default:
                aguardarCarregamentoElemento(botaoContratarSeguroConfirmacaoDeDados);
                salvarEvidencia("Tocar no botão \"Contratar\" da tela \"Confirmação de dados\"");
                tocarElemento(botaoContratarSeguroConfirmacaoDeDados, "Não foi possível clicar no botao \"CONTRATAR\" da tela Confirmação de Dados do Seguro");
                break;
        }
        return this;
    }

    /**
     * Validar layout tela confirmação de contratação
     *
     * @return
     * @throws Exception
     */

    @Step("Validar layout tela confirmação de contratação")
    public ProtecaoTela validarLayoutTelaConfirmacaoContratacao(TipoProtecao tipoProtecao) throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        salvarEvidencia("Validar layout tela confirmação de contratação");
        compararElementoTexto(headerTitulo, Protecao.SUCESSO, MetodoComparacao.CONTEM);

        switch (tipoProtecao) {
            case DEBITO:
                compararElementoTexto(labelTudoCertoContratacao, Protecao.TUDO_CERTO_CONTRATACAO_CARTAO_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(labelTudoCertoContratacaoDetalhes, Protecao.TUDO_CERTO_CONTRATACAO_DETALHES_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(labelNumeroContrato, Protecao.NUMERO_CONTRATO_PROTOCOLO_DEBITO, MetodoComparacao.CONTEM);
                Assert.assertTrue(botaoConcluirTelaSucesso.isDisplayed());
                rolarTelaAteFinal();
                Assert.assertTrue(abaInformacoesSeguroTelaSucesso.isDisplayed());
                salvarEvidencia("Validar layout tela confirmação de contratação - informações do produto");
                break;
            case CREDITO:
                validarLayoutTelaConfirmacaoContratacaoSeguroCartao(tipoProtecao);
                break;
            case ODONTO:
                //validarLayoutTelaConfirmacaoContratacaoOdonto();
                break;
        }

        return this;
    }

    private void validarLayoutTelaConfirmacaoContratacaoSeguroCartao(TipoProtecao tipoProtecao) throws Exception {
        compararElementoTexto(labelTudoCertoContratacao, Protecao.TUDO_CERTO_CONTRATACAO, MetodoComparacao.CONTEM);
        compararElementoTexto(labelTudoCertoContratacaoDetalhes, Protecao.TUDO_CERTO_CONTRATACAO_DETALHES, MetodoComparacao.CONTEM);
        compararElementoTexto(labelNumeroContrato, Protecao.NUMERO_CONTRATO, MetodoComparacao.CONTEM);
        compararElementoTexto(valorNumeroContrato, Protecao.VALOR_NUMERO_CONTRATO, MetodoComparacao.CONTEM);
        Assert.assertTrue(botaoConcluirTelaSucesso.isDisplayed());
        Assert.assertTrue(abaInformacoesSeguroTelaSucesso.isDisplayed());

        rolaTelaBaixo();
        salvarEvidencia("Validar layout tela confirmação de contratação - seção informações do plano");
        compararElementoTexto(labelContratacaoInformacoesPlano, Protecao.CONTRATACAO, MetodoComparacao.CONTEM);
        compararElementoTexto(labelDetalhesContratacaoInformacoesPlano, Protecao.CONTRATACAO_DETALHES, MetodoComparacao.CONTEM);
        compararElementoTexto(labelVigenciaInformacoesPlano, Protecao.VIGENCIA, MetodoComparacao.CONTEM);
        compararElementoTexto(labelDetalhesVigenciaInformacoesPlano, Protecao.VIGENCIA_DETALHES, MetodoComparacao.CONTEM);
        Assert.assertTrue(labelFooterInformacoesPlano.isDisplayed());

    }

    /**
     * Validar layout card contratado
     *
     * @return
     * @throws Exception
     */

    @Step("Validar layout card contratado")
    public ProtecaoTela validarLayoutCardContratado(TipoProtecao tipoProtecao) throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        rolaTelaBaixo();
        aguardarCarregamentoElemento(tituloPrimeiroCardContratado);
        salvarEvidencia("Validar card contratado - NAO PODE HAVER OUTROS CARDS CONTRATADOS - APENAS O DO TESTE!");

        //TODO: pre-requisito do teste: ter somente um card nos contratados
        switch(tipoProtecao){
            case CREDITO:
                compararElementoTexto(tituloPrimeiroCardContratado, Protecao.CARTAO_CREDITO, MetodoComparacao.CONTEM);
                Assert.assertTrue(statusPrimeiroCardContratado.isDisplayed());
                break;
            case DEBITO:
                compararElementoTexto(tituloPrimeiroCardContratado, Protecao.CARTAO_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(statusPrimeiroCardContratado, Protecao.STATUS_SEGURO_CARTAO_DEBITO_CONTRATADO, MetodoComparacao.CONTEM);
                break;
            case ODONTO:
                compararElementoTexto(tituloPrimeiroCardContratado, Protecao.ODONTO, MetodoComparacao.CONTEM);
                Assert.assertTrue(statusPrimeiroCardContratado.isDisplayed());
                break;
        }

        Assert.assertTrue(statusPrimeiroCardContratado.isDisplayed());
        Assert.assertTrue(botaoDetalhesPrimeiroCardContratado.isDisplayed());
        return this;
    }

    /**
     * Tocar Botão "Concluir" da tela sucesso contratacao/cancelamento
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar Botão \"Concluir\" da tela \"Sucesso\"")
    public ProtecaoTela tocarBotaoConcluir(TipoSecaoProtecao tipoSecaoProtecao) throws Exception {

        if(tipoSecaoProtecao.equals(TipoSecaoProtecao.CONTRATACAO)){
            aguardarCarregamentoElemento(botaoConcluirTelaSucesso);
            salvarEvidencia("Tocar botão \"Concluir\" da tela Contratado com \"Sucesso\"");
            tocarElemento(botaoConcluirTelaSucesso, "Não foi possível clicar no botao \"CONCLUIR\"");
        }else{
            aguardarCarregamentoElemento(botaoConcluirTelaSucessoExclusaoSeguro);
            salvarEvidencia("Tocar Botão \"Concluir\" da tela Excluido com \"Sucesso\"");
            tocarElemento(botaoConcluirTelaSucessoExclusaoSeguro, "Não foi possível clicar no botao \"CONCLUIR\"");
        }

        return this;
    }

    /**
     * Validar seção "Proteção" tela Contratados Seguro (Debito/Credito)
     *
     * @return
     * @throws Exception
     */

    @Step("Validar card contratado na seção Contratados")
    public ProtecaoTela validarTelaDetalhesCardContratado(TipoProtecao tipoProtecao) throws Exception {
        aguardarCarregamentoElemento(tituloDetalhesCardContratado);
        salvarEvidencia("Validar seção \"Proteção\" tela Contratados Seguro");
        compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);
        Assert.assertTrue(iconeLixeiraTelaSeguroContratado.isDisplayed());
        Assert.assertTrue(headerBotaoVoltar.isDisplayed());

        switch (tipoProtecao) {
            case DEBITO:
                compararElementoTexto(tituloDetalhesCardContratado, Protecao.CARTAO_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(subtituloDetalhesCardContratado, Protecao.SEGURO_CARTAO_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(labelEmVigenciaDetalhesCardContratado, Protecao.EM_VIGENCIA, MetodoComparacao.CONTEM);
                Assert.assertTrue(botaoAcioneSeuProduto.isDisplayed());
                Assert.assertTrue(labelDataContratacaoCardContratado.isDisplayed());
                Assert.assertTrue(informacoesProdutoCardContratado.isDisplayed());
                rolarTelaAteFinal();
                Assert.assertTrue(collapseCoberturaAbaInformacoesDoSeguroContratado.isDisplayed());
                tocarElemento(collapseCoberturaAbaInformacoesDoSeguroContratado, "Não foi possível tocar em Coberturas");
                salvarEvidencia("Validar seção \"Coberturas\" tela Contratados Seguro");
                Assert.assertTrue(collapseVigenciaAbaInformacoesDoSeguroContratado.isDisplayed());
                tocarElemento(collapseVigenciaAbaInformacoesDoSeguroContratado, "Não foi possível tocar em Vigência");
                salvarEvidencia("Validar seção \"Vigência\" tela Contratados Seguro");
                Assert.assertTrue(collapseTelefonesAbaInformacoesDoSeguroContratado.isDisplayed());
                tocarElemento(collapseTelefonesAbaInformacoesDoSeguroContratado, "Não foi possível tocar em Telefones");
                salvarEvidencia("Validar seção \"Telefones\" tela Contratados Seguro");
                rolarTelaAteFinal();
                Assert.assertTrue(collapseDadosDoParceiroAbaInformacoesDoSeguroContratado.isDisplayed());
                tocarElemento(collapseDadosDoParceiroAbaInformacoesDoSeguroContratado, "Não foi possível tocar em Dados do Parceiro");
                salvarEvidencia("Validar seção \"Dados do Parceiro\" tela Contratados Seguro");
                rolarTelaAteFinal();
                Assert.assertTrue(collapseCancelamentoAbaInformacoesDoSeguroContratado.isDisplayed());
                salvarEvidencia("Validar seção \"Cancelamento\" tela Contratados Seguro");
                Assert.assertTrue(informacoesProdutoDetalhesCardContratado.isDisplayed());
                break;
            case CREDITO:
                break;
            case ODONTO:
                break;
        }

        compararElementoTexto(labelEmVigenciaDetalhesCardContratado, Protecao.EM_VIGENCIA, MetodoComparacao.CONTEM);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("data atual: "+dtf.format(now));
        System.out.println("data contratação: "+dataContratacaoCardContratado.getText());
        Assert.assertTrue(dataContratacaoCardContratado.getText().contains(dtf.format(now)));
        Assert.assertTrue(abaInformacoesDoSeguro.isDisplayed());

        return this;
    }

    /**
     * Tocar Botão 'Simular'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar Botão 'Simular'")
    public ProtecaoTela tocarBotaoSimular() throws Exception {
        rolaTelaCima();
        aguardarCarregamentoElemento(botaoSimularCard);
        tocarElemento(botaoSimularCard, "Não foi possível clicar no botão SIMULAR");
        salvarEvidencia("Clicar no botão SIMULAR");
        return this;
    }

    /**
     * Tocar Botão 'Simular' na tela de Informações do Seguro
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar Botão 'Simular' na tela de Informações do Seguro")
    public ProtecaoTela tocarBotaoSimularInformacoesSeguro() throws Exception {
        aguardarCarregamentoElemento(segundoBotaoSimularContratarCard);
        tocarElemento(segundoBotaoSimularContratarCard, "Não foi possível clicar no botão SIMULAR");
        //TODO: Alterar o elemento segundoBotaoSimularContratarCard para segundoBotaoContratarCard (Alteração necesária pois no IOS os botões tem identificações diferentes)
        salvarEvidencia("Clicar no botão SIMULAR");
        return this;
    }

    /**
     * Validar seção "Acione Seu Seguro" tela Detalhes do Card Contratado
     *
     * @return
     * @throws Exception
     */

    @Step("Validar seção \"Acione Seu Seguro\" tela Detalhes do Card Contratado")
    public ProtecaoTela validarAcioneSeguroTelaDetalhesCardContratado(TipoProtecao tipoProtecao) throws Exception {
        rolarTelaAteInicio();
        aguardarCarregamentoElemento(headerTitulo);
        rolaTelaBaixo();
        salvarEvidencia("Validar seção \"Acione Seu Seguro\" tela Detalhes do Card Contratado");
        aguardarCarregamentoElemento(botaoAcioneSeuProduto);
        tocarElemento(botaoAcioneSeuProduto, "Não foi possível clicar no botão Acione seu produto");

        tocarElemento(acioneSeuSeguroCentralAtendimento, "Não foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroCentralAtendimento);
        tocarElemento(acioneSeuSeguroCentralAtendimento, "Não foi possível clicar no telefone Central de Atendimento");
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - Central de Atendimento");
        tocarElemento(cancelarPopUpLigacao, "Não foi possivel fechar o pop-up");

        tocarElemento(acioneSeuSeguroSac, "Não foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroSac);
        tocarElemento(acioneSeuSeguroSac, "Não foi possível clicar no telefone Central de Atendimento");
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - SAC");
        tocarElemento(cancelarPopUpLigacao, "Não foi possivel fechar o pop-up");

        tocarElemento(acioneSeuSeguroDeficiencia, "Não foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroDeficiencia);
        tocarElemento(acioneSeuSeguroDeficiencia, "Não foi possível clicar no telefone Central de Atendimento");
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - Deficiencia");
        tocarElemento(cancelarPopUpLigacao, "Não foi possivel fechar o pop-up");

        aguardarCarregamentoElemento(acioneSeuSeguroOuvidoria);
        tocarElemento(acioneSeuSeguroOuvidoria, "Não foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroOuvidoria);
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - Ouvidoria");
        tocarElemento(cancelarPopUpLigacao, "Não foi possivel fechar o pop-up");

        Assert.assertTrue(botaoInformacoesSeguroOuPlanoCardContratado.isDisplayed());

        return this;
    }

    /**
     * Tocar Botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar Botão 'Continuar'")
    public ProtecaoTela tocarBotaoContinuar() throws Exception {
        rolaTelaCima();
        aguardarCarregamentoElemento(botaoContinuarTelaContratacao);
        tocarElemento(botaoContinuarTelaContratacao, "Não foi possível clicar no botão CONTINUAR");
        salvarEvidencia("Clicar no botão CONTINUAR");
        return this;
    }

    /**
     * Validar tela "Simulação"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela 'Simular'")
    public ProtecaoTela validarTelaSimulacao() throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);
        Assert.assertTrue(headerBotaoVoltar.isDisplayed());
        Assert.assertTrue(iconeTelaContratacao.isDisplayed());
        compararElementoTexto(textoTelaContratacao, Protecao.CARENCIA, MetodoComparacao.CONTEM);
        compararElementoTexto(rodapeTelaContratacao, Protecao.URGENCIA, MetodoComparacao.CONTEM);
        Assert.assertTrue(botaoContinuarTelaContratacao.isDisplayed());
        return this;
    }

    /**
     * Validar tela "Participantes"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela 'Participantes'")
    public ProtecaoTela validarTelaParticipantes(TipoProtecao tipoProtecao) throws Exception {
        switch (tipoProtecao) {
            case ODONTO:
                aguardarCarregamentoElemento(tituloHeaderTelaSelecaoSegurados);
                compararElementoTexto(tituloHeaderTelaSelecaoSegurados, Protecao.PROTECAO, MetodoComparacao.CONTEM);
                Assert.assertTrue(headerBotaoVoltar.isDisplayed());
                Assert.assertTrue(botaoInformacoesTelaSelecaoSegurados.isDisplayed());
                compararElementoTexto(tituloTelaSelecaoSegurados, Protecao.TITULO_TELA_SELECAO_SEGURADOS_ODONTO, MetodoComparacao.CONTEM);
                compararElementoTexto(textoParaQuemTelaSelecaoSegurados, Protecao.PRA_QUEM, MetodoComparacao.CONTEM);
                Assert.assertTrue(radioPraMimTelaSelecaoSegurados.isDisplayed());
                Assert.assertTrue(radioApenasDependentesTelaSelecaoSegurados.isDisplayed());
                Assert.assertTrue(radioPraMimEDependentesTelaSelecaoSegurados.isDisplayed());
                compararElementoTexto(textoInformativoTelaSelecaoSegurados, Protecao.NOVE_PESSOAS, MetodoComparacao.CONTEM);
                compararElementoTexto(descricaoValorTelaSelecaoSegurados, Protecao.MENSALIDADE, MetodoComparacao.CONTEM);
                compararElementoTexto(valorTelaSelecaoSegurados, Protecao.SIMBOLO_REAIS, MetodoComparacao.CONTEM);
                Assert.assertTrue(botaoProximoTelaSelecaoSegurados.isDisplayed());
        }
        return this;
    }

    /**
     * Selecionar Participantes
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar 'Participantes'")
    public ProtecaoTela selecionarParticipantes(ParticipantesProtecaoOdonto participantes) throws Exception {
        switch (participantes)
        {
            case APENAS_DEPENDENTES:
                aguardarCarregamentoElemento(participantesRadioApenasDependentes);
                tocarElemento(participantesRadioApenasDependentes,"Erro ao selecionar Radiobutton");
                break;
        }
        return this;
    }

    /**
     * Adicionar Participante
     *
     * @return
     * @throws Exception
     */
    @Step("Adicionar 'Participante'")
    public ProtecaoTela adicionarParticipante() throws Exception {
        int numAntes = Integer.parseInt(numeroDependentes.getText());
        aguardarCarregamentoElemento(aumentarParticipante);
        tocarElemento(aumentarParticipante,"Erro ao aumentar Participantes");
        Assert.assertEquals(Integer.parseInt(numeroDependentes.getText()), numAntes + 1);
        return this;
    }

    /**
     * Remover Participante
     *
     * @return
     * @throws Exception
     */
    @Step("Remover 'Participante'")
    public ProtecaoTela removerParticipante() throws Exception {
        int numAntes = Integer.parseInt(numeroDependentes.getText());
        aguardarCarregamentoElemento(diminuirParticipante);
        tocarElemento(diminuirParticipante,"Erro ao diminuir participantes");
        Assert.assertEquals(Integer.parseInt(numeroDependentes.getText()), numAntes - 1);
        return this;
    }

    /**
     * Tocar botão voltar (sup/esq)
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão voltar (sup/esq)")
    public ProtecaoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão voltar (sup/esq)");
        aguardarCarregamentoElemento(headerBotaoVoltar);
        tocarElemento(headerBotaoVoltar, "Não foi possível clicar no botao \"voltar\"");
        return this;
    }

    /**
     * Tocar botão cancelar "lixeira" Protecao (sup/dir)
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão cancelar \"lixeira\" Protecao (sup/dir)")
    public ProtecaoTela tocarBotaoCancelarProtecao() throws Exception {
        salvarEvidencia("Cancelar seguro através da aba Cancelamento");
        aguardarCarregamentoElemento(collapseCancelamentoAbaInformacoesDoSeguroContratado);
        tocarElemento(collapseCancelamentoAbaInformacoesDoSeguroContratado, "Não foi possível clicar na aba \"Cancelamento\"");

        return this;
    }

    /**
     * Validar layout Tela de Cancelar Protecao
     *
     * @return
     * @throws Exception
     */
    @Step("Validar layout Tela de Cancelar Protecao")
    public ProtecaoTela validarLayoutTelaCancelarProtecao(TipoProtecao tipoProtecao) throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        salvarEvidencia("Validar layout Tela de Cancelar Protecao");
        compararElementoTexto(headerTitulo, Protecao.CANCELAMENTO, MetodoComparacao.CONTEM);
        Assert.assertTrue(headerBotaoVoltar.isDisplayed());

        switch (tipoProtecao) {
            case DEBITO:
            case CREDITO:
                compararElementoTexto(tituloTelaExclusaoSeguro, Protecao.PERGUNTA_MOTIVO_CANCELAMENTO_PLANO, MetodoComparacao.CONTEM);
                break;
            case ODONTO:
                break;
        }

        compararElementoTexto(subtituloTelaExclusaoSeguro, Protecao.CONTA_MOTIVO_PRA_GENTE, MetodoComparacao.CONTEM);
        compararElementoTexto(botaoMotivoCancelamentoTelaExclusaoSeguro, Protecao.MOTIVO_CANCELAMENTO, MetodoComparacao.CONTEM);
        Assert.assertTrue(!botaoConfirmarExclusaoSeguro.isEnabled());

        return this;
    }

    /**
     * Selecionar motivo do cancelamento
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar motivo do cancelamento")
    public ProtecaoTela selecionarMotivoCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoMotivoCancelamentoTelaExclusaoSeguro);
        salvarEvidencia("Selecionar motivo do cancelamento");
        tocarElemento(botaoMotivoCancelamentoTelaExclusaoSeguro, "Não foi possível clicar no botao \"Motivo do Cancelamento\"");
        aguardarCarregamentoElemento(tituloHeaderTelaConfirmacaoCancelamento);
        tocarElemento(opcao1MotivoCancelamento, "Não foi possível clicar no botao \"Motivo 1\" do Cancelamento da proteção");
        tocarElemento(botaoHeaderConfirmar, "Não foi possível clicar no botao \"confirmar\" (sup/dir)");
        compararElementoTexto(botaoMotivoCancelamentoTelaExclusaoSeguro, Protecao.NAO_PRECISO_MAIS, MetodoComparacao.CONTEM);
        salvarEvidencia("Motivo do cancelamento selecionado");
        return this;
    }

    /**
     * Tocar no botão "Confirmar" da tela Cancelamento Protecao
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão \"Confirmar\" da tela Cancelamento Protecao")
    public ProtecaoTela tocarBotaoConfirmarTelaCancelamentoProtecao() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmarExclusaoSeguro);
        salvarEvidencia("Tocar no botão \"Confirmar\" da tela Cancelamento Protecao");
        tocarElemento(botaoConfirmarExclusaoSeguro, "Não foi possível clicar no botao \"CONFIRMAR\"");
        return this;
    }

    /**
     * Validar layout tela Cancelamento efetuado com sucesso
     *
     * @return
     * @throws Exception
     */
    @Step("Validar layout tela Cancelamento efetuado com sucesso")
    public ProtecaoTela validarLayoutTelaCancelamentoComSucesso() throws Exception {
        aguardarCarregamentoElemento(tituloHeaderTelaConfirmacaoCancelamento);
        salvarEvidencia("Validar layout tela Cancelamento efetuado com sucesso");
        compararElementoTexto(tituloTelaExclusaoSeguro, Protecao.PEDIDO_CANCELAMENTO_EFETUADO, MetodoComparacao.CONTEM);
        Assert.assertTrue(botaoConcluirTelaSucessoExclusaoSeguro.isDisplayed());
        return this;
    }

    /**
     * Acessar "Termos e Condições"
     *
     * @return
     * @throws Exception
     */
    @Step("Acessar \"Termos e Condições\"")
    public ProtecaoTela acessarTermosCondicoes() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(botaoLerTermosCondicoesConfirmacaoDeDados);
        salvarEvidencia("Acessar \"Termos e Condições\"");
        tocarElemento(botaoLerTermosCondicoesConfirmacaoDeDados, "Não foi possível clicar no botão ler Termos e Condicoes");
        return this;
    }

    /**
     * Trocar campo data de pagamento
     *
     * @return
     * @throws Exception
     */
    @Step("Trocar campo data de pagamento")
    public ProtecaoTela trocarDataPagamentoTelaCalendario(TipoProtecao tipoProtecao) throws Exception {
        salvarEvidencia("Trocar campo data de pagamento");
        aguardarCarregamentoElemento(botaoDataPagamentoConfirmacaoDeDados);
        String dateBefore=botaoDataPagamentoConfirmacaoDeDados.getText();
        System.out.println(">>>>data antes: "+dateBefore);
        salvarEvidencia("Trocar campo data de pagamento");
        tocarElemento(botaoDataPagamentoConfirmacaoDeDados, "Não foi possível clicar no botão \"Data do Pagamento\"");
        salvarEvidencia("Selecionar nova data de pagamento");
        aguardarCarregamentoElemento(botaoDataPagamentoDia5);
        tocarElemento(botaoDataPagamentoDia5, "Não foi possível selecionar \"Data do Pagamento\"");
        aguardarCarregamentoElemento(botaoConfirmarCalendario);
        tocarElemento(botaoConfirmarCalendario, "Não foi possível clicar no botão \"confirmar\" do calendario");
        aguardarCarregamentoElemento(botaoDataPagamentoConfirmacaoDeDados);
        compararElementoTexto(labelDataPagamentoConfirmacaoDeDados, Protecao.TODO_DIA_5, MetodoComparacao.CONTEM);
        salvarEvidencia("Campo data de pagamento alterado");
        return this;
    }

    /**
     * Clicar no botão Detalhes na tela cards contratados
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no botão Detalhes na tela cards contratados")
    public ProtecaoTela tocarBotaoDetalhesCardContratado() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(botaoDetalhesPrimeiroCardContratado);
        salvarEvidencia("Clicar no botão Detalhes na tela cards contratados");
        tocarElemento(botaoDetalhesPrimeiroCardContratado, "Não foi possível clicar no botão Detalhes da tela cards contratados");
        return this;
    }

    /**
     * Clicar no botão Contratar na tela cards Cartão debito
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no botão Contratar na tela cards Cartão debito")
    public ProtecaoTela selecionarCardProtecaoCartaoDebito() throws Exception {
            rolaTelaBaixo();
            aguardarCarregamentoElemento(tituloCard);
            aguardarCarregamentoElemento(textoCardValidar);
            String CardCartaoDebito = "Proteção contra transações indevidas";
            salvarEvidencia("Procurando o Card de proteção Cartão Debito para Contratar.");
            for (int i = 0; i < 6; i++) {
                String textoCard = textoCardValidar.getText();
                if (textoCard.equals(CardCartaoDebito)) {
                    aguardarCarregamentoElemento(btnContratarProtecaoDebito);
                    salvarEvidencia("Clicar no botão Simular na tela cards de cartão de debito.");
                    tocarElemento(btnContratarProtecaoDebito, "Não foi possível clicar no botão Simular cards contrataçao cartao debito");
                    break;
                } else {
                    deslizar(Direcao.ESQUERDA, 30,80);
                }
            }
           return this;
    }

    /**
     * Clicar no botão Simular na tela de card de Odonto
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no botão Simular na tela de card de Odonto")
    public ProtecaoTela selecionarCardSegurosOdonto() throws Exception {
        aguardarCarregamentoElemento(textoCardValidar);
        String CardOdonto = "Proteja seu cartão de débito contra transações decorrentes de roubo do cartão ou coação.";
        salvarEvidencia("Procurando o Card de proteção Odonto para Contratar.");
        for (int i = 0; i < 6; i++) {
            String textoCard = textoCardValidar.getText();
            if (textoCard.equals(CardOdonto)) {
                aguardarCarregamentoElemento(botaoSimularCard);
                salvarEvidencia("Clicar no botão Simular na tela card de Odonto.");
                tocarElemento(botaoSimularCard, "Não foi possível clicar no botão Simular card contratacao do Odonto");
                break;
            } else {
                deslizar(Direcao.ESQUERDA, 30, 80);
            }
        }
        return this;
    }


    /**
     * Clicar no check box termo e condição na tela cards Cartão debito
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no check box termo e condição na tela cards Cartão debito")
    public ProtecaoTela aceitarTermosCondicoesCartaoDebito() throws Exception {
        salvarEvidencia("Tela de proteção Cartão Debito Termo e Condições.");
        rolaTelaBaixo();
        aguardarCarregamentoElemento(selecionarCheckTermoCondicoes);
        salvarEvidencia("Clicar no check box Termo e condições de cartão de debito.");
        tocarElemento(selecionarCheckTermoCondicoes, "Não foi possível Clicar no check box Termo e condições de cartão de debito.");
        return this;
    }
    /**
     * Clicar no botao contratar apos aceitar check box termo e condição na tela cards Cartão debito
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no botao contratar apos aceitar check box termo e condição na tela cards Cartão debito")
    public ProtecaoTela btnContratarProtecaoCartaoDebito() throws Exception {
        salvarEvidencia("Tela de proteção Cartão Debito Termo e Condições.");
        aguardarCarregamentoElemento(botaoContratar);
        salvarEvidencia("Clicar no botao contratar apos aceitar Termo e condições de cartão de debito.");
        tocarElemento(botaoContratar, "Não foi possível Clicar no botão Contratar apos aceitar termos e condições.");
        return this;
    }

    /**
     * Validar contratacao na tela cards Cartão debito
     *
     * @return
     * @throws Exception
     */
    @Step("Validar contratacao na tela cards Cartão debito")
    public ProtecaoTela validarContratacaoProtecaoCartaoDebito() throws Exception {
        salvarEvidencia("Tela de proteção Cartão Debito Concluir contratação.");
        aguardarCarregamentoElemento(validarContratacaoCartaoDebito);
        compararElementoTexto(validarContratacaoCartaoDebito, ProtecaoCartaoDebito.VALIDARCONTRATACAOCARTAODEBITO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validação da contratação de proteção de cartão de debito.");
        return this;
    }

    /**
     * clicar botao concluir contratacao na tela cards Cartão debito
     *
     * @return
     * @throws Exception
     */
    @Step("clicar botao concluir contratacao na tela cards Cartão debito")
    public ProtecaoTela btnConcluirProtecaoCartaoDebito() throws Exception {
        salvarEvidencia("Tela de proteção Cartão Debito Concluir contratação e validação.");
        aguardarCarregamentoElemento(botaoConcluir);
        tocarElemento(botaoConcluir,"Não foi possivel clicar no botão VER DETALHES DO PLANO");
        salvarEvidencia("concluir a contratação de proteção de cartão de debito e voltando ao cards.");
        return this;
    }
}
