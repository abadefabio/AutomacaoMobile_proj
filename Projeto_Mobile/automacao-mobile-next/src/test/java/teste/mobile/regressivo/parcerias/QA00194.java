package teste.mobile.regressivo.parcerias;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.parcerias.ConviteIndiqueAmigos;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.parcerias.IndiqueAmigosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PARCERIAS_COMERCIAIS)
public class QA00194 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    IndiqueAmigosFunc parcerias = new IndiqueAmigosFunc();

    @Test(description = "REG.PC.11.02 - Validar Indica��o para NEXT via op��o INDIQUE AMIGOS - NEXT")
    @Description("Validar Indica��o para NEXT via op��o INDIQUE AMIGOS - NEXT\n" +
            "Pr�-requisitos:\n" +
            "Ter o APP do Next instalado (android ou ios);\n" +
            "Cliente n�o ser� consultor no inicio do teste;\n" +
            "Ser parceiros next\n" +
            "P�s-condfi��es:\n" +
            "Indica��o para NEXT via op��o PARCEIROS - NEXT")
    @Severity(SeverityLevel.NORMAL)

    public void QA00194() throws Exception {

        login.efetuarLoginUsuarioExistente( recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarParcerias();

        parcerias.indicarAmigoAleatorioValido();
        parcerias.validarConviteEnviado(ConviteIndiqueAmigos.CONVITE_FUNCIONARIO_APENAS_UM);

        menu.validarTelaMenu();
    }
}
