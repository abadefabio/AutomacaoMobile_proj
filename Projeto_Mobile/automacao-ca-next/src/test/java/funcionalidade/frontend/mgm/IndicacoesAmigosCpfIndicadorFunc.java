package funcionalidade.frontend.mgm;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.frontend.frames.componentes.MgmFrame;
import pagina.web.frontend.mgm.IndicacoesAmigosCpfIndicadorTela;
import tools.ContensorTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class IndicacoesAmigosCpfIndicadorFunc extends FuncionalidadeBase {

    /**
     * Filtrar Convidado por todos os campos
     *
     * @param nomeConvidado
     * @param statusConta
     * @param cpfConvidado
     * @param dataInicio
     * @param dataFim
     *
     * @throws Exception
     */
    public void filtrarConvidadoTodosCampos(String nomeConvidado, String statusConta, String cpfConvidado, String dataInicio, String dataFim) throws Exception {
        new ContensorTela(getWebDriver(), MgmFrame.class)
                .executar(new IndicacoesAmigosCpfIndicadorTela(getWebDriver())
                        .informarNomeConvidado(nomeConvidado)
                        .selecionarOpcaoStatusConta(statusConta)
                        .informarCpfConvidado(cpfConvidado)
                        .informarDataInicio(dataInicio)
                        .informarDataFim(dataFim)
                        .clicarBotaoBuscar()
                ).desfazer();
    }

    /**
     * Limpar Campos
     *
     * @throws Exception
     */
    public void limparCampos() throws Exception {
        new ContensorTela(getWebDriver(), MgmFrame.class)
                .executar(new IndicacoesAmigosCpfIndicadorTela(getWebDriver())
                        .clicarBotaoLimpar())
                .desfazer();
    }
}
