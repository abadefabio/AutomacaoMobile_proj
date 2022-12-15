package br.com.next.automacao.core.base;

import br.com.next.automacao.core.constantes.AtributoElemento;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.Normaliza;
import br.com.next.automacao.core.drivers.OperadorDriver;
import br.com.next.automacao.core.error.NextError;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.NextEvidencia;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidenciaInterface;
import com.lowagie.text.pdf.codec.Base64;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.next.automacao.core.base.TesteBase.getEvidencia;
import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;

/**
 * Super Classe define as classes de tela do framework
 * Os métodos implementados nessa classe são comuns às classes PaginaBase e PaginaBaseWeb
 * @author Matheus Lima Barbosa de Tulio
 * @since 05-2021
 * @version 3.7.3
 *
 */
public class PaginaNext implements OperadorEvidenciaInterface {

    protected boolean mobile;
    String screenshot;
    String textoEvidencia;
    protected WebDriver driver;
    private EsperaNext esperaNextPadrao;
    private Boolean validacaoSucesso = null;

    public PaginaNext(WebDriver driver){
        this.driver = driver;
        mobile = driver instanceof AppiumDriver;
        esperaNextPadrao = new EsperaNext();
    }

    @Override
    public String recuperarFonteTela(){
        try{
            return driver.getPageSource();
        }catch(Exception ex){
            return "Erro ao recuperar fonte da tela:\n" + ex.getMessage();
        }
    }

    private boolean deveAvisarDeviceEmulador() {
        return OperadorDriver.isDeviceEmulador();
    }

    /**
     * Edita a imagem passada como uma Base64,
     * adicionando um aviso em vermelho de que o device é um emulador,
     * e depois retorna a imagem editada no formato Base64
     * @param screenshot
     * @return
     * @throws IOException
     */
    private String adicionarAvisoEmulador(String screenshot) throws IOException {

        byte[] imgBytes = DatatypeConverter.parseBase64Binary(screenshot);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
        Graphics g = img.getGraphics();
        g.setColor(Color.red);
        g.setFont(new Font("SansSerif", Font.BOLD, 40));
        g.drawString("TESTE EXECUTADO EM DISPOSITIVO EMULADO.", 10, 50);
        g.drawString("NÃO VÁLIDO PARA GARANTIA DE QUALIDADE FINAL DA FEATURE", 10, 100);
        g.dispose();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        OutputStream b64 = new Base64.OutputStream(os);
        ImageIO.write(img, "png", b64);
        return os.toString();
    }

    @Override
    public void salvarEvidencia(String description) {
        try {
            screenshot = tirarScreenShot();
            textoEvidencia = montarTextoEvidencia(description);
            NextEvidencia nextEvidencia = null;
            if(deveAvisarDeviceEmulador())
                nextEvidencia = new NextEvidencia(textoEvidencia, adicionarAvisoEmulador(screenshot));
            else
                nextEvidencia = new NextEvidencia(textoEvidencia, screenshot);

            getEvidencia().add(nextEvidencia);
        } catch (Exception ex) {
            Reporter.log("Não foi possível salvar o Screenshot", true);
            ex.printStackTrace();
        }
        OperadorEvidencia.logarPasso(description);
    }

    protected void salvarEvidenciaIgnorandoFalha(String description) {
        if (validacaoSucesso == null) {
            salvarEvidencia(description);
        } else{
            salvarEvidencia(description + ": " + (validacaoSucesso ? "SUCESSO" : "FALHA"));
        }
    }

    /**
     * Método registra o driver em que a ação foi realizada durante a execução da ação
     * @param mensagem
     * @return
     */
    private String montarTextoEvidencia(String mensagem){

        /* Tags utilizadas nas expressões do campo 'message' do relatório Jasper Reports
        1. Exemplo do campo Passo:
        |PASSO|Clicar no botão tal|/PASSO||MOBJETIVO|Objetivo do Teste Mobile|/MOBJETIVO| -> capturado por:
        Expressão Jasper correspondente: $F{message}.substring($F{message}.indexOf("|PASSO|") + 7, $F{message}.indexOf("|/PASSO|"))
        2. Exemplo do campo de objetivo do teste para a web
        |WOBJETIVO|Detalhes do Teste\nMais detalhes\nEtc.|/WOBJETIVO|
        Expressão Jasper correspondente:
        ($F{message}.contains("WOBJETIVO") ? $F{message}.substring($F{message}.indexOf("|WOBJETIVO|") +11, $F{message}.indexOf("|/WOBJETIVO|"))  : "")

        Os campos no relatório Jasper devem ser configurados com a opção 'Remove Line When Blank' em 'Properties' do campo.
        */
        final String TAG_PASSO = "|PASSO|";
        final String TAG_PASSO_F = "|/PASSO|";
        final String TAG_OBJETIVOCT_ABRIR = mobile ?  "|MOBJETIVO|" : "|WOBJETIVO|";
        final String TAG_OBJETIVOCT_FECHAR = mobile ? "|/MOBJETIVO|" : "|/WOBJETIVO|";

        StringBuilder sb = new StringBuilder();
        String objetivoTeste = getCasoTeste().getObjetivoTeste();
        sb.append(TAG_PASSO).append(mensagem);
        if(driver instanceof AndroidDriver) {
            sb.append(" (Executado em Android)");
        }else if (driver instanceof IOSDriver){
            sb.append(" (Executado em iOS)");
        } else if(driver instanceof ChromeDriver){
            sb.append(" (Executado em Chrome)");
        }else if(driver instanceof EdgeDriver){
            sb.append(" (Executado em Edge)");
        }else if(driver instanceof FirefoxDriver){
            sb.append(" (Executado em Firefox)");
        }else if(driver instanceof InternetExplorerDriver){
            sb.append(" (Executado em IE)");
        }else if(driver instanceof SafariDriver){
            sb.append(" (Executado em Safari)");
        }
        sb      .append(TAG_PASSO_F)
                .append(TAG_OBJETIVOCT_ABRIR)
                .append(objetivoTeste)
                .append(TAG_OBJETIVOCT_FECHAR);
        return sb.toString();
    }

