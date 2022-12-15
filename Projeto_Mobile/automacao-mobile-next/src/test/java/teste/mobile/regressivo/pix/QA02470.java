package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pix.*;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA02470 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PixFunc pix = new PixFunc();
    ContatoFunc contato = new ContatoFunc();

    @Test(description = "REG.PIX.21.09.13 - Transferir com Contato PIX Cadastrado - Conta Celular - Conta Poupança - Sucesso - Ver comprovante")
    @Description("Descrição: Efetuar transferência, PIX cadastrado.\n" +
            "Pré-Requisito:\n" +
            "\n" +
            "Possuir o aplicativo do Next instalado no celular;\n" +
            "Ter uma conta next;\n" +
            "Cliente estar logado no APP;\n" +
            "Ter contato com chave celular.")

    @Severity(SeverityLevel.NORMAL)
    public void QA02470() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarPix();
        pix.selecionarContatoPix();
        contato.transferirContatoPix(
                recuperarMassa("nomeContato"),
                recuperarMassa("chaveCelular"),
                TipoConta.CONTA_POUPANCA);
    }
}
