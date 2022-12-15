package funcionalidade.mobile.portabilidade;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.portabilidade.DetalhesPortabilidade;
import org.json.simple.JSONObject;
import pagina.mobile.jornadas.portabilidade.VerDetalhesTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class VerDetalhesFunc  extends FuncionalidadeBase {

    /**
     * Validar a tela Detalhes (Trazer meu salário)
     *
     * @param portabilidade
     * @throws Exception
     */
    public void validarDetalhesPortabilidade(DetalhesPortabilidade portabilidade) throws Exception {
        new VerDetalhesTela(getDriver())
                .validarInformacoesVerDetalhes(portabilidade)
                .tocarBotaoFechar();
    }

    /**
     * Validar a tela Detalhes (Trazer meu salário)
     *
     * @param portabilidade
     * @throws Exception
     */
    public void validarDetalhesPortabilidade(JSONObject portabilidade) throws Exception {
        new VerDetalhesTela(getDriver())
                .validarInformacoesVerDetalhes(portabilidade)
                .tocarBotaoFechar();
    }
}
