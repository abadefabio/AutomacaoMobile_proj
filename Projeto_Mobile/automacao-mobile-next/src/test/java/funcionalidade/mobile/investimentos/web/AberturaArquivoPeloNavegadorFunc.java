package funcionalidade.mobile.investimentos.web;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.drivers.OperadorDriver;
import pagina.web.email.AberturaArquivoPeloNavegadorTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AberturaArquivoPeloNavegadorFunc extends FuncionalidadeBase {

    /**
     * Abertura do arquivo seu recibo via browser
     * @throws Exception
     */
    public void abrirArquivoSeuReciboBaixado()throws Exception{
        String pathArquivo = "\\Downloads\\Investment_Statement.pdf";
        String filePath = System.getProperty("user.dir") + pathArquivo;
        OperadorDriver.abrirNovaJanelaNavegador(filePath);
    }

    /**
     * Digitar a senha de um arquivo
     * @param senhaArquivo
     * @throws Exception
     *
     */
    public void digitarSenhaArquivo(String senhaArquivo )throws Exception{
        new AberturaArquivoPeloNavegadorTela(getDriver())
                .digitarSenhaArquivoBaixado(senhaArquivo)
                .tocarBotaoOkAberturaNavegador();
    }
}
