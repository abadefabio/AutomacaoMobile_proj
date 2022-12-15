package teste.mobile.regressivo.adesao.hibridos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.ajuda.EsqueciMinhaSenhaFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ADESAO)
public class QA03430 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private EsqueciMinhaSenhaFunc recuperaSenha = new EsqueciMinhaSenhaFunc();
    private MenuFunc menu = new MenuFunc();

    private static ThreadLocal<String> codigo = new ThreadLocal<>();

    @Test(description = "REG.ADS.01.06.02 - Esquecer senha - Informar c�digo de seguran�a e nova senha v�lidos")
    @Description("Descri��o (Objetivo):\n" +
            "\n" +
            "Pr�-Requisitos:\n" +
            "\n" +
            "Possuir o app next instalado no celular;\n" +
            "CPF e senha v�lidos;\n" +
            "Possuir conta aprovada no Next;")
    @Severity(SeverityLevel.NORMAL)

    public void QA03430() throws Exception {

        login.acessarTelaEsqueciMinhaSenha();

        recuperaSenha.iniciarRecuperacaodeSenha(recuperarMassa("cpf"));

        recuperaSenha.recuperarCodigoSegurancaNoEmail(recuperarMassa("dominioUsuarioEmail"), recuperarMassa("senhaEmail"), codigo);

        recuperaSenha.criarNovaSenha(recuperarMassa("novaSenha"), codigo);

    }
}
