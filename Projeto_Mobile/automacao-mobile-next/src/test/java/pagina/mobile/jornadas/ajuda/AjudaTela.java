package pagina.mobile.jornadas.ajuda;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;

public class AjudaTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_open_history")
    @iOSXCUITFindBy(accessibility = "Ver histórico")
    private MobileElement botaoHistorico;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_arrow_download")
    @iOSXCUITFindBy(accessibility = "icon download chat")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"arrow-balloon\"])[5]")
    private MobileElement botaoDownload;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains (upper-case(@text), 'JPEG')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"VAL\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"VAL\"])[1]")
    private MobileElement imagem;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_photo")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"VAL\"]/XCUIElementTypeOther/XCUIElementTypeOther)[1]")
    private MobileElement imagemBaixada;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Digita seu CPF pra mudar sua senha.']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"VAL\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement campoForaImagem;

    @AndroidFindBy(xpath = "android:id/title")
    private MobileElement programaPadrao;

    @iOSXCUITFindBy(accessibility = "Done")
    private MobileElement botaoFecharVideo;

    //Não existe este botão no Ios
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_filename")
    private MobileElement botaoNomeArquivo;

    @AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout)[1]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Puxe para ver o histórico do chat\"]")
    private MobileElement maisMensagens;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains (upper-case(@text), 'PDF')]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_pdf")
    @iOSXCUITFindBy(accessibility = "icon cell accessory")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"VAL\"])[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement botaoPDF;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains (upper-case(@text), 'MP4')]")
    @AndroidFindBy(xpath = "(//android.widget.ImageView)[12]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\\\"arrow-balloon\\\"])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"VAL\"])[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement botaoVideo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_thumbnail")
    private MobileElement botaoVideoBaixado;

    @AndroidFindBy(id = "android:id/sem_title_default")
    @iOSXCUITFindBy(accessibility = "QLPDFViewControllerViewAccessibilityIdentifier")
    private MobileElement opcaoEscolhaApp;

    public AjudaTela(AppiumDriver driver) {
        super(driver);
    }

    /** Tocar botão historico na tela de ajuda
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'historico'")
    public AjudaTela tocarBotaoHistorico() throws Exception {
        tocarElemento(botaoHistorico, "Não foi possível tocar no botão 'Historico'");
        salvarEvidencia("Tocar botao 'historico'");
        return this;
    }

    /** Tocar botão Download do arquivo no histórico da tela
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'Download'")
    public AjudaTela tocarBotaoDownload() throws Exception {
        if (verificarPresencaElemento(botaoDownload)){
            salvarEvidencia("Tocar botao 'Download'");
            tocarElemento(botaoDownload, "Não foi possível tocar no botão 'Download'");
        }
        return this;
    }

    /** Tocar no Arquivo para abrí-lo
     * @return
     * @throws Exception
     */
    @Step("Tocar no 'Arquivo'")
    public AjudaTela tocarArquivo() throws Exception {
        salvarEvidencia("Tocar no 'Arquivo'");
        tocarElemento(botaoNomeArquivo, "Não foi possível tocar no 'Arquivo'");
        return this;
    }


    /** Tocar na Imagem para abrí-la
     * @return
     * @throws Exception
     */
    @Step("Tocar na 'Imagem'")
    public AjudaTela tocarImagem() throws Exception {
        if (!verificarPresencaElemento(imagem) && ios){
            rolarTelaParaCimaAosPoucosAteEncontrarElemento(imagem, "Nao foi possivel encontrar o arquivo");
        }
        salvarEvidencia("Tocar na 'Imagem'");
        aguardarCarregamentoElemento(imagemBaixada);
        tocarElemento(imagemBaixada, "Não foi possível tocar na 'Imagem'");
        return this;
    }

    /** Tocar no campo fora da Imagem para fechá-la
     * @return
     * @throws Exception
     */
    @Step("Tocar no campo fora da imagem")
    public AjudaTela tocarCampoForaArquivoVisualizado() throws Exception {
        salvarEvidencia("Tocar no campo fora da imagem");
        if (android){
            if (verificarPresencaElemento(programaPadrao)){
                tocarCoordenadaElemento(campoForaImagem);
            }else {
                voltarTelaAnterior();
            }
        }else if (ios){
            tocarCoordenadaElemento(imagem);
        }
        return this;
    }

    /** Tocar no botao voltar
     * @return
     * @throws Exception
     */
    @Step("Tocar no botao voltar")
    public AjudaTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no botao voltar");
        if (ios) {
            tocarCoordenadaElemento(botaoFecharVideo);
        }else{
            if (verificarPresencaElemento(programaPadrao)){
                tocarCoordenadaElemento(campoForaImagem);
            }else {
                voltarTelaAnterior();
            }
        }
        return this;
    }

    /** Rolar tela até Verificar Presenca texto Puxe Para Ver Mais Mensagens
     * @return
     * @throws Exception
     */
    @Step("Rolar tela até Verificar Presenca Puxe Para Ver Mais Mensagens")
    public AjudaTela VerificarPresencaTextoPuxeParaVerMaisMensagens() throws Exception {
        salvarEvidencia("Rolar até o inicio das mensagens");
        for (int i = 0;i<=5;i++){
            if (verificarPresencaElemento(maisMensagens)) {
                salvarEvidencia("Encontrado texto 'Puxe para ver mais mensagens'");
                break;
            }else if (i==4 || verificarPresencaElemento(imagem)){
                break;
            }else {
                rolarTela(0.2,0.8);
                i++;

            }
        }
        return this;
    }

    /** Tocar no video para abrí-lo
     * É aguardado o video finalizar para voltar para a tela do chat, através do Thread.Sleep de 5s
     * @return
     * @throws Exception
     */
    @Step("Tocar no 'Video'")
    public AjudaTela tocarVideo() throws Exception {
        salvarEvidencia("Tocar no 'Video'");
        if (android) {
            tocarElemento(botaoVideoBaixado, "Não foi possível tocar na 'Video'");
            Thread.sleep(5000);
        }else {
            rolarTela(0.3D,0.06D);
            tocarCoordenadaProporcional(botaoVideo,75,85);
        }
        return this;
    }

    /** Tocar no PDF para abrí-lo
     * @return
     * @throws Exception
     */
    @Step("Tocar no 'PDF'")
    public AjudaTela tocarPDF() throws Exception {
        salvarEvidencia("Tocar no 'PDF'");
        tocarElemento(botaoPDF, "Não foi possível tocar na 'Imagem'");
        return this;
    }

    /** Rolar tela pra baixo até encontrar o próximo arquivo
     * @return
     * @throws Exception
     */
    @Step("Encontrar proximo arquivo abaixo")
    public AjudaTela encontrarProximoArquivo(String arquivo) throws Exception {
        salvarEvidencia("Encontrando proximo arquivo: " + arquivo);
        MobileElement arquivoVer;
        if (arquivo.equals("IMAGEM")){
            arquivoVer = imagem;
        }else if (arquivo.equals("VIDEO")){
            arquivoVer = botaoVideo;
        }else {
            arquivoVer = botaoPDF;
        }
        for (int i=0;i<=3;i++){
                rolarTela(0.6,0.3);
            if (!verificarPresencaElemento(botaoDownload) && !verificarPresencaElemento(arquivoVer)){
                i++;
            }else {
                break;
            }
        }
        salvarEvidencia("Encontrado proximo arquivo: " + arquivo);
        return this;
    }

    /** Verificar se o PDF está disponivel para abertura
     * @return
     * @throws Exception
     */
    @Step("Verificar se o PDF está disponivel para abertura")
    public AjudaTela validarMensagemAppAberturaPDF(String texto) throws Exception {
        if (android){
            aguardarPaginaConterQualquerTexto(texto);
        }else {
            verificarPresencaElemento(opcaoEscolhaApp);
        }
        salvarEvidencia("Verificar se o PDF está disponivel para abertura");
        return this;
    }

    /** tocar botao via coordenada encontrada no id passado via param
     * @param elemento
     * @return
     * @throws Exception
     */
    protected void tocarCoordenadaElemento(MobileElement elemento) {
        aguardarCarregamentoElemento(elemento);
        Point localizacao = elemento.getLocation();
        tocarCoordenada(localizacao.x, localizacao.y);
    }

    /** Encontrar Imagem
     * @return
     * @throws Exception
     */
    public AjudaTela encontrarImagem() throws Exception {
        salvarEvidencia("Encontrar imagem");
        if (verificarPresencaElemento(maisMensagens)) {
            if (ios) rolarTelaAteInicio();
            else rolarTelaParaCimaAosPoucosAteEncontrarElemento(imagem,"Não foi possível encontrar a Imagem");
        }else {
            rolarTelaParaCimaAosPoucosAteEncontrarElemento(imagem,"Não foi possível encontrar imagem");
        }
        salvarEvidencia("Encontrado imagem");
        return this;
    }
}
