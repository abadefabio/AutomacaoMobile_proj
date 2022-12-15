package teste.web.regressivo.fnext.next;


import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.comum.PropostasFunc;
import funcionalidade.web.fnext.n1.DocumentosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(value = Jornadas.FNEXT)

public class QA17602 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    PropostasFunc propostasFunc = new PropostasFunc();

    @Test(description = "[A&A4] - Validar Fluxo de Proposta NEXTJOYII Análise N1 > Solicita Reenvio > Reverter Proposta > Análise N1")
    @Description("Descrição: Validar Fluxo de Proposta NEXT JOY II Análise N1 > Solicita Reenvio > Análise N1\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "1-Possuir usuários com as seguintes permissões no Fnext:\n" +
            "\n" +
            "Analista Nível Joy 1.\n" +
            "Painel de Gestão.\n" +
            " \n" +
            "\n" +
            "2- Possuir uma proposta pendente de análise N1 do tipo NEXT JOY II.")
    @Severity(SeverityLevel.NORMAL)

    public void QA17602() throws Exception{

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        documentosFunc.solicitarReenvioDocumentoIdentificacaoJoy(ComboN1.COPIA);

        documentosFunc.solicitarReenvioDocumentoIdentificacaoResponsavel(ComboN1.COPIA);

        pesquisaGeralFunc.clicarFinalizar();

        propostasFunc.selecionarProposta(recuperarMassa("cpf"));

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_PAINEL_GESTAO_SUSTENTACAO, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        propostasFunc.selecionarProposta(recuperarMassa("cpf"));

        propostasFunc.clicarEmReverterStatus();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        propostasFunc.selecionarProposta(recuperarMassa("cpf"));

        propostasFunc.validaPropostaEmAnaliseN1();
    }


}
