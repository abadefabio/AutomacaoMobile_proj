package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pix.ChavesPix;
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
public class QA07356 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PixFunc pix = new PixFunc();
    TransferirPixFunc transferirPix = new TransferirPixFunc();

    @Test(description = "PB.1070.US.94377.022 - Agendar transferência via chave CPF - Conta Corrente - Next")
    @Description("Descrição: Eu enquanto cliente NEXT quero efetuar um agendamento de transferência PIX Objetivo:\n" +
            "Agendar transferência via chave CPF - Conta Corrente - Next\n" +
            "Dados do teste (Massa necessária):\n" +
            "Nenhum requisito\n" +
            "Pré requisitos:\n" +
            "Usuário deve estar logado no menu Next\n" +
            "Possuir uma massa com saldo na conta\n" +
            "Possuir uma chave CPF next\n" +
            "Referência:\n" +
            "Código Jira: NEXT2-94377 - UserStory: [US.01] Agendamento de transferência -com chave e agência e conta")

    @Severity(SeverityLevel.NORMAL)
    public void QA07356() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        pix.selecionarTransferir();

        transferirPix.transferirPix(
                ChavesPix.CPF_CNPJ,
                recuperarMassa("chavePix"),
                TipoConta.CONTA_CORRENTE, TipoTransacao.AGENDAMENTO);

    }
}
