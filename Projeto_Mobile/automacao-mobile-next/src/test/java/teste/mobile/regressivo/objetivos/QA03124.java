package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03124 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    ObjetivosFunc objetivosFunc = new ObjetivosFunc();

    @Test(description = "REG.OBJ.09.01.12 - Validar tela de tutorial - CRIAR OBJETIVO")
    @Description("Pré-Requisitos:\n" +
            "Pré-requisito na massa de teste\n" +
            "Não deve possuir objetivo criado\n" +
            "Deve possuir perfil de investidor\n" +
            "Pré-requisito no celular de teste\n" +
            "Android - Realizar uma das ações abaixo.\n" +
            "Desinstalar e reinstalar o aplicativo do Next no celular.\n" +
            "Instalar o aplicativo do Next pela primeira vez no celular.\n" +
            "Limpar o cache por completo do aplicativo Next no celular.\n" +
            "IOS - Realizar uma das ações abaixo.\n" +
            "Desinstalar e reinstalar o aplicativo do Next no celular.\n" +
            "Instalar o aplicativo do Next pela primeira vez no celular.")

    @Severity(SeverityLevel.NORMAL)
    public void QA03124() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menuFunc.selecionarObjetivos();

        objetivosFunc.validarDetalhesTelaTutorialObjetivos();

        menuFunc.selecionarObjetivos();

        objetivosFunc.tocarBotaoCriarObjetivo();
    }
}
