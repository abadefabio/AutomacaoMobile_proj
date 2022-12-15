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

public class QA23280 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A4] [N2] Validar fluxo completo para proposta NEXT JOY")
    @Description("Descri��o: Validar fluxo Preencher proposta/ An�lise N1/ P GCCN / Motor Seguran�a/ An�lise N2/ Atualiza��o Cadastral/ Gerente/ Resultado Ades�o/ Atualiza��o Motor para proposta next joy.\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "Pr�-condi��es:\n" +
            "\n" +
            "1-Possuir usu�rios com as seguintes permiss�es no Fnext:\n" +
            "\n" +
            "Analista N�vel 1.\n" +
            "Analista N�vel 2.\n" +
            "\n" +
            "\n" +
            "2- Possuir uma proposta pendente de an�lise N1 DO TIPO NEXT JOY.")

    @Severity(SeverityLevel.NORMAL)
    public void QA23280() throws Exception{

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("document"));

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarDadosCadastraisParaAprovarNextJoy();

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.APROVADO_COM_PENDENCIA, ComboN1.SUSPEITA_DE_FRAUDE);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_COORDENADOR_N2, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarResultadoEtapaAprovado(ComboN2.APROVADO);

        pesquisaGeralFunc.verificarSePropostaFinalizou();

        pesquisaGeralFunc.verificarEtapaAtualizacaoMotorDeSegurancaConcluido();

        pesquisaGeralFunc.verificarEtapaGerenteComoAberturaContaSim();
    }

}
