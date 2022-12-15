package teste.web.regressivo.fnext.next;

import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.comum.PropostasFunc;
import funcionalidade.web.fnext.n1.ConclusaoAnaliseFunc;
import funcionalidade.web.fnext.n1.DadosCadastraisFunc;
import funcionalidade.web.fnext.n1.DocumentosFunc;
import funcionalidade.web.fnext.n1.ReceitaFederalFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.FNEXT)
public class QA15488 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    PropostasFunc propostasFunc = new PropostasFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();

    @Test(description = "[A&A4] Validar análise N1 de proposta NEXTJOY com Resultado da Etapa Recusado e o Motor Reprovando a proposta")
    @Description("Descrição: Validar análise N1 de proposta NEXTJOY com Resultado da Etapa Recusado e o Motor reprovando a proposta\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "1-Possuir usuário para realizar análise N1.\n" +
            "\n" +
            "2- Possuir uma proposta Next Joy pendente da análise N1.")
    @Severity(SeverityLevel.NORMAL)

    public void QA15488() throws Exception{

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        propostasFunc.selecionarProposta(recuperarMassa("cpf"));

        propostasFunc.clicarEmEditar();

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarDadosCadastraisParaReprovaNextJoy(ComboN1.DATA_EMISSAO_DOC, ComboN1.SSP, ComboN1.AC);

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.RECUSADO, ComboN1.CPFDIVERGE);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.verificarSePropostaFinalizou();
    }
}
