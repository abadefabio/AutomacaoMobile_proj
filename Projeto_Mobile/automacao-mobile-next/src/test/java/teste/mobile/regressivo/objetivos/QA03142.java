package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.MensagensObjetivos;
import constantes.objetivos.TipoObjetivo;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ExcluirObjetivoFunc;
import funcionalidade.mobile.objetivos.NovoObjetivoFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;
import static constantes.objetivos.MensagensObjetivos.MENSAGEM_OBJETIVO_EXCLUIDO;
import static constantes.objetivos.MensagensObjetivos.MENSAGEM_OBJETIVO_SO_ACONTECE_DIAS_UTEIS;

@Jornada(Jornadas.OBJETIVOS)
public class QA03142 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivo = new ObjetivosFunc();
    ExcluirObjetivoFunc excluirObj = new ExcluirObjetivoFunc();


    @Test(description = "REG.OBJ.09.04.01 - Validar cancelamento de objetivos com aplicação")
    @Description("Descrição: Validar cancelamento de Objetivos\n" +
            "Pré-Condições: - Cliente deve estar logado na tela principal do Next\n" +
            "Ter objetivo cadastrado\n")

    @Severity(SeverityLevel.NORMAL)
    public void QA03142() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        excluirObj.excluirObjetivo(MENSAGEM_OBJETIVO_EXCLUIDO,MENSAGEM_OBJETIVO_SO_ACONTECE_DIAS_UTEIS);
    }
}
