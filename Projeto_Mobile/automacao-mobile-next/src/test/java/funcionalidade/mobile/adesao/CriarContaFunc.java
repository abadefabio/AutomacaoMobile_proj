package funcionalidade.mobile.adesao;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.adesao.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CriarContaFunc extends FuncionalidadeBase {

    /**
     * Método para Criar Conta
     *
     * @param nome,
     * @param cpf
     * @param dataNascimento
     * @param email
     * @param email
     * @param celular
     * @param senha
     * @throws Exception
     */
    public void criarConta(
            String nome,
            String cpf,
            String dataNascimento,
            String email,
            String celular,
            String senha) throws Exception {

        new CriarContaTela(getDriver())
                .preencherNomeCompleto(nome)
                .preencherCPF(cpf)
                .preencherDataNascimento(dataNascimento)
                .preencherEmail(email)
                .preencherConfirmarEmail(email)
                .preencherCelular(celular)
                .tocarBotaoContinuar();
        new SenhaDoAppTela(getDriver())
                .validarTituloSenhaApp()
                .preencherSenha(senha)
                .preencherConfirmeSenha(senha)
                .tocarBotaoContinuar();
        new FaltaPoucoTela(getDriver())
                .validarTituloAcesseNext()
                .tocarBotaoAcessenext();
        new CompleteSeuCadastroTela(getDriver())
                .validaTelaCompleSeuCadastro()
                .tocarBotaoDadosPessoais();
        new PassoUmDeSeisTela(getDriver())
                .tocarBotaoDadosPessoais();
        new DadosPessoaisTela(getDriver())
                .validarTituloTelaDadosPessoais();
    }

    /**
     * Método para Criar Conta no Fluxo para Terminar o Cadastro mais tarde
     *
     * @param nome,
     * @param cpf
     * @param dataNascimento
     * @param email
     * @param email
     * @param celular
     * @param senha
     * @throws Exception
     */
    public void criarContaCadastroTerminarMaisTarde(
            String nome,
            String cpf,
            String dataNascimento,
            String email,
            String celular,
            String senha) throws Exception {

        new CriarContaTela(getDriver())
                .preencherNomeCompleto(nome)
                .preencherCPF(cpf)
                .preencherDataNascimento(dataNascimento)
                .preencherEmail(email)
                .preencherConfirmarEmail(email)
                .preencherCelular(celular)
                .tocarBotaoContinuar();
        new SenhaDoAppTela(getDriver())
                .validarTituloSenhaApp()
                .preencherSenha(senha)
                .preencherConfirmeSenha(senha)
                .tocarBotaoContinuar();
        new FaltaPoucoTela(getDriver())
                .validarTituloAcesseNext()
                .tocarBotaoAcessenext();
        new CompleteSeuCadastroTela(getDriver())
                .validaTelaCompleSeuCadastro()
                .tocarBotaoDadosPessoais();
    }

}
