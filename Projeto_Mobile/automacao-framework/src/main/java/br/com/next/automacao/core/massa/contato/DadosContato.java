package br.com.next.automacao.core.massa.contato;

import br.com.next.automacao.core.constantes.massa.contato.Contato;
import static br.com.next.automacao.core.massa.contato.RequisicaoContato.getModeloContato;
/**
 * Recuperar os dados do contato*
 * @author Rodrigo Benedetti
 * @since 2021-04
 */

public class DadosContato {
    public static String recuperarDadosContato(Contato contato) {

        switch (contato) {
            case NOME:
                return getModeloContato().getNomeContato();
            case SOBRENOME:
                return getModeloContato().getSobrenomeContato();
            case CPF:
                return getModeloContato().getCpfContato();
            case NUMERO_CELULAR:
                return getModeloContato().getNumeroCelularContato();
            case DDD_CELULAR:
                return getModeloContato().getDddCelularContato();
            case BANCO:
                return getModeloContato().getCodigoBancoContato().replace("[", "").replace("]", "");
            case AGENCIA:
                return getModeloContato().getAgenciaBancoContato().replace("[", "").replace("]", "");
            case CONTA:
                return getModeloContato().getContaBancoContato().replace("[", "").replace("]", "");
            default:
                return null;
        }

    }
}
