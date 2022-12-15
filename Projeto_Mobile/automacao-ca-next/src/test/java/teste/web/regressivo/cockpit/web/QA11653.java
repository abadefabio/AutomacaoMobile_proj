package teste.web.regressivo.cockpit.web;

import base.teste.TesteBaseCockpitLoginToken;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.cockpit.Url;
import funcionalidade.web.cockpit.atendimento.ResumoAdesaoFunc;
import funcionalidade.web.cockpit.login.LoginWebFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.COCKPIT_DE_ATENDIMENTO)
public class QA11653 extends TesteBaseCockpitLoginToken {

    LoginWebFunc loginWebFunc = new LoginWebFunc();
    ResumoAdesaoFunc resumoAdesaoFunc = new ResumoAdesaoFunc();

    @Test(description = "Validar no Telas a Aprova��o da Proposta de Ades�o do Cliente Next")
    @Description("Descri��o: \n" +
            "Dado: que o Gerente da Ag�ncia tenha validado as informa��es para aprova��o da abertura de conta.\n" +
            "Quando: o Gerente da Ag�ncia Validar as Informa��es do cliente\n" +
            "E: optar por Aprovar a conta.\n" +
            "Ent�o: o sistema realiza a aprova��o de abertura da conta apresentando a mensagem de sucesso �Conta Aprovada�.\n" +
            "\n" +

            "Objetivo:\n" +
            " Validar no Telas a Aprova��o da Proposta de Ades�o proveniente do FNEXT realizada pelo Gerente da Ag�ncia com o Resultado da Etapa de (N1 - DOC)\n" +
            " for Aprovada com Pend�ncia, Decis�o do Analista for �Suspeita por Fraude�, Resultado da Etapa (N2 - Seguran�a Corporativa) for Aprovada.\n" +
            "\n" +

            "Pr�-requisito:\n" +
            "- Ter proposta de ades�o abertura de conta Next\n" +
            "- Ter proposta conclu�da no fluxo das etapas (N1 DOC) e (N2 Seguran�a Corportativa) plataforma Fnext")
    @Severity(SeverityLevel.NORMAL)

    public void QA11653() throws Exception {

        String nome = "FULANO BELTRANO DA SILVA PERFIL NOVO";
        cpf = recuperarMassa("document");

        loginFunc.obterToken(cpf);
        loginWebFunc.realizarLoginEmuladorADESAO(
                recuperarMassa("funcionalidade"),
                cpf,
                loginFunc.getToken(),
                recuperarMassa("proposal"),
                recuperarMassa("prospect"),
                recuperarMassa("operador"),
                recuperarMassa("nomeOperador"));
        resumoAdesaoFunc.aprovarEtapaN1Gerente(cpf, nome);
        resumoAdesaoFunc.realizarAprovacaoClienteNext(cpf);

    }
}
