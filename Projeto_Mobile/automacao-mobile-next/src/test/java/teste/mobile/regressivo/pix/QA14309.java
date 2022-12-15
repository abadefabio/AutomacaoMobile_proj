package teste.mobile.regressivo.pix;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.pix.TipoConta;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.MeusLimitesPixFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.PIX)
public class QA14309 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MeusLimitesPixFunc meusLimitesPix = new MeusLimitesPixFunc();

    @Test(description = "PB.1070.US.137927.060 - Validar valor menor que o permitido digitado - CC e CP - Pix Saque e Pix Troco")
    @Description("Eu enquanto aplicativo NEXT quero disponibilizar opção de majoração de limite diário para os clientes.Objetivo:\n"
            + "Validar valor menor que o permitido digitado - CC e CP - Pix Saque e Pix TrocoDados do teste (Massa necessária):\n"
            + "\n"
            + "Nenhum requisitoPré requisitos:\n"
            + "Usuário deve estar logado no menu Next;\n"
            + "Alterar o limite para menor que o limite noturnoReferência:\n"
            + "Código Jira: NEXT2-137927 - UserStory: US 01 Pix - Majoração Limites - Contatos Pix e mesma titularidade, contas e chaves não cadastradas e para empresas")

    @Severity(SeverityLevel.NORMAL)
    public void QA14309() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        meusLimitesPix.validarLimiteMenorPermitidoPixSaquePixTrocoDiurno(TipoConta.CONTA_CORRENTE, recuperarMassa("valorLimite"));

        meusLimitesPix.validarLimiteMenorPermitidoPixSaquePixTrocoDiurno(TipoConta.CONTA_POUPANCA, recuperarMassa("valorLimite"));
    }
}
