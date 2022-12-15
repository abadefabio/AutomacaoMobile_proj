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
public class QA18290 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();

    @Test(description = "[A&A3] Validar a análise de Proposta JOY sem restrição e com análise N1 Recusado com Decisão igual Solicitação do Cliente")
    @Description("Descrição: Validar a análise de Proposta JOY sem restrição e com análise N1 Recusado com Decisão igual Solicitação do Cliente\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "1- Ter acesso ao FNEXT no ambiente em teste\n" +
            "\n" +
            "2- Possuir usuário com permissão para Tratar N1 (next)\n" +
            "\n" +
            "3 - Possuir usuário com permissão para Consultar todas as etapas.\n" +
            "\n")
    @Severity(SeverityLevel.NORMAL)

    public void QA18290() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoNaoSolicitaDocumentoGuardaJoy();

        dadosCadastraisFunc.marcarDadosCadastraisSemPaiEDesconhecidoNextJoy(ComboN1.DATA_EMISSAO_DOC,ComboN1.SSP,ComboN1.AC);

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.RECUSADO, ComboN1.SOLICITACAODOCLIENTE);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.verificarEtapaGerenteAnaliseContaAutomaticaFinalizado();

        pesquisaGeralFunc.verificarGerenteAnaliseContaAutomaticaAberturaContaNao();

        pesquisaGeralFunc.verificarSePropostaFinalizou();

        pesquisaGeralFunc.verificarCampoAContaFoiAbertaNao("cpf");
    }
}
