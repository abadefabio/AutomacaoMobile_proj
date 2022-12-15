package teste.mobile.regressivo.adesao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.adesao.CriarContaFunc;
import funcionalidade.mobile.adesao.DadosPessoaisFunc;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.Utilitarios.gerarCpf;


@Jornada(Jornadas.ADESAO)
public class QA14669 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private CriarContaFunc criarContaFunc = new CriarContaFunc();
    private DadosPessoaisFunc dadosPessoaisFunc = new DadosPessoaisFunc();

    @Test(description = "PBI-143044.001.004 - Validar tela login recorrente PASSO 2 DE 6")
    @Description("Descrição: Validar tela login recorrente PASSO 2 DE 6\n" +
            "Pré requisito:\n" +
            "CPF sem cadastro e valido")

    @Severity(SeverityLevel.NORMAL)
    public void QA14669() throws Exception {

        login.acessarTelaCriarConta();

        criarContaFunc.criarContaCadastroTerminarMaisTarde(
                recuperarMassa("nome"),
                gerarCpf(),
                recuperarMassa("dataNascimento"),
                recuperarMassa("email"),
                recuperarMassa("celular"),
                recuperarMassa("senha"));

        dadosPessoaisFunc.validarCadastroTerminarMaisTarde();
    }

}
