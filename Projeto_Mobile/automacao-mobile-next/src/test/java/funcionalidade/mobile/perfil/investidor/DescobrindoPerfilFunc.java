package funcionalidade.mobile.perfil.investidor;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.perfil.investidor.DescobrindoSeuPerfil;
import pagina.mobile.jornadas.perfil.investidor.DescobrindoSeuPerfilTela;
import pagina.mobile.jornadas.perfil.investidor.SelecionarPerfilTela;
import pagina.mobile.jornadas.perfil.investidor.SeuPerfilTela;

public class DescobrindoPerfilFunc extends FuncionalidadeBase {

    /**
     * Método para selecionar - descobrindo seu perfil
     * - FR
     *
     * @throws Exception
     */
    public void descobrindoSeuPerfilRefazerPerfil(DescobrindoSeuPerfil respostaUm,
                                                  DescobrindoSeuPerfil respostaDois,
                                                  DescobrindoSeuPerfil respostaTres,
                                                  DescobrindoSeuPerfil respostaQuatro,
                                                  DescobrindoSeuPerfil respostaCinco,
                                                  DescobrindoSeuPerfil respostaSeis,
                                                  DescobrindoSeuPerfil respostaSete,
                                                  DescobrindoSeuPerfil respostaOito,
                                                  DescobrindoSeuPerfil respostaNove) throws Exception {
        new SelecionarPerfilTela(getDriver())
                .tocarCheckDescobrirPerfil(respostaUm)
                .tocarCheckDescobrirPerfil(respostaDois)
                .tocarCheckDescobrirPerfil(respostaTres)
                .tocarCheckDescobrirPerfil(respostaQuatro)
                .tocarCheckDescobrirPerfil(respostaCinco)
                .tocarCheckDescobrirPerfil(respostaSeis)
                .tocarCheckDescobrirPerfil(respostaSete)
                .tocarCheckDescobrirPerfil(respostaOito)
                .tocarCheckDescobrirPerfil(respostaNove);
        new DescobrindoSeuPerfilTela(getDriver())
                .tocarBotaoVerMeuPerfil();
        new SeuPerfilTela(getDriver())
                .verificarTituloTela();
    }

    /**
     * Método para tocar em informações e tocar refazer seu perfil
     * - FR
     *
     * @throws Exception
     */
    public void resultadoSeuPerfil() throws Exception {
        new SeuPerfilTela(getDriver())
                .tocarBotaoInformacoes()
                .verificarTelaInformacoes();
        new DescobrindoSeuPerfilTela(getDriver())
                .tocarBotaoFechar();
        new SeuPerfilTela(getDriver())
                .tocarBotaoAdoreiMeuPerfil();
    }

    /**
     * Método que Reponde o questionário selecionando as primeiras respostas
     *
     * @throws Exception
     */
    public void responderQuestionarioPrimeirasOpcoes() throws Exception {

        new DescobrindoSeuPerfilTela(getDriver())
                .verificarTituloTela();
        new SelecionarPerfilTela(getDriver())
                .tocarCheckDescobrirPerfil(DescobrindoSeuPerfil.TENHO_FORMACAO_MAS_NAO_TENHO_EXPERIENCIA)
                .tocarCheckDescobrirPerfil(DescobrindoSeuPerfil.JA_FIZ_INVESTIMENTO_NOS_ULTIMOS_12_MESES)
                .tocarCheckDescobrirPerfil(DescobrindoSeuPerfil.MUITAS_VEZES_FIZ_UMAS_DOZE_APLICACOES)
                .tocarCheckDescobrirPerfil(DescobrindoSeuPerfil.QUERO_JUNTAR_DINHEIRO_PRA_MINHA_APOSENTADORIA)
                .tocarCheckDescobrirPerfil(DescobrindoSeuPerfil.MAIS_DE_QUARENTA_PORCENTO_DA_MINHA_RENDA)
                .tocarCheckDescobrirPerfil(DescobrindoSeuPerfil.MAIS_QUE_TRES_MM)
                .tocarCheckDescobrirPerfil(DescobrindoSeuPerfil.MAIS_DE_70_POR_CENTO_EM_PRODUTOS_FINANCEIROS)
                .tocarCheckDescobrirPerfil(DescobrindoSeuPerfil.NAO_PRECISO_DO_DINHEIRO_AGORA_E_NEM_INVESTIRIA_MAIS)
                .tocarCheckDescobrirPerfil(DescobrindoSeuPerfil.FARIA_E_ATE_PODERIA_CONTINUAR_INVESTINDO_MESMO_RISCO_PERDER_TUDO);
        new DescobrindoSeuPerfilTela(getDriver())
                .tocarBotaoVerMeuPerfil();
        new SeuPerfilTela(getDriver())
                .verificarTituloTela();
    }

    /**
     * tocar no Continuar Aplicação
     *
     * @throws Exception
     */
    public void continuarAplicacao() throws Exception {
        new SeuPerfilTela(getDriver())
                .tocarBotaoContinuarAplicacao();
    }
}
