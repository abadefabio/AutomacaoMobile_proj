package funcionalidade.mobile.objetivos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import pagina.mobile.jornadas.objetivos.DetalhesTela;
import pagina.mobile.jornadas.objetivos.EdicaoObjetivoTela;
import pagina.mobile.jornadas.objetivos.ObjetivosTela;
import pagina.mobile.jornadas.objetivos.cancelamento.ConfirmarCancelamentoTela;
import pagina.mobile.jornadas.objetivos.cancelamento.ObjetivoCanceladoTela;
import pagina.mobile.comum.next.PopUpTela;

public class ExcluirObjetivoFunc extends FuncionalidadeBase {

    /**
     * Método para excluir objetivo
     *
     * @throws Exception
     */
    public void excluirObjetivo(String textoQuerExcluir, String textoDiasUteis) throws Exception {
        fecharTelaPrimeiroAcessoObjetivoPresente();
        new ObjetivosTela(getDriver())
                .validarTelaObjetivos()
                .tocarBotaoDetalhes();
        new DetalhesTela(getDriver())
                .tocarBotaoLapisEditar();
        new EdicaoObjetivoTela(getDriver())
                .tocarExcluir();
        new PopUpTela(getDriver())
                .validarMensagem(textoQuerExcluir)
                .tocarBotaoExcluir();
        new ConfirmarCancelamentoTela(getDriver())
                .validarTituloTela()
                .validarMensagemConferirCancelamento()
                .tocarBotaoConfirmarCancelamento();
        new ObjetivoCanceladoTela(getDriver())
                .validarTituloTela()
                .validarMensagemResgateFeitoEm()
                .validartextoSobreResgate()
                .validartextoSoAconteceDiasUteis(textoDiasUteis)
                .tocarBotaoFechar();
        new ObjetivosTela(getDriver())
                .validarTelaObjetivos();
    }

    public void excluirObjetivoNaTelaDetalhes() throws Exception {
        new DetalhesTela(getDriver())
                .tocarBotaoLapisEditar();
        new EdicaoObjetivoTela(getDriver())
                .tocarExcluir();
        new PopUpTela(getDriver())
                .tocarBotaoExcluir();
        new ConfirmarCancelamentoTela(getDriver())
                .validarTituloTela()
                .validarMensagemConferirCancelamento()
                .tocarBotaoConfirmarCancelamento();
    }

    private void fecharTelaPrimeiroAcessoObjetivoPresente() throws Exception{
        new ObjetivosTela(getDriver())
                .verificarBotaoVerMeusObjetivosEstaPresente();
    }


}
