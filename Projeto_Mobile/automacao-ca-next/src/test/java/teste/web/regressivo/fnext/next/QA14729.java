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
public class QA14729 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    PropostasFunc propostasFunc = new PropostasFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func= new ConclusaoAnaliseN2Func();

    @Test(description = "Validar fluxo de proposta - An�lise N1 > Deriva > An�lise N2 > Reprova")
    @Description("1-Possuir usu�rios com as seguintes permiss�es no Fnext:\n" +
            "\n" +
            "Analista N�vel 1.\n" +
            "Analista N�vel 2.\n" +
            "\n" +
            "2- Possuir uma proposta pendente de an�lise N1 do tipo NEXT.")
    @Severity(SeverityLevel.NORMAL)

    public void QA14729() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        receitaFederalFunc.marcarConfereNomeMaeDataNascimento();

        documentosFunc.marcarAprovadoTodosDocumentos();

        dadosCadastraisFunc.marcarConfereTodosDadosCadastrais(ComboN1.DATA_EMISSAO_DOC,ComboN1.DETRAN,ComboN1.AC);

        informacoesDoEnderecoFunc.marcarConfereCamposInformacaoDoEndereco();

        conclusaoAnaliseFunc.selecionarResultadoEtapa(ComboN1.APROVADO_COM_PENDENCIA);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_COORDENADOR_N2, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarResultadoEtapaRetornoN1(ComboN2.REPROVADO, ComboN2.DADOS_INCONSISTENTES);

        conclusaoAnaliseN2Func.clicarSubMotivo(ComboN2.CONTEXTO_DE_RISCOS);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

    }

}
