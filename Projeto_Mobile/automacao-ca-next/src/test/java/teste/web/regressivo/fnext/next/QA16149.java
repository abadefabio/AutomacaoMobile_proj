package teste.web.regressivo.fnext.next;


import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import constantes.web.fnext.n2.ComboN2;
import funcionalidade.web.fnext.comum.*;
import funcionalidade.web.fnext.n1.*;
import funcionalidade.web.fnext.n2.ConclusaoAnaliseN2Func;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.FNEXT)
public class QA16149 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    PropostasFunc propostasFunc = new PropostasFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A3] Validar a an�lise de Proposta NEXT sem restri��o, com an�lise N1 Recusado com Decis�o igual Analfabeto e an�lise N2 COM descri��o na conclus�o da an�lise")
    @Description("Validar a an�lise de Proposta NEXT sem restri��o, com an�lise N1 Recusado com Decis�o igual Analfabeto e an�lise N2 COM descri��o na conclus�o da an�lise" +
            "\n" +
            "Pr�-condi��es:\n" +
            "\n" +
            "1- Ter acesso ao FNEXT no ambiente em teste\n" +
            "\n" +
            "2- Possuir usu�rio com permiss�o para Tratar N1 (next)\n" +
            "\n" +
            "3 - Possuir usu�rio com pemiss�o para Consultar todas as etapas (next).")
    @Severity(SeverityLevel.NORMAL)

    public void QA16149() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        propostasFunc.selecionarProposta(recuperarMassa("cpf"));

        propostasFunc.clicarEmEditar();

        receitaFederalFunc.marcarNaoConfereNomeMaeDataNascimento();

        documentosFunc.marcarAprovadoTodosDocumentos();

        dadosCadastraisFunc.marcarConfereTodosDadosCadastrais(ComboN1.DATA_EMISSAO_DOC, ComboN1.DETRAN, ComboN1.AC);

        informacoesDoEnderecoFunc.marcarConfereCamposInformacaoDoEndereco();

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.RECUSADO,ComboN1.ANALFABETO);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_COORDENADOR_N2, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarResultadoEtapaAprovadoEDescricaoDaAnaliseN2(ComboN2.APROVADO,"TESTE");

        pesquisaGeralFunc.verificarEtapaGerenteAnaliseContaAutomaticaFinalizado();

        pesquisaGeralFunc.verificarGerenteAnaliseContaAutomaticaDerivadoManual();

        pesquisaGeralFunc.verificarEtapaTelaNegocio();

        pesquisaGeralFunc.clicarLogout();
    }
}
