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


        /* Caso a massa tenha perdido a config., pode rodar com a massa autom�tica para criar um novo cpf multibank e
         * e depois deve ser colocado no json manualmente - parametro no json - criarMassaAutomatica >> True */
        if (json.get("criarMassaAutomatica").equals(false)) {
            return json;
        }

        /* Respons�vel 01 - Multibank
        Rodar a query do CPF multibanco em paralelo com a ades�o Next,
        depois esperar ambos finalizarem para ent�o realizar a ades�o Joy
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
        E ent�o efetua a ades�o Joy multibank com os dados de external customer obtidos no thread
        de sele��o de CPF do multibanco.
        � melhor deixar esta ades�o por �ltimo para n�o correr o risco de gerar esta massa
        sem ter gerado a ades�o Next primeiro, o que faria "desperdi�ar" esta massa finita no banco de dados.
        */
        JSONObject resposta;
        try {
            resposta = new PortalAdesaoJoyMultibank().criarAdesaoJoyMultibank(externalCustomer, arquivoJson);
        } catch (Exception e) {
            throw new RuntimeException("Falha na ades�o Joy. Sem a ades�o Joy o teste n�o pode continuar...");
        }


        /*
        Criar ades�o Next para o respons�vel 2 - NEXT
        */
        var jsonResponsavel2 = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(new JSONObject(), StatusAdesaoOnboarding.APROVADA_FINALIZADA);

        /*
        Atualiza o json de massa e retorna
        */
        json.replace("cpf", jsonResponsavel2.get("document")); // cpf do respons�vel 2 (next)
        json.replace("cpfsMultibank", resposta);   // resposta com cpf respons�vel 1 (Multibanco) e CPF dependente
        return json;
    }

}
