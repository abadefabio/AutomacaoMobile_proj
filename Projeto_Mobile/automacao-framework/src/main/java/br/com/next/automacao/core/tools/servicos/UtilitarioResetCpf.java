package br.com.next.automacao.core.tools.servicos;

import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.ReadProperties;

public class UtilitarioResetCpf {

    public static boolean resetCpf(String cpf) throws NextException {
        ResetCpfServico servico = new ResetCpfServico(cpf, ReadProperties.getCaUrl(), ReadProperties.getEsteira());
        return servico.redefinirCpfPersistente(ReadProperties.getCredenciaisEmulador());
    }
}
