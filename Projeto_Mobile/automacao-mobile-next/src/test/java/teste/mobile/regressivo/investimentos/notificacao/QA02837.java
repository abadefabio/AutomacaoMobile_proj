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
public class QA02837 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    NotificacoesFunc notificacoes = new NotificacoesFunc();

    @Test(description = "REG.INV.06.05.01 - Validar notificação com desenquadramento de perfil - REFAZER PERFIL")
    @Description("Pré-Condições:\n" +
            "1 -Acessar a jornada de investimentos com massa de primeiro acesso\n" +
            "2- Realizar a primeira aplicação sem descobrir perfil em um produto das famílias (FUNDOS ou REDA FIXA)\n" +
            "3- Após a primeira aplicação na jornada descobrir perfil de investidor \"ARROJADO\" no menu de investimentos.\n" +
            "4- Realizar uma aplicação agendada em algum produto das famílias (FUNDOS ou *REDA FIXA) possuindo perfil de investidor \"ARROJADO\".\n" +
            "OBS:* Caso a massa não tenha perfil faça a descoberta de perfil investidor \"ARROJADO\" OU faça a alteração do perfil de investidor pelo Menu de Investimentos*\n" +
            "5- Alterar o perfil de investidor para um dos perfis abaixo: (Para que ocorre o desenquadramento de perfil.)\n" +
            "(ULTRACONSERVADOR, CONSERVADOR, MODERADO ou DINÂMICO)\n" +
            "\n" +
            "6-Aguardar a notificação de desenquadramento de perfil chegar na área de notificações do app Next, conforme o dia em que foi programado o agendamento.\n" +
            "OBS: A massa precisa ser preparada um dia ou mais dias antes do dia do teste, para que a notificação chegue no dia desejado.")
    @Severity(SeverityLevel.NORMAL)
    public void QA02837() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNotificacoes();

        notificacoes.validarNotificacaoInvestimentoAgendadoDesenquadramentoPerfil();

    }

}
