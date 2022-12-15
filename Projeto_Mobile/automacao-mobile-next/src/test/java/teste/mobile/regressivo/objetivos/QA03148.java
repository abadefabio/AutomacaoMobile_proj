package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.MensagensObjetivos;
import constantes.objetivos.TipoEdicao;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.EditarObjetivoFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03148 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivosFunc = new ObjetivosFunc();
    EditarObjetivoFunc editarObjetivoFunc = new EditarObjetivoFunc();

    @Test(description = "REG.OBJ.09.07.01 - Validar edição de todos os campos do card parcelas mensais")
    @Description("Descrição:\n" +
            "Validar edição de todos os campos do card parcelas mensais\n" +
            "Pré-Requisitos:\n" +
            "CPF e senha Válidos")

    @Severity(SeverityLevel.NORMAL)
    public void QA03148()throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        editarObjetivoFunc.editarObjetivo(TipoEdicao.EDICAO_PRAZO, MensagensObjetivos.MENSAGEM_OBJETIVO_EDITADO_SUCESSO,true);

        editarObjetivoFunc.editarObjetivo(TipoEdicao.EDICAO_PRAZO_E_DIA,MensagensObjetivos.MENSAGEM_OBJETIVO_EDITADO_SUCESSO,false);
    }
}
