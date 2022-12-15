package br.com.next.automacao.core.massa.callcenter;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.constantes.MetodoRequisicao;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.geradores.TokenCrs;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


import java.util.ArrayList;
import java.util.List;
import static br.com.next.automacao.core.base.api.RequisicaoBase.executarRequisicao;

/**
 * Alterar o status da adesão para status disponiveis
 * @author Rodrigo Benedetti
 * @since 2021-07
 */

public class requisicaoCallCenter {
    public static final String uriBaseCoreBank = ReadProperties.getCaUrl();

    static Response modificarStatusAdesao(String cpf, int statusOnboarding) throws Exception {
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(new Header("X-Next-AuthToken", TokenCrs.getCrsToken(cpf)));
        headerlist.add(new Header("Authorization", "Basic ZGV2OmNhcGNv"));
        headerlist.add(new Header("Content-Type", "application/json"));
        Headers headers = new Headers(headerlist);

        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseCoreBank, "/v1/preregistrations/onboardingStatus")
                .definirHeaders(headers)
                .definirCorpoRequisicao(
                        "applicationStatus", statusOnboarding,
                        "deptResponsibleId", 4769,
                        "rejectionReasonDescription", "Aprovado",
                        "userResponsibleId", "I931050"
                );

        return executarRequisicao(corpoRequisicao, MetodoRequisicao.POST, 200, "Não  foi possivel alterar o status da adesão! Verifique usuário e senha TokenCRS").getResponse();
    }

}
