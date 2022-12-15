package funcionalidade.web.sistemadegestao.mimos.card;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.sistemadegestao.Menu.SistemaDeGestaoTabelaCardsTela;
import pagina.web.sistemadegestao.Mimos.Card.SistemaDeGestaoCardTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;


public class SistemaDeGestaoCardFunc extends FuncionalidadeBase {

    /**
     * Clicar no Link Editar CARD
     * @param idCard
     * @throws Exception
     */
    public void clicarLinkEditarCard(String idCard) throws Exception {
        new SistemaDeGestaoTabelaCardsTela(getWebDriver())
                .clicarLinkEditCard(idCard);
    }

    /**
     * Alterar campo do texto do card
     * @param texto
     * @throws Exception
     */
    public void editarTextoCard(String texto) throws Exception {
        new SistemaDeGestaoCardTela(getWebDriver())
                .preencherCampoTexto(texto)
                .clicarBotaoAlterar()
                .clicarBotaoSim()
                .clicarBotaoOK();
        new SistemaDeGestaoTabelaCardsTela(getWebDriver())
                .validarTela();
    }

    /**
     * Verificar campo do texto do card
     * @param texto
     * @throws Exception
     */
    public void verificarTextoCard(String texto) throws Exception {
        new SistemaDeGestaoCardTela(getWebDriver())
                .validarCampoTextoCard(texto)
                .clicarBotaoAprovar()
                .clicarBotaoSim()
                .clicarBotaoOK();
        new SistemaDeGestaoTabelaCardsTela(getWebDriver())
                .validarTela();
    }

}
