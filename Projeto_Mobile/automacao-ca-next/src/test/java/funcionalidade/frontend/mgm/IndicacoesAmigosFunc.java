package funcionalidade.frontend.mgm;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.frontend.frames.componentes.MgmFrame;
import pagina.web.frontend.mgm.IndicacoesAmigosTela;
import tools.ContensorTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class IndicacoesAmigosFunc extends FuncionalidadeBase {

    /**
     * Validar Convidado na tabela Indique Amigos filtrado por todos os campos
     *
     * @param nomeConvidado
     * @param cpfConvidado
     * @param dataAceite
     * @param statusConta
     * @param dataAbertura
     * @param previsaoBonus
     *
     * @throws Exception
     */
    public void validarConvidadoFiltradoTodosCampos(
            String nomeConvidado, String cpfConvidado, String dataAceite, String statusConta, String dataAbertura, String previsaoBonus) throws Exception {
        new ContensorTela(getWebDriver(), MgmFrame.class)
                .executar(new IndicacoesAmigosTela(getWebDriver())
                        .validarTextoColunaConvidado(nomeConvidado)
                        .validarTextoColunaCpfConvidado(cpfConvidado)
                        .validarTextoColunaDataAceite(dataAceite)
                        .validarTextoColunaStatusConta(statusConta)
                        .validarTextoColunaDataAbertura(dataAbertura)
                        .validarTextoColunaPrevisaoBonus(previsaoBonus))
                .desfazer();
    }
}
