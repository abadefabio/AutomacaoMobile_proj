package teste.mobile.regressivo.investimentos.agora;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.investimentos.agora.AgoraInvestimentosFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA02842 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AgoraInvestimentosFunc agoraInvestimentos = new AgoraInvestimentosFunc();

    @Test(description = "[v1] Validar fluxo de aplicação no segmento Ágora investimentos")
    @Description("Descrição do cenário\n"
            + "COMO Usuário do NEXT\n"
            + "QUERO ter acesso no menu de investimentos\n"
            + "PARA que eu possa realizar uma aplicação via Ágora Investimentos. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Possuir uma conta ativa no NEXT.")
    @Severity(SeverityLevel.NORMAL)
    public void QA02842() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarInvestimentos();

        agoraInvestimentos.validarExibicaoNavegadorCadastroAgoraInvestimentos();
    }
}
