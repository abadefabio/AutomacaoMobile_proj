package br.com.next.automacao.core.base.cucumber.runners;

import br.com.next.automacao.core.base.TesteBase;
import io.cucumber.java.BeforeStep;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FrameworkRunner extends TesteBase {

    /**
     * Faz o override do método em TesteBase
     * para capturar informações do teste para o Cucumber
     */
    @Override
    protected void definirObjetivoTeste() {
        String descricaoAnnotationTest = this.getClass().getAnnotation(Test.class).description();
        getCasoTeste().setNomeCasoTeste(descricaoAnnotationTest.split("\n")[0]);
        getCasoTeste().setSeveridadeCt("N/A");
        getCasoTeste().setObjetivoTeste(descricaoAnnotationTest);
    }

}


