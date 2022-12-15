package teste.mobile.regressivo.transferencia.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.comprovantes.ConsultaServico;
import constantes.comprovantes.ConsultaTransacao;
import funcionalidade.mobile.comprovantes.ComprovantesExtratosFunc;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.TRANSFERENCIA)
public class QA26864 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private ComprovantesFunc comprovantesFunc = new ComprovantesFunc();
    private ComprovantesExtratosFunc comprovantesExtratosFunc = new ComprovantesExtratosFunc();

    @Test(description = "REG.TRF.15.08.03 - Compartilhar a 2ª via do comprovante PDF de - Outra Pessoa - [Next - CP] para [Bradesco - CC]")
    @Description("Descrição (Objetivo):\n" +
            "Compartilhar comprovante transferência Outras Pessoas tipo TED de conta poupança Next para conta corrente BRADESCO.\n" +
            "Dados do teste (Massa necessária):\n" +
            "-N/A\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo instalado;\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir contato cadastrado para realizar transferência;\n" +
            "Possuir saldo em conta poupança.\n" +
            "Efetuar transferência necessaria para o teste descrito em Dependências.\n")

    @Severity(SeverityLevel.NORMAL)
    public void QA26864() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.validarTelaMenu();

        menu.selecionarComprovantes();

        comprovantesExtratosFunc.menuComprovantes();

        comprovantesFunc.consultaComprovante(ConsultaServico.TRANSFERENCIAS, ConsultaTransacao.TRANSFERENCIA_BANCARIA, recuperarMassa("dataInicialComprovante"), recuperarMassa("dataFinalComprovante"));

        comprovantesFunc.compartilharComprovanteTransferencia();
    }
}
