package teste.mobile.regressivo.adesao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.adesao.CompleteSeuCadastroFunc;
import funcionalidade.mobile.adesao.CriarContaFunc;
import funcionalidade.mobile.adesao.DadosPessoaisFunc;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.Utilitarios.gerarCpf;

@Jornada(Jornadas.ADESAO)
public class QA24952 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private CriarContaFunc criarContaFunc = new CriarContaFunc();

    private CompleteSeuCadastroFunc completeSeuCadastro = new CompleteSeuCadastroFunc();

    @Test(description = "PBI-201985.001.002 - Validar Oculta��o da MD na Retomada da Ades�o")
    @Description("Validar que a MD n�o ser� apresentada na Retomada de Ades�o'- CPF valido para ades�o.\n" +
            "Ter iniciado uma ades�o.")

    @Severity(SeverityLevel.NORMAL)
    public void QA24952() throws Exception {
        login.acessarTelaCriarConta();

        criarContaFunc.criarConta(
                recuperarMassa("nome"),
                recuperarMassa(JSON.CPF),
                recuperarMassa("dataNascimento"),
                recuperarMassa("email"),
                recuperarMassa("celular"),
                recuperarMassa(JSON.SENHA));

        login.recarregarAppNext();

        login.efetuarLoginCadastroIncompleto(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        completeSeuCadastro.validarTelaCompleteSeuCadastro();
    }


}
