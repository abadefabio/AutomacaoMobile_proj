package funcionalidade.web.sistemadegestao.termoCondicoes;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.sistemadegestao.termosEAceite.TermoAceiteTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class TermosECondicoesFunc extends FuncionalidadeBase {

    /**
     * Clicar no Link Parceiros
     *
     * @throws Exception
     */
    public void clicarLinkParceiros(String tipoDocumento, String texto, String textoCampo, String textoPreview) throws Exception {
        new TermoAceiteTela(getWebDriver())
                .preencherCampoTipoDocumento(tipoDocumento)
                .clicarBotaoConsultar()
                .clicarBotaoDetalhe();
        new TermoAceiteTela(getWebDriver())
                .validarTituloTelaDetalhe(texto)
                .validarCampoDetalhe(textoCampo)
                .validarCampoPrivew(textoPreview);

    }
}
