/**
* @author Carlos Alexandre
* @version 1.0
* @since Primeira versão
*/

public class ProdutosDTO {

    private Integer id;
    private String nome;
    private String valor;
    private String status;

    public ProdutosDTO() {
    }
    
    
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
