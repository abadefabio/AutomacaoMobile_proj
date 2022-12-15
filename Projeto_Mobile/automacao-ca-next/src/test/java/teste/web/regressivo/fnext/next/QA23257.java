package teste.web.regressivo.fnext.next;

import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import constantes.web.fnext.n2.ComboN2;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.n1.*;
import funcionalidade.web.fnext.n2.ConclusaoAnaliseN2Func;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.FNEXT)
public class QA23257 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    InformacoesDaPropostaFunc informacoesDaPropostaFunc = new InformacoesDaPropostaFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A4] [N1/N2] Validar fluxo completo para proposta NEXT quando match positivo para Liveness")
    @Description("Descrição: Validar fluxo - Preencher proposta/ Análise N1/ P GCCN / Motor Segurança/ Análise N2/ Atualização Cadastral / Gerente / Atualização Motor para proposta Next.\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "1-Possuir usuários com as seguintes permissões no Fnext:\n" +
            "\n" +
            "Analista N1\n" +
            "Analista N2\n" +
            "\n" +
            "2- Possuir uma proposta com status Positivo no Liveness e pendente de análise N1 DO TIPO NEXT.")
    @Severity(SeverityLevel.NORMAL)

    public void QA23257() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("document"));

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoLivenessNext();

        dadosCadastraisFunc.marcarConfereTodosDadosCadastrais(ComboN1.DATA_EMISSAO_DOC, ComboN1.CRM, ComboN1.AC);

        informacoesDoEnderecoFunc.marcarConfereCamposInformacaoDoEndereco();

        conclusaoAnaliseFunc.selecionarResultadoEtapa(ComboN1.APROVADO_COM_PENDENCIA);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_COORDENADOR_N2, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarResultadoEtapaAprovado(ComboN2.APROVADO);

        pesquisaGeralFunc.verificarSePropostaFinalizou();

        pesquisaGeralFunc.verificarEtapaAtualizacaoMotorDeSegurancaConcluido();

        pesquisaGeralFunc.verificarEtapaGerenteComoAberturaContaSim();

        pesquisaGeralFunc.verificarPresencaBotaoConsultarN1();

        informacoesDaPropostaFunc.verificarCampoLivenessPositivoTelaConsultaN1();

        conclusaoAnaliseN2Func.clicarBotaoVoltar();

        pesquisaGeralFunc.verificarPresencaBotaoConsultarN2();

        conclusaoAnaliseN2Func.verificarCampoLivenessPositivoTelaConsultaN2();

        conclusaoAnaliseN2Func.clicarBotaoVoltar();
    }
}