    /**
     * Tira ScreenShot da tela do dispositivo
     *
     * @return ScreenShot em Base64
     */
    private String tirarScreenShot() {
        return tirarScreenShot(driver);
    }

    /**
     * @param localizador Estratégia para encontrar texto
     * @return Retorna o texto encontrado.
     */
    protected <T> String retornarTexto(T localizador, String mensagemErro) throws Exception {
        try {
            return retornaElemento(localizador).getText();
        }  catch(NoSuchElementException excessaoNext){
            throw new NextException(this, excessaoNext.getMessage(), excessaoNext);
        } catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex);
        }
    }

    /**
     * Digitar texto usando a classe Actions do selenium
     * @param localizador
     * @param texto
     * @param <T>
     * @throws Exception
     */
    protected <T> void digitarTexto(T localizador, CharSequence... texto) throws Exception {
        try{
            Actions acao = new Actions(driver);
            acao.click(retornaElemento(localizador)).perform();
            acao.sendKeys(texto).perform();
        }catch(NoSuchElementException excessaoNext){
            throw new NextException(this, excessaoNext.getMessage(), excessaoNext);
        } catch (Exception ex) {
            throw new NextException( this, "Ocorreu um erro inesperado ao digitar o texto:\n " +
                    "\"" + texto + "\" no elemento localizado por: \n" +
                    localizador, ex);
        }
    }

    /**
     * Apagar texto, digitando back_Space através da classe Actions
     * @param localizador
     * @param repeticoes
     * @param <T>
     * @throws Exception
     */
    protected <T> void teclarBackSpaceAteApagar(T localizador, int repeticoes) throws Exception {
        String sequence = new String();
        for (int indice=0; indice < repeticoes; indice++){
            sequence += Keys.BACK_SPACE;
        }
        digitarTexto(localizador, sequence);
    }

    /**
     * Apagar campo texto usando backSpace
     *
     * @param elemento            Localizador do elemento
     * @param qtdeCaracteresTexto quantidade de caracteres presentes no campo a ser apagado
     * @param mensagemErro        ensagem de erro em caso de falha
     * @param <T>
     * @throws Exception
     */
    protected <T> void apagarCampoTexto(T elemento, int qtdeCaracteresTexto, String mensagemErro) throws Exception {
        String apagaTexto = "" + Keys.END;
        for (int i = 0; i < qtdeCaracteresTexto; i++) {
            apagaTexto += Keys.BACK_SPACE;
        }
        try {
            retornaElemento(elemento).sendKeys(apagaTexto);
        } catch(NoSuchElementException execaoNext){
            throw new NextException(this, execaoNext.getMessage(), execaoNext);
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
    }

    /**
     * Apagar campo texto
     *
     * @param elemento     Localizador do elemento
     * @param mensagemErro ensagem de erro em caso de falha
     * @param <T>
     * @throws Exception
     */
    protected <T> void apagarCampoTexto(T elemento, String mensagemErro) throws Exception {
        try {
            retornaElemento(elemento).clear();
        } catch(NoSuchElementException execaoNext){
            throw new NextException(this, execaoNext.getMessage(), execaoNext);
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
    }

    /**
     * Método retorna elemento da tela a partir de localizador informado
     * @param localizador
     * @param <T> By, MobileBy, MobileElement, WebElement
     * @return objeto referente a elemento de tela
     * @throws NextException
     */
    protected <T> WebElement retornaElemento(T localizador) throws NextException {
        return retornaElemento(localizador, 30);
    }

    /**
     * Método retorna elemento da tela a partir de localizador informado
     * @param localizador
     * @param <T> By, MobileBy, MobileElement, WebElement
     * @return objeto referente a elemento de tela
     * @throws NextException
     */
    protected <T> WebElement  retornaElemento(T localizador, int tempoEspera) throws NextException {
        String mensagemErro = "Elemento " + localizador + " não encontrado";
        try{
            return esperaNextPadrao.definir(tempoEspera).esperarElementoPresente(localizador);
        }catch(TimeoutException exception){
            throw new NoSuchElementException(mensagemErro);
        }catch(NoSuchElementException excecao){
            throw new NextException(excecao, mensagemErro);
        }
    }

    /**
     * @param elemento Estratégia para encontrar elemento.
     * @return Retorna elemento encontrado.
     */
    protected <T> WebElement retornarElemento(T elemento, String mensagemErro) throws Exception {
        try {
            return retornaElemento(elemento);
        } catch (NoSuchElementException ex) {
            throw new NextException(this, ex.getMessage(), ex);
        } catch (Exception excecao) {
            throw new NextException(this, mensagemErro, excecao);
        }
    }

    /**
     * Retornar texto por índice
     *
     * @param localizador           Localizador do elemento
     * @param mensagemErro Mensagem de erro em caso de falha
     * @param index        Índice do elemento
     * @return Retorna o texto encontrado.
     * @throws Exception
     */
    protected String retornarTextoPorIndice(By localizador, String mensagemErro, int index) throws Exception {
        try {
            return driver.findElements(localizador).get(index).getText();
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
    }

    /**
     * Retorna uma lista de elementos
     *
     * @param by           Localizador do elemento
     * @param mensagemErro Mensagem de erro em caso de falha
     * @return retorna uma Lista
     * @throws NextException Exception para falhar o teste
     */
    protected List<?> retornarLista(By by, String mensagemErro) throws NextException {
        try {
            return driver.findElements(by);
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
    }

    /**
     * Verifica a existência de um elemento na tela
     *
     * @param localizador Localizador do elemento
     * @return retorna TRUE para elemento existente e FALSE para não
     */
    protected <T> boolean verificarPresencaElemento(T localizador) {
        try {
            WebElement elemento = esperaNextPadrao.definir(5).esperarElementoVisivel(localizador);
            if(elemento == null)
                return false;
            boolean elementoVisivel = elemento.isDisplayed();
            if (elementoVisivel) {
                return true;
            }else if (! (driver instanceof IOSDriver))
                return false;
            /*
            iOS não retornou que está visível, então o location é a contra-prova.
             */
            Point localizacaoElemento = elemento.getLocation();
            Dimension dimensaoElemento = elemento.getSize();
            Dimension dimensaoTela = driver.manage().window().getSize();
            if (localizacaoElemento.y + dimensaoElemento.height > dimensaoTela.height) {
                return false;
            }
            return localizacaoElemento.y > 0;
        } catch (Exception ignore) {
            return false;
        }
    }

    /**
     * Aguarda existência  de um elemento de tela
     *
     * @param elemento Elemento para esperar carregamento
     */
    protected <T> boolean aguardarExistenciaElemento(T elemento) {
        WebElement element;
        try {
            element = esperaNextPadrao.esperarElementoPresente(elemento);
            if (element == null) return false;
            return true;
        } catch (Exception e) {
            Reporter.log( e.getMessage(), true );
            return false;
        }
    }

    /**
     * Aguarda existência de um elemento de tela já mapeado
     *
     * @param elemento Elemento para esperar carregamento
     */
    protected <T> boolean aguardarExistenciaElemento(T elemento, int tempoTimeOut, int tempoSleep) {
        WebElement element;
        try {
            element = esperaNextPadrao.definir(tempoTimeOut, tempoSleep).esperarElementoPresente(elemento);
            if (element == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            Reporter.log( e.getMessage(), false );
            return false;
        }
    }

    /**
     * Aguarda o carregamento de um elemento de tela já mapeado
     *
     * @param elemento Elemento para esperar carregamento
     */
    protected <T> boolean aguardarCarregamentoElemento(T elemento) {
        WebElement element;
        try {
            element = esperaNextPadrao.esperarElementoVisivel(elemento);
            if (element == null) return false;
            return true;
        } catch (Exception e) {
            Reporter.log( e.getMessage(), true );
            return false;
        }
    }

    /**
     * Aguarda o carregamento de um elemento de tela já mapeado
     *
     * @param elemento Elemento para esperar carregamento
     */
    protected <T> boolean aguardarVisibilidadeElemento(T elemento, int tempoTimeOut, int tempoSleep) {
        WebElement element;
        try {
            element = esperaNextPadrao.definir(tempoTimeOut, tempoSleep).esperarElementoVisivel(elemento);
            if (element == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Aguarda o carregamento de um elemento de tela já mapeado
     *
     * @param elemento Elemento para esperar carregamento
     */
    protected <T> boolean aguardarElementoHabilitado(T elemento) {
        WebElement element;
        try {
            element = esperaNextPadrao.esperarElementoHabilitado(elemento);
            if (element == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            Reporter.log( e.getMessage(), true );
            return false;
        }
    }

    /**
     * Verifica a presença e/ou aguarda o carregamento de qualquer dos elementos
     *
     * @param elementos Elementos para esperar carregamento
     */
    protected Integer aguardarCarregamentoQualquerElemento(WebElement... elementos) {
        try {
            Integer indiceElementoEncontrado = verificarPresencaQualquerElemento(elementos);
            if (!indiceElementoEncontrado.equals(-1)) return indiceElementoEncontrado;
            EsperaNext espera = esperaNextPadrao.definir(1, Exception.class);
            long inicio = System.currentTimeMillis();
            while (System.currentTimeMillis() - inicio < 30 * 1000){
                for (int i = 0; i < elementos.length; i++) {
                    if (espera.esperarElementoVisivel(elementos[i]) != null)
                        return i;
                }
            }
        } catch (Exception ignore) {

        }
        return -1;
    }

    /**
     * Verifica a presença e/ou aguarda o carregamento de qualquer dos elementos
     *
     * @param elementos Elementos para esperar carregamento
     */
    protected Integer verificarPresencaQualquerElemento(WebElement... elementos) {
        try {
            for (int i = 0; i < elementos.length; i++) {
                if (verificarPresencaElemento(elementos[i])) {
                    return i;
                }
            }
        } catch (Exception ignore) {

        }
        return -1;
    }

    /**
     * Aguarda a página dar match com qualquer dos textos informadas
     * Se a normalização não é informada, utiliza-se indiferença de caixa
     * @param textos Strings de texto contidos na página
     */
    protected String aguardarPaginaConterQualquerTexto(String... textos) {
        try{
            return esperaNextPadrao.esperarPaginaConterQualquerTexto(Normaliza.Caixa, textos);
        }catch (Exception ignore){
            return "";
        }
    }

    /**
     * Aguarda a página dar match com qualquer dos textos informadas
     *
     * @param normaliza Tipo de normalização da página e dos textos
     * @param textos Strings de texto contidos na página
     */
    protected String aguardarPaginaConterQualquerTexto(Normaliza normaliza, String... textos) {
        try{
            return esperaNextPadrao.esperarPaginaConterQualquerTexto(normaliza, textos);
        }catch (Exception ignore){
            return "";
        }
    }

    /**
     * Aguarda a página dar match com qualquer dos textos informadas
     * Se a normalização não é informada, utiliza-se indiferença de caixa
     * @param textos Strings de texto contidos na página
     * @param tempoTimeOut tempo para aguardar condição
     */
    protected String aguardarPaginaConterQualquerTexto(int tempoTimeOut, String... textos) {
        try{
            return esperaNextPadrao.definir(tempoTimeOut).esperarPaginaConterQualquerTexto(Normaliza.Caixa, textos);
        }catch(Exception ignore){
            return "";
        }
    }

    /**
     * Aguarda a página dar match com qualquer dos textos informadas
     *
     * @param tempoTimeOut tempo para aguardar condição
     * @param normaliza Tipo de normalização da página e dos textos
     * @param textos Strings de texto contidos na página
     */
    protected String aguardarPaginaConterQualquerTexto(int tempoTimeOut, Normaliza normaliza, String... textos) {
        try{
            return esperaNextPadrao.definir(tempoTimeOut).esperarPaginaConterQualquerTexto(normaliza, textos);
        }catch(Exception ignore){
            return "";
        }
    }

    /**
     * Aguarda a página dar match com qualquer dos textos informadas
     * Se o tipo de normalização não é informado, aplica-se o critério de indiferença de caixa
     * @param textos Strings de texto contidos na página
     */
    protected boolean aguardarPaginaConterTodosTextos(String... textos) {
        try{
            return esperaNextPadrao.esperarPaginaConterTodosOsTextos(Normaliza.Caixa, textos);
        }catch (Exception ignore){
            return false;
        }
    }

    /**
     * Aguarda a página dar match com qualquer dos textos informadas
     *
     * @param normaliza Tipo de normalização da página e dos textos
     * @param textos Strings de texto contidos na página
     */
    protected boolean aguardarPaginaConterTodosTextos(Normaliza normaliza, String... textos) {
        try{
            return esperaNextPadrao.esperarPaginaConterTodosOsTextos(normaliza, textos);
        }catch (Exception ignore){
            return false;
        }
    }

    /**
     * Metodo para 'Aguardar o objeto não esta visivel' Oculto
     * @param localizador - localizador utilizado para encontrar elemento (MobileBy, By, WebElement, MobileElement)
     * @return true - elemento oculto, false - elemento visível
     * @throws Exception
     */
    protected <T> boolean aguardarOcultacaoElemento(T localizador) {
        try {
            if (esperaNextPadrao.esperarElementoOculto(localizador))
                return true;
            else
                return !retornaElemento(localizador).isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * Aguarda a página não corresponder a uma única expressão
     * Se a normalização não é informada, aplica-se, diferentemente de métodos similares,
     * a normalização de string-número (ManterLetrasNumeros), por motivo de compatibilidade
     * com código existente em projetos.
     * Neste caso, deve-se explicitar o tipo de normalização CaixaIndiferente se for o caso.
     * @param texto Strings correspondentes
     */
    protected boolean aguardarPaginaOcultar(String texto) {
        try{
            return esperaNextPadrao.esperarPaginaOcultar(Normaliza.String, texto);
        }catch(Exception ignore){
            return false;
        }
    }

    /**
     * Aguarda a página não corresponder a uma única expressão
     *
     * @param texto Strings correspondentes
     */
    protected boolean aguardarPaginaOcultar(Normaliza normaliza, String texto) {
        try{
            return esperaNextPadrao.esperarPaginaOcultar(normaliza, texto);
        }catch(Exception ignore){
            return false;
        }
    }

    /**
     * Obter String Base64 a partir da propriedade SRC de um elemento
     * e em que há um header na propriedade SRC
     * @throws Exception
     */
    protected <T> String getImagemBase64Header(T localizador) throws NextException {
        /*
        O elemento informado deve ser uma imagem em que
        o atributo 'src' contenha a string base64 embutida no HTML.
        Se um elemento-pai for fornecido, ainda tentamos encontrar
        o elemento-filho <img>
         */
        return StringUtils.substringAfter(getImagemBase64(retornaElemento(localizador)), "data:image/png;base64,");
    }

    /**
     * Obter String Base64 a partir da propriedade SRC de um elemento
     * e em que há um header na propriedade SRC
     * @throws Exception
     */
    protected <T> String getImagemBase64(T localizador) throws NextException {
        /*
        O elemento informado deve ser uma imagem em que
        o atributo 'src' contenha a string base64 embutida no HTML.
        Vamos esperar que o src esteja completo, ou seja:
        1. Não é nulo
        2. A quantidade de bytes lida não muda (carregou completamente)
        por 3 vezes
         */
        WebElement elemento = retornaElemento(localizador);
        if(esperaNextPadrao.esperarAtributoNaoNulo(elemento,"src")){
            return elemento.getAttribute("src");
        }else{
            return null;
        }
    }

    /**
     * Obter string base64 a partir de um screenshot de um elemento
     *
     * @throws Exception
     */
    protected <T> BufferedImage getBufferedImageScreenshot(T localizador) throws IOException, NextException {
        /*
        Obter BufferedImage a partir do screenshot do elemento
        O elemento precisa estar parado na tela,
        do contrário, a leitura não será efetuada corretamente.
         */
        WebElement element = retornaElemento(localizador);
        Point point = element.getLocation();
        while (true) {
            Point pointAtual = element.getLocation();
            if (pointAtual.equals(point))
                // elemento está parado na tela
                break;
            point = pointAtual;
        }
        File file = element.getScreenshotAs(OutputType.FILE);
        return ImageIO.read(file);
    }

    /**
     * Estratégia para encontrar atributo, quando ele é diferente de texto
     *
     * @param atributo passar como "AtributoElemento.ATRIBUTO"
     * @param localizador estratégia utilizada para localizar o elemento
     * @return Retorna o valor encontrado no atributo.
     */
    protected String retornarAtributoElemento(By localizador, AtributoElemento atributo, String mensagemErro) throws Exception {
        try {
            return retornarAtributoElemento(retornaElemento(localizador), atributo, mensagemErro);
        }catch (NoSuchElementException excecao) {
            throw new NextException(this, excecao.getMessage(), excecao);
        }
    }

    /**
     * Estratégia para encontrar atributo, quando ele é diferente de texto
     *
     * @param atributo passar como "AtributoElemento.ATRIBUTO"
     * @param elemento estratégia utilizada para localizar o elemento
     * @return Retorna o valor encontrado no atributo.
     */
    protected String retornarAtributoElemento(WebElement elemento, AtributoElemento atributo, String mensagemErro) throws Exception {
        try {
            switch(atributo){
                case TEXTO:
                    return elemento.getText();
                default:
                    return elemento.getAttribute(atributo.toString());
            }
        }catch (Exception excecao) {
            throw new NextException(this, mensagemErro, excecao);
        }
    }

    /**
     * @param elemento Estratégia para encontrar elemento.
     * @param atributo Atributo do elemento a ser validado.
     * @param condicao Condição para assertiva.
     * @param mensagemErro Mensagem de erro caso a assertiva for falsa
     */
    protected <T>void validarAtributoBooleano(T elemento, String atributo, String condicao, String mensagemErro) throws Exception {
        boolean falhar = mensagemErro != null && !mensagemErro.isEmpty();
        validacaoSucesso = false;
        try {
            Assert.assertTrue(retornaElemento(elemento)
                    .getAttribute(atributo)
                    .equals(condicao));
            validacaoSucesso = falhar ? null : true;
        } catch (Exception ex) {
            if (falhar) {
                throw new NextException(this, mensagemErro, ex);
            }
        } catch (AssertionError erro) {
            if (falhar) {
                throw new NextError(this, mensagemErro, erro);
            }
        }
    }

    /**
     * @param elemento Estratégia para encontrar elemento.
     * @param atributo Atributo do elemento a ser validado.
     * @param condicao Condição para assertiva.
     */
    protected <T>void validarAtributoBooleanoIgnorandoFalha(T elemento, String atributo, String condicao) throws Exception {
        validarAtributoBooleano(elemento, atributo, condicao, null);
    }

    /**
     * @param elemento Estratégia para encontrar elemento.
     * @param texto    Texto para assertiva.
     * @param mensagemErro Mensagem de erro caso a assertiva for falsa
     */
    protected <T> void validarAtributoTexto(T elemento, String texto, String mensagemErro) throws Exception {
        boolean falhar = mensagemErro != null && !mensagemErro.isEmpty();
        validacaoSucesso = false;
        try {
            Assert.assertEquals(normalizaString(texto), normalizaString(retornaElemento(elemento).getText()));
            validacaoSucesso = falhar ? null : true;
        } catch (Exception ex) {
            if (falhar) {
                throw new NextException(this, "Erro inesperado ao realizar a comparação entre o texto do elemento e o texto esperado", ex);
            }
        } catch (AssertionError erro) {
            if (falhar) {
                throw new NextError(this, mensagemErro, erro);
            }
        }
    }

    /**
     * @param elemento Estratégia para encontrar elemento.
     * @param texto    Texto para assertiva.
     */
    protected <T> void validarAtributoTextoIgnorandoFalha(T elemento, String texto) throws Exception {
        validarAtributoTexto(elemento, texto, null);
    }

    /**
     * Compara o elemento com o texto subindo erro caso a comparação seja verdadeira
     *
     * @param elemento
     * @param texto    passar como "ProtecaoTexto.NOME_TEXTO"
     * @param tipo     passar o tipo de comparação a fazer
     */
    protected <T> void compararElementoTexto(T elemento, String texto, MetodoComparacao tipo) throws Exception{
        compararElementoTexto(elemento, texto, tipo, true);
    }

    /**
     * Compara o elemento com o texto ignorando erro caso a comparação seja verdadeira
     *
     * @param elemento
     * @param texto    passar como "ProtecaoTexto.NOME_TEXTO"
     * @param tipo     passar o tipo de comparação a fazer
     */
    protected <T> void compararElementoTextoIgnorandoFalha(T elemento, String texto, MetodoComparacao tipo) throws Exception{
        compararElementoTexto(elemento, texto, tipo, false);
    }

    /**
     * Compara o elemento com o texto
     *
     * @param elemento
     * @param texto    passar como "ProtecaoTexto.NOME_TEXTO"
     * @param tipo     passar o tipo de comparação a fazer
     * @param falhar   passar se sobe erro ou não
     */
    private <T> void compararElementoTexto(T elemento, String texto, MetodoComparacao tipo, boolean falhar) throws Exception{
        final String mensagemErroTexto = "Erro encontrado ao recuperar texto do elemento "+ elemento;
        final String textoEsperado = normalizaString(texto);
        final String textoRetornado = normalizaString(retornarTexto(elemento, mensagemErroTexto));
        final String mensagemErroComparacao = "Comparação inválida! Esperado: " + textoEsperado + " | Retornado: " + textoRetornado;

        Reporter.log("elemento: " + textoRetornado, true);
        Reporter.log("texto: " + textoEsperado, true);

        try {
            switch (tipo) {
                case CONTEM:
                    Assert.assertTrue(textoRetornado.contains(textoEsperado), mensagemErroComparacao);
                    break;
                case NAO_CONTEM:
                    Assert.assertFalse(textoRetornado.contains(textoEsperado), mensagemErroComparacao);
                    break;
                case IGUAL:
                    Assert.assertEquals(textoRetornado, textoEsperado, mensagemErroComparacao);
                    break;
                case DIFERENTE:
                    Assert.assertNotEquals(textoRetornado, textoEsperado, mensagemErroComparacao);
                    break;
            }
            validacaoSucesso = falhar ? null : true;
        } catch (AssertionError error) {
            if (falhar) {
                throw new NextError(this, error.getMessage(), error);
            } else {
                validacaoSucesso = false;
            }
        }
    }

    /**
     * Compara o elemento com o texto
     *
     * @param elemento
     * @param texto    passar como "ProtecaoTexto.NOME_TEXTO"
     * @param tipo     passar o tipo de comparação a fazer
     * @returns true se a comparação é verdadeira e falso caso contrário
     */
    protected <T> void compararElementoTexto(T elemento, Enum texto, MetodoComparacao tipo) throws Exception{
        compararElementoTexto(elemento, texto.toString(), tipo);
    }

    /**
     * Compara a string do atributo escolhido do elemento com o texto informado
     *
     * @param elemento
     * @param atributo passar como "AtributoElemento.ATRIBUTO"
     * @param texto    passar como "Enum.NOME_TEXTO"
     * @param tipo     passar o tipo de comparação a fazer
     */
    protected <T> void compararElementoAtributo(T elemento, AtributoElemento atributo, Enum texto, MetodoComparacao tipo) throws Exception {
        compararElementoAtributo(elemento, atributo, texto.toString(), tipo);
    }

    /**
     * Compara a string do atributo escolhido do elemento com o texto informado, subindo erro caso a comparação seja verdadeira
     *
     * @param elemento
     * @param atributo passar como "AtributoElemento.ATRIBUTO"
     * @param texto    passar como "Enum.NOME_TEXTO"
     * @param tipo     passar o tipo de comparação a fazer
     */
    protected <T> void compararElementoAtributo(T elemento, AtributoElemento atributo, String texto, MetodoComparacao tipo) throws Exception {
        compararElementoAtributo(elemento, atributo, texto, tipo, true);
    }

    /**
     * Compara a string do atributo escolhido do elemento com o texto informado, ignorando erro caso a comparação seja verdadeira
     *
     * @param elemento
     * @param atributo passar como "AtributoElemento.ATRIBUTO"
     * @param texto    passar como "Enum.NOME_TEXTO"
     * @param tipo     passar o tipo de comparação a fazer
     */
    protected <T> void compararElementoAtributoIgnorandoFalha(T elemento, AtributoElemento atributo, String texto, MetodoComparacao tipo) throws Exception {
        compararElementoAtributo(elemento, atributo, texto, tipo, false);
    }

    /**
     * Compara a string do atributo escolhido do elemento com o texto informado
     *
     * @param elemento
     * @param atributo passar como "AtributoElemento.ATRIBUTO"
     * @param texto    passar como "Enum.NOME_TEXTO"
     * @param tipo     passar o tipo de comparação a fazer
     * @param falhar   passar se sobe erro ou não
     */
    private <T> void compararElementoAtributo(T elemento, AtributoElemento atributo, String texto, MetodoComparacao tipo, boolean falhar) throws Exception {
        final String mensagemErroTexto = "Erro encontrado ao recuperar texto do elemento "+ elemento;
        final String textoEsperado = normalizaString(texto);
        final String textoRetornado = normalizaString(retornarAtributoElemento(elemento instanceof WebElement ? retornaElemento(elemento) : (WebElement) elemento, atributo, mensagemErroTexto));
        final String mensagemErroComparacao = "Comparação inválida! Esperado: " + textoEsperado + " | Retornado: " + textoRetornado;
        Reporter.log("elemento: " + textoRetornado, true);
        Reporter.log("label: " + textoEsperado, true);

        try {
            switch (tipo) {
                case CONTEM:
                    Assert.assertTrue(textoRetornado.contains(textoEsperado), mensagemErroComparacao);
                    break;
                case NAO_CONTEM:
                    Assert.assertFalse(textoRetornado.contains(textoEsperado), mensagemErroComparacao);
                    break;
                case IGUAL:
                    Assert.assertEquals(textoRetornado, textoEsperado, mensagemErroComparacao);
                    break;
                case DIFERENTE:
                    Assert.assertNotEquals(textoRetornado, textoEsperado, mensagemErroComparacao);
            }
            validacaoSucesso = falhar ? null : true;
        } catch (AssertionError error) {
            if (falhar) {
                throw new NextError(this, mensagemErroComparacao, error);
            } else {
                validacaoSucesso = false;
            }
        }
    }

    /**
     * Método utiliza método de asserção para validar se condição booleana informada está de acordo com o esperado para o teste
     *
     * @param condicaoEsperada - parâmetro booleano com a expressão a ser validada
     * @param tipo             - enum para informar o tipo de asserção (verdadeiro, falso)
     * @param mensagemErro
     */
    protected void validarCondicaoBooleana(boolean condicaoEsperada, MetodoComparacaoBooleano tipo, String mensagemErro) {
        boolean falhar = mensagemErro != null && !mensagemErro.isEmpty();
        try {
            switch (tipo) {
                case VERDADEIRO:
                    Assert.assertTrue(condicaoEsperada, mensagemErro);
                    break;
                case FALSO:
                    Assert.assertFalse(condicaoEsperada, mensagemErro);
            }
            validacaoSucesso = falhar ? null : true;
        } catch (AssertionError erro) {
            if (falhar) {
                throw new NextError(this, mensagemErro, erro);
            } else {
                validacaoSucesso = false;
            }
        }
    }

    /**
     * Método utiliza método de asserção para validar se condição booleana informada está de acordo com o esperado para o teste
     *
     * @param condicaoEsperada - parâmetro booleano com a expressão a ser validada
     * @param tipo             - enum para informar o tipo de asserção (verdadeiro, falso)
     */
    protected void validarCondicaoBooleanaIgnorandoFalha(boolean condicaoEsperada, MetodoComparacaoBooleano tipo) {
        validarCondicaoBooleana(condicaoEsperada, tipo, null);
    }

    /**
     * Método para validação de cortina de valores em tela
     * @param elementosCampo
     * @param elementosValor
     * @param dicionarioValores
     * @param <T>
     * @throws Exception
     */
    protected <T>void validarCamposValor(List<T> elementosCampo, List<T>elementosValor, Map<String,String> dicionarioValores) throws Exception{
        try {
            Map<String, String> dicionario = retornaDicionarioCampos(elementosCampo, elementosValor);
            for (Map.Entry<String, String> linha: dicionarioValores.entrySet()) {
                String campo = linha.getKey();
                String valor = linha.getValue();
                if (dicionario.containsKey(Utilitarios.normalizaString(campo))) {
                    String valorReal = dicionario.get(Utilitarios.normalizaString(campo));
                    OperadorEvidencia.logarPasso(String.format("Validar campo '%s' com valor '%s'", campo, valor));
                    Assert.assertTrue(valorReal.contains(Utilitarios.normalizaString(valor)),
                            "O valor esperado para o campo \"" + campo + " \":" + valor + "\nValor obitido: \"" + valorReal + "\".");
                } else {
                    throw new Exception(String.format("Não foi possível encontrar campo esperado '%s'", campo));
                }
            }
        }catch(Exception excecao){
            throw new NextException(this, "Erro encontrado ao tentar recuperar texto do elemento", excecao);
        }catch(AssertionError erro){
            throw new NextError(this, erro.getMessage(), erro);
        }
    }

    /**
     * Método retorna dicionario em que chave = campo, e valor = valor exibido para o campo
     * @param elementosCampo
     * @param elementosValor
     * @param <T>
     * @return
     * @throws Exception
     */
    private <T> Map<String,String> retornaDicionarioCampos(List<T>elementosCampo, List<T>elementosValor) throws Exception {
        Map<String,String> dicionario = new HashMap<>();
        String campo, valor;
        if(elementosCampo.size() == elementosValor.size()){
            for(int i = 0; i < elementosCampo.size(); i++){
                campo = normalizaString(retornaElemento(elementosCampo.get(i)).getText());
                valor = normalizaString(retornaElemento(elementosValor.get(i)).getText());
                dicionario.put(campo,valor);
            }
        }else{
            throw new Exception("Quantidade campos informados não é a mesma quantidade de valores");
        }
        return dicionario;
    }

    /**
     * Retorna uma String em hexadecimal da imagem gerada do elemento passado via param
     * @param element
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public String recuperarHashElemento(WebElement element) throws IOException, NoSuchAlgorithmException {

        /*
        Criado para Mobile.
        Para utilizar com web, seria necessário estabilizar o browser quando tiver carregado página
        recentemente, para garantir que o elemento não tenha mudado de posição na tela enquanto
        este método é executado.
        Esta estabilização seria feita aqui, ou externamente ao framework, antes de usar este método.
         */

        File screenshotElement = element.getScreenshotAs(OutputType.FILE);
        BufferedImage buffImage = ImageIO.read(screenshotElement);
        Point point = element.getLocation();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedImage buffImageResize = buffImage.getSubimage(point.getX(),point.getY(),width,height);
        ImageIO.write(buffImageResize, "png",byteArrayOutputStream);
        byte[] data = byteArrayOutputStream.toByteArray();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data);
        byte[] hash = md.digest();
        String hexadecimal = "";
        for(byte h : hash){
            hexadecimal += String.format("%02X",h);
        }
        return hexadecimal;
    }

    protected class EsperaNext{
        final int TEMPO_ESPERA_PADRAO = 30;
        final int TEMPO_SLEEP_PADRAO = 500;
        int tempoEspera;
        int tempoSleep;
        Class<? extends Throwable> ignora;
        WebDriverWait wait;

        EsperaNext(){
            tempoEspera = TEMPO_ESPERA_PADRAO;
            tempoSleep = TEMPO_SLEEP_PADRAO;
            wait = new WebDriverWait( driver, TEMPO_ESPERA_PADRAO );
        }

        private EsperaNext(int tempoSegundos, Class<? extends Throwable> excecao){
            tempoEspera = tempoSegundos;
            tempoSleep = TEMPO_SLEEP_PADRAO;
            ignora = excecao;
            wait = (WebDriverWait)new WebDriverWait( driver, tempoSegundos ).ignoring(excecao);
        }

        private EsperaNext(int tempoSegundos, int tempoSleep){
            tempoEspera = tempoSegundos;
            this.tempoSleep = tempoSleep;
            wait = new WebDriverWait(driver, tempoSegundos, tempoSleep);
        }

        <T> WebElement esperarElementoVisivel(T localizador){
            return (WebElement) aguardar(CondicoesEspera.esperarElementoVisivel(localizador), wait, getNomeMetodo(), getNome());
        }

        <T> WebElement esperarElementoPresente(T localizador){
            return (WebElement) aguardar(CondicoesEspera.esperaElementoExistente(localizador),wait,getNomeMetodo(),getNome());
        }

        <T> WebElement esperarElementoHabilitado(T localizador){
            return (WebElement) aguardar(CondicoesEspera.esperarElementoClicavel(localizador),wait,getNomeMetodo(),getNome());
        }

        <T> boolean esperarElementoOculto(T localizador){
            return (boolean) aguardar(CondicoesEspera.esperarElementoOcultar(localizador),wait,getNomeMetodo(),getNome());
        }

        boolean esperarAtributoNaoNulo(WebElement elemento, String atributo){
            return (boolean) aguardar(ExpectedConditions.attributeToBeNotEmpty(elemento,atributo),wait,getNomeMetodo(),getNome());
        }

        String esperarFontePagina(){
            return wait.until(CondicoesEspera.esperarFontePagina(driver));
        }

        boolean esperarPaginaOcultar(Normaliza normaliza, String texto){
            OperadorEvidencia.logarPasso("Aguardando ocultação do texto: '" + texto + "' (Normalização: " + normaliza + ")");
            return (boolean) aguardar(CondicoesEspera.esperarPaginaOcultar(driver, normaliza, texto),wait,getNomeMetodo(),getNome());
        }

        String esperarPaginaConterQualquerTexto(Normaliza normaliza, String... textos){
            OperadorEvidencia.logarPasso("Aguardando qualquer texto: '" + Arrays.toString(textos) + "' (Normalização: " + normaliza + ")");

            return (String) aguardar(CondicoesEspera.esperarPaginaConterQualquerTexto(driver, normaliza, textos),wait,getNomeMetodo(),getNome());
        }

        boolean esperarPaginaConterTodosOsTextos(Normaliza normaliza, String... textos){
            OperadorEvidencia.logarPasso("Aguardando todos os textos: '" + Arrays.toString(textos) + "' (Normalização: " + normaliza + ")");

            return (boolean) aguardar(CondicoesEspera.esperarPaginaConterTodosTextos(driver, normaliza, textos),wait,getNomeMetodo(),getNome());
        }

        EsperaNext definir(int tempoSegundos, Class<? extends Throwable> excecao){
            return new EsperaNext(tempoSegundos, excecao);
        }

        EsperaNext definir(int tempoSegundos, int tempoSleep){
            return  new EsperaNext(tempoSegundos,tempoSleep);
        }

        EsperaNext definir(int tempoSegundos){
            return new EsperaNext(tempoSegundos, TEMPO_SLEEP_PADRAO);
        }


        private Object aguardar(ExpectedCondition condicao, Wait wait,String operacao,String stack){

            Date d1= Calendar.getInstance().getTime();
            Object retorno = wait.until(condicao);
            Date d2= Calendar.getInstance().getTime();

            int diff = diferencaHoras(d1,d2);
            OperadorEvidencia.logarPassoCompleto(stack, operacao, diff);
            return retorno;
        }

    }

    public static String getNome () {
        try {
            Throwable thr = new Throwable(); thr.fillInStackTrace ();
            StackTraceElement[] ste = thr.getStackTrace();
            String classe = ste[3].getClassName();
            String[] classes = classe.split("\\.");
            classe = classes[classes.length-1];
            return classe +"."+ ste[3].getMethodName();
        }catch (Exception e){
            return"";
        }
    }

    public static String getNomeMetodo () {
        try {
            Throwable thr = new Throwable(); thr.fillInStackTrace ();
            StackTraceElement[] ste = thr.getStackTrace();
            return ste[1].getMethodName();
        }catch (Exception e){
            return"";
        }
    }

    /**
     * @param d1
     * @param d2
     * @return
     */
    public int diferencaHoras(Date d1, Date d2) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

        String d1St = df.format(d1);
        String d2St = df.format(d2);

        LocalDateTime dt1= LocalDateTime.parse(d1St, f);
        LocalDateTime dt2= LocalDateTime.parse(d2St, f);

        long diferencaMili = Duration.between(dt1, dt2).toMillis();

        return (int) diferencaMili;
    }

    /**
     * Verificar presença de elemento que é visto na tela, mas não se consiga interagir
     * @param xpath localizador do elemento no formato xpath
     * @return
     */
    public boolean verificarPresencaElementoOculto(String xpath) {
        return verificarPresencaElemento(new By.ByXPath(xpath));
    }

    /**
     * Retornar atributo de elemento (ex.: texto, label)
     * que é visto na tela, mas não se consiga interagir (problema comum em android)
     * ou atributo visible é igual a false (problema comum em ios)
     * @param xpathElemento localizador do elemento no formato xpath
     * @param atributo atributo do elemento a ser retornado
     * @return
     */
    public String retornarAtributoElementoOculto(String xpathElemento, String atributo) {
        String result = "";
        long startTime = System.currentTimeMillis();
        while (result != null && result.isEmpty() && (System.currentTimeMillis() - startTime) < 30 * 1000) {
            result = evaluateXPathAttribute(getDriver().getPageSource(), xpathElemento, atributo);
        }
        if (result == null || result.isEmpty()) {
            throw new NullPointerException(String.format("Não foi possível encontrar elemento: %s", xpathElemento));
        }
        return result;
    }

    /**
     * Chama evaluateXPath pegando o xpath do elemento em questão e retornar o valor do atributo passado como parâmetro
     * @param attribute
     * @return
     */
    protected String evaluateXPathAttribute(String page, String xpath, String attribute) {
        List<String> results;
        Document document = getDocument(page);
        String xpathAttribute = xpath + "/@" + attribute;
        results = evaluateXPath(document, xpathAttribute);
        if (results.size() == 0) {
            return null;
        }
        return results.get(0);
    }

    /**
     * Retorna lista de valores dos nós encontrados no documento passado o xpath do elemento/atributo
     * @param document
     * @param xpathExpression
     * @return
     */
    protected List<String> evaluateXPath(Document document, String xpathExpression) {
        try {
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            List<String> values = new ArrayList<>();
            try {
                XPathExpression expr = xpath.compile(xpathExpression);
                NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

                for (int i = 0; i < nodes.getLength(); i++) {
                    values.add(nodes.item(i).getNodeValue());
                }
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            return values;
        } catch (Exception e) {
            throw new NullPointerException(e.toString());
        }
    }

    /**
     * Retornar objeto Document dado xml da fonte da página
     * @param xml
     * @return
     */
    protected Document getDocument(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            throw new NullPointerException(e.toString());
        }
    }
}
