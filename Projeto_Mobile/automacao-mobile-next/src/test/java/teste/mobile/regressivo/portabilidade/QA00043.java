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

;

@Jornada(Jornadas.TRAZER_MEU_SALARIO)
public class QA00043 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();

    @Test(description = "REG.TMS.01.06 - Validar detalhe portabilidade de sal�rio (CNPJ) em andamento 01 (Pendente) e 51 (Pendente-Sem envio ao partic. folha de pagamento) e efetuar o cancelamento.")
    @Description("Objetivo:\n" +
            "Garantir detalhes de portabilidade pendente;\n" +
            "Garantir cancelamento de portabilidade de sal�rio;\n" +
            "Garantir bot�o de retorno na tela COMPROVANTE;\n" +
            " \n" +
            "Dados do teste:\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Possuir usu�rio e senha next;\n" +
            "Possuir portabilidade de sal�rio cujo o status seja 1 ou 51 ou 61 (PENDENTE);\n" +
            "Possuir uma portabilidade conclu�da;\n" +
            "\n" +
            "Depend�ncia: N/A\n" +
            "Evidencias necess�rias: Todo o fluxo at� o resultado esperado.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00043() throws Exception {

        String cpf = recuperarMassa(JSON.CPF);

        String cnpj = recuperarMassa("cnpjPortabilidadePendente");

        login.efetuarLoginUsuarioExistente(cpf, recuperarMassa(JSON.SENHA));

        menu.selecionarTrazerSalario();

        trazerMeuSalario.validarTelaInformacao();

        trazerMeuSalario.tocarVerDetalhesPortabilidade(cnpj);

        trazerMeuSalario.tocarBotaoCancelarTestandoNaoESim(cnpj);

        trazerMeuSalario.validarComprovante(cnpj);

        trazerMeuSalario.tocarBotaoFecharComprovante();
    }
}
