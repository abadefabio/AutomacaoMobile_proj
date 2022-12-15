package funcionalidade.mobile.pix;

import constantes.pix.TipoConta;
import constantes.pix.TipoLimite;
import constantes.pix.ValorPix;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.mais.opcoes.InformacoesTela;
import pagina.mobile.jornadas.pix.mais.opcoes.MaisOpcoesTela;
import pagina.mobile.jornadas.pix.mais.opcoes.MeusLimitesPixTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static constantes.pix.TipoConta.CONTA_POUPANCA;

public class MeusLimitesPixFunc {

    /**
     * Validar Aumento de limite maior na poupança
     *
     * @param valorLimite
     * @throws Exception
     */
    public void validarEdicaoLapisLimiteMaiorMinhasContasContatosPixContaCorrente(ValorPix valorLimite) throws Exception {

        new PixTela(getDriver())
                .tocarBotaoMaisOpcoes();
        new MaisOpcoesTela(getDriver())
                .tocarBotaoMeusLimitesPix();
        new MeusLimitesPixTela(getDriver())
                .tocarBotaoLimiteMaior()
                .tocarBotaoAlterarLimite()
                .tocarIconeLapis(TipoLimite.DIARIO.toString())
                .preencherValorLimite(TipoLimite.DIARIO.toString(), valorLimite.getValue());

        new MeusLimitesPixTela(getDriver())
                .tocarBotaoAlterarLimite()
                .tocarBotaoVoltarMeusLimites()
                .tocarBotaoI();

        new InformacoesTela(getDriver())
                .tocarBotaoMinhasContasContatosPixComLimiteMaior()
                .validarLimite(valorLimite.getValue())
                .tocarBotaoVoltar();
        new MeusLimitesPixTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Validar Aumento de limite maior na poupança
     *
     * @param valorLimite
     * @throws Exception
     */
    public void validarEdicaoLapisLimiteMaiorMinhasContasContatosPixPoupanca(ValorPix valorLimite) throws Exception {

        new PixTela(getDriver())
                .tocarBotaoMaisOpcoes();
        new MaisOpcoesTela(getDriver())
                .tocarBotaoMeusLimitesPix();
        new MeusLimitesPixTela(getDriver())
                .tocarBotaoContaPoupanca()
                .tocarBotaoLimiteMaior()
                .tocarBotaoAlterarLimite()
                .tocarIconeLapis(TipoLimite.DIARIO.toString())
                .preencherValorLimite(TipoLimite.DIARIO.toString(), valorLimite.getValue());

        new MeusLimitesPixTela(getDriver())
                .tocarBotaoAlterarLimite()
                .tocarBotaoVoltarMeusLimites()
                .tocarBotaoI();

        new InformacoesTela(getDriver())
                .tocarBotaoMinhasContasContatosPixComLimiteMaior()
                .validarLimite(valorLimite.getValue())
                .tocarBotaoVoltar();
        new MeusLimitesPixTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Validar Aumento de limite maior na poupança
     *
     * @param Coordenada
     * @throws Exception
     */
    public void validarEdicaoSliderLimiteMaiorMinhasContasContatosPixPoupanca(int Coordenada) throws Exception {

        new PixTela(getDriver())
                .tocarBotaoMaisOpcoes();
        new MaisOpcoesTela(getDriver())
                .tocarBotaoMeusLimitesPix();
        new MeusLimitesPixTela(getDriver())
                .tocarBotaoContaPoupanca()
                .tocarBotaoLimiteMaior()
                .tocarBotaoAlterarLimite()
                .tocarIconeLapis(TipoLimite.DIARIO.toString())
                .tocarBarraDeLimite(Coordenada);

        //TODO Descomentar quando o problema de mapeamento do campo texto for resolvido
        /*String valorValidar = new MeusLimitesPixTela(getDriver())
                .recuperarValorDoLimite(TipoLimite.DIARIO.toString());*/

        new MeusLimitesPixTela(getDriver())
                .tocarBotaoAlterarLimite()
                .tocarBotaoVoltarMeusLimites();

        //TODO Remover quando o problema de mapeamento do campo texto for resolvido
        new MeusLimitesPixTela(getDriver())
                .tocarBotaoContaPoupanca()
                .tocarBotaoLimiteMaior();

        //TODO Remover quando o problema de mapeamento do campo texto for resolvido
        String valorValidar = new MeusLimitesPixTela(getDriver()).recuperarValorDoLimiteAtual();

        new MeusLimitesPixTela(getDriver())
                .tocarBotaoI();

        new InformacoesTela(getDriver())
                .tocarBotaoMinhasContasContatosPixComLimiteMaior()
                .validarLimite(valorValidar)
                .tocarBotaoVoltar();
        new MeusLimitesPixTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Validar valor mínimo do limite de Pix Saque e Pix Troco
     *
     * @throws Exception
     */
    public void validarLimiteMenorPermitidoPixSaquePixTrocoDiurno(TipoConta tipoConta, String valorLimite) throws Exception {

        new PixTela(getDriver())
                .tocarBotaoMaisOpcoes();
        new MaisOpcoesTela(getDriver())
                .tocarBotaoMeusLimitesPix();

        if (tipoConta.equals(CONTA_POUPANCA)) {
            new MeusLimitesPixTela(getDriver())
                    .tocarBotaoContaPoupanca();
        }

        new MeusLimitesPixTela(getDriver())
                .tocarOpcaoPixSaquePixTroco()
                .tocarBotaoAlterarLimiteDiurno()
                .tocarIconeLapis(TipoLimite.DIURNO.toString())
                .preencherValorLimite(TipoLimite.DIURNO.toString(), valorLimite)
                .validarMensagemValorMinimoLimite()
                .tocarBotaoVoltar()
                .tocarBotaoVoltar();
    }

    /**
     * Validar Reduçãoo de Limite Empresa com Limite Utilizado
     *
     * @throws Exception
     */
    public void validarReducaoLimiteEmpresaComLimiteUtilizado() throws Exception{
        new PixTela(getDriver())
                .tocarBotaoMaisOpcoes();
        new MaisOpcoesTela(getDriver())
                .tocarBotaoMeusLimitesPix();

        new MeusLimitesPixTela(getDriver())
                .tocarBotaoEmpresas();

        String valorValidar = new MeusLimitesPixTela(getDriver())
                .recuperarValorDoLimiteAtual();

        new MeusLimitesPixTela(getDriver())
                .validarAlteracaoLimiteEmAnalise()
                .tocarBotaoAlterarLimiteDiurno()
                .tocarBotaoAlterarLimite()
                .tocarBotaoI();
        new InformacoesTela(getDriver())
                .tocarBotaoEmpresas()
                .validarLimiteAtual(valorValidar)
                .tocarBotaoVoltar();
        new MeusLimitesPixTela(getDriver())
                .tocarBotaoLapis()
                .preencherValorLimiteReduzido(valorValidar,TipoLimite.DIURNO.toString())
                .tocarBotaoAlterarLimite()
                .validarMensagemLimiteAlterado()
                .tocarBotaoVoltarMeusLimites()
                .tocarBotaoEmpresas();

        String novoValorValidar = new MeusLimitesPixTela(getDriver())
                .recuperarValorDoLimiteAtual();

        new MeusLimitesPixTela(getDriver())
                .tocarBotaoI();
        new InformacoesTela(getDriver())
                .tocarBotaoEmpresas()
                .validarLimiteAtual(novoValorValidar)
                .tocarBotaoVoltar();
        new MeusLimitesPixTela(getDriver())
                .validarTelaMeusLimitesEmpresa();






    }
}
