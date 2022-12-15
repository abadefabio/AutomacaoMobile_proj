package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.MensagensObjetivos;
import constantes.objetivos.TipoObjetivo;
import constantes.perfil.investidor.DescobrindoSeuPerfil;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.objetivos.NovoObjetivoFunc;
import funcionalidade.mobile.perfil.investidor.DescobrindoPerfilFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;
import static constantes.objetivos.TipoObjetivo.TIPO_OBJETIVO_CELULAR;

@Jornada(Jornadas.OBJETIVOS)
public class QA03114 extends TesteBase {

    LoginFunc login = new LoginFunc();
    ComprovantesFunc comprovante = new ComprovantesFunc();
    DescobrindoPerfilFunc perfil = new DescobrindoPerfilFunc();
    NovoObjetivoFunc novoObjetivo = new NovoObjetivoFunc();

    @Test(description = "REG.OBJ.09.01.02 - Validar primeira criação de objetivo pelo menu de COMPROVANTES validando o botão SAIBA MAIS do next Simples")
    @Description("Descrição (Objetivo): Descobrindo seu Perfil - Arrojado - Refazer PerfilPré-Requisitos:\n" +
            "\n" +
            "CPF e senha Válidos\n" +
            "Não possuir perfil de investidor")

    @Severity(SeverityLevel.NORMAL)
    public void QA03114() throws Exception {

        login.efetuarLoginUsuarioPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        comprovante.acessarObjetivosViaComprovantes();

        novoObjetivo.selecionarDescobrirPerfil();

        perfil.descobrindoSeuPerfilRefazerPerfil(
                DescobrindoSeuPerfil.TENHO_FORMACAO_MAS_NAO_TENHO_EXPERIENCIA,
                DescobrindoSeuPerfil.JA_INVESTI_EM_TODAS_OPCOES_ANTERIORES_E_DERIVATIVOS,
                DescobrindoSeuPerfil.MUITAS_VEZES_FIZ_UMAS_DOZE_APLICACOES,
                DescobrindoSeuPerfil.QUERO_JUNTAR_DINHEIRO_PRA_MINHA_APOSENTADORIA,
                DescobrindoSeuPerfil.MAIS_DE_QUARENTA_PORCENTO_DA_MINHA_RENDA,
                DescobrindoSeuPerfil.MAIS_QUE_TRES_MM,
                DescobrindoSeuPerfil.ENTRE_TRINTA_E_SETENTA_PORCENTO_EM_PRODUTOS_FINANCEIROS,
                DescobrindoSeuPerfil.NAO_PRECISO_AGORA_E_CONTINUARIA_INVESTINDO,
                DescobrindoSeuPerfil.FARIA_E_ATE_PODERIA_CONTINUAR_INVESTINDO_MESMO_RISCO_PERDER_TUDO);

        perfil.resultadoSeuPerfil();

        perfil.descobrindoSeuPerfilRefazerPerfil(
                DescobrindoSeuPerfil.NAO_TENHO_FORMACAO_MAS_TENHO_EXPERIENCIA,
                DescobrindoSeuPerfil.NUNCA_INVESTI_MAS_SEI_POUCO_SOBRE_TIPOS_DE_INVESTIMENTOS,
                DescobrindoSeuPerfil.QUASE_NAO_FIZ_FORAM_NO_MAXIMO_DUAS_APLICACOES,
                DescobrindoSeuPerfil.QUERO_APLICAR_PRA_TER_UMA_RESERVA_DEVO_DEIXAR_INVESTIDO_POR_ATE_UM_ANO,
                DescobrindoSeuPerfil.ATE_DEZ_PORCENTO_DA_MINHA_RENDA,
                DescobrindoSeuPerfil.ENTRE_QUINHENTOSMIL_E_UMQUINHENTOS_MM,
                DescobrindoSeuPerfil.ATE_QUINZE_PORCENTO_EM_PRODUTOS_FINANCEIROS,
                DescobrindoSeuPerfil.TALVEZ_USARIA_UMA_PARTE_PARA_PAGAR_ALGUMAS_DESPESAS,
                DescobrindoSeuPerfil.INVESTIRIA_POUCO_PORQUE_NAO_SINTO_CONFORTAVEL_COM_O_RISCO_DE_PERDER);

        novoObjetivo.selecionarTipoObjetivo(TIPO_OBJETIVO_CELULAR);

        String valor = String.valueOf(numeroAleatorio(10000,50000));
        novoObjetivo.criarObjetivoSimples(recuperarMassa("nomeObjetivo"), MensagensObjetivos.MENSAGEM_QUANTO_PRECISA,valor, TipoObjetivo.TIPO_OBJETIVO_CELULAR.toString());

    }
}
