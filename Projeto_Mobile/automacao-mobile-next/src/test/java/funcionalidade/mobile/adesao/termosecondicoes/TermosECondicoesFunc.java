package funcionalidade.mobile.adesao.termosecondicoes;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.adesao.termosecondicoes.TermosECondicoesTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class TermosECondicoesFunc extends FuncionalidadeBase {

    /**
     *
     * @param termosECondicoes
     * @param conteudoTermo
     * @throws Exception
     */
    public void selecionarEValidarTermoECondicaoEConteudoDoTermo(String termosECondicoes, String... conteudoTermo) throws Exception {
        new TermosECondicoesTela(getDriver())
                .validarCarregamentoTela()
                .selecionarTermo(termosECondicoes);
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(conteudoTermo);
    }
}
