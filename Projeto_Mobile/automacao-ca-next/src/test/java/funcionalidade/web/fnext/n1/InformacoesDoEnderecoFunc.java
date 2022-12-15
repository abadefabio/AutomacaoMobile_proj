package funcionalidade.web.fnext.n1;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.n1.CardInformacoesEnderecoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class InformacoesDoEnderecoFunc extends FuncionalidadeBase {

    /**
     *Preencher op��o confere no Card Informa��es do Endere�o
     *
     *
     * @throws Exception
     */
    public void marcarConfereCamposInformacaoDoEndereco() throws Exception{
        new CardInformacoesEnderecoTela(getWebDriver())
                .clicarConfereCep()
                .clicarConfereLogradouro()
                .clicarConfereNumero()
                .clicarConfereComplemento()
                .clicarConfereUf()
                .clicarConfereCidade();
    }

    /**
     * Preencher op��o N�o Confere no Card Informa��e do Endere�o
     *
     * @param CorrecaoCep
     * @param CorrecaoLogradouro
     * @param CorrecaoNumero
     * @param CorrecaoComplemento
     * @param CorrecaoUf
     * @param CorrecaoCidade
     * @throws Exception
     */
    public void marcarNaoConfereCamposInformacaodoEndereco(String CorrecaoCep, String CorrecaoLogradouro, String CorrecaoNumero, String CorrecaoComplemento, String CorrecaoUf, String CorrecaoCidade)throws Exception {
        new CardInformacoesEnderecoTela(getWebDriver())
                .clicarNaoConfereCep()
                .clicarCampoCorrecaoCepInformarCorrecao(CorrecaoCep)
                .clicarNaoConfereLogradouro()
                .clicarCampoCorrecaoLogradouroInformarCorrecao(CorrecaoLogradouro)
                .clicarNaoConfereNumero()
                .clicarCampoCorrecaoNumeroInformarCorrecao(CorrecaoNumero)
                .clicarNaoConfereComplemento()
                .clicarCampoCorrecaoComplementoInformarCorrecao(CorrecaoComplemento)
                .clicarNaoConfereUf()
                .selecionarComboCorrecaoUf(CorrecaoUf)
                .clicarNaoConfereCidade()
                .selecionarComboCorrecaoCidade(CorrecaoCidade);
    }

    /**
     * Validar Informa��es Alteradas no Card Informa��e do Endere�o
     *
     * @param Cep
     * @param Logradouro
     * @param Numero
     * @param Complemento
     * @param Uf
     * @param Cidade
     * @throws Exception
     */
    public void validarAlteracaoCamposInformacaodoEndereco(String Cep, String Logradouro, String Numero, String Complemento, String Uf, String Cidade)throws Exception {
        new CardInformacoesEnderecoTela(getWebDriver())
                .verificarCampoCorrecaoCepValidarCorrecao(Cep)
                .verificarCampoCorrecaoLogradouroValidarCorrecao(Logradouro)
                .verificarCampoCorrecaoNumeroValidarCorrecao(Numero)
                .verificarCampoCorrecaoComplementoValidarCorrecao(Complemento)
                .verificarCampoCorrecaoUfValidarCorrecao(Uf)
                .verificarCampoCorrecaoCidadeValidarCorrecao(Cidade);
    }
}
