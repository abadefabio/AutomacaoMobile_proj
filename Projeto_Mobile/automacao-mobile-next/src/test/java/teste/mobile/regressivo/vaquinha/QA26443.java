package teste.mobile.regressivo.vaquinha;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.vaquinha.VaquinhaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.VAQUINHA)
public class QA26443 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    VaquinhaFunc vaquinha = new VaquinhaFunc();

    @Test(description = "REG.VAQ.17.02 - Validar cancelamento da vaquinha na tela Sua Vaquinha está pronta")
    @Description("Validar cancelamento da vaquinha na tela Sua Vaquinha está pronta")

    @Severity(SeverityLevel.NORMAL)
    public void QA26443() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarVaquinha();

        vaquinha.acessarCriarVaquinha();

        vaquinha.aceitarCheckTermoCondicoes();

        vaquinha.preencherNomedaVaquinha(recuperarMassa("nomeVaquinha"));

        vaquinha.inserirValorSelecionarDataCriarVaquinha(recuperarMassa("valorVaquinha"));

        vaquinha.tocarBotaoPerfil();

        vaquinha.acessarExcluirVaquinha();

        vaquinha.tocarBotaoConfirmaExclusaoVaquinha();

    }

   }
