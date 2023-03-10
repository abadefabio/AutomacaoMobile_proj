package teste.web.regressivo.fnext.next;

import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.n1.ConclusaoAnaliseFunc;
import funcionalidade.web.fnext.n1.DadosCadastraisFunc;
import funcionalidade.web.fnext.n1.DocumentosFunc;
import funcionalidade.web.fnext.n1.ReceitaFederalFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.FNEXT)
public class QA15995 extends TesteBaseFnext {
   LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();



    @Test(description = "Validar fluxo de proposta - Validar Fluxo de Proposta - An?lise N1 > Aprova")
    @Description("Descri??o: Validar Fluxo de Proposta - An?lise N1 > Aprova\n" +
            "\n" +
            "Pre-Condi??es" +
            "\n" +
            "1- Ter acesso ao FNEXT no ambiente em teste\n" +
            "2- Possuir usu?rio com permiss?o para Tratar N1 (next joy)\n" +
            "\n" +
            "P?s-Condi??es" +
            "\n" +
            "A proposta ? analisada com sucesso, enviando-a para a etapa Gerente.")
    @Severity(SeverityLevel.NORMAL)

    public void QA15995() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarDadosCadastraisParaAprovarNextJoy();

        conclusaoAnaliseFunc.selecionarResultadoEtapa(ComboN1.APROVADO);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.verificarEtapaTelaNegocio();

    }
}
