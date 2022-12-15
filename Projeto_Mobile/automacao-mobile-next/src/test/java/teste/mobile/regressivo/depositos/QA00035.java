package teste.mobile.regressivo.depositos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.depositos.saques.DepositosSaques;
import constantes.depositos.saques.TipoSaque;
import funcionalidade.mobile.depositos.AgendamentoSaqueFunc;
import funcionalidade.mobile.depositos.DepositosSaquesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.DEPOSITOS_E_SAQUES)
public class QA00035 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    DepositosSaquesFunc depositos = new DepositosSaquesFunc();
    AgendamentoSaqueFunc agendamento = new AgendamentoSaqueFunc();

    @Test(description = "REG.SAQ.03 - Validar agendamento de saque para uso próprio, verificando que não é possível agendar em dias não util.")
    @Description("Objetivo:\n" +
            "Validar agendamento de saque para uso próprio, verificando que não é possível agendar em dias não util." +
            "Requisitos:" +
            "1) Possuir o app next instalado no celular;" +
            "2) Possuir CPF e senha para login;" +
            "3) Ter acesso a funcionalidade de Depósitos e Saques" +
            "Possuir acesso a opção Agendar Saque")

    @Severity(SeverityLevel.NORMAL)

    public void QA00035() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarDepositosSaques();

        depositos.acessarAgendarSaques();

        agendamento.preencherValorSaqueMinMaxEValidarMensagens();

        agendamento.preencherValorSaque();

        agendamento.verificarInformacoesEContinuarSeAndroid();

        agendamento.preencherDataDoDia();

        agendamento.informarBeneficiario(TipoSaque.PROPRIO, null);

        agendamento.informarCep();

        agendamento.informarAgencia();

        agendamento.editarData(false);

        agendamento.confirmarAgendamento(DepositosSaques.MENSAGEM_FERIADO);

        agendamento.editarData(true);

        agendamento.confirmarAgendamento(DepositosSaques.MENSAGEM_SUCESSO);

    }
}
