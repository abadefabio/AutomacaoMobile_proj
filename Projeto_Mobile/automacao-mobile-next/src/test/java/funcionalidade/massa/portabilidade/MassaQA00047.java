package funcionalidade.massa.portabilidade;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.constantes.massa.tdm.StatusPortabilidade;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.core.CoreTrazerMeuSalario;
import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

import javax.swing.text.MaskFormatter;

public class MassaQA00047 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject arquivoJSON = obterJsonTesteAtual();
        CoreTrazerMeuSalario massa = new CoreTrazerMeuSalario();
        MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
        String cnpj = Utilitarios.geradorCnpj();
        String bankCode = "33";

        //Sleep necessario para dar tempo da adesao ser criada antes da portabilidade ser criada
        JSONObject json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJSON, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
        Thread.sleep(5000);

        //Sleep necessario para dar tempo do request passar para concluida a portabilidade
        new PortalConta().realizarPortabilidade(json, cnpj, bankCode);
        Thread.sleep(5000);
        massa.alterarStatusPortabilidade(json.get("cpf").toString(), StatusPortabilidade.PENDENTE_EM_PROCESSAMENTO);

        mask.setValueContainsLiteralCharacters(false);
        json.replace("cnpjPortabilidadePendente", cnpj);
        json.replace("cnpj", mask.valueToString(cnpj));

        return json;
    }
}
