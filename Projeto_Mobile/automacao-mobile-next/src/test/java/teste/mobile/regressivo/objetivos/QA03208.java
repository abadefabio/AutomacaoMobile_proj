package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivoFinalizadoFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03208 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivoFunc = new ObjetivosFunc();

    @Test(description = "REG.OBJ.09.13.08 - Objetivo Conclu�do - Validar o bot�o Ver Produto na tela de detalhes")
    @Description("Descri��o:\n" +
            "Validar exclus�o de aplica��o agendada\n" +
            "Pr�-Requisitos:\n" +
            "CPF e senha V�lidos")

    @Severity(SeverityLevel.NORMAL)
    public void QA03208()throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        objetivoFunc.verProdutoShopFacil(true);
    }
}
