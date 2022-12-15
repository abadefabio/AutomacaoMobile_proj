package teste.mobile.regressivo.investimentos.notificacao;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.investimentos.Texto;
import funcionalidade.mobile.investimentos.notificacoes.NotificacoesFunc;
import funcionalidade.mobile.investimentos.perfil.PerfilVencidoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.perfil.investidor.DescobrindoPerfilFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA02839 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    NotificacoesFunc notificacoes = new NotificacoesFunc();
    PerfilVencidoFunc perfilVencido = new PerfilVencidoFunc();
    DescobrindoPerfilFunc descobrindoPerfil = new DescobrindoPerfilFunc();

    @Test(description = "REG.INV.06.05.03 - Validar notificação com perfil vencido - REFAZER PERFIL")
    @Description("Pré-Condições:\n" +
            "1- Ter feito pelo menos uma aplicação em um produto das famílias (FUNDOS ou REDA FIXA)\n" +
            "2- Possuir perfil de investidor.\n" +
            "3- Realizar uma aplicação agendada em algum produto das famílias (FUNDOS ou REDA FIXA)\n" +
            "4 - Acessar o Test Data Manager Portal (TDM) no link https://192.168.231.104:8443/TestDataManager/index.html e alterar o perfil de investidor para vencido na opção \"Alterar Perfil do Cliente para Vencido\"\n" +
            "5-Aguardar a notificação de perfil vencido chegar na área de notificações do app Next, no dia em que foi programado o agendamento.\n" +
            "OBS: A massa precisa ser preparada um dia ou mais dias antes do dia do teste, para que a notificação chegue no dia desejado.")
    @Severity(SeverityLevel.NORMAL)
    public void QA02839() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNotificacoes();

        notificacoes.acessarValidarNotificacaoPerfilVencido();

        perfilVencido.refazerPerfilInvestidor();

        descobrindoPerfil.responderQuestionarioPrimeirasOpcoes();

        descobrindoPerfil.continuarAplicacao();
    }
}
