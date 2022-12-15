package pagina.mobile.comum.next;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

import java.util.Arrays;

public class ValidaMensagensTela extends PaginaBase {

    public ValidaMensagensTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Valida se está sendo exibido na tela todos as mensagens informadas
     *
     * @param mensagensParaValidar Palavras que deverão ser validadas na tela
     * @return ValidaMensagensTela
     */
    @Step("Validar se todos os textos estão presentes na tela")
    public ValidaMensagensTela validarTodasAsMensagens(String... mensagensParaValidar) {
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(mensagensParaValidar),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar a mensagem '" + Arrays.toString(mensagensParaValidar) + "'."
        );
        salvarEvidencia("Mensagem '" + Arrays.toString(mensagensParaValidar) + "' está presente na tela!");
        return this;
    }
}
