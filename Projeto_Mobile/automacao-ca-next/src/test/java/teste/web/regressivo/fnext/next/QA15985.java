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

@Jornada(Jornadas.FNEXT)
public class QA15985 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    PropostasFunc propostasFunc = new PropostasFunc();


    @Test(description = "[A&A4] Validar solicitação de reenvio com reversão de status para propostas NEXTJOY")
    @Description("Descrição: Validar solicitação de reenvio com reversão de status para propostas NEXTJOY\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "1-Possuir usuários para realizar análise N1 e Reversão de Status\n" +
            "\n" +
            "2- Possuir uma proposta Next Joy pendente da análise N1.")
    @Severity(SeverityLevel.NORMAL)
    public void QA15985() throws Exception{

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        documentosFunc.solicitarReenvioDocumentoIdentificacaoJoy(ComboN1.TELA);

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
