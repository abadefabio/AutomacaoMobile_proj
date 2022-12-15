package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pix.ValorPix;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.MeusLimitesPixFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA14251 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MeusLimitesPixFunc meusLimitesPix = new MeusLimitesPixFunc();

    @Test(description = "PB.1070.US.137927.002 - Aumentar o limite de Minhas contas e Contatos Pix com limite maior - CP - Lápis - Botão X")
    @Description("Eu enquanto aplicativo NEXT quero disponibilizar opção de majoração de limite diário para os clientes.Objetivo:\n" +
            "Aumentar o limite de Minhas contas e Contatos Pix com limite maior - CP - Lápis - Botão X Dados do teste (Massa necessária):\n" +
            "\n" +
            "Nenhum requisitoPré requisitos:\n" +
            "Usuário deve estar logado no menu Next;\n" +
            "Limite total deve estar abaixo do valor máximo;\n" +
            "Alterar o limite para maior que o atual;Referência:\n" +
            "Código Jira: NEXT2-137927 - UserStory: US 01 Pix - Majoração Limites - Contatos Pix e mesma titularidade, contas e chaves não cadastradas e para empresas")

    @Severity(SeverityLevel.NORMAL)
    public void QA14251() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        meusLimitesPix.validarEdicaoLapisLimiteMaiorMinhasContasContatosPixPoupanca(ValorPix.ALEATORIO_MINIMO);

        meusLimitesPix.validarEdicaoLapisLimiteMaiorMinhasContasContatosPixPoupanca(ValorPix.ALEATORIO_MAXIMO);
    }
}
