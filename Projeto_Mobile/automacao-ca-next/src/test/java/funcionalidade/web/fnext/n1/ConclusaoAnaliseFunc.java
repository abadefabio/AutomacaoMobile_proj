package funcionalidade.web.fnext.n1;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.comum.PesquisaGeralTela;
import pagina.web.fnext.n1.CardConclusaoAnaliseN1Tela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class ConclusaoAnaliseFunc extends FuncionalidadeBase {

    /**
     * Método para selecionar combo Resultado da Etapa
     *
     * @param combo
     * @throws Exception
     */
    public void selecionarResultadoEtapa(String combo) throws Exception{
        new CardConclusaoAnaliseN1Tela(getWebDriver())
                .selecionarCombo(combo);
    }

    /**
     * Método para selecionar o combo Resultado da Etapa e Decisão do Analista
     *
     * @param resultado
     * @param decisao
     * @throws Exception
     */
    public void selecionarResultadoEtapaDecisao(String resultado, String decisao) throws Exception{
        new CardConclusaoAnaliseN1Tela(getWebDriver())
                .selecionarCombo(resultado)
                .selecionarDecisao(decisao);
    }

    /**
     * Método para selecionar o combo Resultado da Etapa, Decisão do Analista e Exceder Limite de Caracteres
     *
     * @param resultado
     * @param decisao
     * @param descricao
     * @throws Exception
     */
    public void ResultadoEtapaRecusadoEDescricaoDoAnalista(String resultado, String decisao, String descricao) throws Exception{
        new CardConclusaoAnaliseN1Tela(getWebDriver())
                .selecionarCombo(resultado)
                .selecionarDecisao(decisao)
                .digitarDescricaoDoAnalista(descricao);
    }
}
