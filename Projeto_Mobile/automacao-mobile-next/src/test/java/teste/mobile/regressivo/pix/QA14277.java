package teste.mobile.regressivo.pix;

import org.testng.annotations.Test;

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

@Jornada(Jornadas.PIX)
public class QA14277 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MeusLimitesPixFunc meusLimitesPix = new MeusLimitesPixFunc();

    @Test(description = "PB.1070.US.137927.028 - Diminuir o limite para \n" +
            "Empresas - CC - Com limite utilizado - Solicitação Cancelada D0 - Lápis.")
    @Description("Ter uma transação de transferência para Empresas (Chave CNPJ) no dia atual (utilizando parte do limite diário);\n" +
            "Diminuir o limite para Empresas para um valor menor que o atual;\n" +
            "Ter uma solicitação em análise no dia atual = D0")

    @Severity(SeverityLevel.NORMAL)
    public void QA14277() throws Exception {
        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        meusLimitesPix.validarReducaoLimiteEmpresaComLimiteUtilizado();
    }
}
