package teste.mobile.regressivo.portabilidade;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.portabilidade.ComprovanteFunc;
import funcionalidade.mobile.portabilidade.TrazerMeuSalarioFunc;
import funcionalidade.mobile.portabilidade.VerDetalhesFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

;

@Jornada(Jornadas.TRAZER_MEU_SALARIO)
public class QA00044 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();
    VerDetalhesFunc verDetalhes = new VerDetalhesFunc();
    ComprovanteFunc comprovante = new ComprovanteFunc();

    @Test(description = "REG.TMS.01.04 - Validar compartilhamento de comprovante de portabilidade de salário (CNPJ) em andamento[01 (Pendente) e 51 (Pendente-Sem envio ao partic. folha de pagamento)] após efetuar um cancelamento.")
    @Description("Objetivo:\n" +
            "Garantir detalhes de portabilidade pendente;\n" +
            "Garantir cancelamento de portabilidade de salário;\n" +
            "Garantir compartilhamento do comprovante PDF;\n" +
            "\n" +
            "Dados do teste:\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Possuir usuário e senha next;\n" +
            "Possuir portabilidade de salário cujo o status seja 1 ou 51 ou 61 (PENDENTE);\n" +
            "Possuir uma portabilidade concluída;\n" +
            "\n" +
            "Dependência: N/A\n" +
            "\n" +
            "Evidencias necessárias: Todo o fluxo até o resultado esperado.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00044() throws Exception {

        String cpf = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);
        JSONObject portabilidade = recuperarJSSONMassa("portabilidade");

        login.efetuarLoginUsuarioExistente(cpf, senha);

        menu.selecionarTrazerSalario();

        trazerMeuSalario.validarTelaInformacao();
        trazerMeuSalario.acessarVerDetalhesPortabilidadeEmAndamento(recuperarMassa("cpfCnpjFormatado"));

        verDetalhes.validarDetalhesPortabilidade(portabilidade);

        trazerMeuSalario.desistirCancelarPortabilidade(recuperarMassa("cpfCnpjFormatado"));
        trazerMeuSalario.cancelarPortabilidade();

        comprovante.compartilharComprovante(portabilidade);
    }
}
