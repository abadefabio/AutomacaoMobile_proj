package funcionalidade.mobile.objetivos.resgate;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.tools.Utilitarios;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.jornadas.objetivos.MeusObjetivosTela;
import pagina.mobile.jornadas.objetivos.ObjetivosTela;
import pagina.mobile.jornadas.objetivos.ResgateTela;
import pagina.mobile.jornadas.objetivos.notificacoes.NotificacoesTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class RealizarResgateFunc extends FuncionalidadeBase{

    private boolean android;

    private void fecharTelaPrimeiroAcessoObjetivoPresente() throws Exception {
        new ObjetivosTela(getDriver())
                .verificarBotaoVerMeusObjetivosEstaPresente();
    }

    /**
     * Método para tocar no botao notificacao'
     *
     * @throws Exception
     */
    public void validarNotificacao() throws Exception{
        new MenuTela(getDriver())
                .tocarMenuNotificacoes()
                .mensagemNotificacao()
                .tocarBotaoVerMais();
        if (getDriver() instanceof IOSDriver){
            new ObjetivosTela(getDriver())
                    .tocarBotaoVerMeusObjetivos()
                    .tocarMeusObjetivos();
        }
        else{
            new ObjetivosTela(getDriver())
                    .validarEstarTelaObjetivos()
                    .tocarCriarObjetivo()
                    .tocarMeusObjetivos();
        }
        new ObjetivosTela(getDriver())
                .validarTextoTelaObjetivos();
    }

    /**
     * Método para realizar resgate do objetivo'
     *
     * @throws Exception
     */
    public void realizarResgate() throws Exception{
        String valorMinimo = String.valueOf(Utilitarios.numeroAleatorio(100,999));
        new MeusObjetivosTela(getDriver())
                .tocarResgateObjetivoConcluido();
        new ResgateTela(getDriver())
                .escrevreValorResgate(valorMinimo)
                .tocarContinuar()
                .tocarResgatarTudo()
                .tocarContinuar()
                .tocarConfirmarResgate()
                .tocarVerComprovante()
                .validarPresencaTelaComprovante()
                .tocarVoltar()
                .tocarBotaoVerMeusObjetivos();
        if (android) {
            new ObjetivosTela(getDriver())
                    .validarTextoTelaObjetivos()
                    .verificarElementoZeroObjetivoCriado();
        }else {
            new ObjetivosTela(getDriver())
                    .validarTextoTelaObjetivos();
        }
    }

    /**
     * Método para realizar resgate parcial do objetivo'
     *
     * @throws Exception
     */
    public void realizarResgateParcial(String valorParcial) throws Exception{
        String valorMinimo = String.valueOf(Utilitarios.numeroAleatorio(100,999));
        new MeusObjetivosTela(getDriver())
                .tocarResgateObjetivoConcluido();
        new ResgateTela(getDriver())
                .escrevreValorResgate(valorMinimo)
                .validarResgateMinimo()
                .escrevreValorResgate(valorParcial)
                .tocarCheckUsarResgate()
                .tocarContinuar()
                .validarConfereSeTaTudoCerto()
                .validarValorResgateParcial(valorParcial)
                .tocarConfirmarResgate()
                .tocarVerComprovante()
                .tocarBotaoCompartilhar()
                .tocarBotaoFechar()
                .tocarVoltar()
                .tocarBotaoFechar();
        new ObjetivosTela(getDriver())
                .validarTelaObjetivos()
                .tocarBotaoVoltar();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }

    /**
     * Método para realizar resgate total do objetivo'
     * fr
     * @throws Exception
     */
    public void realizarResgateTotal(String valor) throws Exception{
        fecharTelaPrimeiroAcessoObjetivoPresente();
        new MeusObjetivosTela(getDriver())
                .rolarTelaBaixoEtocarResgate();
        new ResgateTela(getDriver())
                .tocarResgatarTudo()
                .tocarContinuar()
                .tocarConfirmarResgate();
        new NotificacoesTela(getDriver())
                .tocarBotaoEditarValor();
        new ResgateTela(getDriver())
                .escrevreValorResgate(valor)
                .tocarResgatarTudo()
                .tocarContinuar()
                .tocarConfirmarResgate();
        new NotificacoesTela(getDriver())
                .tocarBotaoResgatar();
        new ResgateTela(getDriver())
                .tocarVerComprovante()
                .validarPresencaTelaComprovante()
                .tocarVoltar()
                .tocarBotaoVerMeusObjetivos();
    }

}
