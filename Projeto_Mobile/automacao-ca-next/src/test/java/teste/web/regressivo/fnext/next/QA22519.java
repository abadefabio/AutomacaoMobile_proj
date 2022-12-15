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
public class QA22519 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    PropostasFunc propostasFunc = new PropostasFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A4] [N2] Validar que o tratamento realizado por Analista N1 no card \"Informa��es do Endere�o\" s�o acatadas pelo sistema FNEXT")
    @Description("Descri��o: Validar atrav�s da consulta N2 que as confer�ncias feitas pelo analista N1 no card �Informa��es do Endere�o� s�o salvas pelo sistema.\n" +
            "\n" +
            "Pr�-condi��es:\n" +
            "\n" +
            "1-Possuir usu�rios com as seguintes permiss�es no Fnext:\n" +
            "\n" +
            "Analista N1.\n" +
            "Analista N2 - para consulta da an�lise N1.\n" +
            "\n" +
            "2- Possuir uma proposta pendente de an�lise N1 DO TIPO NEXT.")

    @Severity(SeverityLevel.NORMAL)
    public void QA22519() throws Exception {


        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1,Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        propostasFunc.selecionarProposta(recuperarMassa("cpf"));

        propostasFunc.clicarEmEditar();

        receitaFederalFunc.marcarNaoConfereNomeMaeDataNascimento();

        documentosFunc.marcarAprovadoTodosDocumentos();

        dadosCadastraisFunc.marcarConfereTodosDadosCadastrais(ComboN1.DATA_EMISSAO_DOC, ComboN1.DETRAN,ComboN1.AC);

        informacoesDoEnderecoFunc.marcarNaoConfereCamposInformacaodoEndereco(recuperarMassa("CorrecaoCep"), recuperarMassa("CorrecaoLogradouro"), recuperarMassa("CorrecaoNumero"), recuperarMassa("CorrecaoComplemento"), ComboN1.AC, ComboN1.ACRELANDIA);

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.RECUSADO, ComboN1.SOLICITACAODOCLIENTE);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_COORDENADOR_N2, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("cpf"));

        pesquisaGeralFunc.verificarPresencaBotaoConsultarN1();

        informacoesDoEnderecoFunc.validarAlteracaoCamposInformacaodoEndereco(recuperarMassa("CorrecaoCep"),recuperarMassa("CorrecaoLogradouro"),recuperarMassa("CorrecaoNumero"),recuperarMassa("CorrecaoComplemento"),recuperarMassa("CorrecaoUf"),recuperarMassa("CorrecaoCidade"));

        conclusaoAnaliseN2Func.clicarBotaoVoltar();

        pesquisaGeralFunc.clicarLogout();

    }
}
