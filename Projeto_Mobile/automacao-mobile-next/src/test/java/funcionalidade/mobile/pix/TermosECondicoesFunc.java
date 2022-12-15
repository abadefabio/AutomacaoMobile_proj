package funcionalidade.mobile.pix;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.pix.TermosECondicoesTela;


import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class TermosECondicoesFunc extends FuncionalidadeBase {

    /**
     * Realizar aceite do termo de adesao pix
     *
     * @throws Exception
     */
    public void realizarAceiteTermosECondicoesPix() throws Exception {
        new TermosECondicoesTela(getDriver())
                .tocarBotaoTermoAdesaoPix()
                .validarTermoAdesaoPix()
                .tocarBotaoVoltar()
                .tocarCheckBoxTermosECondições()
                .tocarBotaoContinuar();
    }
}
