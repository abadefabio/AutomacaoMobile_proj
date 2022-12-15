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

public class QA21702 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A4] [N2] Validar Resultado da Etapa = “Reprovado” onde Motivo = \"Dados Inconsistentes\" e Sub-Motivo = \"Responsável sem Doc GCCN E Contexto de Risco\" e os campos “Descrição da Análise de N2:” e “Observações N2:” tenham a qtde de caracteres excedida")
    @Description("Descrição: Validar que o sistema não permite exceder a quantidade de caracteres nos campos “Descrição da Análise de N2:” e “Observações N2:” para Resultado da Etapa = “Reprovado” onde o Motivo seja = \"Dados Inconsistentes\" e Sub-Motivo = \"Responsável sem Doc GCCN E Contexto de Risco\".\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "1-Possuir usuários com as seguintes permissões no Fnext:\n" +
            "\n" +
            "Analista Nível 1.\n" +
            "Analista Nível 2.\n" +
            " \n" +
            "2- Possuir uma proposta pendente de análise N2 DO TIPO JOY MULTIBANCO.")
    @Severity(SeverityLevel.NORMAL)
    public void QA21702() throws Exception{

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1_JOY, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("document"));

        receitaFederalFunc.marcarNaoConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarConfereTodosDadosCadastraisMultibanco(ComboN1.DATA_EMISSAO_DOC, ComboN1.CRM, ComboN1.AC);

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.APROVADO_COM_PENDENCIA, ComboN1.SUSPEITA_DE_FRAUDE);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_COORDENADOR_N2, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("document"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarResultadoEtapaReprovadoJoyMultibanco(ComboN2.REPROVADO, ComboN2.DADOS_INCONSISTENTES, recuperarMassa("descricaoCampo"));

        pesquisaGeralFunc.verificarSePropostaFinalizou();
    }

}
