package teste.mobile.regressivo.parcerias;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.parcerias.Parcerias;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.parcerias.IndiqueAmigosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PARCERIAS_COMERCIAIS)
public class QA00190 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    IndiqueAmigosFunc parcerias = new IndiqueAmigosFunc();

    @Test(description = "REG.PC.11.04 - Validar Indicação - Cliente já realizou 30 convites no dia.")
    @Description("Objetivos:\n" +
            "Validar quando o consultor indicar um celular, após já ter realizado 30 convites no mesmo dia. O app next deverá impedir o envio do convite e apresentar uma mensagem de alerta.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            "Ter o APP do Next instalado (android ou ios);\n" +
            "Usuario deve ser Cliente Next;\n" +
            "Usuário deve ser Consultor Jequiti;\n" +
            "Telefone a ser indicado não deve ter sido indicado a menos de 15 dias;\n" +
            "Usuário ja deve ter realizado 30 convites no mesmo dia.\n" +
            " \n" +
            "Pós-Condições:\n" +
            "Após clicar no botao Enviar Convite, o app Next deverá apresentar popup com mensagem de alerta impedindo o envio de mais de 30 convites no mesmo dia.\n" +
            " \n" +
            "Evidências necessárias:\n" +
            "Todo o fluxo até as telas.")

    @Severity(SeverityLevel.NORMAL)

    public void QA00190() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarParcerias();

        int maxIndicacoesPossiveis = Integer.parseInt(Parcerias.MAXIMO_INDICACOES_POSSIVEIS.toString());
        parcerias.indicarMultiplosAmigos(maxIndicacoesPossiveis + 1);

        parcerias.validarMensagemPopUpIndicacoesUltrapassadas(Parcerias.MENSAGEM_MAXIMO_INDICACOES_ULTRAPASSADO);

        parcerias.validarCamposEmBranco();
    }
}
