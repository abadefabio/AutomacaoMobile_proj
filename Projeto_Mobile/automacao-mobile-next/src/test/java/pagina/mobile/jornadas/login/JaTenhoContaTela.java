package pagina.mobile.jornadas.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.login.LoginApp;
import constantes.login.ambiente.SelecaoAmbiente;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.stream.Collectors;

public class JaTenhoContaTela extends PaginaBase {

    private ModalEsteiraAndroid modalAndroid;
    private TelaEsteirasIOS telaEsteirasIOS;

    public JaTenhoContaTela(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.modalAndroid = new ModalEsteiraAndroid(driver);
        this.telaEsteirasIOS = new TelaEsteirasIOS(driver);
    }

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/nb_have_account\" or @resource-id = \"br.com.bradesco.next:id/nb_enter\"]")
    @iOSXCUITFindBy(accessibility = "J� TENHO CONTA")
    private MobileElement botaoJaTenhoConta;

    //N�o possu� mapeamento em Android
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOkPopUpInternet;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_create_account_start")
    @AndroidFindBy(xpath = "//*[contains(@text,\"CRIAR CONTA\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CRIAR CONTA\"`]")
    @iOSXCUITFindBy(accessibility = "CRIAR CONTA")
    private MobileElement botaoCriarConta;

    /**
     * Valida a exibi��o do bot�o "J� tenho conta"
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Valida a exibi��o do bot�o \"J� tenho conta\"")
    public JaTenhoContaTela validarExibicaoBotaoJaTenhoContaTela() throws Exception {
        boolean telaCarregada = aguardarPaginaConterQualquerTexto(LoginApp.TEXTOS_BOTOES_TELA_INICIAL).isEmpty();
        validarCondicaoBooleana(telaCarregada, MetodoComparacaoBooleano.FALSO, "N�o foi poss�vel verificar a presen�a da tela inicial com o banner");
        salvarEvidencia("Tela inicial com banner foi carregada com sucesso");
        return this;
    }

    /**
     * M�todo utilizado para verificar se est� na tela Login Ja Logado
     * @return
     */
    public boolean verificarTelaJaTenhoConta(){
        //passo inclu�do, pois app estava quebrando em iOS
        return aguardarPaginaConterQualquerTexto(LoginApp.TEXTOS_BOTOES_TELA_INICIAL).isEmpty();
    }

    /**
     * M�todo pressiona barra de progresso da tela inicial para exibir esteira de sele��o de ambientes de teste
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Abrir esteira de sele��o de ambientes de teste")
    public JaTenhoContaTela abrirSelecaoAmbiente() throws Exception {
        OperadorEvidencia.logarPasso("Abrir esteira de sele��o de ambientes");
        manterPressionado(50, 13,2000,  "Falha ao manter coordenada pressionada por 2 segundos");
        return this;
    }

    /**
     * M�todo pressiona barra de progresso da tela inicial para exibir esteira de sele��o de ambientes de teste
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Abrir esteira de sele��o de ambientes de teste")
    public JaTenhoContaTela tocarOkPopUpUsoInternet() throws Exception {
        if (verificarPresencaElemento(botaoOkPopUpInternet)){
            tocarElemento(botaoOkPopUpInternet, "N�o foi poss�vel tocar no bot�o OK no Pop Up de uso de internet no iOS.");
        }
        return this;
    }

    /**
     * Validar Exibi��o da sele��o de ambientes
     *
     * @return JaTenhoContaTela
     */
    @Step("Validar exibi��o da sele��o de ambientes")
    public JaTenhoContaTela validarExibicaoSelecaoAmbiente() throws Exception {
        if(android)
           modalAndroid.validarOpcoesAmbiente();
        if(ios)
            telaEsteirasIOS.validarOpcoesAmbiente();
        return this;
    }

    /**
     * Selecionar Ambiente de teste (TI_CLOUD, TU_CLOUD, SIT)
     *
     * @param ambiente
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Selecionar Ambiente")
    public JaTenhoContaTela selecionarAmbiente(String ambiente) throws Exception {
        if (android)
            modalAndroid.selecionarAmbiente(ambiente);
        if (ios)
            telaEsteirasIOS.rolarRoletaAteEncontrarAmbiente(ambiente);
        return this;
    }

    /**
     * M�todo seleciona esteira de teste a partir do ambiente selecionado
     *
     * @param esteira
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Selecionar esteira de teste")
    public JaTenhoContaTela escolherEsteira(String esteira) throws Exception {
        if (android)
            modalAndroid
                    .tocarComboBoxEsteira()
                    .preencherCampoBusca(esteira)
                    .selecionarEsteira(esteira);
        if (ios)
            telaEsteirasIOS.preencherCampoBusca(esteira);
        return this;
    }

    /**
     * M�todo clica bot�o "v" em iOS e bot�o "Enviar Esteira" em Android
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("M�todo clica bot�o \"v\" em iOS e bot�o \"Enviar Esteira\" em Android")
    public JaTenhoContaTela confirmarEsteira() throws Exception {
        if(android)
            modalAndroid.tocarBotaoEnviar();
        if(ios)
            telaEsteirasIOS.tocarBotaoConfirmar();
        return this;
    }

    /**
     * M�todo toca bot�o "J� tenho conta"
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Tocar em \"J� tenho conta\"")
    public JaTenhoContaTela tocarJaTenhoConta() throws Exception {
        salvarEvidencia("Tocar Bot�o J� Tenho Conta");
        tocarElemento(botaoJaTenhoConta, "n�o foi poss�vel tocarElemento em j� tenho conta");
        return this;
    }

    /**
     * M�todo toca bot�o "Criar Conta"
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Tocar em \"J� tenho conta\"")
    public JaTenhoContaTela tocarBotaoCriarConta() throws Exception {
        salvarEvidencia("Tocar Bot�o 'Criar Conta'");
        tocarElemento(botaoCriarConta, "N�o foi poss�vel tocar no bot�o 'Criar Conta'");
        return this;
    }


    /**
     * Classe criada para definir objeto que contenha os elementos do easter egg exibido ao manter pressionada
     * a tela inicial em android em ambiente de teste
     */
    private class ModalEsteiraAndroid extends PaginaBase{

        private String textoAmbiente;

        private String textoEsteira;

        @AndroidFindBy(id = "br.com.bradesco.next:id/spinner_environment")
        private MobileElement comboboxAmbiente;

        @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/spinner_environment\"]/*[@resource-id = \"android:id/text1\"]")
        private MobileElement textoAmbienteCombobox;

        @AndroidFindBy(xpath = "//*[lower-case(@text) = \"ti_cloud\"]")
        private MobileElement radioButtonTI;

        @AndroidFindBy(xpath = "//*[lower-case(@text) = \"tu_cloud\"]")
        private MobileElement radioButtonTU;

        @AndroidFindBy(id = "br.com.bradesco.next:id/spinner_coreip")
        private MobileElement comboboxEsteira;

        @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/spinner_coreip\"]/*[@resource-id = \"android:id/text1\"]")
        private MobileElement textoEsteiraCombobox;

        @AndroidFindBy(id = "br.com.bradesco.next:id/search_src_text")
        private MobileElement campoBusca;

        @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
        private MobileElement botaoEnviar;

        By celulaEsteira = new By.ById("android:id/text1");

        public ModalEsteiraAndroid(AppiumDriver driver) {
            super(driver);
        }

        /**
         * Validar exibi��o modal com op��es de ambiente
         */
        @Step("Validar exibi��o de op��es de ambiente em android")
        private ModalEsteiraAndroid validarOpcoesAmbiente(){
            String textoAmbiente = aguardarPaginaConterQualquerTexto(SelecaoAmbiente.TITULO_MODAL_AMBIENTE_ANDROID);
            validarCondicaoBooleana(textoAmbiente.isEmpty(), MetodoComparacaoBooleano.FALSO, "N�o foi poss�vel validar a exibi��o do modal de sele��o de esteira");
            salvarEvidencia("Validar exibi��o modal para sele��o de ambiente em android");
            return this;
        }

        /**
         * M�todo seleciona o ambiente desejado em android
         * @param ambiente
         * @return ModalEsteiraAndroid
         * @throws Exception
         */
        @Step("Selecionar ambiente em android")
        private ModalEsteiraAndroid selecionarAmbiente(String ambiente) throws Exception {
            textoAmbiente = retornarTexto(textoAmbienteCombobox, "Erro ao recuperar o atributo texto do combobox de ambiente");
            if(!textoAmbiente.toLowerCase().contains(ambiente.toLowerCase())){
                tocarComboBoxAmbiente();
                switch(ambiente.toLowerCase()){
                    case "ti":
                        tocarRadioButtonTI();
                        break;
                    case "tu":
                        tocarRadioButtonTU();
                        break;
                }
                textoAmbiente = retornarTexto(textoAmbienteCombobox, "Erro ao recuperar o atributo texto do combobox de ambiente");
            }
            aguardarEstabilizarEsteira();
            salvarEvidencia("Ambiente " + ambiente + " est� selecionado");
            return this;
        }

        /**
         * Tocar no compobox de ambiente
         * @return ModalEsteiraAndroid
         * @throws NextException
         */
        @Step("Tocar combobox ambiente")
        private ModalEsteiraAndroid tocarComboBoxAmbiente() throws NextException {
            salvarEvidencia("Tocar no combobox de sele��o de ambiente");
            tocarElemento(comboboxAmbiente, "Erro encontrado ao executar a a��o de tocar no combobox de ambiente");
            return this;
        }

        /**
         * Tocar no radion button TI
         * @return ModalEsteiraAndroid
         * @throws NextException
         */
        @Step("Tocar radio-button TI_CLOUD")
        private ModalEsteiraAndroid tocarRadioButtonTI() throws NextException {
            salvarEvidencia("Tocar no radio-button TI_CLOUD");
            tocarElemento(radioButtonTI, "Erro encontrado ao executar a a��o de tocar no radio-button TI_CLOUD");
            return this;
        }

        /**
         * Tocar no radion button TU
         * @return ModalEsteiraAndroid
         * @throws NextException
         */
        @Step("Tocar radio-button TU_CLOUD")
        private ModalEsteiraAndroid tocarRadioButtonTU() throws NextException {
            salvarEvidencia("Tocar no radio-button TU_CLOUD");
            tocarElemento(radioButtonTU, "Erro encontrado ao executar a a��o de tocar no radio-button TU_CLOUD");
            return this;
        }

        /**
         * M�todo aguarda o combobox esteira ficar est�vel no modal da sele��o ambiente
         * @return ModalEsteiraAndroid
         */
        private ModalEsteiraAndroid aguardarEstabilizarEsteira() throws Exception {
            String esteiraEsperada = textoAmbiente.equalsIgnoreCase(SelecaoAmbiente.AMBIENTES_ANDROID[0]) ? SelecaoAmbiente.ESTEIRAS_ANDROID[0] : SelecaoAmbiente.ESTEIRAS_ANDROID[1];
            By localizador =  new By.ByXPath("//*[lower-case(@text) = \"" + esteiraEsperada + "\"]");
            for(int i =0; i < 4; i++){
                if(aguardarCarregamentoElemento(localizador))
                    break;
            }
            return this;
        }

        /**
         * M�todo toca no combobox da esteira
         * @return ModalEsteiraAndroid
         * @throws Exception
         */
        @Step("Tocar combobox Esteira")
        private ModalEsteiraAndroid tocarComboBoxEsteira() throws Exception {
            salvarEvidencia("Tocar Combobox Esteira");
            tocarElemento(comboboxEsteira, "Erro ao tocar combobox esteira");
            return this;
        }

        /**
         * Preencher campo busca
         * @param esteira
         * @return ModalEsteiraAndroid
         * @throws Exception
         */
        @Step("Preencher campo busca")
        private ModalEsteiraAndroid preencherCampoBusca(String esteira) throws Exception {
            //A ordem das a��es sendKeys, esconderTeclado do framework causa um erro nesse elemento
            campoBusca.sendKeys(esteira);
            esconderTeclado();
            salvarEvidencia("Procurar esteira: " + esteira);
            return this;
        }

        /**
         * Selecionar Esteira
         * @param esteira
         * @return
         * @throws Exception
         */
        @Step("Selecionar esteira")
        private ModalEsteiraAndroid selecionarEsteira(String esteira) throws Exception{
            MobileElement elementoEsteira;
            try{
                elementoEsteira = retornarLista(celulaEsteira, "Erro ao recuperar lista esteira")
                        .stream()
                        .filter(elemento ->{
                            try {
                                return retornarTexto(elemento, "Erro ao recuperar texto elemento").equalsIgnoreCase(esteira);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return false;
                        }).collect(Collectors.toList()).get(0);
            }catch(java.lang.IndexOutOfBoundsException excecao){
                //Exce��o n�o est� sendo tratada pelo framework, por isso foi necess�rio a inclus�o de um bloco try-catch
                throw new NextException(this,"A esteira " + esteira + " n�o foi encontrada", excecao);
            }
            tocarElemento(elementoEsteira, "Erro ao tocar elemento esteira");
            return this;
        }

        /**
         * M�todo toca no bot�o "Enviar" em Android
         *
         * @return ModalEsteiraAndroid
         * @throws Exception
         */
        @Step("M�todo toca no bot�o \"Enviar\" em Android")
        private  ModalEsteiraAndroid tocarBotaoEnviar() throws Exception {
            salvarEvidencia("Tocar bot�o \"Enviar Esteira\"");
            tocarElemento(botaoEnviar, "Erro encontrado ao tocar no bot�o \"Enviar Esteira\"");
            return this;
        }

    }

    /**
     * Classe criada para definir objeto que contenha os elementos do easter egg exibido ao manter pressionada
     * a tela inicial em android em ambiente de teste
     */
    private class TelaEsteirasIOS extends PaginaBase{

        @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[1]")
        private MobileElement roletaAmbiente;

        @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[2]")
        private MobileElement roletaEsteira;

        @iOSXCUITFindBy(accessibility = "Buscar")
        private MobileElement barraBuscarEsteira;

        @iOSXCUITFindBy(accessibility = "Confirmar")
        private MobileElement botaoConfirmar;

        private double ySuperiorProporcionalRoletaAmbiente;

        private double yInferiorProporcionalRoletaAmbiente;

        private double ySuperiorProporcionalRoletaEsteira;

        private double yInferiorProporcionalRoletaEsteira;

        public TelaEsteirasIOS(AppiumDriver driver) {
            super(driver);
        }

        /**
         * Validar exibi��o da tela com op��es de ambiente em iOS
         */
        @Step("Validar exibi��o da tela com op��es de ambiente em iOS")
        private TelaEsteirasIOS validarOpcoesAmbiente(){
            esperarCarregando();
            String textoAmbiente = aguardarPaginaConterQualquerTexto(SelecaoAmbiente.TITULO_TELA_AMBIENTE_IOS);
            validarCondicaoBooleana(textoAmbiente.isEmpty(), MetodoComparacaoBooleano.FALSO, "N�o foi poss�vel validar a exibi��o da tela de sele��o de esteira");
            salvarEvidencia("Validar exibi��o tela para sele��o de ambiente em ios");
            return this;
        }

        /**
         * M�todo rola a roleta de ambiente at� encontrar o ambiente desejado
         * @param ambiente
         * @return
         * @throws Exception
         */
        @Step("M�todo rola a roleta de ambiente at� encontrar o ambiente desejado")
        private TelaEsteirasIOS rolarRoletaAteEncontrarAmbiente(String ambiente)throws Exception{
            calcularRegiaoRolagemRoletaAmbiente();
            boolean ambienteEncontrado = false;
            for(int i = 0; i < 4; i++){
                ambienteEncontrado = retornarTexto(roletaAmbiente, "Erro ao recuperar atributo texto da roleta").toUpperCase().contains(ambiente.toUpperCase());
                if(ambienteEncontrado)
                    break;
                if(i < 2)
                    rolarRoletaAmbienteParaBaixo();
                if(i >= 2)
                    rolarRoletaAmbienteParaCima();
            }
            validarCondicaoBooleana(ambienteEncontrado, MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel encontrar o ambiente");
            salvarEvidencia("Ambiente " + ambiente + " est� selecionado");
            return this;
        }

        /**
         * M�todo calcula a regi�o da roleta para executar a a��o de rolar
         */
        @Step("Calcular Regi�o Rolagem roleta ambiente")
        private void calcularRegiaoRolagemRoletaAmbiente() {
            double yInferiorElemento = roletaAmbiente.getRect().y + roletaAmbiente.getRect().height;
            double alturaTela = retornaDimensaoTela().getHeight();
            ySuperiorProporcionalRoletaAmbiente = 1.25 * roletaAmbiente.getRect().y / alturaTela;
            yInferiorProporcionalRoletaAmbiente = 0.75 * (yInferiorElemento / alturaTela);
        }

        /**
         * M�todo rola a roleta para baixo dentro da regi�o calculada
         */
        @Step("M�todo rola a roleta para baixo dentro da regi�o calculada")
        private void rolarRoletaAmbienteParaBaixo(){
            rolarTela(yInferiorProporcionalRoletaAmbiente, ySuperiorProporcionalRoletaAmbiente);
            ySuperiorProporcionalRoletaAmbiente *= 0.95;
        }

        /**
         * M�todo rola a roleta para cima dentro da regi�o calculada
         */
        @Step("M�todo rola a roleta para cima dentro da regi�o calculada")
        private void rolarRoletaAmbienteParaCima(){
            rolarTela(ySuperiorProporcionalRoletaAmbiente, yInferiorProporcionalRoletaAmbiente);
            ySuperiorProporcionalRoletaAmbiente *= 1.25;
        }

        /**
         * M�todo rola a roleta de ambiente at� encontrar o ambiente desejado
         * @param esteira
         * @return
         * @throws Exception
         */
        @Step("M�todo rola a roleta de ambiente at� encontrar o ambiente desejado")
        private TelaEsteirasIOS rolarRoletaAteEncontrarEsteira(String esteira)throws Exception{
            calcularRegiaoRolagemRoletaEsteira();
            boolean ambienteEncontrado = false;
            for(int i = 0; i < 10; i++){
                ambienteEncontrado = retornarTexto(roletaEsteira, "Erro ao recuperar atributo texto da roleta").equalsIgnoreCase(esteira);
                if(ambienteEncontrado)
                    break;
                rolarRoletaEsteiraParaBaixo();
            }
            validarCondicaoBooleana(ambienteEncontrado, MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel encontrar o ambiente");
            salvarEvidencia("Esteira " + esteira + " est� selecionada");
            return this;
        }

        /**
         * M�todo calcula a regi�o da roleta para executar a a��o de rolar
         */
        @Step("Calcular a regi�o da roleta para executar a a��o de rolar")
        private void calcularRegiaoRolagemRoletaEsteira() {
            int yCentroElemento = roletaEsteira.getCenter().getY();
            int meiaAlturaElemento = roletaEsteira.getSize().getHeight() / 2;
            int alturaTela = retornaDimensaoTela().getHeight();
            ySuperiorProporcionalRoletaEsteira = (double) (yCentroElemento - meiaAlturaElemento) / alturaTela;
            yInferiorProporcionalRoletaEsteira = (double) yCentroElemento / alturaTela;
        }

        /**
         * M�todo rola a roleta para baixo dentro da regi�o calculada
         */
        @Step("rola a roleta para baixo dentro da regi�o calculada")
        private void rolarRoletaEsteiraParaBaixo(){
            rolarTela(yInferiorProporcionalRoletaEsteira, ySuperiorProporcionalRoletaEsteira);
        }

        /**
         * M�todo preenche barra de pesquisa com o valor desejado para a esteira
         * @param esteira
         * @return
         * @throws Exception
         */
        @Step("Preencher barra de pesquisa com o valor desejado para a esteira")
        private TelaEsteirasIOS preencherCampoBusca(String esteira) throws Exception {
            escreverTexto(barraBuscarEsteira, esteira, "Erro ao preencher o barra de busca com valor da esteira");
            salvarEvidencia("Pesquisar a esteira \"" + esteira + "\"");
            return this;
        }

        /**
         * M�todo clica bot�o "v" em iOS
         *
         * @return TelaEsteirasIOS
         * @throws Exception
         */
        @Step("M�todo clica bot�o \"v\" em iOS")
        private TelaEsteirasIOS tocarBotaoConfirmar() throws Exception {
            salvarEvidencia("Tocar bot�o \"v\"");
            tocarElemento(botaoConfirmar, "Erro encontrado ao tocar no bot�o \"Confirmar\"");
            return this;
        }

    }
}
