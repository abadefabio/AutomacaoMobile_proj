package funcionalidade.mobile.depositos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import constantes.depositos.saques.DepositosSaques;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.jornadas.depositos.ComprovanteTela;
import pagina.mobile.jornadas.depositos.ConsultaSaqueTela;
import pagina.mobile.jornadas.depositos.DepositosSaquesTela;
import pagina.mobile.comum.next.PopUpTela;

public class ConsultaSaqueFunc extends FuncionalidadeBase {

    /**
     * Selecionar data de início e data final para consulta de saques agendados
     *
     * @throws Exception
     */
    public void consultarSaquesAgendados() throws Exception {
        new DepositosSaquesTela(getDriver())
                .tocarBotaoConsultarSaques();
        new ConsultaSaqueTela(getDriver())
                .tocarBotaoDataInicial();
        new CalendarioTela(getDriver())
                .selecionarData(false, proximoDiaUtil())
                .tocarBotaoConfirmar();
        new ConsultaSaqueTela(getDriver())
                .tocarBotaoDataFinal();
        new CalendarioTela(getDriver())
                .selecionarData(false, proximoDiaUtil())
                .tocarBotaoConfirmar();
        new ConsultaSaqueTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Cancelar Exclusão de Agendamento
     *
     * @throws Exception
     */
    public void cancelarExclusaoAgendamento() throws Exception {
        new ConsultaSaqueTela(getDriver())
                .selecionarPrimeiroSaqueListado()
                .tocarBotaoExcluir();
        new PopUpTela(getDriver())
                .tocarBotaoNao();
    }

    /**
     * Excluir agendamento de saque
     *
     * @throws Exception
     */
    public void excluirAgendamento() throws Exception {
        new ConsultaSaqueTela(getDriver())
                .selecionarPrimeiroSaqueListado()
                .tocarBotaoExcluir();
        new PopUpTela(getDriver())
                .validarMensagem(DepositosSaques.MENSAGEM_CANCELAMENTO.toString())
                .tocarBotaoSim()
                .validarMensagem(DepositosSaques.MENSAGEM_CANCELAMENTO_SUCESSO.toString())
                .tocarBotaoOk();
    }

    /**
     * Validar agendamento excluído
     *
     * @throws Exception
     */
    public void validarExclusaoAgendamento() throws Exception {
        new ConsultaSaqueTela(getDriver())
                .validarExclusaoAgendamento(true);
    }

    /**
     * Enviar comprovante por e-mail
     */
    public void enviarComprovantePorEmail() throws Exception {
        new ConsultaSaqueTela(getDriver())
                .tocarBotaoComprovante();
        new ComprovanteTela(getDriver())
                .enviarComprovantePorEmail()
                .tocarBotaoConfirmarEnvioEmail();
        new PopUpTela(getDriver())
                .validarMensagem(DepositosSaques.MENSAGEM_EMAIL_ENVIADO.toString())
                .tocarBotaoOk();
    }
}
