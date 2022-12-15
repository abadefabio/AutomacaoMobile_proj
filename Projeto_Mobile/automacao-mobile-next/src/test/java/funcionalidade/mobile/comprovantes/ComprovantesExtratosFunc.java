package funcionalidade.mobile.comprovantes;

import pagina.mobile.jornadas.comprovantes.ComprovantesExtratoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ComprovantesExtratosFunc {
    /**
     * Acessar menu Comprovantes
     *
     * @throws Exception
     */
    public void menuComprovantes() throws Exception {
        new ComprovantesExtratoTela(getDriver())
                .tocarBotaoComprovantes();
    }

    /**
     * Acessar menu Extratos
     *
     * @throws Exception
     */
    public void menuExtratos() throws Exception {
        new ComprovantesExtratoTela(getDriver())
                .tocarBotaoExtratos();
    }

    /**
     * Acessar menu Informe de Rendimentos
     *
     * @throws Exception
     */
    public void menuInformeRendimentos() throws Exception {
        new ComprovantesExtratoTela(getDriver())
                .tocarBotaoInformeRendimentos();
    }

    /**
     * Acessar menu Objetivos
     *
     * @throws Exception
     */
    public void menuObjetivos() throws Exception {
        new ComprovantesExtratoTela(getDriver())
                .tocarBotaoObjetivos();
    }

    /**
     * Acessar menu Investimentos
     *
     * @throws Exception
     */
    public void menuInvestimentos() throws Exception {
        new ComprovantesExtratoTela(getDriver())
                .tocarBotaoInvestimentos();
    }

    /**
     * Acessar menu Pix
     *
     * @throws Exception
     */
    public void menuPix() throws Exception {
        new ComprovantesExtratoTela(getDriver())
                .tocarBotaoPix();
    }
}
