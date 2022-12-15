package funcionalidade.mobile.perfil.investidor;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import pagina.mobile.jornadas.perfil.investidor.SeuPerfilDeInvestidorTela;
import pagina.mobile.jornadas.perfil.investidor.SeuPerfilTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SeuPerfilDeInvestidorFunc extends FuncionalidadeBase {

    /**
     * Acessar o perfil de investidor
     * @throws NextException
     */
    public void acessarPerfilInvestidorResponderQuestionario() throws NextException {
        new SeuPerfilDeInvestidorTela(getDriver())
                .tocarBotaoResponder();
    }

    /**
     * Método Criar Objetivo APOS REFAZER SEU PERFIL
     * fr
     * @throws Exception
     */
    public void criarObjetivoAposRefazerPerfil() throws Exception {
        new SeuPerfilTela(getDriver())
                .tocarBotaoCriarObjetivo();
    }

}
