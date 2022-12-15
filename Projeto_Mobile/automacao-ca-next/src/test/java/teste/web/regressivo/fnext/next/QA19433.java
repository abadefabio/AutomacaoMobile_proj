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
public class QA19433 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A3] Validar a an�lise de Proposta JOY II sem restri��o, com an�lise N1 Recusado com Decis�o igual Solicita��o de Neg�cio e an�lise N2 com descri��o na conclus�o da an�lise")
    @Description("1- Ter acesso ao FNEXT no ambiente em teste\n" +
            "\n" +
            "2- Possuir usu�rio com permiss�o para Tratar N1 e Tratar N2\n" +
            "\n" +
            "3 - Possuir usu�rio com permiss�o para Consultar todas as etapas")
    @Severity(SeverityLevel.NORMAL)
    public void QA19433() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        receitaFederalFunc.marcarNaoConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoNaoSolicitaDocumentoGuardaJoy();

        dadosCadastraisFunc.marcarConfereDependenteJoyIIPadrao(ComboN1.DATA_EMISSAO_DOC, ComboN1.SSP, ComboN1.AC);

        documentosFunc.marcarAprovadoDocumentosResponsavelJoyII();

        dadosCadastraisFunc.marcarConfereResponsavelJoyIIPadrao(ComboN1.DATA_EMISSAO_DOC, ComboN1.DETRAN, ComboN1.AC);

        informacoesDoEnderecoFunc.marcarConfereCamposInformacaoDoEndereco();

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.RECUSADO, ComboN1.SOLICITACAODONEGOCIO);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N2_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarResultadoEtapaAprovadoEDescricaoDaAnaliseN2(ComboN2.APROVADO, "TESTE");

        pesquisaGeralFunc.verificarEtapaGerenteAnaliseContaAutomaticaFinalizado();

        pesquisaGeralFunc.verificarGerenteAnaliseContaAutomaticaDerivadoManual();

        pesquisaGeralFunc.verificarEtapaTelaNegocio();
    }
}
