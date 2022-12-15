package funcionalidade.transferencia;

import br.com.next.automacao.core.api.token.crs.TokenCrsApi;
import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.tools.ReadProperties;
import constantes.NextTransfer;
import constantes.TiposDeConta;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.GET;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserId;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserPassword;
import static org.hamcrest.Matchers.*;

public class ListarContatoFunc extends ListarContatoAtributos {

    protected RespostaBase respostaBase;
    private String uri = ReadProperties.getCaUrl();

    /**
     * Listar contatos de transferencias feitas passando token inválido
     *
     * @param cpf
     * @param token
     * @return
     * @throws Exception
     */
    public ListarContatoFunc listarContatosDeTransferenciasFeitasPassandoTokenInvalido(String cpf, String token) throws Exception {
        String requisicao = NextTransfer.LISTA_CONTATOS_TRANSFERENCIAS_FEITAS;
        logarPasso(String.format("Montando requisição '%s'", requisicao));

        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .limparDadosRequisicao()
                .definirHeaders(obterHeaderRequisicaoApiCorporativa(token, cpf))
                .definirCaminhoRequisicao(requisicao);

        respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET);
        logarPassoResposta(respostaBase);

        return this;
    }

    /**
     * Listar contatos de transferências recentes
     *
     * @param cpf
     * @return
     * @throws Exception
     */
    public ListarContatoFunc listarContatosDeTransferenciasFeitasRecentes(String cpf) throws Exception {
        String path = NextTransfer.LISTA_CONTATOS_TRANSFERENCIAS_FEITAS_RECENTES;
        logarPasso(String.format("Montando requisição '%s'", path));

        TokenCrsApi tokenCrsApi = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword());
        String token = loginCliente(tokenCrsApi);

        try {
            DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri)
                    .limparDadosRequisicao()
                    .definirHeaders(obterHeaderRequisicao(token))
                    .definirCaminhoRequisicao(path);
            respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET);
            logarPassoResposta(respostaBase);
        } finally {
            logoffCliente(tokenCrsApi, token);
        }

        return this;
    }

    /**
     * Listar contas de destinatários
     *
     * @param cpf
     * @return
     * @throws Exception
     */
    public ListarContatoFunc listarContasDeDestinatários(String cpf) throws Exception {
        String requisicao = NextTransfer.LISTA_CONTAS_DESTINATARIOS;
        logarPasso(String.format("Montando requisição '%s'", requisicao));

        TokenCrsApi tokenCrsApi = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword());
        String token = loginCliente(tokenCrsApi);

        try {
            DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri)
                    .limparDadosRequisicao()
                    .definirHeaders(obterHeaderRequisicao(token))
                    .definirCaminhoRequisicao(requisicao);

            respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET);
            logarPassoResposta(respostaBase);
        } finally {
            logoffCliente(tokenCrsApi, token);
        }

        return this;
    }

    /**
     * Validar se status da resposta é a especificada
     *
     * @param statusCode
     * @return
     */
    public ListarContatoFunc validarStatusResposta(int statusCode) {
        logarPasso("Validando retorno requisição");

        respostaBase.validarStatusCodeRequisicao(statusCode);

        return this;

    }

    /**
     * Validar se a lista de contatos de tranferências recentes está vazia
     *
     * @param statusCode
     * @return
     */
    public ListarContatoFunc validarListaContatosTransferenciasRecentesVazia(int statusCode) {
        logarPasso("Validando retorno requisição");

        respostaBase.validarStatusCodeRequisicao(statusCode)
                .getResponse().then()
                .body("system.messages", empty())
                .body("recentContactAccountList", empty());

        return this;
    }

    /**
     * Validar lista de contatos recentes com transferência recente com resultado
     *
     * @param tipoConta
     * @param statusCode
     * @param phoneNumber
     * @param email
     * @param cpf
     * @param agencia
     * @param conta
     * @param institutionNameOrBankId
     * @return
     */
    public ListarContatoFunc validarListaContatosTransferenciasRecentesComResultado(int statusCode, TiposDeConta tipoConta, String phoneNumber, String email, String cpf, String agencia, String conta, String institutionNameOrBankId) {
        logarPasso("Validando retorno requisição");
        respostaBase.validarStatusCodeRequisicao(statusCode)
                .getResponse().then().body("recentContactAccountList",
                        hasItem(both(hasEntry("phoneNumber", phoneNumber))
                                .and(hasEntry("email", email))
                                .and(hasEntry("cpfCnpj", cpf))
                                .and(hasEntry("registrationAccount", conta))
                                .and(hasKey("contactUid"))
                                .and(hasKey("customerUid"))
                                .and(hasKey("fullLegalName"))
                                .and(hasKey("registeredAccount"))
                                .and(hasKey("accountInDelay"))
                                .and(hasKey("contactBankAccountId"))
                                .and(hasKey("contactInstitutionalAccountId"))
                                .and(hasKey("dateToCompare"))
                                .and(hasKey("paymentInstitution"))))
                .assertThat().body("recentContactAccountList", not(nullValue()))
                .assertThat().body("recentContactAccountList", not(empty()));
        switch (tipoConta) {
            case CONTA_PAGAMENTO:
                respostaBase.validarStatusCodeRequisicao(statusCode)
                        .getResponse().then().body("recentContactAccountList",
                                hasItem(both(hasEntry("paymentAccount", conta))
                                        .and(hasEntry("branchCode", Integer.parseInt(agencia)))
                                        .and(hasEntry("registrationBranch", Integer.parseInt(agencia)))
                                        .and(hasEntry("institutionName", institutionNameOrBankId))
                                        .and(hasKey("institutionIspb"))
                                        .and(hasKey("institutionalLastTransferDate"))));
                break;
            case CONTA_CORRENTE:
                respostaBase.validarStatusCodeRequisicao(statusCode)
                        .getResponse().then().body("recentContactAccountList",
                                hasItem(both(hasEntry("accountNumber", Integer.parseInt(conta)))
                                        .and(hasEntry("branchCode", 0))
                                        .and(hasEntry("registrationBranch", 0))
                                        .and(hasEntry("bankId", Integer.parseInt(institutionNameOrBankId)))
                                        .and(hasEntry("bank", Integer.parseInt(institutionNameOrBankId)))
                                        .and(hasKey("contactLastTransferDate"))));
                break;
        }
        return this;
    }

    /**
     * Validar lista de contas de destinatário com resultado especificado
     *
     * @param statusCode
     * @param cpf
     * @param agencia
     * @param conta
     * @param nomeBanco
     * @return
     */
    public ListarContatoFunc validarListaContasDestinatarioComResultado(int statusCode, String cpf, String agencia, String conta, String nomeBanco) {
        logarPasso("Validando retorno requisição");

        respostaBase.validarStatusCodeRequisicao(statusCode)
                .getResponse().then().body("customerBankAccountResponseList",
                        hasItem(both(hasEntry("cpf", cpf))
                                .and(hasEntry("branch", Integer.parseInt(agencia)))
                                .and(hasEntry("accountNumber", Integer.parseInt(conta)))
                                .and(hasEntry("bankName", nomeBanco))
                                .and(hasKey("bankId"))
                                .and(hasKey("customerName"))
                                .and(hasKey("email"))
                                .and(hasKey("customerBankAccountId"))
                                .and(hasKey("bankIspb"))
                                .and(hasKey("registeredAccount"))
                                .and(hasKey("uniqueID"))
                                .and(hasKey("accountInDelay"))
                                .and(hasKey("registrationAccount"))
                                .and(hasKey("registrationBranch"))
                                .and(hasKey("bank"))));

        return this;
    }

    /**
     * Validar lista de contas de destinatário está vazia
     *
     * @param statusCode
     * @return
     */
    public ListarContatoFunc validarListaContasDestinatarioVazia(int statusCode) {
        logarPasso("Validando retorno requisição");

        respostaBase.validarStatusCodeRequisicao(statusCode)
                .getResponse().then()
                .body("system.messages", empty())
                .body("customerBankAccountResponseList", empty());

        return this;

    }

    /**
     * METODO LISTA OS ULTIMOS CONTATOS DE TRANSFERENCIA ATUAIS E RECENTES
     *
     * @param statusCode
     * @param cpf
     * @return response
     * @throws Exception
     */
    public ListarContatoFunc consultarContatosTransferenciasEfetivadas(int statusCode, String cpf) throws Exception {
        logarPasso("Montando requisição" + NextTransfer.LISTAR_CONTATOS);

        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        respostaBase = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword()).gerarTokenCliente();
        String token = respostaBase.obterJsonPath().get("token");
        logarPasso(token);

        dadosRequisicaoBase
                .limparDadosRequisicao()
                .definirHeaders(obterHeaderRequisicao(token))
                .definirCaminhoRequisicao(NextTransfer.LISTAR_CONTATOS);

        respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET).validarStatusCodeRequisicao(statusCode);
        logarPasso("Retorno Requisição \nCódigo Retorno: " + respostaBase.getResponse().statusCode()
                + "\n" + respostaBase.getResponse().asPrettyString());
        return this;
    }

    /**
     * VALIDAR SE A LISTA ESTÁ TRAZENDO OS ÚLTIMOS CONTATOS DE TRANSFERÊNCIA ATUAIS E RECENTES
     *
     * @param codigo
     * @return ListarContatoFunc
     */
    public ListarContatoFunc validarListaContatoAtuaisERecentes(int codigo) {
        logarPasso("Validando retorno requisição");
        respostaBase.getResponse()
                .then()
                .body("Status Code:", is(codigo))
                .body("accountInDelay", is(codigo))
                .body("accountNumber", is(codigo))
                .body("accountType", is(codigo))
                .body("bank", is(codigo))
                .body("bankId", is(codigo))
                .body("branchCode", is(codigo))
                .body("contactBankAccountId", is(codigo))
                .body("contactInstitutionalAccountId", is(codigo))
                .body("contactLastTransferDate", is(codigo))
                .body("date", is(codigo))
                .body("day", is(codigo))
                .body("hours", is(codigo))
                .body("minutes", is(codigo))
                .body("month", is(codigo))
                .body("nanos", is(codigo))
                .body("seconds", is(codigo))
                .body("time", is(codigo))
                .body("timezoneOffset", is(codigo))
                .body("year", is(codigo))
                .body("contactUid", is(39138791))
                .body("cpfCnpj", is("cupidatat officia"))
                .body("customerUid", is(-8459151))
                .body("email", is("incididunt est occaecat nisi"))
                .body("fullLegalName", is("officia aliquip pariatur aliqua sit"))
                .body("institutionIspb", is("moll"))
                .body("institutionName", is("est enim"))
                .body("institutionalLastTransferDate", is(codigo))
                .body("date", is(-41209076))
                .body("day", is(2000112))
                .body("hours", is(16131064))
                .body("minutes", is(65420805))
                .body("month", is(84774747))
                .body("nanos", is(61563480))
                .body("seconds", is(74429475))
                .body("time", is(21733338))
                .body("timezoneOffset", is(-83862802))
                .body("year", is(-41484843))
                .body("paymentAccount", is("aliquip occaec"))
                .body("paymentInstitution", is(false))
                .body("phoneNumber", is("dolor velit ullamco in officia"))
                .body("registeredAccount", is(true))
                .body("registrationAccount", is("officia ullamco sint"))
                .body("registrationBranch", is(-71699046));
        logarPasso("Retorno Requisição \nCódigo Retorno: " + respostaBase.getResponse().statusCode()
                + "\n" + respostaBase.getResponse().asPrettyString());
        return this;
    }

    /**
     * Listar instruções de contato Outra pessoa a quem uma transferencia foi feita sem resultado
     * fr
     *
     * @param cpf CPF a ser logado para geração do token e listagem das instruções de transferência
     * @return ListarContatoFunc
     * @throws Exception
     */
    public ListarContatoFunc listarContatosTransferenciaFeitaSemResultados(String cpf) throws Exception {
        String requisicao = NextTransfer.LISTA_CONTATOS_TRANSFERENCIAS_SEM_RESULTADO;
        logarPasso(String.format("Montando requisição '%s'", requisicao));

        TokenCrsApi tokenCrsApi = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword());
        String token = loginCliente(tokenCrsApi);

        try {
            DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
            dadosRequisicaoBase
                    .limparDadosRequisicao()
                    .definirHeaders(obterHeaderRequisicao(token))
                    .definirCorpoRequisicao("customerId", cpf)
                    .definirCaminhoRequisicao(requisicao);
            respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET);
            logarPassoResposta(respostaBase);
        } finally {
            logoffCliente(tokenCrsApi, token);
        }

        return this;
    }

    /**
     * Validar Lista de contatos(OUTRA PESSOA) a quem uma transferência foi feita sem resultado
     *
     * @param statusCode
     * @return ListarContatoFunc
     */
    public ListarContatoFunc validarListaContatosSemResultados(int statusCode) {
        logarPasso("Validando retorno requisição");

        respostaBase.validarStatusCodeRequisicao(statusCode)
                .getResponse().then()
                .body("system.messages", empty())
                .body("recentContactAccountList", empty());

        return this;
    }

    /**
     * Listar contatos de transferências recentes
     *
     * @param cpf
     * @return
     * @throws Exception
     */
    public ListarContatoFunc listarContatosDeTransferenciasFeitas(String cpf) throws Exception {
        String path = NextTransfer.LISTA_CONTATOS_TRANSFERENCIAS_FEITAS;
        logarPasso(String.format("Montando requisição '%s'", path));

        TokenCrsApi tokenCrsApi = new TokenCrsApi(cpf, uri, getCsrUserId(), getCsrUserPassword());
        String token = loginCliente(tokenCrsApi);

        try {
            DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri)
                    .limparDadosRequisicao()
                    .definirHeaders(obterHeaderRequisicao(token))
                    .definirCaminhoRequisicao(path);
            respostaBase = RequisicaoBase.executarRequisicao(dadosRequisicaoBase, GET);
            logarPassoResposta(respostaBase);
        } finally {
            logoffCliente(tokenCrsApi, token);
        }

        return this;
    }

    /**
     * Validar lista de contatos recentes com transferência com resultado
     *
     * @param tipoConta
     * @param statusCode
     * @param phoneNumber
     * @param email
     * @param cpf
     * @param agencia
     * @param conta
     * @param institutionNameOrBankId
     * @return ListarContatoFunc
     */
    public ListarContatoFunc validarListaContatosTransferenciasComResultado(int statusCode, TiposDeConta tipoConta, String phoneNumber, String email, String cpf, String agencia, String conta, String institutionNameOrBankId) {
        logarPasso("Validando retorno requisição");

        respostaBase.validarStatusCodeRequisicao(statusCode)
                .getResponse().then().body("contactAccountList",
                        hasItem(both(hasEntry("email", email))
                                .and(hasEntry("cpfCnpj", cpf))
                                .and(hasEntry("registrationAccount", conta))
                                .and(hasEntry("phoneNumber", phoneNumber))
                                .and(hasKey("contactUid"))
                                .and(hasKey("customerUid"))
                                .and(hasKey("fullLegalName"))
                                .and(hasKey("registeredAccount"))
                                .and(hasKey("contactBankAccountId"))
                                .and(hasKey("contactInstitutionalAccountId"))
                                .and(hasKey("dateToCompare"))
                                .and(hasKey("paymentInstitution"))))
                .assertThat().body("recentContactAccountList", not(nullValue()))
                .assertThat().body("recentContactAccountList", not(empty()));

        switch (tipoConta) {
            case CONTA_PAGAMENTO:
                respostaBase.validarStatusCodeRequisicao(statusCode)
                        .getResponse().then().body("contactAccountList",
                                hasItem(both(hasEntry("paymentAccount", conta))
                                        .and(hasEntry("branchCode", 0))
                                        .and(hasEntry("registrationBranch", 0))
                                        .and(hasEntry("institutionName", institutionNameOrBankId))
                                        .and(hasKey("institutionIspb"))
                                        .and(hasKey("institutionalLastTransferDate"))));
                break;
            case CONTA_CORRENTE:
                respostaBase.validarStatusCodeRequisicao(statusCode)
                        .getResponse().then().body("contactAccountList",
                                hasItem(both(hasEntry("accountNumber", Integer.parseInt(conta)))
                                        .and(hasEntry("branchCode", Integer.parseInt(agencia)))
                                        .and(hasEntry("registrationBranch", Integer.parseInt(agencia)))
                                        .and(hasEntry("bankId", Integer.parseInt(institutionNameOrBankId)))
                                        .and(hasEntry("bank", Integer.parseInt(institutionNameOrBankId)))
                                        .and(hasKey("contactLastTransferDate"))));
                break;
        }
        return this;
    }
}
