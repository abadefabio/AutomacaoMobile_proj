package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pix.ChavesPix;
import constantes.pix.DadosPIX;
import constantes.pix.TipoConta;
import constantes.pix.TipoTransacao;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.PixFunc;
import funcionalidade.mobile.pix.TransferirPixFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA02478 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PixFunc pix = new PixFunc();
    TransferirPixFunc transferirPix = new TransferirPixFunc();

    @Test(description = "REG.PIX.21.09.21 - Transferir com E-mail - Conta Corrente - Sucesso - Sair - Outros bancos")
    @Description("Descrição: Efetuar transferência, por chave Email.\n" +
            "Pré-Requisito:\n" +
            "\n" +
            "Possuir o aplicativo do Next instalado no celular;\n" +
            "Ter uma conta next;\n" +
            "Cliente estar logado no APP;\n" +
            "Ter chave Email para destinatário de outros bancos.")

    @Severity(SeverityLevel.NORMAL)
    public void QA02478() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        pix.selecionarTransferir();

        transferirPix.transferirPix(ChavesPix.EMAIL, DadosPIX.E_MAIL, TipoConta.CONTA_CORRENTE, TipoTransacao.TRANSFERENCIA_EMAIL);

    }
}
