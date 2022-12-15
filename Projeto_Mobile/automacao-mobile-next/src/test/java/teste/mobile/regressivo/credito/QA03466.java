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

    @Test(description = "REG.LIM.07.05.12 - Solicitação de aumento de limite com aprovação do credito de valor igual ao solicitado e cliente habilita novo limite")
    @Description("Permitir que o Cliente Next solicite a majoração do limite global de crédito pelo APP NEXTO cliente deve possuir Conta “Universitária, ou conta Flex”\n" +
            "\n" +
            "valor informado ter passado pelas consistências de valor: valor informado maior que limite atual e menor que 9.999.999,99\n" +
            "deverá ser verificado com o crédito se a resposta da análise e crédito foi aprovado e valor solicitado pelo cliente\n" +
            "app deverá exibir o valor aprovado pelo crédito\n" +
            "Cliente deve habilitar novo limite")

    @Severity(SeverityLevel.NORMAL)
    public void QA03466() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarEmprestimos();

        credito.validarAntecipacaoCredito(recuperarMassa("valorCredito"), recuperarMassa("texto"),recuperarMassa("textoTitulo"));

    }

}
