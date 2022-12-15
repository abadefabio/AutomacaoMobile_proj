package funcionalidade.massa.nextjoy;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.tools.Utilitarios;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.portal.funcionalidades.PortalAdesaoNext;
import org.json.simple.JSONObject;

import static dados.portal.utils.PortalMassasUtil.alterPropertiesJsonObject;

public class MassaQA18395 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json, arquivoJson = obterJsonTesteAtual();
        var jsonOnbording = arquivoJson;

        //cpf Dependente
        String cpfDependente = Utilitarios.gerarCpf();
        jsonOnbording.replace("cpfDependente",cpfDependente);

        //Criação do Responsável 01
            json = new PortalAdesaoNext().criacaoAdesaoAtivadoComTutorialComEmail(new JSONObject(), StatusAdesaoOnboarding.APROVADA_FINALIZADA, "fuladociclado43458@next.com");
            if (json.size() != 0) {
                jsonOnbording.replace("cpfResponsavel1", json.get("document"));
            }


        //Criação do Responsável 02
            json = new PortalAdesaoNext().criacaoAdesaoAtivadoComTutorialComEmail(new JSONObject(),StatusAdesaoOnboarding.SOB_ANALISE, "fuladociclado43458@next.com");
            if (json.size() != 0) {
                jsonOnbording.replace("cpfResponsavel2", json.get("document"));
            }

        return jsonOnbording;
    }

}
