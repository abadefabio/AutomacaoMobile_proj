package teste.mobile.regressivo.transferencia.transferencia.mim;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.TipoDeConta;
import constantes.transferencia.TipoTransferencia;
import constantes.transferencia.TransferenciaMotivo;
import constantes.transferencia.ValorTransferencia;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


@Jornada(Jornadas.TRANSFERENCIA)
public class QA00724 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();

    @Test(description = "REG.TRF.15.03.05 - Validar TRANSFERÊNCIA - Para mim - DOC - Conta Corrente - Com valor acima de R$ 4.999,99 - Outros Bancos")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Para mim - DOC - De Conta Corrente - valor SUPERIOR ao permitido - Outros Bancos.\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PF)\n" +
            "Possuir saldo em conta.\n" +
            "Ter cadastro no PACL\n" +
            "\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "TRANSFERÊNCIA - Para mim - DOC - De Conta Corrente - valor SUPERIOR ao permitido - Outros Bancos.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00724() throws Exception {
        String cpf = recuperarMassa(JSON.CPF);
        JSONObject contaPagamento = atualizarContaPagamentoParams(TipoDeConta.CONTA_CORRENTE, TipoTransferencia.DOC,
                TipoDeConta.CONTA_CORRENTE, ValorTransferencia.VALOR_ALEATORIO_ACIMA_DE_5000, TransferirPara.MIM, TransferenciaMotivo.CREDITO_EM_CONTA);

        login.efetuarLoginUsuarioExistente(cpf, recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.aceitarTecladoNext();

        transferencia.selecionarTransferirPara(contaPagamento.get("transferirPara").toString());
        JSONObject json = recuperarJSSONMassa("contaPagamento");


        minhasContas.selecionarMinhaContaPorNome(json.get("conta").toString(), json.get("agencia").toString());


        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigemString(contaPagamento.get("tipoContaOrigem").toString());

        transferirFunc.iniciarTransferenciaString(contaPagamento.get("valor").toString(), json.get("nome").toString());

        transferirFunc.selecionarTipoDeContaDestinoString(contaPagamento.get("tipoContaDestino").toString());

        transferirFunc.selecionarTipoTransferenciaDocInvalido(); // Tentar selecionar opção Doc
    }

    private JSONObject atualizarContaPagamentoParams(TipoDeConta contaOrigem, TipoTransferencia tipoTransf,
                                                     TipoDeConta contaDestino, ValorTransferencia valor, TransferirPara transferirPara,
                                                     TransferenciaMotivo motivo) {

        JSONObject contaPagamento = new JSONObject();
        contaPagamento.put("tipoContaOrigem", contaOrigem);
        contaPagamento.put("tipoTransferencia", tipoTransf);
        contaPagamento.put("tipoContaDestino", contaDestino);
        contaPagamento.put("valor", valor);
        contaPagamento.put("transferirPara", transferirPara);
        contaPagamento.put("finalidade", motivo);

        return contaPagamento;
    }
}
