package teste.web.regressivo.fnext.next;


import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.comum.PropostasFunc;
import funcionalidade.web.fnext.n1.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.FNEXT)
public class QA15997 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    PropostasFunc propostasFunc = new PropostasFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();

    @Test(description = "[A&A4] - Validar Fluxo de Proposta NEXT Análise N1 > Reprova ")
    @Description("Descrição:\n" +
            "\n" +
            "Validar Fluxo de Proposta NEXT Análise N1 > Reprova\n" +
            "\n" +
            " \n" +
            "\n" +
            "Pré-condiçãoes: \n" +
            "\n" +
            "1-Possuir usuários para realizar análise N1\n" +
            "\n" +
            "2- Possuir uma proposta Next da análise N1.")

    @Severity(SeverityLevel.NORMAL)
    public void QA15997() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1,Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        propostasFunc.selecionarProposta(recuperarMassa("cpf"));

        propostasFunc.clicarEmEditar();

        receitaFederalFunc.marcarConfereDatadeNascimentoNext();

        documentosFunc.marcarAprovadoTodosDocumentos();

        dadosCadastraisFunc.marcarDadosCadastraisParaReprovaNext(ComboN1.DATA_EMISSAO_DOC, ComboN1.DETRAN,ComboN1.AC);

        informacoesDoEnderecoFunc.marcarConfereCamposInformacaoDoEndereco();

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.RECUSADO, ComboN1.CPFDIVERGE);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.verificarSePropostaFinalizou();
    }
}
