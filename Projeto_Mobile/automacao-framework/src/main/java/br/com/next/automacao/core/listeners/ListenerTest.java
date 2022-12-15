package br.com.next.automacao.core.listeners;

import br.com.next.automacao.core.constantes.driver.TipoExecucao;
import br.com.next.automacao.core.constantes.jira.ExecucaoStatus;
import br.com.next.automacao.core.tools.dados.DadosScript;
import br.com.next.automacao.core.tools.dados.DadosSuite;
import br.com.next.automacao.core.tools.dados.DadosTestes;
import br.com.next.automacao.core.tools.dados.ResumoSuite;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import br.com.next.automacao.core.tools.evidencia.RelatorioEvidencia;
import br.com.next.automacao.core.tools.evidencia.TipoEvidencia;
import br.com.next.automacao.core.tools.evidencia.relatorio.GeradorLogJasperReport;
import br.com.next.automacao.core.tools.planilha.RelatorioSuiteExcel;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.util.List;

import static br.com.next.automacao.core.base.TesteBase.getEvidencia;
import static br.com.next.automacao.core.base.TesteNext.conectorJira;
import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static br.com.next.automacao.core.base.TesteNext.ignorarJiraIntegracao;
import static br.com.next.automacao.core.base.TesteNext.jiraIntegracao;
import static br.com.next.automacao.core.drivers.ResetApp.redefinirResetAppSuite;
import static br.com.next.automacao.core.drivers.ResetApp.setMensagemApp;
import static br.com.next.automacao.core.drivers.ResetApp.setMensagemBrowser;
import static br.com.next.automacao.core.drivers.ResetApp.setResetAppProximoTeste;
import static br.com.next.automacao.core.tools.evidencia.relatorio.GeradorLogTxtReport.geradorLogApi;
import static br.com.next.automacao.core.tools.evidencia.relatorio.GeradorRelatorioEvidencia.gerarRelatorioEvidencia;
import static java.util.Objects.isNull;

/**
 * O Listener é responsável pelo controle de ações baseadas em
 * resultados da execução dos casos de teste
 *
 * @author Lucas Santos
 * @version 1.0
 * @since 2019-12
 */

public class ListenerTest implements ITestListener, ISuiteListener {

    ResumoSuite resumoSuite;

    @Override
    public void onStart(ISuite suite) {
        resumoSuite = new DadosSuite(suite.getName(), suite.getXmlSuite().getThreadCount());
    }

    @Override
    public void onStart(ITestContext context) {
        resumoSuite.adicionarNovoBlocoTeste(new DadosTestes(context));
    }

