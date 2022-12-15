package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.TipoObjetivo;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.NovoObjetivoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03116 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    NovoObjetivoFunc novoObjetivo = new NovoObjetivoFunc();


    @Test(description = "REG.OBJ.09.01.04 - Validar o valor mínimo da PARCELA, valor mínimo da META e o COMPROMETIMENTO ORÇAMENTO durante a criação de objetivo")
    @Description("Pré-Requisitos:" +
            "1 - Realizar o acesso a jornada de objetivos:" +
            "POSSUINDO PERFIL DE INVESTIDOR , POSSUINDO OBJETIVOS CRIADO" +
            "2 - Criar um objetivo com o produto NEXT MULTIMERCADO" +
            "Objetivo do teste;" +
            "Validar o valor mínimo da \"META\"" +
            "Validar o valor mínimo da \"PARCELA\"" +
            "Validar o \"COMPROMETIMENTO DO ORÇAMENTO\"")
    @Severity(SeverityLevel.NORMAL)

    public void QA03116() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        novoObjetivo.criarNovoObjetivoValidandoValoresDeParcelas(TipoObjetivo.TIPO_OBJETIVO_CASA, recuperarMassa("nomeObjetivo"), recuperarMassa("valorMinimo"),recuperarMassa("valorAcimaMeta"), recuperarMassa("valor"),recuperarMassa("valorParcela"));
    }
}
