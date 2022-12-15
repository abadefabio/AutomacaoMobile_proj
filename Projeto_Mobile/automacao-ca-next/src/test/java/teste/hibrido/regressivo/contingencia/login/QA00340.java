package teste.hibrido.regressivo.contingencia.login;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import funcionalidade.web.contingencia.pagamento.PagamentoWebFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.LOGIN_CONTINGENCIA)
public class QA00340 extends TesteBase {

    LoginContingenciaFunc login = new LoginContingenciaFunc();
    PagamentoWebFunc pagamentowebfunc = new PagamentoWebFunc();

    @Test(description = "EP-32484-37209–11.Validar se cliente next tentar logar na mesma conta em outro navegador")
    @Description("Pré-condições" +
            "1. Estar com contingência ativada;\n" +
            "2. Possuir usuário e senha Next com CPF veiculado a um device.\n")
    @Severity(SeverityLevel.NORMAL)
    public void QA00340() throws Exception {

        String cpfCliente = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);

        login.efetuarSuperLoginUsuarioExistente(cpfCliente, senha);
        login.abrirContigenciaEmOutroNavegador();
        login.efetuarLoginContingenciaWeb(cpfCliente, senha);
        login.voltarParaPrimeiroNavegador();
        login.validarSessaoExpirada();
        login.voltarParaSegundoNavegador();
        pagamentowebfunc.validarTituloPagamentoWeb();
    }
}
