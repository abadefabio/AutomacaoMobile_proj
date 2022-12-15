package funcionalidade.massa.portabilidade;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

import static dados.portal.utils.PortalMassasUtil.convertResponseJsonObject;

public class MassaQA00046 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json, arquivoJson = obterJsonTesteAtual();
        var portabilidade = convertResponseJsonObject(arquivoJson.get("portabilidade"));
        var cpfCnpjPortabilidade = portabilidade.get("CPF/CNPJ").toString();
        String cnpj = Utilitarios.geradorCnpj();
        String bankCode = "341";

        //Sleep necessario para dar tempo da adesao ser criada antes da portabilidade ser criada
        json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJson, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
        Thread.sleep(5000);
        new PortalConta().realizarPortabilidade(json, cpfCnpjPortabilidade, bankCode);

        json.replace(portabilidade.get("CPF/CNPJ"), cnpj);

        return json;
    }
}
