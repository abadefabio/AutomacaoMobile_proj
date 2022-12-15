package funcionalidade.mobile.depositos;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.depositos.AgendarSaqueTela;
import pagina.mobile.jornadas.depositos.DepositosSaquesTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class DepositosSaquesFunc extends FuncionalidadeBase {

    /**
     * Método para acessar 'Transferir de outros bancos'
     *
     * @throws Exception
     */
    public void acessarTransferirOutrosBancos() throws Exception {
        new DepositosSaquesTela(getDriver())
                .tocarBotaoTransferirOutrosBancos();
    }

    /**
     * Método para acessar 'Agendar Saques'
     *
     * @throws Exception
     */
    public void acessarAgendarSaques() throws Exception {
        new DepositosSaquesTela(getDriver())
                .tocarBotaoAgendarSaque();
        new AgendarSaqueTela(getDriver())
                .tocarBotaoContinuar();
    }
}
