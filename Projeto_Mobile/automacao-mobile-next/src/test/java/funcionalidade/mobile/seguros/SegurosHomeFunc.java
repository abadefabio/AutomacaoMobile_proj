package funcionalidade.mobile.seguros;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSeguro;
import pagina.mobile.jornadas.seguros.SegurosHomeTela;
import pagina.mobile.jornadas.seguros.dental.adesao.ProdutoDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.TelefonesUteisDentalTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SegurosHomeFunc extends FuncionalidadeBase {

    /**
     * Método que faz a ação de simular um seguro
     *
     * @throws Exception
     */
    public void simularSeguro(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        new SegurosHomeTela(getDriver())
                .tocarBotaoSimular(tipoSeguro, tipoProtecao);
    }
    /**
     * Método que faz a ação de simular um seguro
     *
     * @throws Exception
     */
    public void simularSeguroComDeslizeDeTela(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        new SegurosHomeTela(getDriver())
                .tocarBotaoSimularComDeslizeDeTela(tipoSeguro, tipoProtecao);
    }

    /**
     * Método que faz a ação de cancelar um seguro
     *
     * @param meusSeguros
     * @throws Exception
     */
    public void cancelamentoSeguro(String meusSeguros) throws Exception {
        new SegurosHomeTela(getDriver())
                .tocarAbaMeusSeguros()
                .tocarBotaoSeguroContratado(meusSeguros)
                .tocarBotaoCancelamento();
    }

    /**
     * Método que retorna true ou false ao procurar o card de um seguro
     * @param tipoSeguro
     * @param tipoProtecao
     * @return SegurosHomeTela
     * @throws Exception
     */
    public void procurarCard(TipoSeguro tipoSeguro, TipoProtecao tipoProtecao) throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .validarNaoExistenciaDoCard(tipoSeguro,tipoProtecao);
    }

    /**
     * Método para validar Telefones Uteis Dental
     * @throws Exception
     */
    public void validarTelefonesUteisDental() throws Exception {
        new SegurosHomeTela(getDriver())
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlano();
        new ProdutoDentalTela(getDriver())
                .validaTelaProdutoDental()
                .tocarBotaoTelefonesUteisDental();
        new TelefonesUteisDentalTela(getDriver())
                .validaTelaTelefonesUteisDental()
                .tocarBotaoVoltar();
        new ProdutoDentalTela(getDriver())
                .validaTelaProdutoDental();
    }
}
