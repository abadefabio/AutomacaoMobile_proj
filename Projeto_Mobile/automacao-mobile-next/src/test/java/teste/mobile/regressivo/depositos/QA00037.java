package teste.mobile.regressivo.depositos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.depositos.saques.DepositosSaques;
import constantes.depositos.saques.TipoSaque;
import funcionalidade.mobile.depositos.AgendamentoSaqueFunc;
import funcionalidade.mobile.depositos.ConsultaSaqueFunc;
import funcionalidade.mobile.depositos.DepositosSaquesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.DEPOSITOS_E_SAQUES)

public class QA00037 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private DepositosSaquesFunc depositos = new DepositosSaquesFunc();
    private AgendamentoSaqueFunc agendamento = new AgendamentoSaqueFunc();
    private ConsultaSaqueFunc consultaAgendamento = new ConsultaSaqueFunc();

    @Test(description = "REG.SAQ.05 - Validar agendar e buscar e excluir Agendamento de Saque")
    @Description("Objetivo do teste: Validar buscar, envio de comprovante por e-mail e exclus�o de Agendamento de Saque\n" +
            "\n" +
            "Dados do teste: N/A\n" +
            "\n" +
            "Pr�-Requisitos:\n" +
            "Possuir CPF e Senha v�lidos para acessar o aplicativo;\n" +
            "Possuir acesso a funcionalidade DEP�SITOS E SAQUES.\n" +
            "Possuir o APP do Branco Bradesco instalado.\n" +
            "Possuir agendamento de saque para o range de datas consultado\n" +
            " \n" +
            "Depend�ncia: N/A\n" +
            "\n" +
            "Evidencias necess�rias: Todo o fluxo at� as telas.")
    @Severity(SeverityLevel.NORMAL)

    public void QA00037() throws Exception {

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

        agendamento.fechaComprovante();

        consultaAgendamento.consultarSaquesAgendados();

        consultaAgendamento.cancelarExclusaoAgendamento();

        consultaAgendamento.enviarComprovantePorEmail();

        consultaAgendamento.consultarSaquesAgendados();

        consultaAgendamento.excluirAgendamento();

        consultaAgendamento.consultarSaquesAgendados();

        consultaAgendamento.validarExclusaoAgendamento();
    }
}

