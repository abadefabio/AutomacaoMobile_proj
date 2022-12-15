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
            "Garantir que a tela tutorial � apresentada corretamente no primeiro acesso a funcionalidade;\n" +
            "Garantir a efetiva��o de Solicita��o de portabilidade para outros bancos utilizando CNPJ;\n" +
            "Garantir consist�ncia dos campos CNPJ DO EMPREGADOR, NOME DO EMPREGADOR e BANCO DA CONTA SAL�RIO;\n" +
            "Garantir que o termo e condi��o apresentado estar com todas as informa��es corretas;\n" +
            "\n" +
            "Dados do teste:\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Possuir usu�rio e senha next;\n" +
            "Nunca ter acessado a funcionalidade TRAZER MEU SAL�RIO;\n" +
            "Ter CNPJ valido;\n" +
            "\n" +
            "Depend�ncia: N/A\n" +
            "\n" +
            "Evidencias necess�rias: Todo o fluxo at� o resultado esperado.")

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
