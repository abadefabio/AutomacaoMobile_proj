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
public class QA17098 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A4] Validar fluxo de proposta -  An?lise N1 > Deriva > An?lise N2 > Reprovado")
    @Description("Descri??o: Validar fluxo de proposta - An?lise N1 > Deriva > An?lise N2 > Reprovado\n" +
            "\n" +
            "Pr?-condi??es:\n" +
            "\n" +
            "1-Possuir usu?rios com as seguintes permiss?es no Fnext:\n" +
            "\n" +
            "Analista N?vel 1 JOY.\n" +
            "Analista N?vel 2 JOY\n" +
            "\n" +
            "2- Possuir uma proposta Next JOY II pendente da an?lise N1.\n" +
            "\n" +
            "P?s-condi??es:\n" +
            "\n" +
            "A proposta ? analisada com sucesso e reprovada.")
    @Severity(SeverityLevel.NORMAL)
    public void QA17098() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarConfereDependenteJoyIIPadrao(ComboN1.DATA_EMISSAO_DOC, ComboN1.SSP, ComboN1.AC);

        documentosFunc.marcarAprovadoDocumentosResponsavelJoyII();

        dadosCadastraisFunc.marcarConfereResponsavelJoyIIPadrao(ComboN1.DATA_EMISSAO_DOC, ComboN1.DETRAN, ComboN1.AC);

        informacoesDoEnderecoFunc.marcarConfereCamposInformacaoDoEndereco();

        conclusaoAnaliseFunc.selecionarResultadoEtapa(ComboN1.APROVADO_COM_PENDENCIA);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N2_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarReprovadoDadosInconsistentesContaminacaoJoyII();

        pesquisaGeralFunc.verificarSePropostaFinalizou();
    }
}
