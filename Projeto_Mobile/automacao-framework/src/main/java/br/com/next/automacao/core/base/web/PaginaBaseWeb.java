package br.com.next.automacao.core.base.web;

import br.com.next.automacao.core.base.PaginaNext;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A página base contém os métodos que instrumentam a tela do
 * dispositivo em teste
 *
 * @author Fernando Angelin
 * @since 2020-07
 */
public class PaginaBaseWeb extends PaginaNext {

    /**
     * Construtor da página base.
     * Seta o tipo de evidência como WEB (Para o método de screenshot)
     */
    public PaginaBaseWeb(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * @param elemento Estratégia para encontrar e clicar em elemento.
     */
    protected <T> void clicarElementoSeExistir(T elemento, String mensagemErro) throws Exception {
        Date d1= Calendar.getInstance().getTime();
        try {
            retornaElemento(elemento).click();
        } catch(ElementClickInterceptedException excecao) {
            try{
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", retornaElemento(elemento));
            }catch(NoSuchElementException excessaoNext){
                return;
            }catch(Exception excecaoJavaScript){
                throw new NextException( this, mensagemErro, excecaoJavaScript);
            }
        }catch(NoSuchElementException excessaoNext){
            return;
        } catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * @param elemento Estratégia para encontrar e clicar em elemento.
     */
    protected <T> void clicarElemento(T elemento, String mensagemErro) throws Exception {
        Date d1= Calendar.getInstance().getTime();
        try {
            retornaElemento(elemento).click();
        } catch(ElementClickInterceptedException excecao) {
            try{
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", retornaElemento(elemento));
            }catch(NoSuchElementException excessaoNext){
                throw new NextException(this, excessaoNext.getMessage(), excessaoNext);
            }catch(Exception excecaoJavaScript){
                throw new NextException( this, mensagemErro, excecaoJavaScript);
            }
        }catch(NoSuchElementException excessaoNext){
            throw new NextException(this, excessaoNext.getMessage(), excessaoNext);
        } catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * @param elemento Estratégia para encontrar e deixar o ponteiro do mouse em cima do elemento.
     */
    protected <T> void flutuarElemento(T elemento, String mensagemErro) throws Exception {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(retornaElemento(elemento));
            actions.perform();
        } catch(NoSuchElementException excessaoNext){
            throw new NextException(this, excessaoNext.getMessage(), excessaoNext);
        } catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex);
        }
    }

