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

public class QA16122 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();

    @Test(description = "[A&A4] - Validar Fluxo de Proposta NEXTJOYII An�lise N1 > Recusado")
    @Description("Descri��o: Validar Fluxo de Proposta NEXT JOY II An�lise N1 > Recusado\n" +
            "\n" +
            "Pr�-condi��es:\n" +
            "\n" +
            "1-Possuir usu�rios com as seguintes permiss�es no Fnext:\n" +
            "\n" +
            "Analista N�vel Joy 1.\n" +
            "Analista N�vel Joy 2.\n" +
            " \n" +
            "\n" +
            "2- Possuir uma proposta pendente de an�lise N1 do tipo NEXT JOY II.")
    @Severity(SeverityLevel.NORMAL)
    public void QA16122() throws Exception{

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarDadosCadastraisDependenteJoyIICpfNaoConfere(ComboN1.DATA_EMISSAO_DOC, ComboN1.SSP, ComboN1.AC);

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentosResponsavelJoyII();

        dadosCadastraisFunc.marcarDadosCadastraisResponsavelJoyIICpfNaoConfere(ComboN1.DATA_EMISSAO_DOC, ComboN1.SSP, ComboN1.AC);

        informacoesDoEnderecoFunc.marcarConfereCamposInformacaoDoEndereco();

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.RECUSADO, ComboN1.CPFDIVERGEJOYII_RESPONSAVEL);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.verificarSePropostaFinalizou();
    }

}
