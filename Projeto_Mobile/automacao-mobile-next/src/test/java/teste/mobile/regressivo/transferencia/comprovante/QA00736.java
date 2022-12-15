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
public class QA00736 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private ComprovantesFunc comprovantesFunc = new ComprovantesFunc();
    private ComprovantesExtratosFunc comprovantesExtratosFunc = new ComprovantesExtratosFunc();

    @Test(description = "REG.TRF.15.08.02 - Compartilhar a 2� via do comprovante PDF de [TED - Outros Bancos - Outra Pessoa (CNPJ)] de CC-CP")
    @Description("Descri��o (Objetivo):\n" +
            "Compartilhar comprovante transfer�ncia Outras Pessoas tipo TED de conta corrente Next para conta poupan�a outro banco.\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "-N/A\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo instalado;\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir contato cadastrado para realizar transfer�ncia;\n" +
            "Possuir saldo em conta.\n" +
            "Efetuar transfer�ncia necessaria para o teste descrito em Depend�ncias.\n" +
            "\n" +
            "Depend�ncias:\n" +
            "-REG.TRF.05.02 - Validar transfer�ncia - Outra Pessoa - TED - Conta Corrente para Conta Poupan�a - Outros Bancos - PJ\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "Compartilhar comprovante transfer�ncia Outras Pessoas tipo TED de conta poupan�a Next para conta poupan�a outro banco.")

    @Severity(SeverityLevel.NORMAL)
    public void QA00736() throws Exception {

        ConsultaServico servico = ConsultaServico.TRANSFERENCIAS;
        ConsultaTransacao transacao = ConsultaTransacao.TRANSFERENCIA_INTERBANCARIA;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.validarTelaMenu();

        menu.selecionarComprovantes();

        comprovantesExtratosFunc.menuComprovantes();

        comprovantesFunc.consultaComprovante(servico, transacao, recuperarMassa("dataInicialComprovante"), recuperarMassa("dataFinalComprovante"));

        comprovantesFunc.compartilharComprovanteTransferencia();
    }
}
