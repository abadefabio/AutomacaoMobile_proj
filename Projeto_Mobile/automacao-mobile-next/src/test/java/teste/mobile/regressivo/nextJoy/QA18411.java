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
public class QA18411 extends TesteBase {

    LoginFunc login = new LoginFunc();
    CadastroDadosDependenteFunc cadastroNextJoy = new CadastroDadosDependenteFunc();

    @Test(description = "PBI129025 -  1 -  Validar adesão joy status 0, substituindo o primeiro responsável   status 1, para o  segundo responsável - status 1  (Next x Next)")
    @Description("1 - Possuir app do Next/Nextjoy instalado;\n" +
            "2 - Joy com vínculo status 0 (Em Adesão);\n" +
            "3 - Responsável 1  status 1 (Em análise);\n" +
            "4 - Responsável 2 status 1 (Em análise); \n" +
            "\n" +
            "Para iniciar os testes do Responsavel 2, a massa do responsável 1 deverá estar iniciada e de acordo com o pré requisito desejado.")

    @Severity(SeverityLevel.NORMAL)
    public void QA18411() throws Exception {

        login.loginCadastroPendente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA), false);
        login.criarContaNextJoy();
        cadastroNextJoy.tocarBotaoCriarConta();
        cadastroNextJoy.cadastrarInformacoesDependenteAteSenha(
                recuperarMassa("nome"),
                recuperarMassa("cpfDependente"),
                recuperarMassa("dataNasc"),
                recuperarMassa(JSON.SENHA),
                false);
        cadastroNextJoy.validarCadastroExistente();
    }
}
