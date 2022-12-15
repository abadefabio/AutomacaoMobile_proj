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

    //Bot�o confirmar - calendario
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system_option")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmarCalendario;

    //Bot�o de voltar
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement headerBotaoVoltar;

    //T�tulo do Header
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTitulo;

    //T�tulo do Header Confirma��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONFIRMA��O\"]")
    private MobileElement headerTituloConf;

    //Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/background_card_protection")
    //@iOSXCUITFindBy()
    private MobileElement card;

    //T�tulo - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtTitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"chip\"])[3]/XCUIElementTypeOther")
    private MobileElement tituloCard;

    //T�tulo - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Plano Dental\"]")
    private MobileElement tituloCardDetalhes;

    //T�tulo - Confirma��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title_insurance")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement tituloCardConfirmacao;

    //Subt�tulo - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtSubtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"subtitleLabel\"])[2]")
    private MobileElement subtituloCard;

    //Subt�tulo - Card - Detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtSubtitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tenha mais motivos para sorrir\"]")
    private MobileElement subtituloCardDetalhes;

    //Subt�tulo - Card Detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_subtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[3]")
    private MobileElement subtituloCardAberto;

    //�cone - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_insurance")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//following-sibling::XCUIElementTypeImage | //XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//..//XCUIElementTypeCell//XCUIElementTypeImage[@visible='true'])[1]")
    private MobileElement iconeCard;

    //Descri��o - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDescription")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[5]")
    private MobileElement descricaoCard;

    //Descri��o - Card Detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_description")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[4]")
    private MobileElement descricaoCardAberto;

    //Descri��o - Card Detalhes Odonto
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tenha mais motivos para sorrir\"]")
    private MobileElement descricaoCardOdonto;

    //Descri��o Valor - Card
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

    //Bot�o "Detalhes"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnDetails")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"DETALHES\" and @visible='true'])[1]")
    private MobileElement botaoDetalhes;

    //bot�o "Simular" - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_accept")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SIMULAR\"`][2]")
    private MobileElement botaoSimularCard;

    //bot�o "Contratar" - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_action_button_label")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CONTRATAR\"])[1]")
    private MobileElement botaoContratarCard;

    //bot�o "Contratar" - Card
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

    //Tela de Participantes - Bot�o Diminuir
    @AndroidFindBy(id = "br.com.bradesco.next:id/left_img")
    private MobileElement diminuirParticipante;

    //Tela de Participantes - Bot�o Aumentar
    @AndroidFindBy(id = "br.com.bradesco.next:id/right_img")
    private MobileElement aumentarParticipante;

    //Tela de Participantes - N�mero de Dependentes
    @AndroidFindBy(id = "br.com.bradesco.next:id/number_et")
    private MobileElement numeroDependentes;

    //Aba "Contratados" - Card "Sem Seguros" - �cone
    @AndroidFindBy(id = "br.com.bradesco.next:id/imageView11")
    //@iOSXCUITFindBy()
    private MobileElement iconeAbaContratadosCardSemSeguros;

    //Aba "Contratados" - Card "Sem Seguros" - T�tulo
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

    //Aba "Contratados" - �cone Seguro Contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_contracted_insurance")
    //@iOSXCUITFindBy()
    private MobileElement iconeSeguroContratado;

    //Aba "Contratados" - Status Seguro Contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtStatus")
    //@iOSXCUITFindBy()
    private MobileElement statusSeguroContratado;

    //Aba "Informa��es do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_active_insurance")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"INFORMA��ES DO PRODUTO\"])[1]")
    private MobileElement abaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Descri��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/insuranceTopicsDescription")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Informa��es do produto')]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement descricaoAbaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Collapse Cobertura
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[1]/android.widget.LinearLayout/android.widget.RelativeLayout")
    @iOSXCUITFindBy(accessibility = "Cobertura Expandir")
    private MobileElement collapseCoberturaAbaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Collapse Carencia
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[2]/android.widget.LinearLayout/android.widget.RelativeLayout")
    @iOSXCUITFindBy(accessibility = "Car�ncia Expandir")
    private MobileElement collapseCarenciaAbaInformacoesDoSeguro;

    @AndroidFindBy(id = "br.com.bradesco.next:id/txtInsuranceName")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[1]")
    private MobileElement labelPlanoConfirmacaoDeDados;

    //Aba "Informa��es do Seguro" - Collapse Dados do Parceiro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[3]/android.widget.LinearLayout/android.widget.RelativeLayout")
    @iOSXCUITFindBy(accessibility = "Dados do parceiro Expandir")
    private MobileElement collapseDadosParceiroAbaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Collapse - Cobertura - Texto
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Cobertura")
    private MobileElement textoCollapseCoberturaAbaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Collapse - Car�ncia - Texto
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    //@iOSXCUITFindBy()
    private MobileElement textoCollapseCarenciaAbaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Collapse - Dados Parceiro - Texto
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    //@iOSXCUITFindBy()
    private MobileElement textoCollapseDadosParceiroAbaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Collapse - Cobertura - Seta
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"expandir\"`][3]")
    private MobileElement setaCollapseAbaCoberturaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Collapse - Car�ncia - Seta
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"expandir\"`][2]")
    private MobileElement setaCollapseAbaCarenciaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Collapse - Dados do Parceiro - Seta
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"expandir\"`][1]")
    private MobileElement setaCollapseDadosParceiroAbaInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Collapse - Texto Interno
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_item")
    //@iOSXCUITFindBy(N�o � poss�vel mapear no momento)
    private MobileElement textoInternoCollapseAbaInformacoesDoSeguro;

    //Aba "Detalhes/Informa��es do Seguro" - Rodap�
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_insurance_details_footer")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement rodapeDetalhesSecaoInformacoesDoSeguro;

    //Aba "Confirmacao de dados/Informa��es do Seguro" - Rodap�
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDetailsFooter")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONTRATAR\"]/../../../../XCUIElementTypeOther)[2]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    private MobileElement rodapeConfirmacaoDeDadosSecaoInformacoesDoSeguro;

    //Aba "Informa��es do Seguro" - Bot�o "Simular"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_accept_2")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"SIMULAR\" or @name=\"CONTRATAR\"])[2]")
    private MobileElement segundoBotaoSimularContratarCard;

    //Aba "Informa��es do Seguro" - Bot�o "Contratar"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnAccept2")
    @iOSXCUITFindBy(iOSClassChain = "(//XCUIElementTypeButton[@name=\"CONTRATAR\"])[2]")
    private MobileElement segundoBotaoContratarCard;

    //Tela de Contrata��o - �cone
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView")
    //@iOSXCUITFindBy()
    private MobileElement iconeTelaContratacao;

    //Tela de Contrata��o - Texto
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_info_message")
    //@iOSXCUITFindBy()
    private MobileElement textoTelaContratacao;

    //Tela de Contrata��o - Rodap�
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_info_message_footer")
    //@iOSXCUITFindBy()
    private MobileElement rodapeTelaContratacao;

    //Tela de Contrata��o - Bot�o "Continuar"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnContinue")
    //@iOSXCUITFindBy()
    private MobileElement botaoContinuarTelaContratacao;

    //Tela de Sele��o de Segurados - T�tulo do Header
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloHeaderTelaSelecaoSegurados;

    //Tela Confirmacao cancelamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"PROTE��O\"`]")
    private MobileElement tituloHeaderTelaConfirmacaoCancelamento;

    //Tela de Sele��o de Segurados - Bot�o de Informa��es
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_info")
    //@iOSXCUITFindBy()
    private MobileElement botaoInformacoesTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - T�tulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_info_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement tituloTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - texto "Para quem?"
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    //@iOSXCUITFindBy()
    private MobileElement textoParaQuemTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Radio "Pra mim"
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_dental_for_me")
    //@iOSXCUITFindBy()
    private MobileElement radioPraMimTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Radio "Pra mim e dependentes"
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_dental_has_dependents")
    //@iOSXCUITFindBy()
    private MobileElement radioPraMimEDependentesTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Radio "Apenas Dependentes"
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_dental_only_dependents")
    //@iOSXCUITFindBy()
    private MobileElement radioApenasDependentesTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Texto Informativo
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    //@iOSXCUITFindBy()
    private MobileElement textoInformativoTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Descri��o do valor
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[3]")
    //@iOSXCUITFindBy()
    private MobileElement descricaoValorTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Valor
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_month_value")
    //@iOSXCUITFindBy()
    private MobileElement valorTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Label Adicionar Dependentes
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
    //@iOSXCUITFindBy()
    private MobileElement labelAdicionarDependentesTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Quantidade Atual
    @AndroidFindBy(id = "br.com.bradesco.next:id/number_et")
    private MobileElement quantidadeAtualTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Diminuir
    @AndroidFindBy(id = "br.com.bradesco.next:id/left_img")
    private MobileElement diminuirTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Aumentar
    @AndroidFindBy(id = "br.com.bradesco.next:id/right_img")
    //@iOSXCUITFindBy()
    private MobileElement aumentarTelaSelecaoSegurados;

    //Tela de Sele��o de Segurados - Bot�o "Pr�ximo"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnNext")
    //@iOSXCUITFindBy()
    private MobileElement botaoProximoTelaSelecaoSegurados;

    //Tela de Confirma��o - Label Campo
    @AndroidFindBy(id = "br.com.bradesco.next:id/fl_container_optional")
    //@iOSXCUITFindBy()
    private MobileElement labelCampoTelaConfirmacao;

    //Tela de Confirma��o - Campo "Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtInsuranceName")
    //@iOSXCUITFindBy()
    private MobileElement campoSeguroTelaConfirmacao;

    //Tela de Confirma��o - Campo "N�mero de Pessoas Beneficiadas"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtBeneficiariesQuantity")
    //@iOSXCUITFindBy()
    private MobileElement campoNoPessoasBeneficiadasTelaConfirmacao;

    //Tela de Confirma��o - Texto Radio Grupo
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_details_dental_type_payment")
    //@iOSXCUITFindBy()
    private MobileElement textoRadioGrupoTelaConfirmacao;

    //Tela de Confirma��o - Linha Horizontal
    @AndroidFindBy(id = "br.com.bradesco.next:id/view_line")
    //@iOSXCUITFindBy()
    private MobileElement linhaHorizontalTelaConfirmacao;

    //Label - Tipo de Pagamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_details_dental_type_payment")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"TIPO DE PAGAMENTO\"`]")
    private MobileElement   labelTipoPagamento;

    //Radio - Tipo de Pagamento - Mensal
    @AndroidFindBy(id = "br.com.bradesco.next:id/month_checker")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[1]")
    private MobileElement   radioButtonTipoPagamentoMensal;

    //Label Radio - Tipo de Pagamento - Mensal
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Selecionado,Mensal,bot�o de sele��o,\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[1]")
    private MobileElement labelRadioButtonTipoPagamentoMensal;

    //Radio - Tipo de Pagamento - Anual
    @AndroidFindBy(id = "br.com.bradesco.next:id/annual_checker")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[2]")
    private MobileElement radioButtonTipoPagamentoAnual;

    //Label Radio - Tipo de Pagamento - Anual
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\",N�o selecionado,Anual com desconto,bot�o de sele��o,\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[2]")
    private MobileElement labelRadioButtonTipoPagamentoAnual;

    //Valor Radio - Tipo de Pagamento - Mensal
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[1]")
    private MobileElement valorRadioButtonTipoPagamentoMensal;

    //Valor Radio - Tipo de Pagamento - Anual
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[2]")
    private MobileElement valorRadioButtonTipoPagamentoAnual;

    //Label Data do Pagamento
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"DATA DO PAGAMENTO\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[3]")
    private MobileElement labelDataPagamento;

    //Tela de Confirma��o - Radio Button
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_circle")
    //@iOSXCUITFindBy()
    private MobileElement radioButtonTelaConfirmacao;

    //Tela de Confirma��o - Descri��o Radio Button
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    //@iOSXCUITFindBy()
    private MobileElement descricaoRadioButtonTelaConfirmacao;

    //Tela de Confirma��o - Label "Valor Total"
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"VALOR TOTAL\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[5]")
    private MobileElement labelValorTotal;

    //Tela de Confirma��o - Label "Vig�ncia"
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"VIG�NCIA\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeTextView")
    private MobileElement labelVigencia;

    //Tela de Confirma��o - Valor Radio Button
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text_bottom")
    //@iOSXCUITFindBy()
    private MobileElement valorRadioButtonTelaConfirmacao;

    //Tela de Confirma��o - Campo "Data do Pagamento"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtPaymentDay")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[3]")
    private MobileElement campoDataPagamentoTelaConfirmacao;

    //Tela de Confirma��o - Campo "Forma de Pagamento"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtPaymentForm")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[4]")
    private MobileElement campoFormaPagamentoTelaConfirmacao;

    //Tela de Confirma��o - Campo "Valor Total"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtTotalValue")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[5]")
    private MobileElement campoValorTotalTelaConfirmacao;

    //Tela de Confirma��o - Campo "Vig�ncia"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtVigency")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeTextView")
    private MobileElement campoVigenciaTelaConfirmacao;

    //Tela de Confirma��o - Checkbox
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_confirm_checkbox_terms")
    @AndroidFindBy(id = "br.com.bradesco.next:id/debito_confirm_checkbox_terms")
    //@iOSXCUITFindBy()
    private MobileElement checkboxTelaConfirmacao;

    //Tela de Confirma��o - Bot�o "?" (No IOS o bot�o de "?" equivale ao bot�o ">")
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_confirm_checkbox_terms")
    @iOSXCUITFindBy(accessibility = "avan�ar")
    private MobileElement botaoInterrogacaoTelaConfirmacao;

    //Tela de Confirma��o - Texto Aceite
    @AndroidFindBy(id = "br.com.bradesco.next:id/webview")
    //@iOSXCUITFindBy()
    private MobileElement textoAceiteTelaConfirmacao;

    //Tela de Confirma��o - Aba "Informa��es do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_info")
    //@iOSXCUITFindBy()
    private MobileElement abaInformacoesDoSeguroTelaConfirmacao;

    //Tela de Confirma��o - Bot�o "Contratar"
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_btn_hire")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONTRATAR\"`]")
    private MobileElement botaoContratarOdontoTelaConfirmacao;

    //Tela de Sucesso - �cone
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView")
    //@iOSXCUITFindBy()
    private MobileElement iconeTelaSucesso;

    //Tela de Sucesso - T�tulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_cancellation_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloTelaSucesso;

    //Tela de Sucesso - Descri��o
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

    //Tela de Sucesso - N�mero da Proposta
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_contracting_success_protocol")
    //@iOSXCUITFindBy()
    private MobileElement numeroPropostaTelaSucesso;

    //Tela de Sucesso - Bot�o "Concluir"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_debit_card_success_contracting")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONCLUIR\"`]")
    private MobileElement botaoConcluirTelaSucesso;

    //Tela de exclus�o com sucesso - Bot�o "Concluir"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_receipt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONCLUIR\"`]")
    private MobileElement botaoConcluirTelaSucessoExclusaoSeguro;

    //Tela de Sucesso - Aba "Informa��es do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_product_information_title_debit_card_success")
    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeOther[`label == \"informa��es do produto\"`]")
    private MobileElement abaInformacoesSeguroTelaSucesso;

    //Tela de Sucesso - Aba "Informa��es do Seguro Detalhes"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_debit_card_success_contracting_information")
    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeOther[`label == \"informa��es do produto\"`]")
    private MobileElement abaInformacoesSeguroDetalhesTelaSucesso;

    //Tela de Seguro Contratado - �cone Lixeira
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_next_option")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]/XCUIElementTypeButton[2]")
    private MobileElement iconeLixeiraTelaSeguroContratado;

    //Tela de Seguro Contratado - T�tulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloSeguroContratado;

    //Tela de Seguro Contratado - Subt�tulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_subtitle")
    //@iOSXCUITFindBy()
    private MobileElement subtituloSeguroContratado;

    //Tela de Seguro Contratado - Descri��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_description")
    //@iOSXCUITFindBy()
    private MobileElement descricaoSeguroContratado;

    //Tela de Seguro Contratado - �cone
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_main_icon")
    //@iOSXCUITFindBy()
    //private MobileElement iconeSeguroContratado;

    //Tela de Seguro Contratado - Label Data da Contrata��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtPeriod")
    //@iOSXCUITFindBy()
    private MobileElement labelDataContratacaoSeguroContratado;

    //Tela de Seguro Contratado - Data da Contrata��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_date")
    //@iOSXCUITFindBy()
    private MobileElement dataContratacaoSeguroContratado;

    //Tela de Seguro Contratado - Label N�mero Proposta
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtCert")
    //@iOSXCUITFindBy()
    private MobileElement labelNumeroPropostaSeguroContratado;

    //Tela de Seguro Contratado - N�mero Proposta
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_details_certified_number")
    //@iOSXCUITFindBy()
    private MobileElement numeroPropostaSeguroContratado;

    //Tela de Seguro Contratado - Aba "Acione seu Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_active_insurance")
    //@iOSXCUITFindBy()
    private MobileElement abaAcioneSeuSeguroCardContratado;

    //Tela de Seguro Contratado - Bot�o "Informa��es do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_insurance_info")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"INFORMA��ES DO PRODUTO\"`]")
    private MobileElement botaoInformacoesSeguroOuPlanoCardContratado;

    //Tela de Seguro Contratado - Descri��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_phone_name")
    //@iOSXCUITFindBy()
    private MobileElement descricaoInformacoesSeguro;

    //Tela de Seguro Contratado - Telefone
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_phone_phone")
    //@iOSXCUITFindBy()
    private MobileElement telefoneInformacoesSeguro;

    //Tela de Seguro Contratado - Subt�tulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_phone_hours")
    //@iOSXCUITFindBy()
    private MobileElement subtituloInformacoesSeguro;

    //Tela de Seguro Contratado - Linha Horizontal
    @AndroidFindBy(id = "br.com.bradesco.next:id/v_insurance_divider")
    //@iOSXCUITFindBy()
    private MobileElement linhaHorizontalInformacoesSeguro;

    //Tela de Adi��o de Dependente - T�tulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloAdicaoDependente;

    //label titulo - Informa��es do produto - tela contratados/btn_informacoes do seguroOuPlano
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement labelInformacoesProduto;

    //Tela de Adi��o de Dependente - Rodap�
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_bottom")
    //@iOSXCUITFindBy()
    private MobileElement rodapeAdicaoDependente;

    //Rodape - Tela Informacoes do produto
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_bottom")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[5]")
    private MobileElement rodapeInformacoesDoProduto;

    //Tela de Adi��o de Dependente - Seta
    @AndroidFindBy(id = "br.com.bradesco.next:id/iconExpandCollapse")
    //@iOSXCUITFindBy()
    private MobileElement setaAdicaoDependente;

    //Tela de Adi��o de Dependente - Bot�o Pr�ximo
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_beneficiaries_next_button")
    //@iOSXCUITFindBy()
    private MobileElement botaoProximoAdicaoDependente;

    //Tela de Adi��o de Dependente - Campo "Nome Completo"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtName")
    //@iOSXCUITFindBy()
    private MobileElement campoNomeCompletoAdicaoDependente;

    //Tela de Adi��o de Dependente - bot�o Editar "Nome Completo"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, bot�o\"])[1]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarNomeCompletoAdicaoDependente;

    //Tela de Adi��o de Dependente - Campo "Data de Nascimento"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtBirthDate")
    //@iOSXCUITFindBy()
    private MobileElement campoDataNascimentoAdicaoDependente;

    //Tela de Adi��o de Dependente - bot�o Editar "Data de Nascimento"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, bot�o\"])[2]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarDataNascimentoAdicaoDependente;

    //Tela de Adi��o de Dependente - Campo "CPF"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtCPF")
    //@iOSXCUITFindBy()
    private MobileElement campoCpfAdicaoDependente;

    //Tela de Adi��o de Dependente - bot�o Editar "CPF"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, bot�o\"])[3]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarCpfAdicaoDependente;

    //Tela de Adi��o de Dependente - Campo "Nome da M�e"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtMothersName")
    //@iOSXCUITFindBy()
    private MobileElement campoNomeDaMaeAdicaoDependente;

    //Tela de Adi��o de Dependente - Bot�o Editar "Nome da M�e"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, bot�o\"])[4]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarNomeDaMaeAdicaoDependente;

    //Tela de Adi��o de Dependente - Campo "Sexo"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtGender")
    //@iOSXCUITFindBy()
    private MobileElement campoSexoAdicaoDependente;

    //Tela de Adi��o de Dependente - Seta "Sexo"
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Editar, bot�o\"]/android.widget.ImageView")
    //@iOSXCUITFindBy()
    private MobileElement setaSexoAdicaoDependente;

    //Tela de Adi��o de Dependente - Bot�o Confirmar
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_apply")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoHeaderConfirmar;

    //Tela de Adi��o de Dependente - Campo "Parentesco"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtKinship")
    //@iOSXCUITFindBy()
    private MobileElement campoParentescoAdicaoDependente;

    //Tela de Adi��o de Dependente - Seta "Parentesco"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, bot�o\"])[6]")
    //@iOSXCUITFindBy()
    private MobileElement setaParentescoAdicaoDependente;

    //Tela de Exclus�o de Seguro - �cone
    @AndroidFindBy(id = "br.com.bradesco.next:id/imageView11")
    //@iOSXCUITFindBy()
    private MobileElement iconeTelaExclusaoSeguro;

    //Tela de Exclus�o de Seguro - T�tulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/credit_success_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement tituloTelaExclusaoSeguro;

    //Tela de Exclus�o de Seguro - Subt�tulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/credit_success_subtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[2]")
    private MobileElement subtituloTelaExclusaoSeguro;

    //Tela de Exclus�o de Seguro - Texto Cancelamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField")
    private MobileElement botaoMotivoCancelamentoTelaExclusaoSeguro;

    //Tela de Exclus�o de Seguro - Seta
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon")
    //@iOSXCUITFindBy()
    private MobileElement setaTelaExclusaoSeguro;

    //Tela de Exclus�o de Seguro - Bot�o Confirmar
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_cancellation_btn_confirm")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONFIRMAR\"`]")
    private MobileElement botaoConfirmarExclusaoSeguro;

    //Tela de Sucesso de Exclus�o de Seguro - �cone
    @AndroidFindBy(id = "br.com.bradesco.next:id/imageView3")
    //@iOSXCUITFindBy()
    private MobileElement iconeTelaSucessoExclusaoSeguro;

    //Tela de Sucesso de Exclus�o de Seguro - T�tulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/credit_success_title")
    //@iOSXCUITFindBy()
    private MobileElement tituloTelaSucessoExclusaoSeguro;

    //Tela de Sucesso de Exclus�o de Seguro - Label Proposta
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_cancellation_success_description")
    //@iOSXCUITFindBy()
    private MobileElement labelPropostaTelaSucessoExclusaoSeguro;

    //Tela de Sucesso de Exclus�o de Seguro - N�mero Proposta
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

    //campo "Seguro" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_credit_card_number_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"CONFIRMA��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[1]")
    private MobileElement labelSeguroConfirmacaoDeDados;

    //campo "Cartao Assegurado" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_subscription_type_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[2]")
    private MobileElement labelCartaoAsseguradoConfirmacaoDeDados;

    //campo "Valor Mensal" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_mensal_value_value")
    private MobileElement labelValorMensal;

    //campo "Data do Pagamento" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_date_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[3]")
    private MobileElement labelDataPagamentoConfirmacaoDeDados;

    //campo "Forma de Pagamento" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_form_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[4]")
    private MobileElement labelFormaPagamentoConfirmacaoDeDados;

    //bot�o "Editar Data de Pagamento" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_edit_date")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[3]")
    private MobileElement botaoDataPagamentoConfirmacaoDeDados;

    //Bot�o data 'dia 5' - calendario
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[@text=\"Todo dia 5\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoDataPagamentoDia5;

    //Botao Ok tela Erro
    @AndroidFindBy(id="br.com.bradesco.next:id/bt_confirm")
    private MobileElement botaoOkTelaErro;

    //N�mero de Pessoas Beneficiadas
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtBeneficiariesQuantity")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[2]")
    private MobileElement numeroPessoasBeneficiadas;

    //campo "Valor Total" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtTotalValue")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[5]")
    private MobileElement labelValorTotalConfirmacaoDeDados;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"FORMA DE PAGAMENTO\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[4]")
    private MobileElement labelFormaPagamento;

    //campo "Vigencia" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_vingency")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@visible=\"true\"]/XCUIElementTypeStaticText[3]")
    private MobileElement labelVigenciaConfirmacaoDeDados;

    //check box "Termos e Condicoes" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ncl_terms")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Selecionar\"]/XCUIElementTypeOther")
    private MobileElement checkBoxSeguroTermosCondicoesConfirmacaoDeDados;

    //bot�o ler "Termos e Condicoes" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_details_terms_button")
    @iOSXCUITFindBy(accessibility = "(//XCUIElementTypeOther[@name=\"CONTRATAR\"]/preceding-sibling::XCUIElementTypeOther)[2]/XCUIElementTypeButton")
    private MobileElement botaoLerTermosCondicoesConfirmacaoDeDados;

    //bot�o voltar "Termos e Condicoes" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Li e aceito os termos e condi��es. . Selecionar\"])[1]/XCUIElementTypeButton")
    private MobileElement botaoVoltarTermosCondicoesConfirmacaoDeDados;

    //bot�o expandir "cobertura" - tela confirma��o de dados do seguro cart�o (deb/cred)/Informacoes Seguro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Expandir\"] | //XCUIElementTypeCell[@name=\"Coberturas Colapsar\"]")
    private MobileElement botaoCoberturaInformacoesSeguro;

    //bot�o expandir "vigencia" - confirma��o dos dados/informa��es do seguro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Vig�ncia Expandir\"] | //XCUIElementTypeCell[@name=\"Vig�ncia Colapsar\"]")
    private MobileElement botaoVigenciaInformacoesSeguro;

    //bot�o expandir "dados da seguradora" - confirma��o dos dados/informa��es do seguro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Expandir\"] | //XCUIElementTypeCell[@name=\"Dados do parceiro Colapsar\"]")
    private MobileElement botaoDadosDaSeguradoraInformacoesSeguro;

    //bot�o "contratar" - tela confirma��o de dados do seguro cart�o (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_accept")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTRATAR\"]")
    private MobileElement botaoContratarSeguroConfirmacaoDeDados;

    //bot�o termo1 - Resumo das coberturas - bot�o tipo extender drop-down
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout")
    //@iOSXCUITFindBy()
    private MobileElement botaoPrimeiroTermoScrollView;

    //bot�o termo2 - Seguro coletivo de pessoas - bot�o tipo extender drop-down
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout")
    //@iOSXCUITFindBy()
    private MobileElement botaoSegundoTermoScrollView;

    //bot�o termo1 - Resumo das coberturas - abre uma nova pagina
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")
    //@iOSXCUITFindBy()
    private MobileElement botaoPrimeiroRecycleView;

    //bot�o termo2 - Seguro coletivo de pessoas - abre uma nova pagina
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

    //bot�o Detalhes - tela card contratado
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ir para detalhes\"`][1]")
    private MobileElement botaoDetalhesCardContratado;

    //titulo card - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement tituloDetalhesCardContratado;

    //subtitulo card - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_subtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[2]")
    private MobileElement subtituloDetalhesCardContratado;

    //label "em vigencia" - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_validity")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement labelEmVigenciaDetalhesCardContratado;

    //data da contrata��o - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_contracted_date_label")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement labelDataContratacaoCardContratado;

    //data da contrata��o - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_contracted_credit_card_contracted_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement dataContratacaoCardContratado;

    //bot�o Acione seu produto - tela card contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_contracted_credit_card_insurance_activate")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ir para detalhes\"`][1]")
    private MobileElement botaoAcioneSeuProduto;

    //informa��es do produto - tela seguro contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_active_insurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement informacoesProdutoCardContratado;

    //informa��es do produto - tela seguro contratado
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement informacoesProdutoDetalhesCardContratado;

    //informa��es do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Coberturas\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseCoberturaAbaInformacoesDoSeguroContratado;

    //informa��es do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Vig�ncia\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseVigenciaAbaInformacoesDoSeguroContratado;

    //informa��es do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Telefones\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseTelefonesAbaInformacoesDoSeguroContratado;

    //informa��es do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Dados do Parceiro\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseDadosDoParceiroAbaInformacoesDoSeguroContratado;

    //informa��es do produto - tela seguro contratado
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text=\"Cancelamento\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement collapseCancelamentoAbaInformacoesDoSeguroContratado;

    //label "tudo certo com a contrata��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title_debit_card_success")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/preceding-sibling::XCUIElementTypeStaticText)[1]")
    private MobileElement labelTudoCertoContratacao;

    //label "tudo certo com a contrata��o - detalhes
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

    //label contrata��o - se��o informa��es do plano
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_footer_title")
    @iOSXCUITFindBy(accessibility = "Contrata��o")
    private MobileElement labelContratacaoInformacoesPlano;

    //label contrata��o detalhes - se��o informa��es do plano
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_footer_message")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONCLUIR\"]/following-sibling::XCUIElementTypeStaticText)[2]")
    private MobileElement labelDetalhesContratacaoInformacoesPlano;

    //label vigencia - se��o informa��es do plano
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "Vig�ncia")
    private MobileElement labelVigenciaInformacoesPlano;

    //label detalhes vigencia - se��o informa��es do plano
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONCLUIR\"]/following-sibling::XCUIElementTypeStaticText)[4]")
    private MobileElement labelDetalhesVigenciaInformacoesPlano;

    //footer - se��o informa��es do plano
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

    //bot�o detalhes card1 contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/icon_details")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ir para detalhes\"`][1]")
    private MobileElement botaoDetalhesPrimeiroCardContratado;

    //op��o1 "nao preciso mais" - tela motivo do cancelamento
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTE��O\"]/..//XCUIElementTypeOther//XCUIElementTypePickerWheel")
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

    //Texto detalhes do card de prote��o cartao debito
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDescription")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Proteja seu cart�o de d�bito contra transa��es decorrentes de roubo do cart�o ou coa��o.\"]")
    private MobileElement validarTextoCardCartaoDebito;

    //botao contratar card cart�o debito
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CONTRATAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SIMULAR\"`][3]")
    private MobileElement btnContratarProtecaoDebito;

    // check box termo de condi�oes de uso
    @AndroidFindBy(id = "br.com.bradesco.next:id/debit_confirm_checkbox_terms")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"termsCheckbox\"]/XCUIElementTypeOther")
    private MobileElement selecionarCheckTermoCondicoes;

    // botao contratar tela prote��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/debit_card_btn_hire")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTRATAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"hireButton\"]")
    private MobileElement botaoContratar;

    // botao Concluir tela prote��o cartao debito
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_Receipt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"finishButton\"]")
    private MobileElement botaoConcluir;

    // validar texto da contrata��o prote��o cartao debito
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_contracting_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Agora � s� aguardar a ativa��o\"`]")
    private MobileElement validarContratacaoCartaoDebito;

    // validar cards
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDescription")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Prote��o contra transa��es indevidas'")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Tenha mais motivos para sorrir'")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Proteja sua casa contra danos'")
    private MobileElement textoCardValidar;

    public ProtecaoTela(AppiumDriver driver) {
        super(driver);
    }

    /******************************************************************
     * Validar layout do Card de Prote��o (todos tipos)
     *
     * @return
     * @throws Exception
     */

    @Step("Validar layout do Card de Prote��o")
    public ProtecaoTela validarLayoutCardProtecao(TipoProtecao tipoProtecao) throws Exception {
        salvarEvidencia("Validar layout do Card de Prote��o");
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
        tocarElemento(menuPrincipal, "N�o foi poss�vel clicar no Menu Next Principal (esq/sup)");
        return this;
    }

    /**
     * Navegar at� o card "Odonto/Debito/Credito"
     *
     * @return
     * @throws Exception
     */

    @Step("Navegar at� o card a ser testado")
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
                Assert.fail("N�o foi possivel encontrar o card a ser testado. O card precisa estar disponivel para contratacao. Verifique!!!");
            }
        }
        salvarEvidencia("Card encontrado!!!");
        return this;
    }

    /**
     * Tocar no bot�o Detalhe - Tela do Card
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no bot�o Detalhe")
    public ProtecaoTela tocarBotaoDetalhes() throws Exception {
        salvarEvidencia("Clicar no bot�o DETALHE");
        rolaTelaCima();
        aguardarCarregamentoElemento(botaoDetalhes);
        tocarElemento(botaoDetalhes, "N�o foi poss�vel clicar no bot�o DETALHE");
        return this;
    }

    /**
     * Tocar no bot�o Contratar - tela do Card
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no bot�o Contratar")
    public ProtecaoTela tocarBotaoContratar() throws Exception {
        salvarEvidencia("Clicar no bot�o CONTRATAR");
        rolaTelaCima();
        aguardarCarregamentoElemento(botaoContratarCard);
        tocarElemento(botaoContratarCard, "N�o foi poss�vel clicar no bot�o CONTRATAR");
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
        salvarEvidencia("Validar layout do Card de Prote��o");
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
     * Tocar bot�o Continuar Informacoes Seguro
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar bot�o Continuar")
    public ProtecaoTela tocarBotaoContinuarInformacoesSeguro(TipoProtecao tipoProtecao) throws Exception {
        switch(tipoProtecao)
        {
            case ODONTO:
                tocarBotaoContinuar();
        }

        return this;
    }

    /**
     * Tocar bot�o Contratar - tela seguro/detalhe
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar bot�o Contratar - tela card/detalhe")
    public ProtecaoTela tocarBotaoContratarTelaDetalhes(Protecao botao) throws Exception {
        if(botao.equals(Protecao.PRIMEIRO_BOTAO_CONTRATAR_FROM_DETALHES)) {
            aguardarCarregamentoElemento(botaoContratarCardDetalhes);
            salvarEvidencia("Tocar no primeiro bot�o Contratar - tela card/detalhe");
            tocarElemento(botaoContratarCardDetalhes, "N�o foi poss�vel tocar no primeiro bot�o Contratar - tela card/detalhe");
        }else{
                aguardarCarregamentoElemento(segundoBotaoContratarCard);
                salvarEvidencia("Tocar no segundo bot�o Contratar - tela seguro/detalhe");
                tocarElemento(segundoBotaoContratarCard, "N�o foi poss�vel tocar no segundo bot�o Contratar - tela card/detalhe");
        }

        return this;
    }

    /**
     * Validar campos da tela "Confirma��o de dados" (Deb/Cre)
     *
     * @return
     * @throws Exception
     */

    @Step("Validar campos da tela \"Confirma��o de dados\"")
    public ProtecaoTela validarTelaConfirmacaoDeDados(TipoProtecao tipoProtecao, ParticipantesProtecaoOdonto participantes) throws Exception {
        switch (tipoProtecao) {
            case DEBITO:
                salvarEvidencia("Validar campos da tela \"Confirma��o de dados\"");
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
                        throw new AssertionError("N�o foi poss�vel encontrar campo Vigencia");
                    }
                    aux++;
                }
                Assert.assertTrue(labelVigenciaConfirmacaoDeDados.isDisplayed());

                aux=1;
                while(!aguardarCarregamentoElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados)){
                    rolarTela(0.7,0.3);
                    if(aux > 3){
                        throw new AssertionError("N�o foi poss�vel encontrar campo Termos e Condicoes");
                    }
                    aux++;
                }
                break;
            case CREDITO:
                aguardarCarregamentoElemento(labelSeguroConfirmacaoDeDados);
                salvarEvidencia("Validar campos da tela \"Confirma��o de dados\"");
                compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);
                compararElementoTexto(labelSeguroConfirmacaoDeDados, Protecao.SEGURO_CARTAO_CREDITO, MetodoComparacao.CONTEM);
                compararElementoTexto(tituloCard, Protecao.TITULO_CONFIRMACAO_DADOS_CARTAO_CREDITO, MetodoComparacao.CONTEM);

                aux=1;
                while(!aguardarCarregamentoElemento(labelVigenciaConfirmacaoDeDados)){
                    rolarTela(0.7,0.3);
                    if(aux > 3){
                        throw new AssertionError("N�o foi poss�vel encontrar campo Vigencia");
                    }
                    aux++;
                }
                Assert.assertTrue(labelVigenciaConfirmacaoDeDados.isDisplayed());

                aux=1;
                while(!aguardarCarregamentoElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados)){
                    rolarTela(0.7,0.3);
                    if(aux > 3){
                        throw new AssertionError("N�o foi poss�vel encontrar campo Termos e Condicoes");
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
        salvarEvidencia("Validar campos da tela \"Confirma��o de dados\"");
        return this;
    }

    /**
     * Validar layout da tela "Termos e Condi��es"
     *
     * @return
     * @throws Exception
     */

    @Step("Validar \"Termos e Condi��es\"")
    public ProtecaoTela validarTelaTermosCondicoes(TipoProtecao tipoProtecao) throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        salvarEvidencia("Validar layout \"Termos e Condi��es\"");
        compararElementoTexto(headerTitulo, Protecao.TERMOS_CONDICOES, MetodoComparacao.CONTEM);

        List<MobileElement> todosTermos = retornarLista(new By.ById("br.com.bradesco.next:id/protection_item_term_title"), "Termos n�o encontrados");

        System.out.println(">>>>>> QTD DE TERMOS>>>>: "+todosTermos.size());

        int ind=0;
        for (MobileElement termo : todosTermos) {
            ind++;
            aguardarCarregamentoElemento(termo);
            tocarElemento(termo, "N�o foi poss�vel tocar no Termo "+ind);
            aguardarCarregamentoElemento(headerTitulo);
            compararElementoTexto(headerTitulo, Protecao.TERMOS_CONDICOES, MetodoComparacao.CONTEM);
            salvarEvidencia("Termos e Condi��es - Termo "+ind);
            tocarElemento(botaoVoltarTermosCondicoesConfirmacaoDeDados, "N�o foi poss�vel tocar no bot�o voltar "+ind);
        }

        tocarElemento(botaoVoltarTermosCondicoesConfirmacaoDeDados, "Erro ao tocar bot�o Fechar(x) Termo e Condicoes");
        return this;
    }

    /**
     * Validar "Informa��es do Seguro" em "seguro/detalhes/confirma��o de dados"
     *
     * @return
     * @throws Exception
     */
    //botao 1 ou 2 = caso tenha o mesmo botao de nome repetido na tela
    @Step("Validar \"Informa��es do Seguro\" em \"seguro/detalhes/confirma��o de dados\"")
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
     * Validar a se��o "Informa��es do Produto" em ODONTO
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
        tocarElemento(setaCollapseAbaCoberturaInformacoesDoSeguro,"N�o foi poss�vel expandir a se��o 'Cobertura'");
        aguardarCarregamentoElemento(textoInternoCollapseAbaInformacoesDoSeguro);
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.DIAGNOSTICO, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseAbaCoberturaInformacoesDoSeguro,"N�o foi poss�vel expandir a se��o 'Cobertura'");

        aguardarCarregamentoElemento(collapseCarenciaAbaInformacoesDoSeguro);
        Assert.assertTrue(collapseCarenciaAbaInformacoesDoSeguro.isDisplayed());
        Assert.assertTrue(setaCollapseAbaCarenciaInformacoesDoSeguro.isDisplayed());
        compararElementoTexto(textoCollapseCarenciaAbaInformacoesDoSeguro, Protecao.CARENCIA, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseAbaCarenciaInformacoesDoSeguro,"N�o foi poss�vel expandir a se��o 'Car�ncia'");
        aguardarCarregamentoElemento(textoInternoCollapseAbaInformacoesDoSeguro);
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.BENEFICIARIOS, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseAbaCarenciaInformacoesDoSeguro,"N�o foi poss�vel expandir a se��o 'Car�ncia'");

        aguardarCarregamentoElemento(collapseDadosParceiroAbaInformacoesDoSeguro);
        Assert.assertTrue(collapseDadosParceiroAbaInformacoesDoSeguro.isDisplayed());
        Assert.assertTrue(setaCollapseDadosParceiroAbaInformacoesDoSeguro.isDisplayed());
        compararElementoTexto(textoCollapseDadosParceiroAbaInformacoesDoSeguro, Protecao.DADOS_PARCEIRO, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseDadosParceiroAbaInformacoesDoSeguro,"N�o foi poss�vel expandir a se��o 'Dados do parceiro'");
        aguardarCarregamentoElemento(textoInternoCollapseAbaInformacoesDoSeguro);
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.CNPJ, MetodoComparacao.CONTEM);
        tocarElemento(setaCollapseDadosParceiroAbaInformacoesDoSeguro,"N�o foi poss�vel expandir a se��o 'Car�ncia'");

        aguardarCarregamentoElemento(segundoBotaoSimularContratarCard);
        Assert.assertTrue(segundoBotaoSimularContratarCard.isDisplayed());
        //TODO: Alterar o elemento segundoBotaoSimularContratarCard para segundoBotaoContratarCard (Altera��o neces�ria pois no IOS os bot�es tem identifica��es diferentes)
    }


    private void validarSecaoInformacoesDoProdutoFromCartaoCardContratadosTipoDebito() throws Exception {
        aguardarCarregamentoElemento(labelInformacoesProduto);
        compararElementoTexto(rodapeInformacoesDoProduto, Protecao.RODAPE_INFORMACOES_DO_SEGURO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar se��o Informa��es do Produto");

        aguardarCarregamentoElemento(botaoCoberturaInformacoesSeguro);
        tocarElemento(botaoCoberturaInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Cobertura\"");
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.COBERTURA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Cobertura em informacoes do Seguro");

        aguardarCarregamentoElemento(botaoVigenciaInformacoesSeguro);
        tocarElemento(botaoVigenciaInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Vigencia\"");
        rolaTelaBaixo();
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.VIGENCIA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Vigencia em informacoes do Seguro");

        aguardarCarregamentoElemento(botaoDadosDaSeguradoraInformacoesSeguro);
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Vigencia\"");
        rolaTelaBaixo();
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.DADOS_DA_SEGURADORA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes dos Dados da seguradora em informacoes do Seguro");
    }

    private void validarSecaoInformacoesSeguroCartaoFromConfirmacaoDadosTipoDebito(Protecao botao) throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(tituloTelaSelecaoSegurados);
        compararElementoTexto(rodapeConfirmacaoDeDadosSecaoInformacoesDoSeguro, Protecao.RODAPE_INFORMACOES_DO_SEGURO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar se��o Informa��es do Seguro");

        aguardarCarregamentoElemento(botaoCoberturaInformacoesSeguro);
        tocarElemento(botaoCoberturaInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Cobertura\"");
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.COBERTURA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Cobertura em informacoes do Seguro");
        tocarElemento(botaoCoberturaInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Cobertura\"");

        aguardarCarregamentoElemento(botaoVigenciaInformacoesSeguro);
        tocarElemento(botaoVigenciaInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Vigencia\"");
        rolaTelaBaixo();
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.VIGENCIA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Vigencia em informacoes do Seguro");
        tocarElemento(botaoVigenciaInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Vigencia\"");

        aguardarCarregamentoElemento(botaoDadosDaSeguradoraInformacoesSeguro);
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Dados da Seguradora\"");
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.DADOS_DA_SEGURADORA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes dos Dados da seguradora em informacoes do Seguro");
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Dados da Seguradora\"");
        //TODO: swap para cima nao funciona nessa parte, estou tendo que voltar e entrar de novo para aparecer no topo da pagina
        tocarElemento(headerBotaoVoltar, "nao foi possivel clicar no bot�o voltar");
        switch(botao){
            case PRIMEIRO_BOTAO_CONTRATAR_FROM_DETALHES:
                aguardarCarregamentoElemento(botaoSimularCard);
                tocarElemento(botaoSimularCard, "N�o foi poss�vel clicar no bot�o1 CONTRATAR ");
                break;
            case SEGUNDO_BOTAO_CONTRATAR_FROM_DETALHES:
                aguardarCarregamentoElemento(segundoBotaoSimularContratarCard);
                tocarElemento(segundoBotaoSimularContratarCard, "N�o foi poss�vel clicar no bot�o2 CONTRATAR ");
                //TODO: Alterar o elemento segundoBotaoSimularContratarCard para segundoBotaoContratarCard (Altera��o neces�ria pois no IOS os bot�es tem identifica��es diferentes)
                break;
            case BOTAO_CONTRATAR_FROM_CARD:
                aguardarCarregamentoElemento(botaoContratarCard);
                tocarElemento(botaoContratarCard, "N�o foi poss�vel clicar no bot�o CONTRATAR ");
                break;
        }
    }

    /**
     * Tocar bot�o Pr�ximo
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o pr�ximo")
    public ProtecaoTela tocarBotaoProximo() throws Exception {
        aguardarCarregamentoElemento(botaoProximoTelaSelecaoSegurados);
        tocarElemento(botaoProximoTelaSelecaoSegurados, "N�o foi poss�vel clicar no botao \"Pr�ximo\"");
        salvarEvidencia("Tocar bot�o Proximo");
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
     * Tocar bot�o X
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o X")
    public ProtecaoTela tocarBotaoX() throws Exception {
        aguardarCarregamentoElemento(headerBotaoVoltar);
        tocarElemento(headerBotaoVoltar,"Erro ao tocar no bot�o X");
        return this;
    }

    private void validarSecaoInformacoesSeguroCartaoFromDetalhesTipoDebito(Protecao botao) throws Exception {
        rolarTelaAteFinal();
        aguardarCarregamentoElemento(headerTitulo);
        compararElementoTexto(rodapeDetalhesSecaoInformacoesDoSeguro, Protecao.RODAPE_INFORMACOES_DO_SEGURO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar se��o Informa��es do Seguro");

        aguardarCarregamentoElemento(botaoCoberturaInformacoesSeguro);
        tocarElemento(botaoCoberturaInformacoesSeguro, "N�o foi poss�vel clicar no bot�o \"Cobertura\"");
        salvarEvidencia("Validar detalhes da Cobertura em informacoes do Seguro");

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVigenciaInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Vigencia\"");
        aguardarCarregamentoElemento(botaoVigenciaInformacoesSeguro);
        tocarElemento(botaoVigenciaInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Vigencia\"");
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.VIGENCIA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes da Vigencia em informacoes do Seguro");

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Dados da Seguradora\"");
        aguardarCarregamentoElemento(botaoDadosDaSeguradoraInformacoesSeguro);
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "N�o foi poss�vel clicar no botao \"Dados da Seguradora\"");
        aguardarCarregamentoElemento(textoInternoCollapseAbaInformacoesDoSeguro);
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.DADOS_DA_SEGURADORA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes dos Dados da seguradora em informacoes do Seguro");
        rolarTelaAteFinal();
        aguardarCarregamentoElemento(segundoBotaoSimularContratarCard);
        salvarEvidencia("Validar se��o Informa��es do Seguro Rodap� com Dados do Seguro Aberto");
        Assert.assertTrue(segundoBotaoSimularContratarCard.isDisplayed());
        rolarTelaAteInicio();
    }

    /**
     * Tocar no bot�o "Informa��es do Seguro" (debito) ou "Informa��es do Plano" (credito)
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no bot�o \"Informa��es do Seguro/Plano\"")
    public ProtecaoTela tocarBotaoInformacoesSeguroOuPlano() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(botaoInformacoesSeguroOuPlanoCardContratado);
        salvarEvidencia("Tocar no bot�o \"Informa��es do Seguro/Plano\"");
        tocarElemento(botaoInformacoesSeguroOuPlanoCardContratado, "N�o foi poss�vel clicar no botao \"Informacoes do Seguro/Plano\"");
        Assert.assertTrue(labelInformacoesProduto.isEnabled());
        return this;
    }

    /**
     * Tocar na check box "Li e aceito os termos e condi��es"
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar na check box \"Li e aceito os termos e condi��es\"")
    public ProtecaoTela tocarCheckBoxLiAceitoTermosCondicoes(TipoProtecao tipoProtecao) throws Exception {
        rolaTelaBaixo();
        switch (tipoProtecao)
        {
            case ODONTO:
                aguardarCarregamentoElemento(headerTitulo);
                aguardarCarregamentoElemento(botaoInterrogacaoTelaConfirmacao);
                tocarElemento(botaoInterrogacaoTelaConfirmacao, "N�o foi poss�vel marcar o checkbox");
                Assert.assertTrue(botaoContratarOdontoTelaConfirmacao.isEnabled());
                break;
            default:
                aguardarCarregamentoElemento(headerTitulo);
                aguardarCarregamentoElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados);
                tocarElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados, "N�o foi poss�vel clicar no bot�o \"checkBox SeguroTermosCondicoes\"");
                Assert.assertTrue(botaoContratarSeguroConfirmacaoDeDados.isEnabled());
                break;
        }

        salvarEvidencia("Tocar na check box \"Li e aceito os termos e condi��es\"");
        return this;
    }

    /**
     * Tocar no bot�o "Contratar" da tela "Confirma��o de dados"
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no bot�o \"Contratar\" da tela \"Confirma��o de dados\"")
    public ProtecaoTela tocarBotaoContratarTelaConfirmacaoDeDados(TipoProtecao tipoProtecao) throws Exception {
        rolaTelaBaixo();
        switch (tipoProtecao)
        {
            case ODONTO:
                aguardarCarregamentoElemento(botaoContratarOdontoTelaConfirmacao);
                salvarEvidencia("Tocar no bot�o \"Contratar\" da tela \"Confirma��o de dados\"");
                tocarElemento(botaoContratarOdontoTelaConfirmacao, "N�o foi poss�vel clicar no botao \"CONTRATAR\" da tela Confirma��o de Dados do Seguro");
                break;
            default:
                aguardarCarregamentoElemento(botaoContratarSeguroConfirmacaoDeDados);
                salvarEvidencia("Tocar no bot�o \"Contratar\" da tela \"Confirma��o de dados\"");
                tocarElemento(botaoContratarSeguroConfirmacaoDeDados, "N�o foi poss�vel clicar no botao \"CONTRATAR\" da tela Confirma��o de Dados do Seguro");
                break;
        }
        return this;
    }

    /**
     * Validar layout tela confirma��o de contrata��o
     *
     * @return
     * @throws Exception
     */

    @Step("Validar layout tela confirma��o de contrata��o")
    public ProtecaoTela validarLayoutTelaConfirmacaoContratacao(TipoProtecao tipoProtecao) throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        salvarEvidencia("Validar layout tela confirma��o de contrata��o");
        compararElementoTexto(headerTitulo, Protecao.SUCESSO, MetodoComparacao.CONTEM);

        switch (tipoProtecao) {
            case DEBITO:
                compararElementoTexto(labelTudoCertoContratacao, Protecao.TUDO_CERTO_CONTRATACAO_CARTAO_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(labelTudoCertoContratacaoDetalhes, Protecao.TUDO_CERTO_CONTRATACAO_DETALHES_DEBITO, MetodoComparacao.CONTEM);
                compararElementoTexto(labelNumeroContrato, Protecao.NUMERO_CONTRATO_PROTOCOLO_DEBITO, MetodoComparacao.CONTEM);
                Assert.assertTrue(botaoConcluirTelaSucesso.isDisplayed());
                rolarTelaAteFinal();
                Assert.assertTrue(abaInformacoesSeguroTelaSucesso.isDisplayed());
                salvarEvidencia("Validar layout tela confirma��o de contrata��o - informa��es do produto");
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
        salvarEvidencia("Validar layout tela confirma��o de contrata��o - se��o informa��es do plano");
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
     * Tocar Bot�o "Concluir" da tela sucesso contratacao/cancelamento
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar Bot�o \"Concluir\" da tela \"Sucesso\"")
    public ProtecaoTela tocarBotaoConcluir(TipoSecaoProtecao tipoSecaoProtecao) throws Exception {

        if(tipoSecaoProtecao.equals(TipoSecaoProtecao.CONTRATACAO)){
            aguardarCarregamentoElemento(botaoConcluirTelaSucesso);
            salvarEvidencia("Tocar bot�o \"Concluir\" da tela Contratado com \"Sucesso\"");
            tocarElemento(botaoConcluirTelaSucesso, "N�o foi poss�vel clicar no botao \"CONCLUIR\"");
        }else{
            aguardarCarregamentoElemento(botaoConcluirTelaSucessoExclusaoSeguro);
            salvarEvidencia("Tocar Bot�o \"Concluir\" da tela Excluido com \"Sucesso\"");
            tocarElemento(botaoConcluirTelaSucessoExclusaoSeguro, "N�o foi poss�vel clicar no botao \"CONCLUIR\"");
        }

        return this;
    }

    /**
     * Validar se��o "Prote��o" tela Contratados Seguro (Debito/Credito)
     *
     * @return
     * @throws Exception
     */

    @Step("Validar card contratado na se��o Contratados")
    public ProtecaoTela validarTelaDetalhesCardContratado(TipoProtecao tipoProtecao) throws Exception {
        aguardarCarregamentoElemento(tituloDetalhesCardContratado);
        salvarEvidencia("Validar se��o \"Prote��o\" tela Contratados Seguro");
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
                tocarElemento(collapseCoberturaAbaInformacoesDoSeguroContratado, "N�o foi poss�vel tocar em Coberturas");
                salvarEvidencia("Validar se��o \"Coberturas\" tela Contratados Seguro");
                Assert.assertTrue(collapseVigenciaAbaInformacoesDoSeguroContratado.isDisplayed());
                tocarElemento(collapseVigenciaAbaInformacoesDoSeguroContratado, "N�o foi poss�vel tocar em Vig�ncia");
                salvarEvidencia("Validar se��o \"Vig�ncia\" tela Contratados Seguro");
                Assert.assertTrue(collapseTelefonesAbaInformacoesDoSeguroContratado.isDisplayed());
                tocarElemento(collapseTelefonesAbaInformacoesDoSeguroContratado, "N�o foi poss�vel tocar em Telefones");
                salvarEvidencia("Validar se��o \"Telefones\" tela Contratados Seguro");
                rolarTelaAteFinal();
                Assert.assertTrue(collapseDadosDoParceiroAbaInformacoesDoSeguroContratado.isDisplayed());
                tocarElemento(collapseDadosDoParceiroAbaInformacoesDoSeguroContratado, "N�o foi poss�vel tocar em Dados do Parceiro");
                salvarEvidencia("Validar se��o \"Dados do Parceiro\" tela Contratados Seguro");
                rolarTelaAteFinal();
                Assert.assertTrue(collapseCancelamentoAbaInformacoesDoSeguroContratado.isDisplayed());
                salvarEvidencia("Validar se��o \"Cancelamento\" tela Contratados Seguro");
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
        System.out.println("data contrata��o: "+dataContratacaoCardContratado.getText());
        Assert.assertTrue(dataContratacaoCardContratado.getText().contains(dtf.format(now)));
        Assert.assertTrue(abaInformacoesDoSeguro.isDisplayed());

        return this;
    }

    /**
     * Tocar Bot�o 'Simular'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar Bot�o 'Simular'")
    public ProtecaoTela tocarBotaoSimular() throws Exception {
        rolaTelaCima();
        aguardarCarregamentoElemento(botaoSimularCard);
        tocarElemento(botaoSimularCard, "N�o foi poss�vel clicar no bot�o SIMULAR");
        salvarEvidencia("Clicar no bot�o SIMULAR");
        return this;
    }

    /**
     * Tocar Bot�o 'Simular' na tela de Informa��es do Seguro
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar Bot�o 'Simular' na tela de Informa��es do Seguro")
    public ProtecaoTela tocarBotaoSimularInformacoesSeguro() throws Exception {
        aguardarCarregamentoElemento(segundoBotaoSimularContratarCard);
        tocarElemento(segundoBotaoSimularContratarCard, "N�o foi poss�vel clicar no bot�o SIMULAR");
        //TODO: Alterar o elemento segundoBotaoSimularContratarCard para segundoBotaoContratarCard (Altera��o neces�ria pois no IOS os bot�es tem identifica��es diferentes)
        salvarEvidencia("Clicar no bot�o SIMULAR");
        return this;
    }

    /**
     * Validar se��o "Acione Seu Seguro" tela Detalhes do Card Contratado
     *
     * @return
     * @throws Exception
     */

    @Step("Validar se��o \"Acione Seu Seguro\" tela Detalhes do Card Contratado")
    public ProtecaoTela validarAcioneSeguroTelaDetalhesCardContratado(TipoProtecao tipoProtecao) throws Exception {
        rolarTelaAteInicio();
        aguardarCarregamentoElemento(headerTitulo);
        rolaTelaBaixo();
        salvarEvidencia("Validar se��o \"Acione Seu Seguro\" tela Detalhes do Card Contratado");
        aguardarCarregamentoElemento(botaoAcioneSeuProduto);
        tocarElemento(botaoAcioneSeuProduto, "N�o foi poss�vel clicar no bot�o Acione seu produto");

        tocarElemento(acioneSeuSeguroCentralAtendimento, "N�o foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroCentralAtendimento);
        tocarElemento(acioneSeuSeguroCentralAtendimento, "N�o foi poss�vel clicar no telefone Central de Atendimento");
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - Central de Atendimento");
        tocarElemento(cancelarPopUpLigacao, "N�o foi possivel fechar o pop-up");

        tocarElemento(acioneSeuSeguroSac, "N�o foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroSac);
        tocarElemento(acioneSeuSeguroSac, "N�o foi poss�vel clicar no telefone Central de Atendimento");
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - SAC");
        tocarElemento(cancelarPopUpLigacao, "N�o foi possivel fechar o pop-up");

        tocarElemento(acioneSeuSeguroDeficiencia, "N�o foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroDeficiencia);
        tocarElemento(acioneSeuSeguroDeficiencia, "N�o foi poss�vel clicar no telefone Central de Atendimento");
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - Deficiencia");
        tocarElemento(cancelarPopUpLigacao, "N�o foi possivel fechar o pop-up");

        aguardarCarregamentoElemento(acioneSeuSeguroOuvidoria);
        tocarElemento(acioneSeuSeguroOuvidoria, "N�o foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroOuvidoria);
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - Ouvidoria");
        tocarElemento(cancelarPopUpLigacao, "N�o foi possivel fechar o pop-up");

        Assert.assertTrue(botaoInformacoesSeguroOuPlanoCardContratado.isDisplayed());

        return this;
    }

    /**
     * Tocar Bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar Bot�o 'Continuar'")
    public ProtecaoTela tocarBotaoContinuar() throws Exception {
        rolaTelaCima();
        aguardarCarregamentoElemento(botaoContinuarTelaContratacao);
        tocarElemento(botaoContinuarTelaContratacao, "N�o foi poss�vel clicar no bot�o CONTINUAR");
        salvarEvidencia("Clicar no bot�o CONTINUAR");
        return this;
    }

    /**
     * Validar tela "Simula��o"
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
     * Tocar bot�o voltar (sup/esq)
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o voltar (sup/esq)")
    public ProtecaoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o voltar (sup/esq)");
        aguardarCarregamentoElemento(headerBotaoVoltar);
        tocarElemento(headerBotaoVoltar, "N�o foi poss�vel clicar no botao \"voltar\"");
        return this;
    }

    /**
     * Tocar bot�o cancelar "lixeira" Protecao (sup/dir)
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o cancelar \"lixeira\" Protecao (sup/dir)")
    public ProtecaoTela tocarBotaoCancelarProtecao() throws Exception {
        salvarEvidencia("Cancelar seguro atrav�s da aba Cancelamento");
        aguardarCarregamentoElemento(collapseCancelamentoAbaInformacoesDoSeguroContratado);
        tocarElemento(collapseCancelamentoAbaInformacoesDoSeguroContratado, "N�o foi poss�vel clicar na aba \"Cancelamento\"");

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
        tocarElemento(botaoMotivoCancelamentoTelaExclusaoSeguro, "N�o foi poss�vel clicar no botao \"Motivo do Cancelamento\"");
        aguardarCarregamentoElemento(tituloHeaderTelaConfirmacaoCancelamento);
        tocarElemento(opcao1MotivoCancelamento, "N�o foi poss�vel clicar no botao \"Motivo 1\" do Cancelamento da prote��o");
        tocarElemento(botaoHeaderConfirmar, "N�o foi poss�vel clicar no botao \"confirmar\" (sup/dir)");
        compararElementoTexto(botaoMotivoCancelamentoTelaExclusaoSeguro, Protecao.NAO_PRECISO_MAIS, MetodoComparacao.CONTEM);
        salvarEvidencia("Motivo do cancelamento selecionado");
        return this;
    }

    /**
     * Tocar no bot�o "Confirmar" da tela Cancelamento Protecao
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o \"Confirmar\" da tela Cancelamento Protecao")
    public ProtecaoTela tocarBotaoConfirmarTelaCancelamentoProtecao() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmarExclusaoSeguro);
        salvarEvidencia("Tocar no bot�o \"Confirmar\" da tela Cancelamento Protecao");
        tocarElemento(botaoConfirmarExclusaoSeguro, "N�o foi poss�vel clicar no botao \"CONFIRMAR\"");
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
     * Acessar "Termos e Condi��es"
     *
     * @return
     * @throws Exception
     */
    @Step("Acessar \"Termos e Condi��es\"")
    public ProtecaoTela acessarTermosCondicoes() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(botaoLerTermosCondicoesConfirmacaoDeDados);
        salvarEvidencia("Acessar \"Termos e Condi��es\"");
        tocarElemento(botaoLerTermosCondicoesConfirmacaoDeDados, "N�o foi poss�vel clicar no bot�o ler Termos e Condicoes");
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
        tocarElemento(botaoDataPagamentoConfirmacaoDeDados, "N�o foi poss�vel clicar no bot�o \"Data do Pagamento\"");
        salvarEvidencia("Selecionar nova data de pagamento");
        aguardarCarregamentoElemento(botaoDataPagamentoDia5);
        tocarElemento(botaoDataPagamentoDia5, "N�o foi poss�vel selecionar \"Data do Pagamento\"");
        aguardarCarregamentoElemento(botaoConfirmarCalendario);
        tocarElemento(botaoConfirmarCalendario, "N�o foi poss�vel clicar no bot�o \"confirmar\" do calendario");
        aguardarCarregamentoElemento(botaoDataPagamentoConfirmacaoDeDados);
        compararElementoTexto(labelDataPagamentoConfirmacaoDeDados, Protecao.TODO_DIA_5, MetodoComparacao.CONTEM);
        salvarEvidencia("Campo data de pagamento alterado");
        return this;
    }

    /**
     * Clicar no bot�o Detalhes na tela cards contratados
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no bot�o Detalhes na tela cards contratados")
    public ProtecaoTela tocarBotaoDetalhesCardContratado() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(botaoDetalhesPrimeiroCardContratado);
        salvarEvidencia("Clicar no bot�o Detalhes na tela cards contratados");
        tocarElemento(botaoDetalhesPrimeiroCardContratado, "N�o foi poss�vel clicar no bot�o Detalhes da tela cards contratados");
        return this;
    }

    /**
     * Clicar no bot�o Contratar na tela cards Cart�o debito
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no bot�o Contratar na tela cards Cart�o debito")
    public ProtecaoTela selecionarCardProtecaoCartaoDebito() throws Exception {
            rolaTelaBaixo();
            aguardarCarregamentoElemento(tituloCard);
            aguardarCarregamentoElemento(textoCardValidar);
            String CardCartaoDebito = "Prote��o contra transa��es indevidas";
            salvarEvidencia("Procurando o Card de prote��o Cart�o Debito para Contratar.");
            for (int i = 0; i < 6; i++) {
                String textoCard = textoCardValidar.getText();
                if (textoCard.equals(CardCartaoDebito)) {
                    aguardarCarregamentoElemento(btnContratarProtecaoDebito);
                    salvarEvidencia("Clicar no bot�o Simular na tela cards de cart�o de debito.");
                    tocarElemento(btnContratarProtecaoDebito, "N�o foi poss�vel clicar no bot�o Simular cards contrata�ao cartao debito");
                    break;
                } else {
                    deslizar(Direcao.ESQUERDA, 30,80);
                }
            }
           return this;
    }

    /**
     * Clicar no bot�o Simular na tela de card de Odonto
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no bot�o Simular na tela de card de Odonto")
    public ProtecaoTela selecionarCardSegurosOdonto() throws Exception {
        aguardarCarregamentoElemento(textoCardValidar);
        String CardOdonto = "Proteja seu cart�o de d�bito contra transa��es decorrentes de roubo do cart�o ou coa��o.";
        salvarEvidencia("Procurando o Card de prote��o Odonto para Contratar.");
        for (int i = 0; i < 6; i++) {
            String textoCard = textoCardValidar.getText();
            if (textoCard.equals(CardOdonto)) {
                aguardarCarregamentoElemento(botaoSimularCard);
                salvarEvidencia("Clicar no bot�o Simular na tela card de Odonto.");
                tocarElemento(botaoSimularCard, "N�o foi poss�vel clicar no bot�o Simular card contratacao do Odonto");
                break;
            } else {
                deslizar(Direcao.ESQUERDA, 30, 80);
            }
        }
        return this;
    }


    /**
     * Clicar no check box termo e condi��o na tela cards Cart�o debito
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no check box termo e condi��o na tela cards Cart�o debito")
    public ProtecaoTela aceitarTermosCondicoesCartaoDebito() throws Exception {
        salvarEvidencia("Tela de prote��o Cart�o Debito Termo e Condi��es.");
        rolaTelaBaixo();
        aguardarCarregamentoElemento(selecionarCheckTermoCondicoes);
        salvarEvidencia("Clicar no check box Termo e condi��es de cart�o de debito.");
        tocarElemento(selecionarCheckTermoCondicoes, "N�o foi poss�vel Clicar no check box Termo e condi��es de cart�o de debito.");
        return this;
    }
    /**
     * Clicar no botao contratar apos aceitar check box termo e condi��o na tela cards Cart�o debito
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no botao contratar apos aceitar check box termo e condi��o na tela cards Cart�o debito")
    public ProtecaoTela btnContratarProtecaoCartaoDebito() throws Exception {
        salvarEvidencia("Tela de prote��o Cart�o Debito Termo e Condi��es.");
        aguardarCarregamentoElemento(botaoContratar);
        salvarEvidencia("Clicar no botao contratar apos aceitar Termo e condi��es de cart�o de debito.");
        tocarElemento(botaoContratar, "N�o foi poss�vel Clicar no bot�o Contratar apos aceitar termos e condi��es.");
        return this;
    }

    /**
     * Validar contratacao na tela cards Cart�o debito
     *
     * @return
     * @throws Exception
     */
    @Step("Validar contratacao na tela cards Cart�o debito")
    public ProtecaoTela validarContratacaoProtecaoCartaoDebito() throws Exception {
        salvarEvidencia("Tela de prote��o Cart�o Debito Concluir contrata��o.");
        aguardarCarregamentoElemento(validarContratacaoCartaoDebito);
        compararElementoTexto(validarContratacaoCartaoDebito, ProtecaoCartaoDebito.VALIDARCONTRATACAOCARTAODEBITO, MetodoComparacao.CONTEM);
        salvarEvidencia("Valida��o da contrata��o de prote��o de cart�o de debito.");
        return this;
    }

    /**
     * clicar botao concluir contratacao na tela cards Cart�o debito
     *
     * @return
     * @throws Exception
     */
    @Step("clicar botao concluir contratacao na tela cards Cart�o debito")
    public ProtecaoTela btnConcluirProtecaoCartaoDebito() throws Exception {
        salvarEvidencia("Tela de prote��o Cart�o Debito Concluir contrata��o e valida��o.");
        aguardarCarregamentoElemento(botaoConcluir);
        tocarElemento(botaoConcluir,"N�o foi possivel clicar no bot�o VER DETALHES DO PLANO");
        salvarEvidencia("concluir a contrata��o de prote��o de cart�o de debito e voltando ao cards.");
        return this;
    }
}
