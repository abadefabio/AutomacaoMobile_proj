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

    @Test(description = "REG.PC.11.01 - Validar Indicação para NEXT via opção INDIQUE AMIGOS - Consultor Jequiti")
    @Description("Objetivos:  \n" +
            "\n" +
            "Validar Indicação para NEXT via opção PARCEIROS - Consultor Jequiti\n" +
            " \n" +
            "\n" +
            "Pré-Requisitos:\n" +
            "\n" +
            "Ter o APP do Next instalado (android ou ios);\n" +
            "Usuário deve ser Cliente Next;\n" +
            "Usuário deve ser Consultor Jequiti \n" +
            "Celular deve ter contato cadastrado na agenda\n" +
            " \n" +
            "Pós-Condições:\n" +
            "\n" +
            "Após clicar no botao INDICAR AMIGOS, o app Next deverá permitir o envio do convite.")
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
