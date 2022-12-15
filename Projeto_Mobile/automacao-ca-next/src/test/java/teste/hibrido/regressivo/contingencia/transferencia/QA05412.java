package teste.hibrido.regressivo.contingencia.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import funcionalidade.web.contingencia.saldo.SaldoExtratoFunc;
import funcionalidade.web.contingencia.transferencia.TranfereciaWebFunc;
import funcionalidade.web.contingencia.transferencia.para.TransferenciaTidFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA_CONTINGENCIA)
public class QA05412 extends TesteBase {
    private static ThreadLocal<String> valorContaPoupanca = new ThreadLocal<>();

    LoginContingenciaFunc login = new LoginContingenciaFunc();
    TranfereciaWebFunc transferencia = new TranfereciaWebFunc();
    TransferenciaTidFunc transferenciaTid = new TransferenciaTidFunc();
    SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    @Test(description = "EP-32484-88526-08-Validar transferência outra pessoa, instituição de pagamento, de Poupança para Poupança TED")
    @Description("Validar que o sistema está exibindo as informações corretas na tela de transferência." +
            "Pré-condições: " +
            "1. Possuir usuário e senha Next;" +
            "2. Estar com contingência ativada;" +
            "3. Estar logado e na tela principal;"
    )

    @Severity(SeverityLevel.NORMAL)
    public void QA05412() throws Exception {
        String cpfCliente = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);
        JSONObject objeto = recuperarJSSONMassa("objeto");

        login.efetuarSuperLoginUsuarioExistente(cpfCliente, senha);
        valorContaPoupanca.set(saldoExtratoFunc.verificarEArmazenarSaldoExtratoContaPoupanca());
        transferencia.clicarMenuTransferencia();
        transferencia.paraQuemVoceVaiTransferir(
                (String) objeto.get("nomeCompleto"),
                (String) objeto.get("valortransferencia"),
                (String) objeto.get("finalidadetransferencia"),
                (String) objeto.get("nometransferencia"),
                (String) objeto.get("agencia"),
                (String) objeto.get("conta")
        );

        transferenciaTid.confirmarTidTransferencia(recuperarMassa(JSON.SENHA));
        transferencia.confirmarAlertaTransferencia();
        saldoExtratoFunc.verificarSaldoAposTransferenciaContaPoupanca(
                valorContaPoupanca.get(),
                (String) objeto.get("valortransferencia"),
                (String) objeto.get("valortarifa")
        );
    }
}
