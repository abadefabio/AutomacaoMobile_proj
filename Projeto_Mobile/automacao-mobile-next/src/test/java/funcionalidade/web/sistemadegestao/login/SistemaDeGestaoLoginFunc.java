package funcionalidade.web.sistemadegestao.login;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.sistemadegestao.Login.SistemaDeGestaoLoginTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class SistemaDeGestaoLoginFunc extends FuncionalidadeBase {

    /**
     * Preencher Campo Login
     *
     * @throws Exception
     */
    public void preencherCampoLogin(String login) throws Exception {
        new SistemaDeGestaoLoginTela(getWebDriver())
                .preencherCampoLogin(login);

    }

    /**
     * Preencher Campo Senha
     *
     * @throws Exception
     */
    public void preencherCampoSenha(String senha) throws Exception {
        new SistemaDeGestaoLoginTela(getWebDriver())
                .preencherCampoSenha(senha);
    }

    /**
     * Clicar botão login
     *
     * @throws Exception
     */
    public void clicarBotaoLogin() throws Exception {
        new SistemaDeGestaoLoginTela(getWebDriver())
                .clicarBotaoLogin();
    }

    /**
     * Realiza login no sistema de gestão
     *
     * @param login
     * @param senha
     * @param esteira
     * @throws Exception
     */
    public void realizarLogin(String login, String senha, String esteira) throws Exception{
        getWebDriver().navigate().refresh();
        new SistemaDeGestaoLoginTela(getWebDriver())
                .preencherCampoLogin(login)
                .preencherCampoSenha(senha)
                .selecionarEsteira(esteira)
                .clicarBotaoLogin();
    }


}
