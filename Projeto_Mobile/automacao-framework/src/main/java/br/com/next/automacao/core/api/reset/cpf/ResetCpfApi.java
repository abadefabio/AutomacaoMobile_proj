package br.com.next.automacao.core.api.reset.cpf;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;

import javax.annotation.Nonnull;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.POST;

public class ResetCpfApi extends ResetCpfApiAtributos {

    protected String uri;
    protected String esteira;
    private String caminhoRequisicao = "/v1/resetCpf";
    protected String cpf;

    public ResetCpfApi(@Nonnull String cpf, @Nonnull String uri, @Nonnull String esteira) {
       this.cpf = cpf;
       this.uri = uri;
       this.esteira = esteira;
    }

    /**
     * Redefine um CPF
     * @param token
     * @return response
     * @throws NextException
     */
    public RespostaBase redefinirCpf(String token) throws NextException {
        /*
        *** Verificar se faz o corpo da requisição corretamente.
         */
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .definirHeaders(obterHeadersRedefinirCpf(cpf, esteira, token))
                .definirCaminhoRequisicao(caminhoRequisicao);

        return RequisicaoBase.executarRequisicao(dadosRequisicaoBase, POST);
    }
}
