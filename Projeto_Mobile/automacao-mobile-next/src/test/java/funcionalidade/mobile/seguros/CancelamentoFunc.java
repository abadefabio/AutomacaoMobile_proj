package funcionalidade.mobile.seguros;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;

import pagina.mobile.jornadas.seguros.CancelamentoTela;

public class CancelamentoFunc extends FuncionalidadeBase {

    public void cancelarSeguro(String motivoCancelamento) throws NextException {
        new CancelamentoTela(getDriver())
                .tocarListaMotivoDoCancelamento()
                .tocarBotaoMotivoDoCancelamento(motivoCancelamento)
                .tocarBotaoConfirmarSelecao()
                .tocarBotaoCorfirmar()
                .tocarBotaoOk();
    }
}
