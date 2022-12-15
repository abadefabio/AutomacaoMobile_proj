package funcionalidade.frontend.login;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.frontend.GestaoOcorrenciasUrl;
import pagina.web.frontend.login.LoginGestaoOcorrenciasTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class LoginGestaoOcorrenciasFunc extends FuncionalidadeBase {

    /**
     * Fazer o login no sistema de Gestao de Ocorrencias
     *
     * @param usuario
     * @param senha
     * @throws Exception
     */
    public void loginGestaoOcorrencias(String usuario, String senha) throws Exception {
        new LoginGestaoOcorrenciasTela(getWebDriver())
                .navegar(GestaoOcorrenciasUrl.URL)
                .informarUsuario(usuario)
                .informarSenha(senha)
                .clicarConfirmar();
    }

}
