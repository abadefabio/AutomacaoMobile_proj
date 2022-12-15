package funcionalidade.massa.nextjoy;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.tools.Utilitarios;
import dados.portal.funcionalidades.PortalAdesaoNext;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

import static dados.portal.utils.PortalMassasUtil.alterPropertiesJsonObject;

public class MassaQA18397 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json1;
        JSONObject json2;
        var arquivoJson = obterJsonTesteAtual();

        if (arquivoJson.get("criarMassaAutomatica").equals(false)) {
            return arquivoJson;
        }

        //cpf Dependente
        String cpfDependente = Utilitarios.gerarCpf();

        //Criação do Responsável 01
        json1 = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorialComEmail(null, StatusAdesaoOnboarding.APROVADA_FINALIZADA, "fuladociclado43458@next.com");

        if (json1 == null) {
            return arquivoJson;
        }

        JSONObject jsonObjectCpfs = new JSONObject();
        jsonObjectCpfs.put("cpfDependente",cpfDependente);
        jsonObjectCpfs.put("cpfResponsavel1",json1);
        alterPropertiesJsonObject(jsonObjectCpfs,arquivoJson);

        //Criação do Responsável 02
        json2 = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorialComEmail(null, StatusAdesaoOnboarding.SOB_ANALISE, "fuladociclado43458@next.com");


        if (json2 == null) {
            json2 = arquivoJson;

        }

        jsonObjectCpfs.put("cpfResponsavel2", json2);
        alterPropertiesJsonObject(jsonObjectCpfs,arquivoJson);


        return json1;
    }
}
