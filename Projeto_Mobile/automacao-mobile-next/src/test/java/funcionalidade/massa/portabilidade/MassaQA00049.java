package funcionalidade.massa.portabilidade;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.portabilidade.DetalhesPortabilidade;
import dados.core.CoreTrazerMeuSalario;
import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

import javax.swing.text.MaskFormatter;

public class MassaQA00049 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        CoreTrazerMeuSalario massa = new CoreTrazerMeuSalario();
        JSONObject json, arquivoJson = obterJsonTesteAtual();
        String cnpj = Utilitarios.geradorCnpj();
        MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
        mask.setValueContainsLiteralCharacters(false);

        json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJson, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
        try {
            new PortalConta().realizarPortabilidade(json, cnpj, "33");
            json.replace("cnpj", mask.valueToString(cnpj));
            massa.alterarStatusPortabilidade(json.get("cpf").toString(), DetalhesPortabilidade.PORTABILIDADE_OUTROS_BANCOS_STATUS_02_CNPJ);
            Thread.sleep(5000);
        } catch (Exception e) {
            OperadorEvidencia.logarPasso("Não foi possível realizar a portabilidade da massa automática.");
        }
        return json;
    }
}
