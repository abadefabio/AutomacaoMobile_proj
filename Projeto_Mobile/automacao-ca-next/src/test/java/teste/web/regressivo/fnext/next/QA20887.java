package teste.web.regressivo.fnext.next;


import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import constantes.web.fnext.n2.ComboN2;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.comum.PropostasFunc;
import funcionalidade.web.fnext.n1.*;
import funcionalidade.web.fnext.n2.ConclusaoAnaliseN2Func;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.FNEXT)
public class QA20887 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    PropostasFunc propostasFunc = new PropostasFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();




    @Test(description = "Validar fluxo de proposta - An�lise N1 > An�lise N2 x N1")
    @Description("Descri��o*: Validar fluxo de proposta - An�lise N1 > An�lise N2 > N1\n" +
            "\n" +
            "*Pr�-condi��es*:\n" +
            "\n" +
            "1-Possuir usu�rios com as seguintes permiss�es no Fnext:\n" +
            " - Analista N�vel 1.\n" +
            "\n" +
            " - Analista N�vel 2.\n" +
            "\n" +
            "\n" +
            "2- Possuir uma proposta pendente de an�lise N1.")
    @Severity(SeverityLevel.NORMAL)



    public void QA20887() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("document"));

        receitaFederalFunc.marcarConfereNomeMaeDataNascimento();

        documentosFunc.marcarAprovadoTodosDocumentos();

        dadosCadastraisFunc.marcarConfereTodosDadosCadastrais(ComboN1.DATA_EMISSAO_DOC, ComboN1.DETRAN, ComboN1.AC);

        informacoesDoEnderecoFunc.marcarConfereCamposInformacaoDoEndereco();

        conclusaoAnaliseFunc.selecionarResultadoEtapa(ComboN1.APROVADO_COM_PENDENCIA);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_COORDENADOR_N2, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarResultadoEtapaRetornoN1deN2(ComboN2.RETORNO_N1, ComboN2.ERRO_OPERACIONAL, recuperarMassa("descricaoCampo"));

        propostasFunc.selecionarProposta(recuperarMassa("document"));

    }
}

