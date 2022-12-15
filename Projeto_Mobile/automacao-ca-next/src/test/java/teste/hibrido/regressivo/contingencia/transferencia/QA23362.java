package teste.hibrido.regressivo.contingencia.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.login.contingencia.web.Parametros;
import constantes.transferencia.TipoContaTransferencia;
import constantes.transferencia.TipoTransferencia;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import funcionalidade.web.contingencia.saldo.SaldoExtratoFunc;
import funcionalidade.web.contingencia.transferencia.para.TransferenciaTidFunc;
import funcionalidade.web.contingencia.transferencia.para.outro.TransferenciaWebParaOutroBancoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA_CONTINGENCIA)
public class QA23362 extends TesteBase {
    private static ThreadLocal<String> valorContaPoupanca = new ThreadLocal<>();

    LoginContingenciaFunc login = new LoginContingenciaFunc();
    TransferenciaWebParaOutroBancoFunc transferencia = new TransferenciaWebParaOutroBancoFunc();
    TransferenciaTidFunc transferenciaTid = new TransferenciaTidFunc();
    SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    @Test(description = "EP - 32484 - 83552 - 08 - validar expiração do Qrcode e a transferência O,outra pessoa, banco, de conta-corrente para corrente DOC.")
    @Description("Pré-condições:" +
            "1. Possuir usuário e senha Next;" +
            "2. Estar com contingência esta ativada.")

    @Severity(SeverityLevel.NORMAL)
    public void QA23362() throws Exception {
        String cpfCliente = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);
        JSONObject objeto = recuperarJSSONMassa("objeto");

        login.efetuarSuperLoginUsuarioExistente(cpfCliente, senha);
        valorContaPoupanca.set(saldoExtratoFunc.verificarEArmazenarSaldoExtratoContaPoupanca());
        transferencia.acessarMenuTransferencia();
        transferencia.preencherDadosTransferencia(
                (String) objeto.get("nomeCompleto"),
                (String) objeto.get("tipoContaDestino"),
                (String) objeto.get("valorTransferir"),
                (String) objeto.get("finalidade"),
                (String) objeto.get("nomeTransferencia"),
                TipoContaTransferencia.CONTA_POUPANCA,
                TipoTransferencia.DOC,
                (String) objeto.get("agencia"),
                (String) objeto.get("conta")
        );

        transferencia.clicarBotaoAvancar();
        transferencia.validarDadosTransferencia(
                (String) objeto.get("de"),
                (String) objeto.get("para"),
                (String) objeto.get("razaoSocialNome"),
                (String) objeto.get("cpfDestino"),
                (String) objeto.get("instituicaoVerificacao"),
                (String) objeto.get("agencia"),
                (String) objeto.get("conta"),
                (String) objeto.get("contaDestino"),
                (String) objeto.get("contaOrigem"),
                (String) objeto.get("confereValor"),
                (String) objeto.get("tipo"),
                (String) objeto.get("finalidadeVerificacao"),
                (String) objeto.get("descricao")
        );

        login.gerarQrCodeAguardarExpiracaoValidarTrasferencia(Parametros.TEMPO_MAX_AGUARDAR_QRCODE_EXPIRAR);
        login.renovarQrCodeExpirado();
        transferenciaTid.confirmarTidTransferencia(recuperarMassa(JSON.SENHA));
        transferencia.confirmarAlertaTransferencia();
        saldoExtratoFunc.verificarSaldoAposTransferenciaContaPoupanca(
                valorContaPoupanca.get(),
                (String) objeto.get("valorTransferir"),
                (String) objeto.get("valortarifa")
        );
    }
}
