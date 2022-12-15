package teste.hibrido.regressivo.contingencia.login;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.LOGIN_CONTINGENCIA)
public class QA00339 extends TesteBase {

    LoginContingenciaFunc login = new LoginContingenciaFunc();

    @Test(description = "EP-32484-37209–10.Validar se cliente next tentar logar a mesma conta em outro aba do mesmo navegador")
    @Description("Pré-condições:" +
            "1. Estar com contingência ativada;\n" +
            "2. Possuir usuário e senha Next com CPF veiculado a um device.")
    @Severity(SeverityLevel.NORMAL)

    public void QA00339() throws Exception {
        String cpfCliente = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);

        login.efetuarSuperLoginUsuarioExistente(cpfCliente, senha);
        login.abrirNovaAbaNavegadorWeb();
        login.efetuarLoginContingenciaMobileWebSenhaCorreta(cpfCliente, senha);
        login.alternarEntreAbas(0);
        login.validarSessaoExpirada();
        login.alternarEntreAbas(1);
        login.validarSessaoAtiva();
    }
}



