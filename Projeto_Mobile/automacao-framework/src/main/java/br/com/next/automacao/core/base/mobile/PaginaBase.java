package br.com.next.automacao.core.base.mobile;

import br.com.next.automacao.core.base.PaginaNext;
import br.com.next.automacao.core.constantes.AtributoElemento;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.ParentescoElemento;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.NextEvidencia;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static br.com.next.automacao.core.base.TesteBase.getEvidencia;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;


/**
 * A p�gina base cont�m os m�todos que instrumentam a tela do
 * dispositivo em teste
 *
 * @author Lucas Santos
 * @since 2019-11
 */
public class PaginaBase extends PaginaNext {

    protected final boolean android;
    protected final boolean ios;
    private AcoesToqueTela acoes;

    /**
     * Construtor da p�gina base.
     * Seta o tipo de evid�ncia como MOBILE (Para o m�todo de screenshot)
     */
    public PaginaBase(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        android = this.driver instanceof AndroidDriver;
        ios = !android;
        acoes = new AcoesToqueTela();
    }

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "breadcrumb")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ajustes\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'Tela de In�cio')]//XCUIElementTypeImage")
    protected MobileElement breadcrumb;

    @Override
    protected <T> MobileElement retornaElemento(T localizador) throws NextException {
        return (MobileElement) super.retornaElemento(localizador);
    }

    @Override
    protected <T> MobileElement retornaElemento(T localizador, int tempo) throws NextException {
        return (MobileElement) super.retornaElemento(localizador, tempo);
    }

    /**
     * Captura e retorna as dimens�es da tela
     *
     * @return Dimens�es da Tela
     */
    protected Dimension retornaDimensaoTela() {
        return acoes.dimensaoTela;
    }

    /**
     * Realiza a rolagem completa da tela para cima (topo)
     */
    protected void rolaTelaCima() {
        acoes.rolarTela(10,90);
    }

    /**
     * Realiza a rolagem completa da tela para baixo (fundo)
     */
    protected void rolaTelaBaixo() {
        acoes.rolarTela(90,10);
    }

    /**
     * @param elemento Estrat�gia para rolar tela para baixo e encontrar o elemento.
     *                 Se o elemento n�o estiver em tela, lancar� a mensagem de erro.
     */
    protected <T> void rolarTelaParaBaixoAosPoucosAteEncontrarElemento(T elemento, String mensagemErro) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, mensagemErro, 10);
    }

    /**
     * @param elemento Estrat�gia para rolar tela para baixo e encontrar o elemento.
     *                 Se o elemento n�o estiver em tela, lancar� a mensagem de erro.
     */
    protected <T> void rolarTelaParaBaixoAosPoucosAteEncontrarElemento(T elemento, String mensagemErro, int quantidadeMaximaTentativas) throws Exception {
        Date d1= Calendar.getInstance().getTime();
        try{
            this.moverTelaAteEncontrarElemento(elemento, Direcao.ABAIXO,30, 70,50, quantidadeMaximaTentativas);
        }catch(NoSuchElementException excecaoNaoEncontrada){
            throw new NextException(this, excecaoNaoEncontrada.getMessage(), excecaoNaoEncontrada);
        }catch(Exception excecao){
            throw new NextException(this, mensagemErro, excecao);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * @param elemento Estrat�gia para rolar tela para cima e encontrar o elemento.
     *                 Se o elemento n�o estiver em tela, lancar� a mensagem de erro.
     */
    protected <T> void rolarTelaParaCimaAosPoucosAteEncontrarElemento(T elemento, String mensagemErro) throws Exception {
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(elemento, mensagemErro, 10);
    }

    /**
     * @param elemento Estrat�gia para rolar tela para cima e encontrar o elemento.
     *                 Se o elemento n�o estiver em tela, lancar� a mensagem de erro.
     */
    protected <T> void rolarTelaParaCimaAosPoucosAteEncontrarElemento(T elemento, String mensagemErro, int quantidadeMaximaTentativas) throws Exception {
        Date d1= Calendar.getInstance().getTime();
        try{
            this.moverTelaAteEncontrarElemento(elemento, Direcao.ACIMA,30, 70, 50, quantidadeMaximaTentativas);
        }catch(NoSuchElementException excecaoNaoEncontrada){
            throw new NextException(this, excecaoNaoEncontrada.getMessage(), excecaoNaoEncontrada);
        }catch(Exception excecao){
            throw new NextException(this, mensagemErro, excecao);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * Rolar Tela at� o in�cio
     */
    protected void rolarTelaAteInicio() {
        for (int i = 0; i < 4; i++) {
            acoes.rolarTela(20, 80);
        }
    }

    /**
     * Rolar Tela at� o in�cio
     */
    protected void rolarTelaAteInicio(int iteracoes) {
        for (int i = 0; i < iteracoes; i++) {
            acoes.rolarTela(20, 80);
        }
    }

    /**
     * Rolar Tela at� o final
     */
    protected void rolarTelaAteFinal() {
        for (int i = 0; i < 4; i++) {
            acoes.rolarTela(80, 20);
        }
    }

    /**
     * Rolar Tela at� o final
     */
    protected void rolarTelaAteFinal(int iteracoes) {
        for (int i = 0; i < iteracoes; i++) {
            acoes.rolarTela(80, 20);
        }
    }

    /**
     * Realiza a rolagem vertical da tela, dado a posi��o
     * de in�cio e ai posi��o final.
     *
     * @param inicio Propor��o inicial
     * @param fim    Propor��o Final
     */
    protected void rolarTela(double inicio, double fim) {
        int proporcionalInicio = (int) (inicio * 100);
        int proporcionalFim = (int) (fim * 100);
        acoes.rolarTela(proporcionalInicio, proporcionalFim);
    }

    /**
     * Desliza elemento horizontalmente
     * @param elemento
     * @param proporcionalInicial - posi��o inicial em porcentagem da tela
     * @param proporcionalFinal - posi��o final em porcentagem da tela
     * @param <T>
     * @throws NextException
     */
    protected <T> void deslizar(T elemento, double proporcionalInicial, double proporcionalFinal) throws NextException {
        boolean inicioMaiorQueFim = proporcionalInicial > proporcionalFinal;
        deslizar(elemento,
                 inicioMaiorQueFim ? Direcao.ESQUERDA : Direcao.DIREITA,
                (int) (inicioMaiorQueFim ? proporcionalFinal * 100 : proporcionalInicial * 100),
                (int) (inicioMaiorQueFim ? proporcionalInicial * 100 : proporcionalFinal * 100));
    }

    /**
     * Desliza elemento horizontalmente
     * @param elemento
     * @param direcao
     * @param proporcionalMinimo
     * @param proporcionalMaximo
     * @param <T>
     * @throws NextException
     */
    protected <T> void deslizar(T elemento,Direcao direcao,  int proporcionalMinimo, int proporcionalMaximo) throws NextException {
        Date d1= Calendar.getInstance().getTime();
        try {
            MobileElement elementoMobile = retornaElemento(elemento);
            int pivo = elementoMobile.getLocation().getY() * 100 / retornaDimensaoTela().getHeight();
            try {
                acoes.moverTela(direcao,pivo,proporcionalMinimo,proporcionalMaximo);
            }catch(Exception ignore){}
        }  catch (Exception e) {
            throw new NextException(this, e.getMessage(), e);
        }

        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * Desliza tela device na dire��o horizontal
     * @param direcao - dire��o do movimento em tela
     * @param xProporcionalMaximo - maior posi��o percentual da �rea de a��o do movimento
     * @param xProporcionalMinimo - menor posi��o percentual da �rea de a��o do movimento
     */
    protected void deslizar(Direcao direcao, int xProporcionalMinimo, int xProporcionalMaximo) throws Exception {
        /*
        500 era o padr�o do framework antes de criar o m�todo
        sobrecarregado com todos os par�metros, incluindo 'tempo':
        protected void deslizar(double inicio, double fim, int tempo)
         */
        deslizar(direcao, xProporcionalMinimo, xProporcionalMaximo, 500);
    }

    /**
     * Desliza tela device na dire��o horizontal
     * @param direcao - dire��o do movimento em tela
     * @param xProporcionalMaximo - maior posi��o percentual da �rea de a��o do movimento
     * @param xProporcionalMinimo - menor posi��o percentual da �rea de a��o do movimento
     * @param tempo - tempo da a��o em milisegundos
     */
    protected void deslizar(Direcao direcao, int xProporcionalMinimo, int xProporcionalMaximo, int tempo) throws Exception{
        try{
            acoes.deslizarTela(direcao, xProporcionalMinimo, xProporcionalMaximo, tempo);
        }catch(Exception e){
            throw new NextException(this,e.getMessage(),e);
        }
    }

    /**
     * M�todo desliza a tela para a dire��o para a esquerda at� encontrar elemento desejado
     * @param localizador - estrat�gia para localiza��o do elemento
     * @param proporcionalMinimo - menor posi��o percentual da �rea de a��o do movimento
     * @param proporcionalMaximo - maior posi��o percentual da �rea de a��o do movimento
     * @param proporcionalPivo - posi��o percentual referente a altura em tela do movimento
     * @param maximoTentativas - n�mero m�ximo de tentativas para encontrar o elemento
     * @param <T>
     */
    protected <T> void deslizarTelaParaEsquerdaEmBuscaDeElemento(T localizador, int proporcionalMinimo, int proporcionalMaximo, int proporcionalPivo, int maximoTentativas){
        try{
            moverTelaAteEncontrarElemento(localizador,
                    Direcao.ESQUERDA,
                    proporcionalMinimo,
                    proporcionalMaximo,
                    proporcionalPivo,
                    1,
                    200,
                    maximoTentativas);
        }catch(NoSuchElementException ignore){ }
    }

    /**
     * M�todo desliza a tela para a dire��o para a direita at� encontrar elemento desejado
     * @param localizador - estrat�gia para localiza��o do elemento
     * @param proporcionalMinimo - menor posi��o percentual da �rea de a��o do movimento
     * @param proporcionalMaximo - maior posi��o percentual da �rea de a��o do movimento
     * @param proporcionalPivo - posi��o percentual referente a altura em tela do movimento
     * @param maximoTentativas - n�mero m�ximo de tentativas para encontrar o elemento
     * @param <T>
     */
    protected <T> void deslizarTelaParaDireitaEmBuscaDeElemento(T localizador, int proporcionalMinimo, int proporcionalMaximo, int proporcionalPivo, int maximoTentativas){

        try{
            moverTelaAteEncontrarElemento(localizador,
                    Direcao.DIREITA,
                    proporcionalMinimo,
                    proporcionalMaximo,
                    proporcionalPivo,
                    1,
                    200,
                    maximoTentativas);
        }catch(NoSuchElementException ignore){ }
    }


    /**
     * M�todo para move a tela em direcao determinada at� encontrar elemento procurado
     * @param localizador - localizador referente ao elemento (By, MobileBy ou MobileElement)
     * @param direcao - ACIMA, ABAIXO, DIREITA, ESQUERDA
     * @param proporcionalPivo - posi��o(em x ou em y) a ser mantida fixa no movimento em porcentagem de dimens�o da tela
     * @param quantidadeMaximaTentativas quantidade m�xima de tentativas
     * @throws Exception
     */
    private <T> void moverTelaAteEncontrarElemento(T localizador,
                                                   Direcao direcao,
                                                   int proporcionalMinimo,
                                                   int proporcionalMaximo,
                                                   int proporcionalPivo,
                                                   int quantidadeMaximaTentativas) {

        moverTelaAteEncontrarElemento(localizador,
                direcao,
                proporcionalMinimo,
                proporcionalMaximo,
                proporcionalPivo,
                1,
                200,
                quantidadeMaximaTentativas);
    }

    /**
     * M�todo para deslizar tela at� encontrar elemento procurado
     * @param localizador - localizador referente ao elemento (By, MobileBy ou MobileElement)
     * @param direcao - ACIMA, ABAIXO, DIREITA, ESQUERDA
     * @param proporcionalMinimo - posi��o m�nima da a��o em porcentagem da dimens�o da tela
     * @param proporcionalMaximo - posi��o m�xima da a��o em porcentagem da dimens�o da tela
     * @param proporcionalPivo - posi��o(em x ou em y) a ser mantida fixa no movimento em porcentagem de dimens�o da tela
     * @param tempoTimeOut - tempo em milisegundos para a execu��o da a��o
     * @param tempoSleep - tempo em milissegundos de sleep
     * @param quantidadeMaximaTentativas - quantidade m�xima de tentativas para encontrar
     * @throws Exception
     */
    private <T> void moverTelaAteEncontrarElemento(T localizador,
                                                     Direcao direcao,
                                                     int proporcionalMinimo,
                                                     int proporcionalMaximo,
                                                     int proporcionalPivo,
                                                     int tempoTimeOut,
                                                     int tempoSleep,
                                                     int quantidadeMaximaTentativas){

        for(int i = 0; i < quantidadeMaximaTentativas; i++){
            if(aguardarVisibilidadeElemento(localizador, tempoTimeOut, tempoSleep)){
                OperadorEvidencia.logarPasso("Elemento " + localizador + " encontrado");
                return;
            }
            try {
                acoes.moverTela(direcao,proporcionalPivo,proporcionalMinimo,proporcionalMaximo);
            }catch(Exception ignore) { }
        }
        throw  new NoSuchElementException("O elemento " + localizador + " n�o foi encontrado ap�s " + quantidadeMaximaTentativas + " tentativas");
    }

    /**
     * M�todo desliza os elementos de um carrossel at� encontrar o valor desejado para atributo do elemento
     * @param localizador - localizador utilizado para o elemento
     * @param texto - valor esperado para o texto
     * @param direcao - direcao a deslizar o carrossel
     * @param mensagemErro - mensagem a ser devolvida quando o teste falhar nesse m�todo
     * @param <T> - Objeto do tipo By, MobileBy ou MobileElement
     * @throws Exception
     */
    public <T> void deslizarCarrosselAteEncontrarTexto(T localizador, String texto, Direcao direcao, int proporcionalMinimo, int proporcionalMaximo, String mensagemErro) throws Exception {
        deslizarCarrosselAteEncontrarAtributo(localizador, AtributoElemento.TEXTO, texto, direcao, proporcionalMinimo, proporcionalMaximo, mensagemErro);
    }

    /**
     * M�todo desliza os elementos de um carrossel at� encontrar o valor desejado para atributo do elemento
     * @param localizador - localizador utilizado para o elemento
     * @param atributo - atributo a ser analizado
     * @param valor - valor esperado para o atributo
     * @param direcao - direcao a deslizar o carrossel
     * @param mensagemErro - mensagem a ser devolvida quando o teste falhar nesse m�todo
     * @param <T> - Objeto do tipo By, MobileBy ou MobileElement
     * @throws Exception
     */
    public <T> void deslizarCarrosselAteEncontrarAtributo(T localizador,
                                                          AtributoElemento atributo,
                                                          String valor,
                                                          Direcao direcao,
                                                          int proporcionalMinimo,
                                                          int proporcionalMaximo,
                                                          String mensagemErro) throws Exception {
        try {
            String textoNormalizado = normalizaString(valor);
            MobileElement elemento = retornaElemento(localizador);
            int proporcionalPivo = elemento.getLocation().y * 100 /acoes.dimensaoTela.height;
            String mensagemErroAtributo = "N�o foi poss�vel recuperar o atributo " + atributo + " do elemento " + elemento;
            String textoCardCategoria;
            List<String> categoriasJaRoladas = new ArrayList<>();

            while (true) {
                textoCardCategoria = normalizaString(retornarAtributoElemento(elemento, atributo, mensagemErroAtributo));
                if(textoCardCategoria.contains(textoNormalizado)){
                    break;
                }else if (categoriasJaRoladas.contains(textoCardCategoria)) {
                    throw new NoSuchElementException(mensagemErro);
                }
                categoriasJaRoladas.add(textoCardCategoria);
                try {
                    acoes.moverTela(direcao,proporcionalPivo, proporcionalMinimo, proporcionalMaximo );
                }catch (Exception ignore){}
            }
        }catch(Exception excecao) {
            throw new NextException(this, excecao.getMessage(),excecao);
        }
    }

    /**
     * Realizar toque prolongado/manter pressionado elemento por tempo determinado
     *
     * @param localizador     Elemento ou seu localizador(BY)
     * @param duracao      Duracao em segundos do toque
     * @param mensagemErro Mensagem de erro em caso de falha
     * @param <T>          Elemento gen�rico
     */
    protected <T> void manterPressionado(T localizador, int duracao, String mensagemErro) throws NextException {
        Date d1= Calendar.getInstance().getTime();
        try {
            MobileElement elemento =  retornaElemento(localizador);
            acoes.pressionar(elemento,duracao);
        }catch(Exception excecao) {
            throw new NextException(this,mensagemErro,excecao);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * Realizar toque prolongado/manter pressionado uma coordenada
     * proporcional da tela por tempo determinado
     *
     * @param proporcaoX   Coordenada proporcional X
     * @param proporcaoY   Coordenada proporcional Y
     * @param duracao      Duracao em segundos do toque
     * @param mensagemErro Mensagem de erro em caso de falha
     * @throws Exception
     */
    protected void manterPressionado(int proporcaoX, int proporcaoY, int duracao, String mensagemErro) throws Exception {
        Date d1= Calendar.getInstance().getTime();
        try {
            acoes.pressionar(proporcaoX,proporcaoY,duracao);
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * Realiza toque na tela por coordenada
     * @param x
     * @param y
     */
    protected void tocarCoordenada(int x, int y){
        try{
            acoes.tocar(new Point(x,y));
        }catch (Exception ignore){}
    }

    /**
     * Realiza toque no elemento por suas coordenadas
     * @param localizador - elemento a ser tocado
     */
    protected <T> void tocarCoordenada(T localizador){
        try{
            acoes.tocar(retornaElemento(localizador).getLocation());
        }catch (Exception ignore){}
    }

    /**
     * Realiza toque por percentual de coordenada
     *
     * @param percentualX Propor��o do eixo X
     * @param percentualY Propor��o do eixo Y
     */
    protected void tocarCoordenadaProporcional(int percentualX, int percentualY) {
        try {
            acoes.tocar(percentualX, percentualY);
        }catch (Exception ignore){}
    }

    /**
     * Realiza toque por percentual de coordenada dentro de elemento
     *
     * @param elemento    elemento no qual acontecer� a a��o de toque
     * @param percentualX Propor��o do eixo X
     * @param percentualY Propor��o do eixo Y
     */
    protected <T> void tocarCoordenadaProporcional(T elemento, int percentualX, int percentualY) throws NextException {
        try {
            MobileElement elementoMobile = retornaElemento(elemento);
            try {
                acoes.tocar(elementoMobile,percentualX,percentualY);
            }catch(Exception ignore){}
        } catch (Exception e) {
            throw new NextException(this, e.getMessage(), e);
        }
    }

    /**
     * Arrasta um elemento de tela at� outro elemento, verticalmente
     *
     * @param origem  Elemento a ser arrastado
     * @param destino Elemento destino
     */
    protected <T> void arrastarElemento(T origem, T destino) throws NextException {
        try {
            MobileElement elementoOrigem = retornaElemento(origem);
            MobileElement elementoDestino = retornaElemento(destino);
            try {
                acoes.moverElemento(elementoOrigem, elementoDestino.getLocation(),500);
            }catch (Exception ignore){}
        }catch(Exception exception) {
            throw new NextException(this, "Erro ao arrastar elemento " + origem + " para a posi��o do elemento " + destino, exception);
        }
    }

    /**
     * Estrat�gia para arrastar elementos em qualquer dire��o e quantidade de pixels
     * @param localizador - estrat�gia para localizar elemento (By, MobileBy, MobileElement)
     * @param direcao - dire��o a movimentar o elemento
     * @param deslocamento - deslocamento proporcional desejada para o elemento
     * @param duracaoMilisegundos - dura��o da a��o em milisegundos
     */
    protected <T> void arrastarElemento(T localizador, int duracaoMilisegundos, int deslocamento, Direcao direcao) throws NextException {
        try {
            MobileElement elemento = retornaElemento(localizador);
            try {
                acoes.moverElemento(elemento,deslocamento,direcao,duracaoMilisegundos);
            }catch(Exception ignore) { }
        } catch (Exception e) {
            throw new NextException(this, e.getMessage(), e);
        }
    }

    /**
     * Arrasta um elemento de tela at� posi��o desejada
     *
     * @param origem        Elemento a ser arrastado
     * @param proporcionalX posi��o horizontal proporcional de destino
     * @param proprocionalY posi��o vertical proporcional de destino
     */
    protected <T> void arrastarElementoProporcional(T origem, int proporcionalX, int proprocionalY) throws NextException {
        arrastarElementoProporcional(origem, proporcionalX, proprocionalY, 500);
    }

    /**
     * Arrasta um elemento de tela at� posi��o desejada
     *
     * @param origem        Elemento a ser arrastado
     * @param proporcionalX posi��o horizontal proporcional de destino
     * @param proprocionalY posi��o vertical proporcional de destino
     * @param duracao       dura��o do toque em ms
     */
    protected <T> void arrastarElementoProporcional(T origem, int proporcionalX, int proprocionalY, int duracao) throws NextException {
        Date d1= Calendar.getInstance().getTime();
        try {
            MobileElement elemento = retornaElemento(origem);
            acoes.moverElemento(elemento, proporcionalX, proprocionalY, duracao);
        }catch(Exception exception){
            throw new NextException(this, exception.getMessage(), exception);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * Toca bot�o "ENTER" no teclado
     *
     * @param elemento     - Campo de texto em tela
     * @param mensagemErro - Mensagem de erro
     * @param <T>
     * @throws Exception
     */
    protected <T> void tocarBotaoENTERTeclado(T elemento, String mensagemErro) throws Exception {
        try {
            retornaElemento(elemento).sendKeys(Keys.ENTER);
        } catch(NoSuchElementException execaoNext){
            throw new NextException(this, execaoNext.getMessage(), execaoNext);
        }catch (Exception e) {
            throw new NextException(this, mensagemErro, e);
        }
    }

    /**
     * @param localizador Estrat�gia para encontrar elemento.
     * @return Retorna elemento encontrado.
     */
    @Override
    protected <T> MobileElement retornarElemento(T localizador, String mensagemErro) throws Exception {
        return (MobileElement) super.retornarElemento(localizador, mensagemErro);
    }


    /**
     * @param elemento          Estrat�gia para encontrar a caixa de texto.
     * @param texto             Texto para inser��o.
     * @param esconderTeclado   Decis�o pra uso do m�todo esconderTeclado.
     */
    protected <T> void escreverTexto(T elemento, String texto, Boolean esconderTeclado, String mensagemErro) throws NextException {
        try {
            MobileElement elementoMobile = retornaElemento(elemento);
            elementoMobile.click();
            if (ios){
                elementoMobile.setValue(texto);
                if (esconderTeclado){
                    esconderTeclado();
                }
            } else {
                if (esconderTeclado) {
                    esconderTeclado();
                }
                elementoMobile.sendKeys(texto);
            }
        } catch(NoSuchElementException execaoNext){
            throw new NextException(this, execaoNext.getMessage(), execaoNext);
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
    }

    /**
     * @param elemento Estrat�gia para encontrar a caixa de texto.
     * @param texto    Texto para inser��o.
     */
    protected <T> void escreverTexto(T elemento, String texto, String mensagemErro) throws NextException {
        Date d1= Calendar.getInstance().getTime();
        try {
            MobileElement elementoMobile = retornaElemento(elemento);
            elementoMobile.click();
            if(ios){
                elementoMobile.setValue(texto);
                esconderTeclado();
            } else {
                esconderTeclado();
                elementoMobile.sendKeys(texto);
            }
        } catch(NoSuchElementException execaoNext){
            throw new NextException(this, execaoNext.getMessage(), execaoNext);
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo() + " [" + elemento + "]", diff);
    }

    /**
     * M�todo para esconder teclado
     */
    protected void esconderTeclado(){
        new Teclado().esconderTeclado();
    }

    /**
     * M�todo para esconder teclado elemento
     * @param localizador
     * @param <T>
     */
    protected <T> void esconderTeclado(T localizador){
        Date d1= Calendar.getInstance().getTime();
        Teclado teclado = new Teclado();
        teclado.esconderTeclado();
        if(teclado.tecladoPresente()){
            try{
                retornaElemento(localizador,1).sendKeys(Keys.ENTER);
            }catch (Exception ignore){}
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo() + " [" + localizador + "]", diff);
    }

    /**
     * @param elemento Estrat�gia para encontrar elemento clic�vel.
     */
    protected <T> void tocarElemento(T elemento, String mensagemErro) throws NextException {
        try {
            Date d1= Calendar.getInstance().getTime();
            retornaElemento(elemento).click();
            Date d2= Calendar.getInstance().getTime();

            int diff = diferencaHoras(d1,d2);
            OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo() + " [" + elemento + "]", diff);
        } catch(NoSuchElementException excessaoNaoEncontrado){
            throw new NextException(this, excessaoNaoEncontrado.getMessage(), excessaoNaoEncontrado);
        }catch (Exception e) {
            throw new NextException(this, mensagemErro, e);
        }
    }

    /**
     * @param elemento Estrat�gia para encontrar elemento clic�vel.
     */
    protected <T> void tocarElementoSeExistir(T elemento, String mensagemErro) throws NextException {
        try {
            retornaElemento(elemento).click();
        } catch(NoSuchElementException excessaoNaoEncontrado){
            return;
        }catch (Exception e) {
            throw new NextException(this, mensagemErro, e);
        }
    }

    /**
     * @param texto valor a ser clicado.
     */
    protected void tocarTexto(String texto, String mensagemErro) throws Exception {
        try {
            driver.findElement(By.xpath("//*[contains(@text,'" + texto + "')]")).click();
        } catch (Exception ex) {
            throw new NextException(this, mensagemErro, ex);
        }
    }

    /**
     * Volta para a tela anterior pelo driver
     */
    protected void voltarTelaAnterior() {
        driver.navigate().back();
    }

    /**
     * M�todo utiliza mapeamento por tipo e coordenada para localizar elemento parente [following-sibling(PROXIMO_IRMAO),
     * preceding-sibling(IRMAO_ANTECESSOR), parent(PAI), ancestor(ANCESTRAL) ] via xpath
     *
     * @param elemento   - Elemento em tela a partir do qual ser� encontrado o elemento parente
     * @param xpath      - String com xpath do elemento parente no formato - "type[@atributo = \"valorAtributo\"]"
     * @param parentesco - Enum dos poss�veis parentescos encontrados via xpath (following-sibling, preceding-sibling, parente, ancestor)
     * @return elementoParente - elemento do tipo MobileElement, encontrado via grau de parentesco por xpath
     * @throws Exception
     */
    protected <T> MobileElement retornarElementoParente(T elemento, String xpath, ParentescoElemento parentesco) throws Exception {
        //O m�todo utiliza as coordenadas e tipo do elemento original para montar o xpath, pois os m�todos nativos n�o
        //funcionaram para encontrar elementos parentes via xpath a partir do elemento original
        try{
            MobileElement elementoParente,elementoPrincipal;
            elementoPrincipal = retornaElemento(elemento);
            int x = elementoPrincipal.getLocation().getX();
            int y = elementoPrincipal.getLocation().getY();
            String tipo = elementoPrincipal.getAttribute("type");
            switch (parentesco) {
                case PROXIMO_IRMAO:
                    elementoParente = retornarElemento(new By.ByXPath("//" + tipo + "[@x = " + x + " and @y = " + y + "]/following-sibling::" + xpath)
                            , "Erro ao recuperar elemento por grau de parentesco \"Pr�ximo Irm�o\"");
                    break;
                case IRMAO_ANTECESSOR:
                    elementoParente = retornarElemento(new By.ByXPath("//" + tipo + "[@x = " + x + " and @y = " + y + "]/preceding-sibling::" + xpath)
                            , "Erro ao recuperar elemento por grau de parentesco \"Irm�o Antecessor\"");
                    break;
                case PAI:
                    elementoParente = retornarElemento(new By.ByXPath("//" + tipo + "[@x = " + x + " and @y = " + y + "]/parent::" + xpath)
                            , "Erro ao recuperar elemento por grau de parentesco \"Pai\"");
                    break;
                case ANCESTRAL:
                    elementoParente = retornarElemento(new By.ByXPath("//" + tipo + "[@x = " + x + " and @y = " + y + "]/ancestor::" + xpath)
                            , "Erro ao recuperar elemento por grau de parentesco \"Ancestral\"");
                    break;
                default:
                    elementoParente =  elementoPrincipal;
            }
            return elementoParente;
        }catch(Exception exception){
            throw new NextException(this,exception.getMessage(),exception);
        }
    }

    @Override
    protected List<MobileElement> retornarLista(By by, String mensagemErro) throws NextException {
        return (List<MobileElement>) super.retornarLista(by, mensagemErro);
    }

    /**
     * M�todo retorna  ao App Next - apenas em Ios
     */
    protected void voltarAppIos(MobileElement breadcrumbCustomizado) throws Exception {
        if (ios) {
            MobileElement elemento = breadcrumbCustomizado != null ? breadcrumbCustomizado : breadcrumb;
            tocarElementoSeExistir(elemento, "N�o foi poss�vel voltar tocando o elemento breadcrumb do iOS");
        }
    }

    /**
     * M�todo retorna  ao App Next - apenas em Ios
     */
    protected void voltarAppIos() throws Exception {
        voltarAppIos(null);
    }

    /**
     * Executa o comando de voltar no android
     */
    protected void executarVoltarAndroid() {
        final  Integer BACK_KEY = 4;
        executar("input", "keyevent", BACK_KEY.toString());
    }

    /**
     * M�todo executa script Adbshell no driver com o comando informado
     * @param comando
     * @param argumentos
     * @return resultado do comando
     */
    private String executar(String comando, String... argumentos) {
        List<String> commandArgs = Arrays.asList(argumentos);
        Map<String, Object> executeCmd = ImmutableMap
                .of("command", comando, "args", commandArgs);

        return ((AndroidDriver) driver).executeScript("mobile: shell", executeCmd).toString();
    }

    /**
     * M�todo para retornar se o driver do Android ou iOS est� aceitando permiss�es automaticamente
     * @return
     */
    protected boolean usandoPermissoesAutomaticas() {

        if (android) {
            String autoGrantPermissions = ((AppiumDriver)driver).getCapabilities().asMap().get("autoGrantPermissions").toString();
            if (autoGrantPermissions != null) {
                if (autoGrantPermissions.equals("true"))
                    return true;
            }
        }

        return false;
    }

    /**
     * Classe interna � PaginaBase criada para organizar as a��es com o teclado
     * @author Matheus Lima Barbosa de Tulio
     * @since 11-2021
     * @version 4.0.2
     */
    class Teclado{

        private Teclado(){
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

        @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
        @iOSXCUITFindBy(xpath = "//*[translate(@label, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') = \"seguinte\"]")
        @iOSXCUITFindBy(id = "OK")
        @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') ='ok']")
        @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
        @iOSXCUITFindBy(accessibility = "Pr�ximo")
        @iOSXCUITFindBy(accessibility = "next")
        @iOSXCUITFindBy(accessibility = "Next")
        @iOSXCUITFindBy(xpath = "//*[contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz','ximo', 'next')]")
        @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') = \"search\"]")
        private MobileElement teclado;

        /**
         * M�todo retorna True se teclado presente e falso se teclado oculto
         * @return
         */
        boolean tecladoPresente(){
            return ios? ((IOSDriver<MobileElement>) driver).isKeyboardShown() : ((AndroidDriver) driver).isKeyboardShown();
        }

        /**
         * M�todo esconde teclado
         */
        void esconderTeclado(){
            try{
                if(ios && tecladoPresente()){
                    aguardarCarregamentoElemento(teclado);
                    teclado.click();
                }else{
                    ((AppiumDriver) driver).hideKeyboard();
                }
            }catch(Exception ignore){}
        }
    }


    public static String getNomeMetodoClasse() {
        try {
            Throwable thr = new Throwable(); thr.fillInStackTrace ();
            StackTraceElement[] ste = thr.getStackTrace();
            String classe = ste[2].getClassName();
            String[] classes = classe.split("\\.");
            classe = classes[classes.length-1];
            return classe +"."+ ste[2].getMethodName();
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

    @AndroidFindBy(xpath = "//*[@content-desc=\"Carregando\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"carregando\")]")
    private MobileElement iconeCarregando;


    /**
     * M�todo que aguarda o carregamento do tela
     * @return tempo da a��o de carregamento
     */
    protected void esperarCarregando() {
            aguardarOcultacaoElemento(iconeCarregando);
    }

    /**
     * Tocar em elemento
     * que � visto na tela, mas n�o se consiga interagir (problema comum em android)
     * ou atributo visible � igual a false (problema comum em ios)
     *
     * @param xpath localizador do elemento no formato xpath
     */
    protected void tocarElementoOculto(String xpath, String mensagemErro) throws NextException {
        try {
            Date d1= Calendar.getInstance().getTime();
            Point coord = retornarCoordElementoOculto(xpath);
            tocarCoordenada(coord.x, coord.y);
            Date d2= Calendar.getInstance().getTime();

            int diff = diferencaHoras(d1,d2);
            OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo() + " [" + xpath + "]", diff);
        } catch(NoSuchElementException excessaoNaoEncontrado){
            throw new NextException(this, excessaoNaoEncontrado.getMessage(), excessaoNaoEncontrado);
        }catch (Exception e) {
            throw new NextException(this, mensagemErro, e);
        }
    }

    /**
     * Verificar presen�a de elemento
     * que � visto na tela, mas n�o se consiga interagir (problema comum em android)
     * ou atributo visible � igual a false (problema comum em ios)
     * @param xpath localizador do elemento no formato xpath
     * @return
     */
    @Override
    public boolean verificarPresencaElementoOculto(String xpath) {
        try {
            retornarCoordElementoOculto(xpath);
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    /**
     * Retorna coordenadas do centro do elemento oculto
     * @param xpath
     * @return
     */
    private Point retornarCoordElementoOculto(String xpath) {
        String result = "";
        long startTime = System.currentTimeMillis();
        String bounds = "", xStart = "", yStart = "", width = "", height = "";
        while (result != null && result.isEmpty() && (System.currentTimeMillis() - startTime) < 30 * 1000) {
            String page = getDriver().getPageSource();
            if (android) {
                bounds = evaluateXPathAttribute(page, xpath, "bounds");
                result = bounds;
            } else {
                xStart = evaluateXPathAttribute(page, xpath, "x");
                yStart = evaluateXPathAttribute(page, xpath, "y");
                width = evaluateXPathAttribute(page, xpath, "width");
                height = evaluateXPathAttribute(page, xpath, "height");
                result = height;
            }
        }
        if (result == null || result.isEmpty()) {
            throw new NullPointerException(String.format("N�o foi poss�vel encontrar elemento: %s", xpath));
        }

        int x, y;
        if (android) {
            OperadorEvidencia.logarPasso(String.format("Elemento {%s} localizado com bounds: %s", xpath, bounds));

            String[] boundsToSplit = bounds.split("]\\[");
            String[] boundsStart = boundsToSplit[0].replace("[", "").split(",");
            String[] boundsEnd = boundsToSplit[1].replace("]", "").split(",");

            x = (Integer.parseInt(boundsStart[0]) + Integer.parseInt(boundsEnd[0])) / 2;
            y = (Integer.parseInt(boundsStart[1]) + Integer.parseInt(boundsEnd[1])) / 2;
        } else {
            OperadorEvidencia.logarPasso(String.format("Elemento {%s} localizado com x: %s, y: %s, width: %s, height: %s", xpath, xStart, yStart, width, height));
            x = Integer.parseInt(xStart) + Integer.parseInt(width) / 2;
            y = Integer.parseInt(yStart) + Integer.parseInt(height) / 2;
        }

        return new Point(x, y);
    }
}
