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


    @Test(description = "REG.TRF.15.03.02 - Validar TRANSFER�NCIA - Para mim - Conta Poupan�a - Cliente n�o possui Saldo e Grana de Emerg�ncia - Outros Bancos")
    @Description("Descri��o (Objetivo):\n" +
            "Validar TRANSFER�NCIA - Para mim - De Conta Poupan�a - Cliente n�o possui Saldo e Grana de Emerg�ncia - Outros Bancos.\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PF)\n" +
            "N�o obter saldo em conta;\n" +
            "N�o obter grana de emerg�ncia.\n" +
            "Ter cadastro no PACL\n" +
            "Depend�ncias:\n" +
            "N/A.\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "TRANSFER�NCIA - Para mim - De Conta Poupan�a - Cliente n�o possui Saldo e Grana de Emerg�ncia - Outros Bancos.")
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
