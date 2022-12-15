package funcionalidade.api.cockpit.atendimento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;
import funcionalidade.api.cockpit.base.CaApi;

import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static org.hamcrest.Matchers.*;

public class ListCustomerDependentsApiFunc extends FuncionalidadeBase {

    private RespostaBase respostaBase;

    /** Envia a requisição incial com os parametros do header
     *
     * @param token
     * @param endpoint
     * @param esteira
     * @throws NextException
     */
    public void enviarRequisicao(String endpoint, String token, String esteira) throws NextException {

        TesteBase.getDadosRequisicao()
                .limparDadosRequisicao()
                .definirCaminhoRequisicao(endpoint);
        respostaBase = new CaApi(TesteBase.getDadosRequisicao())
                .enviarRequisicaoGet(token, esteira);
        logarPasso(respostaBase.getResponse().asPrettyString());
    }

    /** Validar nomes dos dependentes
     *
     * @return
     */
    public ListCustomerDependentsApiFunc validarNomesDependentes() {
        respostaBase.getResponse()
                .then()
                .body("customerDependents", hasSize(5))
                .body("customerDependents.name", hasSize(5))
                .body("customerDependents.name", hasItems("FABIANO MATOS", "ALEXANDRA SILVA", "WILLIAN RODRIGUES", "ARTHUR SOARES", "ANTONIO DE PAULA"));
        return this;
    }

    /** Validar cpf dos dependentes
     *
     * @return
     */
    public ListCustomerDependentsApiFunc validarCpfsDependentes() {
        respostaBase.getResponse()
                .then()
                .body("customerDependents.cpf", hasSize(5))
                .body("customerDependents.cpf", notNullValue())
                .body("customerDependents.cpf", hasItems("21750497018", "27399375046", "61633599094", "82330673000", "39857240089"));
        return this;
    }

    /** Validar agencia dos dependentes
     *
     * @return
     */
    public ListCustomerDependentsApiFunc validarAgenciaDependentes() {
        respostaBase.getResponse()
                .then()
                .body("customerDependents.branch", notNullValue())
                .body("customerDependents.branch", hasSize(5))
                .body("customerDependents.branch", hasItem(3929));
        return this;
    }

    /** Validar numero e digito dos dependentes
     *
     * @return
     */
    public ListCustomerDependentsApiFunc validarNumeroEDigitoDaContaDependentes() {
        respostaBase.getResponse()
                .then()
                .body("customerDependents.account", notNullValue())
                .body("customerDependents.account", hasSize(5))
                .body("customerDependents.account", hasItems(14348, 14347, 14350, 14351, 14349))
                .body("customerDependents.accountDigit", notNullValue())
                .body("customerDependents.accountDigit", hasSize(5))
                .body("customerDependents.accountDigit", hasItems(0, 2, 2, 9, 0));
        return this;
    }
}