    @Override
    public void onTestStart(ITestResult result) {
        XmlTest teste = result.getTestContext().getCurrentXmlTest();
        Reporter.log("Teste:      " + result.getName(), true);
        if (teste.getParameter("plataforma") != null) {
            Reporter.log("Udid:       " + teste.getParameter("udid"), true);
            Reporter.log("Plataforma: " + teste.getParameter("plataforma"), true);
            Reporter.log("DeviceName: " + teste.getParameter("deviceName"), true);
        }
        if (teste.getParameter("navegador") != null) {
            Reporter.log("Navegador:  " + teste.getParameter("navegador"), true);
        }
        Reporter.log("===============================================", true);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log(result.getName() + " executado com sucesso!", true);

        List<String> log = Reporter.getOutput();
        resumoSuite.atualizarDadosTeste(new DadosScript(result));
        gerarEvidencia("", log, calcularTempoExecucao(result));

        if (jiraIntegracao) {
            try {
                conectorJira.alterarStatusExecucao(ExecucaoStatus.PASS);
                conectorJira.removerArquivosEvidenciaTeste();
                conectorJira.anexarArquivosEvidenciaGerados();
                Reporter.log("Evidências anexadas no Jira!");
            } catch (Throwable t) {
                ignorarJiraIntegracao(t, "Falha ao atualizar evidências no Jira");
            }
        }

        decidirRedefinirAppBrowsers(true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("===============================================", true);
        Reporter.log("O caso de teste " + result.getName() + " falhou!", true);
        List<String> log = Reporter.getOutput();
        String erros = null;
        try {
            erros = result.getThrowable().getMessage();
            erros = erros.isEmpty() ? result.getThrowable().getCause().getMessage() : erros;
        } catch (NullPointerException e) {
            if (!isNull(erros)) {
                OperadorEvidencia.logarPasso(erros);
                if (erros.isEmpty()) erros = "NullPointerException";
            } else {
                erros = "NullPointerException";
            }
        }
        erros = isNull(erros) || erros.isEmpty() ? "Um erro desconhecido ocorreu." : erros;
        resumoSuite.atualizarDadosTeste(new DadosScript(result));
        gerarEvidencia(erros, log, calcularTempoExecucao(result));
        if (jiraIntegracao) {
            try {
                conectorJira.alterarStatusExecucao(ExecucaoStatus.FAIL);
                conectorJira.anexarArquivosEvidenciaGerados();
                Reporter.log("Evidências anexadas no Jira!");
            } catch (Throwable t) {
                ignorarJiraIntegracao(t, "Falha ao atualizar evidências no Jira");
            }
        }

        decidirRedefinirAppBrowsers(false);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("===============================================", true);
        Reporter.log("O caso de teste " + result.getName() + " foi ignorado!", true);

        if (jiraIntegracao) {
            try {
                conectorJira.alterarStatusExecucao(ExecucaoStatus.BLOCKED);
                Reporter.log("Evidências anexadas no Jira!");
            } catch (Throwable t) {
                ignorarJiraIntegracao(t, "Falha ao atualizar evidências no Jira");
            }
        }
        resumoSuite.atualizarDadosTeste(new DadosScript(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onFinish(ITestContext context) {
        resumoSuite.atualizarDadosConjuntoTestes(context);
        redefinirResetAppSuite();
    }

    @Override
    public void onFinish(ISuite suite) {
        resumoSuite.registrarResultadosSuite(suite.getResults());
        String relatorio = suite.getParameter("relatorio");
        relatorio = relatorio == null ? "false" : relatorio;
        if (relatorio.equalsIgnoreCase("true"))
            RelatorioSuiteExcel
                    .escreverRelatorioExcel(suite.getParameter("arquivoRelatorio") + ".xlsx", resumoSuite)
                    .escreverResumoConjuntosTestes(resumoSuite.recuperarResumoTestes())
                    .escreverResultadosScripts(resumoSuite.recuperarResumoScripts())
                    .finalizar()
                    .salvar();
    }

    /**
     * Gera o relatório de evidência de teste
     *
     * @param erros mensagem de erro gerada
     */
    private synchronized void gerarEvidencia(String erros, List<String> log, String tempoExecucao) {

        GeradorLogJasperReport.gerarLogRelatorio(log);

        if (getCasoTeste().isTipoExecucao(TipoExecucao.MOBILE) || getCasoTeste().isTipoExecucao(TipoExecucao.WEB)) {
            RelatorioEvidencia relatorio = null;
            relatorio = new RelatorioEvidencia(getEvidencia(), getCasoTeste().getCasoId(), getCasoTeste().getTester(), getCasoTeste().getJornadaCt(), erros, getCasoTeste().getNomeCasoTeste(), getCasoTeste().getObjetivoTeste(), getCasoTeste().getPlataformaCt(), tempoExecucao, getCasoTeste().getDispositivo(), getCasoTeste().getUdid());
            try {
                gerarRelatorioEvidencia(relatorio, TipoEvidencia.PDF, getCasoTeste().getNomeArquivoEvidencia());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (getCasoTeste().isTipoExecucao(TipoExecucao.API)) {
            geradorLogApi(log);
        }
    }

    private String calcularTempoExecucao(ITestResult result) {
        long minutos = ((result.getEndMillis() - result.getStartMillis()) / 1000) / 60;
        long segundos = ((result.getEndMillis() - result.getStartMillis()) / 1000) % 60;
        return minutos + "m" + segundos + "s";
    }

    /**
     * Método chamado ao final de uma execução com sucesso ou execução com falha.
     * O parâmetro sucessoExecucao serve para orientar a decisão de reiniciar app e browser.
     * O app e browser só não reiniciam se o teste passar com sucesso e for solicitado no resetApp = false.
     * Em qualquer outra situação, o app deve reiniciar.
     * Este método alimenta a classe ResetApp, que é consultada no início de um próximo teste,
     * e essa classe é que efetua o reset do app e browser com base nos dados informados aqui no final de um teste.
     *
     * @param sucessoExecucao
     */
    private void decidirRedefinirAppBrowsers(Boolean sucessoExecucao) {

        Boolean parametroExiste = getCasoTeste().getParametrosTeste().containsKey("resetApp");

        if (!sucessoExecucao) {
            setResetAppProximoTeste(true);
            setMensagemApp("O app será reiniciado por falha no teste anterior...");
            setMensagemBrowser("O navegador será reiniciado por falha no teste anterior...");
        } else if (!parametroExiste) {
            setResetAppProximoTeste(true);
            setMensagemApp("O app será reiniciado por padrão...");
            setMensagemBrowser("O navegador será reiniciado por padrão...");
        } else {
            boolean resetApp = getCasoTeste().getParametrosTeste().get("resetApp").equals("true");
            setResetAppProximoTeste(resetApp);
            setMensagemApp(resetApp ? "O app será reiniciado por especificação no parâmetro resetApp..." :
                    "O app será mantido no seu estado em que estava no teste anterior...");
            setMensagemBrowser(resetApp ? "O navegador será reiniciado por especificação no parâmetro resetApp..." :
                    "O navegador será mantido aberto neste teste desde o teste anterior...");
        }

    }
}
