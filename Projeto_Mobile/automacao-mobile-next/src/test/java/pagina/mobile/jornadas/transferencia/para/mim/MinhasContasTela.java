package pagina.mobile.jornadas.transferencia.para.mim;

import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.AtributoElemento;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.ParentescoElemento;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;

import constantes.transferencia.ContaPagamento;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MinhasContasTela extends PaginaBase {

    private String nomeInstituicaoAntesTroca;
    private String nomeInstituicaoDepoisTroca;
    private String bancoSelecionado;
    private String instituicaoInicial;
    private String instituicaoFinal;
    private static ThreadLocal<MobileElement> iconeContato = new ThreadLocal<>();
    private static ThreadLocal<String> valorConta = null;
    private static ThreadLocal<String> valorAgencia = null;
    private static ThreadLocal<String> valorInstituicao = null;
    private static ThreadLocal<String> valorDadosContato = null;
    private static ThreadLocal<String> valorContaInicial = null;
    private static ThreadLocal<String> valorAgenciaInicial = null;
    private static ThreadLocal<String> valorInstituicaoInicial = null;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "MINHAS CONTAS")
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"MINHAS CONTAS\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"MINHAS CONTAS\"`]")
    private MobileElement headerTituloMinhasContas;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Fechar, Bot�o")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fechar, Bot�o\"]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement headerBotaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Adicionar Conta, Bot�o")
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_add")
    @AndroidFindBy(xpath = "//*[contains(@text,'Adicionar nova conta')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Adicionar Conta, Bot�o\"]")
    @iOSXCUITFindBy(accessibility = "Adicionar conta")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Adicionar nova conta')]")
    private MobileElement botaoAdicionarConta;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_button_edit")
    @iOSXCUITFindBy(accessibility = "Editar contato")
    private MobileElement botaoEditarConta;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_button_remove")
    @iOSXCUITFindBy(accessibility = "Remover contato")
    private MobileElement botaoExcluirConta;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    private MobileElement botaoSelecionarIntituicaoPagamento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon_close")
    private  MobileElement botaoConfirmarSelecaoInstituicao;

    @AndroidFindBy (id = "br.com.bradesco.next:id/bt_save")
    private MobileElement botaoSalvar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_name_icon")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label CONTAINS \"Ag.\"$]")
    private MobileElement elementoInstituicaoSalva;

    @AndroidFindBy( id = "br.com.bradesco.next:id/sv_container_main")
    private MobileElement gradeContas;

    @AndroidFindBy( id = "br.com.bradesco.next:id/bt_left")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"n�o\"`]")
    private MobileElement botaoCancelar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(xpath = "//*[@name = \"MINHAS CONTAS\"]")
    @AndroidFindBy(accessibility = "MINHAS CONTAS")
    private MobileElement tituloMinhasContasTela;

    public MinhasContasTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Inicializa a vari�vel valorConta
     */
    public static void setConta(){
        if(valorConta == null){
            valorConta = new ThreadLocal<>();
        }
        valorConta.set(new String());
    }

    /**
     * Armazena valor da conta na vari�vel valorConta
     *
     * @param conta
     */
    public static void setConta(String conta){
        setConta();
        valorConta.set(conta);
    }

    /**
     * Retorna valor armazenado na vari�vel valorConta
     *
     * @return String
     */
    public static String retornaConta(){
        return (String) valorConta.get();
    }

    /**
     * Inicializa a vari�vel valorAgencia
     */
    public static void setAgencia(){
        if(valorAgencia == null){
            valorAgencia = new ThreadLocal<>();
        }
        valorAgencia.set(new String());
    }

    /**
     * Armazena valor da ag�ncia na vari�vel valorAgencia
     *
     * @param agencia
     */
    public static void setAgencia(String agencia){
        setAgencia();
        valorAgencia.set(agencia);
    }

    /**
     * Retorna valor armazenado na vari�vel valorAgencia
     *
     * @return String
     */
    public static String retornaAgencia(){
        return (String) valorAgencia.get();
    }

    /**
     * Inicializa a vari�vel valorAgencia
     */
    public static void setInstituicao(){
        if(valorInstituicao == null){
            valorInstituicao = new ThreadLocal<>();
        }
        valorInstituicao.set(new String());
    }

    /**
     * Armazena valor da institui��o na vari�vel valorInstituicao
     *
     * @param instituicao
     */
    public static void setInstituicao(String instituicao){
        setInstituicao();
        valorInstituicao.set(instituicao);
    }

    /**
     * Retorna valor armazenado na vari�vel valorInstituicao
     *
     * @return String
     */
    public static String retornaInstituicao(){
        return (String) valorInstituicao.get();
    }

    /**
     * Inicializa a vari�vel valorDadosContato
     */
    public static void setDadosContato(){
        if(valorDadosContato == null){
            valorDadosContato = new ThreadLocal<>();
        }
        valorDadosContato.set(new String());
    }

    /**
     * Armazena valor dos dados do contato na vari�vel valorDadosContato
     *
     * @param dadosContato
     */
    public static void setDadosContato(String dadosContato){
        setDadosContato();
        valorDadosContato.set(dadosContato);
    }

    /**
     * Retorna valor armazenado na vari�vel valorDadosContato
     *
     * @return String
     */
    public static String retornaDadosContato(){
        return (String) valorDadosContato.get();
    }

    /**
     * Armazena valor da institui��o inicial na vari�vel valorInstituicaoInicial
     *
     * @param instituicao
     */
    public static void setInstituicaoInicial(String instituicao){
        if(valorInstituicaoInicial == null){
            valorInstituicaoInicial = new ThreadLocal<>();
        }
        valorInstituicaoInicial.set(instituicao);
    }

    /**
     * Retorna valor armazenado na var�vel valorInstituicao
     *
     * @return String
     */
    public static String retornaInstituicaoInicial(){
        return (String) valorInstituicaoInicial.get();
    }

    /**
     * Armazena valor da ag�ncia inicial na vari�vel valorAgenciaInicial
     *
     * @param agencia
     */
    public static void setAgenciaInicial(String agencia){
        if(valorAgenciaInicial == null){
            valorAgenciaInicial = new ThreadLocal<>();
        }
        valorAgenciaInicial.set(agencia);
    }

    /**
     * Retorna valor armazenado na vari�vel valorInstituicao
     *
     * @return String
     */
    public static String retornaAgenciaInicial(){
        return (String) valorAgenciaInicial.get();
    }

    /**
     * Armazena valor da conta inicial na vari�vel valorContaInicial
     *
     * @param conta
     */
    public static void setContaInicial(String conta){
        if(valorContaInicial == null){
            valorContaInicial = new ThreadLocal<>();
        }
        valorContaInicial.set(conta);
    }

    /**
     * Retorna valor armazenado na vari�vel valorInstituicao
     *
     * @return String
     */
    public static String retornaContaInicial(){
        return (String) valorContaInicial.get();
    }

    /**
     * Armazena elemento referente a conta na variavel iconeContato
     *
     * @param contato
     */
    public static void setElementoConta(MobileElement contato){
        if(iconeContato == null){
            iconeContato = new ThreadLocal<>();
        }
        iconeContato.set(contato);
    }

    /**
     * Retorna valor objeto do elemento armazenado na vari�vel iconeContato
     *
     * @return MobileElement
     */
    public static MobileElement retornaElementoConta(){
        return iconeContato.get();
    }

    /**
     * Retorna o elemento com o contato que possui a conta e ag�ncia esperados
     * @param conta
     * @param agencia
     */
    private MobileElement contaAgencia(String conta, String agencia) throws Exception {
        By locator;

        if(ios) {
            locator = By.xpath("//*[@name='Ag�ncia " + agencia + " / Conta " + conta +"']");
        } else {
            locator = By.xpath("//*[contains(translate(@text, '-', ''), 'Ag�ncia " + agencia + " / Conta " + conta + "')]");
        }

        return retornarElemento(locator, "");
    }

    /**
     * Retorna o elemento com o contato que possui a conta pagamento esperados
     * @param conta
     */
    private MobileElement contaAgencia(String conta) throws Exception {
        MobileElement contaCirculo = null;
        By locator = null;
        if(ios) {
            locator = By.xpath("//XCUIElementTypeStaticText[@name=\"C Pagto Final " + conta + "\"]");
        } else {
            locator = By.xpath("//*[contains(@content-desc,'" + conta + "')]");
        }
        contaCirculo = retornarElemento(locator, "");
        return contaCirculo;
    }

    /**
     *Manter primeiro �cone contato em tela pressionado
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("manter pressionado o bot�o da conta salva")
    public MinhasContasTela manterPressionadoBanco() throws Exception {
        instituicaoInicial = retornarTexto( elementoInstituicaoSalva, "N�o foi poss�vel recuperar o nome da institui��o" );
        OperadorEvidencia.logarPasso( "Conta salva: "+ instituicaoInicial);
        manterPressionado( elementoInstituicaoSalva, 1000, "N�o foi poss�vel manter pressionado a conta salva." );
        salvarEvidencia( "Manter Pressionado o bot�o 'Banco'" );
        return this;
    }

    /**
     * Armazenar dados iniciais da conta
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Armazenar dados iniciais da conta")
    public  MinhasContasTela armazenarDadosContaInicial() throws Exception {
        setInstituicaoInicial(retornaInstituicao());
        setAgenciaInicial(retornaAgencia());
        setContaInicial(retornaConta());
        return this;
    }

    /**
     * Tocar bot�o "Edi��o" conta
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Tocar bot�o de edi��o da conta cadastrada")
    public MinhasContasTela tocarBotaoEdicaoConta () throws Exception {
        aguardarCarregamentoElemento(botaoEditarConta);
        tocarElemento( botaoEditarConta, "Erro ao tocar bot�o \"Editar\"" );
        salvarEvidencia("Tocar bot�o \"Editar\"");
        return this;
    }

    /**
     * Tocar bot�o "Excluir"
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Tocar bot�o de exclus�o da conta cadastrada")
    public MinhasContasTela tocarBotaoExclusaoConta () throws Exception {
        aguardarCarregamentoElemento(botaoExcluirConta);
        tocarElemento( botaoExcluirConta, "N�o foi poss�vel tocar o bot�o de excluir de conta" );
        salvarEvidencia( "Tocar bot�o de exclus�o da conta cadastrada");
        return this;
    }

    /**
     * Tocar bot�o "Cancelar"
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Tocar bot�o cancelar exclus�o da conta cadastrada")
    public MinhasContasTela tocarBotaoCancelar () throws Exception {
        aguardarCarregamentoElemento(botaoCancelar);
        tocarElemento( botaoCancelar, "Erro ao cancelar exclus�o" );
        salvarEvidencia( "Cancelar exclus�o da conta cadastrada");
        return this;
    }

    /**
     * Abrir lista "Institui��es de Pagamento"
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Abrir lista de Institui��oes de Pagamento")
    public MinhasContasTela abrirlistaIntituicoesPagamento () throws Exception {
        nomeInstituicaoAntesTroca = retornarTexto( botaoSelecionarIntituicaoPagamento, "n�o foi poss�vel recuperar o texto");
        tocarElemento( botaoSelecionarIntituicaoPagamento, "n�o foi poss�vel abrir lista de Institui��es de Pagamento" );
        salvarEvidencia( "Abrir lista de Institui��es de Pagamento" );
        return this;
    }

    /**
     * Selecionar institui��o da lista
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Selecionar outra institui��o")
    public MinhasContasTela selecionarIntituicaoLista() throws Exception {
        if (StringUtils.equalsIgnoreCase(nomeInstituicaoAntesTroca, "BANCO INTERMEDIUM S.A.")) {
            bancoSelecionado = "1 -BANCO DO BRASIL S.A.";
            tocarTexto( "BANCO DO BRASIL S.A.", "n�o foi poss�vel tocar no texto" );
            salvarEvidencia( "institui��o selecionada: BANCO DO BRASIL S.A." );
        } else if (StringUtils.equalsIgnoreCase( nomeInstituicaoAntesTroca, "BANCO DO BRASIL S.A.") ){
            bancoSelecionado = "77 -BANCO INTERMEDIUM S.A.";
            tocarTexto( "BANCO INTERMEDIUM S.A.", "n�o foi poss�vel tocar no texto" );
            salvarEvidencia( "institui��o selecionada: BANCO INTERMEDIUM S.A." );
        }
        return this;
    }

    /**
     * Confirmar sele��o institui��o
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Confirmar sele��o")
    public MinhasContasTela confirmarSelecaoInstituicao () throws Exception {
        tocarElemento( botaoConfirmarSelecaoInstituicao, "n�o foi poss�vel tocar na confirma��o da lista de institui��es" );
        salvarEvidencia( "Tocar no bot�o de confirma��o de sele��o da institui��o" );
        return this;
    }

    /**
     * Validar Altera��o institui��o
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Validar a altera��o de institui��o de Pagamento")
    public MinhasContasTela validarAlteracaoInstituicao () throws Exception {
        nomeInstituicaoDepoisTroca = retornarTexto( botaoSelecionarIntituicaoPagamento, "n�o foi poss�vel recuperar o texto");
        Assert.assertNotEquals( nomeInstituicaoAntesTroca, nomeInstituicaoDepoisTroca );
        Assert.assertEquals( nomeInstituicaoDepoisTroca, bancoSelecionado );
        return this;
    }

    /**
     * Salvar Altera��es
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Salvar altera��es")
    public MinhasContasTela salvarAlteracoes () throws Exception {
        rolaTelaBaixo();
        OperadorEvidencia.logarPasso( "Tocar no bot�o SALVAR" );
        tocarElemento( botaoSalvar, "n�o foi poss�vel salcar as altera��es" );
        return this;
    }

    /**
     * Validar que foi efetuada a troca de institui��es
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Validar que foi efetuada a troca de institui��es")
    public MinhasContasTela validarSalvamentoTrocaInstituicao () throws Exception {
        aguardarCarregamentoElemento( elementoInstituicaoSalva );
        instituicaoFinal = retornarTexto( elementoInstituicaoSalva, "n�o foi poss�vel recuperar o nome da institui��o" );
        Assert.assertNotEquals(instituicaoInicial, instituicaoFinal);
        salvarEvidencia( "institui��o alterada com sucesso" );
        return this;
    }

    /**
     * Tocar em Adicionar Conta
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Tocar em adicionar conta")
    public MinhasContasTela tocarAdicionarConta() throws Exception {
        aguardarCarregamentoElemento(botaoAdicionarConta);
        tocarElemento( botaoAdicionarConta, "n�o foi poss�vel tocar em adicionar conta" );
        salvarEvidencia("Tocar bot�o \"+\"");
        return this;
    }

    /**
     * Encontrar Conta
     *
     * - m�todo pr�-existente (ainda n�o foi constru�do)
     *
     * @return MinhasContasTela
     * @throws Exception
     */
   @Step("Encontrar conta")
    public  MinhasContasTela encontrarConta() throws Exception {
//        encontrarFilho( MobileBy.id( "br.com.bradesco.next:id/sv_container_main" ), MobileBy. );
        return this;
    }

    /**
     * Rolar Tela at� contato
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Rolar Tela at� contato")
    public MinhasContasTela rolarAteConta() throws Exception{
        OperadorEvidencia.logarPasso("rolar tela at� encontrar contato");
        int contador = 0;
        String xpath = android ? "//*[@resource-id = \"br.com.bradesco.next:id/rl_main\"]" : "//XCUIElementTypeStaticText";
        String valor = android ? retornaInstituicao() + " " + retornaConta() + " " + retornaAgencia(): retornaAgencia() + " " + retornaConta();
        AtributoElemento atributo = android ? AtributoElemento.CONTENT_DESC : AtributoElemento.LABEL;
        List<MobileElement> listaDeIncidencias = listarIncidencia(xpath,atributo,valor);
        while(listaDeIncidencias.size() == 0){
            if(contador > 8){
                validarCondicaoBooleana(false, MetodoComparacaoBooleano.VERDADEIRO, "Contato n�o encontrado depois de rolar tela para baixo 5 vezes");
            }
            rolarTela(0.6D, 0.3D);
            contador++;
            listaDeIncidencias = listarIncidencia(xpath,atributo,valor);
        }
        setElementoConta(listaDeIncidencias.get(0));
        return this;
    }

    /**
     * Rolar tela at� contato de institui��o informada
     *
     * @param instituicao
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Rolar tela at� contato")
    public MinhasContasTela rolarAteInstituicao(Enum instituicao) throws Exception{
        setInstituicao(instituicao.toString());
        setConta();
        setAgencia();
        setDadosContato();
        int contador = 0;
        while(!verificaInstituicaoEmTela(retornaInstituicao())){
            if(contador > 10){
                validarCondicaoBooleana(false, MetodoComparacaoBooleano.VERDADEIRO, "Contato n�o encontrado depois de rolar tela para cima 10 vezes");
            }
            rolarTela(0.6D, 0.3D);
            contador++;
        }
        salvarEvidencia("Visualizar contato da institui��o: \"" + retornaInstituicao() + "\"");
        return this;
    }

    /**
     * Verifica institui��o em elementos listados em tela
     *
     * @param instituicao
     * @return true: institui��o encontrada, false: institui��o n�o encontrada
     */
    private boolean verificaInstituicaoEmTela(String instituicao)throws Exception{
        boolean elementoEncontrado;
        List<MobileElement> listaElementosEncontrados;
        AtributoElemento atributo;
        if(android){
            atributo = AtributoElemento.CONTENT_DESC;
            listaElementosEncontrados = listarIncidencia("//*[@resource-id = \"br.com.bradesco.next:id/rl_main\"]",atributo, instituicao);
            elementoEncontrado = listaElementosEncontrados.size() >0;
            if(elementoEncontrado){
                setElementoConta(listaElementosEncontrados.get(0));
                setDadosContato(retornarAtributoElemento(retornaElementoConta(), atributo,"Erro ao recuperar atributo de elemento"));
            }
        }else{
            atributo = AtributoElemento.LABEL;
            listaElementosEncontrados = listarIncidencia("//XCUIElementTypeStaticText", atributo, instituicao);
            elementoEncontrado = listaElementosEncontrados.size() > 0;
            if(elementoEncontrado){
                setElementoConta(retornarElementoParente(listaElementosEncontrados.get(0),"XCUIElementTypeStaticText", ParentescoElemento.PROXIMO_IRMAO));
                setDadosContato(retornarAtributoElemento(retornaElementoConta(), atributo,"Erro ao recuperar atributo de elemento"));
            }
        }
        return elementoEncontrado;
    }

    /**
     * m�todo gera lista <MobileElement> com elementos em que h� incid�ncia do valor procurado
     *
     * @param xpath - String com o xpath para localiza��o dos elementos da lista
     * @param atributo - Enum selecionando a atributo a ser utilizado no filtro para sele��o dos elementos da lista
     * @param valor - valor procurado, para o qual ser� montada a lista com as respectivas incid�ncias
     * @return lista de MobileElement em que o atributo � igual ao valor procurado
     * @throws Exception
     */
    private List<MobileElement> listarIncidencia(String xpath, AtributoElemento atributo, String valor) throws Exception{
        List<MobileElement> listaInstituicoesTela = retornarLista(new By.ByXPath(xpath), "Erro ao gerar lista de contatos");
        String valorNormalizado = normalizaString(valor);
        return listaInstituicoesTela.stream().filter(s -> {
            try {
                String atributoRecuperadoElemento = normalizaString(retornarAtributoElemento(s, atributo,"erro ao recuperar elemento"));
                return android ?
                        atributoRecuperadoElemento.contains(valorNormalizado):valorNormalizado.contains(atributoRecuperadoElemento);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());
    }

    /**
     * Pressionar elemento do contato
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Pressionar elemento do contato")
    public MinhasContasTela manterContatoPressionado() throws Exception{
        obterDadosContato();
        manterPressionado( retornaElementoConta(), 1000, "n�o foi poss�vel manter pressionado a conta salva." );
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoExcluirConta) && aguardarCarregamentoElemento(botaoExcluirConta), MetodoComparacaoBooleano.VERDADEIRO,
                    "n�o foi poss�vel verificar e exibi��o dos bot�es \"Excluir\" e \"Editar\"");
        salvarEvidencia( "Manter Pressionado contato institui��o  \"" + retornaInstituicao() +"\", " + retornaAgencia() + " e " + retornaConta() );
        return this;
    }

    /**
     * Armazenar dados de conta e ag�ncia do contato em vari�veis dentro da thread local para utilizar durante o teste
     *
     * @throws Exception
     */
    private void obterDadosContato() throws Exception{
        if(retornaConta().equals(new String()) || retornaAgencia().equals(new String())){
            if(android){
                setConta(retornarTexto(retornaElementoConta().findElementById("br.com.bradesco.next:id/ctv_account"), "Erro ao recuperar atributo texto da conta"));
                setAgencia(retornarTexto(retornaElementoConta().findElementById("br.com.bradesco.next:id/ctv_agency"), "Erro ao recuperar atributo texto da ag�ncia"));
            }else{
                setAgencia(retornaDadosContato().substring(0,retornaDadosContato().indexOf(" ")));
                setConta(retornaDadosContato().substring(retornaDadosContato().indexOf("C")));
            }
        }
    }

    /**
     * Rolar Tela at� in�cio
     *
     * @return MinhasContasTela
     */
    @Step("Rolar tela at� o in�cio")
    public MinhasContasTela retornarParaTopoTela(){
        OperadorEvidencia.logarPasso("Retornar para topo da tela");
        //Nas execu��es mais recentes do iOS, depois de cancelar a exclus�o, o m�todo n�o estava interagindo
        //com a tela... m�todo toca no topo da tela para voltar a interagir com a tela
        if(ios){
            tocarCoordenadaProporcional(50,10);
        }
        rolarTelaAteInicio();
        return this;
    }

    /**
     * Tocar bot�o "Fechar"
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Fechar\"")
    public MinhasContasTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "Erro ao tocar bot�o \"Fechar\"");
        salvarEvidencia("Tocar bot�o \"Fechar\"");
        return this;
    }

    /**
     * Validar presen�a de Contato em Tela
     *
     * @param presencaContato
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Validar presen�a de Contato em Tela")
    public MinhasContasTela validarPresencaConta(boolean presencaContato) throws Exception{
        if(presencaContato){
            validarCondicaoBooleana(verificarPresencaConta(),MetodoComparacaoBooleano.VERDADEIRO,
                    "n�o foi poss�vel encontrar conta: \"" + retornaInstituicao() + "\", " + retornaAgencia() + ", " + retornaConta());
            salvarEvidencia("Validar presen�a conta: \"" + retornaInstituicao() + "\", " + retornaAgencia() + ", " + retornaConta());
        }else{
            validarCondicaoBooleana(verificarPresencaConta(),MetodoComparacaoBooleano.FALSO ,
                    "Conta da institui��o \"" + retornaInstituicao() + "\", " + retornaAgencia() + ", " + retornaConta() + " est� presente em \"Minhas Contas\"");
            salvarEvidencia("Validar conta da institui��o \"" + retornaInstituicao() + "\", " + retornaAgencia() + ", " + retornaConta() + " n�o est� presente em \"Minhas Contas\"");
        }
        return this;
    }

    /**
     *  Verifica se conta est� presente na tela Minhas Contas
     *
     * @return true - se conseguiu rolar at� a conta, false - se n�o foi poss�vel encontar conta
     * @throws Exception
     */
    private boolean verificarPresencaConta() throws Exception{
        try{
            rolarAteConta();
            return true;
        }catch(AssertionError e){
            return false;
        }
    }

    /**
     * Validar exibi��o da tela "MINHAS CONTAS"
     *
     * @return MeusContatosTela
     */
    @Step("Validar exibi��o da tela \"MINHAS CONTAS\"")
    public MinhasContasTela validarExibicaoMinhasContasTela() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloMinhasContasTela), MetodoComparacaoBooleano.VERDADEIRO,
                    "N�o foi poss�vel validar a exibi��o do t�tulo da tela \"MINHAS CONTAS\"");
        salvarEvidencia( "Visualizar tela Minhas Contas" );
        return this;
    }

    /**
     * Tocar c�rculo da conta e ag�ncia
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar c�rculo da conta e ag�ncia")
    public MinhasContasTela tocarContaAgenciaContato(ContaPagamento contaPagamento) throws Exception {
        String agencia = contaPagamento.recuperarAgencia();
        String conta = contaPagamento.recuperarConta();
        tocarElemento(contaAgencia(conta, agencia), "Erro ao executar a a��o de tocar bot�o \"OK\"");
        salvarEvidencia("Tocar c�rculo da conta " + conta + " e ag�ncia " + agencia);
        return this;
    }

    /**
     * Tocar c�rculo da conta pagamento
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar c�rculo da conta e ag�ncia")
    public MinhasContasTela tocarContaPagamentoContato(ContaPagamento contaPagamento) throws Exception {
        String conta = contaPagamento.recuperarConta();
        tocarElemento(contaAgencia(conta), "Erro ao executar a a��o de tocar bot�o \"OK\"");
        salvarEvidencia("Tocar c�rculo da conta " + conta);
        return this;
    }

    /**
     * Tocar c�rculo da conta pagamento recebido do JSON
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar c�rculo da conta e ag�ncia")
    public MinhasContasTela tocarContaPagamentoContatoJSON(String contaPagamento,String agencia) throws Exception {
        MobileElement conta = contaAgencia(contaPagamento, agencia);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(conta, "N�o foi poss�vel encontrar conta");
        salvarEvidencia("Tocar c�rculo da conta " + contaPagamento);
        tocarElemento(conta, "Erro ao executar a a��o de tocar bot�o \"OK\"");
        return this;
    }


}
