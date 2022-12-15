package teste.mobile.regressivo.parcerias;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PARCERIAS_COMERCIAIS)
public class QA00193 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();

    @Test(description = "REG.PC.11.03 -Validar nova op��o de INDIQUE AMIGOS na tela inicial - Cliente Novo e N�o � Consultor")
    @Description("ID ALM 82834\n" +
            "\n" +
            "Objetivos:  \n" +
            "\n" +
            "Validar nova op��o de INDIQUE AMIGOS na tela inicial - Cliente Novo e N�o � Consultor\n" +
            " \n" +
            "\n" +
            "Pr�-Requisitos:\n" +
            "\n" +
            "Ter o APP do Next instalado;\n" +
            "Ter acesso a internet;\n" +
            "Cliente Next N�o pode ser Consultor Jequiti nem funcionario \n" +
            "Necess�rio n�o estar logado antes de executar o cen�rio.\n" +
            " \n" +
            "P�s-Condi��es:\n" +
            "\n" +
            "Menu INDIQUE AMIGOS n�o � exibido")
    @Severity(SeverityLevel.NORMAL)

    public void QA00193() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.validarMenuSemParceiros();

    }
}
