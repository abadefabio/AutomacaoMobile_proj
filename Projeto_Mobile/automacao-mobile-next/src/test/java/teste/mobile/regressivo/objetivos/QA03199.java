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
public class QA03199  extends TesteBase {

    LoginFunc login = new LoginFunc();
    ComprovantesFunc comprovantesFunc = new ComprovantesFunc();
    ObjetivoFinalizadoFunc objetivoFinalizadoFunc = new ObjetivoFinalizadoFunc();

    @Test(description = "REG.OBJ.09.12.02 - Objetivo em andamento - Validar o recebimento do extrato da ultima aplicação")
    @Description("Pré-requisito na massa de teste\n" +
            "Já deve possuir objetivo em andamento na lista")

    @Severity(SeverityLevel.NORMAL)
    public void QA03199() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        comprovantesFunc.acessarObjetivosViaComprovantes();

        objetivoFinalizadoFunc.validarObetivosEmAndamento();
    }

    }
