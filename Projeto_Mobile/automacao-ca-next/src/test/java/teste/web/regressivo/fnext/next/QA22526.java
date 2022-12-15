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
public class QA22526 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    PropostasFunc propostasFunc = new PropostasFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A4] [N1/N2] Validar fluxo com Reversão de Status para proposta Next Joy")
    @Description("Descrição: Validar fluxo Preencher proposta > Análise N1 > Retorno Cliente > (Reverter Status) Análise N1 > P GCCN > Motor Segurança > Análise N2 > Análise N1 > Retorno Cliente > (Reverter Status) Análise N1 > P GCCN > Motor Segurança > Atualização Dados Cadastrais > Gerente > Resultado Adesão > Atualização Motor Segurança para proposta next joy.\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "1-Possuir usuários com as seguintes permissões no Fnext:\n" +
            "\n" +
            "Analista N1.\n" +
            "Analista N2.\n" +
            "Perfil de Painel de Gestão (Sustentação) para reversão de status.\n" +
            "\n" +
            "2- Possuir uma proposta pendente de análise N1 DO TIPO NEXT JOY.")
    @Severity(SeverityLevel.NORMAL)

    public void QA22526() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("document"));

        documentosFunc.solicitarReenvioDocumentoIdentificacaoJoy(ComboN1.DANIFICADO);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_PAINEL_GESTAO_SUSTENTACAO, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        propostasFunc.selecionarProposta(recuperarMassa("document"));

        propostasFunc.clicarEmReverterStatus();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("document"));

        receitaFederalFunc.marcarConfereDatadeNascimentoNext();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarDadosCadastraisParaAprovarNextJoy();

        conclusaoAnaliseFunc.selecionarResultadoEtapa(ComboN1.APROVADO_COM_PENDENCIA);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_COORDENADOR_N2, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarResultadoEtapaRetornoN1(ComboN2.RETORNO_N1,ComboN2.DOCUMENTOS_ILEGIVEIS);

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        propostasFunc.selecionarProposta(recuperarMassa("cpf"));

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("document"));

        documentosFunc.solicitarReenvioDocumentoIdentificacaoJoy(ComboN1.DOCUMENTO_RESPONSAVEL);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_PAINEL_GESTAO_SUSTENTACAO, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        propostasFunc.selecionarProposta(recuperarMassa("document"));

        propostasFunc.clicarEmReverterStatus();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("document"));

        receitaFederalFunc.marcarConfereDatadeNascimentoNext();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarDadosCadastraisParaAprovarNextJoy();

        conclusaoAnaliseFunc.selecionarResultadoEtapa(ComboN1.APROVADO);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.verificarSePropostaFinalizou();

        pesquisaGeralFunc.verificarEtapaAtualizacaoMotorDeSegurancaConcluido();

        pesquisaGeralFunc.verificarEtapaGerenteComoAberturaContaSim();
    }
}

