package teste.mobile.regressivo.portabilidade;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.portabilidade.TrazerMeuSalarioFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRAZER_MEU_SALARIO)
public class QA00045 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();

    @Test(description = "REG.TMS.01.10 - Validar que o botão Cancelar fique habilitado apenas para os status permitidos pelo CSAL (01 (PENDENTE) - 51(Pendente-Sem Envio folha de pagamento) - 61 (Pendente-Em processamento)")
    @Description("Objetivo: Garantir que as portabilidades em andamento com status 01,51 e 61 estão apresentados o botão Cancelar\n" +
            "\n" +
            "Dados do teste:\n" +
            "\n" +
            "Pré requisitos:\n" +
            "-Possuir portabilidade com status 01,51 e 61\n" +
            "Possuir usuário e senha next;\n" +
            "\n" +
            "Dependência: N/A\n" +
            "\n" +
            "Evidencias necessárias: Todo o fluxo até o resultado esperado.")
    @Severity(SeverityLevel.NORMAL)

    public void QA00045() throws Exception {

        String cpf = recuperarMassa(JSON.CPF);

        login.efetuarLoginUsuarioExistente(cpf, recuperarMassa(JSON.SENHA));

        menu.selecionarTrazerSalario();

        trazerMeuSalario.validarBotaoCancelarPortabilidadesEmAndamento(recuperarMassa("cnpj1"), recuperarMassa("cnpj2"));
    }
}
