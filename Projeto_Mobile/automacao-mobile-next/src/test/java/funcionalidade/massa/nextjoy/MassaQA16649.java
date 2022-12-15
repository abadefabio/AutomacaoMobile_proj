package funcionalidade.massa.nextjoy;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.exception.NextException;
import constantes.nextJoy.ConfigMultibanco;
import dados.portal.funcionalidades.PortalAdesaoJoyMultibank;
import dados.database.ContaMultibankSelecaoExternalCustomer;
import dados.portal.funcionalidades.PortalAdesaoNext;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

import java.sql.SQLException;


@SuppressWarnings("unchecked")
public class MassaQA16649 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {


        var json = obterJsonTesteAtual();


        /* Caso a massa tenha perdido a config., pode rodar com a massa automática para criar um novo cpf multibank e
         * e depois deve ser colocado no json manualmente - parametro no json - criarMassaAutomatica >> True */
        if (json.get("criarMassaAutomatica").equals(false)) {
            return json;
        }

        /* Responsável 01 - Multibank
        Rodar a query do CPF multibanco em paralelo com a adesão Next,
        depois esperar ambos finalizarem para então realizar a adesão Joy
         */

        JSONObject arquivoJson = new JSONObject();
        ContaMultibankSelecaoExternalCustomer.ExternalCustomer externalCustomer;

        ContaMultibankSelecaoExternalCustomer contaMultibank = new ContaMultibankSelecaoExternalCustomer();
        try {
            contaMultibank.selecionarCpfResponsavel(ConfigMultibanco.MAX_DEPENDENTES_CPF_MULTIBANK);
            externalCustomer = contaMultibank.getExternalCustomer();
        } catch (SQLException | NextException e) {
            throw new RuntimeException(e);
        }

        /*
        E então efetua a adesão Joy multibank com os dados de external customer obtidos no thread
        de seleção de CPF do multibanco.
        É melhor deixar esta adesão por último para não correr o risco de gerar esta massa
        sem ter gerado a adesão Next primeiro, o que faria "desperdiçar" esta massa finita no banco de dados.
        */
        JSONObject resposta;
        try {
            resposta = new PortalAdesaoJoyMultibank().criarAdesaoJoyMultibank(externalCustomer, arquivoJson);
        } catch (Exception e) {
            throw new RuntimeException("Falha na adesão Joy. Sem a adesão Joy o teste não pode continuar...");
        }


        /*
        Criar adesão Next para o responsável 2 - NEXT
        */
        var jsonResponsavel2 = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(new JSONObject(), StatusAdesaoOnboarding.APROVADA_FINALIZADA);

        /*
        Atualiza o json de massa e retorna
        */
        json.replace("cpf", jsonResponsavel2.get("document")); // cpf do responsável 2 (next)
        json.replace("cpfsMultibank", resposta);   // resposta com cpf responsável 1 (Multibanco) e CPF dependente
        return json;
    }

}
