package teste.web.regressivo.fnext.next;


import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import constantes.web.fnext.n1.ComboN1;
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
public class QA22527 extends TesteBaseFnext {

    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    PropostasFunc propostasFunc = new PropostasFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();

    @Test(description = "[A&A4] [N1] Validar fluxo com Atualiza��o Cadastral direto pelo Analista N1 para proposta Next")
    @Description("Descri��o: Validar fluxo - Preencher proposta > An�lise N1 > P GCCN > Motor Seguran�a > Atualizar Dados Cadastrais > Gerente > Resultado Ades�o > Atualiza��o Motor para proposta next.\n" +
            "\n" +
            "Pr�-condi��es:\n" +
            "\n" +
            "1-Possuir usu�rios com as seguintes permiss�es no Fnext:\n" +
            "\n" +
            "Analista N1.\n" +
            "\n" +
            "2- Possuir uma proposta pendente de an�lise N1 DO TIPO NEXT.")

    @Severity(SeverityLevel.NORMAL)
    public void QA22527() throws Exception {

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        propostasFunc.selecionarProposta(recuperarMassa("document"));

        propostasFunc.clicarEmEditar();

        receitaFederalFunc.marcarConfereNomeMaeDataNascimento();

        documentosFunc.marcarAprovadoTodosDocumentos();

        dadosCadastraisFunc.marcarNaoConfereCorrigirDadosCadastraisNext(recuperarMassa("nomeCompleto"), recuperarMassa("dataNascimento"), ComboN1.PAIS_NASCIMENTO_BRASIL, ComboN1.AL, ComboN1.AGUA_BRANCA, recuperarMassa("nomePai"), ComboN1.RG_COM_CPF, recuperarMassa("numeroDocumento"), ComboN1.DATA_EMISSAO_DOC, ComboN1.CRM, ComboN1.AL);

        informacoesDoEnderecoFunc.marcarNaoConfereCamposInformacaodoEndereco(recuperarMassa("correcaoCep"), recuperarMassa("correcaoLogradouro"), recuperarMassa("correcaoNumero"), recuperarMassa("correcaoComplemento"), ComboN1.AC, ComboN1.ACRELANDIA);

        conclusaoAnaliseFunc.selecionarResultadoEtapa(ComboN1.APROVADO);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.verificarSePropostaFinalizou();

        propostasFunc.validarInformacaoFluxoPropostaAnaliseN1();
    }
}
