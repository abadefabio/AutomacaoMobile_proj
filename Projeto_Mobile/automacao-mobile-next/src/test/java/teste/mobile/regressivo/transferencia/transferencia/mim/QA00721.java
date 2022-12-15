package teste.mobile.regressivo.transferencia.transferencia.mim;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.TipoDeConta;
import constantes.transferencia.ValorTransferencia;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00721 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();
    private SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();


    @Test(description = "REG.TRF.15.03.02 - Validar TRANSFERÊNCIA - Para mim - Conta Poupança - Cliente não possui Saldo e Grana de Emergência - Outros Bancos")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Para mim - De Conta Poupança - Cliente não possui Saldo e Grana de Emergência - Outros Bancos.\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PF)\n" +
            "Não obter saldo em conta;\n" +
            "Não obter grana de emergência.\n" +
            "Ter cadastro no PACL\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "TRANSFERÊNCIA - Para mim - De Conta Poupança - Cliente não possui Saldo e Grana de Emergência - Outros Bancos.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00721() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        ContaPagamento dadosTransf = ContaPagamento.CONTA_BANCO_ITAU;

        transferencia.selecionarTransferirPara(TransferirPara.MIM);

        minhasContas.selecionarMinhaConta(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(TipoDeConta.CONTA_POUPANCA);

        transferirFunc.validarTranferenciaSemSaldo(dadosTransf, ValorTransferencia.VALOR_ALEATORIO_100_A_500);

    }
}
