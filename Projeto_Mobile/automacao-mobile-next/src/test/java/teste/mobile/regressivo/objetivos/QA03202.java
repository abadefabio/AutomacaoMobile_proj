package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.objetivos.ObjetivoFinalizadoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03202 extends TesteBase {

    LoginFunc login = new LoginFunc();
    ComprovantesFunc comprovante = new ComprovantesFunc();
    ObjetivoFinalizadoFunc objFinalizadoFunc = new ObjetivoFinalizadoFunc();

    @Test(description = "REG.OBJ.09.12.05 - Objetivo finalizado - Validar o recebimento do extrato da ultima aplica��o")
    @Description("Validar comprovantes." +
            "Pr�-Requisitos:\n" +
            "CPF e senha V�lidos")

    @Severity(SeverityLevel.NORMAL)
    public void QA03202() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        comprovante.acessarObjetivosViaComprovantes();

        objFinalizadoFunc.enviarEmailComprovanteObjetivoFinalizado();
    }
}
