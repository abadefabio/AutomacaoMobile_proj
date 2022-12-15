package teste.mobile.regressivo.adesao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.adesao.CompleteSeuCadastroFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.ADESAO)

public class QA03776 extends TesteBase{

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private CompleteSeuCadastroFunc completeSeuCadastro = new CompleteSeuCadastroFunc();

    @Test(description = "REG.ADS.01.01.56 - Validar a Retomada no est�gio Foto do documento\t\n")
    @Description("Objetivo:\n" +
            "Validar novas telas da ades�o next.\n" +
            "Pr� requisito:\n" +
            "\n" +
            "Ter acesso ao app next;Objetivo:\n" +
            "Validar novas telas da ades�o next.\n" +
            "Pr� requisito:\n" +
            "Ter acesso ao app next;\n" +
            "Possuir um CPF j� iniciado ades�o (Terminar mais tarde OU fechar o app ap�s envio da foto do documento)")

    @Severity(SeverityLevel.NORMAL)
    public void QA03776() throws Exception{

        login.efetuarLoginCadastroIncompleto(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        completeSeuCadastro.validarRetomadaNoEstagioFotoDoDocumento();
    }
}
