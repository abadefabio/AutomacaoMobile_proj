package teste.mobile.regressivo.credito;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.credito.CreditoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CREDITO)
public class QA03466 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    CreditoFunc credito = new CreditoFunc();

    @Test(description = "REG.LIM.07.05.12 - Solicita��o de aumento de limite com aprova��o do credito de valor igual ao solicitado e cliente habilita novo limite")
    @Description("Permitir que o Cliente Next solicite a majora��o do limite global de cr�dito pelo APP NEXTO cliente deve possuir Conta �Universit�ria, ou conta Flex�\n" +
            "\n" +
            "valor informado ter passado pelas consist�ncias de valor: valor informado maior que limite atual e menor que 9.999.999,99\n" +
            "dever� ser verificado com o cr�dito se a resposta da an�lise e cr�dito foi aprovado e valor solicitado pelo cliente\n" +
            "app dever� exibir o valor aprovado pelo cr�dito\n" +
            "Cliente deve habilitar novo limite")

    @Severity(SeverityLevel.NORMAL)
    public void QA03466() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarEmprestimos();

        credito.validarAntecipacaoCredito(recuperarMassa("valorCredito"), recuperarMassa("texto"),recuperarMassa("textoTitulo"));

    }

}
