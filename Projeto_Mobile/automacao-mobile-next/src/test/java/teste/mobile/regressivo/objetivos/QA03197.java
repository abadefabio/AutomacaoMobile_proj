package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import funcionalidade.mobile.perfil.investidor.DescobrindoPerfilFunc;
import funcionalidade.mobile.perfil.investidor.SeuPerfilDeInvestidorFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03197  extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivos = new ObjetivosFunc();
    SeuPerfilDeInvestidorFunc seuPerfilDeInvestidor = new SeuPerfilDeInvestidorFunc();
    DescobrindoPerfilFunc descobrindoPerfil = new DescobrindoPerfilFunc();

    @Test(description = "REG.OBJ.09.11.08 - Validar a descoberta de perfil investidor pelo bot�o - RESPONDER")
    @Description("Descri��o (Objetivo): Validar tela de perfil investidor SEM POSSUIR PERFIL DE INVESTIDOR E SEM POSSUIR TERMO - RESPONDER\n" +
            "Pr�-Requisitos:\n" +
            "\n" +
            "CPF e senha V�lidos\n" +
            "Possuir objetivo criado com produto nextSimples,\n" +
            "N�o ter realizado a descorberta de perfil de investidor\n" +
            "N�o possuir termo \"TERMO RECUSA\" assinado")

    @Severity(SeverityLevel.NORMAL)
    public void QA03197()throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        objetivos.acessarPerfilInvestidorViaMenu();

        seuPerfilDeInvestidor.acessarPerfilInvestidorResponderQuestionario();

        descobrindoPerfil.responderQuestionarioPrimeirasOpcoes();

    }

}
