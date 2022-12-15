package pagina.mobile.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.login.ambiente.SelecaoAmbiente;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.stream.Collectors;

import static java.time.Duration.ofSeconds;

public class JaTenhoContaTela extends PaginaBase {

    private ModalEsteiraAndroid modalAndroid;
    private TelaEsteirasIOS telaEsteirasIOS;

    public JaTenhoContaTela(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.modalAndroid = new ModalEsteiraAndroid(driver);
        this.telaEsteirasIOS = new TelaEsteirasIOS(driver);
    }

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/nb_have_account\" or @resource-id = \"br.com.bradesco.next:id/nb_enter\"]")
    @iOSXCUITFindBy(accessibility = "JÁ TENHO CONTA")
    private MobileElement botaoJaTenhoConta;

    /**
     * Valida a exibição do botão "Já tenho conta"
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Valida a exibição do botão \"Já tenho conta\"")
    public JaTenhoContaTela validarExibicaoBotaoJaTenhoContaTela() throws Exception {
        validarAtributoBooleano(botaoJaTenhoConta, "visible", "true", "Erro ao verificar que botão \"Já tenho Conta\" está visível");
        salvarEvidencia("Botão \"Já tenho conta\" está visível na tela");
        return this;
    }

    /**
     * Método pressiona barra de progresso da tela inicial para exibir esteira de seleção de ambientes de teste
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Abrir esteira de seleção de ambientes de teste")
    public JaTenhoContaTela abrirSelecaoAmbiente() throws Exception {
        manterPressionado(50, 13, 2000, "Falha ao manter coordenada pressionada por 2 segundos");
        OperadorEvidencia.logarPasso("Abrir esteira de seleção de ambientes");
        return this;
    }

    /**
     * Validar Exibição da seleção de ambientes
     *
     * @return JaTenhoContaTela
     */
    @Step("Validar exibição da seleção de ambientes")
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
     * Método seleciona esteira de teste a partir do ambiente selecionado
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
     * Método clica botão "v" em iOS e botão "Enviar Esteira" em Android
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Método clica botão \"v\" em iOS e botão \"Enviar Esteira\" em Android")
    public JaTenhoContaTela confirmarEsteira() throws Exception {
        if(android)
            modalAndroid.tocarBotaoEnviar();
        if(ios)
            telaEsteirasIOS.tocarBotaoConfirmar();
        return this;
    }

    /**
     * Método toca botão "Já tenho conta"
     *
     * @return JaTenhoContaTela
     * @throws Exception
     */
    @Step("Tocar em \"Já tenho conta\"")
    public JaTenhoContaTela tocarJaTenhoConta() throws Exception {
        salvarEvidencia("Tocar Botão Já Tenho Conta");
        tocarElemento(botaoJaTenhoConta, "não foi possível tocarElemento em já tenho conta");
        return this;
    }


    /**
     * Classe criada para definir objeto que contenha os elementos do easter egg exibido ao manter pressionada
     * a tela inicial em android em ambiente de teste
     */
    private class ModalEsteiraAndroid extends PaginaBase{

        ModalEsteiraAndroid(AppiumDriver<MobileElement> driver){
            super(driver);
        }
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

        /**
         * Validar exibição modal com opções de ambiente
         */
        @Step("Validar exibição de opções de ambiente em android")
        private ModalEsteiraAndroid validarOpcoesAmbiente(){
            String textoAmbiente = aguardarPaginaConterQualquerTexto(SelecaoAmbiente.TITULO_MODAL_AMBIENTE_ANDROID);
            validarCondicaoBooleana(textoAmbiente.isEmpty(), MetodoComparacaoBooleano.FALSO, "Não foi possível validar a exibição do modal de seleção de esteira");
            salvarEvidencia("Validar exibição modal para seleção de ambiente em android");
            return this;
        }

        /**
         * Método seleciona o ambiente desejado em android
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
            textoEsteira = retornarTexto(textoEsteiraCombobox, "Erro ao recuperar o texto da esteira");
            aguardarEstabilizarEsteira();
            salvarEvidencia("Ambiente " + ambiente + " está selecionado");
            return this;
        }

        /**
         * Tocar no compobox de ambiente
         * @return ModalEsteiraAndroid
         * @throws NextException
         */
        @Step("Tocar combobox ambiente")
        private ModalEsteiraAndroid tocarComboBoxAmbiente() throws NextException {
            salvarEvidencia("Tocar no combobox de seleção de ambiente");
            tocarElemento(comboboxAmbiente, "Erro encontrado ao executar a ação de tocar no combobox de ambiente");
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
            tocarElemento(radioButtonTI, "Erro encontrado ao executar a ação de tocar no radio-button TI_CLOUD");
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
            tocarElemento(radioButtonTU, "Erro encontrado ao executar a ação de tocar no radio-button TU_CLOUD");
            return this;
        }

        /**
         * Método aguarda o combobox esteira ficar estável no modal da seleção ambiente
         * @return ModalEsteiraAndroid
         */
        private ModalEsteiraAndroid aguardarEstabilizarEsteira() throws Exception {
            String esteiraEsperada = textoAmbiente.equalsIgnoreCase(SelecaoAmbiente.AMBIENTES_ANDROID[0]) ? SelecaoAmbiente.ESTEIRAS_ANDROID[0] : SelecaoAmbiente.ESTEIRAS_ANDROID[1];
            String esteiraCarregada = "";
            for(int i = 0; i < 100 ; i++ ){
                //Esse sleep está aqui para estabelecer uma pausa entre as requisições.
                //Ao observar-se o comportamento atual da tela, verificou-se que demora um tempo até carregar
                //o valor da esteira no combobox correspondente
                Thread.sleep(300);
                esteiraCarregada = retornarTexto(textoEsteiraCombobox, "Erro ao recuperar o texto da esteira");
                if(esteiraCarregada.equals(esteiraEsperada)){
                    break;
                }
            }
            return this;
        }

        /**
         * Método toca no combobox da esteira
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
            //A ordem das ações sendKeys, esconderTeclado do framework causa um erro nesse elemento
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
                //Exceção não está sendo tratada pelo framework, por isso foi necessário a inclusão de um bloco try-catch
                throw new NextException(this,"A esteira " + esteira + " não foi encontrada", excecao);
            }
            tocarElemento(elementoEsteira, "Erro ao tocar elemento esteira");
            return this;
        }

        /**
         * Método toca no botão "Enviar" em Android
         *
         * @return ModalEsteiraAndroid
         * @throws Exception
         */
        @Step("Método toca no botão \"Enviar\" em Android")
        private  ModalEsteiraAndroid tocarBotaoEnviar() throws Exception {
            salvarEvidencia("Tocar botão \"Enviar Esteira\"");
            tocarElemento(botaoEnviar, "Erro encontrado ao tocar no botão \"Enviar Esteira\"");
            return this;
        }

    }

    /**
     * Classe criada para definir objeto que contenha os elementos do easter egg exibido ao manter pressionada
     * a tela inicial em android em ambiente de teste
     */
    private class TelaEsteirasIOS extends PaginaBase{

        TelaEsteirasIOS(AppiumDriver<MobileElement> driver){
            super(driver);
        }

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

        /**
         * Validar exibição da tela com opções de ambiente em iOS
         */
        @Step("Validar exibição da tela com opções de ambiente em iOS")
        private TelaEsteirasIOS validarOpcoesAmbiente(){
            String textoAmbiente = aguardarPaginaConterQualquerTexto(SelecaoAmbiente.TITULO_TELA_AMBIENTE_IOS);
            validarCondicaoBooleana(textoAmbiente.isEmpty(), MetodoComparacaoBooleano.FALSO, "Não foi possível validar a exibição da tela de seleção de esteira");
            salvarEvidencia("Validar exibição tela para seleção de ambiente em ios");
            return this;
        }

        /**
         * Método rola a roleta de ambiente até encontrar o ambiente desejado
         * @param ambiente
         * @return
         * @throws Exception
         */
        @Step("Método rola a roleta de ambiente até encontrar o ambiente desejado")
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
            validarCondicaoBooleana(ambienteEncontrado, MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível encontrar o ambiente");
            salvarEvidencia("Ambiente " + ambiente + " está selecionado");
            return this;
        }

        /**
         * Método calcula a região da roleta para executar a ação de rolar
         */
        @Step("Calcular Região Rolagem roleta ambiente")
        private void calcularRegiaoRolagemRoletaAmbiente() {
            double yInferiorElemento = roletaAmbiente.getRect().y + roletaAmbiente.getRect().height;
            double alturaTela = retornaDimensaoTela().getHeight();
            ySuperiorProporcionalRoletaAmbiente = 1.25 * roletaAmbiente.getRect().y / alturaTela;
            yInferiorProporcionalRoletaAmbiente = 0.75 * (yInferiorElemento / alturaTela);
        }

        /**
         * Método rola a roleta para baixo dentro da região calculada
         */
        @Step("Método rola a roleta para baixo dentro da região calculada")
        private void rolarRoletaAmbienteParaBaixo(){
            rolarTela(yInferiorProporcionalRoletaAmbiente, ySuperiorProporcionalRoletaAmbiente);
            ySuperiorProporcionalRoletaAmbiente *= 0.95;
        }

        /**
         * Método rola a roleta para cima dentro da região calculada
         */
        @Step("Método rola a roleta para cima dentro da região calculada")
        private void rolarRoletaAmbienteParaCima(){
            rolarTela(ySuperiorProporcionalRoletaAmbiente, yInferiorProporcionalRoletaAmbiente);
            ySuperiorProporcionalRoletaAmbiente *= 1.25;
        }

        /**
         * Método rola a roleta de ambiente até encontrar o ambiente desejado
         * @param esteira
         * @return
         * @throws Exception
         */
        @Step("Método rola a roleta de ambiente até encontrar o ambiente desejado")
        private TelaEsteirasIOS rolarRoletaAteEncontrarEsteira(String esteira)throws Exception{
            calcularRegiaoRolagemRoletaEsteira();
            boolean ambienteEncontrado = false;
            for(int i = 0; i < 10; i++){
                ambienteEncontrado = retornarTexto(roletaEsteira, "Erro ao recuperar atributo texto da roleta").equalsIgnoreCase(esteira);
                if(ambienteEncontrado)
                    break;
                rolarRoletaEsteiraParaBaixo();
            }
            validarCondicaoBooleana(ambienteEncontrado, MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível encontrar o ambiente");
            salvarEvidencia("Esteira " + esteira + " está selecionada");
            return this;
        }

        /**
         * Método calcula a região da roleta para executar a ação de rolar
         */
        @Step("Calcular a região da roleta para executar a ação de rolar")
        private void calcularRegiaoRolagemRoletaEsteira() {
            int yCentroElemento = roletaEsteira.getCenter().getY();
            int meiaAlturaElemento = roletaEsteira.getSize().getHeight() / 2;
            int alturaTela = retornaDimensaoTela().getHeight();
            ySuperiorProporcionalRoletaEsteira = (double) (yCentroElemento - meiaAlturaElemento) / alturaTela;
            yInferiorProporcionalRoletaEsteira = (double) yCentroElemento / alturaTela;
        }

        /**
         * Método rola a roleta para baixo dentro da região calculada
         */
        @Step("rola a roleta para baixo dentro da região calculada")
        private void rolarRoletaEsteiraParaBaixo(){
            rolarTela(yInferiorProporcionalRoletaEsteira, ySuperiorProporcionalRoletaEsteira);
        }

        /**
         * Método preenche barra de pesquisa com o valor desejado para a esteira
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
         * Método clica botão "v" em iOS
         *
         * @return TelaEsteirasIOS
         * @throws Exception
         */
        @Step("Método clica botão \"v\" em iOS")
        private TelaEsteirasIOS tocarBotaoConfirmar() throws Exception {
            salvarEvidencia("Tocar botão \"v\"");
            tocarElemento(botaoConfirmar, "Erro encontrado ao tocar no botão \"Confirmar\"");
            return this;
        }

    }
}
