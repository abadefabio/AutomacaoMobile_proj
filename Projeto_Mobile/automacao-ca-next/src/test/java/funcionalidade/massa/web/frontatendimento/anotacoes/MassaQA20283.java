package funcionalidade.massa.web.frontatendimento.anotacoes;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import org.json.simple.JSONObject;

@SuppressWarnings("unused")
public class MassaQA20283 extends BaseQAFunc implements CasoDeTesteMassa {

    /**
     * Realiza a criação da massa de dados para o teste
     *
     * @return Retorna um objeto do tipo Json Object com as informações da massa criada
     * @throws Exception
     */
    @Override
    public JSONObject criar() throws Exception {

        return lerArquivoJson(recuperarClasseDeTeste());

    }
}
