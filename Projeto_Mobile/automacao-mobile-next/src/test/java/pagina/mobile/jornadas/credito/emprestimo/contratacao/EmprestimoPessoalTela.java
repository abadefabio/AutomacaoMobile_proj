package pagina.mobile.jornadas.credito.emprestimo.contratacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.credito.Mensagem;
import constantes.credito.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EmprestimoPessoalTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@name='Voltar']")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar']")
    private MobileElement botaoVoltar;

    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.CheckBox")
    private MobileElement checkRepetirTentativasDeDebitoAutomatico;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Usar grana de emerg�ncia para pagamento de parcelas Selecionado")
    @iOSXCUITFindBy(accessibility = "Usar grana de emerg�ncia para pagamento de parcelas")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ncbl_option2")
    private MobileElement checkUsarGranaDeEmergenciaParaPagamentoParcelas;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @AndroidFindBy(xpath = "//*[@text='CONTINUAR']")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_more")
    @iOSXCUITFindBy(accessibility = "Lista")
    private MobileElement botaoMaisOpcoes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_image_add")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    private MobileElement botaoContratarEmprestimo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/checkbox")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Li e concordo com o regulamento\"]/../../XCUIElementTypeButton[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name,\"Li e concordo com\")])[1]/XCUIElementTypeButton[2]")
    private MobileElement checkBoxLiAceitoTermos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_get_loan")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_to_hire")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuarTermo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOk;

    @AndroidFindBy(xpath = "//*[@text='VER COMPROVANTE' or @text='Ver comprovante']")
    @iOSXCUITFindBy(accessibility = "VER COMPROVANTE")
    private MobileElement botaoVerComprovante;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_share")
    @iOSXCUITFindBy(accessibility = "COMPARTILHAR")
    private MobileElement botaocompartilhar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Repetir d�bito autom�tico: Autorizado")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_repeat_auto_debt")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_repeat_auto_debit")
    private MobileElement textRepetirDebitoAutomaticoAut;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"Autorizado\"])[2]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_emergency_money")
    @iOSXCUITFindBy(accessibility = "Usar grana de emerg�ncia: Autorizado")
    private MobileElement textUsarGranaEmergencia;

    public EmprestimoPessoalTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Empr�stimo Pessoal'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Empr�stimo Pessoal'")
    public EmprestimoPessoalTela validarPresencaTelaEmprestimoPessoal() throws Exception {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO_PESSOAL, Mensagem.GARANTA_MAIOR_COMODIDADE), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo '" + TituloTela.EMPRESTIMO_PESSOAL + "' e/ou mensagem '" + Mensagem.GARANTA_MAIOR_COMODIDADE + "' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela 'Empr�stimo Pessoal'");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public EmprestimoPessoalTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Tocar check 'Repetir tentativas de d�bito autom�tico'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar check 'Repetir tentativas de d�bito autom�tico'")
    public EmprestimoPessoalTela tocarCheckRepetirTentativasDeDebitoAutomatico() throws Exception {
        salvarEvidencia("Tocar check 'Repetir tentativas de d�bito autom�tico'");
        tocarElemento(checkRepetirTentativasDeDebitoAutomatico, "N�o foi poss�vel tocar no check 'Repetir tentativas de d�bito autom�tico'");
        return this;
    }

    /**
     * Tocar check 'Usar grana de emerg�ncia para pagamento de parcelas'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar check 'Usar grana de emerg�ncia para pagamento de parcelas'")
    public EmprestimoPessoalTela tocarCheckUsarGranaDeEmergenciaParaPagamentoDeParcelas() throws Exception {
        salvarEvidencia("Tocar check 'Usar grana de emerg�ncia para pagamento de parcelas'");
        tocarElemento(checkUsarGranaDeEmergenciaParaPagamentoParcelas, "N�o foi poss�vel tocar no check 'Usar grana de emerg�ncia para pagamento de parcelas'");
        return this;
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public EmprestimoPessoalTela tocarbotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "N�o foi poss�vel encontrar o bot�o 'Continuar'");
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Tocar bot�o 'Mais Opcoes'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Mais Opcoes'")
    public EmprestimoPessoalTela tocarbotaoMaisOpcoes() throws Exception {
        salvarEvidencia("Tocar bot�o 'Mais Opcoes'");
        tocarElemento(botaoMaisOpcoes, "N�o foi poss�vel tocar no bot�o 'Mais Opcoes'");
        return this;
    }

    /**
     * Tocar bot�o 'Contratar Emprestimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Contratar Emprestimo'")
    public EmprestimoPessoalTela tocarbotaoContratarEmprestimo() throws Exception {
        salvarEvidencia("Tocar bot�o 'Contratar Emprestimo'");
        tocarElemento(botaoContratarEmprestimo, "N�o foi poss�vel tocar no bot�o 'Contratar Emprestimo'");
        return this;
    }

    /**
     * selecionar Checkox Li Termos
     *
     * @return
     * @throws Exception
     */
    @Step("selecionar Checkox Li Termos")
    public EmprestimoPessoalTela selecionarCheckoxLiTermos() throws Exception {
        esperarCarregando();
        rolarTelaAteFinal();
        salvarEvidencia("selecionar Checkox Li Termos");
        tocarElemento(checkBoxLiAceitoTermos, "N�o foi poss�vel selecionar Checkox Li Termos");
        return this;
    }

    /**
     * Tocar bot�o 'Continuar' Termos Condicoes
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar' Termos Condicoes")
    public EmprestimoPessoalTela tocarbotaoContinuarTermos() throws Exception {
        salvarEvidencia("Tocar bot�o 'Continuar' Termos Condicoes");
        tocarElemento(botaoContinuarTermo, "N�o foi poss�vel tocar no bot�o 'Continuar' Termos Condicoes");
        return this;
    }

    /**
     * Tocar bot�o 'ok'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'ok'")
    public EmprestimoPessoalTela tocarbotaoOk() throws Exception {
        salvarEvidencia("Tocar bot�o 'ok'");
        tocarElemento(botaoOk, "N�o foi poss�vel tocar no bot�o 'ok'");
        return this;
    }

    /**
     * Tocar bot�o 'Ver Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ver Comprovante'")
    public EmprestimoPessoalTela tocarbotaoVerComprovante() throws Exception {
        esperarCarregando();
        rolarTelaAteFinal();
        salvarEvidencia("Tocar bot�o 'Ver Comprovante'");
        tocarElemento(botaoVerComprovante, "N�o foi poss�vel tocar no bot�o 'Ver Comprovante'");
        return this;
    }

    /**
     * Validar presenca Elemento 'Compartilhar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar Elemento 'Compartilhar'")
    public EmprestimoPessoalTela tocarBotaoCompartilhar() throws Exception {
        aguardarCarregamentoElemento(botaocompartilhar);
        salvarEvidencia("Tocar Elemento 'Compartilhar'");
        tocarElemento(botaocompartilhar,"N�o foi poss�vel tocar elemento 'Compartilhar'");
        return this;
    }

    /**
     * Verificar se o CheckBox 'Repetir Tentativas De Debito Automatico' esta Marcado
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar se o CheckBox 'Repetir Tentativas De Debito Automatico' esta Marcado")
    public EmprestimoPessoalTela verificarCheckRepetirTentativasDeDebitoAutomaticoMarcado() throws Exception {
        salvarEvidencia("Verificar se o CheckBox 'Repetir Tentativas De Debito Automatico' esta Marcado");
        validarAtributoBooleano(checkRepetirTentativasDeDebitoAutomatico, "enabled", "true","Valor esperado para a situa��o do Checkbox repetir tentativas � habilitado era: true\nValor obtido foi: false");
        if(android) validarAtributoBooleano(checkRepetirTentativasDeDebitoAutomatico, "checked", "true","Valor esperado para a situa��o do Checkbox repetir tentativas � habilitado era: true\nValor obtido foi: false");
        return this;
    }

    /**
     * Validar 'Debito Automatico' Autorizado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar 'Debito Automatico' Autorizado")
    public EmprestimoPessoalTela validarTextoDebitoAutomaticoAutorizado(String texto) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textRepetirDebitoAutomaticoAut, "N�o foi poss�vel encontrar Repetir D�bito Autom�tico");
        salvarEvidencia("Validar 'Debito Automatico' Autorizado");
        if (ios){
            validarCondicaoBooleana(verificarPresencaElemento(textRepetirDebitoAutomaticoAut), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi possivel validar Debito Automatico Autorizado");
        }else {
            validarCondicaoBooleana(retornarTexto(textRepetirDebitoAutomaticoAut,"N�o foi possivel Validar Elemento 'Debito Automatico'").contains(texto), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi possivel verificar a mensagem");
        }
        return this;
    }

    /**
     * Validar 'Utilizar Grana de Emergencia' Autorizada
     *
     * @return
     * @throws Exception
     */
    @Step("Validar 'Utilizar Grana de Emergencia' Autorizada")
    public EmprestimoPessoalTela validarTextoUsarGranaEmergenciaAutorizado(String texto) throws Exception {
        aguardarCarregamentoElemento(textUsarGranaEmergencia);
        salvarEvidencia("Validar 'Utilizar Grana de Emergencia' Autorizada");
        if (ios){
            validarCondicaoBooleana(verificarPresencaElemento(textUsarGranaEmergencia), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi possivel validar se Utilizar Grana de Emergencia est� Autorizada");
        }else {
            validarCondicaoBooleana(retornarTexto(textUsarGranaEmergencia,"N�o foi possivel").contains(texto), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi possivel verificar a mensagem");
        }
        return this;
    }
}
