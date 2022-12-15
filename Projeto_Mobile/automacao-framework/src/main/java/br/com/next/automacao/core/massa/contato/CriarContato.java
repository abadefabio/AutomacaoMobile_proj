package br.com.next.automacao.core.massa.contato;

import br.com.next.automacao.core.constantes.massa.contato.TipoContato;
import br.com.next.automacao.core.tools.Utilitarios;
import static br.com.next.automacao.core.massa.contato.RequisicaoContato.requestCriarContato;

public class CriarContato{
    /**
     * Criar contatos para funcionalidade transferencia e vaquinha*
     * @author Rodrigo Benedetti
     * @since 2021-04
     */

    public static void criarContato(TipoContato tipoContatos, String cpf) {
        try {
            switch (tipoContatos) {
                case OUTROS_BANCOS:
                    requestCriarContato(cpf, Utilitarios.geradorBancosOperantes(),Utilitarios.geradorAgencia(),Utilitarios.geradorConta(), null);
                    break;
                case VAQUINHA:
                    requestCriarContato(cpf,Utilitarios.geradorBancosOperantes(),Utilitarios.geradorAgencia(),Utilitarios.geradorConta(),Utilitarios.geradorDeEmail());
                    break;
                case NEXT:
                    requestCriarContato(cpf,237,"3750",Utilitarios.geradorContaNext(),Utilitarios.geradorDeEmail());
                    break;
                case BRADESCO:
                    requestCriarContato(cpf,237,"1382",Utilitarios.geradorContaBradesco(),Utilitarios.geradorDeEmail());
                    break;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
