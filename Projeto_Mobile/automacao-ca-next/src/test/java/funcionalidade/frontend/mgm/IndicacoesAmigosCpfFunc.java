package funcionalidade.frontend.mgm;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.frontend.frames.componentes.MgmFrame;
import pagina.web.frontend.mgm.IndicacoesAmigosCpfTela;
import tools.ContensorTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class IndicacoesAmigosCpfFunc extends FuncionalidadeBase {

    /**
     * Inserir o CPF Indicador para buscar Convidados
     *
     * @param cpfIndicador
     * @throws Exception
     */
    public void inserirCPFIndicadorBuscarConvidados(String cpfIndicador) throws Exception {
        new ContensorTela(getWebDriver(), MgmFrame.class)
                .executar(new IndicacoesAmigosCpfTela(getWebDriver())
                        .informarCpfIndicador(cpfIndicador)
                        .clicarBotaoBuscar())
                .desfazer();
    }

    /**
     * Inserir o CPF Convidado para buscar Indicadores
     *
     * @param cpfConvidado
     * @throws Exception
     */
    public void inserirCPFConvidadoBuscarIndicadores(String cpfConvidado) throws Exception {
        new ContensorTela(getWebDriver(), MgmFrame.class)
                .executar(new IndicacoesAmigosCpfTela(getWebDriver())
                        .informarCpfConvidado(cpfConvidado)
                        .clicarBotaoBuscar())
                .desfazer();
    }

    /**
     * Limpar Campos
     *
     * @throws Exception
     */
    public void limparCampos() throws Exception {
        new ContensorTela(getWebDriver(), MgmFrame.class)
                .executar(new IndicacoesAmigosCpfTela(getWebDriver())
                        .clicarBotaoLimpar())
                .desfazer();
    }
}
