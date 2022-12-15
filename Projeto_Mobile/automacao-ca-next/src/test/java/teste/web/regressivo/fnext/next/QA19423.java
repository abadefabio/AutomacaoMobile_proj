package teste.web.regressivo.fnext.next;

import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.n1.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.FNEXT)
public class QA19423 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();

    @Test(description = "[A&A3] Validar a an�lise de Proposta JOY II sem restri��o e com an�lise N1 Recusado com Decis�o igual CPF Diverge da Receita Federal - Dependente")
    @Description("1- Ter acesso ao FNEXT no ambiente em teste\n" +
            "\n" +
            "2- Possuir usu�rio com permiss�o para Tratar N1 (next)\n" +
            "\n" +
            "3 - Possuir usu�rio com permiss�o para Consultar todas as etapas.")
    @Severity(SeverityLevel.NORMAL)

    public void QA19423() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.RECUSADO, ComboN1.CPF_DIVERGE_DA_RECEITA_FEDERAL_DEPENDENTE);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.verificarEtapaGerenteAnaliseContaAutomaticaFinalizado();

        pesquisaGeralFunc.verificarGerenteAnaliseContaAutomaticaDerivadoManual();

        pesquisaGeralFunc.verificarEtapaTelaNegocio();
    }
}
