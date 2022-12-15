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
public class QA18399 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    CadastroDadosDependenteFunc cadastroNextJoy = new CadastroDadosDependenteFunc();

    @Test(description = "PBI129025 -  6 -  Validar  adesão joy status 0 por segundo responsável - status 5  Segregada x Next   ")
    @Description("1 - Possuir app do Next/Nextjoy instalado;\n" +
            "2 - Joy sem vínculo status 0 (Em Adesão);\n" +
            "3 - Responsável 2 status 5 (Aprovada); \n" +
            "\n" +
            "Para iniciar os testes do Responsavel 2, a massa do responsável nextjoy deverá estar iniciada e de acordo com o pré requisito desejado.")

    @Severity(SeverityLevel.NORMAL)
    public void QA18399() throws Exception {

        login.loginCadastroPendente(
                recuperarMassa("cpfResponsavel1"),
                recuperarMassa(JSON.SENHA),
                false);

        login.criarContaNextJoy();

        cadastroNextJoy.tocarBotaoCriarConta();

        cadastroNextJoy.cadastrarInformacoesDependenteAteSenha(
                recuperarMassa("nome"),
                recuperarMassa("cpfDependente"),
                recuperarMassa("dataNasc"),
                recuperarMassa(JSON.SENHA),
                false);

        cadastroNextJoy.terminarCadastroMaisTarde(recuperarMassa("textoValidacao"),recuperarMassa("textoOkObrigado"));

        login.loginCadastroPendente(
                recuperarMassa("cpfResponsavel2"),
                recuperarMassa(JSON.SENHA),
                true);

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
