/**
* @author Carlos Alexandre
* @version 1.0
* @since Primeira versão
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conectaDAO {
    
    public Connection conectaDAO() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/uc11?useSSL=false", // linha de conexao
                    "root", // usuario do mysql
                    "123456"// senha do mysql
            );
            return conn;

        } catch (SQLException e) {
            System.out.println("Erro ao Conectar: " + e.getMessage());
            return null;
        }

    }
    
}
