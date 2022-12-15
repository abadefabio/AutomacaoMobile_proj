package br.com.next.automacao.core.base;


import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.caso.CasoTeste;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.jira.ExecucaoStatus;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.massa.SQL;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.massa.LeitorMassaDados;
import br.com.next.automacao.core.tools.jira.conector.ConectorJira;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

import static br.com.next.automacao.core.tools.database.ConectorOracle.executarQuery;

/**
 * O teste base é a super classe das classes de teste, nela é realizado:
 * criação do objeto CasoTeste
 * setup Jira
 * chamada para criação de novo driver para teste ou reinicio do app;
 * carregamento da massa de dados para o caso de teste
 * chamada para encerrar driver
 *
 * @author Lucas Santos
 * @since 2019-10
 */

public class TesteNext {

    private static ThreadLocal<CasoTeste> casoTeste = null;
    private static ThreadLocal<String> nomeSuiteTeste = null;
    private static ThreadLocal<LeitorMassaDados> leitorMassaDados = null;
    public static ThreadLocal<HashSet> queryExecutada = null;
    public static ThreadLocal<HashMap<String, ArrayList>> listaResultado = null;
    public static ConectorJira conectorJira;
    public static Boolean jiraIntegracao;
    public static String nomeSuite;
    public static Boolean paralelo;

    Jornadas jornada = this.getClass().getAnnotation(Jornada.class).value();

    /**
     * Pega o nome da suite de teste no xml do testng
     *
     * @param contexto contexto da execucao
     */
    @BeforeSuite
    public void getNomeSuite(ITestContext contexto) {
        nomeSuite = contexto.getCurrentXmlTest().getSuite().getName();
    }

    /**
     * Configura váriavel paralelo 'true' se a suite está executando em paralelo via xml, 'false' caso contrário
     *
     * @param contexto contexto da execucao
     * @return
     */
    @BeforeSuite
    public void getParalelo(ITestContext contexto) {
        paralelo = contexto.getCurrentXmlTest().getSuite().getThreadCount() > 1;
    }

    /**
     * Retorna o objeto de caso de teste
     *
     * @return CasoTeste
     */
    public static CasoTeste getCasoTeste() {
        return casoTeste.get();
    }

    /**
     * Seta o objeto de caso de teste(Thread safe)
     */
    private void setCasoTeste() {
        if (casoTeste == null) {
            casoTeste = new ThreadLocal<>();
        }
        casoTeste.set(new CasoTeste());
    }

    private static HashSet getQueryExecutada() {
        return queryExecutada.get();
    }

    private static void setQueryExecutada() {
        queryExecutada = new ThreadLocal<HashSet>();
        queryExecutada.set(new HashSet());
    }

    private static HashMap getListaResultado() {
        return listaResultado.get();
    }

    private static void setListaResultado() {
        listaResultado = new ThreadLocal<HashMap<String, ArrayList>>();
        listaResultado.set(new HashMap<String, ArrayList>());
    }

    /**
     * retorna o objeto de leitura da massa de dados (Thread Safe)
     *
     * @return
     */
    protected static LeitorMassaDados getLeitorMassaDados() {
        return leitorMassaDados.get();
    }

    /**
     * Seta o objeto de leitor de massa de dados (Thread Safe)
     *
     * @param casoTeste
     */
    private static void setLeitorMassaDados(String casoTeste) {
        if (leitorMassaDados == null) {
            leitorMassaDados = new ThreadLocal<>();
        }
        leitorMassaDados.set(new LeitorMassaDados(casoTeste));
    }

    /**
     * Método responsável por recuperar o valo de uma chave do JSON de massa de dados
     *
     * @param chave chave a qual deseja-se obter o valor (ENUMERADOR)
     * @return Valor do JSON de massa
     */
    public static String recuperarMassa(JSON chave) {
        return (String) getLeitorMassaDados().getMassaDados().get(chave.getValue());
    }

    /**
     * Método responsável por recuperar o valor de uma chave do JSON de massa de dados
     *
     * @param chave chave a qual deseja-se obter o valor (STRING)
     * @return Valor do JSON de massa
     */
    public static String recuperarMassa(String chave) {
        return (String) getLeitorMassaDados().getMassaDados().get(chave);
    }

    /**
     * Método responsável por recuperar o valor de uma chave do JSON de massa de dados
     *
     * @return objeto JSON de massa
     */
    protected static JSONObject recuperarJSSONMassa(String chave) {
        return (JSONObject) getLeitorMassaDados().getMassaDados().get(chave);
    }

    /**
     * Metodo recupera um valor da base Oracle
     *
     * @param query parametro para busca
     * @return String com um CPF
     */
    public static String recuperarMassa(SQL query) {
        Random randomGenerator = new Random();
        if (queryExecutada == null) {
            setQueryExecutada();
        }
        if (listaResultado == null) {
            setListaResultado();
        }
        if (queryExecutada.get().isEmpty() || !queryExecutada.get().contains(query.getValue())) {
            queryExecutada.get().add(query.getValue());
            listaResultado.get().put(query.getValue(), executarQuery(query.getValue()));
        }
        ArrayList lista = listaResultado.get().get(query.getValue());
        return lista.get(randomGenerator.nextInt(lista.size())).toString();
    }

