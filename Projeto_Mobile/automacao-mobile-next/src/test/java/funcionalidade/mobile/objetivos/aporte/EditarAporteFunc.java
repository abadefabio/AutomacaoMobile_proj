package funcionalidade.mobile.objetivos.aporte;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.objetivos.aporte.MensagemConfirmacaoExclusaoAgedamentoAporte;
import pagina.mobile.jornadas.objetivos.DetalhesTela;
import pagina.mobile.jornadas.objetivos.aporte.AplicacaoCanceladaTela;
import pagina.mobile.jornadas.objetivos.aporte.EditarAplicacaoTela;
import pagina.mobile.jornadas.objetivos.aporte.ModalConfirmacaoExclusaoAporteTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class EditarAporteFunc extends FuncionalidadeBase {

    /**
     * Excluir agendamento de aporte objetivo
     *
     * @throws Exception
     */
    public void excluirAgendamentoAporteObjetivo(MensagemConfirmacaoExclusaoAgedamentoAporte mensagem, String valorAporte, String tituloTelaAplicacaoCancelada) throws Exception{
        new EditarAplicacaoTela(getDriver())
                .tocarBotaoLixeira();
        new ModalConfirmacaoExclusaoAporteTela(getDriver())
                .validarMensagemConfirmacaoExclusaoAgendamentoAporte(mensagem.toString())
                .tocarBotaoExcluir();
        new AplicacaoCanceladaTela(getDriver())
                .validarTituloTelaAplicacaoCancelada(tituloTelaAplicacaoCancelada)
                .validarValorAporte(valorAporte)
                .tocarBotaoVerObjetivos();
        new DetalhesTela(getDriver())
                .tocarBotaoDetalhes()
                .validarNaoPresencaSessaoAgendamentoAporte();
    }
}
