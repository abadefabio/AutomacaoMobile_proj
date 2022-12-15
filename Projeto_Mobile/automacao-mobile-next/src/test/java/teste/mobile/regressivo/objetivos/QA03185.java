package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import funcionalidade.mobile.objetivos.resgate.RealizarResgateFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03185 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    RealizarResgateFunc resgateFunc = new RealizarResgateFunc();
    ObjetivosFunc objetivosFunc = new ObjetivosFunc();

    @Test(description = "REG.OBJ.09.09.01 - Validar resgate total de objetivo concluido atraves da NOTIFICA��O pelo bot�o RESGATE do card")
    @Description("Descri��o:\n" +
            "Validar resgate total de objetivo concluido atraves do cardDescri��o: Validar resgate total de objetivo concluido atraves do card\n" +
            "Pr�-Requisitos:\n" +
            "CPF e senha V�lidos")

    @Severity(SeverityLevel.NORMAL)
    public void QA03185()throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        resgateFunc.validarNotificacao();

        resgateFunc.realizarResgate();



    }
}
