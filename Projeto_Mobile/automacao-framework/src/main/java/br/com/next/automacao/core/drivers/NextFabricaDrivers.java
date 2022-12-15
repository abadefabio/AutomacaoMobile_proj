package br.com.next.automacao.core.drivers;

import br.com.next.automacao.core.drivers.mobile.managers.NextMobileDriver;
import org.testng.Reporter;

/**
 * Interface para fabrica de Drivers, implementa métodos para configuração de drivers e encerramento de drivers
 * @author Matheus Lima Barbosa de Tulio
 * @version 3.5.1
 * @since 2021-05
 */
public interface NextFabricaDrivers {


    /**
     * Método encerra a seção iniciada pelo NextDriver
     * @param driver
     */
    static void encerrarNextDriver(NextDriver driver){
        try{
            driver.recuperarDriver().quit();
        }catch(NullPointerException ex){
            if(driver instanceof NextMobileDriver){
                Reporter.log("Não foi possivel encerrar o driver! Dica: Se a conexao com o dispositivo nao foi encerrada automaticamente, lembre-se de que a reserva do mesmo não foi excluida.", true);
            } else {
                Reporter.log("Não foi possivel encerrar o WebDriver!", true);
            }
            ex.getMessage();
        }
    }
}
