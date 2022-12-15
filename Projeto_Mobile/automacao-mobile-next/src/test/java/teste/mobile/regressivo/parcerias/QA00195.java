package teste.mobile.regressivo.parcerias;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.parcerias.IndiqueAmigosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


import static constantes.parcerias.Parcerias.MENSAGEM_VALIDACAO_CONSULTOR_JEQUETI;

@Jornada(Jornadas.PARCERIAS_COMERCIAIS)
public class QA00195 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    IndiqueAmigosFunc parcerias = new IndiqueAmigosFunc();

    @Test(description = "REG.PC.11.01 - Validar Indica��o para NEXT via op��o INDIQUE AMIGOS - Consultor Jequiti")
    @Description("Objetivos:  \n" +
            "\n" +
            "Validar Indica��o para NEXT via op��o PARCEIROS - Consultor Jequiti\n" +
            " \n" +
            "\n" +
            "Pr�-Requisitos:\n" +
            "\n" +
            "Ter o APP do Next instalado (android ou ios);\n" +
            "Usu�rio deve ser Cliente Next;\n" +
            "Usu�rio deve ser Consultor Jequiti \n" +
            "Celular deve ter contato cadastrado na agenda\n" +
            " \n" +
            "P�s-Condi��es:\n" +
            "\n" +
            "Ap�s clicar no botao INDICAR AMIGOS, o app Next dever� permitir o envio do convite.")
    @Severity(SeverityLevel.NORMAL)

    public void QA00195() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarParcerias();

        parcerias.indicarAmigoAleatorioValido();

        parcerias.validarMensagemEsperada(MENSAGEM_VALIDACAO_CONSULTOR_JEQUETI);

        parcerias.tocarBotaoOK();

        menu.validarTelaMenu();
    }
}
