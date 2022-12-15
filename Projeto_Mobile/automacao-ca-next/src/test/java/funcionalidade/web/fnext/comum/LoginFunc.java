package funcionalidade.web.fnext.comum;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.web.fnext.TitulosTela;
import constantes.web.fnext.Url;
import pagina.web.fnext.comum.LoginTela;
import pagina.web.fnext.comum.PesquisaGeralTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class LoginFunc extends FuncionalidadeBase {

     /**
     * Realiza login no FNEXT
     *
     * @param usuario
     * @param senha
     * @throws Exception
     */
    public void realizarLogin(String usuario, String senha) throws Exception {
        new LoginTela(getWebDriver())
                .navegar(Url.FNEXT_URL)
                .preencherCampoUsuario(usuario)
                .preencherCampoSenha(senha)
                .clicarBotaoConfirmar();
        new PesquisaGeralTela(getWebDriver())
                .validarTituloPesquisaGeral(TitulosTela.TITULO_PESQ_GERAL);
    }
}
