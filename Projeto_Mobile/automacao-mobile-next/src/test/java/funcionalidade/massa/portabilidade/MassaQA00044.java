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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MassaQA00044 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject arquivoJSON = obterJsonTesteAtual();
        CoreTrazerMeuSalario massa = new CoreTrazerMeuSalario();
        MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
        String cnpj = Utilitarios.geradorCnpj();
        String bankCode = "33";

        JSONObject json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJSON, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);

        //Gerando portabilidade concluida:
        //Sleep necessario para dar tempo da adesao ser criada antes da portabilidade ser criada
        Thread.sleep(5000);
        new PortalConta().realizarPortabilidade(json, Utilitarios.geradorCnpj(), bankCode);
        massa.alterarStatusPortabilidade(json.get("cpf").toString(), DetalhesPortabilidade.PORTABILIDADE_OUTROS_BANCOS_STATUS_02_CNPJ);

        //Gerando portabilidade pendente a ser usada no teste:
        //Sleep necessario para dar tempo do request passar para concluida somente a primeira portabilidade
        Thread.sleep(5000);
        new PortalConta().realizarPortabilidade(json, cnpj, bankCode);

        mask.setValueContainsLiteralCharacters(false);
        json.replace("cpfCnpjFormatado",  mask.valueToString(cnpj));
        ((JSONObject) json.get("portabilidade")).replace("CPF/CNPJ", cnpj);
        ((JSONObject) json.get("portabilidade")).replace("Data da Solicitação", Utilitarios.calcularDataRelativaHoje(0));

        return arquivoJSON;
    }
}
