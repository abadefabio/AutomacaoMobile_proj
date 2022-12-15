package funcionalidade.mobile.ajuda;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.ajuda.AtalhosTela;
import pagina.mobile.jornadas.ajuda.CotacaoDoDolarTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AtalhosFunc extends FuncionalidadeBase {

    /**
     * Tocar no botão Cotação do Dólar
     * @throws Exception
     */
    public void tocarBotaoCotacaoDoDolar() throws Exception {
        new AtalhosTela(getDriver())
                .tocarBotaoCotacaoDoDolar();
        new CotacaoDoDolarTela(getDriver())
                .validarTituloTelaCotacaoDoDolar();
    }
}
