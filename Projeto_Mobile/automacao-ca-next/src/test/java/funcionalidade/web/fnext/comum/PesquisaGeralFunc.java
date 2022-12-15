package funcionalidade.web.fnext.comum;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.drivers.OperadorDriver;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.web.fnext.TitulosTela;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pagina.web.fnext.comum.EtapasDaPropostaTela;
import pagina.web.fnext.comum.PesquisaGeralTela;
import pagina.web.fnext.comum.PropostasTela;
import tools.Tempo;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class PesquisaGeralFunc extends FuncionalidadeBase {

    /**
     * Realiza pesquisa por uma proposta no FNEXT com CPF
     *
     * @param cpf
     * @throws Exception
     */
    public void pesquisarPorCpf(String cpf) throws Exception {
        new PesquisaGeralTela(getWebDriver())
                .validarTituloPesquisaGeral(TitulosTela.TITULO_PESQ_GERAL)
                .preencherCpf(cpf)
                .clicarBotaoPesquisar();
    }

    /**
     * Realiza logout do FNext
     *
     * @throws Exception
     */
    public void clicarLogout() throws Exception {
        new PesquisaGeralTela(getWebDriver())
                .clicarLogout();
    }

    /**
     * Realiza logout do FNext
     *
     * @throws Exception
     */
    public void garantirLogout() throws Exception {
        Actions actions = new Actions(OperadorDriver.getWebDriver());
        actions.sendKeys(Keys.ESCAPE).perform();
        new PesquisaGeralTela(getWebDriver())
                .garantirLogoutAfterMethod();
    }

    /**
     * Finaliza an�lise
     *
     * @throws Exception
     */
    public void clicarFinalizar() throws Exception {
        new PesquisaGeralTela(getWebDriver())
                .clicarFinalizar()
                .validarTituloPesquisaGeral(TitulosTela.TITULO_PESQ_GERAL);
    }

    /**
     * Realiza a pesquisa por uma proposta, seleciona e clica no bot�o Editar
     *
     * @param cpf
     * @throws Exception
     */
    public void pesquisaSelecionaEditaProposta(String cpf) throws Exception {
        new PesquisaGeralTela((getWebDriver()))
                .validarTituloPesquisaGeral(TitulosTela.TITULO_PESQ_GERAL)
                .preencherCpf(cpf)
                .clicarBotaoPesquisar();
        new PropostasTela(getWebDriver())
                .validarResultadoPesquisaCpf(cpf)
                .clicarCpfPesquisado();
        new EtapasDaPropostaTela(getWebDriver())
                .validarTituloEtapasDaProposta()
                .clicarBotaoEditar();
    }

    /**
     * Realiza pesquisa e verifica presen�a do bot�o editar
     *
     * @throws Exception
     */
    public void verificarPresencaBotaoEditar() throws Exception {
        int cont = 0;

        PesquisaGeralTela pesquisaGeralTela = new PesquisaGeralTela(getWebDriver());
        PropostasTela propostasTela = new PropostasTela(getWebDriver());
        EtapasDaPropostaTela etapasDaPropostaTela = new EtapasDaPropostaTela(getWebDriver());

        Tempo tempo = new Tempo(90*1000);
        while (!etapasDaPropostaTela.verificarCarregamentoBotaoEditar() && tempo.resta()) {
            OperadorEvidencia.logarPasso("Verificando presen�a do bot�o Editar");
            cont++;
            pesquisaGeralTela.clicarBotaoPesquisar();
            propostasTela.clicarCpfPesquisado();
            tempo.dormir(5000);
        }
        etapasDaPropostaTela.clicarBotaoEditar();
    }

    /**
     * Realiza pesquisa e verifica presen�a do bot�o Consultar N1
     *
     * @throws Exception
     */
    public void verificarPresencaBotaoConsultarN1() throws Exception {
        int cont = 0;

        PesquisaGeralTela pesquisaGeralTela = new PesquisaGeralTela(getWebDriver());
        PropostasTela propostasTela = new PropostasTela(getWebDriver());
        EtapasDaPropostaTela etapasDaPropostaTela = new EtapasDaPropostaTela(getWebDriver());

        while (!etapasDaPropostaTela.verificarCarregamentoBotaoConsultarN1()) {
            OperadorEvidencia.logarPasso("Verificando presen�a do bot�o ConsultarN1");
            cont++;
            pesquisaGeralTela.clicarBotaoPesquisar();
            propostasTela.clicarCpfPesquisado();
            if (cont > 7) break;
        }
        etapasDaPropostaTela.clicarBotaoConsultarN1();
    }

    /**
     * Realiza pesquisa e verifica presen�a do bot�o Consultar N2
     *
     * @throws Exception
     */
    public void verificarPresencaBotaoConsultarN2() throws Exception {
        int cont = 0;

        PesquisaGeralTela pesquisaGeralTela = new PesquisaGeralTela(getWebDriver());
        PropostasTela propostasTela = new PropostasTela(getWebDriver());
        EtapasDaPropostaTela etapasDaPropostaTela = new EtapasDaPropostaTela(getWebDriver());

        while (!etapasDaPropostaTela.verificarCarregamentoBotaoConsultarN2()) {
            OperadorEvidencia.logarPasso("Verificando presen�a do bot�o ConsultarN2");
            cont++;
            pesquisaGeralTela.clicarBotaoPesquisar();
            propostasTela.clicarCpfPesquisado();
            if (cont > 7) break;
        }
        etapasDaPropostaTela.clicarBotaoConsultarN2();
    }


    /**
     * Realiza pesquisa e verifica se a proposta foi finalizada
     *
     * @throws Exception
     */
    public void verificarSePropostaFinalizou() throws Exception {
        int cont = 0;

        PesquisaGeralTela pesquisaGeralTela = new PesquisaGeralTela(getWebDriver());
        PropostasTela propostasTela = new PropostasTela(getWebDriver());
        EtapasDaPropostaTela etapasDaPropostaTela = new EtapasDaPropostaTela(getWebDriver());

        while (!etapasDaPropostaTela.verificarStatusFinalizado()) {
            OperadorEvidencia.logarPasso("Verificando se a proposta foi finalizada");
            cont++;
            pesquisaGeralTela.clicarBotaoPesquisar();
            propostasTela.clicarCpfPesquisado();
            if (cont > 7) break;
        }
    }

    /**
     * Realiza pesquisa e verifica se a etapa da proposta est� em Tela de Neg�cio
     *
     * @throws Exception
     */
    public void verificarEtapaTelaNegocio() throws Exception {
        int cont = 0;

        PesquisaGeralTela pesquisaGeralTela = new PesquisaGeralTela(getWebDriver());
        PropostasTela propostasTela = new PropostasTela(getWebDriver());
        EtapasDaPropostaTela etapasDaPropostaTela = new EtapasDaPropostaTela(getWebDriver());

        while (!etapasDaPropostaTela.verificarEtapaTelaNegocio()) {
            OperadorEvidencia.logarPasso("Verificando se a etapa da proposta est� em Etapa Gerente - Tela de Neg�cio");
            cont++;
            pesquisaGeralTela.clicarBotaoPesquisar();
            propostasTela.clicarCpfPesquisado();
            if (cont > 7) break;
        }
    }

    /**
     * Realiza pesquisa e verifica se a etapa da proposta est� em Gerente - An�lise de Conta Autom�tica como Finalizado
     *
     * @throws Exception
     */
    public void verificarEtapaGerenteAnaliseContaAutomaticaFinalizado() throws Exception {
        int cont = 0;

        PesquisaGeralTela pesquisaGeralTela = new PesquisaGeralTela(getWebDriver());
        PropostasTela propostasTela = new PropostasTela(getWebDriver());
        EtapasDaPropostaTela etapasDaPropostaTela = new EtapasDaPropostaTela(getWebDriver());

        while (!etapasDaPropostaTela.verificarAnaliseContaAutomaticaFinalizada()) {
            OperadorEvidencia.logarPasso("Verificando se a etapa da proposta est� em Gerente - An�lise de Conta Autom�tica como Finalizado");
            cont++;
            pesquisaGeralTela.clicarBotaoPesquisar();
            propostasTela.clicarCpfPesquisado();
            if (cont > 7) break;
        }
    }

    /**
     * Verificar Resultado da Etapa Gerente - An�lise de Conta Autom�tica como Derivado Manual
     *
     * @throws Exception
     */
    public void verificarGerenteAnaliseContaAutomaticaDerivadoManual() throws Exception {
        new EtapasDaPropostaTela(getWebDriver())
                .validarAnaliseContaAutomaticaComoDerivaManual();
    }

    /**
     * Verificar Resultado da Etapa Gerente - An�lise de Conta Autom�tica como ABERTURA DE CONTA N�O
     *
     * @throws Exception
     */
    public void verificarGerenteAnaliseContaAutomaticaAberturaContaNao() throws Exception {
        new EtapasDaPropostaTela(getWebDriver())
                .validarAnaliseContaAutomaticaComoAberturaContaNao();
    }

    /**
     * Verificar Campo A conta foi aberta igual N�o
     *
     * @throws Exception
     */
    public void verificarCampoAContaFoiAbertaNao(String cpf) throws Exception {
        new PesquisaGeralTela(getWebDriver())
                .preencherCpf(cpf)
                .clicarBotaoPesquisar()
                .validarNaoCampoAContaFoiAberta();
    }

    /**
     * Verificar Resultado da Etapa igual a APROVADO MOTOR
     *
     * @throws Exception
     */
    public void verificarResultadoDaEtapaAprovadoMotor() throws Exception {
        new PesquisaGeralTela(getWebDriver())
                .resultadoDaEtapaAprovadoMotor();
    }

    /**
     * Verificar Resultado da Etapa igual a REPROVADO MOTOR
     *
     * @throws Exception
     */
    public void verificarResultadoDaEtapaReprovadoMotor() throws Exception {
        new PesquisaGeralTela(getWebDriver())
                .validarResultadoReprovadoMotor();
    }

    /**
     * Verificar Etapa igual a Atualiza��o Motor de Seguran�a como Conclu�do
     *
     * @throws Exception
     */
    public void verificarEtapaAtualizacaoMotorDeSegurancaConcluido() throws Exception {
        new EtapasDaPropostaTela(getWebDriver())
                .validarAtualizacaoMotorDeSegurancaConcluido();
    }

    /**
     * Verificar Resultado da Etapa Gerente - An�lise de Conta Autom�tica como ABERTURA DE CONTA SIM
     *
     * @throws Exception
     */
    public void verificarEtapaGerenteComoAberturaContaSim() throws Exception {
        new EtapasDaPropostaTela(getWebDriver())
                .validarEtapaGerenteComoAberturaContaSim();
    }

    /**
     * Verificar Resultado da Etapa igual a ADES�O N�O REALIZADA
     *
     * @throws Exception
     */
    public void verificarResultadoDaEtapaAdesaoNaoRealizada() throws Exception {
        new EtapasDaPropostaTela(getWebDriver())
                .validarResultadoDaEtapaAdesaoNaoRealizada();
    }

}