    /**
     * @param elemento Estratégia para encontrar a caixa de texto.
     * @param texto    Texto para inserção.
     */
    protected <T> void digitarTexto(T elemento, String texto, String mensagemErro) throws Exception {
        Date d1= Calendar.getInstance().getTime();
        try {
            clicarElemento( elemento, mensagemErro );
            retornaElemento(elemento).sendKeys( texto );
        } catch(NoSuchElementException excessaoNext){
            throw new NextException(this, excessaoNext.getMessage(), excessaoNext);
        } catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * @param texto valor a ser clicado.
     */
    protected void clicarTexto(String texto, String mensagemErro) throws Exception {
        Date d1= Calendar.getInstance().getTime();
        try {
            driver
                    .findElement( By.xpath( "//*[contains(@text(),'" + texto + "')]" ) )
                    .click();
        } catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * @param elemento Estratégia para encontrar combobox.
     * @param valor    opção da combobox para clique.
     */
    protected <T> void clicarTextoComboBox(T elemento, String valor, String mensagemErro) throws Exception {
        Date d1= Calendar.getInstance().getTime();
        try {
            retornaElemento(elemento).click();
            clicarTexto( valor, mensagemErro );
        } catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex);
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * @param elemento Estratégia para rolar até o elemento.
     */
    protected <T> void rolarAteElemento(T elemento, String mensagemErro) throws Exception {

        Date d1= Calendar.getInstance().getTime();
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(retornaElemento(elemento));
            actions.perform();
        }  catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex );
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * Volta para a página anterior pelo driver
     */
    protected void voltarPaginaAnterior() {
        driver.navigate().back();
    }


    /**
     * Avançar para a próxima página com referência ao histórico do navegador pelo driver
     */
    protected void avançarPagina() {
        driver.navigate().forward();
    }


    /**
     * Atualizar página pelo driver
     */
    protected void atualizarPagina() {
        driver.navigate().refresh();
    }


    /**
     * Fechar aba do navegador
     */
    protected void fecharAba() { driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w"); }

    @Override
    protected List<WebElement> retornarLista(By by, String mensagemErro) throws NextException {
        return (List<WebElement>) super.retornarLista(by, mensagemErro);
    }

    /**
     * Selecionar opção Combobox
     *
     * @param elemento     Localizador do elemento combobox no topo
     * @param opcao        O texto da opção a ser selecionado
     * @param mensagemErro ensagem de erro em caso de falha
     * @param <T>
     * @throws Exception
     */
        protected <T> void digitarSelecionarTextoCombobox(T elemento, String opcao, String mensagemErro) throws NextException {

            Date d1= Calendar.getInstance().getTime();
            WebElement element = null;
            boolean sucesso = false;

            long inicio = System.currentTimeMillis();
            while (System.currentTimeMillis() - inicio < 30*1000) {
                try {

                    if (elemento instanceof By)
                        element = new WebDriverWait(driver, 5L)
                                .until(ExpectedConditions.elementToBeClickable((By)(elemento)));
                    else
                        element = new WebDriverWait(driver, 5L)
                                .until(ExpectedConditions.elementToBeClickable((WebElement)(elemento)));

                    if (element == null) continue;
                    element.click();
                    element.sendKeys(opcao.trim());
                    WebElement elementoOpcao = new WebDriverWait(driver, 5L)
                            .until(ExpectedConditions
                                    .presenceOfElementLocated(By.xpath("//*[text() = '" + opcao.trim() + "']")));
                    if (elementoOpcao != null) {
                        elementoOpcao.click();
                        sucesso = true;
                        break;
                    }

                } catch (Exception e) {

                }

                if (!sucesso) {
                    OperadorEvidencia.logarPasso("*Não foram retornadas opções no combo. Tentando novamente...");
                    element.click();
                    element.sendKeys(Keys.END);
                    for (int i = 0; i < opcao.length() * 2; i++)
                        element.sendKeys(Keys.BACK_SPACE);
                }
            }

            if (!sucesso) {
                try {
                    throw new Exception("Falha na utilização do seletor combo.");
                } catch (Exception e) {
                    throw new NextException(e.getMessage(), e);
                }
            }
            Date d2= Calendar.getInstance().getTime();
            int diff = diferencaHoras(d1,d2);
            OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * Selecionar opção Combobox
     *
     * @param elemento     Localizador do elemento combobox no topo
     * @param opcao        O texto da opção a ser selecionado
     * @param mensagemErro ensagem de erro em caso de falha
     * @param <T>
     * @throws Exception
     */
    protected <T> void selecionarTextoCombobox(T elemento, String opcao, String mensagemErro) throws NextException {

        Date d1= Calendar.getInstance().getTime();
        try {
            long inicio = System.currentTimeMillis();
            while (System.currentTimeMillis() - inicio < 30*1000) {
                WebElement element = new WebDriverWait(driver, 1L)
                        .until(ExpectedConditions.visibilityOf(retornaElemento(elemento)));
                try {
                    if (element == null) continue;
                    element.click();
                } catch (Exception ignore) {
                    continue;
                }
                WebElement elementoOpcao = new WebDriverWait(driver, 5L)
                        .until(ExpectedConditions
                                .elementToBeClickable(By.xpath("//*[text()='" + opcao.trim() + "']")));
                if (elementoOpcao == null) continue;
                elementoOpcao.click();
                break;
            }
        }  catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex );
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * Selecionar opção Combobox
     *
     * @param elemento     Localizador do elemento combobox no topo
     * @param <T>
     * @throws Exception
     */
    protected <T> void aguardarElementoClicavel(T elemento) throws NextException {

        Date d1= Calendar.getInstance().getTime();
        try {
            aguardarCarregamentoElemento(elemento);
            new WebDriverWait(driver, 30L)
                    .until(ExpectedConditions.elementToBeClickable(retornaElemento(elemento)));
        } catch (Exception ex) {
            Reporter.log(ex.getMessage(), true );
        }
        Date d2= Calendar.getInstance().getTime();
        int diff = diferencaHoras(d1,d2);
        OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
    }

    /**
     * Rolar até encontrar elemento e centralizar na página
     *
     * @param elemento     Localizador do elemento a ser encontrado e centralizado
     * @param <T>
     * @throws Exception
     */
    public <T> void rolarParaBaixoAteElemento(T elemento) {

        Date d1= Calendar.getInstance().getTime();
        WebElement element = null;


        final double fatorRolagem = 0.20; // 20% da tela visível
        final int esperaEntreRolagens = 1; // 1 segundo
        final double rolagem = driver.manage().window().getSize().height * fatorRolagem; // qtde pixels
        final int passoRolagem = 7; // quantidade mínima de pixels a rolar

        long inicio = System.currentTimeMillis();
        long tempoDecorrido = 0;
        WebElement webElement = null;
        externo: while (tempoDecorrido < 30*1000) {

            /*
            Caso o elemento seja encontrado...
             */
            try {
                if (elemento instanceof By)
                    element = new WebDriverWait(driver, esperaEntreRolagens)
                            .until(ExpectedConditions.presenceOfElementLocated((By) elemento));
                else
                    element = new WebDriverWait(driver, esperaEntreRolagens)
                            .until(ExpectedConditions.visibilityOf((WebElement) elemento));

                if (element != null) {
                    inicio = System.currentTimeMillis();
                    while (System.currentTimeMillis() - inicio < 30*1000) {
                        /*
                        Ao ser encontrado, o elemento é centralizado.
                        */
                        try {
                            rolarJs(element);
                            break externo;
                        } catch (Exception e) {
                            Thread.sleep(1000);
                        }
                    }

                }

            } catch (Exception ignore) {

            }

            tempoDecorrido = System.currentTimeMillis() - inicio;

            /*
            Rolar a quantidade de pixels calculada pelo fator de rolagem, sendo cada rolagem de 'passoRolagem' pixels
             */
            for (int i = 0; i <= rolagem + passoRolagem; i = i + passoRolagem) {
                try {
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + passoRolagem + ");");
                } catch (Exception ignore) {

                }
            }

            Date d2= Calendar.getInstance().getTime();
            int diff = diferencaHoras(d1,d2);
            OperadorEvidencia.logarPassoCompleto(getNomeMetodoClasse(), getNomeMetodo(), diff);
        }
    }

    /**
     * @param elemento que terá a borda realçada para a cor vermelha
     */
    private <T> void rolarJs(WebElement elemento){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\"});", elemento);
    }

    /**
     * @param elemento que terá a borda realçada para a cor vermelha
     */
    private <T> void realcaElementoVermelho(WebDriver driver, T elemento){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", elemento);
    }

    /**
     * @param elemento que terá a borda realçada para a cor amarela
     */
    private <T> void realcaElementoAmarelo(WebDriver driver, T elemento){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid yellow'", elemento);
    }

    /**
     * @param elemento que terá a borda realçada para a cor azul
     */
    private <T> void realcaElementoAzul(WebDriver driver, T elemento){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid blue'", elemento);
    }

    /**
     * @param elemento que terá a borda realçada para a cor verde
     */
    private <T> void realcaElementoVerde(WebDriver driver, T elemento){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid green'", elemento);
    }

    /**
     * @param elemento que terá a borda realçada para a cor laranja
     */
    private <T> void realcaElementoLaranja(WebDriver driver, T elemento){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid orange'", elemento);
    }

    /**
     * @param elemento que terá a borda resetada
     */
    private <T> void limpaRealceElemento(WebDriver driver, T elemento){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border=''", elemento);
    }

    /**
     * Método para selecionar a cor da borda do lemenento
     */
    private <T> void selecionaCor(String cor, T elemento){
        switch (cor) {
            case "vermelho":
                realcaElementoVermelho(driver, elemento);
                break;
            case "azul":
                realcaElementoAzul(driver, elemento);
                break;
            case "amarelo":
                realcaElementoAmarelo(driver, elemento);
                break;
            case "verde":
                realcaElementoVerde(driver, elemento);
                break;
            default:
                realcaElementoLaranja(driver, elemento);
                break;
        }
    }


    /**
     * @param elemento Estratégia para realçar elemento, aplicando borda ao elemento que sofrerá a interação.
     */
    protected <T> void realcarElemento(T elemento, String cor, String mensagemErro) throws Exception {
        try {
            selecionaCor(cor, retornaElemento(elemento));
        }  catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex );
        }
    }

    /**
     * @param elemento Estratégia para realçar elemento, aplicando borda ao elemento que sofrerá a interação.
     */
    protected <T> void limparRealceElemento(T elemento, String mensagemErro) throws Exception {
        try {
            limpaRealceElemento(driver, retornaElemento(elemento));
        } catch (Exception ex) {
            throw new NextException( this, mensagemErro, ex );
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

}