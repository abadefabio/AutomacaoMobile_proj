package teste.mobile.regressivo.ajuda;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.ajuda.EsqueciMinhaSenhaFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.AJUDA_E_AREA_NAO_LOGADA)
public class QA03283 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private EsqueciMinhaSenhaFunc recuperaSenha = new EsqueciMinhaSenhaFunc();
    private MenuFunc menu = new MenuFunc();

    private static ThreadLocal<String> codigo = new ThreadLocal<>();

    @Test(description = "REG.AJU.02.10 - Validar troca de senha no esqueceu sua senha area não logada")
    @Description("REG.AJU.02.10 - Validar troca de senha no esqueceu sua senha area não logada")
    @Severity(SeverityLevel.NORMAL)

    public void QA03283() throws Exception {

        login.acessarTelaEsqueciMinhaSenha();

        recuperaSenha.iniciarRecuperacaodeSenhaReenviandoCodigo(recuperarMassa("cpf"));

        recuperaSenha.recuperarCodigoSegurancaNoEmail(recuperarMassa("dominioUsuarioEmail"), recuperarMassa("senhaEmail"), codigo);

        recuperaSenha.criarNovaSenha(recuperarMassa("novaSenha"), codigo);

        login.acessarAppComNovaSenha(recuperarMassa("cpf"),recuperarMassa("novaSenha"));

    }
}
