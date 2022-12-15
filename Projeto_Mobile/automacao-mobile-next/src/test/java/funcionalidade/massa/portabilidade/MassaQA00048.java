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

public class MassaQA00048 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        CoreTrazerMeuSalario massa = new CoreTrazerMeuSalario();
        JSONObject json, arquivoJson = obterJsonTesteAtual();
        String cnpj = Utilitarios.geradorCnpj();
        MaskFormatter mask = new MaskFormatter("##.###.###/####-##");

        json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJson, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
        Thread.sleep(5000);

        new PortalConta().realizarPortabilidade(json, cnpj, "33");
        Thread.sleep(5000);

        massa.alterarStatusPortabilidade(json.get("cpf").toString(), DetalhesPortabilidade.PORTABILIDADE_OUTROS_BANCOS_STATUS_02_CNPJ);

        mask.setValueContainsLiteralCharacters(false);
        json.replace("cnpjFormatado", mask.valueToString(cnpj));

        return json;
    }
}
