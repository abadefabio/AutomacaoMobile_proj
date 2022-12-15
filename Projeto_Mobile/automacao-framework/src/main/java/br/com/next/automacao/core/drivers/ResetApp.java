package br.com.next.automacao.core.drivers;

import br.com.next.automacao.core.constantes.driver.TipoExecucao;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static br.com.next.automacao.core.drivers.OperadorDriver.encerrarDriversNavegador;
import static java.util.Objects.isNull;

/*
Esta classe determina se um app e browser ser�o reiniciados no in�cio do pr�ximo teste.
� inicialmente alimentada pelo listener ao final de um teste com sucesso ou falha.
� consultada no in�cio de cada teste, para efetuar ou n�o um reset do app e browser.

Nota: decidir sobre o reset no *in�cio do teste* com base em um *teste anterior* � �til
para que um app ou browser n�o seja reiniciado antes do @AfterMethod de um caso de teste.

 */

public class ResetApp {

    public static ThreadLocal<Boolean> resetAppProximoTeste = new ThreadLocal<>();
    public static ThreadLocal<String> mensagemApp = new ThreadLocal<>();
    public static ThreadLocal<String> mensagemBrowser = new ThreadLocal<>();

    /**
     * Redefine as vari�veis da classe para cada suite
     */
    public static void redefinirResetAppSuite() {
        resetAppProximoTeste = new ThreadLocal<>();
        mensagemApp = new ThreadLocal<>();
        mensagemBrowser = new ThreadLocal<>();
    }

    /**
     * Normalmente utilizado pelo listener ao final de um teste,
     * este m�todo determina que um app ser� reiniciado.
     * @param resetApp
     */
    public static void setResetAppProximoTeste(boolean resetApp) {
        resetAppProximoTeste.set(resetApp);
    }

    /**
     * Consulta sobre se o app ser� reiniciado
     * @return
     */
    public static boolean isResetAppProximoTeste() {
        if (isNull(resetAppProximoTeste.get()))
            setResetAppProximoTeste(false);
        return resetAppProximoTeste.get();
    }


    /**
     * Criado m�todo com outro nome para n�o gerar confus�o:
     * Durante um teste, � poss�vel determinar se o app foi ressetado
     * com isResetAppProximoTeste(), mas seria melhor consultar
     * no passado: o app e browser foram ressetados?
     * Isto tamb�m mant�m compatibilidade com o isAppBrowserRessetado em OperadorDriver.
     * @return
     */
    public static boolean isAppBrowserRessetado() {
        return isResetAppProximoTeste();
    }

    /**
     * efetua a reinicializa��o do app
     */
    public static void decidirExecutarResetApp() {
        OperadorEvidencia.logarPasso(getMensagemApp());
        if (isResetAppProximoTeste())
            OperadorDriver.redefinirMobileDriver();
    }

    /**
     * efetua a reinicializa��o do browser
     */
    public static void decidirExecutarResetBrowser() {
        OperadorEvidencia.logarPasso(getMensagemBrowser());
        if (isResetAppProximoTeste())
            encerrarDriversNavegador();
    }

    /**
     * Define uma mensagem de log para quando o app for reiniciado.
     */
    public static void setMensagemApp(String mensagem) {
        mensagemApp.set(mensagem);
    }

    /**
     * Define uma mensagem de log para quando o browser for reiniciado.
     * @param mensagem
     */
    public static void setMensagemBrowser(String mensagem) {
        mensagemBrowser.set(mensagem);
    }

    /**
     * Obt�m a mensagem de reset do app
     * @return
     */
    public static String getMensagemApp() {
        if (isNull(mensagemApp.get()))
            mensagemApp.set("O app foi iniciado pela primeira vez neste grupo de teste");
        return mensagemApp.get();
    }

    /**
     * Obt�m a mensagem de reset de browser
     * @return
     */
    public static String getMensagemBrowser() {
        if (isNull(mensagemBrowser.get()))
            mensagemBrowser.set("O browser foi iniciado pela primeira vez neste grupo de teste");
        return mensagemBrowser.get();
    }

}
