package br.com.next.automacao.core.tools.dados;

import org.testng.ISuiteResult;
import org.testng.ITestContext;

import java.util.Map;

public interface ResumoSuite extends Resumo{

    void adicionarNovoBlocoTeste(ResumoTestes resumo);

    void registrarResultadosSuite(Map<String, ISuiteResult> resultados);

    void atualizarDadosConjuntoTestes(ITestContext context);

    void atualizarDadosTeste(ResumoScript resumo);

    Object[] recuperarResumoTestes();

    Object[] recuperarResumoScripts();

}
