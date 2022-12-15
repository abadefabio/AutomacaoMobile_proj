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

    @Test(description = "PBI129025 -  1 -  Validar ades�o joy status 0, substituindo o primeiro respons�vel   status 1, para o  segundo respons�vel - status 1  (Next x Next)")
    @Description("1 - Possuir app do Next/Nextjoy instalado;\n" +
            "2 - Joy com v�nculo status 0 (Em Ades�o);\n" +
            "3 - Respons�vel 1 �status 1 (Em an�lise);\n" +
            "4 - Respons�vel 2 status 1 (Em an�lise);�\n" +
            "\n" +
            "Para iniciar os testes do Responsavel 2, a massa do respons�vel 1 dever� estar iniciada e de acordo com o pr� requisito desejado.")

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
