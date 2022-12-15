package br.com.next.automacao.core.drivers;
import br.com.next.automacao.core.exception.NextException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * O Next Driver � a super classe que define os drivers
 * utilizados nas execu��es dos testes
 * Toda classe NextDriver cont�m as inst�ncias driver e plataforma
 * Tamb�m devem conter os m�todos:
 * criarDriver -> M�todo para iniciar uma inst�ncia do driver
 * recuperarDriver -> M�todo retorna a inst�ncia driver da classe
 * recuperarPlataforma -> O M�todo retorna a inst�ncia plataforma da classe
 *
 * @author Matheus Lima Barbosa de Tulio
 * @version 3.5.2
 * @since 2021-05
 */
public abstract class NextDriver {

    protected WebDriver driver;
    protected String plataforma;
    protected MutableCapabilities configuracoesDriver;

    /**
     * M�todo cria a inst�ncia WebDriver driver da classe
     * @param url
     * @return Objeto NextDriver criado
     * @throws MalformedURLException
     * @throws NextException
     */
    protected abstract NextDriver criarDriver(String url) throws Exception;

    /**
     * M�todo retonar a inst�ncia Webdriver driver da classe NextDriver
     * @return driver
     */
    public abstract WebDriver recuperarDriver();

    /**
     * @return plataforma (Web: navegador; Mobile:Android/iOS)
     */
    public String recuperarPlataforma(){
        return this.plataforma;
    }

    /**
     * M�todo configura o tempo de implicitlyWait padr�o do driver
     * @param implicitlyWait
     */
    public void configurarImplicitlyWait( int implicitlyWait){
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
    }
}
