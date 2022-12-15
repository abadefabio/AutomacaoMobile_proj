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
public class QA23460 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private CriarContaFunc criarContaFunc = new CriarContaFunc();

    private DadosPessoaisFunc dadosPessoaisFunc = new DadosPessoaisFunc();

    @Test(description = "PBI-171887.001.001 - Validar lista Estado Civil")
    @Description("Validar lista Estado Civil- CPF valido para adesão.")

    @Severity(SeverityLevel.NORMAL)
    public void QA23460() throws Exception{

        login.acessarTelaCriarConta();

        criarContaFunc.criarConta(
                recuperarMassa("nome"),
                gerarCpf(),
                recuperarMassa("dataNascimento"),
                recuperarMassa("email"),
                recuperarMassa("celular"),
                recuperarMassa("senha"));

        dadosPessoaisFunc.validarOpcoesCampoEstadoCivil();
    }

}
