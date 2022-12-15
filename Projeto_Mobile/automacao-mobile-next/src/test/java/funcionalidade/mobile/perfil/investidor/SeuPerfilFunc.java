package funcionalidade.mobile.perfil.investidor;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.investimentos.Perfil;
import constantes.perfil.investidor.SeuPerfil;
import pagina.mobile.jornadas.investimentos.home.HomeInvestimentosTela;
import pagina.mobile.jornadas.perfil.investidor.SeuPerfilTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SeuPerfilFunc extends FuncionalidadeBase {

    /**
     * Validar tipo de perfil apos responder o questionario
     * @throws Exception
     */
    public void validarTipoPerfilAposResponderQuestionario(SeuPerfil tipoPerfil) throws Exception {

        switch (tipoPerfil) {
            case PERFIL_ARROJADO:
                new SeuPerfilTela(getDriver())
                        .verificarPresencaTituloPerfilArrojado()
                        .tocarBotaoContinuarAplicacao();
                break;
            case PERFIL_ULTRACONSERVADOR:
                new SeuPerfilTela(getDriver())
                        .verificarPresencaTituloPerfilUltraconservador()
                        .tocarBotaoInformacoes()
                        .verificarTelaInformacoes()
                        .tocarBotaoFechar()
                        .tocarBotaoAdoreiMeuPerfil();
                new HomeInvestimentosTela(getDriver())
                        .validarTextoPerfilDeInvestidor(Perfil.PERFIL_ULTRACONSERVADOR.toString());
                break;
        }
    }
}
