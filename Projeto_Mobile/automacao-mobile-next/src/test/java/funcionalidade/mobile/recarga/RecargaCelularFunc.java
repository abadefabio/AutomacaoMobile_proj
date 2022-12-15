package funcionalidade.mobile.recarga;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import pagina.mobile.comum.so.ModalCompartilhamentoTela;
import pagina.mobile.jornadas.recarga.RecargaCelularTela;
import pagina.mobile.jornadas.recarga.confirmacao.ComprovanteTela;
import pagina.mobile.jornadas.recarga.meusContatos.MeusContatosTela;
import pagina.mobile.jornadas.recarga.resumo.EscolherOperadoraTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class RecargaCelularFunc extends FuncionalidadeBase {

    /**
     * Método para preencher os dados da recarga
     *
     * @param telefone - número de telefone para o qual a recarga será realizada
     * @param operadora - operadora do número informado
     *
     * @throws Exception
     */
    public void preencherDadosRecarga(String telefone, String operadora) throws Exception {
        new RecargaCelularTela(getDriver())
                .informarCelular(telefone)
                .tocarSeletorOperadora();
        new EscolherOperadoraTela(getDriver())
                .buscarOperadora(operadora)
                .selecionarOperadora(operadora);
       new RecargaCelularTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Método para preencher os dados da recarga selecionando o primeiro contato da agenda
     *
     * @param operadora - operadora do número informado
     *
     * @throws Exception
     */
    public void preencherDadosRecargaPrimeiroContatoSalvo(String operadora) throws Exception {
        new RecargaCelularTela(getDriver())
                .tocarIconeDaAgenda()
                .tocarPrimeiroContatoDaAgenda()
                .tocarSeletorOperadora();
        new EscolherOperadoraTela(getDriver())
                .buscarOperadora(operadora)
                .selecionarOperadora(operadora);
        new RecargaCelularTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Selecionar contato existente em 'Meus Contatos'
     *
     * @param nome
     * @throws Exception
     */
    public void selecionarContato(String nome) throws Exception {
        new MeusContatosTela( getDriver() )
                .selecionarContato( nome );
    }

    /**
     * Exibe as 'Recargas Salvas' validando label sem nenhuma recarga.
     *
     * @throws NextException
     */
    public void exibirRecargasSalvasSemContatosSalvos() throws Exception {
        new RecargaCelularTela(getDriver())
                .expandirRecargasSalvas()
                .validarLabelNenhumaRecarga()
                .ocultarRecargasSalvas();
    }

    /**
     * Valida recarga.
     * @throws NextException
     */
    public void validarRecarga() throws Exception {
        new RecargaCelularTela(getDriver())
                .validarLabelTudoCertoComARecarga()
                .tocarVerComprovante();
        new ComprovanteTela(getDriver())
                .validarExibicaoTelaComprovante();
        new ComprovanteTela(getDriver())
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento();
        new ComprovanteTela(getDriver())
                .voltarParaTelaDeComprovante()
                .tocarBotaoFechar();
        new RecargaCelularTela(getDriver())
                .validarExibicaoTelaRecarga();
        new RecargaCelularTela(getDriver())
                .tocarBotaoFechar();
    }

    /**
     * Validação do telefone inválido
     * @throws NextException
     */
    public void validarEdicaoTelefoneInvalido(String telfoneIncorreto) throws Exception {
        new RecargaCelularTela(getDriver())
                .informarCelular(telfoneIncorreto)
                .validarLabelTelefoneInvalido();
    }
}
