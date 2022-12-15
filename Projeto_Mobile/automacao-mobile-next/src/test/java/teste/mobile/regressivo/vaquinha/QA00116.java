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

    @Test(description = "REG.VAQ.01.01 - Validação de: criação da vaquinha com primeiro acesso e que não é possível exceder a quantia máxima de 5 vaquinhas")
    @Description("Objetivos: \n" +
            "Criação da primeira vaquinha com valor até no máximo de R$5.000,00 (1) e validar que não é possível exceder  a quantidade máxima de vaquinhas simultâneas (2).\n" +
            "Pré-Requisitos:\n" +
            "1. Possuir o aplicativo do Next instalado no celular;\n" +
            "2. Ter acesso a crição de vaquinha" +
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
