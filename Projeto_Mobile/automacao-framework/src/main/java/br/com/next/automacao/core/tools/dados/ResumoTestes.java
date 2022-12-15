package br.com.next.automacao.core.tools.dados;

import org.testng.ITestContext;

public interface ResumoTestes extends Resumo{

    String obterNomeTestes();

    void consolidarInformacoesTestes(ITestContext context);

    void incluirResumoTeste(ResumoScript resumoScript);

}
