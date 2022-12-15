package br.com.next.automacao.core.exception;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

public class SecaoNextException extends WebDriverException {

    public SecaoNextException(String message){
        super(message);
    }

    public SecaoNextException(String reason, SessionNotCreatedException cause){
        Assert.fail(reason, cause.getCause());
    }
}
