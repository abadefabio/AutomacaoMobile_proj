package teste.web.regressivo.frontend.mgm;

import base.teste.TesteBaseFrontEnd;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.tools.ReadProperties;
import funcionalidade.frontend.login.LoginGestaoOcorrenciasFunc;
import funcionalidade.frontend.menu.MenuGestaoOcorrenciasFunc;
import funcionalidade.frontend.menu.MenuHamburguerFunc;
import funcionalidade.frontend.mgm.IndicacoesAmigosCpfFunc;
import funcionalidade.frontend.mgm.IndicacoesAmigosCpfIndicadorFunc;
import funcionalidade.frontend.mgm.IndicacoesAmigosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ATENDIMENTO)
public class QA24325 extends TesteBaseFrontEnd {

    LoginGestaoOcorrenciasFunc loginGestao = new LoginGestaoOcorrenciasFunc();
    MenuGestaoOcorrenciasFunc menuGestao = new MenuGestaoOcorrenciasFunc();
    MenuHamburguerFunc menuHamburguer = new MenuHamburguerFunc();
    IndicacoesAmigosCpfFunc indicacoesAmigosCpf = new IndicacoesAmigosCpfFunc();
    IndicacoesAmigosCpfIndicadorFunc indicacoesAmigosCpfIndicador = new IndicacoesAmigosCpfIndicadorFunc();
    IndicacoesAmigosFunc indicacoesAmigos = new IndicacoesAmigosFunc();

    @Test(description = "[QA AUT] Validar na página de 'Indique amigos' (Indicador) a funcionalidade do botão 'Buscar' no painel de filtros")
    @Description("Pré-condições:\n" +
            "1. Ter acesso ao Gestão de Ocorrências;\n" +
            "2. Ter perfil de acesso ao Indicações de Amigos;\n" +
            "3. Possuir um CPF Indicador válido para realizar a busca.")
    @Severity(SeverityLevel.NORMAL)
    public void QA24325() throws Exception {
        loginGestao.loginGestaoOcorrencias(ReadProperties.getGestaoUser(), ReadProperties.getGestaoPass());
        menuGestao.acessarMenuHamburguer();
        menuHamburguer.acessarIndicacoesAmigos();
        indicacoesAmigosCpf.inserirCPFIndicadorBuscarConvidados(recuperarMassa("cpfIndicador"));
        indicacoesAmigosCpfIndicador.filtrarConvidadoTodosCampos(
                recuperarMassa("convidado"),
                recuperarMassa("statusConta"),
                recuperarMassa("cpf"),
                recuperarMassa("dataInicio"),
                recuperarMassa("dataFim"));
        indicacoesAmigos.validarConvidadoFiltradoTodosCampos(
                recuperarMassa("convidado"),
                recuperarMassa("cpf"),
                recuperarMassa("dataAceite"),
                recuperarMassa("statusConta"),
                recuperarMassa("dataAbertura"),
                recuperarMassa("previsaoBonus"));
    }
}
