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
public class QA03184 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivo = new ObjetivosFunc();
    RealizarResgateFunc resgate = new RealizarResgateFunc();


    @Test(description = "REG.OBJ.09.08.03 - Validar a EDI��O e o RESGATE TOTAL do objetivo pelo bot�o RESGATE do card")
    @Description("Descri��o: Validar resgate total do objetivo - Editar\n" +
            "Pr�-Requisitos:\n" +
            "\n" +
            "CPF e senha V�lidos")

    @Severity(SeverityLevel.NORMAL)
    public void QA03184() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        resgate.realizarResgateTotal(recuperarMassa("valorResgate"));

    }
}
