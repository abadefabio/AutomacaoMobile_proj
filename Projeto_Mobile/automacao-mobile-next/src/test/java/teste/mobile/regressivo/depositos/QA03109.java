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

public class QA03109 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    DepositosSaquesFunc depositos = new DepositosSaquesFunc();
    AgendamentoSaqueFunc agendamento = new AgendamentoSaqueFunc();

    @Test(description = "AUT-REG.SAQ.04 - Validar agendamento de saque para Outro Beneficiário, verificando que não é possível agendar em dias não util.")
    @Description("Objetivo:\n" +
            "Validar agendamento de saque para Outro Beneficiário, verificando que não é possível agendar em dias não util" +
            "Requisitos:" +
            "1) Possuir R$50.000,00 disponíveis na conta corrente;" +
            "2) Não ter saque agendado para daqui a três dias úteis;" +
            "3) Possuir um CPF de outra pessoa")

    @Severity(SeverityLevel.NORMAL)

    public void QA03109() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarDepositosSaques();

        depositos.acessarAgendarSaques();

        agendamento.preencherValorSaqueMinMaxEValidarMensagens();

        agendamento.preencherValorSaque();

        agendamento.verificarInformacoesEContinuarSeAndroid();

        agendamento.preencherDataDoDia();

        agendamento.informarBeneficiario(TipoSaque.OUTRO_BENEFICIARIO, recuperarMassa(JSON.CPF_ADICIONAL));

        agendamento.informarCep();

        agendamento.informarAgencia();

        agendamento.editarData(false);

        agendamento.confirmarAgendamento(DepositosSaques.MENSAGEM_FERIADO);

        agendamento.editarData(true);

        agendamento.confirmarAgendamento(DepositosSaques.MENSAGEM_SUCESSO);

    }
}


