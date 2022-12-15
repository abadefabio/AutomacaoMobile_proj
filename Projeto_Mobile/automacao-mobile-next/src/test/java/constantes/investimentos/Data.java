package constantes.investimentos;

import framework.MobileUtils;
import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;
import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;

public interface Data {

    String HOJE = calcularDataRelativaHoje(0);
    String DIA_NAO_UTIL = MobileUtils.retornaDataDiaNaoUtil(0, "dd/MM/yyyy");
    String DIA_UTIL_APOS_DIA_NAO_UTIL = MobileUtils.retornaDataDiaUtilAPartirDeUmaDataDiaNaoUtil(2,"dd/MM/yyyy", DIA_NAO_UTIL);
    String PROXIMO_DIA_UTIL = proximoDiaUtil(1);
}
