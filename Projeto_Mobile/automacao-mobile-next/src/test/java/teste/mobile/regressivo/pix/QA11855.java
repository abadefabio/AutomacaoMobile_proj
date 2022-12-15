package teste.mobile.regressivo.pix;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.pix.ChavesPix;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.MinhasChavesFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Jornada(Jornadas.PIX)
public class QA11855 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MinhasChavesFunc minhasChavesFunc = new MinhasChavesFunc();


    @Test(description = "-PIX-PB.1070.US.75881.006 - Confirmação de \n" +
            "exclusão de Chave aleatória - Mais Chaves - Botão OK - Conta-Corrente\n")
    @Description("Possuir massa de dados com uma chave aleatória vinculada a conta-corrente.")

    @Severity(SeverityLevel.NORMAL)
    public void QA11855() throws Exception {
        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarPix();
        minhasChavesFunc.validarExclusaoDeChave(ChavesPix.CHAVE_ALEATORIA_CONTA_CORRENTE.toString(), true);
    }
}
