package teste.mobile.regressivo.vaquinha;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
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
public class QA00117 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    VaquinhaFunc vaquinha = new VaquinhaFunc();

    @Test(description = "REG.VAQ.01.02 - Validar a não criação da vaquinha com valor maior que limite máximo por pessoa")
    @Description("Objetivos: \n" +
            "Validar a não criação da vaquinha com valor maior que o limite máximo\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            "Possuir o aplicativo do Next instalado no celular;\n" +
            "Ter conta next;\n" +
            "Logar no app;\n" +
            "Ter acesso a criação de vaquinha")

    @Severity(SeverityLevel.NORMAL)
    public void QA00117() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarVaquinha();

        vaquinha.validarValorLimiteVaquinha();
    }
}
