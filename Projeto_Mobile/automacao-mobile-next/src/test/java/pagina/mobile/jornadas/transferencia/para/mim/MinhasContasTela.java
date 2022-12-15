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
    @AndroidFindBy(accessibility = "Fechar, Botão")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fechar, Botão\"]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement headerBotaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Adicionar Conta, Botão")
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_add")
    @AndroidFindBy(xpath = "//*[contains(@text,'Adicionar nova conta')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Adicionar Conta, Botão\"]")
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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"não\"`]")
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
     * Inicializa a variável valorConta
     */
    public static void setConta(){
        if(valorConta == null){
            valorConta = new ThreadLocal<>();
        }
        valorConta.set(new String());
    }

    /**
     * Armazena valor da conta na variável valorConta
     *
     * @param conta
     */
    public static void setConta(String conta){
        setConta();
        valorConta.set(conta);
    }

    /**
     * Retorna valor armazenado na variável valorConta
     *
     * @return String
     */
    public static String retornaConta(){
        return (String) valorConta.get();
    }

    /**
     * Inicializa a variável valorAgencia
     */
    public static void setAgencia(){
        if(valorAgencia == null){
            valorAgencia = new ThreadLocal<>();
        }
        valorAgencia.set(new String());
    }

    /**
     * Armazena valor da agência na variável valorAgencia
     *
     * @param agencia
     */
    public static void setAgencia(String agencia){
        setAgencia();
        valorAgencia.set(agencia);
    }

    /**
     * Retorna valor armazenado na variável valorAgencia
     *
     * @return String
     */
    public static String retornaAgencia(){
        return (String) valorAgencia.get();
    }

    /**
     * Inicializa a variável valorAgencia
     */
    public static void setInstituicao(){
        if(valorInstituicao == null){
            valorInstituicao = new ThreadLocal<>();
        }
        valorInstituicao.set(new String());
    }

    /**
     * Armazena valor da instituição na variável valorInstituicao
     *
     * @param instituicao
     */
    public static void setInstituicao(String instituicao){
        setInstituicao();
        valorInstituicao.set(instituicao);
    }

    /**
     * Retorna valor armazenado na variável valorInstituicao
     *
     * @return String
     */
    public static String retornaInstituicao(){
        return (String) valorInstituicao.get();
    }

    /**
     * Inicializa a variável valorDadosContato
     */
    public static void setDadosContato(){
        if(valorDadosContato == null){
            valorDadosContato = new ThreadLocal<>();
        }
        valorDadosContato.set(new String());
    }

    /**
     * Armazena valor dos dados do contato na variável valorDadosContato
     *
     * @param dadosContato
     */
    public static void setDadosContato(String dadosContato){
        setDadosContato();
        valorDadosContato.set(dadosContato);
    }

    /**
     * Retorna valor armazenado na variável valorDadosContato
     *
     * @return String
     */
    public static String retornaDadosContato(){
        return (String) valorDadosContato.get();
    }

    /**
     * Armazena valor da instituição inicial na variável valorInstituicaoInicial
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
     * Retorna valor armazenado na varível valorInstituicao
     *
     * @return String
     */
    public static String retornaInstituicaoInicial(){
        return (String) valorInstituicaoInicial.get();
    }

    /**
     * Armazena valor da agência inicial na variável valorAgenciaInicial
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
     * Retorna valor armazenado na variável valorInstituicao
     *
     * @return String
     */
    public static String retornaAgenciaInicial(){
        return (String) valorAgenciaInicial.get();
    }

    /**
     * Armazena valor da conta inicial na variável valorContaInicial
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
     * Retorna valor armazenado na variável valorInstituicao
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
     * Retorna valor objeto do elemento armazenado na variável iconeContato
     *
     * @return MobileElement
     */
    public static MobileElement retornaElementoConta(){
        return iconeContato.get();
    }

    /**
     * Retorna o elemento com o contato que possui a conta e agência esperados
     * @param conta
     * @param agencia
     */
    private MobileElement contaAgencia(String conta, String agencia) throws Exception {
        By locator;

        if(ios) {
            locator = By.xpath("//*[@name='Agência " + agencia + " / Conta " + conta +"']");
        } else {
            locator = By.xpath("//*[contains(translate(@text, '-', ''), 'Agência " + agencia + " / Conta " + conta + "')]");
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
     *Manter primeiro ícone contato em tela pressionado
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("manter pressionado o botão da conta salva")
    public MinhasContasTela manterPressionadoBanco() throws Exception {
        instituicaoInicial = retornarTexto( elementoInstituicaoSalva, "Não foi possível recuperar o nome da instituição" );
        OperadorEvidencia.logarPasso( "Conta salva: "+ instituicaoInicial);
        manterPressionado( elementoInstituicaoSalva, 1000, "Não foi possível manter pressionado a conta salva." );
        salvarEvidencia( "Manter Pressionado o botão 'Banco'" );
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
     * Tocar botão "Edição" conta
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Tocar botão de edição da conta cadastrada")
    public MinhasContasTela tocarBotaoEdicaoConta () throws Exception {
        aguardarCarregamentoElemento(botaoEditarConta);
        tocarElemento( botaoEditarConta, "Erro ao tocar botão \"Editar\"" );
        salvarEvidencia("Tocar botão \"Editar\"");
        return this;
    }

    /**
     * Tocar botão "Excluir"
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Tocar botão de exclusão da conta cadastrada")
    public MinhasContasTela tocarBotaoExclusaoConta () throws Exception {
        aguardarCarregamentoElemento(botaoExcluirConta);
        tocarElemento( botaoExcluirConta, "Não foi possível tocar o botão de excluir de conta" );
        salvarEvidencia( "Tocar botão de exclusão da conta cadastrada");
        return this;
    }

    /**
     * Tocar botão "Cancelar"
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Tocar botão cancelar exclusão da conta cadastrada")
    public MinhasContasTela tocarBotaoCancelar () throws Exception {
        aguardarCarregamentoElemento(botaoCancelar);
        tocarElemento( botaoCancelar, "Erro ao cancelar exclusão" );
        salvarEvidencia( "Cancelar exclusão da conta cadastrada");
        return this;
    }

    /**
     * Abrir lista "Instituições de Pagamento"
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Abrir lista de Instituiçãoes de Pagamento")
    public MinhasContasTela abrirlistaIntituicoesPagamento () throws Exception {
        nomeInstituicaoAntesTroca = retornarTexto( botaoSelecionarIntituicaoPagamento, "não foi possível recuperar o texto");
        tocarElemento( botaoSelecionarIntituicaoPagamento, "não foi possível abrir lista de Instituições de Pagamento" );
        salvarEvidencia( "Abrir lista de Instituições de Pagamento" );
        return this;
    }

    /**
     * Selecionar instituição da lista
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Selecionar outra instituição")
    public MinhasContasTela selecionarIntituicaoLista() throws Exception {
        if (StringUtils.equalsIgnoreCase(nomeInstituicaoAntesTroca, "BANCO INTERMEDIUM S.A.")) {
            bancoSelecionado = "1 -BANCO DO BRASIL S.A.";
            tocarTexto( "BANCO DO BRASIL S.A.", "não foi possível tocar no texto" );
            salvarEvidencia( "instituição selecionada: BANCO DO BRASIL S.A." );
        } else if (StringUtils.equalsIgnoreCase( nomeInstituicaoAntesTroca, "BANCO DO BRASIL S.A.") ){
            bancoSelecionado = "77 -BANCO INTERMEDIUM S.A.";
            tocarTexto( "BANCO INTERMEDIUM S.A.", "não foi possível tocar no texto" );
            salvarEvidencia( "instituição selecionada: BANCO INTERMEDIUM S.A." );
        }
        return this;
    }

    /**
     * Confirmar seleção instituição
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Confirmar seleção")
    public MinhasContasTela confirmarSelecaoInstituicao () throws Exception {
        tocarElemento( botaoConfirmarSelecaoInstituicao, "não foi possível tocar na confirmação da lista de instituições" );
        salvarEvidencia( "Tocar no botão de confirmação de seleção da instituição" );
        return this;
    }

    /**
     * Validar Alteração instituição
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Validar a alteração de instituição de Pagamento")
    public MinhasContasTela validarAlteracaoInstituicao () throws Exception {
        nomeInstituicaoDepoisTroca = retornarTexto( botaoSelecionarIntituicaoPagamento, "não foi possível recuperar o texto");
        Assert.assertNotEquals( nomeInstituicaoAntesTroca, nomeInstituicaoDepoisTroca );
        Assert.assertEquals( nomeInstituicaoDepoisTroca, bancoSelecionado );
        return this;
    }

    /**
     * Salvar Alteraï¿½ï¿½es
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Salvar alteraï¿½ï¿½es")
    public MinhasContasTela salvarAlteracoes () throws Exception {
        rolaTelaBaixo();
        OperadorEvidencia.logarPasso( "Tocar no botão SALVAR" );
        tocarElemento( botaoSalvar, "não foi possível salcar as alteraï¿½ï¿½es" );
        return this;
    }

    /**
     * Validar que foi efetuada a troca de instituições
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Validar que foi efetuada a troca de instituições")
    public MinhasContasTela validarSalvamentoTrocaInstituicao () throws Exception {
        aguardarCarregamentoElemento( elementoInstituicaoSalva );
        instituicaoFinal = retornarTexto( elementoInstituicaoSalva, "não foi possível recuperar o nome da instituição" );
        Assert.assertNotEquals(instituicaoInicial, instituicaoFinal);
        salvarEvidencia( "instituição alterada com sucesso" );
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
        tocarElemento( botaoAdicionarConta, "não foi possível tocar em adicionar conta" );
        salvarEvidencia("Tocar botão \"+\"");
        return this;
    }

    /**
     * Encontrar Conta
     *
     * - método pré-existente (ainda não foi construído)
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
     * Rolar Tela até contato
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Rolar Tela até contato")
    public MinhasContasTela rolarAteConta() throws Exception{
        OperadorEvidencia.logarPasso("rolar tela até encontrar contato");
        int contador = 0;
        String xpath = android ? "//*[@resource-id = \"br.com.bradesco.next:id/rl_main\"]" : "//XCUIElementTypeStaticText";
        String valor = android ? retornaInstituicao() + " " + retornaConta() + " " + retornaAgencia(): retornaAgencia() + " " + retornaConta();
        AtributoElemento atributo = android ? AtributoElemento.CONTENT_DESC : AtributoElemento.LABEL;
        List<MobileElement> listaDeIncidencias = listarIncidencia(xpath,atributo,valor);
        while(listaDeIncidencias.size() == 0){
            if(contador > 8){
                validarCondicaoBooleana(false, MetodoComparacaoBooleano.VERDADEIRO, "Contato não encontrado depois de rolar tela para baixo 5 vezes");
            }
            rolarTela(0.6D, 0.3D);
            contador++;
            listaDeIncidencias = listarIncidencia(xpath,atributo,valor);
        }
        setElementoConta(listaDeIncidencias.get(0));
        return this;
    }

    /**
     * Rolar tela até contato de instituição informada
     *
     * @param instituicao
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Rolar tela até contato")
    public MinhasContasTela rolarAteInstituicao(Enum instituicao) throws Exception{
        setInstituicao(instituicao.toString());
        setConta();
        setAgencia();
        setDadosContato();
        int contador = 0;
        while(!verificaInstituicaoEmTela(retornaInstituicao())){
            if(contador > 10){
                validarCondicaoBooleana(false, MetodoComparacaoBooleano.VERDADEIRO, "Contato não encontrado depois de rolar tela para cima 10 vezes");
            }
            rolarTela(0.6D, 0.3D);
            contador++;
        }
        salvarEvidencia("Visualizar contato da instituição: \"" + retornaInstituicao() + "\"");
        return this;
    }

    /**
     * Verifica instituição em elementos listados em tela
     *
     * @param instituicao
     * @return true: instituição encontrada, false: instituição não encontrada
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
     * método gera lista <MobileElement> com elementos em que há incidência do valor procurado
     *
     * @param xpath - String com o xpath para localização dos elementos da lista
     * @param atributo - Enum selecionando a atributo a ser utilizado no filtro para seleção dos elementos da lista
     * @param valor - valor procurado, para o qual será montada a lista com as respectivas incidências
     * @return lista de MobileElement em que o atributo é igual ao valor procurado
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
        manterPressionado( retornaElementoConta(), 1000, "não foi possível manter pressionado a conta salva." );
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoExcluirConta) && aguardarCarregamentoElemento(botaoExcluirConta), MetodoComparacaoBooleano.VERDADEIRO,
                    "não foi possível verificar e exibição dos botões \"Excluir\" e \"Editar\"");
        salvarEvidencia( "Manter Pressionado contato instituição  \"" + retornaInstituicao() +"\", " + retornaAgencia() + " e " + retornaConta() );
        return this;
    }

    /**
     * Armazenar dados de conta e agência do contato em variï¿½veis dentro da thread local para utilizar durante o teste
     *
     * @throws Exception
     */
    private void obterDadosContato() throws Exception{
        if(retornaConta().equals(new String()) || retornaAgencia().equals(new String())){
            if(android){
                setConta(retornarTexto(retornaElementoConta().findElementById("br.com.bradesco.next:id/ctv_account"), "Erro ao recuperar atributo texto da conta"));
                setAgencia(retornarTexto(retornaElementoConta().findElementById("br.com.bradesco.next:id/ctv_agency"), "Erro ao recuperar atributo texto da agência"));
            }else{
                setAgencia(retornaDadosContato().substring(0,retornaDadosContato().indexOf(" ")));
                setConta(retornaDadosContato().substring(retornaDadosContato().indexOf("C")));
            }
        }
    }

    /**
     * Rolar Tela até início
     *
     * @return MinhasContasTela
     */
    @Step("Rolar tela até o início")
    public MinhasContasTela retornarParaTopoTela(){
        OperadorEvidencia.logarPasso("Retornar para topo da tela");
        //Nas execuções mais recentes do iOS, depois de cancelar a exclusão, o método não estava interagindo
        //com a tela... método toca no topo da tela para voltar a interagir com a tela
        if(ios){
            tocarCoordenadaProporcional(50,10);
        }
        rolarTelaAteInicio();
        return this;
    }

    /**
     * Tocar botão "Fechar"
     *
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public MinhasContasTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "Erro ao tocar botão \"Fechar\"");
        salvarEvidencia("Tocar botão \"Fechar\"");
        return this;
    }

    /**
     * Validar presença de Contato em Tela
     *
     * @param presencaContato
     * @return MinhasContasTela
     * @throws Exception
     */
    @Step("Validar presença de Contato em Tela")
    public MinhasContasTela validarPresencaConta(boolean presencaContato) throws Exception{
        if(presencaContato){
            validarCondicaoBooleana(verificarPresencaConta(),MetodoComparacaoBooleano.VERDADEIRO,
                    "não foi possível encontrar conta: \"" + retornaInstituicao() + "\", " + retornaAgencia() + ", " + retornaConta());
            salvarEvidencia("Validar presença conta: \"" + retornaInstituicao() + "\", " + retornaAgencia() + ", " + retornaConta());
        }else{
            validarCondicaoBooleana(verificarPresencaConta(),MetodoComparacaoBooleano.FALSO ,
                    "Conta da instituição \"" + retornaInstituicao() + "\", " + retornaAgencia() + ", " + retornaConta() + " está presente em \"Minhas Contas\"");
            salvarEvidencia("Validar conta da instituição \"" + retornaInstituicao() + "\", " + retornaAgencia() + ", " + retornaConta() + " não está presente em \"Minhas Contas\"");
        }
        return this;
    }

    /**
     *  Verifica se conta está presente na tela Minhas Contas
     *
     * @return true - se conseguiu rolar até a conta, false - se não foi possível encontar conta
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
     * Validar exibição da tela "MINHAS CONTAS"
     *
     * @return MeusContatosTela
     */
    @Step("Validar exibição da tela \"MINHAS CONTAS\"")
    public MinhasContasTela validarExibicaoMinhasContasTela() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloMinhasContasTela), MetodoComparacaoBooleano.VERDADEIRO,
                    "Não foi possível validar a exibição do título da tela \"MINHAS CONTAS\"");
        salvarEvidencia( "Visualizar tela Minhas Contas" );
        return this;
    }

    /**
     * Tocar círculo da conta e agência
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar círculo da conta e agência")
    public MinhasContasTela tocarContaAgenciaContato(ContaPagamento contaPagamento) throws Exception {
        String agencia = contaPagamento.recuperarAgencia();
        String conta = contaPagamento.recuperarConta();
        tocarElemento(contaAgencia(conta, agencia), "Erro ao executar a ação de tocar botão \"OK\"");
        salvarEvidencia("Tocar círculo da conta " + conta + " e agência " + agencia);
        return this;
    }

    /**
     * Tocar círculo da conta pagamento
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar círculo da conta e agência")
    public MinhasContasTela tocarContaPagamentoContato(ContaPagamento contaPagamento) throws Exception {
        String conta = contaPagamento.recuperarConta();
        tocarElemento(contaAgencia(conta), "Erro ao executar a ação de tocar botão \"OK\"");
        salvarEvidencia("Tocar círculo da conta " + conta);
        return this;
    }

    /**
     * Tocar círculo da conta pagamento recebido do JSON
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar círculo da conta e agência")
    public MinhasContasTela tocarContaPagamentoContatoJSON(String contaPagamento,String agencia) throws Exception {
        MobileElement conta = contaAgencia(contaPagamento, agencia);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(conta, "Não foi possível encontrar conta");
        salvarEvidencia("Tocar círculo da conta " + contaPagamento);
        tocarElemento(conta, "Erro ao executar a ação de tocar botão \"OK\"");
        return this;
    }


}
