package dados.portal.funcionalidades;

import br.com.bradesco.next.test.data.provider.client.model.CreateBankContactOtherOwnershipRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateBankContactSameOwnershipRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateFinancialInstitutionContactOtherOwnershipRequest;
import br.com.next.automacao.core.tools.Utilitarios;
import dados.portal.base.BasePortalFunc;
import dados.portal.base.PortalMassasClient;
import org.json.simple.JSONObject;

import static dados.portal.base.PortalMassasClient.getCoreIP;
import static dados.portal.base.PortalMassasClient.getCsrUserId;
import static dados.portal.base.PortalMassasClient.getCsrUserPassword;
import static dados.portal.base.PortalMassasClient.getEsteira;
import static dados.portal.utils.PortalMassasUtil.alterPropertiesJsonObject;
import static dados.portal.utils.PortalMassasUtil.convertResponseJsonObject;

public class PortalContato extends BasePortalFunc {

    /**
     * Criação de contato tipo banco de mesma titularidade
     *
     * @param arquivoJson
     * @param bankCode
     */
    public void criarContatoMesmaTitularidade(JSONObject arquivoJson, String bankCode) {
        executarPortal("Criação de contato mesma titularidade",
                new JSONObject() {{
                    put("CPF", arquivoJson.get("cpf").toString());
                    put("Banco", bankCode);
                }},
                () -> {
                    CreateBankContactSameOwnershipRequest body = new CreateBankContactSameOwnershipRequest();
                    body.document(arquivoJson.get("cpf").toString());
                    body.bankId(bankCode);

                    return new PortalMassasClient()
                            .testDataContactControllerApi()
                            .createBankContactSameOwnership(
                                    getCoreIP(),
                                    getEsteira(),
                                    getCsrUserId(),
                                    getCsrUserPassword(),
                                    body);
                });
    }

    /**
     * Criação de contato tipo banco de mesma titularidade passando agencia e conta do contato
     *
     * @param arquivoJson
     * @param bancoId
     * @param agencia
     * @param conta
     * @return
     * @throws Exception
     */
    public JSONObject criarContatoMesmaTitularidadeRetornandoContato(JSONObject arquivoJson, String bancoId, String agencia, String conta) throws Exception {
        var response = executarPortal("Criação de contato mesma titularidade",
                new JSONObject() {{
                    put("CPF", arquivoJson.get("cpf").toString());
                    put("Banco", bancoId);
                    put("Agência", agencia);
                    put("Conta", conta);
                }},
                () -> {
                    var body = new CreateBankContactSameOwnershipRequest();
                    body.setDocument(arquivoJson.get("cpf").toString());
                    body.setBankId(bancoId);
                    body.setBranch(agencia);
                    body.setAccountNumber(conta);

                    return new PortalMassasClient()
                            .testDataContactControllerApi()
                            .createBankContactSameOwnership(
                                    getCoreIP(),
                                    getEsteira(),
                                    getCsrUserId(),
                                    getCsrUserPassword(),
                                    body);

                });

        var contactResponseJson = convertResponseJsonObject(response);
        return alterPropertiesJsonObject(contactResponseJson, arquivoJson);
    }

    /**
     * Criação de contato outra titularidade passando agencia e conta do contato
     *
     * @param arquivoJson
     * @param bancoId
     * @param agencia
     * @param conta
     * @return
     * @throws Exception
     */
    public void criarContatoOutraTitularidadeOutrosBancos(JSONObject arquivoJson, String bancoId, String agencia, String conta) throws Exception {
        executarPortal("Criação de contato mesma titularidade",
                new JSONObject() {{
                    put("CPF", arquivoJson.get("cpf").toString());
                    put("Banco", bancoId);
                    put("Agência", agencia);
                    put("Conta", conta);
                }},
                () -> {

                    CreateBankContactOtherOwnershipRequest body = new CreateBankContactOtherOwnershipRequest();
                    body.setDocument(arquivoJson.get("cpf").toString());
                    body.setBankId(bancoId);
                    body.setBranch(agencia);
                    body.setAccountNumber(conta);
                    body.setEmail(Utilitarios.geradorDeEmail());
                    body.setContactDocument(Utilitarios.gerarCpf());
                    body.setContactType(CreateBankContactOtherOwnershipRequest.ContactTypeEnum.OUTROS_BANCOS);
                    body.setName(Utilitarios.geradorPalavra(5));
                    body.setSurname(Utilitarios.geradorPalavra(5));

                    return new PortalMassasClient()
                            .testDataContactControllerApi()
                            .createBankContactOtherOwnership(
                                    getCoreIP(),
                                    getEsteira(),
                                    getCsrUserId(),
                                    getCsrUserPassword(),
                                    body);

                });
    }

    /**
     * Criação de contato intituicao pagamento agencia e conta do contato
     *
     * @param arquivoJson
     * @param bancoId
     * @param agencia
     * @param conta
     * @return
     * @throws Exception
     */
    public void criarContatoIntituicaoPagamento(JSONObject arquivoJson, String bancoId, String bancoNome, String ispb, String agencia, String conta) throws Exception {
        executarPortal("Criação de contato mesma titularidade",
                new JSONObject() {{
                    put("CPF", arquivoJson.get("cpf").toString());
                    put("Banco", bancoId);
                    put("Banco Nome", bancoNome);
                    put("ISBP", ispb);
                    put("Agência", conta);
                    put("Conta", conta);
                }},
                () -> {
                    CreateFinancialInstitutionContactOtherOwnershipRequest body = new CreateFinancialInstitutionContactOtherOwnershipRequest();
                    body.setDocument(arquivoJson.get("cpf").toString());
                    body.setBankId(bancoId);
                    body.setInstitutionName(bancoNome);
                    body.setBranchId(agencia);
                    body.setPaymentAccount(conta);
                    body.setEmail(Utilitarios.geradorDeEmail());
                    body.setInstitutionIspb(ispb);
                    body.setContactDocument(Utilitarios.gerarCpf());
                    body.setName(Utilitarios.geradorPalavra(5));
                    body.setSurname(Utilitarios.geradorPalavra(6));

                    var response = new PortalMassasClient()
                            .testDataContactControllerApi()
                            .createFinancialInstitutionContactOtherOwnership(
                                    getCoreIP(),
                                    getEsteira(),
                                    getCsrUserId(),
                                    getCsrUserPassword(),
                                    body);

                    JSONObject json = new JSONObject();
                    json.put("nome", response.getName());
                    json.put("sobrenome", response.getSurname());
                    json.put("banco", response.getInstitutionName());
                    json.put("conta", response.getPaymentAccount());

                    return json;
                });
    }
}
