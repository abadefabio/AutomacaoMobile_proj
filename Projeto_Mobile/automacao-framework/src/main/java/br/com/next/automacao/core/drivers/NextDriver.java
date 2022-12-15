package br.com.next.automacao.core.drivers;
import br.com.next.automacao.core.exception.NextException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * O Next Driver é a super classe que define os drivers
 * utilizados nas execuções dos testes
 * Toda classe NextDriver contém as instâncias driver e plataforma
 * Também devem conter os métodos:
 * criarDriver -> Método para iniciar uma instância do driver
 * recuperarDriver -> Método retorna a instância driver da classe
 * recuperarPlataforma -> O Método retorna a instância plataforma da classe
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
     * Método cria a instância WebDriver driver da classe
     * @param url
     * @return Objeto NextDriver criado
     * @throws MalformedURLException
     * @throws NextException
     */
    protected abstract NextDriver criarDriver(String url) throws Exception;

    /**
     * Método retonar a instância Webdriver driver da classe NextDriver
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
     * Método configura o tempo de implicitlyWait padrão do driver
     * @param implicitlyWait
     */
    public void configurarImplicitlyWait( int implicitlyWait){
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
    }
}
