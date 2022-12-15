package teste.mobile.regressivo.vaquinha;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.vaquinha.VaquinhaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

;

@Jornada(Jornadas.VAQUINHA)
public class QA00116 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    VaquinhaFunc vaquinha = new VaquinhaFunc();

    @Test(description = "REG.VAQ.01.01 - Valida��o de: cria��o da vaquinha com primeiro acesso e que n�o � poss�vel exceder a quantia m�xima de 5 vaquinhas")
    @Description("Objetivos: \n" +
            "Cria��o da primeira vaquinha com valor at� no m�ximo de R$5.000,00 (1) e validar que n�o � poss�vel exceder  a quantidade m�xima de vaquinhas simult�neas (2).\n" +
            "Pr�-Requisitos:\n" +
            "1. Possuir o aplicativo do Next instalado no celular;\n" +
            "2. Ter acesso a cri��o de vaquinha" +
            "3. Possuir um CPF que nunca tenha criado uma vaquinha")

    @Severity(SeverityLevel.NORMAL)
    public void QA00116() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarVaquinha();

        vaquinha.criarMultiplasVaquinhas(5);

        vaquinha.validarLimiteVaquinhasCriadas();

    }

    @AfterMethod
    public void deletarVaquinhas() throws Exception{

        vaquinha.excluirMultiplasVaquinhas(5);

        vaquinha.excluirMultiplosCards(5);

    }
}
