package dal;
//importação de bibliotecas
import java.sql.*;

public class ModuloConexao {
    /*
        modulos responsavel por estabelecer a conexão com o BD.
    */
    public static Connection conector(){
        java.sql.Connection conexao = null;
        //a linha abaixo chama o driver 
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3307/usuarios";
        String user = "root";
        String password = "";
        //estabelecendo aa conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } 
        catch (Exception e){
            return null;
        }
    }
}
