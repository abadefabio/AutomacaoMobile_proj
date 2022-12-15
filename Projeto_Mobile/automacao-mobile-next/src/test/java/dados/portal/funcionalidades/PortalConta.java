package dados.portal.funcionalidades;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.bradesco.next.test.data.provider.client.model.SalaryPortabilityRequest;
import dados.portal.base.BasePortalFunc;
import dados.portal.base.PortalMassasClient;
import org.json.simple.JSONObject;

import java.util.HashMap;

import static dados.portal.base.PortalMassasClient.getCoreIP;
import static dados.portal.base.PortalMassasClient.getCsrUserId;
import static dados.portal.base.PortalMassasClient.getCsrUserPassword;
import static dados.portal.base.PortalMassasClient.getEsteira;

public class PortalConta extends BasePortalFunc {

    /**
     * Adição de saldo em conta next
     *
     * @param arquivoJson JsonObject contendo o CPF recuperado do arquivo json de massa
     * @param tipoConta   Tipo de conta que será feito a inclusão do saldo. Ex.: AddBalanceRequest.AccountTypeEnum.CORRENTE
     * @param valor
     */
    public boolean adicionarSaldo(JSONObject arquivoJson, AddBalanceRequest.AccountTypeEnum tipoConta, double valor) {
        var response = executarPortal("Adição de saldo em conta next",
                new JSONObject() {{
                    put("CPF", arquivoJson.get("cpf").toString());
                    put("Tipo Conta", tipoConta.name());
                    put("Valor", valor);
                }},
                () -> {

                    AddBalanceRequest body = new AddBalanceRequest();

                    body.setDocument(arquivoJson.get("cpf").toString());
                    body.setValue(valor + "");
                    body.setAccountType(tipoConta);

                    return new PortalMassasClient()
                            .testDataAccountControllerApi()
                            .addBalance(getCoreIP(), body);
                });

        return response != null;
    }

    /**
     * Realiza portabilidade de salário
     *
     * @param arquivoJson
     * @param cnpj
     * @param bankCode
     */
    public void realizarPortabilidade(JSONObject arquivoJson, String cnpj, String bankCode) {
        executarPortal("Realizar portabilidade de salário",
                new JSONObject() {{
                    put("CPF", arquivoJson.get("cpf").toString());
                    put("CNPJ", cnpj);
                    put("Banco", bankCode);
                }},
                () -> {
                    SalaryPortabilityRequest body = new SalaryPortabilityRequest();
                    body.setDocument(arquivoJson.get("cpf").toString());
                    body.setPayingCompanyCNPJ(cnpj);
                    body.setBankCode(bankCode);

                    return new PortalMassasClient()
                            .testDataAccountControllerApi()
                            .salaryPortability(getCoreIP(),
                                    getEsteira(),
                                    getCsrUserId(),
                                    getCsrUserPassword(),
                                    body);
                });
    }
}
