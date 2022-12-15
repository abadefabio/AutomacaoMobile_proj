package funcionalidade.mobile.nextjoy;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.nextJoy.LocalPaisNascimento;
import constantes.nextJoy.MensagemEsperadas;
import constantes.nextJoy.TipoDocumento;
import constantes.nextJoy.Vinculo;
import io.appium.java_client.ios.IOSDriver;
import org.testng.util.Strings;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.login.LoginTela;
import pagina.mobile.jornadas.nextjoy.ConsentimentoUsoDadosTela;
import pagina.mobile.jornadas.nextjoy.DadosDependenteTela;
import pagina.mobile.jornadas.nextjoy.EnvioCartaoTela;
import pagina.mobile.jornadas.nextjoy.ExposicaoPoliticaTela;
import pagina.mobile.jornadas.nextjoy.FotoDocumentoTela;
import pagina.mobile.jornadas.nextjoy.InformacoesFiscaisTela;
import pagina.mobile.jornadas.nextjoy.NextJoyTela;
import pagina.mobile.jornadas.nextjoy.SenhaCartaoTela;
import pagina.mobile.jornadas.nextjoy.TermosCondicoesTela;
import pagina.mobile.jornadas.nextjoy.TirarFotoDocumentoTela;

import java.util.Random;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CadastroDadosDependenteFunc extends FuncionalidadeBase {

    /**
     * Fluxo de Cadastro Dependente
     *
     * @param nome           Nome completo do dependente
     * @param cpfDependente  Cpf do dependente (Se Nulo ou Vazio gera um CPF aleatório)
     * @param dataNascimento Data de nascimento do dependente
     * @param senha          Senha a ser informada no app e no cartão
     * @param fluxoLogado    Condição booleana (true/false) que valida se o usuário já está em processo de adesão ou não'
     * @throws Exception
     */
    public void cadastrarInformacoesDependenteAteSenha(String nome, String cpfDependente, String dataNascimento,
            String senha, boolean fluxoLogado) throws Exception {

        /*
        OBS: Validação de Campo impede o cadastro com senha que contenha sequencias do CPF do Dependente */
        if(Strings.isNullOrEmpty(cpfDependente))
            cpfDependente = gerarCpfSemNumerosRepetidosEReversosDaSenha(senha);

        if (fluxoLogado)
            new NextJoyTela(getDriver()).validarPresencaTelaCriarContaNextJoy();
        new NextJoyTela(getDriver())
                .preencherNomeCompleto(nome)
                .preencherCampoCpf(cpfDependente)
                .preencherCampoDataDeNascimento(dataNascimento);
        if (getDriver()instanceof IOSDriver) {
            new NextJoyTela(getDriver())
                    .tocarBotaoContinuar();

        }
        new NextJoyTela(getDriver())
                .tocaSelecionarVinculo()
                .selecionarVinculo(Vinculo.PAI)
                .tocarBotaoContinuar()
                .validarTelaDadosETocarContinuar()
                .tocarBotaoSimUsarMeusDados()
                .preencherCampoSenha(senha)
                .preencherCampoConfirmarSenha(senha)
                .tocarBotaoContinuar();
        if (getDriver() instanceof IOSDriver){
            new NextJoyTela(getDriver())
                    .tocarBotaoContinuar()
                    .validarTelaSenha();
        }
    }

    /**
     * Validar Cadastro Existente
     */
    public void validarCadastroExistente() {
        new DadosDependenteTela(getDriver())
                .validarTextoNaoMultibanco();
    }

    /**
     * Metodo para tocar no botao criar conta nextJoy
     *
     * @throws Exception
     */
    public void tocarBotaoCriarConta() throws Exception {
        new NextJoyTela(getDriver())
                .tocarBotaoCriarContaNextJoy();
    }

    /**
     * Método responsável por finalizar o cadastro através do botão Terminar mais tarde
     * @param textPoupUp Texto a ser validado no popup exibido após clicar no botão Terminar mais tarde
     * @param textoOk Texto a ser validado após confirmar a finalização do cadastro
     * @throws Exception
     */
    public void terminarCadastroMaisTarde(String textPoupUp, String textoOk) throws Exception {
        new NextJoyTela(getDriver())
                .tocarBotaoTerminarMaisTarde();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(textPoupUp);
        new NextJoyTela(getDriver())
                .tocarBotaoSimPopUp();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(textoOk);
        new NextJoyTela(getDriver())
                .tocarBotaoOkObrigado();
        new LoginTela(getDriver())
                .tocarBotaoAcompanheAberturaConta()
                .tocarBotaoVoltar()
                .tocarBotaoFechar();
    }

    /**
     * Metodo para voltar ao menu principal da tela de cadastro de Dependente
     *
     * @throws NextException
     */
    public void voltarAoMenuPrincipal() throws NextException {

        int i = 0;
        if (getDriver() instanceof IOSDriver){
            while (i<4){
                new NextJoyTela(getDriver())
                        .tocarBotaoVoltar();
                i++;
            }
        }else{
            new NextJoyTela(getDriver())
                    .tocarBotaoVoltar();
        }
        new NextJoyTela(getDriver())
                .tocarBotaoMenu();
    }

    /**
     * Fluxo para cadastro de dependente Joy já vinculado ao CPF do cliente
     *
     * @param nome
     * @param cpfDependente
     * @param dataNascimento
     * @throws Exception
     */
    public void cadastroDependenteJaVinculado(String nome, String cpfDependente,String dataNascimento) throws Exception {

        new NextJoyTela(getDriver())
                .validarPresencaTelaCriarContaNextJoy()
                .preencherNomeCompleto(nome)
                .preencherCampoCpf(cpfDependente)
                .preencherCampoDataDeNascimento(dataNascimento)
                .tocaSelecionarVinculo()
                .selecionarVinculo(Vinculo.PAI)
                .tocarBotaoContinuar();
        if (getDriver() instanceof IOSDriver){
            new NextJoyTela(getDriver())
                .tocarBotaoContinuar();

        }
        new NextJoyTela(getDriver())
                .validarMensagemCadastroExiste()
                .tocarBotaoOk();
    }

    /**
     * Método que finaliza a adesão do dependente
     *
     * @param senha Senha a ser informada no app e no cartão
     * @throws Exception
     */
    public void finalizarAdesaoDependente(String senha) throws Exception {

        String numeroRg = String.valueOf(new Random().nextInt(999999999));

        new DadosDependenteTela(getDriver())
                .tocarTipoDocumento()
                .selecionarTipoDocumento(TipoDocumento.RG)
                .preencherNumeroDocumento(numeroRg)
                .tocarPaisNascimento()
                .preencherCampoBuscarPaisNascimento(LocalPaisNascimento.BRASIL.toString())
                .selecionarPaisNascimento(LocalPaisNascimento.BRASIL.toString())
                .tocarLocalNascimento()
                .preencherCampoBuscarLocalNascimento(LocalPaisNascimento.BRASIL.getValue())
                .selecionarLocalNascimento(LocalPaisNascimento.BRASIL.getValue())
                .tocarBotaoContinuar();
        new InformacoesFiscaisTela(getDriver())
                .tocarRadioButtonNao()
                .tocarBotaoContinuar();
        new ExposicaoPoliticaTela(getDriver())
                .tocarRadioButtonNao()
                .tocarBotaoContinuar();
        new FotoDocumentoTela(getDriver())
                .tocarBotaoOkContinuar();
        new TirarFotoDocumentoTela(getDriver())
                .tocarBotaoContinuar()
                .tocarBotaoTirarFotoDaFrente()
                .tocarAcessoCameraPermitirOkSeVisivelEmTela()
                .tocarBotaoConfirmar()
                .tocarBotaoConfirmar()
                .tocarBotaoTirarFotoDoVerso()
                .tocarBotaoConfirmar()
                .tocarBotaoConfirmar();
        new SenhaCartaoTela(getDriver())
                .preencherCampoSenha(senha)
                .preencherCampoConfirmeSenhaCartao(senha)
                .tocarBotaoContinuar();
        new EnvioCartaoTela(getDriver())
                .tocarBotaoUsarEsteEndereco();
        new ConsentimentoUsoDadosTela(getDriver())
                .selecionarCheckBoxLiConcordo()
                .tocarBotaoContinuar();
        new TermosCondicoesTela(getDriver())
                .selecionarCheckBoxLiAceitoTermos()
                .tocarBotaoContinuar();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(MensagemEsperadas.PEDIDO_ABERTURA_CONTA_ENVIADO);
    }

    /**
     * Tocar em '+ Adicionar Dependente' Se Existir Outro Já Cadastrado
     * @throws NextException
     */
    public void tocarAdicionarDependenteSeExistirOutro() throws Exception {
        NextJoyTela nextJoyTela = new NextJoyTela(getDriver());
        if(nextJoyTela.verificaLabelSelecioneUmaContaParaGerenciar())
            nextJoyTela.tocarBotaoMaisAdicionarDependente();
    }

    /**
     * Gerar um CPF sem números repetidos e reversos da Senha
     * @param senha
     * @return String
     */
    private String gerarCpfSemNumerosRepetidosEReversosDaSenha(String senha) {

        String senhaReversa = "";
        String cpf = "";
        for(Character c : senha.toCharArray())
            senhaReversa = c.toString() + senhaReversa;

        String[] sequencias = {
                senha.substring(0,3), senha.substring(1,4), senha.substring(2,5), senha.substring(3,6),
                senhaReversa.substring(0,3), senhaReversa.substring(1,4), senhaReversa.substring(2,5), senhaReversa.substring(3,6)
        };
        boolean contemSequencia;
        do{
            contemSequencia = false;
            cpf = Utilitarios.gerarCpf();
            for(String s : sequencias)
                if(cpf.contains(s)) contemSequencia = true;
        } while (contemSequencia);

        return cpf;
    }

}
