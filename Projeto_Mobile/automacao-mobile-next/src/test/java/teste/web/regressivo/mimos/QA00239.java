package teste.web.regressivo.mimos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.web.sistemadegestao.login.SistemaDeGestaoLoginFunc;
import funcionalidade.web.sistemadegestao.menu.SistemaDeGestaoMenuFunc;
import funcionalidade.web.sistemadegestao.mimos.hub.SistemaDeGestaoMenuHubFunc;
import funcionalidade.web.sistemadegestao.mimos.hub.SistemaDeGestaoOfertasFunc;
import funcionalidade.web.sistemadegestao.mimos.menu.SistemaDeGestaoMenuMimosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.MIMOS)
public class QA00239 extends TesteBase {

    SistemaDeGestaoLoginFunc loginSistemaDeGestao = new SistemaDeGestaoLoginFunc();
    SistemaDeGestaoMenuFunc menuSistemaDeGestao = new SistemaDeGestaoMenuFunc();
    SistemaDeGestaoMenuMimosFunc menuMimosSistemaDeGestao = new SistemaDeGestaoMenuMimosFunc();
    SistemaDeGestaoMenuHubFunc menuHubSistemaDeGestao = new SistemaDeGestaoMenuHubFunc();
    SistemaDeGestaoOfertasFunc parceriasHubSistemaDeGestao = new SistemaDeGestaoOfertasFunc();

    @Test(description = "REG.MIMO.01.09 - Validação de: exclusão da lista de Voucher, pelo sistema de gestão - quando houver voucher utilizado")
    @Description("Validar a exclusão da lista de Voucher - quando houver voucher utilizado.")
    @Severity(SeverityLevel.NORMAL)


    public void QA00239() throws Exception{

        loginSistemaDeGestao.preencherCampoLogin(recuperarMassa("loginGestao"));

        loginSistemaDeGestao.preencherCampoSenha(recuperarMassa("senhaGestao"));

        loginSistemaDeGestao.clicarBotaoLogin();

        menuSistemaDeGestao.clicarLinkMIMOS();

        menuMimosSistemaDeGestao.clicarLinkHub();

        menuHubSistemaDeGestao.clicarLinkOfertas();

        parceriasHubSistemaDeGestao.selecionarInativoEmComboboxSituacao();

        parceriasHubSistemaDeGestao.clicarBotaoConsultar();

        parceriasHubSistemaDeGestao.clicarBotaoExcluirOferta(recuperarMassa("nomeOferta"));

        parceriasHubSistemaDeGestao.clicarBotaoSim();

        parceriasHubSistemaDeGestao.clicarBotaoOK();

        parceriasHubSistemaDeGestao.validarOfertaNaoCadastrada();

    }
}
