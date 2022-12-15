package br.com.next.automacao.core.api.token.crs;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;

import javax.annotation.Nonnull;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.POST;

public class TokenCrsApi extends TokenCrsApiAtributos{

    private String cpf;
    private String uri;
    private String user;
    private String password;
    private String caminhoRequisicao = "/v1/login/csr";

    public TokenCrsApi(@Nonnull String cpf, @Nonnull String uri, @Nonnull String user, @Nonnull String password) {
       this.cpf = cpf;
       this.uri = uri;
       this.user = user;
       this.password = password;
    }

    /**
     * Gera um token do cliente
     * @return response
     * @throws NextException
     */
    public RespostaBase gerarTokenCliente() throws NextException {
        /*
        *** Verificar se faz o corpo da requisição corretamente.
         */
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .definirHeaders(obterHeadersGerarTokenCrs())
                .definirCorpoRequisicao(obterCorpoRequisicaoGeralTokenCrs(cpf, user, password))
                .definirCaminhoRequisicao(caminhoRequisicao);

        return RequisicaoBase.executarRequisicao(dadosRequisicaoBase, POST);
    }

    /**
     * Logoff do token do cliente
     * @param token
     * @return response
     * @throws NextException
     */
    public RespostaBase logoffTokenCliente(String token) throws NextException {
        /*
         *** Verificar se faz o corpo da requisição corretamente.
         */
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .definirHeaders(obterHeadersLogoffTokenCliente(token))
                .definirCorpoRequisicao(obterCorpoRequisicaoGeralTokenCrs(cpf, user, password))
                .definirCaminhoRequisicao(caminhoRequisicao);

        return RequisicaoBase.executarRequisicao(dadosRequisicaoBase, POST);
    }
}
