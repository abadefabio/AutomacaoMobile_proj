package teste.mobile.regressivo.seguros;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.seguros.TipoSeguroContratado;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.SegurosCreditoAdesaoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA22705 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosCreditoAdesaoFunc segurosCreditoAdesaoFunc = new SegurosCreditoAdesaoFunc();

    @Test(description = "PBI.120115.US.121486.002 - Validar VIS?O GERAL - CR?DITO")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a Jornada de Seguros no App do next\n" +
            "Para visualizar informa??es pertinentes ao produto CR?DITO contratado \"<\"")
    @Severity(SeverityLevel.NORMAL)
    public void QA22705() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosCreditoAdesaoFunc.validarVisaoGeral(TipoSeguroContratado.SEGURO_CREDITO);

    }
}
