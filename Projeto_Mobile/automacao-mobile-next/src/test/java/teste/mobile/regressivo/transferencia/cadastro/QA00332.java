package teste.mobile.regressivo.transferencia.cadastro;

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
public class QA00332 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc meusContatos = new MeusContatosFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();

    @Test(description = "REG.TRF.15.01.15 - Validar aba Novo contato sem salvar o contato validando CPF inválido")
    @Description("Objetivos: \n" +
            "  Validar transferencia sem salvar contato.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            "Possuir o aplicativo do Next instalado no celular;\n" +
            "Possuir CPF válido.\n" +
            " \n" +
            "Pós-Condições:\n" +
            " Não possuir nenhum contato Salvo.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")

    @Severity(SeverityLevel.NORMAL)
    public void QA00332() throws Exception {

        /*
        Dados de cadastro devem incluir um banco com agência e conta reais
        de banco terceiro (porque cadastramos CPF) para a realização da transferência (sem agendar)
        Portanto, para este CT, usamos o Banco do Brasil com agência e contas específicas.
         */
        CadastroContatoTransferencia cadastro = CadastroContatoTransferencia.CADASTRO_SEM_SALVAR_TRANSFERENCIA_BANCO_TERCEIRO_CADASTRADO;
        ContaPagamento dadosTransf = cadastro.recuperarContaPagamento();
        TransferenciaMotivo motivo = TransferenciaMotivo.CREDITO_EM_CONTA; // fluxo não especifica motivo então escolhemos este

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.aceitarTecladoNext();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara()); // outra pessoa

        meusContatos.informarCpfCnpjInvalidoContinuar(GeradorNumeros.CPF_INVALIDO, MensagensEsperadas.CADASTRO_CPF_INVALIDO);

        meusContatos.cadastrarContato(cadastro); // objeto 'cadastro' teve ter flag para não salvar contato

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem()); // padrão (CC)

        transferirFunc.iniciarTransferencia(dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino()); // padrão (CC)

        transferirFunc.selecionarTipoTransferencia(dadosTransf.recuperarTipoTransferencia()); // padrão (TED)

        transferirFunc.selecionarMotivoTransferencia(motivo); // qualquer motivo, então usamos "crédito em conta"

        transferirFunc.validarTransferir(cadastro.recuperarContaPagamento(), motivo);

        /*
        Ao transferir de conta cadastrada sem salvar, a mensagem da transferência é diferente de quando já existe um contato salvo.
         */
        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_CADASTRO_SEM_SALVAR_TRANSFERENCIA);

        transferencia.iniciarNovaTransferencia(); // tocar botão Nova Transferência

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara()); // outra pessoa

        meusContatos.validarContatoNaoSalvoAposTransferencia();

    }
}
