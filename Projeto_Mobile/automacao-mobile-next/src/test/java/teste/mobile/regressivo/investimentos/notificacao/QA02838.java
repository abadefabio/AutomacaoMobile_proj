package teste.mobile.regressivo.investimentos.notificacao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.investimentos.notificacoes.NotificacoesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA02838 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    NotificacoesFunc notificacoes = new NotificacoesFunc();

    @Test(description = "REG.INV.06.05.02 - Validar notifica��o com dados cadastrais incompleto - CONTINUAR NO CHAT")
    @Description("Pr�-Condi��es:\n" +
    "1- Realizar uma aplica��o em um produto das fam�lias (FUNDOS ou REDA FIXA)\n" +
    "2- Possuir perfil de investidor.*\n" +
    "3- Realizar uma aplica��o agendada em algum produto das fam�lias (FUNDOS ou REDA FIXA)\n" +
    "4- Solicitar o time de desenvolvimento da squad DESATUALIZAR OS DADOS CADRASTAIS da massa de teste.\n" +
    "5-Aguardar a notifica��o de aguardar a notifica��o de dados cadastrais incompletos chegar na �rea de notifica��es do app Next, conforme o dia em que foi programado o agendamento.\n" +
    "OBS: A massa precisa ser preparada um dia ou mais dias antes do dia do teste, para que a notifica��o chegue no dia desejado.)")

    @Severity(SeverityLevel.NORMAL)
    public void QA02838() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNotificacoes();

        notificacoes.acessarValidarNotificacaoAtualizacaoCadastral();
    }
}
