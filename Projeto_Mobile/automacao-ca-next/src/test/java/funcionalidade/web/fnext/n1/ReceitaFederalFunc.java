package funcionalidade.web.fnext.n1;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.n1.CardReceitaFederalTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class ReceitaFederalFunc extends FuncionalidadeBase {

    /**
     * M�todo para preencher  op��o confere no Nome da M�e e Data Nascimento
     *
     * @throws Exception
     */
    public void marcarConfereNomeMaeDataNascimento() throws Exception {
        new CardReceitaFederalTela(getWebDriver())
                .clicarConfereNomeMae()
                .clicarConfereDataNascimento();
    }

    /**
     * M�todo para preencher  op��o N�o confere no Nome da M�e e Data Nascimento
     *
     * @throws Exception
     */
    public void marcarNaoConfereNomeMaeDataNascimento() throws Exception {
        new CardReceitaFederalTela(getWebDriver())
                .clicarNaoConfereNomeMae()
                .clicarConfereDataNascimento();
    }

    /**
     * M�todo para selecionar op��o Confere na Data de Nascimento em ades�es Next
     *
     * @throws Exception
     */
    public void marcarConfereDatadeNascimentoNext() throws Exception {
        new CardReceitaFederalTela(getWebDriver())
                .clicarConfereDataNascimento();
    }

    /**
     * M�todo para selecionar op��o Confere na Data de Nascimento em ades�es Next Joy
     *
     * @throws Exception
     */
    public void marcarConfereDatadeNascimento() throws Exception{
        new CardReceitaFederalTela(getWebDriver())
                .clicarConfereDataNascimento();
    }


    /**
     * M�todo para selecionar op��o N�o Confere na Data de Nascimento em ades�es Next Joy
     *
     * @throws Exception
     */
    public void marcarNaoConfereDatadeNascimento() throws Exception{
        new CardReceitaFederalTela(getWebDriver())
                .clicarNaoConfereDataNascimento();
    }
}
