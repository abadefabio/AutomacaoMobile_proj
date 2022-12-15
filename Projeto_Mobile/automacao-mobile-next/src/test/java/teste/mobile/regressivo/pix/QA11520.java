package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pix.*;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.ContestacaoFunc;
import funcionalidade.mobile.pix.PixFunc;
import funcionalidade.mobile.pix.TransferirPixFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA11520 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menuTela = new MenuFunc();
    PixFunc menuPix = new PixFunc();
    ContestacaoFunc contestarPix = new ContestacaoFunc();

    @Test(description = "PB.1070.US.115874.004 - Solicitar contesta��o de devolu��o Total - Fui vitima de golpe amea�a - Bot�o voltar ao Pix")
    @Description("Descri��o: Eu enquanto cliente NEXT quero contestar um lan�amento enviado para reaver o dinheiro por desconhecimento deste lan�amentoObjetivo:\n" +
            "Solicitar contesta��o de devolu��o total - Fui vitima de golpe amea�a - Bot�o voltar ao Pix\n" +
            "\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "\n" +
            "Nenhum requisito\n" +
            "Pr� requisitos:\n" +
            "-Usu�rio deve estar logado no menu Next\n" +
            "-Ter uma transa��o Pix enviada com menos de 80 dias\n" +
            "\n" +
            "Refer�ncia:\n" +
            "C�digo Jira: NEXT2-115874 - UserStory: US 01 Criar solicita��o - MED")

    @Severity(SeverityLevel.NORMAL)
    public void QA11520() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menuTela.selecionarPix();

        menuPix.selecionarExtratosEComprovantes();

        contestarPix.efetuarContestacaoPix(recuperarMassa("valor"), TipoContestacao.FUI_VITIMA_DE_GOLPE_AMEACA,recuperarMassa("descricaoContestacao"));

    }
}
