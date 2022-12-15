package funcionalidade.massa.portabilidade;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

import javax.swing.text.MaskFormatter;

public class MassaQA00041 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject arquivoJSON = obterJsonTesteAtual();
        MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
        String cnpj = Utilitarios.geradorCnpj();
        String bankCode = "33";


        JSONObject json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJSON, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
        //Sleep necessario para dar tempo da adesao ser criada antes da portabilidade ser criada
        Thread.sleep(5000);
        new PortalConta().realizarPortabilidade(json, cnpj, bankCode);
        mask.setValueContainsLiteralCharacters(false);
        json.replace("cnpj", mask.valueToString(cnpj));

        return json;
    }
}
