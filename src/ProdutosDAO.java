/**
* @author Carlos Alexandre
* @version 1.0
* @since Primeira versão
*/


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProdutosDAO {
    
     private conectaDAO conexao;
        private Connection conn;

    public ProdutosDAO() {
        this.conexao = new conectaDAO();
        this.conn = (Connection) this.conexao.conectaDAO();
    }
    
    // Metodo Inserir
     public void inserir(ProdutosDTO produtosDTO) {
    String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)";
    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, produtosDTO.getNome());
        stmt.setString(2, produtosDTO.getValor() );
        stmt.setString(3, produtosDTO.getStatus());
        
        stmt.execute();
        
    } catch (SQLException e) {
        System.out.println("Erro ao inserir empresa: " + e.getMessage());
    }
}
     
     public List<ProdutosDTO> getProdutos() {
                String sql = "SELECT * FROM produtos";
                
                try {
                    PreparedStatement stmt = this.conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();            
                    
                    List<ProdutosDTO> listaProdutos = new ArrayList<>();
                    
                    while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                        ProdutosDTO produtosDTO = new ProdutosDTO();
                        
                        produtosDTO.setId(rs.getInt("id"));
                        produtosDTO.setNome(rs.getString("nome"));
                        produtosDTO.setValor(rs.getString("valor"));
                        produtosDTO.setStatus(rs.getString("status"));
                        
                        listaProdutos.add(produtosDTO);    
                    }
                    return listaProdutos;
                    
                    //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
                } catch (SQLException e) {
                    return null;
                }
            }
     
     public void venderProdutos (int id){
      
         String sql = "UPDATE produtos SET status=? where id=?";
         try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
          
            stmt.setString(1, "Vendido");
            stmt.setInt(2, id);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto Atualizado com Sucesso.");
         
         }catch (SQLException ex){
         System.out.println("Erro ao vender Produto " + ex.getMessage());
         }
     }
}

