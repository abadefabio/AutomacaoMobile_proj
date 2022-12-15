package teste.mobile.regressivo.nextJoy;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.nextjoy.CadastroDadosDependenteFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.JOY)
public class QA18396 extends TesteBase {

    LoginFunc login = new LoginFunc();
    CadastroDadosDependenteFunc cadastroNextJoy = new CadastroDadosDependenteFunc();
    MenuFunc menu = new MenuFunc();

    @Test(description = "PBI129025 -  3 -  Validar adesão joy status 0, substituindo o primeiro responsável - status 5, para o  segundo responsável - status 1   Next x Next ")
    @Description("1 - Possuir app do Next/Nextjoy instalado;\n" +
            "2 - Joy com vínculo status 0 (Em Adesão);\n" +
            "3 - Responsável 1 status 5 (Aprovada);\n" +
            "4 - Responsável 2 status 5 (Aprovada);\n" +
            "\n" +
            "Para iniciar os testes do Responsavel 2, a massa do responsável 1 deverá estar iniciada e de acordo com o pré requisito desejado." )

    @Severity(SeverityLevel.NORMAL)
    public void QA18396() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa("cpfResponsavel01"), recuperarMassa(JSON.SENHA));
        menu.selecionarNextJoy();

        cadastroNextJoy.cadastrarInformacoesDependenteAteSenha(recuperarMassa("nome"),recuperarMassa("cpfDependente"),recuperarMassa("dataNasc"),recuperarMassa(JSON.SENHA),true);

        cadastroNextJoy.voltarAoMenuPrincipal();
        login.logout();

        login.loginCadastroPendente(recuperarMassa("cpfResponsavel02"), recuperarMassa(JSON.SENHA),true);
        menu.selecionarNextJoy();

        cadastroNextJoy.cadastrarInformacoesDependenteAteSenha(recuperarMassa("nome"),recuperarMassa("cpfDependente"),recuperarMassa("dataNasc"),recuperarMassa(JSON.SENHA),true);

        cadastroNextJoy.validarCadastroExistente();
    }
}
