package pagina.mobile.jornadas.seguros;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.ParticipantesProtecaoOdonto;
import constantes.seguros.Protecao;
import constantes.seguros.TipoSecaoProtecao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProtecaoCreditoTela extends PaginaBase {

    //Botão de voltar
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement headerBotaoVoltar;

    //Título do Header
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_next_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PROTEÇÃO\"]")
    private MobileElement headerTitulo;

    //Título - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtTitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Cartão de Crédito\"])[1]")
    private MobileElement tituloCard;

    //Subtítulo - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtSubtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Seguro Cartão de Crédito\"])[1]")
    private MobileElement subtituloCard;

    //Ícone - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/imgInsurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"protection-cartao_de_credito\"]")
    private MobileElement iconeCard;

    //Descrição - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDescription")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Proteja seu cartão de crédito contra transações decorrentes de roubo do cartão ou coação.\"])[1]")
    private MobileElement descricaoCard;

    //Descrição Valor - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_value_description_protection")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Por apenas R$  4,99 por mês\"])[1]")
    private MobileElement descricaoValorCard;

    //Label Valor - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/coverage_label")
    private MobileElement labelValorCard;

    //Valor - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/coverage_value")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText)[2]")
    private MobileElement valorCard;

    //Botão "Detalhes"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnDetails")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"DETALHES\" and @visible='true'])[1]")
    private MobileElement botaoDetalhes;

    //Botão "Simular" - Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnAccept")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"SIMULAR\"`][1]")
    private MobileElement botaoSimularCard;

    //Botão "Contratar" - Card
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CONTRATAR\"])[1]")
    private MobileElement botaoContratarCard;

    //campo "Seguro" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_insurence_name")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[1]")
    private MobileElement labelSeguroConfirmacaoDeDados;

    //campo "Cartao Assegurado" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/txt_number_credit_card")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[2]")
    private MobileElement labelCartaoAsseguradoConfirmacaoDeDados;

    //campo "Data do Pagamento" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/text_payment_day")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[3]")
    private MobileElement botaoDataPagamentoConfirmacaoDeDados;

    //campo "Forma de Pagamento" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtPaymentForm")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField)[4]")
    private MobileElement labelFormaPagamentoConfirmacaoDeDados;

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
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtVigency")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeTextView")
    private MobileElement labelVigenciaConfirmacaoDeDados;

    //check box "Termos e Condicoes" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/debit_confirm_checkbox_terms")
    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@text, 'Li e aceito os termos')]") //<marcos2>
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Li e aceito os termos & condições gerais do produto Selecionar\"`]")
    private MobileElement checkBoxSeguroTermosCondicoesConfirmacaoDeDados;

    //botão ler "Termos e Condicoes" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_details_terms_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Clique para ler os termos e condições\"]")
    private MobileElement botaoLerTermosCondicoesConfirmacaoDeDados;

    //botão expandir "cobertura" - tela confirmação de dados do seguro cartão (deb/cred)/Informacoes Seguro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Cobertura Expandir")
    private MobileElement botaoCoberturaInformacoesSeguro;

    //botão expandir "vigencia" - confirmação dos dados/informações do seguro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Vigência Expandir")
    private MobileElement botaoVigenciaInformacoesSeguro;

    //botão expandir "dados da seguradora" - confirmação dos dados/informações do seguro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Dados do parceiro Expandir")
    private MobileElement botaoDadosDaSeguradoraInformacoesSeguro;

    //botão "contratar" - tela confirmação de dados do seguro cartão (deb/cred)
    @AndroidFindBy(id = "br.com.bradesco.next:id/debit_card_btn_hire")
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

    //Botão confirmar - calendario
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_check")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmarCalendario;

    //Card
    @AndroidFindBy(id = "br.com.bradesco.next:id/background_card_protection")
    //@iOSXCUITFindBy()
    private MobileElement card;

    //Aba "Informações do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_active_insurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"SIMULAR\"]/following-sibling::XCUIElementTypeButton")
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
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtInsuranceDetailsFooter")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"SIMULAR\"])[2]/preceding-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement rodapeDetalhesSecaoInformacoesDoSeguro;

    //Aba "Confirmacao de dados/Informações do Seguro" - Rodapé
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtDetailsFooter")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Todos os documentos sobre o produto contratado ficam disponíveis no site: banco.bradesco/cartões\"]")
    private MobileElement rodapeConfirmacaoDeDadosSecaoInformacoesDoSeguro;

    //Aba "Informações do Seguro" - Botão "Simular"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnAccept2")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"SIMULAR\"`][2]")
    private MobileElement segundoBotaoSimularContratarCard;

    //Aba "Informações do Seguro" - Botão "Contratar"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btnAccept2")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONTRATAR\"`][2]")
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
    //@iOSXCUITFindBy()
    private MobileElement quantidadeAtualTelaSelecaoSegurados;

    //Tela de Seleção de Segurados - Diminuir
    @AndroidFindBy(id = "br.com.bradesco.next:id/left_img")
    //@iOSXCUITFindBy()
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
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Selecionado,Mensal,Botão de seleção,\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[1]")
    private MobileElement labelRadioButtonTipoPagamentoMensal;

    //Radio - Tipo de Pagamento - Anual
    @AndroidFindBy(id = "br.com.bradesco.next:id/annual_checker")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeTextField/following-sibling::XCUIElementTypeOther)[2]")
    private MobileElement radioButtonTipoPagamentoAnual;

    //Label Radio - Tipo de Pagamento - Anual
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\",Não selecionado,Anual com desconto,Botão de seleção,\"]")
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
    private MobileElement campoVigênciaTelaConfirmacao;

    //Tela de Confirmação - Checkbox
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_confirm_checkbox_terms")
    @AndroidFindBy(id = "br.com.bradesco.next:id/debito_confirm_checkbox_terms")
    //@iOSXCUITFindBy()
    private MobileElement checkboxTelaConfirmacao;

    //Tela de Confirmação - Botão "?" (No IOS o botão de "?" equivale ao botão ">")
    @AndroidFindBy(id = "br.com.bradesco.next:id/dental_confirm_checkbox_terms")
    @iOSXCUITFindBy(accessibility = "avançar")
    private MobileElement botaoInterrogacaoTelaConfirmacao;

    //label titulo - Informações do produto - tela contratados/btn_informacoes do seguroOuPlano
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement labelInformacoesProduto;

    //Rodape - Tela Informacoes do produto
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_bottom")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[5]")
    private MobileElement rodapeInformacoesDoProduto;

    //Tela de Sucesso - Botão "Concluir"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_Receipt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONCLUIR\"`]")
    private MobileElement botaoConcluirTelaSucesso;

    //Tela de exclusão com sucesso - Botão "Concluir"
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_receipt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"CONCLUIR\"`]")
    private MobileElement botaoConcluirTelaSucessoExclusaoSeguro;

    //Tela de Sucesso - Aba "Informações do Seguro"
    @AndroidFindBy(id = "br.com.bradesco.next:id/moreInfoContent")
    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeOther[`label == \"informações do produto\"`]")
    private MobileElement abaInformacoesSeguroTelaSucesso;

    //Tela de Seguro Contratado - Ícone Lixeira
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
    private MobileElement íconeSeguroContratado;

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
    private MobileElement botaoInformaçõesSeguroOuPlanoCardContratado;

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

    //Tela de Adição de Dependente - Rodapé
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_bottom")
    //@iOSXCUITFindBy()
    private MobileElement rodapeAdicaoDependente;

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

    //Tela de Adição de Dependente - Botão Editar "Nome Completo"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, botão\"])[1]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarNomeCompletoAdicaoDependente;

    //Tela de Adição de Dependente - Campo "Data de Nascimento"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtBirthDate")
    //@iOSXCUITFindBy()
    private MobileElement campoDataNascimentoAdicaoDependente;

    //Tela de Adição de Dependente - Botão Editar "Data de Nascimento"
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Editar, botão\"])[2]")
    //@iOSXCUITFindBy()
    private MobileElement botaoEditarDataNascimentoAdicaoDependente;

    //Tela de Adição de Dependente - Campo "CPF"
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtCPF")
    //@iOSXCUITFindBy()
    private MobileElement campoCpfAdicaoDependente;

    //Tela de Adição de Dependente - Botão Editar "CPF"
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
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_details_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[1]")
    private MobileElement tituloDetalhesCardContratado;

    //subtitulo card - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_details_subtitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]//../XCUIElementTypeOther//XCUIElementTypeStaticText)[2]")
    private MobileElement subtituloDetalhesCardContratado;

    //label "em vigencia" - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_details_description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement labelEmVigenciaDetalhesCardContratado;

    //data da contratação - tela detalhes do card ja contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_details_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement dataContratacaoCardContratado;

    //label "tudo certo com a contratação
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_contracting_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/preceding-sibling::XCUIElementTypeStaticText)[1]")
    private MobileElement labelTudoCertoContratacao;

    //label "tudo certo com a contratação - detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_contracting_success_description")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/preceding-sibling::XCUIElementTypeStaticText)[2]")
    private MobileElement labelTudoCertoContratacaoDetalhes;

    //label "numero do contrato"
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_proposal_number_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"CONCLUIR\"]/preceding-sibling::XCUIElementTypeStaticText)[4]")
    private MobileElement labelNumeroContrato;

    //label valor "numero do contrato"
    @AndroidFindBy(id = "br.com.bradesco.next:id/insurance_contracting_success_protocol")
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
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtTitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"CONTRATADOS\"]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText)[2]")
    private MobileElement tituloPrimeiroCardContratado;

    //status card1 contratado
    @AndroidFindBy(id = "br.com.bradesco.next:id/txtStatus")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"CONTRATADOS\"]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText)[1]")
    private MobileElement statusPrimeiroCardContratado;

    //botão detalhes card1 contratado
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ir para detalhes\"`][1]")
    private MobileElement botaoDetalhesPrimeiroCardContratado;

    //opção1 "nao preciso mais" - tela motivo do cancelamento
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PROTEÇÃO\"]/..//XCUIElementTypeOther//XCUIElementTypePickerWheel")
    private MobileElement opcao1MotivoCancelamento;

    //acione seu seguro - central de atendimento
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"telefone\"`][1]")
    private MobileElement acioneSeuSeguroCentralAtendimento;

    //tela de erro - titulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_protection_warning_title")
    private MobileElement tituloTelaErro;

    //tela de erro - subtitulo
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_protection_warning_subtitle")
    private MobileElement subtituloTelaErro;

    //acione seu seguro - sac
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"telefone\"`][2]")
    private MobileElement acioneSeuSeguroSac;

    //acione seu seguro - deficiencia
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == \"telefone\"`][3]")
    private MobileElement acioneSeuSeguroDeficiencia;

    //acione seu seguro - ouvidoria
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]")
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

    public ProtecaoCreditoTela(AppiumDriver driver) {
        super(driver);
    }


    @Step("Validar layout do Card de Proteção")
    public ProtecaoCreditoTela validarLayoutCardProtecao() throws Exception {

        salvarEvidencia("Validar layout do Card de Proteção");
        aguardarCarregamentoElemento(headerTitulo);
        compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);

        Assert.assertTrue(tituloCard.isDisplayed());
        Assert.assertTrue(subtituloCard.isDisplayed());
        Assert.assertTrue(descricaoCard.isDisplayed());
        //Assert.assertTrue(valorCard.isDisplayed());
        //Assert.assertTrue(botaoContratarCard.isDisplayed());
        Assert.assertTrue(iconeCard.isDisplayed());
        Assert.assertTrue(botaoDetalhes.isDisplayed());

        return this;
    }
    @Step("Navegar até o card a ser testado")
    public ProtecaoCreditoTela navegarCardProtecao() throws Exception {
        int ind=0;
        Boolean cardFound=false;

        while(!cardFound){
            System.out.println("Procurando pelo card a ser testado...");
            aguardarCarregamentoElemento(headerTitulo);
            tocarElemento(botaoDetalhes, "Não foi possível clicar no botão DETALHE");
            aguardarCarregamentoElemento(tituloCard);
            if (verificarPresencaElemento(tituloCard)) {
                if (tituloCard.getText().toUpperCase().contains(Protecao.CARTAO_DEBITO.toString().toUpperCase())) {
                    cardFound = true;
                }
            }
            tocarElemento(headerBotaoVoltar, "nao foi possivel tocar no botão voltar");
            aguardarCarregamentoElemento(headerTitulo);

            if(!cardFound){
                deslizar(Direcao.ESQUERDA, 30,80);
            }
            ind++;
            if(ind>5){
                Assert.fail("Não foi possível encontrar o card a ser testado. O card precisa estar disponivel para contratacao. Verifique!!!");
            }
        }
        salvarEvidencia("Card encontrado!!!");
        return this;
    }
    /**
     * Tocar no botão Contratar - tela do Card
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no botão Contratar")
    public ProtecaoCreditoTela tocarBotaoContratar() throws Exception {
        salvarEvidencia("Clicar no botão CONTRATAR");
        rolaTelaCima();
        aguardarCarregamentoElemento(botaoContratarCard);
        tocarElemento(botaoContratarCard, "Não foi possível clicar no botão CONTRATAR");
        return this;
    }

    /**
     * Validar campos da tela "Confirmação de dados" (Deb/Cre)
     *
     * @return
     * @throws Exception
     */

    @Step("Validar campos da tela \"Confirmação de dados\"")
    public ProtecaoCreditoTela validarTelaConfirmacaoDeDados(ParticipantesProtecaoOdonto participantes) throws Exception {

        aguardarCarregamentoElemento(labelSeguroConfirmacaoDeDados);
        salvarEvidencia("Validar campos da tela \"Confirmação de dados\"");
        compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);
        compararElementoTexto(labelSeguroConfirmacaoDeDados, Protecao.SEGURO_CARTAO_DEBITO, MetodoComparacao.CONTEM);
        //compararElementoTexto(tituloCard, Protecao.TITULO_CONFIRMACAO_DADOS_CARTAO_DEBITO, MetodoComparacao.CONTEM);
        Assert.assertTrue(labelCartaoAsseguradoConfirmacaoDeDados.isDisplayed());
        Assert.assertTrue(botaoDataPagamentoConfirmacaoDeDados.isDisplayed());
        Assert.assertTrue(labelFormaPagamentoConfirmacaoDeDados.isDisplayed());
        Assert.assertTrue(labelValorTotalConfirmacaoDeDados.isDisplayed());

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
        Assert.assertTrue(!checkBoxSeguroTermosCondicoesConfirmacaoDeDados.isSelected());
        Assert.assertTrue(botaoContratarSeguroConfirmacaoDeDados.isDisplayed());
        salvarEvidencia("Validar campos da tela \"Confirmação de dados\"");
        return this;
    }

    //botao 1 ou 2 = caso tenha o mesmo botao de nome repetido na tela
    @Step("Validar \"Informações do Seguro\" em \"seguro/detalhes/confirmação de dados\"")
    public ProtecaoCreditoTela validarSecaoInformacoesSeguro(TipoSecaoProtecao tipoSecaoProtecao, Protecao botao) throws Exception {

        switch (tipoSecaoProtecao) {
            case INFORMACOES_SEGURO_FROM_DETALHES:
                validarSecaoInformacoesSeguroCartaoFromDetalhesTipoDebito(botao);
                break;
            case INFORMACOES_SEGURO_FROM_CONFIRMACAO_DADOS:
                validarSecaoInformacoesSeguroCartaoFromConfirmacaoDadosTipoDebito(botao);
                break;
            case INFORMACOES_SEGURO_FROM_CARD_CONTRATADO:
                validarSecaoInformacoesDoProdutoFromCartaoCardContratadosTipoDebito();
                break;
        }
        return this;
    }
    /**
     * Trocar campo data de pagamento
     *
     * @return
     * @throws Exception
     */
    @Step("Trocar campo data de pagamento")
    public ProtecaoCreditoTela trocarDataPagamentoTelaCalendario() throws Exception {
        aguardarCarregamentoElemento(botaoDataPagamentoConfirmacaoDeDados);
        String dateBefore=botaoDataPagamentoConfirmacaoDeDados.getText();
        System.out.println(">>>>data antes: "+dateBefore);
        salvarEvidencia("Trocar campo data de pagamento");
        tocarElemento(botaoDataPagamentoConfirmacaoDeDados, "Não foi possível clicar no botão \"Data do Pagamento\"");
        aguardarCarregamentoElemento(botaoConfirmarCalendario);
        tocarElemento(botaoConfirmarCalendario, "nao foi possivel clicar no botão \"confirmar\" do calendario");

        aguardarCarregamentoElemento(botaoDataPagamentoConfirmacaoDeDados);
        System.out.println(">>>>> data depois: "+botaoDataPagamentoConfirmacaoDeDados.getText());
        salvarEvidencia("Campo data de pagamento alterado");
        return this;
    }

    /**
     * Acessar "Termos e Condições"
     *
     * @return
     * @throws Exception
     */
    @Step("Acessar \"Termos e Condições\"")
    public ProtecaoCreditoTela acessarTermosCondicoes() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(botaoLerTermosCondicoesConfirmacaoDeDados);
        salvarEvidencia("Acessar \"Termos e Condições\"");
        tocarElemento(botaoLerTermosCondicoesConfirmacaoDeDados, "Não foi possível clicar no botão ler Termos e Condicoes");
        return this;
    }

    @Step("Validar \"Termos e Condições\"")
    public ProtecaoCreditoTela validarTelaTermosCondicoes() throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        salvarEvidencia("Validar layout \"Termos e Condições\"");
        compararElementoTexto(headerTitulo, Protecao.TERMOS_CONDICOES, MetodoComparacao.CONTEM);

        List<MobileElement> todosTermos = retornarLista(new By.ById("br.com.bradesco.next:id/protection_item_term_title"), "Termos não encontrados");

        System.out.println(">>>>>> QTD DE TERMOS>>>>: "+todosTermos.size());

        int ind=0;
        for (MobileElement termo : todosTermos) {
            ind++;
            aguardarCarregamentoElemento(termo);
            tocarElemento(termo, "não foi possível tocar no Termo "+ind);
            aguardarCarregamentoElemento(headerTitulo);
            if(headerTitulo.getText().contains(Protecao.TERMOS_CONDICOES.toString())){
                salvarEvidencia("Clicando no Termo "+ind);
                tocarElemento(termo, "não foi possível tocar no Termo "+ind);
            }else{
                aguardarCarregamentoElemento(headerBotaoVoltar);
                salvarEvidencia("Clicando no Termo "+ind);
                tocarElemento(headerBotaoVoltar, "Não foi possivel tocar no botão voltar");
            }
        }

        tocarElemento(headerBotaoVoltar, "Erro ao tocar botão Fechar(x) Termo e Condicoes");
        return this;
    }

    /**
     * Tocar na check box "Li e aceito os termos e condições"
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar na check box \"Li e aceito os termos e condições\"")
    public ProtecaoCreditoTela tocarCheckBoxLiAceitoTermosCondicoes() throws Exception {
        rolaTelaBaixo();


                aguardarCarregamentoElemento(headerTitulo);
                aguardarCarregamentoElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados);
                tocarElemento(checkBoxSeguroTermosCondicoesConfirmacaoDeDados, "Não foi possível clicar no botao \"checkBox SeguroTermosCondicoes\"");
                Assert.assertTrue(botaoContratarSeguroConfirmacaoDeDados.isEnabled());



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
    public ProtecaoCreditoTela tocarBotaoContratarTelaConfirmacaoDeDados() throws Exception {
        rolaTelaBaixo();

                aguardarCarregamentoElemento(botaoContratarSeguroConfirmacaoDeDados);
                salvarEvidencia("Tocar no botão \"Contratar\" da tela \"Confirmação de dados\"");
                tocarElemento(botaoContratarSeguroConfirmacaoDeDados, "Não foi possível clicar no botao \"CONTRATAR\" da tela Confirmação de Dados do Seguro");


        return this;
    }

    private void validarSecaoInformacoesSeguroCartaoFromDetalhesTipoDebito(Protecao botao) throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(headerTitulo);
        compararElementoTexto(rodapeDetalhesSecaoInformacoesDoSeguro, Protecao.RODAPE_INFORMACOES_DO_SEGURO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar seção Informações do Seguro");

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
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "Não foi possível clicar no botao \"Dados da Seguradora\"");
        aguardarCarregamentoElemento(textoInternoCollapseAbaInformacoesDoSeguro);
        compararElementoTexto(textoInternoCollapseAbaInformacoesDoSeguro, Protecao.DADOS_DA_SEGURADORA_TEXTO_CARTAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar detalhes dos Dados da seguradora em informacoes do Seguro");
        tocarElemento(botaoDadosDaSeguradoraInformacoesSeguro, "Não foi possível clicar no botao \"Dados da Seguradora\"");
        aguardarCarregamentoElemento(segundoBotaoSimularContratarCard);
        Assert.assertTrue(segundoBotaoSimularContratarCard.isDisplayed());
        //TODO: Alterar o elemento segundoBotaoSimularContratarCard para segundoBotaoContratarCard (Alteração necesária pois no IOS os botões tem identificações diferentes)

        //TODO: swap para cima nao funciona nessa parte, estou tendo que voltar e entrar de novo para aparecer no topo da pagina
        if(botao.equals(Protecao.PRIMEIRO_BOTAO_CONTRATAR_FROM_DETALHES)){
            tocarElemento(headerBotaoVoltar, "nao foi possivel clicar no botão voltar");
            aguardarCarregamentoElemento(botaoDetalhes);
            tocarElemento(botaoDetalhes, "Não foi possível clicar no botão1 CONTRATAR ");
        }
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

    /**
     * Validar layout tela confirmação de contratação
     *
     * @return
     * @throws Exception
     */

    @Step("Validar layout tela confirmação de contratação")
    public ProtecaoCreditoTela validarLayoutTelaConfirmacaoContratacao() throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        salvarEvidencia("Validar layout tela confirmação de contratação");
        compararElementoTexto(headerTitulo, Protecao.SUCESSO, MetodoComparacao.CONTEM);
        validarLayoutTelaConfirmacaoContratacaoSeguroCartao();
        return this;
    }

    private void validarLayoutTelaConfirmacaoContratacaoSeguroCartao() throws Exception {

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
    public ProtecaoCreditoTela validarLayoutCardContratado() throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        rolaTelaBaixo();
        aguardarCarregamentoElemento(tituloPrimeiroCardContratado);
        salvarEvidencia("Validar card contratado - NAO PODE HAVER OUTROS CARDS CONTRATADOS - APENAS O DO TESTE!");

        compararElementoTexto(tituloPrimeiroCardContratado, Protecao.CARTAO_DEBITO, MetodoComparacao.CONTEM);

        Assert.assertTrue(statusPrimeiroCardContratado.isDisplayed());
        Assert.assertTrue(botaoDetalhesPrimeiroCardContratado.isDisplayed());
        return this;
    }
    /**
     * Validar seção "Proteção" tela Contratados Seguro (Debito/Credito)
     *
     * @return
     * @throws Exception
     */

    @Step("Validar card contratado na seção Contratados")
    public ProtecaoCreditoTela validarTelaDetalhesCardContratado() throws Exception {
        aguardarCarregamentoElemento(tituloDetalhesCardContratado);
        salvarEvidencia("Validar seção \"Proteção\" tela Contratados Seguro");
        compararElementoTexto(headerTitulo, Protecao.PROTECAO, MetodoComparacao.CONTEM);
        Assert.assertTrue(iconeLixeiraTelaSeguroContratado.isDisplayed());
        Assert.assertTrue(headerBotaoVoltar.isDisplayed());


        compararElementoTexto(tituloDetalhesCardContratado, Protecao.CARTAO_DEBITO, MetodoComparacao.CONTEM);
        compararElementoTexto(subtituloDetalhesCardContratado, Protecao.SEGURO_CARTAO_DEBITO, MetodoComparacao.CONTEM);
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
     * Clicar no botão Detalhes na tela cards contratados
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no botão Detalhes na tela cards contratados")
    public ProtecaoCreditoTela tocarBotaoDetalhesCardContratado() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(botaoDetalhesCardContratado);
        salvarEvidencia("Clicar no botão Detalhes na tela cards contratados");
        tocarElemento(botaoDetalhesCardContratado, "Não foi possível clicar no botão Detalhes da tela cards contratados");
        return this;
    }

    /**
     * Validar seção "Acione Seu Seguro" tela Detalhes do Card Contratado
     *
     * @return
     * @throws Exception
     */

    @Step("Validar seção \"Acione Seu Seguro\" tela Detalhes do Card Contratado")
    public ProtecaoCreditoTela validarAcioneSeguroTelaDetalhesCardContratado() throws Exception {
        aguardarCarregamentoElemento(headerTitulo);
        rolaTelaBaixo();
        salvarEvidencia("Validar seção \"Acione Seu Seguro\" tela Detalhes do Card Contratado");

        tocarElemento(acioneSeuSeguroCentralAtendimento, "Não foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroCentralAtendimento);
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - Central de Atendimento");
        tocarElemento(cancelarPopUpLigacao, "Não foi possivel fechar o pop-up");

        tocarElemento(acioneSeuSeguroSac, "Não foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroSac);
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - SAC");
        tocarElemento(cancelarPopUpLigacao, "Não foi possivel fechar o pop-up");

        tocarElemento(acioneSeuSeguroDeficiencia, "Não foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroDeficiencia);
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - Deficiencia");
        tocarElemento(cancelarPopUpLigacao, "Não foi possivel fechar o pop-up");

        tocarElemento(acioneSeuSeguroOuvidoria, "Não foi possivel clicar no telefone Central de Atendimento");
        aguardarCarregamentoElemento(acioneSeuSeguroOuvidoria);
        Assert.assertTrue(popUpLigacao.isDisplayed());
        salvarEvidencia("Validar Acione seu Seguro - Ouvidoria");
        tocarElemento(cancelarPopUpLigacao, "Não foi possivel fechar o pop-up");

        Assert.assertTrue(botaoInformaçõesSeguroOuPlanoCardContratado.isDisplayed());

        return this;
    }

    /**
     * Tocar no botão "Informações do Seguro" (debito) ou "Informações do Plano" (credito)
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar no botão \"Informações do Seguro/Plano\"")
    public ProtecaoCreditoTela tocarBotaoInformacoesSeguroOuPlano() throws Exception {
        rolaTelaBaixo();
        aguardarCarregamentoElemento(botaoInformaçõesSeguroOuPlanoCardContratado);
        salvarEvidencia("Tocar no botão \"Informações do Seguro/Plano\"");
        tocarElemento(botaoInformaçõesSeguroOuPlanoCardContratado, "Não foi possível clicar no botao \"Informacoes do Seguro/Plano\"");
        Assert.assertTrue(labelInformacoesProduto.isEnabled());
        return this;
    }

    /**
     * Tocar botão cancelar "lixeira" Protecao (sup/dir)
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão cancelar \"lixeira\" Protecao (sup/dir)")
    public ProtecaoCreditoTela tocarBotaoCancelarProtecao() throws Exception {
        salvarEvidencia("Tocar botão cancelar \"lixeira\" Protecao (sup/dir)");
        aguardarCarregamentoElemento(iconeLixeiraTelaSeguroContratado);
        tocarElemento(iconeLixeiraTelaSeguroContratado, "Não foi possível clicar no botao \"lixeira\" excluir");
        return this;
    }

    /**
     * Validar layout Tela de Cancelar Protecao
     *
     * @return
     * @throws Exception
     */
    @Step("Validar layout Tela de Cancelar Protecao")
    public ProtecaoCreditoTela validarLayoutTelaCancelarProtecao() throws Exception {
        aguardarCarregamentoElemento(tituloHeaderTelaConfirmacaoCancelamento);
        salvarEvidencia("Validar layout Tela de Cancelar Protecao");
        compararElementoTexto(tituloHeaderTelaConfirmacaoCancelamento, Protecao.PROTECAO, MetodoComparacao.CONTEM);
        Assert.assertTrue(headerBotaoVoltar.isDisplayed());
        compararElementoTexto(tituloTelaExclusaoSeguro, Protecao.PERGUNTA_MOTIVO_CANCELAMENTO_PLANO, MetodoComparacao.CONTEM);

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
    public ProtecaoCreditoTela selecionarMotivoCancelamento() throws Exception {
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
    public ProtecaoCreditoTela tocarBotaoConfirmarTelaCancelamentoProtecao() throws Exception {
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
    public ProtecaoCreditoTela validarLayoutTelaCancelamentoComSucesso() throws Exception {
        aguardarCarregamentoElemento(tituloHeaderTelaConfirmacaoCancelamento);
        salvarEvidencia("Validar layout tela Cancelamento efetuado com sucesso");
        compararElementoTexto(tituloTelaExclusaoSeguro, Protecao.PEDIDO_CANCELAMENTO_EFETUADO, MetodoComparacao.CONTEM);
        Assert.assertTrue(botaoConcluirTelaSucessoExclusaoSeguro.isDisplayed());
        return this;
    }

    /**
     * Tocar Botão "Concluir" da tela sucesso contratacao/cancelamento
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar Botão \"Concluir\" da tela \"Sucesso\"")
    public ProtecaoCreditoTela tocarBotaoConcluir(TipoSecaoProtecao tipoSecaoProtecao) throws Exception {

        if(tipoSecaoProtecao.equals(TipoSecaoProtecao.CONTRATACAO)){
            aguardarCarregamentoElemento(botaoConcluirTelaSucesso);
            salvarEvidencia("Tocar Botão \"Concluir\" da tela Contratado com \"Sucesso\"");
            tocarElemento(botaoConcluirTelaSucesso, "Não foi possível clicar no botao \"CONCLUIR\"");
        }else{
            aguardarCarregamentoElemento(botaoConcluirTelaSucessoExclusaoSeguro);
            salvarEvidencia("Tocar Botão \"Concluir\" da tela Excluido com \"Sucesso\"");
            tocarElemento(botaoConcluirTelaSucessoExclusaoSeguro, "Não foi possível clicar no botao \"CONCLUIR\"");
        }

        return this;
    }

    /**
     * Tocar botão voltar (sup/esq)
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão voltar (sup/esq)")
    public ProtecaoCreditoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão voltar (sup/esq)");
        aguardarCarregamentoElemento(headerBotaoVoltar);
        tocarElemento(headerBotaoVoltar, "Não foi possível clicar no botao \"voltar\"");
        return this;
    }

}
