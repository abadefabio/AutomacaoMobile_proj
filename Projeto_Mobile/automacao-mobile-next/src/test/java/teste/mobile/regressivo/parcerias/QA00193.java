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

    @Test(description = "REG.PC.11.03 -Validar nova opção de INDIQUE AMIGOS na tela inicial - Cliente Novo e Não é Consultor")
    @Description("ID ALM 82834\n" +
            "\n" +
            "Objetivos:  \n" +
            "\n" +
            "Validar nova opção de INDIQUE AMIGOS na tela inicial - Cliente Novo e Não é Consultor\n" +
            " \n" +
            "\n" +
            "Pré-Requisitos:\n" +
            "\n" +
            "Ter o APP do Next instalado;\n" +
            "Ter acesso a internet;\n" +
            "Cliente Next Não pode ser Consultor Jequiti nem funcionario \n" +
            "Necessário não estar logado antes de executar o cenário.\n" +
            " \n" +
            "Pós-Condições:\n" +
            "\n" +
            "Menu INDIQUE AMIGOS não é exibido")
    @Severity(SeverityLevel.NORMAL)

    public void QA00193() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.validarMenuSemParceiros();

    }
}
