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
public class QA00046 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();

    @Test(description = "REG.TMS.01.05 - Validar a solicita��o da segunda portabilidade de sal�rio para o mesmo CNPJ e Banco de destino")
    @Description("Objetivo:\n" +
            "\n" +
            "Dados do teste:\n" +
            "Garantir que n�o � poss�vel efetuar uma dupla solicita��o para o mesmo CPF/CNPJ com o mesmo banco\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Possuir usu�rio e senha next;\n" +
            "Possuir portabilidade de sal�rio (PENDENTE);\n" +
            "\n" +
            "Depend�ncia: N/A\n" +
            "Evidencias necess�rias: Todo o fluxo at� o resultado esperado.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00046() throws Exception {
        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTrazerSalario();

        trazerMeuSalario.criarPortabilidade(recuperarJSSONMassa("portabilidade"));

        trazerMeuSalario.validarMensagemVoceJaCadastrouCpfCnpj();
    }
}
