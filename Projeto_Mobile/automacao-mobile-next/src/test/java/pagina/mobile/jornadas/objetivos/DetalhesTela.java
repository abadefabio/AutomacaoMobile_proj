package pagina.mobile.jornadas.objetivos;


import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.objetivos.MensagensObjetivos;
import constantes.objetivos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.reformatarValorMonetario;

public class DetalhesTela extends PaginaBase {

    // texto Detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/discover_profile")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Detalhes\"]")
    private MobileElement textoDetalhes;

    // titulo da tela Detalhes
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"DETALHES\"]")
    private MobileElement tituloTelaDetalhes;

    // switch parcelas mensais
    @AndroidFindBy(id = "br.com.bradesco.next:id/sw_subscribe_status")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Parcelas mensais, Valor da parcela: R$  50,00, Dia da aplica��o: todo dia 5\"]")
    private MobileElement switchParcelasMensais;

    // texto descricao valor da parcela
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_installment")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Valor da parcela\")]")
    private MobileElement textoValorParcela;

    // texto Dia da aplicacao
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_monthy_payment_day")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Dia da aplica��o\")]")
    private MobileElement textoDiaAplicacao;

    // botao Editar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_edit")
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_edit")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Editar\"`]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Editar\"])[2]")
    private MobileElement botaoEditar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_edit")
    @iOSXCUITFindBy(accessibility = "icon edit medium")
    private MobileElement botaoEditarAgendamentoAporte;

    // texto total aplicado
    @AndroidFindBy(xpath = "//*[@text=\"Total aplicado\"]")
    @iOSXCUITFindBy(accessibility = "Total Aplicado")
    MobileElement textoTotalAplicado;

    // texto total aplicado
    @AndroidFindBy(xpath = "//*[@text=\"Resgatado\"]")
    @iOSXCUITFindBy(accessibility = "Resgatado")
    MobileElement textoResgatado;

    @AndroidFindBy(id = "br.com.bradesco.next:id/discover_profile")
    @iOSXCUITFindBy(accessibility = "Detalhes")
    private MobileElement botaoDetalhes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_schedules_layout")
    @iOSXCUITFindBy(accessibility = "Aplica��es agendadas")
    private MobileElement sessaoAportesAgendados;

    // botao editar "Lapis"
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_edit")
    @AndroidFindBy(accessibility = "Editar")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Editar\"])[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Editar\"`]")
    private MobileElement botaoLapisEditar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@value,\"R$\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_goal_suggestion")
    private MobileElement textoParcelasMensais;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"icon edit\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_edit")
    private MobileElement botaoLapisEditarParcelasMensais;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Todo\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_arrow_down")
    private MobileElement comboDiaDaAplicacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_save")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Salvar\"]")
    private MobileElement botaoSalvar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_edit")
    @iOSXCUITFindBy(accessibility = "icon edit medium")
    private MobileElement botaoLapisAportesAgendados;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_amount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Buscar\"]")
    private MobileElement textoValorDaAplicacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]/XCUIElementTypeButton")
    private MobileElement comboDataDaAplicacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Continuar'])[2]")
    private MobileElement tocarBotaoContinuarAporte;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"/\")]")
    private MobileElement dataAportesAgendados;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[5]/XCUIElementTypeStaticText[contains(@name,\"R\")]")
    private MobileElement valorAportesAgendados;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_show_product")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ver produto\"]")
    private MobileElement botaoVerProduto;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DETALHES\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextViewWithDrawDetailsAchieved")
    private MobileElement botaoDetalhesCardConcluido;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"QA-3208\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextViewWithDrawDetailsAchieved")
    private MobileElement cardObjetivo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @AndroidFindBy(xpath = "//me.next.uikit.NextNavigationIcon[@content-desc=\"Fechar, bot�o\"]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    public DetalhesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao Editar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Editar <\"")
    public DetalhesTela tocarBotaoEditar() throws Exception {
        aguardarCarregamentoElemento(botaoEditar);
        salvarEvidencia("'validar presenca botao Editar'");
        tocarElemento(botaoEditar, "erro ao tocar botao Editar.");
        return this;
    }

    /**
     * Tocar botao Lapis - Editar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Editar Lapis<\"")
    public DetalhesTela tocarBotaoLapisEditar() throws Exception {
        salvarEvidencia("'Tocar botao Editar'");
        tocarElemento(botaoLapisEditar, "erro ao tocar botao Editar.");
        return this;
    }

    /**
     * Tocar botao Editar agendamento aporte
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'Editar agendamento aporte' ")
    public DetalhesTela tocarBotaoEditarAgendamentoAporte() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEditarAgendamentoAporte, "N�o foi poss�vel encontrar o bot�o 'Editar aporte'");
        salvarEvidencia("Tocar bot�o 'Editar agendamento aporte'");
        tocarElemento(botaoEditarAgendamentoAporte, "Erro ao tocar bot�o 'Editar agendamento aporte'.");
        return this;
    }

    /**
     * validar presenca do botao Editar
     *
     * @return
     * @throws Exception
     */
    @Step("Validar botao  \"Editar <\"")
    public DetalhesTela verificarPresencaBotaoEditar() throws Exception {
        rolaTelaBaixo();
        salvarEvidencia("'validar presenca botao Editar'");
        verificarPresencaElemento(botaoEditar);
        return this;
    }

    /**
     * validar Texto - Total Aplicado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto  \"Total Aplicado \"")
    public DetalhesTela validarTextoTotalAplicado(String texto) throws Exception {
        salvarEvidencia("'validar o texto Total Aplicado.");
        compararElementoTexto(textoTotalAplicado, texto, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * validar Texto - Detalhes
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto  \"Detalhes \"")
    public DetalhesTela validarTextoDetahes() throws Exception {
        aguardarCarregamentoElemento(textoDetalhes);
        salvarEvidencia("'validar presenca texto Detahes'");
        verificarPresencaElemento(textoDetalhes);
        return this;
    }

    /**
     * validar presenca switch
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presenca  \"switch <\"")
    public DetalhesTela validarPresencaSwitch() throws Exception {
        rolaTelaBaixo();
        salvarEvidencia("'validar presenca switch'");
        verificarPresencaElemento(switchParcelasMensais);
        return this;
    }

    /**
     * validar Texto - Resgatado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto  \"Resgatado \"")
    public DetalhesTela validarTextoResgatado(String texto) throws Exception {
        salvarEvidencia("'validar o texto Resgatado'");
        compararElementoTexto(textoResgatado, texto, MetodoComparacao.IGUAL);
        return this;
    }

    /**
     * validar Texto - Valor Parcela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto  \"Valor Parcela \"")
    public DetalhesTela validarTextoValorParcela(String texto) throws Exception {
        salvarEvidencia("'validar Texto Valor Parcela'");
        if (getDriver() instanceof AndroidDriver) {
            compararElementoTexto(textoValorParcela, texto, MetodoComparacao.CONTEM);
        } else {
            verificarPresencaElemento(textoValorParcela);
        }
        return this;
    }

    /**
     * Validar presenca da mensagem a aplicacao minima e de cinquenta reais
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presenca da mensagem a aplicacao minima e de cinquenta reais")
    public DetalhesTela validarPresencaMensagemAplicacaoMinimaCinquentaReais() throws Exception {
        aguardarCarregamentoElemento(MensagensObjetivos.MENSAGEM_VALOR_APLICACAO);
        validarCondicaoBooleana(aguardarPaginaConterQualquerTexto(MensagensObjetivos.MENSAGEM_VALOR_APLICACAO).isEmpty(), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem a aplicacao minima e de cinquenta reais n�o esta presente na tela");
        salvarEvidencia("Validado presenca da mensagem a aplicacao minima e de cinquenta reais");
        return this;
    }

    /**
     * validar Texto - Dia da aplicacao
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto  \"Dia Aplicacao\"")
    public DetalhesTela validarTextoDiaAplicacao(String texto) throws Exception {
        salvarEvidencia("'validar Texto Valor Parcela'");
        compararElementoTexto(textoDiaAplicacao, texto, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * Tocar no bot�o 'Detalhes'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Detalhes'")
    public DetalhesTela tocarBotaoDetalhes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDetalhes, "N�o foi poss�vel rolar at� o bot�o detalhes!");
        salvarEvidencia("Tocar bot�o 'Detalhes'");
        tocarElemento(botaoDetalhes, "N�o foi poss�vel tocar no bot�o detalhes!");
        return this;
    }

    /**
     * Validar a n�o presen�a da sess�o de agendamento de aporte
     *
     * @return
     * @throws Exception
     */
    @Step("Validar a n�o presen�a da sess�o de agendamento de aporte")
    public DetalhesTela validarNaoPresencaSessaoAgendamentoAporte() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(sessaoAportesAgendados), MetodoComparacaoBooleano.FALSO, "A sess�o de agendamento de aporte est� presente na tela!");
        salvarEvidencia("Validado a n�o presen�a da sess�o de agendamento de aporte!");
        return this;
    }

    /**
     * Validar a exibi��o da tela 'Detalhes'
     *
     * @return
     */
    @Step("Validar a exibi��o da tela 'Detalhes'")
    public DetalhesTela validarExibicaoDetalhesTela() {
        // valida a apresenta��o do texto devido o titulo da tela ser nomeado pelo o nome do objetivo.
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.DETALHES.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Detalhes' n�o est� presente na tela!");
        salvarEvidencia("Validar exibi��o da tela de 'Detalhes'");
        return this;
    }

    /**
     * Validar titulo Tela'Detalhes'
     *
     * @return
     */
    @Step("Validar a exibi��o da tela 'Detalhes'")
    public DetalhesTela validarTituloTelaDetalhes() {
        aguardarCarregamentoElemento(tituloTelaDetalhes);
        salvarEvidencia("Validado Titulo Tela 'detalhes'");
        verificarPresencaElemento(tituloTelaDetalhes);
        return this;
    }

    /**
     * Editar valor da parcela no campo 'parcelas mensais'
     *
     * @param valorParcelasMensais
     * @return
     * @throws NextException
     */
    @Step("Editar valor da parcela no campo 'parcelas mensais'")
    public DetalhesTela editarValorDaParcela(String valorParcelasMensais) throws Exception {
        apagarCampoTexto(textoParcelasMensais, "Erro ao apagar o campo: 'Parcelas Mensais'");
        escreverTexto(textoParcelasMensais, valorParcelasMensais, "Erro a editar no campo 'Parcelas Mensais'");
        salvarEvidencia("Digitou o valor: " + valorParcelasMensais + " no campo : 'Parcelas Mensais'");
        return this;
    }

    /**
     * Selecionar 'Dia da aplica��o'
     *
     * @return
     * @throws NextException
     */
    @Step("Selecionar 'Dia da aplica��o'")
    public DetalhesTela selecionarDiaDaAplicacao() throws NextException {
        salvarEvidencia("Tocar na combo: 'Dia Da Aplica��o'");
        tocarElemento(comboDiaDaAplicacao, "Erro ao tocar na combo: 'Dia Da Aplica��o'");
        return this;
    }

    /**
     * Tocar no Bot�o: 'Salvar'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Salvar'")
    public DetalhesTela tocarBotaoSalvar() throws NextException {
        salvarEvidencia("Tocar no bot�o: 'Salvar'");
        tocarElemento(botaoSalvar, "Erro ao tocar na combo: 'Dia Da Aplica��o'");
        return this;
    }

    /**
     * validar label: Valor da parcela R$ X.XXX,XX
     *
     * @param valorParcela
     * @return
     * @throws Exception
     */
    @Step("Validar a label 'Valor da parcela R$ X.XXX,XX'")
    public DetalhesTela validarValorDaParcela(String valorParcela) throws Exception {
        salvarEvidencia("Validar o Valor da Parcela: " + valorParcela);
        validarCondicaoBooleana(retornarTexto(textoValorParcela, "Erro ao recuperar o valor da parcela")
                        .replaceAll("[^0-9]", "").equals(valorParcela), MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar o valor da parcela");
        return this;
    }

    /**
     * Validar label: Dia da Aplica��o
     *
     * @param dia
     * @return
     * @throws Exception
     */
    @Step("Validar a label 'Dia da Aplica��o'")
    public DetalhesTela validarDiaDaAplicacao(String dia) throws Exception {
        salvarEvidencia("Validar o Dia da Aplica��o: " + dia);
        validarCondicaoBooleana(retornarTexto(textoDiaAplicacao, "Erro ao recuperar Dia da Aplica��o")
                        .contains(dia), MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar o dia da aplica��o");
        return this;
    }

    /**
     * Tocar no bot�o (lapis): 'Aportes Agendados'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o (lapis): 'Aportes Agendados'")
    public DetalhesTela tocarlapisAportesAgendados() throws NextException {
        salvarEvidencia("Tocar no bot�o (lapis): 'Aportes Agendados'");
        if(!verificarPresencaElemento(botaoLapisAportesAgendados)) {
            System.out.println("E necessario fazer um agendamento do aporte");
        }
        tocarElemento(botaoLapisAportesAgendados, "Erro ao tocar no bot�o (Lapis): 'Aportes Agendados'");
        return this;
    }

    /**
     * Editar o 'Valor da Aplica��o'
     *
     * @param valorDaAplicacao
     * @return
     * @throws NextException
     */
    @Step("Editar o 'Valor da Aplica��o'")
    public DetalhesTela editarValorDaAplicacao(String valorDaAplicacao) throws Exception {
        apagarCampoTexto(textoValorDaAplicacao, "Erro a editar no campo Valor da Aplica��o'");
        if (ios) {
            apagarCampoTexto(textoValorDaAplicacao, valorDaAplicacao.length() * 2, "Erro ao apagar o campo Valor da Aplica��o");
            escreverTexto(textoValorDaAplicacao, valorDaAplicacao + "\uE007", "Erro a editar no campo Valor da Aplica��o");
        } else {
            escreverTexto(textoValorDaAplicacao, valorDaAplicacao, "Erro a editar no campo Valor da Aplica��o'");
        }
        salvarEvidencia("Editou no campo: 'Aportes Agendados' o valor: " + valorDaAplicacao);
        return this;
    }

    /**
     * Tocar na 'Data da Aplica��o'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar na 'Data da Aplica��o'")
    public DetalhesTela tocarDataDaAplicacao() throws NextException {
        salvarEvidencia("Tocar na combo: 'Data Da Aplica��o'");
        tocarElemento(comboDataDaAplicacao, "Erro ao Tocar na combo: 'Data Da Aplica��o'");
        return this;
    }

    /**
     * Tocar no bot�o: 'Continuar'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o: 'Continuar'")
    public DetalhesTela tocarBotaoContinuar() throws NextException {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no bot�o: 'Continuar'");
        tocarElemento(botaoContinuar, "Erro ao Tocar no bot�o: 'Continuar'");
        return this;
    }

    /**
     * Validar na lista 'Aportes Agendados' a data agendada
     *
     * @param data
     * @return
     * @throws Exception
     */
    @Step("Validar na lista 'Aportes Agendados' a data agendada")
    public DetalhesTela validarAportesAgendadosDataAgendamento(String data) throws Exception {
        aguardarCarregamentoElemento(dataAportesAgendados);
        compararElementoTexto(dataAportesAgendados, data, MetodoComparacao.IGUAL);
        salvarEvidencia("Validou na lista 'Aportes agendados' a data: " + data);
        return this;
    }

    /**
     * Validar na lista 'Aportes Agendados' o valor agendado
     *
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Validar na lista 'Aportes Agendados' o valor agendado")
    public DetalhesTela validarAportesAgendadosValorAgendado(String valor) throws Exception {
        valor = "R$ ".concat(reformatarValorMonetario(valor));
        compararElementoTexto(valorAportesAgendados, valor, MetodoComparacao.IGUAL);
        salvarEvidencia("Validou na lista 'Aportes agendados' o valor: " + valor);
        return this;
    }


    /**
     * Tocar no Bot�o: 'Ver Produto'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Ver Produto'")
    public DetalhesTela tocarBotaoVerProduto() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerProduto, "Nao foi possivel encontrar botao 'Ver Produto'");
        salvarEvidencia("Tocar no bot�o: 'Ver produto'");
        tocarElemento(botaoVerProduto, "Erro ao tocar no botao 'Ver Produto'");
        return this;
    }

    /**
     * @return
     * @throws Exception
     */
    @Step("Tocar card Objetivo concluido")
    public DetalhesTela tocarCardObjetivo() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDetalhesCardConcluido, "Nao foi possivel encontrar elemento 'detalhes'");
        tocarElemento(cardObjetivo, "Nao foi possivel tocar no card");
        salvarEvidencia("Tocar card Objetivo concluido");
        return this;
    }

    /**
     * Tocar no Bot�o: 'Fechar'
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Fechar'")
    public DetalhesTela tocarBotaoFechar() throws Exception {
        salvarEvidencia("Tocar no bot�o: 'Fechar'");
        tocarElemento(botaoFechar, "Erro ao tocar no botao 'Fechar'");
        return this;
    }
}
