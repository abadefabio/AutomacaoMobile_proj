package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.MensagensObjetivos;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import funcionalidade.mobile.objetivos.notificacoes.NotificacoesFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03212 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private ObjetivosFunc objetivos = new ObjetivosFunc();
    private NotificacoesFunc notificacoes = new NotificacoesFunc();

    @Test(description = "REG.OBJ.09.15.03 - Validar notificação com dados cadastrais incompleto - CONTINUAR NO CHAT")
    @Description("Pré-Requisitos:\n" +
            "CPF e senha Válidos\n" +
            "Desenquadrado")

    @Severity(SeverityLevel.NORMAL)
    public void QA03212() throws Exception {

        login.efetuarLoginUsuarioExistente( recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNotificacoes();

        notificacoes.validarDadosCadastraisContinuandoNoChat(MensagensObjetivos.MENSAGEM_OBJETIVO_NOTIFICACOES_CHAT);

    }
}
