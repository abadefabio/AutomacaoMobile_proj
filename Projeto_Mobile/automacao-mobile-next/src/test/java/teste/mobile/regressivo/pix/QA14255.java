package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.MeusLimitesPixFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static constantes.pix.BarraLimitePix.ALEATORIO_MAXIMO;
import static constantes.pix.BarraLimitePix.ALEATORIO_MINIMO;

@Jornada(Jornadas.PIX)
public class QA14255 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MeusLimitesPixFunc meusLimitesPix = new MeusLimitesPixFunc();

    @Test(description = "PB.1070.US.137927.006 - Diminuir o limite de Minhas contas e Contatos Pix com limite maior - CC - Slider - Botão X")
    @Description("Eu enquanto aplicativo NEXT quero disponibilizar opção de majoração de limite diário para os clientes.Objetivo:\n" +
            "Diminuir o limite de Minhas contas e Contatos Pix com limite maior - CC - Slider - Botão XDados do teste (Massa necessária):\n" +
            "\n" +
            "Nenhum requisitoPré requisitos:\n" +
            "Usuário deve estar logado no menu Next;\n" +
            "Alterar o limite para menor que o atual;Referência:\n" +
            "Código Jira: NEXT2-137927 - UserStory: US 01 Pix - Majoração Limites - Contatos Pix e mesma titularidade, contas e chaves não cadastradas e para empresas")

    @Severity(SeverityLevel.NORMAL)
    public void QA14255() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        meusLimitesPix.validarEdicaoSliderLimiteMaiorMinhasContasContatosPixPoupanca(ALEATORIO_MAXIMO.getValue());

        meusLimitesPix.validarEdicaoSliderLimiteMaiorMinhasContasContatosPixPoupanca(ALEATORIO_MINIMO.getValue());
    }
}
