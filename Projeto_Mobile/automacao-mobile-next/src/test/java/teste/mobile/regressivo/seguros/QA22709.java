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
public class QA22709 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosCreditoAdesaoFunc segurosCreditoAdesaoFunc = new SegurosCreditoAdesaoFunc();


    @Test(description = "PBI.120115.US.121486.006 - Validar acionamento da seguradora - CRÉDITO")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a Jornada de Seguros no App do next\n" +
            "Para visualizar informações pertinentes ao produto Crédito contratado \"<\"")
    @Severity(SeverityLevel.NORMAL)
    public void QA22709() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosCreditoAdesaoFunc.validarAcionamentoSeguradora(TipoSeguroContratado.SEGURO_CREDITO);

    }
}
