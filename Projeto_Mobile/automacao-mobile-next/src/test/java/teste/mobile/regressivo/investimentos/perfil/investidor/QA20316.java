package teste.mobile.regressivo.investimentos.perfil.investidor;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.investimentos.Decisao;
import constantes.perfil.investidor.DescobrindoSeuPerfil;
import funcionalidade.mobile.investimentos.home.HomeInvestimentosFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.perfil.investidor.DescobrindoPerfilFunc;
import funcionalidade.mobile.perfil.investidor.SeuPerfilFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.constantes.massa.JSON.CPF;
import static br.com.next.automacao.core.constantes.massa.JSON.SENHA;
import static constantes.perfil.investidor.SeuPerfil.PERFIL_ULTRACONSERVADOR;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA20316 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    HomeInvestimentosFunc homeInvestimentos = new HomeInvestimentosFunc();

    DescobrindoPerfilFunc descobrindoPerfil = new DescobrindoPerfilFunc();
    SeuPerfilFunc seuPerfil = new SeuPerfilFunc();

    @Test(description = "PBI.153634.153649.002 Verificar se é possível criar e refazer um perfil de investidor de usuário com investimento e sem perfil através da nova Home de Investimentos")
    @Description("COMO Usuário de investimento NEXT\n" +
            "QUERO poder visualizar nova home de investimentos com os links as is\n" +
            "PARA que eu possa navegar nos itens da jornadaTer o app instalado.\n" +
            "Pré-requisitos:\n" +
            "Ter conta ativa no Next;\n" +
            "Ter investimentos no app;\n" +
            "Não ter perfil de investidor.\n" +
            "\n")
    @Severity(SeverityLevel.NORMAL)

    public void QA20316() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos(Decisao.JA_ACESSOU_COM_INVESTIMENTOS);

        homeInvestimentos.descubraSeuPerfilDeInvestidor();

        descobrindoPerfil.responderQuestionarioPrimeirasOpcoes();

        descobrindoPerfil.resultadoSeuPerfil();

        homeInvestimentos.refazerPerfilDeInvestidor();

        descobrindoPerfil.descobrindoSeuPerfilRefazerPerfil(
                DescobrindoSeuPerfil.NAO_TENHO_FORMACAO_NAO_ENTENDO_DO_ASSUNTO,
                DescobrindoSeuPerfil.NUNCA_INVESTI_MAS_SEI_POUCO_SOBRE_TIPOS_DE_INVESTIMENTOS,
                DescobrindoSeuPerfil.NAO_FIZ_APLICACOES,
                DescobrindoSeuPerfil.QUERO_TER_RESERVA_PARA_IMPREVISTOS_E_TIRAR_QUANDO_PRECISAR,
                DescobrindoSeuPerfil.NUNCA_INVESTI,
                DescobrindoSeuPerfil.ATE_DUZENTOS_E_CINQUENTA_MIL,
                DescobrindoSeuPerfil.AINDA_NAO_INVESTI,
                DescobrindoSeuPerfil.NAO_TENHO_PLANOS_COMO_USAR_ESSE_DINHEIRO_NO_FUTURO,
                DescobrindoSeuPerfil.PREFIRO_NAO_CORRER_RISCO_DE_PERDER_DINHERIO);

        seuPerfil.validarTipoPerfilAposResponderQuestionario(PERFIL_ULTRACONSERVADOR);
    }
}
