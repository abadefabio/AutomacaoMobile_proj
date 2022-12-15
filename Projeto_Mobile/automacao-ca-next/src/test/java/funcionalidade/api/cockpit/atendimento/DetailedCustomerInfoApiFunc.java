package funcionalidade.api.cockpit.atendimento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;
import funcionalidade.api.cockpit.base.CaApi;
import org.json.simple.JSONObject;

import static br.com.next.automacao.core.base.TesteBase.*;
import static br.com.next.automacao.core.tools.ReadProperties.getEsteira;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class DetailedCustomerInfoApiFunc extends FuncionalidadeBase {

    protected RespostaBase respostaBase;

    /**
     * Envia uma requisição uma única vez por instanciação da funcionalidade,
     * A resposta é mantida na instância para futuras validações.
     *
     * @return
     * @throws NextException
     */

    public void enviarRequisicaoGet(String endpoint, String token) throws NextException {
        getDadosRequisicao()
                .limparDadosRequisicao()
                .definirCaminhoRequisicao(endpoint);
        respostaBase = new CaApi(getDadosRequisicao())
                .enviarRequisicaoGet(token, getEsteira());
        logarPasso(respostaBase.getResponse().asPrettyString());
    }

    /**
     * Valida dados do cliente Joy no Visão 360
     *
     * @param cpf do cliente
     * @param jsonObject da massa pertinente ao Visão 360
     * @return
     */
    public void validarInfoVisao360ClienteJoy(String cpf, JSONObject jsonObject) {

        final String PRODDESCR1 = "proposalData.listOfproducts[1].productDescription";
        final String PRODDESCR0 = "proposalData.listOfproducts[0].productDescription";
        final String FATHERNAME = "fatherName";
        final String DOB = "dateOfBirth";
        final String CUSTTYPEDESCR = "customerTypeDescription";
        final String ONBOARDINGSTATUS = "onboardingStatus";

        respostaBase.getResponse().then()
                .body("cpf", is(cpf))
                .body("representative", is(false))
                .body(PRODDESCR1, is(jsonObject.get(PRODDESCR1)))
                .body(PRODDESCR0, is(jsonObject.get(PRODDESCR0)))
                .body("name", is(jsonObject.get("name")))
                .body(FATHERNAME, is(jsonObject.get(FATHERNAME)))
                .body("email", is(jsonObject.get("email")))
                .body(DOB, is(jsonObject.get(DOB)))
                .body(CUSTTYPEDESCR, is(jsonObject.get(CUSTTYPEDESCR)))
                .body(ONBOARDINGSTATUS, is(Integer.parseInt(jsonObject.get(ONBOARDINGSTATUS).toString())))
                .body("age",is(Integer.parseInt(jsonObject.get("age").toString())))
                .body("gender",is(jsonObject.get("gender")));
    }

    /**
     * Valida dados do cliente Next no Visão 360
     * @param cpf do cliente Next
     * @param jsonObject da massa pertinente ao Visão 360
     * @return
     */
    public void validarInfoVisao360ClienteNext(String cpf, JSONObject jsonObject) {

        final String PRODDESCR1 = "proposalData.listOfproducts[1].productDescription";
        final String PRODDESCR0 = "proposalData.listOfproducts[0].productDescription";
        final String DOB = "dateOfBirth";
        final String CUSTTYPEDESCR = "customerTypeDescription";
        final String ONBOARDINGSTATUS = "onboardingStatus";
        final String PHONE_CC = "phoneNumbers.countryCode";
        final String PHONE_AC = "phoneNumbers.areaCode";
        final String PHONENUM = "phoneNumbers.phoneNumber[0]";

        respostaBase.getResponse().then()
                .body("cpf", is(cpf))
                .body("representative", is(true))
                .body(PRODDESCR1, is(jsonObject.get(PRODDESCR1)))
                .body(PRODDESCR0, is(jsonObject.get(PRODDESCR0)))
                .body("name", is(jsonObject.get("name")))
                .body("email", is(jsonObject.get("email")))
                .body(DOB, is(jsonObject.get(DOB)))
                .body(CUSTTYPEDESCR, is(jsonObject.get(CUSTTYPEDESCR)))
                .body(ONBOARDINGSTATUS, is(Integer.parseInt(jsonObject.get(ONBOARDINGSTATUS).toString())))
                .body(PHONE_CC, hasItem(jsonObject.get(PHONE_CC)))
                .body(PHONE_AC, hasItem(jsonObject.get(PHONE_AC)))
                .body(PHONENUM, is(Integer.parseInt(jsonObject.get(PHONENUM).toString())))
                .body("gender",is(jsonObject.get("gender")));
    }

    /**
     * Valida dados de endereço do cliente (tanto Next como Joy)
     *
     * @param jsonObject da massa pertinente à validação de endereço
     * @return
     */
    public void validarEnderecoClienteComumNextJoy(JSONObject jsonObject) {

        final String STREET = "addresses.streetName[0]";
        final String STREETNUM = "addresses.streetNumber[0]";
        final String NEIGHBH = "addresses.neighbourhood[0]";
        final String CITY = "addresses.cityName[0]";
        final String STATE = "addresses.state[0]";
        final String POSTALCODE = "addresses.postalCode[0]";

        respostaBase.getResponse().then()
                .body(STREET, is(jsonObject.get(STREET)))
                .body(STREETNUM,is(jsonObject.get(STREETNUM)))
                .body(NEIGHBH,is(jsonObject.get(NEIGHBH)))
                .body(CITY,is(jsonObject.get(CITY)))
                .body(STATE,is(jsonObject.get(STATE)))
                .body(POSTALCODE,is(jsonObject.get(POSTALCODE)));
    }

}
