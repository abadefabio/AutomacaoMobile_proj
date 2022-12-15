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
public class QA05410 extends TesteBase {
    private static ThreadLocal<String> valorContaCorrente = new ThreadLocal<>();

    LoginContingenciaFunc login = new LoginContingenciaFunc();
    TransferenciaParaMimFunc transferencia  = new TransferenciaParaMimFunc();
    SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    @Test(description = "EP - 32484 - 88526 - 06 - Validar transferência para mim, banco, de conta-corrente para Poupança DOC. ")
    @Description("Pré-condições:" +
            "1. Possuir usuário e senha Next;\n" +
            "2. Estar com contingência ativada.")

    @Severity(SeverityLevel.NORMAL)
    public void QA05410() throws Exception {
        String cpfCliente = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);
        JSONObject objeto = recuperarJSSONMassa("objeto");

        login.efetuarSuperLoginUsuarioExistente(cpfCliente, senha);
        valorContaCorrente.set(saldoExtratoFunc.verificarEArmazenarSaldoExtratoContaCorrente());

        transferencia.acessarMenuTransferencia();
        transferencia.preencherDadosTransferenciaParaMimDoc(
                (String) objeto.get("nome"),
                (String) objeto.get("tipoConta"),
                (String) objeto.get("valorTransferir"),
                (String) objeto.get("finalidadeSeletor"),
                (String) objeto.get("nomeTransferencia"),
                (String) objeto.get("agencia"),
                (String) objeto.get("conta")
        );

        transferencia.conferirDadosTransferencia(
                (String) objeto.get("de"),
                (String) objeto.get("para"),
                cpfCliente,
                (String) objeto.get("banco"),
                (String) objeto.get("agencia"),
                (String) objeto.get("conta"),
                (String) objeto.get("destino"),
                (String) objeto.get("origem"),
                (String) objeto.get("confereValor"),
                (String) objeto.get("tipo"),
                (String) objeto.get("finalidadeVerificacao"),
                (String) objeto.get("nomeTransferencia")
        );

        transferencia.confirmarTransferenciaTid(senha);
        transferencia.confirmarAlertaTransferencia();
        saldoExtratoFunc.verificarSaldoAposTransferenciaContaCorrente(
                valorContaCorrente.get(),
                (String) objeto.get("valorTransferir"),
                (String) objeto.get("valorTarifa")
        );
    }
}
