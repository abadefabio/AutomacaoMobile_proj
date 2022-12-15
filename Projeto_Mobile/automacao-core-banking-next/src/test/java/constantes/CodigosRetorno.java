package constantes;

public enum CodigosRetorno {

    OK(200,"OK","O recurso solicitado foi processado e retornado com sucesso"),
    CREATED(201,"Created","O recurso informado foi criado com sucesso."),
    UNAUTHORIZED(401,"Unauthorized","A chave da API está desativada, incorreta ou não foi informada corretamente. Consulte a seção sobre autenticação da documentação"),
    BAD_REQUEST(400,"Bad Request","O servidor não pode ou não irá processar a requisição devido a alguma coisa que foi entendida como um erro do cliente"),
    UNPROCESSABLE_ENTITY(422,"Unprocessable Entity","A requisição foi recebida com sucesso, porém contém parâmetros inválidos. Para mais detalhes, verifique o atributo errors no corpo da resposta"),
    INTERNAL_SERVER_ERROR(500,"Internal Server Error","Ocorreu uma falha na plataforma Vindi. Por favor, entre em contato com o atendimento.");

    private int codigo;
    private String nome;
    private String descricao;


    private CodigosRetorno(int codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }



}
