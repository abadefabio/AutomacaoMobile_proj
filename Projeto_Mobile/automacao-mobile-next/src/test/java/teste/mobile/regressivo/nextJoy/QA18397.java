package teste.mobile.regressivo.nextJoy;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.nextjoy.CadastroDadosDependenteFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.JOY)
public class QA18397 extends TesteBase {

    LoginFunc login = new LoginFunc();
    CadastroDadosDependenteFunc cadastroNextJoy = new CadastroDadosDependenteFunc();

    @Test(description = "PBI129025 - 5 - Validar adesão joy status 0 por segundo responsável - status 1 Segregada x Next")
    @Description("1 - Possuir app do Next/Nextjoy instalado;\n" +
            "2 - Joy sem vínculo status 0 (Em Adesão) iniciada na segregada.\n" +
            "3 - Responsável 2 status 1 (Em análise);\n" +
            "\n" +
            "Para iniciar os testes do Responsavel 2, a massa do responsável nextjoy deverá estar iniciada e de acordo com o pré requisito desejado.")

    @Severity(SeverityLevel.NORMAL)
    public void QA18397() throws Exception {

        login.loginCadastroPendente(recuperarMassa("cpfResponsavel2"), recuperarMassa(JSON.SENHA),false);
        login.criarContaNextJoy();
        cadastroNextJoy.tocarBotaoCriarConta();
        cadastroNextJoy.cadastrarInformacoesDependenteAteSenha(
                recuperarMassa("nome"),
                recuperarMassa("cpfDependente"),
                recuperarMassa("dataNasc"),
                recuperarMassa(JSON.SENHA),
                false);
        cadastroNextJoy.finalizarAdesaoDependente(recuperarMassa(JSON.SENHA));
    }
}
