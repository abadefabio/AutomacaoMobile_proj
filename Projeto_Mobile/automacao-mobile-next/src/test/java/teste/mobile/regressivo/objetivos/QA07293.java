package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import funcionalidade.mobile.objetivos.aporte.RealizarAporteFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA07293 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivosFunc = new ObjetivosFunc();
    RealizarAporteFunc realizarAporteFunc = new RealizarAporteFunc();

    @Test(description = "REG.OBJ.09.02.03 - Validar aplicação com desenquadramento de perfil pelo APORTE")
    @Description("Descrição:\n" +
            " Aplicação do dia com desenquadramento de perfil\n" +
            "Pré-Requisitos:\n" +
            "CPF e senha Válidos" +
            "A massa deve possuir perfil utlraconservador")

    @Severity(SeverityLevel.NORMAL)
    public void QA07293()throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        objetivosFunc.tocarBotaoAporteObjetivo();

        realizarAporteFunc.realizarAporte(recuperarMassa("valorAporte"));

        realizarAporteFunc.validarAporteDesenquadradoPerfil();

        realizarAporteFunc.validarComprovanteAplicacaoNoObjetivo();

    }
}
