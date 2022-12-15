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

public class QA22514 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();
    InformacoesDoEnderecoFunc informacoesDoEnderecoFunc = new InformacoesDoEnderecoFunc();
    ConclusaoAnaliseFunc conclusaoAnaliseFunc = new ConclusaoAnaliseFunc();
    ConclusaoAnaliseN2Func conclusaoAnaliseN2Func = new ConclusaoAnaliseN2Func();

    @Test(description = "[A&A4] [N1] Validar fluxo completo para proposta NEXT JOY MULTIBANCO")
    @Description("Descrição: Validar fluxo Preencher proposta/ Análise N1/ P GCCN / Motor Segurança/ Análise N2/ Atualizar Dados Cadastrais/ Gerente/ Resultado Adesão/ Atualização Motor para proposta next joy multibanco.\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "1-Possuir usuários com as seguintes permissões no Fnext:\n" +
            "\n" +
            "Analista Nível 1.\n" +
            "Analista Nível 2.\n" +
            " \n" +
            "2- Possuir uma proposta pendente de análise N1 DO TIPO NEXT JOY MULTIBANCO.")

    @Severity(SeverityLevel.NORMAL)
    public void QA22514() throws Exception{

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("documentDependente"));

        receitaFederalFunc.marcarConfereDatadeNascimento();

        documentosFunc.marcarAprovadoDocumentoJoys();

        dadosCadastraisFunc.marcarConfereTodosDadosCadastraisMultibanco(ComboN1.DATA_EMISSAO_DOC, ComboN1.CRM, ComboN1.AC);

        conclusaoAnaliseFunc.selecionarResultadoEtapaDecisao(ComboN1.APROVADO_COM_PENDENCIA, ComboN1.SUSPEITA_DE_FRAUDE);

        pesquisaGeralFunc.clicarFinalizar();

        pesquisaGeralFunc.clicarLogout();

        loginFunc.realizarLogin(Login.USUARIO_COORDENADOR_N2, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisarPorCpf(recuperarMassa("documentDependente"));

        pesquisaGeralFunc.verificarPresencaBotaoEditar();

        conclusaoAnaliseN2Func.selecionarResultadoEtapaAprovado(ComboN2.APROVADO);

        pesquisaGeralFunc.verificarSePropostaFinalizou();

        pesquisaGeralFunc.verificarEtapaAtualizacaoMotorDeSegurancaConcluido();

        pesquisaGeralFunc.verificarEtapaGerenteComoAberturaContaSim();
    }

}
