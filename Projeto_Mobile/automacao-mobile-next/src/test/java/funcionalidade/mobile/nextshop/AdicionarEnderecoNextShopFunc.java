package funcionalidade.mobile.nextshop;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.nextshop.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AdicionarEnderecoNextShopFunc extends FuncionalidadeBase {

    /**
     * Adiciona um novo endereço válido e estático.
     * @throws Exception
     */
    public void adicionaNovoEnderecoValido() throws Exception{
        AdicionarEnderecoNextShopTela adicionarEnderecoMarketplaceTela = new AdicionarEnderecoNextShopTela(getDriver());

        adicionarEnderecoMarketplaceTela.preencheCampoCEP("13088221");
        adicionarEnderecoMarketplaceTela.preencheCampoEnderco("Rua Capitao");
        adicionarEnderecoMarketplaceTela.preencheCampoNumero("234");
        adicionarEnderecoMarketplaceTela.preencheCampoComplemento("Caso dos fundos");
        adicionarEnderecoMarketplaceTela.preencheCampoBairro("Bela Vista");
        adicionarEnderecoMarketplaceTela.preencheCampoDestinatario("Jorge Capitao");
        adicionarEnderecoMarketplaceTela.preencheCampoTelefone("19999999999");
        adicionarEnderecoMarketplaceTela.tocarBotaoSalvar();
    }

}
