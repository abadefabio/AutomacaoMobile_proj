package teste.hibrido.regressivo.contingencia.login;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.perfil.PerfilCliente;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import funcionalidade.web.contingencia.perfil.PerfilFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.LOGIN_CONTINGENCIA)
public class QA00286 extends TesteBase {

    LoginContingenciaFunc login = new LoginContingenciaFunc();
    PerfilFunc perfil = new PerfilFunc();

    @Test(description = "EP-32484-38238–01.Validação dos dados básicos do cliente")
    @Description("Validar dados básicos do cliente\n" +
            "\n" +
            "Pré-condições:\n" +
            "\n" +
            "Estar com contingência ativada;\n" +
            "Possuir usuário e senha Next com CPF veiculado a um device.\n" +
            "Usuário deverá estar logado na aplicação\n" +
            "Usuário deverá estar na tela de Saldo e extrato")
    @Severity(SeverityLevel.NORMAL)

    public void QA0286() throws Exception {

        String cpfCliente = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);

        login.efetuarSuperLoginUsuarioExistente(cpfCliente, senha);
        perfil.validarPerfilCliente(PerfilCliente.QA0286_PERFIL_CLIENTE, cpfCliente);
    }
}
