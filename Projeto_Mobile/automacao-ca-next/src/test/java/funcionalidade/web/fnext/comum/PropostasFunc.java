package funcionalidade.web.fnext.comum;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.comum.EtapasDaPropostaTela;
import pagina.web.fnext.comum.PropostasTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class PropostasFunc extends FuncionalidadeBase {

    /**
     * Seleciona uma proposta no FNEXT
     *
     * @param cpf
     * @throws Exception
     */
    public void selecionarProposta(String cpf) throws Exception {
        new PropostasTela(getWebDriver())
                .validarResultadoPesquisaCpf(cpf)
                .clicarCpfPesquisado();
    }

    /**
     * Clica no bot�o editar
     *
     * @throws Exception
     */
    public void clicarEmEditar() throws Exception {
        new EtapasDaPropostaTela(getWebDriver())
                .validarTituloEtapasDaProposta()
                .clicarBotaoEditar();
    }

    /**
     * Clica no bot�o Reverter Status
     *
     * @throws Exception
     */
    public void clicarEmReverterStatus() throws Exception {
        new EtapasDaPropostaTela(getWebDriver())
                .validarTituloEtapasDaProposta()
                .clicarBotaoReverterStatus()
                .digitarCampoJustificativa()
                .clicarBotaoReverter()
                .validarTituloEtapasDaProposta();

    }

    /**
     * Valida que a proposta est� em An�lise N1
     *
     * @throws Exception
     */
    public void validaPropostaEmAnaliseN1() throws Exception{
        new EtapasDaPropostaTela(getWebDriver())
                .verificarAnaliseN1EmAndamento();
    }

    /**
     * Validar informa��o das colunas Data da Atualiza��o e Fila de Atendimento e o fluxo das Etapas do Card Etapas da Proposta
     *
     * @throws Exception
     */
    public void validarInformacaoFluxoPropostaAnaliseN1() throws Exception {
        new PropostasTela(getWebDriver())
                .validarDataAtualizacaoProposta()
                .validarFilaAtendimentoProposta();
        new EtapasDaPropostaTela(getWebDriver())
                .validarFluxoEtapasPropostaAnaliseN1();
    }
}
