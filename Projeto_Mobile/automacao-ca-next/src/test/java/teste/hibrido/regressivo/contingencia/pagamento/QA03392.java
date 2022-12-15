package teste.hibrido.regressivo.contingencia.pagamento;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import funcionalidade.web.contingencia.pagamento.PagamentoWebFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

@Jornada(Jornadas.PAGAMENTOS_CONTINGENCIA)
public class QA03392 extends TesteBase {

    LoginContingenciaFunc login = new LoginContingenciaFunc();
    PagamentoWebFunc pagamento  = new PagamentoWebFunc();

    @Test(description = "EP - 32484 - 32830 - 05 - Validar fluxo de pagamento de boletos para código de barras válido e inválidos.")
    @Description("Pré-condições:" +
            "1. Estar com contingência ativada;\n" +
            "2. Possuir usuário e senha Next com CPF veiculado a um device.")
    @Severity(SeverityLevel.NORMAL)

    public void QA03392() throws Exception {
        String cpfCliente = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);
        JSONObject objeto = recuperarJSSONMassa("objeto");

        login.efetuarSuperLoginUsuarioExistente(cpfCliente, senha);
        pagamento.acessarMenuPagamento();
        pagamento.digitarCodigoBarrasInvalido(
                (String) objeto.get("codigo"));
        pagamento.digitarCodigoBarrasValido(
                (String) objeto.get("codigo"));
        pagamento.validarTelasClicarBotaoVoltar();
    }
}



