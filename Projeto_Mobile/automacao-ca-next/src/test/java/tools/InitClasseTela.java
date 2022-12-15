package tools;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
@SuppressWarnings("unchecked")
public class InitClasseTela {

    WebDriver driver;
    Class<?> classeIframeBase;
    Object iframeBase;

    public InitClasseTela(WebDriver driver, Class<?> classeIframeBase) {
        this.driver = driver;
        this.classeIframeBase = classeIframeBase;
        instanciar(driver, classeIframeBase);
    }

    private InitClasseTela instanciar(WebDriver driver, Class<?> classeIframebase) {
        Constructor[] constructors = classeIframebase.getDeclaredConstructors();
        try {
            this.iframeBase = constructors[0].newInstance(driver);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public <T> T recuperarObjetoInstanciado() {
        return (T) iframeBase;
    }
}
