package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.pix.PixFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA02490 extends TesteBase {

    LoginFunc login = new LoginFunc();
    PixFunc pix = new PixFunc();

    @Test(description = "REG.PIX.21.08.01 - Validar Login Recorrente - Atalho PIX")
    @Description("Descrição: Validar login para Home Pix, através do atalho \"PIX\" na tela de login recorrente.\n" +
            "Pré-Condições: - Possuir o aplicativo do Next instalado no celular;\n" +
            "Ter uma conta next;\n" +
            "Já ter logado no app anteriormente e salvo as informações de login.")

    @Severity(SeverityLevel.NORMAL)
    public void QA02490() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        login.logout();

        login.acessarPixLoginRecorrente(recuperarMassa(JSON.SENHA));

        pix.validarTelaInicialPix();
    }
}
