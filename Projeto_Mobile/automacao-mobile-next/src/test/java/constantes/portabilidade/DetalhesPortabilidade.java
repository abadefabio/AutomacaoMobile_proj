package constantes.portabilidade;

import br.com.next.automacao.core.constantes.massa.Portabilidade.Portabilidade;
import br.com.next.automacao.core.constantes.massa.Portabilidade.TipoPortabilidade;
import br.com.next.automacao.core.constantes.massa.tdm.StatusPortabilidade;

import java.util.HashMap;
import java.util.Map;

import static br.com.next.automacao.core.constantes.massa.Portabilidade.TipoPortabilidade.*;
import static br.com.next.automacao.core.constantes.massa.tdm.StatusPortabilidade.*;
import static br.com.next.automacao.core.massa.portabilidade.DadosPortabilidade.recuperarDadosPortabilidade;


public enum DetalhesPortabilidade {

    PORTABILIDADE_OUTROS_BANCOS_STATUS_51_CNPJ(CRIAR_PORTABILIDADE_OUTROS_BANCOS_CNPJ,
            PENDENTE_SEM_ENVIO_PARTICIPANTE_FOLHA_PAGAMENTO,
            null,
            null,
            null),

    PORTABILIDADE_OUTROS_BANCOS_STATUS_51_CNPJ_19867802_0001_21(CRIAR_PORTABILIDADE_OUTROS_BANCOS_CNPJ, PENDENTE_SEM_ENVIO_PARTICIPANTE_FOLHA_PAGAMENTO, null, "19867802000121", null),
    PORTABILIDADE_OUTROS_BANCOS_STATUS_1_CNPJ(CRIAR_PORTABILIDADE_OUTROS_BANCOS_CNPJ, PENDENTE_SEM_ENVIO_PARTICIPANTE_FOLHA_PAGAMENTO,null, "null", null),
    PORTABILIDADE_OUTROS_BANCOS_STATUS_02_CNPJ(CRIAR_PORTABILIDADE_OUTROS_BANCOS_CNPJ,APROVADA_PARTICIPANTE_FOLHA_PAGAMENTO,null,null,null),
    PORTABILIDADE_OUTROS_BANCOS_STATUS_01_CNPJ(CRIAR_PORTABILIDADE_OUTROS_BANCOS_CNPJ,
            PENDENTE,
            null,
            null,
            null);

    private static ThreadLocal<DetalhesPortabilidade> massaTeste;
    private TipoPortabilidade tipo;
    private String cpfCnpj;
    private StatusPortabilidade status;
    private String banco;
    private String dataSolicitacao;

    DetalhesPortabilidade(TipoPortabilidade tipo, StatusPortabilidade status, String banco, String cpfCnpj, String dataSolicitacao){
        this.tipo = tipo;
        this.cpfCnpj = cpfCnpj;
        this.status = status;
        this.banco = banco;
        this.dataSolicitacao = dataSolicitacao;
        definirMassa(this);
    }

    public static void definirMassa(DetalhesPortabilidade massa){
        if(massaTeste == null){
            massaTeste = new ThreadLocal<>();
        }
        massaTeste.set(massa);
    }

    public static DetalhesPortabilidade recuperarMassa(){
        return massaTeste.get();
    }

    public Map<String,String> retornaDadosPortabilidade(){

        //Recuperar informação CPF/CNPJ empregador
        String cpfCnpjEmpregador = this.cpfCnpj == null ? recuperarDadosPortabilidade(Portabilidade.CNPJ) : this.cpfCnpj;
        //Caso o objeto cpfCnpjEmpregador seja nulo, recuperar o CPF da portabilidade criada
        cpfCnpjEmpregador = cpfCnpjEmpregador == null ? recuperarDadosPortabilidade(Portabilidade.CPF) : cpfCnpjEmpregador;

        //Recuperar informação de status portabilidade - Sem Número
        String statusPortabilidade = this.status.getValue().replaceAll("[0-9]", "");

        //Recuperar informação data solicitação
        String dataSolicitacao = recuperarDadosPortabilidade(Portabilidade.DATA_CRIACAO);
       //Alterar formatação da data de mm-dd-yyyy  para dd/mm/yyy
        dataSolicitacao = dataSolicitacao.substring(8) + "/" + dataSolicitacao.substring(5,7) + "/" + dataSolicitacao.substring(0,4);
        dataSolicitacao = this.dataSolicitacao == null ? dataSolicitacao : this.dataSolicitacao;

        //Recuperar informação de banco da solicitação
        String banco = this.banco == null ? recuperarDadosPortabilidade(Portabilidade.CODIGO_BANCO) + " " + recuperarDadosPortabilidade(Portabilidade.NOME_BANCO) : this.banco;
        banco = banco.contains("33") ? "33-SANTANDER BANESPA" : banco;
        banco = banco.contains("341") ? "341-ITAU UNIBANCO S.A." : banco;

        Map<String, String> dicionario = new HashMap<>();
        dicionario.put("CPF/CNPJ", cpfCnpjEmpregador);
        dicionario.put("Status", statusPortabilidade);
        dicionario.put("Banco",banco);
        dicionario.put("Data da solicitação",dataSolicitacao);
        return dicionario;
    }

    public Map<String,String> retornaDadosPortabilidade(String... campos){
        Map<String, String> dicionario = new HashMap<>();
        Map<String, String> dicionarioCompleto = retornaDadosPortabilidade();
        for(String campo : campos) dicionario.put(campo, dicionarioCompleto.get(campo));
        return dicionario;
    }

    public TipoPortabilidade retornarTipoPortabilidade(){
        return this.tipo;
    }

    public StatusPortabilidade retornarStatusPortabilidade(){
        return this.status;
    }

    public String retornarCpfCnpjEmpregador(){
        return retornaDadosPortabilidade().get("CPF/CNPJ"); }

    public String retornaBancoPortabilidade(){
        return retornaDadosPortabilidade().get("Banco");
    }

}
