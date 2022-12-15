package funcionalidade.mobile.login;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.ajuda.AtalhosTela;
import pagina.mobile.jornadas.login.LoginUsuarioLogadoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;


public class LoginUsuarioLogadoFunc extends FuncionalidadeBase {

    /**
     * Tocar no bot�o Atalhos
     * @throws Exception
     */
    public void tocarBotaoAtalhos() throws Exception {
        new LoginUsuarioLogadoTela(getDriver())
                .tocarBotaoAtalhos();
        new AtalhosTela(getDriver())
                .validarTituloTelaAtalhos();
    }
}
