package funcionalidade.mobile.ajuda;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.jornadas.ajuda.CotacaoDoDolarTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;


public class CotacaoDoDolarFunc extends FuncionalidadeBase {

    /**
     * Pesquisar a cotação para uma data
     * @throws Exception
     * @param dataInicial
     * @param dataFinal
     */
    public void pesquisarCotacaoParaUmaData(String dataInicial, String dataFinal) throws Exception {
        new CotacaoDoDolarTela(getDriver())
                .tocarCampoPeríodo();
        new CalendarioTela(getDriver())
                .selecionarData(false, dataInicial)
                .selecionarData(false,dataFinal)
                .tocarBotaoConfirmar();
        new CotacaoDoDolarTela(getDriver())
                .validarResultadoConsultaCotacaoDoDolar();
    }
}
