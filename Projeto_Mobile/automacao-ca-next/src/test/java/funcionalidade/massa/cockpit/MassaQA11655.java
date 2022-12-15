package funcionalidade.massa.cockpit;

import br.com.next.automacao.core.constantes.massa.callcenter.*;
import br.com.next.automacao.core.massa.portal.qualidade.*;
import dados.base.*;
import dados.portal.*;
import org.json.simple.*;

public class MassaQA11655 extends BaseQAFunc implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        return new IntegracaoDeDadosFunc()
                .criacaoAdesaoNaoAtivadoComTutorial(
                        lerArquivoJson(recuperarClasseDeTeste()),
                        StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
    }

}
