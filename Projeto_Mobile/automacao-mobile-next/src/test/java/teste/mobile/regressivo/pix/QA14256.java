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

import static constantes.pix.ValorPix.ALEATORIO_MAXIMO;
import static constantes.pix.ValorPix.ALEATORIO_MINIMO;

@Jornada(Jornadas.PIX)
public class QA14256 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MeusLimitesPixFunc meusLimitesPix = new MeusLimitesPixFunc();

    @Test(description = "PB.1070.US.137927.007 - Diminuir o limite de Minhas contas e Contatos Pix com limite maior - CP - L�pis - Bot�o VOLTAR AOS MEUS LIMITES PIX")
    @Description("Eu enquanto aplicativo NEXT quero disponibilizar op��o de majora��o de limite di�rio para os clientes.Objetivo:\n" +
            "Diminuir o limite de Minhas contas e Contatos Pix com limite maior - CP - L�pis - Bot�o VOLTAR AOS MEUS LIMITES PIXDados do teste (Massa necess�ria):\n" +
            "\n" +
            "Nenhum requisitoPr� requisitos:\n" +
            "Usu�rio deve estar logado no menu Next;\n" +
            "Alterar o limite para um valor menor que o atual.Refer�ncia:\n" +
            "C�digo Jira: NEXT2-137927 - UserStory: US 01 Pix - Majora��o Limites - Contatos Pix e mesma titularidade, contas e chaves n�o cadastradas e para empresas")

    @Severity(SeverityLevel.NORMAL)
    public void QA14256() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        meusLimitesPix.validarEdicaoLapisLimiteMaiorMinhasContasContatosPixPoupanca(ALEATORIO_MAXIMO);

        meusLimitesPix.validarEdicaoLapisLimiteMaiorMinhasContasContatosPixPoupanca(ALEATORIO_MINIMO);
    }
}
