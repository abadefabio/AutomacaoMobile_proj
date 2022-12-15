package pagina.mobile.jornadas.pix.mais.opcoes;

import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.AtributoElemento;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;

import constantes.pix.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MeusLimitesPixTela extends PaginaBase {

    //Botao Menu Conta Poupança
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"CONTA-POUPANÇA\"]")
    @iOSXCUITFindBy(accessibility = "CONTA-POUPANÇA")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CONTA-POUPANÇA')]")
    @iOSXCUITFindBy(xpath = "//*[@value='CONTA-POUPANÇA']")
    private MobileElement botaoMenuContaPoupanca;

    //Botao menu Limite maior
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Minhas contas e Contatos Pix com limite maior\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Minhas contas e Contatos Pix com limite maior\"]")
    private MobileElement botaoMenuLimiteMaior;

    //botao Alterar Limite
    @AndroidFindBy(xpath = "//*[@text=\"ALTERAR LIMITE\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"ALTERAR LIMITE\"]")
    private MobileElement botaoAlterarLimite;

    //botao OK
    @AndroidFindBy(xpath = "//*[@text=\"OK\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"OK\"]")
    private MobileElement botaoOk;

    //botao voltar AOS meus limites
    @AndroidFindBy(xpath = "//*[@text=\"VOLTAR AOS MEUS LIMITES PIX\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"VOLTAR AOS MEUS LIMITES PIX\"]")
    private MobileElement botaoVoltarAosMeusLimites;

    //botão menu I
    @AndroidFindBy(accessibility = "informação sobre limites")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"MEUS LIMITES PIX\"]/XCUIElementTypeButton[2]")
    private MobileElement botaoMenuI;

    //botão Voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"MEUS LIMITES PIX\"]/XCUIElementTypeButton[1]")
    private MobileElement botaoVoltar;

    //opção Pix Saque e Pix Troco
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_limits_change_withdraw")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pix Saque e Pix Troco']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Pix Saque e Pix Troco']")
    private MobileElement opcaoPixSaquePixTroco;

    //botão alterar limite diurno
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_change_daily_limit")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='ALTERAR LIMITE'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='ALTERAR LIMITE'])[1]")
    private MobileElement botaoAlterarLimiteDiurno;

    //texto valor mínimo permitido no limite
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_info' and contains(@text, 'O valor mínimo é de R$')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Valor é menor que o permitido']")
    private MobileElement labelValorMinimoPermitidoLimite;

    //texto valor mínimo permitido no limite
    @AndroidFindBy(xpath = "//android.widget.SeekBar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSlider")
    private MobileElement barraDeLimite;

    @AndroidFindBy(xpath = "//*[contains(@text,'Empresas')]/..")
    @iOSXCUITFindBy(accessibility = "Empresas")
    private MobileElement botaoEmpresas;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Em análise')]")
    @iOSXCUITFindBy(accessibility = "Em Análise")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Em análise'")
    private MobileElement botaoEmAnalise;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ii_suffix_icon")
    @AndroidFindBy(id ="br.com.bradesco.next:id/ntf_input_limit_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField/XCUIElementTypeImage")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Diurno (06h às 20h)']/following::XCUIElementTypeTextField")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Diurno')]/following::XCUIElementTypeTextField")
    private MobileElement botaoLapis;

    public MeusLimitesPixTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão Conta poupança
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Tocar botão \"Conta poupança\"")
    public MeusLimitesPixTela tocarBotaoContaPoupanca() throws Exception {
        aguardarCarregamentoElemento(botaoMenuContaPoupanca);
        salvarEvidencia("Tocar no botão 'Conta poupança'");
        tocarElemento(botaoMenuContaPoupanca, "Não foi possível Tocar no botão Conta poupança");
        return this;
    }

    /**
     * Tocar botão 'Limite Maior'
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Tocar botão \"Limite Maior\"")
    public MeusLimitesPixTela tocarBotaoLimiteMaior() throws Exception {
        aguardarCarregamentoElemento(botaoMenuLimiteMaior);
        salvarEvidencia("Tocar no botão 'Limite Maior'");
        tocarElemento(botaoMenuLimiteMaior, "Não foi possível Tocar no botão Limite Maior");
        return this;
    }

    /**
     * Tocar botão 'Alterar Limite'
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Tocar botão \"Alterar Limite\"")
    public MeusLimitesPixTela tocarBotaoAlterarLimite() throws Exception {
        aguardarCarregamentoElemento(botaoAlterarLimite);
        salvarEvidencia("Tocar no botão 'Alterar Limite'");
        tocarElemento(botaoAlterarLimite, "Não foi possível Tocar no botão Alterar Limite");
        return this;
    }

    /**
     * Tocar Icone Lapis para editar limite
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Tocar Icone Lapis para editar limite")
    public MeusLimitesPixTela tocarIconeLapis(String tipoLimite) throws Exception {
        By botaoEditarLimiteLapis;

        if (ios) {
            botaoEditarLimiteLapis = By.xpath("//*[contains(@name,'" + tipoLimite + "')]/../XCUIElementTypeTextField");
            salvarEvidencia("Tocar no Icone Lapis");
            tocarCoordenada(botaoEditarLimiteLapis);
        } else {
            botaoEditarLimiteLapis = By.xpath("//*[contains(@text,'" + tipoLimite + "')]/following::*[@resource-id='br.com.bradesco.next:id/ntf_input_limit_value']");
            salvarEvidencia("Tocar no Icone Lapis");
            tocarElemento(botaoEditarLimiteLapis, "Não foi possível tocar no botão 'Lápis'");
        }
        return this;
    }

    /**
     * Recuperar valor do limite
     *
     * @param tipoLimite Tipo de limite (Limite diário ou Diurno)
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Recupera o valor do limite \"Valor Limite\"")
    public String recuperarValorDoLimite(String tipoLimite) throws Exception {
        By campoValorLimite;
        if (ios) {
            campoValorLimite = By.xpath("//*[contains(@name,'"+tipoLimite+"')]/../XCUIElementTypeTextField");
        } else {
            campoValorLimite = By.xpath("//*[contains(@text,'"+tipoLimite+"')]/following::*[@resource-id='br.com.bradesco.next:id/ntf_input_limit_value'][2]");
        }

        esconderTeclado();

        return retornarTexto(campoValorLimite, "Não foi possível extrair o valor do Novo Valor do limite");
    }

    /**
     * Preencher valor limite
     *
     * @param tipoLimite
     * @param valorLimite
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Preencher campo 'Valor Limite'")
    public MeusLimitesPixTela preencherValorLimite(String tipoLimite, String valorLimite) throws Exception {
        By campoValorLimite;
        if (ios) {
            campoValorLimite = By.xpath("//*[contains(@name,'"+tipoLimite+"')]/../XCUIElementTypeTextField");
            apagarCampoTexto(campoValorLimite, 10, "Não foi possível apagar o valor no campo 'Valor Limite'");
            escreverTexto(campoValorLimite, valorLimite, "Não foi possível escrever o valor limite");
        } else {
            campoValorLimite = By.xpath("//*[contains(@text,'"+tipoLimite+"')]/following::*[@resource-id='br.com.bradesco.next:id/ntf_input_limit_value']");
            teclarBackSpaceAteApagar(campoValorLimite, 10);
            digitarTexto(campoValorLimite, valorLimite);
        }
        esconderTeclado();
        salvarEvidencia("Valor limite alterado para: " + valorLimite);
        return this;
    }

    /**
     * Tocar Botão OK
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Tocar Botão \"OK\"")
    public MeusLimitesPixTela tocarBotaoOk() throws Exception {
        if (verificarPresencaElemento(botaoOk)) {
            salvarEvidencia("Tocar no botão OK");
            tocarElemento(botaoOk, "Não foi possível Tocar no botão OK");
        }
        return this;
    }

    /**
     * Tocar no Botão Voltar aos meus limites
     *
     * @return MeusLimitesPixTela
     * @throws NextException
     */
    @Step("Tocar no Botão Voltar aos meus limites")
    public MeusLimitesPixTela tocarBotaoVoltarMeusLimites() throws NextException {
        aguardarCarregamentoElemento(botaoVoltarAosMeusLimites);
        salvarEvidencia("Tocar no botão Voltar aos meus limites");
        tocarElemento(botaoVoltarAosMeusLimites, "Não foi possível Tocar no botão Voltar aos meus limites");
        return this;
    }

    /**
     * Tocar Botão I
     *
     * @return MeusLimitesPixTela
     * @throws NextException
     */
    @Step("Tocar Botão I")
    public MeusLimitesPixTela tocarBotaoI() throws NextException {
        aguardarCarregamentoElemento(botaoMenuI);
        salvarEvidencia("Tocar no botão I");
        tocarElemento(botaoMenuI, "Não foi possível Tocar no botão I");
        return this;
    }

    /**
     * Tocar no Botão Voltar aos meus limites
     *
     * @return MeusLimitesPixTela
     * @throws NextException
     */
    @Step("Tocar no Botão Voltar aos meus limites")
    public MeusLimitesPixTela tocarBotaoVoltar() throws NextException {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar no botão Voltar");
        tocarElemento(botaoVoltar, "Não foi possível Tocar no botão Voltar");
        return this;
    }

    /**
     * Tocar na opção 'Pix Saque e Pix Troco'
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Tocar na opção 'Pix Saque e Pix Troco'")
    public MeusLimitesPixTela tocarOpcaoPixSaquePixTroco() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar na opção 'Pix Saque e Pix Troco'");
        tocarElemento(opcaoPixSaquePixTroco, "Não foi possível tocar na opção 'Pix Saque e Pix Troco'");
        return this;
    }

    /**
     * Tocar na botão 'Alterar limite' diurno
     *
     * @return MeusLimitesPixTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Alterar limite' diurno")
    public MeusLimitesPixTela tocarBotaoAlterarLimiteDiurno() throws NextException {
        aguardarCarregamentoElemento(botaoAlterarLimiteDiurno);
        salvarEvidencia("Tocar no botão 'Alterar limite' diurno");
        tocarElemento(botaoAlterarLimiteDiurno, "Não foi possível tocar no botão 'Alterar limite' diurno");
        return this;
    }

    /**
     * Validar o valor mínimo do limite
     *
     * @return MeusLimitesPixTela
     */
    public MeusLimitesPixTela validarMensagemValorMinimoLimite() throws Exception {
        //TODO Remover if quando o campo texto de limite no Android for corrigido, pois o mesmo não está trazendo a propriedade text vazia
        //TODO Para testes em Android, validar manualmente se o label de valor minimo é apresentado em tela (rodar via debug e inserir breakpoint na linha 316)
        if (ios) {
            validarCondicaoBooleana(aguardarCarregamentoElemento(labelValorMinimoPermitidoLimite),
                    MetodoComparacaoBooleano.VERDADEIRO, "Erro ao apresentar o texto de validação de valor mínimo limite");
            salvarEvidencia("Apresentou o texto: " + retornarTexto(labelValorMinimoPermitidoLimite, "Erro ao apresentar o texto de validação de valor mínimo limite"));
        } else {
            salvarEvidencia("Validada a presença do texto 'O valor mínimo é de R$ 100,00'");
        }
        return this;
    }

    /**
     * Tocar na botão 'Barra de limite'
     *
     * @return MeusLimitesPixTela
     * @throws NextException
     */
    @Step("Tocar na Barra de limite")
    public MeusLimitesPixTela tocarBarraDeLimite(int Coordenada) throws NextException {

        salvarEvidencia("Tocar no botão 'Alterar limite' diurno");
        if (android) {
            tocarCoordenadaProporcional(barraDeLimite, Coordenada, 50);
        } else {
            arrastarElementoProporcional(barraDeLimite, Coordenada, 50);
            esconderTeclado();
        }

        return this;
    }

    /**
     * Tocar Botão 'Empresas'
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Tocar Botão 'Empresas'")
    public MeusLimitesPixTela tocarBotaoEmpresas() throws Exception{
        aguardarCarregamentoElemento(botaoEmpresas);
        salvarEvidencia("Tocar no botão 'Empresas'");
        tocarElemento(botaoEmpresas, "Não foi possível tocar no botão 'Empresas'");
        return this;
    }

    /**
     * Validar Presença Alteração de limite em análise
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Validar Presença Alteração de limite em análise")
    public MeusLimitesPixTela validarAlteracaoLimiteEmAnalise() {
        aguardarCarregamentoElemento(botaoEmAnalise);
        salvarEvidencia("Validada a presença de alteração de limite 'Em Análise'");
        return this;
    }

    /**
     * Tocar Botão Lápis
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Tocar Botão Lápis")
    public MeusLimitesPixTela tocarBotaoLapis() throws Exception{
        aguardarCarregamentoElemento(botaoLapis);
        salvarEvidencia("Tocar no botão lápis");
        tocarElemento(botaoLapis, "Não foi possível tocar no botão lápis");
        return this;
    }

    /**
     * Recuperar valor do limite
     *
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Recupera o valor do limite atual")
    public String recuperarValorDoLimiteAtual() throws Exception {
        aguardarCarregamentoElemento(botaoAlterarLimiteDiurno);
        By campoValorLimite;
        if(ios) {
            campoValorLimite = By.xpath("(//XCUIElementTypeStaticText[contains(@name,'R$')])[3]");
        } else {
            campoValorLimite = By.xpath("(//*[contains(@text,'R$')])[2]");
        }
        AtributoElemento attribute;
        if (android) {
            attribute = AtributoElemento.TEXTO;
        } else {
            attribute = AtributoElemento.NAME;
        }

        String valor = retornarAtributoElemento(campoValorLimite, attribute,"Não foi possível extrair o valor do Novo Valor do limite");
        salvarEvidencia("Valor do limite: " + valor);
        return valor;
    }

    /**
     * Preencher valor do limite menor que atual
     * @param tipoLimite
     * @return MeusLimitesPixTela
     * @throws Exception
     */
    @Step("Preencher valor do limite menor que atual")
    public MeusLimitesPixTela preencherValorLimiteReduzido(String valorAtual, String tipoLimite) throws Exception {
        By campoValorLimite;
        if(ios) {
            campoValorLimite = By.xpath("//*[contains(@name,'"+tipoLimite+"')]/../XCUIElementTypeTextField");
        } else {
            campoValorLimite = By.xpath("//*[contains(@text,'"+tipoLimite+"')]/following::*[@resource-id='br.com.bradesco.next:id/ntf_input_limit_value']");
        }
        valorAtual = valorAtual.replace("\u00a0","").replace("R$","").replace(" ","").replace(".", "").replace(",", "");
        Integer valorLimiteReduzidoInt = (Integer.parseInt(valorAtual) /100) - 1 ;
        String novoValorSerPreenchido = valorLimiteReduzidoInt.toString();
        if(android){
            teclarBackSpaceAteApagar(campoValorLimite, 10);
            digitarTexto(campoValorLimite, novoValorSerPreenchido);
            esconderTeclado();
        }else{
            apagarCampoTexto(campoValorLimite, 10, "Não foi possível apagar o valor no campo 'Valor Limite'");
            escreverTexto(campoValorLimite, novoValorSerPreenchido, "Não foi possível escrever o valor limite");
        }
        salvarEvidencia("Valor limite alterado para: " + valorLimiteReduzidoInt);
        return this;
    }

    /**
     * Validar Mensagem Limite Autorizado
     *
     *
     * @throws Exception
     */
    @Step("Validar Mensagem Limite Autorizado")
    public MeusLimitesPixTela validarMensagemLimiteAlterado() throws Exception {
        aguardarPaginaConterTodosTextos(Mensagens.LIMITE_AUTORIZADO);
        salvarEvidencia("Limite Autorizado");
        return this;
    }

    /**
     * Validar Tela Meus Limites Empresa
     *
     *
     * @throws Exception
     */
    @Step("Validar Mensagem Limite Autorizado")
    public MeusLimitesPixTela validarTelaMeusLimitesEmpresa() throws Exception {
        aguardarCarregamentoElemento(botaoAlterarLimiteDiurno);
        salvarEvidencia("Limite Empresa validado com sucesso");
        return this;
    }
}
