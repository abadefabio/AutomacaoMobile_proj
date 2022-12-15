package teste.web.regressivo.fnext.next;

import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.comum.PropostasFunc;
import funcionalidade.web.fnext.n1.DocumentosFunc;
import funcionalidade.web.fnext.n1.InformacoesDaPropostaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.FNEXT)
public class QA14481 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    PropostasFunc propostasFunc = new PropostasFunc();
    InformacoesDaPropostaFunc informacoesDaPropostaFunc = new InformacoesDaPropostaFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();

    @Test(description = "[A&A3] Validar os cards \"Informações da Proposta\" e \"Documentos\" na análise N1 de proposta NEXT com Match Positivo no Bureau de Face (Status: \"2\" Score =100%)")
    @Description("Validar os cards \"Informações da Proposta\" e \"Documentos\" na análise N1 de proposta NEXT com Match Positivo no Bureau de Face (Status: \"2\" Score =100%)\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "1- Ter acesso ao FNEXT no ambiente em teste\n" +
            "\n" +
            "2- Possuir usuário com permissão para Tratar N1 (next)\n" +
            "\n" +
            "3- Possuir proposta next com Match Positivo no Bureau de Face (Status: \"2\" Score =100%) em etapa Análise N1 - Tela Análise N1 - Em Andamento")
    @Severity(SeverityLevel.NORMAL)

    public void QA14481() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        propostasFunc.selecionarProposta(recuperarMassa("cpf"));

        propostasFunc.clicarEmEditar();

        informacoesDaPropostaFunc.verificarCampoBureauDeFacePositivoTelaConsultaN1();

        documentosFunc.verificarNaoExistenciaDosCamposDeFrameLiveness();
    }

}
