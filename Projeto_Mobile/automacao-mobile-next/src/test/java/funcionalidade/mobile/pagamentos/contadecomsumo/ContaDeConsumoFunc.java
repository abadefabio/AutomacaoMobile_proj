package funcionalidade.mobile.pagamentos.contadecomsumo;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.pagamentos.TipoConta;
import io.qameta.allure.Step;
import pagina.mobile.jornadas.pagamentos.contadeconsumo.ContaDeConsumoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ContaDeConsumoFunc extends FuncionalidadeBase {

    /**
     * Efetuar pagamento de conta de consumo
     * @param descricao
     * @param tipoConta
     * @param mensagem
     * @throws Exception
     */
    @Step("Efetuar pagamento de conta de consumo")
    public void efetuarPagamendoContaDeConsumo(String descricao, TipoConta tipoConta, String mensagem) throws Exception {
        new ContaDeConsumoTela(getDriver())
                .validarContaDeConsumoTela()
                .tocarConfirmar()
                .editarDescricao(descricao);
        switch (tipoConta){
            case CONTA_CORRENTE:
                new ContaDeConsumoTela(getDriver()).tocarRadioContaCorrente();
                break;
            case CONTA_POUPANCA:
                new ContaDeConsumoTela(getDriver()).tocarRadioContaPoupanca();
                break;
        }
        new ContaDeConsumoTela(getDriver())
                .tocarBotaoPagarAgora();
    }


}
