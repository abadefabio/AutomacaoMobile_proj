package funcionalidade.web.fnext.n2;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.web.fnext.n2.ComboN2;
import pagina.web.fnext.comum.PesquisaGeralTela;
import pagina.web.fnext.n1.CardConclusaoAnaliseN1Tela;
import pagina.web.fnext.n1.CardInformacoesPropostaTela;
import pagina.web.fnext.n2.CardConclusaoAnaliseN2Tela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class ConclusaoAnaliseN2Func extends FuncionalidadeBase {

    /**
     * Método para selecionar combo Resultado da Etapa igual Retorno N1
     *
     * @param combo
     * @param comboMotivo
     * @throws Exception
     */
    public void selecionarResultadoEtapaRetornoN1(String combo, String comboMotivo) throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(combo)
                .selecionarComboMotivo(comboMotivo);
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para clicar em sub motivo para Recusa N2
     *
     * @throws Exception
     */
    public void clicarSubMotivo(String opcao) throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .clicarSubMotivo(opcao);
    }

    /**
     * Método para selecionar combo Resultado da Etapa igual Aprovado
     *
     * @param combo
     * @throws Exception
     */
    public void selecionarResultadoEtapaAprovado(String combo) throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(combo);
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para selecionar combo Resultado da Etapa igual Reprovado / Fraude Ideológica / CPF PERTENCE A OUTRA PESSOA
     *
     * @throws Exception
     */
    public void selecionarResultadoEtapaReprovadoN2FraudeIdeologicaCpfPertenceOutraPessoa() throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(ComboN2.REPROVADO)
                .selecionarComboMotivo(ComboN2.FRAUDE_IDEOLOGICA)
                .clicarSubMotivoCpfPertenceOutraPessoa();
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para selecionar combo Resultado da Etapa igual Reprovado / Dados Inconsistentes / Contaminação Por Fraude - Responsável
     *
     * @throws Exception
     */
    public void selecionarReprovadoDadosInconsistentesContaminacaoJoyII() throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(ComboN2.REPROVADO)
                .selecionarComboMotivo(ComboN2.DADOS_INCONSISTENTES)
                .clicarSubMotivoContiminacaoResponsavelJoyII();
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para selecionar combo Resultado da Etapa igual Reprovado / Auto Fraude
     *
     * @throws Exception
     */
    public void selecionarReprovadoAutoFraudeJoyII() throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(ComboN2.REPROVADO)
                .selecionarComboMotivo(ComboN2.AUTO_FRAUDE)
                .clicarSubMotivoAdulteracaoDeDadosDocumentoJoyII()
                .clicarSubMotivoSobreposicaoFotoDocumentoJoyII();
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para selecionar combo Resultado da Etapa igual Reprovado / Auto Fraude / Adulteração de Dados do Próprio Doc. de Identificação
     *
     * @param combo
     * @param motivo
     * @throws Exception
     */
    public void selecionarReprovadoAutoFraudeNext(String combo, String motivo) throws Exception {
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(combo)
                .selecionarComboMotivo(motivo)
                .clicarSubMotivoAdulteracaoDeDadosDocumentoNext();
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para selecionar combo Resultado da Etapa igual Aprovado e Preencher o campo Descrição da Análise N2
     *
     * @param combo
     * @param descricaoAnaliseN2
     * @throws Exception
     */
    public void selecionarResultadoEtapaAprovadoEDescricaoDaAnaliseN2(String combo, String descricaoAnaliseN2) throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(combo)
                .digitarCampoDescricaoAnaliseN2(descricaoAnaliseN2);
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para selecionar combo Resultado da Etapa igual Retorno N1 e o Motivo igual a "Erro Operacional" Preencher os campos "Descrição da Análise N2" e
     * "Observações N2"
     *
     * @param descricao
     * @param combo
     * @param comboMotivo
     * @throws Exception
     */
    public void selecionarResultadoEtapaRetornoN1deN2(String combo, String comboMotivo, String descricao) throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(combo)
                .selecionarComboMotivo(comboMotivo)
                .digitarCampoDescricaoAnaliseN2ValidarLimiteCaracteres(descricao)
                .digitarCampoObservacoesdeN2ValidarLimiteCaracteres(descricao);
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para selecionar combo Resultado da Etapa igual Aprovado e Preencher os campos "Descrição da Análise N2" e
     * "Observações N2
     *
     * @param descricao
     * @param combo
     * @throws Exception
     */
    public void selecionarResultadoEtapaAprovadoEDescricaoDaAnaliseN2EObservacaoN2(String combo, String descricao) throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(combo)
                .digitarCampoDescricaoAnaliseN2ValidarLimiteCaracteres(descricao)
                .digitarCampoObservacoesdeN2ValidarLimiteCaracteres(descricao);
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para selecionar combo Resultado da Etapa igual Reprovado Joy Multibanco
     *
     * @param descricao
     * @param comboMotivo
     * @param combo
     * @throws Exception
     */
    public void selecionarResultadoEtapaReprovadoJoyMultibanco(String combo, String comboMotivo, String descricao) throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .selecionarComboResultadoEtapa(combo)
                .selecionarComboMotivo(comboMotivo)
                .clicarSubMotivoResposavelSemDocGccnEContextoRisco()
                .digitarCampoDescricaoAnaliseN2ValidarLimiteCaracteres(descricao)
                .digitarCampoObservacoesdeN2ValidarLimiteCaracteres(descricao);
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar();
    }

    /**
     * Método para clicar no botão Voltar
     *
     * @throws Exception
     */
    public void clicarBotaoVoltar() throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .clicarBotaoVoltar();
    }

    /**
     * Verificar campo Liveness quando Positivo na tela de Consulta da Proposta N2
     *
     * @throws Exception
     */
    public void verificarCampoLivenessPositivoTelaConsultaN2() throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .validarCampoLivenessPositivoTelaConsultaN2();
    }

    /**
     * Verificar campo Bureau de Face quando Positivo na tela de Consulta da Proposta N2
     *
     * @throws Exception
     */
    public void verificarCampoBureauDeFacePositivoTelaConsultaN2() throws Exception{
        new CardConclusaoAnaliseN2Tela(getWebDriver())
                .validarCampoBureauDeFacePositivoTelaConsultaN2();
    }
}
