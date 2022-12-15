package teste.hibrido.regressivo.contingencia.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.transferencia.TipoContaTransferencia;
import constantes.transferencia.TipoTransferencia;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import funcionalidade.web.contingencia.transferencia.para.TransferenciaTidFunc;
import funcionalidade.web.contingencia.transferencia.para.outro.TransferenciaWebParaOutroBancoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA_CONTINGENCIA)
public class QA05473 extends TesteBase {

    LoginContingenciaFunc login = new LoginContingenciaFunc();
    TransferenciaWebParaOutroBancoFunc transferencia = new TransferenciaWebParaOutroBancoFunc();
    TransferenciaTidFunc transferenciaTid = new TransferenciaTidFunc();


    @Test(description = "EP - 32484 - 84029 - 13 - Validar uma transferência DOC para outra pessoa em outro banco")
    @Description("Pré-condições:" +
            "1. Estar com contingência ativada;\n" +
            "2. Possuir usuário e senha Next com CPF veiculado a um device.")
    @Severity(SeverityLevel.NORMAL)

    public void QA05473() throws Exception {
            String cpfCliente = recuperarMassa(JSON.CPF);
            String senha = recuperarMassa(JSON.SENHA);
            JSONObject objeto = recuperarJSSONMassa("objeto");

        login.efetuarSuperLoginUsuarioExistente(cpfCliente, senha);
        transferencia.acessarMenuTransferencia();
        transferencia.preencherDadosTransferencia(
                (String) objeto.get("nomeCompleto"),
                (String) objeto.get("tipoConta"),
                (String) objeto.get("quantiaTransferir"),
                (String) objeto.get("finalidade"),
                (String) objeto.get("nomeTransferencia"),
                TipoContaTransferencia.CONTA_CORRENTE,
                TipoTransferencia.DOC,
                (String) objeto.get("agencia"),
                (String) objeto.get("conta"));

        transferencia.clicarBotaoAvancar();
        transferenciaTid.confirmarTidTransferencia(
                recuperarMassa(JSON.SENHA));
        transferencia.confirmarAlertaTransferencia();
    }
}

