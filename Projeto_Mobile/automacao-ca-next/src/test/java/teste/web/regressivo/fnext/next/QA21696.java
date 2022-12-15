package teste.web.regressivo.fnext.next;

import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.n1.*;
import funcionalidade.web.fnext.n2.ConclusaoAnaliseN2Func;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.FNEXT)
public class QA21696 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A4] [N2] - Validar fluxo de Reprova��o da Proposta para proposta do tipo NEXT JOY II")
    @Description("Descri��o: Validar o fluxo de proposta - Preencher Proposta > An�lise N1 > P GCCN > Motor Seguran�a > An�lise N2 > Reprova proposta > Resultado Ades�o > Atualiza��o Motor.\n" +
            "\n" +
            "Pr�-condi��es:\n" +
            "\n" +
            "1-Possuir usu�rios com as seguintes permiss�es no Fnext:\n" +
            "\n" +
            "Analista N�vel 1.\n" +
            "Analista N�vel 2.\n" +
            " \n" +
            "2- Possuir uma proposta pendente de an�lise N1 do tipo Next Joy II.")
    @Severity(SeverityLevel.NORMAL)
    public void QA21696() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("document"));

        receitaFederalFunc.marcarNaoConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarConfereDependenteJoyIIPadrao(ComboN1.DATA_EMISSAO_DOC, ComboN1.SSP, ComboN1.AC);

        documentosFunc.marcarAprovadoDocumentosResponsavelJoyII();

        dadosCadastraisFunc.marcarConfereResponsavelJoyIIPadrao(ComboN1.DATA_EMISSAO_DOC, ComboN1.SSP, ComboN1.AC);

        informacoesDoEnderecoFunc.marcarConfereCamposInformacaoDoEndereco();

        conclusaoAnaliseFunc.selecionarResultadoEtapa(ComboN1.APROVADO);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N2_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarReprovadoAutoFraudeJoyII();

        pesquisaGeralFunc.verificarSePropostaFinalizou();
    }
}
