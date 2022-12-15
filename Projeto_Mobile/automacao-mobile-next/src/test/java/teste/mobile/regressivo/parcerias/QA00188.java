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

import static br.com.next.automacao.core.tools.Utilitarios.gerarNumeroCelular;

@Jornada(Jornadas.PARCERIAS_COMERCIAIS)
public class QA00188 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    IndiqueAmigosFunc parcerias = new IndiqueAmigosFunc();

    @Test(description = "REG.PC.11.05|11.06|11.08 - validar nome com palavrões, campo telefone incompleto e layout tela INDIQUE AMIGOS")
    @Description("ID ALM 82831,78418 e 78410\n" +
            "\n" +
            "Objetivos:\n" +
            "\n" +
            "REG.PC.11.05 - Validar Nome digitado com Palavrões na Tela INDIQUE AMIGOS\n" +
            "REG.PC.11.06 - Validar Layout tela INDIQUE AMIGOS.\n" +
            "REG.PC.11.08 - Validar campo telefone incompleto na tela INDIQUE AMIGOS\n" +
            "Pré-Requisitos:\n" +
            "\n" +
            "Ter o APP do Next instalado (android ou ios);\n" +
            "Cliente Next ser Consultor Jequiti ou funcionario next\n" +
            "\n" +
            "\n" +
            "Pós-Condições:\n" +
            "\n" +
            "validar Nome digitado com Palavrões na Tela INDIQUE AMIGO\n" +
            "Inserir númenro de telefone inconpleto")
    @Severity(SeverityLevel.NORMAL)

    public void QA00188() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarParcerias();

        parcerias.indicarAmigoEnviarConvite(Parcerias.NOME_PALAVRAO, "11" + gerarNumeroCelular());

        parcerias.validarTelaTextoNomeInvalido(Parcerias.NOME_INVALIDO);

        parcerias.tocarBotaoFecharTelaParceria();

        menu.selecionarParcerias();

        parcerias.validarTelaTextoQuemAbreConta();

        parcerias.validarTelaTextoBancoDigital();

        parcerias.indicarAmigoEnviarConvite(Parcerias.NOME_CONSULTOR_JEQUETI, Parcerias.NUMERO_CELULAR_INCOMPLETO.toString());

        parcerias.validarTelaCelularIncompleto();

    }
}
