package teste.mobile.regressivo.pix;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.pix.TipoChave;
import constantes.pix.TipoConta;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.IncluirChavePixFunc;
import funcionalidade.mobile.pix.TermosECondicoesFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.PIX)
public class QA02405 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TermosECondicoesFunc termosECondicoesFunc = new TermosECondicoesFunc();
    IncluirChavePixFunc incluirChavePixFunc = new IncluirChavePixFunc();

    @Test(description = "REG.PIX.21.01.01 - Incluir Chave CPF a partir de Onboarding Inicial - Conta Corrente - Acessar o Pix")
    @Description("Validar primeiro acesso de usuário ao PIXPré-Condições: \n" +
            "Ter acesso ao NEXT com ussuário que nunca acessou o PIX. \n")

    @Severity(SeverityLevel.NORMAL)
    public void QA02405() throws Exception {
        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarPix();
        termosECondicoesFunc.realizarAceiteTermosECondicoesPix();
        incluirChavePixFunc.realizarTutorial();
        incluirChavePixFunc.selecionarTipoDeChave(TipoChave.CPF);
        incluirChavePixFunc.selecionarTipoDeConta(TipoConta.CONTA_CORRENTE);
        incluirChavePixFunc.validarChaveIncluidaComSucesso();
        incluirChavePixFunc.validarTelaOpcoesMenuPix();
    }
}
