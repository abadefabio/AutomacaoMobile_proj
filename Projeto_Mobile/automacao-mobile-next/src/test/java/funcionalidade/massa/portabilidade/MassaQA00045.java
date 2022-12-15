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

public class MassaQA00045 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject arquivoJson = obterJsonTesteAtual();
        MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
        CoreTrazerMeuSalario massa = new CoreTrazerMeuSalario();
        String cnpj1 = Utilitarios.geradorCnpj();
        String cnpj2 = Utilitarios.geradorCnpj();
        String bankCode = "33";

        //Sleep necessario para dar tempo da adesao ser criada antes da portabilidade ser criada
        JSONObject json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJson, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
        Thread.sleep(5000);

        //Sleep necessario para dar tempo do request passar a segunda portabilidade pro Status 51
        new PortalConta().realizarPortabilidade(json, cnpj2, bankCode);
        Thread.sleep(5000);
        massa.alterarStatusPortabilidade(json.get("cpf").toString(), DetalhesPortabilidade.PORTABILIDADE_OUTROS_BANCOS_STATUS_51_CNPJ);
        Thread.sleep(5000);

        new PortalConta().realizarPortabilidade(json, cnpj1, bankCode);

        mask.setValueContainsLiteralCharacters(false);
        json.replace("cnpj1", mask.valueToString(cnpj1));
        json.replace("cnpj2", mask.valueToString(cnpj2));

        return json;
    }
}
