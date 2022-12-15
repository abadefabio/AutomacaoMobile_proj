package pagina.mobile.jornadas.transferencia.para.outra;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.TipoDeInstituicaoFinanceira;
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

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static pagina.mobile.jornadas.transferencia.para.mim.MinhasContasTela.setAgencia;
import static pagina.mobile.jornadas.transferencia.para.mim.MinhasContasTela.setConta;
import static pagina.mobile.jornadas.transferencia.para.mim.MinhasContasTela.setInstituicao;

public class MeuContatoContasTela extends PaginaBase {

    private static ThreadLocal<MobileElement> iconeContato = null;

    private static ThreadLocal<String> valorNomeContato = null;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/animated_view']")
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Fechar\")]")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fechar, Botão\"]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_main")
    @iOSXCUITFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/rl_main']")
    private MobileElement contaAgenciaCirculo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system_option")
    @iOSXCUITFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/ni_system_option']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"MINHAS CONTAS\"]/XCUIElementTypeButton[2]")
    private MobileElement botaoAcoesExtras;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"SIM\"]")
    @iOSXCUITFindBy(xpath = "//*[@text=\"SIM\"]")
    private MobileElement botaoSim;

    public MeuContatoContasTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Retorna o elemento com o contato que possui a conta e agência esperados
     * @param conta
     * @param agencia
     */
    private MobileElement contaAgencia(String conta, String agencia) throws Exception {
        By locator;
        if(getDriver() instanceof IOSDriver) {
            locator = By.xpath("//*[@name='Agência " + agencia + " / Conta " + conta +"']");
        } else {
            locator = By.xpath("//*[contains(translate(@text, '-', ''), 'Agência " + agencia + " / Conta " + conta + "')]");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(locator, String.format("Não foi possível encontrar agencia %s / conta %s", agencia, conta));
        aguardarPaginaConterQualquerTexto(agencia, conta); // por estabilidade
        return retornaElemento(locator);
    }

    /**
     * Retorna o elemento da lixeira referente ao contato que possui a conta e agência esperados
     * @param conta
     * @param agencia
     */
    private MobileElement lixieraContaAgencia(String conta, String agencia) throws Exception {
        By locator;
        if(getDriver() instanceof IOSDriver) {
            locator = By.xpath("//*[@name='Agência " + agencia + " / Conta " + conta +"']/../XCUIElementTypeButton");
        } else {
            locator = By.xpath("//*[contains(translate(@text, '-', ''), 'Agência " + agencia + " / Conta " + conta + "')]../../[@resource-id='br.com.bradesco.next:id/si_suffix_icon']");
        }
        aguardarPaginaConterQualquerTexto(agencia, conta); // por estabilidade
        return retornaElemento(locator);
    }

    /**
     * Retorna o elemento com o contato que possui a conta esperados (Instituição de pagamento)
     * @param conta
     */
    private MobileElement contaInstituicaoCirculo(String conta) throws Exception {
        if(conta.length() > 5) {
            conta = conta.substring(1);
        }

        By locator = getDriver() instanceof IOSDriver?
                By.xpath("//*[contains(@name, '" + conta + "')]"):
                By.xpath("//*[contains(@text, '" + conta + "')]");

        return retornarElemento(locator, "Não foi possível encontrar a conta do contato");
    }
    /**
     * Retorna o elemento com o contato que possui a Conta separada
     * @param conta
     */
    private MobileElement contaCirculo(String conta) throws Exception {
        MobileElement contaCirculo = null;
        By locator = getDriver() instanceof AndroidDriver ? new By.ByXPath("//android.widget.RelativeLayout[contains(@content-desc, \"" + conta + "\")]") : new By.ByXPath("//XCUIElementTypeStaticText[contains(@name,\"" + conta + "\")]");
        if (android) aguardarCarregamentoElemento(contaAgenciaCirculo); // por estabilidade
        contaCirculo = retornarElemento(locator, "Não foi possível encontrar a conta e agência do contato");

        return contaCirculo;
    }

    /**
     * Tocar o nome do contato no círculo do contato após a pesquisa na barra de pesquisas
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar o contato")
    public MeuContatoContasTela tocarContaPagamentoAgenciaContato(String banco, String conta, String agencia) throws Exception {
        MobileElement contatoCirculo = contaAgencia(conta, agencia);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(contatoCirculo,"Não foi possivel encontrar conta " + conta + " e agência " + agencia);
        tocarElemento(contatoCirculo, "Não foi possível tocar o círculo com a conta e agência especificadas.");
        /*
        Utilizando as threadlocals de MinhasContasTela para instituição, agência e conta
        O fluxo aqui pode ser diferente, pode ser minhas contas ou conta de contato,
        razão pela qual é necessário utilizar uma solução de threadlocals mais global
        e não associada a telas.
         */
        setInstituicao(banco);
        setConta(conta);
        setAgencia(agencia);
        salvarEvidencia("Tocar no círculo da conta " + conta + " e agência " + agencia);
        return this;
    }

    /**
     * Tocar o círculo com a conta e agência OU conta pagamento
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar a conta e agência do contato")
    public MeuContatoContasTela tocarContaPagamentoAgenciaContato(ContaPagamento contaPagamento) throws Exception {
        return tocarContaAgenciaContato(
               contaPagamento.recuperarTipoInstituicao(),
               contaPagamento.recuperarConta(),
               contaPagamento.recuperarBanco(),
               contaPagamento.recuperarAgencia());
    }

    /**
     * Tocar o círculo com a conta e agência OU conta pagamento
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar a conta e agência do contato")
    public MeuContatoContasTela tocarContaAgenciaContato(TipoDeInstituicaoFinanceira tipo, String conta, String instituicao, String agencia) throws Exception {
        MobileElement contatoConta;
        String textoEvidencia;
        if (tipo.equals(TipoDeInstituicaoFinanceira.INSTITUICAO_DE_PAGAMENTO)) {
            contatoConta = contaInstituicaoCirculo(conta);
            textoEvidencia = "Tocar no círculo da conta " + conta + " da Instituição de pagamento: " + instituicao;
        } else {
            contatoConta = contaAgencia(conta, agencia);
            textoEvidencia = "Tocar na conta " + conta + " e agência " + agencia;
        }
        aguardarCarregamentoElemento(contatoConta);
        tocarElemento(contatoConta, "Não foi possível tocar na conta e agência especificadas.");
        salvarEvidencia(textoEvidencia);
        return this;
    }

    /**
     * Tocar o círculo com a conta banco
     *
     * @return MeuContatoContasTela
     * @throws Exception
     */
    @Step("Tocar conta banco: ")
    public MeuContatoContasTela tocarContaBancoContato(ContaPagamento bancoContato) throws Exception {
        MobileElement contatoCirculo = contaCirculo(bancoContato.recuperarConta());
        salvarEvidencia( "Tocar no contato banco: " + bancoContato.recuperarBanco());
        tocarElemento(contatoCirculo, "Não foi possível tocar o círculo com a conta e agência especificadas.");
        return this;
    }

    /**
     * Tocar o círculo com a conta banco
     *
     * @return MeuContatoContasTela
     * @throws Exception
     */
    @Step("Tocar conta banco: ")
    public MeuContatoContasTela tocarContaBancoContato(String bancoContato) throws Exception {
        MobileElement contatoCirculo = contaCirculo(bancoContato);
        aguardarCarregamentoElemento(contatoCirculo);
        tocarElemento(contatoCirculo, "Não foi possível tocar o círculo com a conta e agência especificadas.");
        salvarEvidencia( "Tocar na conta: " + bancoContato);
        return this;
    }
    /**
     * Tocar botão Fechar (X)
     *
     * @return MeuContatoContasTela
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public MeuContatoContasTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "Não foi possível tocar o o botão \"Fechar\"");
        salvarEvidencia( "Tocar botão \"Fechar\"");
        return this;
    }

    /**
     * Tocar o nome do contato no círculo do contato após a pesquisa na barra de pesquisas
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar o contato")
    public MeuContatoContasTela validarAgenciaConta(String agencia, String conta) throws Exception {
        MobileElement contatoCirculo = contaAgencia(conta, agencia);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(contatoCirculo,"Agencia e conta " + conta + " e agência " + agencia);

        salvarEvidencia("Agencia e conta " + conta + " e agência " + agencia);
        return this;
    }

    /**
     * Toca no botão somente se for android
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar o contato")
    public MeuContatoContasTela tocarContaPagamentoAgenciaContatoSoAndroid(String agencia, String conta) throws Exception {
        if (ios) return this;
        esperarCarregando();
        MobileElement contatoCirculo = contaAgencia(conta, agencia);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(contatoCirculo,"Não foi possivel encontrar conta " + conta + " e agência " + agencia);
        salvarEvidencia("Tocar o botão contato");
        tocarElemento(contatoCirculo, "Não foi possível tocar o círculo com a conta e agência especificadas.");

        return this;
    }

    /**
     * Tocar o círculo com a conta e agência OU conta pagamento
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar a conta e agência do contato")
    public MeuContatoContasTela tocarBotaoAcaoExtra() throws Exception {
        salvarEvidencia( "Tocar botão \"Fechar\"");
        tocarElemento(botaoAcoesExtras, "Não foi possível tocar o o botão \"Fechar\"");
        return this;
    }

    /**
     * Tocar a lixeira do contato no círculo do contato após a pesquisa na barra de pesquisas
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar a lixeira do contato")
    public MeuContatoContasTela tocarLixeiraContaPagamentoAgenciaContato(String agencia, String conta) throws Exception {
        MobileElement contatoCirculo = lixieraContaAgencia(conta, agencia);
        salvarEvidencia("Tocar na lixiera da conta " + conta + " e agência " + agencia);
        tocarElemento(contatoCirculo, "Não foi possível tocar a lixeira do círculo com a conta e agência especificadas.");
        return this;
    }

    /**
     * Tocar o botao SIM
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar o botao SIM")
    public MeuContatoContasTela tocarBotaoSim() throws Exception {

        salvarEvidencia("Tocar o botao SIM");
        tocarElemento(botaoSim, "Não foi possível tocar o botao SIM.");
        return this;
    }
}
