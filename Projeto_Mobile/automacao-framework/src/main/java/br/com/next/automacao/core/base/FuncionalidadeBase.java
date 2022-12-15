package br.com.next.automacao.core.base;

import br.com.next.automacao.core.constantes.driver.web.NavegadorEmFoco;
import br.com.next.automacao.core.exception.NextException;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static br.com.next.automacao.core.drivers.OperadorDriver.*;

public class FuncionalidadeBase {

    public void definirProximoNavegador(NavegadorEmFoco navegador){
        switch (navegador){
            case PRINCIPAL:
                trocarNavegador(new ArrayList<String>(recuperarListaNavegadores()).get(0));
                break;
            case SECUNDARIO:
                trocarNavegador(new ArrayList<String>(recuperarListaNavegadores()).get(1));
        }
    }

    public void definirProximoNavegador(NavegadorEmFoco navegador, String url) throws Exception {
        switch (navegador){
            case PRINCIPAL:
                trocarNavegador(new ArrayList<String>(recuperarListaNavegadores()).get(0), url);
                break;
            case SECUNDARIO:
                trocarNavegador(new ArrayList<String>(recuperarListaNavegadores()).get(1), url);
        }
    }

    public void abrirUrlEmNovaAba(String url){
        abrirNovaAbaNavegador(url);
    }

    public void abrirUrlEmNovaJanela(String url){
        abrirNovaJanelaNavegador(url);
    }

    public void encerrarNavegador(NavegadorEmFoco navegador){
        switch (navegador){
            case PRINCIPAL:
                encerrarDriverNavegador(new ArrayList<String>(recuperarListaNavegadores()).get(0));
                break;
            case SECUNDARIO:
                encerrarDriverNavegador(new ArrayList<String>(recuperarListaNavegadores()).get(1));
        }
    }

    public void fecharAbaJanela(int indiceInstanciaNavegador){
        fecharInstanciaNavegador(indiceInstanciaNavegador);
    }

    public void alterarFocoAgente(int indiceInstanciaNavegador){
        alterarFocoNavegadorPara(indiceInstanciaNavegador);
    }

    public ArrayList<String> recuperarInstanciasAbertas(){
        return recuperarListaInstanciasAbertas();
    }
}
