package funcionalidade.massa.transferencia;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.bradesco.next.test.data.provider.client.model.CreateOnboardingRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.client.portal.massas.PortalMassasClient;
import funcionalidade.massa.MassaFunc;
import org.json.simple.JSONObject;

import static dados.client.portal.massas.PortalMassasClient.getCoreIP;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserId;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserPassword;
import static dados.client.portal.massas.PortalMassasClient.getEsteira;
import static dados.client.portal.massas.utils.PortalMassasUtil.alterPropertiesJsonObject;
import static dados.client.portal.massas.utils.PortalMassasUtil.convertResponseJsonObject;

public class MassaQA21298 implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return new MassaFunc().lerArquivoJson("QA21298");
    }
}

