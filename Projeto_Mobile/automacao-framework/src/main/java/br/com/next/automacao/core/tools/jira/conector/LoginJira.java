package br.com.next.automacao.core.tools.jira.conector;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.constantes.MetodoRequisicao;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.ReadProperties;
import io.restassured.http.Cookies;

import static br.com.next.automacao.core.base.api.RequisicaoBase.executarRequisicao;
import static io.restassured.RestAssured.given;

/**
 * Classe responsável pelo login no Jira
 *
 * @author Lucas Santos
 * @version 1.0
 * @since 2020-07
 */
public class LoginJira {

    public static final String uriBaseJira = ReadProperties.getJiraUrl();

    /**
     * Chamada para recuperar cookie de sessão no Jira
     *
     * @return cookie de sessão Jira
     */
    static Cookies login() throws NextException {

        DadosRequisicaoBase corpoRequisicao = new DadosRequisicaoBase(uriBaseJira, "/rest/auth/latest/session")
                .definirCorpoRequisicao("username", ReadProperties.getJiraUser(), "password", ReadProperties.getJiraPass());
        return executarRequisicao(corpoRequisicao, MetodoRequisicao.POST,200, "Não foi possível realizar login no JIRA!").obterCookiesRequisicao();
    }
}
