package constantes.pagamentos;

import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;
import static br.com.next.automacao.core.tools.Utilitarios.retornaDataDiaUtil;

public interface Data {

    String HOJE = calcularDataRelativaHoje(0);
    String HOJE_FORMATADO_DD_MMM_YYYY = calcularDataRelativaHoje(0, "dd MMM yyyy");
    String DIA_UTIL_FORMATADO_ANO_MES_DIA = retornaDataDiaUtil(1,"yyyy-MM-dd");
    String DIA_UTIL_FORMATADO_DIA_MES_POR_EXTENSO_ANO = retornaDataDiaUtil(1,"dd 'de' MMMM 'de' yyyy");
}
