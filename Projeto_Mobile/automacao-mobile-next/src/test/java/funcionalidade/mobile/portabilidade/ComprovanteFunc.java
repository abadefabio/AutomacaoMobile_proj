package funcionalidade.mobile.portabilidade;

import constantes.portabilidade.DetalhesPortabilidade;
import org.json.simple.JSONObject;
import pagina.mobile.jornadas.portabilidade.ComprovanteTela;
import pagina.mobile.jornadas.portabilidade.TrazerMeuSalarioTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ComprovanteFunc {

    /**
     * Método para visualizar comprovante da Recarga
     *
     * @throws Exception
     */
    public void compartilharComprovante(DetalhesPortabilidade portabilidade) throws Exception {
        new ComprovanteTela(getDriver())
                .validarDataComprovante()
                .validarDadosComprovante(portabilidade)
                .tocarBotaoVisualizar()
                .validarPdf()
                .tocarBotaoCompartilhar();
    }

    /**
     * Método para visualizar comprovante da Recarga
     *
     * @throws Exception
     */
    public void compartilharComprovante(JSONObject portabilidade) throws Exception {
        new TrazerMeuSalarioTela(getDriver())
                .tocarBotaoVerDetalhes();
        new ComprovanteTela(getDriver())
                .validarDataComprovante()
                .validarDadosComprovante(portabilidade)
                .tocarBotaoVisualizar()
                .validarPdf()
                .tocarBotaoCompartilhar();
    }
}
