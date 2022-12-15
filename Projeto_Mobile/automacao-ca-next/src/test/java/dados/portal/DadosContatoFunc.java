package dados.portal;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.bradesco.next.test.data.provider.client.model.CreateBankContactOtherOwnershipRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateBankContactOtherOwnershipResponse;
import br.com.bradesco.next.test.data.provider.client.model.CreateBankContactSameOwnershipRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateBankContactSameOwnershipResponse;
import br.com.bradesco.next.test.data.provider.client.model.CreateFinancialInstitutionContactOtherOwnershipRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateFinancialInstitutionContactOtherOwnershipResponse;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.massa.transferencia.DadosEmail;
import dados.base.PortalMassasClient;
import org.json.simple.JSONObject;

import static dados.base.PortalMassasClient.getCoreIP;
import static dados.base.PortalMassasClient.getEsteira;


public class DadosContatoFunc {


    public static void criarContatoBancoParaMim(JSONObject arquivoJsonMassa) {

        var objeto = (JSONObject) arquivoJsonMassa.get("objeto");

        CreateBankContactSameOwnershipRequest request = new CreateBankContactSameOwnershipRequest();
        request.document(arquivoJsonMassa.get("cpf").toString());
        request.accountNumber(objeto.get("conta").toString());
        request.bankId(objeto.get("bankId").toString());
        request.branch(objeto.get("agencia").toString());

        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Iniciando criacao de contato");
        CreateBankContactSameOwnershipResponse response = null;
        try {
            response = new PortalMassasClient()
                    .testDataContactControllerApi()
                    .createBankContactSameOwnership(getCoreIP(),
                            getEsteira(),
                            ReadProperties.getEmuladorUser(),
                            ReadProperties.getEmuladorPass(),
                            request);
        } catch (ApiException e) {
            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Não foi possível criar o contato do tipo para MIM! Erro: " + e.getResponseBody());
        }
        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Response criacao de contato" + response);
    }

    public static void criarContatoBancoParaOutraPessoa(JSONObject arquivoJsonMassa) {

        var objeto = (JSONObject) arquivoJsonMassa.get("objeto");

        CreateBankContactOtherOwnershipRequest request = new CreateBankContactOtherOwnershipRequest();
        request.accountNumber(objeto.get("conta").toString());
        request.bankId(objeto.get("bankId").toString());
        request.branch(objeto.get("agencia").toString());
        request.contactDocument(objeto.get("cpfDestino").toString());
        request.contactType(CreateBankContactOtherOwnershipRequest.ContactTypeEnum.OUTROS_BANCOS);
        request.document(arquivoJsonMassa.get("cpf").toString());
        request.email(DadosEmail.EMAIL_TESTE.toString());
        request.name(objeto.get("nome").toString());
        request.surname(objeto.get("sobrenome").toString());

        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Iniciando criacao de contato");
        CreateBankContactOtherOwnershipResponse response = null;
        try {
            response = new PortalMassasClient()
                    .testDataContactControllerApi()
                    .createBankContactOtherOwnership(getCoreIP(),
                            getEsteira(),
                            ReadProperties.getGestaoUser(),
                            ReadProperties.getGestaoPass(),
                            request);
        } catch (ApiException e) {
            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Não foi possível criar o contato do tipo para OUTRA PESSOA! Erro: " + e.getResponseBody());
        }
        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Response criacao de contato" + response);
    }

    public static void criarContatoInstituicaoPagamentoParaOutraPessoa(JSONObject arquivoJsonMassa) {

        var objeto = (JSONObject) arquivoJsonMassa.get("objeto");

        CreateFinancialInstitutionContactOtherOwnershipRequest request = new CreateFinancialInstitutionContactOtherOwnershipRequest();
        request.bankId(objeto.get("bankId").toString());
        request.branchId(objeto.get("branchId").toString());
        request.contactDocument(objeto.get("cpfcnpj").toString());
        request.document(arquivoJsonMassa.get("cpf").toString());
        request.email(DadosEmail.EMAIL_TESTE.toString());
        request.institutionIspb(objeto.get("intituicaoBancoISPB").toString());
        request.institutionName(objeto.get("intituicaoBanco").toString());
        request.name(objeto.get("nome").toString());
        request.paymentAccount(objeto.get("contapagamento").toString());
        request.surname(objeto.get("sobrenome").toString());

        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Iniciando criacao de contato");
        CreateFinancialInstitutionContactOtherOwnershipResponse response = null;
        try {
            response = new PortalMassasClient()
                    .testDataContactControllerApi()
                    .createFinancialInstitutionContactOtherOwnership(getCoreIP(),
                            getEsteira(),
                            ReadProperties.getGestaoUser(),
                            ReadProperties.getGestaoPass(),
                            request);
        } catch (ApiException e) {
            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Não foi possível criar o contato do tipo INSTITUICAO PAGAMENTO OUTRA PESSOA! Erro: " + e.getResponseBody());
        }
        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Response criacao de contato" + response);
    }

}
