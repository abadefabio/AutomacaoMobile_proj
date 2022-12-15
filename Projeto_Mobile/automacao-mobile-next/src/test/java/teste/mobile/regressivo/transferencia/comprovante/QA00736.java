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

    @Test(description = "REG.TRF.15.08.02 - Compartilhar a 2ª via do comprovante PDF de [TED - Outros Bancos - Outra Pessoa (CNPJ)] de CC-CP")
    @Description("Descrição (Objetivo):\n" +
            "Compartilhar comprovante transferência Outras Pessoas tipo TED de conta corrente Next para conta poupança outro banco.\n" +
            "Dados do teste (Massa necessária):\n" +
            "-N/A\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo instalado;\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir contato cadastrado para realizar transferência;\n" +
            "Possuir saldo em conta.\n" +
            "Efetuar transferência necessaria para o teste descrito em Dependências.\n" +
            "\n" +
            "Dependências:\n" +
            "-REG.TRF.05.02 - Validar transferência - Outra Pessoa - TED - Conta Corrente para Conta Poupança - Outros Bancos - PJ\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "Compartilhar comprovante transferência Outras Pessoas tipo TED de conta poupança Next para conta poupança outro banco.")

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
