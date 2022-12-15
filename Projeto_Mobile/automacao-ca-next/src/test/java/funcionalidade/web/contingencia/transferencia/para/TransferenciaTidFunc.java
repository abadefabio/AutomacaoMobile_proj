package funcionalidade.web.contingencia.transferencia.para;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.contingencia.MobileContingenciaTela;
import pagina.web.contingencia.transferencia.TrasferenciaTidTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class TransferenciaTidFunc extends FuncionalidadeBase {

    /**
     * Metódo para confirmar a autorização da transação da TID
     * @throws Exception
     * @param senha
     * @return
     */

    public void confirmarTidTransferencia(String senha) throws Exception {
        MobileContingenciaTela mobileContingenciaTela = new MobileContingenciaTela(getDriver());
        TrasferenciaTidTela transferenciaTela = new TrasferenciaTidTela(getWebDriver());
        String TID = transferenciaTela
                .lerTID();
        mobileContingenciaTela
                .informarTID(TID)
                .tocarBotaoAvancar()
                .tocarBotaoTransferir()
                .informarSenhaLogin(senha)
                .tocarBotaoContinuar()
                .tocarBotaoOk();
    }
}