    /**
     * Cria uma Release no Jira para a execução da suíte de testes
     */
    @BeforeSuite(dependsOnMethods = {"getNomeSuite", "getParalelo"})
    @Parameters({"jira", "release"})
    public void criarReleaseJira(@Optional("") String jira, @Optional("") String release) throws NextException {
        Reporter.log("===============================================\n" +
                "             Conexão com o Jira\n" +
                "===============================================", true);
        if (jira.equalsIgnoreCase("true")) {
            jiraIntegracao = true;
            try {
                setConectorJira();
                conectorJira.criarVersaoRelease(release);
                Reporter.log("Conexão estabelecida!", true);
            } catch (Throwable t) {
                ignorarJiraIntegracao(t, "Falha na conexão com o Jira!");
            }
        } else {
            jiraIntegracao = false;
        }
    }

    public static void ignorarJiraIntegracao(Throwable t, String mensagemErro) {
        jiraIntegracao = false;
        Reporter.log("\n" + mensagemErro + ":", true);
        t.printStackTrace(System.err);
        Reporter.log("\nProsseguindo com o teste... Em caso de sucesso atualize manualmente as evidências no Jira.", true);
    }

    private void setConectorJira() throws NextException {
        if (conectorJira == null) {
            conectorJira = new ConectorJira();
        }
    }

    /**
     * Cria o ciclo de teste
     *
     * @param plataforma plataforma da execução
     */
    @BeforeTest
    @Parameters({"plataforma", "navegador", "baseURI", "nivel"})
    public void criarCicloJira(@Optional("") String plataforma, @Optional("") String navegador, @Optional("") String baseUri, @Optional("") String nivel) throws NextException {

        setCasoTeste();
        String secaoApi = "", secaoPlataforma = "", secaoNavegador = "";

        if (!baseUri.isEmpty())
            secaoApi = "[API]";
        if (!plataforma.isEmpty())
            secaoPlataforma = "[" + plataforma.toUpperCase() + "]";
        if (!navegador.isEmpty())
            secaoNavegador = "[" + navegador.toUpperCase() + "]";

        String cicloTeste = "[AUT]"
                .concat(secaoApi)
                .concat(secaoPlataforma)
                .concat(secaoNavegador)
                .concat(nivel);

        if (jiraIntegracao) {
            getCasoTeste().setCicloTeste(cicloTeste);
            try {
                if (!conectorJira.verificarExistenciaCiclo(getCasoTeste().getCicloTeste())) {
                    conectorJira.processarCicloJira(getCasoTeste().getCicloTeste());
                    Reporter.log("Ciclo criado!", true);
                } else {
                    Reporter.log("Ciclo verificado!", true);
                }
            } catch (Throwable t) {
                ignorarJiraIntegracao(t, "Falha ao atualizar ciclo no Jira");
            }
        }
    }

    /**
     * Configura a o card de teste e sua execução no Jira
     */
    public void configurarTesteJira() throws NextException {
        if (jiraIntegracao) {
            try {
                conectorJira.adicionarTeste();
                conectorJira.criarExecucao();
                conectorJira.alterarStatusExecucao(ExecucaoStatus.WIP);
                Reporter.log("Teste configurado!", true);
            } catch (Throwable t) {
                ignorarJiraIntegracao(t, "Falha ao configurar teste no Jira");
            }
        }
    }

    /**
     * Método responsável pela carga de massa via JSON para a execução do CT
     */
    public void carregaMassaDados() throws Exception {

        setLeitorMassaDados(getCasoTeste().getCasoId());
    }

    /**
     * Define descrição, jornada e objetivos do Teste
     * Para integração com Cucumber, o runner fará o override
     * deste método para chamar o definirObjetivoTesteCucumber()
     */
    @BeforeClass(dependsOnMethods = "criarCasoTeste")
    protected static void definirParametrosTeste(ITestContext contexto) {
        Map<String, String> parametros = new HashMap<>();
        parametros.putAll(contexto.getCurrentXmlTest().getAllParameters());
        getCasoTeste().setParametrosTeste(parametros);
        setSuiteXmlTeste(contexto);
    }

    public static Map<String, String> getParametroTeste(String parametro) {
        return getCasoTeste().getParametrosTeste();
    }

    /**
     * Define nome da suite/teste dentro do xml para acomapanhar execução em paralelo
     *
     * @param contexto
     */
    public static void setSuiteXmlTeste(ITestContext contexto) {
        if (nomeSuiteTeste == null) {
            nomeSuiteTeste = new ThreadLocal<>();
        }
        nomeSuiteTeste.set(contexto.getCurrentXmlTest().getName());
    }

    /**
     * Recupera nome da suite/teste dentro do xml
     */
    public static String getSuiteXmlTest() {
        return nomeSuiteTeste.get();
    }

    /**
     * Define descrição, jornada e objetivos do Teste
     */
    protected void definirObjetivoTeste() {
        Method[] methods = this.getClass().getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                Test nomeCt = m.getAnnotation(Test.class);
                getCasoTeste().setNomeCasoTeste(nomeCt.description());
            }
            if (m.isAnnotationPresent(Description.class)) {
                Description description = m.getAnnotation(Description.class);
                getCasoTeste().setObjetivoTeste(description.value());
            }
            if (m.isAnnotationPresent(Test.class)) {
                Severity severidade = m.getAnnotation(Severity.class);
                getCasoTeste().setSeveridadeCt(severidade.value().toString());
            }
        }
    }
}
