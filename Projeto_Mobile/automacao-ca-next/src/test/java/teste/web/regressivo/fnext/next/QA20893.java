package teste.web.regressivo.fnext.next;

import base.teste.TesteBaseFnext;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.web.fnext.Login;
import funcionalidade.web.fnext.comum.LoginFunc;
import funcionalidade.web.fnext.comum.PesquisaGeralFunc;
import funcionalidade.web.fnext.n1.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.FNEXT)

public class QA20893 extends TesteBaseFnext {
    LoginFunc loginFunc = new LoginFunc();
    PesquisaGeralFunc pesquisaGeralFunc = new PesquisaGeralFunc();
    ReceitaFederalFunc receitaFederalFunc = new ReceitaFederalFunc();
    DocumentosFunc documentosFunc = new DocumentosFunc();
    DadosCadastraisFunc dadosCadastraisFunc = new DadosCadastraisFunc();

    @Test(description = "[A&A4] [N1] - Validar regras de aceita��o na corre��o do campo �Nome Completo� no card �Dados Cadastrais�")
    @Description("*Descri��o*: Validar que a corre��o do campo �Nome Completo� atende �s regras (as regras s�o N�O aceitar: nome concatenado (ex.: mariajesusdossantos), �Desconhecido� e �Ignorado�, com nome �nico, com nome ou sobrenome que um dos nomes tem 3 letras consecutivas, com 2 ou mais espa�os e com n�meros e caracteres especiais)\n" +
            "\n" +
            "*Pr�-condi��es*:\n" +
            "\n" +
            "1-Possuir usu�rios com as seguintes permiss�es no Fnext:\n" +
            " - Analista N�vel 1.\n" +
            "\n" +
            "\n" +
            "2- Possuir uma proposta do *TIPO* *+{color:#DE350B}NEXT{color}+* pendente de an�lise N1.")
    @Severity(SeverityLevel.NORMAL)

    public void QA20893() throws Exception{

        loginFunc.realizarLogin(Login.USUARIO_ANALISTA_N1, Login.SENHA_GERAL);

        pesquisaGeralFunc.pesquisaSelecionaEditaProposta(recuperarMassa("cpf"));

        receitaFederalFunc.marcarConfereDatadeNascimentoNext();

        documentosFunc.marcarAprovadoTodosDocumentos();

        dadosCadastraisFunc.marcarNaoConfereNomeCompleto(recuperarMassa("nomeCompleto1"));

        dadosCadastraisFunc.marcarNaoConfereNomeCompleto(recuperarMassa("nomeCompleto2"));

        dadosCadastraisFunc.marcarNaoConfereNomeCompleto(recuperarMassa("nomeCompleto3"));

        dadosCadastraisFunc.marcarNaoConfereNomeCompleto(recuperarMassa("nomeCompleto4"));

        dadosCadastraisFunc.marcarNaoConfereNomeCompleto(recuperarMassa("nomeCompleto5"));

        dadosCadastraisFunc.marcarNaoConfereNomeCompleto(recuperarMassa("nomeCompleto6"));

        dadosCadastraisFunc.marcarNaoConfereNomeCompleto(recuperarMassa("nomeCompleto7"));

        dadosCadastraisFunc.marcarNaoConfereNomeCompleto(recuperarMassa("nomeCompleto8"));

        dadosCadastraisFunc.marcarNaoConfereNomeCompletoFinalizar(recuperarMassa("nomeCompletoFinalizar"));

    }
}
