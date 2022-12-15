package dados.portal.funcionalidades;

import br.com.bradesco.next.test.data.provider.client.model.ChangeInvestorProfileRequest;
import br.com.bradesco.next.test.data.provider.client.model.DoOthersInvestmentRequest;
import dados.portal.base.BasePortalFunc;
import dados.portal.base.PortalMassasClient;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static dados.portal.base.PortalMassasClient.getCoreIP;
import static dados.portal.base.PortalMassasClient.getCsrUserId;
import static dados.portal.base.PortalMassasClient.getCsrUserPassword;
import static dados.portal.base.PortalMassasClient.getEsteira;

public class PortalInvestimento extends BasePortalFunc {

    /**
     * Realiza/agenda investimento
     *
     * @param arquivoJson JsonObject contendo o CPF recuperado do arquivo json de massa
     * @param fundoId     Id do fundo que será investido
     * @param valorAporte valor do aporte do invetimento
     * @param data        data do investimento
     */
    public void realizarInvestimento(JSONObject arquivoJson, int fundoId, Double valorAporte, LocalDateTime data) {
        executarPortal("Realizar/agendar investimento",
                new JSONObject() {{
                    put("CPF", arquivoJson.get("cpf").toString());
                    put("Fundo Id", fundoId);
                    put("Aporte", valorAporte);
                    put("Data", data);
                }},
                () -> {
                    var body = new DoOthersInvestmentRequest();
                    body.setDocument(arquivoJson.get("cpf").toString());
                    body.setFundId(fundoId);
                    body.setTransactionAmount(valorAporte);
                    body.setScheduledDate(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(data));

                    return new PortalMassasClient()
                            .testDataInvestmentControllerApi()
                            .doOthersInvestment(
                                    getCoreIP(),
                                    getEsteira(),
                                    getCsrUserId(),
                                    getCsrUserPassword(),
                                    body);
                });
    }

    /**
     * Altera perfil de investidor
     *
     * @param arquivoJson JsonObject contendo o CPF recuperado do arquivo json de massa
     * @param perfil      atualizar perfil para este perfil
     */
    public void alterarPerfilInvestidor(JSONObject arquivoJson, ChangeInvestorProfileRequest.InvestorProfileTypeEnum perfil) {
        executarPortal("Alterar perfil de investidor",
                new JSONObject() {{
                    put("CPF", arquivoJson.get("cpf").toString());
                    put("Perfil", perfil.name());
                }},
                () -> {
                    var body = new ChangeInvestorProfileRequest();
                    body.setDocument(arquivoJson.get("cpf").toString());
                    body.setInvestorProfileType(perfil);

                    return new PortalMassasClient()
                            .testDataInvestmentControllerApi()
                            .changeInvestorProfile(getCoreIP(),
                                    getEsteira(),
                                    body);
                });
    }
}
