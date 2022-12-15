package funcionalidade.mobile.recarga;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import constantes.recarga.Recarga;
import constantes.recarga.SalvarContato;
import constantes.recarga.TipoConta;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.recarga.RecargaCelularTela;
import pagina.mobile.jornadas.recarga.resumo.ResumoTela;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ResumoFunc extends FuncionalidadeBase {

    /**
     * Realiza uma primeira regarga de celular (não deve possuir recargas anteriores)
     * @param salvarContato
     * @param nome
     * @param tipoConta
     * @throws NextException
     * @throws NoSuchAlgorithmException
     * @throws InterruptedException
     * @throws NextException
     * @throws IOException
     */
    public void realizarRecarga(SalvarContato salvarContato, String nome, TipoConta tipoConta) throws Exception {
        ResumoTela resumoTela = new ResumoTela(getDriver());
        if(salvarContato.equals(SalvarContato.SALVAR)) {
            resumoTela
                    .tocarSwitchSalvarContato()
                    .informarNomeContato(nome.split(" ")[0])
                    .validarLabelNomeESobrenome()
                    .informarNomeContato(nome);
        }
        switch (tipoConta){
            case CONTA_CORRENTE:
                resumoTela.selecionaContaCorrente();
                break;
            case CONTA_POUPANCA:
                resumoTela.selecionaContaPoupanca();
                break;
        }

        resumoTela.tocarBotaoConfirmar();

        new RecargaCelularTela(getDriver())
                .validarExibicaoTelaRecarga();
    }
    /**
     * realiza recarga com saldo insuficiente
     *
     * @param tipoConta - CORRENTE ou POUPANCA
     * @throws NoSuchAlgorithmException
     * @throws InterruptedException
     * @throws NextException
     *
     */
    public void realizarRecargaComSaldoInsuficiente(SalvarContato salvarContato, String nome, TipoConta tipoConta) throws Exception {
        ResumoTela resumoTela = new ResumoTela(getDriver());
       if (salvarContato.equals(SalvarContato.SALVAR)) {
            resumoTela
                    .tocarSwitchSalvarContato()
                    .informarNomeContato(nome.split(" ")[0])
                    .validarLabelNomeESobrenome()
                    .informarNomeContato(nome);
        }
        switch (tipoConta) {
            case CONTA_CORRENTE:
                resumoTela.selecionaContaCorrente();
                break;
            case CONTA_POUPANCA:
                resumoTela.selecionaContaPoupanca();
                break;
        }

        resumoTela.tocarBotaoConfirmar();

    new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Recarga.SALDO_INSUFICIENTE.toString());


    }
}
