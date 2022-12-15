package funcionalidade.mobile.recarga;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.recarga.resumo.EscolhaValorTela;
import pagina.mobile.jornadas.recarga.resumo.ResumoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class EscolhaValorFunc extends FuncionalidadeBase {

    /**
     * Seleciona o Valor da recarga tela: 'Escolha o Valor'
     * @param valor
     * @throws Exception
     */
    public void selecionarValorRecarga(String valor) throws Exception {
        new EscolhaValorTela(getDriver())
                .selecionarValorRecarga(valor);
        new ResumoTela(getDriver())
                .validarExibicaoTelaResumo();
    }

}
