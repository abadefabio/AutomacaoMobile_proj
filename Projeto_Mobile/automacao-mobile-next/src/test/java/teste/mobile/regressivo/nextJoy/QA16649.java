package teste.mobile.regressivo.nextJoy;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.Utilitarios;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.nextjoy.CadastroDadosDependenteFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.JOY)
public class QA16649 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    CadastroDadosDependenteFunc cadastroDadosDependenteFunc = new CadastroDadosDependenteFunc();

    @Test(description = "[Adesões Táticas] - Validar alerta de adesão em andamento para clientes Multibanco (Bradesco) -  Responsável Status 5 ")
    @Description("Pré Requisito\n" +
            "\n" +
            "1 - Possuir app do Next/Nextjoy instalado;\n" +
            "2 - Joy com vínculo status 0 (Em Adesão);\n" +
            "3 - Responsável 1 (Multibanco) status 5 (Aprovada); \n" +
            "4 - Responsável 2 (NEXT) status 5 (Aprovada); \n ")
    @Severity(SeverityLevel.NORMAL)

    public void QA16649() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNextJoy();

        cadastroDadosDependenteFunc.cadastroDependenteJaVinculado(recuperarMassa("nome"),
                (String) recuperarJSSONMassa("cpfsMultibank").get("cpfDependente"),
                Utilitarios.calcularDataRelativaHoje(-670));

    }
}
