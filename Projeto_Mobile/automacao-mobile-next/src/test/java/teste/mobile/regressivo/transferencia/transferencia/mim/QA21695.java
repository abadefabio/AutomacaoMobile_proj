package teste.mobile.regressivo.transferencia.transferencia.mim;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.MensagensEsperadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static constantes.transferencia.ContaPagamento.CADASTRO_TRANSFERENCIA_OUTRA_CC_CC_BRADESCARD_1;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA21695 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();

    private ThreadLocal<String> valorDisponivelSaldo = new ThreadLocal<>();

    @Test(description = "Validar TRANSFERÊNCIA acima de R$ 10.000,00 - Para Mim - CC para CC e Next para Bradesco")
    @Description("Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n" +
            "Ter um contato já cadastrado")

    @Severity(SeverityLevel.NORMAL)
    public void QA21695() throws Exception {

        ContaPagamento dadosTransf = ContaPagamento.CONTA_TRANSFERENCIA_BRADESCO_FR;
        String cpf = recuperarMassa(JSON.CPF);

        login.efetuarLoginUsuarioExistente(cpf, recuperarMassa(JSON.SENHA));
        menu.tocarExibirSaldoConta(valorDisponivelSaldo);

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(TransferirPara.MIM);
        minhasContas.selecionarMinhaConta(dadosTransf);
        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());
        transferirFunc.iniciarTransferenciaString(recuperarMassa("valor"),recuperarMassa("nome"));

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());
        transferirFunc.validarTransferir(dadosTransf);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_DE_TRANSFERENCIA_DATA_ATUAL);

        transferirFunc.validarComprovanteAgendamentoTransferencia();

        Integer valorInicial = Integer.parseInt(Utilitarios.normalizaStringNumero(valorDisponivelSaldo.get()));
        Integer valorTransferencia = Integer.parseInt(Utilitarios.normalizaStringNumero(recuperarMassa("valor")));
        Integer valorSaldoFinal = valorInicial - valorTransferencia;

        menu.validaSaldoFinal(valorSaldoFinal.toString());
    }
}
