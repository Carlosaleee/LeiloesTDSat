/**
* @author Carlos Alexandre
* @version 1.0
* @since Primeira versão
*/


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
}

