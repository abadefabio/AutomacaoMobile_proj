package funcionalidade.web.fnext.n1;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.n1.CardInformacoesEnderecoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class InformacoesDoEnderecoFunc extends FuncionalidadeBase {

    /**
     *Preencher opção confere no Card Informações do Endereço
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
     * Preencher opção Não Confere no Card Informaçõe do Endereço
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
     * Validar Informações Alteradas no Card Informaçõe do Endereço
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
