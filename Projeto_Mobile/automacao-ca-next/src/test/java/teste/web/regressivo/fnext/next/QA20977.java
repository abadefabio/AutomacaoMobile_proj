package teste.web.regressivo.fnext.next;

import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.n1.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.FNEXT)

public class QA20977 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();

    @Test(description = "[A&A4] [Analista N1] Validar Conclus�o da An�lise N1 para Resultado da Etapa = �Recusado� onde o Motivo seja = �Documento do Respons�vel Irregular (Reincid�ncia)� campo �Descri��o do Analista:� tenha a qde de caracteres excedida e Status = Aprovado Motor")
    @Description("Descri��o*: Validar que o sistema n�o permite exceder a quantidade de caracteres nos campos campos �Descri��o da An�lise de N2:� e �Observa��es N2:�  para Resultado da Etapa igual a �Recusado� e que ao finalizar a an�lise a proposta seja aprovada pelo Motor SADIF.\n" +
            "\n" +
            "*Pr�-condi��es*:\n" +
            "\n" +
            "1-Possuir usu�rios com as seguintes permiss�es no Fnext:\n" +
            " - Analista N�vel 1.\n" +
            "\n" +
            " - Analista N�vel 2.\n" +
            "\n" +
            "\n" +
            "2- Possuir uma proposta pendente de an�lise N1 DO TIPO JOY MULTIBANCO")
    @Severity(SeverityLevel.NORMAL)
    public void QA20977() throws Exception{

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("documentDependente"));

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarConfereTodosDadosCadastraisMultibanco(ComboN1.DATA_EMISSAO_DOC, ComboN1.CRM, ComboN1.AC);

        conclusaoAnaliseFunc.ResultadoEtapaRecusadoEDescricaoDoAnalista(ComboN1.RECUSADO, ComboN1.DOCUMENTO_RESP_IRREGULAR, recuperarMassa("descricaoCampo"));

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.verificarSePropostaFinalizou();

        pesquisaGeralFunc.verificarResultadoDaEtapaAprovadoMotor();
    }

}
