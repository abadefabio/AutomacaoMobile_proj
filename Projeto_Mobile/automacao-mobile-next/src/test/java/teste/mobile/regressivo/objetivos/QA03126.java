package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.perfil.investidor.DescobrindoSeuPerfil;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import funcionalidade.mobile.objetivos.aporte.AporteFunc;
import funcionalidade.mobile.perfil.investidor.DescobrindoPerfilFunc;
import funcionalidade.mobile.perfil.investidor.SeuPerfilFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static constantes.perfil.investidor.SeuPerfil.PERFIL_ARROJADO;
import static constantes.perfil.investidor.StatusPerfil.PERFIL_VENCIDO;

@Jornada(Jornadas.OBJETIVOS)
public class QA03126 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivo = new ObjetivosFunc();
    DescobrindoPerfilFunc perfil  = new DescobrindoPerfilFunc ();
    SeuPerfilFunc tipoPerfil = new SeuPerfilFunc();
    AporteFunc aporte = new AporteFunc();

    private ThreadLocal<String> valorDisponivelSaldo = new ThreadLocal<>();

    @Test(description="REG.OBJ.09.02.02 - Validar aplicação com perfil vencido - pelo botão APORTE - REFAZER PERFIL")
    @Description("Descrição (Objetivo): Aplicação do dia com desenquadramento de perfil\n" +
            "Pré-Requisitos:\n" +
            "\n" +
            "CPF e senha Válidos\n" +
            "Desenquadrado .")
    @Severity(SeverityLevel.NORMAL)
    public void QA03126()throws Exception{


        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.tocarExibirSaldoConta(valorDisponivelSaldo);

        menu.selecionarObjetivos();

        objetivo.selecionarAporte(PERFIL_VENCIDO);

        perfil.descobrindoSeuPerfilRefazerPerfil(
                DescobrindoSeuPerfil.TENHO_FORMACAO_MAS_NAO_TENHO_EXPERIENCIA,
                DescobrindoSeuPerfil.JA_FIZ_INVESTIMENTO_NOS_ULTIMOS_12_MESES,
                DescobrindoSeuPerfil.MUITAS_VEZES_FIZ_UMAS_DOZE_APLICACOES,
                DescobrindoSeuPerfil.QUERO_JUNTAR_DINHEIRO_PRA_MINHA_APOSENTADORIA,
                DescobrindoSeuPerfil.MAIS_DE_QUARENTA_PORCENTO_DA_MINHA_RENDA,
                DescobrindoSeuPerfil.MAIS_QUE_TRES_MM,
                DescobrindoSeuPerfil.MAIS_DE_70_POR_CENTO_EM_PRODUTOS_FINANCEIROS,
                DescobrindoSeuPerfil.NAO_PRECISO_DO_DINHEIRO_AGORA_E_NEM_INVESTIRIA_MAIS,
                DescobrindoSeuPerfil.FARIA_E_ATE_PODERIA_CONTINUAR_INVESTINDO_MESMO_RISCO_PERDER_TUDO);

        tipoPerfil.validarTipoPerfilAposResponderQuestionario(PERFIL_ARROJADO);

        aporte.aplicarAporteNoObjetivo(recuperarMassa("valorAporte"));

        Integer valorInicial = Integer.parseInt(Utilitarios.normalizaStringNumero(valorDisponivelSaldo.get()));
        Integer valorResgate = Integer.parseInt(Utilitarios.normalizaStringNumero(recuperarMassa("valorAporte")));

        Integer valorSaldoFinal = valorInicial - valorResgate;
        aporte.verificarVoltarTelaMenuInicial();
        menu.validaSaldoFinal(valorSaldoFinal.toString());

    }
}
