package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.transferencia.*;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00726 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();
    private TransferirFunc transferir = new TransferirFunc();

    @Test(description = "REG.TRF.15.05.01 - Validar TRANSFERÊNCIA - Outra Pessoa - DOC - Conta Corrente para Poupança - Outros Bancos - PF - Acentuação")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Outra Pessoa - DOC - Conta Corrente para Poupança - Outros Bancos - PF.\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PF)\n" +
            "Possuir saldo em conta.\n" +
            "\n" +
            "Dependências:\n" +
            "Ter cadastro na PACL\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "TRANSFERÊNCIA - Outra Pessoa - DOC - Conta Corrente para Poupança - Outros Bancos - PF.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00726() throws Exception{

        ContaPagamento dadosTransf = ContaPagamento.CONTA_BANCO_SANTANDER;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        outraPessoa.selecionarContatoOutraPessoa(ContaPagamento.CONTA_BANCO_SANTANDER);

        transferir.exibirFaixaDropdown();

        transferir.ocultarFaixaDropdown();

        transferir.verificarTipoDeContaOrigemEstaSelecionado(TipoDeConta.CONTA_CORRENTE);

        transferir.validarTransferenciaValorAcimaLimite(dadosTransf);

        transferir.selecionarTipoDeContaDestino(TipoDeConta.CONTA_POUPANCA);

        transferir.selecionarTipoTransferencia(TipoTransferencia.DOC);

        transferir.selecionarMotivoTransferencia(TransferenciaMotivo.DOC_PARA_POUPANCA);

        transferir.validarTransferir(dadosTransf);

        transferir.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_TRANSFERENCIA);

        transferir.validarComprovanteAgendamentoTransferencia(); //Validar nomenclatura do método

        menu.validarTelaMenu();
    }
}
