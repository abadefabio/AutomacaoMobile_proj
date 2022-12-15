package teste.hibrido.regressivo.contingencia.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import funcionalidade.web.contingencia.saldo.SaldoExtratoFunc;
import funcionalidade.web.contingencia.transferencia.para.mim.TransferenciaParaMimFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA_CONTINGENCIA)
public class QA21394 extends TesteBase {
    private static ThreadLocal<String> valorContaCorrente = new ThreadLocal<>();

    LoginContingenciaFunc login = new LoginContingenciaFunc();
    TransferenciaParaMimFunc transferencia  = new TransferenciaParaMimFunc();
    SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    @Test(description = "EP - 32484 - 32830 - 01 - Validar transferência para mim, banco, de conta-corrente para corrente Conta Interna.")
    @Description("Pré-condições:" +
            "1. Possuir usuário e senha Next;\n" +
            "2. Estar com contingência ativada.")

    @Severity(SeverityLevel.NORMAL)
    public void QA21394() throws Exception {
        String cpfCliente = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);
        JSONObject objeto = recuperarJSSONMassa("objeto");

        login.efetuarSuperLoginUsuarioExistente(cpfCliente, senha);
        valorContaCorrente.set(saldoExtratoFunc.verificarEArmazenarSaldoExtratoContaCorrente());
        transferencia.acessarMenuTransferencia();
        transferencia.preencherDadosTransferenciaParaMimContaInterna(
                (String) objeto.get("nome"),
                (String) objeto.get("tipoConta"),
                (String) objeto.get("valorTransferir"),
                (String) objeto.get("nomeTransferencia"),
                (String) objeto.get("agencia"),
                (String) objeto.get("conta")
        );

        transferencia.conferirDadosTransferenciaContaInterna(
                (String) objeto.get("de"),
                (String) objeto.get("para"),
                cpfCliente,
                (String) objeto.get("banco"),
                (String) objeto.get("agencia"),
                (String) objeto.get("destino"),
                (String) objeto.get("origem"),
                (String) objeto.get("confereValor"),
                (String) objeto.get("finalidadeVerificacao"),
                (String) objeto.get("nomeTransferencia")
        );

        transferencia.confirmarTransferenciaTid(senha);
        transferencia.confirmarAlertaTransferencia();
        saldoExtratoFunc.verificarEArmazenarSaldoExtratoContaCorrente();
    }
}

