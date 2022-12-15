package teste.mobile.regressivo.parcerias;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.parcerias.ConviteIndiqueAmigos;
import constantes.parcerias.AmigoParcerias;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.parcerias.ConviteEnviadoIndiqueAmigosFunc;
import funcionalidade.mobile.parcerias.IndiqueAmigosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static constantes.parcerias.Parcerias.MENSAGEM_PROXIMA_DATA_INDICACAO;

@Jornada(Jornadas.PARCERIAS_COMERCIAIS)
public class QA00189 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    IndiqueAmigosFunc indiqueAmigos = new IndiqueAmigosFunc();
    ConviteEnviadoIndiqueAmigosFunc convite = new ConviteEnviadoIndiqueAmigosFunc();

    @Test(description = "REG.PC.11.07 - Validar campo telefone com numero j� indicado na tela INDIQUE AMIGOS")
    @Description("Pr�-Requisitos:\n" +
            "\n" +
            "Ter o APP do Next instalado (android ou ios);\n" +
            "Usuario deve ser Cliente Next;\n" +
            "Usu�rio deve ser Consultor Jequiti OU Funcionario next\n" +
            "Telefone a ser indicado j� deve ter sido indicado a menos de 15 dias.\n" +
            "P�s-Condi��es:\n" +
            "\n" +
            "Ap�s clicar no botao Enviar Convite, o app Next dever� apresentar a mensagem de alerta devido ao n�mero de telefone j� ter sido indicado nos �ltimos 15 dias.\n" +
            " \n" +
            "\n" +
            "Evid�ncias necess�rias:\n" +
            "Todo o fluxo at� as telas.")
    @Severity(SeverityLevel.NORMAL)

    public void QA00189() throws Exception {

        boolean gerarMassa = true; // para ligar ou desligar a gera��o de massa

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        if (gerarMassa) {

            /*Bloco para gera��o de massa (indica��o de amigo na data de hoje)
            e que n�o faz parte das evid�ncias.
            Com base na indica��o de amigo hoje, calculamos a mensagem.*/

            menu.selecionarParcerias();
            indiqueAmigos.indicarAmigoEnviarConvite(AmigoParcerias.AMIGO_ALEATORIO);
            convite.validarConviteEnviado(ConviteIndiqueAmigos.CONVITE_ENVIADO_APENAS_UM);
        }

        menu.selecionarParcerias();
        indiqueAmigos.indicarAmigoEnviarConvite(AmigoParcerias.AMIGO_JA_UTILIZADO);
        convite.validarMensagemProximaDataIndicacao(MENSAGEM_PROXIMA_DATA_INDICACAO);
        indiqueAmigos.validarCamposEmBranco();
    }
}
