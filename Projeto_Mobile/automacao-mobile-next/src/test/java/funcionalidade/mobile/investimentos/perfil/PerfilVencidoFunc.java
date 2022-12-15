package funcionalidade.mobile.investimentos.perfil;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import pagina.mobile.jornadas.investimentos.perfil.PerfilVencidoTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class PerfilVencidoFunc  extends FuncionalidadeBase {

    /**
     * validar apresentação da tela 'Perfil Vencido' e 'Refazer perfil'
     * @throws NextException
     */
    public void refazerPerfilInvestidor() throws NextException {
        new PerfilVencidoTela(getDriver())
                .validarExibicaoTelaPerfilVencido()
                .tocarBotaoRefazerPerfil();
    }
}
