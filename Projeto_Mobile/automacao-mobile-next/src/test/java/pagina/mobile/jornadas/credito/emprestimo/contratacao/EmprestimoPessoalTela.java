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
    @iOSXCUITFindBy(accessibility = "Usar grana de emergência para pagamento de parcelas Selecionado")
    @iOSXCUITFindBy(accessibility = "Usar grana de emergência para pagamento de parcelas")
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
    @iOSXCUITFindBy(accessibility = "Repetir débito automático: Autorizado")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_repeat_auto_debt")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_repeat_auto_debit")
    private MobileElement textRepetirDebitoAutomaticoAut;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"Autorizado\"])[2]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_emergency_money")
    @iOSXCUITFindBy(accessibility = "Usar grana de emergência: Autorizado")
    private MobileElement textUsarGranaEmergencia;

    public EmprestimoPessoalTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Empréstimo Pessoal'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença tela 'Empréstimo Pessoal'")
    public EmprestimoPessoalTela validarPresencaTelaEmprestimoPessoal() throws Exception {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPRESTIMO_PESSOAL, Mensagem.GARANTA_MAIOR_COMODIDADE), MetodoComparacaoBooleano.VERDADEIRO, "Título '" + TituloTela.EMPRESTIMO_PESSOAL + "' e/ou mensagem '" + Mensagem.GARANTA_MAIOR_COMODIDADE + "' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela 'Empréstimo Pessoal'");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public EmprestimoPessoalTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Tocar check 'Repetir tentativas de débito automático'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar check 'Repetir tentativas de débito automático'")
    public EmprestimoPessoalTela tocarCheckRepetirTentativasDeDebitoAutomatico() throws Exception {
        salvarEvidencia("Tocar check 'Repetir tentativas de débito automático'");
        tocarElemento(checkRepetirTentativasDeDebitoAutomatico, "Não foi possível tocar no check 'Repetir tentativas de débito automático'");
        return this;
    }

    /**
     * Tocar check 'Usar grana de emergência para pagamento de parcelas'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar check 'Usar grana de emergência para pagamento de parcelas'")
    public EmprestimoPessoalTela tocarCheckUsarGranaDeEmergenciaParaPagamentoDeParcelas() throws Exception {
        salvarEvidencia("Tocar check 'Usar grana de emergência para pagamento de parcelas'");
        tocarElemento(checkUsarGranaDeEmergenciaParaPagamentoParcelas, "Não foi possível tocar no check 'Usar grana de emergência para pagamento de parcelas'");
        return this;
    }

    /**
     * Tocar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public EmprestimoPessoalTela tocarbotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "Não foi possível encontrar o botão 'Continuar'");
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Tocar botão 'Mais Opcoes'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Mais Opcoes'")
    public EmprestimoPessoalTela tocarbotaoMaisOpcoes() throws Exception {
        salvarEvidencia("Tocar botão 'Mais Opcoes'");
        tocarElemento(botaoMaisOpcoes, "Não foi possível tocar no botão 'Mais Opcoes'");
        return this;
    }

    /**
     * Tocar botão 'Contratar Emprestimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Contratar Emprestimo'")
    public EmprestimoPessoalTela tocarbotaoContratarEmprestimo() throws Exception {
        salvarEvidencia("Tocar botão 'Contratar Emprestimo'");
        tocarElemento(botaoContratarEmprestimo, "Não foi possível tocar no botão 'Contratar Emprestimo'");
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
        tocarElemento(checkBoxLiAceitoTermos, "Não foi possível selecionar Checkox Li Termos");
        return this;
    }

    /**
     * Tocar botão 'Continuar' Termos Condicoes
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar' Termos Condicoes")
    public EmprestimoPessoalTela tocarbotaoContinuarTermos() throws Exception {
        salvarEvidencia("Tocar botão 'Continuar' Termos Condicoes");
        tocarElemento(botaoContinuarTermo, "Não foi possível tocar no botão 'Continuar' Termos Condicoes");
        return this;
    }

    /**
     * Tocar botão 'ok'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'ok'")
    public EmprestimoPessoalTela tocarbotaoOk() throws Exception {
        salvarEvidencia("Tocar botão 'ok'");
        tocarElemento(botaoOk, "Não foi possível tocar no botão 'ok'");
        return this;
    }

    /**
     * Tocar botão 'Ver Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Ver Comprovante'")
    public EmprestimoPessoalTela tocarbotaoVerComprovante() throws Exception {
        esperarCarregando();
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão 'Ver Comprovante'");
        tocarElemento(botaoVerComprovante, "Não foi possível tocar no botão 'Ver Comprovante'");
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
        tocarElemento(botaocompartilhar,"Não foi possível tocar elemento 'Compartilhar'");
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
        validarAtributoBooleano(checkRepetirTentativasDeDebitoAutomatico, "enabled", "true","Valor esperado para a situação do Checkbox repetir tentativas é habilitado era: true\nValor obtido foi: false");
        if(android) validarAtributoBooleano(checkRepetirTentativasDeDebitoAutomatico, "checked", "true","Valor esperado para a situação do Checkbox repetir tentativas é habilitado era: true\nValor obtido foi: false");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textRepetirDebitoAutomaticoAut, "Não foi possível encontrar Repetir Débito Automático");
        salvarEvidencia("Validar 'Debito Automatico' Autorizado");
        if (ios){
            validarCondicaoBooleana(verificarPresencaElemento(textRepetirDebitoAutomaticoAut), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possivel validar Debito Automatico Autorizado");
        }else {
            validarCondicaoBooleana(retornarTexto(textRepetirDebitoAutomaticoAut,"Não foi possivel Validar Elemento 'Debito Automatico'").contains(texto), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possivel verificar a mensagem");
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
            validarCondicaoBooleana(verificarPresencaElemento(textUsarGranaEmergencia), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possivel validar se Utilizar Grana de Emergencia está Autorizada");
        }else {
            validarCondicaoBooleana(retornarTexto(textUsarGranaEmergencia,"Não foi possivel").contains(texto), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possivel verificar a mensagem");
        }
        return this;
    }
}
