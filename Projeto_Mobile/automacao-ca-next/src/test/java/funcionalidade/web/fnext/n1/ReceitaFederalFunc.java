package funcionalidade.web.fnext.n1;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.n1.CardReceitaFederalTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class ReceitaFederalFunc extends FuncionalidadeBase {

    /**
     * Método para preencher  opção confere no Nome da Mãe e Data Nascimento
     *
     * @throws Exception
     */
    public void marcarConfereNomeMaeDataNascimento() throws Exception {
        new CardReceitaFederalTela(getWebDriver())
                .clicarConfereNomeMae()
                .clicarConfereDataNascimento();
    }

    /**
     * Método para preencher  opção Não confere no Nome da Mãe e Data Nascimento
     *
     * @throws Exception
     */
    public void marcarNaoConfereNomeMaeDataNascimento() throws Exception {
        new CardReceitaFederalTela(getWebDriver())
                .clicarNaoConfereNomeMae()
                .clicarConfereDataNascimento();
    }

    /**
     * Método para selecionar opção Confere na Data de Nascimento em adesões Next
     *
     * @throws Exception
     */
    public void marcarConfereDatadeNascimentoNext() throws Exception {
        new CardReceitaFederalTela(getWebDriver())
                .clicarConfereDataNascimento();
    }

    /**
     * Método para selecionar opção Confere na Data de Nascimento em adesões Next Joy
     *
     * @throws Exception
     */
    public void marcarConfereDatadeNascimento() throws Exception{
        new CardReceitaFederalTela(getWebDriver())
                .clicarConfereDataNascimento();
    }


    /**
     * Método para selecionar opção Não Confere na Data de Nascimento em adesões Next Joy
     *
     * @throws Exception
     */
    public void marcarNaoConfereDatadeNascimento() throws Exception{
        new CardReceitaFederalTela(getWebDriver())
                .clicarNaoConfereDataNascimento();
    }
}
