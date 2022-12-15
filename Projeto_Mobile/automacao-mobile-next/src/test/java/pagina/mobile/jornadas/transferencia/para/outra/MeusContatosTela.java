package pagina.mobile.jornadas.transferencia.para.outra;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.retornarPrimeiroNome;

import java.time.temporal.ChronoUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.comprovantes.ConsultaServico;
import constantes.transferencia.ContaPagamento;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MeusContatosTela extends PaginaBase {

    private static ThreadLocal<MobileElement> iconeContato = null;

    private static ThreadLocal<String> valorNomeContato = null;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_more")
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_add")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Adicionar Conta, Botão\"]")
    @iOSXCUITFindBy(accessibility = "Adicionar conta")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Adicionar conta\"]")
    @iOSXCUITFindBy(accessibility = "Adicionar conta")
    private MobileElement botaoAdicionarContato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"GERENCIAR CONTATO\"]/XCUIElementTypeButton")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/search_contacts_bar")
    @AndroidFindBy(xpath = "//*[@text=\"Buscar\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name, 'Buscar')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@label='']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[$visible == true$]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Buscar\"`][2]")
    private MobileElement barraPesquisaTexto;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_clear_search")
    private MobileElement limparTextoPesquisa;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_tab_all")
    private MobileElement abaTodos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_tab_autorized")
    private MobileElement abaAutorizados;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_main")
    private MobileElement contato;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_avatar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Todos os contatos']/../XCUIElementTypeCell[2]")
    private MobileElement contatoGenerico;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name_user")
    private MobileElement nomeContato;

    @AndroidFindBy(xpath = "//*[@text=\"TRANSFERÊNCIAS\"]")
    private MobileElement tituloTransferencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage['label == \"Foto\"']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Foto\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_container_img")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    private MobileElement contatoCirculo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"DETALHES DO CONTATO\"]/XCUIElementTypeButton[2]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system_option")
    private MobileElement botaoAcoesExtras;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeButton")
    @AndroidFindBy(id = "br.com.bradesco.next:id/si_suffix_icon")
    private MobileElement botaoExcluirConta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_button_remove")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/rl_button_remove']")
    @AndroidFindBy(xpath = "//*[@text=\"EXCLUIR CONTATO\"]")
    @iOSXCUITFindBy(accessibility = "Remover contato")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Remover contato\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Remover contato\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"EXCLUIR CONTATO\"]")
    private MobileElement botaoExcluirContato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_button_edit")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/rl_button_edit']")
    @iOSXCUITFindBy(accessibility = "Editar contato")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Editar contato\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Editar contato\"]")
    private MobileElement botaoEditarContato;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_right")
    @iOSXCUITFindBy(accessibility = "Sim")
    private MobileElement botaoConfirmar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_left")
    @iOSXCUITFindBy(accessibility = "Não")
    private MobileElement botaoCancelar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_tab_autorized")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_tab_autorized")
    @AndroidFindBy(id = "Aba Novo Contato, Botão")
    @iOSXCUITFindBy(accessibility = "Opção selecionável, NOVO CONTATO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Opção selecionável, NOVO CONTATO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,\"NOVO CONTATO\")]")
    private MobileElement abaNovoContato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Aba Todos selecionada")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_tab_all")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Aba Todos selecionada\"]")
    @iOSXCUITFindBy(accessibility = "Opção selecionável, CONTATO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Opção selecionável, CONTATO\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Opção selecionável, CONTATO\"]")
    private MobileElement abaContato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='EM ANÁLISE']")
    @iOSXCUITFindBy(xpath = "//*[@name='EM ANÁLISE']")
    private MobileElement abaEmAnalise;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement fecharTransferir;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "REMOVER")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_add_remove")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"REMOVER\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"- Remover\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"- Remover\"])[1]")
    private MobileElement removerConta; // (-Remover)

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_add")
    @AndroidFindBy(accessibility = "Adicionar Conta, Botão")
    @AndroidFindBy(accessibility = "ADICIONAR")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ADICIONAR\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Adicionar nova conta\"]")
    @iOSXCUITFindBy(accessibility = "Adicionar conta")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Adicionar conta\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"+ Adicionar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"+ Adicionar\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Adicionar nova conta\"]")
    private MobileElement adicionarConta;// (+Adicionar)

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"SIM\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Sim\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"SIM\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Sim\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sim\"]")
    private MobileElement botaoSimMensagem;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name=\"NÃO\"]")
    @AndroidFindBy(xpath = "//*[@text=\"NÃO\"]")
    private MobileElement botaoNaoMensagem;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@content-desc=\"Carregando\"]")
    @iOSXCUITFindBy(xpath = "?")
    private MobileElement iconeCarregando;

    public MeusContatosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Retorna o elemento com o nome do contato do ícone do círculo
     *
     * @param contato
     */
    private MobileElement retornaContatoCirculo(String contato) throws Exception {
        /*
        O nome do contato passado deve ser apenas o primeiro nome,
        que aparece no ícone do círculo, ou foto.
         */
        MobileElement contatoNomeCirculo = null;
        By locator = null;
        if (android) {
            locator = By.xpath("//*[contains(@content-desc,\"" + contato + "\")]");
        } else {
            locator = By.xpath("//XCUIElementTypeStaticText[contains(@name, \"" + contato + "\")]");
        }

        contatoNomeCirculo = (MobileElement) retornaElemento(locator);

        return contatoNomeCirculo;
    }

    /**
     * Retorna o elemento com o contato que possui a conta e agência esperados
     *
     * @param conta
     * @param agencia
     */
    private MobileElement contaAgenciaCirculo(String conta, String agencia) throws Exception {
        MobileElement contaCirculo = null;
        By locator = null;

        if (ios) {
            locator = By.xpath("//XCUIElementTypeStaticText[@name='Ag." + agencia + " CC." + conta + "']");

        } else {
            locator = By.xpath("//*[contains(@content-desc,'CC " + conta + " AG " + agencia + "')]");
        }

        contaCirculo = retornarElemento(locator, "Não foi possível recuperar a conta e agência do contato");

        return contaCirculo;
    }

    /**
     * Armazena MobileElement na variável thread-safe iconeContato
     *
     * @param elemento
     */
    public static void setElementoContato(MobileElement elemento) {
        if (iconeContato == null) {
            iconeContato = new ThreadLocal<>();
        }
        iconeContato.set(elemento);
    }

    /**
     * Retorna MobileElement do contato armazenado na variável thread-safe iconeContato
     *
     * @return MobileElement elementoContato
     */
    public static MobileElement retornaElementoContato() {
        return iconeContato.get();
    }

    /**
     * Armazena String na variável thread-safe valorNomeContato
     *
     * @param nomeContato
     */
    public static void setNomeContato(String nomeContato) {
        if (valorNomeContato == null) {
            valorNomeContato = new ThreadLocal<>();
        }
        valorNomeContato.set(nomeContato);
    }

    /**
     * Retorna String do contato armazenado na variável thread-safe valorNomeContato
     *
     * @return String nomeContato
     */
    public static String retornaNomeContato() {
        return valorNomeContato.get();
    }

    /**
     * Tocar ícone "+"
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar em adicionar contatos")
    public MeusContatosTela tocarAdicionarContato() throws Exception {
        salvarEvidencia("Meus Contatos");
        tocarElemento(botaoAdicionarContato, "Não foi possível tocar em adicionar contato");
        return this;
    }

    /**
     * Tocar botão "Fechar"
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public MeusContatosTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar botão \"Fechar\"");
        tocarElemento(botaoFechar, "Erro ao tocar botão \"Fechar\"");
        return this;
    }

    /**
     * Preencher barra de pesquisa com o nome do contato
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Preencher barra de pesquisa")
    public MeusContatosTela preencherBarraPesquisa() throws Exception {
        preencherBarraPesquisa(retornaNomeContato());
        return this;
    }

    /**
     * Preencher barra de pesquisa com o nome do contato
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Preencher barra de pesquisa")
    public MeusContatosTela pesquisaContato() throws Exception {
        pesquisaContato(retornaNomeContato());
        esconderTeclado();
        return this;
    }


    /**
     * Preencher barra de pesquisa com o nome do contato
     *
     * @param contato
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Preencher barra de pesquisa")
    public MeusContatosTela preencherBarraPesquisa(String contato) throws Exception {
        aguardarCarregamentoElemento(barraPesquisaTexto);
        setNomeContato(contato);
        if (android) {
            tocarElementoOculto("//*[@resource-id='br.com.bradesco.next:id/search_contacts_bar']", "Nao foi possível encontrar campo de busca");
            this.retornaElemento(barraPesquisaTexto)
                    .sendKeys(retornaNomeContato());
        } else {
            String nomePesquisa = StringUtils.substringBefore(retornaNomeContato(), " ");
            apagarCampoTexto(barraPesquisaTexto, retornaNomeContato().length() * 2, "Erro ao executar a ação de apagar texto");
            escreverTexto(barraPesquisaTexto, nomePesquisa, "Erro ao executar ação de preencher barra de pesquisa");
        }
        salvarEvidencia("Pesquisar contato: \"" + retornaNomeContato() + "\"");
        return this;
    }

    /**
     * pesquisa o contato na barra de pesquisa
     *
     * @param contato
     * @return
     * @throws Exception
     */
    @Step("Preencher barra de pesquisa")
    public MeusContatosTela pesquisaContato(String contato) throws Exception {
        String primeiroNome = contato.split(" ")[0];
        setNomeContato(primeiroNome);
        esperarCarregando();
        String mensagemErro = "Erro ao tocar na barra de pesquisa";
        if (ios) {
            aguardarCarregamentoElemento(barraPesquisaTexto);
            tocarElemento(barraPesquisaTexto, mensagemErro);
        } else {
            String locatorPesquisa = "//*[@resource-id='br.com.bradesco.next:id/search_contacts_bar']";
            verificarPresencaElementoOculto(locatorPesquisa);
            tocarElementoOculto(locatorPesquisa, mensagemErro);
        }
        barraPesquisaTexto.sendKeys(primeiroNome);
        esconderTeclado();
        salvarEvidencia("Pesquisar contato: \"" + retornaNomeContato() + "\"");
        return this;
    }

    /**
     * Tocar o nome do contato no círculo do contato após a pesquisa na barra de pesquisas
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar círculo com o nome do contato")
    public MeusContatosTela tocarContatoCirculo() throws Exception {
        String primeiroNome = StringUtils.substringBefore(retornaNomeContato(), " ");
        String mensagemErro = "Não foi possível tocar o contato no ícone do círculo.";
        if (ios) {
            MobileElement contatoCirculo = retornaContatoCirculo(primeiroNome);
            aguardarCarregamentoElemento(contatoCirculo);
            tocarElemento(contatoCirculo, mensagemErro);
        } else {
            tocarElementoOculto(String.format("//*[@text='%s' and @class='me.next.uikit.NextLabel']", primeiroNome), mensagemErro);
        }
        salvarEvidencia("Acessar contato: \"" + retornaNomeContato() + "\"");
        return this;
    }

    /**
     * Manter pressionado o ícone do primeiro contato disponível na tela (círculo da foto)
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Pressionar primeiro contato disponível na tela")
    public MeusContatosTela pressionarPrimeiroContatoCirculo() throws Exception {
        /*
        Utilizar este método quando esperar que este seja o primeiro, ou único, contato
        disponível na tela.
         */
        manterPressionado(contatoCirculo, 2000, "Erro ao executar a ação de manter pressionado o elemento do contato");
        salvarEvidencia("Pressionar primeiro contato na tela");
        return this;
    }

    /**
     * Manter pressionado o ícone do primeiro contato disponível na tela (círculo da foto)
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Pressionar círculo do contato com o nome do contato")
    public MeusContatosTela pressionarNomeContatoCirculo() throws Exception {
        MobileElement contatoCirculo = retornaContatoCirculo(retornarPrimeiroNome(retornaNomeContato()));
        manterPressionado(contatoCirculo, 2000, "Erro ao executar a ação de manter pressionado o elemento do contato");
        salvarEvidencia("Pressionar contato: " + retornaNomeContato());
        return this;
    }

    /**
     * Tocar o nome do contato
     *
     * @param contato
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar no nome contato presente na tela")
    public MeusContatosTela tocarContato(String contato) throws Exception {
        esperarCarregando();
        aguardarPaginaConterQualquerTexto("Todos os contatos");
        esconderTeclado();
        salvarEvidencia(String.format("Tocar contato '%s'", contato));
        String mensagemErro = "Não foi possível tocar o primeiro contato";
        if (ios) {
            tocarElemento(retornarContato(contato), mensagemErro);
        } else {
            tocarElementoOculto(String.format("//*[contains(@text, '%s')]", contato), mensagemErro);
        }
        return this;
    }

    /**
     * Tocar o nome do contato
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar no nome contato presente na tela")
    public MeusContatosTela tocarContato() throws Exception {
        esperarCarregando();
        aguardarPaginaConterQualquerTexto("Todos os contatos");
        salvarEvidencia(String.format("Tocar no primeiro contato"));
        if (ios) {
            tocarElemento(contatoGenerico, "Não foi possível tocar o primeiro contato");
        } else {
            tocarElementoOculto("//*[@resource-id='br.com.bradesco.next:id/si_suffix_icon'][1]", "Não foi possível tocar o primeiro contato");
        }
        return this;
    }

    /**
     * Retorna o elemento com o contato que possui o nome especificado
     *
     * @param nomeContato
     */
    private MobileElement retornarContato(String nomeContato) throws Exception {
        By locator;
        if (getDriver() instanceof IOSDriver) {
            locator = By.xpath("//*[contains(@name, '" + nomeContato + "')]");
        } else {
            locator = By.xpath(String.format("//*[@text='%s']", nomeContato));
        }
        String encontrado = aguardarPaginaConterQualquerTexto(nomeContato); // por estabilidade
        return driver.findElement(locator);
    }


    /**
     * Tocar aba "NovoContato"
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar aba \"Novo Contato\"")
    public MeusContatosTela tocarAbaNovoContato() throws Exception {
        aguardarCarregamentoElemento(abaNovoContato);
        salvarEvidencia("Tocar aba \"Novo Contato\"");
        tocarElemento(abaNovoContato, "Erro ao executar a ação de tocar aba \"Novo Contato\"");
        return this;
    }

    /**
     * Tocar botão "Confirmar"
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Confirmar\"")
    public MeusContatosTela tocarBotaoConfirmar() throws Exception {
        tocarElemento(botaoConfirmar, "Erro ao executar a ação de tocar botão \"Confirmar\"");
        salvarEvidencia("Tocar botão \"Confirmar\"");
        return this;
    }

    /**
     * Tocar botão "Cancelar"
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Cancelar\"")
    public MeusContatosTela tocarBotaoCancelar() throws Exception {
        tocarElemento(botaoCancelar, "Erro ao executar a ação de tocar botão \"Cancelar\"");
        salvarEvidencia("Tocar botão \"Cancelar\"");
        return this;
    }

    /**
     * Validar exibição dos ícones "Excluir" e "Editar" após cancelamento exclusão
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Validar exibição dos ícones \"Excluir\" e \"Editar\" após cancelamento exclusão")
    public MeusContatosTela validarExibicaoIconesExcluirEditar() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoExcluirContato) && aguardarCarregamentoElemento(botaoEditarContato), MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível verificar a exibição dos botões \"Excluir\" e \"Editar\"");
        salvarEvidencia("Validar exibição dos ícones \"Excluir\" e \"Editar\" após cancelamento exclusão");
        //Método criado para que o sistema volte a interagir com a tela após a automação
        if (ios) {
            tocarCoordenadaProporcional(50, 10);
        }
        return this;
    }

    /**
     * Tocar botão "Excluir"
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Excluir\"")
    public MeusContatosTela tocarExcluirContato() throws Exception {
        tocarElemento(botaoExcluirContato, "Erro ao executar a ação de tocar botão \"Excluir\"");
        salvarEvidencia("Tocar botão \"Excluir\"");
        return this;
    }

    /**
     * Tocar botão "Editar"
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Editar\"")
    public MeusContatosTela tocarEditarContato() throws Exception {
        tocarElemento(botaoEditarContato, "Erro ao executar a ação de tocar botão \"Excluir\"");
        salvarEvidencia("Tocar botão \"Editar\"");
        return this;
    }

    /**
     * Pressionar ícone contato por 2 segunda para exibição de botões "Editar" e "Excluir"
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Pressionar ícone contao por 2 segundos")
    public MeusContatosTela pressionarIconeContato() throws Exception {
        esconderTeclado(barraPesquisaTexto);
        validarCondicaoBooleana(verificarContatoPresente(), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível encontrar contato: \"" + retornaNomeContato() + "\"");
        manterPressionado(retornaElementoContato(), 2000, "Erro ao executar a ação de manter pressionado o elemento do contato");
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoExcluirContato) && aguardarCarregamentoElemento(botaoEditarContato), MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível verificar a exibição dos botões \"Excluir\" e \"Editar\"");
        salvarEvidencia("Pressionar ícone de contato");
        return this;
    }

    /**
     * Valida contato presente ou ausente na tela
     *
     * @param validacaoContaoPresente: true - valida contato presente na tela; false - valida contato ausente na tela
     *                                 esconderTeclado();
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Validar se contato está presente ou ausente em tela")
    public MeusContatosTela validarPresencaContato(boolean validacaoContaoPresente) throws Exception {
        if (validacaoContaoPresente) {
            validarCondicaoBooleana(verificarContatoPresente(), MetodoComparacaoBooleano.VERDADEIRO, "Resultado Esperado: \"Encontrar - " + retornaNomeContato() + "\"; Resultado Obtido: \"Contato Não Encontrado\"");
            salvarEvidencia("Validar contato: \"" + retornaNomeContato() + "\" aparece na lista de contatos");
        } else {
            validarCondicaoBooleana(verificarContatoPresente(), MetodoComparacaoBooleano.FALSO, "Resultado Esperado: \"Não Encontrar - " + retornaNomeContato() + "\"; Resultado Obtido: \"Contato Encontrado\"");
            salvarEvidencia("Validar contato: \"" + retornaNomeContato() + "\" não aparece na lista de contatos");
        }
        return this;
    }

    /**
     * Valida contato presente na tela
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Validar se contato está presente ou ausente em tela")
    public MeusContatosTela validarPresencaContato() throws Exception {
        String nomeContatoValidacao = StringUtils.substringBefore(retornaNomeContato(), " ");
        validarCondicaoBooleana(retornaContatoCirculo(nomeContatoValidacao) != null,
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a presença do contato");
        salvarEvidencia("Validar contato: \"" + nomeContatoValidacao + "\" aparece na lista de contatos");
        return this;
    }

    /**
     * Verifica se contato procurado está presente na tela
     *
     * @throws Exception
     * @return: true - contato encontrado; false: contato não encontrado
     */
    private boolean verificarContatoPresente() throws Exception {
        String nomeContatoValidacao = StringUtils.substringBefore(retornaNomeContato(), " ");
        By iconeContato;
        iconeContato = android ? new By.ByXPath("//*[contains(@content-desc,\"" + nomeContatoValidacao + "\")]") :
                new By.ByXPath("//*[@name = \"" + nomeContatoValidacao + "\"]");
        if (verificarPresencaElemento(iconeContato)) {
            setElementoContato(retornarElemento(iconeContato, "Elemento referente ao contato: \"" + nomeContatoValidacao + "\" não encontrado"));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tocar botão "Fechar(x)"
     *
     * @return TransferenciaTela
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public MeusContatosTela tocarFechar() throws Exception {
        salvarEvidencia("Tocar no botão fechar (X)");
        tocarElemento(fecharTransferir, "Nao foi possivel tocar no botão fechar");
        return this;
    }

    @Step("tocar em editar contato")
    public MeusContatosTela tocarParaEditarContato() throws Exception {
        validarCondicaoBooleana(verificarContatoPresente(), MetodoComparacaoBooleano.VERDADEIRO, "Nao foi possivel encontrar contato: \"" + retornaNomeContato() + "\"");
        manterPressionado(MeusContatosTela.retornaNomeContato(), 1000, "Não foi possível manter pressionado a conta salva.");
        salvarEvidencia("Pressionar icone de contato");
        return this;
    }

    /**
     * Tocar na Aba Contato
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar na Aba Contato")
    public MeusContatosTela tocarAbaContato() throws Exception {
        tocarElemento(abaContato, "Erro ao executar a ação de tocar aba \"Contato\"");
        salvarEvidencia("Tocou aba \"Contato\"");
        return this;
    }

    /**
     * Tocar na Aba Em Análise
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar na Aba Em Análise")
    public MeusContatosTela tocarAbaEmAnalise() throws Exception {
        tocarElemento(abaEmAnalise, "Erro ao executar a ação de tocar aba \"Em Análise\"");
        salvarEvidencia("Tocou aba \"Em Análise\"");
        return this;
    }

    /**
     * Tocar em '-Remover' na tela Editar Contato
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em -Remover (Conta)")
    public MeusContatosTela tocarRemoverConta() throws Exception {
        tocarElemento(removerConta, "");
        salvarEvidencia("Tocou em \"-Remover\" (Conta)");
        return this;
    }

    /**
     * Tocar em '-Alterar' na tela Editar Contato
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em +Adicionar (Conta)")
    public MeusContatosTela tocarAdicionarConta() throws Exception {
        aguardarCarregamentoElemento(adicionarConta);
        salvarEvidencia("Tocou em \"+Adicionar/Adicionar Conta\" (Conta)");
        tocarElemento(adicionarConta, "");

        return this;
    }

    /**
     * Tocar no contato Circulo
     *
     * @throws Exception
     */
    @Step("Tocar no Contato Circulo")
    public void selecionarContato() throws Exception {
        String mensagemErro = "Não foi possível recuperar o contato.";
        if (android) {
            String xpath = "//*[@class='me.next.uikit.NextLabel' and contains(@text, \"" + retornaNomeContato() + "\")]";
            tocarElementoOculto(xpath, mensagemErro);
        } else {
            By locator = By.xpath("//*[contains(@name, \"" + retornaNomeContato() + "\")]");
            MobileElement contatoNomeCirculo = retornarElemento(locator, mensagemErro);
            aguardarCarregamentoElemento(contatoNomeCirculo);
            tocarElemento(contatoNomeCirculo, "Não foi possivel tocar no Contato");
        }
    }


    /**
     * Tocar no contato Circulo
     *
     * @param contato
     * @throws Exception
     */
    @Step("Tocar no Contato Circulo")
    public void selecionarContato(String contato) throws Exception {
        if (android) contato = contato.substring(0, 10);
        setNomeContato(contato);
        MobileElement elementoContato = retornaContatoCirculo(contato);
        aguardarCarregamentoElemento(elementoContato);
        tocarElemento(elementoContato, "Não foi possivel tocar no Contato");
    }

    /**
     * Tocar icone "Editar Contato (Lápis)"
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar icone \"Editar Contato (Lápis)\"")
    public MeusContatosTela tocarIconeEditarContato() throws Exception { //  botaoEditarContato
        tocarElemento(botaoEditarContato, "Erro ao tocar no icone editar contato");
        salvarEvidencia("Tocar icone \"Editar Contato (Lápis)\"");
        return this;
    }

    /**
     * Tocar no Botão "Sim" na Mensagem
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Sim\" na Mensagem")
    public MeusContatosTela tocarBotaoSimMensagem() throws Exception {
        aguardarCarregamentoElemento(botaoSimMensagem);
        salvarEvidencia("Mensagem de confirmação");
        tocarElemento(botaoSimMensagem, "Nao foi possivel tocar em OK");
        salvarEvidencia("Tocou no botão 'Sim' da mensagem");
        return this;
    }

    /**
     * Tocar no Botão "Não" na Mensagem
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Não\" na Mensagem")
    public MeusContatosTela tocarBotaoNaoMensagem() throws Exception {
        aguardarCarregamentoElemento(botaoNaoMensagem);
        salvarEvidencia("Mensagem de confirmação");
        tocarElemento(botaoNaoMensagem, "Nao foi possivel tocar em Não");
        salvarEvidencia("Tocou no botão 'Não' da mensagem");
        return this;
    }

    /**
     * Validar Presença de Contato em Tela
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Validar Presença de Contato em Tela")
    public MeusContatosTela validarPresencaContaContatos() throws Exception {
        validarCondicaoBooleana(verificarContatoPresente(), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível encontrar contato: \"" + retornaNomeContato() + "\"");
        salvarEvidencia("Validação do contato incluido.");
        return this;
    }

    /**
     * Seleciona um contato de Instituição de pagamento
     *
     * @return MeuContatosTela
     * @throws Exception
     */
    @Step("Selecionar contato de Instituição de pagamento")
    public MeusContatosTela tocarContatosInstituicaoBancariaOutraPessoa(ContaPagamento bancoContato) throws Exception {
        By xpathContatoCirculo = android ? new By.ByXPath("//android.widget.RelativeLayout[contains(@content-desc, \"" + bancoContato.recuperarBanco() + "\")]") : new By.ByXPath("//XCUIElementTypeStaticText[@name=\"" + bancoContato.recuperarBanco() + " \"]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(xpathContatoCirculo, "Erro ao encontrar o elemento: " + bancoContato);
        salvarEvidencia("Tocar no contato: " + bancoContato.recuperarBanco());
        tocarElemento(xpathContatoCirculo, "Erro ao encontrar o elemento: " + bancoContato);
        return this;
    }

    /**
     * Seleciona um contato
     *
     * @return MeuContatosTela
     * @throws Exception
     */
    @Step("Selecionar contato: ")
    public MeusContatosTela selecionarContatoBancoOutraPessoa(ContaPagamento bancoContato) throws Exception {
        By xpathContatoCirculo = android ? new By.ByXPath("//android.widget.RelativeLayout[contains(@content-desc, \"" + bancoContato.recuperarBanco() + "\")]") : new By.ByXPath("//XCUIElementTypeStaticText[@name=\"" + bancoContato.recuperarBanco() + " \"]");
        By xpathContatoCirculoBanco = android ? new By.ByXPath("//android.widget.RelativeLayout[contains(@content-desc, \"" + bancoContato.recuperarBanco() + "\")]") : new By.ByXPath("//XCUIElementTypeStaticText[contains(@name,\"" + bancoContato.recuperarAgencia() + "\")]");

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(xpathContatoCirculo, "Erro ao encontrar o elemento: " + bancoContato);
        tocarElemento(xpathContatoCirculo, "Erro ao encontrar o elemento: " + bancoContato);
        salvarEvidencia("Tocar no contato: " + bancoContato.recuperarBanco());

        tocarElemento(xpathContatoCirculoBanco, "Não foi possível tocar no contato: " + bancoContato);
        salvarEvidencia("Tocar no contato banco: " + bancoContato.recuperarBanco());
        return this;
    }

    /**
     * Verifica se contato procurado está presente na tela
     *
     * @throws Exception
     * @return: true - contato encontrado; false: contato não encontrado
     */
    private boolean verificarContatoInformado(String nomeContato) throws Exception {
        String iconeContatoXpath = android ?
                "//*[contains(@text, \"" + nomeContato + "\") and @class=\"me.next.uikit.NextLabel\"]" :
                "//XCUIElementTypeStaticText[contains(@name, \"" + nomeContato + "\")]";

        By iconeContato = new By.ByXPath(iconeContatoXpath);

        if (android) {
            return verificarPresencaElementoOculto(iconeContatoXpath);
        } else {
            if (verificarPresencaElemento(iconeContato)) {
                setElementoContato(retornarElemento(iconeContato, "Elemento referente ao contato: \"" + nomeContato + "\" não encontrado"));
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Valida contato presente ou ausente na tela
     *
     * @param validacaoContaoPresente: true - valida contato presente na tela; false - valida contato ausente na tela
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Validar se contato está presente ou ausente em tela")
    public MeusContatosTela validarPresencaContatoInformado(boolean validacaoContaoPresente, String nomeContato) throws Exception {
        if (validacaoContaoPresente) {
            validarCondicaoBooleana(verificarContatoInformado(nomeContato), MetodoComparacaoBooleano.VERDADEIRO, "Resultado Esperado: \"Encontrar - " + nomeContato + "\"; Resultado Obtido: \"Contato Não Encontrado\"");
            salvarEvidencia("Validar contato: \"" + nomeContato + "\" aparece na lista de contatos");
        } else {
            validarCondicaoBooleana(verificarContatoInformado(nomeContato), MetodoComparacaoBooleano.FALSO, "Resultado Esperado: \"Não Encontrar - " + nomeContato + "\"; Resultado Obtido: \"Contato Encontrado\"");
            salvarEvidencia("Validar contato: \"" + nomeContato + "\" não aparece na lista de contatos");
        }
        return this;
    }

    /**
     * Valida tela no contexto 'Meus Contatos'
     *
     * @return
     */
    @Step("Validar se está em 'Meus Contatos'")
    public MeusContatosTela validarPresencaMeusContatos() {
        validarCondicaoBooleana(verificarPresencaQualquerElemento(abaContato, abaNovoContato) != -1,
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar a presença do contexto: 'Meus Contatos'");
        salvarEvidencia("Validou tela no contexto 'Meus Contatos'");
        return this;
    }

    /**
     * Toca no botão acoes extras
     *
     * @return MeuContatosTela
     * @throws Exception
     */
    @Step("Tocar Botão Ações Extras")
    public MeusContatosTela tocarBotaoAcoesExtras() throws Exception {
        aguardarPaginaConterTodosTextos("DETALHES DO CONTATO");
        salvarEvidencia("Tocar no botão acoes extras");
        tocarElemento(botaoAcoesExtras, "Erro ao encontrar o elemento: " + botaoAcoesExtras);
        return this;
    }

    /**
     * Toca no botão excluir Conta/Agencia
     *
     * @throws Exception
     */
    @Step("Tocar Botão Excluir Conta/Agencia")
    public MeusContatosTela tocarExcluirConta() throws Exception {
        if (android) aguardarPaginaConterTodosTextos("EXCLUIR CONTATO");
        if (ios) aguardarCarregamentoElemento(botaoExcluirConta);
        tocarElemento(botaoExcluirConta, "Erro ao encontrar o elemento: " + botaoExcluirConta);
        salvarEvidencia("Tocar no Excluir Conta/Agencia (Lixeira)");
        return this;
    }

    /**
     * Valida a tela Transferencia
     *
     * @throws Exception
     */
    @Step("Tocar Botão Excluir Conta/Agencia")
    public MeusContatosTela validarTelaTransferencias() throws Exception {
        aguardarPaginaConterTodosTextos(String.valueOf(ConsultaServico.TRANSFERENCIAS));
        salvarEvidencia("Validar tela Transferencias");
        return this;
    }


}
