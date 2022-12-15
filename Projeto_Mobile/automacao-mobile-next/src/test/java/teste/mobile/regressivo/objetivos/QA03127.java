package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.perfil.investidor.DescobrindoSeuPerfil;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import funcionalidade.mobile.objetivos.aporte.RealizarAporteFunc;
import funcionalidade.mobile.perfil.investidor.DescobrindoPerfilFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static constantes.objetivos.JSONObjetivos.TITULO_EXTRATO;
import static constantes.objetivos.JSONObjetivos.VALOR_APORTE;

@Jornada(Jornadas.OBJETIVOS)
public class QA03127 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    DescobrindoPerfilFunc perfil = new DescobrindoPerfilFunc();
    ObjetivosFunc objetivosFunc = new ObjetivosFunc();
    RealizarAporteFunc realizarAporteFunc = new RealizarAporteFunc();
    SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    @Test(description = "REG.OBJ.09.02.03 - Validar aplicação com desenquadramento de perfil pelo APORTE - REFAZER PERFIL")
    @Description("Descrição (Objetivo): Aplicação do dia com desenquadramento de perfil\n" +
            "Pré-Requisitos:\n" +
            "\n" +
            "CPF e senha Válidos\n" +
            "Desenquadrado .")

    @Severity(SeverityLevel.NORMAL)
    public void QA03127() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        objetivosFunc.tocarBotaoAporteObjetivo();

        realizarAporteFunc.realizarAporte(recuperarMassa("valorAporte"));

        realizarAporteFunc.refazerPerfilViaAporte();

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

        realizarAporteFunc.continuarAplicacaoAportePerfilArrojado();

        realizarAporteFunc.validarComprovanteAplicacaoNoObjetivo();

        menu.selecionarSaldoExtrato();

        saldoExtratoFunc.validarTransacaoNaAbaTodas(recuperarMassa(TITULO_EXTRATO), recuperarMassa(VALOR_APORTE));

    }
}
