package pagina.mobile.jornadas.pix.contato;

import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class ContatoTela extends PaginaBase {

    public ContatoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Selecionar contato pelo nome
     *
     * @param nomeContato Nome do contato a ser selecionado
     * @return ContatoTela
     * @throws NextException
     */
    @Step("Selecionar contato")
    public ContatoTela selecionarContato(String nomeContato) throws NextException {
        aguardarPaginaConterQualquerTexto(nomeContato);
        salvarEvidencia("Selecionar o contato: " + nomeContato);
        By contato;
        if (android) {
            contato = By.xpath("//*[@resource-id='br.com.bradesco.next:id/nl_contact_name' and contains(@text, '"+nomeContato+"')]");
        } else {
            contato = By.xpath("//XCUIElementTypeStaticText[@name='"+nomeContato+"']");
        }
        tocarElemento(contato, "Não foi possível selecionar o contato: " + nomeContato);
        return this;
    }
}
