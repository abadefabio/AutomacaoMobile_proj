package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.MensagensObjetivos;
import constantes.objetivos.TipoObjetivo;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

@Jornada(Jornadas.OBJETIVOS)
public class QA03139 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivo = new ObjetivosFunc();
    EditarObjetivoFunc editarObjetivoFunc = new EditarObjetivoFunc();

    @Test(description = "REG.OBJ.09.03.01 - Validar edição de objetivo todos os campos")
    @Description("Descrição: Validar edição de ObjetivosPré-Condições: - Cliente deve estar logado na tela principal do Next\n" +
            "\n" +
            "Ter objetivo cadastrado\n")

    @Severity(SeverityLevel.NORMAL)
    public void QA03139() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.validarTelaMenu();

        menu.selecionarObjetivos();

        editarObjetivoFunc.tocarEditarObjetivo();

        editarObjetivoFunc.alteraDadosObjetivo();

    }
}


