package pagina.mobile.jornadas.transferencia.para;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pagina.mobile.jornadas.transferencia.para.outra.NovoContatoTela;

import java.util.List;

public class ContatoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_account")
    private MobileElement contaContatoAdicionado;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_agency")
    private MobileElement agenciaContatoAdicionado;

    public ContatoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar Primeira Conta Salva na tela
     *
     * @return ContatoTela
     * @throws Exception
     */
    @Step("Validar conta")
    public ContatoTela validarContaSalva () throws Exception {
        Assert.assertEquals( "CC "+ NovoContatoTela.retornaContaContato(), retornarTexto( contaContatoAdicionado, "" ) );
        return this;
    }

    /**
     * Validar primeira Ag�ncia Salva na tela
     *
     * @return ContatoTela
     * @throws Exception
     */
    @Step("Validar agencia")
    public ContatoTela validarAgenciaSalva () throws Exception {
        salvarEvidencia( "Contato criado" );
        Assert.assertEquals( "AG "+ NovoContatoTela.retornaAgenciaContato(), retornarTexto( agenciaContatoAdicionado, "" ) );
        return this;
    }

    /**
     * Valida se Conta foi salva
     *
     * @return ContatoTela
     * @throws Exception
     */
    @Step("Validar Conta")
    public ContatoTela validarContaSalvaMaisDeUmaConta() throws Exception{
        if (!verificarContaSalva()){
            throw new AssertionError("Esperado encontrar \"CC "+ NovoContatoTela.retornaContaContato() + "\" na tela, mas conta n�o encontrada");
        }
        return this;
    }

    /**
     * Verifica se a conta está presenta na lista de todas as contas da tela
     *
     * @return true: Se conta encontrada; false: se conta não encontrada
     * @throws Exception
     */
    private boolean verificarContaSalva() throws Exception{
        List<MobileElement> listaContasSalvas = retornarLista(By.id("br.com.bradesco.next:id/ctv_account"), "Não foi possível retornar lista de contas salvas");
        boolean contaSalva = false;
        for(MobileElement conta: listaContasSalvas){
            if(retornarTexto(conta,"Erro ao recupear texto do elemento conta").equals("CC "+NovoContatoTela.retornaContaContato())){
                contaSalva = true;
            }
        }
        return contaSalva;
    }

    /**
     * Valida se Ag�ncia foi salva
     *
     * @return ContatoTela
     * @throws Exception
     */
    @Step("Validar Conta")
    public ContatoTela validarAgenciaSalvaMaisDeUmaAgencia() throws Exception{
        if (!verificarAgenciaSalva()){
            throw new AssertionError("Esperado encontrar \"AG "+ NovoContatoTela.retornaAgenciaContato() + "\" na tela, mas agência não encontrada");
        }else{
            salvarEvidencia("Validar contato (\"AG: "+NovoContatoTela.retornaAgenciaContato() +";\"CC: "+ NovoContatoTela.retornaContaContato() + ") salvo com sucesso");
        }
        return this;
    }

    /**
     Verifica se a ag�ncia est� presenta na lista de todas as ag�ncias da tela
     *
     * @return true: Se ag�ncia encontrada; false: se ag�ncia n�o encontrada
     * @return ContatoTela
     * @throws Exception
     */
    private boolean verificarAgenciaSalva() throws Exception{
        List<MobileElement> listaAgenciasSalvas = retornarLista(By.id("br.com.bradesco.next:id/ctv_agency"), "Não foi possível retornar lista de agências salvas");
        boolean agenciaSalva = false;
        for(MobileElement conta: listaAgenciasSalvas){
            if(retornarTexto(conta,"Erro ao recuperar texto do elemento agência").equals("AG "+ NovoContatoTela.retornaAgenciaContato())){
                agenciaSalva = true;
            }
        }
        return agenciaSalva;
    }
}
