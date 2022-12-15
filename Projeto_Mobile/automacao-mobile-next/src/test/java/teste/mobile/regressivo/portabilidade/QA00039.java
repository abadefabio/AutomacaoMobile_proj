package teste.mobile.regressivo.portabilidade;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.portabilidade.PortabilidadeDados;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.portabilidade.TrazerMeuSalarioFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

;

@Jornada(Jornadas.TRAZER_MEU_SALARIO)
public class QA00039 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();

    @Test(description = "REG.TMS.01.01 - Validar Pedido de portabilidade para outros bancos no primeiro acesso a funcionalidade - CNPJ")
    @Description("Objetivo:\n" +
            "Garantir que a tela tutorial é apresentada corretamente no primeiro acesso a funcionalidade;\n" +
            "Garantir a efetivação de Solicitação de portabilidade para outros bancos utilizando CNPJ;\n" +
            "Garantir consistência dos campos CNPJ DO EMPREGADOR, NOME DO EMPREGADOR e BANCO DA CONTA SALÁRIO;\n" +
            "Garantir que o termo e condição apresentado estar com todas as informações corretas;\n" +
            "\n" +
            "Dados do teste:\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Possuir usuário e senha next;\n" +
            "Nunca ter acessado a funcionalidade TRAZER MEU SALÁRIO;\n" +
            "Ter CNPJ valido;\n" +
            "\n" +
            "Dependência: N/A\n" +
            "\n" +
            "Evidencias necessárias: Todo o fluxo até o resultado esperado.")

    @Severity(SeverityLevel.NORMAL)
    public void QA00039() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTrazerSalario();

        trazerMeuSalario.validarPrimeiraPortabilidade();

        trazerMeuSalario.portabilidadePrimeiroAcesso(
                PortabilidadeDados.CNPJ_INVALIDO,
                PortabilidadeDados.CNPJ_EMPRESA_TST_GATW,
                PortabilidadeDados.SANTANDER);
    }
}
